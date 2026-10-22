package androidx.compose.material3;

import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TextFieldLabelPosition;", "", "<init>", "()V", "Attached", "Above", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TextFieldLabelPosition {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/TextFieldLabelPosition$Above;", "Landroidx/compose/material3/TextFieldLabelPosition;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "equals", "", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Above extends TextFieldLabelPosition {
        public static final int $stable = 0;
        private final Alignment.Horizontal alignment;

        /* JADX WARN: Multi-variable type inference failed */
        public Above() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public int hashCode() {
            return this.alignment.hashCode();
        }

        public String toString() {
            return "Above(alignment=" + this.alignment + ')';
        }

        public final Alignment.Horizontal getAlignment() {
            return this.alignment;
        }

        public Above(Alignment.Horizontal r100) {
            super(null);
            this.alignment = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Above) == true) goto L10;
            return false;
        L10:
            return Intrinsics.areEqual(this.alignment, ((Above) r100).alignment);
        }

        public /* synthetic */ Above(Alignment.Horizontal r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = Alignment.Companion.getStart();
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/TextFieldLabelPosition$Attached;", "Landroidx/compose/material3/TextFieldLabelPosition;", "alwaysMinimize", "", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "<init>", "(ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;)V", "getAlwaysMinimize", "()Z", "getMinimizedAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getExpandedAlignment", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attached extends TextFieldLabelPosition {
        public static final int $stable = 0;
        private final boolean alwaysMinimize;
        private final Alignment.Horizontal expandedAlignment;
        private final Alignment.Horizontal minimizedAlignment;

        public Attached() {
            this(false, null, null, 7, null);
        }

        public int hashCode() {
            if (this.alwaysMinimize == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.minimizedAlignment.hashCode()) * 31) + this.expandedAlignment.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public String toString() {
            return "Attached(alwaysMinimize=" + this.alwaysMinimize + ", minimizedAlignment=" + this.minimizedAlignment + ", expandedAlignment=" + this.expandedAlignment + ')';
        }

        public final boolean getAlwaysMinimize() {
            return this.alwaysMinimize;
        }

        public final Alignment.Horizontal getExpandedAlignment() {
            return this.expandedAlignment;
        }

        public final Alignment.Horizontal getMinimizedAlignment() {
            return this.minimizedAlignment;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Attached) == true) goto L8;
            return false;
        L8:
            Attached r101 = (Attached) r100;
            if (this.alwaysMinimize == r101.alwaysMinimize) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.minimizedAlignment, r101.minimizedAlignment) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.expandedAlignment, r101.expandedAlignment) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public Attached(boolean r100, Alignment.Horizontal r101, Alignment.Horizontal r102) {
            super(null);
            this.alwaysMinimize = r100;
            this.minimizedAlignment = r101;
            this.expandedAlignment = r102;
        }

        public /* synthetic */ Attached(boolean r100, Alignment.Horizontal r101, Alignment.Horizontal r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = Alignment.Companion.getStart();
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = Alignment.Companion.getStart();
        L11:
            this(r100, r101, r102);
        }
    }

    private TextFieldLabelPosition() {
    }

    public /* synthetic */ TextFieldLabelPosition(DefaultConstructorMarker r100) {
        this();
    }
}
