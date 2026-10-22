package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/view/inputmethod/EditorInfo;", "LC7/r;", "updateWithEmojiCompat", "(Landroid/view/inputmethod/EditorInfo;)V", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldValue", "update", "(Landroid/view/inputmethod/EditorInfo;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroid/view/Choreographer;", "Ljava/util/concurrent/Executor;", "asExecutor", "(Landroid/view/Choreographer;)Ljava/util/concurrent/Executor;", "", "bits", "flag", "", "hasFlag", "(II)Z", "", "DEBUG_CLASS", "Ljava/lang/String;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.b
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.a
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                runnable.run();
            }
        });
    }

    private static final boolean hasFlag(int i, int i6) {
        return (i & i6) == i6;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int iM6506getImeActioneUduSuo = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 6;
        if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6490getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6494getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6492getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6493getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6495getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6496getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6497getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m6477equalsimpl0(iM6506getImeActioneUduSuo, companion.m6491getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int iM6507getKeyboardTypePjHm6EE = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6551getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6544getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6547getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6550getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6553getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6546getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6549getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6548getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m6530equalsimpl0(iM6507getKeyboardTypePjHm6EE, companion2.m6545getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m6477equalsimpl0(imeOptions.getImeAction(), companion.m6490getDefaulteUduSuo())) {
                editorInfo.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM6505getCapitalizationIUNYP9k = imeOptions.getCapitalization();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
            if (KeyboardCapitalization.m6513equalsimpl0(iM6505getCapitalizationIUNYP9k, companion3.m6522getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m6513equalsimpl0(iM6505getCapitalizationIUNYP9k, companion3.m6526getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m6513equalsimpl0(iM6505getCapitalizationIUNYP9k, companion3.m6524getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m6311getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m6306getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
