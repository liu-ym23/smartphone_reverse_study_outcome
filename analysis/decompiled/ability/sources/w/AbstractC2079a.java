package w;

/* renamed from: w.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2079a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6798a;
    public volatile Object b;

    public abstract Object a(Object... objArr);

    public final Object b(Object... objArr) {
        switch (this.f6798a) {
            case 0:
                if (this.b == null) {
                    synchronized (this) {
                        try {
                            if (this.b == null) {
                                this.b = a(objArr);
                            }
                        } finally {
                        }
                    }
                }
                return this.b;
            default:
                if (this.b == null) {
                    synchronized (this) {
                        try {
                            if (this.b == null) {
                                this.b = a(objArr);
                            }
                        } finally {
                        }
                    }
                }
                return this.b;
        }
    }
}
