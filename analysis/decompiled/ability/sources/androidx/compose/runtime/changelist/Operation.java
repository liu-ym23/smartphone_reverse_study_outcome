package androidx.compose.runtime.changelist;

import C7.r;
import S7.n;
import S7.o;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.System_jvmKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLB\u001d\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u0011\u001a\u00020\u0010*\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0016\u001a\u00020\u0010*\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH$¢\u0006\u0004\b\u0016\u0010\u0012J\u001b\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u00060\u0002j\u0002`\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b$\u0010#R\u0011\u0010&\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b%\u0010 \u0082\u0001%MNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopq¨\u0006r"}, d2 = {"Landroidx/compose/runtime/changelist/Operation;", "", "", "ints", "objects", AppAgent.CONSTRUCT, "(II)V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "executeWithComposeStackTrace", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/Anchor;", "getGroupAnchor", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/SlotWriter;)Landroidx/compose/runtime/Anchor;", "execute", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "toString", "()Ljava/lang/String;", "I", "getInts", "()I", "getObjects", "getName", HintConstants.AUTOFILL_HINT_NAME, "ObjectParameter", "Ups", "Downs", "AdvanceSlotsBy", "SideEffect", "Remember", "RememberPausingScope", "StartResumingScope", "EndResumingScope", "AppendValue", "TrimParentValues", "UpdateValue", "UpdateAnchoredValue", "UpdateAuxData", "EnsureRootGroupStarted", "EnsureGroupStarted", "RemoveCurrentGroup", "MoveCurrentGroup", "EndCurrentGroup", "SkipToEndOfCurrentGroup", "EndCompositionScope", "UseCurrentNode", "UpdateNode", "RemoveNode", "MoveNode", "InsertSlots", "InsertSlotsWithFixups", "InsertNodeFixup", "PostInsertNodeFixup", "DeactivateCurrentGroup", "ResetSlots", "DetermineMovableContentNodeIndex", "CopyNodesToNewAnchorLocation", "CopySlotTableToAnchorLocation", "EndMovableContentPlacement", "ReleaseMovableGroupAtCurrent", "ApplyChangeList", "TestOperation", "Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation$EndResumingScope;", "Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation$RememberPausingScope;", "Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$StartResumingScope;", "Landroidx/compose/runtime/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Operation {
    public static final int $stable = 0;
    private final int ints;
    private final int objects;

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getDistance", "()I", "Distance", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AdvanceSlotsBy extends Operation {
        public static final int $stable = 0;
        public static final AdvanceSlotsBy INSTANCE = new AdvanceSlotsBy();

        private AdvanceSlotsBy() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.advanceBy(operationArgContainer.getInt(0));
        }

        public final int getDistance() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "distance" : super.intParamName(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Anchor", "", "getValue-HpuvwBQ", "Value", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AppendValue extends Operation {
        public static final int $stable = 0;
        public static final AppendValue INSTANCE = new AppendValue();

        private AppendValue() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            Object objMo3532getObject31yXWZQ = operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            if (objMo3532getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering((RememberObserverHolder) objMo3532getObject31yXWZQ);
            }
            slotWriter.appendSlot(anchor, objMo3532getObject31yXWZQ);
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3487getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m3488getValueHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "anchor" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "value" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/changelist/ChangeList;", "getChanges-HpuvwBQ", "()I", "Changes", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-HpuvwBQ", "EffectiveNodeIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ApplyChangeList extends Operation {
        public static final int $stable = 0;
        public static final ApplyChangeList INSTANCE = new ApplyChangeList();

        private ApplyChangeList() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            IntRef intRef = (IntRef) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            int element = intRef != null ? intRef.getElement() : 0;
            ChangeList changeList = (ChangeList) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            if (element > 0) {
                applier = new OffsetApplier(applier, element);
            }
            changeList.executeAndFlushAllPendingChanges(applier, slotWriter, rememberManager, operationErrorContext != null ? OperationKt.withCurrentStackTrace(operationErrorContext, slotWriter) : null);
        }

        /* renamed from: getChanges-HpuvwBQ, reason: not valid java name */
        public final int m3489getChangesHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getEffectiveNodeIndex-HpuvwBQ, reason: not valid java name */
        public final int m3490getEffectiveNodeIndexHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "changes" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "effectiveNodeIndex" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-HpuvwBQ", "()I", "EffectiveNodeIndex", "", "", "getNodes-HpuvwBQ", "Nodes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CopyNodesToNewAnchorLocation extends Operation {
        public static final int $stable = 0;
        public static final CopyNodesToNewAnchorLocation INSTANCE = new CopyNodesToNewAnchorLocation();

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            int element = ((IntRef) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0))).getElement();
            List list = (List) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i6 = element + i;
                applier.insertBottomUp(i6, obj);
                applier.insertTopDown(i6, obj);
            }
        }

        /* renamed from: getEffectiveNodeIndex-HpuvwBQ, reason: not valid java name */
        public final int m3491getEffectiveNodeIndexHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getNodes-HpuvwBQ, reason: not valid java name */
        public final int m3492getNodesHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "effectiveNodeIndex" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "nodes" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u0018¨\u0006\""}, d2 = {"Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/MovableContentState;", "getResolvedState-HpuvwBQ", "()I", "ResolvedState", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-HpuvwBQ", "ParentCompositionContext", "Landroidx/compose/runtime/MovableContentStateReference;", "getFrom-HpuvwBQ", "From", "getTo-HpuvwBQ", "To", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CopySlotTableToAnchorLocation extends Operation {
        public static final int $stable = 0;
        public static final CopySlotTableToAnchorLocation INSTANCE = new CopySlotTableToAnchorLocation();

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(2));
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(3));
            CompositionContext compositionContext = (CompositionContext) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            MovableContentState movableContentStateMovableContentStateResolve$runtime = (MovableContentState) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            if (movableContentStateMovableContentStateResolve$runtime == null && (movableContentStateMovableContentStateResolve$runtime = compositionContext.movableContentStateResolve$runtime(movableContentStateReference)) == null) {
                ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                throw new KotlinNothingValueException();
            }
            List<Anchor> listMoveIntoGroupFrom = slotWriter.moveIntoGroupFrom(1, movableContentStateMovableContentStateResolve$runtime.getSlotTable(), 2);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.INSTANCE;
            ControlledComposition composition = movableContentStateReference2.getComposition();
            k.d(composition, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            companion.adoptAnchoredScopes$runtime(slotWriter, listMoveIntoGroupFrom, (RecomposeScopeOwner) composition);
        }

        /* renamed from: getFrom-HpuvwBQ, reason: not valid java name */
        public final int m3493getFromHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(2);
        }

        /* renamed from: getParentCompositionContext-HpuvwBQ, reason: not valid java name */
        public final int m3494getParentCompositionContextHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        /* renamed from: getResolvedState-HpuvwBQ, reason: not valid java name */
        public final int m3495getResolvedStateHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getTo-HpuvwBQ, reason: not valid java name */
        public final int m3496getToHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "resolvedState" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "resolvedCompositionContext" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(2)) ? TypedValues.TransitionType.S_FROM : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(3)) ? TypedValues.TransitionType.S_TO : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DeactivateCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final DeactivateCurrentGroup INSTANCE = new DeactivateCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private DeactivateCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            ComposerKt.deactivateCurrentGroup(slotWriter, rememberManager);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndexOut-HpuvwBQ", "()I", "EffectiveNodeIndexOut", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "Anchor", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DetermineMovableContentNodeIndex extends Operation {
        public static final int $stable = 0;
        public static final DetermineMovableContentNodeIndex INSTANCE = new DetermineMovableContentNodeIndex();

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            IntRef intRef = (IntRef) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            intRef.setElement(OperationKt.positionToInsert(slotWriter, anchor, applier));
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3497getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        /* renamed from: getEffectiveNodeIndexOut-HpuvwBQ, reason: not valid java name */
        public final int m3498getEffectiveNodeIndexOutHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "effectiveNodeIndexOut" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "anchor" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "", "getNodes-HpuvwBQ", "()I", "Nodes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Downs extends Operation {
        public static final int $stable = 0;
        public static final Downs INSTANCE = new Downs();

        /* JADX WARN: Illegal instructions before constructor call */
        private Downs() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0))) {
                applier.down(obj);
            }
        }

        /* renamed from: getNodes-HpuvwBQ, reason: not valid java name */
        public final int m3499getNodesHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "nodes" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "getAction-HpuvwBQ", "()I", "Action", "getComposition-HpuvwBQ", "Composition", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EndCompositionScope extends Operation {
        public static final int $stable = 0;
        public static final EndCompositionScope INSTANCE = new EndCompositionScope();

        private EndCompositionScope() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            ((S7.k) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0))).invoke((Composition) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1)));
        }

        /* renamed from: getAction-HpuvwBQ, reason: not valid java name */
        public final int m3500getActionHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getComposition-HpuvwBQ, reason: not valid java name */
        public final int m3501getCompositionHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "anchor" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "composition" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EndCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final EndCurrentGroup INSTANCE = new EndCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.endGroup();
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EndMovableContentPlacement extends Operation {
        public static final int $stable = 0;
        public static final EndMovableContentPlacement INSTANCE = new EndMovableContentPlacement();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndMovableContentPlacement() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.positionToParentOf(slotWriter, applier, 0);
            slotWriter.endGroup();
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndResumingScope;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-HpuvwBQ", "()I", "Scope", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EndResumingScope extends Operation {
        public static final int $stable = 0;
        public static final EndResumingScope INSTANCE = new EndResumingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private EndResumingScope() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            rememberManager.endResumingScope((RecomposeScopeImpl) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getScope-HpuvwBQ, reason: not valid java name */
        public final int m3502getScopeHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "scope" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Anchor", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnsureGroupStarted extends Operation {
        public static final int $stable = 0;
        public static final EnsureGroupStarted INSTANCE = new EnsureGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureGroupStarted() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.ensureStarted((Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3503getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "anchor" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnsureRootGroupStarted extends Operation {
        public static final int $stable = 0;
        public static final EnsureRootGroupStarted INSTANCE = new EnsureRootGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        private EnsureRootGroupStarted() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.ensureStarted(0);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u001a\u001a\u00020\u0019*\u00020\r2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c0\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010\"\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b#\u0010\u001f¨\u0006%"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/Anchor;", "getGroupAnchor", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/SlotWriter;)Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Lkotlin/Function0;", "", "getFactory-HpuvwBQ", "()I", "Factory", "getInsertIndex", "InsertIndex", "getGroupAnchor-HpuvwBQ", "GroupAnchor", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InsertNodeFixup extends Operation {
        public static final int $stable = 0;
        public static final InsertNodeFixup INSTANCE = new InsertNodeFixup();

        private InsertNodeFixup() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            Object objInvoke = ((S7.a) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0))).invoke();
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            int i = operationArgContainer.getInt(0);
            k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            slotWriter.updateNode(anchor, objInvoke);
            applier.insertTopDown(i, objInvoke);
            applier.down(objInvoke);
        }

        /* renamed from: getFactory-HpuvwBQ, reason: not valid java name */
        public final int m3504getFactoryHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public Anchor getGroupAnchor(OperationArgContainer operationArgContainer, SlotWriter slotWriter) {
            return (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
        }

        /* renamed from: getGroupAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3505getGroupAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        public final int getInsertIndex() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "insertIndex" : super.intParamName(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "factory" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "groupAnchor" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Anchor", "Landroidx/compose/runtime/SlotTable;", "getFromSlotTable-HpuvwBQ", "FromSlotTable", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InsertSlots extends Operation {
        public static final int $stable = 0;
        public static final InsertSlots INSTANCE = new InsertSlots();

        private InsertSlots() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            SlotTable slotTable = (SlotTable) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            slotWriter.beginInsert();
            slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
            slotWriter.endInsert();
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3506getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getFromSlotTable-HpuvwBQ, reason: not valid java name */
        public final int m3507getFromSlotTableHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "anchor" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? TypedValues.TransitionType.S_FROM : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Anchor", "Landroidx/compose/runtime/SlotTable;", "getFromSlotTable-HpuvwBQ", "FromSlotTable", "Landroidx/compose/runtime/changelist/FixupList;", "getFixups-HpuvwBQ", "Fixups", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InsertSlotsWithFixups extends Operation {
        public static final int $stable = 0;
        public static final InsertSlotsWithFixups INSTANCE = new InsertSlotsWithFixups();

        private InsertSlotsWithFixups() {
            super(0, 3, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            OperationErrorContext operationErrorContextWithCurrentStackTrace;
            SlotTable slotTable = (SlotTable) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            FixupList fixupList = (FixupList) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(2));
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            if (operationErrorContext != null) {
                try {
                    operationErrorContextWithCurrentStackTrace = OperationKt.withCurrentStackTrace(operationErrorContext, slotWriter);
                } catch (Throwable th) {
                    slotWriterOpenWriter.close(false);
                    throw th;
                }
            } else {
                operationErrorContextWithCurrentStackTrace = null;
            }
            fixupList.executeAndFlushAllPendingFixups(applier, slotWriterOpenWriter, rememberManager, operationErrorContextWithCurrentStackTrace);
            slotWriterOpenWriter.close(true);
            slotWriter.beginInsert();
            slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
            slotWriter.endInsert();
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3508getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getFixups-HpuvwBQ, reason: not valid java name */
        public final int m3509getFixupsHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(2);
        }

        /* renamed from: getFromSlotTable-HpuvwBQ, reason: not valid java name */
        public final int m3510getFromSlotTableHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "anchor" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? TypedValues.TransitionType.S_FROM : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(2)) ? "fixups" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getOffset", "()I", "Offset", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final MoveCurrentGroup INSTANCE = new MoveCurrentGroup();

        private MoveCurrentGroup() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.moveGroup(operationArgContainer.getInt(0));
        }

        public final int getOffset() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? TypedValues.CycleType.S_WAVE_OFFSET : super.intParamName(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001c\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getFrom", "()I", "From", "getTo", "To", "getCount", "Count", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveNode extends Operation {
        public static final int $stable = 0;
        public static final MoveNode INSTANCE = new MoveNode();

        private MoveNode() {
            super(3, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            applier.move(operationArgContainer.getInt(0), operationArgContainer.getInt(1), operationArgContainer.getInt(2));
        }

        public final int getCount() {
            return 2;
        }

        public final int getFrom() {
            return 0;
        }

        public final int getTo() {
            return 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? TypedValues.TransitionType.S_FROM : parameter == 1 ? TypedValues.TransitionType.S_TO : parameter == 2 ? "count" : super.intParamName(parameter);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", ExifInterface.GPS_DIRECTION_TRUE, "", TypedValues.CycleType.S_WAVE_OFFSET, "", "constructor-impl", "(I)I", "getOffset", "()I", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObjectParameter<T> {
        private final int offset;

        private /* synthetic */ ObjectParameter(int i) {
            this.offset = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ ObjectParameter m3511boximpl(int i) {
            return new ObjectParameter(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static <T> int m3512constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m3513equalsimpl(int i, Object obj) {
            return (obj instanceof ObjectParameter) && i == ((ObjectParameter) obj).m3517unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3514equalsimpl0(int i, int i6) {
            return i == i6;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m3515hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m3516toStringimpl(int i) {
            return androidx.appfunctions.metadata.a.k("ObjectParameter(offset=", i, ')');
        }

        public boolean equals(Object other) {
            return m3513equalsimpl(this.offset, other);
        }

        public final int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return m3515hashCodeimpl(this.offset);
        }

        public String toString() {
            return m3516toStringimpl(this.offset);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m3517unboximpl() {
            return this.offset;
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u001a\u001a\u00020\u0019*\u00020\r2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/Anchor;", "getGroupAnchor", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/SlotWriter;)Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getInsertIndex", "()I", "InsertIndex", "getGroupAnchor-HpuvwBQ", "GroupAnchor", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PostInsertNodeFixup extends Operation {
        public static final int $stable = 0;
        public static final PostInsertNodeFixup INSTANCE = new PostInsertNodeFixup();

        /* JADX WARN: Illegal instructions before constructor call */
        private PostInsertNodeFixup() {
            int i = 1;
            super(i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            int i = operationArgContainer.getInt(0);
            applier.up();
            applier.insertBottomUp(i, slotWriter.node(anchor));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public Anchor getGroupAnchor(OperationArgContainer operationArgContainer, SlotWriter slotWriter) {
            return (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
        }

        /* renamed from: getGroupAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3518getGroupAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        public final int getInsertIndex() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "insertIndex" : super.intParamName(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "groupAnchor" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/ControlledComposition;", "getComposition-HpuvwBQ", "()I", "Composition", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-HpuvwBQ", "ParentCompositionContext", "Landroidx/compose/runtime/MovableContentStateReference;", "getReference-HpuvwBQ", "Reference", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ReleaseMovableGroupAtCurrent extends Operation {
        public static final int $stable = 0;
        public static final ReleaseMovableGroupAtCurrent INSTANCE = new ReleaseMovableGroupAtCurrent();

        private ReleaseMovableGroupAtCurrent() {
            super(0, 3, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            ControlledComposition controlledComposition = (ControlledComposition) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(2));
            ((CompositionContext) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1))).movableContentStateReleased$runtime(movableContentStateReference, ComposerKt.extractMovableContentAtCurrent(controlledComposition, movableContentStateReference, slotWriter, null), applier);
        }

        /* renamed from: getComposition-HpuvwBQ, reason: not valid java name */
        public final int m3519getCompositionHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        /* renamed from: getParentCompositionContext-HpuvwBQ, reason: not valid java name */
        public final int m3520getParentCompositionContextHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        /* renamed from: getReference-HpuvwBQ, reason: not valid java name */
        public final int m3521getReferenceHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "composition" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "parentCompositionContext" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(2)) ? TypedValues.Custom.S_REFERENCE : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/RememberObserverHolder;", "getValue-HpuvwBQ", "()I", "Value", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Remember extends Operation {
        public static final int $stable = 0;
        public static final Remember INSTANCE = new Remember();

        /* JADX WARN: Illegal instructions before constructor call */
        private Remember() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            rememberManager.remembering((RememberObserverHolder) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m3522getValueHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "value" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$RememberPausingScope;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-HpuvwBQ", "()I", "Scope", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RememberPausingScope extends Operation {
        public static final int $stable = 0;
        public static final RememberPausingScope INSTANCE = new RememberPausingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private RememberPausingScope() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            rememberManager.rememberPausingScope((RecomposeScopeImpl) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getScope-HpuvwBQ, reason: not valid java name */
        public final int m3523getScopeHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "scope" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RemoveCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final RemoveCurrentGroup INSTANCE = new RemoveCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            ComposerKt.removeCurrentGroup(slotWriter, rememberManager);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getRemoveIndex", "()I", "RemoveIndex", "getCount", "Count", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RemoveNode extends Operation {
        public static final int $stable = 0;
        public static final RemoveNode INSTANCE = new RemoveNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private RemoveNode() {
            int i = 2;
            super(i, 0, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            applier.remove(operationArgContainer.getInt(0), operationArgContainer.getInt(1));
        }

        public final int getCount() {
            return 1;
        }

        public final int getRemoveIndex() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "removeIndex" : parameter == 1 ? "count" : super.intParamName(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ResetSlots extends Operation {
        public static final int $stable = 0;
        public static final ResetSlots INSTANCE = new ResetSlots();

        /* JADX WARN: Illegal instructions before constructor call */
        private ResetSlots() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.reset();
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Lkotlin/Function0;", "getEffect-HpuvwBQ", "()I", "Effect", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SideEffect extends Operation {
        public static final int $stable = 0;
        public static final SideEffect INSTANCE = new SideEffect();

        /* JADX WARN: Illegal instructions before constructor call */
        private SideEffect() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            rememberManager.sideEffect((S7.a) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getEffect-HpuvwBQ, reason: not valid java name */
        public final int m3524getEffectHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "effect" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SkipToEndOfCurrentGroup extends Operation {
        public static final int $stable = 0;
        public static final SkipToEndOfCurrentGroup INSTANCE = new SkipToEndOfCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        private SkipToEndOfCurrentGroup() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.skipToGroupEnd();
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$StartResumingScope;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getScope-HpuvwBQ", "()I", "Scope", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StartResumingScope extends Operation {
        public static final int $stable = 0;
        public static final StartResumingScope INSTANCE = new StartResumingScope();

        /* JADX WARN: Illegal instructions before constructor call */
        private StartResumingScope() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            rememberManager.startResumingScope((RecomposeScopeImpl) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getScope-HpuvwBQ, reason: not valid java name */
        public final int m3525getScopeHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "scope" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0013\u001a\u00020\t*\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R3\u0010\n\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0006¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR%\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"0\u001b8\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/changelist/Operation;", "", "ints", "objects", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Landroidx/compose/runtime/SlotWriter;", "Landroidx/compose/runtime/RememberManager;", "LC7/r;", "block", AppAgent.CONSTRUCT, "(IILS7/o;)V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "slots", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "toString", "()Ljava/lang/String;", "LS7/o;", "getBlock", "()LS7/o;", "", "intParams", "Ljava/util/List;", "getIntParams", "()Ljava/util/List;", "getIntParams$annotations", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "", "objParams", "getObjParams", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TestOperation extends Operation {
        public static final int $stable = 8;
        private final o block;
        private final List<Integer> intParams;
        private final List<ObjectParameter<Object>> objParams;

        public TestOperation() {
            this(0, 0, null, 7, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r _init_$lambda$0(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
            return r.f317a;
        }

        public static /* synthetic */ void getIntParams$annotations() {
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            this.block.invoke(applier, slotWriter, rememberManager);
        }

        public final o getBlock() {
            return this.block;
        }

        public final List<Integer> getIntParams() {
            return this.intParams;
        }

        public final List<ObjectParameter<Object>> getObjParams() {
            return this.objParams;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String toString() {
            return "TestOperation(ints = " + getInts() + ", objects = " + getObjects() + ")@" + System_jvmKt.identityHashCode(this);
        }

        public /* synthetic */ TestOperation(int i, int i6, o oVar, int i10, e eVar) {
            this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i6, (i10 & 4) != 0 ? new a(0) : oVar);
        }

        public TestOperation(int i, int i6, o oVar) {
            super(i, i6, null);
            this.block = oVar;
            ArrayList arrayList = new ArrayList(i);
            for (int i10 = 0; i10 < i; i10++) {
                arrayList.add(Integer.valueOf(i10));
            }
            this.intParams = arrayList;
            ArrayList arrayList2 = new ArrayList(i6);
            for (int i11 = 0; i11 < i6; i11++) {
                arrayList2.add(ObjectParameter.m3511boximpl(ObjectParameter.m3512constructorimpl(i11)));
            }
            this.objParams = arrayList2;
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getCount", "()I", "Count", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TrimParentValues extends Operation {
        public static final int $stable = 0;
        public static final TrimParentValues INSTANCE = new TrimParentValues();

        private TrimParentValues() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            int i = operationArgContainer.getInt(0);
            int parent = slotWriter.getParent();
            int iSlotsStartIndex$runtime = slotWriter.slotsStartIndex$runtime(parent);
            int iSlotsEndIndex$runtime = slotWriter.slotsEndIndex$runtime(parent);
            for (int iMax = Math.max(iSlotsStartIndex$runtime, iSlotsEndIndex$runtime - i); iMax < iSlotsEndIndex$runtime; iMax++) {
                Object obj = slotWriter.slots[slotWriter.dataIndexToDataAddress(iMax)];
                if (obj instanceof RememberObserverHolder) {
                    rememberManager.forgetting((RememberObserverHolder) obj);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            slotWriter.trimTailSlots(i);
        }

        public final int getCount() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "count" : super.intParamName(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u000b\u0010\tJ9\u0010\u0017\u001a\u00020\u0016*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u0012\u0010!\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u001b¨\u0006\""}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "getValue-HpuvwBQ", "()I", "Value", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "Anchor", "getGroupSlotIndex", "GroupSlotIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UpdateAnchoredValue extends Operation {
        public static final int $stable = 0;
        public static final UpdateAnchoredValue INSTANCE = new UpdateAnchoredValue();

        private UpdateAnchoredValue() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            Object objMo3532getObject31yXWZQ = operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1));
            int i = operationArgContainer.getInt(0);
            if (objMo3532getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering((RememberObserverHolder) objMo3532getObject31yXWZQ);
            }
            Object obj = slotWriter.set(slotWriter.anchorIndex(anchor), i, objMo3532getObject31yXWZQ);
            if (obj instanceof RememberObserverHolder) {
                rememberManager.forgetting((RememberObserverHolder) obj);
            } else if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }

        /* renamed from: getAnchor-HpuvwBQ, reason: not valid java name */
        public final int m3526getAnchorHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        public final int getGroupSlotIndex() {
            return 0;
        }

        /* renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m3527getValueHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "groupSlotIndex" : super.intParamName(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "value" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "anchor" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "getData-HpuvwBQ", "()I", "Data", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UpdateAuxData extends Operation {
        public static final int $stable = 0;
        public static final UpdateAuxData INSTANCE = new UpdateAuxData();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateAuxData() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            slotWriter.updateAux(operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getData-HpuvwBQ, reason: not valid java name */
        public final int m3528getDataHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? SettingsConfig.KEY_DATA : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u001c\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00130\u001a0\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", "", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "getValue-HpuvwBQ", "()I", "Value", "Lkotlin/Function2;", "getBlock-HpuvwBQ", "Block", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UpdateNode extends Operation {
        public static final int $stable = 0;
        public static final UpdateNode INSTANCE = new UpdateNode();

        private UpdateNode() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            applier.apply((n) operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(1)), operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0)));
        }

        /* renamed from: getBlock-HpuvwBQ, reason: not valid java name */
        public final int m3529getBlockHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(1);
        }

        /* renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m3530getValueHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "value" : ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(1)) ? "block" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0004\b\u000b\u0010\tJ9\u0010\u0017\u001a\u00020\u0016*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001e\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "getValue-HpuvwBQ", "()I", "Value", "getGroupSlotIndex", "GroupSlotIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UpdateValue extends Operation {
        public static final int $stable = 0;
        public static final UpdateValue INSTANCE = new UpdateValue();

        /* JADX WARN: Illegal instructions before constructor call */
        private UpdateValue() {
            int i = 1;
            super(i, i, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            Object objMo3532getObject31yXWZQ = operationArgContainer.mo3532getObject31yXWZQ(ObjectParameter.m3512constructorimpl(0));
            int i = operationArgContainer.getInt(0);
            if (objMo3532getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering((RememberObserverHolder) objMo3532getObject31yXWZQ);
            }
            Object obj = slotWriter.set(slotWriter.getCurrentGroup(), i, objMo3532getObject31yXWZQ);
            if (obj instanceof RememberObserverHolder) {
                rememberManager.forgetting((RememberObserverHolder) obj);
            } else if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }

        public final int getGroupSlotIndex() {
            return 0;
        }

        /* renamed from: getValue-HpuvwBQ, reason: not valid java name */
        public final int m3531getValueHpuvwBQ() {
            return ObjectParameter.m3512constructorimpl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "groupSlotIndex" : super.intParamName(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo3486objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m3514equalsimpl0(parameter, ObjectParameter.m3512constructorimpl(0)) ? "value" : super.mo3486objectParamName31yXWZQ(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ9\u0010\u0014\u001a\u00020\u0013*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "", "intParamName", "(I)Ljava/lang/String;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "getCount", "()I", "Count", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Ups extends Operation {
        public static final int $stable = 0;
        public static final Ups INSTANCE = new Ups();

        private Ups() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            int i = operationArgContainer.getInt(0);
            for (int i6 = 0; i6 < i; i6++) {
                applier.up();
            }
        }

        public final int getCount() {
            return 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName(int parameter) {
            return parameter == 0 ? "count" : super.intParamName(parameter);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000e\u001a\u00020\r*\u00020\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "Landroidx/compose/runtime/changelist/Operation;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "LC7/r;", "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UseCurrentNode extends Operation {
        public static final int $stable = 0;
        public static final UseCurrentNode INSTANCE = new UseCurrentNode();

        /* JADX WARN: Illegal instructions before constructor call */
        private UseCurrentNode() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
            applier.reuse();
        }
    }

    public /* synthetic */ Operation(int i, int i6, e eVar) {
        this(i, i6);
    }

    public abstract void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext);

    public final void executeWithComposeStackTrace(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager, OperationErrorContext operationErrorContext) {
        Anchor groupAnchor = getGroupAnchor(operationArgContainer, slotWriter);
        try {
            execute(operationArgContainer, applier, slotWriter, rememberManager, operationErrorContext);
        } catch (Throwable th) {
            throw OperationKt.attachComposeStackTrace(th, operationErrorContext, slotWriter, groupAnchor);
        }
    }

    public Anchor getGroupAnchor(OperationArgContainer operationArgContainer, SlotWriter slotWriter) {
        return null;
    }

    public final int getInts() {
        return this.ints;
    }

    public final String getName() {
        String strM = m.f4928a.b(getClass()).m();
        return strM == null ? "" : strM;
    }

    public final int getObjects() {
        return this.objects;
    }

    public String intParamName(int parameter) {
        return androidx.appfunctions.metadata.a.k("IntParameter(", parameter, ')');
    }

    /* renamed from: objectParamName-31yXWZQ, reason: not valid java name */
    public String mo3486objectParamName31yXWZQ(int parameter) {
        return androidx.appfunctions.metadata.a.k("ObjectParameter(", parameter, ')');
    }

    public String toString() {
        return getName();
    }

    private Operation(int i, int i6) {
        this.ints = i;
        this.objects = i6;
    }

    public /* synthetic */ Operation(int i, int i6, int i10, e eVar) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i6, null);
    }
}
