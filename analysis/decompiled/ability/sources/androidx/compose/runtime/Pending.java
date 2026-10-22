package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010!J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b#\u0010!R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)\"\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010$R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R'\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0003098F¢\u0006\u0006\u001a\u0004\b:\u0010&¨\u0006<"}, d2 = {"Landroidx/compose/runtime/Pending;", "", "", "Landroidx/compose/runtime/KeyInfo;", "keyInfos", "", "startIndex", AppAgent.CONSTRUCT, "(Ljava/util/List;I)V", "key", "dataKey", "getNext", "(ILjava/lang/Object;)Landroidx/compose/runtime/KeyInfo;", "keyInfo", "", "recordUsed", "(Landroidx/compose/runtime/KeyInfo;)Z", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "LC7/r;", "registerMoveSlot", "(II)V", "count", "registerMoveNode", "(III)V", "insertIndex", "registerInsert", "(Landroidx/compose/runtime/KeyInfo;I)V", "group", "newCount", "updateNodeCount", "(II)Z", "slotPositionOf", "(Landroidx/compose/runtime/KeyInfo;)I", "nodePositionOf", "updatedNodeCountOf", "Ljava/util/List;", "getKeyInfos", "()Ljava/util/List;", "I", "getStartIndex", "()I", "groupIndex", "getGroupIndex", "setGroupIndex", "(I)V", "usedKeys", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/GroupInfo;", "groupInfos", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/collection/MultiValueMap;", "keyMap$delegate", "LC7/f;", "getKeyMap-fVlnmYg", "()Landroidx/collection/MutableScatterMap;", "keyMap", "", "getUsed", "used", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class Pending {
    private int groupIndex;
    private final MutableIntObjectMap<GroupInfo> groupInfos;
    private final List<KeyInfo> keyInfos;

    /* renamed from: keyMap$delegate, reason: from kotlin metadata */
    private final C7.f keyMap;
    private final int startIndex;
    private final List<KeyInfo> usedKeys;

    public Pending(List<KeyInfo> list, int i) {
        this.keyInfos = list;
        this.startIndex = i;
        if (!(i >= 0)) {
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }
        this.usedKeys = new ArrayList();
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        int size = list.size();
        int nodes = 0;
        for (int i6 = 0; i6 < size; i6++) {
            KeyInfo keyInfo = this.keyInfos.get(i6);
            mutableIntObjectMap.set(keyInfo.getLocation(), new GroupInfo(i6, nodes, keyInfo.getNodes()));
            nodes += keyInfo.getNodes();
        }
        this.groupInfos = mutableIntObjectMap;
        this.keyMap = kotlin.a.a(new S7.a() { // from class: androidx.compose.runtime.Pending$keyMap$2
            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                return MultiValueMap.m3550boximpl(m3432invokefVlnmYg());
            }

            /* renamed from: invoke-fVlnmYg, reason: not valid java name */
            public final MutableScatterMap<Object, Object> m3432invokefVlnmYg() {
                MutableScatterMap<Object, Object> mutableScatterMapMultiMap = ComposerKt.multiMap(this.this$0.getKeyInfos().size());
                Pending pending = this.this$0;
                int size2 = pending.getKeyInfos().size();
                for (int i10 = 0; i10 < size2; i10++) {
                    KeyInfo keyInfo2 = pending.getKeyInfos().get(i10);
                    MultiValueMap.m3549addimpl(mutableScatterMapMultiMap, ComposerKt.getJoinedKey(keyInfo2), keyInfo2);
                }
                return mutableScatterMapMultiMap;
            }
        });
    }

    public final int getGroupIndex() {
        return this.groupIndex;
    }

    public final List<KeyInfo> getKeyInfos() {
        return this.keyInfos;
    }

    /* renamed from: getKeyMap-fVlnmYg, reason: not valid java name */
    public final MutableScatterMap<Object, Object> m3431getKeyMapfVlnmYg() {
        return ((MultiValueMap) this.keyMap.getF4884a()).getMap();
    }

    public final KeyInfo getNext(int key, Object dataKey) {
        return (KeyInfo) MultiValueMap.m3562removeFirstimpl(m3431getKeyMapfVlnmYg(), dataKey != null ? new JoinedKey(Integer.valueOf(key), dataKey) : Integer.valueOf(key));
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final List<KeyInfo> getUsed() {
        return this.usedKeys;
    }

    public final int nodePositionOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        if (groupInfo != null) {
            return groupInfo.getNodeIndex();
        }
        return -1;
    }

    public final boolean recordUsed(KeyInfo keyInfo) {
        return this.usedKeys.add(keyInfo);
    }

    public final void registerInsert(KeyInfo keyInfo, int insertIndex) {
        this.groupInfos.set(keyInfo.getLocation(), new GroupInfo(-1, insertIndex, 0));
    }

    public final void registerMoveNode(int from, int to, int count) {
        char c;
        long j5;
        char c2;
        long j6;
        char c5 = 7;
        long j10 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j11 = jArr[i];
                if ((((~j11) << c5) & j11 & j10) != j10) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i6) {
                        if ((j11 & 255) < 128) {
                            c2 = c5;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i10];
                            j6 = j10;
                            int nodeIndex = groupInfo.getNodeIndex();
                            if (from <= nodeIndex && nodeIndex < from + count) {
                                groupInfo.setNodeIndex((nodeIndex - from) + to);
                            } else if (to <= nodeIndex && nodeIndex < from) {
                                groupInfo.setNodeIndex(nodeIndex + count);
                            }
                        } else {
                            c2 = c5;
                            j6 = j10;
                        }
                        j11 >>= 8;
                        i10++;
                        c5 = c2;
                        j10 = j6;
                    }
                    c = c5;
                    j5 = j10;
                    if (i6 != 8) {
                        return;
                    }
                } else {
                    c = c5;
                    j5 = j10;
                }
                if (i == length) {
                    return;
                }
                i++;
                c5 = c;
                j10 = j5;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                long j12 = jArr2[i11];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length2)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((j12 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i11 << 3) + i13];
                            int nodeIndex2 = groupInfo2.getNodeIndex();
                            if (from <= nodeIndex2 && nodeIndex2 < from + count) {
                                groupInfo2.setNodeIndex((nodeIndex2 - from) + to);
                            } else if (from + 1 <= nodeIndex2 && nodeIndex2 < to) {
                                groupInfo2.setNodeIndex(nodeIndex2 - count);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i12 != 8) {
                        return;
                    }
                }
                if (i11 == length2) {
                    return;
                } else {
                    i11++;
                }
            }
        }
    }

    public final void registerMoveSlot(int from, int to) {
        char c;
        long j5;
        char c2;
        long j6;
        char c5 = 7;
        long j10 = -9187201950435737472L;
        if (from > to) {
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
            Object[] objArr = mutableIntObjectMap.values;
            long[] jArr = mutableIntObjectMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j11 = jArr[i];
                if ((((~j11) << c5) & j11 & j10) != j10) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i6) {
                        if ((j11 & 255) < 128) {
                            c2 = c5;
                            GroupInfo groupInfo = (GroupInfo) objArr[(i << 3) + i10];
                            j6 = j10;
                            int slotIndex = groupInfo.getSlotIndex();
                            if (slotIndex == from) {
                                groupInfo.setSlotIndex(to);
                            } else if (to <= slotIndex && slotIndex < from) {
                                groupInfo.setSlotIndex(slotIndex + 1);
                            }
                        } else {
                            c2 = c5;
                            j6 = j10;
                        }
                        j11 >>= 8;
                        i10++;
                        c5 = c2;
                        j10 = j6;
                    }
                    c = c5;
                    j5 = j10;
                    if (i6 != 8) {
                        return;
                    }
                } else {
                    c = c5;
                    j5 = j10;
                }
                if (i == length) {
                    return;
                }
                i++;
                c5 = c;
                j10 = j5;
            }
        } else {
            if (to <= from) {
                return;
            }
            MutableIntObjectMap<GroupInfo> mutableIntObjectMap2 = this.groupInfos;
            Object[] objArr2 = mutableIntObjectMap2.values;
            long[] jArr2 = mutableIntObjectMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                long j12 = jArr2[i11];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length2)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((j12 & 255) < 128) {
                            GroupInfo groupInfo2 = (GroupInfo) objArr2[(i11 << 3) + i13];
                            int slotIndex2 = groupInfo2.getSlotIndex();
                            if (slotIndex2 == from) {
                                groupInfo2.setSlotIndex(to);
                            } else if (from + 1 <= slotIndex2 && slotIndex2 < to) {
                                groupInfo2.setSlotIndex(slotIndex2 - 1);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i12 != 8) {
                        return;
                    }
                }
                if (i11 == length2) {
                    return;
                } else {
                    i11++;
                }
            }
        }
    }

    public final void setGroupIndex(int i) {
        this.groupIndex = i;
    }

    public final int slotPositionOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        if (groupInfo != null) {
            return groupInfo.getSlotIndex();
        }
        return -1;
    }

    public final boolean updateNodeCount(int group, int newCount) {
        int nodeIndex;
        GroupInfo groupInfo = this.groupInfos.get(group);
        if (groupInfo == null) {
            return false;
        }
        int nodeIndex2 = groupInfo.getNodeIndex();
        int nodeCount = newCount - groupInfo.getNodeCount();
        groupInfo.setNodeCount(newCount);
        if (nodeCount == 0) {
            return true;
        }
        MutableIntObjectMap<GroupInfo> mutableIntObjectMap = this.groupInfos;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        GroupInfo groupInfo2 = (GroupInfo) objArr[(i << 3) + i10];
                        if (groupInfo2.getNodeIndex() >= nodeIndex2 && !groupInfo2.equals(groupInfo) && (nodeIndex = groupInfo2.getNodeIndex() + nodeCount) >= 0) {
                            groupInfo2.setNodeIndex(nodeIndex);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final int updatedNodeCountOf(KeyInfo keyInfo) {
        GroupInfo groupInfo = this.groupInfos.get(keyInfo.getLocation());
        return groupInfo != null ? groupInfo.getNodeCount() : keyInfo.getNodes();
    }
}
