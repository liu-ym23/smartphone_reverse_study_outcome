package com.android.contacts.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.util.HanziToPinyin;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FreeCallHelper {
    public static final String MIMETYPE = "mimetype_freecall";
    private static FreeCallHelper sMe;
    HashMap<String, Boolean> mCacheMap;
    private Context mContext;

    private FreeCallHelper() {
        this.mCacheMap = new HashMap();
        this.mContext = ContactsApplication.getInstance().getApplicationContext();
    }

    public static FreeCallHelper getMe() {
        if (sMe != null) goto L6;
        sMe = new FreeCallHelper();
    L6:
        return sMe;
    }

    public boolean isSupportFreeCall(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        String r5 = r4.replace("-", "").replace(HanziToPinyin.Token.SEPARATOR, "");
        Boolean r3 = this.mCacheMap.get(r5);
        log("isSupportFreeCall, " + r5 + ", " + r3);
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.booleanValue();
    }

    public void updateCache(String[] r5, boolean[] r6) {
        if (r5 == null) goto L11;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r5.length > r6.length) goto L14;
        int r0 = 0;
    L9:
        if (r0 >= r5.length) goto L15;
        this.mCacheMap.put(r5[r0], Boolean.valueOf(r6[r0]));
        r0 = r0 + 1;
        goto L9
    L15:
        return;
    L14:
        return;
    }

    public void updateCache(String r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mCacheMap.put(r1, Boolean.valueOf(r2));
    }

    public static Intent getFreeCallIntent(String r3) {
        Intent r0 = new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts("smvoip", r3, null));
        r0.setFlags(268435456);
        return r0;
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("FreeCallHelper", r1);
        return;
    }
}
