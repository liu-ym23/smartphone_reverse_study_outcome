package androidx.compose.ui.draw;

import S7.k;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a!\u0010\f\u001a\u00020\u000b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "onDraw", "drawBehind", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "onBuildDrawCache", "drawWithCache", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "CacheDrawModifierNode", "(LS7/k;)Landroidx/compose/ui/draw/CacheDrawModifierNode;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawWithContent", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawModifierKt {
    public static final CacheDrawModifierNode CacheDrawModifierNode(k kVar) {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), kVar);
    }

    public static final Modifier drawBehind(Modifier modifier, k kVar) {
        return modifier.then(new DrawBehindElement(kVar));
    }

    public static final Modifier drawWithCache(Modifier modifier, k kVar) {
        return modifier.then(new DrawWithCacheElement(kVar));
    }

    public static final Modifier drawWithContent(Modifier modifier, k kVar) {
        return modifier.then(new DrawWithContentElement(kVar));
    }
}
