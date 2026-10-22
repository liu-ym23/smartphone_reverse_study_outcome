package androidx.compose.ui.focus;

import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/Focusability;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "canFocus", "", "node", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canFocus-impl$ui_release", "(ILandroidx/compose/ui/node/CompositionLocalConsumerModifierNode;)Z", "equals", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class Focusability {
    private static final int Always = 0;
    public static final Companion Companion = null;
    private static final int Never = 0;
    private static final int SystemDefined = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/Focusability$Companion;", "", "<init>", "()V", "Always", "Landroidx/compose/ui/focus/Focusability;", "getAlways-LCbbffg", "()I", "I", "SystemDefined", "getSystemDefined-LCbbffg", "Never", "getNever-LCbbffg", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getAlways-LCbbffg, reason: not valid java name */
        public final int m4516getAlwaysLCbbffg() {
            return Focusability.access$getAlways$cp();
        }

        /* JADX INFO: renamed from: getNever-LCbbffg, reason: not valid java name */
        public final int m4517getNeverLCbbffg() {
            return Focusability.access$getNever$cp();
        }

        /* JADX INFO: renamed from: getSystemDefined-LCbbffg, reason: not valid java name */
        public final int m4518getSystemDefinedLCbbffg() {
            return Focusability.access$getSystemDefined$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Focusability m4508boximpl(int r100) {
        return new Focusability(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4510constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4511equalsimpl(int r100, Object r101) {
        if ((r101 instanceof Focusability) == true) goto L6;
        return false;
    L6:
        if (r100 == ((Focusability) r101).m4515unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4512equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4513hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m4511equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m4513hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4515unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Always = m4510constructorimpl(1);
        SystemDefined = m4510constructorimpl(0);
        Never = m4510constructorimpl(2);
    }

    public String toString() {
        return m4514toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getAlways$cp() {
        return Always;
    }

    public static final /* synthetic */ int access$getNever$cp() {
        return Never;
    }

    public static final /* synthetic */ int access$getSystemDefined$cp() {
        return SystemDefined;
    }

    private /* synthetic */ Focusability(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4514toStringimpl(int r100) {
        if (m4512equalsimpl0(r100, Always) == false) goto L6;
        return "Always";
    L6:
        if (m4512equalsimpl0(r100, SystemDefined) == false) goto L9;
        return "SystemDefined";
    L9:
        if (m4512equalsimpl0(r100, Never) == false) goto L13;
        return "Never";
    L13:
        throw new IllegalStateException("Unknown Focusability".toString());
    }

    /* JADX INFO: renamed from: canFocus-impl$ui_release, reason: not valid java name */
    public static final boolean m4509canFocusimpl$ui_release(int r100, CompositionLocalConsumerModifierNode r101) {
        if (m4512equalsimpl0(r100, Always) == false) goto L6;
        return true;
    L6:
        if (m4512equalsimpl0(r100, SystemDefined) == false) goto L9;
        return true ^ InputMode.m5642equalsimpl0(((InputModeManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(r101, CompositionLocalsKt.getLocalInputModeManager())).mo5648getInputModeaOaMEAU(), InputMode.Companion.m5647getTouchaOaMEAU());
    L9:
        if (m4512equalsimpl0(r100, Never) == false) goto L13;
        return false;
    L13:
        throw new IllegalStateException("Unknown Focusability".toString());
    }
}
