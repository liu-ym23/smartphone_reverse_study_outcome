package r2;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.api.internal.p;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.functor.FunctorApi31Impl;

/* loaded from: classes.dex */
public abstract class d extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final FunctorApi31Impl f14081a;

    /* renamed from: b, reason: collision with root package name */
    public c f14082b;

    /* renamed from: c, reason: collision with root package name */
    public A2.a f14083c;

    /* renamed from: d, reason: collision with root package name */
    public s2.b f14084d;

    public d() {
        p pVar = new p(21, this);
        if (RenderFilter.f12295f) {
            return;
        }
        this.f14081a = new FunctorApi31Impl(pVar);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }
}
