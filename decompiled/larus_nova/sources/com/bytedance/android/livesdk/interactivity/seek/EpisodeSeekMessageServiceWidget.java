package com.bytedance.android.livesdk.interactivity.seek;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.live.datacontext.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/seek/EpisodeSeekMessageServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeSeekMessageServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f140775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f140776b;

    public static final class a implements jc1.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EpisodeSeekMessageServiceWidget f140777a;

        @Override // jc1.h
        public final void h(long r100) {
        }

        public a(EpisodeSeekMessageServiceWidget r100) {
            this.f140777a = r100;
        }

        @Override // jc1.h
        public final void a(long r100) {
            EpisodeInteractivityTracer.c("first show play resume, time point: " + r100);
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(this.f140777a.dataCenter) == false) goto L8;
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L9;
            r101.a();
            return;
        L9:
            return;
        }

        @Override // jc1.h
        public final void b(long r100) {
            EpisodeInteractivityTracer.c("first show play pause, try stop, time point: " + r100);
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L6;
            r101.b(false);
            return;
        }

        @Override // jc1.h
        public final void c(long r100) {
            EpisodeInteractivityTracer.c("first show seek start, try stop, time point: " + r100);
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L6;
            r101.b(true);
            return;
        }

        @Override // jc1.h
        public final void d(long r100) {
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(this.f140777a.dataCenter) == false) goto L8;
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L9;
            r101.a();
            return;
        L9:
            return;
        }

        @Override // jc1.h
        public final void e(long r110) {
            EpisodeInteractivityTracer.c("first show play success, try start, time point: " + r110);
            EpisodeSeekMessageServiceWidget r100 = this.f140777a;
            r100.getClass();
            long r101 = ((long) 1000) * r110;
            long r102 = (r110 * 1000) + r101;
            long r103 = r101 + ((r110 + 1) * 1000);
            StringBuilder r111 = new StringBuilder();
            r111.append(r102);
            r111.append('_');
            r111.append(r103);
            String r112 = r111.toString();
            RoomContext r113 = r100.getRoomContext();
            if (r113 == null) goto L10;
            j<vlc.d> r114 = r113.getSeekMessageManager();
            if (r114 == null) goto L10;
            vlc.d r115 = r114.getValue();
            if (r115 == null) goto L10;
            q52.b.a(r115, r112);
        L10:
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(this.f140777a.dataCenter) == false) goto L15;
            h r116 = this.f140777a.f140776b;
            if (r116 == null) goto L16;
            r116.a();
            return;
        L16:
            return;
        }

        @Override // jc1.h
        public final void f(long r100) {
            EpisodeInteractivityTracer.c("first show back to latest, try stop, time point: " + r100);
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L6;
            r101.b(true);
            return;
        }

        @Override // jc1.h
        public final void g(boolean r100) {
            EpisodeInteractivityTracer.c("on message fetch mode switch, seek: " + r100);
            if (r100 == true) goto L5;
        L9:
            h r101 = this.f140777a.f140776b;
            if (r101 == null) goto L15;
            r101.b(true);
            return;
        L15:
            return;
        L5:
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.c(this.f140777a.dataCenter) == false) goto L9;
            h r102 = this.f140777a.f140776b;
            if (r102 == null) goto L13;
            r102.a();
            return;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EpisodeSeekMessageServiceWidget f140778a;

        @Override // com.bytedance.android.livesdk.interactivity.seek.c
        public final void start() {
            RoomContext r100 = this.f140778a.getRoomContext();
            if (r100 == null) goto L8;
            j<vlc.d> r101 = r100.getSeekMessageManager();
            if (r101 == null) goto L9;
            r101.c(EpisodeSeekMessageServiceWidget$startMessage$1.INSTANCE);
            return;
        L9:
            return;
        }

        public b(EpisodeSeekMessageServiceWidget r100) {
            this.f140778a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.seek.c
        public final void stop(final boolean r100) {
            RoomContext r101 = this.f140778a.getRoomContext();
            if (r101 == null) goto L8;
            j<vlc.d> r102 = r101.getSeekMessageManager();
            if (r102 == null) goto L9;
            r102.c(new EpisodeSeekMessageServiceWidget$stopMessage$1(r100));
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.f140776b = null;
        EpisodeInteractivityTracer.c("unregister first show listener");
        jc1.b.b(this.f140775a);
    }

    public EpisodeSeekMessageServiceWidget() {
        this.f140775a = new a(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f140776b = new h(new b(this));
        RoomContext r101 = getRoomContext();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isVSFirstShow() != true) goto L9;
        EpisodeInteractivityTracer.c("register first show listener");
        jc1.b.a(this.f140775a);
        return;
    }
}
