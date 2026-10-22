package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.NonNullValueClassSaver;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB)\b\u0016\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "text", "", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getText", "()Ljava/lang/String;", "getSelection-d9O1mEE", "()J", "J", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", "", "other", "hashCode", "", "toString", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldValue {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<TextFieldValue, Object> Saver = null;
    private final AnnotatedString annotatedString;
    private final TextRange composition;
    private final long selection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.access$getSaver$cp();
        }
    }

    public /* synthetic */ TextFieldValue(AnnotatedString r100, long r101, TextRange r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ TextFieldValue(String r100, long r101, TextRange r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public static /* synthetic */ TextFieldValue a(Object r100) {
        return Saver$lambda$1(r100);
    }

    public static /* synthetic */ Object b(SaverScope r100, TextFieldValue r101) {
        return Saver$lambda$0(r100, r101);
    }

    static {
        Companion = new Companion(null);
        Saver = SaverKt.Saver(new b(), new c());
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int r100 = ((this.annotatedString.hashCode() * 31) + TextRange.m6999hashCodeimpl(this.selection)) * 31;
        TextRange r101 = this.composition;
        if (r101 == null) goto L5;
        int r102 = TextRange.m6999hashCodeimpl(r101.m7002unboximpl());
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "TextFieldValue(text='" + this.annotatedString + "', selection=" + TextRange.m7001toStringimpl(this.selection) + ", composition=" + this.composition + ')';
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m7248getCompositionMzsxiRA() {
        return this.composition;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m7249getSelectiond9O1mEE() {
        return this.selection;
    }

    private static final TextFieldValue Saver$lambda$1(Object r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List r101 = (List) r100;
        Object r102 = ListProtector.get(r101, 0);
        Saver<AnnotatedString, Object> r103 = SaversKt.getAnnotatedStringSaver();
        Boolean r104 = Boolean.FALSE;
        TextRange r105 = null;
        if (Intrinsics.areEqual(r102, r104) == true) goto L5;
    L7:
        if (r102 == null) goto L9;
        AnnotatedString r106 = r103.restore(r102);
    L10:
        Intrinsics.checkNotNull(r106);
        Object r107 = ListProtector.get(r101, 1);
        Saver<TextRange, Object> r108 = SaversKt.getSaver(TextRange.Companion);
        if (Intrinsics.areEqual(r107, r104) == true) goto L13;
    L15:
        if (r107 == null) goto L17;
        r105 = r108.restore(r107);
    L17:
        Intrinsics.checkNotNull(r105);
        return new TextFieldValue(r106, r105.m7002unboximpl(), null, 4, null);
    L13:
        if ((r108 instanceof NonNullValueClassSaver) == true) goto L15;
    L9:
        r106 = null;
        goto L10
    L5:
        if ((r103 instanceof NonNullValueClassSaver) == true) goto L7;
        goto L7
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextFieldValue) == true) goto L8;
        return false;
    L8:
        TextFieldValue r101 = (TextFieldValue) r100;
        if (TextRange.m6991equalsimpl0(this.selection, r101.selection) == true) goto L11;
    L15:
        return false;
    L11:
        if (Intrinsics.areEqual(this.composition, r101.composition) == false) goto L15;
        if (Intrinsics.areEqual(this.annotatedString, r101.annotatedString) == false) goto L15;
        return true;
    }

    private static final Object Saver$lambda$0(SaverScope r100, TextFieldValue r101) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(r101.annotatedString, SaversKt.getAnnotatedStringSaver(), r100), SaversKt.save(TextRange.m6986boximpl(r101.selection), SaversKt.getSaver(TextRange.Companion), r100)});
    }

    private TextFieldValue(AnnotatedString r100, long r101, TextRange r102) {
        this.annotatedString = r100;
        this.selection = TextRangeKt.m7004coerceIn8ffj60Q(r101, 0, getText().length());
        if (r102 == null) goto L5;
        TextRange r103 = TextRange.m6986boximpl(TextRangeKt.m7004coerceIn8ffj60Q(r102.m7002unboximpl(), 0, getText().length()));
    L6:
        this.composition = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m7247copy3r_uNRQ(String r100, long r101, TextRange r110) {
        return new TextFieldValue(new AnnotatedString(r100, null, 2, 0 == true ? 1 : 0), r101, r110, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldValue(String r100, long r101, TextRange r110) {
        this(new AnnotatedString(r100, null, 2, 0 == true ? 1 : 0), r101, r110, null);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m7246copy3r_uNRQ(AnnotatedString r100, long r101, TextRange r110) {
        return new TextFieldValue(r100, r101, r110, null);
    }

    public /* synthetic */ TextFieldValue(String r100, long r101, TextRange r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r102 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = TextRange.Companion.m7003getZerod9O1mEE();
    L8:
        long r103 = r101;
        if ((r111 & 4) == 0) goto L11;
        r110 = null;
    L11:
        this(r102, r103, r110, null);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString r100, long r101, TextRange r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = TextRange.Companion.m7003getZerod9O1mEE();
    L5:
        long r102 = r101;
        if ((r111 & 4) == 0) goto L8;
        r110 = null;
    L8:
        this(r100, r102, r110, null);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m7244copy3r_uNRQ$default(TextFieldValue r100, AnnotatedString r101, long r102, TextRange r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.annotatedString;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.selection;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.composition;
    L12:
        return r100.m7246copy3r_uNRQ(r101, r102, r103);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m7245copy3r_uNRQ$default(TextFieldValue r100, String r101, long r102, TextRange r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.selection;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = r100.composition;
    L9:
        return r100.m7247copy3r_uNRQ(r101, r102, r103);
    }
}
