package p3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class p extends ArrayAdapter<CharSequence> {

    /* renamed from: a, reason: collision with root package name */
    private final int f19580a;

    /* renamed from: b, reason: collision with root package name */
    private final int f19581b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f19582c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f19583d;

    /* renamed from: e, reason: collision with root package name */
    private final ColorStateList[] f19584e;

    /* renamed from: f, reason: collision with root package name */
    private final LayoutInflater f19585f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i5, int i6, CharSequence[] charSequenceArr, ColorStateList colorStateList, ColorStateList[] colorStateListArr) {
        super(context, i5, i6, charSequenceArr);
        j4.k.g(context, "context");
        j4.k.g(charSequenceArr, "entries");
        this.f19580a = i5;
        this.f19581b = i6;
        this.f19582c = charSequenceArr;
        this.f19583d = colorStateList;
        this.f19584e = colorStateListArr;
        this.f19585f = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        j4.k.g(viewGroup, "parent");
        if (view == null) {
            view = this.f19585f.inflate(this.f19580a, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(this.f19581b);
        textView.setText(this.f19582c[i5]);
        ColorStateList[] colorStateListArr = this.f19584e;
        if (colorStateListArr != null) {
            textView.setTextColor(colorStateListArr[i5]);
        } else {
            ColorStateList colorStateList = this.f19583d;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
        j4.k.d(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
