package androidx.compose.material3;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$4$3$1", f = "SearchBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBarKt$ExpandedFullScreenSearchBar$4$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SoftwareKeyboardController $softwareKeyboardController;
    final /* synthetic */ SearchBarState $state;
    int label;

    public SearchBarKt$ExpandedFullScreenSearchBar$4$3$1(SearchBarState r100, SoftwareKeyboardController r101, Continuation<? super SearchBarKt$ExpandedFullScreenSearchBar$4$3$1> r102) {
        this.$state = r100;
        this.$softwareKeyboardController = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SearchBarKt$ExpandedFullScreenSearchBar$4$3$1(this.$state, this.$softwareKeyboardController, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SearchBarKt$ExpandedFullScreenSearchBar$4$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        if (this.$state.getTargetValue() != SearchBarValue.Collapsed) goto L10;
        SoftwareKeyboardController r101 = this.$softwareKeyboardController;
        if (r101 == null) goto L10;
        r101.hide();
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
