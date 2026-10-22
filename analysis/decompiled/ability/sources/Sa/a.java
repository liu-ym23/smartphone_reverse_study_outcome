package Sa;

import android.graphics.drawable.Drawable;
import android.view.View;
import j3.C1595a;

/* loaded from: classes4.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1184a;
    public final /* synthetic */ Drawable b;

    public /* synthetic */ a(Drawable drawable, int i) {
        this.f1184a = i;
        this.b = drawable;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        switch (this.f1184a) {
            case 0:
                c.a((c) this.b);
                break;
            default:
                C1595a c1595a = (C1595a) this.b;
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                c1595a.f4767X = iArr[0];
                view.getWindowVisibleDisplayFrame(c1595a.f4760Q);
                break;
        }
    }
}
