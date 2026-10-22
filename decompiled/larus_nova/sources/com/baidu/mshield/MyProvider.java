package com.baidu.mshield;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.c;
import com.facebook.keyframes.model.KFAnimation;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class MyProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32357a;

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f32357a = true;
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public MyProvider() {
    }

    public static boolean a() {
        return f32357a;
    }

    public final HashMap<String, String> a(Bundle r100) {
        HashMap<String, String> r101 = new HashMap();
    L10:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L12:
        return r101;
    L4:
        if (r100.size() <= 0) goto L12;
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Throwable -> L10
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L10
        r101.put(r103, r100.getString(r103));     // Catch: Throwable -> L10
        goto L7
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r110) {
        String r102 = getCallingPackage();     // Catch: Throwable -> L40
        if (r102 == null) goto L9;
        if (r102.equals(getContext().getPackageName()) == true) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        Bundle r103 = new Bundle();     // Catch: Throwable -> L40
        if ("init".equals(r100) == false) goto L16;
        r103.putString("result", MH.init(getContext(), a(r110)));     // Catch: Throwable -> L40
        r103.putBoolean("handle_flag", true);     // Catch: Throwable -> L40
    L38:
        r103.putString("server_version", "4.2.9");     // Catch: Throwable -> L40
        return r103;
    L16:
        if ("gzfi".equals(r100) == false) goto L19;
        String r104 = r110.getString("accountId", "");     // Catch: Throwable -> L40
        int r105 = r110.getInt("scene", 0);     // Catch: Throwable -> L40
        String r106 = r110.getString("para", "");     // Catch: Throwable -> L40
        Bundle r111 = r110.getBundle(KFAnimation.PROPERTY_TYPE_JSON_FIELD);     // Catch: Throwable -> L40
        r103.putString("result", MH.gzfi(getContext(), r104, r105, r106, a(r111)));     // Catch: Throwable -> L40
        r103.putBoolean("handle_flag", true);     // Catch: Throwable -> L40
        goto L38
    L19:
        if ("getRemoteZid".equals(r100) == false) goto L24;
        String r107 = c.b(getContext());     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r107) == true) goto L38;
        r103.putString("_zid", r107);     // Catch: Throwable -> L40
        r103.putBoolean("handle_flag", true);     // Catch: Throwable -> L40
        goto L38
    L24:
        if ("setAgreePolicy".equals(r100) == false) goto L27;
        com.baidu.mshield.core.a.a(r110.getBoolean("_agree_policy"));     // Catch: Throwable -> L40
        goto L38
    L27:
        if ("ud".equals(r100) == false) goto L30;
        HashMap<String, String> r108 = a(r110);     // Catch: Throwable -> L40
        MH.ud(getContext(), r108);     // Catch: Throwable -> L40
        goto L38
    L30:
        if ("setAppStatus".equals(r100) == false) goto L33;
        com.baidu.mshield.core.a.b(r110.getBoolean("_app_status"));     // Catch: Throwable -> L40
        goto L38
    L33:
        if ("CallPreferences".equals(r100) == false) goto L38;
        Bundle r109 = com.baidu.mshield.sharedpreferences.a.a(getContext()).a(r110);     // Catch: Throwable -> L40
        if (r109 != null) goto L37;
        r109 = new Bundle();     // Catch: Throwable -> L40
    L37:
        r103 = r109;
        r103.putBoolean("handle_flag", true);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }
}
