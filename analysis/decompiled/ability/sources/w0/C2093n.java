package w0;

import android.content.IntentFilter;

/* renamed from: w0.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2093n {

    /* renamed from: a, reason: collision with root package name */
    public N5.b f6827a;
    public IntentFilter b;
    public boolean c;
    public float d;
    public int e;
    public float f;

    public final synchronized void a() {
        if (this.c) {
            return;
        }
        try {
            this.c = true;
            H.h.f711a.registerReceiver(this.f6827a, this.b);
        } catch (Exception unused) {
        }
    }
}
