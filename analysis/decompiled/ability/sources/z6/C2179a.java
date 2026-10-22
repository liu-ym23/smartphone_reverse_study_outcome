package z6;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.stepos.widget.list.StepOSListItem;

/* renamed from: z6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2179a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final StepOSListItem f6972a;
    public final ImageView b;
    public final View c;
    public final ImageView d;
    public final View e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final FrameLayout i;

    /* renamed from: j, reason: collision with root package name */
    public final Barrier f6973j;
    public final TextView k;

    public C2179a(StepOSListItem stepOSListItem, ImageView imageView, View view, ImageView imageView2, View view2, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, Barrier barrier, TextView textView4) {
        this.f6972a = stepOSListItem;
        this.b = imageView;
        this.c = view;
        this.d = imageView2;
        this.e = view2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = frameLayout;
        this.f6973j = barrier;
        this.k = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f6972a;
    }
}
