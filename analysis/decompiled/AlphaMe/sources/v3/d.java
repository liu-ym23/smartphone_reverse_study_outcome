package v3;

import A3.j;
import A3.m;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import t3.e;
import t3.f;

/* loaded from: classes2.dex */
public final class d extends f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15730a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15731b;

    public d(int i4, Object obj) {
        this.f15730a = i4;
        this.f15731b = obj;
    }

    @Override // t3.f
    public final e b() {
        int i4 = this.f15730a;
        Object obj = this.f15731b;
        switch (i4) {
            case 0:
                return new b((Handler) obj);
            case 1:
                return new j((Executor) obj);
            default:
                return new m((ThreadFactory) obj);
        }
    }

    public d(Looper looper) {
        this.f15730a = 0;
        this.f15731b = new Handler(looper);
    }
}
