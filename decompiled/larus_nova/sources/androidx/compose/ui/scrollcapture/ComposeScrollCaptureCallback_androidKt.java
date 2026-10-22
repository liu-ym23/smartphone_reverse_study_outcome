package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\u0002\b\u000eH\u0002¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"DEBUG", "", "TAG", "", "launchWithCancellationSignal", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", IAllianceService.LAUNCH_FROM_SIGNAL, "Landroid/os/CancellationSignal;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Landroid/os/CancellationSignal;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposeScrollCaptureCallback_androidKt {
    private static final boolean DEBUG = false;
    private static final String TAG = "ScrollCapture";

    public static /* synthetic */ void a(Job r100) {
        launchWithCancellationSignal$lambda$0(r100);
    }

    private static final void launchWithCancellationSignal$lambda$0(Job r100) {
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    }

    public static final /* synthetic */ Job access$launchWithCancellationSignal(CoroutineScope r100, CancellationSignal r101, Function2 r102) {
        return launchWithCancellationSignal(r100, r101, r102);
    }

    private static final Job launchWithCancellationSignal(CoroutineScope r100, final CancellationSignal r101, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r102) {
        final Job r103 = BuildersKt.launch$default(r100, null, null, r102, 3, null);
        r103.invokeOnCompletion(new AnonymousClass1(r101));
        r101.setOnCancelListener(new a(r103));
        return r103;
    }
}
