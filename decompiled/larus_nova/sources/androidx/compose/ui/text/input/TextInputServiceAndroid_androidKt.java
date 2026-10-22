package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "update", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", ForwardDependency$ForwardLocation.FLAG, "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static /* synthetic */ void a(Runnable r100, long r101) {
        asExecutor$lambda$2$lambda$1(r100, r101);
    }

    public static /* synthetic */ void b(Choreographer r100, Runnable r101) {
        asExecutor$lambda$2(r100, r101);
    }

    private static final boolean hasFlag(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ void access$updateWithEmojiCompat(EditorInfo r100) {
        updateWithEmojiCompat(r100);
    }

    public static final Executor asExecutor(final Choreographer r100) {
        return new f(r100);
    }

    private static final void updateWithEmojiCompat(EditorInfo r100) {
        if (EmojiCompat.isConfigured() == true) goto L5;
        return;
    L5:
        EmojiCompat.get().updateEditorInfo(r100);
    }

    private static final void asExecutor$lambda$2(Choreographer r100, final Runnable r101) {
        r100.postFrameCallback(new e(r101));
    }

    private static final void asExecutor$lambda$2$lambda$1(Runnable r100, long r101) {
        r100.run();
    }

    public static final void update(EditorInfo r100, ImeOptions r101, TextFieldValue r102) {
        int r103 = r101.m7196getImeActioneUduSuo();
        ImeAction.Companion r104 = ImeAction.Companion;
        int r105 = 6;
        if (ImeAction.m7167equalsimpl0(r103, r104.m7180getDefaulteUduSuo()) == false) goto L9;
        if (r101.getSingleLine() == true) goto L28;
        r105 = 0;
    L28:
        r100.imeOptions = r105;
        PlatformImeOptions r106 = r101.getPlatformImeOptions();
        if (r106 == null) goto L33;
        String r107 = r106.getPrivateImeOptions();
        if (r107 == null) goto L33;
        r100.privateImeOptions = r107;
    L33:
        int r108 = r101.m7197getKeyboardTypePjHm6EE();
        KeyboardType.Companion r109 = KeyboardType.Companion;
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7241getTextPjHm6EE()) == false) goto L37;
        r100.inputType = 1;
    L61:
        if (r101.getSingleLine() == true) goto L68;
        if (hasFlag(r100.inputType, 1) == false) goto L68;
        r100.inputType |= 131072;
        if (ImeAction.m7167equalsimpl0(r101.m7196getImeActioneUduSuo(), r104.m7180getDefaulteUduSuo()) == false) goto L68;
        r100.imeOptions |= 1073741824;
    L68:
        if (hasFlag(r100.inputType, 1) == false) goto L81;
        int r110 = r101.m7195getCapitalizationIUNYP9k();
        KeyboardCapitalization.Companion r111 = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.m7203equalsimpl0(r110, r111.m7212getCharactersIUNYP9k()) == false) goto L73;
        r100.inputType |= 4096;
    L79:
        if (r101.getAutoCorrect() == false) goto L81;
        r100.inputType |= 32768;
        goto L81
    L73:
        if (KeyboardCapitalization.m7203equalsimpl0(r110, r111.m7216getWordsIUNYP9k()) == false) goto L76;
        r100.inputType |= 8192;
        goto L79
    L76:
        if (KeyboardCapitalization.m7203equalsimpl0(r110, r111.m7214getSentencesIUNYP9k()) == false) goto L79;
        r100.inputType |= 16384;
    L81:
        r100.initialSelStart = TextRange.m6998getStartimpl(r102.m7249getSelectiond9O1mEE());
        r100.initialSelEnd = TextRange.m6993getEndimpl(r102.m7249getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(r100, r102.getText());
        r100.imeOptions |= 33554432;
        return;
    L37:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7234getAsciiPjHm6EE()) == false) goto L40;
        r100.inputType = 1;
        r100.imeOptions |= Integer.MIN_VALUE;
        goto L61
    L40:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7237getNumberPjHm6EE()) == false) goto L43;
        r100.inputType = 2;
        goto L61
    L43:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7240getPhonePjHm6EE()) == false) goto L46;
        r100.inputType = 3;
        goto L61
    L46:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7243getUriPjHm6EE()) == false) goto L49;
        r100.inputType = 17;
        goto L61
    L49:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7236getEmailPjHm6EE()) == false) goto L52;
        r100.inputType = 33;
        goto L61
    L52:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7239getPasswordPjHm6EE()) == false) goto L55;
        r100.inputType = 129;
        goto L61
    L55:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7238getNumberPasswordPjHm6EE()) == false) goto L58;
        r100.inputType = 18;
        goto L61
    L58:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7235getDecimalPjHm6EE()) == false) goto L84;
        r100.inputType = 8194;
        goto L61
    L84:
        throw new IllegalStateException("Invalid Keyboard Type".toString());
    L9:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7184getNoneeUduSuo()) == false) goto L12;
        r105 = 1;
        goto L28
    L12:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7182getGoeUduSuo()) == false) goto L15;
        r105 = 2;
        goto L28
    L15:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7183getNexteUduSuo()) == false) goto L18;
        r105 = 5;
        goto L28
    L18:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7185getPreviouseUduSuo()) == false) goto L21;
        r105 = 7;
        goto L28
    L21:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7186getSearcheUduSuo()) == false) goto L24;
        r105 = 3;
        goto L28
    L24:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7187getSendeUduSuo()) == false) goto L27;
        r105 = 4;
        goto L28
    L27:
        if (ImeAction.m7167equalsimpl0(r103, r104.m7181getDoneeUduSuo()) == true) goto L28;
        throw new IllegalStateException("invalid ImeAction".toString());
    }
}
