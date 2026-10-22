package com.bytedance.android.livesdk.chatroom.replay.util;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.i;
import kotlin.jvm.internal.Intrinsics;
import mq1.t;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<i> f110270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f110271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f110272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f110273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f110274e;

    public static final class a implements jm1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f110275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f110276b;

        @Override // jm1.c
        public final void P1() {
        }

        @Override // jm1.c
        public final void Xa(boolean r100) {
        }

        @Override // jm1.c
        public final void onRenderStart() {
        }

        @Override // jm1.c
        public final void z() {
        }

        @Override // jm1.c
        public final void C5() {
            Iterator<T> r100 = this.f110276b.f110270a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((i) r100.next()).e(e.a(this.f110276b));
            goto L4
        }

        @Override // jm1.c
        public final void g5() {
            Iterator<T> r100 = this.f110276b.f110270a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((i) r100.next()).c(e.a(this.f110276b));
            goto L4
        }

        @Override // jm1.c
        public final void k2() {
            Iterator<T> r100 = this.f110276b.f110270a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((i) r100.next()).a(e.a(this.f110276b));
            goto L4
        }

        @Override // jm1.c
        public final void l3() {
            Iterator<T> r100 = this.f110276b.f110270a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((i) r100.next()).b(e.a(this.f110276b));
            goto L4
        }

        public a(e r100) {
            this.f110276b = r100;
            this.f110275a = -1;
        }

        @Override // jm1.c
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // jm1.c
        public final void Pc(float r100, boolean r101, long r102) {
            if (r101 == false) goto L4;
            return;
        L4:
            long r103 = e.a(this.f110276b);
            if (this.f110275a == r103) goto L10;
            Iterator<i> r104 = this.f110276b.f110270a.iterator();
        L8:
            if (r104.hasNext() == false) goto L10;
            r104.next().d(e.a(this.f110276b));
        L10:
            this.f110275a = r103;
        }
    }

    public final Context getContext() {
        return this.f110273d;
    }

    public static final long a(e r100) {
        return f.a(r100.f110274e) / ((long) 1000);
    }

    public e(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f110273d = r100;
        this.f110274e = r101;
        this.f110270a = new ArrayList();
        this.f110272c = new a(this);
    }
}
