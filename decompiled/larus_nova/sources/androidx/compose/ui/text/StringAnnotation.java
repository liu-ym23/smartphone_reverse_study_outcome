package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/StringAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class StringAnnotation implements AnnotatedString.Annotation {
    private final String value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StringAnnotation m6946boximpl(String r100) {
        return new StringAnnotation(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m6947constructorimpl(String r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6948equalsimpl(String r100, Object r101) {
        if ((r101 instanceof StringAnnotation) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((StringAnnotation) r101).m6952unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6949equalsimpl0(String r100, String r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6950hashCodeimpl(String r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6951toStringimpl(String r100) {
        return "StringAnnotation(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m6948equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m6950hashCodeimpl(this.value);
    }

    public String toString() {
        return m6951toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m6952unboximpl() {
        return this.value;
    }

    public final String getValue() {
        return this.value;
    }

    private /* synthetic */ StringAnnotation(String r100) {
        this.value = r100;
    }
}
