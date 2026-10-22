package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import je0.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xh0.f;
import xh0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/BasePaidLinkMicWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BasePaidLinkMicWidget extends AbsPlayModeWidget {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f78578g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f78579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PaidLinkMicViewModel f78580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f78581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f78582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f78583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78584f;

    public static final class a {
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        IncompatibleTag r100 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new f[]{new f(r100, 5), new f(r100, 7, ""), new f(r100, 16, ""), new f(r100, 17, ""), new f(r100, 6, ""), new f(r100, 29, ""), new f(IncompatibleTag.SCENE, 9, s1.B(R.string.ttlive_live_paid_link_voice_ktv_conflict))});
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r100) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r100) {
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(11, s1.B(R.string.ttlive_paid_link));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        PaidLinkMicViewModel r100 = this.f78580b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        return r100.isPaidLinkOn();
    }

    public BasePaidLinkMicWidget() {
        this.f78581c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onCreate() {
        super.onCreate();
        this.f78579a = (IRoom) this.dataCenter.get("data_room", vh7.f.c(IRoom.class));
        Boolean r100 = (Boolean) this.dataCenter.get("data_is_anchor");
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = r100.booleanValue();
    L6:
        this.f78582d = r102;
        this.f78583e = d.h();
        this.f78584f = d.f();
        Pair r103 = com.bytedance.live.datacontext.d.a(BasePaidLinkMicWidget$onCreate$pair$1.INSTANCE);
        this.f78580b = new PaidLinkMicViewModel(this.dataCenter);
        j<cj0.c> r104 = ((PaidLinkMicContext) r103.getFirst()).m8179getWidget();
        PaidLinkMicViewModel r105 = this.f78580b;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r104.d(r105);
        com.bytedance.live.datacontext.b.a((DataContext) r103.getFirst(), cj0.a.class);
        this.f78581c.add((Disposable) r103.getSecond());
        DataCenter r106 = this.dataCenter;
        Boolean r107 = Boolean.TRUE;
        r106.put("cmd_paid_linkmic_widget_ready", r107);
        com.bytedance.android.live.liveinteract.api.data.a.f71432h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C1153a.e() == false) goto L54;
        IRoom r108 = this.f78579a;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L14:
        z5 r109 = r108.getLinkerDetail();
        if (r109 == null) goto L42;
        List<Long> r110 = r109.getPlayModes();
        if (r110 == null) goto L42;
        if (r110.contains(Long.valueOf(11)) != true) goto L42;
        j<LivePlayModeLogContext> r111 = m.e(this).J();
        if (r111 == null) goto L26;
        LivePlayModeLogContext r112 = r111.getValue();
        if (r112 == null) goto L26;
        r112.addPlayMode(11);
    L26:
        if (this.f78582d == true) goto L34;
        PaidLinkMicViewModel r113 = this.f78580b;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        IRoom r114 = this.f78579a;
        if (r114 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L33:
        r113.fetchUserPaidBenefitInfo(r114.getId());
    L34:
        PaidLinkMicViewModel r115 = this.f78580b;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        IRoom r116 = this.f78579a;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L40:
        r115.fetchNormalPaidInfo(r116.getId());
    L42:
        if (this.f78582d == false) goto L44;
    L50:
        if (r101 == false) goto L54;
        DataCenter r117 = this.dataCenter;
        if (r117 == null) goto L54;
        r117.put("data_paid_link_profile_show", r107);
        goto L54
    L44:
        if (vm2.d.o0() == false) goto L50;
        cj0.c r118 = PaidLinkMicContext.Companion.a();
        if (r118 == null) goto L50;
        if (r118.isPaidLinkOn() != true) goto L50;
        r101 = true;
    L54:
        PaidLinkMicViewModel r119 = this.f78580b;
        if (r119 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r119.getPaidLinkMicPlayModeGuideState().observe(this, new com.bytedance.android.live.liveinteract.revenue.paid.widget.a(this));
        PaidLinkMicViewModel r120 = this.f78580b;
        if (r120 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r120.getPaidLinkMicAddPriceState().observe(this, new b(this));
        PaidLinkMicViewModel r121 = this.f78580b;
        if (r121 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r121.getPaidLinkMicState().observe(this, new c(this));
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
        cj0.c r100 = PaidLinkMicContext.Companion.a();
        if (r100 != null) goto L5;
    L10:
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L14;
        r101.put("data_paid_link_profile_show", Boolean.FALSE);
    L14:
        if (this.f78581c.isDisposed() == true) goto L17;
        this.f78581c.clear();
        return;
    L17:
        return;
    L5:
        if (r100.isPaidLinkOn() != true) goto L10;
        fj0.b r102 = fj0.b.f477461b;
        if (this.f78582d == false) goto L9;
        fj0.b.d(r102);
        goto L10
    L9:
        fj0.b.g(r102);
        goto L10
    }

    public void wq(k r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.f23919a == false) goto L14;
        if (this.f78582d == false) goto L7;
        return;
    L7:
        if (vm2.d.o0() == true) goto L9;
        return;
    L9:
        if (r100.f23922d == false) goto L23;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L24;
        r101.put("data_paid_link_profile_show", Boolean.TRUE);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if (this.f78582d == false) goto L16;
        return;
    L16:
        if (vm2.d.o0() == false) goto L27;
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L28;
        r102.put("data_paid_link_profile_show", Boolean.FALSE);
        return;
    L28:
        return;
    }

    public final void xq(int r100, int r101) {
        cj0.c r102 = PaidLinkMicContext.Companion.a();
        if (r102 != null) goto L5;
    L15:
        this.f78583e = Integer.valueOf(r101);
        this.f78584f = r100;
        return;
    L5:
        if (r102.isPaidLinkOn() != true) goto L15;
        Integer r103 = this.f78583e;
        if (r103 == null) goto L12;
        if (r103.intValue() == r101) goto L15;
    L12:
        if (this.f78582d == false) goto L14;
        fj0.b r104 = fj0.b.f477461b;
        fj0.b.c(this.f78584f, this.f78583e);
        fj0.b.h(r104, "function_switch", null, 6);
        goto L15
    L14:
        fj0.a r105 = fj0.b.f477460a;
        fj0.b.f(this.f78584f, this.f78583e);
        fj0.b.e(null);
        goto L15
    }
}
