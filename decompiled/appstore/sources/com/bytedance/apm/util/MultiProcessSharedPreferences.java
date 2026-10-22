package com.bytedance.apm.util;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.bytedance.librarian.LibrarianImpl;
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
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f6617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f6618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f6620d;

    public static /* synthetic */ class a {
    }

    public class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HashMap f6622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MultiProcessSharedPreferences f6623c;

        public b(MultiProcessSharedPreferences r10) {
            this.f6623c = r10;
            this.f6621a = false;
            this.f6622b = new HashMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.f6621a == false) goto L5;
        L7:
            Bundle r10 = new Bundle();
            if (this.f6621a == false) goto L10;
            r10.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r11 = new ArrayList(this.f6622b.size());
            Iterator r12 = this.f6622b.entrySet().iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            Map.Entry r13 = (Map.Entry) r12.next();
            r11.add(new SpPair((String) r13.getKey(), r13.getValue()));
            goto L12
        L14:
            r10.putParcelableArrayList("edit", r11);
            MultiProcessSharedPreferences.c(this.f6623c).getContentResolver().call(MultiProcessSharedPreferences.a(this.f6623c), MultiProcessSharedPreferences.b(this.f6623c), "edit", r10);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            s3.a.c("MultiProcessSharedPref", "apply exception: ", e);
            return;
        L5:
            if (this.f6622b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f6622b.clear();
            this.f6621a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r10, boolean r11) {
            this.f6622b.put(r10, Boolean.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r10, float r11) {
            this.f6622b.put(r10, Float.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r10, int r11) {
            this.f6622b.put(r10, Integer.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r10, long r11) {
            this.f6622b.put(r10, Long.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r10, String r11) {
            this.f6622b.put(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r10, Set r11) {
            this.f6622b.put(r10, com.bytedance.apm6.util.ListUtils.e(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r10) {
            this.f6622b.put(r10, null);
            return this;
        }

        public /* synthetic */ b(MultiProcessSharedPreferences r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public MultiProcessSharedPreferences() {
    }

    public static /* synthetic */ Uri a(MultiProcessSharedPreferences r10) {
        return r10.f6620d;
    }

    public static /* synthetic */ String b(MultiProcessSharedPreferences r10) {
        return r10.f6619c;
    }

    public static /* synthetic */ Application c(MultiProcessSharedPreferences r10) {
        return r10.f6618b;
    }

    public static void e(SharedPreferences.Editor r10, String r11, Object r12) {
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

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        if (r12 == null) goto L4;
        r12.setClassLoader(getClass().getClassLoader());
    L4:
        Pair r13 = h(Uri.parse(r10));
        Object r14 = null;
        if (r13 != null) goto L8;
        return null;
    L8:
        if ("query".equals(r11) == false) goto L16;
        if (r12 == null) goto L14;
        SpPair r15 = (SpPair) r12.getParcelable(CloudControlInf.SP);
        if (r15 == null) goto L14;
        r14 = r15.mValue;
    L14:
        return i((SharedPreferences) r13.first, (String) r13.second, r14);
    L16:
        if ("contains".equals(r11) == false) goto L20;
        return d((SharedPreferences) r13.first, (String) r13.second);
    L20:
        if ("edit".equals(r11) == false) goto L26;
        if (r12 == null) goto L26;
        f((SharedPreferences) r13.first, r12);     // Catch: Throwable -> L24
        long r16 = Binder.clearCallingIdentity();     // Catch: Throwable -> L24
        this.f6617a.notifyChange(Uri.parse(r10), null);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(r16);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        s3.a.c("MultiProcessSharedPref", "edit", th);
    L26:
        return null;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r10) {
        if (this.f6620d != null) goto L5;
        return false;
    L5:
        Bundle r11 = null;
        ContentResolver r12 = this.f6618b.getContentResolver();     // Catch: Throwable -> L9
        Uri r13 = this.f6620d;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        String r14 = this.f6619c + LibrarianImpl.Constants.SEPARATOR + r10;     // Catch: Throwable -> L9
    L12:
        r11 = r12.call(r13, r14, "contains", null);     // Catch: Throwable -> L9
    L15:
        if (r11 != null) goto L17;
        return false;
    L17:
        if (r11.getBoolean("contains") == false) goto L23;
        return true;
    L23:
        return false;
    L11:
        r14 = this.f6619c;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        s3.a.c("APM-AsyncTask", "contains", th);
        goto L15
    }

    public final Bundle d(SharedPreferences r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putBoolean("contains", r10.contains(r11));
        return r12;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, null);
    }

    public final void f(SharedPreferences r10, Bundle r11) {
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
        e(r12, r15.mKey, r16);
        goto L10
    L13:
        r12.remove(r15.mKey);
        goto L10
    L15:
        r12.commit();
    }

    public final ArrayList g(String r10, Object r11) {
        Bundle r12 = new Bundle();
        if (r11 == null) goto L21;
        r12.putParcelable(CloudControlInf.SP, new SpPair(r10, r11));
    L21:
        ContentResolver r13 = this.f6618b.getContentResolver();     // Catch: Exception -> L16
        Uri r14 = this.f6620d;     // Catch: Exception -> L16
        if (r10 == null) goto L9;
        String r15 = this.f6619c + LibrarianImpl.Constants.SEPARATOR + r10;     // Catch: Exception -> L16
    L11:
        if (r11 != null) goto L14;
        r12 = null;
    L14:
        Bundle r16 = r13.call(r14, r15, "query", r12);     // Catch: Exception -> L16
    L17:
        if (r16 != null) goto L19;
        return null;
    L19:
        r16.setClassLoader(getClass().getClassLoader());
        return r16.getParcelableArrayList(CloudControlInf.SP);
    L9:
        r15 = this.f6619c;     // Catch: Exception -> L16
    L16:
        r16 = null;
        goto L17
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        ArrayList r10 = g(null, null);
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r11 = new HashMap();
        Iterator r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        SpPair r13 = (SpPair) r12.next();
        r11.put(r13.mKey, r13.mValue);
        goto L7
    L9:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r10, boolean r11) {
        ArrayList r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = ((SpPair) r12.get(0)).mValue;
        if ((r13 instanceof Boolean) == false) goto L10;
        return ((Boolean) r13).booleanValue();
    L10:
        if ((r13 instanceof String) == true) goto L12;
        return r11;
    L12:
        return Boolean.valueOf((String) r13).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r10, float r11) {
        ArrayList r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = ((SpPair) r12.get(0)).mValue;
        if ((r13 instanceof Float) == false) goto L10;
        return ((Float) r13).floatValue();
    L10:
        if ((r13 instanceof String) == true) goto L12;
        return r11;
    L12:
        return Float.valueOf((String) r13).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r10, int r11) {
        ArrayList r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = ((SpPair) r12.get(0)).mValue;
        if ((r13 instanceof Integer) == false) goto L10;
        return ((Integer) r13).intValue();
    L10:
        if ((r13 instanceof String) == true) goto L12;
        return r11;
    L12:
        return Integer.decode((String) r13).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r10, long r11) {
        ArrayList r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = ((SpPair) r12.get(0)).mValue;
        if ((r13 instanceof Long) == false) goto L10;
        return ((Long) r13).longValue();
    L10:
        if ((r13 instanceof String) == true) goto L12;
        return r11;
    L12:
        return Long.decode((String) r13).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String r10, String r11) {
        ArrayList r12 = g(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (String) ((SpPair) r12.get(0)).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String r10, Set r11) {
        ArrayList r12 = g(r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        if (((SpPair) r12.get(0)).mValue != null) goto L8;
        return null;
    L8:
        String[] r13 = (String[]) ((SpPair) r12.get(0)).mValue;
        HashSet r14 = new HashSet(r13.length);
        r14.addAll(Arrays.asList(r13));
        return r14;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    public final synchronized Pair h(Uri r10) {
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

    public final Bundle i(SharedPreferences r10, String r11, Object r12) {
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
        r12 = com.bytedance.apm6.util.ListUtils.e((Set) r12);
    L16:
        r14.add(new SpPair(r11, r12));
        r13.putParcelableArrayList(CloudControlInf.SP, r14);
        goto L17
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f6617a = getContext().getContentResolver();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return -1;
    }
}
