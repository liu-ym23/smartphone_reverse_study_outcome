package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class AbstractClickableNode$focusableNode$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public AbstractClickableNode$focusableNode$1(Object r100) {
        super(1, r100, AbstractClickableNode.class, "onFocusChange", "onFocusChange(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        AbstractClickableNode.access$onFocusChange((AbstractClickableNode) this.receiver, r100);
    }
}
