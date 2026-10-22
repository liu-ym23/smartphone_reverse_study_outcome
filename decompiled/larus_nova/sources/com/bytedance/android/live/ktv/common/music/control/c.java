package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class c extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IMusicControlNode.OperationType f70017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f70018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f70019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f70020i;

    public void e(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
    }

    public void g(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
    }

    public void h() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void c() {
        if (this.f70020i == false) goto L5;
        e(this.f70024d);
        return;
    L5:
        g(this.f70024d);
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d
    public final void d() {
        super.d();
        h();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.d, com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public IMusicControlNode.OperationType getType() {
        return this.f70017f;
    }

    public final void f(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Disposable r101 = this.f70022b;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        g r102 = this.f70023c;
        if (r102 == null) goto L8;
        r102.c(new IMusicControlNode.b(getType(), r100), this);
    L8:
        h();
    }

    public c(MusicPanel r100, boolean r101, ModeType r102) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r102, "modeType");
        super(r100, r102);
        this.f70020i = r101;
        this.f70017f = IMusicControlNode.OperationType.CUT_MUSIC;
        this.f70018g = o3.f();
    }
}
