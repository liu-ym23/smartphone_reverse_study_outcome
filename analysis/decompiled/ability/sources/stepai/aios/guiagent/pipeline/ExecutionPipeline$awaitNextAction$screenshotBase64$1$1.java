package stepai.aios.guiagent.pipeline;

import Aa.e;
import C7.r;
import J7.c;
import S7.n;
import android.graphics.Bitmap;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.ability.GuiAbilityProvider;

@c(c = "stepai.aios.guiagent.pipeline.ExecutionPipeline$awaitNextAction$screenshotBase64$1$1", f = "ExecutionPipeline.kt", l = {PointerIconCompat.TYPE_GRABBING}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes4.dex */
final class ExecutionPipeline$awaitNextAction$screenshotBase64$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6047a;
    public final /* synthetic */ e b;
    public final /* synthetic */ Bitmap c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExecutionPipeline$awaitNextAction$screenshotBase64$1$1(e eVar, Bitmap bitmap, H7.c cVar) {
        super(2, cVar);
        this.b = eVar;
        this.c = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ExecutionPipeline$awaitNextAction$screenshotBase64$1$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ExecutionPipeline$awaitNextAction$screenshotBase64$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6047a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        GuiAbilityProvider guiAbilityProvider = this.b.f168a.getGuiAbilityProvider();
        this.f6047a = 1;
        Object objBitmap2Base64 = guiAbilityProvider.bitmap2Base64(this.c, this);
        return objBitmap2Base64 == coroutineSingletons ? coroutineSingletons : objBitmap2Base64;
    }
}
