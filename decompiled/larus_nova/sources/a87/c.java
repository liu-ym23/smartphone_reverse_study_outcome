package a87;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.push.settings.storage.MainProcessSettingsProvider;
import com.bytedance.push.settings.storage.SmpProcessSettingsProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2160d;

    public final class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f2162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SharedPreferences.Editor f2163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f2164d;

        public final void a() {
            Iterator r100 = ((ConcurrentHashMap) this.f2162b).entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            Map.Entry r101 = (Map.Entry) r100.next();
            String r102 = (String) r101.getKey();
            String r103 = (String) r101.getValue();
            if (d87.a.c(this.f2161a) == true) goto L7;
            Context r104 = this.f2161a;
            String r105 = this.f2164d.f2160d;
            String r106 = SmpProcessSettingsProvider.f267023a;
            new j(r105, r102, r103, r104).run();
            goto L4
        L7:
            Context r107 = this.f2161a;
            String r108 = this.f2164d.f2160d;
            String r109 = MainProcessSettingsProvider.f267019a;
            new d(r108, r102, r103, r107).run();
            goto L4
        L9:
            ((ConcurrentHashMap) this.f2162b).clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            this.f2163c.apply();
            a();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            throw new UnsupportedOperationException("clear not support");
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            boolean r100 = this.f2163c.commit();
            a();
            return r100;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f2163c.remove(r100);
            ((ConcurrentHashMap) this.f2162b).remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            this.f2163c.putBoolean(r100, r101);
            if (r101 != this.f2164d.getBoolean(r100, false)) goto L5;
            ((ConcurrentHashMap) this.f2162b).remove(r100);
        L6:
            return this;
        L5:
            ((ConcurrentHashMap) this.f2162b).put(r100, "boolean");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            this.f2163c.putFloat(r100, r101);
            if (r101 != this.f2164d.getFloat(r100, 0.0f)) goto L5;
            ((ConcurrentHashMap) this.f2162b).remove(r100);
        L6:
            return this;
        L5:
            ((ConcurrentHashMap) this.f2162b).put(r100, "float");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            this.f2163c.putInt(r100, r101);
            if (r101 != this.f2164d.getInt(r100, 0)) goto L5;
            ((ConcurrentHashMap) this.f2162b).remove(r100);
        L6:
            return this;
        L5:
            ((ConcurrentHashMap) this.f2162b).put(r100, "integer");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            this.f2163c.putLong(r100, r101);
            if (r101 != this.f2164d.getLong(r100)) goto L5;
            ((ConcurrentHashMap) this.f2162b).remove(r100);
        L6:
            return this;
        L5:
            ((ConcurrentHashMap) this.f2162b).put(r100, "long");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            this.f2163c.putString(r100, r101);
            if (TextUtils.equals(this.f2164d.getString(r100, null), r101) == false) goto L5;
            ((ConcurrentHashMap) this.f2162b).remove(r100);
        L6:
            return this;
        L5:
            ((ConcurrentHashMap) this.f2162b).put(r100, "string");
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            throw new UnsupportedOperationException("not support putStringSet");
        }

        public a(c r100, Context r101, SharedPreferences.Editor r102) {
            this.f2164d = r100;
            this.f2162b = new ConcurrentHashMap();
            this.f2161a = r101;
            this.f2163c = r102;
        }
    }

    @Override // a87.h, a87.k
    public final SharedPreferences.Editor edit() {
        return new a(this, this.f2159c, super.edit());
    }

    public c(Context r100, String r101) {
        super(r100, r101);
        this.f2160d = r101;
        this.f2159c = r100;
    }
}
