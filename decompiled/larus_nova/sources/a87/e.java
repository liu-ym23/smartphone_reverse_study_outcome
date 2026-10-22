package a87;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.push.d0;
import com.bytedance.push.e0;
import com.bytedance.push.settings.storage.MainProcessSettingsProvider;
import com.bytedance.push.settings.storage.SmpProcessSettingsProvider;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f2169d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<j77.a, ContentObserver> f2172c;

    public class a implements l {
        public a() {
        }
    }

    public class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j77.a f2173a;

        public b(Handler r100, j77.a r101) {
            this.f2173a = r101;
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            super.onChange(r100, r101);
            d0 r102 = (d0) this.f2173a;
            e0 r103 = r102.f266849b;
            Context r104 = r102.f266848a;
            r103.getClass();
            e0.a(r104);
        }
    }

    public static final class c implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f2174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f2176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ContentValues f2177d;

        @Override // android.content.SharedPreferences.Editor
        public final synchronized void apply() {
            monitor-enter(this);
            a87.b r100 = new a87.b(this.f2175b, "key", "val", "type");     // Catch: Throwable -> L19
            l r101 = this.f2174a;     // Catch: Throwable -> L15
            Context r102 = this.f2176c;     // Catch: Throwable -> L15
            ((a) r101).getClass();     // Catch: Throwable -> L15
            Uri r103 = e.d(r102, r100);     // Catch: Throwable -> L15
            if (Build.VERSION.SDK_INT < 29) goto L13;
            ContentProviderClient r104 = a(this.f2176c.getContentResolver(), r103);     // Catch: Throwable -> L15
            if (r104 != null) goto L23;
        L17:
            monitor-exit(this);
            return;
        L23:
            r104.insert(r103, this.f2177d);     // Catch: Throwable -> L10
            r104.close();     // Catch: Throwable -> L15
            goto L17
        L10:
            th = move-exception;
            r104.close();     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L13:
            b(this.f2176c.getContentResolver(), r103, this.f2177d);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            int r105 = q77.a.f531973a;     // Catch: Throwable -> L19
            th.getLocalizedMessage();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            throw new UnsupportedOperationException("no support clear");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f2177d.putNull(r100);
            return this;
        }

        public static ContentProviderClient a(ContentResolver r110, Uri r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(240008);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return (ContentProviderClient) r107.f474983b;
        L21:
            return r110.acquireUnstableContentProviderClient(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            this.f2177d.put(r100, Boolean.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            this.f2177d.put(r100, Float.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            this.f2177d.put(r100, Integer.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            this.f2177d.put(r100, Long.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            this.f2177d.put(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            throw new UnsupportedOperationException("putStringSet not support");
        }

        public c(Context r100, String r101, a r102) {
            this.f2177d = new ContentValues();
            this.f2176c = r100.getApplicationContext();
            this.f2174a = r102;
            this.f2175b = r101;
        }

        public static void b(ContentResolver r110, Uri r111, ContentValues r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111, r210};
            f06.b r112 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(240017);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L20;
            Uri r108 = (Uri) r107.f474983b;
            return;
        L20:
            r110.insert(r111, r210);
            return;
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    @Override // a87.k
    public final SharedPreferences.Editor edit() {
        return new c(this.f2170a, this.f2171b, new a());
    }

    @Override // a87.k
    public final float a(String r100) {
        return getFloat(r100, 0.0f);
    }

    @Override // a87.k
    public final boolean contains(String r100) {
        Bundle r101 = null;
        Uri r102 = d(this.f2170a, null);     // Catch: Throwable -> L23
    L15:
        th = move-exception;
        int r103 = q77.a.f531973a;     // Catch: Throwable -> L23
        th.getLocalizedMessage();     // Catch: Throwable -> L23
    L17:
        if (r101 == null) goto L21;
        return r101.getBoolean("_result");
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L13;
        ContentProviderClient r104 = b(this.f2170a.getContentResolver(), r102);     // Catch: Throwable -> L15
        if (r104 == null) goto L17;
        String r105 = r102.getAuthority();     // Catch: Throwable -> L10
        String r106 = this.f2171b;     // Catch: Throwable -> L10
        Bundle r107 = new Bundle();     // Catch: Throwable -> L10
        r107.putString("_storage_key", r106);     // Catch: Throwable -> L10
        r107.putString("_key", r100);     // Catch: Throwable -> L10
        r101 = r104.call(r105, "_contains", null, r107);     // Catch: Throwable -> L10
        r104.close();     // Catch: Throwable -> L15
        goto L17
    L10:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L13:
        ContentResolver r108 = this.f2170a.getContentResolver();     // Catch: Throwable -> L15
        String r109 = this.f2171b;     // Catch: Throwable -> L15
        Bundle r110 = new Bundle();     // Catch: Throwable -> L15
        r110.putString("_storage_key", r109);     // Catch: Throwable -> L15
        r110.putString("_key", r100);     // Catch: Throwable -> L15
        r101 = r108.call(r102, "_contains", null, r110);     // Catch: Throwable -> L15
    L21:
        return false;
    }

    public final Cursor e(Uri r100) {
        Cursor r101 = null;
    L15:
        th = move-exception;
        int r102 = q77.a.f531973a;
        th.getLocalizedMessage();
        return r101;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L23;
        ContentProviderClient r103 = b(this.f2170a.getContentResolver(), r100);     // Catch: Throwable -> L15
        if (r103 != null) goto L18;
        return null;
    L18:
        r101 = r103.query(r100, null, null, null, null);     // Catch: Throwable -> L10
        r103.close();     // Catch: Throwable -> L15
        return r101;
    L10:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L23:
        return c(this.f2170a.getContentResolver(), r100);
    }

    @Override // a87.k
    public final boolean getBoolean(String r100) {
        return getBoolean(r100, false);
    }

    @Override // a87.k
    public final int getInt(String r100) {
        return getInt(r100, 0);
    }

    @Override // a87.k
    public final long getLong(String r100) {
        return getLong(r100, 0);
    }

    @Override // a87.k
    public final String getString(String r100) {
        return getString(r100, null);
    }

    @Override // a87.k
    public final void unregisterValChanged(j77.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ContentObserver r101 = this.f2172c.remove(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        this.f2170a.getContentResolver().unregisterContentObserver(r101);
    }

    public e(Context r100, String r101) {
        this.f2172c = new ConcurrentHashMap();
        int r102 = q77.a.f531973a;
        this.f2170a = r100;
        this.f2171b = r101;
        f2169d = false;
    }

    public static ContentProviderClient b(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor c(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static synchronized Uri d(Context r100, a87.b r101) {
        monitor-enter(e.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f2169d == false) goto L9;
        Uri r102 = SmpProcessSettingsProvider.a(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(e.class);
        return r102;
    L9:
        Uri r103 = MainProcessSettingsProvider.a(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(e.class);
        return r103;
    }

    @Override // a87.k
    public final boolean getBoolean(String r100, boolean r101) {
        Cursor r102 = e(d(this.f2170a, new a87.b(this.f2171b, r100, String.valueOf(r101), "boolean")));     // Catch: Throwable -> L19
        if (r102 == null) goto L31;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L12:
        boolean r103 = r101;
    L29:
        r102.close();     // Catch: Exception -> L20 Throwable -> L19
    L15:
        return r103;
    L16:
        th = move-exception;
        r102.close();     // Catch: Exception -> L21 Throwable -> L19
    L18:
        throw th;     // Catch: Throwable -> L19
    L6:
        if (r102.moveToFirst() == false) goto L12;
        r103 = false;
        if (r102.getInt(0) <= 0) goto L29;
        r103 = true;
        goto L29
    L31:
        return r101;
    L19:
        return r101;
    }

    @Override // a87.k
    public final float getFloat(String r100, float r101) {
        Cursor r102 = e(d(this.f2170a, new a87.b(this.f2171b, r100, String.valueOf(r101), "float")));     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        if (r102.moveToFirst() == false) goto L9;
        float r103 = r102.getFloat(0);     // Catch: Throwable -> L14
    L16:
        r102.close();     // Catch: Exception -> L13 Throwable -> L15
    L12:
        return r103;
    L9:
        r103 = r101;
        goto L16
    L21:
        return r101;
    L22:
        return r101;
    }

    @Override // a87.k
    public final int getInt(String r100, int r101) {
        Cursor r102 = e(d(this.f2170a, new a87.b(this.f2171b, r100, String.valueOf(r101), "integer")));     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        if (r102.moveToFirst() == false) goto L9;
        int r103 = r102.getInt(0);     // Catch: Throwable -> L14
    L16:
        r102.close();     // Catch: Exception -> L13 Throwable -> L15
    L12:
        return r103;
    L9:
        r103 = r101;
        goto L16
    L21:
        return r101;
    L22:
        return r101;
    }

    @Override // a87.k
    public final long getLong(String r100, long r101) {
        Cursor r102 = e(d(this.f2170a, new a87.b(this.f2171b, r100, String.valueOf(r101), "long")));     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        if (r102.moveToFirst() == false) goto L9;
        long r103 = r102.getLong(0);     // Catch: Throwable -> L14
    L16:
        r102.close();     // Catch: Exception -> L13 Throwable -> L15
    L12:
        return r103;
    L9:
        r103 = r101;
        goto L16
    L21:
        return r101;
    L22:
        return r101;
    }

    @Override // a87.k
    public final String getString(String r100, String r101) {
        Cursor r102 = e(d(this.f2170a, new a87.b(this.f2171b, r100, r101, "string")));     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        if (r102.moveToFirst() == false) goto L9;
        String r103 = r102.getString(0);     // Catch: Throwable -> L14
    L20:
        r102.close();     // Catch: Exception -> L13 Throwable -> L15
    L12:
        return r103;
    L9:
        r103 = r101;
        goto L20
    L21:
        return r101;
    L22:
        return r101;
    }

    public e(Context r100, String r101, int r102) {
        this.f2172c = new ConcurrentHashMap();
        int r103 = q77.a.f531973a;
        this.f2170a = r100;
        this.f2171b = r101;
        f2169d = true;
    }

    @Override // a87.k
    public final void registerValChanged(Context r100, String r101, String r102, j77.a r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        String r104 = this.f2171b;
        String r105 = MainProcessSettingsProvider.f267019a;
        monitor-enter(MainProcessSettingsProvider.class);
    L35:
        th = move-exception;
        throw th;
    L7:
        if (MainProcessSettingsProvider.f267020b == null) goto L41;
    L14:
        if (r100 != null) goto L16;
    L25:
        Uri r106 = MainProcessSettingsProvider.f267020b;     // Catch: Throwable -> L35
        monitor-exit(MainProcessSettingsProvider.class);
    L27:
        if (r106 != null) goto L29;
        return;
    L29:
        b r107 = new b(new Handler(Looper.getMainLooper()), r103);
        r100.getContentResolver().registerContentObserver(r106, true, r107);     // Catch: Throwable -> L32
        ((ConcurrentHashMap) this.f2172c).put(r103, r107);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        int r108 = q77.a.f531973a;
        th.getLocalizedMessage();
        return;
    L16:
        if (TextUtils.isEmpty(r104) == true) goto L25;
        if (TextUtils.isEmpty(r101) == true) goto L25;
        if (TextUtils.isEmpty(r102) == true) goto L25;
        r106 = MainProcessSettingsProvider.f267020b.buildUpon().appendPath(r104).appendPath(r101).appendPath("val").appendPath(r102).build();     // Catch: Throwable -> L35
        monitor-exit(MainProcessSettingsProvider.class);
        goto L27
    L41:
        MainProcessSettingsProvider.b(r100);     // Catch: Exception -> L10 Throwable -> L35
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
        r106 = null;
        goto L27
    }
}
