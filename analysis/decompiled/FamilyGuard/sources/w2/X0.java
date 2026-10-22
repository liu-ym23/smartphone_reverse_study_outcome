package w2;

import androidx.lifecycle.AbstractC0545z;
import com.stepos.digitalwellbeing.server.data.DataToken;
import v2.AbstractC1182a;

/* loaded from: classes.dex */
public abstract class X0 extends AbstractC1182a implements V0 {

    /* renamed from: b, reason: collision with root package name */
    protected androidx.lifecycle.B<DataToken> f23591b;

    /* renamed from: c, reason: collision with root package name */
    protected androidx.lifecycle.B<DataToken> f23592c;

    /* renamed from: d, reason: collision with root package name */
    protected androidx.lifecycle.B<com.stepos.familyguard.ui.usage.U> f23593d;

    /* renamed from: e, reason: collision with root package name */
    protected androidx.lifecycle.B<com.stepos.familyguard.ui.usage.x> f23594e;

    /* renamed from: f, reason: collision with root package name */
    protected androidx.lifecycle.B<Long> f23595f;

    public X0(v2.e eVar) {
        super(eVar);
        this.f23591b = new androidx.lifecycle.B<>();
        this.f23592c = new androidx.lifecycle.B<>();
        this.f23593d = new androidx.lifecycle.B<>();
        this.f23594e = new androidx.lifecycle.B<>();
        this.f23595f = new androidx.lifecycle.B<>();
    }

    public AbstractC0545z<Long> J() {
        return this.f23595f;
    }

    public AbstractC0545z<DataToken> K() {
        return this.f23592c;
    }

    public AbstractC0545z<com.stepos.familyguard.ui.usage.x> L() {
        return this.f23594e;
    }

    public AbstractC0545z<DataToken> M() {
        return this.f23591b;
    }

    public AbstractC0545z<com.stepos.familyguard.ui.usage.U> N() {
        return this.f23593d;
    }
}
