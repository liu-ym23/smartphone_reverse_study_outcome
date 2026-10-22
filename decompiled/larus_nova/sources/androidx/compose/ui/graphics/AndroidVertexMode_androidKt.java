package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"toAndroidVertexMode", "Landroid/graphics/Canvas$VertexMode;", "Landroidx/compose/ui/graphics/VertexMode;", "toAndroidVertexMode-JOOmi9M", "(I)Landroid/graphics/Canvas$VertexMode;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidVertexMode_androidKt {
    /* JADX INFO: renamed from: toAndroidVertexMode-JOOmi9M, reason: not valid java name */
    public static final android.graphics.Canvas.VertexMode m4732toAndroidVertexModeJOOmi9M(int r100) {
        VertexMode.Companion r101 = VertexMode.Companion;
        if (VertexMode.m5249equalsimpl0(r100, r101.m5255getTrianglesc2xauaI()) == false) goto L6;
        return android.graphics.Canvas.VertexMode.TRIANGLES;
    L6:
        if (VertexMode.m5249equalsimpl0(r100, r101.m5254getTriangleStripc2xauaI()) == false) goto L9;
        return android.graphics.Canvas.VertexMode.TRIANGLE_STRIP;
    L9:
        if (VertexMode.m5249equalsimpl0(r100, r101.m5253getTriangleFanc2xauaI()) == false) goto L12;
        return android.graphics.Canvas.VertexMode.TRIANGLE_FAN;
    L12:
        return android.graphics.Canvas.VertexMode.TRIANGLES;
    }
}
