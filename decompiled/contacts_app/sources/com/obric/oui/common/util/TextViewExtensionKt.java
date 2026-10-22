package com.obric.oui.common.util;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TextViewExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¨\u0006\r"}, d2 = {"makeLink", "", "Landroid/widget/TextView;", "linkText", "", "linkTextPadding", "", "spanColor", "", "clickActionOnLinkText", "Lkotlin/Function1;", "Landroid/view/View;", "clickActionOnOtherText", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TextViewExtensionKt {
    public static /* synthetic */ void makeLink$default(TextView r6, String r7, float r8, int r9, Function1 r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = OUnitExtensionKt.vdpFloat(r6, 4);
    L5:
        float r2 = r8;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        makeLink(r6, r7, r2, r9, r10, r11);
    }

    public static final void makeLink(final TextView r8, String r9, float r10, final int r11, final Function1<? super View, Unit> r12, final Function1<? super View, Unit> r13) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "linkText");
        Intrinsics.checkNotNullParameter(r12, "clickActionOnLinkText");
        CharSequence r0 = r8.getText();
        SpannableString r7 = new SpannableString(r0);
        Intrinsics.checkNotNullExpressionValue(r0, "originText");
        int r1 = StringsKt.indexOf$default(r0, r9, 0, false, 6, null);
        if (r1 >= 0) goto L6;
        OUILoggerKt.raiseIllegalArgumentException("TextView.makeLink: Link text is not found in TextView.text");
        return;
    L6:
        int r14 = r9.length() + r1;
        r7.setSpan(new AnonymousClass1(r12, r11), r1, r14, 33);
        r7.setSpan(new PaddingSpan(OUnitExtensionKt.vdpFloat(r8, r10), r11), r1, r14, 33);
        if (r13 == null) goto L13;
        if (r1 <= 0) goto L11;
        r7.setSpan(new AnonymousClass2(r13, r8), 0, r1, 33);
    L11:
        if (r14 >= r0.length()) goto L13;
        r7.setSpan(new AnonymousClass3(r13, r8), r14, r0.length() - 1, 33);
    L13:
        r8.setMovementMethod(LinkMovementMethod.getInstance());
        r8.setHighlightColor(0);
        r8.setText(r7);
    }
}
