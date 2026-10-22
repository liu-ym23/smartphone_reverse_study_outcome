package androidx.compose.runtime;

import D7.q;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0001\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\b¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0007H\u0086\b¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J?\u0010*\u001a\u00020'2\u0006\u0010\"\u001a\u00020\b2&\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u0001`%H\u0000¢\u0006\u0004\b(\u0010)J\u008f\u0001\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\f2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00122\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/2\u0006\u00102\u001a\u00020\u00122\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001403j\b\u0012\u0004\u0012\u00020\u0014`42&\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u0001`%2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0000¢\u0006\u0004\b(\u00109J\u0087\u0001\u0010<\u001a\u00020'2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00122\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/2\u0006\u00102\u001a\u00020\u00122\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001403j\b\u0012\u0004\u0012\u00020\u0014`42&\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u0001`%2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0000¢\u0006\u0004\b:\u0010;J\u001f\u0010B\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0006\u0010=\u001a\u00020\u0012H\u0000¢\u0006\u0004\b@\u0010AJ\r\u0010C\u001a\u00020\u0019¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u0004\u0018\u00010$2\u0006\u0010E\u001a\u00020\u0012¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020'¢\u0006\u0004\bH\u0010\u0005J\r\u0010I\u001a\u00020'¢\u0006\u0004\bI\u0010\u0005J\r\u0010J\u001a\u00020'¢\u0006\u0004\bJ\u0010\u0005J\r\u0010L\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000>2\u0006\u0010E\u001a\u00020\u0012H\u0000¢\u0006\u0004\bN\u0010AJ!\u0010S\u001a\u0004\u0018\u0001002\u0006\u0010E\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0000¢\u0006\u0004\bQ\u0010RJ\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030TH\u0096\u0002¢\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001a\u0004\u0018\u00010\u00032\u0006\u0010W\u001a\u000200H\u0016¢\u0006\u0004\bX\u0010YJ\u0019\u0010Z\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\bZ\u0010\u0016J\u0019\u0010[\u001a\u0004\u0018\u00010?2\u0006\u0010E\u001a\u00020\u0012H\u0002¢\u0006\u0004\b[\u0010\\J'\u0010`\u001a\u00020\u0012*\u00060]j\u0002`^2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u0012H\u0002¢\u0006\u0004\b`\u0010aJ\u0015\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120>H\u0002¢\u0006\u0004\bb\u0010cJ\u0015\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00120>H\u0002¢\u0006\u0004\bd\u0010cJ\u0015\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00120>H\u0002¢\u0006\u0004\be\u0010cJ\u0015\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00120>H\u0002¢\u0006\u0004\bf\u0010cJ\u0015\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00120>H\u0002¢\u0006\u0004\bg\u0010cR$\u0010-\u001a\u00020,2\u0006\u0010h\u001a\u00020,8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010i\u001a\u0004\bj\u0010kR$\u0010.\u001a\u00020\u00122\u0006\u0010h\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u0010l\u001a\u0004\bm\u0010nR4\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/2\u000e\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u0010o\u001a\u0004\bp\u0010qR$\u00102\u001a\u00020\u00122\u0006\u0010h\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b2\u0010l\u001a\u0004\br\u0010nR\u0016\u0010s\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010lR\u0018\u0010u\u001a\u000600j\u0002`t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010+\u001a\u00020\u00192\u0006\u0010h\u001a\u00020\u00198\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b+\u0010w\u001a\u0004\bx\u0010DR\"\u0010y\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010l\u001a\u0004\bz\u0010n\"\u0004\b{\u0010|R4\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u001403j\b\u0012\u0004\u0012\u00020\u0014`48\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b5\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001RG\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020$\u0018\u0001`%8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b&\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R/\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b8\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010\u008c\u0001\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010DR\u001d\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006\u0090\u0001"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Landroidx/compose/runtime/SlotReader;", "block", "read", "(LS7/k;)Ljava/lang/Object;", "Landroidx/compose/runtime/SlotWriter;", "write", "openReader", "()Landroidx/compose/runtime/SlotReader;", "openWriter", "()Landroidx/compose/runtime/SlotWriter;", "", "index", "Landroidx/compose/runtime/Anchor;", "anchor", "(I)Landroidx/compose/runtime/Anchor;", "anchorIndex", "(Landroidx/compose/runtime/Anchor;)I", "", "ownsAnchor", "(Landroidx/compose/runtime/Anchor;)Z", "groupAnchor", "inGroup", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/Anchor;)Z", "groupIndex", "groupContainsAnchor", "(ILandroidx/compose/runtime/Anchor;)Z", "reader", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "LC7/r;", "close$runtime", "(Landroidx/compose/runtime/SlotReader;Ljava/util/HashMap;)V", "close", "writer", "", "groups", "groupsSize", "", "", "slots", "slotsSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "calledByMap", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo$runtime", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", TypedValues.AttributesType.S_TARGET, "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateGroupsWithKey$runtime", "(I)Ljava/util/List;", "invalidateGroupsWithKey", "containsMark", "()Z", "group", "sourceInformationOf", "(I)Landroidx/compose/runtime/GroupSourceInformation;", "verifyWellFormed", "collectCalledByInformation", "collectSourceInformation", "", "toDebugString", "()Ljava/lang/String;", "slotsOf$runtime", "slotsOf", "slotIndex", "slot$runtime", "(II)Ljava/lang/Object;", "slot", "", "iterator", "()Ljava/util/Iterator;", "identityToFind", "find", "(Ljava/lang/Object;)Landroidx/compose/runtime/tooling/CompositionGroup;", "tryAnchor", "findEffectiveRecomposeScope", "(I)Landroidx/compose/runtime/RecomposeScopeImpl;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "emitGroup", "(Ljava/lang/StringBuilder;II)I", "keys", "()Ljava/util/List;", "nodes", "parentIndexes", "dataIndexes", "groupSizes", "value", "[I", "getGroups", "()[I", "I", "getGroupsSize", "()I", "[Ljava/lang/Object;", "getSlots", "()[Ljava/lang/Object;", "getSlotsSize", "readers", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "Z", "getWriter$runtime", "version", "getVersion$runtime", "setVersion$runtime", "(I)V", "Ljava/util/ArrayList;", "getAnchors$runtime", "()Ljava/util/ArrayList;", "setAnchors$runtime", "(Ljava/util/ArrayList;)V", "Ljava/util/HashMap;", "getSourceInformationMap$runtime", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime", "(Ljava/util/HashMap;)V", "Landroidx/collection/MutableIntObjectMap;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", "getCompositionGroups", "()Ljava/lang/Iterable;", "compositionGroups", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, T7.a {
    public static final int $stable = 8;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private final Object lock = new Object();
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final int emitGroup(StringBuilder sb, int i, int i6) {
        String sourceInformation;
        for (int i10 = 0; i10 < i6; i10++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(")");
        GroupSourceInformation groupSourceInformationSourceInformationOf = sourceInformationOf(i);
        if (groupSourceInformationSourceInformationOf != null && (sourceInformation = groupSourceInformationSourceInformationOf.getSourceInformation()) != null && (t.e0(sourceInformation, "C(", false) || t.e0(sourceInformation, "CC(", false))) {
            int iQ0 = m.q0(sourceInformation, "(", 0, false, 6) + 1;
            int iP0 = m.p0(sourceInformation, ')', 0, 6);
            sb.append(" ");
            String strSubstring = sourceInformation.substring(iQ0, iP0);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            sb.append(strSubstring);
            sb.append("()");
        }
        sb.append(" key=");
        int i11 = i * 5;
        sb.append(this.groups[i11]);
        int iGroupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        int i12 = i11 + 1;
        sb.append(this.groups[i12] & RectListKt.Lower26Bits);
        sb.append(", size=");
        sb.append(iGroupSize);
        if ((this.groups[i12] & 134217728) != 0) {
            sb.append(", mark");
        }
        if ((this.groups[i12] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0) {
            sb.append(", contains mark");
        }
        int iEmitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int iEmitGroup = i + 1;
        int iEmitGroup$dataIndex2 = emitGroup$dataIndex(this, iEmitGroup);
        if (iEmitGroup$dataIndex < 0 || iEmitGroup$dataIndex > iEmitGroup$dataIndex2 || iEmitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + iEmitGroup$dataIndex + '-' + iEmitGroup$dataIndex2 + '*');
        } else {
            if ((this.groups[i12] & 536870912) != 0) {
                sb.append(" objectKey=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]), 10));
            }
            if ((this.groups[i12] & BasicMeasure.EXACTLY) != 0) {
                sb.append(" node=" + SlotTableKt.summarize(String.valueOf(this.slots[this.groups[i11 + 4]]), 10));
            }
            if ((this.groups[i12] & 268435456) != 0) {
                sb.append(" aux=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.auxIndex(this.groups, i)]), 10));
            }
            int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (iSlotAnchor < iEmitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(iSlotAnchor);
                sb.append(": ");
                for (int i13 = iSlotAnchor; i13 < iEmitGroup$dataIndex2; i13++) {
                    if (i13 != iSlotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(SlotTableKt.summarize(String.valueOf(this.slots[i13]), 10));
                }
                sb.append("]");
            }
        }
        sb.append('\n');
        int i14 = i + iGroupSize;
        while (iEmitGroup < i14) {
            iEmitGroup += emitGroup(sb, iEmitGroup, i6 + 1);
        }
        return iGroupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : slotTable.groups[(i * 5) + 4];
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int i = group;
        while (i > 0) {
            Iterator<Object> it = new DataIterator(this, i).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    if (recomposeScopeImpl.getUsed() && i != group) {
                        return recomposeScopeImpl;
                    }
                    recomposeScopeImpl.setForcedRecompose(true);
                }
            }
            i = this.groups[(i * 5) + 2];
        }
        return null;
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    private static final void invalidateGroupsWithKey$lambda$20$scanGroup(SlotReader slotReader, MutableIntSet mutableIntSet, List<Anchor> list, Ref$BooleanRef ref$BooleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope;
        int groupKey = slotReader.getGroupKey();
        if (!mutableIntSet.contains(groupKey)) {
            slotReader.startGroup();
            while (!slotReader.isGroupEnd()) {
                invalidateGroupsWithKey$lambda$20$scanGroup(slotReader, mutableIntSet, list, ref$BooleanRef, slotTable, list2);
            }
            slotReader.endGroup();
            return;
        }
        if (groupKey != -3) {
            list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
        }
        if (ref$BooleanRef.f4916a) {
            RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope2 = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
            if (recomposeScopeImplFindEffectiveRecomposeScope2 != null) {
                list2.add(recomposeScopeImplFindEffectiveRecomposeScope2);
                Anchor anchor = recomposeScopeImplFindEffectiveRecomposeScope2.getAnchor();
                if (anchor != null && anchor.getLocation() == slotReader.getCurrentGroup() && (recomposeScopeImplFindEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getParent())) != null) {
                    list2.add(recomposeScopeImplFindEffectiveRecomposeScope);
                }
            } else {
                ref$BooleanRef.f4916a = false;
                list2.clear();
            }
        }
        slotReader.skipGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final Anchor tryAnchor(int index) {
        int i;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (index < 0 || index >= (i = this.groupsSize)) {
            return null;
        }
        return SlotTableKt.find(this.anchors, index, i);
    }

    private static final int verifyWellFormed$validateGroup(Ref$IntRef ref$IntRef, SlotTable slotTable, int i, int i6) {
        int i10 = ref$IntRef.f4918a;
        int i11 = i10 + 1;
        ref$IntRef.f4918a = i11;
        int i12 = i10 * 5;
        int i13 = slotTable.groups[i12 + 2];
        if (!(i13 == i)) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i10, "Invalid parent index detected at ", i, ", expected parent index to be ", " found ");
            sbS.append(i13);
            PreconditionsKt.throwIllegalStateException(sbS.toString());
        }
        int iGroupSize = SlotTableKt.groupSize(slotTable.groups, i10) + i10;
        if (!(iGroupSize <= slotTable.groupsSize)) {
            PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + i10);
        }
        if (!(iGroupSize <= i6)) {
            PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + i10);
        }
        int[] iArr = slotTable.groups;
        int i14 = i12 + 4;
        int i15 = iArr[i14];
        int i16 = i10 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : iArr[(i11 * 5) + 4];
        if (!(i16 <= slotTable.slots.length)) {
            PreconditionsKt.throwIllegalStateException("Slots for " + i10 + " extend past the end of the slot table");
        }
        if (!(i15 <= i16)) {
            PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + i10);
        }
        if (!(SlotTableKt.slotAnchor(slotTable.groups, i10) <= i16)) {
            PreconditionsKt.throwIllegalStateException("Slots start out of range at " + i10);
        }
        int i17 = i12 + 1;
        int i18 = slotTable.groups[i17];
        if (!(i16 - i15 >= (((i18 & BasicMeasure.EXACTLY) != 0 ? 1 : 0) + ((536870912 & i18) != 0 ? 1 : 0)) + ((i18 & 268435456) != 0 ? 1 : 0))) {
            PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + i10);
        }
        int[] iArr2 = slotTable.groups;
        boolean z10 = (iArr2[i17] & BasicMeasure.EXACTLY) != 0;
        if (!((z10 && slotTable.slots[iArr2[i14]] == null) ? false : true)) {
            PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + i10);
        }
        int iVerifyWellFormed$validateGroup = 0;
        while (ref$IntRef.f4918a < iGroupSize) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(ref$IntRef, slotTable, i10, iGroupSize);
        }
        int[] iArr3 = slotTable.groups;
        int i19 = iArr3[i17] & RectListKt.Lower26Bits;
        int iGroupSize2 = SlotTableKt.groupSize(iArr3, i10);
        if (!(i19 == iVerifyWellFormed$validateGroup)) {
            StringBuilder sbS2 = androidx.appfunctions.metadata.a.s(i10, "Incorrect node count detected at ", i19, ", expected ", ", received ");
            sbS2.append(iVerifyWellFormed$validateGroup);
            PreconditionsKt.throwIllegalStateException(sbS2.toString());
        }
        int i20 = ref$IntRef.f4918a - i10;
        if (!(iGroupSize2 == i20)) {
            StringBuilder sbS3 = androidx.appfunctions.metadata.a.s(i10, "Incorrect slot count detected at ", iGroupSize2, ", expected ", ", received ");
            sbS3.append(i20);
            PreconditionsKt.throwIllegalStateException(sbS3.toString());
        }
        int[] iArr4 = slotTable.groups;
        if ((iArr4[i17] & 201326592) != 0) {
            if (!(i10 <= 0 || (iArr4[(i * 5) + 1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0)) {
                PreconditionsKt.throwIllegalStateException("Expected group " + i + " to record it contains a mark because " + i10 + " does");
            }
        }
        if (z10) {
            return 1;
        }
        return iVerifyWellFormed$validateGroup;
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable slotTable, GroupSourceInformation groupSourceInformation) {
        ArrayList<Object> groups = groupSourceInformation.getGroups();
        if (groups != null) {
            int size = groups.size();
            for (int i = 0; i < size; i++) {
                Object obj = groups.get(i);
                if (obj instanceof Anchor) {
                    Anchor anchor = (Anchor) obj;
                    if (!anchor.getValid()) {
                        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                    }
                    if (!slotTable.ownsAnchor(anchor)) {
                        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                    }
                } else if (obj instanceof GroupSourceInformation) {
                    verifyWellFormed$verifySourceGroup(slotTable, (GroupSourceInformation) obj);
                }
            }
        }
    }

    public final Anchor anchor(int index) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        boolean z10 = false;
        if (index >= 0 && index < this.groupsSize) {
            z10 = true;
        }
        if (!z10) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, this.groupsSize);
        if (iSearch >= 0) {
            return arrayList.get(iSearch);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(iSearch + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!anchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return anchor.getLocation();
    }

    public final void close$runtime(SlotReader reader, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        if (!(reader.getTable() == this && this.readers > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers--;
        if (sourceInformationMap != null) {
            synchronized (this.lock) {
                try {
                    HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
                    if (map != null) {
                        map.putAll(sourceInformationMap);
                    } else {
                        this.sourceInformationMap = sourceInformationMap;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap<>(0, 1, null);
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap<>();
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && (this.groups[1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(identityToFind);
    }

    public final ArrayList<Anchor> getAnchors$runtime() {
        return this.anchors;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
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

    /* renamed from: getVersion$runtime, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: getWriter$runtime, reason: from getter */
    public final boolean getWriter() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int groupIndex, Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        if (!(groupIndex >= 0 && groupIndex < this.groupsSize)) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        if (ownsAnchor(anchor)) {
            int iGroupSize = SlotTableKt.groupSize(this.groups, groupIndex) + groupIndex;
            int location$runtime = anchor.getLocation();
            if (groupIndex <= location$runtime && location$runtime < iGroupSize) {
                return true;
            }
        }
        return false;
    }

    public final boolean inGroup(Anchor groupAnchor, Anchor anchor) {
        int location$runtime = groupAnchor.getLocation();
        int iGroupSize = SlotTableKt.groupSize(this.groups, location$runtime) + location$runtime;
        int location$runtime2 = anchor.getLocation();
        return location$runtime <= location$runtime2 && location$runtime2 < iGroupSize;
    }

    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime(int target) {
        MutableIntSet mutableIntSet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.f4916a = true;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        mutableIntSet2.add(target);
        mutableIntSet2.add(-3);
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        if (mutableIntObjectMap != null && (mutableIntSet = mutableIntObjectMap.get(target)) != null) {
            mutableIntSet2.addAll(mutableIntSet);
        }
        SlotReader slotReaderOpenReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$20$scanGroup(slotReaderOpenReader, mutableIntSet2, arrayList, ref$BooleanRef, this, arrayList2);
            slotReaderOpenReader.close();
            SlotWriter slotWriterOpenWriter = openWriter();
            try {
                slotWriterOpenWriter.startGroup();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Anchor anchor = (Anchor) arrayList.get(i);
                    if (anchor.toIndexFor(slotWriterOpenWriter) >= slotWriterOpenWriter.getCurrentGroup()) {
                        slotWriterOpenWriter.seek(anchor);
                        slotWriterOpenWriter.bashCurrentGroup();
                    }
                }
                slotWriterOpenWriter.skipToGroupEnd();
                slotWriterOpenWriter.endGroup();
                slotWriterOpenWriter.close(true);
                if (ref$BooleanRef.f4916a) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        } catch (Throwable th2) {
            slotReaderOpenReader.close();
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(Anchor anchor) {
        int iSearch;
        return anchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, anchor.getLocation(), this.groupsSize)) >= 0 && kotlin.jvm.internal.k.b(this.anchors.get(iSearch), anchor);
    }

    public final <T> T read(S7.k block) {
        SlotReader slotReaderOpenReader = openReader();
        try {
            return (T) block.invoke(slotReaderOpenReader);
        } finally {
            slotReaderOpenReader.close();
        }
    }

    public final void setAnchors$runtime(ArrayList<Anchor> arrayList) {
        this.anchors = arrayList;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    public final void setSourceInformationMap$runtime(HashMap<Anchor, GroupSourceInformation> map) {
        this.sourceInformationMap = map;
    }

    public final void setTo$runtime(int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors, HashMap<Anchor, GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
        this.sourceInformationMap = sourceInformationMap;
        this.calledByMap = calledByMap;
    }

    public final void setVersion$runtime(int i) {
        this.version = i;
    }

    public final Object slot$runtime(int group, int slotIndex) {
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i = group + 1;
        return (slotIndex < 0 || slotIndex >= (i < this.groupsSize ? this.groups[(i * 5) + 4] : this.slots.length) - iSlotAnchor) ? Composer.INSTANCE.getEmpty() : this.slots[iSlotAnchor + slotIndex];
    }

    public final List<Object> slotsOf$runtime(int group) {
        int[] iArr = this.groups;
        int i = iArr[(group * 5) + 4];
        int i6 = group + 1;
        return q.I0(this.slots).subList(i, i6 < this.groupsSize ? iArr[(i6 * 5) + 4] : this.slots.length);
    }

    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor anchorTryAnchor;
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (anchorTryAnchor = tryAnchor(group)) == null) {
            return null;
        }
        return map.get(anchorTryAnchor);
    }

    public final String toDebugString() {
        if (this.writer) {
            return toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int iEmitGroup = 0;
            while (iEmitGroup < i) {
                iEmitGroup += emitGroup(sb, iEmitGroup, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final void verifyWellFormed() {
        int i;
        int i6;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i10 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i = ref$IntRef.f4918a;
                i6 = this.groupsSize;
                if (i >= i6) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(ref$IntRef, this, -1, SlotTableKt.groupSize(this.groups, i) + i);
                }
            }
            if (!(i == i6)) {
                PreconditionsKt.throwIllegalStateException("Incomplete group at root " + ref$IntRef.f4918a + " expected to be " + this.groupsSize);
            }
        }
        int length = this.slots.length;
        for (int i11 = this.slotsSize; i11 < length; i11++) {
            if (!(this.slots[i11] == null)) {
                PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + i11);
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            int indexFor = arrayList.get(i12).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            }
            if (!(i10 < indexFor)) {
                PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            }
            i12++;
            i10 = indexFor;
        }
        HashMap<Anchor, GroupSourceInformation> map = this.sourceInformationMap;
        if (map != null) {
            for (Map.Entry<Anchor, GroupSourceInformation> entry : map.entrySet()) {
                Anchor key = entry.getKey();
                GroupSourceInformation value = entry.getValue();
                if (!key.getValid()) {
                    PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                }
                if (!ownsAnchor(key)) {
                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }
                verifyWellFormed$verifySourceGroup(this, value);
            }
        }
    }

    public final <T> T write(S7.k block) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            T t9 = (T) block.invoke(slotWriterOpenWriter);
            slotWriterOpenWriter.close(true);
            return t9;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    public final void close$runtime(SlotWriter writer, int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors, HashMap<Anchor, GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        if (!(writer.getTable() == this && this.writer)) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = false;
        setTo$runtime(groups, groupsSize, slots, slotsSize, anchors, sourceInformationMap, calledByMap);
    }
}
