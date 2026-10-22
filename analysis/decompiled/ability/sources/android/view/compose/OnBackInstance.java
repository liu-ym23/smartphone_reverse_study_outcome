package android.view.compose;

import S7.n;
import Z6.k;
import android.view.BackEventCompat;
import android.view.OnBackPressedCallback;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import o9.InterfaceC1779e;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012(\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/activity/compose/OnBackInstance;", "", "Lm9/z;", "scope", "", "isPredictiveBack", "Lkotlin/Function2;", "Lp9/c;", "Landroidx/activity/BackEventCompat;", "LH7/c;", "LC7/r;", "onBack", "Landroidx/activity/OnBackPressedCallback;", "callback", AppAgent.CONSTRUCT, "(Lm9/z;ZLS7/n;Landroidx/activity/OnBackPressedCallback;)V", "backEvent", "Lo9/h;", "send-JP2dKIU", "(Landroidx/activity/BackEventCompat;)Ljava/lang/Object;", "send", "close", "()Z", "cancel", "()V", "Z", "setPredictiveBack", "(Z)V", "Lo9/e;", "channel", "Lo9/e;", "getChannel", "()Lo9/e;", "Lm9/c0;", "job", "Lm9/c0;", "getJob", "()Lm9/c0;", "activity-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class OnBackInstance {
    private final InterfaceC1779e channel = k.b(-2, 4, BufferOverflow.f5184a);
    private boolean isPredictiveBack;
    private final c0 job;

    public OnBackInstance(InterfaceC1733z interfaceC1733z, boolean z10, n nVar, OnBackPressedCallback onBackPressedCallback) {
        this.isPredictiveBack = z10;
        this.job = AbstractC1683A.n(interfaceC1733z, null, new OnBackInstance$job$1(onBackPressedCallback, nVar, this, null), 3);
    }

    public final void cancel() {
        this.channel.cancel(new CancellationException("onBack cancelled"));
        this.job.cancel(null);
    }

    public final boolean close() {
        return this.channel.s(null);
    }

    public final InterfaceC1779e getChannel() {
        return this.channel;
    }

    public final c0 getJob() {
        return this.job;
    }

    /* renamed from: isPredictiveBack, reason: from getter */
    public final boolean getIsPredictiveBack() {
        return this.isPredictiveBack;
    }

    /* renamed from: send-JP2dKIU, reason: not valid java name */
    public final Object m5sendJP2dKIU(BackEventCompat backEvent) {
        return this.channel.a(backEvent);
    }

    public final void setPredictiveBack(boolean z10) {
        this.isPredictiveBack = z10;
    }
}
