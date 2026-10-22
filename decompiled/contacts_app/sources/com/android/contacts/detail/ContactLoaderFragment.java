package com.android.contacts.detail;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ServiceManager;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.activities.ContactDetailActivity;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.list.ShortcutIntentBuilder;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.BytedanceApi;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.PhoneCapabilityTester;
import com.android.contacts.util.ShareContactByText;
import com.android.internal.telephony.ITelephony;
import com.google.common.base.Objects;
import com.obric.contacts.Constants;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ContactLoaderFragment extends Fragment implements ContactDetailActivity.FragmentKeyListener {
    private static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final String INTENT_RESOLVER_PACKAGE_NAME = "com.android.intentresolver";
    private static final String KEY_CONTACT_URI = "contactUri";
    private static final String LOADER_ARG_CONTACT_URI = "contactUri";
    private static final int LOADER_DETAILS = 1;
    private static final int REQUEST_CODE_PICK_RINGTONE = 1;
    private static final String TAG = "ContactLoaderFragment";
    private ContactLoader.Result mContactData;
    private Context mContext;
    private String mCustomRingtone;
    private final LoaderManager.LoaderCallbacks<ContactLoader.Result> mDetailLoaderListener;
    private ContactLoaderFragmentListener mListener;
    private Uri mLookupUri;
    private OActionDialog mOActionDialog;
    private boolean mPreLoadSuccess;
    private DialogInterface.OnClickListener onBtnShareSelect;

    public interface ContactLoaderFragmentListener {
        void onContactNotFound();

        void onDeleteRequested(Uri r1);

        void onDetailsLoaded(ContactLoader.Result r1);

        void onEditRequested(Uri r1);
    }

    static /* synthetic */ Context access$000(ContactLoaderFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$100(ContactLoaderFragment r0) {
        return r0.mPreLoadSuccess;
    }

    static /* synthetic */ boolean access$102(ContactLoaderFragment r0, boolean r1) {
        r0.mPreLoadSuccess = r1;
        return r1;
    }

    static /* synthetic */ Uri access$200(ContactLoaderFragment r0) {
        return r0.mLookupUri;
    }

    static /* synthetic */ ContactLoader.Result access$300(ContactLoaderFragment r0) {
        return r0.mContactData;
    }

    static /* synthetic */ ContactLoader.Result access$302(ContactLoaderFragment r0, ContactLoader.Result r1) {
        r0.mContactData = r1;
        return r1;
    }

    static /* synthetic */ ContactLoaderFragmentListener access$400(ContactLoaderFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ OActionDialog access$500(ContactLoaderFragment r0) {
        return r0.mOActionDialog;
    }

    public ContactLoaderFragment() {
        this.mPreLoadSuccess = false;
        this.mDetailLoaderListener = new AnonymousClass1(this);
        this.onBtnShareSelect = new AnonymousClass6(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L6;
        this.mLookupUri = (Uri) r2.getParcelable("contactUri");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putParcelable("contactUri", this.mLookupUri);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mContext = r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return r1.inflate(R.layout.contact_detail_loader_fragment, r2, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (this.mLookupUri == null) goto L11;
        Bundle r4 = new Bundle();     // Catch: IllegalStateException -> L6
        r4.putParcelable("contactUri", this.mLookupUri);     // Catch: IllegalStateException -> L6
        LoaderManager.getInstance(this).initLoader(1, r4, this.mDetailLoaderListener);     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "fail to init loader");
        e.printStackTrace();
        return;
    }

    public void loadUri(Uri r4) {
        if (Objects.equal(r4, this.mLookupUri) == false) goto L5;
        return;
    L5:
        this.mLookupUri = r4;
        if (r4 != null) goto L11;
        getLoaderManager().destroyLoader(1);
        this.mContactData = null;
        ContactLoaderFragmentListener r3 = this.mListener;
        if (r3 == null) goto L14;
        r3.onDetailsLoaded(null);
        return;
    L14:
        return;
    L11:
        if (getActivity() == null) goto L16;
        Bundle r5 = new Bundle();
        r5.putParcelable("contactUri", this.mLookupUri);
        getLoaderManager().restartLoader(1, r5, this.mDetailLoaderListener);
        return;
    }

    public void preLoadSuccess(ContactLoader.Result r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mContactData = r2;
        this.mLookupUri = r2.getLookupUri();
        ContactLoaderFragmentListener r3 = this.mListener;
        if (r3 == null) goto L8;
        r3.onDetailsLoaded(this.mContactData);
        this.mPreLoadSuccess = true;
        return;
    }

    public void setListener(ContactLoaderFragmentListener r1) {
        this.mListener = r1;
    }

    public boolean isContactOptionsChangeEnabled() {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isDirectoryEntry() == true) goto L9;
        if (PhoneCapabilityTester.isPhone(this.mContext) == false) goto L9;
        return true;
    }

    public boolean isContactEditable() {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isDirectoryEntry() == true) goto L7;
        return true;
    }

    public boolean isContactShareable() {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isDirectoryEntry() == true) goto L7;
        return true;
    }

    public void setContactEdit() {
        ContactLoaderFragmentListener r0 = this.mListener;
        if (r0 == null) goto L8;
        Uri r1 = this.mLookupUri;
        if (r1 == null) goto L9;
        r0.onEditRequested(r1);
        return;
    L9:
        return;
    }

    private Uri getVCardUri(ContactLoader.Result r1) {
        String r0 = r1.getLookupKey();
        return Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, r0);
    }

    public void setShareContactVcf() {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
        return;
    L5:
        Uri r1 = getVCardUri(r0);
        if (this.mContactData.isUserProfile() == false) goto L8;
        r1 = getPreAuthorizedUri(r1);
    L8:
        String r2 = ContactsUtils.getContactName(getActivity(), this.mContactData.getDisplayName());
    L28:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "vcfile create error" + e);
    L30:
        this.mContext.grantUriPermission(INTENT_RESOLVER_PACKAGE_NAME, r1, 1);
        String r3 = getString(R.string.share_contact_subject_context, new Object[]{r2});
        Intent r4 = new Intent("android.intent.action.SEND");
        r4.setType("text/x-vcard");
        r4.putExtra("android.intent.extra.STREAM", r1);
        r4.putExtra("android.intent.extra.SUBJECT", r3);
        r4.addFlags(3);
        this.mContext.startActivity(Intent.createChooser(r4, this.mContext.getText(R.string.menu_share)));     // Catch: ActivityNotFoundException -> L33
        return;
    L33:
        Toast.makeText(this.mContext, R.string.share_error, 0).show();
        return;
    L10:
        if (this.mContext.getExternalCacheDir() == null) goto L30;
        File[] r5 = this.mContext.getExternalCacheDir().listFiles();     // Catch: Exception -> L28
        int r6 = r5.length;     // Catch: Exception -> L28
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L19;
        File r8 = r5[r7];     // Catch: Exception -> L28
        if (r8.getName().endsWith(".vcf") == false) goto L18;
        r8.delete();     // Catch: Exception -> L28
    L18:
        r7 = r7 + 1;     // Catch: Exception -> L28
        goto L14
    L19:
        InputStream r9 = this.mContext.getContentResolver().openInputStream(r1);     // Catch: Exception -> L28
        if (r9 != null) goto L22;
        return;
    L22:
        final File r10 = new File(this.mContext.getExternalCacheDir(), r2 + ".vcf");     // Catch: Exception -> L28
        FileOutputStream r11 = new FileOutputStream(r10);     // Catch: Exception -> L28
        byte[] r12 = new byte[4096];     // Catch: Exception -> L28
    L23:
        int r13 = r9.read(r12);     // Catch: Exception -> L28
        if (r13 == (-1)) goto L26;
        r11.write(r12, 0, r13);     // Catch: Exception -> L28
        goto L23
    L26:
        r11.close();     // Catch: Exception -> L28
        r9.close();     // Catch: Exception -> L28
        r1 = FileProvider.getUriForFile(this.mContext, ContactPhotoUtils.FILE_PROVIDER_AUTHORITY, r10);     // Catch: Exception -> L28
        new Handler().postDelayed(new ContactLoaderFragment$$ExternalSyntheticLambda0(r10), TimeUnit.MINUTES.toMillis(5));     // Catch: Exception -> L28
        goto L30
    }

    static /* synthetic */ void lambda$setShareContactVcf$0(File r1) {
        if (r1.exists() == false) goto L6;
        r1.delete();
        return;
    }

    public void setShowContactCalllog(String r4, List<String> r5, boolean r6, int r7) {
        if (this.mLookupUri != null) goto L5;
        return;
    L5:
        Intent r0 = new Intent(ContactCalllogsActivity.ACTION_VIEW);
        Bundle r1 = new Bundle();
        r1.putString(ContactCalllogsActivity.SELECTION_KEY, r4);
        r1.putStringArrayList(ContactCalllogsActivity.SELECTION_RESULT, (ArrayList) r5);
        r1.putBoolean(ContactCalllogsActivity.EXTRA_HAS_CALL_LOG, r6);
        if (r7 <= 1) goto L8;
        boolean r8 = true;
    L9:
        r1.putBoolean(ContactCalllogsActivity.EXTRA_CONTACT_HAS_MORE_NUMBERS, r8);
        r0.putExtras(r1);
        getActivity().startActivity(r0);
        AnimationUtil.switchActivityAnimation(getActivity(), 1);
        return;
    L8:
        r8 = false;
        goto L9
    }

    public void doDeleteContact() {
        ContactLoaderFragmentListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onDeleteRequested(this.mLookupUri);
        return;
    }

    public void setShareContact(String r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        showDialog(r2);
    }

    public void cancelShareContact() {
        OActionDialog r0 = this.mOActionDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mOActionDialog.dismiss();
        return;
    }

    private void showDialog(String r7) {
        final String r8 = getCallingNumbersString();
        boolean r0 = !TextUtils.isEmpty(r8);
        ArrayList r2 = new ArrayList();
        if (r0 == false) goto L5;
        r2.add(new ActionDialogItemData(getString(R.string.btn_share_contact_calling), ActionButtonStyle.Neutral, new AnonymousClass2(this, r8)));
    L5:
        r2.add(new ActionDialogItemData(getString(R.string.btn_share_contact_text), ActionButtonStyle.Neutral, new AnonymousClass3(this)));
        r2.add(new ActionDialogItemData(getString(R.string.btn_share_contact_vcf), ActionButtonStyle.Neutral, new AnonymousClass4(this)));
        r2.add(new ActionDialogItemData(getString(R.string.common_cancel), ActionButtonStyle.Neutral, new AnonymousClass5(this)));
        OActionDialog r9 = OUIDialogHelper.getActionDialog(this.mContext, getString(R.string.share_contact_dialog_title), "", r2, true);
        this.mOActionDialog = r9;
        r9.show();
    }

    private String getCallingNumbersString() {
        List<String> r7 = BytedanceApi.getActiveNumbers(ITelephony.Stub.asInterface(ServiceManager.checkService("phone")));
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.isEmpty() == true) goto L33;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r8 = r7.iterator();
        boolean r1 = true;
    L9:
        if (r8.hasNext() == false) goto L25;
        String r2 = r8.next();
        int r3 = r2.indexOf(SimContactsConstants.EMAIL_SEP);
        int r5 = r2.indexOf(";");
        if (r3 >= 0) goto L13;
        if (r5 >= 0) goto L13;
    L18:
        if (PhoneNumberUtils.isEmergencyNumber(r2) == true) goto L9;
        if (r1 == false) goto L22;
        r1 = false;
    L23:
        r0.append(r2);
        goto L9
    L22:
        r0.append(";");
    L13:
        if (r3 < 0) goto L15;
        r2 = r2.substring(0, r3);
        r5 = r2.indexOf(";");
    L15:
        if (r5 < 0) goto L18;
        r2 = r2.substring(0, r5);
        goto L18
    L25:
        return r0.toString();
    L33:
        return null;
    }

    private Intent generateTextShareIntent(ContactLoader.Result r4) {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
    L12:
        return null;
    L5:
        if (r0.getShareString() == null) goto L12;
        String r1 = ShareContactByText.toShareText(getActivity(), r4);
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return null;
    L10:
        String r3 = getString(R.string.share_contact_subject_context, new Object[]{ContactsUtils.getContactName(getActivity(), r4.getDisplayName())});
        Intent r5 = new Intent("android.intent.action.SEND");
        r5.setType(HTTP.PLAIN_TEXT_TYPE);
        r5.putExtra("android.intent.extra.SUBJECT", r3);
        r5.putExtra("android.intent.extra.TEXT", r1);
        return r5;
    }

    public void setShareTextContact() {
        Intent r0 = generateTextShareIntent(this.mContactData);
        if (r0 == null) goto L6;
        getActivity().startActivity(Intent.createChooser(r0, this.mContext.getText(R.string.menu_share)));
        return;
    }

    public void setCreateWidget() {
        final FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        new ShortcutIntentBuilder(r0, new AnonymousClass7(this, r0)).createContactShortcutIntent(this.mLookupUri);
    }

    public void shareContactToMms(String r5) {
        ContactLoader.Result r0 = this.mContactData;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getShareString() == null) goto L21;
        FragmentActivity r1 = getActivity();     // Catch: Exception -> L15
        if (r1 != null) goto L10;
        return;
    L10:
        String r2 = ShareContactByText.toShareText(r1, this.mContactData);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == false) goto L13;
        return;
    L13:
        Intent r3 = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", r5, null));     // Catch: Exception -> L15
        r3.putExtra("sms_body", r2);     // Catch: Exception -> L15
        r3.putExtra(Constants.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});     // Catch: Exception -> L15
        getActivity().startActivity(r3);     // Catch: Exception -> L15
        AnimationUtil.switchActivityAnimation(getActivity(), 1);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Parser vCard Exception shareUri:" + this.mContactData.toString());
        e.printStackTrace();
        return;
    }

    private Uri getPreAuthorizedUri(Uri r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable("uri_to_authorize", r5);
        Bundle r4 = this.mContext.getContentResolver().call(ContactsContract.AUTHORITY_URI, "authorize", null, r0);
        if (r4 != null) goto L5;
        return r5;
    L5:
        return (Uri) r4.getParcelable("authorized_uri");
    }

    @Override // com.android.contacts.activities.ContactDetailActivity.FragmentKeyListener
    public boolean handleKeyDown(int r2) {
        if (r2 == 67) goto L6;
        return false;
    L6:
        ContactLoaderFragmentListener r3 = this.mListener;
        if (r3 == null) goto L11;
        r3.onDeleteRequested(this.mLookupUri);
        return true;
    L11:
        return true;
    }

    public void doPickRingtone() {
        Intent r0 = new Intent("android.intent.action.RINGTONE_PICKER");
        r0.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        r0.putExtra("android.intent.extra.ringtone.TYPE", 1);
        r0.putExtra("android.intent.extra.ringtone.SHOW_SILENT", false);
        String r1 = this.mCustomRingtone;
        if (r1 == null) goto L5;
        Uri r2 = Uri.parse(r1);
    L6:
        r0.putExtra("android.intent.extra.ringtone.EXISTING_URI", r2);
        startActivityForResult(r0, 1);
        return;
    L5:
        r2 = RingtoneManager.getDefaultUri(1);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 1) goto L10;
        handleRingtonePicked((Uri) r4.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI"));
        return;
    }

    private void handleRingtonePicked(Uri r3) {
        if (r3 != null) goto L4;
    L7:
        this.mCustomRingtone = null;
    L8:
        Intent r4 = ContactSaveService.createSetRingtone(this.mContext, this.mLookupUri, this.mCustomRingtone);
        this.mContext.startService(r4);
        return;
    L4:
        if (RingtoneManager.isDefault(r3) == true) goto L7;
        this.mCustomRingtone = r3.toString();
        goto L8
    }
}
