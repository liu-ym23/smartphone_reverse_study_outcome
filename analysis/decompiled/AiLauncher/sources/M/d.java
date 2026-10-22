package M;

import android.util.Size;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator<Size> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4463a;

    public d() {
        this(false);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Size size, Size size2) {
        int iSignum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        return this.f4463a ? iSignum * (-1) : iSignum;
    }

    public d(boolean z10) {
        this.f4463a = z10;
    }
}
