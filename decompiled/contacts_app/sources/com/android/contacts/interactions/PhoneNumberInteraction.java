package com.android.contacts.interactions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.contacts.Collapser;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.activities.TransactionSafeActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.DataKind;
import com.android.contacts.util.Constants;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.oui.checkbox.OCheckBox;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneNumberInteraction implements Loader.OnLoadCompleteListener<Cursor> {
    private static final String[] PHONE_NUMBER_PROJECTION = null;
    private static final String PHONE_NUMBER_SELECTION = "mimetype='vnd.android.cursor.item/phone_v2' AND data1 NOT NULL";
    private static final String TAG = "PhoneNumberInteraction";
    private final String mCallOrigin;
    private final Context mContext;
    private final DialogInterface.OnDismissListener mDismissListener;
    private final InteractionType mInteractionType;
    private CursorLoader mLoader;

    /* JADX INFO: renamed from: com.android.contacts.interactions.PhoneNumberInteraction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$contacts$interactions$PhoneNumberInteraction$InteractionType = null;

        static {
            int[] r0 = new int[InteractionType.values().length];
            $SwitchMap$com$android$contacts$interactions$PhoneNumberInteraction$InteractionType = r0;
            r0[InteractionType.SMS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    static final enum InteractionType extends Enum<InteractionType> {
        private static final /* synthetic */ InteractionType[] $VALUES = null;
        public static final InteractionType PHONE_CALL = null;
        public static final InteractionType SMS = null;

        private static /* synthetic */ InteractionType[] $values() {
            return new InteractionType[]{PHONE_CALL, SMS};
        }

        public static InteractionType valueOf(String r1) {
            return (InteractionType) Enum.valueOf(InteractionType.class, r1);
        }

        public static InteractionType[] values() {
            return (InteractionType[]) $VALUES.clone();
        }

        private InteractionType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PHONE_CALL = new InteractionType("PHONE_CALL", 0);
            SMS = new InteractionType("SMS", 1);
            $VALUES = $values();
        }
    }

    public static class PhoneDisambiguationDialogFragment extends DialogFragment implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private static final String ARG_CALL_ORIGIN = "callOrigin";
        private static final String ARG_INTERACTION_TYPE = "interactionType";
        private static final String ARG_PHONE_LIST = "phoneList";
        private String mCallOrigin;
        private InteractionType mInteractionType;
        private List<PhoneItem> mPhoneList;
        private ListAdapter mPhonesAdapter;

        public PhoneDisambiguationDialogFragment() {
        }

        public static void show(FragmentManager r3, ArrayList<PhoneItem> r4, InteractionType r5, String r6) {
            PhoneDisambiguationDialogFragment r0 = new PhoneDisambiguationDialogFragment();
            Bundle r1 = new Bundle();
            r1.putParcelableArrayList(ARG_PHONE_LIST, r4);
            r1.putSerializable(ARG_INTERACTION_TYPE, r5);
            r1.putString(ARG_CALL_ORIGIN, r6);
            r0.setArguments(r1);
            r0.show(r3, PhoneNumberInteraction.TAG);
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            Activity r5 = getActivity();
            this.mPhoneList = getArguments().getParcelableArrayList(ARG_PHONE_LIST);
            this.mInteractionType = (InteractionType) getArguments().getSerializable(ARG_INTERACTION_TYPE);
            this.mCallOrigin = getArguments().getString(ARG_CALL_ORIGIN);
            this.mPhonesAdapter = new PhoneItemAdapter(r5, this.mPhoneList, this.mInteractionType);
            View r0 = r5.getLayoutInflater().inflate(R.layout.set_primary_checkbox, null);
            AlertDialog.Builder r6 = new AlertDialog.Builder(r5).setAdapter(this.mPhonesAdapter, this);
            if (this.mInteractionType != InteractionType.SMS) goto L5;
            int r3 = R.string.sms_disambig_title;
        L7:
            return r6.setTitle(r3).setView(r0).create();
        L5:
            r3 = R.string.call_disambig_title;
            goto L7
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r3, int r4) {
            AlertDialog r0 = (AlertDialog) r3;
            if (this.mPhoneList.size() <= r4) goto L9;
            if (r4 < 0) goto L9;
            PhoneItem r5 = this.mPhoneList.get(r4);
            if (((OCheckBox) r0.findViewById(R.id.setPrimary)).isChecked() == false) goto L8;
            Intent r6 = ContactSaveService.createSetSuperPrimaryIntent(getActivity(), r5.id);
            getActivity().startService(r6);
        L8:
            PhoneNumberInteraction.access$100(getActivity(), r5.phoneNumber, this.mInteractionType, this.mCallOrigin);
            return;
        L9:
            r3.dismiss();
        }
    }

    static class PhoneItem implements Parcelable, Collapser.Collapsible<PhoneItem> {
        public static final Parcelable.Creator<PhoneItem> CREATOR = null;
        String accountType;
        String dataSet;
        long id;
        String label;
        String phoneNumber;
        long type;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean collapseWith(PhoneItem r1) {
            return collapseWith2(r1);
        }

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean shouldCollapseWith(PhoneItem r1) {
            return shouldCollapseWith2(r1);
        }

        /* synthetic */ PhoneItem(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        public PhoneItem() {
        }

        private PhoneItem(Parcel r3) {
            this.id = r3.readLong();
            this.phoneNumber = r3.readString();
            this.accountType = r3.readString();
            this.dataSet = r3.readString();
            this.type = r3.readLong();
            this.label = r3.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeLong(this.id);
            r3.writeString(this.phoneNumber);
            r3.writeString(this.accountType);
            r3.writeString(this.dataSet);
            r3.writeLong(this.type);
            r3.writeString(this.label);
        }

        /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
        public boolean collapseWith2(PhoneItem r1) {
            if (shouldCollapseWith2(r1) == true) goto L6;
            return false;
        L6:
            return true;
        }

        /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
        public boolean shouldCollapseWith2(PhoneItem r2) {
            return ContactsUtils.shouldCollapse("vnd.android.cursor.item/phone_v2", this.phoneNumber, "vnd.android.cursor.item/phone_v2", r2.phoneNumber);
        }

        public String toString() {
            return this.phoneNumber;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static class PhoneItemAdapter extends ArrayAdapter<PhoneItem> {
        private final AccountTypeManager mAccountTypeManager;
        private final InteractionType mInteractionType;

        public PhoneItemAdapter(Context r3, List<PhoneItem> r4, InteractionType r5) {
            super(r3, R.layout.phone_disambig_item, android.R.id.text2, r4);
            this.mInteractionType = r5;
            this.mAccountTypeManager = AccountTypeManager.getInstance(r3);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            View r8 = super.getView(r5, r6, r7);
            PhoneItem r9 = getItem(r5);
            AccountType r10 = this.mAccountTypeManager.getAccountType(r9.accountType, r9.dataSet);
            TextView r0 = (TextView) r8.findViewById(android.R.id.text1);
            DataKind r11 = r10.getKindForMimetype("vnd.android.cursor.item/phone_v2");
            if (r11 == null) goto L9;
            ContentValues r1 = new ContentValues();
            r1.put(DBHelper.COL_DATA2, Long.valueOf(r9.type));
            r1.put(DBHelper.COL_DATA3, r9.label);
            if (this.mInteractionType != InteractionType.SMS) goto L7;
            AccountType.StringInflater r12 = r11.actionAltHeader;
        L8:
            r0.setText(r12.inflateUsing(getContext(), r1));
        L10:
            return r8;
        L7:
            r12 = r11.actionHeader;
            goto L8
        L9:
            r0.setText(R.string.common_call);
            goto L10
        }
    }

    static /* synthetic */ void access$100(Context r0, String r1, InteractionType r2, String r3) {
        performAction(r0, r1, r2, r3);
    }

    @Override // android.content.Loader.OnLoadCompleteListener
    public /* bridge */ /* synthetic */ void onLoadComplete(Loader<Cursor> r1, Cursor r2) {
        onLoadComplete2(r1, r2);
    }

    static {
        PHONE_NUMBER_PROJECTION = new String[]{"_id", "data1", "is_super_primary", "account_type", "data_set", DBHelper.COL_DATA2, DBHelper.COL_DATA3};
    }

    PhoneNumberInteraction(Context r2, InteractionType r3, DialogInterface.OnDismissListener r4) {
        this(r2, r3, r4, null);
    }

    private PhoneNumberInteraction(Context r1, InteractionType r2, DialogInterface.OnDismissListener r3, String r4) {
        this.mContext = r1;
        this.mInteractionType = r2;
        this.mDismissListener = r3;
        this.mCallOrigin = r4;
    }

    private void performAction(String r3) {
        performAction(this.mContext, r3, this.mInteractionType, this.mCallOrigin);
    }

    private static void performAction(Context r2, String r3, InteractionType r4, String r5) {
        if (AnonymousClass1.$SwitchMap$com$android$contacts$interactions$PhoneNumberInteraction$InteractionType[r4.ordinal()] == 1) goto L7;
        Intent r6 = new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts(Constants.SCHEME_TEL, r3, null));
        if (r5 == null) goto L8;
        r6.putExtra("com.android.phone.CALL_ORIGIN", r5);
    L8:
        r2.startActivity(r6);
        return;
    L7:
        r6 = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", r3, null));
        goto L8
    }

    void startInteraction(Uri r9) {
        CursorLoader r0 = this.mLoader;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        String r1 = r9.toString();
        if (r1.startsWith(ContactsContract.Contacts.CONTENT_URI.toString()) == false) goto L11;
        if (r1.endsWith("data") == true) goto L12;
        r9 = Uri.withAppendedPath(r9, "data");
    L12:
        CursorLoader r10 = new CursorLoader(this.mContext, r9, PHONE_NUMBER_PROJECTION, PHONE_NUMBER_SELECTION, null, null);
        this.mLoader = r10;
        r10.registerListener(0, this);
        this.mLoader.startLoading();
        return;
    L11:
        if (r1.startsWith(ContactsContract.Data.CONTENT_URI.toString()) == true) goto L12;
        throw new UnsupportedOperationException("Input Uri must be contact Uri or data Uri (input: \"" + r9 + "\")");
    }

    /* JADX INFO: renamed from: onLoadComplete, reason: avoid collision after fix types in other method */
    public void onLoadComplete2(Loader<Cursor> r5, Cursor r6) {
        if (r6 != null) goto L4;
    L31:
        onDismiss();
        return;
    L4:
        if (isSafeToCommitTransactions() == false) goto L31;
        ArrayList<PhoneItem> r7 = new ArrayList();
    L33:
    L28:
        th = move-exception;
        r6.close();
        throw th;
    L8:
        if (r6.moveToNext() == false) goto L15;
        if (r6.getInt(r6.getColumnIndex("is_super_primary")) != 0) goto L12;
        PhoneItem r0 = new PhoneItem();     // Catch: Throwable -> L28
        r0.id = r6.getLong(r6.getColumnIndex("_id"));     // Catch: Throwable -> L28
        r0.phoneNumber = r6.getString(r6.getColumnIndex("data1"));     // Catch: Throwable -> L28
        r0.accountType = r6.getString(r6.getColumnIndex("account_type"));     // Catch: Throwable -> L28
        r0.dataSet = r6.getString(r6.getColumnIndex("data_set"));     // Catch: Throwable -> L28
        r0.type = r6.getInt(r6.getColumnIndex(DBHelper.COL_DATA2));     // Catch: Throwable -> L28
        r0.label = r6.getString(r6.getColumnIndex(DBHelper.COL_DATA3));     // Catch: Throwable -> L28
        r7.add(r0);     // Catch: Throwable -> L28
        goto L33
    L12:
        String r1 = r6.getString(r6.getColumnIndex("data1"));     // Catch: Throwable -> L28
    L16:
        r6.close();
        if (r1 == null) goto L20;
        performAction(r1);
        onDismiss();
        return;
    L20:
        Collapser.collapseList(r7);
        if (r7.size() != 0) goto L24;
        onDismiss();
        return;
    L24:
        if (r7.size() != 1) goto L26;
        onDismiss();
        performAction(r7.get(0).phoneNumber);
        return;
    L26:
        showDisambiguationDialog(r7);
        return;
    L15:
        r1 = null;
        goto L16
    }

    private boolean isSafeToCommitTransactions() {
        Context r1 = this.mContext;
        if ((r1 instanceof TransactionSafeActivity) == true) goto L7;
        return true;
    L7:
        return ((TransactionSafeActivity) r1).isSafeToCommitTransactions();
    }

    private void onDismiss() {
        DialogInterface.OnDismissListener r1 = this.mDismissListener;
        if (r1 == null) goto L6;
        r1.onDismiss(null);
        return;
    }

    public static void startInteractionForPhoneCall(TransactionSafeActivity r3, Uri r4) {
        new PhoneNumberInteraction(r3, InteractionType.PHONE_CALL, null).startInteraction(r4);
    }

    public static void startInteractionForPhoneCall(TransactionSafeActivity r3, Uri r4, String r5) {
        new PhoneNumberInteraction(r3, InteractionType.PHONE_CALL, null, r5).startInteraction(r4);
    }

    public static void startInteractionForTextMessage(TransactionSafeActivity r3, Uri r4) {
        new PhoneNumberInteraction(r3, InteractionType.SMS, null).startInteraction(r4);
    }

    CursorLoader getLoader() {
        return this.mLoader;
    }

    void showDisambiguationDialog(ArrayList<PhoneItem> r3) {
        PhoneDisambiguationDialogFragment.show(((Activity) this.mContext).getFragmentManager(), r3, this.mInteractionType, this.mCallOrigin);
    }
}
