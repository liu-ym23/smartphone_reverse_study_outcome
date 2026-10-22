package com.android.contacts.interactions;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.security.bytedance.guard.BDSettingsEvent;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.R;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.util.OAlertDialogUtils;
import com.google.android.collect.Sets;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.utils.OAutoSecurityGuardUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ContactDeletionInteraction extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, DialogInterface.OnDismissListener {
    public static final String ARG_CONTACT_URI = "contactUri";
    private static final int COLUMN_INDEX_ACCOUNT_TYPE = 1;
    private static final int COLUMN_INDEX_CONTACT_ID = 3;
    private static final int COLUMN_INDEX_DATA_SET = 2;
    private static final int COLUMN_INDEX_LOOKUP_KEY = 4;
    private static final int COLUMN_INDEX_RAW_CONTACT_ID = 0;
    private static final String[] ENTITY_PROJECTION = null;
    private static final String FRAGMENT_TAG = "deleteContact";
    private static final String KEY_ACTIVE = "active";
    private static final String KEY_CONTACT_URI = "contactUri";
    private static final String KEY_FINISH_WHEN_DONE = "finishWhenDone";
    private boolean mActive;
    private Uri mContactUri;
    private OAlertDialog mDialog;
    private boolean mFinishActivityWhenDone;
    private boolean mIsDeleteRawContact;
    int mMessageId;
    private Uri mRawContactUri;
    private TestLoaderManager mTestLoaderManager;

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> r1) {
    }

    public ContactDeletionInteraction() {
        this.mIsDeleteRawContact = false;
    }

    static /* synthetic */ boolean access$000(ContactDeletionInteraction r0) {
        return r0.mIsDeleteRawContact;
    }

    static /* synthetic */ Uri access$100(ContactDeletionInteraction r0) {
        return r0.mRawContactUri;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> r1, Cursor r2) {
        onLoadFinished2(r1, r2);
    }

    static {
        ENTITY_PROJECTION = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "account_type", "data_set", "contact_id", "lookup"};
    }

    public static ContactDeletionInteraction start(Activity r1, Uri r2, boolean r3) {
        return startWithTestLoaderManager(r1, r2, r3, null);
    }

    public static ContactDeletionInteraction start(Activity r6, Uri r7, boolean r8, boolean r9, Uri r10) {
        return startWithTestLoaderManager(r6, r7, r8, null, r9, r10);
    }

    static ContactDeletionInteraction startWithTestLoaderManager(Activity r6, Uri r7, boolean r8, TestLoaderManager r9) {
        return startWithTestLoaderManager(r6, r7, r8, r9, false, null);
    }

    static ContactDeletionInteraction startWithTestLoaderManager(Activity r2, Uri r3, boolean r4, TestLoaderManager r5, boolean r6, Uri r7) {
        if (r3 != null) goto L5;
        return null;
    L5:
        FragmentManager r8 = r2.getFragmentManager();
        ContactDeletionInteraction r1 = (ContactDeletionInteraction) r8.findFragmentByTag(FRAGMENT_TAG);
        if (r1 != null) goto L8;
        ContactDeletionInteraction r9 = new ContactDeletionInteraction();
        r9.setTestLoaderManager(r5);
        r9.setContactUri(r3);
        r9.setRawContactUri(r7);
        r9.setIsDeleteRawContact(r6);
        r9.setFinishActivityWhenDone(r4);
        r8.beginTransaction().add(r9, FRAGMENT_TAG).commitAllowingStateLoss();
        return r9;
    L8:
        r1.setTestLoaderManager(r5);
        r1.setContactUri(r3);
        r1.setRawContactUri(r7);
        r1.setIsDeleteRawContact(r6);
        r1.setFinishActivityWhenDone(r4);
        return r1;
    }

    @Override // android.app.Fragment
    public LoaderManager getLoaderManager() {
        LoaderManager r0 = super.getLoaderManager();
        TestLoaderManager r1 = this.mTestLoaderManager;
        if (r1 == null) goto L6;
        r1.setDelegate(r0);
        return this.mTestLoaderManager;
    L6:
        return r0;
    }

    private void setTestLoaderManager(TestLoaderManager r1) {
        this.mTestLoaderManager = r1;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        OAlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mDialog.setOnDismissListener(null);
        this.mDialog.dismiss();
        this.mDialog = null;
        return;
    }

    public void setContactUri(Uri r3) {
        this.mContactUri = r3;
        this.mActive = true;
        if (isStarted() == false) goto L6;
        Bundle r4 = new Bundle();
        r4.putParcelable("contactUri", this.mContactUri);
        getLoaderManager().restartLoader(R.id.dialog_delete_contact_loader_id, r4, this);
        return;
    }

    public void setRawContactUri(Uri r1) {
        this.mRawContactUri = r1;
    }

    public void setIsDeleteRawContact(boolean r1) {
        this.mIsDeleteRawContact = r1;
    }

    private void setFinishActivityWhenDone(boolean r1) {
        this.mFinishActivityWhenDone = r1;
    }

    boolean isStarted() {
        return isAdded();
    }

    @Override // android.app.Fragment
    public void onStart() {
        if (this.mActive == false) goto L5;
        Bundle r0 = new Bundle();
        r0.putParcelable("contactUri", this.mContactUri);
        getLoaderManager().initLoader(R.id.dialog_delete_contact_loader_id, r0, this);
    L5:
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        OAlertDialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int r10, Bundle r11) {
        Uri r12 = (Uri) r11.getParcelable("contactUri");
        if (r12 != null) goto L14;
    L13:
        return null;
    L14:
        if (ContentUris.parseId(r12) > 0) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(FRAGMENT_TAG, "Invalid contactId in URI: " + r12);
        return null;
    L10:
        return new CursorLoader(getActivity(), Uri.withAppendedPath(r12, "entities"), ENTITY_PROJECTION, null, null, null);
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(FRAGMENT_TAG, "Invalid contactId in URI: " + r12, e);
        goto L13
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<Cursor> r12, Cursor r13) {
        OAlertDialog r14 = this.mDialog;
        String r0 = null;
        if (r14 == null) goto L6;
        r14.dismiss();
        this.mDialog = null;
    L6:
        if (this.mActive == true) goto L8;
        return;
    L8:
        HashSet r15 = Sets.newHashSet();
        HashSet r1 = Sets.newHashSet();
        AccountTypeManager r2 = AccountTypeManager.getInstance(getActivity());
        long r4 = 0;
        if (r13 == null) goto L22;
        r13.moveToPosition(-1);
    L12:
        if (r13.moveToNext() == false) goto L22;
        boolean r3 = false;
        long r5 = r13.getLong(0);
        String r6 = r13.getString(1);
        String r7 = r13.getString(2);
        long r8 = r13.getLong(3);
        String r10 = r13.getString(4);
        AccountType r9 = r2.getAccountType(r6, r7);
        if (r9 != null) goto L16;
    L17:
        r3 = true;
    L18:
        if (r3 == false) goto L20;
        r1.add(Long.valueOf(r5));
    L21:
        r4 = r8;
        r0 = r10;
        goto L12
    L20:
        r15.add(Long.valueOf(r5));
        goto L21
    L16:
        if (r9.areContactsWritable() == false) goto L18;
    L22:
        int r16 = r15.size();
        int r17 = r1.size();
        if (r16 <= 0) goto L26;
        if (r17 <= 0) goto L26;
        this.mMessageId = R.string.readOnlyContactDeleteConfirmation;
    L33:
        showDialog(ContactsContract.Contacts.getLookupUri(r4, r0));
        getLoaderManager().destroyLoader(R.id.dialog_delete_contact_loader_id);
        return;
    L26:
        if (r16 <= 0) goto L29;
        if (r17 != 0) goto L29;
        this.mMessageId = R.string.readOnlyContactWarning;
    L29:
        if (r16 != 0) goto L32;
        if (r17 <= 1) goto L32;
        this.mMessageId = R.string.multipleContactDeleteConfirmation;
    L32:
        this.mMessageId = R.string.deleteConfirmation;
        goto L33
    }

    private void showDialog(final Uri r14) {
        final int r0 = BDSettingsEvent.EVENT_TYPE_CONTACT_DELETE.getType();
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(getContext(), r0, true, false);
        OAlertDialog r15 = OAlertDialogUtils.showConfirmationDialog(getActivity(), getString(R.string.deleteConfirmation_title), null, getString(R.string.btn_confirm_delete), new AnonymousClass1(this, r14, r0), ButtonStyleController.TextColorType.Negative, getString(R.string.common_cancel), new AnonymousClass2(this, r0), null);
        this.mDialog = r15;
        r15.setOnShowListener(new AnonymousClass3(this));
        this.mDialog.setOnDismissListener(this);
        this.mDialog.show();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r4) {
        if ((getActivity() instanceof ContactEditorActivity) == false) goto L5;
        new Handler().postDelayed(new AnonymousClass4(this), 100);
    L5:
        this.mActive = false;
        this.mDialog = null;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putBoolean(KEY_ACTIVE, this.mActive);
        r3.putParcelable("contactUri", this.mContactUri);
        r3.putBoolean(KEY_FINISH_WHEN_DONE, this.mFinishActivityWhenDone);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        if (r2 == null) goto L6;
        this.mActive = r2.getBoolean(KEY_ACTIVE);
        this.mContactUri = (Uri) r2.getParcelable("contactUri");
        this.mFinishActivityWhenDone = r2.getBoolean(KEY_FINISH_WHEN_DONE);
        return;
    }

    protected void doDeleteContact(Uri r3) {
        getActivity().startService(ContactSaveService.createDeleteContactIntent(getActivity(), r3));
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mFinishActivityWhenDone == true) goto L7;
        return;
    L7:
        if (getActivity() == null) goto L12;
        Intent r0 = new Intent();
        r0.setData(r3);
        r0.putExtra("deleted", true);
        getActivity().setResult(-1, r0);
        getActivity().finish();
        return;
    }

    protected void doDeleteRawContact(Uri r3, Uri r4) {
        getActivity().startService(ContactSaveService.createDeleteRawContactIntent(getActivity(), r4));
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mFinishActivityWhenDone == false) goto L9;
        Intent r5 = new Intent();
        r5.setData(r3);
        r5.putExtra("deleted", true);
        Activity r2 = getActivity();
        r2.setResult(-1, r5);
        r2.finish();
        return;
    }
}
