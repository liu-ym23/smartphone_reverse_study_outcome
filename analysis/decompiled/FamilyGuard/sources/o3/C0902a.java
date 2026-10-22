package o3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import i0.C0756a;
import l3.h;
import l3.j;

/* renamed from: o3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0902a {

    /* renamed from: a, reason: collision with root package name */
    private final View f19070a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f19071b;

    /* renamed from: c, reason: collision with root package name */
    public final View f19072c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f19073d;

    /* renamed from: e, reason: collision with root package name */
    public final View f19074e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f19075f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f19076g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f19077h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f19078i;

    /* renamed from: j, reason: collision with root package name */
    public final Barrier f19079j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f19080k;

    private C0902a(View view, ImageView imageView, View view2, ImageView imageView2, View view3, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, Barrier barrier, TextView textView4) {
        this.f19070a = view;
        this.f19071b = imageView;
        this.f19072c = view2;
        this.f19073d = imageView2;
        this.f19074e = view3;
        this.f19075f = textView;
        this.f19076g = textView2;
        this.f19077h = textView3;
        this.f19078i = frameLayout;
        this.f19079j = barrier;
        this.f19080k = textView4;
    }

    public static C0902a a(View view) {
        View viewA;
        View viewA2;
        int i5 = h.f18451z;
        ImageView imageView = (ImageView) C0756a.a(view, i5);
        if (imageView != null && (viewA = C0756a.a(view, (i5 = h.f18409A))) != null) {
            i5 = h.f18410B;
            ImageView imageView2 = (ImageView) C0756a.a(view, i5);
            if (imageView2 != null && (viewA2 = C0756a.a(view, (i5 = h.f18411C))) != null) {
                i5 = h.f18412D;
                TextView textView = (TextView) C0756a.a(view, i5);
                if (textView != null) {
                    i5 = h.f18413E;
                    TextView textView2 = (TextView) C0756a.a(view, i5);
                    if (textView2 != null) {
                        i5 = h.f18414F;
                        TextView textView3 = (TextView) C0756a.a(view, i5);
                        if (textView3 != null) {
                            i5 = h.f18415G;
                            FrameLayout frameLayout = (FrameLayout) C0756a.a(view, i5);
                            if (frameLayout != null) {
                                i5 = h.f18416H;
                                Barrier barrier = (Barrier) C0756a.a(view, i5);
                                if (barrier != null) {
                                    i5 = h.f18417I;
                                    TextView textView4 = (TextView) C0756a.a(view, i5);
                                    if (textView4 != null) {
                                        return new C0902a(view, imageView, viewA, imageView2, viewA2, textView, textView2, textView3, frameLayout, barrier, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0902a b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(j.f18467j, viewGroup);
        return a(viewGroup);
    }
}
