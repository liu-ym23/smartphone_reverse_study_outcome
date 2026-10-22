package t2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends Throwable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13139c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, int i) {
        super(str);
        this.f13139c = i;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        int i = this.f13139c;
        synchronized (this) {
            switch (i) {
            }
            return this;
        }
    }
}
