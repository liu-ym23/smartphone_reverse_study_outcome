package K;

import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* loaded from: classes.dex */
public final class X implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f942a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f943b;

    public /* synthetic */ X(ViewGroup viewGroup, int i4) {
        this.f942a = i4;
        this.f943b = viewGroup;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        int i4 = this.f942a;
        ViewGroup viewGroup = this.f943b;
        switch (i4) {
            case 0:
                return new Z(viewGroup);
            default:
                return new C0093z(new X(viewGroup, 0).iterator(), Y.f944a);
        }
    }
}
