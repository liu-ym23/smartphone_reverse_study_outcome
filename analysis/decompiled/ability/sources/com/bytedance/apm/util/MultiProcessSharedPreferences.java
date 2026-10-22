package com.bytedance.apm.util;

import H4.o;
import K2.a;
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
import cc.dd.dd.b0.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f2245a;

    public static void a(SharedPreferences sharedPreferences, Bundle bundle) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (bundle.getBoolean("clear")) {
            editorEdit.clear();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("edit");
        if (parcelableArrayList == null) {
            return;
        }
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            Object obj = lVar.b;
            if (obj == null) {
                editorEdit.remove(lVar.f2132a);
            } else {
                String str = lVar.f2132a;
                if (obj instanceof String) {
                    editorEdit.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    editorEdit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof String[]) {
                    editorEdit.putStringSet(str, new HashSet(Arrays.asList((String[]) obj)));
                }
            }
        }
        editorEdit.commit();
    }

    public static void b(Object obj, String str) {
        Bundle bundle = new Bundle();
        if (obj != null) {
            bundle.putParcelable("sp", new l(str, obj));
        }
        try {
            throw null;
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        int i;
        Object obj;
        Pair pair;
        l lVar;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        Uri uri = Uri.parse(str);
        synchronized (this) {
            try {
                List<String> pathSegments = uri.getPathSegments();
                i = 0;
                obj = null;
                pair = (pathSegments == null || pathSegments.size() < 2 || !"sp".equals(pathSegments.get(0))) ? null : new Pair(getContext().getSharedPreferences(pathSegments.get(1), 0), pathSegments.size() > 2 ? pathSegments.get(2) : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pair != null) {
            if ("query".equals(str2)) {
                if (bundle != null && (lVar = (l) bundle.getParcelable("sp")) != null) {
                    obj = lVar.b;
                }
                SharedPreferences sharedPreferences = (SharedPreferences) pair.first;
                String str3 = (String) pair.second;
                Bundle bundle2 = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (str3 == null) {
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        arrayList.add(new l(entry.getKey(), entry.getValue()));
                    }
                    bundle2.putParcelableArrayList("sp", arrayList);
                    return bundle2;
                }
                Object obj2 = sharedPreferences.getAll().get(str3);
                if (obj2 != null) {
                    obj = obj2;
                }
                if (obj instanceof Set) {
                    Set set = (Set) obj;
                    String[] strArr = new String[set.size()];
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        strArr[i] = (String) it.next();
                        i++;
                    }
                    obj = strArr;
                }
                arrayList.add(new l(str3, obj));
                bundle2.putParcelableArrayList("sp", arrayList);
                return bundle2;
            }
            if ("contains".equals(str2)) {
                SharedPreferences sharedPreferences2 = (SharedPreferences) pair.first;
                String str4 = (String) pair.second;
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("contains", sharedPreferences2.contains(str4));
                return bundle3;
            }
            if ("edit".equals(str2) && bundle != null) {
                try {
                    a((SharedPreferences) pair.first, bundle);
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    this.f2245a.notifyChange(Uri.parse(str), null);
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    return null;
                } catch (Throwable th2) {
                    o.g("MultiProcessSharedPref", "edit", th2);
                }
            }
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return false;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        b(null, null);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) {
        b(String.valueOf(z10), str);
        return z10;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        b(String.valueOf(f), str);
        return f;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        b(String.valueOf(i), str);
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j5) {
        b(String.valueOf(j5), str);
        return j5;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        b(str2, str);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        b(set, str);
        return null;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f2245a = getContext().getContentResolver();
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return -1;
    }
}
