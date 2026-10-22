package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.stepos.alphame.R;
import g.AbstractC0560a;

/* renamed from: androidx.appcompat.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0185k {

    /* renamed from: A, reason: collision with root package name */
    public TextView f2620A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f2621B;

    /* renamed from: C, reason: collision with root package name */
    public View f2622C;

    /* renamed from: D, reason: collision with root package name */
    public ListAdapter f2623D;

    /* renamed from: F, reason: collision with root package name */
    public final int f2625F;

    /* renamed from: G, reason: collision with root package name */
    public final int f2626G;

    /* renamed from: H, reason: collision with root package name */
    public final int f2627H;

    /* renamed from: I, reason: collision with root package name */
    public final int f2628I;

    /* renamed from: J, reason: collision with root package name */
    public final int f2629J;

    /* renamed from: K, reason: collision with root package name */
    public final boolean f2630K;

    /* renamed from: L, reason: collision with root package name */
    public final HandlerC0183i f2631L;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2633a;

    /* renamed from: b, reason: collision with root package name */
    public final DialogInterfaceC0187m f2634b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f2635c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2636d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f2637e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f2638f;

    /* renamed from: g, reason: collision with root package name */
    public AlertController$RecycleListView f2639g;

    /* renamed from: h, reason: collision with root package name */
    public View f2640h;

    /* renamed from: i, reason: collision with root package name */
    public int f2641i;

    /* renamed from: k, reason: collision with root package name */
    public Button f2643k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2644l;

    /* renamed from: m, reason: collision with root package name */
    public Message f2645m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f2646n;

    /* renamed from: o, reason: collision with root package name */
    public Button f2647o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f2648p;

    /* renamed from: q, reason: collision with root package name */
    public Message f2649q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f2650r;

    /* renamed from: s, reason: collision with root package name */
    public Button f2651s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f2652t;

    /* renamed from: u, reason: collision with root package name */
    public Message f2653u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f2654v;

    /* renamed from: w, reason: collision with root package name */
    public NestedScrollView f2655w;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f2657y;

    /* renamed from: z, reason: collision with root package name */
    public ImageView f2658z;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2642j = false;

    /* renamed from: x, reason: collision with root package name */
    public int f2656x = 0;

    /* renamed from: E, reason: collision with root package name */
    public int f2624E = -1;

    /* renamed from: M, reason: collision with root package name */
    public final ViewOnClickListenerC0177c f2632M = new ViewOnClickListenerC0177c(0, this);

    public C0185k(Context context, DialogInterfaceC0187m dialogInterfaceC0187m, Window window) {
        this.f2633a = context;
        this.f2634b = dialogInterfaceC0187m;
        this.f2635c = window;
        this.f2631L = new HandlerC0183i(dialogInterfaceC0187m, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0560a.f12592e, R.attr.alertDialogStyle, 0);
        this.f2625F = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f2626G = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f2627H = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.f2628I = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.f2629J = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f2630K = typedArrayObtainStyledAttributes.getBoolean(10, true);
        this.f2636d = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogInterfaceC0187m.h().w(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.f2631L.obtainMessage(i4, onClickListener) : null;
        if (i4 == -3) {
            this.f2652t = charSequence;
            this.f2653u = messageObtainMessage;
            this.f2654v = null;
        } else if (i4 == -2) {
            this.f2648p = charSequence;
            this.f2649q = messageObtainMessage;
            this.f2650r = null;
        } else {
            if (i4 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f2644l = charSequence;
            this.f2645m = messageObtainMessage;
            this.f2646n = null;
        }
    }
}
