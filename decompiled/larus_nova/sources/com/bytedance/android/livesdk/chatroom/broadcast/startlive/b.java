package com.bytedance.android.livesdk.chatroom.broadcast.startlive;

import com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ILivePreviewTouchEventDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f105357a;

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "broadcastProvider");
        this.f105357a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processDoubleClickEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processLongPressEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processRotationEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processScaleEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processTouchDownEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processTouchEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processTouchUpEvent(float r100, float r101) {
        com.bytedance.android.live.pushstream.d r102 = this.f105357a.getLiveStream();
        if (r102 == null) goto L5;
        r102.d();
    L5:
        com.bytedance.android.live.pushstream.d r103 = this.f105357a.getLiveStream();
        if (r103 == null) goto L11;
        d0 r104 = r103.A();
        if (r104 == null) goto L12;
        r104.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processPanEvent(float r100, float r101, float r102, float r103, float r104) {
        com.bytedance.android.live.pushstream.d r105 = this.f105357a.getLiveStream();
        if (r105 == null) goto L5;
        r105.d();
    L5:
        com.bytedance.android.live.pushstream.d r106 = this.f105357a.getLiveStream();
        if (r106 == null) goto L11;
        d0 r107 = r106.A();
        if (r107 == null) goto L12;
        r107.D();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewTouchEventDelegate
    public final void processAmazingTouchEvent(int r100, int r101, float r102, float r103, float r104, float r105, int r106) {
        com.bytedance.android.live.pushstream.d r107 = this.f105357a.getLiveStream();
        if (r107 == null) goto L5;
        r107.d();
    L5:
        com.bytedance.android.live.pushstream.d r108 = this.f105357a.getLiveStream();
        if (r108 == null) goto L11;
        d0 r109 = r108.A();
        if (r109 == null) goto L12;
        r109.D();
        return;
    L12:
        return;
    }
}
