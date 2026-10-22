package com.obric.appintents;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactSaveService;
import com.android.contacts.activities.ContactCalllogsActivity;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.HanziToPinyin;
import com.obric.appintents.contacts.ContactsCreateIntent;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.ContactsCreateParams;
import com.obric.capabilitykit.common.intent.ContactsUpdateParams;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a,\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\n\u001a\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a \u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u001e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0013\u001a\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0013\u001a\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0013\u001a\u0012\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u001a\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\f\u001a \u0010%\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\n\u001a\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0016\u0010*\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0016\u0010+\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u001c\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d\u001a\u0018\u00100\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u001a\u000e\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\n\u001a\u0014\u00103\u001a\u00020\n2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\u001d\u001a\u0014\u00105\u001a\u00020\n2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\u001d\u001a\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209\u001a\u000e\u00106\u001a\u00020\f2\u0006\u00108\u001a\u00020:¨\u0006;"}, d2 = {"clearIntentsAction", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "getActivityByClassNameIntent", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "getActivityIntent", "context", "Landroid/content/Context;", "className", "", "intentParams", "Lorg/json/JSONObject;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "getActivityStartParams", "getCallLogFragmentIntent", CallLogListAdapter.PAYLOAD_SELECTION, "getContactDetailFragmentIntent", "id", "", "getContactEditActivityIntent", "getCreateNewContactActivityIntent", "getGanderByString", "", "ganderString", "getIntent", "getRawContactIdByContactId", ContactSaveService.EXTRA_CONTACT_ID, "getRawContactIdsByContactId", "", "getRawContactsIdByRawContactId", "contacted", "contactsId", "getTopActivityName", "getTypeValue", "mimeType", "jsonObject", "getUiTypeByName", "currentUiType", "targetName", ContactCalllogsActivity.EXTRA_HAS_CALL_LOG, "", "isNormalContacts", "isProfileContacts", "queryContactsStarredById", "contentResolver", "Landroid/content/ContentResolver;", "ids", "queryPhoneHasCallLog", "toJSONObject", "str", "updateMissedSelection", "numbers", "updateSelection", "updateTypeValues", "Landroid/content/ContentValues;", "params", "Lcom/obric/capabilitykit/common/intent/ContactsCreateParams;", "Lcom/obric/capabilitykit/common/intent/ContactsUpdateParams;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntentsUtilsKt {
    public static final Intent getIntent(Context r5, Intent r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L5;
        Intent r0 = new Intent();
    L6:
        JSONObject r1 = getActivityStartParams(r6);
        String r2 = null;
        if (r6 == null) goto L9;
        String r3 = r6.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_NAME);
    L11:
        if (r6 == null) goto L13;
        r2 = r6.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION);
    L13:
        if (r3 == null) goto L15;
        r0.setClassName(r5, r3);
    L15:
        r0.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS, r1.toString());
        r0.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, r2);
        r0.addFlags(268435456);
        r0.addFlags(67108864);
        r0.setPackage("com.android.contacts");
        return r0;
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = r6;
        goto L6
    }

    public static final Intent getActivityIntent(Context r1, String r2, JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intent r0 = new Intent();
        if (r3 != null) goto L5;
        r3 = new JSONObject();
    L5:
        if (r2 == null) goto L7;
        r0.setClassName(r1, r2);
        r0.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_NAME, r2);
    L7:
        if (r4 == null) goto L9;
        r0.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, r4);
        r3.put(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, r4);
    L9:
        r0.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS, r3.toString());
        r0.addFlags(268435456);
        r0.addFlags(67108864);
        return r0;
    }

    public static final Intent getActivityByClassNameIntent(DispatchContext r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r1, "dispatchContext");
        Intent r3 = getIntent(r1.getContext(), r2);
        r3.setPackage("com.android.contacts");
        return r3;
    }

    public static final Intent getContactDetailFragmentIntent(DispatchContext r3, long r4, Intent r6) {
        Intrinsics.checkNotNullParameter(r3, "dispatchContext");
        Uri r5 = ContentUris.withAppendedId(Uri.parse("content://contacts/people?currentTime=" + System.currentTimeMillis()), r4);
        Intrinsics.checkNotNullExpressionValue(r5, "withAppendedId(legacyContentUri, id)");
        if (r6 == null) goto L5;
        String r0 = r6.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION);
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#openContactDetailFragment " + r0 + " uri = " + r5);
        Intent r7 = ContactsIntentUtils.launchContactDetailIntent(r3.getContext(), r5, true);
        r7.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS, getActivityStartParams(r6).toString());
        r7.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, r0);
        r7.addFlags(268435456);
        r7.addFlags(67108864);
        r7.setPackage("com.android.contacts");
        Intrinsics.checkNotNullExpressionValue(r7, "newIntent");
        return r7;
    L5:
        r0 = null;
        goto L6
    }

    public static final Intent getCallLogFragmentIntent(DispatchContext r1, String r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r1, "dispatchContext");
        Intent r4 = getIntent(r1.getContext(), r3);
        r4.setAction(ContactCalllogsActivity.ACTION_VIEW);
        Bundle r5 = new Bundle();
        r5.putString(ContactCalllogsActivity.SELECTION_KEY, r2);
        r4.putExtras(r5);
        r4.setPackage("com.android.contacts");
        return r4;
    }

    public static final Intent getCreateNewContactActivityIntent(DispatchContext r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "dispatchContext");
        Intent r3 = getActivityIntent(r1.getContext(), null, r2, null);
        r3.setData(ContactsContract.Contacts.CONTENT_URI);
        r3.setAction("android.intent.action.INSERT");
        r3.setPackage("com.android.contacts");
        return r3;
    }

    public static final Intent getContactEditActivityIntent(DispatchContext r1, long r2, Intent r4) {
        Intrinsics.checkNotNullParameter(r1, "dispatchContext");
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        Uri r3 = ContentUris.withAppendedId(Uri.parse("content://contacts/people"), r2);
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedId(legacyContentUri, id)");
        Intent r5 = new Intent("android.intent.action.EDIT", r3);
        r5.setPackage("com.android.contacts");
        r5.putExtra(ContactEditorActivity.INTENT_KEY_FINISH_ACTIVITY_ON_SAVE_COMPLETED, true);
        r5.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS, r4.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS));
        r5.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, r4.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION));
        r5.addFlags(268435456);
        r5.addFlags(67108864);
        r5.setPackage("com.android.contacts");
        return r5;
    }

    public static final JSONObject getActivityStartParams(Intent r2) {
        JSONObject r0 = new JSONObject();
        if (r2 == null) goto L10;
        String r3 = r2.getStringExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS);
        if (r3 != null) goto L7;
        return r0;
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return r0;
    L9:
        return toJSONObject(r3);
    L10:
        return r0;
    }

    public static final JSONObject toJSONObject(String r3) {
        Intrinsics.checkNotNullParameter(r3, "str");
        JSONObject r0 = new JSONObject();
        return new JSONObject(r3);
    L5:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(IntentsConstantKt.TAG, "IntentsUtils#toJSONObject Throwable e = " + th);
        return r0;
    }

    public static final String updateSelection(List<String> r17) {
        Intrinsics.checkNotNullParameter(r17, "numbers");
        if (r17.isEmpty() == false) goto L5;
        return "";
    L5:
        String r3 = StringsKt.replace$default(r17.get(0), HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        String r4 = "PHONE_NUMBERS_EQUAL(number,'" + r3 + "')";
    L9:
        int r7 = 1;
    L11:
        if (r7 >= r17.size()) goto L17;
        String r8 = StringsKt.replace$default(r17.get(r7), HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        if (TextUtils.isEmpty(r8) == true) goto L15;
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        r4 = String.format("(%s) OR (%s)", Arrays.copyOf(new Object[]{r4, "PHONE_NUMBERS_EQUAL(number,'" + r8 + "')"}, 2));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
    L15:
        r7 = r7 + 1;
        goto L11
    L17:
        if (TextUtils.isEmpty(r4) == false) goto L19;
        return "";
    L19:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r1 = String.format("(%s) AND (%s)", Arrays.copyOf(new Object[]{"1 = 1", r4}, 2));
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        String r2 = r1 + " AND type IN (1, 7, 2, 3, 4)";
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#updateSelection");
        return r2;
    L8:
        r4 = "1 = 0";
        goto L9
    }

    public static final String updateMissedSelection(List<String> r17) {
        Intrinsics.checkNotNullParameter(r17, "numbers");
        if (r17.isEmpty() == false) goto L5;
        return "";
    L5:
        String r3 = StringsKt.replace$default(r17.get(0), HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        String r4 = "PHONE_NUMBERS_EQUAL(number,'" + r3 + "')";
    L9:
        int r7 = 1;
    L11:
        if (r7 >= r17.size()) goto L17;
        String r8 = StringsKt.replace$default(r17.get(r7), HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        if (TextUtils.isEmpty(r8) == true) goto L15;
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        r4 = String.format("(%s) OR (%s)", Arrays.copyOf(new Object[]{r4, "PHONE_NUMBERS_EQUAL(number,'" + r8 + "')"}, 2));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
    L15:
        r7 = r7 + 1;
        goto L11
    L17:
        if (TextUtils.isEmpty(r4) == false) goto L19;
        return "";
    L19:
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        String r1 = String.format("(%s) AND (%s)", Arrays.copyOf(new Object[]{"1 = 1", r4}, 2));
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        String r2 = r1 + " AND type IN (3)";
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#updateMissedSelection");
        return r2;
    L8:
        r4 = "1 = 0";
        goto L9
    }

    public static final String getTypeValue(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        String r3 = r2.optString(r1, "");
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return null;
    L6:
        return r3;
    }

    public static final ContentValues updateTypeValues(ContactsCreateParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        new ArrayList();
        ContentValues r0 = new ContentValues();
        r0.put("vnd.android.cursor.item/name", r3.getName());
        r0.put("vnd.android.cursor.item/gender", r3.getGender());
        r0.put("vnd.android.cursor.item/organization", r3.getCompany());
        r0.put("vnd.android.cursor.item/note", r3.getNote());
        r0.put("vnd.android.cursor.item/email_v2", r3.getEmail());
        r0.put("vnd.android.cursor.item/postal-address_v2", r3.getAddress());
        r0.put("vnd.android.cursor.item/relation", r3.getRelationship());
        r0.put("vnd.android.cursor.item/card_id", r3.getIdentifyCard());
        r0.put("vnd.android.cursor.item/contact_event", r3.getBirthday());
        return r0;
    }

    public static final JSONObject updateTypeValues(ContactsUpdateParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        JSONObject r0 = new JSONObject();
        r0.put("vnd.android.cursor.item/name", r3.getName());
        r0.put("vnd.android.cursor.item/gender", r3.getGender());
        r0.put("vnd.android.cursor.item/organization", r3.getCompany());
        r0.put("vnd.android.cursor.item/note", r3.getNote());
        r0.put("vnd.android.cursor.item/email_v2", r3.getEmail());
        r0.put("vnd.android.cursor.item/postal-address_v2", r3.getAddress());
        r0.put("vnd.android.cursor.item/relation", r3.getRelationship());
        r0.put("vnd.android.cursor.item/card_id", r3.getIdentifyCard());
        r0.put("vnd.android.cursor.item/contact_event", r3.getBirthday());
        return r0;
    }

    public static final int getGanderByString(String r6) {
        boolean r2 = true;
        if (r6 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L19;
        if (r6 != null) goto L12;
    L14:
        r2 = false;
    L15:
        if (r2 == false) goto L18;
        return 2;
    L18:
        return 0;
    L12:
        if (StringsKt.contains$default(r6, ContactsCreateIntent.GANDER_FEMALE, false, 2, null) != true) goto L14;
    L19:
        return 1;
    L5:
        if (StringsKt.contains$default(r6, ContactsCreateIntent.GANDER_MALE, false, 2, null) != true) goto L7;
        r4 = true;
        goto L8
    }

    public static final Intent clearIntentsAction(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        r2.setAction(null);
        r2.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_ACTION, "");
        r2.putExtra(IntentsConstantKt.PARAMS_KEY_ACTIVITY_START_PARAMS, "");
        return r2;
    }

    public static final boolean queryPhoneHasCallLog(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneDeleteIntent#queryPhoneHasCallLog");
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return false;
    L5:
        Cursor r1 = null;
        r1 = r10.getApplicationContext().getContentResolver().query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, r11, null, "date DESC");     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneDeleteIntent#queryPhoneHasCallLog cursor null ");     // Catch: Throwable -> L17
        if (r1 == null) goto L16;
        r1.close();
    L16:
        return false;
    L9:
        if (r1.getCount() <= 0) goto L13;
        r1.close();
        return true;
    L17:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "PhoneCallIntent#openInCallWithContacts err = " + th);     // Catch: Throwable -> L22
        if (r1 == null) goto L21;
        r1.close();
    L21:
        return false;
    L22:
        th = move-exception;
        if (r1 == null) goto L25;
        r1.close();
    L25:
        throw th;
    }

    public static final int queryContactsStarredById(ContentResolver r10, List<Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Intrinsics.checkNotNullParameter(r11, "ids");
        Cursor r12 = r10.query(ContactsContract.Data.CONTENT_URI, null, "contact_id IN " + CollectionsKt.joinToString$default(r11, SimContactsConstants.EMAIL_SEP, "(", ")", 0, null, null, 56, null), null, null);
        int r0 = 0;
        if (r12 == null) goto L22;
        Cursor r1 = r12;
        Cursor r2 = r1;     // Catch: Throwable -> L17
    L7:
        if (r2.moveToNext() == false) goto L15;
        String r3 = r2.getString(r2.getColumnIndexOrThrow("mimetype"));     // Catch: Throwable -> L17
        if (r2.getString(r2.getColumnIndexOrThrow("data1")) == null) goto L7;
        if (Intrinsics.areEqual(r3, "vnd.android.cursor.item/phone_v2") == false) goto L7;
        String r4 = CallHistoryEntityUtilKt.safeGetColumn(r12, BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);     // Catch: Throwable -> L17
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#queryContactsById");     // Catch: Throwable -> L17
        if (TextUtils.equals("1", r4) == false) goto L7;
        r0 = r0 + 1;     // Catch: Throwable -> L17
        goto L7
    L15:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r1, null);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#queryContactsById count = " + r0);
        return r0;
    }

    public static final String getTopActivityName(Context r2) {
        if (r2 == null) goto L5;
        Object r3 = r2.getSystemService("activity");
    L7:
        if ((r3 instanceof ActivityManager) == false) goto L9;
        ActivityManager r4 = (ActivityManager) r3;
    L10:
        if (r4 == null) goto L14;
        List<ActivityManager.RunningTaskInfo> r5 = r4.getRunningTasks(1);
        if (r5 == null) goto L14;
        ActivityManager.RunningTaskInfo r6 = r5.get(0);
    L15:
        if (r6 == null) goto L20;
        ComponentName r7 = r6.topActivity;
        if (r7 != null) goto L19;
        return null;
    L19:
        return r7.getClassName();
    L20:
        return null;
    L14:
        r6 = null;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public static final int getUiTypeByName(Context r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetName");
        if (Intrinsics.areEqual(r3, getTopActivityName(r1)) == false) goto L5;
        return r2;
    L5:
        return r2 | 8;
    }

    public static final boolean isNormalContacts(Context r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#isNormalContacts id: " + r9);
        Cursor r10 = r8.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, "_id = ?", new String[]{String.valueOf(r9)}, null);
        if (r10 == null) goto L13;
        Cursor r11 = r10;
        boolean r12 = r11.moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);
        return r12;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L13:
        return false;
    }

    public static final boolean isProfileContacts(Context r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#hasProfileContacts id: " + r9);
        Cursor r10 = r8.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[]{"_id"}, "_id =?", new String[]{String.valueOf(r9)}, null);
        if (r10 == null) goto L13;
        Cursor r11 = r10;
        boolean r12 = r11.moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);
        return r12;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L13:
        return false;
    }

    public static final boolean hasCallLog(Context r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(IntentsConstantKt.TAG, "IntentsUtils#hasCallLog id: " + r9);
        Cursor r10 = r8.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"_id"}, "_id =?", new String[]{String.valueOf(r9)}, null);
        if (r10 == null) goto L13;
        Cursor r11 = r10;
        boolean r12 = r11.moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r11, null);
        return r12;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L13:
        return false;
    }

    public static final long getRawContactsIdByRawContactId(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "contacted");
        Cursor r9 = r7.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"name_raw_contact_id"}, "_id=?", new String[]{String.valueOf(r8)}, null);
        long r0 = -1;
        if (r9 == null) goto L15;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L10
        if (r11.moveToFirst() == false) goto L8;
        r0 = r11.getLong(0);     // Catch: Throwable -> L10
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r10, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L15:
        return r0;
    }

    public static final long getRawContactIdByContactId(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String[] r5 = {String.valueOf(r8)};
        Cursor r9 = r7.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"name_raw_contact_id"}, "_id = ?", r5, null);
        if (r9 == null) goto L21;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L16
        if (r11.moveToFirst() == false) goto L14;
        int r12 = r11.getColumnIndex("name_raw_contact_id");     // Catch: Throwable -> L16
        if (r12 >= 0) goto L11;
        CloseableKt.closeFinally(r10, null);
        return -1;
    L11:
        long r13 = r11.getLong(r12);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r10, null);
        return r13;
    L14:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r10, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L21:
        return -1;
    }

    public static final List<Long> getRawContactIdsByContactId(Context r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        ArrayList r0 = new ArrayList();
        String[] r5 = {String.valueOf(r8)};
        Cursor r9 = r7.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "contact_id = ?", r5, null);
        if (r9 == null) goto L19;
        Cursor r10 = r9;
        Cursor r11 = r10;     // Catch: Throwable -> L14
        if (r11.moveToFirst() == false) goto L12;
    L7:
        int r1 = r11.getColumnIndex("_id");     // Catch: Throwable -> L14
        if (r1 < 0) goto L11;
        r0.add(Long.valueOf(r11.getLong(r1)));     // Catch: Throwable -> L14
    L11:
        if (r11.moveToNext() == true) goto L7;
    L12:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r10, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L19:
        return r0;
    }
}
