package com.bytedance.android.livesdk.live.extension.plugin.api.liveffect;

import com.bytedance.android.ec.core.event.a;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/liveffect/LiveWrappedFace;", "", "()V", "degree", "", "getDegree", "()I", "setDegree", "(I)V", "id", "getId", "setId", SVGRenderEngine.RECT, "", "getRect", "()[I", "setRect", "([I)V", a.KEY_SCORE, "", "getScore", "()F", "setScore", "(F)V", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWrappedFace {
    private int degree;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f147286id;
    private int[] rect;
    private float score;

    public LiveWrappedFace() {
        this.rect = new int[4];
    }

    public final int getDegree() {
        return this.degree;
    }

    public final int getId() {
        return this.f147286id;
    }

    public final int[] getRect() {
        return this.rect;
    }

    public final float getScore() {
        return this.score;
    }

    public final void setDegree(int r100) {
        this.degree = r100;
    }

    public final void setId(int r100) {
        this.f147286id = r100;
    }

    public final void setRect(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rect = r100;
    }

    public final void setScore(float r100) {
        this.score = r100;
    }
}
