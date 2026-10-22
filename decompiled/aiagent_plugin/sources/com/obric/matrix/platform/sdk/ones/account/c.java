package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import d.h.b.o;

/* JADX INFO: compiled from: AccountInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final b a(b r5, Bundle r6) {
        o.e(r5, "<this>");
        o.e(r6, "bundle");
        r5.a(r6.getBoolean("loginState", false));
        r5.a(r6.getInt("logoutScene", 0));
        String r0 = r6.getString("secUserId", "");
        o.c(r0, "bundle.getString(Account…undleKey.SEC_USER_ID, \"\")");
        r5.a(r0);
        String r1 = r6.getString("userId", "");
        o.c(r1, "bundle.getString(AccountInfoBundleKey.USER_ID, \"\")");
        r5.b(r1);
        r5.b(r6.getInt("odinUserType", 0));
        String r2 = r6.getString("token", "");
        o.c(r2, "bundle.getString(AccountInfoBundleKey.TOKEN, \"\")");
        r5.c(r2);
        String r3 = r6.getString("innerSsoToken", "");
        o.c(r3, "bundle.getString(Account…eKey.INNER_SSO_TOKEN, \"\")");
        r5.d(r3);
        String r4 = r6.getString("avatarUrl", "");
        o.c(r4, "bundle.getString(Account…BundleKey.AVATAR_URL, \"\")");
        r5.e(r4);
        r5.c(r6.getInt("countryCode", 86));
        String r7 = r6.getString("userName", "");
        o.c(r7, "bundle.getString(Account…oBundleKey.USER_NAME, \"\")");
        r5.f(r7);
        String r8 = r6.getString("screenName", "");
        o.c(r8, "bundle.getString(Account…undleKey.SCREEN_NAME, \"\")");
        r5.g(r8);
        String r9 = r6.getString("userEmail", "");
        o.c(r9, "bundle.getString(Account…BundleKey.USER_EMAIL, \"\")");
        r5.h(r9);
        String r10 = r6.getString("userMobile", "");
        o.c(r10, "bundle.getString(Account…undleKey.USER_MOBILE, \"\")");
        r5.i(r10);
        r5.b(r6.getBoolean("hasPassword", false));
        r5.d(r6.getInt("userGender", 0));
        r5.c(r6.getBoolean("isNewUser", false));
        String r11 = r6.getString("userSession", "");
        o.c(r11, "bundle.getString(Account…ndleKey.USER_SESSION, \"\")");
        r5.j(r11);
        r5.a(r6.getLong("loginUtcTime", 0));
        String r12 = r6.getString("loginPhoneNumber", "");
        o.c(r12, "bundle.getString(Account…y.LOGIN_PHONE_NUMBER, \"\")");
        r5.k(r12);
        return r5;
    }
}
