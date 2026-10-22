package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelInviteButtonWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelInviteButtonWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelInviteButtonWidget extends AbsChatChannelInviteButtonWidget {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f134534c = 0;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelInviteButtonWidget f134535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f134536b;

        public b(ChatChannelInviteButtonWidget r100, View r101) {
            this.f134535a = r100;
            this.f134536b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            View r102 = LayoutInflater.from(this.f134536b.getContext()).inflate(R.layout.ttlive_chat_channel_invite_popup, null);
            yo2.e r103 = new yo2.e(this.f134535a.getContext());
            r103.f568642d = r102;
            r103.f568643e = 0;
            r103.f568651m = 2;
            r103.f568653o = 1;
            r103.f568652n = false;
            r103.f568650l = true;
            r103.f568662x = l.f134693a;
            r103.a();
            r103.i(this.f134536b, 1, 4, 0, s1.f(-4.0f));
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = com.bytedance.android.livesdk.sharedpref.b.f158156h3;
            Boolean r105 = Boolean.TRUE;
            r104.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget
    public final void wq() {
        Context r100 = this.context;
        if (r100 != null) goto L5;
        return;
    L5:
        RoomContext r101 = getRoomContext();
        if (r101 != null) goto L8;
        return;
    L8:
        DataCenter r102 = this.dataCenter;
        if (r102 != null) goto L11;
        return;
    L11:
        s22.e r103 = ChatChannelUtils.b(r101);
        if (r103 != null) goto L14;
        return;
    L14:
        s22.a r104 = ChatChannelUtils.c(r101);
        if (r104 != null) goto L17;
        return;
    L17:
        n62.e r105 = n62.h.b(r100, r101, r102, r103);
        Intrinsics.checkNotNullParameter(r104, "channel");
        r105.e(r104, null);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.g("icon");
    }

    public final void xq() {
        CompositeDisposable r100 = this.f134486b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f134486b = new CompositeDisposable();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r101 = ChatChannelUtils.f(getRoomContext());
        if (r101 == null) goto L29;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r102 = r101.getState();
        if (r102 == null) goto L30;
        com.bytedance.android.livesdk.interactivity.api.base.d r103 = r102.getValue();
        if (r103 == null) goto L34;
        s22.e r104 = ChatChannelUtils.b(getRoomContext());
        if (r104 == null) goto L15;
        s22.a r105 = r104.getChannel(r103.f132905b);
    L16:
        if (r105 == null) goto L22;
        PropertyOwner r106 = r105.z();
        if (r106 == null) goto L22;
        Disposable r107 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r106, new ChatChannelInviteButtonWidget$observeChannelInviteState$1(this));
        if (r107 == null) goto L22;
        RxUtilKt.c(r107, this.f134486b);
    L22:
        if (r105 == null) goto L31;
        PropertyOwner r108 = r105.v();
        if (r108 == null) goto L32;
        Disposable r109 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r108, new ChatChannelInviteButtonWidget$observeChannelInviteState$2(this));
        if (r109 == null) goto L33;
        RxUtilKt.c(r109, this.f134486b);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L15:
        r105 = null;
        goto L16
    L34:
        return;
    L30:
        return;
    }

    public final void zq() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r100 = ChatChannelUtils.f(getRoomContext());
        s22.a r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r102 = r100.getState();
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.base.d r103 = r102.getValue();
    L8:
        s22.e r104 = ChatChannelUtils.b(getRoomContext());
        if (r104 == null) goto L15;
        if (r103 == null) goto L12;
        long r105 = r103.f132905b;
    L13:
        r101 = r104.getChannel(r105);
        goto L15
    L12:
        r105 = 0;
    L15:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.b.a(r103) == false) goto L32;
        if (r101 == null) goto L32;
        boolean r106 = r101.w();
        boolean r107 = true;
        if (r106 != true) goto L32;
        if (this.containerView.getVisibility() != 0) goto L23;
        r107 = false;
    L23:
        ViewGroup r108 = this.containerView;
        if (r108 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r108);
    L26:
        if (r107 == false) goto L36;
        DataCenter r109 = this.dataCenter;
        if (r109 != null) goto L30;
        return;
    L30:
        if (ChatChannelUtils.h(r109) == false) goto L38;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.h("icon");
        return;
    L38:
        return;
    L36:
        return;
    L32:
        ViewGroup r110 = this.containerView;
        if (r110 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r110);
        return;
    L40:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public ChatChannelInviteButtonWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        super.onLoad(r100);
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r101);
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r102 = ChatChannelUtils.f(getRoomContext());
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r103 = r102.getState();
        if (r103 == null) goto L12;
        Disposable r104 = i80.a.a(r103, new ChatChannelInviteButtonWidget$observePageState$1(this));
        if (r104 == null) goto L12;
        RxUtilKt.c(r104, this.f134485a);
    L12:
        xq();
        zq();
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.f158156h3.getValue(), Boolean.TRUE) == true) goto L29;
        k r105 = new k(this);
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L18;
        r106.observe("multi_selected_tab_id", r105);
    L18:
        RxUtilKt.c(Disposables.fromAction(new i(this, r105)), this.f134485a);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r107 = ChatChannelUtils.f(getRoomContext());
        if (r107 == null) goto L27;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r108 = r107.getState();
        if (r108 == null) goto L27;
        Observable<com.bytedance.android.livesdk.interactivity.api.base.d> r109 = r108.a();
        if (r109 == null) goto L27;
        Disposable r110 = r109.subscribe(new j(this));
        if (r110 == null) goto L27;
        RxUtilKt.c(r110, this.f134485a);
    L27:
        yq(this.contentView);
        return;
    }

    public final void yq(View r100) {
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.sharedpref.b.f158156h3.getValue(), Boolean.TRUE) == false) goto L6;
        return;
    L6:
        if (isScreenPortrait() == true) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        DataCenter r101 = this.dataCenter;
        if (r101 != null) goto L13;
        return;
    L13:
        boolean r102 = ChatChannelUtils.h(r101);
        ViewGroup r103 = this.containerView;
        boolean r104 = false;
        if (r103 != null) goto L16;
    L18:
        boolean r105 = false;
    L20:
        if (n62.a.f518105d == false) goto L22;
    L23:
        r104 = true;
    L24:
        if (r102 == false) goto L29;
        if (r105 == false) goto L30;
        if (r104 == true) goto L31;
        RxUtilKt.c(Observable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100)), this.f134485a);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (n62.a.f518106e == false) goto L24;
    L16:
        if (r103.getVisibility() != 0) goto L18;
        r105 = true;
        goto L20
    }
}
