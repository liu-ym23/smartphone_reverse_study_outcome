package androidx.compose.ui.input.indirect;

import androidx.compose.ui.ExperimentalIndirectTouchTypeApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@ExperimentalIndirectTouchTypeApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IndirectTouchEventType {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m4952constructorimpl(0);
    private static final int Press = m4952constructorimpl(1);
    private static final int Release = m4952constructorimpl(2);
    private static final int Move = m4952constructorimpl(3);

    @ExperimentalIndirectTouchTypeApi
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchEventType$Companion;", "", AppAgent.CONSTRUCT, "()V", "Unknown", "Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "getUnknown-LxEHWp8", "()I", "I", "Press", "getPress-LxEHWp8", "Release", "getRelease-LxEHWp8", "Move", "getMove-LxEHWp8", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getMove-LxEHWp8, reason: not valid java name */
        public final int m4958getMoveLxEHWp8() {
            return IndirectTouchEventType.Move;
        }

        /* renamed from: getPress-LxEHWp8, reason: not valid java name */
        public final int m4959getPressLxEHWp8() {
            return IndirectTouchEventType.Press;
        }

        /* renamed from: getRelease-LxEHWp8, reason: not valid java name */
        public final int m4960getReleaseLxEHWp8() {
            return IndirectTouchEventType.Release;
        }

        /* renamed from: getUnknown-LxEHWp8, reason: not valid java name */
        public final int m4961getUnknownLxEHWp8() {
            return IndirectTouchEventType.Unknown;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IndirectTouchEventType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IndirectTouchEventType m4951boximpl(int i) {
        return new IndirectTouchEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4952constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4953equalsimpl(int i, Object obj) {
        return (obj instanceof IndirectTouchEventType) && i == ((IndirectTouchEventType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4954equalsimpl0(int i, int i6) {
        return i == i6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4955hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4956toStringimpl(int i) {
        return m4954equalsimpl0(i, Press) ? "Press" : m4954equalsimpl0(i, Release) ? "Release" : m4954equalsimpl0(i, Move) ? "Move" : "Unknown";
    }

    public boolean equals(Object other) {
        return m4953equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4955hashCodeimpl(this.value);
    }

    public String toString() {
        return m4956toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
