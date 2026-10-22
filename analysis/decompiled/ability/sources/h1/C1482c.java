package h1;

import F.i;
import android.util.Log;
import g1.AbstractC1451a;

/* renamed from: h1.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1482c extends i {
    @Override // F.i
    public final void j(String str, String str2) {
        if (AbstractC1451a.f4467a) {
            Log.e(str, str2);
        }
        AbstractC1481b.b(str, str2, null);
    }

    @Override // F.i
    public final void r(String str, String str2, Throwable th) {
        if (AbstractC1451a.f4467a) {
            Log.e(str, str2, th);
        }
        AbstractC1481b.b(str, str2, th);
    }
}
