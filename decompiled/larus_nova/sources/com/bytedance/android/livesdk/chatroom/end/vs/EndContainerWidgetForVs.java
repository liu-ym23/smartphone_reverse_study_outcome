package com.bytedance.android.livesdk.chatroom.end.vs;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.event.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import fq1.f;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vg1.c;
import vg1.d;
import vg1.e;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/vs/EndContainerWidgetForVs;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvg1/e;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EndContainerWidgetForVs extends LiveRecyclableWidget implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f106180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vg1.a f106181b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EndContainerWidgetForVs f106182a;

        public a(EndContainerWidgetForVs r100) {
            this.f106182a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if ((((o) r100) instanceof o) == false) goto L6;
            this.f106182a.getClass();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.end.vs.EndContainerWidgetForVs$onInit$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(EndContainerWidgetForVs r100) {
            super(0, r100, EndContainerWidgetForVs.class, "onLoadStart", "onLoadStart()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EndContainerWidgetForVs) this.receiver).getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.end.vs.EndContainerWidgetForVs$onInit$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(EndContainerWidgetForVs r100) {
            super(0, r100, EndContainerWidgetForVs.class, "onHybridViewPageFinished", "onHybridViewPageFinished()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EndContainerWidgetForVs r100 = (EndContainerWidgetForVs) this.receiver;
            if (r100.isViewValid() == false) goto L9;
            ViewGroup r101 = r100.f106180a;
            if (r101 == null) goto L10;
            r101.setVisibility(0);
            return;
        L10:
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.end.vs.EndContainerWidgetForVs$onInit$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(EndContainerWidgetForVs r100) {
            super(0, r100, EndContainerWidgetForVs.class, "error", "error()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((EndContainerWidgetForVs) this.receiver).getClass();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_vs_end_container;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public EndContainerWidgetForVs() {
        this.f106181b = new vg1.a();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        vg1.a r100 = this.f106181b;
        HybridCard r101 = r100.f554664b;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        r100.f554664b = null;
        ViewGroup r102 = r100.f554665c;
        if (r102 == null) goto L9;
        r102.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f106180a = (ViewGroup) findViewById(R.id.hybrid_container);
        vg1.a r101 = this.f106181b;
        AnonymousClass1 r102 = new AnonymousClass1(this);
        AnonymousClass2 r103 = new AnonymousClass2(this);
        AnonymousClass3 r104 = new AnonymousClass3(this);
        r101.f554667e = r103;
        r101.f554668f = r104;
        r101.f554666d = r102;
        r101.f554669g = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100[0];
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r101 = r102;
    L10:
        String r103 = (String) r101;
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        if (r100 == null) goto L19;
        if (r100.length <= 1) goto L19;
        this.f106181b.f554663a = (IRoom) r100[1];
    L19:
        if (r103.length() <= 0) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L38;
        ViewGroup r105 = this.f106180a;
        if (r105 == null) goto L38;
        vg1.a r106 = this.f106181b;
        int r107 = vg1.a.f554662h;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r103, "schema");
        Intrinsics.checkNotNullParameter(r105, KtvSubElement.CONTAINER);
        if (r106.f554664b != null) goto L28;
    L30:
        Uri r108 = UriProtector.parse(r103);
        Context r109 = r105.getContext();
        if (r109 == null) goto L38;
        HybridCard r110 = f.a().getHybridCard(r109, r108, new c(r106, r105));
        if (r110 == null) goto L38;
        r106.f554664b = r110;
        if ((r110 instanceof WebView) == false) goto L37;
        r110.setBackgroundColor(0);
    L37:
        r110.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r105.removeAllViews();
        r105.addView(r110, 0);
        i0.c().post(new vg1.b(r106, r103));
        r106.f554665c = r105;
        goto L38
    L28:
        if ((true ^ Intrinsics.areEqual(r103, r103)) == false) goto L30;
        r106.a(r103);
    L38:
        ((ObservableSubscribeProxy) xs2.b.a().b(o.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new a(this));
        return;
    L21:
        r104 = false;
        goto L22
    L5:
        r102 = null;
        goto L7
    }

    public final void wq(b r100) {
        Intrinsics.checkNotNullParameter("vsOpenLiveRoom", "name");
        Intrinsics.checkNotNullParameter(r100, "func");
        vg1.a r101 = this.f106181b;
        r101.getClass();
        Intrinsics.checkNotNullParameter("vsOpenLiveRoom", "name");
        Intrinsics.checkNotNullParameter(r100, "func");
        HybridCard r102 = r101.f554664b;
        if (r102 == null) goto L6;
        r102.setJSBridgeListener(new d(r100));
        return;
    }

    @Override // vg1.e
    public final void updateScreenMetrics(int r100, int r101) {
        vg1.a r102 = this.f106181b;
        r102.getClass();
        ALogger.i("HybridManagerForVsEnd", "updateScreenMetrics widthPixels:" + r100 + "; heightPixels:" + r101);
        HybridCard r103 = r102.f554664b;
        if (r103 == null) goto L6;
        r103.f(r100, r101);
        return;
    }
}
