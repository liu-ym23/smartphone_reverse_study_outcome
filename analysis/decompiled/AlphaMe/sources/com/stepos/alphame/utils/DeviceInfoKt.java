package com.stepos.alphame.utils;

import B0.f;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import l1.g;
import o2.C0808a;
import o2.C0809b;
import o2.d;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"getOaid", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceInfoKt {
    @Nullable
    public static final String getOaid() throws Throwable {
        Context context;
        g gVarA;
        String str;
        ApplicationImpl application = ApplicationImpl.getApplication();
        String str2 = "";
        if (application == null) {
            return "";
        }
        String str3 = null;
        str3 = null;
        str3 = null;
        str3 = null;
        cursor = null;
        Cursor cursor = null;
        str3 = null;
        str3 = null;
        str3 = null;
        try {
            if (f.f144a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                f.f144a = method;
                method.setAccessible(true);
            }
            context = (Context) f.f144a.invoke(null, null);
        } catch (Exception e4) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e4.toString());
            context = null;
        }
        if (context != null && d.c().e(context, false)) {
            d dVarC = d.c();
            Context applicationContext = application.getApplicationContext();
            C0808a c0808a = (C0808a) dVarC.f13797b;
            if (c0808a != null) {
                if (c0808a.f13789b > System.currentTimeMillis()) {
                    str3 = (String) c0808a.f13790c;
                } else if (dVarC.e(applicationContext, true) && (gVarA = dVarC.a(applicationContext)) != null && gVarA.f13460b) {
                    try {
                        try {
                            Cursor cursorQuery = applicationContext.getContentResolver().query(Uri.parse((String) gVarA.f13462d), null, null, new String[]{(String) c0808a.f13791d}, null);
                            try {
                                try {
                                    if (cursorQuery != null) {
                                        C0809b c0809bB = d.b(cursorQuery);
                                        str = (String) c0809bB.f13794c;
                                        try {
                                            c0808a.f13790c = str;
                                            c0808a.f13789b = c0809bB.f13792a;
                                            int i4 = c0809bB.f13793b;
                                            c0808a.f13788a = i4;
                                            if (i4 != 1000) {
                                                dVarC.d(applicationContext, (String) gVarA.f13461c);
                                                if (!dVarC.e(applicationContext, false)) {
                                                    dVarC.e(applicationContext, true);
                                                }
                                            }
                                            str3 = str;
                                        } catch (Exception e5) {
                                            e = e5;
                                            cursor = cursorQuery;
                                            e.getMessage();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            str3 = str;
                                            if (!TextUtils.isEmpty(str3)) {
                                                str2 = str3;
                                            }
                                            AlphaMeLogger.dLog("oaid " + str2);
                                            return str2;
                                        }
                                    } else if (dVarC.e(applicationContext, false)) {
                                        dVarC.e(applicationContext, true);
                                    }
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = cursorQuery;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                str = str3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str = null;
                    }
                }
            }
        } else {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3) && (str3 == null || !StringsKt.c(str3, "00000000000000000000000000000000"))) {
            str2 = str3;
        }
        AlphaMeLogger.dLog("oaid " + str2);
        return str2;
    }
}
