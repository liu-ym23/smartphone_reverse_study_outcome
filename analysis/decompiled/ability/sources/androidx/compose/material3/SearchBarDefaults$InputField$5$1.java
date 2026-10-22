package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.ui.focus.FocusManager;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.SearchBarDefaults$InputField$5$1", f = "SearchBar.android.kt", l = {571}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SearchBarDefaults$InputField$5$1 extends SuspendLambda implements n {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ boolean $shouldClearFocus;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarDefaults$InputField$5$1(boolean z10, FocusManager focusManager, H7.c<? super SearchBarDefaults$InputField$5$1> cVar) {
        super(2, cVar);
        this.$shouldClearFocus = z10;
        this.$focusManager = focusManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SearchBarDefaults$InputField$5$1(this.$shouldClearFocus, this.$focusManager, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            if (this.$shouldClearFocus) {
                this.label = 1;
                if (kotlinx.coroutines.a.f(100L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return r.f317a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.b.b(obj);
        FocusManager.clearFocus$default(this.$focusManager, false, 1, null);
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((SearchBarDefaults$InputField$5$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
