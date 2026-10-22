package w3;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzal;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.List;
import r3.C5217k;
import t3.C5506b;
import u3.C5573a;
import x3.C5846a;
import y3.C5938b;
import z2.B8;

/* loaded from: classes2.dex */
public final class p implements l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f43098a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f43099b;

    /* renamed from: c, reason: collision with root package name */
    public final zzah f43100c;

    /* renamed from: d, reason: collision with root package name */
    public final B8 f43101d;

    /* renamed from: e, reason: collision with root package name */
    public zzaj f43102e;

    public p(Context context, C5506b c5506b, B8 b82) {
        zzah zzahVar = new zzah();
        this.f43100c = zzahVar;
        this.f43099b = context;
        zzahVar.zza = c5506b.a();
        this.f43101d = b82;
    }

    @Override // w3.l
    public final List a(C5846a c5846a) throws MlKitException {
        zzu[] zzuVarArrZzf;
        if (this.f43102e == null) {
            zzc();
        }
        zzaj zzajVar = this.f43102e;
        if (zzajVar == null) {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
        zzaj zzajVar2 = (zzaj) C1669j.k(zzajVar);
        zzan zzanVar = new zzan(c5846a.j(), c5846a.f(), 0, 0L, C5938b.a(c5846a.i()));
        try {
            int iE = c5846a.e();
            if (iE == -1) {
                zzuVarArrZzf = zzajVar2.zzf(ObjectWrapper.wrap(c5846a.b()), zzanVar);
            } else if (iE == 17) {
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(c5846a.c()), zzanVar);
            } else if (iE == 35) {
                Image.Plane[] planeArr = (Image.Plane[]) C1669j.k(c5846a.h());
                zzanVar.zza = planeArr[0].getRowStride();
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), zzanVar);
            } else {
                if (iE != 842094169) {
                    throw new MlKitException("Unsupported image format: " + c5846a.e(), 3);
                }
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(y3.c.d().c(c5846a, false)), zzanVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzu zzuVar : zzuVarArrZzf) {
                arrayList.add(new C5573a(new o(zzuVar), c5846a.d()));
            }
            return arrayList;
        } catch (RemoteException e10) {
            throw new MlKitException("Failed to detect with legacy barcode detector", 13, e10);
        }
    }

    @Override // w3.l
    public final void zzb() {
        zzaj zzajVar = this.f43102e;
        if (zzajVar != null) {
            try {
                zzajVar.zzd();
            } catch (RemoteException e10) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e10);
            }
            this.f43102e = null;
        }
    }

    @Override // w3.l
    public final boolean zzc() throws MlKitException {
        if (this.f43102e != null) {
            return false;
        }
        try {
            zzaj zzajVarZzd = zzal.zza(DynamiteModule.d(this.f43099b, DynamiteModule.f19887b, "com.google.android.gms.vision.dynamite").c("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(ObjectWrapper.wrap(this.f43099b), this.f43100c);
            this.f43102e = zzajVarZzd;
            if (zzajVarZzd == null && !this.f43098a) {
                Log.d("LegacyBarcodeScanner", "Request optional module download.");
                C5217k.c(this.f43099b, "barcode");
                this.f43098a = true;
                C5725b.e(this.f43101d, zzrb.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            C5725b.e(this.f43101d, zzrb.NO_ERROR);
            return false;
        } catch (RemoteException e10) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e10);
        } catch (DynamiteModule.LoadingException e11) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e11);
        }
    }
}
