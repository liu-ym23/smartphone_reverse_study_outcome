package L;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class d implements SharedPreferences {
    public static int d = -1;

    /* renamed from: a, reason: collision with root package name */
    public Application f919a;
    public String b;
    public Uri c;

    public static SharedPreferences a(Context context, String str) {
        int i = -1;
        if (d == -1) {
            try {
                Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://" + context.getPackageName() + ".apm"), "getPid", (String) null, (Bundle) null);
                if (bundleCall != null) {
                    i = bundleCall.getInt("Pid", -1);
                }
            } catch (Exception unused) {
            }
            d = i;
        }
        if (d == Process.myPid()) {
            return context.getSharedPreferences("" + str, 0);
        }
        Application application = context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
        d dVar = new d();
        dVar.f919a = application;
        String str2 = "content://" + application.getPackageName() + ".apm/sp/" + str;
        dVar.b = str2;
        dVar.c = Uri.parse(str2);
        return dVar;
    }

    public final ArrayList b(Object obj, String str) {
        Bundle bundleCall;
        String str2 = this.b;
        Bundle bundle = new Bundle();
        if (obj != null) {
            bundle.putParcelable("sp", new cc.dd.dd.aa.g(str, obj));
        }
        try {
            ContentResolver contentResolver = this.f919a.getContentResolver();
            Uri uri = this.c;
            if (str != null) {
                str2 = str2 + "/" + str;
            }
            if (obj == null) {
                bundle = null;
            }
            bundleCall = contentResolver.call(uri, str2, "query", bundle);
        } catch (Exception unused) {
            bundleCall = null;
        }
        if (bundleCall == null) {
            return null;
        }
        bundleCall.setClassLoader(d.class.getClassLoader());
        return bundleCall.getParcelableArrayList("sp");
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        String str2 = this.b;
        Bundle bundleCall = null;
        try {
            ContentResolver contentResolver = this.f919a.getContentResolver();
            Uri uri = this.c;
            if (str != null) {
                str2 = str2 + "/" + str;
            }
            bundleCall = contentResolver.call(uri, str2, "contains", (Bundle) null);
        } catch (Exception unused) {
        }
        return bundleCall != null && bundleCall.getBoolean("contains");
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new c(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        ArrayList arrayListB = b(null, null);
        if (arrayListB == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            cc.dd.dd.aa.g gVar = (cc.dd.dd.aa.g) it.next();
            map.put(gVar.f2130a, gVar.b);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) {
        ArrayList arrayListB = b(String.valueOf(z10), str);
        if (arrayListB != null) {
            Object obj = ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof String) {
                return Boolean.valueOf((String) obj).booleanValue();
            }
        }
        return z10;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        ArrayList arrayListB = b(String.valueOf(f), str);
        if (arrayListB != null) {
            Object obj = ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            if (obj instanceof String) {
                return Float.valueOf((String) obj).floatValue();
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        ArrayList arrayListB = b(String.valueOf(i), str);
        if (arrayListB != null) {
            Object obj = ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                return Integer.decode((String) obj).intValue();
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j5) {
        ArrayList arrayListB = b(String.valueOf(j5), str);
        if (arrayListB != null) {
            Object obj = ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
            if (obj instanceof Long) {
                return ((Long) obj).longValue();
            }
            if (obj instanceof String) {
                return Long.decode((String) obj).longValue();
            }
        }
        return j5;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        ArrayList arrayListB = b(str2, str);
        if (arrayListB == null) {
            return null;
        }
        return (String) ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        ArrayList arrayListB = b(set, str);
        if (arrayListB == null || ((cc.dd.dd.aa.g) arrayListB.get(0)).b == null) {
            return null;
        }
        String[] strArr = (String[]) ((cc.dd.dd.aa.g) arrayListB.get(0)).b;
        HashSet hashSet = new HashSet(strArr.length);
        hashSet.addAll(Arrays.asList(strArr));
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
