package bwa;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.annotation.AppConfigPriority;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class p extends c0c.b implements awa.c, awa.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.passportc.api.j f21266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final awa.a f21267c;

    @Inject
    public p(com.ss.android.lark.passportc.api.j r100, awa.a r101) {
        super(r100);
        this.f21267c = r101;
        com.ss.android.lark.passportc.api.h.a(this);
    }

    @Override // awa.c
    public final int T1(String r100, Class<?> r101) {
        Integer r102 = (Integer) sf(r101, Integer.class);
        if (r102 != null) goto L5;
        String r103 = tf(r100, r101);
        return CastIntegerProtector.parseInt(r103);
    L9:
        e = move-exception;
        Log.e("GlobalSettingManager", "failed to parseInt, value: " + r103 + ", e:" + e);
        return 0;
    L5:
        return r102.intValue();
    }

    @Override // awa.c
    public final String V5(String r100, Class<?> r101) {
        String r102 = (String) sf(r101, String.class);
        if (r102 == null) goto L5;
        return r102;
    L5:
        String r103 = tf(r100, r101);
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103;
    }

    @Override // awa.c
    public final long b4(String r100, Class<?> r101) {
        Long r102 = (Long) sf(r101, Long.class);
        if (r102 != null) goto L5;
        String r103 = tf(r100, r101);
        return CastLongProtector.parseLong(r103);
    L9:
        e = move-exception;
        Log.e("GlobalSettingManager", "failed to parseInt, value: " + r103 + ", e:" + e);
        return 0;
    L5:
        return r102.longValue();
    }

    @Override // awa.c
    public final double m6(String r100, Class<?> r101) {
        Double r102 = (Double) sf(r101, Double.class);
        if (r102 != null) goto L5;
        String r103 = tf(r100, r101);
        return CastDoubleProtector.parseDouble(r103);
    L9:
        e = move-exception;
        Log.e("GlobalSettingManager", "failed to parseDouble, value: " + r103 + ", e:" + e);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        return r102.doubleValue();
    }

    @Override // awa.c
    public final boolean s3(String r100, Class<?> r101) {
        Boolean r102 = (Boolean) sf(r101, Boolean.class);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return Boolean.valueOf(tf(r100, r101)).booleanValue();
    }

    public final <T> T sf(Class<?> r100, Class<T> r101) {
        AppConfig r102 = com.ss.android.lark.appsetting.api.e.a.f408951a.b(r100);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L12;
        return null;
    L12:
        return (T) rf(r102, r100, r101);
    L5:
        if (r102.priority() != AppConfigPriority.LIBRA_FIRST) goto L7;
        r103 = true;
        goto L8
    }

    public final String tf(String r100, Class<?> r101) {
        if (r101 == null) goto L10;
        com.ss.android.lark.appsetting.api.e r102 = com.ss.android.lark.appsetting.api.e.a.f408951a;
        AppConfig r103 = r102.b(r101);
        if (r103 != null) goto L9;
        Log.e("GlobalSettingManager", "failed to get setting config, param clazz must be isAnnotationPresent by AppConfig Annotation.");
        return "";
    L9:
        return r102.c(r100, r103.key(), r103.needDiskCache());
    L10:
        Log.e("GlobalSettingManager", "failed to get setting config, param clazz mustn't be null.");
        throw new IllegalArgumentException("param clazz is null.");
    }

    @Override // awa.c
    public final <T> T y0(String r100, Class<T> r101) {
        if (r101 == null) goto L38;
        com.ss.android.lark.appsetting.api.e r102 = com.ss.android.lark.appsetting.api.e.a.f408951a;
        AppConfig r103 = r102.b(r101);
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == true) goto L14;
        T r105 = (T) r102.a(r100, r101.getName());
        if (r105 == null) goto L17;
        return r105;
    L17:
        String r106 = tf(r100, r101);
        if (TextUtils.isEmpty(r106) == false) goto L21;
        Log.i("GlobalSettingManager", "failed to get setting config, clazz:" + r101 + ", value:" + r106);
        int r107 = zva.b.f573773a;
        return (T) zva.b.a.b(r101);
    L21:
        if (r103 != null) goto L24;
        Log.i("GlobalSettingManager", "failed to get AppConfig object, AppConfig is null");
        int r108 = zva.b.f573773a;
        return (T) zva.b.a.b(r101);
    L24:
        T r109 = (T) com.ss.android.lark.appsetting.api.f.a(r101, r106, r103.parse());
        if (r104 == false) goto L27;
        return r109;
    L27:
        String r110 = r101.getName();
        if (TextUtils.isEmpty(r100) == false) goto L30;
        Log.w("SettingCacheService", "put settings form absent_user, className: ".concat(r110));
        r100 = "absent_user";
    L30:
        Reference r111 = (Reference) ((HashMap) r102.f408949c).get(r100);
        if (r111 != null) goto L33;
        r111 = new SoftReference(new HashMap());
        ((HashMap) r102.f408949c).put(r100, r111);
    L33:
        Map r112 = (Map) r111.get();
        if (r112 != null) goto L36;
        r112 = new HashMap();
        ((HashMap) r102.f408949c).put(r100, new SoftReference(r112));
    L36:
        r112.put(r110, r109);
        return r109;
    L14:
        T r113 = (T) rf(r103, r101, r101);
        if (r113 == null) goto L17;
        return r113;
    L7:
        if (r103.priority() != AppConfigPriority.LIBRA_FIRST) goto L9;
        r104 = true;
        goto L10
    L38:
        Log.e("GlobalSettingManager", "failed to get setting config, param clazz mustn't be null.");
        throw new IllegalArgumentException("param clazz is null.");
    }

    @Override // awa.c
    public final void Bd(String r100, Class r101, IGetDataCallback<Double> r102) {
        x3(r100, r101, LarkRxSchedulers.io(), LarkRxSchedulers.mainThread(), r102);
    }

    @Override // awa.c
    public final void C9(String r100, Class r101, IGetDataCallback<String> r102) {
        x3(r100, r101, LarkRxSchedulers.io(), LarkRxSchedulers.mainThread(), r102);
    }

    @Override // awa.c
    public final <T> void M5(String r100, Class<T> r101, IGetDataCallback<T> r102) {
        x3(r100, r101, LarkRxSchedulers.io(), LarkRxSchedulers.mainThread(), r102);
    }

    @Override // awa.c
    public final void k9(String r100, Class r101, IGetDataCallback<Integer> r102) {
        x3(r100, r101, LarkRxSchedulers.io(), LarkRxSchedulers.mainThread(), r102);
    }

    @Override // awa.c
    public final String q0(String r100, String r101, boolean r102) {
        return com.ss.android.lark.appsetting.api.e.a.f408951a.c(r100, r101, r102);
    }

    public final <T> T rf(AppConfig r100, Class<?> r101, Class<T> r102) {
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L21;
        return null;
    L21:
        T r104 = (T) this.f21267c.a(r100.key(), r101, r102);
        if (r104 != null) goto L14;
    L17:
        return r104;
    L14:
        if (r102.isInstance(r104) == true) goto L17;
        Log.e("GlobalSettingManager", "external config type mismatch, key: " + r100.key() + ", expected: " + r102.getName() + ", actual: " + r104.getClass().getName());     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        Log.e("GlobalSettingManager", "failed to get external config, key: " + r100.key() + ", valueClass: " + r102.getName(), th);
        return null;
    L5:
        if (r100.priority() != AppConfigPriority.LIBRA_FIRST) goto L7;
        r103 = true;
        goto L9
    }

    @Override // awa.c
    public final void sc(String r100, Class r101, IGetDataCallback<Boolean> r102) {
        x3(r100, r101, LarkRxSchedulers.io(), LarkRxSchedulers.mainThread(), r102);
    }

    @Override // awa.c
    public final void D7(final String r100, final Class r101, Scheduler r102, Scheduler r103, final IGetDataCallback<Double> r104) {
        Observable.create(new a(this, r100, r101)).subscribeOn(r102).observeOn(r103).subscribe(new g(r104), new h(r104));
    }

    @Override // awa.c
    public final void f7(final String r100, final Class r101, Scheduler r102, Scheduler r103, final IGetDataCallback<Integer> r104) {
        Observable.create(new d(this, r100, r101)).subscribeOn(r102).observeOn(r103).subscribe(new e(r104), new f(r104));
    }

    @Override // awa.c
    public final void m2(final String r100, final Class r101, Scheduler r102, Scheduler r103, final IGetDataCallback<Boolean> r104) {
        Observable.create(new o(this, r100, r101)).subscribeOn(r102).observeOn(r103).subscribe(new b(r104), new c(r104));
    }

    @Override // awa.c
    public final void p5(final String r100, final Class r101, Scheduler r102, Scheduler r103, final IGetDataCallback<String> r104) {
        Observable.create(new i(this, r100, r101)).subscribeOn(r102).observeOn(r103).subscribe(new j(r104), new k(r104));
    }

    @Override // awa.c
    public final <T> void x3(final String r100, final Class<T> r101, Scheduler r102, Scheduler r103, final IGetDataCallback<T> r104) {
        Observable.create(new l(this, r100, r101)).subscribeOn(r102).observeOn(r103).subscribe(new m(r104), new n(r104));
    }
}
