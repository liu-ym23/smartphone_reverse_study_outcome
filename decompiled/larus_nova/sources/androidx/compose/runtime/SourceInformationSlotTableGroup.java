package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010*H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(¨\u0006+"}, d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "parent", "", "sourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", "identityPath", "Landroidx/compose/runtime/SourceInformationGroupPath;", "<init>", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;Landroidx/compose/runtime/SourceInformationGroupPath;)V", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getParent", "()I", "getSourceInformation", "()Landroidx/compose/runtime/GroupSourceInformation;", "getIdentityPath", "()Landroidx/compose/runtime/SourceInformationGroupPath;", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "getData", "()Ljava/lang/Iterable;", "compositionGroups", "getCompositionGroups", DownloadHelper.IDENTITY, "getIdentity", "isEmpty", "", "()Z", "iterator", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final Iterable<CompositionGroup> compositionGroups;
    private final SourceInformationGroupPath identityPath;
    private final Object key;
    private final int parent;
    private final GroupSourceInformation sourceInformation;
    private final SlotTable table;

    @Override // androidx.compose.runtime.tooling.CompositionData
    public final /* synthetic */ CompositionGroup find(Object r100) {
        return CompositionData.CC.$default$find(this, r100);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final /* synthetic */ int getGroupSize() {
        return CompositionGroup.CC.$default$getGroupSize(this);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final /* synthetic */ int getSlotsSize() {
        return CompositionGroup.CC.$default$getSlotsSize(this);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Iterable<Object> getData() {
        return new SourceInformationGroupDataIterator(this.table, this.parent, this.sourceInformation);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        return this.identityPath.getIdentity(this.table);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        return this.sourceInformation.getSourceInformation();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        ArrayList<Object> r100 = this.sourceInformation.getGroups();
        boolean r101 = false;
        if (r100 == null) goto L8;
        if (r100.isEmpty() == true) goto L8;
        r101 = true;
    L8:
        return !r101;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new SourceInformationGroupIterator(this.table, this.parent, this.sourceInformation, this.identityPath);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this.compositionGroups;
    }

    public final SourceInformationGroupPath getIdentityPath() {
        return this.identityPath;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        return this.key;
    }

    public final int getParent() {
        return this.parent;
    }

    public final GroupSourceInformation getSourceInformation() {
        return this.sourceInformation;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public SourceInformationSlotTableGroup(SlotTable r100, int r101, GroupSourceInformation r102, SourceInformationGroupPath r103) {
        this.table = r100;
        this.parent = r101;
        this.sourceInformation = r102;
        this.identityPath = r103;
        this.key = Integer.valueOf(r102.getKey());
        this.compositionGroups = this;
    }
}
