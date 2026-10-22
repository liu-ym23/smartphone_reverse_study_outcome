package org.libpag;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HardwareDecoder f19225a;

    b(HardwareDecoder hardwareDecoder) {
        this.f19225a = hardwareDecoder;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f19225a.f19126c.stop();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            this.f19225a.f19126c.release();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        this.f19225a.f19126c = null;
        this.f19225a.f19125b.a();
    }
}
