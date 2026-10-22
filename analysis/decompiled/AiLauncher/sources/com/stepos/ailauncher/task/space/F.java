package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/space/F;", "", "<init>", "()V", "", "isDown", "c", "(Z)Z", "passthrough", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "(Z)V", "passingCurrentGesture", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    private boolean passingCurrentGesture;
    private boolean passthrough;

    /* renamed from: a, reason: from getter */
    public final boolean getPassthrough() {
        return this.passthrough;
    }

    public final void b(boolean z10) {
        this.passthrough = z10;
    }

    public final boolean c(boolean isDown) {
        if (isDown) {
            this.passingCurrentGesture = this.passthrough;
        }
        return !this.passingCurrentGesture;
    }
}
