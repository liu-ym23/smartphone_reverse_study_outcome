package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.ReplayMessageTracer;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView;
import com.bytedance.common.utility.collection.WeakContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayDanmakuPresenter extends lq1.a<IView> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f108897d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/ReplayDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/IReplayWidgetView;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IReplayWidgetView {
        void Ai();

        void K0();

        @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView
        /* synthetic */ Context getContext();

        void x0();
    }

    public static final class a implements jc1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuPresenter f108898a;

        @Override // jc1.i
        public final void d(long r100) {
        }

        @Override // jc1.i
        public final void e(long r100) {
        }

        public a(ReplayDanmakuPresenter r100) {
            this.f108898a = r100;
        }

        @Override // jc1.i
        public final void a(long r100) {
            ReplayMessageTracer.b("video play resume, resume all danmaku");
            IView r101 = (IView) this.f108898a.f510284a;
            if (r101 == null) goto L6;
            r101.x0();
            return;
        }

        @Override // jc1.i
        public final void b(long r100) {
            ReplayMessageTracer.b("video play pause, stop all danmaku");
            IView r101 = (IView) this.f108898a.f510284a;
            if (r101 == null) goto L6;
            r101.Ai();
            return;
        }

        @Override // jc1.i
        public final void c(long r100) {
            ReplayMessageTracer.b("video seek start, clear all danmaku");
            IView r101 = (IView) this.f108898a.f510284a;
            if (r101 == null) goto L6;
            r101.K0();
            return;
        }
    }

    public ReplayDanmakuPresenter() {
        this.f108897d = new a(this);
    }

    @Override // lq1.a
    public final void f() {
        super.f();
        ReplayMessageTracer.b("unregister video progress listener");
        a r100 = this.f108897d;
        WeakContainer<jc1.h> r101 = jc1.b.f498072a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        jc1.b.f498074c.remove(r100);
    }
}
