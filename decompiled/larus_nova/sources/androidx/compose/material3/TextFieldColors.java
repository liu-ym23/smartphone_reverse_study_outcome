package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J½\u0003\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0003¢\u0006\u0004\b`\u0010aJ!\u0010b\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e0dH\u0000¢\u0006\u0002\beJ'\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bk\u0010lJ'\u0010m\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bn\u0010lJ'\u0010o\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bp\u0010lJ'\u0010q\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\br\u0010lJ'\u0010s\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bt\u0010lJ'\u0010u\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bv\u0010lJ'\u0010w\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bx\u0010lJ'\u0010y\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bz\u0010lJ'\u0010{\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b|\u0010lJ'\u0010}\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b~\u0010lJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010i\u001a\u00020hH\u0001¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b5\u00102R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00102R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b7\u00102R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b8\u00102R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b9\u00102R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b:\u00102R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b;\u00102R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b<\u00102R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b?\u00102R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b@\u00102R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bB\u00102R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bC\u00102R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bG\u00102R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bI\u00102R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bJ\u00102R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bK\u00102R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bL\u00102R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bM\u00102R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bN\u00102R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bO\u00102R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bP\u00102R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bQ\u00102R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bR\u00102R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bS\u00102R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bT\u00102R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bU\u00102R\u0013\u0010&\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bV\u00102R\u0013\u0010'\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bW\u00102R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bX\u00102R\u0013\u0010)\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bY\u00102R\u0013\u0010*\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bZ\u00102R\u0013\u0010+\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b[\u00102R\u0013\u0010,\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b\\\u00102R\u0013\u0010-\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b]\u00102R\u0013\u0010.\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b^\u00102¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "<init>", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFocusedTextColor-0d7_KjU", "()J", "J", "getUnfocusedTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getUnfocusedContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getCursorColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getFocusedIndicatorColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "leadingIconColor", "enabled", "", "isError", "focused", "leadingIconColor-XeAY9LY$material3", "(ZZZ)J", "trailingIconColor", "trailingIconColor-XeAY9LY$material3", "indicatorColor", "indicatorColor-XeAY9LY$material3", "containerColor", "containerColor-XeAY9LY$material3", "placeholderColor", "placeholderColor-XeAY9LY$material3", "labelColor", "labelColor-XeAY9LY$material3", "textColor", "textColor-XeAY9LY$material3", "supportingTextColor", "supportingTextColor-XeAY9LY$material3", "prefixColor", "prefixColor-XeAY9LY$material3", "suffixColor", "suffixColor-XeAY9LY$material3", "cursorColor-vNxB06k$material3", "(Z)J", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long r100, long r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114, TextSelectionColors r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, DefaultConstructorMarker r813) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r810, r811, r812);
    }

    public static /* synthetic */ TextSelectionColors a(TextFieldColors r100) {
        return copy_ejIjP34$lambda$10(r100);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m4834hashCodeimpl(this.focusedTextColor) * 31) + Color.m4834hashCodeimpl(this.unfocusedTextColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4834hashCodeimpl(this.errorTextColor)) * 31) + Color.m4834hashCodeimpl(this.focusedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedContainerColor)) * 31) + Color.m4834hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m4834hashCodeimpl(this.errorContainerColor)) * 31) + Color.m4834hashCodeimpl(this.cursorColor)) * 31) + Color.m4834hashCodeimpl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.m4834hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m4834hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m4834hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m4834hashCodeimpl(this.focusedLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m4834hashCodeimpl(this.focusedTrailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedTrailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m4834hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m4834hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m4834hashCodeimpl(this.errorLabelColor)) * 31) + Color.m4834hashCodeimpl(this.focusedPlaceholderColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedPlaceholderColor)) * 31) + Color.m4834hashCodeimpl(this.disabledPlaceholderColor)) * 31) + Color.m4834hashCodeimpl(this.errorPlaceholderColor)) * 31) + Color.m4834hashCodeimpl(this.focusedSupportingTextColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedSupportingTextColor)) * 31) + Color.m4834hashCodeimpl(this.disabledSupportingTextColor)) * 31) + Color.m4834hashCodeimpl(this.errorSupportingTextColor)) * 31) + Color.m4834hashCodeimpl(this.focusedPrefixColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedPrefixColor)) * 31) + Color.m4834hashCodeimpl(this.disabledPrefixColor)) * 31) + Color.m4834hashCodeimpl(this.errorPrefixColor)) * 31) + Color.m4834hashCodeimpl(this.focusedSuffixColor)) * 31) + Color.m4834hashCodeimpl(this.unfocusedSuffixColor)) * 31) + Color.m4834hashCodeimpl(this.disabledSuffixColor)) * 31) + Color.m4834hashCodeimpl(this.errorSuffixColor);
    }

    /* JADX INFO: renamed from: getCursorColor-0d7_KjU, reason: not valid java name */
    public final long m2769getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2770getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2771getDisabledIndicatorColor0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    /* JADX INFO: renamed from: getDisabledLabelColor-0d7_KjU, reason: not valid java name */
    public final long m2772getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2773getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m2774getDisabledPlaceholderColor0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    /* JADX INFO: renamed from: getDisabledPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m2775getDisabledPrefixColor0d7_KjU() {
        return this.disabledPrefixColor;
    }

    /* JADX INFO: renamed from: getDisabledSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m2776getDisabledSuffixColor0d7_KjU() {
        return this.disabledSuffixColor;
    }

    /* JADX INFO: renamed from: getDisabledSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m2777getDisabledSupportingTextColor0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m2778getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2779getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* JADX INFO: renamed from: getErrorContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2780getErrorContainerColor0d7_KjU() {
        return this.errorContainerColor;
    }

    /* JADX INFO: renamed from: getErrorCursorColor-0d7_KjU, reason: not valid java name */
    public final long m2781getErrorCursorColor0d7_KjU() {
        return this.errorCursorColor;
    }

    /* JADX INFO: renamed from: getErrorIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2782getErrorIndicatorColor0d7_KjU() {
        return this.errorIndicatorColor;
    }

    /* JADX INFO: renamed from: getErrorLabelColor-0d7_KjU, reason: not valid java name */
    public final long m2783getErrorLabelColor0d7_KjU() {
        return this.errorLabelColor;
    }

    /* JADX INFO: renamed from: getErrorLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2784getErrorLeadingIconColor0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    /* JADX INFO: renamed from: getErrorPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m2785getErrorPlaceholderColor0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    /* JADX INFO: renamed from: getErrorPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m2786getErrorPrefixColor0d7_KjU() {
        return this.errorPrefixColor;
    }

    /* JADX INFO: renamed from: getErrorSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m2787getErrorSuffixColor0d7_KjU() {
        return this.errorSuffixColor;
    }

    /* JADX INFO: renamed from: getErrorSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m2788getErrorSupportingTextColor0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    /* JADX INFO: renamed from: getErrorTextColor-0d7_KjU, reason: not valid java name */
    public final long m2789getErrorTextColor0d7_KjU() {
        return this.errorTextColor;
    }

    /* JADX INFO: renamed from: getErrorTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2790getErrorTrailingIconColor0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    /* JADX INFO: renamed from: getFocusedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2791getFocusedContainerColor0d7_KjU() {
        return this.focusedContainerColor;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2792getFocusedIndicatorColor0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    /* JADX INFO: renamed from: getFocusedLabelColor-0d7_KjU, reason: not valid java name */
    public final long m2793getFocusedLabelColor0d7_KjU() {
        return this.focusedLabelColor;
    }

    /* JADX INFO: renamed from: getFocusedLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2794getFocusedLeadingIconColor0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getFocusedPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m2795getFocusedPlaceholderColor0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    /* JADX INFO: renamed from: getFocusedPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m2796getFocusedPrefixColor0d7_KjU() {
        return this.focusedPrefixColor;
    }

    /* JADX INFO: renamed from: getFocusedSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m2797getFocusedSuffixColor0d7_KjU() {
        return this.focusedSuffixColor;
    }

    /* JADX INFO: renamed from: getFocusedSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m2798getFocusedSupportingTextColor0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    /* JADX INFO: renamed from: getFocusedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2799getFocusedTextColor0d7_KjU() {
        return this.focusedTextColor;
    }

    /* JADX INFO: renamed from: getFocusedTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2800getFocusedTrailingIconColor0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* JADX INFO: renamed from: getUnfocusedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2801getUnfocusedContainerColor0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2802getUnfocusedIndicatorColor0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    /* JADX INFO: renamed from: getUnfocusedLabelColor-0d7_KjU, reason: not valid java name */
    public final long m2803getUnfocusedLabelColor0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    /* JADX INFO: renamed from: getUnfocusedLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2804getUnfocusedLeadingIconColor0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getUnfocusedPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m2805getUnfocusedPlaceholderColor0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    /* JADX INFO: renamed from: getUnfocusedPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m2806getUnfocusedPrefixColor0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    /* JADX INFO: renamed from: getUnfocusedSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m2807getUnfocusedSuffixColor0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    /* JADX INFO: renamed from: getUnfocusedSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m2808getUnfocusedSupportingTextColor0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    /* JADX INFO: renamed from: getUnfocusedTextColor-0d7_KjU, reason: not valid java name */
    public final long m2809getUnfocusedTextColor0d7_KjU() {
        return this.unfocusedTextColor;
    }

    /* JADX INFO: renamed from: getUnfocusedTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m2810getUnfocusedTrailingIconColor0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    private static final TextSelectionColors copy_ejIjP34$lambda$10(TextFieldColors r100) {
        return r100.textSelectionColors;
    }

    /* JADX INFO: renamed from: cursorColor-vNxB06k$material3, reason: not valid java name */
    public final long m2768cursorColorvNxB06k$material3(boolean r100) {
        if (r100 == false) goto L5;
        return this.errorCursorColor;
    L5:
        return this.cursorColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L140:
        return false;
    L8:
        if ((r100 instanceof TextFieldColors) == false) goto L140;
        TextFieldColors r101 = (TextFieldColors) r100;
        if (Color.m4828equalsimpl0(this.focusedTextColor, r101.focusedTextColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.unfocusedTextColor, r101.unfocusedTextColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.disabledTextColor, r101.disabledTextColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.errorTextColor, r101.errorTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.focusedContainerColor, r101.focusedContainerColor) == true) goto L26;
        return false;
    L26:
        if (Color.m4828equalsimpl0(this.unfocusedContainerColor, r101.unfocusedContainerColor) == true) goto L29;
        return false;
    L29:
        if (Color.m4828equalsimpl0(this.disabledContainerColor, r101.disabledContainerColor) == true) goto L32;
        return false;
    L32:
        if (Color.m4828equalsimpl0(this.errorContainerColor, r101.errorContainerColor) == true) goto L35;
        return false;
    L35:
        if (Color.m4828equalsimpl0(this.cursorColor, r101.cursorColor) == true) goto L38;
        return false;
    L38:
        if (Color.m4828equalsimpl0(this.errorCursorColor, r101.errorCursorColor) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.textSelectionColors, r101.textSelectionColors) == true) goto L44;
        return false;
    L44:
        if (Color.m4828equalsimpl0(this.focusedIndicatorColor, r101.focusedIndicatorColor) == true) goto L47;
        return false;
    L47:
        if (Color.m4828equalsimpl0(this.unfocusedIndicatorColor, r101.unfocusedIndicatorColor) == true) goto L50;
        return false;
    L50:
        if (Color.m4828equalsimpl0(this.disabledIndicatorColor, r101.disabledIndicatorColor) == true) goto L53;
        return false;
    L53:
        if (Color.m4828equalsimpl0(this.errorIndicatorColor, r101.errorIndicatorColor) == true) goto L56;
        return false;
    L56:
        if (Color.m4828equalsimpl0(this.focusedLeadingIconColor, r101.focusedLeadingIconColor) == true) goto L59;
        return false;
    L59:
        if (Color.m4828equalsimpl0(this.unfocusedLeadingIconColor, r101.unfocusedLeadingIconColor) == true) goto L62;
        return false;
    L62:
        if (Color.m4828equalsimpl0(this.disabledLeadingIconColor, r101.disabledLeadingIconColor) == true) goto L65;
        return false;
    L65:
        if (Color.m4828equalsimpl0(this.errorLeadingIconColor, r101.errorLeadingIconColor) == true) goto L68;
        return false;
    L68:
        if (Color.m4828equalsimpl0(this.focusedTrailingIconColor, r101.focusedTrailingIconColor) == true) goto L71;
        return false;
    L71:
        if (Color.m4828equalsimpl0(this.unfocusedTrailingIconColor, r101.unfocusedTrailingIconColor) == true) goto L74;
        return false;
    L74:
        if (Color.m4828equalsimpl0(this.disabledTrailingIconColor, r101.disabledTrailingIconColor) == true) goto L77;
        return false;
    L77:
        if (Color.m4828equalsimpl0(this.errorTrailingIconColor, r101.errorTrailingIconColor) == true) goto L80;
        return false;
    L80:
        if (Color.m4828equalsimpl0(this.focusedLabelColor, r101.focusedLabelColor) == true) goto L83;
        return false;
    L83:
        if (Color.m4828equalsimpl0(this.unfocusedLabelColor, r101.unfocusedLabelColor) == true) goto L86;
        return false;
    L86:
        if (Color.m4828equalsimpl0(this.disabledLabelColor, r101.disabledLabelColor) == true) goto L89;
        return false;
    L89:
        if (Color.m4828equalsimpl0(this.errorLabelColor, r101.errorLabelColor) == true) goto L92;
        return false;
    L92:
        if (Color.m4828equalsimpl0(this.focusedPlaceholderColor, r101.focusedPlaceholderColor) == true) goto L95;
        return false;
    L95:
        if (Color.m4828equalsimpl0(this.unfocusedPlaceholderColor, r101.unfocusedPlaceholderColor) == true) goto L98;
        return false;
    L98:
        if (Color.m4828equalsimpl0(this.disabledPlaceholderColor, r101.disabledPlaceholderColor) == true) goto L101;
        return false;
    L101:
        if (Color.m4828equalsimpl0(this.errorPlaceholderColor, r101.errorPlaceholderColor) == true) goto L104;
        return false;
    L104:
        if (Color.m4828equalsimpl0(this.focusedSupportingTextColor, r101.focusedSupportingTextColor) == true) goto L107;
        return false;
    L107:
        if (Color.m4828equalsimpl0(this.unfocusedSupportingTextColor, r101.unfocusedSupportingTextColor) == true) goto L110;
        return false;
    L110:
        if (Color.m4828equalsimpl0(this.disabledSupportingTextColor, r101.disabledSupportingTextColor) == true) goto L113;
        return false;
    L113:
        if (Color.m4828equalsimpl0(this.errorSupportingTextColor, r101.errorSupportingTextColor) == true) goto L116;
        return false;
    L116:
        if (Color.m4828equalsimpl0(this.focusedPrefixColor, r101.focusedPrefixColor) == true) goto L119;
        return false;
    L119:
        if (Color.m4828equalsimpl0(this.unfocusedPrefixColor, r101.unfocusedPrefixColor) == true) goto L122;
        return false;
    L122:
        if (Color.m4828equalsimpl0(this.disabledPrefixColor, r101.disabledPrefixColor) == true) goto L125;
        return false;
    L125:
        if (Color.m4828equalsimpl0(this.errorPrefixColor, r101.errorPrefixColor) == true) goto L128;
        return false;
    L128:
        if (Color.m4828equalsimpl0(this.focusedSuffixColor, r101.focusedSuffixColor) == true) goto L131;
        return false;
    L131:
        if (Color.m4828equalsimpl0(this.unfocusedSuffixColor, r101.unfocusedSuffixColor) == true) goto L134;
        return false;
    L134:
        if (Color.m4828equalsimpl0(this.disabledSuffixColor, r101.disabledSuffixColor) == true) goto L137;
        return false;
    L137:
        if (Color.m4828equalsimpl0(this.errorSuffixColor, r101.errorSuffixColor) == true) goto L139;
        return false;
    L139:
        return true;
    }

    public final TextSelectionColors takeOrElse$material3(TextSelectionColors r100, Function0<TextSelectionColors> r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return r101.invoke();
    }

    /* JADX INFO: renamed from: containerColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2766containerColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedContainerColor;
    L9:
        return this.unfocusedContainerColor;
    L11:
        return this.errorContainerColor;
    L10:
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: indicatorColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2811indicatorColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedIndicatorColor;
    L9:
        return this.unfocusedIndicatorColor;
    L11:
        return this.errorIndicatorColor;
    L10:
        return this.disabledIndicatorColor;
    }

    /* JADX INFO: renamed from: labelColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2812labelColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedLabelColor;
    L9:
        return this.unfocusedLabelColor;
    L11:
        return this.errorLabelColor;
    L10:
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: leadingIconColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2813leadingIconColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedLeadingIconColor;
    L9:
        return this.unfocusedLeadingIconColor;
    L11:
        return this.errorLeadingIconColor;
    L10:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: placeholderColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2814placeholderColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedPlaceholderColor;
    L9:
        return this.unfocusedPlaceholderColor;
    L11:
        return this.errorPlaceholderColor;
    L10:
        return this.disabledPlaceholderColor;
    }

    /* JADX INFO: renamed from: prefixColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2815prefixColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedPrefixColor;
    L9:
        return this.unfocusedPrefixColor;
    L11:
        return this.errorPrefixColor;
    L10:
        return this.disabledPrefixColor;
    }

    /* JADX INFO: renamed from: suffixColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2816suffixColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedSuffixColor;
    L9:
        return this.unfocusedSuffixColor;
    L11:
        return this.errorSuffixColor;
    L10:
        return this.disabledSuffixColor;
    }

    /* JADX INFO: renamed from: supportingTextColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2817supportingTextColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedSupportingTextColor;
    L9:
        return this.unfocusedSupportingTextColor;
    L11:
        return this.errorSupportingTextColor;
    L10:
        return this.disabledSupportingTextColor;
    }

    /* JADX INFO: renamed from: textColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2818textColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedTextColor;
    L9:
        return this.unfocusedTextColor;
    L11:
        return this.errorTextColor;
    L10:
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: trailingIconColor-XeAY9LY$material3, reason: not valid java name */
    public final long m2819trailingIconColorXeAY9LY$material3(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L10;
        if (r101 == true) goto L11;
        if (r102 == false) goto L9;
        return this.focusedTrailingIconColor;
    L9:
        return this.unfocusedTrailingIconColor;
    L11:
        return this.errorTrailingIconColor;
    L10:
        return this.disabledTrailingIconColor;
    }

    private TextFieldColors(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211, TextSelectionColors r212, long r213, long r214, long r215, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813) {
        this.focusedTextColor = r100;
        this.unfocusedTextColor = r101;
        this.disabledTextColor = r102;
        this.errorTextColor = r110;
        this.focusedContainerColor = r111;
        this.unfocusedContainerColor = r112;
        this.disabledContainerColor = r113;
        this.errorContainerColor = r114;
        this.cursorColor = r210;
        this.errorCursorColor = r211;
        this.textSelectionColors = r212;
        this.focusedIndicatorColor = r213;
        this.unfocusedIndicatorColor = r214;
        this.disabledIndicatorColor = r215;
        this.errorIndicatorColor = r310;
        this.focusedLeadingIconColor = r311;
        this.unfocusedLeadingIconColor = r312;
        this.disabledLeadingIconColor = r313;
        this.errorLeadingIconColor = r314;
        this.focusedTrailingIconColor = r410;
        this.unfocusedTrailingIconColor = r411;
        this.disabledTrailingIconColor = r412;
        this.errorTrailingIconColor = r413;
        this.focusedLabelColor = r414;
        this.unfocusedLabelColor = r510;
        this.disabledLabelColor = r511;
        this.errorLabelColor = r512;
        this.focusedPlaceholderColor = r513;
        this.unfocusedPlaceholderColor = r514;
        this.disabledPlaceholderColor = r610;
        this.errorPlaceholderColor = r611;
        this.focusedSupportingTextColor = r612;
        this.unfocusedSupportingTextColor = r613;
        this.disabledSupportingTextColor = r614;
        this.errorSupportingTextColor = r710;
        this.focusedPrefixColor = r711;
        this.unfocusedPrefixColor = r712;
        this.disabledPrefixColor = r713;
        this.errorPrefixColor = r714;
        this.focusedSuffixColor = r810;
        this.unfocusedSuffixColor = r811;
        this.disabledSuffixColor = r812;
        this.errorSuffixColor = r813;
    }

    /* JADX INFO: renamed from: copy-ejIjP34, reason: not valid java name */
    public final TextFieldColors m2767copyejIjP34(long r910, long r911, long r912, long r101, long r103, long r105, long r107, long r109, long r111, long r113, TextSelectionColors r115, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178) {
        boolean r100 = true;
        if (r910 == 16) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        long r104 = r910;
    L10:
        if (r911 == 16) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        long r110 = r911;
    L17:
        if (r912 == 16) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        long r112 = r912;
    L24:
        if (r101 == 16) goto L26;
        boolean r114 = true;
    L27:
        if (r114 == false) goto L29;
        long r117 = r101;
    L31:
        if (r103 == 16) goto L33;
        boolean r119 = true;
    L34:
        if (r119 == false) goto L36;
        long r121 = r103;
    L38:
        if (r105 == 16) goto L40;
        boolean r123 = true;
    L41:
        if (r123 == false) goto L43;
        long r125 = r105;
    L45:
        if (r107 == 16) goto L47;
        boolean r127 = true;
    L48:
        if (r127 == false) goto L50;
        long r210 = r107;
    L52:
        if (r109 == 16) goto L54;
        boolean r129 = true;
    L55:
        if (r129 == false) goto L57;
        long r211 = r109;
    L59:
        if (r111 == 16) goto L61;
        boolean r131 = true;
    L62:
        if (r131 == false) goto L64;
        long r212 = r111;
    L66:
        if (r113 == 16) goto L68;
        boolean r133 = true;
    L69:
        if (r133 == false) goto L71;
        long r213 = r113;
    L72:
        TextSelectionColors r214 = takeOrElse$material3(r115, new et(this));
        if (r116 == 16) goto L75;
        boolean r135 = true;
    L76:
        if (r135 == false) goto L78;
        long r215 = r116;
    L80:
        if (r118 == 16) goto L82;
        boolean r137 = true;
    L83:
        if (r137 == false) goto L85;
        long r310 = r118;
    L87:
        if (r120 == 16) goto L89;
        boolean r139 = true;
    L90:
        if (r139 == false) goto L92;
        long r311 = r120;
    L94:
        if (r122 == 16) goto L96;
        boolean r141 = true;
    L97:
        if (r141 == false) goto L99;
        long r312 = r122;
    L101:
        if (r124 == 16) goto L103;
        boolean r143 = true;
    L104:
        if (r143 == false) goto L106;
        long r313 = r124;
    L108:
        if (r126 == 16) goto L110;
        boolean r145 = true;
    L111:
        if (r145 == false) goto L113;
        long r314 = r126;
    L115:
        if (r128 == 16) goto L117;
        boolean r147 = true;
    L118:
        if (r147 == false) goto L120;
        long r410 = r128;
    L122:
        if (r130 == 16) goto L124;
        boolean r149 = true;
    L125:
        if (r149 == false) goto L127;
        long r411 = r130;
    L129:
        if (r132 == 16) goto L131;
        boolean r151 = true;
    L132:
        if (r151 == false) goto L134;
        long r412 = r132;
    L136:
        if (r134 == 16) goto L138;
        boolean r153 = true;
    L139:
        if (r153 == false) goto L141;
        long r413 = r134;
    L143:
        if (r136 == 16) goto L145;
        boolean r155 = true;
    L146:
        if (r155 == false) goto L148;
        long r414 = r136;
    L150:
        if (r138 == 16) goto L152;
        boolean r157 = true;
    L153:
        if (r157 == false) goto L155;
        long r510 = r138;
    L157:
        if (r140 == 16) goto L159;
        boolean r159 = true;
    L160:
        if (r159 == false) goto L162;
        long r511 = r140;
    L164:
        if (r142 == 16) goto L166;
        boolean r161 = true;
    L167:
        if (r161 == false) goto L169;
        long r512 = r142;
    L171:
        if (r144 == 16) goto L173;
        boolean r163 = true;
    L174:
        if (r163 == false) goto L176;
        long r513 = r144;
    L178:
        if (r146 == 16) goto L180;
        boolean r165 = true;
    L181:
        if (r165 == false) goto L183;
        long r514 = r146;
    L185:
        if (r148 == 16) goto L187;
        boolean r167 = true;
    L188:
        if (r167 == false) goto L190;
        long r610 = r148;
    L192:
        if (r150 == 16) goto L194;
        boolean r169 = true;
    L195:
        if (r169 == false) goto L197;
        long r611 = r150;
    L199:
        if (r152 == 16) goto L201;
        boolean r171 = true;
    L202:
        if (r171 == false) goto L204;
        long r612 = r152;
    L206:
        if (r154 == 16) goto L208;
        boolean r173 = true;
    L209:
        if (r173 == false) goto L211;
        long r613 = r154;
    L213:
        if (r156 == 16) goto L215;
        boolean r175 = true;
    L216:
        if (r175 == false) goto L218;
        long r614 = r156;
    L220:
        if (r158 == 16) goto L222;
        boolean r177 = true;
    L223:
        if (r177 == false) goto L225;
        long r710 = r158;
    L227:
        if (r160 == 16) goto L229;
        boolean r179 = true;
    L230:
        if (r179 == false) goto L232;
        long r711 = r160;
    L234:
        if (r162 == 16) goto L236;
        boolean r180 = true;
    L237:
        if (r180 == false) goto L239;
        long r712 = r162;
    L241:
        if (r164 == 16) goto L243;
        boolean r181 = true;
    L244:
        if (r181 == false) goto L246;
        long r713 = r164;
    L248:
        if (r166 == 16) goto L250;
        boolean r182 = true;
    L251:
        if (r182 == false) goto L253;
        long r714 = r166;
    L255:
        if (r168 == 16) goto L257;
        boolean r183 = true;
    L258:
        if (r183 == false) goto L260;
        long r810 = r168;
    L262:
        if (r170 == 16) goto L264;
        boolean r184 = true;
    L265:
        if (r184 == false) goto L267;
        long r811 = r170;
    L269:
        if (r172 == 16) goto L271;
        boolean r185 = true;
    L272:
        if (r185 == false) goto L274;
        long r812 = r172;
    L276:
        if (r174 == 16) goto L278;
        boolean r186 = true;
    L279:
        if (r186 == false) goto L281;
        long r813 = r174;
    L283:
        if (r176 == 16) goto L285;
        boolean r187 = true;
    L286:
        if (r187 == false) goto L288;
        long r814 = r176;
    L290:
        if (r178 != 16) goto L293;
        r100 = false;
    L293:
        if (r100 == false) goto L295;
        long r913 = r178;
    L297:
        return new TextFieldColors(r104, r110, r112, r117, r121, r125, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r810, r811, r812, r813, r814, r913, null);
    L295:
        r913 = this.errorSuffixColor;
        goto L297
    L288:
        r814 = this.disabledSuffixColor;
        goto L290
    L285:
        r187 = false;
        goto L286
    L281:
        r813 = this.unfocusedSuffixColor;
        goto L283
    L278:
        r186 = false;
        goto L279
    L274:
        r812 = this.focusedSuffixColor;
        goto L276
    L271:
        r185 = false;
        goto L272
    L267:
        r811 = this.errorPrefixColor;
        goto L269
    L264:
        r184 = false;
        goto L265
    L260:
        r810 = this.disabledPrefixColor;
        goto L262
    L257:
        r183 = false;
        goto L258
    L253:
        r714 = this.unfocusedPrefixColor;
        goto L255
    L250:
        r182 = false;
        goto L251
    L246:
        r713 = this.focusedPrefixColor;
        goto L248
    L243:
        r181 = false;
        goto L244
    L239:
        r712 = this.errorSupportingTextColor;
        goto L241
    L236:
        r180 = false;
        goto L237
    L232:
        r711 = this.disabledSupportingTextColor;
        goto L234
    L229:
        r179 = false;
        goto L230
    L225:
        r710 = this.unfocusedSupportingTextColor;
        goto L227
    L222:
        r177 = false;
        goto L223
    L218:
        r614 = this.focusedSupportingTextColor;
        goto L220
    L215:
        r175 = false;
        goto L216
    L211:
        r613 = this.errorPlaceholderColor;
        goto L213
    L208:
        r173 = false;
        goto L209
    L204:
        r612 = this.disabledPlaceholderColor;
        goto L206
    L201:
        r171 = false;
        goto L202
    L197:
        r611 = this.unfocusedPlaceholderColor;
        goto L199
    L194:
        r169 = false;
        goto L195
    L190:
        r610 = this.focusedPlaceholderColor;
        goto L192
    L187:
        r167 = false;
        goto L188
    L183:
        r514 = this.errorLabelColor;
        goto L185
    L180:
        r165 = false;
        goto L181
    L176:
        r513 = this.disabledLabelColor;
        goto L178
    L173:
        r163 = false;
        goto L174
    L169:
        r512 = this.unfocusedLabelColor;
        goto L171
    L166:
        r161 = false;
        goto L167
    L162:
        r511 = this.focusedLabelColor;
        goto L164
    L159:
        r159 = false;
        goto L160
    L155:
        r510 = this.errorTrailingIconColor;
        goto L157
    L152:
        r157 = false;
        goto L153
    L148:
        r414 = this.disabledTrailingIconColor;
        goto L150
    L145:
        r155 = false;
        goto L146
    L141:
        r413 = this.unfocusedTrailingIconColor;
        goto L143
    L138:
        r153 = false;
        goto L139
    L134:
        r412 = this.focusedTrailingIconColor;
        goto L136
    L131:
        r151 = false;
        goto L132
    L127:
        r411 = this.errorLeadingIconColor;
        goto L129
    L124:
        r149 = false;
        goto L125
    L120:
        r410 = this.disabledLeadingIconColor;
        goto L122
    L117:
        r147 = false;
        goto L118
    L113:
        r314 = this.unfocusedLeadingIconColor;
        goto L115
    L110:
        r145 = false;
        goto L111
    L106:
        r313 = this.focusedLeadingIconColor;
        goto L108
    L103:
        r143 = false;
        goto L104
    L99:
        r312 = this.errorIndicatorColor;
        goto L101
    L96:
        r141 = false;
        goto L97
    L92:
        r311 = this.disabledIndicatorColor;
        goto L94
    L89:
        r139 = false;
        goto L90
    L85:
        r310 = this.unfocusedIndicatorColor;
        goto L87
    L82:
        r137 = false;
        goto L83
    L78:
        r215 = this.focusedIndicatorColor;
        goto L80
    L75:
        r135 = false;
        goto L76
    L71:
        r213 = this.errorCursorColor;
        goto L72
    L68:
        r133 = false;
        goto L69
    L64:
        r212 = this.cursorColor;
        goto L66
    L61:
        r131 = false;
        goto L62
    L57:
        r211 = this.errorContainerColor;
        goto L59
    L54:
        r129 = false;
        goto L55
    L50:
        r210 = this.disabledContainerColor;
        goto L52
    L47:
        r127 = false;
        goto L48
    L43:
        r125 = this.unfocusedContainerColor;
        goto L45
    L40:
        r123 = false;
        goto L41
    L36:
        r121 = this.focusedContainerColor;
        goto L38
    L33:
        r119 = false;
        goto L34
    L29:
        r117 = this.errorTextColor;
        goto L31
    L26:
        r114 = false;
        goto L27
    L22:
        r112 = this.disabledTextColor;
        goto L24
    L19:
        r108 = false;
        goto L20
    L15:
        r110 = this.unfocusedTextColor;
        goto L17
    L12:
        r106 = false;
        goto L13
    L8:
        r104 = this.focusedTextColor;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-ejIjP34$default, reason: not valid java name */
    public static /* synthetic */ TextFieldColors m2765copyejIjP34$default(TextFieldColors r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, TextSelectionColors r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r100, int r102, int r103, Object r104) {
        if ((r102 & 1) == 0) goto L5;
        long r101 = r110.focusedTextColor;
    L7:
        if ((r102 & 2) == 0) goto L9;
        long r105 = r110.unfocusedTextColor;
    L11:
        if ((r102 & 4) == 0) goto L13;
        long r106 = r110.disabledTextColor;
    L15:
        if ((r102 & 8) == 0) goto L17;
        long r107 = r110.errorTextColor;
    L19:
        if ((r102 & 16) == 0) goto L21;
        long r113 = r110.focusedContainerColor;
    L23:
        if ((r102 & 32) == 0) goto L25;
        long r114 = r110.unfocusedContainerColor;
    L26:
        long r215 = r114;
        if ((r102 & 64) == 0) goto L29;
        long r115 = r110.disabledContainerColor;
    L30:
        long r216 = r115;
        if ((r102 & 128) == 0) goto L33;
        long r116 = r110.errorContainerColor;
    L34:
        long r315 = r116;
        if ((r102 & 256) == 0) goto L37;
        long r117 = r110.cursorColor;
    L38:
        long r316 = r117;
        if ((r102 & 512) == 0) goto L41;
        long r118 = r110.errorCursorColor;
    L43:
        if ((r102 & 1024) == 0) goto L45;
        TextSelectionColors r119 = r110.textSelectionColors;
    L46:
        TextSelectionColors r317 = r119;
        long r318 = r118;
        if ((r102 & 2048) == 0) goto L49;
        long r120 = r110.focusedIndicatorColor;
    L50:
        long r319 = r120;
        if ((r102 & 4096) == 0) goto L53;
        long r121 = r110.unfocusedIndicatorColor;
    L54:
        long r415 = r121;
        if ((r102 & 8192) == 0) goto L57;
        long r122 = r110.disabledIndicatorColor;
    L58:
        long r416 = r122;
        if ((r102 & 16384) == 0) goto L61;
        long r123 = r110.errorIndicatorColor;
    L62:
        long r417 = r123;
        if ((32768 & r102) == 0) goto L65;
        long r124 = r110.focusedLeadingIconColor;
    L66:
        long r418 = r124;
        if ((65536 & r102) == 0) goto L69;
        long r125 = r110.unfocusedLeadingIconColor;
    L70:
        long r419 = r125;
        if ((131072 & r102) == 0) goto L73;
        long r126 = r110.disabledLeadingIconColor;
    L74:
        long r515 = r126;
        if ((262144 & r102) == 0) goto L77;
        long r127 = r110.errorLeadingIconColor;
    L78:
        long r516 = r127;
        if ((524288 & r102) == 0) goto L81;
        long r128 = r110.focusedTrailingIconColor;
    L82:
        long r517 = r128;
        if ((1048576 & r102) == 0) goto L85;
        long r129 = r110.unfocusedTrailingIconColor;
    L86:
        long r518 = r129;
        if ((2097152 & r102) == 0) goto L89;
        long r130 = r110.disabledTrailingIconColor;
    L90:
        long r519 = r130;
        if ((4194304 & r102) == 0) goto L93;
        long r131 = r110.errorTrailingIconColor;
    L94:
        long r615 = r131;
        if ((8388608 & r102) == 0) goto L97;
        long r132 = r110.focusedLabelColor;
    L98:
        long r616 = r132;
        if ((16777216 & r102) == 0) goto L101;
        long r133 = r110.unfocusedLabelColor;
    L102:
        long r617 = r133;
        if ((33554432 & r102) == 0) goto L105;
        long r134 = r110.disabledLabelColor;
    L106:
        long r618 = r134;
        if ((67108864 & r102) == 0) goto L109;
        long r135 = r110.errorLabelColor;
    L110:
        long r619 = r135;
        if ((134217728 & r102) == 0) goto L113;
        long r136 = r110.focusedPlaceholderColor;
    L114:
        long r715 = r136;
        if ((268435456 & r102) == 0) goto L117;
        long r137 = r110.unfocusedPlaceholderColor;
    L118:
        long r716 = r137;
        if ((536870912 & r102) == 0) goto L121;
        long r138 = r110.disabledPlaceholderColor;
    L122:
        long r717 = r138;
        if ((1073741824 & r102) == 0) goto L125;
        long r139 = r110.errorPlaceholderColor;
    L126:
        long r718 = r139;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L129;
        long r140 = r110.focusedSupportingTextColor;
    L130:
        long r719 = r140;
        if ((r103 & 1) == 0) goto L133;
        long r141 = r110.unfocusedSupportingTextColor;
    L134:
        long r815 = r141;
        if ((r103 & 2) == 0) goto L137;
        long r142 = r110.disabledSupportingTextColor;
    L138:
        long r816 = r142;
        if ((r103 & 4) == 0) goto L141;
        long r143 = r110.errorSupportingTextColor;
    L142:
        long r817 = r143;
        if ((r103 & 8) == 0) goto L145;
        long r144 = r110.focusedPrefixColor;
    L146:
        long r818 = r144;
        if ((r103 & 16) == 0) goto L149;
        long r145 = r110.unfocusedPrefixColor;
    L150:
        long r819 = r145;
        if ((r103 & 32) == 0) goto L153;
        long r146 = r110.disabledPrefixColor;
    L154:
        long r915 = r146;
        if ((r103 & 64) == 0) goto L157;
        long r147 = r110.errorPrefixColor;
    L158:
        long r916 = r147;
        if ((r103 & 128) == 0) goto L161;
        long r148 = r110.focusedSuffixColor;
    L162:
        long r917 = r148;
        if ((r103 & 256) == 0) goto L165;
        long r149 = r110.unfocusedSuffixColor;
    L166:
        long r918 = r149;
        if ((r103 & 512) == 0) goto L169;
        long r150 = r110.disabledSuffixColor;
    L171:
        if ((r103 & 1024) == 0) goto L173;
        long r108 = r110.errorSuffixColor;
    L175:
        return r110.m2767copyejIjP34(r101, r105, r106, r107, r113, r215, r216, r315, r316, r318, r317, r319, r415, r416, r417, r418, r419, r515, r516, r517, r518, r519, r615, r616, r617, r618, r619, r715, r716, r717, r718, r719, r815, r816, r817, r818, r819, r915, r916, r917, r918, r150, r108);
    L173:
        r108 = r100;
        goto L175
    L169:
        r150 = r914;
        goto L171
    L165:
        r149 = r913;
        goto L166
    L161:
        r148 = r912;
        goto L162
    L157:
        r147 = r911;
        goto L158
    L153:
        r146 = r910;
        goto L154
    L149:
        r145 = r814;
        goto L150
    L145:
        r144 = r813;
        goto L146
    L141:
        r143 = r812;
        goto L142
    L137:
        r142 = r811;
        goto L138
    L133:
        r141 = r810;
        goto L134
    L129:
        r140 = r714;
        goto L130
    L125:
        r139 = r713;
        goto L126
    L121:
        r138 = r712;
        goto L122
    L117:
        r137 = r711;
        goto L118
    L113:
        r136 = r710;
        goto L114
    L109:
        r135 = r614;
        goto L110
    L105:
        r134 = r613;
        goto L106
    L101:
        r133 = r612;
        goto L102
    L97:
        r132 = r611;
        goto L98
    L93:
        r131 = r610;
        goto L94
    L89:
        r130 = r514;
        goto L90
    L85:
        r129 = r513;
        goto L86
    L81:
        r128 = r512;
        goto L82
    L77:
        r127 = r511;
        goto L78
    L73:
        r126 = r510;
        goto L74
    L69:
        r125 = r414;
        goto L70
    L65:
        r124 = r413;
        goto L66
    L61:
        r123 = r412;
        goto L62
    L57:
        r122 = r411;
        goto L58
    L53:
        r121 = r410;
        goto L54
    L49:
        r120 = r314;
        goto L50
    L45:
        r119 = r313;
        goto L46
    L41:
        r118 = r312;
        goto L43
    L37:
        r117 = r311;
        goto L38
    L33:
        r116 = r310;
        goto L34
    L29:
        r115 = r214;
        goto L30
    L25:
        r114 = r213;
        goto L26
    L21:
        r113 = r212;
        goto L23
    L17:
        r107 = r211;
        goto L19
    L13:
        r106 = r210;
        goto L15
    L9:
        r105 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
