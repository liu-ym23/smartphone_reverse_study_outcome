package com.bytedance.android.livesdk.dslservice;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.dslservice.gecko.GeckoUtils;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.util.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import dt2.e;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yt1.n;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/TriangleServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TriangleServiceWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f122809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<du1.a> f122810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f122811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f122812d;

    public static final class a implements du1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TriangleServiceWidget f122813a;

        @Override // du1.a
        public final boolean a() {
            return y3.m(this.f122813a.dataCenter).n(ToolbarButton.COMMERCE);
        }

        public a(TriangleServiceWidget r100) {
            this.f122813a = r100;
        }

        @Override // du1.a
        public final void preLoad(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            q r101 = iv1.a.a(this.f122813a.dataCenter, 2);
            if (r101 == null) goto L10;
            j<n> r102 = r101.E1();
            if (r102 == null) goto L11;
            n r103 = r102.getValue();
            if (r103 == null) goto L12;
            r103.g(r100);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TriangleServiceWidget f122814a;

        public b(TriangleServiceWidget r100) {
            this.f122814a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TriangleServiceWidget.wq(this.f122814a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TriangleServiceWidget f122815a;

        public c(TriangleServiceWidget r100) {
            this.f122815a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            TriangleServiceWidget.wq(this.f122815a);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TriangleServiceWidget f122816a;

        public d(TriangleServiceWidget r100) {
            this.f122816a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.dslservice.util.a.f122964d.h("livesdk_dsl_low_memory_clear_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("level", String.valueOf(((Integer) r100).intValue())), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCORE, (String) this.f122816a.f122812d.getValue())}));
            f.f122938a.b().evictAll();
            f.f122939b.b().evictAll();
            cu1.a.f465417b.b().evictAll();
            SlcRenderContext r101 = com.bytedance.android.livesdk.dslservice.slice.cache.b.f122934a;
            if (r101 == null) goto L5;
            r101.d();
        L5:
            com.bytedance.android.livesdk.dslservice.slice.cache.b.f122934a = null;
        }
    }

    public TriangleServiceWidget() {
        this.f122810b = new ArrayList();
        this.f122812d = LazyKt.lazy(TriangleServiceWidget$score$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.f122810b.add(new a(this));
        int r100 = Build.VERSION.SDK_INT;
        String r101 = null;
        if (r100 < 23) goto L16;
        Integer r102 = e.f469999a.getValue();
        if (r102 == null) goto L16;
        if (r102.intValue() != 1) goto L16;
        k r103 = new k(new b(this));
        if (r100 >= 23) goto L12;
    L14:
        r103 = null;
    L15:
        this.f122809a = r103;
    L17:
        com.bytedance.android.livesdk.dslservice.util.c r104 = com.bytedance.android.livesdk.dslservice.util.c.f122968b;
        d r105 = new d(this);
        Intrinsics.checkNotNullParameter(r105, "callback");
        com.bytedance.android.livesdk.dslservice.util.c.f122967a = r105;
        jc1.a.b().registerComponentCallbacks(r104);
        q r106 = iv1.a.a(this.dataCenter, 2);
        if (r106 == null) goto L24;
        j<zt1.c> r107 = r106.G1();
        if (r107 == null) goto L24;
        zt1.c r108 = r107.getValue();
        if (r108 == null) goto L24;
        r108.b();
    L24:
        m<IRoom> r109 = IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), this.dataCenter, 0, 2).getRoom();
        if (r109 == null) goto L29;
        IRoom r110 = r109.getValue();
        if (r110 == null) goto L29;
        r101 = r110.getIdStr();
    L29:
        this.f122811c = r101;
        return;
    L12:
        if (r103.f122993a == true) goto L14;
        r103.f122993a = true;
        ALogger.i("IdleTaskHandler", "start");
        Looper.getMainLooper().getQueue().removeIdleHandler((MessageQueue.IdleHandler) r103.f122995c.getValue());
        Looper.getMainLooper().getQueue().addIdleHandler((MessageQueue.IdleHandler) r103.f122995c.getValue());
    L16:
        ((ObservableSubscribeProxy) Observable.timer(6, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new c(this));
        goto L17
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.dslservice.util.c r100 = com.bytedance.android.livesdk.dslservice.util.c.f122968b;
        com.bytedance.android.livesdk.dslservice.util.c.f122967a = null;
        jc1.a.b().unregisterComponentCallbacks(r100);
        k r101 = this.f122809a;
        if (r101 != null) goto L5;
    L9:
        GeckoUtils.f122825a.clear();
        String r102 = this.f122811c;
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        ALogger.i("TriangleManager", "onDestroy room=".concat(r102));
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r101.f122993a == false) goto L9;
        r101.f122993a = false;
        Looper.getMainLooper().getQueue().removeIdleHandler((MessageQueue.IdleHandler) r101.f122995c.getValue());
        goto L9
    }

    public static final void wq(TriangleServiceWidget r100) {
        Iterator<du1.a> r101 = r100.f122810b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        du1.a r102 = r101.next();
        if (r102.a() == false) goto L4;
        r102.preLoad(r100.context);
        goto L4
    }
}
