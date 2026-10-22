package androidx.appcompat.app;

import android.view.ViewGroup;

/* renamed from: androidx.appcompat.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0175a extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public int f2583a;

    public AbstractC0175a(AbstractC0175a abstractC0175a) {
        super((ViewGroup.MarginLayoutParams) abstractC0175a);
        this.f2583a = 0;
        this.f2583a = abstractC0175a.f2583a;
    }

    public AbstractC0175a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f2583a = 0;
    }
}
