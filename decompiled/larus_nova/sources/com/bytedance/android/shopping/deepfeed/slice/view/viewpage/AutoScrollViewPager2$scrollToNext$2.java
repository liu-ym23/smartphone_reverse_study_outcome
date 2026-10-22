package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"doStep", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AutoScrollViewPager2$scrollToNext$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AutoScrollViewPager2$scrollToNext$1 $finishScroll$1;
    final /* synthetic */ long $frameInterval;
    final /* synthetic */ float $pageHeight;
    final /* synthetic */ Ref.LongRef $step;
    final /* synthetic */ long $steps;
    final /* synthetic */ Ref.FloatRef $totalDragged;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.viewpage.AutoScrollViewPager2$scrollToNext$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ AutoScrollViewPager2$scrollToNext$2 this$0;

        public AnonymousClass1(AutoScrollViewPager2$scrollToNext$2 r100) {
            this.this$0 = r100;
            super(0, null, "doStep", "invoke()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.invoke2();
        }
    }

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f173668a;

        public a(Function0 r100) {
            this.f173668a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f173668a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AutoScrollViewPager2$scrollToNext$2(com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a r100, Ref.LongRef r101, long r102, AutoScrollViewPager2$scrollToNext$1 r103, float r104, Ref.FloatRef r105, long r106) {
        this.this$0 = r100;
        this.$step = r101;
        this.$steps = r102;
        this.$finishScroll$1 = r103;
        this.$pageHeight = r104;
        this.$totalDragged = r105;
        this.$frameInterval = r106;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a r100 = this.this$0;
        boolean r101 = false;
        if (r100.f173675c == false) goto L7;
        r100.f173674b = false;
        return;
    L7:
        if (this.$step.element < this.$steps) goto L24;
        this.$finishScroll$1.invoke2();
        return;
    L24:
    L20:
        this.$finishScroll$1.invoke2();
        return;
    L9:
        if (r100.f173680h.isFakeDragging() == true) goto L12;
        this.$finishScroll$1.invoke2();     // Catch: IllegalStateException -> L20
        return;
    L12:
        long r102 = this.$step.element;     // Catch: IllegalStateException -> L20
        long r103 = this.$steps;     // Catch: IllegalStateException -> L20
        if (r102 != (r103 - 1)) goto L15;
        r101 = true;
    L15:
        if (r101 == false) goto L17;
        float r104 = -(this.$pageHeight + this.$totalDragged.element);
    L18:
        this.this$0.f173680h.fakeDragBy(r104);     // Catch: IllegalStateException -> L20
        this.$totalDragged.element += r104;     // Catch: IllegalStateException -> L20
        this.$step.element++;
        this.this$0.f173673a.postDelayed(new a(new AnonymousClass1(this)), this.$frameInterval);
        return;
    L17:
        r104 = (-this.$pageHeight) / r103;     // Catch: IllegalStateException -> L20
        goto L18
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
