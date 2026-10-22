package androidx.compose.foundation.text.input;

import S7.a;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\r*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\r*\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldState;", "TextFieldState", "(Landroidx/compose/ui/text/input/TextFieldValue;)Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "Landroidx/compose/ui/text/TextRange;", "initialSelection", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/input/TextFieldState;", "rememberTextFieldState", "text", "LC7/r;", "setTextAndPlaceCursorAtEnd", "(Landroidx/compose/foundation/text/input/TextFieldState;Ljava/lang/String;)V", "setTextAndSelectAll", "clearText", "(Landroidx/compose/foundation/text/input/TextFieldState;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldStateKt {
    public static final TextFieldState TextFieldState(TextFieldValue textFieldValue) {
        return new TextFieldState(textFieldValue.getText(), textFieldValue.getSelection(), (e) null);
    }

    public static final void clearText(TextFieldState textFieldState) {
        TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
        try {
            TextFieldBufferKt.delete(textFieldBufferStartEdit, 0, textFieldBufferStartEdit.getLength());
            TextFieldBufferKt.placeCursorAtEnd(textFieldBufferStartEdit);
            textFieldState.commitEdit(textFieldBufferStartEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }

    @Composable
    /* renamed from: rememberTextFieldState-Le-punE, reason: not valid java name */
    public static final TextFieldState m1146rememberTextFieldStateLepunE(final String str, final long j5, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            str = "";
        }
        if ((i6 & 2) != 0) {
            j5 = TextRangeKt.TextRange(str.length());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1125389485, i, -1, "androidx.compose.foundation.text.input.rememberTextFieldState (TextFieldState.kt:620)");
        }
        Object[] objArr = new Object[0];
        TextFieldState.Saver saver = TextFieldState.Saver.INSTANCE;
        boolean z10 = ((((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(j5)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: androidx.compose.foundation.text.input.TextFieldStateKt$rememberTextFieldState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final TextFieldState invoke() {
                    return new TextFieldState(str, j5, (e) null);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TextFieldState textFieldState = (TextFieldState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) saver, (String) null, (a) objRememberedValue, composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return textFieldState;
    }

    public static final void setTextAndPlaceCursorAtEnd(TextFieldState textFieldState, String str) {
        TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
        try {
            textFieldBufferStartEdit.replace(0, textFieldBufferStartEdit.getLength(), str);
            TextFieldBufferKt.placeCursorAtEnd(textFieldBufferStartEdit);
            textFieldState.commitEdit(textFieldBufferStartEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }

    public static final void setTextAndSelectAll(TextFieldState textFieldState, String str) {
        TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
        try {
            textFieldBufferStartEdit.replace(0, textFieldBufferStartEdit.getLength(), str);
            TextFieldBufferKt.selectAll(textFieldBufferStartEdit);
            textFieldState.commitEdit(textFieldBufferStartEdit);
        } finally {
            textFieldState.finishEditing();
        }
    }
}
