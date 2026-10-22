package com.bytedance.android.gamecp.hybrid_impl.lynx.ui.gamecpWaveProgress;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/lynx/ui/gamecpWaveProgress/GradientDirection;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DIAGONAL_BOTTOM_LEFT_TO_TOP_RIGHT", "DIAGONAL_TOP_LEFT_TO_BOTTOM_RIGHT", "HORIZONTAL", "VERTICAL", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GradientDirection extends Enum<GradientDirection> {
    public static final a Companion = null;
    public static final GradientDirection DIAGONAL_BOTTOM_LEFT_TO_TOP_RIGHT = null;
    public static final GradientDirection DIAGONAL_TOP_LEFT_TO_BOTTOM_RIGHT = null;
    public static final GradientDirection HORIZONTAL = null;
    public static final GradientDirection VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GradientDirection[] f57723a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        GradientDirection r100 = new GradientDirection("DIAGONAL_BOTTOM_LEFT_TO_TOP_RIGHT", 0, 0);
        DIAGONAL_BOTTOM_LEFT_TO_TOP_RIGHT = r100;
        GradientDirection r101 = new GradientDirection("DIAGONAL_TOP_LEFT_TO_BOTTOM_RIGHT", 1, 1);
        DIAGONAL_TOP_LEFT_TO_BOTTOM_RIGHT = r101;
        GradientDirection r102 = new GradientDirection("HORIZONTAL", 2, 2);
        HORIZONTAL = r102;
        GradientDirection r103 = new GradientDirection("VERTICAL", 3, 3);
        VERTICAL = r103;
        f57723a = new GradientDirection[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static GradientDirection valueOf(String r100) {
        return (GradientDirection) r27.a.a(GradientDirection.class, r100);
    }

    public static GradientDirection[] values() {
        return (GradientDirection[]) f57723a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GradientDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
