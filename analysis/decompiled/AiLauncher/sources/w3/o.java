package w3;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import v3.InterfaceC5656a;

/* loaded from: classes2.dex */
public final class o implements InterfaceC5656a {

    /* renamed from: a, reason: collision with root package name */
    public final zzu f43097a;

    public o(zzu zzuVar) {
        this.f43097a = zzuVar;
    }

    @Override // v3.InterfaceC5656a
    public final Rect a() {
        zzu zzuVar = this.f43097a;
        if (zzuVar.zze == null) {
            return null;
        }
        int i10 = 0;
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.zze;
            if (i10 >= pointArr.length) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
            Point point = pointArr[i10];
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
            i10++;
        }
    }

    @Override // v3.InterfaceC5656a
    public final String b() {
        return this.f43097a.zzb;
    }

    @Override // v3.InterfaceC5656a
    public final int c() {
        return this.f43097a.zzd;
    }

    @Override // v3.InterfaceC5656a
    public final Point[] d() {
        return this.f43097a.zze;
    }

    @Override // v3.InterfaceC5656a
    public final int getFormat() {
        return this.f43097a.zza;
    }
}
