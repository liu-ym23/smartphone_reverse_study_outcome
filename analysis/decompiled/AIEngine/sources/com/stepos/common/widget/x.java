package com.stepos.common.widget;

import android.media.SoundPool;
import android.os.Looper;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f7202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SoundPool f7203b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7204c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Looper f7205d;

    public x(boolean z, SoundPool soundPool, int i10, Looper looper) {
        this.f7202a = z;
        this.f7203b = soundPool;
        this.f7204c = i10;
        this.f7205d = looper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoundPool soundPool;
        Looper looper = this.f7205d;
        try {
            if (this.f7202a && (soundPool = this.f7203b) != null) {
                soundPool.unload(this.f7204c);
            }
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }
}
