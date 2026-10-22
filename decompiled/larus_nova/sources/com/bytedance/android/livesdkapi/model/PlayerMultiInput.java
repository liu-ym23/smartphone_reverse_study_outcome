package com.bytedance.android.livesdkapi.model;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMultiInput;", "", SVGRenderEngine.RECT, "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "visible", "", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;Z)V", "getRect", "()Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "getVisible", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMultiInput {
    private final RenderAreaInfo rect;
    private final boolean visible;

    public static /* synthetic */ PlayerMultiInput copy$default(PlayerMultiInput r100, RenderAreaInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.rect;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.visible;
    L9:
        return r100.copy(r101, r102);
    }

    public final RenderAreaInfo component1() {
        return this.rect;
    }

    public final boolean component2() {
        return this.visible;
    }

    public final PlayerMultiInput copy(RenderAreaInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        return new PlayerMultiInput(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMultiInput) == false) goto L10;
        PlayerMultiInput r101 = (PlayerMultiInput) r100;
        if (Intrinsics.areEqual(this.rect, r101.rect) == true) goto L8;
        return false;
    L8:
        if (this.visible == r101.visible) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        RenderAreaInfo r100 = this.rect;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.visible;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "PlayerMultiInput(rect=" + this.rect + ", visible=" + this.visible + ")";
    }

    public final RenderAreaInfo getRect() {
        return this.rect;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public PlayerMultiInput(RenderAreaInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        this.rect = r100;
        this.visible = r101;
    }
}
