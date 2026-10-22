package q2;

import e3.C1417f;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1796a extends C1417f {
    public boolean c;

    @Override // e3.C1417f, J0.a
    public final boolean a(String str) {
        if (!this.c && str.contains("android.os.Looper.loop")) {
            this.c = true;
        }
        return !this.c;
    }
}
