package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001!B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "initialChanges", "<init>", "(Landroidx/compose/foundation/text/input/internal/ChangeTracker;)V", "_changes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "_changesTemp", "changeCount", "", "getChangeCount", "()I", "trackChange", "", "preStart", "preEnd", "postLength", "clearChanges", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "toString", "", "appendNewChange", "mergedOverlappingChange", "preMin", "preMax", "postDelta", "Change", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChangeTracker implements TextFieldBuffer.ChangeList {
    public static final int $stable = 8;
    private MutableVector<Change> _changes;
    private MutableVector<Change> _changesTemp;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/ChangeTracker$Change;", "", "preStart", "", "preEnd", "originalStart", "originalEnd", "<init>", "(IIII)V", "getPreStart", "()I", "setPreStart", "(I)V", "getPreEnd", "setPreEnd", "getOriginalStart", "setOriginalStart", "getOriginalEnd", "setOriginalEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Change {
        private int originalEnd;
        private int originalStart;
        private int preEnd;
        private int preStart;

        public static /* synthetic */ Change copy$default(Change r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.preStart;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.preEnd;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.originalStart;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.originalEnd;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.preStart;
        }

        public final int component2() {
            return this.preEnd;
        }

        public final int component3() {
            return this.originalStart;
        }

        public final int component4() {
            return this.originalEnd;
        }

        public final Change copy(int r100, int r101, int r102, int r103) {
            return new Change(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Change) == true) goto L8;
            return false;
        L8:
            Change r101 = (Change) r100;
            if (this.preStart == r101.preStart) goto L12;
            return false;
        L12:
            if (this.preEnd == r101.preEnd) goto L15;
            return false;
        L15:
            if (this.originalStart == r101.originalStart) goto L18;
            return false;
        L18:
            if (this.originalEnd == r101.originalEnd) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.preStart * 31) + this.preEnd) * 31) + this.originalStart) * 31) + this.originalEnd;
        }

        public String toString() {
            return "Change(preStart=" + this.preStart + ", preEnd=" + this.preEnd + ", originalStart=" + this.originalStart + ", originalEnd=" + this.originalEnd + ')';
        }

        public final int getOriginalEnd() {
            return this.originalEnd;
        }

        public final int getOriginalStart() {
            return this.originalStart;
        }

        public final int getPreEnd() {
            return this.preEnd;
        }

        public final int getPreStart() {
            return this.preStart;
        }

        public final void setOriginalEnd(int r100) {
            this.originalEnd = r100;
        }

        public final void setOriginalStart(int r100) {
            this.originalStart = r100;
        }

        public final void setPreEnd(int r100) {
            this.preEnd = r100;
        }

        public final void setPreStart(int r100) {
            this.preStart = r100;
        }

        public Change(int r100, int r101, int r102, int r103) {
            this.preStart = r100;
            this.preEnd = r101;
            this.originalStart = r102;
            this.originalEnd = r103;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChangeTracker() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void clearChanges() {
        this._changes.clear();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    public int getChangeCount() {
        return this._changes.getSize();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ChangeList(changes=[");
        MutableVector<Change> r101 = this._changes;
        Change[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Change r105 = r102[r104];
        r100.append("(" + r105.getOriginalStart() + ',' + r105.getOriginalEnd() + ")->(" + r105.getPreStart() + ',' + r105.getPreEnd() + ')');
        if (r104 >= (getChangeCount() - 1)) goto L7;
        r100.append(", ");
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        r100.append("])");
        return r100.toString();
    }

    public ChangeTracker(ChangeTracker r100) {
        int r101 = 0;
        this._changes = new MutableVector(new Change[16], 0);
        this._changesTemp = new MutableVector(new Change[16], 0);
        if (r100 == null) goto L9;
        MutableVector<Change> r102 = r100._changes;
        if (r102 == null) goto L11;
        Change[] r103 = r102.content;
        int r104 = r102.getSize();
    L7:
        if (r101 >= r104) goto L12;
        Change r105 = r103[r101];
        this._changes.add(new Change(r105.getPreStart(), r105.getPreEnd(), r105.getOriginalStart(), r105.getOriginalEnd()));
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    /* JADX INFO: renamed from: getOriginalRange--jx7JFs */
    public long mo1193getOriginalRangejx7JFs(int r100) {
        Change r101 = this._changes.content[r100];
        return TextRangeKt.TextRange(r101.getOriginalStart(), r101.getOriginalEnd());
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    /* JADX INFO: renamed from: getRange--jx7JFs */
    public long mo1194getRangejx7JFs(int r100) {
        Change r101 = this._changes.content[r100];
        return TextRangeKt.TextRange(r101.getPreStart(), r101.getPreEnd());
    }

    public /* synthetic */ ChangeTracker(ChangeTracker r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }

    public final void trackChange(int r100, int r110, int r111) {
        if (r100 != r110) goto L5;
        if (r111 != 0) goto L5;
        return;
    L5:
        int r101 = Math.min(r100, r110);
        int r102 = Math.max(r100, r110);
        int r112 = r111 - (r102 - r101);
        Change r103 = null;
        int r104 = 0;
        boolean r105 = false;
    L7:
        if (r104 >= this._changes.getSize()) goto L44;
        Change r106 = this._changes.content[r104];
        int r107 = r106.getPreStart();
        if (r101 > r107) goto L12;
        if (r107 > r102) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L40;
        int r109 = r106.getPreEnd();
        if (r101 > r109) goto L18;
        if (r109 > r102) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == true) goto L40;
        int r114 = r106.getPreStart();
        if (r101 > r106.getPreEnd()) goto L24;
        if (r114 > r101) goto L24;
        boolean r115 = true;
    L25:
        if (r115 == true) goto L40;
        int r116 = r106.getPreStart();
        if (r102 > r106.getPreEnd()) goto L30;
        if (r116 > r102) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == true) goto L40;
        if (r106.getPreStart() <= r102) goto L37;
        if (r105 == true) goto L37;
        appendNewChange(r103, r101, r102, r112);
        r105 = true;
    L37:
        if (r105 == false) goto L39;
        r106.setPreStart(r106.getPreStart() + r112);
        r106.setPreEnd(r106.getPreEnd() + r112);
    L39:
        this._changesTemp.add(r106);
    L43:
        r104 = r104 + 1;
    L30:
        r117 = false;
    L24:
        r115 = false;
    L18:
        r113 = false;
    L40:
        if (r103 != null) goto L42;
        r103 = r106;
        goto L43
    L42:
        r103.setPreEnd(r106.getPreEnd());
        r103.setOriginalEnd(r106.getOriginalEnd());
    L12:
        r108 = false;
        goto L13
    L44:
        if (r105 == true) goto L46;
        appendNewChange(r103, r101, r102, r112);
    L46:
        MutableVector<Change> r118 = this._changes;
        this._changes = this._changesTemp;
        this._changesTemp = r118;
        r118.clear();
    }

    private final void appendNewChange(Change r100, int r101, int r102, int r103) {
        int r104 = 0;
        if (this._changesTemp.getSize() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L9;
        Change r106 = this._changesTemp.last();
        r104 = r106.getPreEnd() - r106.getOriginalEnd();
    L9:
        if (r100 != null) goto L12;
        int r107 = r101 - r104;
        int r108 = (r102 - r101) + r107;
        r100 = new Change(r101, r102 + r103, r107, r108);
    L18:
        this._changesTemp.add(r100);
        return;
    L12:
        if (r100.getPreStart() <= r101) goto L15;
        r100.setPreStart(r101);
        r100.setOriginalStart(r101);
    L15:
        if (r102 <= r100.getPreEnd()) goto L17;
        int r109 = r100.getPreEnd() - r100.getOriginalEnd();
        r100.setPreEnd(r102);
        r100.setOriginalEnd(r102 - r109);
    L17:
        r100.setPreEnd(r100.getPreEnd() + r103);
        goto L18
    L5:
        r105 = false;
        goto L6
    }
}
