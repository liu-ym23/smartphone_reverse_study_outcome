package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.view.ILivePlayerView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements ILivePlayerView.PlayerCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125223a;

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onBufferingEnd() {
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onBufferingStart() {
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onInteractSeiUpdate(Object r100) {
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onMute(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onRoomFinish() {
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onPlayComplete() {
        k.i(this.f125223a);
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onPlayDisplayed() {
        FrameLayout r100 = this.f125223a.f125197e;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
    L6:
        if (Intrinsics.areEqual(this.f125223a.f125208p, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L13;
        k r101 = this.f125223a;
        RelativeLayout r102 = r101.f125206n;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
    L10:
        TextView r103 = r101.f125205m;
        if (r103 == null) goto L13;
        r103.setVisibility(0);
    L13:
        k r104 = this.f125223a;
        HSImageView r105 = r104.f125201i;
        if (r105 == null) goto L16;
        r105.setVisibility(8);
    L16:
        View r106 = r104.f125202j;
        if (r106 == null) goto L19;
        r106.setVisibility(8);
    L19:
        RelativeLayout r107 = r104.f125203k;
        if (r107 == null) goto L22;
        r107.setVisibility(8);
    L22:
        k r108 = this.f125223a;
        com.bytedance.android.livesdk.floatview.mob.b r109 = r108.f125215w;
        if (r109 == null) goto L26;
        boolean r110 = r108.f125210r;
        Room r111 = r108.f125209q;
        int r112 = com.bytedance.android.livesdk.floatview.mob.b.f125241o;
        r109.j(r110, r111, null);
        return;
    }

    public n(k r100) {
        this.f125223a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onError(String r100) {
        k.i(this.f125223a);
    }

    @Override // com.bytedance.android.livesdkapi.view.ILivePlayerView.PlayerCallback
    public final void onVideoSizeChanged(int r100, int r101) {
        k r102 = this.f125223a;
        Room r103 = r102.f125209q;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.getStreamType() == LiveMode.AUDIO) goto L13;
        float r104 = r101 / r100;
        if (r100 <= r101) goto L9;
        float r105 = UIUtils.dip2Px(r102.getContext(), 178.0f);
    L10:
        int r106 = (int) r105;
        int r107 = (int) (r106 * r104);
        FrameLayout r108 = r102.f125194b;
        if (r108 == null) goto L14;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        r109.width = r106;
        r109.height = r107;
        Unit r110 = Unit.INSTANCE;
        r108.setLayoutParams(r109);
    L14:
        com.bytedance.android.livesdk.floatview.e r111 = r102.f125214v;
        if (r111 == null) goto L19;
        r111.a(r106, r107);
        return;
    L19:
        return;
    L9:
        r105 = UIUtils.dip2Px(r102.getContext(), 100.0f);
        goto L10
    L13:
        r106 = 0;
        r107 = 0;
        goto L14
    }
}
