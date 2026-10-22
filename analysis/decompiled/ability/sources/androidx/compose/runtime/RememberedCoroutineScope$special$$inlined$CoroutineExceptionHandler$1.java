package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Metadata;
import m9.C1730w;
import m9.InterfaceC1731x;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/runtime/RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1", "LH7/a;", "Lm9/x;", "LH7/h;", "context", "", "exception", "LC7/r;", "handleException", "(LH7/h;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 extends H7.a implements InterfaceC1731x {
    final /* synthetic */ CompositionErrorContextImpl $traceContext$inlined;
    final /* synthetic */ RememberedCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(C1730w c1730w, CompositionErrorContextImpl compositionErrorContextImpl, RememberedCoroutineScope rememberedCoroutineScope) {
        super(c1730w);
        this.$traceContext$inlined = compositionErrorContextImpl;
        this.this$0 = rememberedCoroutineScope;
    }

    @Override // m9.InterfaceC1731x
    public void handleException(H7.h context, Throwable exception) throws Throwable {
        this.$traceContext$inlined.attachComposeStackTrace(exception, this.this$0);
        H7.h hVar = this.this$0.overlayContext;
        C1730w c1730w = C1730w.f5337a;
        InterfaceC1731x interfaceC1731x = (InterfaceC1731x) hVar.get(c1730w);
        if (interfaceC1731x != null) {
            interfaceC1731x.handleException(context, exception);
            return;
        }
        InterfaceC1731x interfaceC1731x2 = (InterfaceC1731x) this.this$0.parentContext.get(c1730w);
        if (interfaceC1731x2 == null) {
            throw exception;
        }
        interfaceC1731x2.handleException(context, exception);
    }
}
