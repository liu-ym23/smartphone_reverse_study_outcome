package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import l.k;
import l.l;
import l.n;
import l.z;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements k, z, AdapterView.OnItemClickListener {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f726f = {R.attr.background, R.attr.divider};

    /* renamed from: c, reason: collision with root package name */
    public l f727c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        m mVarJ = m.J(context, attributeSet, f726f, i);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(mVarJ.A(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(mVarJ.A(1));
        }
        mVarJ.M();
    }

    @Override // l.k
    public final boolean a(n nVar) {
        return this.f727c.q(nVar, null, 0);
    }

    @Override // l.z
    public final void c(l lVar) {
        this.f727c = lVar;
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
        a((n) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }
}
