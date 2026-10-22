package androidx.compose.ui.graphics.drawscope;

import C7.c;
import S7.k;
import androidx.appfunctions.metadata.a;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a0\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\u000b\u001a<\u0010\t\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\u000e\u001a<\u0010\u000f\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u000f\u0010\u000e\u001a:\u0010\u0015\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a:\u0010\u0018\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0014\u001aB\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a:\u0010\u001d\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\u001e\u0010\u0014\u001aZ\u0010#\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\u001f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b!\u0010\"\u001a:\u0010(\u001a\u00020\u0007*\u00020\u00002\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b&\u0010'\u001a(\u0010*\u001a\u00020\u0007*\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b*\u0010+\u001a<\u0010/\u001a\u00020\u0007*\u00020\u00002\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b/\u00100\u001aH\u0010:\u001a\u00020\u0007*\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020)2\u0006\u00107\u001a\u0002062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0087\b¢\u0006\u0004\b8\u00109\u001aT\u0010:\u001a\u00020\u0007*\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020)2\u0006\u00107\u001a\u0002062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b=\u0010>¨\u0006?"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "left", "top", "right", "bottom", "Lkotlin/Function1;", "LC7/r;", "block", "inset", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFLS7/k;)V", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FLS7/k;)V", "horizontal", "vertical", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFLS7/k;)V", "translate", "degrees", "Landroidx/compose/ui/geometry/Offset;", "pivot", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLS7/k;)V", "rotate", "radians", "rotateRad-Rg1IO4c", "rotateRad", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLS7/k;)V", "scale", "scale-Rg1IO4c", "Landroidx/compose/ui/graphics/ClipOp;", "clipOp", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILS7/k;)V", "clipRect", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILS7/k;)V", "clipPath", "Landroidx/compose/ui/graphics/Canvas;", "drawIntoCanvas", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;LS7/k;)V", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "transformBlock", "drawBlock", "withTransform", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;LS7/k;LS7/k;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "canvas", "Landroidx/compose/ui/geometry/Size;", "size", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLS7/k;)V", "draw", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;LS7/k;)V", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawScopeKt {
    /* renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m4747clipPathKD09W0M(DrawScope drawScope, Path path, int i, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4630clipPathmtrdDE(path, i);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m4748clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4630clipPathmtrdDE(path, i);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m4749clipRectrOu3jXo(DrawScope drawScope, float f, float f7, float f9, float f10, int i, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4631clipRectN_I0leg(f, f7, f9, f10, i);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m4750clipRectrOu3jXo$default(DrawScope drawScope, float f, float f7, float f9, float f10, int i, k kVar, int i6, Object obj) {
        float f11 = (i6 & 1) != 0 ? 0.0f : f;
        float f12 = (i6 & 2) != 0 ? 0.0f : f7;
        if ((i6 & 4) != 0) {
            f9 = Float.intBitsToFloat((int) (drawScope.mo4707getSizeNHjbRc() >> 32));
        }
        float f13 = f9;
        if ((i6 & 8) != 0) {
            f10 = Float.intBitsToFloat((int) (drawScope.mo4707getSizeNHjbRc() & 4294967295L));
        }
        float f14 = f10;
        if ((i6 & 16) != 0) {
            i = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        }
        int i10 = i;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4631clipRectN_I0leg(f11, f12, f13, f14, i10);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    @c
    /* renamed from: draw-GRGpd60, reason: not valid java name */
    public static final /* synthetic */ void m4751drawGRGpd60(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j5, k kVar) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo4628getSizeNHjbRc = drawScope.getDrawContext().mo4628getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo4629setSizeuvyYCjk(j5);
        drawContext.setGraphicsLayer(null);
        canvas.save();
        try {
            kVar.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
        }
    }

    /* renamed from: draw-ymL40Pk, reason: not valid java name */
    public static final void m4752drawymL40Pk(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j5, GraphicsLayer graphicsLayer, k kVar) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo4628getSizeNHjbRc = drawScope.getDrawContext().mo4628getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo4629setSizeuvyYCjk(j5);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            kVar.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
        }
    }

    /* renamed from: draw-ymL40Pk$default, reason: not valid java name */
    public static /* synthetic */ void m4753drawymL40Pk$default(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j5, GraphicsLayer graphicsLayer, k kVar, int i, Object obj) {
        if ((i & 16) != 0) {
            graphicsLayer = null;
        }
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo4628getSizeNHjbRc = drawScope.getDrawContext().mo4628getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo4629setSizeuvyYCjk(j5);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            kVar.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
        }
    }

    public static final void drawIntoCanvas(DrawScope drawScope, k kVar) {
        kVar.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(DrawScope drawScope, float f, float f7, float f9, float f10, k kVar) {
        drawScope.getDrawContext().getTransform().inset(f, f7, f9, f10);
        try {
            kVar.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().inset(-f, -f7, -f9, -f10);
        }
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f7, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().inset(f, f7, f, f7);
        try {
            kVar.invoke(drawScope);
        } finally {
            float f9 = -f;
            float f10 = -f7;
            drawScope.getDrawContext().getTransform().inset(f9, f10, f9, f10);
        }
    }

    /* renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m4754rotateRg1IO4c(DrawScope drawScope, float f, long j5, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4634rotateUv8p0NA(f, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4755rotateRg1IO4c$default(DrawScope drawScope, float f, long j5, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = drawScope.mo4706getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4634rotateUv8p0NA(f, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m4756rotateRadRg1IO4c(DrawScope drawScope, float f, long j5, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4634rotateUv8p0NA(DegreesKt.degrees(f), j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4757rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j5, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = drawScope.mo4706getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4634rotateUv8p0NA(DegreesKt.degrees(f), j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m4758scaleFgt4K4Q(DrawScope drawScope, float f, float f7, long j5, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4635scale0AR0LA0(f, f7, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m4759scaleFgt4K4Q$default(DrawScope drawScope, float f, float f7, long j5, k kVar, int i, Object obj) {
        if ((i & 4) != 0) {
            j5 = drawScope.mo4706getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4635scale0AR0LA0(f, f7, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m4760scaleRg1IO4c(DrawScope drawScope, float f, long j5, k kVar) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4635scale0AR0LA0(f, f, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m4761scaleRg1IO4c$default(DrawScope drawScope, float f, long j5, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = drawScope.mo4706getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4635scale0AR0LA0(f, f, j5);
            kVar.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    public static final void translate(DrawScope drawScope, float f, float f7, k kVar) {
        drawScope.getDrawContext().getTransform().translate(f, f7);
        try {
            kVar.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-f, -f7);
        }
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f7, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f7 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().translate(f, f7);
        try {
            kVar.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-f, -f7);
        }
    }

    public static final void withTransform(DrawScope drawScope, k kVar, k kVar2) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            kVar.invoke(drawContext.getTransform());
            kVar2.invoke(drawScope);
        } finally {
            a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    public static final void inset(DrawScope drawScope, float f, k kVar) {
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        try {
            kVar.invoke(drawScope);
        } finally {
            float f7 = -f;
            drawScope.getDrawContext().getTransform().inset(f7, f7, f7, f7);
        }
    }

    public static final void inset(DrawScope drawScope, float f, float f7, k kVar) {
        drawScope.getDrawContext().getTransform().inset(f, f7, f, f7);
        try {
            kVar.invoke(drawScope);
        } finally {
            float f9 = -f;
            float f10 = -f7;
            drawScope.getDrawContext().getTransform().inset(f9, f10, f9, f10);
        }
    }
}
