package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public class TuningEffectAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.ktv.common.model.bean.h> f70503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f70504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f70505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadTask f70507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f70508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f70509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70510h;

    public static final class a {
    }

    public static final class b extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SingleEmitter<String> f70511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f70512b;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            super.onSuccessed(r100);
            this.f70511a.onSuccess(this.f70512b);
        }

        public b(SingleEmitter<String> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            Intrinsics.checkNotNullParameter(r101, "filePath");
            this.f70511a = r100;
            this.f70512b = r101;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            super.onFailed(r100, r101);
            f2.b(R.string.ttlive_ktv_tuning_effect_download_failed, 0);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningEffectAbility f70513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.h f70514b;

        public c(TuningEffectAbility r100, com.bytedance.android.live.ktv.common.model.bean.h r101, boolean r102) {
            this.f70513a = r100;
            this.f70514b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f70513a.h(this.f70514b);
            Disposable r102 = this.f70513a.f70504b;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.isDisposed() == true) goto L9;
            r102.dispose();
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f70515a = null;

        static {
            f70515a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningEffectAbility f70516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.h f70517b;

        public e(TuningEffectAbility r100, com.bytedance.android.live.ktv.common.model.bean.h r101) {
            this.f70516a = r100;
            this.f70517b = r101;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<String> r110) {
            Intrinsics.checkNotNullParameter(r110, "it");
            TuningEffectAbility r100 = this.f70516a;
            com.bytedance.android.live.ktv.common.model.bean.h r101 = this.f70517b;
            r100.getClass();
            StringBuilder r102 = new StringBuilder(r100.f70510h);
            r102.append(r101.d());
            String r103 = File.separator;
            r102.append(r103);
            r102.append(r101.d());
            r102.append("_version_");
            r102.append(r101.f());
            r102.append(InvRouter.FLOW_SUFFIX);
            String r104 = r102.toString();
            if (new PolarisFileWrapper(r104).exists() == false) goto L5;
            r110.onSuccess(r104);
            return;
        L5:
            this.f70516a.getClass();
            FileUtils.removeDir(new PolarisFileWrapper(r104));
            TuningEffectAbility r105 = this.f70516a;
            r105.f70507e = null;
            Integer r106 = r105.f70508f;
            if (r106 == null) goto L8;
            Downloader.getInstance(s1.getContext()).cancel(r106.intValue());
        L8:
            TuningEffectAbility r107 = this.f70516a;
            com.bytedance.android.live.ktv.common.model.bean.h r108 = this.f70517b;
            r107.getClass();
            List<String> r109 = r108.b().getUrls();
            if (CollectionsKt.getLastIndex(r109) < 0) goto L11;
            Object r111 = ListProtector.get(r109, 0);
        L12:
            TuningEffectAbility r112 = this.f70516a;
            DownloadTask r113 = Downloader.with(s1.getContext()).url((String) r111);
            this.f70516a.getClass();
            int r114 = StringsKt.lastIndexOf$default(r104, HTTP.URL_DEFAULT, 0, false, 6, null);
            if (r114 == (-1)) goto L18;
            if (r104 == null) goto L17;
            String r115 = r104.substring(r114);
        L19:
            DownloadTask r116 = r113.name(r115);
            TuningEffectAbility r117 = this.f70516a;
            r117.getClass();
            int r118 = StringsKt.lastIndexOf$default(r104, HTTP.URL_DEFAULT, 0, false, 6, null);
            if (r118 == (-1)) goto L25;
            if (r104 == null) goto L24;
            String r119 = r104.substring(0, r118);
        L26:
            r112.f70507e = r116.savePath(r119).monitorScene("musicpack_tuningeffect");
            DownloadTask r120 = this.f70516a.f70507e;
            if (r120 == null) goto L42;
            r120.autoRemoveCallback(true);
        L42:
            Class r121 = a();     // Catch: Exception -> L31
            Object r122 = r121.newInstance();     // Catch: Exception -> L31
            Method r123 = r121.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L31
            r123.setAccessible(true);     // Catch: Exception -> L31
            r123.invoke(r122, new Object[]{Integer.valueOf(AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE)});     // Catch: Exception -> L31
        L33:
            this.f70516a.f70509g = new b(r110, r104);
            TuningEffectAbility r124 = this.f70516a;
            DownloadTask r125 = r124.f70507e;
            if (r125 == null) goto L36;
            r125.mainThreadListener(r124.f70509g);
        L36:
            TuningEffectAbility r126 = this.f70516a;
            DownloadTask r127 = r126.f70507e;
            if (r127 == null) goto L39;
            Integer r128 = Integer.valueOf(r127.download());
        L40:
            r126.f70508f = r128;
            return;
        L39:
            r128 = null;
        L31:
            e = move-exception;
            String r129 = "set cache life time max fail : " + e.getMessage();
            ALogger.i(bb0.b.b(), r129 + ", invoke class :" + TuningEffectAbility.class.getSimpleName());
            goto L33
        L24:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L25:
            r119 = r117.f70510h + "none" + r103;
            goto L26
        L17:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L18:
            r115 = "none.json";
            goto L19
        L11:
            r111 = "";
            goto L12
        }
    }

    public static final class f<T> implements FlowableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningEffectAbility f70518a;

        public f(TuningEffectAbility r100) {
            this.f70518a = r100;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<List<com.bytedance.android.live.ktv.common.model.bean.h>> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            List<String> r101 = com.bytedance.android.livesdk.sharedpref.c.f158284m.getValue();
            ((CopyOnWriteArrayList) this.f70518a.f70503a).clear();
            Iterator<T> r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            String r103 = (String) r102.next();
            com.bytedance.android.live.ktv.common.model.bean.h r104 = (com.bytedance.android.live.ktv.common.model.bean.h) GsonProtectorUtils.fromJson(new Gson(), r103, com.bytedance.android.live.ktv.common.model.bean.h.class);
            r104.f69999a = false;
            ((CopyOnWriteArrayList) this.f70518a.f70503a).add(r104);
            goto L4
        L6:
            r100.onNext(this.f70518a.f70503a);
            r100.onComplete();
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningEffectAbility f70519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cc0.b f70520b;

        public g(TuningEffectAbility r100, cc0.b r101) {
            this.f70519a = r100;
            this.f70520b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List<com.bytedance.android.live.ktv.common.model.bean.h> r101 = (List) r100;
            this.f70519a.getClass();
            TuningEffectAbility.f(r101);
            this.f70520b.onLocalTuningEffectsSuccess(r101);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningEffectAbility f70521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cc0.b f70522b;

        public h(TuningEffectAbility r100, cc0.b r101) {
            this.f70521a = r100;
            this.f70522b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TuningEffectAbility.f(this.f70521a.f70503a);
            this.f70522b.onLocalTuningEffectsFailed();
            pb0.a r101 = pb0.b.f528406a;
            pb0.b.b("TuningEffectAbility", (Throwable) r100);
        }
    }

    static {
    }

    public void h(com.bytedance.android.live.ktv.common.model.bean.h r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    public final com.bytedance.android.live.ktv.common.model.bean.h c() {
        Iterator r100 = ((CopyOnWriteArrayList) this.f70503a).iterator();
    L3:
        Object r101 = null;
        if (r100.hasNext() == false) goto L8;
        Object r102 = r100.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.model.bean.h) r102).d(), e()) == false) goto L3;
    L9:
        com.bytedance.android.live.ktv.common.model.bean.h r103 = (com.bytedance.android.live.ktv.common.model.bean.h) r102;
        if (r103 != null) goto L18;
        Iterator r104 = ((CopyOnWriteArrayList) this.f70503a).iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.model.bean.h) r105).d(), d()) == false) goto L13;
        r101 = r105;
    L17:
        r103 = (com.bytedance.android.live.ktv.common.model.bean.h) r101;
    L18:
        if (r103 == null) goto L20;
        return r103;
    L20:
        return (com.bytedance.android.live.ktv.common.model.bean.h) CollectionsKt.getOrNull(this.f70503a, 0);
    L8:
        r102 = null;
        goto L9
    }

    public String d() {
        return com.bytedance.android.livesdk.sharedpref.c.f158300r0.getValue();
    }

    public String e() {
        return com.bytedance.android.livesdk.sharedpref.c.f158260e.getValue();
    }

    public TuningEffectAbility() {
        this.f70503a = new CopyOnWriteArrayList();
        this.f70506d = LazyKt.lazy(TuningEffectAbility$compositeDisposable$2.INSTANCE);
        StringBuilder r100 = new StringBuilder(KtvCommonConfigParams.a());
        String r101 = File.separator;
        r100.append(r101);
        r100.append("ktv_tunings");
        r100.append(r101);
        this.f70510h = r100.toString();
    }

    public static void f(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (r100.isEmpty() == false) goto L5;
    L6:
        ListProtector.add(r100, 0, new com.bytedance.android.live.ktv.common.model.bean.h("none", "原声", qy.a.c(), qy.a.c(), 1, false));
        return;
    L5:
        if (((com.bytedance.android.live.ktv.common.model.bean.h) ListProtector.get(r100, 0)).g() == false) goto L6;
    }

    public final Disposable g(cc0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "loadTuningEffectCallback");
        return Flowable.create(new f(this), BackpressureStrategy.BUFFER).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r100), new h(this, r100));
    }

    public void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        com.bytedance.android.livesdk.sharedpref.e<String> r101 = com.bytedance.android.livesdk.sharedpref.c.f158300r0;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r100);
    }

    public void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        com.bytedance.android.livesdk.sharedpref.e<String> r101 = com.bytedance.android.livesdk.sharedpref.c.f158260e;
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r100);
    }

    public final Disposable k(final cc0.b r100) {
        int r101 = dc0.a.f467842a;
        dc0.a r102 = dc0.a.b.f467843a;
        long r103 = System.currentTimeMillis();
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.bean.c>, Unit> r104 = new TuningEffectAbility$syncTuningEffects$1(this, r100);
        Function1<Throwable, Unit> r105 = new TuningEffectAbility$syncTuningEffects$2(this, r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "successCallback");
        Intrinsics.checkNotNullParameter(r105, "failCallback");
        return ((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).getTuningInfoList().compose(RxUtil.rxSchedulerHelper()).subscribe(new dc0.b(r103, r104), new dc0.c(r103, r105));
    }

    public final void a(com.bytedance.android.live.ktv.common.model.bean.h r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Disposable r102 = this.f70504b;
        if (r102 != null) goto L5;
    L7:
        this.f70504b = Observable.timer(30, TimeUnit.SECONDS).subscribe(new c(this, r100, r101), d.f70515a);
        if (r101 == false) goto L11;
        ALogger.d("TuningEffectAbility", "update ktv user manual selected : " + r100.d());
        j(r100.d());
        return;
    L11:
        return;
    L5:
        if (r102.isDisposed() == true) goto L7;
        r102.dispose();
        goto L7
    }

    public final void b(com.bytedance.android.live.ktv.common.model.bean.h r100, cc0.c r101) {
        Intrinsics.checkNotNullParameter(r100, "tuningEffectItem");
        Intrinsics.checkNotNullParameter(r101, "tuningEffectDownloadCallback");
        if (r100.g() == false) goto L6;
        r101.a("");
        return;
    L6:
        Disposable r102 = this.f70505c;
        if (r102 == null) goto L9;
        ((CompositeDisposable) this.f70506d.getValue()).remove(r102);
    L9:
        Single r103 = Single.create(new e(this, r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final TuningEffectAbility$downLoadTuningEffect$3 r104 = new TuningEffectAbility$downLoadTuningEffect$3(r101);
        Disposable r105 = r103.subscribe(new i(r104));
        if (r105 == null) goto L12;
        RxUtilKt.c(r105, (CompositeDisposable) this.f70506d.getValue());
    L13:
        this.f70505c = r105;
        return;
    L12:
        r105 = null;
        goto L13
    }
}
