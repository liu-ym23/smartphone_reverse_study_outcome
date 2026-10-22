package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class K extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f4036a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f4037b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f4038c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4039d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4040e;

    public K(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f4038c = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        sparseArray.put(com.stepos.alphame.R.id.icon_frame, view.findViewById(com.stepos.alphame.R.id.icon_frame));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f4036a = view.getBackground();
        if (textView != null) {
            this.f4037b = textView.getTextColors();
        }
    }

    public final View a(int i4) {
        SparseArray sparseArray = this.f4038c;
        View view = (View) sparseArray.get(i4);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i4);
        if (viewFindViewById != null) {
            sparseArray.put(i4, viewFindViewById);
        }
        return viewFindViewById;
    }
}
