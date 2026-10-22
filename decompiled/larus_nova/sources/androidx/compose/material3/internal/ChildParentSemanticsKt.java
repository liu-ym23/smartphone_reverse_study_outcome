package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0000\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0000¨\u0006\b"}, d2 = {"childSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "parentSemantics", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChildParentSemanticsKt {
    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r100) {
        return childSemantics$lambda$0(r100);
    }

    private static final Unit childSemantics$lambda$0(SemanticsPropertyReceiver r100) {
        return Unit.INSTANCE;
    }

    public static final Modifier childSemantics(Modifier r100, Function1<? super SemanticsPropertyReceiver, Unit> r101) {
        return r100.then(new ChildSemanticsNodeElement(r101));
    }

    public static final Modifier parentSemantics(Modifier r100, Function1<? super SemanticsPropertyReceiver, Unit> r101) {
        return r100.then(new ParentSemanticsNodeElement(r101));
    }

    public static /* synthetic */ Modifier childSemantics$default(Modifier r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = new q0();
    L6:
        return childSemantics(r100, r101);
    }
}
