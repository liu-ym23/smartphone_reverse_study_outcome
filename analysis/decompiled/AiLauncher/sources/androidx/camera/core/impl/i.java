package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.k;

/* loaded from: classes.dex */
public final class i implements k.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f11425a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11426b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11427c;

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f11428d;

    public i(long j10, int i10, Throwable th) {
        this.f11427c = SystemClock.elapsedRealtime() - j10;
        this.f11426b = i10;
        if (th instanceof CameraValidator.CameraIdListIncorrectException) {
            this.f11425a = 2;
            this.f11428d = th;
            return;
        }
        if (!(th instanceof InitializationException)) {
            this.f11425a = 0;
            this.f11428d = th;
            return;
        }
        Throwable cause = th.getCause();
        th = cause != null ? cause : th;
        this.f11428d = th;
        if (th instanceof CameraUnavailableException) {
            this.f11425a = 2;
        } else if (th instanceof IllegalArgumentException) {
            this.f11425a = 1;
        } else {
            this.f11425a = 0;
        }
    }

    @Override // androidx.camera.core.k.b
    public Throwable a() {
        return this.f11428d;
    }

    @Override // androidx.camera.core.k.b
    public long b() {
        return this.f11427c;
    }

    @Override // androidx.camera.core.k.b
    public int getStatus() {
        return this.f11425a;
    }
}
