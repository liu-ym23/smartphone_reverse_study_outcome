package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class EventDispatcher implements o, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f169036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<p> f169037b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventDispatcher f169038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f169039b;

        @Override // java.lang.Runnable
        public final void run() {
            List<p> r100 = this.f169038a.f169037b;     // Catch: Throwable -> L6
            ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L6
            if (r101.contains(this.f169039b) == true) goto L9;
            List<p> r102 = this.f169038a.f169037b;     // Catch: Throwable -> L6
            ArrayList r103 = (ArrayList) r102;     // Catch: Throwable -> L6
            r103.add(this.f169039b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(EventDispatcher r100, p r101) {
            this.f169038a = r100;
            this.f169039b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventDispatcher f169040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f169041b;

        public b(EventDispatcher r100, p r101) {
            this.f169040a = r100;
            this.f169041b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<p> r100 = this.f169040a.f169037b;     // Catch: Throwable -> L4
            ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
            r101.remove(this.f169041b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void e() {
        b(EventDispatcher$onHiddenCellShow$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void k() {
        b(EventDispatcher$hideWireFrame$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void m() {
        b(EventDispatcher$onHeadInVisible$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onDestroy() {
        b(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPause() {
        b(C103191.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onResume() {
        b(C103201.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void s() {
        b(EventDispatcher$onBeginTransit$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void t() {
        b(EventDispatcher$onHeadVisible$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void u() {
        b(EventDispatcher$onFooterInvoke$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void v() {
        b(EventDispatcher$onStartVideoPlay$1.INSTANCE);
    }

    public EventDispatcher() {
        this.f169037b = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void A(final boolean r100) {
        b(new EventDispatcher$onEndTransit$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void a(final boolean r100) {
        b(new EventDispatcher$onDragProgressStateChange$1(r100));
    }

    public final void b(Function1<? super p, Unit> r100) {
        this.f169036a = true;
        Iterator r101 = ((ArrayList) this.f169037b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    L6:
        this.f169036a = false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void c(final boolean r100) {
        b(new EventDispatcher$onSmallModeChange$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void f(final boolean r100) {
        b(new EventDispatcher$onVideoPlayStateChange$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void h(final boolean r100) {
        b(new EventDispatcher$onHeadAICombinationStateChange$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void i(final float r100) {
        b(new EventDispatcher$onTransit$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void onPageSelected(final int r100) {
        b(new C103181(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void p(final String r100) {
        b(new EventDispatcher$onSkuSelected$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void q(final AnchorV4HeadV2VO r100) {
        Intrinsics.checkNotNullParameter(r100, "headVo");
        b(new EventDispatcher$onDataSet$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void w(final int r100) {
        b(new EventDispatcher$onBeforeOpenGallery$1(r100));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
    public final void x(p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a r101 = new a(this, r100);
        if (this.f169036a == false) goto L5;
        Lazy r102 = UIUtils.f45548a;
        UIUtils.c().post(r101);
        return;
    L5:
        r101.run();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.o
    public final boolean z(p r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f169036a == false) goto L6;
        boolean r101 = ((ArrayList) this.f169037b).contains(r100);
        Lazy r102 = UIUtils.f45548a;
        UIUtils.c().post(new b(this, r100));
        return r101;
    L6:
        return ((ArrayList) this.f169037b).remove(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void d(final boolean r100, final int r101) {
        b(new EventDispatcher$onFoldableTabStatusUpdate$1(r100, r101));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void n(final int r100, final Boolean r101) {
        b(new EventDispatcher$trySelectPage$1(r100, r101));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p
    public final void j(final int r100, final ImageInfo r101, final boolean r102, final int r103) {
        b(new EventDispatcher$onBitmapLoaded$1(r100, r101, r102, r103));
    }
}
