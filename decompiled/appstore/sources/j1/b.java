package j1;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b implements SharedPreferences {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f20883d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f20884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f20886c;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: j1.b$b, reason: collision with other inner class name */
    public class SharedPreferencesEditorC0276b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HashMap f20888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f20889c;

        public SharedPreferencesEditorC0276b(b r10) {
            this.f20889c = r10;
            this.f20887a = false;
            this.f20888b = new HashMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.f20887a == false) goto L5;
        L7:
            Bundle r10 = new Bundle();
            if (this.f20887a == false) goto L10;
            r10.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r11 = new ArrayList(this.f20888b.size());
            Iterator r12 = this.f20888b.entrySet().iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            Map.Entry r13 = (Map.Entry) r12.next();
            r11.add(new SpPair((String) r13.getKey(), r13.getValue()));
            goto L12
        L14:
            r10.putParcelableArrayList("edit", r11);
            b.c(this.f20889c).getContentResolver().call(b.a(this.f20889c), b.b(this.f20889c), "edit", r10);     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.f20888b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f20888b.clear();
            this.f20887a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r10, boolean r11) {
            this.f20888b.put(r10, Boolean.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r10, float r11) {
            this.f20888b.put(r10, Float.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r10, int r11) {
            this.f20888b.put(r10, Integer.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r10, long r11) {
            this.f20888b.put(r10, Long.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r10, String r11) {
            this.f20888b.put(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r10, Set r11) {
            this.f20888b.put(r10, ListUtils.e(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r10) {
            this.f20888b.put(r10, null);
            return this;
        }

        public /* synthetic */ SharedPreferencesEditorC0276b(b r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public b(Application r10, String r11) {
        this.f20884a = r10;
        String r12 = CommonColumns.SCHEME + r10.getPackageName() + ".apm/sp/" + r11;
        this.f20885b = r12;
        this.f20886c = Uri.parse(r12);
    }

    public static /* synthetic */ Uri a(b r10) {
        return r10.f20886c;
    }

    public static /* synthetic */ String b(b r10) {
        return r10.f20885b;
    }

    public static /* synthetic */ Application c(b r10) {
        return r10.f20884a;
    }

    public static int e(Context r10) {
        Bundle r11 = r10.getContentResolver().call(Uri.parse(CommonColumns.SCHEME + r10.getPackageName() + ".apm"), "getPid", null, null);     // Catch: Exception -> L8
        if (r11 == null) goto L7;
        return r11.getInt("Pid", -1);
    L7:
        return -1;
    }

    public static SharedPreferences f(Context r10, String r11) {
        if ((r10 instanceof Application) == false) goto L5;
        Application r12 = (Application) r10;
    L7:
        return new b(r12, r11);
    L5:
        r12 = (Application) r10.getApplicationContext();
        goto L7
    }

    public static SharedPreferences g(Context r10, String r11) {
        if (h(r10) == false) goto L7;
        return r10.getSharedPreferences(r11, 0);
    L7:
        return f(r10, r11);
    }

    public static boolean h(Context r10) {
        if (f20883d != (-1)) goto L6;
        f20883d = e(r10);
    L6:
        if (f20883d != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r10) {
        Bundle r11 = null;
        ContentResolver r12 = this.f20884a.getContentResolver();     // Catch: Exception -> L14
        Uri r13 = this.f20886c;     // Catch: Exception -> L14
        if (r10 == null) goto L6;
        String r14 = this.f20885b + LibrarianImpl.Constants.SEPARATOR + r10;     // Catch: Exception -> L14
    L7:
        r11 = r12.call(r13, r14, "contains", null);     // Catch: Exception -> L14
        goto L8
    L6:
        r14 = this.f20885b;     // Catch: Exception -> L14
    L8:
        if (r11 != null) goto L10;
    L12:
        return false;
    L10:
        if (r11.getBoolean("contains") == false) goto L12;
        return true;
    }

    public final ArrayList d(String r10, Object r11) {
        Bundle r12 = new Bundle();
        if (r11 == null) goto L21;
        r12.putParcelable(CloudControlInf.SP, new SpPair(r10, r11));
    L21:
        ContentResolver r13 = this.f20884a.getContentResolver();     // Catch: Exception -> L16
        Uri r14 = this.f20886c;     // Catch: Exception -> L16
        if (r10 == null) goto L9;
        String r15 = this.f20885b + LibrarianImpl.Constants.SEPARATOR + r10;     // Catch: Exception -> L16
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
        r15 = this.f20885b;     // Catch: Exception -> L16
    L16:
        r16 = null;
        goto L17
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC0276b(this, null);
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        ArrayList r10 = d(null, null);
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
        ArrayList r12 = d(r10, String.valueOf(r11));
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
        ArrayList r12 = d(r10, String.valueOf(r11));
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
        ArrayList r12 = d(r10, String.valueOf(r11));
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
        ArrayList r12 = d(r10, String.valueOf(r11));
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
        ArrayList r12 = d(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (String) ((SpPair) r12.get(0)).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String r10, Set r11) {
        ArrayList r12 = d(r10, r11);
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

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }
}
