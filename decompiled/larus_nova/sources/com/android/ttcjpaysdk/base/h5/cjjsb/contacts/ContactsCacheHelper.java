package com.android.ttcjpaysdk.base.h5.cjjsb.contacts;

import android.content.SharedPreferences;
import com.bytedance.caijing.sdk.infra.base.api.kvstore.CJKVStoreService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ve4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/ContactsCacheHelper;", "", "()V", "FIELD_NAME", "", "FIELD_PHONE_LIST", "KEY_PREFIX", "SP_NAME", "TAG", "buildKey", "bizScene", "uid", "readContacts", "", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/CJContactsCacheModel;", "writeContacts", "", "contacts", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContactsCacheHelper {
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PHONE_LIST = "phone_number_list";
    public static final ContactsCacheHelper INSTANCE = null;
    private static final String KEY_PREFIX = "cj_contacts_";
    private static final String SP_NAME = "cj_pay_contacts_cache";
    private static final String TAG = "ContactsCacheHelper";

    static {
        INSTANCE = new ContactsCacheHelper();
    }

    private ContactsCacheHelper() {
    }

    private final String buildKey(String r100, String r101) {
        return KEY_PREFIX + r100 + '_' + r101;
    }

    public final List<CJContactsCacheModel> readContacts(String r110, String r111) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r110, "bizScene");
        Intrinsics.checkNotNullParameter(r111, "uid");
        ArrayList r101 = new ArrayList();
        CJKVStoreService r102 = (CJKVStoreService) b.b(CJKVStoreService.class);     // Catch: Throwable -> L31
        if (r102 == null) goto L30;
        SharedPreferences r103 = r102.getSharedPreference(SP_NAME, 0);     // Catch: Throwable -> L31
        if (r103 == null) goto L30;
        String r112 = r103.getString(buildKey(r110, r111), "");     // Catch: Throwable -> L31
        if (r112 == null) goto L13;
        r100 = r112;
    L13:
        if (r100.length() != 0) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == false) goto L18;
        return r101;
    L18:
        JSONArray r114 = new JSONArray(r100);     // Catch: Throwable -> L31
        int r115 = r114.length();     // Catch: Throwable -> L31
        int r104 = 0;
    L19:
        if (r104 >= r115) goto L33;
        JSONObject r105 = r114.optJSONObject(r104);     // Catch: Throwable -> L31
        if (r105 == null) goto L29;
        JSONArray r106 = r105.optJSONArray(FIELD_PHONE_LIST);     // Catch: Throwable -> L31
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L31
        if (r106 == null) goto L28;
        int r108 = r106.length();     // Catch: Throwable -> L31
        int r109 = 0;
    L26:
        if (r109 >= r108) goto L28;
        r107.add(r106.optString(r109));     // Catch: Throwable -> L31
        r109 = r109 + 1;     // Catch: Throwable -> L31
    L28:
        r101.add(new CJContactsCacheModel(r105.optString("name"), r107));     // Catch: Throwable -> L31
    L29:
        r104 = r104 + 1;
    L33:
        return r101;
    L15:
        r113 = false;
    L30:
        return r101;
    L31:
        th = move-exception;
        CJLogger.b(TAG, "readContacts fail: " + th.getMessage());
        goto L33
    }

    public final void writeContacts(String r100, String r101, List<CJContactsCacheModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "bizScene");
        Intrinsics.checkNotNullParameter(r101, "uid");
        Intrinsics.checkNotNullParameter(r102, "contacts");
        CJKVStoreService r103 = (CJKVStoreService) b.b(CJKVStoreService.class);     // Catch: Throwable -> L15
        if (r103 == null) goto L14;
        SharedPreferences r104 = r103.getSharedPreference(SP_NAME, 0);     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L15
        Iterator<T> r106 = r102.iterator();     // Catch: Throwable -> L15
    L10:
        if (r106.hasNext() == false) goto L12;
        CJContactsCacheModel r107 = (CJContactsCacheModel) r106.next();     // Catch: Throwable -> L15
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L15
        r108.put("name", r107.getName());     // Catch: Throwable -> L15
        r108.put(FIELD_PHONE_LIST, new JSONArray(r107.getPhoneNumberList()));     // Catch: Throwable -> L15
        r105.put(r108);     // Catch: Throwable -> L15
        goto L10
    L12:
        r104.edit().putString(buildKey(r100, r101), r105.toString()).apply();     // Catch: Throwable -> L15
        return;
    L21:
        return;
    L14:
        return;
    L15:
        th = move-exception;
        CJLogger.b(TAG, "writeContacts fail: " + th.getMessage());
    }
}
