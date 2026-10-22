package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public Context f4811a;

    /* renamed from: b, reason: collision with root package name */
    public h f4812b;

    /* renamed from: c, reason: collision with root package name */
    public Window f4813c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f4814d;

    /* renamed from: e, reason: collision with root package name */
    public AlertController$RecycleListView f4815e;

    /* renamed from: f, reason: collision with root package name */
    public Button f4816f;

    /* renamed from: g, reason: collision with root package name */
    public Button f4817g;

    /* renamed from: h, reason: collision with root package name */
    public Button f4818h;
    public NestedScrollView i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f4819j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f4820k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f4821l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f4822m;

    /* renamed from: n, reason: collision with root package name */
    public View f4823n;

    /* renamed from: o, reason: collision with root package name */
    public ListAdapter f4824o;

    /* renamed from: p, reason: collision with root package name */
    public int f4825p;

    /* renamed from: q, reason: collision with root package name */
    public int f4826q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4827r;

    /* renamed from: s, reason: collision with root package name */
    public e f4828s;

    /* renamed from: t, reason: collision with root package name */
    public b f4829t;

    public static ViewGroup a(View view, View view2) {
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
}
