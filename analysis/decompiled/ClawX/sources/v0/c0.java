package v0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class c0 extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f5804a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5805b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5806c;

    public c0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5804a = new Rect();
        this.f5805b = true;
        this.f5806c = false;
    }

    public c0(int i8, int i9) {
        super(i8, i9);
        this.f5804a = new Rect();
        this.f5805b = true;
        this.f5806c = false;
    }

    public c0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f5804a = new Rect();
        this.f5805b = true;
        this.f5806c = false;
    }

    public c0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f5804a = new Rect();
        this.f5805b = true;
        this.f5806c = false;
    }

    public c0(c0 c0Var) {
        super((ViewGroup.LayoutParams) c0Var);
        this.f5804a = new Rect();
        this.f5805b = true;
        this.f5806c = false;
    }
}
