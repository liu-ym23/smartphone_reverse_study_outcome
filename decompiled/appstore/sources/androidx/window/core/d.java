package androidx.window.core;

import com.bytedance.apm.constant.CommonKey;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class d extends SpecificationComputer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Logger f5243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f5244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WindowStrictModeException f5245g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5246a = null;

        static {
            int[] r10 = new int[SpecificationComputer.VerificationMode.values().length];
            r10[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            r10[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            r10[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            f5246a = r10;
        }
    }

    public d(Object r10, String r11, String r12, Logger r13, SpecificationComputer.VerificationMode r14) {
        q.g(r10, CommonKey.KEY_VALUE);
        q.g(r11, "tag");
        q.g(r12, "message");
        q.g(r13, "logger");
        q.g(r14, "verificationMode");
        this.f5240b = r10;
        this.f5241c = r11;
        this.f5242d = r12;
        this.f5243e = r13;
        this.f5244f = r14;
        WindowStrictModeException r15 = new WindowStrictModeException(b(r10, r12));
        StackTraceElement[] r16 = r15.getStackTrace();
        q.f(r16, "stackTrace");
        Object[] r17 = n.p(r16, 2).toArray(new StackTraceElement[0]);
        if (r17 == null) goto L7;
        r15.setStackTrace((StackTraceElement[]) r17);
        this.f5245g = r15;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        SpecificationComputer.VerificationMode r10 = this.f5244f;
        int r11 = a.f5246a[r10.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L7;
        this.f5243e.debug(this.f5241c, b(this.f5240b, this.f5242d));
        return null;
    L7:
        if (r11 != 3) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        throw this.f5245g;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String r10, Function1 r11) {
        q.g(r10, "message");
        q.g(r11, "condition");
        return this;
    }
}
