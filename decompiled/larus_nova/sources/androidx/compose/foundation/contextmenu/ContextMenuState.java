package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState;", "", "initialStatus", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "<init>", "(Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;)V", "<set-?>", "status", "getStatus", "()Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "setStatus", "status$delegate", "Landroidx/compose/runtime/MutableState;", "toString", "", "hashCode", "", "equals", "", "other", "Status", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuState {
    public static final int $stable = 0;
    private final MutableState status$delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "", "<init>", "()V", "Open", "Closed", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Status {
        public static final int $stable = 0;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "<init>", "()V", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Closed extends Status {
            public static final int $stable = 0;
            public static final Closed INSTANCE = null;

            static {
                INSTANCE = new Closed();
            }

            private Closed() {
                super(null);
            }

            public String toString() {
                return "Closed";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "offset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOffset-F1C5BW0", "()J", "J", "toString", "", "hashCode", "", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Open extends Status {
            public static final int $stable = 0;
            private final long offset;

            public /* synthetic */ Open(long r100, DefaultConstructorMarker r101) {
                this(r100);
            }

            public int hashCode() {
                return Offset.m4584hashCodeimpl(this.offset);
            }

            public String toString() {
                return "Open(offset=" + Offset.m4590toStringimpl(this.offset) + ')';
            }

            /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
            public final long m356getOffsetF1C5BW0() {
                return this.offset;
            }

            private Open(long r100) {
                super(null);
                this.offset = r100;
                if ((r100 & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
                boolean r101 = true;
            L6:
                if (r101 == true) goto L9;
                androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateException("ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.");
                return;
            L9:
                return;
            L5:
                r101 = false;
                goto L6
            }

            public boolean equals(Object r100) {
                if (r100 != this) goto L6;
                return true;
            L6:
                if ((r100 instanceof Open) == true) goto L10;
                return false;
            L10:
                return Offset.m4579equalsimpl0(this.offset, ((Open) r100).offset);
            }
        }

        private Status() {
        }

        public /* synthetic */ Status(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextMenuState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Status getStatus() {
        return (Status) this.status$delegate.getValue();
    }

    public String toString() {
        return "ContextMenuState(status=" + getStatus() + ')';
    }

    public int hashCode() {
        return getStatus().hashCode();
    }

    public ContextMenuState(Status r100) {
        this.status$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContextMenuState) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(((ContextMenuState) r100).getStatus(), getStatus());
    }

    public final void setStatus(Status r100) {
        this.status$delegate.setValue(r100);
    }

    public /* synthetic */ ContextMenuState(Status r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Status.Closed.INSTANCE;
    L5:
        this(r100);
    }
}
