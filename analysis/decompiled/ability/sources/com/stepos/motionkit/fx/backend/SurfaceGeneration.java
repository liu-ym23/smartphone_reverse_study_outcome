package com.stepos.motionkit.fx.backend;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SurfaceGeneration;", "", AppAgent.CONSTRUCT, "()V", "", "available", "()Ljava/lang/Long;", "LC7/r;", "lost", "", "release", "()Z", "value", "isCurrent", "(J)Z", "released", "Z", "getReleased", "generation", "J", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfaceGeneration {
    private boolean available;
    private long generation;
    private boolean released;

    public final Long available() {
        if (this.released || this.available) {
            return null;
        }
        this.available = true;
        long j5 = this.generation + 1;
        this.generation = j5;
        return Long.valueOf(j5);
    }

    public final boolean getReleased() {
        return this.released;
    }

    public final boolean isCurrent(long value) {
        return !this.released && this.available && value == this.generation;
    }

    public final void lost() {
        this.available = false;
        this.generation++;
    }

    public final boolean release() {
        if (this.released) {
            return false;
        }
        this.released = true;
        lost();
        return true;
    }
}
