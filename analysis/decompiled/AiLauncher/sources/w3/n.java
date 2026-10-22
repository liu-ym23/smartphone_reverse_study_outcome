package w3;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyu;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r3.C5217k;
import t3.C5506b;
import u3.C5573a;
import x3.C5846a;
import y3.C5938b;
import z2.B8;

/* loaded from: classes2.dex */
public final class n implements l {

    /* renamed from: h, reason: collision with root package name */
    public static final zzcs f43089h = zzcs.l("com.google.android.gms.vision.barcode", "com.google.android.gms.tflite_dynamite");

    /* renamed from: a, reason: collision with root package name */
    public boolean f43090a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f43091b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f43092c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f43093d;

    /* renamed from: e, reason: collision with root package name */
    public final C5506b f43094e;

    /* renamed from: f, reason: collision with root package name */
    public final B8 f43095f;

    /* renamed from: g, reason: collision with root package name */
    public zzyl f43096g;

    public n(Context context, C5506b c5506b, B8 b82) {
        this.f43093d = context;
        this.f43094e = c5506b;
        this.f43095f = b82;
    }

    public static boolean b(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > 0;
    }

    @Override // w3.l
    public final List a(C5846a c5846a) throws MlKitException {
        if (this.f43096g == null) {
            zzc();
        }
        zzyl zzylVar = (zzyl) C1669j.k(this.f43096g);
        if (!this.f43090a) {
            try {
                zzylVar.zze();
                this.f43090a = true;
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to init barcode scanner.", 13, e10);
            }
        }
        int iJ = c5846a.j();
        if (c5846a.e() == 35) {
            iJ = ((Image.Plane[]) C1669j.k(c5846a.h()))[0].getRowStride();
        }
        try {
            List listZzd = zzylVar.zzd(y3.d.b().a(c5846a), new zzyu(c5846a.e(), iJ, c5846a.f(), C5938b.a(c5846a.i()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            Iterator it = listZzd.iterator();
            while (it.hasNext()) {
                arrayList.add(new C5573a(new m((zzyb) it.next()), c5846a.d()));
            }
            return arrayList;
        } catch (RemoteException e11) {
            throw new MlKitException("Failed to run barcode scanner.", 13, e11);
        }
    }

    public final zzyl c(DynamiteModule.a aVar, String str, String str2) throws RemoteException, DynamiteModule.LoadingException {
        boolean z10;
        zzyo zzyoVarZza = zzyn.zza(DynamiteModule.d(this.f43093d, aVar, str).c(str2));
        C5506b c5506b = this.f43094e;
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.f43093d);
        int iA = c5506b.a();
        if (c5506b.d()) {
            z10 = true;
        } else {
            this.f43094e.b();
            z10 = false;
        }
        return zzyoVarZza.zzd(iObjectWrapperWrap, new zzyd(iA, z10));
    }

    @Override // w3.l
    public final void zzb() {
        zzyl zzylVar = this.f43096g;
        if (zzylVar != null) {
            try {
                zzylVar.zzf();
            } catch (RemoteException e10) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e10);
            }
            this.f43096g = null;
            this.f43090a = false;
        }
    }

    @Override // w3.l
    public final boolean zzc() throws MlKitException {
        if (this.f43096g != null) {
            return this.f43091b;
        }
        if (b(this.f43093d)) {
            this.f43091b = true;
            try {
                this.f43096g = c(DynamiteModule.f19888c, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to create thick barcode scanner.", 13, e10);
            } catch (DynamiteModule.LoadingException e11) {
                throw new MlKitException("Failed to load the bundled barcode module.", 13, e11);
            }
        } else {
            this.f43091b = false;
            if (!C5217k.a(this.f43093d, f43089h)) {
                if (!this.f43092c) {
                    C5217k.d(this.f43093d, zzcs.l("barcode", "tflite_dynamite"));
                    this.f43092c = true;
                }
                C5725b.e(this.f43095f, zzrb.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.f43096g = c(DynamiteModule.f19887b, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | DynamiteModule.LoadingException e12) {
                C5725b.e(this.f43095f, zzrb.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin barcode scanner.", 13, e12);
            }
        }
        C5725b.e(this.f43095f, zzrb.NO_ERROR);
        return this.f43091b;
    }
}
