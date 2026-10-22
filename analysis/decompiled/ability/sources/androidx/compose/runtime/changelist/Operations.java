package androidx.compose.runtime.changelist;

import C7.c;
import D7.q;
import D7.s;
import D7.v;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001:\u0002deB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ9\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000fH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u000e\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0003J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u001a\u001a\u00020\b2\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0018R\u00020\u0000\u0012\u0004\u0012\u00020\b0\u000fH\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u001d\u001a\u00020\b2\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0018R\u00020\u0000\u0012\u0004\u0012\u00020\b0\u000fH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001bJ3\u0010&\u001a\u00020\b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u0010\u0003J\u0018\u00104\u001a\u00020\b2\u0006\u00100\u001a\u00020.H\u0082\b¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u00020\b2\u0006\u00100\u001a\u00020.H\u0082\b¢\u0006\u0004\b8\u00105J\u001f\u00109\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002¢\u0006\u0004\b9\u00107J\u0017\u0010:\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b<\u0010;J\u0018\u0010>\u001a\u00020.2\u0006\u0010=\u001a\u00020.H\u0082\b¢\u0006\u0004\b>\u0010?J\u0013\u0010@\u001a\u00020(*\u00020(H\u0002¢\u0006\u0004\b@\u0010-J\u0010\u0010A\u001a\u00020\nH\u0082\b¢\u0006\u0004\bA\u0010BJ\u001c\u0010E\u001a\u00020.2\n\u0010D\u001a\u00060.j\u0002`CH\u0082\b¢\u0006\u0004\bE\u0010?J\u001c\u0010H\u001a\u00020.2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030FH\u0082\b¢\u0006\u0004\bG\u0010?J\u001f\u0010I\u001a\u00020(*\u00060\u0018R\u00020\u00002\u0006\u0010+\u001a\u00020(H\u0002¢\u0006\u0004\bI\u0010JJ\u001d\u0010L\u001a\u00020(*\u0004\u0018\u00010K2\u0006\u0010+\u001a\u00020(H\u0002¢\u0006\u0004\bL\u0010MJ'\u0010P\u001a\u00020(\"\u0004\b\u0000\u0010N*\b\u0012\u0004\u0012\u00028\u00000O2\u0006\u0010+\u001a\u00020(H\u0002¢\u0006\u0004\bP\u0010QR\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0R8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bS\u0010T\u0012\u0004\bU\u0010\u0003R\u0016\u0010V\u001a\u00020.8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020.8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b[\u0010WR\u001e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0R8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020.8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b^\u0010WR\u0016\u0010_\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010WR\u0016\u0010`\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010WR\u0011\u0010c\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006f"}, d2 = {"Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", AppAgent.CONSTRUCT, "()V", "", "isEmpty", "()Z", "isNotEmpty", "LC7/r;", "clear", "Landroidx/compose/runtime/changelist/Operation;", "operation", "pushOp", "(Landroidx/compose/runtime/changelist/Operation;)V", "push", "Lkotlin/Function1;", "Landroidx/compose/runtime/changelist/Operations$WriteScope;", "args", "(Landroidx/compose/runtime/changelist/Operation;LS7/k;)V", "ensureAllArgumentsPushedFor", "pop", "other", "popInto", "(Landroidx/compose/runtime/changelist/Operations;)V", "Landroidx/compose/runtime/changelist/Operations$OpIterator;", "sink", "drain", "(LS7/k;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "forEach", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "Landroidx/compose/runtime/changelist/OperationErrorContext;", "errorContext", "executeAndFlushAllPendingOperations", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;Landroidx/compose/runtime/changelist/OperationErrorContext;)V", "", "toString", "()Ljava/lang/String;", "linePrefix", "toDebugString", "(Ljava/lang/String;)Ljava/lang/String;", "", "currentSize", "requiredSize", "determineNewSize", "(II)I", "resizeOpCodes", "ensureIntArgsSizeAtLeast", "(I)V", "resizeIntArgs", "(II)V", "ensureObjectArgsSizeAtLeast", "resizeObjectArgs", "exceptionMessageForOperationPushNoScope", "(Landroidx/compose/runtime/changelist/Operation;)Ljava/lang/String;", "exceptionMessageForOperationPushWithScope", "paramCount", "createExpectedArgMask", "(I)I", "indent", "peekOperation", "()Landroidx/compose/runtime/changelist/Operation;", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "topIntIndexOf", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "topObjectIndexOf-31yXWZQ", "topObjectIndexOf", "currentOpToDebugString", "(Landroidx/compose/runtime/changelist/Operations$OpIterator;Ljava/lang/String;)Ljava/lang/String;", "", "formatOpArgumentToString", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "", "toCollectionString", "(Ljava/lang/Iterable;Ljava/lang/String;)Ljava/lang/String;", "", "opCodes", "[Landroidx/compose/runtime/changelist/Operation;", "getOpCodes$runtime$annotations", "opCodesSize", "I", "", "intArgs", "[I", "intArgsSize", "objectArgs", "[Ljava/lang/Object;", "objectArgsSize", "pushedIntMask", "pushedObjectMask", "getSize", "()I", "size", "WriteScope", "OpIterator", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Operations extends OperationsDebugStringFormattable {
    public static final int $stable = 8;
    public int intArgsSize;
    public int objectArgsSize;
    public int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;
    public Operation[] opCodes = new Operation[16];
    public int[] intArgs = new int[16];
    public Object[] objectArgs = new Object[16];

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000e\u001a\u00020\u00052\n\u0010\u000f\u001a\u00060\u0005j\u0002`\u0010H\u0016J#\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/changelist/Operations;)V", "opIdx", "", "intIdx", "objIdx", "next", "", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/changelist/IntParameter;", "getObject", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "getObject-31yXWZQ", "(I)Ljava/lang/Object;", "currentOperationDebugString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator() {
        }

        public final String currentOperationDebugString() {
            String str = "operation[" + this.opIdx + "] = " + Operations.this.currentOpToDebugString(this, "");
            k.e(str, "toString(...)");
            return str;
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public int getInt(int parameter) {
            return Operations.this.intArgs[this.intIdx + parameter];
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        /* renamed from: getObject-31yXWZQ */
        public <T> T mo3532getObject31yXWZQ(int parameter) {
            return (T) Operations.this.objectArgs[this.objIdx + parameter];
        }

        public final Operation getOperation() {
            return Operations.this.opCodes[this.opIdx];
        }

        public final boolean next() {
            if (this.opIdx >= Operations.this.opCodesSize) {
                return false;
            }
            Operation operation = getOperation();
            this.intIdx = operation.getInts() + this.intIdx;
            this.objIdx = operation.getObjects() + this.objIdx;
            int i = this.opIdx + 1;
            this.opIdx = i;
            return i < Operations.this.opCodesSize;
        }
    }

    private final int createExpectedArgMask(int paramCount) {
        return (paramCount == 0 ? 0 : -1) >>> (32 - paramCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String currentOpToDebugString(OpIterator opIterator, String str) {
        Operation operation = opIterator.getOperation();
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            return operation.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operation.getName());
        sb.append('(');
        String strIndent = indent(str);
        int ints = operation.getInts();
        boolean z10 = true;
        for (int i = 0; i < ints; i++) {
            String strIntParamName = operation.intParamName(i);
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            sb.append(strIndent);
            sb.append(strIntParamName);
            sb.append(" = ");
            sb.append(opIterator.getInt(i));
        }
        int objects = operation.getObjects();
        for (int i6 = 0; i6 < objects; i6++) {
            int iM3512constructorimpl = Operation.ObjectParameter.m3512constructorimpl(i6);
            String strMo3486objectParamName31yXWZQ = operation.mo3486objectParamName31yXWZQ(iM3512constructorimpl);
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append('\n');
            sb.append(strIndent);
            sb.append(strMo3486objectParamName31yXWZQ);
            sb.append(" = ");
            sb.append(formatOpArgumentToString(opIterator.mo3532getObject31yXWZQ(iM3512constructorimpl), strIndent));
        }
        sb.append('\n');
        sb.append(str);
        sb.append(")");
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    private final int determineNewSize(int currentSize, int requiredSize) {
        int i = currentSize + (currentSize <= 1024 ? currentSize : 1024);
        return i < requiredSize ? requiredSize : i;
    }

    private final void ensureIntArgsSizeAtLeast(int requiredSize) {
        int length = this.intArgs.length;
        if (requiredSize > length) {
            resizeIntArgs(length, requiredSize);
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int requiredSize) {
        int length = this.objectArgs.length;
        if (requiredSize > length) {
            resizeObjectArgs(length, requiredSize);
        }
    }

    private final String exceptionMessageForOperationPushNoScope(Operation operation) {
        return "Cannot push " + operation + " without arguments because it expects " + operation.getInts() + " ints and " + operation.getObjects() + " objects.";
    }

    private final String exceptionMessageForOperationPushWithScope(Operation operation) {
        StringBuilder sb = new StringBuilder();
        int ints = operation.getInts();
        int i = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & this.pushedIntMask) == 0) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(operation.intParamName(i6));
                i++;
            }
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        StringBuilder sb2 = new StringBuilder();
        int objects = operation.getObjects();
        int i10 = 0;
        for (int i11 = 0; i11 < objects; i11++) {
            if (((1 << i11) & this.pushedObjectMask) == 0) {
                if (i > 0) {
                    sb2.append(", ");
                }
                sb2.append(operation.mo3486objectParamName31yXWZQ(Operation.ObjectParameter.m3512constructorimpl(i11)));
                i10++;
            }
        }
        String string2 = sb2.toString();
        k.e(string2, "toString(...)");
        return "Error while pushing " + operation + ". Not all arguments were provided. Missing " + i + " int arguments (" + string + ") and " + i10 + " object arguments (" + string2 + ").";
    }

    private final String formatOpArgumentToString(Object obj, String str) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Object[]) {
            return toCollectionString(q.K((Object[]) obj), str);
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            return toCollectionString(iArr.length == 0 ? EmptyList.f4893a : new s(iArr, 1), str);
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            return toCollectionString(jArr.length == 0 ? EmptyList.f4893a : new s(jArr, 2), str);
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            return toCollectionString(fArr.length == 0 ? EmptyList.f4893a : new s(fArr, 3), str);
        }
        if (!(obj instanceof double[])) {
            return obj instanceof Iterable ? toCollectionString((Iterable) obj, str) : obj instanceof OperationsDebugStringFormattable ? ((OperationsDebugStringFormattable) obj).toDebugString(str) : obj.toString();
        }
        double[] dArr = (double[]) obj;
        return toCollectionString(dArr.length == 0 ? EmptyList.f4893a : new s(dArr, 4), str);
    }

    public static /* synthetic */ void getOpCodes$runtime$annotations() {
    }

    private final String indent(String str) {
        return androidx.appfunctions.metadata.a.l(str, "    ");
    }

    private final Operation peekOperation() {
        return this.opCodes[this.opCodesSize - 1];
    }

    private final void resizeIntArgs(int currentSize, int requiredSize) {
        int[] iArr = new int[determineNewSize(currentSize, requiredSize)];
        q.R(0, 0, this.intArgs, iArr, currentSize);
        this.intArgs = iArr;
    }

    private final void resizeObjectArgs(int currentSize, int requiredSize) {
        Object[] objArr = new Object[determineNewSize(currentSize, requiredSize)];
        System.arraycopy(this.objectArgs, 0, objArr, 0, currentSize);
        this.objectArgs = objArr;
    }

    private final void resizeOpCodes() {
        int i = this.opCodesSize;
        Operation[] operationArr = new Operation[(i <= 1024 ? i : 1024) + i];
        System.arraycopy(this.opCodes, 0, operationArr, 0, i);
        this.opCodes = operationArr;
    }

    private final <T> String toCollectionString(Iterable<? extends T> iterable, String str) {
        return v.I0(iterable, ", ", "[", "]", new R3.b(13, this, str), 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toCollectionString$lambda$14(Operations operations, String str, Object obj) {
        return operations.formatOpArgumentToString(obj, str);
    }

    private final int topIntIndexOf(int parameter) {
        return (this.intArgsSize - this.opCodes[this.opCodesSize - 1].getInts()) + parameter;
    }

    /* renamed from: topObjectIndexOf-31yXWZQ, reason: not valid java name */
    private final int m3533topObjectIndexOf31yXWZQ(int parameter) {
        return (this.objectArgsSize - this.opCodes[this.opCodesSize - 1].getObjects()) + parameter;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        q.f0(null, 0, this.objectArgs, this.objectArgsSize);
        this.objectArgsSize = 0;
    }

    public final void drain(S7.k sink) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                sink.invoke(opIterator);
            } while (opIterator.next());
        }
        clear();
    }

    public final void ensureAllArgumentsPushedFor(Operation operation) {
        int i = this.pushedIntMask;
        int ints = operation.getInts();
        if (i == ((ints == 0 ? 0 : -1) >>> (32 - ints))) {
            operation.getObjects();
        }
    }

    public final void executeAndFlushAllPendingOperations(Applier<?> applier, SlotWriter slots, RememberManager rememberManager, OperationErrorContext errorContext) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            while (true) {
                Applier<?> applier2 = applier;
                SlotWriter slotWriter = slots;
                RememberManager rememberManager2 = rememberManager;
                OperationErrorContext operationErrorContext = errorContext;
                opIterator.getOperation().executeWithComposeStackTrace(opIterator, applier2, slotWriter, rememberManager2, operationErrorContext);
                if (!opIterator.next()) {
                    break;
                }
                applier = applier2;
                slots = slotWriter;
                rememberManager = rememberManager2;
                errorContext = operationErrorContext;
            }
        }
        clear();
    }

    public final void forEach(S7.k action) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                action.invoke(opIterator);
            } while (opIterator.next());
        }
    }

    /* renamed from: getSize, reason: from getter */
    public final int getOpCodesSize() {
        return this.opCodesSize;
    }

    public final boolean isEmpty() {
        return getOpCodesSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getOpCodesSize() != 0;
    }

    public final void pop() {
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        operationArr[i] = null;
        int objects = operation.getObjects();
        for (int i6 = 0; i6 < objects; i6++) {
            Object[] objArr = this.objectArgs;
            int i10 = this.objectArgsSize - 1;
            this.objectArgsSize = i10;
            objArr[i10] = null;
        }
        this.intArgsSize -= operation.getInts();
    }

    public final void popInto(Operations other) {
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        operationArr[i] = null;
        other.pushOp(operation);
        Object[] objArr = this.objectArgs;
        Object[] objArr2 = other.objectArgs;
        int objects = other.objectArgsSize - operation.getObjects();
        int objects2 = this.objectArgsSize - operation.getObjects();
        System.arraycopy(objArr, objects2, objArr2, objects, this.objectArgsSize - objects2);
        q.f0(null, this.objectArgsSize - operation.getObjects(), this.objectArgs, this.objectArgsSize);
        q.R(other.intArgsSize - operation.getInts(), this.intArgsSize - operation.getInts(), this.intArgs, other.intArgs, this.intArgsSize);
        this.objectArgsSize -= operation.getObjects();
        this.intArgsSize -= operation.getInts();
    }

    public final void push(Operation operation) {
        pushOp(operation);
    }

    @InternalComposeApi
    public final void pushOp(Operation operation) {
        if (this.opCodesSize == this.opCodes.length) {
            resizeOpCodes();
        }
        int ints = operation.getInts() + this.intArgsSize;
        int length = this.intArgs.length;
        if (ints > length) {
            resizeIntArgs(length, ints);
        }
        int objects = operation.getObjects() + this.objectArgsSize;
        int length2 = this.objectArgs.length;
        if (objects > length2) {
            resizeObjectArgs(length2, objects);
        }
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize;
        this.opCodesSize = i + 1;
        operationArr[i] = operation;
        this.intArgsSize = operation.getInts() + this.intArgsSize;
        this.objectArgsSize = operation.getObjects() + this.objectArgsSize;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String toDebugString(String linePrefix) {
        StringBuilder sb = new StringBuilder();
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            int i = 0;
            while (true) {
                sb.append(linePrefix);
                int i6 = i + 1;
                sb.append(i);
                sb.append(". ");
                sb.append(currentOpToDebugString(opIterator, linePrefix));
                sb.append('\n');
                if (!opIterator.next()) {
                    break;
                }
                i = i6;
            }
        }
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    @c
    public String toString() {
        return super.toString();
    }

    public final void push(Operation operation, S7.k args) {
        pushOp(operation);
        args.invoke(WriteScope.m3534boximpl(WriteScope.m3535constructorimpl(this)));
        ensureAllArgumentsPushedFor(operation);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\r\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0014\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0011\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013JL\u0010\u0014\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0011\u001a\u00020\u00062\n\u0010\u0015\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0016\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0017J)\u0010\u001c\u001a\u00020\n\"\u0004\b\u0000\u0010\u00182\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010 \u001a\u00020\n\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u001e\u0010\u001fJa\u0010 \u001a\u00020\n\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u001d\"\u0004\b\u0002\u0010!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u0011\u001a\u00028\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00192\u0006\u0010\u0016\u001a\u00028\u0002¢\u0006\u0004\b\"\u0010#J}\u0010 \u001a\u00020\n\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u001d\"\u0004\b\u0002\u0010!\"\u0004\b\u0003\u0010$2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u0011\u001a\u00028\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00192\u0006\u0010\u0016\u001a\u00028\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00030\u00192\u0006\u0010&\u001a\u00028\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00102R\u0011\u00106\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u00067"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$WriteScope;", "", "Landroidx/compose/runtime/changelist/Operations;", "stack", "constructor-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operations;", "", "Landroidx/compose/runtime/changelist/IntParameter;", "parameter", "value", "LC7/r;", "setInt-impl", "(Landroidx/compose/runtime/changelist/Operations;II)V", "setInt", "parameter1", "value1", "parameter2", "value2", "setInts-impl", "(Landroidx/compose/runtime/changelist/Operations;IIII)V", "setInts", "parameter3", "value3", "(Landroidx/compose/runtime/changelist/Operations;IIIIII)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "setObject-DKhxnng", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;)V", "setObject", "U", "setObjects-4uCC6AY", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;)V", "setObjects", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "setObjects-t7hvbck", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", ExifInterface.LONGITUDE_WEST, "parameter4", "value4", "setObjects-OGa0p1M", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operation;", "operation", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WriteScope {
        private final Operations stack;

        private /* synthetic */ WriteScope(Operations operations) {
            this.stack = operations;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WriteScope m3534boximpl(Operations operations) {
            return new WriteScope(operations);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static Operations m3535constructorimpl(Operations operations) {
            return operations;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m3536equalsimpl(Operations operations, Object obj) {
            return (obj instanceof WriteScope) && k.b(operations, ((WriteScope) obj).getStack());
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3537equalsimpl0(Operations operations, Operations operations2) {
            return k.b(operations, operations2);
        }

        /* renamed from: getOperation-impl, reason: not valid java name */
        public static final Operation m3538getOperationimpl(Operations operations) {
            return operations.opCodes[operations.opCodesSize - 1];
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m3539hashCodeimpl(Operations operations) {
            return operations.hashCode();
        }

        /* renamed from: setInt-impl, reason: not valid java name */
        public static final void m3540setIntimpl(Operations operations, int i, int i6) {
            operations.intArgs[(operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts()) + i] = i6;
        }

        /* renamed from: setInts-impl, reason: not valid java name */
        public static final void m3541setIntsimpl(Operations operations, int i, int i6, int i10, int i11) {
            int ints = operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts();
            int[] iArr = operations.intArgs;
            iArr[i + ints] = i6;
            iArr[ints + i10] = i11;
        }

        /* renamed from: setObject-DKhxnng, reason: not valid java name */
        public static final <T> void m3543setObjectDKhxnng(Operations operations, int i, T t9) {
            operations.objectArgs[(operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects()) + i] = t9;
        }

        /* renamed from: setObjects-4uCC6AY, reason: not valid java name */
        public static final <T, U> void m3544setObjects4uCC6AY(Operations operations, int i, T t9, int i6, U u) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t9;
            objArr[objects + i6] = u;
        }

        /* renamed from: setObjects-OGa0p1M, reason: not valid java name */
        public static final <T, U, V, W> void m3545setObjectsOGa0p1M(Operations operations, int i, T t9, int i6, U u, int i10, V v10, int i11, W w8) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t9;
            objArr[i6 + objects] = u;
            objArr[i10 + objects] = v10;
            objArr[objects + i11] = w8;
        }

        /* renamed from: setObjects-t7hvbck, reason: not valid java name */
        public static final <T, U, V> void m3546setObjectst7hvbck(Operations operations, int i, T t9, int i6, U u, int i10, V v10) {
            int objects = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].getObjects();
            Object[] objArr = operations.objectArgs;
            objArr[i + objects] = t9;
            objArr[i6 + objects] = u;
            objArr[objects + i10] = v10;
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m3547toStringimpl(Operations operations) {
            return "WriteScope(stack=" + operations + ')';
        }

        public boolean equals(Object other) {
            return m3536equalsimpl(this.stack, other);
        }

        public int hashCode() {
            return m3539hashCodeimpl(this.stack);
        }

        public String toString() {
            return m3547toStringimpl(this.stack);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ Operations getStack() {
            return this.stack;
        }

        /* renamed from: setInts-impl, reason: not valid java name */
        public static final void m3542setIntsimpl(Operations operations, int i, int i6, int i10, int i11, int i12, int i13) {
            int ints = operations.intArgsSize - operations.opCodes[operations.opCodesSize - 1].getInts();
            int[] iArr = operations.intArgs;
            iArr[i + ints] = i6;
            iArr[i10 + ints] = i11;
            iArr[ints + i12] = i13;
        }
    }
}
