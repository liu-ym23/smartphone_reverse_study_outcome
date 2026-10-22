package I;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h implements K0.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f824a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f825b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(int i4, Object obj) {
        this(Collections.singletonList(new Q0.a(obj)), 2);
        this.f824a = i4;
        if (i4 != 4) {
        } else {
            if (obj == null) {
                throw new IllegalArgumentException("Wrapped Object can not be null.");
            }
            this.f825b = obj;
        }
    }

    public abstract boolean d();

    public abstract float e(Object obj);

    public final boolean f(CharSequence charSequence, int i4) {
        if (charSequence == null || i4 < 0 || charSequence.length() - i4 < 0) {
            throw new IllegalArgumentException();
        }
        g gVar = (g) this.f825b;
        if (gVar == null) {
            return d();
        }
        int iA = gVar.a(charSequence, i4);
        if (iA == 0) {
            return true;
        }
        if (iA != 1) {
            return d();
        }
        return false;
    }

    public abstract void g(Object obj, float f4);

    public final String toString() {
        switch (this.f824a) {
            case 2:
                StringBuilder sb = new StringBuilder();
                if (!((List) this.f825b).isEmpty()) {
                    sb.append("values=");
                    sb.append(Arrays.toString(((List) this.f825b).toArray()));
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h(Object obj, int i4) {
        this.f824a = i4;
        this.f825b = obj;
    }
}
