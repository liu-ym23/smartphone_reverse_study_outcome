package androidx.compose.ui.platform;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/AndroidUiDispatcher$dispatchCallback$1", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "run", "", "doFrame", "frameTimeNanos", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidUiDispatcher$dispatchCallback$1 implements Choreographer.FrameCallback, Runnable {
    final /* synthetic */ AndroidUiDispatcher this$0;

    @Override // java.lang.Runnable
    public void run() {
        androidx_compose_ui_platform_AndroidUiDispatcher$dispatchCallback$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_compose_ui_platform_AndroidUiDispatcher$dispatchCallback$1__run$___twin___() {
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        Object r100 = AndroidUiDispatcher.access$getLock$p(this.this$0);
        AndroidUiDispatcher r101 = this.this$0;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (AndroidUiDispatcher.access$getToRunOnFrame$p(r101).isEmpty() == false) goto L7;
        r101.getChoreographer().removeFrameCallback(this);     // Catch: Throwable -> L10
        AndroidUiDispatcher.access$setScheduledFrameDispatch$p(r101, false);     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
    }

    public AndroidUiDispatcher$dispatchCallback$1(AndroidUiDispatcher r100) {
        this.this$0 = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_compose_ui_platform_AndroidUiDispatcher$dispatchCallback$1_com_larus_apm_impl_protector_RunnableLancet_run(AndroidUiDispatcher$dispatchCallback$1 r100) {
        r100.androidx_compose_ui_platform_AndroidUiDispatcher$dispatchCallback$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r100) {
        AndroidUiDispatcher.access$getHandler$p(this.this$0).removeCallbacks(this);
        AndroidUiDispatcher.access$performTrampolineDispatch(this.this$0);
        AndroidUiDispatcher.access$performFrameDispatch(this.this$0, r100);
    }
}
