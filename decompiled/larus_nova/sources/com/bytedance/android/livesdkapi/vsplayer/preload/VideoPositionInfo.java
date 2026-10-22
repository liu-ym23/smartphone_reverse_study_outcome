package com.bytedance.android.livesdkapi.vsplayer.preload;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/preload/VideoPositionInfo;", "", "startPosition", "", "startHighlight", "standardHighlight", "", "highlightFirst", "(JJZZ)V", "getHighlightFirst", "()Z", "getStandardHighlight", "getStartHighlight", "()J", "getStartPosition", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPositionInfo {
    public static final Companion Companion = null;
    private final boolean highlightFirst;
    private final boolean standardHighlight;
    private final long startHighlight;
    private final long startPosition;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/preload/VideoPositionInfo$Companion;", "", "()V", "default", "Lcom/bytedance/android/livesdkapi/vsplayer/preload/VideoPositionInfo;", "fromBundle", "bundle", "Landroid/os/Bundle;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final VideoPositionInfo m8277default() {
            return new VideoPositionInfo(-1000, -1000, false, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VideoPositionInfo fromBundle(Bundle r110) {
            Intrinsics.checkNotNullParameter(r110, "bundle");
            return new VideoPositionInfo(r110.getLong(VSConstants.EXTRA_VS_START_PLAY_POSITION, -1) * 1000, r110.getLong(VSConstants.EXTRA_VS_START_HIGHLIGHT_POSITION, -1) * 1000, r110.getBoolean(VSConstants.EXTRA_VS_START_HIGHLIGHT_STANDARD, false), r110.getBoolean(VSConstants.EXTRA_VS_START_POSITION_FIRST, true));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ VideoPositionInfo copy$default(VideoPositionInfo r100, long r101, long r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.startPosition;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.startHighlight;
    L8:
        long r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.standardHighlight;
    L11:
        boolean r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.highlightFirst;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.startPosition;
    }

    public final long component2() {
        return this.startHighlight;
    }

    public final boolean component3() {
        return this.standardHighlight;
    }

    public final boolean component4() {
        return this.highlightFirst;
    }

    public final VideoPositionInfo copy(long r100, long r110, boolean r111, boolean r112) {
        return new VideoPositionInfo(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VideoPositionInfo) == false) goto L14;
        VideoPositionInfo r101 = (VideoPositionInfo) r100;
        if (this.startPosition == r101.startPosition) goto L8;
        return false;
    L8:
        if (this.startHighlight == r101.startHighlight) goto L10;
        return false;
    L10:
        if (this.standardHighlight == r101.standardHighlight) goto L12;
        return false;
    L12:
        if (this.highlightFirst == r101.highlightFirst) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        long r100 = this.startPosition;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.startHighlight;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.standardHighlight;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L5;
        r106 = 1;
    L5:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.highlightFirst;
        if (r108 == true) goto L10;
        r105 = r108;
    L10:
        return r107 + r105;
    }

    public String toString() {
        return "VideoPositionInfo(startPosition=" + this.startPosition + ", startHighlight=" + this.startHighlight + ", standardHighlight=" + this.standardHighlight + ", highlightFirst=" + this.highlightFirst + ")";
    }

    public final boolean getHighlightFirst() {
        return this.highlightFirst;
    }

    public final boolean getStandardHighlight() {
        return this.standardHighlight;
    }

    public final long getStartHighlight() {
        return this.startHighlight;
    }

    public final long getStartPosition() {
        return this.startPosition;
    }

    public VideoPositionInfo(long r100, long r101, boolean r102, boolean r103) {
        this.startPosition = r100;
        this.startHighlight = r101;
        this.standardHighlight = r102;
        this.highlightFirst = r103;
    }
}
