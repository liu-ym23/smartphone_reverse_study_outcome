package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
public final class BasicTextFieldKt$DefaultTextFieldDecorator$1 implements TextFieldDecorator {
    public static final BasicTextFieldKt$DefaultTextFieldDecorator$1 INSTANCE = null;

    static {
        INSTANCE = new BasicTextFieldKt$DefaultTextFieldDecorator$1();
    }

    public BasicTextFieldKt$DefaultTextFieldDecorator$1() {
    }

    private static final Unit Decoration$lambda$0(BasicTextFieldKt$DefaultTextFieldDecorator$1 r100, Function2 r101, int r102, Composer r103, int r104) {
        r100.Decoration(r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(BasicTextFieldKt$DefaultTextFieldDecorator$1 r100, Function2 r101, int r102, Composer r103, int r104) {
        return Decoration$lambda$0(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldDecorator
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(-2101003086);
        if ((r102 & 6) == 0) goto L5;
        int r104 = r102;
    L11:
        if ((r102 & 48) != 0) goto L18;
        if (r103.changed(this) == false) goto L15;
        int r105 = 32;
    L16:
        r104 = r104 | r105;
        goto L18
    L15:
        r105 = 16;
    L18:
        if ((r104 & 19) == 18) goto L20;
        boolean r106 = true;
    L22:
        if (r103.shouldExecute(r106, r104 & 1) == true) goto L24;
        r103.skipToGroupEnd();
    L30:
        ScopeUpdateScope r107 = r103.endRestartGroup();
        if (r107 == null) goto L34;
        r107.updateScope(new k0(this, r100, r102));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-2101003086, r104, -1, "androidx.compose.foundation.text.DefaultTextFieldDecorator.<no name provided>.Decoration (BasicTextField.kt:610)");
    L26:
        r100.invoke(r103, Integer.valueOf(r104 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r106 = false;
        goto L22
    L5:
        if (r103.changedInstance(r100) == false) goto L7;
        int r108 = 4;
    L8:
        r104 = r108 | r102;
        goto L11
    L7:
        r108 = 2;
        goto L8
    }
}
