package com.bytedance.apm.battery.dao;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
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
import com.bytedance.apm.util.j;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends PluginContentProvider {
    public static String AUTHORITY;
    private final Map<String, SQLiteOpenHelper> mDBHelpers;

    public String getType(Uri r1) {
        return null;
    }

    public MonitorContentProvider() {
        this.mDBHelpers = new HashMap();
    }

    private synchronized Pair<SQLiteDatabase, String> parseUri(Uri r7) {
        monitor-enter(this);
        List<String> r8 = r7.getPathSegments();     // Catch: Throwable -> L23 Exception -> L28
        if (r8 == null) goto L26;
        if (r8.size() < 2) goto L26;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r8.get(0), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23 Exception -> L28
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get(1), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23 Exception -> L28
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r2 = (SQLiteOpenHelper) ZeusTransformUtils.preCheckCast(this.mDBHelpers.get(r1), SQLiteOpenHelper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23 Exception -> L28
        if (r2 == null) goto L15;
    L20:
        Pair<SQLiteDatabase, String> r3 = new Pair(r2.getWritableDatabase(), r9);     // Catch: Throwable -> L23 Exception -> L28
        monitor-exit(this);
        return r3;
        goto L26
    L15:
        if (r1.contains(DBHelper.DB_NAME) == false) goto L18;
        r2 = new DBHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);     // Catch: Throwable -> L23 Exception -> L28
        this.mDBHelpers.put(r1, r2);     // Catch: Throwable -> L23 Exception -> L28
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

    private synchronized Pair<SharedPreferences, String> parseMethod(Uri r9) {
        monitor-enter(this);
        List<String> r10 = r9.getPathSegments();     // Catch: Throwable -> L17
        String r0 = null;
        if (r10 != null) goto L6;
    L15:
        monitor-exit(this);
        return null;
    L6:
        if (r10.size() < 2) goto L15;
        if ("sp".equals(r10.get(0)) == false) goto L15;
        SharedPreferences r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSharedPreferences((String) ZeusTransformUtils.preCheckCast(r10.get(1), String.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L17
        if (r10.size() <= 2) goto L12;
        r0 = (String) ZeusTransformUtils.preCheckCast(r10.get(2), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L12:
        Pair<SharedPreferences, String> r1 = new Pair(r3, r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    public boolean onCreate() {
        AUTHORITY = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName() + ".apm";
        return false;
    }

    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        Pair<SQLiteDatabase, String> r0 = parseUri(r9);
        if (r0 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r2 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(r0.first, SQLiteDatabase.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r13, "rawQuery") == false) goto L13;
        return r2.rawQuery(r11, r12);
    L13:
        if (TextUtils.equals(r13, "execSQL") == false) goto L21;
        String[] r1 = r11.split(";");
        int r3 = r1.length;
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L20;
        String r5 = r1[r4];
        if (TextUtils.isEmpty(r5) == true) goto L19;
        r2.execSQL(r5);
    L19:
        r4 = r4 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r6 = new SQLiteQueryBuilder();
        r6.setTables((String) ZeusTransformUtils.preCheckCast(r0.second, String.class, "com.obric.aiagent.plugin"));
        return r6.query(r2, r10, r11, r12, null, null, r13);
    }

    private Bundle querySP(SharedPreferences r6, String r7, Object r8) {
        SharedPreferences r5 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r6, SharedPreferences.class, "com.obric.aiagent.plugin");
        Bundle r9 = new Bundle();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        if (r7 != null) goto L9;
        Iterator<Map.Entry<String, ?>> r10 = r5.getAll().entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r1.add(new SpPair((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin"), r11.getValue()));
        goto L6
    L8:
        r9.putParcelableArrayList("sp", r1);
    L17:
        return r9;
    L9:
        Object r12 = r5.getAll().get(r7);
        if (r12 == null) goto L14;
        r8 = r12;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == false) goto L16;
        r8 = j.a((Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.aiagent.plugin"));
    L16:
        r1.add(new SpPair(r7, r8));
        r9.putParcelableArrayList("sp", r1);
        goto L17
    }

    public Bundle call(String r4, String r5, Bundle r6) {
        if (r6 == null) goto L5;
        r6.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r4) == true) goto L7;
        Uri.parse(r4);
        Pair<SharedPreferences, String> r7 = parseMethod(Uri.parse(r4));
        Object r0 = null;
        if (r7 != null) goto L12;
        return null;
    L12:
        if (DownloadConstants.QUERY_KEY.equals(r5) == false) goto L20;
        if (r6 == null) goto L18;
        SpPair r8 = (SpPair) ZeusTransformUtils.preCheckCast(r6.getParcelable("sp"), SpPair.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L18;
        r0 = r8.mValue;
    L18:
        return querySP((SharedPreferences) ZeusTransformUtils.preCheckCast(r7.first, SharedPreferences.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.second, String.class, "com.obric.aiagent.plugin"), r0);
    L20:
        if ("contains".equals(r5) == false) goto L24;
        return containsSP((SharedPreferences) ZeusTransformUtils.preCheckCast(r7.first, SharedPreferences.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.second, String.class, "com.obric.aiagent.plugin"));
    L24:
        if ("edit".equals(r5) == false) goto L27;
        if (r6 == null) goto L27;
        editSP((SharedPreferences) ZeusTransformUtils.preCheckCast(r7.first, SharedPreferences.class, "com.obric.aiagent.plugin"), r6);
    L27:
        return null;
    L7:
        return getPID();
    }

    private Bundle containsSP(SharedPreferences r2, String r3) {
        SharedPreferences r1 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.aiagent.plugin");
        Bundle r4 = new Bundle();
        r4.putBoolean("contains", r1.contains(r3));
        return r4;
    }

    private Bundle getPID() {
        Bundle r2 = new Bundle();
        r2.putInt("Pid", Process.myPid());
        return r2;
    }

    private void editSP(SharedPreferences r3, Bundle r4) {
        SharedPreferences.Editor r2 = ((SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.aiagent.plugin")).edit();
        if (r4.getBoolean("clear") == false) goto L5;
        r2.clear();
    L5:
        ArrayList r5 = r4.getParcelableArrayList("edit");
        if (r5 != null) goto L8;
        return;
    L8:
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        SpPair r7 = (SpPair) ZeusTransformUtils.preCheckCast(r6.next(), SpPair.class, "com.obric.aiagent.plugin");
        if (r7.mValue == null) goto L13;
        edit(r2, r7.mKey, r7.mValue);
        goto L10
    L13:
        r2.remove(r7.mKey);
        goto L10
    L15:
        r2.apply();
    }

    private static void edit(SharedPreferences.Editor r3, String r4, Object r5) {
        SharedPreferences.Editor r6 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L6;
        r6.putString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L9;
        r6.putInt(r4, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L12;
        r6.putLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L15;
        r6.putFloat(r4, ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.aiagent.plugin")).floatValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L18;
        r6.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L18:
        if ((r5 instanceof String[]) == false) goto L26;
        r6.putStringSet(r4, new HashSet(Arrays.asList((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin"))));
        return;
    }

    public Uri insert(Uri r6, ContentValues r7) {
        Pair<SQLiteDatabase, String> r5 = parseUri(r6);
        if (r5 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r1 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(r5.first, SQLiteDatabase.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L14;
        return null;
    L14:
        long r2 = r1.insert((String) ZeusTransformUtils.preCheckCast(r5.second, String.class, "com.obric.aiagent.plugin"), null, r7);     // Catch: Throwable -> L13
        if (r2 < 0) goto L12;
        return ContentUris.withAppendedId(r6, r2);
    L12:
        return null;
    }

    public int delete(Uri r4, String r5, String[] r6) {
        Pair<SQLiteDatabase, String> r3 = parseUri(r4);
        if (r3 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r0 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(r3.first, SQLiteDatabase.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.delete((String) ZeusTransformUtils.preCheckCast(r3.second, String.class, "com.obric.aiagent.plugin"), r5, r6);
    L10:
        return -1;
    }

    public int update(Uri r4, ContentValues r5, String r6, String[] r7) {
        Pair<SQLiteDatabase, String> r3 = parseUri(r4);
        if (r3 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r0 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(r3.first, SQLiteDatabase.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.update((String) ZeusTransformUtils.preCheckCast(r3.second, String.class, "com.obric.aiagent.plugin"), r5, r6, r7);
    L10:
        return -1;
    }

    public static void execSQLForResolver(Context r7, Uri r8, String r9) {
        ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r8, null, r9, null, "execSQL", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return;
    }

    public static Cursor rawQueryForResolver(Context r7, Uri r8, String r9, String[] r10) {
        return ZeusProviderTransform.query(((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r8, null, r9, r10, "rawQuery", "com.obric.aiagent.plugin");
    L5:
        return null;
    }
}
