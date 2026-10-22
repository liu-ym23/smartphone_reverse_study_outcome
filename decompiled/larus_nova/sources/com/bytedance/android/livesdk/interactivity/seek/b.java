package com.bytedance.android.livesdk.interactivity.seek;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.u1;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<jc1.h> f140780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IVSPlayerService f140781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RoomContext f140782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f140783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f140784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f140785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f140786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f140787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f140788i;

    public static final class a implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f140789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f140790b;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r100) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
            b r100 = this.f140790b;
            if (r100.f140782c != null) goto L6;
            return;
        L6:
            if (b.a(r100) == false) goto L11;
            Iterator<T> r101 = this.f140790b.f140780a.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            ((jc1.h) r101.next()).e(b.b(this.f140790b));
            goto L9
        L13:
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
            Iterator<T> r100 = this.f140790b.f140780a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((jc1.h) r100.next()).f(b.b(this.f140790b));
            goto L4
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
            Iterator<T> r100 = this.f140790b.f140780a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((jc1.h) r100.next()).h(b.b(this.f140790b));
            goto L4
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
            b r100 = this.f140790b;
            if (r100.f140782c != null) goto L6;
            return;
        L6:
            if (b.a(r100) == false) goto L11;
            Iterator<T> r101 = this.f140790b.f140780a.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            ((jc1.h) r101.next()).c(b.b(this.f140790b));
            goto L9
        L13:
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
            b r100 = this.f140790b;
            if (r100.f140782c != null) goto L6;
            return;
        L6:
            if (b.a(r100) == false) goto L11;
            Iterator<T> r101 = this.f140790b.f140780a.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            ((jc1.h) r101.next()).a(b.b(this.f140790b));
            goto L9
        L13:
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
            b r100 = this.f140790b;
            if (r100.f140782c != null) goto L6;
            return;
        L6:
            if (b.a(r100) == false) goto L11;
            Iterator<T> r101 = this.f140790b.f140780a.iterator();
        L9:
            if (r101.hasNext() == false) goto L13;
            ((jc1.h) r101.next()).b(b.b(this.f140790b));
            goto L9
        L13:
            return;
        }

        public a(b r100) {
            this.f140790b = r100;
            this.f140789a = -1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r100) {
            if (r100 == false) goto L4;
            return;
        L4:
            b r101 = this.f140790b;
            if (r101.f140782c != null) goto L7;
            return;
        L7:
            long r102 = b.b(r101);
            if (this.f140789a != r102) goto L10;
        L15:
            this.f140789a = r102;
            return;
        L10:
            if (b.a(this.f140790b) == false) goto L15;
            Iterator<jc1.h> r103 = this.f140790b.f140780a.iterator();
        L13:
            if (r103.hasNext() == false) goto L15;
            r103.next().d(b.b(this.f140790b));
            goto L13
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r100, r101);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r100, Pair<Integer, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r100, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r100, r101);
        }
    }

    public final Context getContext() {
        return this.f140787h;
    }

    public static final boolean a(b r100) {
        r100.getClass();
        IVSPlayerService r101 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r101 == null) goto L13;
        IPlayerProgressService r102 = r101.provideVSProgressService(r100.f140788i);
        if (r102 == null) goto L13;
        PlayerProgressServiceContext r103 = r102.provideContext(r100.f140788i);
        if (r103 == null) goto L13;
        m<Boolean> r104 = r103.getVsRoomEnableSeek();
        if (r104 == null) goto L13;
        if (r104.getValue().booleanValue() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static final long b(b r100) {
        return com.bytedance.android.livesdk.interactivity.common.utils.f.b(r100.f140788i) / ((long) 1000);
    }

    public b(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f140787h = r100;
        this.f140788i = r101;
        this.f140780a = new ArrayList();
        this.f140784e = new a(this);
        this.f140785f = ((long) u1.f472062a.getValue().intValue()) * ((long) 1000);
    }
}
