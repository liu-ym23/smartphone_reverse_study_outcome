package androidx.compose.foundation.text.input;

import S7.n;
import S7.p;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a.\u0010\u0013\u001a\u00020\u0005*\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a.\u0010\u0015\u001a\u00020\u0005*\u00020\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0014\u001aF\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162$\u0010\u001a\u001a \u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0019H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "", "index", "", "text", "LC7/r;", "insert", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;ILjava/lang/String;)V", "start", "end", "delete", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;II)V", "placeCursorAtEnd", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "selectAll", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "Lkotlin/Function2;", "Landroidx/compose/ui/text/TextRange;", "block", "forEachChange", "(Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;LS7/n;)V", "forEachChangeReversed", "", "a", "b", "Lkotlin/Function4;", "onFound", "findCommonPrefixAndSuffix", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;LS7/p;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldBufferKt {
    public static final void delete(TextFieldBuffer textFieldBuffer, int i, int i6) {
        textFieldBuffer.replace(i, i6, "");
    }

    public static final void findCommonPrefixAndSuffix(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i6 = 0;
        if (charSequence.length() <= 0 || charSequence2.length() <= 0) {
            i = 0;
        } else {
            int i10 = 0;
            i = 0;
            boolean z10 = false;
            while (true) {
                if (i6 == 0) {
                    if (charSequence.charAt(i10) == charSequence2.charAt(i)) {
                        i10++;
                        i++;
                    } else {
                        i6 = 1;
                    }
                }
                if (!z10) {
                    if (charSequence.charAt(length - 1) == charSequence2.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z10 = true;
                    }
                }
                if (i10 >= length || i >= length2 || (i6 != 0 && z10)) {
                    break;
                }
            }
            i6 = i10;
        }
        if (i6 < length || i < length2) {
            pVar.invoke(Integer.valueOf(i6), Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(length2));
        }
    }

    @ExperimentalFoundationApi
    public static final void forEachChange(TextFieldBuffer.ChangeList changeList, n nVar) {
        for (int i = 0; i < changeList.getChangeCount(); i++) {
            nVar.invoke(TextRange.m6299boximpl(changeList.mo1140getRangejx7JFs(i)), TextRange.m6299boximpl(changeList.mo1139getOriginalRangejx7JFs(i)));
        }
    }

    @ExperimentalFoundationApi
    public static final void forEachChangeReversed(TextFieldBuffer.ChangeList changeList, n nVar) {
        for (int changeCount = changeList.getChangeCount() - 1; changeCount >= 0; changeCount--) {
            nVar.invoke(TextRange.m6299boximpl(changeList.mo1140getRangejx7JFs(changeCount)), TextRange.m6299boximpl(changeList.mo1139getOriginalRangejx7JFs(changeCount)));
        }
    }

    public static final void insert(TextFieldBuffer textFieldBuffer, int i, String str) {
        textFieldBuffer.replace(i, i, str);
    }

    public static final void placeCursorAtEnd(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.placeCursorBeforeCharAt(textFieldBuffer.getLength());
    }

    public static final void selectAll(TextFieldBuffer textFieldBuffer) {
        textFieldBuffer.m1137setSelection5zctL8(TextRangeKt.TextRange(0, textFieldBuffer.getLength()));
    }
}
