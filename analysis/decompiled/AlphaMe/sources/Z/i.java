package Z;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class i extends y1.f {

    /* renamed from: c, reason: collision with root package name */
    public final h f2141c;

    public i(TextView textView) {
        super(20);
        this.f2141c = new h(textView);
    }

    @Override // y1.f
    public final InputFilter[] h(InputFilter[] inputFilterArr) {
        return (X.j.f2054k != null) ^ true ? inputFilterArr : this.f2141c.h(inputFilterArr);
    }

    @Override // y1.f
    public final boolean k() {
        return this.f2141c.f2140e;
    }

    @Override // y1.f
    public final void m(boolean z4) {
        if (!(X.j.f2054k != null)) {
            return;
        }
        this.f2141c.m(z4);
    }

    @Override // y1.f
    public final void n(boolean z4) {
        boolean z5 = !(X.j.f2054k != null);
        h hVar = this.f2141c;
        if (z5) {
            hVar.f2140e = z4;
        } else {
            hVar.n(z4);
        }
    }

    @Override // y1.f
    public final TransformationMethod q(TransformationMethod transformationMethod) {
        return (X.j.f2054k != null) ^ true ? transformationMethod : this.f2141c.q(transformationMethod);
    }
}
