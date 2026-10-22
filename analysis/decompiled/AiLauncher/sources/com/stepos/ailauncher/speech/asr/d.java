package com.stepos.ailauncher.speech.asr;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/d;", "", "", "speechRms", "", "speechFrames", "<init>", "(FI)V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "rms", "c", "(D)Z", Const.INTENT_KEY_PKGNAME, "F", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "latched", "Ljava/util/concurrent/atomic/AtomicBoolean;", "consecutive", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private int consecutive;
    private final AtomicBoolean latched = new AtomicBoolean(false);
    private final int speechFrames;
    private final float speechRms;

    public d(float f10, int i10) {
        this.speechRms = f10;
        this.speechFrames = i10;
    }

    public final boolean a() {
        return this.latched.get();
    }

    public final boolean b() {
        return this.latched.compareAndSet(false, true);
    }

    public final boolean c(double rms) {
        if (this.latched.get()) {
            return false;
        }
        if (rms >= this.speechRms) {
            int i10 = this.consecutive + 1;
            this.consecutive = i10;
            if (i10 >= this.speechFrames && this.latched.compareAndSet(false, true)) {
                return true;
            }
        } else {
            this.consecutive = 0;
        }
        return false;
    }
}
