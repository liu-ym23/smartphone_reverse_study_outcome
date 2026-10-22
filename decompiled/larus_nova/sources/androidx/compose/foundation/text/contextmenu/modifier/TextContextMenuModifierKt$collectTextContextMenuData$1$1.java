package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class TextContextMenuModifierKt$collectTextContextMenuData$1$1 extends FunctionReferenceImpl implements Function1<Function1<? super TextContextMenuComponent, ? extends Boolean>, Unit> {
    public TextContextMenuModifierKt$collectTextContextMenuData$1$1(Object r100) {
        super(1, r100, TextContextMenuBuilderScope.class, "addFilter", "addFilter$foundation_release(Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super TextContextMenuComponent, ? extends Boolean> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<? super TextContextMenuComponent, Boolean> r100) {
        ((TextContextMenuBuilderScope) this.receiver).addFilter$foundation_release(r100);
    }
}
