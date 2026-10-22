package A7;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import z7.C6370e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"LA7/q;", "Ly7/s;", "Lz7/e$c;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lz7/e$c;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Lz7/e$c;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0749q implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6370e.c token;

    public C0749q(C6370e.c token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
    }

    public static final Y8.t d(Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e.f45191a.g(d10, "setBlendArray", new Class[]{int[].class, int[].class}, new int[0], new int[0]);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(int[] iArr, int[] iArr2, Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C6370e.f45191a.g(d10, "setBlendArray", new Class[]{int[].class, int[].class}, iArr, iArr2);
        return Y8.t.f7040a;
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        C0743k c0743k = params instanceof C0743k ? (C0743k) params : null;
        if (c0743k == null) {
            return;
        }
        List listF1 = Z8.F.f1(c0743k.e(), 4);
        int size = listF1.size();
        final int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Number) ((Pair) listF1.get(i10)).e()).intValue();
        }
        int size2 = listF1.size();
        final int[] iArr2 = new int[size2];
        for (int i11 = 0; i11 < size2; i11++) {
            iArr2[i11] = ((Number) ((Pair) listF1.get(i11)).f()).intValue();
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0749q.e(iArr, iArr2, obj);
            }
        });
    }

    @Override // y7.s
    public void release() {
        this.token.c(new InterfaceC5074l() { // from class: A7.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0749q.d(obj);
            }
        });
    }
}
