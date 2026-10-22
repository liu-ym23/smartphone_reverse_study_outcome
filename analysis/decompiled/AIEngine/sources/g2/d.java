package g2;

import androidx.window.core.SpecificationComputer;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d<T> extends SpecificationComputer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f8961a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8962b;

    /* renamed from: c, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f8963c;

    /* renamed from: d, reason: collision with root package name */
    public final a f8964d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Object value, SpecificationComputer.VerificationMode verificationMode, a aVar) {
        g.f(value, "value");
        g.f(verificationMode, "verificationMode");
        this.f8961a = value;
        this.f8962b = "h";
        this.f8963c = verificationMode;
        this.f8964d = aVar;
    }

    @Override // androidx.window.core.SpecificationComputer
    public final T a() {
        return this.f8961a;
    }

    @Override // androidx.window.core.SpecificationComputer
    public final SpecificationComputer<T> c(String str, l<? super T, Boolean> condition) {
        g.f(condition, "condition");
        if (condition.invoke(this.f8961a).booleanValue()) {
            return this;
        }
        return new c(this.f8961a, this.f8962b, str, this.f8964d, this.f8963c);
    }
}
