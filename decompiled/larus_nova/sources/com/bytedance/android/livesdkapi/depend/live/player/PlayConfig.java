package com.bytedance.android.livesdkapi.depend.live.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/player/PlayConfig;", "", "forceUsePortrait", "", "scaleType", "", "(ZLjava/lang/Integer;)V", "getForceUsePortrait", "()Z", "getScaleType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/bytedance/android/livesdkapi/depend/live/player/PlayConfig;", "equals", "other", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayConfig {
    private final boolean forceUsePortrait;
    private final Integer scaleType;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PlayConfig copy$default(PlayConfig r100, boolean r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.forceUsePortrait;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.scaleType;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.forceUsePortrait;
    }

    public final Integer component2() {
        return this.scaleType;
    }

    public final PlayConfig copy(boolean r100, Integer r101) {
        return new PlayConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayConfig) == false) goto L10;
        PlayConfig r101 = (PlayConfig) r100;
        if (this.forceUsePortrait == r101.forceUsePortrait) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scaleType, r101.scaleType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.forceUsePortrait;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        Integer r103 = this.scaleType;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "PlayConfig(forceUsePortrait=" + this.forceUsePortrait + ", scaleType=" + this.scaleType + ")";
    }

    public final boolean getForceUsePortrait() {
        return this.forceUsePortrait;
    }

    public final Integer getScaleType() {
        return this.scaleType;
    }

    public PlayConfig(boolean r100, Integer r101) {
        this.forceUsePortrait = r100;
        this.scaleType = r101;
    }

    public /* synthetic */ PlayConfig(boolean r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
