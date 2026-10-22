package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class l extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f11125a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f11126b;

    /* renamed from: c, reason: collision with root package name */
    private final SparseArray<View> f11127c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11128d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11129e;

    l(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f11127c = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i5 = o.f11143a;
        sparseArray.put(i5, view.findViewById(i5));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f11125a = view.getBackground();
        if (textView != null) {
            this.f11126b = textView.getTextColors();
        }
    }

    public View a(int i5) {
        View view = this.f11127c.get(i5);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i5);
        if (viewFindViewById != null) {
            this.f11127c.put(i5, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean b() {
        return this.f11128d;
    }

    public boolean c() {
        return this.f11129e;
    }

    void d() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.f11125a;
        if (background != drawable) {
            H.o0(this.itemView, drawable);
        }
        TextView textView = (TextView) a(R.id.title);
        if (textView == null || this.f11126b == null || textView.getTextColors().equals(this.f11126b)) {
            return;
        }
        textView.setTextColor(this.f11126b);
    }

    public void e(boolean z5) {
        this.f11128d = z5;
    }

    public void f(boolean z5) {
        this.f11129e = z5;
    }
}
