package w3;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvw;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import r3.C5214h;
import t3.C5506b;
import z2.A8;
import z2.B8;
import z2.C6152h6;
import z2.C6164i8;
import z2.C6184k8;
import z2.C6315y;
import z2.E8;
import z2.InterfaceC6244q8;
import z2.U5;

/* renamed from: w3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5725b {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f43056a;

    /* renamed from: b, reason: collision with root package name */
    public static final SparseArray f43057b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f43058c;

    /* renamed from: d, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public static final Map f43059d;

    static {
        SparseArray sparseArray = new SparseArray();
        f43056a = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        f43057b = sparseArray2;
        f43058c = new AtomicReference();
        sparseArray.put(-1, zzrn.FORMAT_UNKNOWN);
        sparseArray.put(1, zzrn.FORMAT_CODE_128);
        sparseArray.put(2, zzrn.FORMAT_CODE_39);
        sparseArray.put(4, zzrn.FORMAT_CODE_93);
        sparseArray.put(8, zzrn.FORMAT_CODABAR);
        sparseArray.put(16, zzrn.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zzrn.FORMAT_EAN_13);
        sparseArray.put(64, zzrn.FORMAT_EAN_8);
        sparseArray.put(128, zzrn.FORMAT_ITF);
        sparseArray.put(256, zzrn.FORMAT_QR_CODE);
        sparseArray.put(512, zzrn.FORMAT_UPC_A);
        sparseArray.put(1024, zzrn.FORMAT_UPC_E);
        sparseArray.put(2048, zzrn.FORMAT_PDF417);
        sparseArray.put(4096, zzrn.FORMAT_AZTEC);
        sparseArray2.put(0, zzro.TYPE_UNKNOWN);
        sparseArray2.put(1, zzro.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zzro.TYPE_EMAIL);
        sparseArray2.put(3, zzro.TYPE_ISBN);
        sparseArray2.put(4, zzro.TYPE_PHONE);
        sparseArray2.put(5, zzro.TYPE_PRODUCT);
        sparseArray2.put(6, zzro.TYPE_SMS);
        sparseArray2.put(7, zzro.TYPE_TEXT);
        sparseArray2.put(8, zzro.TYPE_URL);
        sparseArray2.put(9, zzro.TYPE_WIFI);
        sparseArray2.put(10, zzro.TYPE_GEO);
        sparseArray2.put(11, zzro.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zzro.TYPE_DRIVER_LICENSE);
        HashMap map = new HashMap();
        f43059d = map;
        map.put(1, zzvw.CODE_128);
        map.put(2, zzvw.CODE_39);
        map.put(4, zzvw.CODE_93);
        map.put(8, zzvw.CODABAR);
        map.put(16, zzvw.DATA_MATRIX);
        map.put(32, zzvw.EAN_13);
        map.put(64, zzvw.EAN_8);
        map.put(128, zzvw.ITF);
        map.put(256, zzvw.QR_CODE);
        map.put(512, zzvw.UPC_A);
        map.put(1024, zzvw.UPC_E);
        map.put(2048, zzvw.PDF417);
        map.put(4096, zzvw.AZTEC);
    }

    public static zzrn a(int i10) {
        zzrn zzrnVar = (zzrn) f43056a.get(i10);
        return zzrnVar == null ? zzrn.FORMAT_UNKNOWN : zzrnVar;
    }

    public static zzro b(int i10) {
        zzro zzroVar = (zzro) f43057b.get(i10);
        return zzroVar == null ? zzro.TYPE_UNKNOWN : zzroVar;
    }

    public static C6184k8 c(C5506b c5506b) {
        int iA = c5506b.a();
        C6315y c6315y = new C6315y();
        if (iA == 0) {
            c6315y.f(f43059d.values());
        } else {
            for (Map.Entry entry : f43059d.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & iA) != 0) {
                    c6315y.e((zzvw) entry.getValue());
                }
            }
        }
        C6164i8 c6164i8 = new C6164i8();
        c6164i8.b(c6315y.g());
        return c6164i8.c();
    }

    public static String d() {
        return true != f() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
    }

    public static void e(B8 b82, final zzrb zzrbVar) {
        b82.f(new A8() { // from class: w3.a
            @Override // z2.A8
            public final InterfaceC6244q8 zza() {
                U5 u52 = new U5();
                zzra zzraVar = C5725b.f() ? zzra.TYPE_THICK : zzra.TYPE_THIN;
                zzrb zzrbVar2 = zzrbVar;
                u52.e(zzraVar);
                C6152h6 c6152h6 = new C6152h6();
                c6152h6.b(zzrbVar2);
                u52.h(c6152h6.c());
                return E8.d(u52);
            }
        }, zzrc.ON_DEVICE_BARCODE_LOAD);
    }

    public static boolean f() {
        AtomicReference atomicReference = f43058c;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean zB = n.b(C5214h.c().b());
        atomicReference.set(Boolean.valueOf(zB));
        return zB;
    }
}
