package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f2422a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f2423b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<View> f2424c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2425d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2426e;

    public h(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f2424c = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        sparseArray.put(com.stepos.aiengine.R.id.icon_frame, view.findViewById(com.stepos.aiengine.R.id.icon_frame));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f2422a = view.getBackground();
        if (textView != null) {
            this.f2423b = textView.getTextColors();
        }
    }

    public final View a(int i10) {
        SparseArray<View> sparseArray = this.f2424c;
        View view = sparseArray.get(i10);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i10);
        if (viewFindViewById != null) {
            sparseArray.put(i10, viewFindViewById);
        }
        return viewFindViewById;
    }
}
