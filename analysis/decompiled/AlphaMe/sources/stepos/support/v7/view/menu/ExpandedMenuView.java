package stepos.support.v7.view.menu;

import L3.j;
import L3.k;
import L3.l;
import L3.y;
import android.R;
import android.content.Context;
import android.support.v4.media.session.c;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* loaded from: classes2.dex */
public final class ExpandedMenuView extends ListView implements j, y, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f14678b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public k f14679a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        c cVarY = c.y(R.attr.listViewStyle, 0, context, attributeSet, f14678b);
        if (cVarY.v(0)) {
            setBackgroundDrawable(cVarY.l(0));
        }
        if (cVarY.v(1)) {
            setDivider(cVarY.l(1));
        }
        cVarY.A();
    }

    @Override // L3.j
    public final boolean d(l lVar) {
        return this.f14679a.p(lVar, null, 0);
    }

    @Override // L3.y
    public final void e(k kVar) {
        this.f14679a = kVar;
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
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        d((l) getAdapter().getItem(i4));
    }
}
