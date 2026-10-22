package androidx.compose.foundation.text.input.internal.undo;

import H4.o;
import androidx.compose.foundation.text.UndoManager_jvmKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\t\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "", "", "index", "", "preText", "postText", "Landroidx/compose/ui/text/TextRange;", "preSelection", "postSelection", "", "timeInMillis", "", "canMerge", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/String;JJJZLkotlin/jvm/internal/e;)V", "I", "getIndex", "()I", "Ljava/lang/String;", "getPreText", "()Ljava/lang/String;", "getPostText", "J", "getPreSelection-d9O1mEE", "()J", "getPostSelection-d9O1mEE", "getTimeInMillis", "Z", "getCanMerge", "()Z", "Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "textEditType", "Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "getTextEditType", "()Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "getDeletionType", "()Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "deletionType", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextUndoOperation {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<TextUndoOperation, Object> Saver = new Saver<TextUndoOperation, Object>() { // from class: androidx.compose.foundation.text.input.internal.undo.TextUndoOperation$Companion$Saver$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.runtime.saveable.Saver
        public TextUndoOperation restore(Object value) {
            k.d(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) value;
            Object obj = list.get(0);
            k.d(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            k.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(2);
            k.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj3;
            Object obj4 = list.get(3);
            k.d(obj4, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue2 = ((Integer) obj4).intValue();
            Object obj5 = list.get(4);
            k.d(obj5, "null cannot be cast to non-null type kotlin.Int");
            long jTextRange = TextRangeKt.TextRange(iIntValue2, ((Integer) obj5).intValue());
            Object obj6 = list.get(5);
            k.d(obj6, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue3 = ((Integer) obj6).intValue();
            Object obj7 = list.get(6);
            k.d(obj7, "null cannot be cast to non-null type kotlin.Int");
            long jTextRange2 = TextRangeKt.TextRange(iIntValue3, ((Integer) obj7).intValue());
            Object obj8 = list.get(7);
            k.d(obj8, "null cannot be cast to non-null type kotlin.Long");
            return new TextUndoOperation(iIntValue, (String) obj2, str, jTextRange, jTextRange2, ((Long) obj8).longValue(), false, 64, null);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope saverScope, TextUndoOperation textUndoOperation) {
            return o.N(Integer.valueOf(textUndoOperation.getIndex()), textUndoOperation.getPreText(), textUndoOperation.getPostText(), Integer.valueOf(TextRange.m6311getStartimpl(textUndoOperation.getPreSelection())), Integer.valueOf(TextRange.m6306getEndimpl(textUndoOperation.getPreSelection())), Integer.valueOf(TextRange.m6311getStartimpl(textUndoOperation.getPostSelection())), Integer.valueOf(TextRange.m6306getEndimpl(textUndoOperation.getPostSelection())), Long.valueOf(textUndoOperation.getTimeInMillis()));
        }
    };
    private final boolean canMerge;
    private final int index;
    private final long postSelection;
    private final String postText;
    private final long preSelection;
    private final String preText;
    private final TextEditType textEditType;
    private final long timeInMillis;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<TextUndoOperation, Object> getSaver() {
            return TextUndoOperation.Saver;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextUndoOperation(int i, String str, String str2, long j5, long j6, long j10, boolean z10, e eVar) {
        this(i, str, str2, j5, j6, j10, z10);
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final TextDeleteType getDeletionType() {
        if (this.textEditType == TextEditType.Delete && TextRange.m6305getCollapsedimpl(this.postSelection)) {
            return TextRange.m6305getCollapsedimpl(this.preSelection) ? TextRange.m6311getStartimpl(this.preSelection) > TextRange.m6311getStartimpl(this.postSelection) ? TextDeleteType.Start : TextDeleteType.End : (TextRange.m6311getStartimpl(this.preSelection) == TextRange.m6311getStartimpl(this.postSelection) && TextRange.m6311getStartimpl(this.preSelection) == this.index) ? TextDeleteType.Inner : TextDeleteType.NotByUser;
        }
        return TextDeleteType.NotByUser;
    }

    public final int getIndex() {
        return this.index;
    }

    /* renamed from: getPostSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getPostSelection() {
        return this.postSelection;
    }

    public final String getPostText() {
        return this.postText;
    }

    /* renamed from: getPreSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getPreSelection() {
        return this.preSelection;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final TextEditType getTextEditType() {
        return this.textEditType;
    }

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }

    private TextUndoOperation(int i, String str, String str2, long j5, long j6, long j10, boolean z10) {
        this.index = i;
        this.preText = str;
        this.postText = str2;
        this.preSelection = j5;
        this.postSelection = j6;
        this.timeInMillis = j10;
        this.canMerge = z10;
        if (str.length() == 0 && str2.length() == 0) {
            throw new IllegalArgumentException("Either pre or post text must not be empty");
        }
        this.textEditType = (str.length() != 0 || str2.length() <= 0) ? (str.length() <= 0 || str2.length() != 0) ? TextEditType.Replace : TextEditType.Delete : TextEditType.Insert;
    }

    public /* synthetic */ TextUndoOperation(int i, String str, String str2, long j5, long j6, long j10, boolean z10, int i6, e eVar) {
        this(i, str, str2, j5, j6, (i6 & 32) != 0 ? UndoManager_jvmKt.timeNowMillis() : j10, (i6 & 64) != 0 ? true : z10, null);
    }
}
