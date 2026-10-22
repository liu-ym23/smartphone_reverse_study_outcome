package com.android.contacts.recyclebin;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.CallLogTimeRangeUtil;
import com.android.contacts.util.ContactsTracker;
import com.android.contacts.util.HanziToPinyin;
import com.obric.account.LocalAccountContactsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleItem implements Parcelable {
    public static final Parcelable.Creator<RecycleItem> CREATOR = null;
    public static final long ONE_MONTH = 2592000000L;
    public static final int SINCE_LAST_1_MONTH = 1;
    public static final int SINCE_LAST_3_DAY = 0;
    public static final int SINCE_LONG_TIME_AGO = 2;
    public static final long THREE_DAY = 259200000;
    private String callingApplicationLabel;
    private String callingPackage;
    public String displayName;
    private List<ContentValues> mDataRows;
    private AccountWithDataSet mDestAccount;
    private ContentValues mPrimaryDataRow;
    private AccountWithDataSet mSrcAccount;
    public byte[] photoBytes;
    public long rawContactId;
    private long recycleDate;
    public CharSequence recycleFormattedDate;
    public int section;
    public String sortkey;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RecycleItem() {
    }

    public void setRecycleDate(long r2) {
        this.recycleDate = r2;
        this.section = getRecycleDateSince(r2);
        this.recycleFormattedDate = CallLogTimeRangeUtil.getCallLogListFormatTime(r2);
    }

    public long getRecycleDate() {
        return this.recycleDate;
    }

    public void setCallingInfo(Context r1, String r2, String r3) {
        this.callingPackage = r2;
        String r4 = RecycleBinUtils.getApplicationLabelForPackageName(r1, r2);
        if (TextUtils.isEmpty(r4) == true) goto L6;
        r3 = r4;
    L6:
        this.callingApplicationLabel = r3;
    }

    public String getCallingInfoDescription(Context r6) {
        if (TextUtils.isEmpty(this.callingApplicationLabel) == false) goto L7;
        return r6.getString(R.string.recycle_by, new Object[]{this.callingPackage});
    L7:
        if ("com.android.contacts".equals(this.callingPackage) == false) goto L11;
        return r6.getString(R.string.recycle_by_self);
    L11:
        return r6.getString(R.string.recycle_by, new Object[]{this.callingApplicationLabel});
    }

    public AccountWithDataSet getSrcAccount() {
        return this.mSrcAccount;
    }

    public void setSrcAccount(String r2, String r3, String r4) {
        if (r2 != null) goto L4;
        r2 = "default";
    L4:
        if (r3 != null) goto L6;
        r3 = ContactsUtils.LOCAL_ACCOUNT_TYPE;
    L6:
        this.mSrcAccount = new AccountWithDataSet(r2, r3, r4);
    }

    public boolean calcDestAccount(AccountWithDataSet r3) {
        List<AccountWithDataSet> r0 = AccountTypeManager.getInstance(ContactsApplication.getInstance()).getAccounts(false);
        if (r0 != null) goto L5;
    L7:
        this.mDestAccount = r3;
        return ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(this.mSrcAccount.type);
    L5:
        if (r0.contains(this.mSrcAccount) == false) goto L7;
        this.mDestAccount = this.mSrcAccount;
        return true;
    }

    public void fillRestoreOperations(ArrayList<ContentProviderOperation> r7) {
        int r0 = r7.size();
        ContentProviderOperation.Builder r1 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        r1.withValue("account_name", this.mDestAccount.name);
        r1.withValue("account_type", this.mDestAccount.type);
        r1.withValue("data_set", this.mDestAccount.dataSet);
        r7.add(r1.build());
        List<ContentValues> r2 = this.mDataRows;
        if (r2 == null) goto L9;
        Iterator<ContentValues> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        ContentValues r4 = r3.next();
        r4.remove("_id");
        r4.remove(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID);
        ContentProviderOperation.Builder r5 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r5.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r0);
        r5.withValues(r4);
        r7.add(r5.build());
    L9:
        if (this.photoBytes == null) goto L13;
        ContentProviderOperation.Builder r6 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        ContentValues r8 = new ContentValues();
        r8.put("mimetype", "vnd.android.cursor.item/photo");
        r8.put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, this.photoBytes);
        r6.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r0);
        r6.withValues(r8);
        r7.add(r6.build());
        return;
    }

    public String getSectionHeader(Context r2) {
        int r1 = this.section;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L11;
        return r2.getString(R.string.recycle_since_long_ago);
    L11:
        return r2.getString(R.string.recycle_since_one_month);
    L9:
        return r2.getString(R.string.recycle_since_three_days);
    }

    public List<ContentValues> getDataRows() {
        return this.mDataRows;
    }

    public void addDataRow(ContentValues r2) {
        if (this.mDataRows != null) goto L5;
        this.mDataRows = new ArrayList();
    L5:
        this.mDataRows.add(r2);
    }

    public ContentValues getPrimaryDataRow() {
        return this.mPrimaryDataRow;
    }

    public String getPrimaryData() {
        ContentValues r1 = this.mPrimaryDataRow;
        if (r1 != null) goto L7;
        return "";
    L7:
        return r1.getAsString("data1");
    }

    public String getPrimaryDataMimeType() {
        ContentValues r1 = this.mPrimaryDataRow;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getAsString("mimetype");
    }

    public void setPrimaryDataRow(ContentValues r3) {
        if (r3 != null) goto L4;
    L6:
        this.mPrimaryDataRow = r3;
        return;
    L4:
        if ("vnd.android.cursor.item/phone_v2".equals(r3.getAsString("mimetype")) == false) goto L6;
        r3.put("data1", ContactsUtils.formatNumber(r3.getAsString("data1")));
        goto L6
    }

    public boolean search(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return false;
    L5:
        String r0 = this.displayName;
        if (r0 == null) goto L11;
        if (r0.contains(r7) == false) goto L11;
        return true;
    L11:
        if (this.mDataRows == null) goto L31;
        String r8 = r7.replace(HanziToPinyin.Token.SEPARATOR, "").replace("-", "").replace(SimContactsConstants.EMAIL_SEP, "");
        Iterator<ContentValues> r6 = this.mDataRows.iterator();
    L14:
        if (r6.hasNext() == false) goto L31;
        ContentValues r1 = r6.next();
        if ("vnd.android.cursor.item/phone_v2".equals(r1.getAsString("mimetype")) == true) goto L17;
        if ("vnd.android.cursor.item/email_v2".equals(r1.getAsString("mimetype")) == false) goto L14;
        String r2 = r1.getAsString("data1");
        if (TextUtils.isEmpty(r2) == true) goto L14;
        if (r2.contains(r8) == false) goto L14;
        return true;
    L17:
        String r3 = r1.getAsString("data1");
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (PhoneNumberUtils.normalizeNumber(r3).contains(r8) == false) goto L14;
        return true;
    L31:
        return false;
    }

    public static void deleteSingleRawContact(Context r4, boolean r5, RecycleItem r6) {
        if (r5 == false) goto L4;
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        r6.fillRestoreOperations(r0);
        ContactsUtils.runApplyBatch(r4.getContentResolver(), "com.android.contacts", r0);
    L4:
        ArrayList r1 = new ArrayList();
        r1.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(RecycleBinConstants.RAW_CONTACTS_ID_URI, r6.rawContactId)).build());
        ContactsUtils.runApplyBatch(r4.getContentResolver(), RecycleBinConstants.AUTHORITY, r1);
        ContactsTracker.trackRecycleBinOperation(r5, 1);
    }

    public static AccountWithDataSet getDefaultAccount(Context r5) {
        AccountTypeManager r6 = AccountTypeManager.getInstance(r5);
        AccountWithDataSet r0 = null;
        AccountWithDataSet r1 = LocalAccountContactsUtils.getLocalAccountContacts(null);
        List<AccountWithDataSet> r7 = r6.getAccounts(false);
        if (r7 == null) goto L10;
        Iterator<AccountWithDataSet> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        AccountWithDataSet r2 = r8.next();
        if (BytedanceAccountType.ACCOUNT_TYPE.equals(r2.type) == false) goto L6;
        r0 = r2;
    L10:
        if (r0 != null) goto L12;
        return r1;
    L12:
        return r0;
    }

    public static String calcDestAccountsOfSingleItem(Context r1, RecycleItem r2) {
        AccountWithDataSet r0 = getDefaultAccount(r1);
        if (r2.calcDestAccount(r0) == false) goto L6;
        return r1.getString(R.string.restore_single_to_same_accounts_msg);
    L6:
        if (ContactsUtils.LOCAL_ACCOUNT_TYPE.equals(r0.type) == false) goto L9;
        return r1.getString(R.string.restore_single_to_local_accounts_msg);
    L9:
        return r1.getString(R.string.restore_single_to_smile_cloud_accounts_msg);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L15;
        if (this.rawContactId != ((RecycleItem) r5).rawContactId) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r0 = this.rawContactId;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public String toString() {
        return "RecycleItem{rawContactId=" + this.rawContactId + ", displayName='" + this.displayName + "', section=" + this.section + ", recycleFormattedDate=" + this.recycleFormattedDate + ", sortkey='" + this.sortkey + "', recycleDate=" + this.recycleDate + ", callingPackage='" + this.callingPackage + "', callingApplicationLabel='" + this.callingApplicationLabel + "', mDataRows=" + this.mDataRows + ", mPrimaryDataRow=" + this.mPrimaryDataRow + ", photoBytes=" + Arrays.toString(this.photoBytes) + '}';
    }

    private int getRecycleDateSince(long r3) {
        long r0 = System.currentTimeMillis() - r3;
        if (r0 <= 0) goto L9;
        if (r0 >= THREE_DAY) goto L9;
        return 0;
    L9:
        if (r0 >= 2592000000L) goto L12;
        return 1;
    L12:
        return 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.rawContactId);
        r3.writeString(this.displayName);
        r3.writeTypedList(this.mDataRows);
        r3.writeParcelable(this.mSrcAccount, r4);
        r3.writeByteArray(this.photoBytes);
    }

    protected RecycleItem(Parcel r3) {
        this.rawContactId = r3.readLong();
        this.displayName = r3.readString();
        this.mDataRows = r3.createTypedArrayList(ContentValues.CREATOR);
        this.mSrcAccount = (AccountWithDataSet) r3.readParcelable(AccountWithDataSet.class.getClassLoader());
        this.photoBytes = r3.createByteArray();
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
