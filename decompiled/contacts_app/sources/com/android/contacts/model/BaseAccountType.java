package com.android.contacts.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.DateUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import obric.api.ContactsContractSmt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAccountType extends AccountType {
    protected static final int FLAGS_EMAIL = 33;
    protected static final int FLAGS_EVENT = 1;
    protected static final int FLAGS_GENERIC_NAME = 8193;
    protected static final int FLAGS_NOTE = 16385;
    protected static final int FLAGS_PERSON_NAME = 8289;
    protected static final int FLAGS_PHONE = 3;
    protected static final int FLAGS_PHONETIC = 193;
    protected static final int FLAGS_POSTAL = 8305;
    protected static final int FLAGS_RELATION = 8289;
    protected static final int FLAGS_SIP_ADDRESS = 33;
    protected static final int FLAGS_WEBSITE = 17;
    private static final String TAG = "BaseAccountType";

    /* JADX INFO: renamed from: com.android.contacts.model.BaseAccountType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface Attr {
        public static final String DATE_WITH_TIME = "dateWithTime";
        public static final String KIND = "kind";
        public static final String MAX_OCCURRENCE = "maxOccurs";
        public static final String TYPE = "type";
        public static final String YEAR_OPTIONAL = "yearOptional";
    }

    public static class CardIdActionInflater extends CommonInflater {
        public CardIdActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L5;
            return R.string.email;
        L5:
            int r0 = r1.intValue();
            if (r0 != 1) goto L8;
            return R.string.cardIdIdentity;
        L8:
            if (r0 == 3) goto L11;
            return R.string.cardIdBank;
        L11:
            return R.string.cardIdDrive;
        }
    }

    public static abstract class CommonInflater implements AccountType.StringInflater {
        protected String getLabelColumn() {
            return DBHelper.COL_DATA3;
        }

        protected String getTypeColumn() {
            return DBHelper.COL_DATA2;
        }

        protected abstract int getTypeLabelResource(Integer r1);

        public CommonInflater() {
        }

        protected boolean isCustom(Integer r1) {
            if (r1.intValue() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        protected CharSequence getTypeLabel(Resources r2, Integer r3, CharSequence r4) {
            int r0 = getTypeLabelResource(r3);
            if (r3 != null) goto L7;
            return r2.getText(r0);
        L7:
            if (isCustom(r3) == false) goto L14;
            Object[] r1 = new Object[1];
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r1[0] = r4;
            return r2.getString(r0, r1);
        L14:
            return r2.getText(r0);
        }

        @Override // com.android.contacts.model.AccountType.StringInflater
        public CharSequence inflateUsing(Context r3, Cursor r4) {
            Integer r0 = Integer.valueOf(r4.getInt(r4.getColumnIndex(getTypeColumn())));
            String r5 = r4.getString(r4.getColumnIndex(getLabelColumn()));
            return getTypeLabel(r3.getResources(), r0, r5);
        }

        @Override // com.android.contacts.model.AccountType.StringInflater
        public CharSequence inflateUsing(Context r3, ContentValues r4) {
            Integer r0 = r4.getAsInteger(getTypeColumn());
            String r5 = r4.getAsString(getLabelColumn());
            return getTypeLabel(r3.getResources(), r0, r5);
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    public static class EmailActionInflater extends CommonInflater {
        public EmailActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L5;
            return R.string.email;
        L5:
            int r0 = r1.intValue();
            if (r0 != 1) goto L8;
            return R.string.email_home;
        L8:
            if (r0 != 2) goto L10;
            return R.string.email_work;
        L10:
            if (r0 != 3) goto L12;
            return R.string.email_other;
        L12:
            if (r0 == 4) goto L15;
            return R.string.email_custom;
        L15:
            return R.string.email_mobile;
        }
    }

    private static class EmailKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "email";
        }

        private EmailKindBuilder() {
            super(null);
        }

        /* synthetic */ EmailKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r14, XmlPullParser r15, AttributeSet r16) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r14, r15, r16, false, "vnd.android.cursor.item/email_v2", DBHelper.COL_DATA2, R.string.email, 15, R.layout.text_fields_editor_view, new EmailActionInflater(), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
            return Lists.newArrayList(new DataKind[]{r0});
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r1, String r2) {
            if ("home".equals(r2) == false) goto L7;
            return BaseAccountType.buildEmailType(1);
        L7:
            if ("work".equals(r2) == false) goto L11;
            return BaseAccountType.buildEmailType(2);
        L11:
            if ("other".equals(r2) == false) goto L15;
            return BaseAccountType.buildEmailType(3);
        L15:
            if ("mobile".equals(r2) == false) goto L19;
            return BaseAccountType.buildEmailType(4);
        L19:
            if ("custom".equals(r2) == true) goto L21;
            return null;
        L21:
            return BaseAccountType.buildEmailType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3);
        }
    }

    public static class EventActionInflater extends CommonInflater {
        public EventActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            return ContactsUtils.getEventTypeResource(r1);
        }
    }

    private static class EventKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "event";
        }

        private EventKindBuilder() {
            super(null);
        }

        /* synthetic */ EventKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r14, XmlPullParser r15, AttributeSet r16) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r14, r15, r16, false, "vnd.android.cursor.item/contact_event", DBHelper.COL_DATA2, R.string.eventLabelsGroup, 150, R.layout.event_field_editor_view, new EventActionInflater(), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.eventLabelsGroup, 1));
            if (BaseAccountType.access$1700(r16, "dateWithTime", false) == false) goto L5;
            r0.dateFormatWithoutYear = DateUtils.NO_YEAR_DATE_FORMAT;
            r0.dateFormatWithYear = DateUtils.DATE_AND_TIME_FORMAT;
        L7:
            return Lists.newArrayList(new DataKind[]{r0});
        L5:
            r0.dateFormatWithoutYear = DateUtils.NO_YEAR_DATE_FORMAT;
            r0.dateFormatWithYear = DateUtils.FULL_DATE_FORMAT;
            goto L7
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r3, String r4) {
            boolean r2 = BaseAccountType.access$1700(r3, "yearOptional", false);
            if (SyncContractKt.COLUMN_BIRTHDAY.equals(r4) == false) goto L7;
            return BaseAccountType.buildEventType(3, r2).setSpecificMax(1);
        L7:
            if ("anniversary".equals(r4) == false) goto L11;
            return BaseAccountType.buildEventType(1, r2);
        L11:
            if ("other".equals(r4) == false) goto L15;
            return BaseAccountType.buildEventType(2, r2);
        L15:
            if ("custom".equals(r4) == true) goto L17;
            return null;
        L17:
            return BaseAccountType.buildEventType(0, r2).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3);
        }
    }

    private static class GroupMembershipKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "group_membership";
        }

        private GroupMembershipKindBuilder() {
            super(null);
        }

        /* synthetic */ GroupMembershipKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r13, XmlPullParser r14, AttributeSet r15) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r16 = newDataKind(r13, r14, r15, false, "vnd.android.cursor.item/group_membership", null, R.string.common_groups, 999, -1, null, null);
            r16.fieldList.add(new AccountType.EditField("data1", -1, -1));
            throwIfList(r16);
            return Lists.newArrayList(new DataKind[]{r16});
        }
    }

    public static class ImActionInflater extends CommonInflater {
        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected String getLabelColumn() {
            return "data6";
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected String getTypeColumn() {
            return "data5";
        }

        public ImActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L6;
            return R.string.chat;
        L6:
            switch(r1.intValue()) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L7:
            return R.string.chat;
        L8:
            return R.string.chat_jabber;
        L10:
            return R.string.chat_icq;
        L12:
            return R.string.chat_gtalk;
        L14:
            return R.string.chat_qq;
        L16:
            return R.string.chat_skype;
        L18:
            return R.string.chat_yahoo;
        L20:
            return R.string.chat_msn;
        L22:
            return R.string.chat_aim;
        }
    }

    private static class ImKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return SyncContractKt.COLUMN_IM;
        }

        private ImKindBuilder() {
            super(null);
        }

        /* synthetic */ ImKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r14, XmlPullParser r15, AttributeSet r16) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r14, r15, r16, false, "vnd.android.cursor.item/im", "data5", R.string.imLabelsGroup, 20, R.layout.text_fields_editor_view, new ImActionInflater(), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.imLabelsGroup, 33));
            r0.defaultValues = new ContentValues();
            r0.defaultValues.put(DBHelper.COL_DATA2, 3);
            return Lists.newArrayList(new DataKind[]{r0});
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r1, String r2) {
            if ("aim".equals(r2) == false) goto L7;
            return BaseAccountType.buildImType(0);
        L7:
            if ("msn".equals(r2) == false) goto L11;
            return BaseAccountType.buildImType(1);
        L11:
            if ("yahoo".equals(r2) == false) goto L15;
            return BaseAccountType.buildImType(2);
        L15:
            if ("skype".equals(r2) == false) goto L19;
            return BaseAccountType.buildImType(3);
        L19:
            if ("qq".equals(r2) == false) goto L23;
            return BaseAccountType.buildImType(4);
        L23:
            if ("google_talk".equals(r2) == false) goto L27;
            return BaseAccountType.buildImType(5);
        L27:
            if ("icq".equals(r2) == false) goto L31;
            return BaseAccountType.buildImType(6);
        L31:
            if ("jabber".equals(r2) == false) goto L35;
            return BaseAccountType.buildImType(7);
        L35:
            if ("custom".equals(r2) == true) goto L37;
            return null;
        L37:
            return BaseAccountType.buildImType(-1).setSecondary(true).setCustomColumn("data6");
        }
    }

    private static abstract class KindBuilder {
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r1, String r2) {
            return null;
        }

        public abstract String getTagName();

        public abstract List<DataKind> parseDataKind(Context r1, XmlPullParser r2, AttributeSet r3) throws AccountType.DefinitionException, XmlPullParserException, IOException;

        private KindBuilder() {
        }

        /* synthetic */ KindBuilder(AnonymousClass1 r1) {
            this();
        }

        protected final DataKind newDataKind(Context r10, XmlPullParser r11, AttributeSet r12, boolean r13, String r14, String r15, int r16, int r17, int r18, AccountType.StringInflater r19, AccountType.StringInflater r20) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            if (Log.isLoggable(BaseAccountType.TAG, 3) == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(BaseAccountType.TAG, "Adding DataKind: " + r14);
        L6:
            DataKind r0 = new DataKind(r14, r16, r17, true, r18);
            r0.typeColumn = r15;
            r0.actionHeader = r19;
            r0.actionBody = r20;
            r0.fieldList = Lists.newArrayList();
            if (r13 == true) goto L16;
            r0.typeOverallMax = BaseAccountType.access$1500(r12, "maxOccurs", -1);
            if (r0.typeColumn == null) goto L15;
            r0.typeList = Lists.newArrayList();
            parseTypes(r10, r11, r12, r0, true);
            if (r0.typeList.size() != 0) goto L16;
            throw new AccountType.DefinitionException("Kind " + r0.mimeType + " must have at least one type");
        L15:
            parseTypes(r10, r11, r12, r0, false);
        L16:
            return r0;
        }

        private void parseTypes(Context r4, XmlPullParser r5, AttributeSet r6, DataKind r7, boolean r8) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            int r9 = r5.getDepth();
        L3:
            int r0 = r5.next();
            if (r0 == 1) goto L22;
            if (r0 == 3) goto L8;
        L9:
            int r1 = r5.getDepth();
            if (r0 != 2) goto L3;
            if (r1 != (r9 + 1)) goto L3;
            String r2 = r5.getName();
            if ("Type".equals(r2) == false) goto L21;
            if (r8 == false) goto L19;
            r7.typeList.add(parseTypeTag(r5, r6, r7));
            goto L3
        L19:
            throw new AccountType.DefinitionException("Kind " + r7.mimeType + " can't have types");
        L21:
            throw new AccountType.DefinitionException("Unknown tag: " + r2);
        L8:
            if (r5.getDepth() > r9) goto L9;
            return;
        }

        private AccountType.EditType parseTypeTag(XmlPullParser r2, AttributeSet r3, DataKind r4) throws AccountType.DefinitionException {
            String r5 = BaseAccountType.access$1400(r3, "type");
            AccountType.EditType r1 = buildEditTypeForTypeTag(r3, r5);
            if (r1 == null) goto L7;
            r1.specificMax = BaseAccountType.access$1500(r3, "maxOccurs", -1);
            return r1;
        L7:
            throw new AccountType.DefinitionException("Undefined type '" + r5 + "' for data kind '" + r4.mimeType + "'");
        }

        protected final void throwIfList(DataKind r3) throws AccountType.DefinitionException {
            if (r3.typeOverallMax != 1) goto L6;
            return;
        L6:
            throw new AccountType.DefinitionException("Kind " + r3.mimeType + " must have 'overallMax=\"1\"'");
        }
    }

    private static class KindParser {
        public static final KindParser INSTANCE = null;
        private final Map<String, KindBuilder> mBuilders;

        static {
            INSTANCE = new KindParser();
        }

        private KindParser() {
            this.mBuilders = Maps.newHashMap();
            AnonymousClass1 r1 = null;
            addBuilder(new NameKindBuilder(r1));
            addBuilder(new NicknameKindBuilder(r1));
            addBuilder(new PhoneKindBuilder(r1));
            addBuilder(new EmailKindBuilder(r1));
            addBuilder(new StructuredPostalKindBuilder(r1));
            addBuilder(new ImKindBuilder(r1));
            addBuilder(new OrganizationKindBuilder(r1));
            addBuilder(new PhotoKindBuilder(r1));
            addBuilder(new NoteKindBuilder(r1));
            addBuilder(new WebsiteKindBuilder(r1));
            addBuilder(new SipAddressKindBuilder(r1));
            addBuilder(new GroupMembershipKindBuilder(r1));
            addBuilder(new EventKindBuilder(r1));
            addBuilder(new RelationshipKindBuilder(r1));
        }

        private void addBuilder(KindBuilder r2) {
            this.mBuilders.put(r2.getTagName(), r2);
        }

        public List<DataKind> parseDataKindTag(Context r2, XmlPullParser r3, AttributeSet r4) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            String r0 = BaseAccountType.access$1400(r4, "kind");
            KindBuilder r1 = this.mBuilders.get(r0);
            if (r1 == null) goto L7;
            return r1.parseDataKind(r2, r3, r4);
        L7:
            throw new AccountType.DefinitionException("Undefined data kind '" + r0 + "'");
        }
    }

    private static class NameKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "name";
        }

        private NameKindBuilder() {
            super(null);
        }

        /* synthetic */ NameKindBuilder(AnonymousClass1 r1) {
            this();
        }

        private static void checkAttributeTrue(boolean r1, String r2) throws AccountType.DefinitionException {
            if (r1 == false) goto L5;
            return;
        L5:
            throw new AccountType.DefinitionException(r2 + " must be true");
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r32, XmlPullParser r33, AttributeSet r34) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            boolean r13 = r32.getResources().getBoolean(R.bool.config_editor_field_order_primary);
            boolean r2 = BaseAccountType.access$1700(r34, "supportsDisplayName", false);
            boolean r4 = BaseAccountType.access$1700(r34, "supportsPrefix", false);
            boolean r6 = BaseAccountType.access$1700(r34, "supportsMiddleName", false);
            boolean r8 = BaseAccountType.access$1700(r34, "supportsSuffix", false);
            boolean r10 = BaseAccountType.access$1700(r34, "supportsPhoneticFamilyName", false);
            boolean r14 = BaseAccountType.access$1700(r34, "supportsPhoneticMiddleName", false);
            boolean r1 = BaseAccountType.access$1700(r34, "supportsPhoneticGivenName", false);
            checkAttributeTrue(r2, "supportsDisplayName");
            checkAttributeTrue(r4, "supportsPrefix");
            checkAttributeTrue(r6, "supportsMiddleName");
            checkAttributeTrue(r8, "supportsSuffix");
            checkAttributeTrue(r10, "supportsPhoneticFamilyName");
            checkAttributeTrue(r14, "supportsPhoneticMiddleName");
            checkAttributeTrue(r1, "supportsPhoneticGivenName");
            ArrayList r15 = Lists.newArrayList();
            DataKind r0 = newDataKind(r32, r33, r34, false, "vnd.android.cursor.item/name", null, R.string.full_name, -1, R.layout.structured_name_editor_view, new SimpleInflater(R.string.full_name), new SimpleInflater("data1"));
            throwIfList(r0);
            r15.add(r0);
            r0.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289));
            r0.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
            r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
            r0.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
            r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
            r0.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
            r0.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
            r0.fieldList.add(new AccountType.EditField("data8", R.string.name_phonetic_middle, 193));
            r0.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
            DataKind r3 = newDataKind(r32, r33, r34, true, "#displayName", null, R.string.full_name, -1, R.layout.text_fields_editor_view, new SimpleInflater(R.string.full_name), new SimpleInflater("data1"));
            r3.typeOverallMax = 1;
            r15.add(r3);
            r3.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289).setShortForm(true));
            if (r13 == true) goto L5;
            r3.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
        L6:
            DataKind r5 = newDataKind(r32, r33, r34, true, "#phoneticName", null, R.string.name_phonetic, -1, R.layout.phonetic_name_editor_view, new SimpleInflater(R.string.full_name), new SimpleInflater("data1"));
            r5.typeOverallMax = 1;
            r15.add(r5);
            r5.fieldList.add(new AccountType.EditField("#phoneticName", R.string.name_phonetic, 193).setShortForm(true));
            r5.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193).setLongForm(true));
            r5.fieldList.add(new AccountType.EditField("data8", R.string.name_phonetic_middle, 193).setLongForm(true));
            r5.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193).setLongForm(true));
            return r15;
        L5:
            r3.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
            r3.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
            goto L6
        }
    }

    private static class NicknameKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "nickname";
        }

        private NicknameKindBuilder() {
            super(null);
        }

        /* synthetic */ NicknameKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r15, XmlPullParser r16, AttributeSet r17) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r15, r16, r17, false, "vnd.android.cursor.item/nickname", null, R.string.nicknameLabelsGroup, 115, R.layout.text_fields_editor_view, new SimpleInflater(R.string.nicknameLabelsGroup), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.nicknameLabelsGroup, 8289));
            r0.defaultValues = new ContentValues();
            r0.defaultValues.put(DBHelper.COL_DATA2, 1);
            throwIfList(r0);
            return Lists.newArrayList(new DataKind[]{r0});
        }
    }

    private static class NoteKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return SyncContractKt.COLUMN_NOTE;
        }

        private NoteKindBuilder() {
            super(null);
        }

        /* synthetic */ NoteKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r15, XmlPullParser r16, AttributeSet r17) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r15, r16, r17, false, "vnd.android.cursor.item/note", null, R.string.common_notes, 110, R.layout.text_fields_editor_view, new SimpleInflater(R.string.common_notes), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.common_notes, BaseAccountType.FLAGS_NOTE));
            throwIfList(r0);
            return Lists.newArrayList(new DataKind[]{r0});
        }
    }

    private static class OrganizationKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "organization";
        }

        private OrganizationKindBuilder() {
            super(null);
        }

        /* synthetic */ OrganizationKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r15, XmlPullParser r16, AttributeSet r17) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r15, r16, r17, false, "vnd.android.cursor.item/organization", null, R.string.organizationLabelsGroup, 5, R.layout.organization_fields_editor_view, new SimpleInflater("data1"), new SimpleInflater("data4"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.common_company, 8193));
            r0.fieldList.add(new AccountType.EditField("data4", R.string.ghostData_title, 8193));
            throwIfList(r0);
            return Lists.newArrayList(new DataKind[]{r0});
        }
    }

    public static class PhoneActionAltInflater extends CommonInflater {
        public PhoneActionAltInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected boolean isCustom(Integer r1) {
            if (r1.intValue() != 0) goto L5;
        L8:
            return true;
        L5:
            if (r1.intValue() == 19) goto L8;
            return false;
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L6;
            return R.string.common_send_sms;
        L6:
            switch(r1.intValue()) {
                case 1: goto L45;
                case 2: goto L43;
                case 3: goto L41;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                case 7: goto L47;
                case 8: goto L33;
                case 9: goto L31;
                case 10: goto L29;
                case 11: goto L27;
                case 12: goto L25;
                case 13: goto L23;
                case 14: goto L21;
                case 15: goto L19;
                case 16: goto L17;
                case 17: goto L15;
                case 18: goto L13;
                case 19: goto L11;
                case 20: goto L9;
                default: goto L7;
            };
        L7:
            return R.string.sms_custom;
        L9:
            return R.string.sms_mms;
        L11:
            return R.string.sms_assistant;
        L13:
            return R.string.sms_work_pager;
        L15:
            return R.string.sms_work_mobile;
        L17:
            return R.string.sms_tty_tdd;
        L19:
            return R.string.sms_telex;
        L21:
            return R.string.sms_radio;
        L23:
            return R.string.sms_other_fax;
        L25:
            return R.string.sms_main;
        L27:
            return R.string.sms_isdn;
        L29:
            return R.string.sms_company_main;
        L31:
            return R.string.sms_car;
        L33:
            return R.string.sms_callback;
        L35:
            return R.string.sms_pager;
        L37:
            return R.string.sms_fax_home;
        L39:
            return R.string.sms_fax_work;
        L41:
            return R.string.sms_work;
        L43:
            return R.string.sms_mobile;
        L45:
            return R.string.sms_home;
        L47:
            return R.string.common_send_sms;
        }
    }

    public static class PhoneActionInflater extends CommonInflater {
        public PhoneActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected boolean isCustom(Integer r1) {
            if (r1.intValue() != 0) goto L5;
        L8:
            return true;
        L5:
            if (r1.intValue() == 19) goto L8;
            return false;
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L6;
            return R.string.call_other;
        L6:
            switch(r1.intValue()) {
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L39;
                case 4: goto L37;
                case 5: goto L35;
                case 6: goto L33;
                case 7: goto L45;
                case 8: goto L31;
                case 9: goto L29;
                case 10: goto L27;
                case 11: goto L25;
                case 12: goto L23;
                case 13: goto L21;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L11;
                case 19: goto L7;
                case 20: goto L9;
                default: goto L7;
            };
        L7:
            return R.string.common_call_value;
        L9:
            return R.string.call_mms;
        L11:
            return R.string.call_work_pager;
        L13:
            return R.string.call_work_mobile;
        L15:
            return R.string.call_tty_tdd;
        L17:
            return R.string.call_telex;
        L19:
            return R.string.call_radio;
        L21:
            return R.string.call_other_fax;
        L23:
            return R.string.call_main;
        L25:
            return R.string.call_isdn;
        L27:
            return R.string.call_company_main;
        L29:
            return R.string.call_car;
        L31:
            return R.string.call_callback;
        L33:
            return R.string.call_pager;
        L35:
            return R.string.call_fax_home;
        L37:
            return R.string.call_fax_work;
        L39:
            return R.string.call_work;
        L41:
            return R.string.call_mobile;
        L43:
            return R.string.call_home;
        L45:
            return R.string.call_other;
        }
    }

    private static class PhoneKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "phone";
        }

        private PhoneKindBuilder() {
            super(null);
        }

        /* synthetic */ PhoneKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r14, XmlPullParser r15, AttributeSet r16) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r14, r15, r16, false, "vnd.android.cursor.item/phone_v2", DBHelper.COL_DATA2, R.string.common_phone, 10, R.layout.text_fields_editor_view, new PhoneActionInflater(), new SimpleInflater("data1"));
            r0.iconAltRes = R.drawable.ic_text_holo_light;
            r0.iconAltDescriptionRes = R.string.sms;
            r0.actionAltHeader = new PhoneActionAltInflater();
            r0.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
            return Lists.newArrayList(new DataKind[]{r0});
        }

        protected static AccountType.EditType build(int r2, boolean r3) {
            return new AccountType.EditType(r2, ContactTypeLabelUtils.getPhoneTypeLabelResource(r2)).setSecondary(r3);
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r2, String r3) {
            if ("home".equals(r3) == false) goto L7;
            return build(1, false);
        L7:
            if ("mobile".equals(r3) == false) goto L11;
            return build(2, false);
        L11:
            if ("work".equals(r3) == false) goto L15;
            return build(3, false);
        L15:
            if ("fax_work".equals(r3) == false) goto L19;
            return build(4, true);
        L19:
            if ("fax_home".equals(r3) == false) goto L23;
            return build(5, true);
        L23:
            if ("pager".equals(r3) == false) goto L27;
            return build(6, true);
        L27:
            if ("other".equals(r3) == false) goto L31;
            return build(7, false);
        L31:
            if ("callback".equals(r3) == false) goto L35;
            return build(8, true);
        L35:
            if ("car".equals(r3) == false) goto L39;
            return build(9, true);
        L39:
            if ("company_main".equals(r3) == false) goto L43;
            return build(10, true);
        L43:
            if ("isdn".equals(r3) == false) goto L47;
            return build(11, true);
        L47:
            if ("main".equals(r3) == false) goto L51;
            return build(12, true);
        L51:
            if ("other_fax".equals(r3) == false) goto L55;
            return build(13, true);
        L55:
            if ("radio".equals(r3) == false) goto L59;
            return build(14, true);
        L59:
            if ("telex".equals(r3) == false) goto L63;
            return build(15, true);
        L63:
            if ("tty_tdd".equals(r3) == false) goto L67;
            return build(16, true);
        L67:
            if ("work_mobile".equals(r3) == false) goto L71;
            return build(17, true);
        L71:
            if ("work_pager".equals(r3) == false) goto L75;
            return build(18, true);
        L75:
            if ("assistant".equals(r3) == false) goto L79;
            return build(19, true);
        L79:
            if (SmsMmsDatabaseUtil.MMS_TYPE.equals(r3) == false) goto L83;
            return build(20, true);
        L83:
            if ("custom".equals(r3) == true) goto L85;
            return null;
        L85:
            return build(0, true).setCustomColumn(DBHelper.COL_DATA3);
        }
    }

    private static class PhotoKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return BlackListQueryHandler.KEY_PHOTO;
        }

        private PhotoKindBuilder() {
            super(null);
        }

        /* synthetic */ PhotoKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r13, XmlPullParser r14, AttributeSet r15) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r16 = newDataKind(r13, r14, r15, false, "vnd.android.cursor.item/photo", null, -1, -1, -1, null, null);
            r16.fieldList.add(new AccountType.EditField(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, -1, -1));
            throwIfList(r16);
            return Lists.newArrayList(new DataKind[]{r16});
        }
    }

    public static class PostalActionInflater extends CommonInflater {
        public PostalActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r2) {
            if (r2 != null) goto L5;
            return R.string.map_other;
        L5:
            int r3 = r2.intValue();
            if (r3 != 1) goto L8;
            return R.string.map_home;
        L8:
            if (r3 != 2) goto L10;
            return R.string.map_work;
        L10:
            if (r3 == 3) goto L17;
            return R.string.map_custom;
        L17:
            return R.string.map_other;
        }
    }

    public static class RelationActionInflater extends CommonInflater {
        public RelationActionInflater() {
        }

        @Override // com.android.contacts.model.BaseAccountType.CommonInflater
        protected int getTypeLabelResource(Integer r1) {
            if (r1 != null) goto L4;
            int r0 = 0;
        L6:
            return ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(r0);
        L4:
            r0 = r1.intValue();
            goto L6
        }
    }

    private static class RelationshipKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "relationship";
        }

        private RelationshipKindBuilder() {
            super(null);
        }

        /* synthetic */ RelationshipKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r14, XmlPullParser r15, AttributeSet r16) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r14, r15, r16, false, "vnd.android.cursor.item/relation", DBHelper.COL_DATA2, R.string.relationLabelsGroup, 160, R.layout.text_fields_editor_view, new RelationActionInflater(), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.relationLabelsGroup, 8289));
            r0.defaultValues = new ContentValues();
            r0.defaultValues.put(DBHelper.COL_DATA2, 14);
            return Lists.newArrayList(new DataKind[]{r0});
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r1, String r2) {
            if ("assistant".equals(r2) == false) goto L7;
            return BaseAccountType.buildRelationType(1);
        L7:
            if ("brother".equals(r2) == false) goto L11;
            return BaseAccountType.buildRelationType(2);
        L11:
            if ("child".equals(r2) == false) goto L15;
            return BaseAccountType.buildRelationType(3);
        L15:
            if ("domestic_partner".equals(r2) == false) goto L19;
            return BaseAccountType.buildRelationType(4);
        L19:
            if ("father".equals(r2) == false) goto L23;
            return BaseAccountType.buildRelationType(5);
        L23:
            if ("friend".equals(r2) == false) goto L27;
            return BaseAccountType.buildRelationType(6);
        L27:
            if ("manager".equals(r2) == false) goto L31;
            return BaseAccountType.buildRelationType(7);
        L31:
            if ("mother".equals(r2) == false) goto L35;
            return BaseAccountType.buildRelationType(8);
        L35:
            if ("parent".equals(r2) == false) goto L39;
            return BaseAccountType.buildRelationType(9);
        L39:
            if ("partner".equals(r2) == false) goto L43;
            return BaseAccountType.buildRelationType(10);
        L43:
            if ("referred_by".equals(r2) == false) goto L47;
            return BaseAccountType.buildRelationType(11);
        L47:
            if ("relative".equals(r2) == false) goto L51;
            return BaseAccountType.buildRelationType(12);
        L51:
            if ("sister".equals(r2) == false) goto L55;
            return BaseAccountType.buildRelationType(13);
        L55:
            if ("spouse".equals(r2) == false) goto L59;
            return BaseAccountType.buildRelationType(14);
        L59:
            if ("custom".equals(r2) == true) goto L61;
            return null;
        L61:
            return BaseAccountType.buildRelationType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3);
        }
    }

    public static class SimpleInflater implements AccountType.StringInflater {
        private final String mColumnName;
        private final int mStringRes;

        public SimpleInflater(int r2) {
            this(r2, null);
        }

        public SimpleInflater(String r2) {
            this(-1, r2);
        }

        public SimpleInflater(int r1, String r2) {
            this.mStringRes = r1;
            this.mColumnName = r2;
        }

        @Override // com.android.contacts.model.AccountType.StringInflater
        public CharSequence inflateUsing(Context r7, Cursor r8) {
            String r0 = this.mColumnName;
            if (r0 == null) goto L5;
            int r1 = r8.getColumnIndex(r0);
        L6:
            int r6 = this.mStringRes;
            if (r6 <= 0) goto L9;
            boolean r4 = true;
        L10:
            if (r1 == (-1)) goto L12;
            boolean r2 = true;
        L14:
            if (r4 == false) goto L16;
            CharSequence r9 = r7.getText(r6);
        L17:
            if (r2 == false) goto L19;
            String r10 = r8.getString(r1);
        L20:
            if (r4 == false) goto L24;
            if (r2 == false) goto L24;
            return String.format(r9.toString(), new Object[]{r10});
        L24:
            if (r4 == false) goto L26;
            return r9;
        L26:
            if (r2 == false) goto L28;
            return r10;
        L28:
            return null;
        L19:
            r10 = null;
            goto L20
        L16:
            r9 = null;
            goto L17
        L12:
            r2 = false;
            goto L14
        L9:
            r4 = false;
            goto L10
        L5:
            r1 = -1;
            goto L6
        }

        @Override // com.android.contacts.model.AccountType.StringInflater
        public CharSequence inflateUsing(Context r7, ContentValues r8) {
            boolean r0 = r8.containsKey(this.mColumnName);
            int r1 = this.mStringRes;
            if (r1 <= 0) goto L5;
            boolean r4 = true;
        L7:
            if (r4 == false) goto L9;
            CharSequence r9 = r7.getText(r1);
        L10:
            if (r0 == false) goto L12;
            String r6 = r8.getAsString(this.mColumnName);
        L13:
            if (r4 == false) goto L17;
            if (r0 == false) goto L17;
            return String.format(r9.toString(), new Object[]{r6});
        L17:
            if (r4 == false) goto L19;
            return r9;
        L19:
            if (r0 == false) goto L21;
            return r6;
        L21:
            return null;
        L12:
            r6 = null;
            goto L13
        L9:
            r9 = null;
            goto L10
        L5:
            r4 = false;
            goto L7
        }

        public String toString() {
            return getClass().getSimpleName() + " mStringRes=" + this.mStringRes + " mColumnName" + this.mColumnName;
        }

        public String getColumnNameForTest() {
            return this.mColumnName;
        }
    }

    private static class SipAddressKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "sip_address";
        }

        private SipAddressKindBuilder() {
            super(null);
        }

        /* synthetic */ SipAddressKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r15, XmlPullParser r16, AttributeSet r17) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r15, r16, r17, false, "vnd.android.cursor.item/sip_address", null, R.string.label_sip_address, 130, R.layout.text_fields_editor_view, new SimpleInflater(R.string.label_sip_address), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.label_sip_address, 33));
            throwIfList(r0);
            return Lists.newArrayList(new DataKind[]{r0});
        }
    }

    private static class StructuredPostalKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return "postal";
        }

        private StructuredPostalKindBuilder() {
            super(null);
        }

        /* synthetic */ StructuredPostalKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r17, XmlPullParser r18, AttributeSet r19) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r17, r18, r19, false, "vnd.android.cursor.item/postal-address_v2", DBHelper.COL_DATA2, R.string.common_address, 25, R.layout.text_fields_editor_view, new PostalActionInflater(), new SimpleInflater("data1"));
            if (BaseAccountType.access$1700(r19, "needsStructured", false) == true) goto L5;
            r0.fieldList.add(new AccountType.EditField("data1", R.string.common_address, BaseAccountType.FLAGS_POSTAL));
        L10:
            return Lists.newArrayList(new DataKind[]{r0});
        L5:
            if (Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage()) == false) goto L7;
            r0.fieldList.add(new AccountType.EditField("data10", R.string.postal_country, BaseAccountType.FLAGS_POSTAL).setOptional(true));
            r0.fieldList.add(new AccountType.EditField("data9", R.string.postal_postcode, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data8", R.string.postal_region, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data7", R.string.postal_city, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data4", R.string.postal_street, BaseAccountType.FLAGS_POSTAL));
            goto L10
        L7:
            r0.fieldList.add(new AccountType.EditField("data4", R.string.postal_street, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data7", R.string.postal_city, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data8", R.string.postal_region, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data9", R.string.postal_postcode, BaseAccountType.FLAGS_POSTAL));
            r0.fieldList.add(new AccountType.EditField("data10", R.string.postal_country, BaseAccountType.FLAGS_POSTAL).setOptional(true));
            goto L10
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        protected AccountType.EditType buildEditTypeForTypeTag(AttributeSet r1, String r2) {
            if ("home".equals(r2) == false) goto L7;
            return BaseAccountType.buildPostalType(1);
        L7:
            if ("work".equals(r2) == false) goto L11;
            return BaseAccountType.buildPostalType(2);
        L11:
            if ("other".equals(r2) == false) goto L15;
            return BaseAccountType.buildPostalType(3);
        L15:
            if ("custom".equals(r2) == true) goto L17;
            return null;
        L17:
            return BaseAccountType.buildPostalType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3);
        }
    }

    private interface Tag {
        public static final String DATA_KIND = "DataKind";
        public static final String TYPE = "Type";
    }

    private static class WebsiteKindBuilder extends KindBuilder {
        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public String getTagName() {
            return SyncContractKt.COLUMN_WEBSITE;
        }

        private WebsiteKindBuilder() {
            super(null);
        }

        /* synthetic */ WebsiteKindBuilder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.android.contacts.model.BaseAccountType.KindBuilder
        public List<DataKind> parseDataKind(Context r15, XmlPullParser r16, AttributeSet r17) throws AccountType.DefinitionException, XmlPullParserException, IOException {
            DataKind r0 = newDataKind(r15, r16, r17, false, "vnd.android.cursor.item/website", null, R.string.websiteLabelsGroup, 120, R.layout.text_fields_editor_view, new SimpleInflater(R.string.websiteLabelsGroup), new SimpleInflater("data1"));
            r0.fieldList.add(new AccountType.EditField("data1", R.string.websiteLabelsGroup, 17));
            r0.defaultValues = new ContentValues();
            r0.defaultValues.put(DBHelper.COL_DATA2, 7);
            return Lists.newArrayList(new DataKind[]{r0});
        }
    }

    private interface Weight {
        public static final int CARDID = 140;
        public static final int EMAIL = 15;
        public static final int EVENT = 150;
        public static final int GROUP_MEMBERSHIP = 999;
        public static final int IM = 20;
        public static final int NICKNAME = 115;
        public static final int NONE = -1;
        public static final int NOTE = 110;
        public static final int ORGANIZATION = 5;
        public static final int PHONE = 10;
        public static final int RELATIONSHIP = 160;
        public static final int SIP_ADDRESS = 130;
        public static final int STRUCTURED_POSTAL = 25;
        public static final int WEBSITE = 120;
    }

    @Override // com.android.contacts.model.AccountType
    public boolean isGroupMembershipEditable() {
        return false;
    }

    static /* synthetic */ String access$1400(AttributeSet r0, String r1) {
        return getAttr(r0, r1);
    }

    static /* synthetic */ int access$1500(AttributeSet r0, String r1, int r2) {
        return getAttr(r0, r1, r2);
    }

    static /* synthetic */ boolean access$1700(AttributeSet r0, String r1, boolean r2) {
        return getAttr(r0, r1, r2);
    }

    public BaseAccountType() {
        this.accountType = null;
        this.dataSet = null;
        this.titleRes = R.string.account_phone;
        this.iconRes = R.mipmap.ic_launcher_phone;
    }

    protected static AccountType.EditType buildPhoneType(int r2) {
        return new AccountType.EditType(r2, ContactTypeLabelUtils.getPhoneTypeLabelResource(r2));
    }

    protected static AccountType.EditType buildEmailType(int r2) {
        return new AccountType.EditType(r2, ContactTypeLabelUtils.getEmailTypeLabelResource(r2));
    }

    protected static AccountType.EditType buildPostalType(int r2) {
        return new AccountType.EditType(r2, ContactTypeLabelUtils.getPostalTypeLabelResource(r2));
    }

    protected static AccountType.EditType buildImType(int r2) {
        return new AccountType.EditType(r2, ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(r2));
    }

    protected static AccountType.EditType buildImType(int r1, int r2) {
        return new AccountType.EditType(r1, r2);
    }

    protected static AccountType.EditType buildEventType(int r2, boolean r3) {
        return new AccountType.EventEditType(r2, ContactsUtils.getEventTypeResource(Integer.valueOf(r2))).setYearOptional(r3);
    }

    protected static AccountType.EditType buildRelationType(int r2) {
        return new AccountType.EditType(r2, ContactTypeLabelUtils.getRelationTypeLabelResource(r2));
    }

    protected static AccountType.EditType buildRelationType(int r1, int r2) {
        return new AccountType.EditType(r1, r2);
    }

    protected static AccountType.EditType buildCardIdType(int r2) {
        if (r2 == 1) goto L10;
        int r1 = R.string.cardIdBank;
        if (r2 == 2) goto L12;
        if (r2 != 3) goto L12;
        r1 = R.string.cardIdDrive;
    L12:
        return new AccountType.EditType(r2, r1);
    L10:
        r1 = R.string.cardIdIdentity;
        goto L12
    }

    protected DataKind addDataKindStructuredName(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/name", R.string.full_name, -1, true, R.layout.structured_name_editor_view));
        r6.actionHeader = new SimpleInflater(R.string.full_name);
        r6.actionBody = new SimpleInflater("data1");
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289));
        r6.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r6.fieldList.add(new AccountType.EditField("data8", R.string.name_phonetic_middle, 193));
        r6.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        return r6;
    }

    protected DataKind addDataKindDisplayName(Context r17) throws AccountType.DefinitionException {
        DataKind r0 = addKind(new DataKind("#displayName", R.string.full_name, -1, true, R.layout.text_fields_editor_view));
        r0.actionHeader = new SimpleInflater(R.string.full_name);
        r0.actionBody = new SimpleInflater("data1");
        r0.typeOverallMax = 1;
        r0.fieldList = Lists.newArrayList();
        r0.fieldList.add(new AccountType.EditField("data1", R.string.full_name, 8289).setShortForm(true));
        if (r17.getResources().getBoolean(R.bool.config_editor_field_order_primary) == true) goto L5;
        r0.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r0.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        r0.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
    L6:
        return r0;
    L5:
        r0.fieldList.add(new AccountType.EditField("data4", R.string.name_prefix, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA2, R.string.common_given_name, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193));
        r0.fieldList.add(new AccountType.EditField("data5", R.string.name_middle, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField(DBHelper.COL_DATA3, R.string.common_last_name, 8289).setLongForm(true));
        r0.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193));
        r0.fieldList.add(new AccountType.EditField("data6", R.string.name_suffix, 8289).setLongForm(true));
        goto L6
    }

    protected DataKind addDataKindPhoneticName(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("#phoneticName", R.string.name_phonetic, -1, true, R.layout.phonetic_name_editor_view));
        r6.actionHeader = new SimpleInflater(R.string.full_name);
        r6.actionBody = new SimpleInflater("data1");
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("#phoneticName", R.string.name_phonetic, 193).setShortForm(true));
        r6.fieldList.add(new AccountType.EditField("data9", R.string.name_phonetic_family, 193).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data8", R.string.name_phonetic_middle, 193).setLongForm(true));
        r6.fieldList.add(new AccountType.EditField("data7", R.string.name_phonetic_given, 193).setLongForm(true));
        return r6;
    }

    protected DataKind addDataKindNickname(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/nickname", R.string.nicknameLabelsGroup, 115, true, R.layout.text_fields_editor_view));
        r6.typeOverallMax = 1;
        r6.actionHeader = new SimpleInflater(R.string.nicknameLabelsGroup);
        r6.actionBody = new SimpleInflater("data1");
        r6.defaultValues = new ContentValues();
        r6.defaultValues.put(DBHelper.COL_DATA2, 1);
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.nicknameLabelsGroup, 8289));
        return r6;
    }

    protected DataKind addDataKindPhone(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/phone_v2", R.string.common_phone, 10, true, R.layout.text_fields_editor_view));
        r6.iconAltRes = R.drawable.ic_text_holo_light;
        r6.iconAltDescriptionRes = R.string.sms;
        r6.actionHeader = new PhoneActionInflater();
        r6.actionAltHeader = new PhoneActionAltInflater();
        r6.actionBody = new SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildPhoneType(2));
        r6.typeList.add(buildPhoneType(3));
        r6.typeList.add(buildPhoneType(1));
        r6.typeList.add(buildPhoneType(12).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(4).setSecondary(true));
        r6.typeList.add(buildPhoneType(5).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(6).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(7));
        r6.typeList.add(buildPhoneType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.typeList.add(buildPhoneType(8).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(9).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(10).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(11).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(13).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(14).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(15).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(16).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(17).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(18).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(19).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildPhoneType(20).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.common_phone, 3));
        return r6;
    }

    protected DataKind addDataKindCardId(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/card_id", R.string.label_custom_field, 140, true, R.layout.card_text_fields_editor_view));
        r6.actionHeader = new CardIdActionInflater();
        r6.actionBody = new SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = com.google.common.collect.Lists.newArrayList();
        r6.defaultValues = new ContentValues();
        r6.defaultValues.put(DBHelper.COL_DATA3, "");
        r6.typeList.add(buildCardIdType(1));
        r6.typeList.add(buildCardIdType(2));
        r6.typeList.add(buildCardIdType(3));
        r6.fieldList = com.google.common.collect.Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.cardIdGroup, 33));
        return r6;
    }

    protected DataKind addDataKindGender(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/gender", R.string.genderGroup, 140, true, R.layout.text_fields_select_view));
        r6.typeOverallMax = 1;
        r6.actionHeader = new SimpleInflater(R.string.genderGroup);
        r6.actionBody = new SimpleInflater("data1");
        r6.fieldList = com.google.common.collect.Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.genderGroup, 33));
        return r6;
    }

    protected DataKind addDataKindcity(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/email_v2", R.string.email, 15, true, R.layout.text_fields_editor_view));
        r6.actionHeader = new EmailActionInflater();
        r6.actionBody = new SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildEmailType(1));
        r6.typeList.add(buildEmailType(2));
        r6.typeList.add(buildEmailType(3));
        r6.typeList.add(buildEmailType(4));
        r6.typeList.add(buildEmailType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r6;
    }

    protected DataKind addDataKindEmail(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/email_v2", R.string.email, 15, true, R.layout.text_fields_editor_view));
        r6.actionHeader = new EmailActionInflater();
        r6.actionBody = new SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildEmailType(1));
        r6.typeList.add(buildEmailType(2));
        r6.typeList.add(buildEmailType(3));
        r6.typeList.add(buildEmailType(4).setSecondary(true).setDisappearWhenUserAdd(true));
        r6.typeList.add(buildEmailType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.email, 33));
        return r6;
    }

    protected DataKind addDataKindStructuredPostal(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/postal-address_v2", R.string.common_address, 25, true, R.layout.text_fields_editor_view));
        r6.actionHeader = new PostalActionInflater();
        r6.actionBody = new SimpleInflater("data1");
        r6.typeColumn = DBHelper.COL_DATA2;
        r6.typeList = Lists.newArrayList();
        r6.typeList.add(buildPostalType(1));
        r6.typeList.add(buildPostalType(2));
        r6.typeList.add(buildPostalType(3));
        r6.typeList.add(buildPostalType(0).setSecondary(true).setCustomColumn(DBHelper.COL_DATA3));
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.common_address, FLAGS_POSTAL));
        return r6;
    }

    protected DataKind addDataKindIm(Context r11) throws AccountType.DefinitionException {
        DataKind r10 = addKind(new DataKind("vnd.android.cursor.item/im", R.string.imLabelsGroup, 20, true, R.layout.text_fields_editor_view));
        r10.actionHeader = new ImActionInflater();
        r10.actionBody = new SimpleInflater("data1");
        r10.defaultValues = new ContentValues();
        r10.defaultValues.put(DBHelper.COL_DATA2, 3);
        r10.typeColumn = "data5";
        r10.typeList = Lists.newArrayList();
        if (ContactsUtils.isFeatureDomestic() == true) goto L5;
        r10.typeList.add(buildImType(0));
        r10.typeList.add(buildImType(1));
        r10.typeList.add(buildImType(2));
        r10.typeList.add(buildImType(3));
        r10.typeList.add(buildImType(4));
        r10.typeList.add(buildImType(5));
        r10.typeList.add(buildImType(6));
        r10.typeList.add(buildImType(7));
    L6:
        r10.fieldList = Lists.newArrayList();
        r10.fieldList.add(new AccountType.EditField("data1", R.string.imLabelsGroup, 33));
        return r10;
    L5:
        r10.typeList.add(buildImType(4));
        r10.typeList.add(buildImType(ContactsContractSmt.get_IM_PROTOCOL_WECHAT(), R.string.wechat));
        r10.typeList.add(buildImType(ContactsContractSmt.get_IM_PROTOCOL_MOMO(), R.string.label_momo));
        r10.typeList.add(buildImType(ContactsContractSmt.get_IM_PROTOCOL_WANGWANG(), R.string.label_wangwang));
        r10.typeList.add(buildImType(1));
        r10.typeList.add(buildImType(3));
        r10.typeList.add(buildImType(-1).setSecondary(true).setCustomColumn("data6"));
        r10.typeList.add(buildImType(0).setDisappearWhenUserAdd(true));
        r10.typeList.add(buildImType(2).setDisappearWhenUserAdd(true));
        r10.typeList.add(buildImType(5).setDisappearWhenUserAdd(true));
        r10.typeList.add(buildImType(6).setDisappearWhenUserAdd(true));
        r10.typeList.add(buildImType(7).setDisappearWhenUserAdd(true));
        goto L6
    }

    protected DataKind addDataKindOrganization(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/organization", R.string.organizationLabelsGroup, 5, true, R.layout.organization_fields_editor_view));
        r6.actionHeader = new SimpleInflater("data1");
        r6.actionBody = new SimpleInflater("data4");
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.common_company, 8193));
        r6.fieldList.add(new AccountType.EditField("data4", R.string.ghostData_title, 8193));
        return r6;
    }

    protected DataKind addDataKindPhoto(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/photo", -1, -1, true, -1));
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, -1, -1));
        return r6;
    }

    protected DataKind addDataKindNote(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/note", R.string.common_notes, 110, true, R.layout.text_fields_editor_view));
        r6.typeOverallMax = 1;
        r6.actionHeader = new SimpleInflater(R.string.common_notes);
        r6.actionBody = new SimpleInflater("data1");
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.common_notes, FLAGS_NOTE));
        return r6;
    }

    protected DataKind addDataKindWebsite(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/website", R.string.websiteLabelsGroup, 120, true, R.layout.text_fields_editor_view));
        r6.actionHeader = new SimpleInflater(R.string.websiteLabelsGroup);
        r6.actionBody = new SimpleInflater("data1");
        r6.defaultValues = new ContentValues();
        r6.defaultValues.put(DBHelper.COL_DATA2, 7);
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.websiteLabelsGroup, 17));
        return r6;
    }

    protected DataKind addDataKindSipAddress(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/sip_address", R.string.label_sip_address, 130, true, R.layout.text_fields_editor_view));
        r6.typeOverallMax = 1;
        r6.actionHeader = new SimpleInflater(R.string.label_sip_address);
        r6.actionBody = new SimpleInflater("data1");
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", R.string.label_sip_address, 33));
        return r6;
    }

    protected DataKind addDataKindGroupMembership(Context r7) throws AccountType.DefinitionException {
        DataKind r6 = addKind(new DataKind("vnd.android.cursor.item/group_membership", R.string.common_groups, 999, true, -1));
        r6.typeOverallMax = 1;
        r6.fieldList = Lists.newArrayList();
        r6.fieldList.add(new AccountType.EditField("data1", -1, -1));
        return r6;
    }

    protected final void parseEditSchema(Context r5, XmlPullParser r6, AttributeSet r7) throws XmlPullParserException, IOException, AccountType.DefinitionException {
        int r0 = r6.getDepth();
    L3:
        int r1 = r6.next();
        if (r1 == 1) goto L21;
        if (r1 == 3) goto L8;
    L9:
        int r2 = r6.getDepth();
        if (r1 != 2) goto L3;
        if (r2 != (r0 + 1)) goto L3;
        String r3 = r6.getName();
        if ("DataKind".equals(r3) == true) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Skipping unknown tag " + r3);
        goto L3
    L16:
        Iterator<DataKind> r4 = KindParser.INSTANCE.parseDataKindTag(r5, r6, r7).iterator();
    L18:
        if (r4.hasNext() == false) goto L3;
        addKind(r4.next());
        goto L18
    L8:
        if (r6.getDepth() > r0) goto L9;
        return;
    }

    private static boolean getAttr(AttributeSet r1, String r2, boolean r3) {
        return r1.getAttributeBooleanValue(null, r2, r3);
    }

    private static int getAttr(AttributeSet r1, String r2, int r3) {
        return r1.getAttributeIntValue(null, r2, r3);
    }

    private static String getAttr(AttributeSet r1, String r2) {
        return r1.getAttributeValue(null, r2);
    }
}
