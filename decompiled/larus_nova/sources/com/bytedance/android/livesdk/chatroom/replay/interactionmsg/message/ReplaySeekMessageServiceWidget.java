package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.message;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.ReplayMessageTracer;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ISegmentFlowTime;
import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import java.util.List;
import jc1.h;
import jc1.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/message/ReplaySeekMessageServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplaySeekMessageServiceWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f109262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends ISegmentFlowTime> f109263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f109264c;

    public static final class a implements com.bytedance.android.livesdk.chatroom.replay.interactionmsg.message.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekMessageServiceWidget f109265a;

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.message.a
        public final void start() {
            ReplaySeekMessageServiceWidget r100 = this.f109265a;
            r100.getClass();
            ReplayDataContext.a r101 = ReplayDataContext.Companion;
            DataCenter r102 = r100.dataCenter;
            r101.getClass();
            ReplayDataContext r103 = ReplayDataContext.a.b(r102);
            if (r103 == null) goto L10;
            n<vlc.d> r104 = r103.getSeekMessageManager();
            if (r104 == null) goto L11;
            vlc.d r105 = r104.getValue();
            if (r105 == null) goto L12;
            xq1.b.b().d(r105);
            return;
        L12:
            return;
        L11:
            return;
        }

        public a(ReplaySeekMessageServiceWidget r100) {
            this.f109265a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.message.a
        public final void stop(boolean r100) {
            ReplaySeekMessageServiceWidget r101 = this.f109265a;
            r101.getClass();
            ReplayDataContext.a r102 = ReplayDataContext.Companion;
            DataCenter r103 = r101.dataCenter;
            r102.getClass();
            ReplayDataContext r104 = ReplayDataContext.a.b(r103);
            if (r104 == null) goto L10;
            n<vlc.d> r105 = r104.getSeekMessageManager();
            if (r105 == null) goto L11;
            vlc.d r106 = r105.getValue();
            if (r106 == null) goto L12;
            ReplayMessageTracer.c("stop message manager");
            r106.r(r100);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplaySeekMessageServiceWidget f109266a;

        public b(ReplaySeekMessageServiceWidget r100) {
            this.f109266a = r100;
        }

        @Override // jc1.i
        public final void a(long r100) {
            ReplayMessageTracer.c("video play resume, try start, time point: " + r100);
            ReplaySeekMessageServiceWidget.wq(this.f109266a, r100);
            f r101 = this.f109266a.f109264c;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // jc1.i
        public final void b(long r100) {
            ReplayMessageTracer.c("video play pause, try stop, time point: " + r100);
            f r101 = this.f109266a.f109264c;
            if (r101 == null) goto L6;
            c.b r102 = new c.b(false);
            StateMachine<e, c, d> r103 = r101.f109273a;
            StateMachine.a r104 = StateMachine.f66079c;
            r103.d(r102, null);
            return;
        }

        @Override // jc1.i
        public final void c(long r100) {
            ReplayMessageTracer.c("video seek start, try stop, time point: " + r100);
            f r101 = this.f109266a.f109264c;
            if (r101 == null) goto L6;
            c.b r102 = new c.b(true);
            StateMachine<e, c, d> r103 = r101.f109273a;
            StateMachine.a r104 = StateMachine.f66079c;
            r103.d(r102, null);
            return;
        }

        @Override // jc1.i
        public final void d(long r100) {
            ReplaySeekMessageServiceWidget.wq(this.f109266a, r100);
            f r101 = this.f109266a.f109264c;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // jc1.i
        public final void e(long r100) {
            ReplayMessageTracer.c("video seek success, try start, time point: " + r100);
            ReplaySeekMessageServiceWidget.wq(this.f109266a, r100);
            f r101 = this.f109266a.f109264c;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f109263b = null;
        this.f109264c = null;
        ReplayMessageTracer.c("unregister video progress listener");
        b r100 = this.f109262a;
        WeakContainer<h> r101 = jc1.b.f498072a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        jc1.b.f498074c.remove(r100);
    }

    public ReplaySeekMessageServiceWidget() {
        this.f109262a = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f109264c = new f(new a(this));
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r103 = ReplayDataContext.a.b(r102);
        if (r103 != null) goto L5;
        return;
    L5:
        Episode r104 = r103.getEpisode().getValue();
        if (r104 == null) goto L10;
        EpisodeVideo r105 = r104.video;
        if (r105 == null) goto L10;
        List<ISegmentFlowTime> r106 = r105.getSegmentFlowTimeList();
    L11:
        this.f109263b = r106;
        ReplayMessageTracer.c("register video progress listener");
        b r107 = this.f109262a;
        WeakContainer<h> r108 = jc1.b.f498072a;
        Intrinsics.checkNotNullParameter(r107, "listener");
        jc1.b.f498074c.add(r107);
        return;
    L10:
        r106 = null;
        goto L11
    }

    public static final void wq(ReplaySeekMessageServiceWidget r110, long r111) {
        List<? extends ISegmentFlowTime> r100 = r110.f109263b;
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Object r102 = r101.next();
        ISegmentFlowTime r103 = (ISegmentFlowTime) r102;
        long r104 = r103.getStartOffset();
        long r105 = r103.getEndOffset();
        long r106 = ((long) 1000) * r111;
        if (r104 <= r106) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L6;
    L17:
        ISegmentFlowTime r108 = (ISegmentFlowTime) r102;
        if (r108 == null) goto L20;
        long r109 = r108.getStartOffsetFlowTime();
    L21:
        long r112 = (r111 * 1000) + r109;
        long r113 = r109 + ((r111 + 1) * 1000);
        StringBuilder r114 = new StringBuilder();
        r114.append(r112);
        r114.append('_');
        r114.append(r113);
        String r115 = r114.toString();
        ReplayDataContext.a r116 = ReplayDataContext.Companion;
        DataCenter r117 = r110.dataCenter;
        r116.getClass();
        ReplayDataContext r118 = ReplayDataContext.a.b(r117);
        if (r118 == null) goto L34;
        n<vlc.d> r119 = r118.getSeekMessageManager();
        if (r119 == null) goto L35;
        vlc.d r120 = r119.getValue();
        if (r120 == null) goto L36;
        xq1.b.b().h(r120, r115);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L11:
        if (r105 < r106) goto L13;
        r107 = true;
        goto L14
    L16:
        r102 = null;
    L20:
        r109 = ((long) 1000) * r111;
        goto L21
    }
}
