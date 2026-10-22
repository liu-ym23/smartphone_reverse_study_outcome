package android.view.result;

import C7.f;
import C7.r;
import D6.i;
import android.content.Context;
import android.content.Intent;
import android.view.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0015R&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", "LC7/r;", "launcher", "Landroidx/activity/result/contract/ActivityResultContract;", "callerContract", "callerInput", AppAgent.CONSTRUCT, "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "input", "Landroidx/core/app/ActivityOptionsCompat;", "options", "launch", "(LC7/r;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "()V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/contract/ActivityResultContract;", "getCallerContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Object;", "getCallerInput", "()Ljava/lang/Object;", "resultContract$delegate", "LC7/f;", "getResultContract", "resultContract", "contract", "getContract", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<r> {
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    private final ActivityResultContract<r, O> contract;
    private final ActivityResultLauncher<I> launcher;

    /* renamed from: resultContract$delegate, reason: from kotlin metadata */
    private final f resultContract;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> launcher, ActivityResultContract<I, O> callerContract, I i) {
        k.f(launcher, "launcher");
        k.f(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i;
        this.resultContract = a.a(new i(this, 6));
        this.contract = getResultContract();
    }

    private final ActivityResultContract<r, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityResultCallerLauncher$resultContract$2$1 resultContract_delegate$lambda$0(final ActivityResultCallerLauncher activityResultCallerLauncher) {
        return new ActivityResultContract<r, O>(activityResultCallerLauncher) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1
            final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            {
                this.this$0 = activityResultCallerLauncher;
            }

            @Override // android.view.result.contract.ActivityResultContract
            public O parseResult(int resultCode, Intent intent) {
                return (O) this.this$0.getCallerContract().parseResult(resultCode, intent);
            }

            @Override // android.view.result.contract.ActivityResultContract
            public Intent createIntent(Context context, r input) {
                k.f(context, "context");
                k.f(input, "input");
                return this.this$0.getCallerContract().createIntent(context, this.this$0.getCallerInput());
            }
        };
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // android.view.result.ActivityResultLauncher
    public ActivityResultContract<r, ?> getContract() {
        return this.contract;
    }

    @Override // android.view.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // android.view.result.ActivityResultLauncher
    public void launch(r input, ActivityOptionsCompat options) {
        k.f(input, "input");
        this.launcher.launch(this.callerInput, options);
    }
}
