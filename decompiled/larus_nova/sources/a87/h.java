package a87;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.push.d0;
import com.bytedance.push.e0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<j77.a, SharedPreferences.OnSharedPreferenceChangeListener> f2180b;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j77.a f2182b;

        public a(String r100, j77.a r101) {
            this.f2181a = r100;
            this.f2182b = r101;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences r100, String r101) {
            if (TextUtils.equals(this.f2181a, r101) == false) goto L6;
            d0 r102 = (d0) this.f2182b;
            e0 r103 = r102.f266849b;
            Context r104 = r102.f266848a;
            r103.getClass();
            e0.a(r104);
            return;
        }
    }

    @Override // a87.k
    public SharedPreferences.Editor edit() {
        return this.f2179a.edit();
    }

    @Override // a87.k
    public final float a(String r100) {
        return getFloat(r100, 0.0f);
    }

    @Override // a87.k
    public final boolean contains(String r100) {
        return this.f2179a.contains(r100);
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
        SharedPreferences.OnSharedPreferenceChangeListener r101 = (SharedPreferences.OnSharedPreferenceChangeListener) ((ConcurrentHashMap) this.f2180b).remove(r100);
        if (r101 == null) goto L8;
        this.f2179a.unregisterOnSharedPreferenceChangeListener(r101);
        return;
    }

    public h(Context r100, String r101) {
        this.f2180b = new ConcurrentHashMap();
        this.f2179a = r100.getSharedPreferences(r101, 0);
    }

    @Override // a87.k
    public final boolean getBoolean(String r100, boolean r101) {
        return this.f2179a.getBoolean(r100, r101);
    L4:
        return r101;
    }

    @Override // a87.k
    public final float getFloat(String r100, float r101) {
        return this.f2179a.getFloat(r100, r101);
    L4:
        return r101;
    }

    @Override // a87.k
    public final int getInt(String r100, int r101) {
        return this.f2179a.getInt(r100, r101);
    L4:
        return r101;
    }

    @Override // a87.k
    public final long getLong(String r100, long r101) {
        return this.f2179a.getLong(r100, r101);
    L4:
        return r101;
    }

    @Override // a87.k
    public final String getString(String r100, String r101) {
        return this.f2179a.getString(r100, r101);
    L4:
        return r101;
    }

    @Override // a87.k
    public final void registerValChanged(Context r100, String r101, String r102, j77.a r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        a r104 = new a(r101, r103);
        ((ConcurrentHashMap) this.f2180b).put(r103, r104);
        this.f2179a.registerOnSharedPreferenceChangeListener(r104);
    }
}
