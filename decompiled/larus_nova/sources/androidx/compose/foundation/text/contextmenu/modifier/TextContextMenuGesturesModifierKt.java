package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012 \b\u0002\u0010\u0002\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"textContextMenuGestures", "Landroidx/compose/ui/Modifier;", "onPreShowContextMenu", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuGesturesModifierKt {
    public static final Modifier textContextMenuGestures(Modifier r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101) {
        return r100.then(new TextContextMenuGestureElement(r101));
    }

    public static /* synthetic */ Modifier textContextMenuGestures$default(Modifier r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return textContextMenuGestures(r100, r101);
    }
}
