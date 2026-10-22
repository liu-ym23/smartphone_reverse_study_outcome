package d4;

import android.util.Log;
import j9.m;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final H3.b f4292a;

    public d(H3.b accountUtil) {
        k.f(accountUtil, "accountUtil");
        this.f4292a = accountUtil;
    }

    public final boolean a() {
        if (this.f4292a.b()) {
            return !m.s0(r1.a());
        }
        Log.i("SyncUploadGate", "canUpload: false (not logged in)");
        return false;
    }
}
