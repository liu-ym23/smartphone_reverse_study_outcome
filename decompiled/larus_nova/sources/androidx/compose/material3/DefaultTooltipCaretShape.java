package androidx.compose.material3;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/DefaultTooltipCaretShape;", "Landroidx/compose/ui/graphics/Shape;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCaretSize-MYxV2XQ", "()J", "J", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultTooltipCaretShape implements Shape {
    public static final int $stable = 0;
    private final long caretSize;

    public /* synthetic */ DefaultTooltipCaretShape(long r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    /* JADX INFO: renamed from: getCaretSize-MYxV2XQ, reason: not valid java name */
    public final long m2165getCaretSizeMYxV2XQ() {
        return this.caretSize;
    }

    private DefaultTooltipCaretShape(long r100) {
        this.caretSize = r100;
    }

    public /* synthetic */ DefaultTooltipCaretShape(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = TooltipDefaults.INSTANCE.m3025getCaretSizeMYxV2XQ();
    L5:
        this(r100, null);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo288createOutlinePq9zytI(long r100, LayoutDirection r101, Density r102) {
        Path r103 = AndroidPath_androidKt.Path();
        float r104 = r102.mo371toPx0680j_4(DpSize.m7642getWidthD9Ej5fM(this.caretSize));
        float r105 = r102.mo371toPx0680j_4(DpSize.m7640getHeightD9Ej5fM(this.caretSize));
        r103.moveTo(0.0f, 0.0f);
        float r106 = 2;
        r103.lineTo(r104 / r106, 0.0f);
        r103.lineTo(0.0f, r105);
        r103.lineTo((-r104) / r106, 0.0f);
        r103.close();
        return new Outline.Generic(r103);
    }
}
