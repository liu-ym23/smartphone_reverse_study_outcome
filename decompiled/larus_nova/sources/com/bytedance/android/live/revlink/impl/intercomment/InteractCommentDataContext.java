package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.bridge.k0;
import com.bytedance.android.livesdk.link.model.bridge.l0;
import com.bytedance.android.livesdk.link.model.l4;
import com.bytedance.android.livesdk.link.model.u4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 J2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010C\u001a\u00020\u000b¢\u0006\u0004\bI\u0010HJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u00101R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010$R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "Lcom/bytedance/android/live/revlink/impl/intercomment/a;", "action", "sendAction", "invite", "", "replyStatus", "", "banInvite", "reply", "close", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/intercomment/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "getRoomContext", "()Lcom/bytedance/android/livesdk/revenue/room/a;", "Lio/reactivex/disposables/Disposable;", "mInviteTimeOutDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "isAnchor", "Z", "Landroidx/lifecycle/MutableLiveData;", "_interComState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "interComState", "Landroidx/lifecycle/LiveData;", "getInterComState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/live/datacontext/k;", "", "onIconClickEvent$delegate", "getOnIconClickEvent", "()Lcom/bytedance/live/datacontext/k;", "onIconClickEvent", "showInterCommentIcon", "getShowInterCommentIcon", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "mInterComLogger", "Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "getMInterComLogger", "()Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "setMInterComLogger", "(Lcom/bytedance/android/live/revlink/impl/intercomment/e;)V", "isStarter", "mIsInviting", "isFinisher", "", "mStartTimeInterval", "J", "scene", "I", "getScene", "()I", "setScene", "(I)V", "<init>", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final long INVITE_TIME_OUT = 20;
    public static final int REPLY_AGREE = 1;
    public static final int REPLY_REFUSE = 2;
    public static final int REPLY_REFUSE_BY_TIME_OUT = 3;
    private static final String TAG = null;
    private final MutableLiveData<Integer> _interComState;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f92506cd;
    private final LiveData<Integer> interComState;
    private boolean isAnchor;
    private boolean isFinisher;
    private boolean isStarter;
    private com.bytedance.android.live.revlink.impl.intercomment.e mInterComLogger;
    private Disposable mInviteTimeOutDisposable;
    private boolean mIsInviting;
    private long mStartTimeInterval;
    private final com.bytedance.live.datacontext.p onIconClickEvent$delegate;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private int scene;
    private final com.bytedance.live.datacontext.p service$delegate;
    private final MutableLiveData<Boolean> showInterCommentIcon;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92507a;

        public a(InteractCommentDataContext r100) {
            this.f92507a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            InteractCommentDataContext.access$getCd$p(this.f92507a).dispose();
            Disposable r100 = InteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.f92507a);
            if (r100 == null) goto L6;
            r100.dispose();
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final InteractCommentDataContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(InteractCommentDataContext.access$getTAG$cp());
            if ((r100 instanceof InteractCommentDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (InteractCommentDataContext) r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92508a;

        public c(InteractCommentDataContext r100) {
            this.f92508a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            InteractCommentDataContext.access$sendAction(this.f92508a, new com.bytedance.android.live.revlink.impl.intercomment.f());
            ToastUtil.b(((l4) ((ExtraResponse) r100).data).getToast(), 0);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f92509a = null;

        static {
            f92509a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r101, (Throwable) r100);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92510a;

        public e(InteractCommentDataContext r100) {
            this.f92510a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            InteractCommentDataContext.access$setMIsInviting$p(this.f92510a, false);
            InteractCommentDataContext.access$sendAction(this.f92510a, new com.bytedance.android.live.revlink.impl.intercomment.g(true));
            Disposable r102 = InteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.f92510a);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            InteractCommentDataContext.access$setMInviteTimeOutDisposable$p(this.f92510a, Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this)));
            l4 r103 = (l4) r101.data;
            if (r103 == null) goto L11;
            String r104 = r103.getToast();
            if (r104 == null) goto L12;
            ToastUtil.b(r104, 0);
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92511a;

        public f(InteractCommentDataContext r100) {
            this.f92511a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            InteractCommentDataContext.access$setMIsInviting$p(this.f92511a, false);
            Context r101 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r101, (Throwable) r100);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f92513b;

        public g(InteractCommentDataContext r100, int r101) {
            this.f92512a = r100;
            this.f92513b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            if (this.f92513b != 1) goto L5;
            InteractCommentDataContext.access$sendAction(this.f92512a, new com.bytedance.android.live.revlink.impl.intercomment.h());
        L6:
            l4 r102 = (l4) r101.data;
            if (r102 == null) goto L12;
            String r103 = r102.getToast();
            if (r103 == null) goto L13;
            ToastUtil.b(r103, 0);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            InteractCommentDataContext.access$sendAction(this.f92512a, new com.bytedance.android.live.revlink.impl.intercomment.f());
            goto L6
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractCommentDataContext f92514a;

        public h(InteractCommentDataContext r100) {
            this.f92514a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r101, (Throwable) r100);
            InteractCommentDataContext.access$sendAction(this.f92514a, new com.bytedance.android.live.revlink.impl.intercomment.f());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractCommentDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractCommentDataContext.class, "onIconClickEvent", "getOnIconClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new b();
        TAG = "InteractCommentDataContext";
    }

    public final void close() {
        this.isFinisher = true;
        r31.a r100 = r31.b.a(r31.a.f535859a);
        yz0.k r101 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        long r102 = 0;
        if (r101 == null) goto L7;
        IRoom r103 = r101.getRoom();
        if (r103 == null) goto L7;
        long r104 = r103.getRoomId();
    L8:
        LinkCrossRoomDataHolder r105 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r105 == null) goto L11;
        r102 = r105.c();
    L11:
        Observable<ExtraResponse<l4, Extra>> r106 = r100.intercomClose(r104, r102);
        if (r106 == null) goto L19;
        Observable<R> r107 = r106.compose(RxUtil.rxSchedulerHelper());
        if (r107 == 0) goto L20;
        Disposable r108 = r107.subscribe(new c(this), d.f92509a);
        if (r108 == null) goto L21;
        this.f92506cd.add(r108);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r104 = 0;
        goto L8
    }

    public final com.bytedance.live.datacontext.k<Object> getOnIconClickEvent() {
        return (com.bytedance.live.datacontext.k) this.onIconClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.intercomment.b> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void invite() {
        this.isStarter = true;
        if (this.mIsInviting == false) goto L5;
        return;
    L5:
        this.mIsInviting = true;
        r31.a r100 = r31.b.a(r31.a.f535859a);
        yz0.k r101 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        long r102 = 0;
        if (r101 == null) goto L10;
        IRoom r103 = r101.getRoom();
        if (r103 == null) goto L10;
        long r104 = r103.getRoomId();
    L11:
        LinkCrossRoomDataHolder r105 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r105 == null) goto L14;
        r102 = r105.c();
    L14:
        Observable<ExtraResponse<l4, Extra>> r106 = r100.intercomInvite(r104, r102);
        if (r106 == null) goto L22;
        Observable<R> r107 = r106.compose(RxUtil.rxSchedulerHelper());
        if (r107 == 0) goto L23;
        Disposable r108 = r107.subscribe(new e(this), new f(this));
        if (r108 == null) goto L24;
        this.f92506cd.add(r108);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final LiveData<Integer> getInterComState() {
        return this.interComState;
    }

    public final com.bytedance.android.live.revlink.impl.intercomment.e getMInterComLogger() {
        return this.mInterComLogger;
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.roomContext;
    }

    public final int getScene() {
        return this.scene;
    }

    public final MutableLiveData<Boolean> getShowInterCommentIcon() {
        return this.showInterCommentIcon;
    }

    public InteractCommentDataContext(int r100) {
        this.scene = r100;
        this.service$delegate = ConstantKt.c(this);
        com.bytedance.android.live.revenue.core.util.j.a r101 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r102 = (com.bytedance.android.livesdk.revenue.service.room.c) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r101.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        if (r102 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r103 = r102.getRoomContext();
    L6:
        this.roomContext = r103;
        CompositeDisposable r104 = new CompositeDisposable();
        this.f92506cd = r104;
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.i<Boolean> r105 = r103.isAnchor();
        if (r105 == null) goto L13;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L13;
        boolean r107 = r106.booleanValue();
    L14:
        this.isAnchor = r107;
        MutableLiveData<Integer> r108 = new MutableLiveData();
        this._interComState = r108;
        this.interComState = r108;
        this.onIconClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.showInterCommentIcon = new MutableLiveData();
        this.mInterComLogger = new com.bytedance.android.live.revlink.impl.intercomment.e(this.scene);
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r104);
        yz0.l r109 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(r101.a(), yz0.l.class);
        if (r109 == null) goto L22;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r110 = yz0.h.a.a(r109, com.bytedance.android.live.revenue.common.message.b.f90897n, false, 6);
        final InteractCommentDataContext$2$1 r111 = new InteractCommentDataContext$2$1(this);
        Disposable r112 = r110.subscribe(new i(r111));
        if (r112 == null) goto L19;
        RxUtilKt.c(r112, r104);
    L19:
        Observable r113 = yz0.h.a.a(r109, com.bytedance.android.live.revenue.common.message.b.f90898o, false, 6);
        final InteractCommentDataContext$2$2 r114 = new InteractCommentDataContext$2$2(this);
        Disposable r115 = r113.subscribe(new i(r114));
        if (r115 == null) goto L22;
        RxUtilKt.c(r115, r104);
    L22:
        Boolean r116 = ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).a0();
        if (r116 != null) goto L25;
    L28:
        Disposable r117 = ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).xn(new AnonymousClass4(this));
        if (r117 == null) goto L32;
        RxUtilKt.c(r117, r104);
        return;
    L32:
        return;
    L25:
        if (r116.booleanValue() == false) goto L27;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.h());
        goto L28
    L27:
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.f());
    L13:
        r107 = false;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(InteractCommentDataContext r100) {
        return r100.f92506cd;
    }

    public static final /* synthetic */ Disposable access$getMInviteTimeOutDisposable$p(InteractCommentDataContext r100) {
        return r100.mInviteTimeOutDisposable;
    }

    public static final /* synthetic */ boolean access$getMIsInviting$p(InteractCommentDataContext r100) {
        return r100.mIsInviting;
    }

    public static final /* synthetic */ long access$getMStartTimeInterval$p(InteractCommentDataContext r100) {
        return r100.mStartTimeInterval;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(InteractCommentDataContext r100) {
        return r100.isAnchor;
    }

    public static final /* synthetic */ boolean access$isFinisher$p(InteractCommentDataContext r100) {
        return r100.isFinisher;
    }

    public static final /* synthetic */ boolean access$isStarter$p(InteractCommentDataContext r100) {
        return r100.isStarter;
    }

    private final void onMessage(yh6.c r100) {
        if ((r100 instanceof k0) == false) goto L6;
        this.isStarter = false;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.g(false));
        return;
    L6:
        if ((r100 instanceof l0) == false) goto L39;
        u4 r101 = (u4) ((vh7.c) r100).castTo(u4.class);
        String r102 = r101.getToast();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        int r104 = ToastUtil.f90810a;
        ToastUtil.b(r101.getToast(), 0);
    L16:
        Disposable r105 = this.mInviteTimeOutDisposable;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        if (((int) r101.getReplyStatus()) != 1) goto L23;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.h());
        return;
    L23:
        if (this.isAnchor == false) goto L36;
        com.bytedance.android.live.revlink.impl.intercomment.e r106 = this.mInterComLogger;
        r106.getClass();
        HashMap r107 = new HashMap();
        if (r106.f92540b != 1) goto L27;
        String r108 = PbRequest.SwitchType.PK;
    L28:
        r107.put("connection_scene", r108);
        LinkCrossRoomDataHolder r109 = com.bytedance.android.live.revlink.impl.global.b.j();
        Long r110 = null;
        if (r109 == null) goto L31;
        Long r111 = Long.valueOf(r109.c());
    L32:
        r107.put("channel_id", String.valueOf(r111));
        w31.c r112 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r112 == null) goto L35;
        r110 = Long.valueOf(r112.i());
    L35:
        r107.put("pk_id", String.valueOf(r110));
        r106.a(r107);
        mz0.n r113 = new mz0.n();
        Map<String, String> r114 = r113.f516447a;
        Intrinsics.checkNotNullParameter(r114, "map");
        Intrinsics.checkNotNullParameter(r107, "map");
        r114.putAll(r107);
        mz0.m r115 = new mz0.m();
        r115.b(LogCommon.ROOM);
        ((ArrayList) r113.f516448b).addAll(r115.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r116 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r117 = com.bytedance.android.scope.m.b(r116).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r117);
        ((mz0.i) ((f80.a) r117)).w3("livesdk_refuse_feedback", r113.f516447a, r113.f516448b);
        goto L36
    L31:
        r111 = null;
        goto L32
    L27:
        r108 = WsConstants.KEY_CONNECTION;
    L36:
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.f());
        return;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    }

    private final void sendAction(com.bytedance.android.live.revlink.impl.intercomment.a r100) {
        Integer r101 = this._interComState.getValue();
        Integer r102 = this._interComState.getValue();
        int r103 = 0;
        if (r102 != null) goto L5;
        r102 = 0;
    L5:
        int r104 = r102.intValue();
        Intrinsics.checkNotNullParameter(r100, "action");
        if (r104 == 0) goto L8;
        if (r104 == 1) goto L24;
        if (r104 == 2) goto L24;
        if (r104 == 4) goto L21;
    L33:
        r103 = r104;
    L34:
        if (r101 != null) goto L37;
    L39:
        this._interComState.setValue(Integer.valueOf(r103));
        return;
    L37:
        if (r101.intValue() != r103) goto L39;
        return;
    L21:
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.f) == false) goto L33;
    L24:
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.i) == false) goto L28;
        ((com.bytedance.android.live.revlink.impl.intercomment.i) r100).getClass();
    L26:
        r103 = 4;
        goto L34
    L28:
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.h) == true) goto L26;
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.f) == false) goto L33;
    L8:
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.g) == false) goto L14;
        if (((com.bytedance.android.live.revlink.impl.intercomment.g) r100).f92541a == false) goto L12;
        r103 = 1;
        goto L34
    L12:
        r103 = 2;
        goto L34
    L14:
        if ((r100 instanceof com.bytedance.android.live.revlink.impl.intercomment.h) == false) goto L33;
        goto L33
    }

    public final void setMInterComLogger(com.bytedance.android.live.revlink.impl.intercomment.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mInterComLogger = r100;
    }

    public final void setScene(int r100) {
        this.scene = r100;
    }

    public static final /* synthetic */ void access$onMessage(InteractCommentDataContext r100, yh6.c r101) {
        r100.onMessage(r101);
    }

    public static final /* synthetic */ void access$sendAction(InteractCommentDataContext r100, com.bytedance.android.live.revlink.impl.intercomment.a r101) {
        r100.sendAction(r101);
    }

    public static final /* synthetic */ void access$setAnchor$p(InteractCommentDataContext r100, boolean r101) {
        r100.isAnchor = r101;
    }

    public static final /* synthetic */ void access$setFinisher$p(InteractCommentDataContext r100, boolean r101) {
        r100.isFinisher = r101;
    }

    public static final /* synthetic */ void access$setMInviteTimeOutDisposable$p(InteractCommentDataContext r100, Disposable r101) {
        r100.mInviteTimeOutDisposable = r101;
    }

    public static final /* synthetic */ void access$setMIsInviting$p(InteractCommentDataContext r100, boolean r101) {
        r100.mIsInviting = r101;
    }

    public static final /* synthetic */ void access$setMStartTimeInterval$p(InteractCommentDataContext r100, long r101) {
        r100.mStartTimeInterval = r101;
    }

    public static final /* synthetic */ void access$setStarter$p(InteractCommentDataContext r100, boolean r101) {
        r100.isStarter = r101;
    }

    public final void reply(int r110, boolean r111) {
        if (r110 != 1) goto L5;
        int r100 = 1;
    L6:
        r31.a r101 = r31.b.a(r31.a.f535859a);
        com.bytedance.android.livesdk.revenue.room.a r102 = this.roomContext;
        long r103 = 0;
        if (r102 == null) goto L13;
        com.bytedance.live.datacontext.m<IRoom> r104 = r102.getRoom();
        if (r104 == null) goto L13;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L13;
        long r106 = r105.getRoomId();
    L14:
        LinkCrossRoomDataHolder r107 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r107 == null) goto L17;
        r103 = r107.c();
    L17:
        Observable<ExtraResponse<l4, Extra>> r112 = r101.intercomReply(r106, r103, r100, r111);
        if (r112 == null) goto L25;
        Observable<R> r113 = r112.compose(RxUtil.rxSchedulerHelper());
        if (r113 == 0) goto L26;
        Disposable r114 = r113.subscribe(new g(this, r110), new h(this));
        if (r114 == null) goto L27;
        this.f92506cd.add(r114);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r106 = 0;
        goto L14
    L5:
        r100 = 2;
        goto L6
    }
}
