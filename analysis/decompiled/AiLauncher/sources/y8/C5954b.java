package y8;

import android.graphics.Rect;

/* renamed from: y8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5954b extends io.noties.markwon.image.i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f43946a;

    public C5954b(boolean z10) {
        this.f43946a = z10;
    }

    @Override // io.noties.markwon.image.i
    public Rect a(io.noties.markwon.image.a aVar) {
        Rect bounds = aVar.g().getBounds();
        int iF = aVar.f();
        if (!this.f43946a) {
            return bounds;
        }
        int iWidth = bounds.width();
        if (iWidth < iF) {
            return new Rect(0, 0, iF, bounds.height());
        }
        if (iWidth <= iF) {
            return bounds;
        }
        return new Rect(0, 0, iF, (int) ((iF / (iWidth / bounds.height())) + 0.5f));
    }
}
