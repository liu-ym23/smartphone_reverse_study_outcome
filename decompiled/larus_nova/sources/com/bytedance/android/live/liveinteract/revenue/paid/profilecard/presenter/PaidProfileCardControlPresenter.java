package com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.data.b;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livesdk.chatroom.model.interact.i1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.xa;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vlc.d;
import vlc.l;
import zg1.f3;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "IView", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardControlPresenter extends n<IView> implements l, Observer<KVData> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f78569h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f78570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRoom f78571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f78572g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IView extends IWidget {
        void Dg();

        void El(b r100);

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();

        void n7();
    }

    public static final class a {
    }

    static {
    }

    public final boolean h0() {
        DataCenter r100 = this.f107664c;
        Boolean r101 = null;
        if (r100 == null) goto L5;
        f3 r102 = (f3) r100.get("data_bottom_right_state", new f3());
    L6:
        DataCenter r103 = this.f107664c;
        if (r103 == null) goto L10;
        r101 = (Boolean) r103.get("data_promotion_right_card_container_show", Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L17;
        if (r102 != null) goto L13;
    L15:
        return false;
    L13:
        if (r102.f571830a != true) goto L15;
        return true;
    L17:
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        super.detachView();
        DataCenter r100 = this.f107664c;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        d r101 = this.f107665d;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        CompositeDisposable r102 = this.f78570e;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f78570e = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
        this.f78570e = new CompositeDisposable();
        DataCenter r101 = this.f107664c;
        if (r101 == null) goto L5;
        r101.observe("data_paid_link_profile_show", this);
    L5:
        d r102 = this.f107665d;
        if (r102 == null) goto L8;
        r102.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getKey(), this);
    L8:
        d r103 = this.f107665d;
        if (r103 == null) goto L12;
        r103.addMessageListener(MessageType.LINK_MIC_PROFIT.getKey(), this);
        return;
    }

    public final void i0(i1 r110) {
        if (h0() == false) goto L5;
        return;
    L5:
        IView r100 = (IView) this.f531633a;
        if (r100 == null) goto L19;
        boolean r101 = this.f78572g;
        j1 r102 = r110.getTag();
        if (r102 == null) goto L10;
        k r103 = r102.getPic();
    L11:
        IRoom r104 = this.f78571f;
        if (r104 == null) goto L16;
        IBaseUser r105 = r104.getBaseOwner();
        if (r105 == null) goto L16;
        k r106 = r105.getAvatarThumbKt();
    L17:
        r100.El(new b(r101, r103, r106, r110.getNumOfLink(), r110.getAvgGrade()));
        return;
    L16:
        r106 = null;
        goto L17
    L10:
        r103 = null;
        goto L11
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101.getKey(), "data_paid_link_profile_show") == false) goto L21;
        Boolean r102 = (Boolean) r101.getData();
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L16;
        if (this.f78571f == null) goto L27;
        Disposable r103 = ((LinkPaidLinkApi) c.b().e(LinkPaidLinkApi.class)).getPaidExplainCardInfo(this.f78571f.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new ej0.a(this), ej0.b.f472836a);
        CompositeDisposable r104 = this.f78570e;
        if (r104 == null) goto L22;
        r104.add(r103);
        return;
    L22:
        return;
    L27:
        return;
    L16:
        if (Intrinsics.areEqual(r102, Boolean.FALSE) == false) goto L24;
        IView r105 = (IView) this.f531633a;
        if (r105 == null) goto L25;
        r105.n7();
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof ILinkMicGuideMessageBridge) == false) goto L22;
        ILinkMicGuideMessageBridge r101 = (ILinkMicGuideMessageBridge) r100;
        if (this.f78572g == false) goto L7;
        return;
    L7:
        if (vm2.d.o0() == true) goto L10;
        return;
    L10:
        if (r101.getGuidelineType() != 9) goto L30;
        xa r102 = r101.getNormalPaidLinkmicExplainCardContent();
        if (r102 == null) goto L31;
        i1 r103 = r102.getPaidLinkmicExplainCardInfo();
        if (r103 == null) goto L39;
        cj0.c r104 = PaidLinkMicContext.Companion.a();
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.isPaidLinkOn() != true) goto L33;
        i0(r103);
        return;
    L33:
        return;
    L39:
        return;
    L31:
        return;
    L30:
        return;
    L22:
        if ((r100 instanceof ILinkmicProfitMessage) == true) goto L24;
        return;
    L24:
        if (((ILinkmicProfitMessage) r100).getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicClose.ordinal()) goto L36;
        IView r105 = (IView) this.f531633a;
        if (r105 == null) goto L37;
        r105.Dg();
        return;
    L37:
        return;
    }

    public PaidProfileCardControlPresenter(IRoom r100, boolean r101) {
        this.f78571f = r100;
        this.f78572g = r101;
    }
}
