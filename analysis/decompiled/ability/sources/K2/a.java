package K2;

import H4.o;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import cc.dd.dd.b0.l;
import com.bytedance.apm.util.MultiProcessSharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public boolean f905a = false;
    public final HashMap b = new HashMap();

    public a(MultiProcessSharedPreferences multiProcessSharedPreferences) {
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        boolean z10 = this.f905a;
        HashMap map = this.b;
        if (z10 || !map.isEmpty()) {
            Bundle bundle = new Bundle();
            if (this.f905a) {
                bundle.putBoolean("clear", true);
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new l((String) entry.getKey(), entry.getValue()));
            }
            bundle.putParcelableArrayList("edit", arrayList);
            try {
                int i = MultiProcessSharedPreferences.b;
                throw null;
            } catch (Exception e) {
                o.g("MultiProcessSharedPref", "apply exception: ", e);
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.b.clear();
        this.f905a = true;
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        apply();
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
        this.b.put(str, Boolean.valueOf(z10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f) {
        this.b.put(str, Float.valueOf(f));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j5) {
        this.b.put(str, Long.valueOf(j5));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        String[] strArr = new String[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = (String) it.next();
            i++;
        }
        this.b.put(str, strArr);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.b.put(str, null);
        return this;
    }
}
