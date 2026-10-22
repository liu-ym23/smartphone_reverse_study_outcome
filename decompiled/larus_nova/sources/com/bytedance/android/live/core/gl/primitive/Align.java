package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/Align;", "", "", "horizontalSize", "getLeftMargin", "getRightMargin", "verticalSize", "getTopMargin", "getBottomMargin", "CENTER", "CENTER_TOP", "CENTER_BOTTOM", "CENTER_LEFT", "CENTER_RIGHT", "LEFT_TOP", "LEFT_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract enum Align extends Enum<Align> {
    public static final Align CENTER = null;
    public static final Align CENTER_BOTTOM = null;
    public static final Align CENTER_LEFT = null;
    public static final Align CENTER_RIGHT = null;
    public static final Align CENTER_TOP = null;
    public static final Align LEFT_BOTTOM = null;
    public static final Align LEFT_TOP = null;
    public static final Align RIGHT_BOTTOM = null;
    public static final Align RIGHT_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Align[] f64826a = null;

    static {
        final String r100 = "CENTER";
        final int r101 = 0;
        Align r102 = new CENTER(r100, r101);
        CENTER = r102;
        final String r103 = "CENTER_TOP";
        final int r104 = 1;
        Align r105 = new CENTER_TOP(r103, r104);
        CENTER_TOP = r105;
        final String r106 = "CENTER_BOTTOM";
        final int r107 = 2;
        Align r108 = new CENTER_BOTTOM(r106, r107);
        CENTER_BOTTOM = r108;
        final String r109 = "CENTER_LEFT";
        final int r110 = 3;
        Align r111 = new CENTER_LEFT(r109, r110);
        CENTER_LEFT = r111;
        final String r112 = "CENTER_RIGHT";
        final int r113 = 4;
        Align r114 = new CENTER_RIGHT(r112, r113);
        CENTER_RIGHT = r114;
        final String r115 = "LEFT_TOP";
        final int r116 = 5;
        Align r117 = new LEFT_TOP(r115, r116);
        LEFT_TOP = r117;
        final String r118 = "LEFT_BOTTOM";
        final int r119 = 6;
        Align r120 = new LEFT_BOTTOM(r118, r119);
        LEFT_BOTTOM = r120;
        final String r121 = "RIGHT_TOP";
        final int r122 = 7;
        Align r123 = new RIGHT_TOP(r121, r122);
        RIGHT_TOP = r123;
        final String r124 = "RIGHT_BOTTOM";
        final int r125 = 8;
        Align r126 = new RIGHT_BOTTOM(r124, r125);
        RIGHT_BOTTOM = r126;
        f64826a = new Align[]{r102, r105, r108, r111, r114, r117, r120, r123, r126};
    }

    public Align() {
        throw null;
    }

    public static Align valueOf(String r100) {
        return (Align) r27.a.a(Align.class, r100);
    }

    public static Align[] values() {
        return (Align[]) f64826a.clone();
    }

    public abstract float getBottomMargin(float r100);

    public abstract float getLeftMargin(float r100);

    public abstract float getRightMargin(float r100);

    public abstract float getTopMargin(float r100);

    public Align(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
