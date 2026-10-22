package com.obric.appintents;

import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: IntentsConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"ACTIVITY_NAME_CALL_DETAIL", "", "ACTIVITY_NAME_CONTACT_DETAIL", "ACTIVITY_NAME_EDIT_CONTACT", "ACTIVITY_NAME_MAIN", "PARAMS_KEY_ACTIVITY_ACTION", "PARAMS_KEY_ACTIVITY_NAME", "PARAMS_KEY_ACTIVITY_START_PARAMS", "TAG", "contactLabelColumnName", "", "getContactLabelColumnName", "()Ljava/util/Map;", "contactTypeColumnName", "getContactTypeColumnName", "contactTypeDefaultValue", "", "getContactTypeDefaultValue", "contactValueColumnName", "getContactValueColumnName", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntentsConstantKt {
    public static final String ACTIVITY_NAME_CALL_DETAIL = "com.android.contacts.activities.ContactCalllogsActivity";
    public static final String ACTIVITY_NAME_CONTACT_DETAIL = "com.android.contacts.activities.ContactDetailActivity";
    public static final String ACTIVITY_NAME_EDIT_CONTACT = "com.android.contacts.activities.ContactEditorActivity";
    public static final String ACTIVITY_NAME_MAIN = "com.android.contacts.activities.DialtactsActivity";
    public static final String PARAMS_KEY_ACTIVITY_ACTION = "intents_activity_action";
    public static final String PARAMS_KEY_ACTIVITY_NAME = "intents_activity_name";
    public static final String PARAMS_KEY_ACTIVITY_START_PARAMS = "intents_activity_start_params";
    public static final String TAG = "Intents_Log";
    private static final Map<String, String> contactLabelColumnName = null;
    private static final Map<String, String> contactTypeColumnName = null;
    private static final Map<String, Integer> contactTypeDefaultValue = null;
    private static final Map<String, String> contactValueColumnName = null;

    public static final Map<String, String> getContactValueColumnName() {
        return contactValueColumnName;
    }

    static {
        contactValueColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/name", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/organization", "data1"), TuplesKt.to("vnd.android.cursor.item/postal-address_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/phone_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/card_id", "data1"), TuplesKt.to("vnd.android.cursor.item/email_v2", "data1"), TuplesKt.to("vnd.android.cursor.item/note", "data1"), TuplesKt.to("vnd.android.cursor.item/nickname", "data1"), TuplesKt.to("vnd.android.cursor.item/im", "data1"), TuplesKt.to("vnd.android.cursor.item/website", "data1"), TuplesKt.to("vnd.android.cursor.item/gender", "data1"), TuplesKt.to("vnd.android.cursor.item/contact_event", "data1"), TuplesKt.to("vnd.android.cursor.item/relation", "data1"), TuplesKt.to("vnd.android.cursor.item/sip_address", "data1"), TuplesKt.to("vnd.android.cursor.item/photo", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG)});
        contactTypeDefaultValue = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", 1), TuplesKt.to("vnd.android.cursor.item/card_id", 1), TuplesKt.to("vnd.android.cursor.item/email_v2", 1), TuplesKt.to("vnd.android.cursor.item/im", 1), TuplesKt.to("vnd.android.cursor.item/contact_event", 3), TuplesKt.to("vnd.android.cursor.item/relation", 10)});
        contactLabelColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/phone_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/email_v2", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/im", "data6"), TuplesKt.to("vnd.android.cursor.item/contact_event", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/relation", DBHelper.COL_DATA3), TuplesKt.to("vnd.android.cursor.item/card_id", DBHelper.COL_DATA3)});
        contactTypeColumnName = MapsKt.mapOf(new Pair[]{TuplesKt.to("vnd.android.cursor.item/postal-address_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/phone_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/card_id", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/email_v2", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/im", "data5"), TuplesKt.to("vnd.android.cursor.item/contact_event", DBHelper.COL_DATA2), TuplesKt.to("vnd.android.cursor.item/relation", DBHelper.COL_DATA2)});
    }

    public static final Map<String, Integer> getContactTypeDefaultValue() {
        return contactTypeDefaultValue;
    }

    public static final Map<String, String> getContactLabelColumnName() {
        return contactLabelColumnName;
    }

    public static final Map<String, String> getContactTypeColumnName() {
        return contactTypeColumnName;
    }
}
