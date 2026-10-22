package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.data.b;
import com.bytedance.android.live.liveinteract.plantform.base.f;
import com.bytedance.android.live.liveinteract.plantform.base.g;
import com.bytedance.android.live.liveinteract.plantform.base.j;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/PaidProfileCardControlWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lcom/bytedance/android/live/liveinteract/plantform/base/j;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardControlWidget extends MiddlewareRoomWidget implements PaidProfileCardControlPresenter.IView, j, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f78556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f78557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PaidProfileCardControlPresenter f78558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f78559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f78560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PaidProfileCardWidget f78561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f78562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v61.a f78563h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView
    public final void Dg() {
        if (this.f78559d == false) goto L6;
        n7();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.j
    public final void Ld() {
        g r100 = f.a();
        boolean r101 = true;
        if (r100 == null) goto L7;
        if (r100.j7() != true) goto L7;
    L10:
        if (r101 == true) goto L13;
        Dg();
        return;
    L13:
        return;
    L7:
        if (f.a().k0(32) == true) goto L10;
        r101 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView, com.bytedance.android.live.liveinteract.plantform.base.j
    public final void n7() {
        if (v71.a.c() == false) goto L9;
        v61.a r100 = this.f78563h;
        if (r100 == null) goto L21;
        r100.dismiss();
        return;
    L21:
        return;
    L9:
        if (this.f78559d == true) goto L11;
        return;
    L11:
        g r101 = f.a();
        if (r101 == null) goto L14;
        r101.xh(this.f78561f);
    L14:
        PaidProfileCardContext r102 = PaidProfileCardContext.Companion.getContext();
        if (r102 == null) goto L19;
        n<b> r103 = r102.getPaidProfileCardData();
        if (r103 == null) goto L19;
        r103.setValue(null);
    L19:
        this.f78561f = null;
        this.f78559d = false;
        this.f78560e = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        Boolean r100 = (Boolean) this.dataCenter.get("data_is_anchor");
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        this.f78556a = r101;
        ((Boolean) this.dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.f78557b = (IRoom) this.dataCenter.get("data_room", vh7.f.c(IRoom.class));
        PaidProfileCardControlPresenter r102 = new PaidProfileCardControlPresenter(this.f78557b, this.f78556a);
        this.f78558c = r102;
        r102.g0(this);
        Pair r103 = d.a(PaidProfileCardControlWidget$onCreate$pair$1.INSTANCE);
        ((PaidProfileCardContext) r103.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r103.getFirst(), cj0.d.class);
        this.f78562g = (Disposable) r103.getSecond();
        this.dataCenter.observe("data_promotion_right_card_container_show", this);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        PaidProfileCardControlPresenter r100 = this.f78558c;
        if (r100 == null) goto L5;
        r100.detachView();
    L5:
        Disposable r101 = this.f78560e;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Disposable r102 = this.f78562g;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f78562g = null;
        this.dataCenter.removeObserver(this);
    }

    public PaidProfileCardControlWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.j
    public final boolean Ie() {
        return this.f78559d;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView
    public final void El(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f78559d == false) goto L5;
        return;
    L5:
        Disposable r101 = this.f78560e;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Widget r102 = null;
        if (v71.a.c() == false) goto L20;
        IMiddlewareMsgWindowService r103 = (IMiddlewareMsgWindowService) k.f(IMiddlewareMsgWindowService.class);
        if (r103 == null) goto L18;
        u61.a r104 = r103.cardBuilder();
        if (r104 == null) goto L18;
        cm0.a r105 = r104.a(new PaidProfileCardControlWidget$initPaidProfileCard$1(this, 10000));
        if (r105 == null) goto L18;
        dm0.a r106 = r105.b();
    L19:
        this.f78563h = r106;
    L18:
        r106 = null;
    L20:
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f78559d == true) goto L43;
        PaidProfileCardContext r107 = PaidProfileCardContext.Companion.getContext();
        if (r107 == null) goto L28;
        n<b> r108 = r107.getPaidProfileCardData();
        if (r108 == null) goto L28;
        r108.setValue(r100);
    L28:
        g r109 = f.a();
        if (r109 == null) goto L31;
        r102 = r109.em();
    L31:
        this.f78561f = (PaidProfileCardWidget) r102;
        if (v71.a.c() == false) goto L41;
        PaidProfileCardWidget r110 = this.f78561f;
        if (r110 == null) goto L38;
        ViewGroup r111 = r110.containerView;
        if (r111 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r111);
    L38:
        v61.a r112 = this.f78563h;
        if (r112 == null) goto L43;
        r112.show();
        goto L43
    L41:
        this.f78559d = true;
    L43:
        if (v71.a.c() == true) goto L46;
        this.f78560e = Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getKey(), "data_bottom_right_state") == false) goto L7;
    L8:
        PaidProfileCardControlPresenter r102 = this.f78558c;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.h0() != true) goto L17;
        Dg();
        return;
    L17:
        return;
    L7:
        if (Intrinsics.areEqual(r101.getKey(), "data_promotion_right_card_container_show") == true) goto L8;
    }
}
