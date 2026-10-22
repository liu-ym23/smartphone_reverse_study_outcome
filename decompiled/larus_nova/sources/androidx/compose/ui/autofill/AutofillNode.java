package androidx.compose.ui.autofill;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/autofill/AutofillNode;", "", "autofillTypes", "", "Landroidx/compose/ui/autofill/AutofillType;", "boundingBox", "Landroidx/compose/ui/geometry/Rect;", "onFill", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)V", "getAutofillTypes", "()Ljava/util/List;", "getBoundingBox", "()Landroidx/compose/ui/geometry/Rect;", "setBoundingBox", "(Landroidx/compose/ui/geometry/Rect;)V", "getOnFill", "()Lkotlin/jvm/functions/Function1;", "id", "", "getId", "()I", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutofillNode {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Object lock = null;
    private static int previousId;
    private final List<AutofillType> autofillTypes;
    private Rect boundingBox;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15174id;
    private final Function1<String, Unit> onFill;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00060\u0001j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/autofill/AutofillNode$Companion;", "", "<init>", "()V", "previousId", "", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "generateId", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final int generateId() {
            Object r100 = AutofillNode.access$getLock$cp();
            monitor-enter(r100);
            AutofillNode.access$setPreviousId$cp(AutofillNode.access$getPreviousId$cp() + 1);     // Catch: Throwable -> L7
            int r101 = AutofillNode.access$getPreviousId$cp();     // Catch: Throwable -> L7
            monitor-exit(r100);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public static final /* synthetic */ int access$generateId(Companion r100) {
            return r100.generateId();
        }
    }

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        $stable = 8;
        lock = r100;
    }

    public int hashCode() {
        int r100 = this.autofillTypes.hashCode() * 31;
        Rect r101 = this.boundingBox;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Function1<String, Unit> r105 = this.onFill;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public static final /* synthetic */ Object access$getLock$cp() {
        return lock;
    }

    public static final /* synthetic */ int access$getPreviousId$cp() {
        return previousId;
    }

    public final List<AutofillType> getAutofillTypes() {
        return this.autofillTypes;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final int getId() {
        return this.f15174id;
    }

    public final Function1<String, Unit> getOnFill() {
        return this.onFill;
    }

    public static final /* synthetic */ void access$setPreviousId$cp(int r100) {
        previousId = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutofillNode) == true) goto L8;
        return false;
    L8:
        AutofillNode r101 = (AutofillNode) r100;
        if (Intrinsics.areEqual(this.autofillTypes, r101.autofillTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.boundingBox, r101.boundingBox) == true) goto L15;
        return false;
    L15:
        if (this.onFill == r101.onFill) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setBoundingBox(Rect r100) {
        this.boundingBox = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutofillNode(List<? extends AutofillType> r100, Rect r101, Function1<? super String, Unit> r102) {
        this.autofillTypes = r100;
        this.boundingBox = r101;
        this.onFill = r102;
        if (ComposeUiFlags.isSemanticAutofillEnabled == false) goto L5;
        int r103 = SemanticsModifierKt.generateSemanticsId();
    L6:
        this.f15174id = r103;
        return;
    L5:
        r103 = Companion.access$generateId(Companion);
        goto L6
    }

    public /* synthetic */ AutofillNode(List r100, Rect r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, r102);
    }
}
