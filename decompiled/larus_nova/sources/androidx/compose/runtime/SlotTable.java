package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.spatial.RectListKt;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010(\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010;\u001a\u0002H<\"\u0004\b\u0000\u0010<2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002H<0>H\u0086\b¢\u0006\u0002\u0010CJ7\u0010D\u001a\u0002H<\"\u0004\b\u0000\u0010<2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110E¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H<0>H\u0086\b¢\u0006\u0002\u0010CJ\u0006\u0010F\u001a\u00020?J\u0006\u0010G\u001a\u00020EJ\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u000bJ\u0012\u0010J\u001a\u0004\u0018\u00010%2\u0006\u0010I\u001a\u00020\u000bH\u0002J\u000e\u0010K\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020%J\u000e\u0010L\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020%J\u0016\u0010M\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020%J=\u0010O\u001a\u00020P2\u0006\u0010B\u001a\u00020?2&\u0010+\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u0001`.H\u0000¢\u0006\u0002\bQJ\u008f\u0001\u0010O\u001a\u00020P2\u0006\u0010\u001c\u001a\u00020E2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&2&\u0010+\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u0001`.2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0000¢\u0006\u0004\bQ\u0010RJ\u0087\u0001\u0010S\u001a\u00020P2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&2&\u0010+\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u0001`.2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0000¢\u0006\u0004\bT\u0010UJ\u001d\u0010V\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010W2\u0006\u0010Y\u001a\u00020\u000bH\u0000¢\u0006\u0002\bZJ\u0006\u0010[\u001a\u00020\u001bJ\u0010\u0010\\\u001a\u0004\u0018\u00010-2\u0006\u0010]\u001a\u00020\u000bJ\u0012\u0010^\u001a\u0004\u0018\u00010X2\u0006\u0010]\u001a\u00020\u000bH\u0002J\u0006\u0010_\u001a\u00020PJ\u0006\u0010`\u001a\u00020PJ\u0006\u0010a\u001a\u00020PJ\u0006\u0010b\u001a\u00020cJ \u0010d\u001a\u00020\u000b*\u00060ej\u0002`f2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000bH\u0002J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0002J\u000e\u0010i\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0002J\u000e\u0010j\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0002J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0002J\u000e\u0010l\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0002J\u001d\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100W2\u0006\u0010]\u001a\u00020\u000bH\u0000¢\u0006\u0002\bnJ\u001f\u0010o\u001a\u0004\u0018\u00010\u00102\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000bH\u0000¢\u0006\u0002\bqJ\u000f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00030vH\u0096\u0002J\u0012\u0010w\u001a\u0004\u0018\u00010\u00032\u0006\u0010x\u001a\u00020\u0010H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00060\u0010j\u0002`\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u001b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R:\u0010+\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020-\u0018\u0001`.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001eR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006y"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "<init>", "()V", "value", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "readers", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "", "writer", "getWriter$runtime", "()Z", "version", "getVersion$runtime", "setVersion$runtime", "(I)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime", "()Ljava/util/ArrayList;", "setAnchors$runtime", "(Ljava/util/ArrayList;)V", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime", "(Ljava/util/HashMap;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", "read", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/SlotReader;", "Lkotlin/ParameterName;", "name", "reader", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "write", "Landroidx/compose/runtime/SlotWriter;", "openReader", "openWriter", "anchor", "index", "tryAnchor", "anchorIndex", "ownsAnchor", "groupContainsAnchor", "groupIndex", "close", "", "close$runtime", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", "setTo$runtime", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", PickerReporterConstants.KEY.TARGET, "invalidateGroupsWithKey$runtime", "containsMark", "sourceInformationOf", "group", "findEffectiveRecomposeScope", "verifyWellFormed", "collectCalledByInformation", "collectSourceInformation", "toDebugString", "", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "keys", "nodes", "parentIndexes", "dataIndexes", "groupSizes", "slotsOf", "slotsOf$runtime", "slot", "slotIndex", "slot$runtime", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "iterator", "", "find", "identityToFind", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    public static final int $stable = 8;
    private ArrayList<Anchor> anchors;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int[] groups;
    private int groupsSize;
    private final Object lock;
    private int readers;
    private Object[] slots;
    private int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> keys() {
        return SlotTableKt.access$keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, this.groupsSize * 5);
    }

    public final void collectCalledByInformation() {
        int r100 = 0;
        this.calledByMap = new MutableIntObjectMap(r100, 1, null);
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap();
    }

    public final boolean containsMark() {
        if (this.groupsSize > 0) goto L5;
        return false;
    L5:
        if ((this.groups[1] & 67108864) == 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        if (this.groupsSize != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer == true) goto L7;
        this.readers++;
        return new SlotReader(this);
    L7:
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if ((!this.writer) == true) goto L6;
        ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
    L6:
        if (this.readers > 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
    L11:
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    L8:
        r100 = false;
        goto L9
    }

    public final String toDebugString() {
        if (this.writer == true) goto L14;
        StringBuilder r100 = new StringBuilder();
        r100.append(toString());
        r100.append('\n');
        int r101 = this.groupsSize;
        if (r101 <= 0) goto L10;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L12;
        r102 = r102 + emitGroup(r100, r102, 0);
    L12:
        return r100.toString();
    L10:
        r100.append("<EMPTY>");
        goto L12
    L14:
        return toString();
    }

    public final void verifyWellFormed() {
        Ref.IntRef r100 = new Ref.IntRef();
        int r101 = -1;
        if (this.groupsSize <= 0) goto L12;
    L4:
        int r102 = r100.element;
        int r103 = this.groupsSize;
        if (r102 >= r103) goto L7;
        verifyWellFormed$validateGroup(r100, this, -1, r102 + SlotTableKt.access$groupSize(this.groups, r102));
        goto L4
    L7:
        if (r102 != r103) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        PreconditionsKt.throwIllegalStateException("Incomplete group at root " + r100.element + " expected to be " + this.groupsSize);
        goto L12
    L9:
        r104 = false;
    L12:
        int r105 = this.slotsSize;
        int r106 = this.slots.length;
    L13:
        if (r105 >= r106) goto L21;
        if (this.slots[r105] != null) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L20;
        PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + r105);
    L20:
        r105 = r105 + 1;
        goto L13
    L17:
        r107 = false;
        goto L18
    L21:
        ArrayList<Anchor> r108 = this.anchors;
        int r109 = r108.size();
        int r110 = 0;
    L22:
        if (r110 >= r109) goto L37;
        int r111 = ((Anchor) ListProtector.get(r108, r110)).toIndexFor(this);
        if (r111 >= 0) goto L26;
    L28:
        boolean r112 = false;
    L29:
        if (r112 == true) goto L31;
        PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
    L31:
        if (r101 >= r111) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == true) goto L36;
        PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
    L36:
        r110 = r110 + 1;
        r101 = r111;
        goto L22
    L33:
        r113 = false;
        goto L34
    L26:
        if (r111 > this.groupsSize) goto L28;
        r112 = true;
        goto L29
    L37:
        HashMap<Anchor, GroupSourceInformation> r114 = this.sourceInformationMap;
        if (r114 == null) goto L49;
        Iterator<Map.Entry<Anchor, GroupSourceInformation>> r115 = r114.entrySet().iterator();
    L41:
        if (r115.hasNext() == false) goto L60;
        Map.Entry<Anchor, GroupSourceInformation> r116 = r115.next();
        Anchor r117 = r116.getKey();
        GroupSourceInformation r118 = r116.getValue();
        if (r117.getValid() == true) goto L46;
        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
    L46:
        if (ownsAnchor(r117) == true) goto L48;
        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
    L48:
        verifyWellFormed$verifySourceGroup(this, r118);
        goto L41
    L60:
        return;
    }

    public SlotTable() {
        this.groups = new int[0];
        this.slots = new Object[0];
        this.lock = new Object();
        this.anchors = new ArrayList();
    }

    public final ArrayList<Anchor> getAnchors$runtime() {
        return this.anchors;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final HashMap<Anchor, GroupSourceInformation> getSourceInformationMap$runtime() {
        return this.sourceInformationMap;
    }

    public final int getVersion$runtime() {
        return this.version;
    }

    public final boolean getWriter$runtime() {
        return this.writer;
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int r100) {
        int r101 = r100;
    L3:
        if (r101 <= 0) goto L15;
        Iterator<Object> r102 = new DataIterator(this, r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if ((r103 instanceof RecomposeScopeImpl) == false) goto L6;
        RecomposeScopeImpl r104 = (RecomposeScopeImpl) r103;
        if (r104.getUsed() == false) goto L13;
        if (r101 == r100) goto L13;
        return r104;
    L13:
        r104.setForcedRecompose(true);
        goto L6
    L14:
        r101 = this.groups[(r101 * 5) + 2];
        goto L3
    L15:
        return null;
    }

    private final Anchor tryAnchor(int r100) {
        boolean r101 = true;
        if ((!this.writer) == true) goto L6;
        ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
    L6:
        if (r100 >= 0) goto L8;
    L10:
        r101 = false;
    L11:
        if (r101 == true) goto L15;
        return null;
    L15:
        return SlotTableKt.access$find(this.anchors, r100, this.groupsSize);
    L8:
        if (r100 >= this.groupsSize) goto L10;
        goto L10
    }

    public final Anchor anchor(int r100) {
        if ((!this.writer) == true) goto L5;
        ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
    L5:
        boolean r101 = false;
        if (r100 >= 0) goto L8;
    L10:
        if (r101 == true) goto L12;
        PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
    L12:
        ArrayList<Anchor> r102 = this.anchors;
        int r103 = SlotTableKt.access$search(r102, r100, this.groupsSize);
        if (r103 >= 0) goto L16;
        Anchor r104 = new Anchor(r100);
        ListProtector.add(r102, -(r103 + 1), r104);
        return r104;
    L16:
        return (Anchor) ListProtector.get(r102, r103);
    L8:
        if (r100 >= this.groupsSize) goto L10;
        r101 = true;
        goto L10
    }

    public final int anchorIndex(Anchor r100) {
        if ((!this.writer) == true) goto L6;
        ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
    L6:
        if (r100.getValid() == true) goto L9;
        PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
    L9:
        return r100.getLocation$runtime();
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object r100) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(r100);
    }

    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime(int r110) {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = true;
        int r111 = 0;
        MutableIntSet r103 = new MutableIntSet(r111, 1, null);
        r103.add(r110);
        r103.add(-3);
        MutableIntObjectMap<MutableIntSet> r104 = this.calledByMap;
        if (r104 == null) goto L7;
        MutableIntSet r112 = r104.get(r110);
        if (r112 == null) goto L7;
        r103.addAll(r112);
    L7:
        SlotReader r113 = openReader();
        invalidateGroupsWithKey$lambda$20$scanGroup(r113, r103, r100, r102, this, r101);     // Catch: Throwable -> L25
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r113.close();
        SlotWriter r114 = openWriter();
        r114.startGroup();     // Catch: Throwable -> L22
        int r106 = r100.size();     // Catch: Throwable -> L22
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L16;
        Anchor r108 = (Anchor) r100.get(r107);     // Catch: Throwable -> L22
        if (r108.toIndexFor(r114) < r114.getCurrentGroup()) goto L15;
        r114.seek(r108);     // Catch: Throwable -> L22
        r114.bashCurrentGroup();     // Catch: Throwable -> L22
    L15:
        r107 = r107 + 1;     // Catch: Throwable -> L22
        goto L11
    L16:
        r114.skipToGroupEnd();     // Catch: Throwable -> L22
        r114.endGroup();     // Catch: Throwable -> L22
        r114.close(true);
        if (r102.element == false) goto L21;
        return r101;
    L21:
        return null;
    L22:
        th = move-exception;
        r114.close(false);
        throw th;
    L25:
        th = move-exception;
        r113.close();
        throw th;
    }

    public final boolean ownsAnchor(Anchor r100) {
        if (r100.getValid() == false) goto L13;
        int r101 = SlotTableKt.access$search(this.anchors, r100.getLocation$runtime(), this.groupsSize);
        if (r101 >= 0) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (Intrinsics.areEqual(ListProtector.get(this.anchors, r101), r100) == false) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> r100) {
        SlotReader r101 = openReader();
        T r102 = r100.invoke(r101);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r101.close();
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r101.close();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void setAnchors$runtime(ArrayList<Anchor> r100) {
        this.anchors = r100;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> r100) {
        this.calledByMap = r100;
    }

    public final void setSourceInformationMap$runtime(HashMap<Anchor, GroupSourceInformation> r100) {
        this.sourceInformationMap = r100;
    }

    public final void setVersion$runtime(int r100) {
        this.version = r100;
    }

    public final List<Object> slotsOf$runtime(int r100) {
        int[] r101 = this.groups;
        int r102 = r101[(r100 * 5) + 4];
        int r103 = r100 + 1;
        if (r103 >= this.groupsSize) goto L5;
        int r104 = r101[(r103 * 5) + 4];
    L7:
        return ArraysKt.toList(this.slots).subList(r102, r104);
    L5:
        r104 = this.slots.length;
        goto L7
    }

    public final GroupSourceInformation sourceInformationOf(int r100) {
        HashMap<Anchor, GroupSourceInformation> r101 = this.sourceInformationMap;
        if (r101 == null) goto L8;
        Anchor r102 = tryAnchor(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r101.get(r102);
    L8:
        return null;
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> r100) {
        SlotWriter r101 = openWriter();
        T r102 = r100.invoke(r101);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r101.close(true);
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r101.close(false);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final int emitGroup$dataIndex(SlotTable r100, int r101) {
        if (r101 < r100.groupsSize) goto L6;
        return r100.slotsSize;
    L6:
        return r100.groups[(r101 * 5) + 4];
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable r100, GroupSourceInformation r101) {
        ArrayList<Object> r102 = r101.getGroups();
        if (r102 == null) goto L18;
        int r103 = r102.size();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L24;
        Object r105 = ListProtector.get(r102, r104);
        if ((r105 instanceof Anchor) == false) goto L15;
        Anchor r106 = (Anchor) r105;
        if (r106.getValid() == true) goto L12;
        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
    L12:
        if (r100.ownsAnchor(r106) == true) goto L17;
        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
    L17:
        r104 = r104 + 1;
        goto L5
    L15:
        if ((r105 instanceof GroupSourceInformation) == false) goto L17;
        verifyWellFormed$verifySourceGroup(r100, (GroupSourceInformation) r105);
        goto L17
    L24:
        return;
    }

    public final void close$runtime(SlotReader r100, HashMap<Anchor, GroupSourceInformation> r101) {
        if (r100.getTable$runtime() == this) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
    L10:
        this.readers--;
        if (r101 == null) goto L24;
        Object r103 = this.lock;
        monitor-enter(r103);
        HashMap<Anchor, GroupSourceInformation> r104 = this.sourceInformationMap;     // Catch: Throwable -> L21
        if (r104 == null) goto L17;
        r104.putAll(r101);     // Catch: Throwable -> L21
    L18:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        return;
    L17:
        this.sourceInformationMap = r101;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        return;
    L5:
        if (this.readers <= 0) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean groupContainsAnchor(int r100, Anchor r101) {
        if ((!this.writer) == true) goto L6;
        ComposerKt.composeImmediateRuntimeError("Writer is active");
    L6:
        if (r100 >= 0) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        ComposerKt.composeImmediateRuntimeError("Invalid group index");
    L14:
        if (ownsAnchor(r101) == false) goto L22;
        int r103 = SlotTableKt.access$groupSize(this.groups, r100) + r100;
        int r104 = r101.getLocation$runtime();
        if (r100 > r104) goto L19;
        if (r104 >= r103) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
        return true;
    L19:
        r105 = false;
    L22:
        return false;
    L8:
        if (r100 >= this.groupsSize) goto L10;
        r102 = true;
        goto L11
    }

    public final Object slot$runtime(int r100, int r101) {
        int r102 = SlotTableKt.access$slotAnchor(this.groups, r100);
        boolean r103 = true;
        int r104 = r100 + 1;
        if (r104 >= this.groupsSize) goto L5;
        int r105 = this.groups[(r104 * 5) + 4];
    L6:
        int r106 = r105 - r102;
        if (r101 < 0) goto L10;
        if (r101 >= r106) goto L10;
    L11:
        if (r103 == false) goto L15;
        return this.slots[r102 + r101];
    L15:
        return Composer.Companion.getEmpty();
    L10:
        r103 = false;
        goto L11
    L5:
        r105 = this.slots.length;
        goto L6
    }

    private final int emitGroup(StringBuilder r110, int r111, int r112) {
        boolean r100 = false;
        int r101 = 0;
    L3:
        if (r101 >= r112) goto L5;
        r110.append(' ');
        r101 = r101 + 1;
        goto L3
    L5:
        r110.append("Group(");
        r110.append(r111);
        r110.append(")");
        GroupSourceInformation r102 = sourceInformationOf(r111);
        if (r102 == null) goto L14;
        String r103 = r102.getSourceInformation();
        if (r103 == null) goto L14;
        if (StringsKt.startsWith$default(r103, "C(", false, 2, null) == false) goto L12;
    L13:
        int r104 = StringsKt.indexOf$default(r103, "(", 0, false, 6, null) + 1;
        int r105 = StringsKt.indexOf$default(r103, ')', 0, false, 6, null);
        r110.append(" ");
        r110.append(r103.substring(r104, r105));
        r110.append("()");
        goto L14
    L12:
        if (StringsKt.startsWith$default(r103, "CC(", false, 2, null) == true) goto L13;
    L14:
        r110.append(" key=");
        int r106 = r111 * 5;
        r110.append(this.groups[r106]);
        int r107 = SlotTableKt.access$groupSize(this.groups, r111);
        r110.append(", nodes=");
        int r108 = r106 + 1;
        r110.append(this.groups[r108] & RectListKt.Lower26Bits);
        r110.append(", size=");
        r110.append(r107);
        if ((this.groups[r108] & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L21;
        r110.append(", mark");
    L21:
        if ((this.groups[r108] & 67108864) == 0) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L26;
        r110.append(", contains mark");
    L26:
        int r114 = emitGroup$dataIndex(this, r111);
        int r115 = r111 + 1;
        int r116 = emitGroup$dataIndex(this, r115);
        if (r114 < 0) goto L30;
        if (r114 > r116) goto L30;
        boolean r117 = true;
    L32:
        if (r117 == true) goto L34;
    L60:
        r110.append(", *invalid data offsets " + r114 + '-' + r116 + '*');
    L61:
        r110.append('\n');
        int r118 = r111 + r107;
    L62:
        if (r115 >= r118) goto L64;
        r115 = r115 + emitGroup(r110, r115, r112 + 1);
        goto L62
    L64:
        return r107;
    L34:
        if (r116 > this.slotsSize) goto L60;
        if ((this.groups[r108] & 536870912) == 0) goto L38;
        boolean r119 = true;
    L39:
        if (r119 == false) goto L42;
        r110.append(" objectKey=" + SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$objectKeyIndex(this.groups, r111)]), 10));
    L42:
        if ((this.groups[r108] & 1073741824) == 0) goto L44;
        boolean r120 = true;
    L45:
        if (r120 == false) goto L48;
        r110.append(" node=" + SlotTableKt.access$summarize(String.valueOf(this.slots[this.groups[r106 + 4]]), 10));
    L48:
        if ((this.groups[r108] & 268435456) == 0) goto L50;
        r100 = true;
    L50:
        if (r100 == false) goto L52;
        r110.append(" aux=" + SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$auxIndex(this.groups, r111)]), 10));
    L52:
        int r121 = SlotTableKt.access$slotAnchor(this.groups, r111);
        if (r121 >= r116) goto L61;
        r110.append(", slots=[");
        r110.append(r121);
        r110.append(": ");
        int r122 = r121;
    L55:
        if (r122 >= r116) goto L59;
        if (r122 == r121) goto L58;
        r110.append(", ");
    L58:
        r110.append(SlotTableKt.access$summarize(String.valueOf(this.slots[r122]), 10));
        r122 = r122 + 1;
        goto L55
    L59:
        r110.append("]");
        goto L61
    L44:
        r120 = false;
        goto L45
    L38:
        r119 = false;
    L30:
        r117 = false;
        goto L32
    L23:
        r113 = false;
        goto L24
    L17:
        r109 = false;
        goto L18
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef r110, SlotTable r111, int r112, int r113) {
        int r100 = r110.element;
        int r101 = r100 + 1;
        r110.element = r101;
        int r102 = r100 * 5;
        int r103 = r111.groups[r102 + 2];
        boolean r104 = false;
        if (r103 != r112) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L8;
        PreconditionsKt.throwIllegalStateException("Invalid parent index detected at " + r100 + ", expected parent index to be " + r112 + " found " + r103);
    L8:
        int r106 = SlotTableKt.access$groupSize(r111.groups, r100) + r100;
        if (r106 > r111.groupsSize) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L14;
        PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + r100);
    L14:
        if (r106 > r113) goto L16;
        boolean r114 = true;
    L17:
        if (r114 == true) goto L19;
        PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + r100);
    L19:
        int[] r115 = r111.groups;
        int r108 = r102 + 4;
        int r109 = r115[r108];
        if (r100 < (r111.groupsSize - 1)) goto L22;
        int r116 = r111.slotsSize;
    L24:
        if (r116 > r111.slots.length) goto L26;
        boolean r117 = true;
    L27:
        if (r117 == true) goto L29;
        PreconditionsKt.throwIllegalStateException("Slots for " + r100 + " extend past the end of the slot table");
    L29:
        if (r109 > r116) goto L31;
        boolean r118 = true;
    L32:
        if (r118 == true) goto L35;
        PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + r100);
    L35:
        if (SlotTableKt.access$slotAnchor(r111.groups, r100) > r116) goto L37;
        boolean r119 = true;
    L38:
        if (r119 == true) goto L40;
        PreconditionsKt.throwIllegalStateException("Slots start out of range at " + r100);
    L40:
        int r120 = r102 + 1;
        int r121 = r111.groups[r120];
        if ((r121 & 1073741824) == 0) goto L43;
        int r122 = 1;
    L45:
        if ((536870912 & r121) == 0) goto L47;
        int r123 = 1;
    L48:
        int r124 = r122 + r123;
        if ((r121 & 268435456) == 0) goto L51;
        int r125 = 1;
    L53:
        if ((r116 - r109) < (r124 + r125)) goto L55;
        boolean r126 = true;
    L56:
        if (r126 == true) goto L58;
        PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + r100);
    L58:
        int[] r127 = r111.groups;
        if ((r127[r120] & 1073741824) == 0) goto L61;
        boolean r128 = true;
    L62:
        if (r128 == true) goto L64;
    L67:
        boolean r129 = true;
    L68:
        if (r129 == true) goto L70;
        PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + r100);
    L70:
        int r130 = 0;
    L72:
        if (r110.element >= r106) goto L74;
        r130 = r130 + verifyWellFormed$validateGroup(r110, r111, r100, r106);
        goto L72
    L74:
        int[] r131 = r111.groups;
        int r132 = r131[r120] & RectListKt.Lower26Bits;
        int r133 = SlotTableKt.access$groupSize(r131, r100);
        if (r132 != r130) goto L77;
        boolean r134 = true;
    L79:
        if (r134 == true) goto L81;
        PreconditionsKt.throwIllegalStateException("Incorrect node count detected at " + r100 + ", expected " + r132 + ", received " + r130);
    L81:
        int r135 = r110.element - r100;
        if (r133 != r135) goto L84;
        boolean r136 = true;
    L85:
        if (r136 == true) goto L87;
        PreconditionsKt.throwIllegalStateException("Incorrect slot count detected at " + r100 + ", expected " + r133 + ", received " + r135);
    L87:
        int[] r137 = r111.groups;
        if ((r137[r120] & 201326592) == 0) goto L90;
        boolean r138 = true;
    L91:
        if (r138 == false) goto L101;
        if (r100 > 0) goto L94;
    L98:
        r104 = true;
    L99:
        if (r104 == true) goto L101;
        PreconditionsKt.throwIllegalStateException("Expected group " + r112 + " to record it contains a mark because " + r100 + " does");
        goto L101
    L94:
        if ((r137[(r112 * 5) + 1] & 67108864) == 0) goto L96;
        boolean r139 = true;
    L97:
        if (r139 == false) goto L99;
    L96:
        r139 = false;
    L101:
        if (r128 == false) goto L104;
        return 1;
    L104:
        return r130;
    L90:
        r138 = false;
        goto L91
    L84:
        r136 = false;
        goto L85
    L77:
        r134 = false;
        goto L79
    L64:
        if (r111.slots[r127[r108]] != null) goto L67;
        r129 = false;
        goto L68
    L61:
        r128 = false;
        goto L62
    L55:
        r126 = false;
        goto L56
    L51:
        r125 = 0;
        goto L53
    L47:
        r123 = 0;
        goto L48
    L43:
        r122 = 0;
        goto L45
    L37:
        r119 = false;
        goto L38
    L31:
        r118 = false;
        goto L32
    L26:
        r117 = false;
        goto L27
    L22:
        r116 = r115[(r101 * 5) + 4];
        goto L24
    L16:
        r114 = false;
        goto L17
    L11:
        r107 = false;
        goto L12
    L5:
        r105 = false;
        goto L6
    }

    private static final void invalidateGroupsWithKey$lambda$20$scanGroup(SlotReader r100, MutableIntSet r101, List<Anchor> r102, Ref.BooleanRef r103, SlotTable r104, List<RecomposeScopeImpl> r105) {
        int r106 = r100.getGroupKey();
        if (r101.contains(r106) == false) goto L24;
        boolean r107 = true;
        if (r106 == (-3)) goto L8;
        r102.add(SlotReader.anchor$default(r100, 0, 1, null));
    L8:
        if (r103.element == false) goto L22;
        RecomposeScopeImpl r108 = r104.findEffectiveRecomposeScope(r100.getCurrentGroup());
        if (r108 == null) goto L21;
        r105.add(r108);
        Anchor r109 = r108.getAnchor();
        if (r109 != null) goto L14;
    L16:
        r107 = false;
    L17:
        if (r107 == false) goto L22;
        RecomposeScopeImpl r110 = r104.findEffectiveRecomposeScope(r100.getParent());
        if (r110 == null) goto L22;
        r105.add(r110);
        goto L22
    L14:
        if (r109.getLocation$runtime() != r100.getCurrentGroup()) goto L16;
    L21:
        r103.element = false;
        r105.clear();
    L22:
        r100.skipGroup();
        return;
    L24:
        r100.startGroup();
    L26:
        if (r100.isGroupEnd() == true) goto L28;
        invalidateGroupsWithKey$lambda$20$scanGroup(r100, r101, r102, r103, r104, r105);
        goto L26
    L28:
        r100.endGroup();
    }

    public final void setTo$runtime(int[] r100, int r101, Object[] r102, int r103, ArrayList<Anchor> r104, HashMap<Anchor, GroupSourceInformation> r105, MutableIntObjectMap<MutableIntSet> r106) {
        this.groups = r100;
        this.groupsSize = r101;
        this.slots = r102;
        this.slotsSize = r103;
        this.anchors = r104;
        this.sourceInformationMap = r105;
        this.calledByMap = r106;
    }

    public final void close$runtime(SlotWriter r110, int[] r111, int r112, Object[] r113, int r114, ArrayList<Anchor> r115, HashMap<Anchor, GroupSourceInformation> r116, MutableIntObjectMap<MutableIntSet> r117) {
        if (r110.getTable$runtime() == this) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
    L10:
        this.writer = false;
        setTo$runtime(r111, r112, r113, r114, r115, r116, r117);
        return;
    L5:
        if (this.writer == false) goto L7;
        r100 = true;
        goto L8
    }
}
