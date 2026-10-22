package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class TwoStateTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private int f21892a;

    /* renamed from: b, reason: collision with root package name */
    private int f21893b;

    /* renamed from: c, reason: collision with root package name */
    private String f21894c;

    /* renamed from: d, reason: collision with root package name */
    private String f21895d;

    /* renamed from: e, reason: collision with root package name */
    private a f21896e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f21897f;

    /* renamed from: g, reason: collision with root package name */
    private I1.f f21898g;

    private enum a {
        COMPLETED,
        PROGRESS
    }

    public TwoStateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21892a = 0;
        this.f21893b = Integer.MAX_VALUE;
        this.f21897f = false;
        a();
        I1.f fVar = new I1.f();
        this.f21898g = fVar;
        fVar.f(this, false, I1.f.f2929e | I1.f.f2931g);
    }

    private void a() {
        this.f21894c = getContext().getResources().getString(X4.j.f6053b);
        this.f21895d = getContext().getResources().getString(X4.j.f6054c);
    }

    private void b() {
        if (this.f21897f) {
            this.f21897f = false;
            if (this.f21893b >= this.f21892a) {
                this.f21896e = a.COMPLETED;
                setText(this.f21895d);
                return;
            } else {
                this.f21896e = a.PROGRESS;
                setText(this.f21894c);
                return;
            }
        }
        a aVar = this.f21896e;
        a aVar2 = a.PROGRESS;
        if (aVar == aVar2 && this.f21893b >= this.f21892a) {
            setText(this.f21895d);
            this.f21896e = a.COMPLETED;
        } else {
            if (aVar != a.COMPLETED || this.f21893b >= this.f21892a) {
                return;
            }
            setText(this.f21894c);
            this.f21896e = aVar2;
        }
    }

    public void setSelectedCount(int i5) {
        this.f21893b = i5;
        b();
    }

    public void setTotalCount(int i5) {
        this.f21892a = i5;
        this.f21897f = true;
    }
}
