package com.android.vcard;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class VCardEntry {
    public static final String CONTACT_ADDED_TIME_MIMETYPE = "vnd.android.cursor.item/added_time";
    private static final int DEFAULT_ORGANIZATION_TYPE = 1;
    private static final String LOG_TAG = "vCard";
    private static final List<String> sEmptyList = null;
    private static final Map<String, Integer> sImMap = null;
    private final Account mAccount;
    private List<AndroidCustomData> mAndroidCustomDataList;
    private AnniversaryData mAnniversary;
    private BirthdayData mBirthday;
    private List<VCardEntry> mChildren;
    private List<EmailData> mEmailList;
    private List<ImData> mImList;
    private final NameData mNameData;
    private List<NicknameData> mNicknameList;
    private List<NoteData> mNoteList;
    private List<OrganizationData> mOrganizationList;
    private List<PhoneData> mPhoneList;
    private List<PhotoData> mPhotoList;
    private List<PostalData> mPostalList;
    private List<SipData> mSipList;
    private List<Pair<String, String>> mUnknownXData;
    private final int mVCardType;
    private List<WebsiteData> mWebsiteList;

    /* JADX INFO: renamed from: com.android.vcard.VCardEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class AndroidCustomData implements EntryElement {
        private final List<String> mDataList;
        private final String mMimeType;

        public AndroidCustomData(String r1, List<String> r2) {
            this.mMimeType = r1;
            this.mDataList = r2;
        }

        public static AndroidCustomData constructAndroidCustomData(List<String> r5) {
            String r0 = null;
            if (r5 != null) goto L6;
            List<String> r6 = null;
        L13:
            return new AndroidCustomData(r0, r6);
        L6:
            if (r5.size() >= 2) goto L8;
            r0 = r5.get(0);
            r6 = null;
            goto L13
        L8:
            int r1 = 16;
            if (r5.size() >= 16) goto L11;
            r1 = r5.size();
        L11:
            r0 = r5.get(0);
            r6 = r5.subList(1, r1);
            goto L13
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r5, int r6) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r6);
            r0.withValue("mimetype", this.mMimeType);
            int r7 = 0;
        L4:
            if (r7 >= this.mDataList.size()) goto L9;
            String r1 = this.mDataList.get(r7);
            if (TextUtils.isEmpty(r1) == true) goto L8;
            r0.withValue("data" + (r7 + 1), r1);
        L8:
            r7 = r7 + 1;
            goto L4
        L9:
            r5.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.mMimeType) == true) goto L10;
            List<String> r1 = this.mDataList;
            if (r1 == null) goto L10;
            if (r1.size() == 0) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if ((r7 instanceof AndroidCustomData) == true) goto L8;
            return false;
        L8:
            AndroidCustomData r8 = (AndroidCustomData) r7;
            if (TextUtils.equals(this.mMimeType, r8.mMimeType) == true) goto L11;
            return false;
        L11:
            List<String> r1 = this.mDataList;
            if (r1 == null) goto L14;
            int r2 = r1.size();
            if (r2 == r8.mDataList.size()) goto L21;
            return false;
        L21:
            int r3 = 0;
        L22:
            if (r3 >= r2) goto L27;
            if (TextUtils.equals(this.mDataList.get(r3), r8.mDataList.get(r3)) == false) goto L25;
            r3 = r3 + 1;
            goto L22
        L25:
            return false;
        L27:
            return true;
        L14:
            if (r8.mDataList != null) goto L17;
            return true;
        L17:
            return false;
        }

        public int hashCode() {
            String r0 = this.mMimeType;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            List<String> r3 = this.mDataList;
            if (r3 == null) goto L16;
            Iterator<String> r4 = r3.iterator();
        L10:
            if (r4.hasNext() == false) goto L16;
            String r2 = r4.next();
            int r5 = r1 * 31;
            if (r2 == null) goto L14;
            int r6 = r2.hashCode();
        L15:
            r1 = r5 + r6;
            goto L10
        L14:
            r6 = 0;
        L16:
            return r1;
        L5:
            r1 = 0;
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("android-custom: " + this.mMimeType + ", data: ");
            List<String> r3 = this.mDataList;
            if (r3 != null) goto L5;
            String r4 = "null";
        L6:
            r0.append(r4);
            return r0.toString();
        L5:
            r4 = Arrays.toString(r3.toArray());
            goto L6
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.ANDROID_CUSTOM;
        }

        public String getMimeType() {
            return this.mMimeType;
        }

        public List<String> getDataList() {
            return this.mDataList;
        }
    }

    public static class AnniversaryData implements EntryElement {
        private final String mAnniversary;

        public AnniversaryData(String r1) {
            this.mAnniversary = r1;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            r0.withValue("data1", this.mAnniversary);
            r0.withValue(DBHelper.COL_DATA2, 1);
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mAnniversary);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof AnniversaryData) == true) goto L10;
            return false;
        L10:
            return TextUtils.equals(this.mAnniversary, ((AnniversaryData) r2).mAnniversary);
        }

        public int hashCode() {
            String r0 = this.mAnniversary;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "anniversary: " + this.mAnniversary;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.ANNIVERSARY;
        }

        public String getAnniversary() {
            return this.mAnniversary;
        }
    }

    public static class BirthdayData implements EntryElement {
        private final String mBirthday;

        static /* synthetic */ String access$1800(BirthdayData r0) {
            return r0.mBirthday;
        }

        public BirthdayData(String r1) {
            this.mBirthday = r1;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            r0.withValue("data1", this.mBirthday);
            r0.withValue(DBHelper.COL_DATA2, 3);
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mBirthday);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof BirthdayData) == true) goto L10;
            return false;
        L10:
            return TextUtils.equals(this.mBirthday, ((BirthdayData) r2).mBirthday);
        }

        public int hashCode() {
            String r0 = this.mBirthday;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "birthday: " + this.mBirthday;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.BIRTHDAY;
        }

        public String getBirthday() {
            return this.mBirthday;
        }
    }

    public static class EmailData implements EntryElement {
        private final String mAddress;
        private final boolean mIsPrimary;
        private final String mLabel;
        private final int mType;

        static /* synthetic */ String access$1500(EmailData r0) {
            return r0.mAddress;
        }

        public EmailData(String r1, int r2, String r3, boolean r4) {
            this.mType = r2;
            this.mAddress = r1;
            this.mLabel = r3;
            this.mIsPrimary = r4;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/email_v2");
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            if (this.mType != 0) goto L5;
            r0.withValue(DBHelper.COL_DATA3, this.mLabel);
        L5:
            r0.withValue("data1", this.mAddress);
            if (this.mIsPrimary == false) goto L8;
            r0.withValue("is_primary", 1);
        L8:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mAddress);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EmailData) == true) goto L8;
            return false;
        L8:
            EmailData r6 = (EmailData) r5;
            if (this.mType != r6.mType) goto L18;
            if (TextUtils.equals(this.mAddress, r6.mAddress) == false) goto L18;
            if (TextUtils.equals(this.mLabel, r6.mLabel) == false) goto L18;
            if (this.mIsPrimary != r6.mIsPrimary) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            int r0 = this.mType * 31;
            String r1 = this.mAddress;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.mLabel;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            if (this.mIsPrimary == false) goto L12;
            int r7 = 1231;
        L14:
            return r6 + r7;
        L12:
            r7 = 1237;
            goto L14
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.mType), this.mAddress, this.mLabel, Boolean.valueOf(this.mIsPrimary)});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.EMAIL;
        }

        public String getAddress() {
            return this.mAddress;
        }

        public int getType() {
            return this.mType;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    public interface EntryElement {
        void constructInsertOperation(List<ContentProviderOperation> r1, int r2);

        EntryLabel getEntryLabel();

        boolean isEmpty();
    }

    public interface EntryElementIterator {
        boolean onElement(EntryElement r1);

        void onElementGroupEnded();

        void onElementGroupStarted(EntryLabel r1);

        void onIterationEnded();

        void onIterationStarted();
    }

    public static final enum EntryLabel extends Enum<EntryLabel> {
        private static final /* synthetic */ EntryLabel[] $VALUES = null;
        public static final EntryLabel ANDROID_CUSTOM = null;
        public static final EntryLabel ANNIVERSARY = null;
        public static final EntryLabel BIRTHDAY = null;
        public static final EntryLabel EMAIL = null;
        public static final EntryLabel IM = null;
        public static final EntryLabel NAME = null;
        public static final EntryLabel NICKNAME = null;
        public static final EntryLabel NOTE = null;
        public static final EntryLabel ORGANIZATION = null;
        public static final EntryLabel PHONE = null;
        public static final EntryLabel PHOTO = null;
        public static final EntryLabel POSTAL_ADDRESS = null;
        public static final EntryLabel SIP = null;
        public static final EntryLabel WEBSITE = null;

        private EntryLabel(String r1, int r2) {
            super(r1, r2);
        }

        public static EntryLabel valueOf(String r1) {
            return (EntryLabel) Enum.valueOf(EntryLabel.class, r1);
        }

        public static EntryLabel[] values() {
            return (EntryLabel[]) $VALUES.clone();
        }

        static {
            EntryLabel r0 = new EntryLabel(VCardConstants.PROPERTY_NAME, 0);
            NAME = r0;
            EntryLabel r1 = new EntryLabel(SimContactsConstants.PHONE_NAME, 1);
            PHONE = r1;
            EntryLabel r3 = new EntryLabel(VCardConstants.PROPERTY_EMAIL, 2);
            EMAIL = r3;
            EntryLabel r5 = new EntryLabel("POSTAL_ADDRESS", 3);
            POSTAL_ADDRESS = r5;
            EntryLabel r7 = new EntryLabel("ORGANIZATION", 4);
            ORGANIZATION = r7;
            EntryLabel r9 = new EntryLabel("IM", 5);
            IM = r9;
            EntryLabel r11 = new EntryLabel(VCardConstants.PROPERTY_PHOTO, 6);
            PHOTO = r11;
            EntryLabel r13 = new EntryLabel("WEBSITE", 7);
            WEBSITE = r13;
            EntryLabel r15 = new EntryLabel("SIP", 8);
            SIP = r15;
            EntryLabel r14 = new EntryLabel(VCardConstants.PROPERTY_NICKNAME, 9);
            NICKNAME = r14;
            EntryLabel r12 = new EntryLabel(VCardConstants.PROPERTY_NOTE, 10);
            NOTE = r12;
            EntryLabel r10 = new EntryLabel("BIRTHDAY", 11);
            BIRTHDAY = r10;
            EntryLabel r8 = new EntryLabel(VCardConstants.PROPERTY_ANNIVERSARY, 12);
            ANNIVERSARY = r8;
            EntryLabel r6 = new EntryLabel("ANDROID_CUSTOM", 13);
            ANDROID_CUSTOM = r6;
            $VALUES = new EntryLabel[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
        }
    }

    public static class ImData implements EntryElement {
        private final String mAddress;
        private final String mCustomProtocol;
        private final boolean mIsPrimary;
        private final int mProtocol;
        private final int mType;

        public ImData(int r1, String r2, String r3, int r4, boolean r5) {
            this.mProtocol = r1;
            this.mCustomProtocol = r2;
            this.mType = r4;
            this.mAddress = r3;
            this.mIsPrimary = r5;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/im");
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            r0.withValue("data5", Integer.valueOf(this.mProtocol));
            r0.withValue("data1", this.mAddress);
            if (this.mProtocol != (-1)) goto L6;
            r0.withValue("data6", this.mCustomProtocol);
        L6:
            if (this.mIsPrimary == false) goto L8;
            r0.withValue("is_primary", 1);
        L8:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mAddress);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ImData) == true) goto L8;
            return false;
        L8:
            ImData r6 = (ImData) r5;
            if (this.mType != r6.mType) goto L20;
            if (this.mProtocol != r6.mProtocol) goto L20;
            if (TextUtils.equals(this.mCustomProtocol, r6.mCustomProtocol) == false) goto L20;
            if (TextUtils.equals(this.mAddress, r6.mAddress) == false) goto L20;
            if (this.mIsPrimary != r6.mIsPrimary) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            int r0 = ((this.mType * 31) + this.mProtocol) * 31;
            String r1 = this.mCustomProtocol;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.mAddress;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            if (this.mIsPrimary == false) goto L12;
            int r7 = 1231;
        L14:
            return r6 + r7;
        L12:
            r7 = 1237;
            goto L14
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.mType), Integer.valueOf(this.mProtocol), this.mCustomProtocol, this.mAddress, Boolean.valueOf(this.mIsPrimary)});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.IM;
        }

        public String getAddress() {
            return this.mAddress;
        }

        public int getProtocol() {
            return this.mProtocol;
        }

        public String getCustomProtocol() {
            return this.mCustomProtocol;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    private class InsertOperationConstrutor implements EntryElementIterator {
        private final int mBackReferenceIndex;
        private final List<ContentProviderOperation> mOperationList;
        final /* synthetic */ VCardEntry this$0;

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupEnded() {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupStarted(EntryLabel r1) {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationEnded() {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationStarted() {
        }

        public InsertOperationConstrutor(VCardEntry r1, List<ContentProviderOperation> r2, int r3) {
            this.this$0 = r1;
            this.mOperationList = r2;
            this.mBackReferenceIndex = r3;
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public boolean onElement(EntryElement r2) {
            if (r2.isEmpty() == true) goto L7;
            r2.constructInsertOperation(this.mOperationList, this.mBackReferenceIndex);
            return true;
        L7:
            return true;
        }
    }

    private class IsIgnorableIterator implements EntryElementIterator {
        private boolean mEmpty;
        final /* synthetic */ VCardEntry this$0;

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupEnded() {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupStarted(EntryLabel r1) {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationEnded() {
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationStarted() {
        }

        private IsIgnorableIterator(VCardEntry r1) {
            this.this$0 = r1;
            this.mEmpty = true;
        }

        /* synthetic */ IsIgnorableIterator(VCardEntry r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public boolean onElement(EntryElement r1) {
            if (r1.isEmpty() == true) goto L6;
            this.mEmpty = false;
            return false;
        L6:
            return true;
        }

        public boolean getResult() {
            return this.mEmpty;
        }
    }

    public static class NameData implements EntryElement {
        public String displayName;
        private String mFamily;
        private String mFormatted;
        private String mGiven;
        private String mMiddle;
        private String mPhoneticFamily;
        private String mPhoneticGiven;
        private String mPhoneticMiddle;
        private String mPrefix;
        private String mSortString;
        private String mSuffix;

        public NameData() {
        }

        static /* synthetic */ String access$1000(NameData r0) {
            return r0.mMiddle;
        }

        static /* synthetic */ String access$1002(NameData r0, String r1) {
            r0.mMiddle = r1;
            return r1;
        }

        static /* synthetic */ String access$1100(NameData r0) {
            return r0.mGiven;
        }

        static /* synthetic */ String access$1102(NameData r0, String r1) {
            r0.mGiven = r1;
            return r1;
        }

        static /* synthetic */ String access$1200(NameData r0) {
            return r0.mFamily;
        }

        static /* synthetic */ String access$1202(NameData r0, String r1) {
            r0.mFamily = r1;
            return r1;
        }

        static /* synthetic */ String access$1300(NameData r0) {
            return r0.mFormatted;
        }

        static /* synthetic */ String access$1302(NameData r0, String r1) {
            r0.mFormatted = r1;
            return r1;
        }

        static /* synthetic */ String access$1402(NameData r0, String r1) {
            r0.mSortString = r1;
            return r1;
        }

        static /* synthetic */ String access$500(NameData r0) {
            return r0.mPhoneticFamily;
        }

        static /* synthetic */ String access$502(NameData r0, String r1) {
            r0.mPhoneticFamily = r1;
            return r1;
        }

        static /* synthetic */ String access$600(NameData r0) {
            return r0.mPhoneticMiddle;
        }

        static /* synthetic */ String access$602(NameData r0, String r1) {
            r0.mPhoneticMiddle = r1;
            return r1;
        }

        static /* synthetic */ String access$700(NameData r0) {
            return r0.mPhoneticGiven;
        }

        static /* synthetic */ String access$702(NameData r0, String r1) {
            r0.mPhoneticGiven = r1;
            return r1;
        }

        static /* synthetic */ String access$800(NameData r0) {
            return r0.mSuffix;
        }

        static /* synthetic */ String access$802(NameData r0, String r1) {
            r0.mSuffix = r1;
            return r1;
        }

        static /* synthetic */ String access$900(NameData r0) {
            return r0.mPrefix;
        }

        static /* synthetic */ String access$902(NameData r0, String r1) {
            r0.mPrefix = r1;
            return r1;
        }

        public boolean emptyStructuredName() {
            if (TextUtils.isEmpty(this.mFamily) == true) goto L5;
        L13:
            return false;
        L5:
            if (TextUtils.isEmpty(this.mGiven) == false) goto L13;
            if (TextUtils.isEmpty(this.mMiddle) == false) goto L13;
            if (TextUtils.isEmpty(this.mPrefix) == false) goto L13;
            if (TextUtils.isEmpty(this.mSuffix) == false) goto L13;
            return true;
        }

        public boolean emptyPhoneticStructuredName() {
            if (TextUtils.isEmpty(this.mPhoneticFamily) == true) goto L5;
        L9:
            return false;
        L5:
            if (TextUtils.isEmpty(this.mPhoneticGiven) == false) goto L9;
            if (TextUtils.isEmpty(this.mPhoneticMiddle) == false) goto L9;
            return true;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r5, int r6) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r6);
            r0.withValue("mimetype", "vnd.android.cursor.item/name");
            if (TextUtils.isEmpty(this.mGiven) == true) goto L6;
            r0.withValue(DBHelper.COL_DATA2, this.mGiven);
        L6:
            if (TextUtils.isEmpty(this.mFamily) == true) goto L9;
            r0.withValue(DBHelper.COL_DATA3, this.mFamily);
        L9:
            if (TextUtils.isEmpty(this.mMiddle) == true) goto L12;
            r0.withValue("data5", this.mMiddle);
        L12:
            if (TextUtils.isEmpty(this.mPrefix) == true) goto L15;
            r0.withValue("data4", this.mPrefix);
        L15:
            if (TextUtils.isEmpty(this.mSuffix) == true) goto L17;
            r0.withValue("data6", this.mSuffix);
        L17:
            boolean r2 = true;
            if (TextUtils.isEmpty(this.mPhoneticGiven) == true) goto L20;
            r0.withValue("data7", this.mPhoneticGiven);
            boolean r7 = true;
        L22:
            if (TextUtils.isEmpty(this.mPhoneticFamily) == true) goto L25;
            r0.withValue("data9", this.mPhoneticFamily);
            r7 = true;
        L25:
            if (TextUtils.isEmpty(this.mPhoneticMiddle) == true) goto L27;
            r0.withValue("data8", this.mPhoneticMiddle);
        L28:
            if (r2 == true) goto L30;
            r0.withValue("data7", this.mSortString);
        L30:
            r0.withValue("data1", this.displayName);
            r5.add(r0.build());
            return;
        L27:
            r2 = r7;
            goto L28
        L20:
            r7 = false;
            goto L22
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.mFamily) == true) goto L5;
        L23:
            return false;
        L5:
            if (TextUtils.isEmpty(this.mMiddle) == false) goto L23;
            if (TextUtils.isEmpty(this.mGiven) == false) goto L23;
            if (TextUtils.isEmpty(this.mPrefix) == false) goto L23;
            if (TextUtils.isEmpty(this.mSuffix) == false) goto L23;
            if (TextUtils.isEmpty(this.mFormatted) == false) goto L23;
            if (TextUtils.isEmpty(this.mPhoneticFamily) == false) goto L23;
            if (TextUtils.isEmpty(this.mPhoneticMiddle) == false) goto L23;
            if (TextUtils.isEmpty(this.mPhoneticGiven) == false) goto L23;
            if (TextUtils.isEmpty(this.mSortString) == false) goto L23;
            return true;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof NameData) == true) goto L8;
            return false;
        L8:
            NameData r6 = (NameData) r5;
            if (TextUtils.equals(this.mFamily, r6.mFamily) == false) goto L30;
            if (TextUtils.equals(this.mMiddle, r6.mMiddle) == false) goto L30;
            if (TextUtils.equals(this.mGiven, r6.mGiven) == false) goto L30;
            if (TextUtils.equals(this.mPrefix, r6.mPrefix) == false) goto L30;
            if (TextUtils.equals(this.mSuffix, r6.mSuffix) == false) goto L30;
            if (TextUtils.equals(this.mFormatted, r6.mFormatted) == false) goto L30;
            if (TextUtils.equals(this.mPhoneticFamily, r6.mPhoneticFamily) == false) goto L30;
            if (TextUtils.equals(this.mPhoneticMiddle, r6.mPhoneticMiddle) == false) goto L30;
            if (TextUtils.equals(this.mPhoneticGiven, r6.mPhoneticGiven) == false) goto L30;
            if (TextUtils.equals(this.mSortString, r6.mSortString) == false) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            String[] r1 = {this.mFamily, this.mMiddle, this.mGiven, this.mPrefix, this.mSuffix, this.mFormatted, this.mPhoneticFamily, this.mPhoneticMiddle, this.mPhoneticGiven, this.mSortString};
            int r5 = 0;
            int r2 = 0;
        L3:
            if (r5 >= 10) goto L9;
            String r4 = r1[r5];
            int r3 = r2 * 31;
            if (r4 == null) goto L7;
            int r6 = r4.hashCode();
        L8:
            r2 = r3 + r6;
            r5 = r5 + 1;
            goto L3
        L7:
            r6 = 0;
            goto L8
        L9:
            return r2;
        }

        public String toString() {
            return String.format("family: %s, given: %s, middle: %s, prefix: %s, suffix: %s", new Object[]{this.mFamily, this.mGiven, this.mMiddle, this.mPrefix, this.mSuffix});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.NAME;
        }

        public String getFamily() {
            return this.mFamily;
        }

        public String getMiddle() {
            return this.mMiddle;
        }

        public String getGiven() {
            return this.mGiven;
        }

        public String getPrefix() {
            return this.mPrefix;
        }

        public String getSuffix() {
            return this.mSuffix;
        }

        public String getFormatted() {
            return this.mFormatted;
        }

        public String getSortString() {
            return this.mSortString;
        }

        public void setFamily(String r1) {
            this.mFamily = r1;
        }

        public void setMiddle(String r1) {
            this.mMiddle = r1;
        }

        public void setGiven(String r1) {
            this.mGiven = r1;
        }

        public void setPrefix(String r1) {
            this.mPrefix = r1;
        }

        public void setSuffix(String r1) {
            this.mSuffix = r1;
        }
    }

    public static class NicknameData implements EntryElement {
        private final String mNickname;

        public NicknameData(String r1) {
            this.mNickname = r1;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/nickname");
            r0.withValue(DBHelper.COL_DATA2, 1);
            r0.withValue("data1", this.mNickname);
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mNickname);
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof NicknameData) == true) goto L7;
            return false;
        L7:
            return TextUtils.equals(this.mNickname, ((NicknameData) r2).mNickname);
        }

        public int hashCode() {
            String r0 = this.mNickname;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "nickname: " + this.mNickname;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.NICKNAME;
        }

        public String getNickname() {
            return this.mNickname;
        }
    }

    public static class NoteData implements EntryElement {
        public final String mNote;

        public NoteData(String r1) {
            this.mNote = r1;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/note");
            r0.withValue("data1", this.mNote);
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mNote);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof NoteData) == true) goto L10;
            return false;
        L10:
            return TextUtils.equals(this.mNote, ((NoteData) r2).mNote);
        }

        public int hashCode() {
            String r0 = this.mNote;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "note: " + this.mNote;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.NOTE;
        }

        public String getNote() {
            return this.mNote;
        }
    }

    public static class OrganizationData implements EntryElement {
        private String mDepartmentName;
        private boolean mIsPrimary;
        private String mOrganizationName;
        private final String mPhoneticName;
        private String mTitle;
        private final int mType;

        static /* synthetic */ String access$100(OrganizationData r0) {
            return r0.mOrganizationName;
        }

        static /* synthetic */ String access$102(OrganizationData r0, String r1) {
            r0.mOrganizationName = r1;
            return r1;
        }

        static /* synthetic */ String access$200(OrganizationData r0) {
            return r0.mDepartmentName;
        }

        static /* synthetic */ String access$202(OrganizationData r0, String r1) {
            r0.mDepartmentName = r1;
            return r1;
        }

        static /* synthetic */ boolean access$302(OrganizationData r0, boolean r1) {
            r0.mIsPrimary = r1;
            return r1;
        }

        static /* synthetic */ String access$400(OrganizationData r0) {
            return r0.mTitle;
        }

        static /* synthetic */ String access$402(OrganizationData r0, String r1) {
            r0.mTitle = r1;
            return r1;
        }

        public OrganizationData(String r1, String r2, String r3, String r4, int r5, boolean r6) {
            this.mType = r5;
            this.mOrganizationName = r1;
            this.mDepartmentName = r2;
            this.mTitle = r3;
            this.mPhoneticName = r4;
            this.mIsPrimary = r6;
        }

        public String getFormattedString() {
            StringBuilder r0 = new StringBuilder();
            if (TextUtils.isEmpty(this.mOrganizationName) == true) goto L6;
            r0.append(this.mOrganizationName);
        L6:
            if (TextUtils.isEmpty(this.mDepartmentName) == true) goto L12;
            if (r0.length() <= 0) goto L10;
            r0.append(", ");
        L10:
            r0.append(this.mDepartmentName);
        L12:
            if (TextUtils.isEmpty(this.mTitle) == true) goto L18;
            if (r0.length() <= 0) goto L16;
            r0.append(", ");
        L16:
            r0.append(this.mTitle);
        L18:
            return r0.toString();
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/organization");
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            String r5 = this.mOrganizationName;
            if (r5 == null) goto L5;
            r0.withValue("data1", r5);
        L5:
            String r6 = this.mDepartmentName;
            if (r6 == null) goto L8;
            r0.withValue("data5", r6);
        L8:
            String r7 = this.mTitle;
            if (r7 == null) goto L11;
            r0.withValue("data4", r7);
        L11:
            String r8 = this.mPhoneticName;
            if (r8 == null) goto L15;
            r0.withValue("data8", r8);
        L15:
            if (this.mIsPrimary == false) goto L17;
            r0.withValue("is_primary", 1);
        L17:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.mOrganizationName) == true) goto L5;
        L11:
            return false;
        L5:
            if (TextUtils.isEmpty(this.mDepartmentName) == false) goto L11;
            if (TextUtils.isEmpty(this.mTitle) == false) goto L11;
            if (TextUtils.isEmpty(this.mPhoneticName) == false) goto L11;
            return true;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OrganizationData) == true) goto L8;
            return false;
        L8:
            OrganizationData r6 = (OrganizationData) r5;
            if (this.mType != r6.mType) goto L20;
            if (TextUtils.equals(this.mOrganizationName, r6.mOrganizationName) == false) goto L20;
            if (TextUtils.equals(this.mDepartmentName, r6.mDepartmentName) == false) goto L20;
            if (TextUtils.equals(this.mTitle, r6.mTitle) == false) goto L20;
            if (this.mIsPrimary != r6.mIsPrimary) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            int r0 = this.mType * 31;
            String r1 = this.mOrganizationName;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.mDepartmentName;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.mTitle;
            if (r8 == null) goto L13;
            r2 = r8.hashCode();
        L13:
            int r9 = (r7 + r2) * 31;
            if (this.mIsPrimary == false) goto L16;
            int r10 = 1231;
        L18:
            return r9 + r10;
        L16:
            r10 = 1237;
            goto L18
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return String.format("type: %d, organization: %s, department: %s, title: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.mType), this.mOrganizationName, this.mDepartmentName, this.mTitle, Boolean.valueOf(this.mIsPrimary)});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.ORGANIZATION;
        }

        public String getOrganizationName() {
            return this.mOrganizationName;
        }

        public String getDepartmentName() {
            return this.mDepartmentName;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getPhoneticName() {
            return this.mPhoneticName;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    public static class PhoneData implements EntryElement {
        private boolean mIsPrimary;
        private final String mLabel;
        private final String mNumber;
        private final int mType;

        static /* synthetic */ String access$1600(PhoneData r0) {
            return r0.mNumber;
        }

        public PhoneData(String r1, int r2, String r3, boolean r4) {
            this.mNumber = r1;
            this.mType = r2;
            this.mLabel = r3;
            this.mIsPrimary = r4;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            if (this.mType != 0) goto L5;
            r0.withValue(DBHelper.COL_DATA3, this.mLabel);
        L5:
            r0.withValue("data1", this.mNumber);
            if (this.mIsPrimary == false) goto L8;
            r0.withValue("is_primary", 1);
        L8:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mNumber);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PhoneData) == true) goto L8;
            return false;
        L8:
            PhoneData r6 = (PhoneData) r5;
            if (this.mType != r6.mType) goto L18;
            if (TextUtils.equals(this.mNumber, r6.mNumber) == false) goto L18;
            if (TextUtils.equals(this.mLabel, r6.mLabel) == false) goto L18;
            if (this.mIsPrimary != r6.mIsPrimary) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            int r0 = this.mType * 31;
            String r1 = this.mNumber;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.mLabel;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            if (this.mIsPrimary == false) goto L12;
            int r7 = 1231;
        L14:
            return r6 + r7;
        L12:
            r7 = 1237;
            goto L14
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", new Object[]{Integer.valueOf(this.mType), this.mNumber, this.mLabel, Boolean.valueOf(this.mIsPrimary)});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.PHONE;
        }

        public String getNumber() {
            return this.mNumber;
        }

        public int getType() {
            return this.mType;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    public static class PhotoData implements EntryElement {
        private final byte[] mBytes;
        private final String mFormat;
        private Integer mHashCode;
        private final boolean mIsPrimary;

        public PhotoData(String r2, byte[] r3, boolean r4) {
            this.mHashCode = null;
            this.mFormat = r2;
            this.mBytes = r3;
            this.mIsPrimary = r4;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/photo");
            r0.withValue(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, this.mBytes);
            if (this.mIsPrimary == false) goto L5;
            r0.withValue("is_primary", 1);
        L5:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            byte[] r0 = this.mBytes;
            if (r0 != null) goto L5;
        L8:
            return true;
        L5:
            if (r0.length == 0) goto L8;
            return false;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PhotoData) == true) goto L8;
            return false;
        L8:
            PhotoData r6 = (PhotoData) r5;
            if (TextUtils.equals(this.mFormat, r6.mFormat) == false) goto L16;
            if (Arrays.equals(this.mBytes, r6.mBytes) == false) goto L16;
            if (this.mIsPrimary != r6.mIsPrimary) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.mHashCode;
            if (r0 != null) goto L5;
            String r1 = this.mFormat;
            int r2 = 0;
            if (r1 == null) goto L9;
            int r3 = r1.hashCode();
        L10:
            int r4 = r3 * 31;
            byte[] r5 = this.mBytes;
            if (r5 == null) goto L15;
            int r6 = r5.length;
        L13:
            if (r2 >= r6) goto L15;
            r4 = r4 + r5[r2];
            r2 = r2 + 1;
        L15:
            int r7 = r4 * 31;
            if (this.mIsPrimary == false) goto L18;
            int r8 = 1231;
        L19:
            int r9 = r7 + r8;
            this.mHashCode = Integer.valueOf(r9);
            return r9;
        L18:
            r8 = 1237;
            goto L19
        L9:
            r3 = 0;
            goto L10
        L5:
            return r0.intValue();
        }

        public String toString() {
            return String.format("format: %s: size: %d, isPrimary: %s", new Object[]{this.mFormat, Integer.valueOf(this.mBytes.length), Boolean.valueOf(this.mIsPrimary)});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.PHOTO;
        }

        public String getFormat() {
            return this.mFormat;
        }

        public byte[] getBytes() {
            return this.mBytes;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    public static class PostalData implements EntryElement {
        private static final int ADDR_MAX_DATA_SIZE = 7;
        private final String mCountry;
        private final String mExtendedAddress;
        private boolean mIsPrimary;
        private final String mLabel;
        private final String mLocalty;
        private final String mPobox;
        private final String mPostalCode;
        private final String mRegion;
        private final String mStreet;
        private final int mType;
        private int mVCardType;

        public PostalData(String r1, String r2, String r3, String r4, String r5, String r6, String r7, int r8, String r9, boolean r10, int r11) {
            this.mType = r8;
            this.mPobox = r1;
            this.mExtendedAddress = r2;
            this.mStreet = r3;
            this.mLocalty = r4;
            this.mRegion = r5;
            this.mPostalCode = r6;
            this.mCountry = r7;
            this.mLabel = r9;
            this.mIsPrimary = r10;
            this.mVCardType = r11;
        }

        public static PostalData constructPostalData(List<String> r18, int r19, String r20, boolean r21, int r22) {
            String[] r1 = new String[7];
            int r2 = r18.size();
            if (r2 <= 7) goto L5;
            r2 = 7;
        L5:
            Iterator<String> r3 = r18.iterator();
            int r5 = 0;
        L7:
            if (r3.hasNext() == false) goto L10;
            r1[r5] = r3.next();
            r5 = r5 + 1;
            if (r5 < r2) goto L7;
        L10:
            if (r5 >= 7) goto L13;
            r1[r5] = null;
            r5 = r5 + 1;
            goto L10
        L13:
            return new PostalData(r1[0], r1[1], r1[2], r1[3], r1[4], r1[5], r1[6], r19, r20, r21, r22);
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r4, int r5) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r5);
            r0.withValue("mimetype", "vnd.android.cursor.item/postal-address_v2");
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            if (this.mType != 0) goto L6;
            r0.withValue(DBHelper.COL_DATA3, this.mLabel);
        L6:
            if (TextUtils.isEmpty(this.mStreet) == false) goto L12;
            if (TextUtils.isEmpty(this.mExtendedAddress) == false) goto L10;
            String r6 = null;
        L15:
            r0.withValue("data5", this.mPobox);
            r0.withValue("data4", r6);
            r0.withValue("data7", this.mLocalty);
            r0.withValue("data8", this.mRegion);
            r0.withValue("data9", this.mPostalCode);
            r0.withValue("data10", this.mCountry);
            r0.withValue("data1", getFormattedAddress(this.mVCardType));
            if (this.mIsPrimary == false) goto L18;
            r0.withValue("is_primary", 1);
        L18:
            r4.add(r0.build());
            return;
        L10:
            r6 = this.mExtendedAddress;
            goto L15
        L12:
            if (TextUtils.isEmpty(this.mExtendedAddress) == false) goto L14;
            r6 = this.mStreet;
            goto L15
        L14:
            r6 = this.mStreet + HanziToPinyin.Token.SEPARATOR + this.mExtendedAddress;
            goto L15
        }

        public String getFormattedAddress(int r8) {
            StringBuilder r0 = new StringBuilder();
            boolean r5 = true;
            int r3 = 6;
            String[] r2 = {this.mPobox, this.mExtendedAddress, this.mStreet, this.mLocalty, this.mRegion, this.mPostalCode, this.mCountry};
            if (VCardConfig.isJapaneseDevice(r8) == false) goto L12;
        L4:
            if (r3 < 0) goto L22;
            String r7 = r2[r3];
            if (TextUtils.isEmpty(r7) == true) goto L11;
            if (r5 == true) goto L9;
            r0.append(' ');
        L10:
            r0.append(r7);
            goto L11
        L9:
            r5 = false;
        L11:
            r3 = r3 - 1;
        L22:
            return r0.toString().trim();
        L12:
            int r9 = 0;
        L13:
            if (r9 >= 7) goto L22;
            String r4 = r2[r9];
            if (TextUtils.isEmpty(r4) == true) goto L20;
            if (r5 == true) goto L18;
            r0.append(' ');
        L19:
            r0.append(r4);
            goto L20
        L18:
            r5 = false;
        L20:
            r9 = r9 + 1;
            goto L13
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.mPobox) == true) goto L5;
        L17:
            return false;
        L5:
            if (TextUtils.isEmpty(this.mExtendedAddress) == false) goto L17;
            if (TextUtils.isEmpty(this.mStreet) == false) goto L17;
            if (TextUtils.isEmpty(this.mLocalty) == false) goto L17;
            if (TextUtils.isEmpty(this.mRegion) == false) goto L17;
            if (TextUtils.isEmpty(this.mPostalCode) == false) goto L17;
            if (TextUtils.isEmpty(this.mCountry) == false) goto L17;
            return true;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PostalData) == true) goto L8;
            return false;
        L8:
            PostalData r6 = (PostalData) r5;
            int r1 = this.mType;
            if (r1 != r6.mType) goto L31;
            if (r1 != 0) goto L14;
            if (TextUtils.equals(this.mLabel, r6.mLabel) == false) goto L31;
        L14:
            if (this.mIsPrimary != r6.mIsPrimary) goto L31;
            if (TextUtils.equals(this.mPobox, r6.mPobox) == false) goto L31;
            if (TextUtils.equals(this.mExtendedAddress, r6.mExtendedAddress) == false) goto L31;
            if (TextUtils.equals(this.mStreet, r6.mStreet) == false) goto L31;
            if (TextUtils.equals(this.mLocalty, r6.mLocalty) == false) goto L31;
            if (TextUtils.equals(this.mRegion, r6.mRegion) == false) goto L31;
            if (TextUtils.equals(this.mPostalCode, r6.mPostalCode) == false) goto L31;
            if (TextUtils.equals(this.mCountry, r6.mCountry) == false) goto L31;
            return true;
        L31:
            return false;
        }

        public int hashCode() {
            int r0 = this.mType * 31;
            String r1 = this.mLabel;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.mIsPrimary == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = r3 + r4;
            String[] r6 = {this.mPobox, this.mExtendedAddress, this.mStreet, this.mLocalty, this.mRegion, this.mPostalCode, this.mCountry};
            int r7 = 0;
        L11:
            if (r7 >= 7) goto L17;
            String r8 = r6[r7];
            int r9 = r5 * 31;
            if (r8 == null) goto L15;
            int r10 = r8.hashCode();
        L16:
            r5 = r9 + r10;
            r7 = r7 + 1;
            goto L11
        L15:
            r10 = 0;
            goto L16
        L17:
            return r5;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return String.format("type: %d, label: %s, isPrimary: %s, pobox: %s, extendedAddress: %s, street: %s, localty: %s, region: %s, postalCode %s, country: %s", new Object[]{Integer.valueOf(this.mType), this.mLabel, Boolean.valueOf(this.mIsPrimary), this.mPobox, this.mExtendedAddress, this.mStreet, this.mLocalty, this.mRegion, this.mPostalCode, this.mCountry});
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public final EntryLabel getEntryLabel() {
            return EntryLabel.POSTAL_ADDRESS;
        }

        public String getPobox() {
            return this.mPobox;
        }

        public String getExtendedAddress() {
            return this.mExtendedAddress;
        }

        public String getStreet() {
            return this.mStreet;
        }

        public String getLocalty() {
            return this.mLocalty;
        }

        public String getRegion() {
            return this.mRegion;
        }

        public String getPostalCode() {
            return this.mPostalCode;
        }

        public String getCountry() {
            return this.mCountry;
        }

        public int getType() {
            return this.mType;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public boolean isPrimary() {
            return this.mIsPrimary;
        }
    }

    public static class SipData implements EntryElement {
        private final String mAddress;
        private final boolean mIsPrimary;
        private final String mLabel;
        private final int mType;

        public SipData(String r2, int r3, String r4, boolean r5) {
            if (r2.startsWith("sip:") == false) goto L5;
            this.mAddress = r2.substring(4);
        L6:
            this.mType = r3;
            this.mLabel = r4;
            this.mIsPrimary = r5;
            return;
        L5:
            this.mAddress = r2;
            goto L6
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/sip_address");
            r0.withValue("data1", this.mAddress);
            r0.withValue(DBHelper.COL_DATA2, Integer.valueOf(this.mType));
            if (this.mType != 0) goto L5;
            r0.withValue(DBHelper.COL_DATA3, this.mLabel);
        L5:
            boolean r2 = this.mIsPrimary;
            if (r2 == false) goto L8;
            r0.withValue("is_primary", Boolean.valueOf(r2));
        L8:
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mAddress);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SipData) == true) goto L8;
            return false;
        L8:
            SipData r6 = (SipData) r5;
            if (this.mType != r6.mType) goto L18;
            if (TextUtils.equals(this.mLabel, r6.mLabel) == false) goto L18;
            if (TextUtils.equals(this.mAddress, r6.mAddress) == false) goto L18;
            if (this.mIsPrimary != r6.mIsPrimary) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            int r0 = this.mType * 31;
            String r1 = this.mLabel;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.mAddress;
            if (r5 == null) goto L9;
            r2 = r5.hashCode();
        L9:
            int r6 = (r4 + r2) * 31;
            if (this.mIsPrimary == false) goto L12;
            int r7 = 1231;
        L14:
            return r6 + r7;
        L12:
            r7 = 1237;
            goto L14
        L5:
            r3 = 0;
            goto L6
        }

        public String toString() {
            return "sip: " + this.mAddress;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.SIP;
        }

        public String getAddress() {
            return this.mAddress;
        }

        public int getType() {
            return this.mType;
        }

        public String getLabel() {
            return this.mLabel;
        }
    }

    private class ToStringIterator implements EntryElementIterator {
        private StringBuilder mBuilder;
        private boolean mFirstElement;
        final /* synthetic */ VCardEntry this$0;

        private ToStringIterator(VCardEntry r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ToStringIterator(VCardEntry r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationStarted() {
            StringBuilder r0 = new StringBuilder();
            this.mBuilder = r0;
            r0.append("[[hash: " + this.this$0.hashCode() + "\n");
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupStarted(EntryLabel r3) {
            this.mBuilder.append(r3.toString() + ": ");
            this.mFirstElement = true;
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public boolean onElement(EntryElement r3) {
            if (this.mFirstElement == true) goto L5;
            this.mBuilder.append(", ");
            this.mFirstElement = false;
        L5:
            this.mBuilder.append("[").append(r3.toString()).append("]");
            return true;
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onElementGroupEnded() {
            this.mBuilder.append("\n");
        }

        @Override // com.android.vcard.VCardEntry.EntryElementIterator
        public void onIterationEnded() {
            this.mBuilder.append("]]\n");
        }

        public String toString() {
            return this.mBuilder.toString();
        }
    }

    public static class WebsiteData implements EntryElement {
        private final String mWebsite;

        public WebsiteData(String r1) {
            this.mWebsite = r1;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public void constructInsertOperation(List<ContentProviderOperation> r3, int r4) {
            ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            r0.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r4);
            r0.withValue("mimetype", "vnd.android.cursor.item/website");
            r0.withValue("data1", this.mWebsite);
            r0.withValue(DBHelper.COL_DATA2, 1);
            r3.add(r0.build());
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.mWebsite);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof WebsiteData) == true) goto L10;
            return false;
        L10:
            return TextUtils.equals(this.mWebsite, ((WebsiteData) r2).mWebsite);
        }

        public int hashCode() {
            String r0 = this.mWebsite;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "website: " + this.mWebsite;
        }

        @Override // com.android.vcard.VCardEntry.EntryElement
        public EntryLabel getEntryLabel() {
            return EntryLabel.WEBSITE;
        }

        public String getWebsite() {
            return this.mWebsite;
        }
    }

    public static VCardEntry buildFromResolver(ContentResolver r0, Uri r1) {
        return null;
    }

    static {
        HashMap r0 = new HashMap();
        sImMap = r0;
        r0.put(VCardConstants.PROPERTY_X_AIM, 0);
        r0.put(VCardConstants.PROPERTY_X_MSN, 1);
        r0.put(VCardConstants.PROPERTY_X_YAHOO, 2);
        r0.put(VCardConstants.PROPERTY_X_QQ, 4);
        r0.put(VCardConstants.PROPERTY_X_ICQ, 6);
        r0.put(VCardConstants.PROPERTY_X_JABBER, 7);
        r0.put(VCardConstants.PROPERTY_X_SKYPE_USERNAME, 3);
        r0.put(VCardConstants.PROPERTY_X_GOOGLE_TALK, 5);
        r0.put(VCardConstants.ImportOnly.PROPERTY_X_GOOGLE_TALK_WITH_SPACE, 5);
        sEmptyList = Collections.unmodifiableList(new ArrayList(0));
    }

    public final void iterateAllData(EntryElementIterator r2) {
        r2.onIterationStarted();
        r2.onElementGroupStarted(this.mNameData.getEntryLabel());
        r2.onElement(this.mNameData);
        r2.onElementGroupEnded();
        iterateOneList(this.mPhoneList, r2);
        iterateOneList(this.mEmailList, r2);
        iterateOneList(this.mPostalList, r2);
        iterateOneList(this.mOrganizationList, r2);
        iterateOneList(this.mImList, r2);
        iterateOneList(this.mPhotoList, r2);
        iterateOneList(this.mWebsiteList, r2);
        iterateOneList(this.mSipList, r2);
        iterateOneList(this.mNicknameList, r2);
        iterateOneList(this.mNoteList, r2);
        iterateOneList(this.mAndroidCustomDataList, r2);
        BirthdayData r0 = this.mBirthday;
        if (r0 == null) goto L5;
        r2.onElementGroupStarted(r0.getEntryLabel());
        r2.onElement(this.mBirthday);
        r2.onElementGroupEnded();
    L5:
        AnniversaryData r1 = this.mAnniversary;
        if (r1 == null) goto L8;
        r2.onElementGroupStarted(r1.getEntryLabel());
        r2.onElement(this.mAnniversary);
        r2.onElementGroupEnded();
    L8:
        r2.onIterationEnded();
    }

    private void iterateOneList(List<? extends EntryElement> r1, EntryElementIterator r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L13;
        r2.onElementGroupStarted(r1.get(0).getEntryLabel());
        Iterator<? extends EntryElement> r0 = r1.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r2.onElement(r0.next());
        goto L7
    L9:
        r2.onElementGroupEnded();
        return;
    }

    public String toString() {
        ToStringIterator r0 = new ToStringIterator(this, null);
        iterateAllData(r0);
        return r0.toString();
    }

    public VCardEntry() {
        this(VCardConfig.VCARD_TYPE_V21_GENERIC);
    }

    public VCardEntry(int r2) {
        this(r2, null);
    }

    public VCardEntry(int r2, Account r3) {
        this.mNameData = new NameData();
        this.mVCardType = r2;
        this.mAccount = r3;
    }

    private void addPhone(int r8, String r9, String r10, boolean r11) {
        if (this.mPhoneList != null) goto L5;
        this.mPhoneList = new ArrayList();
    L5:
        StringBuilder r0 = new StringBuilder();
        String r12 = r9.trim();
        if (r8 != 6) goto L8;
    L35:
        this.mPhoneList.add(new PhoneData(r12, r8, r10, r11));
        return;
    L8:
        if (VCardConfig.refrainPhoneNumberFormatting(this.mVCardType) == true) goto L35;
        int r1 = r12.length();
        int r2 = 0;
        boolean r3 = false;
    L11:
        if (r2 >= r1) goto L32;
        char r4 = r12.charAt(r2);
        if (r4 != 'p') goto L15;
    L29:
        r0.append(',');
    L30:
        r3 = true;
    L31:
        r2 = r2 + 1;
        goto L11
    L15:
        if (r4 == 'P') goto L29;
        if (r4 != 'w') goto L20;
    L28:
        r0.append(';');
        goto L30
    L20:
        if (r4 == 'W') goto L28;
        if (PhoneNumberUtils.is12Key(r4) == true) goto L27;
        if (r2 != 0) goto L31;
        if (r4 != '+') goto L31;
    L27:
        r0.append(r4);
        goto L31
    L32:
        if (r3 == true) goto L34;
        r12 = VCardUtils.PhoneNumberUtilsPort.formatNumber(r0.toString(), VCardUtils.getPhoneNumberFormat(this.mVCardType));
        goto L35
    L34:
        r12 = r0.toString();
        goto L35
    }

    private void addSip(String r2, int r3, String r4, boolean r5) {
        if (this.mSipList != null) goto L5;
        this.mSipList = new ArrayList();
    L5:
        this.mSipList.add(new SipData(r2, r3, r4, r5));
    }

    private void addNickName(String r2) {
        if (this.mNicknameList != null) goto L5;
        this.mNicknameList = new ArrayList();
    L5:
        this.mNicknameList.add(new NicknameData(r2));
    }

    private void addEmail(int r2, String r3, String r4, boolean r5) {
        if (this.mEmailList != null) goto L5;
        this.mEmailList = new ArrayList();
    L5:
        this.mEmailList.add(new EmailData(r3, r2, r4, r5));
    }

    private void addPostal(int r3, List<String> r4, String r5, boolean r6) {
        if (this.mPostalList != null) goto L5;
        this.mPostalList = new ArrayList(0);
    L5:
        this.mPostalList.add(PostalData.constructPostalData(r4, r3, r5, r6, this.mVCardType));
    }

    private void addNewOrganization(String r9, String r10, String r11, String r12, int r13, boolean r14) {
        if (this.mOrganizationList != null) goto L5;
        this.mOrganizationList = new ArrayList();
    L5:
        this.mOrganizationList.add(new OrganizationData(r9, r10, r11, r12, r13, r14));
    }

    private String buildSinglePhoneticNameFromSortAsParam(Map<String, Collection<String>> r3) {
        Collection<String> r4 = r3.get(VCardConstants.PARAM_SORT_AS);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.size() != 0) goto L7;
        return null;
    L7:
        if (r4.size() <= 1) goto L9;
        Log.w(LOG_TAG, "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(r4.toArray()));
    L9:
        List<String> r2 = VCardUtils.constructListFromValue(r4.iterator().next(), this.mVCardType);
        StringBuilder r5 = new StringBuilder();
        Iterator<String> r6 = r2.iterator();
    L11:
        if (r6.hasNext() == false) goto L14;
        r5.append(r6.next());
        goto L11
    L14:
        return r5.toString();
    }

    private void handleOrgValue(int r8, List<String> r9, Map<String, Collection<String>> r10, boolean r11) {
        String r4 = buildSinglePhoneticNameFromSortAsParam(r10);
        if (r9 != null) goto L5;
        r9 = sEmptyList;
    L5:
        int r12 = r9.size();
        if (r12 != 0) goto L8;
        String r13 = "";
    L17:
        String r1 = r13;
        String r2 = null;
    L18:
        List<OrganizationData> r14 = this.mOrganizationList;
        if (r14 != null) goto L22;
        addNewOrganization(r1, r2, null, r4, r8, r11);
        return;
    L22:
        Iterator<OrganizationData> r15 = r14.iterator();
    L24:
        if (r15.hasNext() == false) goto L31;
        OrganizationData r16 = r15.next();
        if (OrganizationData.access$100(r16) != null) goto L24;
        if (OrganizationData.access$200(r16) != null) goto L24;
        OrganizationData.access$102(r16, r1);
        OrganizationData.access$202(r16, r2);
        OrganizationData.access$302(r16, r11);
        return;
    L31:
        addNewOrganization(r1, r2, null, r4, r8, r11);
        return;
    L8:
        if (r12 == 1) goto L15;
        String r0 = r9.get(0);
        StringBuilder r3 = new StringBuilder();
        int r5 = 1;
    L10:
        if (r5 >= r12) goto L14;
        if (r5 <= 1) goto L13;
        r3.append(' ');
    L13:
        r3.append(r9.get(r5));
        r5 = r5 + 1;
        goto L10
    L14:
        r2 = r3.toString();
        r1 = r0;
        goto L18
    L15:
        r13 = r9.get(0);
        goto L17
    }

    private void handleTitleValue(String r11) {
        List<OrganizationData> r0 = this.mOrganizationList;
        if (r0 != null) goto L6;
        addNewOrganization(null, null, r11, null, 1, false);
        return;
    L6:
        Iterator<OrganizationData> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        OrganizationData r2 = r1.next();
        if (OrganizationData.access$400(r2) != null) goto L8;
        OrganizationData.access$402(r2, r11);
        return;
    L13:
        addNewOrganization(null, null, r11, null, 1, false);
    }

    private void addIm(int r8, String r9, String r10, int r11, boolean r12) {
        if (this.mImList != null) goto L5;
        this.mImList = new ArrayList();
    L5:
        this.mImList.add(new ImData(r8, r9, r10, r11, r12));
    }

    private void addNote(String r3) {
        if (this.mNoteList != null) goto L5;
        this.mNoteList = new ArrayList(1);
    L5:
        this.mNoteList.add(new NoteData(r3));
    }

    private void addPhotoBytes(String r3, byte[] r4, boolean r5) {
        if (this.mPhotoList != null) goto L5;
        this.mPhotoList = new ArrayList(1);
    L5:
        PhotoData r0 = new PhotoData(r3, r4, r5);
        this.mPhotoList.add(r0);
    }

    private void tryHandleSortAsName(Map<String, Collection<String>> r5) {
        if (VCardConfig.isVersion30(this.mVCardType) == true) goto L5;
    L11:
        Collection<String> r6 = r5.get(VCardConstants.PARAM_SORT_AS);
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.size() != 0) goto L16;
        return;
    L16:
        if (r6.size() <= 1) goto L18;
        Log.w(LOG_TAG, "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(r6.toArray()));
    L18:
        List<String> r7 = VCardUtils.constructListFromValue(r6.iterator().next(), this.mVCardType);
        int r0 = r7.size();
        if (r0 <= 3) goto L22;
        r0 = 3;
    L22:
        if (r0 == 2) goto L26;
        if (r0 != 3) goto L27;
        NameData.access$602(this.mNameData, r7.get(2));
    L27:
        NameData.access$502(this.mNameData, r7.get(0));
        return;
    L26:
        NameData.access$702(this.mNameData, r7.get(1));
        goto L27
    L5:
        if (TextUtils.isEmpty(NameData.access$500(this.mNameData)) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(NameData.access$600(this.mNameData)) == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(NameData.access$700(this.mNameData)) == true) goto L11;
    }

    private void handleNProperty(List<String> r6, Map<String, Collection<String>> r7) {
        tryHandleSortAsName(r7);
        if (r6 == null) goto L24;
        int r8 = r6.size();
        if (r8 >= 1) goto L8;
        return;
    L8:
        if (r8 <= 5) goto L11;
        r8 = 5;
    L11:
        if (r8 != 2) goto L13;
    L21:
        NameData.access$1102(this.mNameData, r6.get(1));
    L22:
        NameData.access$1202(this.mNameData, r6.get(0));
        return;
    L13:
        if (r8 != 3) goto L15;
    L20:
        NameData.access$1002(this.mNameData, r6.get(2));
        goto L21
    L15:
        if (r8 == 4) goto L19;
        if (r8 != 5) goto L22;
        NameData.access$802(this.mNameData, r6.get(4));
    L19:
        NameData.access$902(this.mNameData, r6.get(3));
        goto L20
    }

    private void handlePhoneticNameFromSound(List<String> r8) {
        if (TextUtils.isEmpty(NameData.access$500(this.mNameData)) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(NameData.access$600(this.mNameData)) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(NameData.access$700(this.mNameData)) == false) goto L47;
        if (r8 == null) goto L46;
        int r0 = r8.size();
        if (r0 >= 1) goto L14;
        return;
    L14:
        if (r0 <= 3) goto L17;
        r0 = 3;
    L17:
        if (r8.get(0).length() <= 0) goto L33;
        int r4 = 1;
    L19:
        if (r4 >= r0) goto L24;
        if (r8.get(r4).length() > 0) goto L22;
        r4 = r4 + 1;
        goto L19
    L22:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L33;
        String[] r1 = r8.get(0).split(HanziToPinyin.Token.SEPARATOR);
        int r6 = r1.length;
        if (r6 != 3) goto L29;
        NameData.access$502(this.mNameData, r1[0]);
        NameData.access$602(this.mNameData, r1[1]);
        NameData.access$702(this.mNameData, r1[2]);
        return;
    L29:
        if (r6 != 2) goto L31;
        NameData.access$502(this.mNameData, r1[0]);
        NameData.access$702(this.mNameData, r1[1]);
        return;
    L31:
        NameData.access$702(this.mNameData, r8.get(0));
        return;
    L24:
        r5 = true;
    L33:
        if (r0 == 2) goto L37;
        if (r0 != 3) goto L38;
        NameData.access$602(this.mNameData, r8.get(2));
    L38:
        NameData.access$502(this.mNameData, r8.get(0));
        return;
    L37:
        NameData.access$702(this.mNameData, r8.get(1));
        goto L38
    L46:
        return;
    }

    public void addProperty(VCardProperty r18) {
        String r1 = r18.getName();
        Map<String, Collection<String>> r2 = r18.getParameterMap();
        List<String> r3 = r18.getValueList();
        byte[] r4 = r18.getByteValue();
        if (r3 != null) goto L5;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        String r5 = null;
        if (r3 == null) goto L11;
        String r6 = listToString(r3).trim();
    L13:
        if (r1.equals(VCardConstants.PROPERTY_VERSION) == false) goto L16;
        return;
    L16:
        if (r1.equals(VCardConstants.PROPERTY_FN) == false) goto L19;
        NameData.access$1302(this.mNameData, r6);
        return;
    L19:
        if (r1.equals(VCardConstants.PROPERTY_NAME) == false) goto L24;
        if (TextUtils.isEmpty(NameData.access$1300(this.mNameData)) == false) goto L330;
        NameData.access$1302(this.mNameData, r6);
        return;
    L330:
        return;
    L24:
        if (r1.equals("N") == false) goto L27;
        handleNProperty(r3, r2);
        return;
    L27:
        if (r1.equals(VCardConstants.PROPERTY_SORT_STRING) == false) goto L30;
        NameData.access$1402(this.mNameData, r6);
        return;
    L30:
        if (r1.equals(VCardConstants.PROPERTY_NICKNAME) == false) goto L32;
    L260:
        addNickName(r6);
        return;
    L32:
        if (r1.equals(VCardConstants.ImportOnly.PROPERTY_X_NICKNAME) == true) goto L260;
        if (r1.equals(VCardConstants.PROPERTY_SOUND) == false) goto L41;
        Collection<String> r7 = r2.get(VCardConstants.PARAM_TYPE);
        if (r7 != null) goto L39;
        return;
    L39:
        if (r7.contains("X-IRMC-N") == false) goto L335;
        handlePhoneticNameFromSound(VCardUtils.constructListFromValue(r6, this.mVCardType));
        return;
    L335:
        return;
    L41:
        int r12 = 1;
        if (r1.equals(VCardConstants.PROPERTY_ADR) == false) goto L89;
        Iterator<String> r8 = r3.iterator();
    L45:
        if (r8.hasNext() == false) goto L49;
        if (TextUtils.isEmpty(r8.next()) == true) goto L45;
        boolean r9 = false;
    L50:
        if (r9 == false) goto L52;
        return;
    L52:
        Collection<String> r10 = r2.get(VCardConstants.PARAM_TYPE);
        if (r10 == null) goto L83;
        Iterator<String> r11 = r10.iterator();
        String r13 = null;
        int r14 = -1;
        boolean r15 = false;
    L56:
        if (r11.hasNext() == false) goto L82;
        String r16 = r11.next();
        String r17 = r16.toUpperCase();
        if (r17.equals(VCardConstants.PARAM_TYPE_PREF) == true) goto L59;
        if (r17.equals("HOME") == true) goto L62;
        if (r17.equals("WORK") == true) goto L81;
        if (r17.equalsIgnoreCase(VCardConstants.PARAM_EXTRA_TYPE_COMPANY) == true) goto L81;
        if (r17.equals(VCardConstants.PARAM_ADR_TYPE_PARCEL) == true) goto L56;
        if (r17.equals(VCardConstants.PARAM_ADR_TYPE_DOM) == true) goto L56;
        if (r17.equals(VCardConstants.PARAM_ADR_TYPE_INTL) == true) goto L56;
        if (r14 >= 0) goto L56;
        if (r17.startsWith("X-") == false) goto L79;
        r13 = r16.substring(2);
    L80:
        r14 = 0;
        goto L56
    L79:
        r13 = r16;
    L81:
        r13 = null;
        r14 = 2;
        goto L56
    L62:
        r13 = null;
        r14 = 1;
        goto L56
    L59:
        r15 = true;
        goto L56
    L82:
        r5 = r13;
        boolean r19 = r15;
    L84:
        if (r14 < 0) goto L87;
        r12 = r14;
    L87:
        addPostal(r12, r3, r5, r19);
        return;
    L83:
        r14 = -1;
        r19 = false;
        goto L84
    L49:
        r9 = true;
        goto L50
    L89:
        if (r1.equals(VCardConstants.PROPERTY_EMAIL) == false) goto L119;
        Collection<String> r20 = r2.get(VCardConstants.PARAM_TYPE);
        if (r20 == null) goto L114;
        Iterator<String> r21 = r20.iterator();
        int r22 = -1;
        boolean r23 = false;
    L94:
        if (r21.hasNext() == false) goto L113;
        String r24 = r21.next();
        String r25 = r24.toUpperCase();
        if (r25.equals(VCardConstants.PARAM_TYPE_PREF) == true) goto L97;
        if (r25.equals("HOME") == true) goto L100;
        if (r25.equals("WORK") == true) goto L103;
        if (r25.equals(VCardConstants.PARAM_TYPE_CELL) == true) goto L106;
        if (r22 >= 0) goto L94;
        if (r25.startsWith("X-") == false) goto L111;
        r5 = r24.substring(2);
    L112:
        r22 = 0;
        goto L94
    L111:
        r5 = r24;
        goto L112
    L106:
        r22 = 4;
        goto L94
    L103:
        r22 = 2;
        goto L94
    L100:
        r22 = 1;
        goto L94
    L97:
        r23 = true;
        goto L94
    L113:
        int r110 = r22;
        boolean r111 = r23;
    L115:
        if (r110 >= 0) goto L117;
        r110 = 3;
    L117:
        addEmail(r110, r6, r5, r111);
        return;
    L114:
        r110 = -1;
        r111 = false;
        goto L115
    L119:
        if (r1.equals(VCardConstants.PROPERTY_ORG) == false) goto L131;
        Collection<String> r26 = r2.get(VCardConstants.PARAM_TYPE);
        if (r26 == null) goto L128;
        Iterator<String> r27 = r26.iterator();
        boolean r112 = false;
    L124:
        if (r27.hasNext() == false) goto L129;
        if (r27.next().equals(VCardConstants.PARAM_TYPE_PREF) == false) goto L124;
        r112 = true;
    L129:
        handleOrgValue(1, r3, r2, r112);
        return;
    L128:
        r112 = false;
        goto L129
    L131:
        if (r1.equals(VCardConstants.PROPERTY_TITLE) == false) goto L134;
        handleTitleValue(r6);
        return;
    L134:
        if (r1.equals(VCardConstants.PROPERTY_ROLE) == false) goto L137;
        return;
    L137:
        if (r1.equals(VCardConstants.PROPERTY_PHOTO) == false) goto L139;
    L243:
        Collection<String> r28 = r2.get(VCardConstants.PARAM_VALUE);
        if (r28 != null) goto L246;
    L248:
        Collection<String> r29 = r2.get(VCardConstants.PARAM_TYPE);
        if (r29 == null) goto L258;
        Iterator<String> r30 = r29.iterator();
        boolean r113 = false;
    L252:
        if (r30.hasNext() == false) goto L259;
        String r31 = r30.next();
        if (VCardConstants.PARAM_TYPE_PREF.equals(r31) == true) goto L255;
        if (r5 != null) goto L252;
        r5 = r31;
        goto L252
    L255:
        r113 = true;
    L259:
        addPhotoBytes(r5, r4, r113);
        return;
    L258:
        r113 = false;
        goto L259
    L246:
        if (r28.contains(VCardConstants.PROPERTY_URL) == false) goto L248;
        return;
    L139:
        if (r1.equals(VCardConstants.PROPERTY_LOGO) == true) goto L243;
        if (r1.equals(VCardConstants.PROPERTY_TEL) == false) goto L169;
        if (VCardConfig.isVersion40(this.mVCardType) == true) goto L146;
    L151:
        String r32 = r6;
    L152:
        boolean r33 = false;
    L153:
        if (r33 == false) goto L156;
        handleSipCase(r6, r2.get(VCardConstants.PARAM_TYPE));
        return;
    L156:
        if (r6.length() != 0) goto L158;
        return;
    L158:
        Collection<String> r34 = r2.get(VCardConstants.PARAM_TYPE);
        Object r35 = VCardUtils.getPhoneTypeFromStrings(r34, r32);
        if ((r35 instanceof Integer) == false) goto L161;
        int r36 = ((Integer) r35).intValue();
    L162:
        if (r34 != null) goto L164;
    L166:
        boolean r114 = false;
    L167:
        addPhone(r36, r32, r5, r114);
        return;
    L164:
        if (r34.contains(VCardConstants.PARAM_TYPE_PREF) == false) goto L166;
        r114 = true;
        goto L167
    L161:
        r5 = r35.toString();
        r36 = 0;
        goto L162
    L146:
        if (r6.startsWith("sip:") == false) goto L149;
        r32 = null;
        r33 = true;
        goto L153
    L149:
        if (r6.startsWith("tel:") == false) goto L151;
        r32 = r6.substring(4);
        goto L152
    L169:
        if (r1.equals(VCardConstants.PROPERTY_X_SKYPE_PSTNNUMBER) == false) goto L177;
        Collection<String> r37 = r2.get(VCardConstants.PARAM_TYPE);
        if (r37 != null) goto L173;
    L175:
        boolean r115 = false;
    L176:
        addPhone(7, r6, null, r115);
        return;
    L173:
        if (r37.contains(VCardConstants.PARAM_TYPE_PREF) == false) goto L175;
        r115 = true;
        goto L176
    L177:
        Map<String, Integer> r38 = sImMap;
        if (r38.containsKey(r1) == false) goto L201;
        int r39 = r38.get(r1).intValue();
        Collection<String> r40 = r2.get(VCardConstants.PARAM_TYPE);
        if (r40 == null) goto L195;
        Iterator<String> r41 = r40.iterator();
        int r42 = -1;
        boolean r116 = false;
    L183:
        if (r41.hasNext() == false) goto L194;
        String r43 = r41.next();
        if (r43.equals(VCardConstants.PARAM_TYPE_PREF) == true) goto L186;
        if (r42 >= 0) goto L183;
        if (r43.equalsIgnoreCase("HOME") == true) goto L190;
        if (r43.equalsIgnoreCase("WORK") == false) goto L183;
        r42 = 2;
        goto L183
    L190:
        r42 = 1;
        goto L183
    L186:
        r116 = true;
        goto L183
    L194:
        boolean r44 = r116;
    L196:
        if (r42 >= 0) goto L198;
        int r45 = 1;
    L199:
        addIm(r39, null, r6, r45, r44);
        return;
    L198:
        r45 = r42;
        goto L199
    L195:
        r42 = -1;
        r44 = false;
        goto L196
    L201:
        if (r1.equals(VCardConstants.PROPERTY_NOTE) == false) goto L204;
        addNote(r6);
        return;
    L204:
        if (r1.equals(VCardConstants.PROPERTY_URL) == false) goto L210;
        if (this.mWebsiteList != null) goto L208;
        this.mWebsiteList = new ArrayList(1);
    L208:
        this.mWebsiteList.add(new WebsiteData(r6));
        return;
    L210:
        if (r1.equals(VCardConstants.PROPERTY_BDAY) == false) goto L213;
        this.mBirthday = new BirthdayData(r6);
        return;
    L213:
        if (r1.equals(VCardConstants.PROPERTY_ANNIVERSARY) == false) goto L216;
        this.mAnniversary = new AnniversaryData(r6);
        return;
    L216:
        if (r1.equals(VCardConstants.PROPERTY_X_PHONETIC_FIRST_NAME) == false) goto L219;
        NameData.access$702(this.mNameData, r6);
        return;
    L219:
        if (r1.equals(VCardConstants.PROPERTY_X_PHONETIC_MIDDLE_NAME) == false) goto L222;
        NameData.access$602(this.mNameData, r6);
        return;
    L222:
        if (r1.equals(VCardConstants.PROPERTY_X_PHONETIC_LAST_NAME) == false) goto L225;
        NameData.access$502(this.mNameData, r6);
        return;
    L225:
        if (r1.equals(VCardConstants.PROPERTY_IMPP) == false) goto L230;
        if (r6.startsWith("sip:") == false) goto L352;
        handleSipCase(r6, r2.get(VCardConstants.PARAM_TYPE));
        return;
    L352:
        return;
    L230:
        if (r1.equals(VCardConstants.PROPERTY_X_SIP) == false) goto L235;
        if (TextUtils.isEmpty(r6) == true) goto L354;
        handleSipCase(r6, r2.get(VCardConstants.PARAM_TYPE));
        return;
    L354:
        return;
    L235:
        if (r1.equals(VCardConstants.PROPERTY_X_ANDROID_CUSTOM) == false) goto L238;
        handleAndroidCustomProperty(VCardUtils.constructListFromValue(r6, this.mVCardType));
        return;
    L238:
        if (r1.toUpperCase().startsWith("X-") == true) goto L240;
        return;
    L240:
        if (this.mUnknownXData != null) goto L242;
        this.mUnknownXData = new ArrayList();
    L242:
        this.mUnknownXData.add(new Pair(r1, r6));
        return;
    L11:
        r6 = null;
        goto L13
    L5:
        if (r3.size() != 0) goto L8;
        goto L6
    }

    private void handleSipCase(String r9, Collection<String> r10) {
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (r9.startsWith("sip:") == false) goto L10;
        r9 = r9.substring(4);
        if (r9.length() != 0) goto L10;
        return;
    L10:
        boolean r0 = false;
        int r1 = -1;
        String r2 = null;
        if (r10 == null) goto L31;
        Iterator<String> r11 = r10.iterator();
        boolean r3 = false;
    L14:
        if (r11.hasNext() == false) goto L30;
        String r4 = r11.next();
        String r5 = r4.toUpperCase();
        int r7 = 1;
        if (r5.equals(VCardConstants.PARAM_TYPE_PREF) == true) goto L17;
        if (r5.equals("HOME") == true) goto L20;
        r7 = 2;
        if (r5.equals("WORK") == true) goto L20;
        if (r1 >= 0) goto L14;
        if (r5.startsWith("X-") == false) goto L28;
        r2 = r4.substring(2);
    L29:
        r1 = 0;
        goto L14
    L28:
        r2 = r4;
    L20:
        r1 = r7;
        goto L14
    L17:
        r3 = true;
        goto L14
    L30:
        r0 = r3;
    L31:
        if (r1 >= 0) goto L33;
        r1 = 3;
    L33:
        addSip(r9, r1, r2, r0);
    }

    public void addChild(VCardEntry r2) {
        if (this.mChildren != null) goto L5;
        this.mChildren = new ArrayList();
    L5:
        this.mChildren.add(r2);
    }

    private void handleAndroidCustomProperty(List<String> r2) {
        if (this.mAndroidCustomDataList != null) goto L5;
        this.mAndroidCustomDataList = new ArrayList();
    L5:
        this.mAndroidCustomDataList.add(AndroidCustomData.constructAndroidCustomData(r2));
    }

    private String constructDisplayName() {
        if (TextUtils.isEmpty(NameData.access$1300(this.mNameData)) == true) goto L6;
        String r7 = NameData.access$1300(this.mNameData);
    L27:
        if (r7 != null) goto L30;
        return "";
    L30:
        return r7;
    L6:
        if (this.mNameData.emptyStructuredName() == true) goto L9;
        r7 = VCardUtils.constructNameFromElements(this.mVCardType, NameData.access$1200(this.mNameData), NameData.access$1000(this.mNameData), NameData.access$1100(this.mNameData), NameData.access$900(this.mNameData), NameData.access$800(this.mNameData));
        goto L27
    L9:
        if (this.mNameData.emptyPhoneticStructuredName() == true) goto L11;
        r7 = VCardUtils.constructNameFromElements(this.mVCardType, NameData.access$500(this.mNameData), NameData.access$600(this.mNameData), NameData.access$700(this.mNameData));
        goto L27
    L11:
        List<EmailData> r0 = this.mEmailList;
        if (r0 != null) goto L14;
    L16:
        List<PhoneData> r1 = this.mPhoneList;
        if (r1 != null) goto L19;
    L21:
        List<OrganizationData> r2 = this.mOrganizationList;
        if (r2 != null) goto L24;
    L26:
        r7 = null;
        goto L27
    L24:
        if (r2.size() <= 0) goto L26;
        r7 = this.mOrganizationList.get(0).getFormattedString();
        goto L27
    L19:
        if (r1.size() <= 0) goto L21;
        r7 = PhoneData.access$1600(this.mPhoneList.get(0));
        goto L27
    L14:
        if (r0.size() <= 0) goto L16;
        r7 = EmailData.access$1500(this.mEmailList.get(0));
        goto L27
    }

    public void consolidateFields() {
        NameData r0 = this.mNameData;
        r0.displayName = constructDisplayName();
    }

    public boolean isIgnorable() {
        IsIgnorableIterator r0 = new IsIgnorableIterator(this, null);
        iterateAllData(r0);
        return r0.getResult();
    }

    public ArrayList<ContentProviderOperation> constructInsertOperations(ContentResolver r4, ArrayList<ContentProviderOperation> r5, boolean r6) {
        if (r5 != null) goto L5;
        r5 = new ArrayList();
    L5:
        if (isIgnorable() == false) goto L7;
        return r5;
    L7:
        int r7 = r5.size();
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        if (r6 == true) goto L10;
        r0.withValue("aggregation_mode", 3);
    L10:
        Account r8 = this.mAccount;
        if (r8 == null) goto L13;
        r0.withValue("account_name", r8.name);
        r0.withValue("account_type", this.mAccount.type);
    L14:
        r5.add(r0.build());
        r5.size();
        iterateAllData(new InsertOperationConstrutor(this, r5, r7));
        r5.size();
        return r5;
    L13:
        r0.withValue("account_name", null);
        r0.withValue("account_type", null);
        goto L14
    }

    public ArrayList<ContentProviderOperation> constructInsertOperations(ContentResolver r5, ArrayList<ContentProviderOperation> r6) {
        if (r6 != null) goto L5;
        r6 = new ArrayList();
    L5:
        if (isIgnorable() == false) goto L7;
        return r6;
    L7:
        int r7 = r6.size();
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        Account r1 = this.mAccount;
        if (r1 == null) goto L10;
        r0.withValue("account_name", r1.name);
        r0.withValue("account_type", this.mAccount.type);
    L11:
        r6.add(r0.build());
        r6.size();
        iterateAllData(new InsertOperationConstrutor(this, r6, r7));
        r6.size();
        return r6;
    L10:
        r0.withValue("account_name", null);
        r0.withValue("account_type", null);
        goto L11
    }

    private ContentProviderOperation getAddTimeValues(int r3) {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        r2.withValue("data1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        r2.withValue(DBHelper.COL_DATA2, "0");
        r2.withValue(DBHelper.COL_DATA3, "added time");
        r2.withValue(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, String.valueOf(System.currentTimeMillis()));
        r2.withValue("is_primary", 0);
        r2.withValue("is_super_primary", 0);
        r2.withValue("data_version", 0);
        r2.withValue("mimetype", "vnd.android.cursor.item/added_time");
        r2.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r3);
        return r2.build();
    }

    public static VCardEntry buildFromResolver(ContentResolver r1) {
        return buildFromResolver(r1, ContactsContract.Contacts.CONTENT_URI);
    }

    private String listToString(List<String> r4) {
        int r3 = r4.size();
        if (r3 <= 1) goto L12;
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        r1.append(r5.next());
        if ((r3 - 1) <= 0) goto L6;
        r1.append(";");
        goto L6
    L11:
        return r1.toString();
    L12:
        if (r3 == 1) goto L14;
        return "";
    L14:
        return r4.get(0);
    }

    public final NameData getNameData() {
        return this.mNameData;
    }

    public final List<NicknameData> getNickNameList() {
        return this.mNicknameList;
    }

    public final String getBirthday() {
        BirthdayData r0 = this.mBirthday;
        if (r0 != null) goto L7;
        return null;
    L7:
        return BirthdayData.access$1800(r0);
    }

    public final List<NoteData> getNotes() {
        return this.mNoteList;
    }

    public final List<PhoneData> getPhoneList() {
        return this.mPhoneList;
    }

    public final List<EmailData> getEmailList() {
        return this.mEmailList;
    }

    public final List<PostalData> getPostalList() {
        return this.mPostalList;
    }

    public final List<OrganizationData> getOrganizationList() {
        return this.mOrganizationList;
    }

    public final List<ImData> getImList() {
        return this.mImList;
    }

    public final List<PhotoData> getPhotoList() {
        return this.mPhotoList;
    }

    public final List<WebsiteData> getWebsiteList() {
        return this.mWebsiteList;
    }

    public final List<AndroidCustomData> getAndroidCustomData() {
        return this.mAndroidCustomDataList;
    }

    public final List<VCardEntry> getChildlen() {
        return this.mChildren;
    }

    public String getDisplayName() {
        if (this.mNameData.displayName != null) goto L6;
        NameData r0 = this.mNameData;
        r0.displayName = constructDisplayName();
    L6:
        return this.mNameData.displayName;
    }

    public List<Pair<String, String>> getUnknownXData() {
        return this.mUnknownXData;
    }
}
