package com.bytedance.apm.battery.dao;

import a1.a;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.ListUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6359b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6360a;

    public MonitorContentProvider() {
        this.f6360a = new HashMap();
    }

    public static void b(SharedPreferences.Editor r10, String r11, Object r12) {
        if ((r12 instanceof String) == false) goto L6;
        r10.putString(r11, (String) r12);
        return;
    L6:
        if ((r12 instanceof Integer) == false) goto L9;
        r10.putInt(r11, ((Integer) r12).intValue());
        return;
    L9:
        if ((r12 instanceof Long) == false) goto L12;
        r10.putLong(r11, ((Long) r12).longValue());
        return;
    L12:
        if ((r12 instanceof Float) == false) goto L15;
        r10.putFloat(r11, ((Float) r12).floatValue());
        return;
    L15:
        if ((r12 instanceof Boolean) == false) goto L18;
        r10.putBoolean(r11, ((Boolean) r12).booleanValue());
        return;
    L18:
        if ((r12 instanceof String[]) == false) goto L26;
        r10.putStringSet(r11, new HashSet(Arrays.asList((String[]) r12)));
        return;
    }

    public final Bundle a(SharedPreferences r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putBoolean("contains", r10.contains(r11));
        return r12;
    }

    public final void c(SharedPreferences r10, Bundle r11) {
        SharedPreferences.Editor r12 = r10.edit();
        if (r11.getBoolean("clear") == false) goto L5;
        r12.clear();
    L5:
        ArrayList r13 = r11.getParcelableArrayList("edit");
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        SpPair r15 = (SpPair) r14.next();
        Object r16 = r15.mValue;
        if (r16 == null) goto L13;
        b(r12, r15.mKey, r16);
        goto L10
    L13:
        r12.remove(r15.mKey);
        goto L10
    L15:
        r12.apply();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        if (r12 == null) goto L5;
        r12.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r10) == true) goto L7;
        Uri.parse(r10);
        Pair r13 = e(Uri.parse(r10));
        Object r14 = null;
        if (r13 != null) goto L12;
        return null;
    L12:
        if ("query".equals(r11) == false) goto L20;
        if (r12 == null) goto L18;
        SpPair r15 = (SpPair) r12.getParcelable(CloudControlInf.SP);
        if (r15 == null) goto L18;
        r14 = r15.mValue;
    L18:
        return g((SharedPreferences) r13.first, (String) r13.second, r14);
    L20:
        if ("contains".equals(r11) == false) goto L24;
        return a((SharedPreferences) r13.first, (String) r13.second);
    L24:
        if ("edit".equals(r11) == false) goto L27;
        if (r12 == null) goto L27;
        c((SharedPreferences) r13.first, r12);
    L27:
        return null;
    L7:
        return d();
    }

    public final Bundle d() {
        Bundle r10 = new Bundle();
        r10.putInt("Pid", Process.myPid());
        return r10;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        Pair r13 = f(r10);
        if (r13 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r14 = (SQLiteDatabase) r13.first;
        if (r14 != null) goto L11;
        return -1;
    L11:
        return r14.delete((String) r13.second, r11, r12);
    L10:
        return -1;
    }

    public final synchronized Pair e(Uri r10) {
        monitor-enter(this);
        List<String> r11 = r10.getPathSegments();     // Catch: Throwable -> L12
        String r12 = null;
        if (r11 != null) goto L6;
    L17:
        monitor-exit(this);
        return null;
    L6:
        if (r11.size() < 2) goto L17;
        if (CloudControlInf.SP.equals(r11.get(0)) == false) goto L17;
        SharedPreferences r13 = getContext().getSharedPreferences(r11.get(1), 0);     // Catch: Throwable -> L12
        if (r11.size() <= 2) goto L14;
        r12 = r11.get(2);     // Catch: Throwable -> L12
    L14:
        Pair r14 = new Pair(r13, r12);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r14;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair f(Uri r10) {
        monitor-enter(this);
        List<String> r11 = r10.getPathSegments();     // Catch: Throwable -> L18 Exception -> L29
        if (r11 == null) goto L27;
        if (r11.size() < 2) goto L27;
        String r12 = r11.get(0);     // Catch: Throwable -> L18 Exception -> L29
        String r13 = r11.get(1);     // Catch: Throwable -> L18 Exception -> L29
        if (r12 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r14 = (SQLiteOpenHelper) this.f6360a.get(r12);     // Catch: Throwable -> L18 Exception -> L29
        if (r14 == null) goto L15;
    L22:
        Pair r15 = new Pair(r14.getWritableDatabase(), r13);     // Catch: Throwable -> L18 Exception -> L29
        monitor-exit(this);
        return r15;
        goto L27
    L15:
        if (r12.contains("apm_monitor_t1.db") == false) goto L20;
        r14 = new a(getContext(), r12);     // Catch: Throwable -> L18 Exception -> L29
        this.f6360a.put(r12, r14);     // Catch: Throwable -> L18 Exception -> L29
        goto L22
    L20:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    L27:
        monitor-exit(this);
        return null;
    }

    public final Bundle g(SharedPreferences r10, String r11, Object r12) {
        Bundle r13 = new Bundle();
        ArrayList<? extends Parcelable> r14 = new ArrayList();
        if (r11 != null) goto L9;
        Iterator<Map.Entry<String, ?>> r15 = r10.getAll().entrySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        Map.Entry<String, ?> r16 = r15.next();
        r14.add(new SpPair(r16.getKey(), r16.getValue()));
        goto L6
    L8:
        r13.putParcelableArrayList(CloudControlInf.SP, r14);
    L17:
        return r13;
    L9:
        Object r17 = r10.getAll().get(r11);
        if (r17 == null) goto L14;
        r12 = r17;
    L14:
        if ((r12 instanceof Set) == false) goto L16;
        r12 = ListUtils.e((Set) r12);
    L16:
        r14.add(new SpPair(r11, r12));
        r13.putParcelableArrayList(CloudControlInf.SP, r14);
        goto L17
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        Pair r12 = f(r10);
        if (r12 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r13 = (SQLiteDatabase) r12.first;
        if (r13 != null) goto L14;
        return null;
    L14:
        long r14 = r13.insert((String) r12.second, null, r11);     // Catch: Throwable -> L13
        if (r14 < 0) goto L12;
        return ContentUris.withAppendedId(r10, r14);
    L12:
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f6359b = getContext().getPackageName() + ".apm";
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Pair r15 = f(r10);
        if (r15 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r16 = (SQLiteDatabase) r15.first;
        if (r16 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r14, "rawQuery") == false) goto L13;
        return r16.rawQuery(r12, r13);
    L13:
        if (TextUtils.equals(r14, "execSQL") == false) goto L21;
        String[] r17 = r12.split(";");
        int r18 = r17.length;
        int r19 = 0;
    L15:
        if (r19 >= r18) goto L20;
        String r110 = r17[r19];
        if (TextUtils.isEmpty(r110) == true) goto L19;
        r16.execSQL(r110);
    L19:
        r19 = r19 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r20 = new SQLiteQueryBuilder();
        r20.setTables((String) r15.second);
        return r20.query(r16, r11, r12, r13, null, null, r14);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        Pair r14 = f(r10);
        if (r14 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r15 = (SQLiteDatabase) r14.first;
        if (r15 != null) goto L11;
        return -1;
    L11:
        return r15.update((String) r14.second, r11, r12, r13);
    L10:
        return -1;
    }
}
