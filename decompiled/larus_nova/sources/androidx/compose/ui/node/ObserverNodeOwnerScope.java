package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "Landroidx/compose/ui/node/OwnerScope;", "observerNode", "Landroidx/compose/ui/node/ObserverModifierNode;", "<init>", "(Landroidx/compose/ui/node/ObserverModifierNode;)V", "getObserverNode$ui_release", "()Landroidx/compose/ui/node/ObserverModifierNode;", "isValidOwnerScope", "", "()Z", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObserverNodeOwnerScope implements OwnerScope {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Function1<ObserverNodeOwnerScope, Unit> OnObserveReadsChanged = null;
    private final ObserverModifierNode observerNode;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/node/ObserverNodeOwnerScope$Companion;", "", "<init>", "()V", "OnObserveReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "", "getOnObserveReadsChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Function1<ObserverNodeOwnerScope, Unit> getOnObserveReadsChanged$ui_release() {
            return ObserverNodeOwnerScope.access$getOnObserveReadsChanged$cp();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        OnObserveReadsChanged = ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1.INSTANCE;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.observerNode.getNode().isAttached();
    }

    public static final /* synthetic */ Function1 access$getOnObserveReadsChanged$cp() {
        return OnObserveReadsChanged;
    }

    public final ObserverModifierNode getObserverNode$ui_release() {
        return this.observerNode;
    }

    public ObserverNodeOwnerScope(ObserverModifierNode r100) {
        this.observerNode = r100;
    }
}
