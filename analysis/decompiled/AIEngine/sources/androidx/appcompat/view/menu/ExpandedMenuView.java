package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.x0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements f.b, k, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f413b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public f f414a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        x0 x0VarE = x0.e(context, attributeSet, f413b, R.attr.listViewStyle);
        TypedArray typedArray = x0VarE.f948b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(x0VarE.b(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(x0VarE.b(1));
        }
        x0VarE.f();
    }

    @Override // androidx.appcompat.view.menu.k
    public final void c(f fVar) {
        this.f414a = fVar;
    }

    @Override // androidx.appcompat.view.menu.f.b
    public final boolean e(h hVar) {
        return this.f414a.q(hVar, null, 0);
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
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        e((h) getAdapter().getItem(i10));
    }
}
