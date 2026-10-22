package b72;

import android.text.Editable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Editable f17913a;

    public d(Editable r100) {
        this.f17913a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        e90.a r102 = (e90.a) r100;
        e90.a r103 = (e90.a) r101;
        if (this.f17913a.getSpanStart(r102) == this.f17913a.getSpanStart(r103)) goto L6;
        return this.f17913a.getSpanStart(r102) - this.f17913a.getSpanStart(r103);
    L6:
        return this.f17913a.getSpanEnd(r103) - this.f17913a.getSpanEnd(r102);
    }
}
