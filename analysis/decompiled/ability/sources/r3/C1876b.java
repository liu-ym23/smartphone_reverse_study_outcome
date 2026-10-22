package r3;

import S7.k;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.mdisdk.display.OmniDisplay;
import com.mdisdk.display.VirtualDisplayFactory;

/* renamed from: r3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1876b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5674a;
    public final /* synthetic */ DisplayMetrics b;
    public final /* synthetic */ Surface c;

    public /* synthetic */ C1876b(DisplayMetrics displayMetrics, Surface surface, int i) {
        this.f5674a = i;
        this.b = displayMetrics;
        this.c = surface;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f5674a) {
            case 0:
                return OmniDisplay.Companion.createWithEgl$lambda$0(this.b, this.c, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
            default:
                return OmniDisplay.Companion.createWithoutEgl$lambda$2(this.b, this.c, (VirtualDisplayFactory.VirtualDisplayBuilder) obj);
        }
    }
}
