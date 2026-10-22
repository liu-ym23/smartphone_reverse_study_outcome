package androidx.compose.ui.contentcapture;

import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureEvent;", "", "id", "", "timestamp", "", "type", "Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "structureCompat", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "<init>", "(IJLandroidx/compose/ui/contentcapture/ContentCaptureEventType;Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;)V", "getId", "()I", "getTimestamp", "()J", "getType", "()Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "getStructureCompat", "()Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ContentCaptureEvent {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15175id;
    private final ViewStructureCompat structureCompat;
    private final long timestamp;
    private final ContentCaptureEventType type;

    public static /* synthetic */ ContentCaptureEvent copy$default(ContentCaptureEvent r100, int r101, long r102, ContentCaptureEventType r103, ViewStructureCompat r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f15175id;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.timestamp;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        ContentCaptureEventType r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.structureCompat;
    L14:
        int r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final int component1() {
        return this.f15175id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final ContentCaptureEventType component3() {
        return this.type;
    }

    public final ViewStructureCompat component4() {
        return this.structureCompat;
    }

    public final ContentCaptureEvent copy(int r100, long r101, ContentCaptureEventType r110, ViewStructureCompat r111) {
        return new ContentCaptureEvent(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContentCaptureEvent) == true) goto L8;
        return false;
    L8:
        ContentCaptureEvent r101 = (ContentCaptureEvent) r100;
        if (this.f15175id == r101.f15175id) goto L12;
        return false;
    L12:
        if (this.timestamp == r101.timestamp) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.structureCompat, r101.structureCompat) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.f15175id * 31;
        long r101 = this.timestamp;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.type.hashCode()) * 31;
        ViewStructureCompat r103 = this.structureCompat;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "ContentCaptureEvent(id=" + this.f15175id + ", timestamp=" + this.timestamp + ", type=" + this.type + ", structureCompat=" + this.structureCompat + ')';
    }

    public final int getId() {
        return this.f15175id;
    }

    public final ViewStructureCompat getStructureCompat() {
        return this.structureCompat;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ContentCaptureEventType getType() {
        return this.type;
    }

    public ContentCaptureEvent(int r100, long r101, ContentCaptureEventType r102, ViewStructureCompat r103) {
        this.f15175id = r100;
        this.timestamp = r101;
        this.type = r102;
        this.structureCompat = r103;
    }
}
