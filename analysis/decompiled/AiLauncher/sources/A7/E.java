package A7;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import z7.C6375j;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/E;", "Ly7/s;", "Lz7/j$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/j$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/j$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class E implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6375j.c token;

    public E(C6375j.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t d(C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.W(C1173v.m());
        return Y8.t.f7040a;
    }

    public static final Y8.t e(C0743k c0743k, C6375j.a c10) {
        kotlin.jvm.internal.p.i(c10, "c");
        c10.W(Z8.F.f1(c0743k.e(), 4));
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        final C0743k c0743k = params instanceof C0743k ? (C0743k) params : null;
        if (c0743k == null) {
            return;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.e(c0743k, (C6375j.a) obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.d((C6375j.a) obj);
            }
        });
    }
}
