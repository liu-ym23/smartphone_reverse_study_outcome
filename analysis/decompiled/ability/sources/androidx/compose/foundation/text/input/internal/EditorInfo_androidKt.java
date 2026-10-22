package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a@\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroid/view/inputmethod/EditorInfo;", "", "text", "Landroidx/compose/ui/text/TextRange;", "selection", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "", "", "contentMimeTypes", "LC7/r;", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "update", "", "bits", "flag", "", "hasFlag", "(II)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i6) {
        return (i & i6) == i6;
    }

    /* renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m1176updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j5, ImeOptions imeOptions, String[] strArr) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 3;
        int i6 = 6;
        if (ImeAction.m6477equalsimpl0(imeAction, companion.m6490getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i6 = 0;
            }
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6494getNoneeUduSuo())) {
            i6 = 1;
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6492getGoeUduSuo())) {
            i6 = 2;
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6493getNexteUduSuo())) {
            i6 = 5;
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6495getPreviouseUduSuo())) {
            i6 = 7;
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6496getSearcheUduSuo())) {
            i6 = 3;
        } else if (ImeAction.m6477equalsimpl0(imeAction, companion.m6497getSendeUduSuo())) {
            i6 = 4;
        } else if (!ImeAction.m6477equalsimpl0(imeAction, companion.m6491getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i6;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6551getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6544getAsciiPjHm6EE())) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i = 1;
        } else if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6547getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6550getPhonePjHm6EE())) {
            if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6553getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6546getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6549getPasswordPjHm6EE())) {
                i = 129;
            } else if (KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6548getNumberPasswordPjHm6EE())) {
                i = 18;
            } else {
                if (!KeyboardType.m6530equalsimpl0(keyboardType, companion2.m6545getDecimalPjHm6EE())) {
                    throw new IllegalStateException("Invalid Keyboard Type");
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m6477equalsimpl0(imeOptions.getImeAction(), companion.m6490getDefaulteUduSuo())) {
                editorInfo.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
            if (KeyboardCapitalization.m6513equalsimpl0(capitalization, companion3.m6522getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m6513equalsimpl0(capitalization, companion3.m6526getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m6513equalsimpl0(capitalization, companion3.m6524getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m6311getStartimpl(j5);
        editorInfo.initialSelEnd = TextRange.m6306getEndimpl(j5);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported() || KeyboardType.m6530equalsimpl0(imeOptions.getKeyboardType(), companion2.m6549getPasswordPjHm6EE()) || KeyboardType.m6530equalsimpl0(imeOptions.getKeyboardType(), companion2.m6548getNumberPasswordPjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
        }
    }

    /* renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m1177updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j5, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m1176updatepLxbY9I(editorInfo, charSequence, j5, imeOptions, strArr);
    }
}
