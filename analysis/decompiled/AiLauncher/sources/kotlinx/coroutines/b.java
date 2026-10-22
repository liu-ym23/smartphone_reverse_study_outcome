package kotlinx.coroutines;

import Ua.D0;
import Ua.N;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/b;", "LUa/D0;", "", "cause", "LY8/t;", "c", "(Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface b extends D0 {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/b$a;", "Lkotlinx/coroutines/b;", "Lkotlin/Function1;", "", "LY8/t;", "handler", "<init>", "(Lp9/l;)V", "cause", "c", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lp9/l;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5074l<Throwable, t> handler;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC5074l<? super Throwable, t> interfaceC5074l) {
            this.handler = interfaceC5074l;
        }

        @Override // kotlinx.coroutines.b
        public void c(Throwable cause) {
            this.handler.invoke(cause);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + N.a(this.handler) + '@' + N.b(this) + ']';
        }
    }

    void c(Throwable cause);
}
