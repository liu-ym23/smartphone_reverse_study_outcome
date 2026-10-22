package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.link.core.layoutstatus.LayoutSnapShotCollect;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class AnchorUILayoutManager implements com.bytedance.android.scope.o, com.bytedance.android.live.revlink.link.biz.service.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f98323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<o> f98324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f98325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f98326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o51.e f98327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yz0.f f98328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.g f98329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f98330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g f98331i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass1(AnchorUILayoutManager r100) {
            super(2, r100, AnchorUILayoutManager.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "p1");
            AnchorUILayoutManager r112 = (AnchorUILayoutManager) this.receiver;
            o51.e r113 = r112.f98327e;
            int r100 = r113.f522037a.f522057b;
            int r101 = o51.f.j.f522068e.f522057b;
            if (r100 != r101) goto L10;
            int r102 = r113.f522039c.ordinal();
            int r103 = r112.f98327e.f522040d.ordinal();
            String r104 = o51.g.b(r112.f98327e);
            o r114 = r112.f98324b.getValue();
            if (r114 != null) goto L8;
            r114 = new o(com.bytedance.revenue.platform.api.core.d.a(new Pair[0]));
        L8:
            r112.d(new r(r101, r102, r103, false, r104, r114), "onlineListChange");
            return;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r100, Integer r101) {
            invoke(r100, r101.intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        l r100 = this.f98325c;
        Observable r101 = yz0.h.a.a(r100.f98353d, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.f90883g), false, 6);
        final LayoutChangeManager$attach$1 r102 = new LayoutChangeManager$attach$1(r100);
        com.bytedance.revenue.platform.api.core.rx.f.a(r101.subscribe(new m(r102)), r100.f98350a);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(r100.getContext().t(), new LayoutChangeManager$attach$2(r100)), r100.f98350a);
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass1(this)), this.f98323a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        l r100 = this.f98325c;
        r100.f98350a.clear();
        r100.f98351b = false;
        this.f98323a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.f98331i;
    }

    public final void a(o r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutDetails");
        Intrinsics.checkNotNullParameter(r101, "source");
        jy0.b.c("xuzr_position", "updateLayoutDetails " + r100 + " from " + r101, null, 4);
        this.f98324b.setValue(r100);
    }

    public final void d(r r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (r100 != null) goto L6;
        f(c.a(getContext()), "empty layoutInfo fallback to default " + c.a(getContext()) + " from " + r110);
        return;
    L6:
        a(r100.f98386f, r110);
        y41.d r101 = y41.d.f565943j;
        r101.getClass();
        if (((Boolean) y41.d.f565939f.getValue(r101, y41.d.f565934a[4])).booleanValue() == true) goto L10;
        jy0.b.c("AnchorUILayoutManager", "refuse change uiLayout for not support enlarge", null, 4);
        return;
    L10:
        String r102 = r100.f98385e;
        String r103 = "";
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        boolean r104 = true;
        if (r100.f98382b == 1) goto L16;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r105 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
    L17:
        int r106 = r100.f98383c;
        if (r106 == 0) goto L29;
        if (r106 == 1) goto L28;
        if (r106 != 2) goto L22;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream;
    L30:
        int r108 = r100.f98381a;
        if (r108 == 0) goto L53;
        if (r108 == 1) goto L51;
        if (r108 == 2) goto L36;
        o51.e r109 = c.a(getContext());
    L56:
        f(r109, r110);
        return;
    L36:
        if (IRoomKtKt.getStreamType(getContext().getRoom()) == LiveMode.SCREEN_RECORD) goto L40;
        r104 = false;
    L40:
        if (r104 == false) goto L46;
        boolean r111 = r100.f98384d;
        Intrinsics.checkNotNullParameter(r102, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r102, "$this$linkerID");
        String r112 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r102);
        if (r112 == null) goto L45;
        r103 = r112;
    L45:
        r109 = new o51.e.C7015e(r111, r102, r103);
        goto L56
    L46:
        Intrinsics.checkNotNullParameter(r102, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r102, "$this$linkerID");
        String r113 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(this, r102);
        if (r113 == null) goto L50;
        r103 = r113;
    L50:
        r109 = new o51.e.d(r102, r103, r105, r107);
        goto L56
    L51:
        r109 = new o51.e.c(r102, r102, r105, r107);
        goto L56
    L53:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L55;
        r109 = h.a(this);
        goto L56
    L55:
        r109 = o51.e.f.f522048e;
        goto L56
    L22:
        if (r106 == 3) goto L26;
        if (r106 == 4) goto L25;
        r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L30
    L25:
        r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeMyStream;
        goto L30
    L26:
        r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeMyStream;
        goto L30
    L28:
        r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeAllStream;
        goto L30
    L29:
        r107 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L30
    L16:
        r105 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom;
        goto L17
    }

    public final void f(o51.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        Intrinsics.checkNotNullParameter(r101, "source");
        String r102 = null;
        jy0.b.c("AnchorUILayoutManager", "updateUILayout from " + this.f98327e + " to " + r100 + ", source=" + r101, null, 4);
        if (this.f98327e.a(r100) == false) goto L7;
        jy0.b.c("AnchorUILayoutManager", "updateUILayout reject for same from " + this.f98327e + " to " + r100 + ", source=" + r101, null, 4);
        return;
    L7:
        if ((r100 instanceof o51.e.f) == false) goto L9;
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r103 = com.bytedance.android.live.revlink.link.biz.service.i.B(this);
        UILayout r104 = o51.g.c(r100);
        String r105 = o51.g.b(r100);
        if (r100.f522039c != IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom) goto L17;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r106 = com.bytedance.android.live.revlink.link.biz.service.i.w(this);
        if (r106 == null) goto L18;
        r102 = r106.Me();
    L18:
        r103.C(r104, r105, r102);
    L19:
        this.f98327e = r100;
        b r107 = this.f98330h;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        AnchorDynamicLayoutImpl r108 = r107.f98334a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        LayoutSnapShotCollect r109 = r108.f98318b;
        AnchorDynamicLayoutImpl$requestLayout$1 r110 = new AnchorDynamicLayoutImpl$requestLayout$1(r108);
        AnchorDynamicLayoutImpl$requestLayout$2 r111 = new AnchorDynamicLayoutImpl$requestLayout$2(r108);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        Intrinsics.checkNotNullParameter(r110, "onResolve");
        Intrinsics.checkNotNullParameter(r111, "onReject");
        r109.f98279k = r100;
        r109.a(r110, r111);
        return;
    L17:
        r102 = getContext().f98681d.f98657k;
        goto L18
    L9:
        if ((r100 instanceof o51.e.c) == true) goto L12;
        if (r100.f522037a.a() == false) goto L19;
        goto L12
    }

    public final void c(String r110, boolean r111, boolean r112) {
        i97.a r100 = i97.a.f488802a;
        long r101 = System.currentTimeMillis();
        long r102 = r101 - this.f98326d;
        y41.d r103 = y41.d.f565943j;
        r103.getClass();
        boolean r104 = false;
        if (r102 <= ((Number) y41.d.f565942i.getValue(r103, y41.d.f565934a[7])).longValue()) goto L5;
        this.f98326d = r101;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L8;
        return;
    L8:
        l r106 = this.f98325c;
        boolean r107 = !r112;
        IRoomSpecificSceneTypeInfo r108 = this.f98329g.getRoom().getSceneTypeInfo();
        if (r108 == null) goto L14;
        if (r108.isLandscapeVerticalRoom() != 1) goto L14;
        r104 = true;
    L14:
        if (r103.a(r104) == true) goto L19;
        if (Intrinsics.areEqual(this.f98327e.f522037a, o51.f.c.f522061e) == false) goto L19;
        IAnchorUpdateLayoutContent.AnchorUIOperationType r109 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
    L28:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r109, "operateType");
        if (r106.f98351b == true) goto L47;
        r106.f98351b = true;
        long r113 = System.currentTimeMillis();
        if (r111 == false) goto L35;
        if (r107 == false) goto L35;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r114 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeMyStream;
    L45:
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r115 = r114;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r106.getContext().getLinkNetwork().z(r114.ordinal(), r106.getContext().getRoomID(), r106.getContext().G(), r110, r109.ordinal())).subscribe(new j(r106, r110, r115, r113), new k(r106, r110, r115, r113)), r106.f98350a);
        return;
    L35:
        if (r111 == false) goto L38;
        if (r107 == true) goto L38;
        r114 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.EnlargeAllStream;
    L38:
        if (r111 == true) goto L41;
        if (r107 == false) goto L41;
        r114 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeMyStream;
    L41:
        if (r111 == true) goto L44;
        if (r107 == true) goto L44;
        r114 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream;
    L44:
        r114 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L45
    L47:
        return;
    L19:
        if (getContext().f98681d.f98661o != 1) goto L24;
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkFullEnlargeUtils");
        if (com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).km().a() == false) goto L23;
        r109 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
        goto L28
    L23:
        r109 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationUnknown;
        goto L28
    L24:
        Intrinsics.checkNotNullParameter(this, "$this$anchorLinkFullEnlargeUtils");
        if (com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).km().a() == false) goto L27;
        r109 = IAnchorUpdateLayoutContent.AnchorUIOperationType.OperationSmall;
        goto L28
    L27:
        r109 = IAnchorUpdateLayoutContent.AnchorUIOperationType.Operation1V3Enlarge;
        goto L28
    L5:
        int r116 = ToastUtil.f90810a;
        int r117 = w11.a.f557889a;
        ToastUtil.a(R.string.ttlive_multi_link_enlarge_frequency_toast, 0);
        r105 = false;
        goto L6
    }

    public AnchorUILayoutManager(yz0.f r100, yz0.g r101, b r102, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r103) {
        Intrinsics.checkNotNullParameter(r100, "messageService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "dynamicLayoutManger");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98328f = r100;
        this.f98329g = r101;
        this.f98330h = r102;
        this.f98331i = r103;
        this.f98323a = new CompositeDisposable();
        this.f98324b = getContext().f98679b;
        this.f98325c = new l(this, r100, getContext());
        this.f98327e = c.a(getContext());
    }
}
