package com.bytedance.android.live.liveinteract.interactivesong.impl;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.q2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001cJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/impl/InteractiveSongViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "curOrderSongUser", "", "getCurOrderSongUser", "()Ljava/lang/String;", "setCurOrderSongUser", "(Ljava/lang/String;)V", "orderSingListUserMicrophone", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdkapi/depend/message/IOrderSingInfoV2;", "closePlayingMv", "", "vid", "itemId", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "closeSource", "closeSuccessCB", "Lkotlin/Function0;", "fetchPlayModeInfo", "observeOrderSingListUserMicrophone", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", LiveCommonConstants.REASON_ON_DEDTROY, "turnOnOrderSing", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongViewModel extends DataContext {
    private final CompositeDisposable compositeDisposable;
    private String curOrderSongUser;
    private final MutableLiveData<IOrderSingInfoV2> orderSingListUserMicrophone;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f73995a;

        public a(Function0 r100) {
            this.f73995a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
            Function0 r102 = this.f73995a;
            if (r102 == null) goto L6;
            Unit r103 = (Unit) r102.invoke();
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f73996a = null;

        static {
            f73996a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractiveSongViewModel f73997a;

        public c(InteractiveSongViewModel r100) {
            this.f73997a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MutableLiveData r101 = InteractiveSongViewModel.access$getOrderSingListUserMicrophone$p(this.f73997a);
            k1 r102 = (k1) ((com.bytedance.android.live.network.response.e) r100).data;
            if (r102 == null) goto L7;
            p2 r103 = r102.getLinkmicPlayModeInfo();
            if (r103 == null) goto L7;
            IOrderSingInfoV2 r104 = r103.getOrderSingInfo();
        L8:
            r101.setValue(r104);
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f73998a = null;

        static {
            f73998a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f73999a = null;

        static {
            f73999a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f74000a = null;

        static {
            f74000a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
        }
    }

    public final void onDestroy() {
        this.compositeDisposable.clear();
    }

    public InteractiveSongViewModel() {
        this.orderSingListUserMicrophone = new MutableLiveData(null);
        this.compositeDisposable = new CompositeDisposable();
    }

    public final String getCurOrderSongUser() {
        return this.curOrderSongUser;
    }

    public static final /* synthetic */ MutableLiveData access$getOrderSingListUserMicrophone$p(InteractiveSongViewModel r100) {
        return r100.orderSingListUserMicrophone;
    }

    public final void fetchPlayModeInfo(IRoom r100) {
        LinkApi r101 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r100 == null) goto L5;
        long r102 = r100.getId();
    L6:
        RxUtilKt.c(r101.fetchPlayModeInfo(r102, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.f73998a), this.compositeDisposable);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setCurOrderSongUser(String r100) {
        this.curOrderSongUser = r100;
    }

    public final void turnOnOrderSing(IRoom r110) {
        q2 r100 = b6.F.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        LinkApi r101 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r110 == null) goto L8;
        long r102 = r110.getId();
    L9:
        String r111 = r100.c();
        if (r111 != null) goto L12;
        String r103 = "";
    L14:
        if (Intrinsics.areEqual(r100.d(), Boolean.TRUE) == false) goto L16;
        int r112 = LinkApi.OrderSingAutoEnlarge.ORDER_SING_AUTO_ENLARGE_OPEN.getValue();
    L17:
        int r104 = r112;
        Boolean r113 = r100.b();
        if (r113 == null) goto L20;
        boolean r114 = r113.booleanValue();
    L21:
        String r105 = r100.a();
        if (r105 != null) goto L24;
        r105 = "";
    L24:
        Boolean r106 = r100.e();
        if (r106 == null) goto L27;
        boolean r107 = r106.booleanValue();
    L28:
        RxUtilKt.c(r101.orderSingTurnOn(r102, r103, r104, r114, r105, r107, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(e.f73999a, f.f74000a), this.compositeDisposable);
        return;
    L27:
        r107 = false;
        goto L28
    L20:
        r114 = false;
        goto L21
    L16:
        r112 = LinkApi.OrderSingAutoEnlarge.ORDER_SING_AUTO_ENLARGE_OFF.getValue();
        goto L17
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = 0;
        goto L9
    }

    public final void observeOrderSingListUserMicrophone(LifecycleOwner r100, Observer<IOrderSingInfoV2> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.orderSingListUserMicrophone.observe(r100, r101);
    }

    public final void closePlayingMv(String r100, String r101, IRoom r110, String r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r111, "closeSource");
        LinkApi r102 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        if (r110 == null) goto L5;
        long r103 = r110.getId();
    L6:
        RxUtilKt.c(r102.closePlayingMv(r103, r101, r100, r111).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r112), b.f73996a), this.compositeDisposable);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void closePlayingMv$default(InteractiveSongViewModel r100, String r101, String r102, IRoom r103, String r110, Function0 r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        r100.closePlayingMv(r101, r102, r103, r110, r111);
    }
}
