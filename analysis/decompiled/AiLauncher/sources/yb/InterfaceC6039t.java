package yb;

import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import tb.C5534a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0011\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lyb/t;", "", "", "e", "()Z", "Lyb/t$b;", Const.INTENT_KEY_UMID, "()Lyb/t$b;", "Lyb/n;", "failedConnection", Const.INTENT_KEY_APIKEY, "(Lyb/n;)Z", "Ltb/v;", "url", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/v;)Z", "Ltb/a;", Const.INTENT_KEY_PKGNAME, "()Ltb/a;", Const.JSON_KEY_ADDRESS, "LZ8/m;", "c", "()LZ8/m;", "deferredPlans", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC6039t {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lyb/t$b;", "", "Lyb/t$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lyb/t$a;", "c", "Lyb/n;", Const.INTENT_KEY_APIKEY, "()Lyb/n;", "LY8/t;", "cancel", "()V", "f", "()Lyb/t$b;", "", "isReady", "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.t$b */
    public interface b {
        C6033n a();

        ConnectResult c();

        void cancel();

        b f();

        ConnectResult g();

        boolean isReady();
    }

    static /* synthetic */ boolean f(InterfaceC6039t interfaceC6039t, C6033n c6033n, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
        }
        if ((i10 & 1) != 0) {
            c6033n = null;
        }
        return interfaceC6039t.a(c6033n);
    }

    boolean a(C6033n failedConnection);

    C5534a b();

    C1165m<b> c();

    b d() throws IOException;

    boolean e();

    boolean g(tb.v url);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001e\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lyb/t$a;", "", "Lyb/t$b;", "plan", "nextPlan", "", "throwable", "<init>", "(Lyb/t$b;Lyb/t$b;Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "()Lyb/t$b;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lyb/t$b;", Const.INTENT_KEY_UMID, "c", "Ljava/lang/Throwable;", "e", "f", "()Z", "isSuccess", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.t$a, reason: from toString */
    public static final /* data */ class ConnectResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final b plan;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final b nextPlan;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Throwable throwable;

        public ConnectResult(b plan, b bVar, Throwable th) {
            kotlin.jvm.internal.p.i(plan, "plan");
            this.plan = plan;
            this.nextPlan = bVar;
            this.throwable = th;
        }

        /* renamed from: a, reason: from getter */
        public final b getNextPlan() {
            return this.nextPlan;
        }

        /* renamed from: b, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final b c() {
            return this.nextPlan;
        }

        /* renamed from: d, reason: from getter */
        public final b getPlan() {
            return this.plan;
        }

        public final Throwable e() {
            return this.throwable;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) other;
            return kotlin.jvm.internal.p.d(this.plan, connectResult.plan) && kotlin.jvm.internal.p.d(this.nextPlan, connectResult.nextPlan) && kotlin.jvm.internal.p.d(this.throwable, connectResult.throwable);
        }

        public final boolean f() {
            return this.nextPlan == null && this.throwable == null;
        }

        public int hashCode() {
            int iHashCode = this.plan.hashCode() * 31;
            b bVar = this.nextPlan;
            int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
            Throwable th = this.throwable;
            return iHashCode2 + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ ConnectResult(b bVar, b bVar2, Throwable th, int i10, kotlin.jvm.internal.i iVar) {
            this(bVar, (i10 & 2) != 0 ? null : bVar2, (i10 & 4) != 0 ? null : th);
        }
    }
}
