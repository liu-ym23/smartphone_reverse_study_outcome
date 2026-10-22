package androidx.compose.material3;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior", f = "SearchBar.kt", i = {0, 0, 1}, l = {TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_NATIVE_REFRESH, 986}, m = "settleSearchBar-OhffZ5M", n = {"remainingVelocity", "scrollFraction", "remainingVelocity"}, s = {"L$0", "F$0", "L$0"})
public final class EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterAlwaysSearchBarScrollBehavior this$0;

    public EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(EnterAlwaysSearchBarScrollBehavior r100, Continuation<? super EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return EnterAlwaysSearchBarScrollBehavior.m2191access$settleSearchBarOhffZ5M(this.this$0, 0.0f, this);
    }
}
