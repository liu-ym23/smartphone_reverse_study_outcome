package r3;

import S7.k;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import com.mdisdk.display.OmniDisplay;
import com.mdisdk.display.VirtualDisplayFactory;

/* renamed from: r3.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1877c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5675a;
    public final /* synthetic */ Display b;
    public final /* synthetic */ DisplayMetrics c;
    public final /* synthetic */ Surface d;

    public /* synthetic */ C1877c(Display display, DisplayMetrics displayMetrics, Surface surface, int i) {
        this.f5675a = i;
        this.b = display;
        this.c = displayMetrics;
        this.d = surface;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f5675a) {
            case 0:
                return OmniDisplay.Companion.createForDisplayWithoutEgl$lambda$4(this.b, this.c, this.d, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
            default:
                return OmniDisplay.Companion.createForDisplayWithEgl$lambda$3(this.b, this.c, this.d, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
        }
    }
}
