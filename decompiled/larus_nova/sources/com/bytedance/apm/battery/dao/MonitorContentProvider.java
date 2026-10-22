package com.bytedance.apm.battery.dao;

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
import com.alipay.sdk.m.u.i;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.systemopt.SysPowerKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xr3.b;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, SQLiteOpenHelper> f190315a;

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        getContext().getPackageName();
        return false;
    }

    public MonitorContentProvider() {
        this.f190315a = new HashMap();
    }

    public final synchronized Pair<SQLiteDatabase, String> a(Uri r100) {
        monitor-enter(this);
        List<String> r101 = r100.getPathSegments();     // Catch: Throwable -> L23 Exception -> L28
        if (r101 == null) goto L26;
        if (r101.size() < 2) goto L26;
        String r102 = (String) ListProtector.get(r101, 0);     // Catch: Throwable -> L23 Exception -> L28
        String r103 = (String) ListProtector.get(r101, 1);     // Catch: Throwable -> L23 Exception -> L28
        if (r102 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r104 = (SQLiteOpenHelper) ((HashMap) this.f190315a).get(r102);     // Catch: Throwable -> L23 Exception -> L28
        if (r104 == null) goto L15;
    L20:
        Pair<SQLiteDatabase, String> r105 = new Pair(r104.getWritableDatabase(), r103);     // Catch: Throwable -> L23 Exception -> L28
        monitor-exit(this);
        return r105;
        goto L26
    L15:
        if (r102.contains("apm_monitor_t1.db") == false) goto L18;
        r104 = new b(getContext(), r102);     // Catch: Throwable -> L23 Exception -> L28
        ((HashMap) this.f190315a).put(r102, r104);     // Catch: Throwable -> L23 Exception -> L28
        goto L20
    L18:
        monitor-exit(this);
        return null;
    L23:
        th = move-exception;
        throw th;
    L26:
        monitor-exit(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        Pair<SQLiteDatabase, String> r102 = a(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r103 = (SQLiteDatabase) r102.first;
        if (r103 != null) goto L14;
        return null;
    L14:
        long r104 = r103.insert((String) r102.second, null, r101);     // Catch: Throwable -> L13
        if (r104 < 0) goto L12;
        return ContentUris.withAppendedId(r100, r104);
    L12:
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (r102 == null) goto L5;
        r102.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r100) == false) goto L8;
        Bundle r103 = new Bundle();
        r103.putInt(SysPowerKit.PWR_OVERUSE_PID, Process.myPid());
        return r103;
    L8:
        UriProtector.parse(r100);
        Uri r104 = UriProtector.parse(r100);
        monitor-enter(this);
        List<String> r105 = r104.getPathSegments();     // Catch: Throwable -> L88
        Object r106 = null;
        if (r105 != null) goto L13;
    L23:
        monitor-exit(this);
        Pair r107 = null;
    L25:
        if (r107 != null) goto L28;
        return null;
    L28:
        if ("query".equals(r101) == false) goto L50;
        if (r102 == null) goto L33;
        SpPair r108 = (SpPair) r102.getParcelable(CloudControlInf.SP);
        if (r108 == null) goto L33;
        r106 = r108.f190512b;
    L33:
        SharedPreferences r109 = (SharedPreferences) r107.first;
        String r110 = (String) r107.second;
        Bundle r111 = new Bundle();
        ArrayList<? extends Parcelable> r112 = new ArrayList();
        if (r110 != null) goto L40;
        Iterator<Map.Entry<String, ?>> r113 = r109.getAll().entrySet().iterator();
    L37:
        if (r113.hasNext() == false) goto L39;
        Map.Entry<String, ?> r114 = r113.next();
        r112.add(new SpPair(r114.getKey(), r114.getValue()));
        goto L37
    L39:
        r111.putParcelableArrayList(CloudControlInf.SP, r112);
    L48:
        return r111;
    L40:
        Object r115 = r109.getAll().get(r110);
        if (r115 == null) goto L45;
        r106 = r115;
    L45:
        if ((r106 instanceof Set) == false) goto L47;
        r106 = k.c((Set) r106);
    L47:
        r112.add(new SpPair(r110, r106));
        r111.putParcelableArrayList(CloudControlInf.SP, r112);
        goto L48
    L50:
        if ("contains".equals(r101) == false) goto L54;
        SharedPreferences r116 = (SharedPreferences) r107.first;
        String r117 = (String) r107.second;
        Bundle r118 = new Bundle();
        r118.putBoolean("contains", r116.contains(r117));
        return r118;
    L54:
        if ("edit".equals(r101) == false) goto L87;
        if (r102 == null) goto L87;
        SharedPreferences.Editor r119 = ((SharedPreferences) r107.first).edit();
        if (r102.getBoolean("clear") == false) goto L59;
        r119.clear();
    L59:
        ArrayList r120 = r102.getParcelableArrayList("edit");
        if (r120 == null) goto L87;
        Iterator r121 = r120.iterator();
    L64:
        if (r121.hasNext() == false) goto L86;
        SpPair r122 = (SpPair) r121.next();
        Object r123 = r122.f190512b;
        if (r123 == null) goto L67;
        String r124 = r122.f190511a;
        if ((r123 instanceof String) == true) goto L70;
        if ((r123 instanceof Integer) == true) goto L73;
        if ((r123 instanceof Long) == true) goto L76;
        if ((r123 instanceof Float) == true) goto L79;
        if ((r123 instanceof Boolean) == true) goto L82;
        if ((r123 instanceof String[]) == false) goto L64;
        r119.putStringSet(r124, new HashSet(Arrays.asList((String[]) r123)));
        goto L64
    L82:
        r119.putBoolean(r124, ((Boolean) r123).booleanValue());
        goto L64
    L79:
        r119.putFloat(r124, ((Float) r123).floatValue());
        goto L64
    L76:
        r119.putLong(r124, ((Long) r123).longValue());
        goto L64
    L73:
        r119.putInt(r124, ((Integer) r123).intValue());
        goto L64
    L70:
        r119.putString(r124, (String) r123);
        goto L64
    L67:
        r119.remove(r122.f190511a);
        goto L64
    L86:
        r119.apply();
    L87:
        return null;
    L13:
        if (r105.size() < 2) goto L23;
        if (CloudControlInf.SP.equals(ListProtector.get(r105, 0)) == false) goto L23;
        SharedPreferences r125 = getContext().getSharedPreferences((String) ListProtector.get(r105, 1), 0);     // Catch: Throwable -> L88
        if (r105.size() <= 2) goto L19;
        String r126 = (String) ListProtector.get(r105, 2);     // Catch: Throwable -> L88
    L20:
        r107 = new Pair(r125, r126);     // Catch: Throwable -> L88
        monitor-exit(this);
        goto L25
    L19:
        r126 = null;
    L88:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        Pair<SQLiteDatabase, String> r103 = a(r100);
        if (r103 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r104 = (SQLiteDatabase) r103.first;
        if (r104 != null) goto L11;
        return -1;
    L11:
        return r104.delete((String) r103.second, r101, r102);
    L10:
        return -1;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Pair<SQLiteDatabase, String> r104 = a(r100);
        if (r104 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r105 = (SQLiteDatabase) r104.first;
        if (r105 != null) goto L11;
        return -1;
    L11:
        return r105.update((String) r104.second, r101, r102, r103);
    L10:
        return -1;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r112, String[] r113, String r114) {
        Pair<SQLiteDatabase, String> r115 = a(r110);
        if (r115 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r100 = (SQLiteDatabase) r115.first;
        if (r100 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r114, "rawQuery") == false) goto L13;
        return r100.rawQuery(r112, r113);
    L13:
        if (TextUtils.equals(r114, "execSQL") == false) goto L21;
        String[] r116 = r112.split(i.f25853b);
        int r117 = r116.length;
        int r118 = 0;
    L15:
        if (r118 >= r117) goto L20;
        String r119 = r116[r118];
        if (TextUtils.isEmpty(r119) == true) goto L19;
        r100.execSQL(r119);
    L19:
        r118 = r118 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r101 = new SQLiteQueryBuilder();
        r101.setTables((String) r115.second);
        return r101.query(r100, r111, r112, r113, null, null, r114);
    }
}
