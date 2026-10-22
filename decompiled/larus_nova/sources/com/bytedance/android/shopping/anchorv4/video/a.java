package com.bytedance.android.shopping.anchorv4.video;

import com.bytedance.android.shopping.commentv3.audio.StopReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends d implements com.bytedance.android.shopping.commentv3.audio.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f167530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f167531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f167532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f167533l;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.video.a$a, reason: collision with other inner class name */
    public static final class C2527a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final Object getPlayer() {
        return this;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.h
    public final void i() {
        this.f167530i = true;
        f.a.b(this.f167532k, this, false, 6);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean b() {
        if (this.f167530i == false) goto L7;
        this.f167533l.invoke();
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.h
    public final void release() {
        if (this.f167531j == true) goto L5;
        return;
    L5:
        f(StopReason.PAGE_DESTROY);
        this.f167531j = false;
        this.f167532k.g(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean isPlaying() {
        return this.f167530i;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.h
    public final void f(StopReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f167530i == true) goto L5;
        return;
    L5:
        this.f167530i = false;
        f.a.a(this.f167532k, this, false, false, 6);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final boolean g(boolean r100) {
        if (r100 == false) goto L7;
        if (this.f167530i == false) goto L7;
        this.f167533l.invoke();
    L7:
        return this.f167530i;
    }

    public a(f r100, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "playerStateManager");
        Intrinsics.checkNotNullParameter(r110, "stopAudio");
        super("comment_audio", r100, Boolean.FALSE, true, false, 40);
        this.f167532k = r100;
        this.f167533l = r110;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
    public final Boolean j(Boolean r100, boolean r101) {
        return Boolean.FALSE;
    }
}
