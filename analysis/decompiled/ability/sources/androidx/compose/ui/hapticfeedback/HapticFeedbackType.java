package androidx.compose.ui.hapticfeedback;

import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HapticFeedbackType {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", AppAgent.CONSTRUCT, "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getConfirm-5zf0vsI, reason: not valid java name */
        public final int m4911getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4924getConfirm5zf0vsI();
        }

        /* renamed from: getContextClick-5zf0vsI, reason: not valid java name */
        public final int m4912getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4925getContextClick5zf0vsI();
        }

        /* renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
        public final int m4913getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4926getGestureEnd5zf0vsI();
        }

        /* renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
        public final int m4914getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4927getGestureThresholdActivate5zf0vsI();
        }

        /* renamed from: getKeyboardTap-5zf0vsI, reason: not valid java name */
        public final int m4915getKeyboardTap5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4928getKeyboardTap5zf0vsI();
        }

        /* renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m4916getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4929getLongPress5zf0vsI();
        }

        /* renamed from: getReject-5zf0vsI, reason: not valid java name */
        public final int m4917getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4930getReject5zf0vsI();
        }

        /* renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
        public final int m4918getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4931getSegmentFrequentTick5zf0vsI();
        }

        /* renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
        public final int m4919getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4932getSegmentTick5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m4920getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4933getTextHandleMove5zf0vsI();
        }

        /* renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
        public final int m4921getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4934getToggleOff5zf0vsI();
        }

        /* renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
        public final int m4922getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4935getToggleOn5zf0vsI();
        }

        /* renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
        public final int m4923getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m4936getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return o.N(HapticFeedbackType.m4904boximpl(m4911getConfirm5zf0vsI()), HapticFeedbackType.m4904boximpl(m4912getContextClick5zf0vsI()), HapticFeedbackType.m4904boximpl(m4913getGestureEnd5zf0vsI()), HapticFeedbackType.m4904boximpl(m4914getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m4904boximpl(m4915getKeyboardTap5zf0vsI()), HapticFeedbackType.m4904boximpl(m4916getLongPress5zf0vsI()), HapticFeedbackType.m4904boximpl(m4917getReject5zf0vsI()), HapticFeedbackType.m4904boximpl(m4918getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m4904boximpl(m4919getSegmentTick5zf0vsI()), HapticFeedbackType.m4904boximpl(m4920getTextHandleMove5zf0vsI()), HapticFeedbackType.m4904boximpl(m4921getToggleOff5zf0vsI()), HapticFeedbackType.m4904boximpl(m4922getToggleOn5zf0vsI()), HapticFeedbackType.m4904boximpl(m4923getVirtualKey5zf0vsI()));
        }

        private Companion() {
        }
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m4904boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4905constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4906equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4907equalsimpl0(int i, int i6) {
        return i == i6;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4908hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4909toStringimpl(int i) {
        Companion companion = INSTANCE;
        return m4907equalsimpl0(i, companion.m4911getConfirm5zf0vsI()) ? "Confirm" : m4907equalsimpl0(i, companion.m4912getContextClick5zf0vsI()) ? "ContextClick" : m4907equalsimpl0(i, companion.m4913getGestureEnd5zf0vsI()) ? "GestureEnd" : m4907equalsimpl0(i, companion.m4914getGestureThresholdActivate5zf0vsI()) ? "GestureThresholdActivate" : m4907equalsimpl0(i, companion.m4915getKeyboardTap5zf0vsI()) ? "KeyboardTap" : m4907equalsimpl0(i, companion.m4916getLongPress5zf0vsI()) ? "LongPress" : m4907equalsimpl0(i, companion.m4917getReject5zf0vsI()) ? "Reject" : m4907equalsimpl0(i, companion.m4918getSegmentFrequentTick5zf0vsI()) ? "SegmentFrequentTick" : m4907equalsimpl0(i, companion.m4919getSegmentTick5zf0vsI()) ? "SegmentTick" : m4907equalsimpl0(i, companion.m4920getTextHandleMove5zf0vsI()) ? "TextHandleMove" : m4907equalsimpl0(i, companion.m4921getToggleOff5zf0vsI()) ? "ToggleOff" : m4907equalsimpl0(i, companion.m4922getToggleOn5zf0vsI()) ? "ToggleOn" : m4907equalsimpl0(i, companion.m4923getVirtualKey5zf0vsI()) ? "VirtualKey" : "Invalid";
    }

    public boolean equals(Object other) {
        return m4906equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4908hashCodeimpl(this.value);
    }

    public String toString() {
        return m4909toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }
}
