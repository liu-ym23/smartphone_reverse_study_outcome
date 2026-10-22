package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
import stepos.support.v7.app.Z;

/* renamed from: androidx.appcompat.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0178d implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2587b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2588c;

    public /* synthetic */ C0178d(View view, View view2, Z z4) {
        this.f2586a = view;
        this.f2587b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        Z.s(absListView, this.f2586a, this.f2587b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i4) {
    }
}
