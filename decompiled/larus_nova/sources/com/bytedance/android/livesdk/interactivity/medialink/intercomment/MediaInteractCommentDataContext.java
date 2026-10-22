package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.c0;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomChangeSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ae;
import com.bytedance.android.livesdk.message.model.be;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB\u000f\u0012\u0006\u0010C\u001a\u00020\u000b¢\u0006\u0004\bI\u0010HJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u00101R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010$R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/MediaInteractCommentDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/a;", "action", "", "sendAction", "Ltlc/d;", "message", "onMessage", "invite", "", "replyStatus", "", "banInvite", "reply", "close", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lio/reactivex/disposables/Disposable;", "mInviteTimeOutDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "isAnchor", "Z", "Landroidx/lifecycle/MutableLiveData;", "_interComState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "interComState", "Landroidx/lifecycle/LiveData;", "getInterComState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/live/datacontext/k;", "", "onIconClickEvent$delegate", "getOnIconClickEvent", "()Lcom/bytedance/live/datacontext/k;", "onIconClickEvent", "showInterCommentIcon", "getShowInterCommentIcon", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "mInterComLogger", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "getMInterComLogger", "()Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "setMInterComLogger", "(Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;)V", "isStarter", "mIsInviting", "isFinisher", "", "mStartTimeInterval", "J", "scene", "I", "getScene", "()I", "setScene", "(I)V", "<init>", "Companion", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaInteractCommentDataContext extends DataContext implements vlc.l {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final c Companion = null;
    public static final long INVITE_TIME_OUT = 20;
    public static final int REPLY_AGREE = 1;
    public static final int REPLY_REFUSE = 2;
    public static final int REPLY_REFUSE_BY_TIME_OUT = 3;
    public static final String TAG = "MediaInteractCommentDataContext";
    private final MutableLiveData<Integer> _interComState;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f138173cd;
    private final LiveData<Integer> interComState;
    private boolean isAnchor;
    private boolean isFinisher;
    private boolean isStarter;
    private com.bytedance.android.livesdk.interactivity.medialink.intercomment.d mInterComLogger;
    private Disposable mInviteTimeOutDisposable;
    private boolean mIsInviting;
    private long mStartTimeInterval;
    private final p onIconClickEvent$delegate;
    private final RoomContext roomContext;
    private int scene;
    private final p service$delegate;
    private final MutableLiveData<Boolean> showInterCommentIcon;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138174a;

        public a(MediaInteractCommentDataContext r100) {
            this.f138174a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            RoomContext r100 = this.f138174a.getRoomContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
            if (r101 == null) goto L9;
            vlc.d r102 = r101.getValue();
            if (r102 == null) goto L9;
            r102.removeMessageListener(this.f138174a);
        L9:
            MediaInteractCommentDataContext.access$getCd$p(this.f138174a).dispose();
            Disposable r103 = MediaInteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.f138174a);
            if (r103 == null) goto L13;
            r103.dispose();
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138175a;

        public b(MediaInteractCommentDataContext r100) {
            this.f138175a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            dc2.c.b r111 = (dc2.c.b) r110;
            if (((IntercomChangeSyncData) r111.f467859b).isInIntercom() == false) goto L6;
            MediaInteractCommentDataContext.access$setMStartTimeInterval$p(this.f138175a, System.currentTimeMillis());
            MediaInteractCommentDataContext.access$sendAction(this.f138175a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        L29:
            MediaInteractCommentDataContext.access$setFinisher$p(this.f138175a, false);
            return;
        L6:
            if (((IntercomChangeSyncData) r111.f467859b).closeReason != 3) goto L11;
            if (MediaInteractCommentDataContext.access$isAnchor$p(this.f138175a) == false) goto L11;
            f2.b(R.string.ttlive_media_inter_comment_close_by_online_list, 0);
        L11:
            if (MediaInteractCommentDataContext.access$isAnchor$p(this.f138175a) == false) goto L28;
            com.bytedance.android.livesdk.interactivity.medialink.intercomment.d r100 = this.f138175a.getMInterComLogger();
            boolean r101 = MediaInteractCommentDataContext.access$isStarter$p(this.f138175a);
            boolean r102 = MediaInteractCommentDataContext.access$isFinisher$p(this.f138175a);
            long r103 = MediaInteractCommentDataContext.access$getMStartTimeInterval$p(this.f138175a);
            long r104 = ((IntercomChangeSyncData) r111.f467859b).closeReason;
            r100.getClass();
            HashMap r112 = new HashMap();
            r112.put("connection_scene", WsConstants.KEY_CONNECTION);
            r112.put("channel_id", String.valueOf(e92.m.b()));
            com.bytedance.android.livesdk.interactivity.medialink.intercomment.d.a(r112);
            r112.put("interflow_time", String.valueOf((System.currentTimeMillis() - r103) / ((long) 1000)));
            if (r104 != 2) goto L15;
        L23:
            String r105 = "other_close_type";
        L24:
            r112.put("close_type", r105);
            com.bytedance.android.livesdk.interactivity.api.base.b.a r106 = com.bytedance.android.livesdk.interactivity.api.base.b.f132890m;
            q r107 = q.f133747a;
            r106.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b r108 = com.bytedance.android.livesdk.interactivity.api.base.b.a.a();
            if (r108 == null) goto L27;
            r112.put("comment_show_cnt", String.valueOf(r108.f132899i));
            r112.put("other_comment_show_cnt", String.valueOf(r108.f132900j));
        L27:
            u.l().sendLog("livesdk_comment_interflow_end", r112, new Object[]{Room.class});
            goto L28
        L15:
            if (r104 == 3) goto L23;
            if (r101 == false) goto L20;
            if (r102 == true) goto L22;
        L21:
            r105 = "guest";
        L22:
            r105 = "host";
            goto L24
        L20:
            if (r102 == false) goto L22;
        L28:
            com.bytedance.android.livesdk.interactivity.api.base.b.a r113 = com.bytedance.android.livesdk.interactivity.api.base.b.f132890m;
            q r109 = q.f133747a;
            r113.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b.a.d();
            MediaInteractCommentDataContext.access$sendAction(this.f138175a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            goto L29
        }
    }

    public static final class c {
        public c() {
        }

        public final MediaInteractCommentDataContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MediaInteractCommentDataContext.TAG);
            if ((r100 instanceof MediaInteractCommentDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (MediaInteractCommentDataContext) r100;
        }

        public final com.bytedance.android.livesdk.interactivity.medialink.intercomment.b a() {
            MediaInteractCommentDataContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.medialink.intercomment.b> r101 = r100.getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138176a;

        public d(MediaInteractCommentDataContext r100) {
            this.f138176a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MediaInteractCommentDataContext.access$sendAction(this.f138176a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            c0 r101 = (c0) ((Response) r100).data;
            if (r101 == null) goto L8;
            String r102 = r101.toast;
            if (r102 == null) goto L9;
            f2.c(r102, 0);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f138177a = null;

        static {
            f138177a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138178a;

        public f(MediaInteractCommentDataContext r100) {
            this.f138178a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            MediaInteractCommentDataContext.access$setMIsInviting$p(this.f138178a, false);
            MediaInteractCommentDataContext.access$sendAction(this.f138178a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.f(true));
            Disposable r102 = MediaInteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.f138178a);
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            MediaInteractCommentDataContext.access$setMInviteTimeOutDisposable$p(this.f138178a, Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.i(this)));
            c0 r103 = (c0) r101.data;
            if (r103 == null) goto L11;
            String r104 = r103.toast;
            if (r104 == null) goto L12;
            f2.c(r104, 0);
            return;
        L12:
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138179a;

        public g(MediaInteractCommentDataContext r100) {
            this.f138179a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            MediaInteractCommentDataContext.access$setMIsInviting$p(this.f138179a, false);
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f138181b;

        public h(MediaInteractCommentDataContext r100, int r101) {
            this.f138180a = r100;
            this.f138181b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (this.f138181b != 1) goto L5;
            MediaInteractCommentDataContext.access$sendAction(this.f138180a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        L6:
            c0 r102 = (c0) r101.data;
            if (r102 == null) goto L12;
            String r103 = r102.toast;
            if (r103 == null) goto L13;
            f2.c(r103, 0);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            MediaInteractCommentDataContext.access$sendAction(this.f138180a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            goto L6
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaInteractCommentDataContext f138182a;

        public i(MediaInteractCommentDataContext r100) {
            this.f138182a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Context r101 = s1.getContext();
            ExceptionUtils.handleException(r101, (Throwable) r100);
            MediaInteractCommentDataContext.access$sendAction(this.f138182a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MediaInteractCommentDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaInteractCommentDataContext.class, "onIconClickEvent", "getOnIconClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new c();
    }

    public final void close() {
        this.isFinisher = true;
        LinkInteractCommentApi r100 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r101 = this.roomContext;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L9;
        Room r103 = r102.getValue();
        if (r103 == null) goto L9;
        long r104 = r103.getRoomId();
    L10:
        Disposable r105 = r100.intercomClose(r104, e92.m.b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), e.f138177a);
        this.f138173cd.add(r105);
        return;
    L9:
        r104 = 0;
        goto L10
    }

    public final com.bytedance.live.datacontext.k<Object> getOnIconClickEvent() {
        return (com.bytedance.live.datacontext.k) this.onIconClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.medialink.intercomment.b> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void invite() {
        this.isStarter = true;
        if (this.mIsInviting == false) goto L5;
        return;
    L5:
        this.mIsInviting = true;
        LinkInteractCommentApi r100 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r101 = this.roomContext;
        if (r101 == null) goto L12;
        com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L12;
        Room r103 = r102.getValue();
        if (r103 == null) goto L12;
        long r104 = r103.getRoomId();
    L13:
        Disposable r105 = r100.intercomInvite(r104, e92.m.b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this), new g(this));
        this.f138173cd.add(r105);
        return;
    L12:
        r104 = 0;
        goto L13
    }

    public final LiveData<Integer> getInterComState() {
        return this.interComState;
    }

    public final com.bytedance.android.livesdk.interactivity.medialink.intercomment.d getMInterComLogger() {
        return this.mInterComLogger;
    }

    public final RoomContext getRoomContext() {
        return this.roomContext;
    }

    public final int getScene() {
        return this.scene;
    }

    public final MutableLiveData<Boolean> getShowInterCommentIcon() {
        return this.showInterCommentIcon;
    }

    public MediaInteractCommentDataContext(int r100) {
        this.scene = r100;
        this.service$delegate = ConstantKt.c(this);
        DataContext r101 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r101 instanceof RoomContext) == true) goto L5;
        r101 = null;
    L5:
        RoomContext r102 = (RoomContext) r101;
        this.roomContext = r102;
        CompositeDisposable r103 = new CompositeDisposable();
        this.f138173cd = r103;
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.i<Boolean> r104 = r102.isAnchor();
        if (r104 == null) goto L12;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L12;
        boolean r106 = r105.booleanValue();
    L13:
        this.isAnchor = r106;
        MutableLiveData<Integer> r107 = new MutableLiveData();
        this._interComState = r107;
        this.interComState = r107;
        this.onIconClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.showInterCommentIcon = new MutableLiveData();
        this.mInterComLogger = new com.bytedance.android.livesdk.interactivity.medialink.intercomment.d();
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r103);
        if (r102 == null) goto L20;
        com.bytedance.live.datacontext.j<vlc.d> r108 = r102.getMessageManager();
        if (r108 == null) goto L20;
        vlc.d r109 = r108.getValue();
        if (r109 == null) goto L20;
        r109.addMessageListener(MessageType.INTER_COM_INVITE.getIntType(), this);
        r109.addMessageListener(MessageType.INTER_COM_REPLY.getIntType(), this);
    L20:
        IntercomSyncDataModel r110 = q.h();
        if (r110 == null) goto L30;
        dc2.c<IntercomChangeSyncData> r111 = r110.getIntercomStatus();
        if (r111 == null) goto L30;
        IntercomChangeSyncData r112 = r111.c();
        if (r112 == null) goto L30;
        if (r112.isInIntercom() == false) goto L29;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        goto L30
    L29:
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
    L30:
        IntercomSyncDataModel r113 = q.h();
        if (r113 == null) goto L40;
        dc2.c<IntercomChangeSyncData> r114 = r113.getIntercomStatus();
        if (r114 == null) goto L41;
        Observable<dc2.c.b<IntercomChangeSyncData>> r115 = r114.b();
        if (r115 == null) goto L42;
        Disposable r116 = r115.subscribe(new b(this));
        if (r116 == null) goto L43;
        r103.add(r116);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L12:
        r106 = false;
        goto L13
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(MediaInteractCommentDataContext r100) {
        return r100.f138173cd;
    }

    public static final /* synthetic */ Disposable access$getMInviteTimeOutDisposable$p(MediaInteractCommentDataContext r100) {
        return r100.mInviteTimeOutDisposable;
    }

    public static final /* synthetic */ boolean access$getMIsInviting$p(MediaInteractCommentDataContext r100) {
        return r100.mIsInviting;
    }

    public static final /* synthetic */ long access$getMStartTimeInterval$p(MediaInteractCommentDataContext r100) {
        return r100.mStartTimeInterval;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(MediaInteractCommentDataContext r100) {
        return r100.isAnchor;
    }

    public static final /* synthetic */ boolean access$isFinisher$p(MediaInteractCommentDataContext r100) {
        return r100.isFinisher;
    }

    public static final /* synthetic */ boolean access$isStarter$p(MediaInteractCommentDataContext r100) {
        return r100.isStarter;
    }

    private final void sendAction(com.bytedance.android.livesdk.interactivity.medialink.intercomment.a r100) {
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
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.e) == false) goto L33;
    L24:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.h) == false) goto L28;
        ((com.bytedance.android.livesdk.interactivity.medialink.intercomment.h) r100).getClass();
    L26:
        r103 = 4;
        goto L34
    L28:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.g) == true) goto L26;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.e) == false) goto L33;
    L8:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.f) == false) goto L14;
        if (((com.bytedance.android.livesdk.interactivity.medialink.intercomment.f) r100).f138206a == false) goto L12;
        r103 = 1;
        goto L34
    L12:
        r103 = 2;
        goto L34
    L14:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.g) == false) goto L33;
        goto L33
    }

    @Override // vlc.l
    public void onMessage(tlc.d r100) {
        if ((r100 instanceof ae) == false) goto L6;
        this.isStarter = false;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.f(false));
        return;
    L6:
        if ((r100 instanceof be) == false) goto L28;
        be r101 = (be) r100;
        String r102 = r101.getMToast();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        f2.c(r101.getMToast(), 0);
    L16:
        Disposable r104 = this.mInviteTimeOutDisposable;
        if (r104 == null) goto L20;
        r104.dispose();
    L20:
        if (r101.getMReplyStatus() != 1) goto L23;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        return;
    L23:
        if (this.isAnchor == false) goto L25;
        this.mInterComLogger.getClass();
        HashMap r105 = new HashMap();
        r105.put("connection_scene", WsConstants.KEY_CONNECTION);
        r105.put("channel_id", String.valueOf(e92.m.b()));
        com.bytedance.android.livesdk.interactivity.medialink.intercomment.d.a(r105);
        u.l().sendLog("livesdk_refuse_feedback", r105, new Object[]{Room.class});
    L25:
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
        return;
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
        goto L14
    }

    public final void setMInterComLogger(com.bytedance.android.livesdk.interactivity.medialink.intercomment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mInterComLogger = r100;
    }

    public final void setScene(int r100) {
        this.scene = r100;
    }

    public static final /* synthetic */ void access$sendAction(MediaInteractCommentDataContext r100, com.bytedance.android.livesdk.interactivity.medialink.intercomment.a r101) {
        r100.sendAction(r101);
    }

    public static final /* synthetic */ void access$setAnchor$p(MediaInteractCommentDataContext r100, boolean r101) {
        r100.isAnchor = r101;
    }

    public static final /* synthetic */ void access$setFinisher$p(MediaInteractCommentDataContext r100, boolean r101) {
        r100.isFinisher = r101;
    }

    public static final /* synthetic */ void access$setMInviteTimeOutDisposable$p(MediaInteractCommentDataContext r100, Disposable r101) {
        r100.mInviteTimeOutDisposable = r101;
    }

    public static final /* synthetic */ void access$setMIsInviting$p(MediaInteractCommentDataContext r100, boolean r101) {
        r100.mIsInviting = r101;
    }

    public static final /* synthetic */ void access$setMStartTimeInterval$p(MediaInteractCommentDataContext r100, long r101) {
        r100.mStartTimeInterval = r101;
    }

    public static final /* synthetic */ void access$setStarter$p(MediaInteractCommentDataContext r100, boolean r101) {
        r100.isStarter = r101;
    }

    public final void reply(int r100, boolean r110) {
        if (r100 != 1) goto L5;
        int r101 = 1;
    L6:
        LinkInteractCommentApi r102 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r103 = this.roomContext;
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L13;
        Room r105 = r104.getValue();
        if (r105 == null) goto L13;
        long r106 = r105.getRoomId();
    L14:
        Disposable r107 = r102.intercomReply(r106, e92.m.b(), r101, r110).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r100), new i(this));
        this.f138173cd.add(r107);
        return;
    L13:
        r106 = 0;
        goto L14
    L5:
        r101 = 2;
        goto L6
    }
}
