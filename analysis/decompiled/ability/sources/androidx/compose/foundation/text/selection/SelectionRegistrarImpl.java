package androidx.compose.foundation.text.selection;

import D7.z;
import N9.j;
import S7.k;
import S7.n;
import S7.p;
import S7.r;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 s2\u00020\u0001:\u0001sB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J2\u0010 \u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\"JB\u0010(\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u0005R\"\u0010+\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0007048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00109\u001a\u000607j\u0002`88\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R0\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010ARB\u0010C\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b\u0018\u00010B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR6\u0010J\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010I8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010ORN\u0010Q\u001a.\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR*\u0010X\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010W8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R0\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010=\u001a\u0004\b_\u0010?\"\u0004\b`\u0010AR0\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010=\u001a\u0004\bb\u0010?\"\u0004\bc\u0010AR7\u0010m\u001a\b\u0012\u0004\u0012\u00020e0d2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020e0d8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bq\u0010j\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006t"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "", "initialIncrementId", AppAgent.CONSTRUCT, "(J)V", "()V", "Landroidx/compose/foundation/text/selection/Selectable;", "selectable", "subscribe", "(Landroidx/compose/foundation/text/selection/Selectable;)Landroidx/compose/foundation/text/selection/Selectable;", "LC7/r;", "unsubscribe", "(Landroidx/compose/foundation/text/selection/Selectable;)V", "nextSelectableId", "()J", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "", "sort", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Ljava/util/List;", "selectableId", "notifyPositionChange", "layoutCoordinates", "Landroidx/compose/ui/geometry/Offset;", "startPosition", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "", "isInTouchMode", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "notifySelectionUpdateStart", "notifySelectionUpdateSelectAll", "(JZ)V", "newPosition", "previousPosition", "isStartHandle", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdate", "notifySelectionUpdateEnd", "notifySelectableChange", "sorted", "Z", "getSorted$foundation_release", "()Z", "setSorted$foundation_release", "(Z)V", "", "_selectables", "Ljava/util/List;", "Landroidx/collection/MutableLongObjectMap;", "_selectableMap", "Landroidx/collection/MutableLongObjectMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/Function1;", "onPositionChangeCallback", "LS7/k;", "getOnPositionChangeCallback$foundation_release", "()LS7/k;", "setOnPositionChangeCallback$foundation_release", "(LS7/k;)V", "Lkotlin/Function4;", "onSelectionUpdateStartCallback", "LS7/p;", "getOnSelectionUpdateStartCallback$foundation_release", "()LS7/p;", "setOnSelectionUpdateStartCallback$foundation_release", "(LS7/p;)V", "Lkotlin/Function2;", "onSelectionUpdateSelectAll", "LS7/n;", "getOnSelectionUpdateSelectAll$foundation_release", "()LS7/n;", "setOnSelectionUpdateSelectAll$foundation_release", "(LS7/n;)V", "Lkotlin/Function6;", "onSelectionUpdateCallback", "LS7/r;", "getOnSelectionUpdateCallback$foundation_release", "()LS7/r;", "setOnSelectionUpdateCallback$foundation_release", "(LS7/r;)V", "Lkotlin/Function0;", "onSelectionUpdateEndCallback", "LS7/a;", "getOnSelectionUpdateEndCallback$foundation_release", "()LS7/a;", "setOnSelectionUpdateEndCallback$foundation_release", "(LS7/a;)V", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation_release", "setOnSelectableChangeCallback$foundation_release", "afterSelectableUnsubscribe", "getAfterSelectableUnsubscribe$foundation_release", "setAfterSelectableUnsubscribe$foundation_release", "Landroidx/collection/LongObjectMap;", "Landroidx/compose/foundation/text/selection/Selection;", "<set-?>", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "getSubselections", "()Landroidx/collection/LongObjectMap;", "setSubselections", "(Landroidx/collection/LongObjectMap;)V", "subselections", "getSelectables$foundation_release", "()Ljava/util/List;", "selectables", "getSelectableMap$foundation_release", "selectableMap", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionRegistrarImpl implements SelectionRegistrar {
    private final MutableLongObjectMap<Selectable> _selectableMap;
    private final List<Selectable> _selectables;
    private k afterSelectableUnsubscribe;
    private AtomicLong incrementId;
    private k onPositionChangeCallback;
    private k onSelectableChangeCallback;
    private r onSelectionUpdateCallback;
    private S7.a onSelectionUpdateEndCallback;
    private n onSelectionUpdateSelectAll;
    private p onSelectionUpdateStartCallback;
    private boolean sorted;

    /* renamed from: subselections$delegate, reason: from kotlin metadata */
    private final MutableState subselections;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Saver<SelectionRegistrarImpl, Long> Saver = SaverKt.Saver(new n() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$1
        @Override // S7.n
        public final Long invoke(SaverScope saverScope, SelectionRegistrarImpl selectionRegistrarImpl) {
            return Long.valueOf(selectionRegistrarImpl.incrementId.get());
        }
    }, new k() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }

        public final SelectionRegistrarImpl invoke(long j5) {
            return new SelectionRegistrarImpl(j5, null);
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<SelectionRegistrarImpl, Long> getSaver() {
            return SelectionRegistrarImpl.Saver;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SelectionRegistrarImpl(long j5, e eVar) {
        this(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$2(n nVar, Object obj, Object obj2) {
        return ((Number) nVar.invoke(obj, obj2)).intValue();
    }

    /* renamed from: getAfterSelectableUnsubscribe$foundation_release, reason: from getter */
    public final k getAfterSelectableUnsubscribe() {
        return this.afterSelectableUnsubscribe;
    }

    /* renamed from: getOnPositionChangeCallback$foundation_release, reason: from getter */
    public final k getOnPositionChangeCallback() {
        return this.onPositionChangeCallback;
    }

    /* renamed from: getOnSelectableChangeCallback$foundation_release, reason: from getter */
    public final k getOnSelectableChangeCallback() {
        return this.onSelectableChangeCallback;
    }

    /* renamed from: getOnSelectionUpdateCallback$foundation_release, reason: from getter */
    public final r getOnSelectionUpdateCallback() {
        return this.onSelectionUpdateCallback;
    }

    /* renamed from: getOnSelectionUpdateEndCallback$foundation_release, reason: from getter */
    public final S7.a getOnSelectionUpdateEndCallback() {
        return this.onSelectionUpdateEndCallback;
    }

    /* renamed from: getOnSelectionUpdateSelectAll$foundation_release, reason: from getter */
    public final n getOnSelectionUpdateSelectAll() {
        return this.onSelectionUpdateSelectAll;
    }

    /* renamed from: getOnSelectionUpdateStartCallback$foundation_release, reason: from getter */
    public final p getOnSelectionUpdateStartCallback() {
        return this.onSelectionUpdateStartCallback;
    }

    public final LongObjectMap<Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    /* renamed from: getSorted$foundation_release, reason: from getter */
    public final boolean getSorted() {
        return this.sorted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public LongObjectMap<Selection> getSubselections() {
        return (LongObjectMap) this.subselections.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long andIncrement = this.incrementId.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.incrementId.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long selectableId) {
        this.sorted = false;
        k kVar = this.onPositionChangeCallback;
        if (kVar != null) {
            kVar.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long selectableId) {
        k kVar = this.onSelectableChangeCallback;
        if (kVar != null) {
            kVar.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* renamed from: notifySelectionUpdate-njBpvok */
    public boolean mo1443notifySelectionUpdatenjBpvok(LayoutCoordinates layoutCoordinates, long newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment adjustment, boolean isInTouchMode) {
        r rVar = this.onSelectionUpdateCallback;
        if (rVar != null) {
            return ((Boolean) rVar.invoke(Boolean.valueOf(isInTouchMode), layoutCoordinates, Offset.m3884boximpl(newPosition), Offset.m3884boximpl(previousPosition), Boolean.valueOf(isStartHandle), adjustment)).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        S7.a aVar = this.onSelectionUpdateEndCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long selectableId, boolean isInTouchMode) {
        n nVar = this.onSelectionUpdateSelectAll;
        if (nVar != null) {
            nVar.invoke(Boolean.valueOf(isInTouchMode), Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* renamed from: notifySelectionUpdateStart-ubNVwUQ */
    public void mo1444notifySelectionUpdateStartubNVwUQ(LayoutCoordinates layoutCoordinates, long startPosition, SelectionAdjustment adjustment, boolean isInTouchMode) {
        p pVar = this.onSelectionUpdateStartCallback;
        if (pVar != null) {
            pVar.invoke(Boolean.valueOf(isInTouchMode), layoutCoordinates, Offset.m3884boximpl(startPosition), adjustment);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(k kVar) {
        this.afterSelectableUnsubscribe = kVar;
    }

    public final void setOnPositionChangeCallback$foundation_release(k kVar) {
        this.onPositionChangeCallback = kVar;
    }

    public final void setOnSelectableChangeCallback$foundation_release(k kVar) {
        this.onSelectableChangeCallback = kVar;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(r rVar) {
        this.onSelectionUpdateCallback = rVar;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(S7.a aVar) {
        this.onSelectionUpdateEndCallback = aVar;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(n nVar) {
        this.onSelectionUpdateSelectAll = nVar;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(p pVar) {
        this.onSelectionUpdateStartCallback = pVar;
    }

    public final void setSorted$foundation_release(boolean z10) {
        this.sorted = z10;
    }

    public void setSubselections(LongObjectMap<Selection> longObjectMap) {
        this.subselections.setValue(longObjectMap);
    }

    public final List<Selectable> sort(final LayoutCoordinates containerLayoutCoordinates) {
        if (!this.sorted) {
            z.d0(new b(new n() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl.sort.1
                {
                    super(2);
                }

                @Override // S7.n
                public final Integer invoke(Selectable selectable, Selectable selectable2) {
                    LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
                    LayoutCoordinates layoutCoordinates2 = selectable2.getLayoutCoordinates();
                    long jMo5558localPositionOfR5De75A = layoutCoordinates != null ? containerLayoutCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m3911getZeroF1C5BW0()) : Offset.INSTANCE.m3911getZeroF1C5BW0();
                    long jMo5558localPositionOfR5De75A2 = layoutCoordinates2 != null ? containerLayoutCoordinates.mo5558localPositionOfR5De75A(layoutCoordinates2, Offset.INSTANCE.m3911getZeroF1C5BW0()) : Offset.INSTANCE.m3911getZeroF1C5BW0();
                    return Integer.valueOf(Offset.m3896getYimpl(jMo5558localPositionOfR5De75A) == Offset.m3896getYimpl(jMo5558localPositionOfR5De75A2) ? j.m(Float.valueOf(Offset.m3895getXimpl(jMo5558localPositionOfR5De75A)), Float.valueOf(Offset.m3895getXimpl(jMo5558localPositionOfR5De75A2))) : j.m(Float.valueOf(Offset.m3896getYimpl(jMo5558localPositionOfR5De75A)), Float.valueOf(Offset.m3896getYimpl(jMo5558localPositionOfR5De75A2))));
                }
            }, 0), this._selectables);
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public Selectable subscribe(Selectable selectable) {
        if (selectable.getSelectableId() == 0) {
            throw new IllegalArgumentException(("The selectable contains an invalid id: " + selectable.getSelectableId()).toString());
        }
        if (this._selectableMap.containsKey(selectable.getSelectableId())) {
            throw new IllegalArgumentException(("Another selectable with the id: " + selectable + ".selectableId has already subscribed.").toString());
        }
        this._selectableMap.set(selectable.getSelectableId(), selectable);
        this._selectables.add(selectable);
        this.sorted = false;
        return selectable;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(Selectable selectable) {
        if (this._selectableMap.containsKey(selectable.getSelectableId())) {
            this._selectables.remove(selectable);
            this._selectableMap.remove(selectable.getSelectableId());
            k kVar = this.afterSelectableUnsubscribe;
            if (kVar != null) {
                kVar.invoke(Long.valueOf(selectable.getSelectableId()));
            }
        }
    }

    private SelectionRegistrarImpl(long j5) {
        this._selectables = new ArrayList();
        this._selectableMap = LongObjectMapKt.mutableLongObjectMapOf();
        this.incrementId = new AtomicLong(j5);
        this.subselections = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LongObjectMapKt.emptyLongObjectMap(), null, 2, null);
    }

    public SelectionRegistrarImpl() {
        this(1L);
    }
}
