package androidx.compose.foundation;

import androidx.compose.foundation.MarqueeSpacing;
import androidx.compose.ui.unit.Density;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements MarqueeSpacing {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1723a;
    public final /* synthetic */ float b;

    public /* synthetic */ a(float f, int i) {
        this.f1723a = i;
        this.b = f;
    }

    @Override // androidx.compose.foundation.MarqueeSpacing
    public final int calculateSpacing(Density density, int i, int i6) {
        int i10 = this.f1723a;
        float f = this.b;
        switch (i10) {
            case 0:
                return BasicMarqueeKt.MarqueeSpacing_0680j_4$lambda$1(f, density, i, i6);
            default:
                return MarqueeSpacing.Companion.fractionOfContainer$lambda$0(f, density, i, i6);
        }
    }
}
