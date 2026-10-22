package com.bytedance.android.livesdk.chatroom.replay_api.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay_api/model/ReplayVideoPositionInfo;", "", "", "component1", "component2", "", "component3", "component4", "startPosition", "startHighlight", "standardHighlight", "highlightFirst", "copy", "", "toString", "", "hashCode", "other", "equals", "J", "getStartPosition", "()J", "getStartHighlight", "Z", "getStandardHighlight", "()Z", "getHighlightFirst", "<init>", "(JJZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoPositionInfo {
    public static final a Companion = null;
    private final boolean highlightFirst;
    private final boolean standardHighlight;
    private final long startHighlight;
    private final long startPosition;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReplayVideoPositionInfo copy$default(ReplayVideoPositionInfo r100, long r101, long r110, boolean r111, boolean r112, int r113, Object r114) {
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

    public final ReplayVideoPositionInfo copy(long r100, long r110, boolean r111, boolean r112) {
        return new ReplayVideoPositionInfo(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ReplayVideoPositionInfo) == false) goto L14;
        ReplayVideoPositionInfo r101 = (ReplayVideoPositionInfo) r100;
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
        return "ReplayVideoPositionInfo(startPosition=" + this.startPosition + ", startHighlight=" + this.startHighlight + ", standardHighlight=" + this.standardHighlight + ", highlightFirst=" + this.highlightFirst + ")";
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

    public ReplayVideoPositionInfo(long r100, long r101, boolean r102, boolean r103) {
        this.startPosition = r100;
        this.startHighlight = r101;
        this.standardHighlight = r102;
        this.highlightFirst = r103;
    }
}
