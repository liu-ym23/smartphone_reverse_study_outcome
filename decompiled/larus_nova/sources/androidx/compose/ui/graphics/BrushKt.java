package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0017\u0010\u0003\u001a\u00020\u00012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"toShaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "ShaderBrush", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "(Landroid/graphics/Shader;)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BrushKt {
    public static final ShaderBrush ShaderBrush(final Shader r100) {
        return new AnonymousClass1(r100);
    }

    public static final ShaderBrush toShaderBrush(Brush r100) {
        if ((r100 instanceof ShaderBrush) == false) goto L6;
        return (ShaderBrush) r100;
    L6:
        if ((r100 instanceof SolidColor) == false) goto L10;
        SolidColor r101 = (SolidColor) r100;
        Brush r102 = Brush.Companion.m4783verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.m4817boximpl(r101.m5188getValue0d7_KjU()), Color.m4817boximpl(r101.m5188getValue0d7_KjU())}), 0.0f, 0.0f, 0, 14, null);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.ui.graphics.ShaderBrush");
        return (ShaderBrush) r102;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
