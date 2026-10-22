package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "hasFlag", "", "bits", "", ForwardDependency$ForwardLocation.FLAG, "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m1237updatepLxbY9I(EditorInfo r100, CharSequence r101, long r110, ImeOptions r111, String[] r112) {
        int r102 = r111.m7196getImeActioneUduSuo();
        ImeAction.Companion r103 = ImeAction.Companion;
        int r104 = 3;
        int r105 = 6;
        if (ImeAction.m7167equalsimpl0(r102, r103.m7180getDefaulteUduSuo()) == false) goto L9;
        if (r111.getSingleLine() == true) goto L28;
        r105 = 0;
    L28:
        r100.imeOptions = r105;
        PlatformImeOptions r106 = r111.getPlatformImeOptions();
        if (r106 == null) goto L34;
        String r107 = r106.getPrivateImeOptions();
        if (r107 == null) goto L34;
        r100.privateImeOptions = r107;
    L34:
        if (Build.VERSION.SDK_INT < 24) goto L36;
        LocaleListHelper.INSTANCE.setHintLocales(r100, r111.getHintLocales());
    L36:
        int r108 = r111.m7197getKeyboardTypePjHm6EE();
        KeyboardType.Companion r109 = KeyboardType.Companion;
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7241getTextPjHm6EE()) == false) goto L40;
    L38:
        r104 = 1;
    L63:
        r100.inputType = r104;
        if (r111.getSingleLine() == true) goto L71;
        if (hasFlag(r100.inputType, 1) == false) goto L71;
        r100.inputType |= 131072;
        if (ImeAction.m7167equalsimpl0(r111.m7196getImeActioneUduSuo(), r103.m7180getDefaulteUduSuo()) == false) goto L71;
        r100.imeOptions |= 1073741824;
    L71:
        if (hasFlag(r100.inputType, 1) == false) goto L84;
        int r113 = r111.m7195getCapitalizationIUNYP9k();
        KeyboardCapitalization.Companion r114 = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.m7203equalsimpl0(r113, r114.m7212getCharactersIUNYP9k()) == false) goto L76;
        r100.inputType |= 4096;
    L82:
        if (r111.getAutoCorrect() == false) goto L84;
        r100.inputType |= 32768;
        goto L84
    L76:
        if (KeyboardCapitalization.m7203equalsimpl0(r113, r114.m7216getWordsIUNYP9k()) == false) goto L79;
        r100.inputType |= 8192;
        goto L82
    L79:
        if (KeyboardCapitalization.m7203equalsimpl0(r113, r114.m7214getSentencesIUNYP9k()) == false) goto L82;
        r100.inputType |= 16384;
    L84:
        r100.initialSelStart = TextRange.m6998getStartimpl(r110);
        r100.initialSelEnd = TextRange.m6993getEndimpl(r110);
        EditorInfoCompat.setInitialSurroundingText(r100, r101);
        if (r112 == null) goto L87;
        EditorInfoCompat.setContentMimeTypes(r100, r112);
    L87:
        r100.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == true) goto L90;
    L94:
        EditorInfoCompat.setStylusHandwritingEnabled(r100, false);
        return;
    L90:
        if (KeyboardType.m7220equalsimpl0(r111.m7197getKeyboardTypePjHm6EE(), r109.m7239getPasswordPjHm6EE()) == true) goto L94;
        if (KeyboardType.m7220equalsimpl0(r111.m7197getKeyboardTypePjHm6EE(), r109.m7238getNumberPasswordPjHm6EE()) == true) goto L94;
        EditorInfoCompat.setStylusHandwritingEnabled(r100, true);
        EditorInfoApi34.INSTANCE.setHandwritingGestures(r100);
        return;
    L40:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7234getAsciiPjHm6EE()) == false) goto L43;
        r100.imeOptions |= Integer.MIN_VALUE;
        goto L38
    L43:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7237getNumberPjHm6EE()) == false) goto L46;
        r104 = 2;
        goto L63
    L46:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7240getPhonePjHm6EE()) == true) goto L63;
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7243getUriPjHm6EE()) == false) goto L52;
        r104 = 17;
        goto L63
    L52:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7236getEmailPjHm6EE()) == false) goto L55;
        r104 = 33;
        goto L63
    L55:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7239getPasswordPjHm6EE()) == false) goto L58;
        r104 = 129;
        goto L63
    L58:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7238getNumberPasswordPjHm6EE()) == false) goto L61;
        r104 = 18;
        goto L63
    L61:
        if (KeyboardType.m7220equalsimpl0(r108, r109.m7235getDecimalPjHm6EE()) == false) goto L97;
        r104 = 8194;
        goto L63
    L97:
        throw new IllegalStateException("Invalid Keyboard Type".toString());
    L9:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7184getNoneeUduSuo()) == false) goto L12;
        r105 = 1;
        goto L28
    L12:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7182getGoeUduSuo()) == false) goto L15;
        r105 = 2;
        goto L28
    L15:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7183getNexteUduSuo()) == false) goto L18;
        r105 = 5;
        goto L28
    L18:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7185getPreviouseUduSuo()) == false) goto L21;
        r105 = 7;
        goto L28
    L21:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7186getSearcheUduSuo()) == false) goto L24;
        r105 = 3;
        goto L28
    L24:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7187getSendeUduSuo()) == false) goto L27;
        r105 = 4;
        goto L28
    L27:
        if (ImeAction.m7167equalsimpl0(r102, r103.m7181getDoneeUduSuo()) == true) goto L28;
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    /* JADX INFO: renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m1238updatepLxbY9I$default(EditorInfo r100, CharSequence r101, long r102, ImeOptions r110, String[] r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        r111 = null;
    L5:
        m1237updatepLxbY9I(r100, r101, r102, r110, r111);
    }
}
