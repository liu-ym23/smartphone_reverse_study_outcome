package stepos.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p5.m;
import te.k;
import te.l;
import te.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class ExpandedMenuView extends ListView implements k, x, AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f12542f = {R.attr.background, R.attr.divider};

    /* renamed from: c, reason: collision with root package name */
    public l f12543c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        m mVarJ = m.J(context, attributeSet, f12542f, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(mVarJ.A(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(mVarJ.A(1));
        }
        mVarJ.M();
    }

    @Override // te.x
    public final void b(l lVar) {
        this.f12543c = lVar;
    }

    @Override // te.k
    public final boolean d(te.m mVar) {
        return this.f12543c.p(mVar, null, 0);
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
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        d((te.m) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }
}
