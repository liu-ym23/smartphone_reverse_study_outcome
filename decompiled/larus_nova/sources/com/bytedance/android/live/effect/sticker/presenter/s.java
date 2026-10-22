package com.bytedance.android.live.effect.sticker.presenter;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.CheckAigcBackgroundImageGenerateTaskByTaskIDResponse;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.utils.n1;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonArray;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f68368q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f68369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> f68370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Long, List<n0>> f68371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, Long> f68372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Long> f68373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f68374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Long, Sticker> f68375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f68376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f68377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, List<l>> f68378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f68379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f68380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Long, Long> f68381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Long, String> f68382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f68383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f68384p;

    public static final class a {
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f68385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f68386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f68387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f68388d;

        @Override // com.bytedance.android.live.effect.sticker.presenter.l
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            this.f68385a.add(r100);
        L8:
            Ref.IntRef r102 = this.f68386b;
            int r103 = r102.element + 1;
            r102.element = r103;
            if (r103 != this.f68387c.size()) goto L14;
            k r104 = this.f68388d;
            if (r104 == null) goto L15;
            r104.a(this.f68385a);
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r101 = false;
            goto L6
        }

        public b(List r100, Ref.IntRef r101, List r102, k r103) {
            this.f68385a = r100;
            this.f68386b = r101;
            this.f68387c = r102;
            this.f68388d = r103;
        }
    }

    public static final class c extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f68389a;

        public c(s r100) {
            this.f68389a = r100;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            if (r100 == null) goto L13;
            String r101 = r100.getSavePath() + '/' + r100.getName();
            List r102 = (List) ((LinkedHashMap) this.f68389a.f68378j).get(r100.getUrl());
            if (r102 != null) goto L6;
            r102 = CollectionsKt.emptyList();
        L6:
            Iterator r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            ((l) r103.next()).a(r101);
            goto L8
        L10:
            this.f68389a.f68378j.remove(r100.getUrl());
            this.f68389a.f68377i.put(r100.getUrl(), r101);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            if (r100 == null) goto L13;
            Map<String, List<l>> r102 = this.f68389a.f68378j;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            List r104 = (List) r103.get(r100.getUrl());
            if (r104 != null) goto L6;
            r104 = CollectionsKt.emptyList();
        L6:
            Iterator r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((l) r105.next()).a("");
            goto L8
        L10:
            this.f68389a.f68378j.remove(r100.getUrl());
            return;
        }
    }

    public static final class d implements com.bytedance.android.live.effect.api.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f68390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f68391b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f68392a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f68393b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.presenter.s$d$a$a, reason: collision with other inner class name */
            public static final class RunnableC1117a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f68394a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ List f68395b;

                /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.presenter.s$d$a$a$a, reason: collision with other inner class name */
                public static final class C1118a implements m {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ RunnableC1117a f68396a;

                    @Override // com.bytedance.android.live.effect.sticker.presenter.m
                    public final void onFail() {
                        p r100 = this.f68396a.f68394a.f68392a.f68391b;
                        if (r100 == null) goto L6;
                        r100.onFail();
                        return;
                    }

                    public C1118a(RunnableC1117a r100) {
                        this.f68396a = r100;
                    }

                    @Override // com.bytedance.android.live.effect.sticker.presenter.m
                    public final void onSuccess(Map<Long, ? extends Map<Long, AigcBackgroundImageGenerateTask>> r100) {
                        Intrinsics.checkNotNullParameter(r100, "taskMap");
                        d r101 = this.f68396a.f68394a.f68392a;
                        r101.f68390a.f68379k = true;
                        p r102 = r101.f68391b;
                        if (r102 == null) goto L6;
                        r102.onSuccess();
                        return;
                    }
                }

                public RunnableC1117a(a r100, List r101) {
                    this.f68394a = r100;
                    this.f68395b = r101;
                }

                public final void a() {
                    s r100 = this.f68394a.f68392a.f68390a;
                    List r101 = this.f68395b;
                    r100.getClass();
                    Intrinsics.checkNotNullParameter(r101, "stickers");
                    ((LinkedHashMap) r100.f68375g).clear();
                    Iterator r102 = r101.iterator();
                L4:
                    if (r102.hasNext() == false) goto L6;
                    Sticker r103 = (Sticker) r102.next();
                    r100.f68375g.put(Long.valueOf(r103.getId()), r103);
                    goto L4
                L6:
                    a r104 = this.f68394a;
                    s r105 = r104.f68392a.f68390a;
                    List r106 = r104.f68393b;
                    ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
                    Iterator r108 = r106.iterator();
                L8:
                    if (r108.hasNext() == false) goto L14;
                    Long r109 = StringsKt.toLongOrNull(((Effect) r108.next()).getEffect_id());
                    if (r109 == null) goto L12;
                    long r110 = r109.longValue();
                L13:
                    r107.add(Long.valueOf(r110));
                    goto L8
                L12:
                    r110 = 0;
                    goto L13
                L14:
                    C1118a r111 = new C1118a(this);
                    r105.getClass();
                    Intrinsics.checkNotNullParameter(r107, "effectIDList");
                    JsonArray r112 = new JsonArray();
                    Iterator r113 = r107.iterator();
                L16:
                    if (r113.hasNext() == false) goto L18;
                    r112.add(String.valueOf(((Number) r113.next()).longValue()));
                    goto L16
                L18:
                    String r114 = r112.toString();
                    RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).checkAigcBackgroundImageGenerateTaskListByEffectID(r114).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r105, r107, r111), new w(r111)), r105.f68369a);
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(d r100, List r101) {
                this.f68392a = r100;
                this.f68393b = r101;
            }

            public final void a() {
                ArrayList r100 = new ArrayList();
                ArrayList r101 = new ArrayList();
                Iterator r102 = this.f68393b.iterator();
            L4:
                if (r102.hasNext() == false) goto L10;
                Effect r103 = (Effect) r102.next();
                r100.add(com.bytedance.android.live.effect.sticker.d.b(r103));
                Long r104 = StringsKt.toLongOrNull(r103.getEffect_id());
                if (r104 == null) goto L8;
                long r105 = r104.longValue();
            L9:
                r101.add(Long.valueOf(r105));
                goto L4
            L8:
                r105 = 0;
                goto L9
            L10:
                MainThreadPostUtils.b(new RunnableC1117a(this, r100));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void onFetchFailed() {
            p r100 = this.f68391b;
            if (r100 == null) goto L6;
            r100.onFail();
            return;
        }

        public d(s r100, p r101) {
            this.f68390a = r100;
            this.f68391b = r101;
        }

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void a(List<Effect> r100, EffectDataFetchCacheType r101) {
            Intrinsics.checkNotNullParameter(r100, "effectList");
            Intrinsics.checkNotNullParameter(r101, "cacheType");
            TTExecutors.getNormalExecutor().submit(new a(this, r100));
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f68397a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f68398a;

            public a(e r100) {
                this.f68398a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Iterator<Map.Entry<Long, AigcBackgroundImageGenerateTask>> r101 = ((CheckAigcBackgroundImageGenerateTaskByTaskIDResponse) ((BaseResponse) r100).data).getTaskMap().getTaskMap().entrySet().iterator();
            L4:
                if (r101.hasNext() == false) goto L34;
                Map.Entry<Long, AigcBackgroundImageGenerateTask> r102 = r101.next();
                long r103 = r102.getKey().longValue();
                AigcBackgroundImageGenerateTask r104 = r102.getValue();
                s r105 = this.f68398a.f68397a;
                Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> r106 = r105.f68370b;
                Long r107 = (Long) ((LinkedHashMap) r105.f68372d).get(Long.valueOf(r103));
                if (r107 == null) goto L8;
                long r108 = r107.longValue();
            L9:
                com.bytedance.android.live.effect.sticker.presenter.g r109 = (com.bytedance.android.live.effect.sticker.presenter.g) ((LinkedHashMap) r106).get(Long.valueOf(r108));
                if (r109 == null) goto L25;
                Intrinsics.checkNotNullParameter(r104, "task");
                AigcBackgroundImageGenerateTask r110 = (AigcBackgroundImageGenerateTask) ((LinkedHashMap) r109.f68318a).get(Long.valueOf(r103));
                if (r110 != null) goto L15;
                ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "modify task not exist");
                goto L25
            L15:
                if (r104.getStatus() == LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L17;
            L23:
                ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "modify task must be finish and current task must be running, current is " + r110.getStatus() + " -> " + r104.getStatus());
                goto L25
            L17:
                if (r110.getStatus() != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L23;
                ((ArrayList) r109.f68319b).remove(Long.valueOf(r103));
                Iterator r111 = ((ArrayList) r109.f68320c).iterator();
            L20:
                if (r111.hasNext() == false) goto L22;
                r109.f68318a.remove(Long.valueOf(((Number) r111.next()).longValue()));
                goto L20
            L22:
                ((ArrayList) r109.f68320c).clear();
                ((ArrayList) r109.f68320c).add(Long.valueOf(r103));
                r109.f68318a.put(Long.valueOf(r103), r104);
            L25:
                if (r104.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L27;
                s.b(this.f68398a.f68397a, r104);
                s r112 = this.f68398a.f68397a;
                r112.f68372d.remove(Long.valueOf(r103));
                ((ArrayList) r112.f68373e).remove(Long.valueOf(r103));
                r112.c();
            L27:
                List r113 = (List) ((LinkedHashMap) this.f68398a.f68397a.f68371c).get(Long.valueOf(r103));
                if (r113 != null) goto L30;
                r113 = CollectionsKt.emptyList();
            L30:
                Iterator r114 = r113.iterator();
            L32:
                if (r114.hasNext() == false) goto L4;
                ((n0) r114.next()).a(r104);
                goto L32
            L8:
                r108 = 0;
                goto L9
            L34:
                s r115 = this.f68398a.f68397a;
                int r116 = s.f68368q;
                r115.c();
                this.f68398a.f68397a.l();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f68399a;

            public b(e r100) {
                this.f68399a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                s r102 = this.f68399a.f68397a;
                int r103 = s.f68368q;
                r102.c();
                this.f68399a.f68397a.l();
            }
        }

        public e(s r100) {
            this.f68397a = r100;
        }

        public final void a() {
            if (this.f68397a.f68374f == false) goto L11;
            JsonArray r100 = new JsonArray();
            Iterator r101 = ((ArrayList) this.f68397a.f68373e).iterator();
        L6:
            if (r101.hasNext() == false) goto L8;
            r100.add(String.valueOf(((Number) r101.next()).longValue()));
            goto L6
        L8:
            String r102 = r100.toString();
            RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).checkAigcBackgroundImageGenerateTaskByTaskID(r102).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this)), this.f68397a.f68369a);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Sticker f68400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f68401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f68402c;

        public f(Sticker r100, String r101, String r102) {
            this.f68400a = r100;
            this.f68401b = r101;
            this.f68402c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            List<String> r102 = com.bytedance.android.live.effect.utils.q.f68881a;
            Sticker r103 = this.f68400a;
            String r104 = this.f68401b;
            String r105 = this.f68402c;
            Intrinsics.checkNotNullParameter(r103, "sticker");
            Intrinsics.checkNotNullParameter(r104, "keyword");
            Intrinsics.checkNotNullParameter(r105, "eventPage");
            HashMap r106 = new HashMap();
            r106.put("sticker_id", String.valueOf(r103.getId()));
            r106.put("sticker_type", r103.getStickerType().getTypeName());
            com.bytedance.android.live.effect.sticker.k.f68200k.getClass();
            r106.put(MonitorConstants.CONNECT_TYPE, com.bytedance.android.live.effect.sticker.k.a.b());
            r106.put("key_word", r104);
            com.bytedance.android.live.effect.utils.q.e("livesdk_live_take_ai_sticker_effective_use", r106, r105);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f68403a = null;

        static {
            f68403a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public final void c() {
        if (((ArrayList) this.f68373e).isEmpty() == false) goto L8;
        if (this.f68374f == false) goto L11;
        this.f68374f = false;
        return;
    L11:
        return;
    L8:
        if (this.f68374f == true) goto L13;
        this.f68374f = true;
        l();
        return;
    }

    public final void l() {
        MainThreadPostUtils.c(this.f68384p, LiveEffectSettings.LIVE_EFFECT_POLLING_AIGC_TASK_INTERVAL.getValue().longValue());
    }

    public s() {
        this.f68369a = new CompositeDisposable();
        this.f68370b = new LinkedHashMap();
        this.f68371c = new LinkedHashMap();
        this.f68372d = new LinkedHashMap();
        this.f68373e = new ArrayList();
        this.f68375g = new LinkedHashMap();
        this.f68376h = LiveEffectSettings.LIVE_EFFECT_AIGC_TASK_BACKGROUND_IMAGE_TARGET_SIZE.getValue();
        this.f68377i = new LinkedHashMap();
        this.f68378j = new LinkedHashMap();
        this.f68381m = new LinkedHashMap();
        this.f68382n = new LinkedHashMap();
        this.f68383o = new c(this);
        this.f68384p = new e(this);
    }

    public static String h(String r100) {
        String r101 = DigestUtils.md5Hex(r100);
        if (StringUtils.isEmpty(r101) == false) goto L6;
        r101 = "images";
    L6:
        return r101 + ".jpeg";
    }

    public final List<String> e(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urlList");
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        String r104 = (String) ((LinkedHashMap) this.f68377i).get(r103);
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L8:
        return r101;
    }

    public final Map<Long, Map<Long, AigcBackgroundImageGenerateTask>> f(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "effectIDList");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Long> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        long r103 = r102.next().longValue();
        Long r104 = Long.valueOf(r103);
        Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> r105 = this.f68370b;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        com.bytedance.android.live.effect.sticker.presenter.g r107 = (com.bytedance.android.live.effect.sticker.presenter.g) r106.get(Long.valueOf(r103));
        if (r107 == null) goto L9;
        Map<Long, AigcBackgroundImageGenerateTask> r108 = r107.f68318a;
        if (r108 == null) goto L9;
    L10:
        r101.put(r104, r108);
    L9:
        r108 = MapsKt.emptyMap();
        goto L10
    L11:
        return r101;
    }

    public final boolean g(long r100) {
        Iterator<String> r101 = i(r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (k(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final List<String> i(long r100) {
        Map<Long, Map<Long, AigcBackgroundImageGenerateTask>> r101 = f(CollectionsKt.listOf(Long.valueOf(r100)));
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Map r103 = (Map) r102.get(Long.valueOf(r100));
        if (r103 == null) goto L8;
        Collection r104 = r103.values();
        if (r104 == null) goto L8;
        List r105 = CollectionsKt.toList(r104);
        if (r105 == null) goto L8;
    L9:
        Iterator r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L24;
        AigcBackgroundImageGenerateTask r107 = (AigcBackgroundImageGenerateTask) r106.next();
        if (r107.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L11;
        ArrayList r108 = new ArrayList();
        Iterator<ImageModel> r109 = r107.getImageList().iterator();
    L16:
        if (r109.hasNext() == false) goto L22;
        List<String> r110 = r109.next().getUrls();
        if (r110 == null) goto L16;
        String r111 = (String) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L16;
        r108.add(r111);
        goto L16
    L22:
        return r108;
    L24:
        return CollectionsKt.emptyList();
    L8:
        r105 = CollectionsKt.emptyList();
        goto L9
    }

    public final void j(p r100) {
        if (this.f68379k == false) goto L7;
        if (r100 == null) goto L9;
        r100.onSuccess();
        return;
    L9:
        return;
    L7:
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d().k(com.bytedance.android.live.effect.api.d0.f66753c, "aibackground", LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().a(), new d(this, r100));
    }

    public final boolean k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (((LinkedHashMap) this.f68377i).get(r100) == null) goto L6;
        return true;
    L6:
        String r101 = new PolarisFileWrapper(n1.a(s1.getContext()), "pixel_loop_sticker") + '/' + h(r100);
        boolean r102 = new PolarisFileWrapper(r101).exists();
        if (r102 == false) goto L9;
        this.f68377i.put(r100, r101);
    L9:
        return r102;
    }

    public static final void b(s r100, AigcBackgroundImageGenerateTask r101) {
        int r102 = r100.f68376h.intValue() - r101.getImageList().size();
        if (r102 <= 0) goto L21;
        Map<Long, Sticker> r103 = r100.f68375g;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Sticker r105 = (Sticker) r104.get(Long.valueOf(r101.getEffectID()));
        if (r105 == null) goto L14;
        Sticker.AigcEffectInfo r106 = r105.getAigcEffectInfo();
        if (r106 == null) goto L14;
        Map<String, Sticker.AigcKeywordInfo> r107 = r106.getKeywordInfoMap();
        if (r107 == null) goto L14;
        Sticker.AigcKeywordInfo r108 = r107.get(r101.getKeyWord());
        if (r108 == null) goto L14;
        List<String> r109 = r108.getDefaultUrlList();
        if (r109 == null) goto L14;
    L15:
        int r110 = 0;
    L16:
        if (r110 >= r102) goto L25;
        if (r110 >= r109.size()) goto L20;
        r101.getImageList().add(ImageModel.genBy((String) ListProtector.get(r109, r110)));
    L20:
        r110 = r110 + 1;
        goto L16
    L25:
        return;
    L14:
        r109 = CollectionsKt.emptyList();
        goto L15
    }

    public final void d(List<String> r110, k r111) {
        Intrinsics.checkNotNullParameter(r110, "urls");
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        ArrayList r101 = new ArrayList();
        ArrayList r102 = (ArrayList) r110;
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L22;
        String r104 = (String) r103.next();
        String r105 = (String) ((LinkedHashMap) this.f68377i).get(r104);
        if (r105 != null) goto L7;
        b r106 = new b(r101, r100, r110, r111);
        if (r104 == null) goto L4;
        PolarisFileWrapper r107 = new PolarisFileWrapper(n1.a(s1.getContext()), "pixel_loop_sticker");
        String r108 = h(r104);
        if (k(r104) == true) goto L15;
        if (this.f68378j.containsKey(r104) == true) goto L18;
        this.f68378j.put(r104, CollectionsKt.mutableListOf(new l[]{r106}));
        DownloadTask r109 = Downloader.with(s1.getContext()).url(r104).name(r108).savePath(r107.getPath()).monitorScene("live_pixel_loop_sticker");
        r109.addDownloadListener(this.f68383o.hashCode(), this.f68383o, ListenerType.MAIN, false);
        r109.download();
        goto L4
    L18:
        List r112 = (List) ((LinkedHashMap) this.f68378j).get(r104);
        if (r112 == null) goto L4;
        r112.add(r106);
        goto L4
    L15:
        String r113 = r107 + '/' + r108;
        this.f68377i.put(r104, r113);
        r106.a(r113);
        goto L4
    L7:
        r101.add(r105);
        int r114 = r100.element + 1;
        r100.element = r114;
        if (r114 != r102.size()) goto L4;
        r111.a(r101);
        goto L4
    }

    public static final void a(s r100, long r101, long r102) {
        List<Long> r103 = r100.f68373e;
        ArrayList r104 = (ArrayList) r103;
        if (r104.contains(Long.valueOf(r102)) == true) goto L7;
        r100.f68372d.put(Long.valueOf(r102), Long.valueOf(r101));
        List<Long> r105 = r100.f68373e;
        ArrayList r106 = (ArrayList) r105;
        r106.add(Long.valueOf(r102));
        r100.c();
        return;
    }

    public final void m(Sticker r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "keyWord");
        Intrinsics.checkNotNullParameter(r102, "eventPage");
        long r103 = r100.getId();
        this.f68381m.put(Long.valueOf(r103), Long.valueOf(SystemClock.elapsedRealtime()));
        this.f68382n.put(Long.valueOf(r103), r101);
        Disposable r104 = this.f68380l;
        if (r104 != null) goto L5;
    L9:
        this.f68380l = Observable.timer(LiveEffectSettings.LIVE_FACE_STICKER_EFFECTIVELY_USE_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r100, r101, r102), g.f68403a);
        return;
    L5:
        if (r104.isDisposed() == true) goto L9;
        Disposable r105 = this.f68380l;
        if (r105 == null) goto L9;
        r105.dispose();
        goto L9
    }
}
