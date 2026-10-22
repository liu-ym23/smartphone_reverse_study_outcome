package b0;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class x0 implements u0.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f1414a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1415b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1416c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1417d;

    public x0(int i2, boolean z4) {
        switch (i2) {
            case 1:
                this.f1414a = new ArrayList();
                this.f1415b = false;
                this.f1416c = new CopyOnWriteArrayList();
                break;
            default:
                this.f1416c = new Object();
                this.f1414a = new ArrayList();
                this.f1417d = new ArrayList();
                this.f1415b = true;
                break;
        }
    }

    @Override // u0.p
    public void a(x0.b bVar) {
        synchronized (this.f1416c) {
            if (!bVar.f11081s) {
                bVar.f11081s = true;
                bVar.b();
            }
        }
    }

    @Override // u0.p
    public x0.b b() {
        x0.b bVar;
        synchronized (this.f1416c) {
            ((j1.y) this.f1414a).getUniqueDrawingId();
            bVar = new x0.b(new x0.c());
        }
        return bVar;
    }

    public int[] c() {
        synchronized (this) {
            try {
                if (!this.f1415b) {
                    return null;
                }
                long[] jArr = (long[]) this.f1416c;
                int length = jArr.length;
                int i2 = 0;
                int i10 = 0;
                while (i2 < length) {
                    int i11 = i10 + 1;
                    int i12 = 1;
                    boolean z4 = jArr[i2] > 0;
                    boolean[] zArr = (boolean[]) this.f1414a;
                    if (z4 != zArr[i10]) {
                        int[] iArr = (int[]) this.f1417d;
                        if (!z4) {
                            i12 = 2;
                        }
                        iArr[i10] = i12;
                    } else {
                        ((int[]) this.f1417d)[i10] = 0;
                    }
                    zArr[i10] = z4;
                    i2++;
                    i10 = i11;
                }
                this.f1415b = false;
                return (int[]) ((int[]) this.f1417d).clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public x0(j1.y yVar) {
        this.f1414a = yVar;
        this.f1416c = new Object();
        u0.c cVar = new u0.c(this);
        this.f1417d = cVar;
        if (yVar.isAttachedToWindow()) {
            Context context = yVar.getContext();
            if (!this.f1415b) {
                context.getApplicationContext().registerComponentCallbacks(cVar);
                this.f1415b = true;
            }
        }
        yVar.addOnAttachStateChangeListener(new j1.b0(3, this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x0(d.f fVar) {
        this(1, false);
        this.f1417d = fVar;
    }

    public x0(int i2) {
        this.f1416c = new long[i2];
        this.f1414a = new boolean[i2];
        this.f1417d = new int[i2];
    }
}
