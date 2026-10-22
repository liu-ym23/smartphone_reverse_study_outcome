package android.view.compose;

import S7.n;
import android.view.BackEventCompat;
import android.view.OnBackPressedCallback;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRD\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/activity/compose/PredictiveBackHandlerCallback;", "Landroidx/activity/OnBackPressedCallback;", "", "enabled", "Lm9/z;", "onBackScope", "Lkotlin/Function2;", "Lp9/c;", "Landroidx/activity/BackEventCompat;", "LH7/c;", "LC7/r;", "", "currentOnBack", AppAgent.CONSTRUCT, "(ZLm9/z;LS7/n;)V", "setIsEnabled", "(Z)V", "backEvent", "handleOnBackStarted", "(Landroidx/activity/BackEventCompat;)V", "handleOnBackProgressed", "handleOnBackPressed", "()V", "handleOnBackCancelled", "Lm9/z;", "getOnBackScope", "()Lm9/z;", "setOnBackScope", "(Lm9/z;)V", "LS7/n;", "getCurrentOnBack", "()LS7/n;", "setCurrentOnBack", "(LS7/n;)V", "Landroidx/activity/compose/OnBackInstance;", "onBackInstance", "Landroidx/activity/compose/OnBackInstance;", "isActive", "Z", "activity-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class PredictiveBackHandlerCallback extends OnBackPressedCallback {
    private n currentOnBack;
    private boolean isActive;
    private OnBackInstance onBackInstance;
    private InterfaceC1733z onBackScope;

    public PredictiveBackHandlerCallback(boolean z10, InterfaceC1733z interfaceC1733z, n nVar) {
        super(z10);
        this.onBackScope = interfaceC1733z;
        this.currentOnBack = nVar;
    }

    public final n getCurrentOnBack() {
        return this.currentOnBack;
    }

    public final InterfaceC1733z getOnBackScope() {
        return this.onBackScope;
    }

    @Override // android.view.OnBackPressedCallback
    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.cancel();
        }
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.setPredictiveBack(false);
        }
        this.isActive = false;
    }

    @Override // android.view.OnBackPressedCallback
    public void handleOnBackPressed() {
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null && !onBackInstance.getIsPredictiveBack()) {
            onBackInstance.cancel();
            this.onBackInstance = null;
        }
        if (this.onBackInstance == null) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, false, this.currentOnBack, this);
        }
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.close();
        }
        OnBackInstance onBackInstance3 = this.onBackInstance;
        if (onBackInstance3 != null) {
            onBackInstance3.setPredictiveBack(false);
        }
        this.isActive = false;
    }

    @Override // android.view.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEvent) {
        super.handleOnBackProgressed(backEvent);
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.m5sendJP2dKIU(backEvent);
        }
    }

    @Override // android.view.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEvent) {
        super.handleOnBackStarted(backEvent);
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.cancel();
        }
        if (getIsEnabled()) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, true, this.currentOnBack, this);
        }
        this.isActive = true;
    }

    public final void setCurrentOnBack(n nVar) {
        this.currentOnBack = nVar;
    }

    public final void setIsEnabled(boolean enabled) {
        OnBackInstance onBackInstance;
        if (!enabled && !this.isActive && getIsEnabled() && (onBackInstance = this.onBackInstance) != null) {
            onBackInstance.cancel();
        }
        setEnabled(enabled);
    }

    public final void setOnBackScope(InterfaceC1733z interfaceC1733z) {
        this.onBackScope = interfaceC1733z;
    }
}
