package com.android.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.lunar.LunarCalendar;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class ShareContactByText {
    private static final int PRIORITY_BIRTHDAY = 8;
    private static final int PRIORITY_EMAIL = 2;
    private static final int PRIORITY_EVENT = 9;
    private static final int PRIORITY_IM = 4;
    private static final int PRIORITY_NICK_NAME = 1;
    private static final int PRIORITY_NOTE = 11;
    private static final int PRIORITY_ORG = 5;
    private static final int PRIORITY_PHONE = 0;
    private static final int PRIORITY_POSTAL = 3;
    private static final int PRIORITY_RELATION = 10;
    private static final int PRIORITY_SIP_ADDRESS = 6;
    private static final int PRIORITY_WEBSITE = 7;

    static abstract class BaseType implements Comparable<BaseType> {
        protected long id;
        protected String type;
        protected String value;

        protected abstract int priority();

        protected abstract void process(Context r1, ContentValues r2, String r3);

        BaseType() {
            this.id = 0;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(BaseType r1) {
            return compareTo2(r1);
        }

        protected String getType() {
            return this.type;
        }

        protected String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(BaseType r3) {
            int r0 = priority() - r3.priority();
            if (r0 != 0) goto L11;
            long r1 = sub_priority() - r3.sub_priority();
            if (r1 <= 0) goto L7;
            return 1;
        L7:
            if (r1 >= 0) goto L9;
            return -1;
        L9:
            return 0;
        L11:
            return r0;
        }

        void handleContentValues(Context r3, ContentValues r4, String r5) {
            if (r3 == null) goto L10;
            if (r4 == null) goto L11;
            Long r0 = r4.getAsLong("_id");
            if (r0 == null) goto L8;
            this.id = r0.longValue();
        L8:
            process(r3, r4, r5);
            return;
        L11:
            return;
        }

        protected long sub_priority() {
            return this.id;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof BaseType) == false) goto L10;
            BaseType r4 = (BaseType) r3;
            if (priority() == r4.priority()) goto L7;
            return false;
        L7:
            if (TextUtils.equals(this.value, r4.value) == false) goto L13;
            return true;
        L13:
            return false;
        L10:
            return false;
        }
    }

    static final class EmailType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 2;
        }

        EmailType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r3, ContentValues r4, String r5) {
            String r6 = r4.getAsString("data1");
            if (TextUtils.isEmpty(r6) == false) goto L5;
            return;
        L5:
            Integer r0 = r4.getAsInteger(DBHelper.COL_DATA2);
            String r7 = r4.getAsString(DBHelper.COL_DATA3);
            if (r0 != null) goto L9;
            this.type = r3.getString(R.string.common_other);
            this.value = r6;
            return;
        L9:
            if (TextUtils.isEmpty(r6) == true) goto L13;
            this.type = ContactTypeLabelUtils.getEmailTypeLabel(r3, r0, r7).toString();
            this.value = r6;
            return;
        }
    }

    static final class EventType extends BaseType {
        private boolean isBirthday;

        EventType() {
            this.isBirthday = false;
        }

        public boolean isBirthday() {
            return this.isBirthday;
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            if (isBirthday() == false) goto L5;
            return 8;
        L5:
            return 9;
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r6, ContentValues r7, String r8) {
            Integer r9 = r7.getAsInteger(DBHelper.COL_DATA2);
            String r0 = r7.getAsString("data1");
            String r10 = r7.getAsString(DBHelper.COL_DATA3);
            if (r9 == null) goto L13;
            if (r9.intValue() != 3) goto L7;
        L10:
            boolean r3 = true;
        L11:
            this.isBirthday = r3;
            goto L13
        L7:
            if (r9.intValue() == 4) goto L10;
            r3 = false;
        L13:
            if (r9 != null) goto L16;
            this.type = r6.getString(R.string.common_custom);
        L30:
            this.value = r0;
            return;
        L16:
            if (this.isBirthday == false) goto L22;
            if (r9.intValue() != 3) goto L20;
            this.type = r6.getResources().getString(R.string.common_birthday);
            goto L30
        L20:
            this.type = r6.getResources().getString(R.string.event_type_birthday_lunar);
            r0 = LunarCalendar.getLunarDisplayStringFromLunarDateString(r0);
            goto L30
        L22:
            if (r9.intValue() != 1) goto L24;
        L29:
            this.type = r6.getString(ContactsUtils.getEventTypeResource(r9));
            goto L30
        L24:
            if (r9.intValue() == 2) goto L29;
            if (TextUtils.isEmpty(r10) == false) goto L28;
            r10 = r6.getString(R.string.common_custom);
        L28:
            this.type = r10;
            goto L30
        }
    }

    static final class ImType extends BaseType {
        private static final int IM_MOMO = 101;
        private static final int IM_WANGWANG = 102;
        private static final int IM_WECHAT = 100;

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 4;
        }

        ImType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r4, ContentValues r5, String r6) {
            String r7 = r5.getAsString("data1");
            Integer r0 = r5.getAsInteger("data5");
            String r8 = r5.getAsString("data6");
            if (TextUtils.isEmpty(r7) == true) goto L8;
            if (r0 != null) goto L6;
            this.type = r4.getResources().getString(R.string.common_others);
            this.value = r7;
            return;
        L6:
            CharSequence r9 = ContactsContract.CommonDataKinds.Im.getProtocolLabel(r4.getResources(), r0.intValue(), r8);
            this.type = getImTypeNameByProtocol(r4, r0.intValue(), r9.toString());
            this.value = r7;
            return;
        }

        public String getImTypeNameByProtocol(Context r1, int r2, String r3) {
            switch(r2) {
                case 100: goto L9;
                case 101: goto L7;
                case 102: goto L5;
                default: goto L3;
            };
        L3:
            return r3;
        L5:
            return r1.getString(R.string.label_wangwang);
        L7:
            return r1.getString(R.string.label_momo);
        L9:
            return r1.getString(R.string.wechat);
        }
    }

    static final class NickNameType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 1;
        }

        NickNameType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r1, ContentValues r2, String r3) {
            this.type = r1.getString(R.string.nicknameLabelsGroup);
            this.value = r2.getAsString("data1");
        }
    }

    static final class NoteType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 11;
        }

        NoteType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r2, ContentValues r3, String r4) {
            if (TextUtils.isEmpty(r3.getAsString("data1")) == true) goto L6;
            this.value = r3.getAsString("data1");
            this.type = r2.getResources().getString(R.string.common_notes);
            return;
        }
    }

    static final class OrganizationType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 5;
        }

        OrganizationType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r3, ContentValues r4, String r5) {
            Integer r6 = r4.getAsInteger(DBHelper.COL_DATA2);
            String r0 = r4.getAsString(DBHelper.COL_DATA3);
            if (r6 != null) goto L5;
            this.type = r3.getString(R.string.common_work);
        L6:
            StringBuilder r7 = new StringBuilder();
            if (TextUtils.isEmpty(r4.getAsString("data1")) == true) goto L10;
            r7.append(r4.getAsString("data1")).append(HanziToPinyin.Token.SEPARATOR);
        L10:
            if (TextUtils.isEmpty(r4.getAsString("data5")) == true) goto L12;
            r7.append(r4.getAsString("data5")).append(HanziToPinyin.Token.SEPARATOR);
        L12:
            this.value = r7.toString();
            return;
        L5:
            this.type = ContactTypeLabelUtils.getOrganizationTypeLabel(r3, r6, r0).toString();
            goto L6
        }
    }

    static final class PhoneNumberType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 0;
        }

        PhoneNumberType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r3, ContentValues r4, String r5) {
            String r6 = r4.getAsString("data1");
            Integer r0 = r4.getAsInteger(DBHelper.COL_DATA2);
            String r7 = r4.getAsString(DBHelper.COL_DATA3);
            if (TextUtils.isEmpty(r6) == true) goto L8;
            if (r0 != null) goto L6;
            this.type = r3.getString(R.string.common_custom);
            this.value = ContactsUtils.formatNumber(r6);
            return;
        L6:
            this.type = ContactTypeLabelUtils.getPhoneTypeLabel(r3, r0, r7).toString();
            this.value = ContactsUtils.formatNumber(r6);
            return;
        }
    }

    static final class PostalType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 3;
        }

        PostalType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r3, ContentValues r4, String r5) {
            Integer r6 = r4.getAsInteger(DBHelper.COL_DATA2);
            String r0 = r4.getAsString(DBHelper.COL_DATA3);
            if (r6 != null) goto L5;
            this.type = r3.getString(R.string.common_other);
        L6:
            StringBuilder r7 = new StringBuilder();
            if (r4.containsKey("data5") == false) goto L12;
            String r8 = r4.getAsString("data5");
            if (TextUtils.isEmpty(r8) == true) goto L12;
            r7.append(r8);
        L12:
            if (r4.containsKey("data1") == false) goto L16;
            String r9 = r4.getAsString("data1");
            if (TextUtils.isEmpty(r9) == true) goto L16;
            r7.append(r9);
        L18:
            if (r4.containsKey("data4") == false) goto L25;
            String r1 = r4.getAsString("data4");
            if (TextUtils.isEmpty(r1) == true) goto L25;
            if (TextUtils.equals(r9, r1) == true) goto L25;
            r7.append(r1);
        L25:
            if (r4.containsKey("data7") == false) goto L30;
            String r10 = r4.getAsString("data7");
            if (TextUtils.isEmpty(r10) == true) goto L30;
            r7.append(r10);
        L30:
            if (r4.containsKey("data8") == false) goto L35;
            String r11 = r4.getAsString("data8");
            if (TextUtils.isEmpty(r11) == true) goto L35;
            r7.append(r11);
        L35:
            if (r4.containsKey("data9") == false) goto L40;
            String r12 = r4.getAsString("data9");
            if (TextUtils.isEmpty(r12) == true) goto L40;
            r7.append(r12);
        L40:
            if (r4.containsKey("data10") == false) goto L44;
            String r13 = r4.getAsString("data10");
            if (TextUtils.isEmpty(r13) == true) goto L44;
            r7.append(r13);
        L44:
            this.value = r7.toString();
            return;
        L16:
            r9 = null;
            goto L18
        L5:
            this.type = ContactTypeLabelUtils.getPostalTypeLabel(r3, r6, r0).toString();
            goto L6
        }
    }

    static final class RelationType extends BaseType {
        private static final int RELATION_CLASSMATE = 101;
        private static final int RELATION_COLLEAGUE = 100;

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 10;
        }

        RelationType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r3, ContentValues r4, String r5) {
            Integer r6 = r4.getAsInteger(DBHelper.COL_DATA2);
            String r0 = r4.getAsString(DBHelper.COL_DATA3);
            String r7 = r4.getAsString("data1");
            if (r6 != null) goto L5;
            this.type = r3.getString(R.string.common_custom);
            this.value = r7;
            return;
        L5:
            String r1 = ContactTypeLabelUtils.getRelationTypeLabel(r3, r6, r0).toString();
            this.type = getRelationTypeNameByProtocol(r3, r6.intValue(), r1);
            this.value = r7;
        }

        public String getRelationTypeNameByProtocol(Context r1, int r2, String r3) {
            if (r2 == 100) goto L10;
            if (r2 == 101) goto L8;
            return r3;
        L8:
            return r1.getString(R.string.relation_type_class_mate);
        L10:
            return r1.getString(R.string.relation_type_work_mate);
        }
    }

    static final class SipAddressType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 6;
        }

        SipAddressType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r2, ContentValues r3, String r4) {
            String r5 = r3.getAsString("data1");
            r3.getAsInteger(DBHelper.COL_DATA2);
            r3.getAsString(DBHelper.COL_DATA3);
            this.type = r2.getResources().getString(R.string.label_sip_address);
            this.value = r5;
        }
    }

    static final class WebsiteType extends BaseType {
        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected int priority() {
            return 7;
        }

        WebsiteType() {
        }

        @Override // com.android.contacts.util.ShareContactByText.BaseType
        protected void process(Context r1, ContentValues r2, String r3) {
            String r4 = r2.getAsString("data1");
            if (TextUtils.isEmpty(r4) == true) goto L6;
            this.type = r1.getResources().getString(R.string.vcard_website_homepage);
            this.value = r4;
            return;
        }
    }

    public ShareContactByText() {
    }

    static BaseType genernateByMimeType(String r1) {
        if (TextUtils.equals(r1, "vnd.android.cursor.item/phone_v2") == false) goto L7;
        return new PhoneNumberType();
    L7:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/nickname") == false) goto L11;
        return new NickNameType();
    L11:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/email_v2") == false) goto L15;
        return new EmailType();
    L15:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/postal-address_v2") == false) goto L19;
        return new PostalType();
    L19:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/im") == false) goto L23;
        return new ImType();
    L23:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/organization") == false) goto L27;
        return new OrganizationType();
    L27:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/website") == false) goto L31;
        return new WebsiteType();
    L31:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/contact_event") == false) goto L35;
        return new EventType();
    L35:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/note") == false) goto L39;
        return new NoteType();
    L39:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/sip_address") == false) goto L43;
        return new SipAddressType();
    L43:
        if (TextUtils.equals(r1, "vnd.android.cursor.item/relation") == true) goto L45;
        return null;
    L45:
        return new RelationType();
    }

    public static final String toShareText(Context r8, ContactLoader.Result r9) {
        if (r9 != null) goto L4;
        return null;
    L4:
        if (r9.isLoaded() == false) goto L72;
        ArrayList r0 = new ArrayList();
        String r1 = r9.getDisplayName();
        StringBuilder r2 = new StringBuilder("[");
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = r8.getResources().getString(R.string.missing_name);
    L9:
        r2.append(r8.getString(R.string.full_name)).append("] ").append(r1);
        String r3 = Locale.getDefault().getCountry();
        ArrayList<Entity> r10 = r9.getEntities();
        if (r10 == null) goto L33;
        if (r10.size() <= 0) goto L33;
        Iterator<Entity> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L33;
        Entity r4 = r11.next();
        if (r4.getSubValues() == null) goto L15;
        Iterator<Entity.NamedContentValues> r5 = r4.getSubValues().iterator();
    L20:
        if (r5.hasNext() == false) goto L15;
        Entity.NamedContentValues r6 = r5.next();
        if (ContactsContract.Data.CONTENT_URI.equals(r6.uri) == false) goto L20;
        ContentValues r7 = r6.values;
        if (r7.containsKey("mimetype") == false) goto L20;
        String r12 = r7.getAsString("mimetype");
        if (TextUtils.isEmpty(r12) == true) goto L20;
        BaseType r13 = genernateByMimeType(r12);
        if (r13 == null) goto L20;
        r13.handleContentValues(r8, r7, r3);
        if (containThisItem(r0, r13) == true) goto L20;
        r0.add(r13);
    L33:
        if (r0.size() <= 0) goto L44;
        Collections.sort(r0);
        Iterator r14 = r0.iterator();
    L36:
        if (r14.hasNext() == false) goto L43;
        BaseType r15 = (BaseType) r14.next();
        if (TextUtils.isEmpty(r15.getType()) == true) goto L36;
        if (TextUtils.isEmpty(r15.getValue()) == true) goto L36;
        r2.append(";\n[").append(r15.getType()).append("] ").append(r15.getValue());
        goto L36
    L43:
        r2.append(";");
    L44:
        r0.clear();
        return r2.toString();
    L72:
        return null;
    }

    private static boolean containThisItem(List<BaseType> r1, BaseType r2) {
        Iterator<BaseType> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r3.next().equals(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
