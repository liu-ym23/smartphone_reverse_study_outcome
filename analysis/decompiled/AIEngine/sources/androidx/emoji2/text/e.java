package androidx.emoji2.text;

import androidx.emoji2.text.d;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends d.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.i f1944a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1945b;

    public e(d.i iVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1944a = iVar;
        this.f1945b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.d.i
    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f1945b;
        try {
            this.f1944a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // androidx.emoji2.text.d.i
    public final void b(h hVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f1945b;
        try {
            this.f1944a.b(hVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
