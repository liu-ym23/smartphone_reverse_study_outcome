package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class HapticFeedbackType {
    public static final Companion Companion = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getConfirm-5zf0vsI, reason: not valid java name */
        public final int m5613getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5626getConfirm5zf0vsI();
        }

        /* JADX INFO: renamed from: getContextClick-5zf0vsI, reason: not valid java name */
        public final int m5614getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5627getContextClick5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
        public final int m5615getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5628getGestureEnd5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
        public final int m5616getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5629getGestureThresholdActivate5zf0vsI();
        }

        /* JADX INFO: renamed from: getKeyboardTap-5zf0vsI, reason: not valid java name */
        public final int m5617getKeyboardTap5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5630getKeyboardTap5zf0vsI();
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m5618getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5631getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getReject-5zf0vsI, reason: not valid java name */
        public final int m5619getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5632getReject5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
        public final int m5620getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5633getSegmentFrequentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
        public final int m5621getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5634getSegmentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m5622getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5635getTextHandleMove5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
        public final int m5623getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5636getToggleOff5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
        public final int m5624getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5637getToggleOn5zf0vsI();
        }

        /* JADX INFO: renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
        public final int m5625getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5638getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf(new HapticFeedbackType[]{HapticFeedbackType.m5606boximpl(m5613getConfirm5zf0vsI()), HapticFeedbackType.m5606boximpl(m5614getContextClick5zf0vsI()), HapticFeedbackType.m5606boximpl(m5615getGestureEnd5zf0vsI()), HapticFeedbackType.m5606boximpl(m5616getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m5606boximpl(m5617getKeyboardTap5zf0vsI()), HapticFeedbackType.m5606boximpl(m5618getLongPress5zf0vsI()), HapticFeedbackType.m5606boximpl(m5619getReject5zf0vsI()), HapticFeedbackType.m5606boximpl(m5620getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m5606boximpl(m5621getSegmentTick5zf0vsI()), HapticFeedbackType.m5606boximpl(m5622getTextHandleMove5zf0vsI()), HapticFeedbackType.m5606boximpl(m5623getToggleOff5zf0vsI()), HapticFeedbackType.m5606boximpl(m5624getToggleOn5zf0vsI()), HapticFeedbackType.m5606boximpl(m5625getVirtualKey5zf0vsI())});
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m5606boximpl(int r100) {
        return new HapticFeedbackType(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5607constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5608equalsimpl(int r100, Object r101) {
        if ((r101 instanceof HapticFeedbackType) == true) goto L6;
        return false;
    L6:
        if (r100 == ((HapticFeedbackType) r101).m5612unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5609equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5610hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m5608equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m5610hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5612unboximpl() {
        return this.value;
    }

    public String toString() {
        return m5611toStringimpl(this.value);
    }

    private /* synthetic */ HapticFeedbackType(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5611toStringimpl(int r100) {
        Companion r101 = Companion;
        if (m5609equalsimpl0(r100, r101.m5613getConfirm5zf0vsI()) == false) goto L6;
        return "Confirm";
    L6:
        if (m5609equalsimpl0(r100, r101.m5614getContextClick5zf0vsI()) == false) goto L9;
        return "ContextClick";
    L9:
        if (m5609equalsimpl0(r100, r101.m5615getGestureEnd5zf0vsI()) == false) goto L12;
        return "GestureEnd";
    L12:
        if (m5609equalsimpl0(r100, r101.m5616getGestureThresholdActivate5zf0vsI()) == false) goto L15;
        return "GestureThresholdActivate";
    L15:
        if (m5609equalsimpl0(r100, r101.m5617getKeyboardTap5zf0vsI()) == false) goto L18;
        return "KeyboardTap";
    L18:
        if (m5609equalsimpl0(r100, r101.m5618getLongPress5zf0vsI()) == false) goto L21;
        return "LongPress";
    L21:
        if (m5609equalsimpl0(r100, r101.m5619getReject5zf0vsI()) == false) goto L24;
        return "Reject";
    L24:
        if (m5609equalsimpl0(r100, r101.m5620getSegmentFrequentTick5zf0vsI()) == false) goto L27;
        return "SegmentFrequentTick";
    L27:
        if (m5609equalsimpl0(r100, r101.m5621getSegmentTick5zf0vsI()) == false) goto L30;
        return "SegmentTick";
    L30:
        if (m5609equalsimpl0(r100, r101.m5622getTextHandleMove5zf0vsI()) == false) goto L33;
        return "TextHandleMove";
    L33:
        if (m5609equalsimpl0(r100, r101.m5623getToggleOff5zf0vsI()) == false) goto L36;
        return "ToggleOff";
    L36:
        if (m5609equalsimpl0(r100, r101.m5624getToggleOn5zf0vsI()) == false) goto L39;
        return "ToggleOn";
    L39:
        if (m5609equalsimpl0(r100, r101.m5625getVirtualKey5zf0vsI()) == false) goto L41;
        return "VirtualKey";
    L41:
        return "Invalid";
    }
}
