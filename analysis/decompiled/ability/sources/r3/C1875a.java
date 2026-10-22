package r3;

import S7.k;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.mdisdk.display.OmniDisplay;
import com.mdisdk.display.VirtualDisplayFactory;

/* renamed from: r3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1875a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5673a;
    public final /* synthetic */ OmniDisplay b;
    public final /* synthetic */ DisplayMetrics c;
    public final /* synthetic */ Surface d;

    public /* synthetic */ C1875a(OmniDisplay omniDisplay, DisplayMetrics displayMetrics, Surface surface, int i) {
        this.f5673a = i;
        this.b = omniDisplay;
        this.c = displayMetrics;
        this.d = surface;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f5673a) {
            case 0:
                return OmniDisplay.createVirtualDisplayForOutput$lambda$0(this.b, this.c, this.d, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
            default:
                return OmniDisplay.createVirtualDisplayForOutputWithoutEgl$lambda$1(this.b, this.c, this.d, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
        }
    }
}
