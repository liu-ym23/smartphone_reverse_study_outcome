package w2;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: w2.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1223f0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    private final D2.r<String, Drawable> f23615a;

    /* renamed from: b, reason: collision with root package name */
    private D2.m f23616b;

    /* renamed from: c, reason: collision with root package name */
    private D2.x f23617c;

    public AbstractC1223f0(View view, D2.r<String, Drawable> rVar) {
        super(view);
        this.f23615a = rVar;
    }

    public abstract D2.m a();

    public void b(String str) {
        if (this.f23616b == null) {
            this.f23616b = a();
        }
        if (this.f23617c == null) {
            this.f23617c = new D2.x();
        }
        D2.x xVar = this.f23617c;
        xVar.f1200a = str;
        this.f23615a.d(xVar, this.f23616b);
    }
}
