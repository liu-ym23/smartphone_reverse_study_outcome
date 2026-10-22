package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.support.v4.media.session.c;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0642C;
import k.InterfaceC0660n;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements InterfaceC0660n, InterfaceC0642C, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2702b = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public C0661o f2703a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        c cVarY = c.y(R.attr.listViewStyle, 0, context, attributeSet, f2702b);
        if (cVarY.v(0)) {
            setBackgroundDrawable(cVarY.l(0));
        }
        if (cVarY.v(1)) {
            setDivider(cVarY.l(1));
        }
        cVarY.A();
    }

    @Override // k.InterfaceC0660n
    public final boolean a(C0663q c0663q) {
        return this.f2703a.q(c0663q, null, 0);
    }

    @Override // k.InterfaceC0642C
    public final void f(C0661o c0661o) {
        this.f2703a = c0661o;
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
        a((C0663q) getAdapter().getItem(i4));
    }
}
