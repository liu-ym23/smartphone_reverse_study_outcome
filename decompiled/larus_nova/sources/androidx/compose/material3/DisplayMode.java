package androidx.compose.material3;

import com.ss.android.lark.picker.Picker;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/DisplayMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class DisplayMode {
    public static final Companion Companion = null;
    private static final int Input = 0;
    private static final int Picker = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/DisplayMode$Companion;", "", "<init>", "()V", Picker.TAG, "Landroidx/compose/material3/DisplayMode;", "getPicker-jFl-4v0", "()I", "I", "Input", "getInput-jFl-4v0", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getInput-jFl-4v0, reason: not valid java name */
        public final int m2174getInputjFl4v0() {
            return DisplayMode.access$getInput$cp();
        }

        /* JADX INFO: renamed from: getPicker-jFl-4v0, reason: not valid java name */
        public final int m2175getPickerjFl4v0() {
            return DisplayMode.access$getPicker$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DisplayMode m2167boximpl(int r100) {
        return new DisplayMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2168constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2169equalsimpl(int r100, Object r101) {
        if ((r101 instanceof DisplayMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((DisplayMode) r101).m2173unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2170equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2171hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m2169equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m2171hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2173unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Picker = m2168constructorimpl(0);
        Input = m2168constructorimpl(1);
    }

    public String toString() {
        return m2172toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getInput$cp() {
        return Input;
    }

    public static final /* synthetic */ int access$getPicker$cp() {
        return Picker;
    }

    private /* synthetic */ DisplayMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2172toStringimpl(int r100) {
        if (m2170equalsimpl0(r100, Picker) == false) goto L6;
        return Picker.TAG;
    L6:
        if (m2170equalsimpl0(r100, Input) == false) goto L8;
        return "Input";
    L8:
        return "Unknown";
    }
}
