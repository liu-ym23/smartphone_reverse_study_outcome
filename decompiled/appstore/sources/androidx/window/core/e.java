package androidx.window.core;

import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class e extends SpecificationComputer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f5249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Logger f5250e;

    public e(Object r10, String r11, SpecificationComputer.VerificationMode r12, Logger r13) {
        q.g(r10, CommonKey.KEY_VALUE);
        q.g(r11, "tag");
        q.g(r12, "verificationMode");
        q.g(r13, "logger");
        this.f5247b = r10;
        this.f5248c = r11;
        this.f5249d = r12;
        this.f5250e = r13;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        return this.f5247b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String r10, Function1 r11) {
        q.g(r10, "message");
        q.g(r11, "condition");
        if (((Boolean) r11.invoke(this.f5247b)).booleanValue() == false) goto L6;
        return this;
    L6:
        return new d(this.f5247b, this.f5248c, r10, this.f5250e, this.f5249d);
    }
}
