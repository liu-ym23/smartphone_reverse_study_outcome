package com.bytedance.android.livesdkapi.eventbus;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;", "", "()V", "backSource", "", "getBackSource", "()Ljava/lang/String;", "setBackSource", "(Ljava/lang/String;)V", ShortVideoSegments.KEY_CAMERA_ID, "", "getCameraId", "()J", "setCameraId", "(J)V", "extra", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "setExtra", "(Landroid/os/Bundle;)V", "matchId", "getMatchId", "setMatchId", "shouldPushBackStack", "", "getShouldPushBackStack", "()Z", "setShouldPushBackStack", "(Z)V", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)V", "style", "", "getStyle", "()I", "setStyle", "(I)V", "toString", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VSJumpCameraEvent {
    public static final Companion Companion = null;
    private String backSource;
    private long cameraId;
    private Bundle extra;
    private long matchId;
    private boolean shouldPushBackStack;
    private IBaseStreamUrl streamUrl;
    private int style;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent$Companion;", "", "()V", "createEvent", "Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;", "cameraInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "extra", "Landroid/os/Bundle;", "shouldPushBackStack", "", "backSource", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final VSJumpCameraEvent createEvent(IVSCameraInfo r100) {
            return createEvent$default(this, r100, null, false, null, 14, null);
        }

        public final VSJumpCameraEvent createEvent(IVSCameraInfo r100, Bundle r101) {
            return createEvent$default(this, r100, r101, false, null, 12, null);
        }

        public final VSJumpCameraEvent createEvent(IVSCameraInfo r100, Bundle r101, boolean r110) {
            return createEvent$default(this, r100, r101, r110, null, 8, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VSJumpCameraEvent createEvent(IVSCameraInfo r100, Bundle r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "cameraInfo");
            VSJumpCameraEvent r104 = new VSJumpCameraEvent();
            r104.setCameraId(r100.getCameraId());
            r104.setStreamUrl(r100.getStreamUrl());
            r104.setStyle(r100.getStyle());
            r104.setMatchId(r100.getMatchId());
            if (r101 == null) goto L5;
            r104.setExtra(r101);
        L5:
            r104.setShouldPushBackStack(r102);
            if (r103 == null) goto L8;
            r104.setBackSource(r103);
        L8:
            return r104;
        }

        public static /* synthetic */ VSJumpCameraEvent createEvent$default(Companion r100, IVSCameraInfo r101, Bundle r102, boolean r103, String r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = false;
        L9:
            if ((r105 & 8) == 0) goto L12;
            r104 = null;
        L12:
            return r100.createEvent(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VSJumpCameraEvent() {
    }

    public String toString() {
        return "VSJumpCameraEvent(cameraId=" + this.cameraId + ", streamUrl=" + this.streamUrl + ", style=" + this.style + ", matchId=" + this.matchId + ", shouldPushBackStack=" + this.shouldPushBackStack + ", backSource=" + this.backSource + ')';
    }

    public final String getBackSource() {
        return this.backSource;
    }

    public final long getCameraId() {
        return this.cameraId;
    }

    public final Bundle getExtra() {
        return this.extra;
    }

    public final long getMatchId() {
        return this.matchId;
    }

    public final boolean getShouldPushBackStack() {
        return this.shouldPushBackStack;
    }

    public final IBaseStreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setBackSource(String r100) {
        this.backSource = r100;
    }

    public final void setCameraId(long r100) {
        this.cameraId = r100;
    }

    public final void setExtra(Bundle r100) {
        this.extra = r100;
    }

    public final void setMatchId(long r100) {
        this.matchId = r100;
    }

    public final void setShouldPushBackStack(boolean r100) {
        this.shouldPushBackStack = r100;
    }

    public final void setStreamUrl(IBaseStreamUrl r100) {
        this.streamUrl = r100;
    }

    public final void setStyle(int r100) {
        this.style = r100;
    }
}
