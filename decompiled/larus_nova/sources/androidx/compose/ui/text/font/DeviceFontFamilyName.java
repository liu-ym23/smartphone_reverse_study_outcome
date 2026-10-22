package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DeviceFontFamilyName {
    private final String name;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m7074boximpl(String r100) {
        return new DeviceFontFamilyName(r100);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7076equalsimpl(String r100, Object r101) {
        if ((r101 instanceof DeviceFontFamilyName) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((DeviceFontFamilyName) r101).m7080unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7077equalsimpl0(String r100, String r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7078hashCodeimpl(String r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7079toStringimpl(String r100) {
        return "DeviceFontFamilyName(name=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m7076equalsimpl(this.name, r100);
    }

    public int hashCode() {
        return m7078hashCodeimpl(this.name);
    }

    public String toString() {
        return m7079toStringimpl(this.name);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m7080unboximpl() {
        return this.name;
    }

    public final String getName() {
        return this.name;
    }

    private /* synthetic */ DeviceFontFamilyName(String r100) {
        this.name = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static String m7075constructorimpl(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("name may not be empty");
    L8:
        return r100;
    L5:
        r101 = false;
        goto L6
    }
}
