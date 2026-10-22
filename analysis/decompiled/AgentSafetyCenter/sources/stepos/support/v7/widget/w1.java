package stepos.support.v7.widget;

import android.view.View;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public View f12895a;

    /* renamed from: b, reason: collision with root package name */
    public int f12896b;

    /* renamed from: c, reason: collision with root package name */
    public int f12897c;

    /* renamed from: d, reason: collision with root package name */
    public int f12898d;

    public final void a() {
        View view = this.f12895a;
        int top = this.f12898d - (view.getTop() - this.f12896b);
        WeakHashMap weakHashMap = n3.k0.f8724a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f12897c));
    }
}
