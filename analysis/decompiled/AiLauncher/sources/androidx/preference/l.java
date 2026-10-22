package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.N;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class l extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f14426a;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f14427c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray<View> f14428d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14429e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14430f;

    public l(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f14428d = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i10 = R$id.icon_frame;
        sparseArray.put(i10, view.findViewById(i10));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f14426a = view.getBackground();
        if (textView != null) {
            this.f14427c = textView.getTextColors();
        }
    }

    public View a(int i10) {
        View view = this.f14428d.get(i10);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i10);
        if (viewFindViewById != null) {
            this.f14428d.put(i10, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean b() {
        return this.f14429e;
    }

    public boolean c() {
        return this.f14430f;
    }

    public void d() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.f14426a;
        if (background != drawable) {
            N.m0(this.itemView, drawable);
        }
        TextView textView = (TextView) a(R.id.title);
        if (textView == null || this.f14427c == null || textView.getTextColors().equals(this.f14427c)) {
            return;
        }
        textView.setTextColor(this.f14427c);
    }

    public void e(boolean z10) {
        this.f14429e = z10;
    }

    public void f(boolean z10) {
        this.f14430f = z10;
    }
}
