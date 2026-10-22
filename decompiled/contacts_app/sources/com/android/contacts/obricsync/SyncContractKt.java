package com.android.contacts.obricsync;

import android.net.Uri;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\"\u000e\u0010\"\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&\"\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&\"\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\"\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&\"\u001d\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002000$¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&\"\u001d\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&¨\u00064"}, d2 = {"AUTHORITY", "", "COLUMN_ADDRESS", "COLUMN_AVATAR", "COLUMN_BIRTHDAY", "COLUMN_COMPANY", "COLUMN_CONTACT_ID", "COLUMN_EMAIL", "COLUMN_FIRST_NAME", "COLUMN_GENDER", "COLUMN_ID_CARDS", "COLUMN_IM", "COLUMN_INTER_ADDRESS", "COLUMN_LAST_NAME", "COLUMN_NAME", "COLUMN_NICK_NAME", "COLUMN_NOTE", "COLUMN_PHONE_NUMBER", "COLUMN_RELATION", "COLUMN_SHOULD_RESET", "COLUMN_SYNC_CONTACT_ID", "COLUMN_WEBSITE", "CONTACT_DATA_PROJECTION", "", "getCONTACT_DATA_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "CONTENT_TYPE", "OBRIC_CALLER_IS_SYNCADAPTER", "SCHEME_CONTENT", "SYNC_BUSINESS_COLUMNS", "", "getSYNC_BUSINESS_COLUMNS", "()Ljava/util/Set;", "TAB_NAME_SYNC", "contactLabelColumnName", "", "getContactLabelColumnName", "()Ljava/util/Map;", "contactMap", "getContactMap", "contactSyncUri", "Landroid/net/Uri;", "getContactSyncUri", "()Landroid/net/Uri;", "contactTypeColumnName", "getContactTypeColumnName", "contactTypeDefaultValue", "", "getContactTypeDefaultValue", "contactValueColumnName", "getContactValueColumnName", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SyncContractKt {
    private static final String AUTHORITY = "obric_contact_sync";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_AVATAR = "avatar";
    public static final String COLUMN_BIRTHDAY = "birthday";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_CONTACT_ID = "contact_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ID_CARDS = "id_cards";
    public static final String COLUMN_IM = "im";
    public static final String COLUMN_INTER_ADDRESS = "intel_address";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NICK_NAME = "nick_name";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_RELATION = "relation";
    public static final String COLUMN_SHOULD_RESET = "should_reset";
    public static final String COLUMN_SYNC_CONTACT_ID = "_id";
    public static final String COLUMN_WEBSITE = "website";
    private static final String[] CONTACT_DATA_PROJECTION = null;
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/obric_sync_contacts_data";
    public static final String OBRIC_CALLER_IS_SYNCADAPTER = "obric_caller_is_syncadapter";
    private static final String SCHEME_CONTENT = "content";
    private static final Set<String> SYNC_BUSINESS_COLUMNS = null;
    public static final String TAB_NAME_SYNC = "obric_sync_contacts_data";
    private static final Map<String, String> contactLabelColumnName = null;
    private static final Map<String, String> contactMap = null;
    private static final Uri contactSyncUri = null;
    private static final Map<String, String> contactTypeColumnName = null;
    private static final Map<String, Integer> contactTypeDefaultValue = null;
    private static final Map<String, String> contactValueColumnName = null;

    static {
        Uri r0 = new Uri.Builder().scheme("content").authority(AUTHORITY).path(TAB_NAME_SYNC).appendQueryParameter(OBRIC_CALLER_IS_SYNCADAPTER, "true").build();
        Intrinsics.checkNotNullExpressionValue(r0, "Builder().scheme(SCHEME_…CADAPTER, \"true\").build()");
        contactSyncUri = r0;
        SYNC_BUSINESS_COLUMNS = SetsKt.setOf(new String[]{"name", COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_COMPANY, COLUMN_ADDRESS, "phone_number", COLUMN_ID_CARDS, "email", COLUMN_AVATAR, COLUMN_BIRTHDAY, COLUMN_NOTE, COLUMN_NICK_NAME, COLUMN_IM, COLUMN_WEBSITE, COLUMN_GENDER, COLUMN_RELATION, COLUMN_INTER_ADDRESS});
        contactMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("name", "vnd.android.cursor.item/name"), TuplesKt.to(COLUMN_COMPANY, "vnd.android.cursor.item/organization"), TuplesKt.to(COLUMN_ADDRESS, "vnd.android.cursor.item/postal-address_v2"), TuplesKt.to("phone_number", "vnd.android.cursor.item/phone_v2"), TuplesKt.to(COLUMN_ID_CARDS, "vnd.android.cursor.item/card_id"), TuplesKt.to("email", "vnd.android.cursor.item/email_v2"), TuplesKt.to(COLUMN_NOTE, "vnd.android.cursor.item/note"), TuplesKt.to(COLUMN_NICK_NAME, "vnd.android.cursor.item/nickname"), TuplesKt.to(COLUMN_IM, "vnd.android.cursor.item/im"), TuplesKt.to(COLUMN_WEBSITE, "vnd.android.cursor.item/website"), TuplesKt.to(COLUMN_GENDER, "vnd.android.cursor.item/gender"), TuplesKt.to(COLUMN_BIRTHDAY, "vnd.android.cursor.item/contact_event"), TuplesKt.to(COLUMN_RELATION, "vnd.android.cursor.item/relation"), TuplesKt.to(COLUMN_INTER_ADDRESS, "vnd.android.cursor.item/sip_address"), TuplesKt.to(COLUMN_AVATAR, "vnd.android.cursor.item/photo")});
        contactValueColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/name", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/organization", "data1"), TuplesKt.to("vnd.android.cursor.item/postal-address_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/phone_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/card_id", "data1"), TuplesKt.to("vnd.android.cursor.item/email_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/note", "data1"), TuplesKt.to("vnd.android.cursor.item/nickname", "data1"), TuplesKt.to("vnd.android.cursor.item/im", "data1"), TuplesKt.to("vnd.android.cursor.item/website", "data1"), TuplesKt.to("vnd.android.cursor.item/gender", "data1"), TuplesKt.to("vnd.android.cursor.item/contact_event", "data1"), TuplesKt.to("vnd.android.cursor.item/relation", "data1"), TuplesKt.to("vnd.android.cursor.item/sip_address", "data1"), TuplesKt.to("vnd.android.cursor.item/photo", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG)});
        contactTypeColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/phone_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/card_id", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/email_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/im", "data5"), TuplesKt.to("vnd.android.cursor.item/contact_event", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/relation", DBHelper.COL_DATA2)});
        contactLabelColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/phone_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/email_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/im", "data6"), TuplesKt.to("vnd.android.cursor.item/contact_event", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/relation", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/card_id", DBHelper.COL_DATA3)});
        contactTypeDefaultValue = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", 1), TuplesKt.to("vnd.android.cursor.item/card_id", 1), TuplesKt.to("vnd.android.cursor.item/email_v2", 1), TuplesKt.to("vnd.android.cursor.item/im", 1), TuplesKt.to("vnd.android.cursor.item/contact_event", 3), TuplesKt.to("vnd.android.cursor.item/relation", 10), TuplesKt.to("vnd.android.cursor.item/phone_v2", 2)});
        CONTACT_DATA_PROJECTION = new String[]{"contact_id", "mimetype", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
    }

    public static final Uri getContactSyncUri() {
        return contactSyncUri;
    }

    public static final Set<String> getSYNC_BUSINESS_COLUMNS() {
        return SYNC_BUSINESS_COLUMNS;
    }

    public static final Map<String, String> getContactMap() {
        return contactMap;
    }

    public static final Map<String, String> getContactValueColumnName() {
        return contactValueColumnName;
    }

    public static final Map<String, String> getContactTypeColumnName() {
        return contactTypeColumnName;
    }

    public static final Map<String, String> getContactLabelColumnName() {
        return contactLabelColumnName;
    }

    public static final Map<String, Integer> getContactTypeDefaultValue() {
        return contactTypeDefaultValue;
    }

    public static final String[] getCONTACT_DATA_PROJECTION() {
        return CONTACT_DATA_PROJECTION;
    }
}
