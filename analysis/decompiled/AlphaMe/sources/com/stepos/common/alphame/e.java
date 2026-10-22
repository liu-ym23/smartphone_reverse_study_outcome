package com.stepos.common.alphame;

import android.os.IBinder;

/* loaded from: classes.dex */
public final class e implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f11226a;

    public e(f fVar) {
        this.f11226a = fVar;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        synchronized (this.f11226a) {
            this.f11226a.f11230d.asBinder().unlinkToDeath(this, 0);
            f fVar = this.f11226a;
            fVar.f11230d = null;
            fVar.f11232f = false;
            fVar.f11227a.clear();
            synchronized (this.f11226a.f11228b) {
                try {
                    f fVar2 = this.f11226a;
                    if (fVar2.f11233g != null && fVar2.f11228b.size() >= 0) {
                        for (int i4 = 0; i4 < this.f11226a.f11228b.size(); i4++) {
                            this.f11226a.f11229c.put(((b) r4.f11228b.valueAt(i4)).getId(), (b) this.f11226a.f11228b.valueAt(i4));
                        }
                        this.f11226a.f11233g.removeMessages(0);
                        this.f11226a.f11233g.sendEmptyMessageDelayed(0, 500L);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f11226a.f11228b.clear();
        }
    }
}
