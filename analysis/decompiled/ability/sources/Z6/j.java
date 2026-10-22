package Z6;

import F9.C0234l;
import a.AbstractC0291a;
import com.volcengine.tos.TosException;
import com.volcengine.tos.model.object.AbortMultipartUploadInput;
import com.volcengine.tos.model.object.CancelHook;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class j implements CancelHook, a {

    /* renamed from: a, reason: collision with root package name */
    public C0234l f1607a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public K1.a g;
    public boolean h;
    public ReentrantLock i = new ReentrantLock();

    @Override // Z6.a
    public final synchronized void a() {
        String str;
        try {
            try {
                try {
                    K1.a aVar = this.g;
                    if (aVar != null) {
                        aVar.q();
                    }
                    this.f1607a.a(new AbortMultipartUploadInput().setBucket(this.b).setKey(this.c).setUploadID(this.d));
                    K1.a aVar2 = this.g;
                    if (aVar2 != null) {
                        aVar2.j();
                    }
                } catch (TosException e) {
                    if (e.getStatusCode() != 404) {
                        throw e;
                    }
                    a7.f.e.debug("tos: abortMultipartUpload return 404 and will ignore it.");
                    K1.a aVar3 = this.g;
                    if (aVar3 != null) {
                        aVar3.j();
                    }
                    if (this.f) {
                        str = this.e;
                    }
                }
                if (this.f) {
                    str = this.e;
                    k.u(str);
                }
            } catch (Throwable th) {
                K1.a aVar4 = this.g;
                if (aVar4 != null) {
                    aVar4.j();
                }
                if (this.f) {
                    k.u(this.e);
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.volcengine.tos.model.object.CancelHook
    public final void cancel(boolean z10) {
        ReentrantLock reentrantLock = this.i;
        if (this.f1607a == null || this.g == null || AbstractC0291a.x(this.b) || AbstractC0291a.x(this.c) || AbstractC0291a.x(this.d) || !reentrantLock.tryLock()) {
            return;
        }
        try {
            if (this.h) {
                reentrantLock.unlock();
                return;
            }
            if (z10) {
                a();
            } else {
                K1.a aVar = this.g;
                if (aVar != null) {
                    aVar.j();
                }
            }
            this.h = true;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
