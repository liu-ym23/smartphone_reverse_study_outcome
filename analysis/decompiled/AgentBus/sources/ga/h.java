package ga;

import d7.h0;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f4023a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f4024b;

    /* renamed from: c, reason: collision with root package name */
    public h0 f4025c;

    public h(Matcher matcher, CharSequence charSequence) {
        q7.k.e(charSequence, "input");
        this.f4023a = matcher;
        this.f4024b = charSequence;
    }

    public final List a() {
        if (this.f4025c == null) {
            this.f4025c = new h0(this);
        }
        h0 h0Var = this.f4025c;
        q7.k.b(h0Var);
        return h0Var;
    }
}
