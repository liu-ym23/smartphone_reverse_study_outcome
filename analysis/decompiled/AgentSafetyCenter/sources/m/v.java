package m;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8089a;

    /* renamed from: b, reason: collision with root package name */
    public final a1.g f8090b;

    public v(TextView textView) {
        this.f8089a = textView;
        a1.g gVar = new a1.g(4, false);
        c4.g gVar2 = new c4.g();
        c4.f fVar = new c4.f();
        fVar.f2199g = textView;
        fVar.i = true;
        c4.d dVar = new c4.d();
        dVar.f2196a = textView;
        VarHandle.storeStoreFence();
        fVar.f2200h = dVar;
        VarHandle.storeStoreFence();
        gVar2.f2201g = fVar;
        VarHandle.storeStoreFence();
        gVar.f19f = gVar2;
        VarHandle.storeStoreFence();
        this.f8090b = gVar;
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((ac.a) this.f8090b.f19f).w(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f8089a.getContext().obtainStyledAttributes(attributeSet, g.a.i, i, 0);
        try {
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z10) {
        ((ac.a) this.f8090b.f19f).S(z10);
    }

    public final void d(boolean z10) {
        ((ac.a) this.f8090b.f19f).T(z10);
    }
}
