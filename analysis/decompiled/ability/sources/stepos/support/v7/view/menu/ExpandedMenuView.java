package stepos.support.v7.view.menu;

import Va.D;
import Va.m;
import Va.n;
import Va.q;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes4.dex */
public final class ExpandedMenuView extends ListView implements m, D, AdapterView.OnItemClickListener {
    public static final int[] b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public n f6377a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, b, R.attr.listViewStyle, 0);
        if (tintTypedArrayObtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            setDivider(tintTypedArrayObtainStyledAttributes.getDrawable(1));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    @Override // Va.D
    public final void a(n nVar) {
        this.f6377a = nVar;
    }

    @Override // Va.m
    public final boolean b(q qVar) {
        return this.f6377a.p(qVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        b((q) getAdapter().getItem(i));
    }
}
