package w3;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import v3.InterfaceC5656a;

/* loaded from: classes2.dex */
public final class m implements InterfaceC5656a {

    /* renamed from: a, reason: collision with root package name */
    public final zzyb f43088a;

    public m(zzyb zzybVar) {
        this.f43088a = zzybVar;
    }

    @Override // v3.InterfaceC5656a
    public final Rect a() {
        Point[] pointArrZzo = this.f43088a.zzo();
        if (pointArrZzo == null) {
            return null;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : pointArrZzo) {
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    @Override // v3.InterfaceC5656a
    public final String b() {
        return this.f43088a.zzm();
    }

    @Override // v3.InterfaceC5656a
    public final int c() {
        return this.f43088a.zzb();
    }

    @Override // v3.InterfaceC5656a
    public final Point[] d() {
        return this.f43088a.zzo();
    }

    @Override // v3.InterfaceC5656a
    public final int getFormat() {
        return this.f43088a.zza();
    }
}
