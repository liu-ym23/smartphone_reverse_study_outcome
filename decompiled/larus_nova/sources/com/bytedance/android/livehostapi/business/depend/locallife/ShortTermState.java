package com.bytedance.android.livehostapi.business.depend.locallife;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "", "childCount", "", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "(ILandroid/graphics/Rect;)V", "getChildCount", "()I", "getRect", "()Landroid/graphics/Rect;", "isShowing", "", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTermState {
    private final int childCount;
    private final Rect rect;

    public final boolean isShowing() {
        if (this.childCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getChildCount() {
        return this.childCount;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public ShortTermState(int r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        this.childCount = r100;
        this.rect = r101;
    }
}
