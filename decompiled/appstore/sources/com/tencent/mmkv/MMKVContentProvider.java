package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class MMKVContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Uri f18209a;

    public MMKVContentProvider() {
    }

    public static Uri a(Context r10) {
        Uri r11 = f18209a;
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        String r12 = d(r10);
        if (r12 != null) goto L11;
        return null;
    L11:
        Uri r13 = Uri.parse(CommonColumns.SCHEME + r12);
        f18209a = r13;
        return r13;
    }

    public static String b(Context r10, int r11) {
        ActivityManager r12 = (ActivityManager) r10.getSystemService("activity");
        if (r12 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r12.getRunningAppProcesses().iterator();
    L6:
        if (r13.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();
        if (r14.pid != r11) goto L6;
        return r14.processName;
    L16:
        return "";
    L11:
        return "";
    }

    public static String d(Context r10) {
        ComponentName r11 = new ComponentName(r10, MMKVContentProvider.class.getName());     // Catch: Exception -> L8
        PackageManager r12 = r10.getPackageManager();     // Catch: Exception -> L8
        if (r12 == null) goto L14;
        ProviderInfo r13 = r12.getProviderInfo(r11, 0);     // Catch: Exception -> L8
        if (r13 == null) goto L15;
        return r13.authority;
    L15:
        return null;
    L14:
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final Bundle c(String r10, int r11, int r12, String r13) {
        MMKV r14 = MMKV.n(getContext(), r10, r11, r12, r13);
        if (r14 == null) goto L6;
        ParcelableMMKV r15 = new ParcelableMMKV(r14);
        Log.i("MMKV", r10 + " fd = " + r14.ashmemFD() + ", meta fd = " + r14.ashmemMetaFD());
        Bundle r16 = new Bundle();
        r16.putParcelable("KEY", r15);
        return r16;
    L6:
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        if (r10.equals("mmkvFromAshmemID") == false) goto L7;
        if (r12 != null) goto L6;
        return null;
    L6:
        return c(r11, r12.getInt("KEY_SIZE"), r12.getInt("KEY_MODE"), r12.getString("KEY_CRYPT"));
    L7:
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context r10 = getContext();
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = d(r10);
        if (r11 != null) goto L9;
        return false;
    L9:
        if (f18209a != null) goto L13;
        f18209a = Uri.parse(CommonColumns.SCHEME + r11);
        return true;
    L13:
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
