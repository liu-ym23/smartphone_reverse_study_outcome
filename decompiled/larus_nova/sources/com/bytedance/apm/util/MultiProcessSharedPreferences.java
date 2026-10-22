package com.bytedance.apm.util;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f190628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f190629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f190630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f190631d;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f190632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Object> f190633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MultiProcessSharedPreferences f190634c;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            if (this.f190632a == false) goto L5;
        L7:
            Bundle r100 = new Bundle();
            if (this.f190632a == false) goto L10;
            r100.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r101 = new ArrayList(this.f190633b.size());
            Iterator<Map.Entry<String, Object>> r102 = this.f190633b.entrySet().iterator();
        L12:
            if (r102.hasNext() == false) goto L14;
            Map.Entry<String, Object> r103 = r102.next();
            r101.add(new SpPair(r103.getKey(), r103.getValue()));
            goto L12
        L14:
            r100.putParcelableArrayList("edit", r101);
            ContentResolver r104 = this.f190634c.f190629b.getContentResolver();     // Catch: Exception -> L17
            MultiProcessSharedPreferences r105 = this.f190634c;     // Catch: Exception -> L17
            r104.call(r105.f190631d, r105.f190630c, "edit", r100);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            av3.b.c("MultiProcessSharedPref", "apply exception: ", e);
            return;
        L5:
            if (this.f190633b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f190633b.clear();
            this.f190632a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            apply();
            return true;
        }

        public a(MultiProcessSharedPreferences r100) {
            this.f190634c = r100;
            this.f190632a = false;
            this.f190633b = new HashMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f190633b.put(r100, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            this.f190633b.put(r100, Boolean.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            this.f190633b.put(r100, Float.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            this.f190633b.put(r100, Integer.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            this.f190633b.put(r100, Long.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            this.f190633b.put(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            this.f190633b.put(r100, xu3.e.d(r101));
            return this;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        ArrayList<SpPair> r100 = b(null, null);
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator<SpPair> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        SpPair r103 = r102.next();
        r101.put(r103.f190635a, r103.f190636b);
        goto L7
    L9:
        return r101;
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
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f190628a = getContext().getContentResolver();
        return false;
    }

    public MultiProcessSharedPreferences() {
    }

    public MultiProcessSharedPreferences(Application r100) {
        this.f190629b = r100;
        String r101 = r100.getPackageName();
        String r102 = MultiProcessSharedPreferences.class.getName();
        if (StringUtils.isEmpty(r102) == false) goto L24;
    L12:
        String r103 = null;
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        Uri r104 = UriProtector.parse("content://" + r101 + ".apm6");
    L19:
        Uri r105 = r104.buildUpon().appendPath(CloudControlInf.SP).appendPath("apm_config").build();
        this.f190631d = r105;
        this.f190630c = r105.toString();
        if (xu3.a.a() == false) goto L28;
        av3.b.a("MultiProcessSharedPref", "getSpUri is " + r105);
        return;
    L28:
        return;
    L16:
        r104 = UriProtector.parse("content://" + r103);
        if (xu3.a.a() == false) goto L19;
        av3.b.a("MultiProcessSharedPref", "authority is " + r104);
        goto L19
    L24:
        ProviderInfo[] r106 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L23
        int r107 = r106.length;     // Catch: Exception -> L23
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L12;
        ProviderInfo r109 = r106[r108];     // Catch: Exception -> L23
        if (r102.equals(r109.name) == true) goto L9;
        r108 = r108 + 1;
        goto L6
    L9:
        r103 = r109.authority;     // Catch: Exception -> L23
        goto L14
    }

    public static MultiProcessSharedPreferences c(Context r100) {
        if ((r100 instanceof Application) == false) goto L5;
        Application r101 = (Application) r100;
    L7:
        return new MultiProcessSharedPreferences(r101);
    L5:
        r101 = (Application) r100.getApplicationContext();
        goto L7
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        if (this.f190631d != null) goto L5;
        return false;
    L5:
        Bundle r101 = null;
        ContentResolver r102 = this.f190629b.getContentResolver();     // Catch: Throwable -> L12
        Uri r103 = this.f190631d;     // Catch: Throwable -> L12
        if (r100 == null) goto L9;
        String r104 = this.f190630c + HTTP.URL_DEFAULT + r100;     // Catch: Throwable -> L12
    L10:
        r101 = r102.call(r103, r104, "contains", null);     // Catch: Throwable -> L12
    L14:
        if (r101 != null) goto L16;
        return false;
    L16:
        if (r101.getBoolean("contains") == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        r104 = this.f190630c;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        av3.b.c("APM-AsyncTask", "contains", th);
        goto L14
    }

    public static void a(SharedPreferences r100, Bundle r101) {
        SharedPreferences.Editor r102 = r100.edit();
        if (r101.getBoolean("clear") == false) goto L5;
        r102.clear();
    L5:
        ArrayList r103 = r101.getParcelableArrayList("edit");
        if (r103 != null) goto L8;
        return;
    L8:
        Iterator r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L32;
        SpPair r105 = (SpPair) r104.next();
        Object r106 = r105.f190636b;
        if (r106 == null) goto L13;
        String r107 = r105.f190635a;
        if ((r106 instanceof String) == true) goto L16;
        if ((r106 instanceof Integer) == true) goto L19;
        if ((r106 instanceof Long) == true) goto L22;
        if ((r106 instanceof Float) == true) goto L25;
        if ((r106 instanceof Boolean) == true) goto L28;
        if ((r106 instanceof String[]) == false) goto L10;
        r102.putStringSet(r107, new HashSet(Arrays.asList((String[]) r106)));
        goto L10
    L28:
        r102.putBoolean(r107, ((Boolean) r106).booleanValue());
        goto L10
    L25:
        r102.putFloat(r107, ((Float) r106).floatValue());
        goto L10
    L22:
        r102.putLong(r107, ((Long) r106).longValue());
        goto L10
    L19:
        r102.putInt(r107, ((Integer) r106).intValue());
        goto L10
    L16:
        r102.putString(r107, (String) r106);
        goto L10
    L13:
        r102.remove(r105.f190635a);
        goto L10
    L32:
        r102.commit();
    }

    public final ArrayList<SpPair> b(String r100, Object r101) {
        Bundle r102 = new Bundle();
        if (r101 == null) goto L21;
        r102.putParcelable(CloudControlInf.SP, new SpPair(r100, r101));
    L21:
        ContentResolver r103 = this.f190629b.getContentResolver();     // Catch: Exception -> L16
        Uri r104 = this.f190631d;     // Catch: Exception -> L16
        if (r100 == null) goto L9;
        String r105 = this.f190630c + HTTP.URL_DEFAULT + r100;     // Catch: Exception -> L16
    L11:
        if (r101 != null) goto L14;
        r102 = null;
    L14:
        Bundle r106 = r103.call(r104, r105, "query", r102);     // Catch: Exception -> L16
    L17:
        if (r106 != null) goto L19;
        return null;
    L19:
        r106.setClassLoader(getClass().getClassLoader());
        return r106.getParcelableArrayList(CloudControlInf.SP);
    L9:
        r105 = this.f190630c;     // Catch: Exception -> L16
    L16:
        r106 = null;
        goto L17
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        ArrayList<SpPair> r102 = b(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190636b;
        if ((r103 instanceof Boolean) == false) goto L10;
        return ((Boolean) r103).booleanValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Boolean.valueOf((String) r103).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        ArrayList<SpPair> r102 = b(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190636b;
        if ((r103 instanceof Float) == false) goto L10;
        return ((Float) r103).floatValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return CastFloatProtector.valueOf((String) r103).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        ArrayList<SpPair> r102 = b(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190636b;
        if ((r103 instanceof Integer) == false) goto L10;
        return ((Integer) r103).intValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Integer.decode((String) r103).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        ArrayList<SpPair> r102 = b(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190636b;
        if ((r103 instanceof Long) == false) goto L10;
        return ((Long) r103).longValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Long.decode((String) r103).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        ArrayList<SpPair> r102 = b(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (String) ((SpPair) ListProtector.get(r102, 0)).f190636b;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        ArrayList<SpPair> r102 = b(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (((SpPair) ListProtector.get(r102, 0)).f190636b != null) goto L8;
        return null;
    L8:
        String[] r103 = (String[]) ((SpPair) ListProtector.get(r102, 0)).f190636b;
        HashSet r104 = new HashSet(r103.length);
        r104.addAll(Arrays.asList(r103));
        return r104;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r110) {
        if (r110 == null) goto L4;
        r110.setClassLoader(getClass().getClassLoader());
    L4:
        Uri r102 = UriProtector.parse(r100);
        monitor-enter(this);
        List<String> r103 = r102.getPathSegments();     // Catch: Throwable -> L57
        Object r104 = null;
        if (r103 != null) goto L9;
    L19:
        monitor-exit(this);
        Pair r105 = null;
    L21:
        if (r105 != null) goto L24;
        return null;
    L24:
        if ("query".equals(r101) == false) goto L46;
        if (r110 == null) goto L29;
        SpPair r106 = (SpPair) r110.getParcelable(CloudControlInf.SP);
        if (r106 == null) goto L29;
        r104 = r106.f190636b;
    L29:
        SharedPreferences r107 = (SharedPreferences) r105.first;
        String r108 = (String) r105.second;
        Bundle r111 = new Bundle();
        ArrayList<? extends Parcelable> r109 = new ArrayList();
        if (r108 != null) goto L36;
        Iterator<Map.Entry<String, ?>> r112 = r107.getAll().entrySet().iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        Map.Entry<String, ?> r113 = r112.next();
        r109.add(new SpPair(r113.getKey(), r113.getValue()));
        goto L33
    L35:
        r111.putParcelableArrayList(CloudControlInf.SP, r109);
    L44:
        return r111;
    L36:
        Object r114 = r107.getAll().get(r108);
        if (r114 == null) goto L41;
        r104 = r114;
    L41:
        if ((r104 instanceof Set) == false) goto L43;
        r104 = xu3.e.d((Set) r104);
    L43:
        r109.add(new SpPair(r108, r104));
        r111.putParcelableArrayList(CloudControlInf.SP, r109);
        goto L44
    L46:
        if ("contains".equals(r101) == false) goto L50;
        SharedPreferences r115 = (SharedPreferences) r105.first;
        String r116 = (String) r105.second;
        Bundle r117 = new Bundle();
        r117.putBoolean("contains", r115.contains(r116));
        return r117;
    L50:
        if ("edit".equals(r101) == false) goto L56;
        if (r110 == null) goto L56;
        a((SharedPreferences) r105.first, r110);     // Catch: Throwable -> L54
        long r118 = Binder.clearCallingIdentity();     // Catch: Throwable -> L54
        this.f190628a.notifyChange(UriProtector.parse(r100), null);     // Catch: Throwable -> L54
        Binder.restoreCallingIdentity(r118);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        av3.b.c("MultiProcessSharedPref", "edit", th);
    L56:
        return null;
    L9:
        if (r103.size() < 2) goto L19;
        if (CloudControlInf.SP.equals(ListProtector.get(r103, 0)) == false) goto L19;
        SharedPreferences r119 = getContext().getSharedPreferences((String) ListProtector.get(r103, 1), 0);     // Catch: Throwable -> L57
        if (r103.size() <= 2) goto L15;
        String r120 = (String) ListProtector.get(r103, 2);     // Catch: Throwable -> L57
    L16:
        r105 = new Pair(r119, r120);     // Catch: Throwable -> L57
        monitor-exit(this);
        goto L21
    L15:
        r120 = null;
    L57:
        th = move-exception;
        throw th;
    }
}
