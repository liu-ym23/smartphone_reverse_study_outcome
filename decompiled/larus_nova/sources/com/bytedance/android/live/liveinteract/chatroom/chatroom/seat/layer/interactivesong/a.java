package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunnableC1159a f72291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b f72292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Deque<com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b> f72294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b> f72295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f72296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f72297g;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a$a, reason: collision with other inner class name */
    public final class RunnableC1159a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f72298a;

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        L20:
            return;
        L3:
            if (this.f72298a.f72294d.isEmpty() == true) goto L14;
            a r100 = this.f72298a;     // Catch: Throwable -> L11
            if (r100.f72293c == true) goto L18;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r101 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) ((LinkedList) r100.f72294d).pollFirst();     // Catch: Throwable -> L11
            this.f72298a.f72292b = r101;     // Catch: Throwable -> L11
            if (r101 == null) goto L19;
            r101.a();     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        }

        public RunnableC1159a(a r100) {
            this.f72298a = r100;
        }
    }

    public static final class b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f72299a;

        public b(a r100) {
            this.f72299a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.q
        public final void a(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            ((ArrayList) this.f72299a.f72295e).add(r100);
            this.f72299a.f72293c = true;
        }

        @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.q
        public final void b(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            a r101 = this.f72299a;
            r101.f72293c = false;
            ((ArrayList) r101.f72295e).remove(r100);
            a r102 = this.f72299a;
            r102.f72297g.removeCallbacks(r102.f72291a);
            a r103 = this.f72299a;
            r103.f72297g.post(r103.f72291a);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f72300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b f72301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f72302c;

        public c(a r100, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r101, boolean r102) {
            this.f72300a = r100;
            this.f72301b = r101;
            this.f72302c = r102;
        }

        public final void a() {
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r100 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) ((LinkedList) this.f72300a.f72294d).peekLast();
            Object r101 = null;
            if (r100 == null) goto L5;
            Class<?> r102 = r100.getClass();
        L6:
            boolean r103 = true;
            if (Intrinsics.areEqual(r102, this.f72301b.getClass()) == true) goto L9;
        L11:
            boolean r104 = false;
        L12:
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r105 = this.f72300a.f72292b;
            if (r105 == null) goto L15;
            Class<?> r106 = r105.getClass();
        L17:
            if (Intrinsics.areEqual(r106, this.f72301b.getClass()) == false) goto L24;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r107 = this.f72300a.f72292b;
            if (r107 == null) goto L22;
            r101 = r107.f72305c;
        L22:
            if (Intrinsics.areEqual(r101, this.f72301b.f72305c) == false) goto L24;
            boolean r108 = true;
        L25:
            a r109 = this.f72300a;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r110 = this.f72301b;
            Iterator r111 = ((ArrayList) r109.f72295e).iterator();
        L27:
            if (r111.hasNext() == false) goto L35;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r112 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) r111.next();
            if (Intrinsics.areEqual(r112.getClass(), r110.getClass()) == false) goto L27;
            if (r112.f72304b == false) goto L27;
            if (Intrinsics.areEqual(r112.f72305c, r110.f72305c) == false) goto L27;
            boolean r113 = true;
        L36:
            n.d("AnimationExecutor#execute.processing:" + this.f72300a.f72293c + ",force:" + this.f72302c + ",isLastSame:" + r104 + ",isFirstSame:" + r108 + ",task:" + this.f72301b + ",alreadyPlay," + r113 + "curTask:" + this.f72300a.f72292b + ",lastTaskInQueue:" + r100);
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r114 = this.f72301b;
            if ((r114 instanceof RequestSongMicSeatView.UpdateScoreTask) == true) goto L42;
            if (r104 == true) goto L43;
            if (r108 == true) goto L43;
            if (r113 == false) goto L42;
        L43:
            if (r103 == false) goto L45;
            return;
        L45:
            ((LinkedList) this.f72300a.f72294d).add(r114);
            com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r115 = this.f72301b;
            a r116 = this.f72300a;
            r115.f72303a = r116.f72296f;
            if (r116.f72293c == true) goto L48;
        L49:
            r116.f72297g.removeCallbacks(r116.f72291a);
            a r117 = this.f72300a;
            r117.f72297g.post(r117.f72291a);
            return;
        L48:
            if (this.f72302c == true) goto L49;
            return;
        L42:
            r103 = false;
            goto L43
        L35:
            r113 = false;
        L24:
            r108 = false;
            goto L25
        L15:
            r106 = null;
            goto L17
        L9:
            if (Intrinsics.areEqual(r100.f72305c, this.f72301b.f72305c) == false) goto L11;
            r104 = true;
            goto L12
        L5:
            r102 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void a() {
        ((LinkedList) this.f72294d).clear();
        this.f72293c = false;
        Iterator r100 = ((ArrayList) this.f72295e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b) r100.next()).f72304b = false;
        goto L4
    L6:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r101 = this.f72292b;
        if (r101 == null) goto L9;
        r101.f72304b = false;
    L9:
        this.f72292b = null;
    }

    public a(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f72297g = r100;
        this.f72291a = new RunnableC1159a(this);
        this.f72294d = new LinkedList();
        this.f72295e = new ArrayList();
        this.f72296f = new b(this);
    }

    public void b(com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.f72297g.postDelayed(new c(this, r100, r102), r101);
    }

    public static /* synthetic */ void c(a r100, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.b r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        r100.b(r101, 0, r102);
    }
}
