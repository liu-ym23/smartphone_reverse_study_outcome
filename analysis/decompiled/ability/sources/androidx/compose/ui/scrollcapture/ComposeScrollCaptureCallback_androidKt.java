package androidx.compose.ui.scrollcapture;

import C7.r;
import S7.k;
import S7.n;
import android.os.CancellationSignal;
import androidx.appfunctions.b;
import kotlin.Metadata;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import m9.q0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a?\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lm9/z;", "Landroid/os/CancellationSignal;", "signal", "Lkotlin/Function2;", "LH7/c;", "LC7/r;", "", "block", "Lm9/c0;", "launchWithCancellationSignal", "(Lm9/z;Landroid/os/CancellationSignal;LS7/n;)Lm9/c0;", "", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeScrollCaptureCallback_androidKt {
    private static final boolean DEBUG = false;
    private static final String TAG = "ScrollCapture";

    /* JADX INFO: Access modifiers changed from: private */
    public static final c0 launchWithCancellationSignal(InterfaceC1733z interfaceC1733z, final CancellationSignal cancellationSignal, n nVar) {
        q0 q0VarN = AbstractC1683A.n(interfaceC1733z, null, nVar, 3);
        q0VarN.w(new k() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    cancellationSignal.cancel();
                }
            }
        });
        cancellationSignal.setOnCancelListener(new b(q0VarN, 2));
        return q0VarN;
    }
}
