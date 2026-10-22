package r3;

import D2.InterfaceC0793e;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_common.zzai;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* renamed from: r3.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5217k {

    /* renamed from: A, reason: collision with root package name */
    public static final zzai f38772A;

    /* renamed from: B, reason: collision with root package name */
    public static final zzai f38773B;

    /* renamed from: a, reason: collision with root package name */
    public static final Feature[] f38774a = new Feature[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Feature f38775b;

    /* renamed from: c, reason: collision with root package name */
    public static final Feature f38776c;

    /* renamed from: d, reason: collision with root package name */
    public static final Feature f38777d;

    /* renamed from: e, reason: collision with root package name */
    public static final Feature f38778e;

    /* renamed from: f, reason: collision with root package name */
    public static final Feature f38779f;

    /* renamed from: g, reason: collision with root package name */
    public static final Feature f38780g;

    /* renamed from: h, reason: collision with root package name */
    public static final Feature f38781h;

    /* renamed from: i, reason: collision with root package name */
    public static final Feature f38782i;

    /* renamed from: j, reason: collision with root package name */
    public static final Feature f38783j;

    /* renamed from: k, reason: collision with root package name */
    public static final Feature f38784k;

    /* renamed from: l, reason: collision with root package name */
    public static final Feature f38785l;

    /* renamed from: m, reason: collision with root package name */
    public static final Feature f38786m;

    /* renamed from: n, reason: collision with root package name */
    public static final Feature f38787n;

    /* renamed from: o, reason: collision with root package name */
    public static final Feature f38788o;

    /* renamed from: p, reason: collision with root package name */
    public static final Feature f38789p;

    /* renamed from: q, reason: collision with root package name */
    public static final Feature f38790q;

    /* renamed from: r, reason: collision with root package name */
    public static final Feature f38791r;

    /* renamed from: s, reason: collision with root package name */
    public static final Feature f38792s;

    /* renamed from: t, reason: collision with root package name */
    public static final Feature f38793t;

    /* renamed from: u, reason: collision with root package name */
    public static final Feature f38794u;

    /* renamed from: v, reason: collision with root package name */
    public static final Feature f38795v;

    /* renamed from: w, reason: collision with root package name */
    public static final Feature f38796w;

    /* renamed from: x, reason: collision with root package name */
    public static final Feature f38797x;

    /* renamed from: y, reason: collision with root package name */
    public static final Feature f38798y;

    /* renamed from: z, reason: collision with root package name */
    public static final Feature f38799z;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        f38775b = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        f38776c = feature2;
        Feature feature3 = new Feature("vision.face", 1L);
        f38777d = feature3;
        Feature feature4 = new Feature("vision.ica", 1L);
        f38778e = feature4;
        Feature feature5 = new Feature("vision.ocr", 1L);
        f38779f = feature5;
        f38780g = new Feature("mlkit.ocr.chinese", 1L);
        f38781h = new Feature("mlkit.ocr.common", 1L);
        f38782i = new Feature("mlkit.ocr.devanagari", 1L);
        f38783j = new Feature("mlkit.ocr.japanese", 1L);
        f38784k = new Feature("mlkit.ocr.korean", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        f38785l = feature6;
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        f38786m = feature7;
        Feature feature8 = new Feature("tflite_dynamite", 1L);
        f38787n = feature8;
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        f38788o = feature9;
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        f38789p = feature10;
        f38790q = new Feature("mlkit.image.caption", 1L);
        f38791r = new Feature("mlkit.docscan.detect", 1L);
        f38792s = new Feature("mlkit.docscan.crop", 1L);
        f38793t = new Feature("mlkit.docscan.enhance", 1L);
        f38794u = new Feature("mlkit.docscan.ui", 1L);
        f38795v = new Feature("mlkit.docscan.stain", 1L);
        f38796w = new Feature("mlkit.docscan.shadow", 1L);
        f38797x = new Feature("mlkit.quality.aesthetic", 1L);
        f38798y = new Feature("mlkit.quality.technical", 1L);
        f38799z = new Feature("mlkit.segmentation.subject", 1L);
        com.google.android.gms.internal.mlkit_common.a aVar = new com.google.android.gms.internal.mlkit_common.a();
        aVar.a("barcode", feature);
        aVar.a("custom_ica", feature2);
        aVar.a("face", feature3);
        aVar.a("ica", feature4);
        aVar.a("ocr", feature5);
        aVar.a("langid", feature6);
        aVar.a("nlclassifier", feature7);
        aVar.a("tflite_dynamite", feature8);
        aVar.a("barcode_ui", feature9);
        aVar.a("smart_reply", feature10);
        f38772A = aVar.b();
        com.google.android.gms.internal.mlkit_common.a aVar2 = new com.google.android.gms.internal.mlkit_common.a();
        aVar2.a("com.google.android.gms.vision.barcode", feature);
        aVar2.a("com.google.android.gms.vision.custom.ica", feature2);
        aVar2.a("com.google.android.gms.vision.face", feature3);
        aVar2.a("com.google.android.gms.vision.ica", feature4);
        aVar2.a("com.google.android.gms.vision.ocr", feature5);
        aVar2.a("com.google.android.gms.mlkit.langid", feature6);
        aVar2.a("com.google.android.gms.mlkit.nlclassifier", feature7);
        aVar2.a("com.google.android.gms.tflite_dynamite", feature8);
        aVar2.a("com.google.android.gms.mlkit_smartreply", feature10);
        f38773B = aVar2.b();
    }

    @Deprecated
    public static boolean a(Context context, List<String> list) throws Throwable {
        if (com.google.android.gms.common.c.f().a(context) >= 221500000) {
            return b(context, f(f38773B, list));
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                DynamiteModule.d(context, DynamiteModule.f19887b, it.next());
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    public static boolean b(Context context, final Feature[] featureArr) {
        try {
            return ((ModuleAvailabilityResponse) D2.l.a(q2.b.a(context).c(new com.google.android.gms.common.api.e() { // from class: r3.A
                @Override // com.google.android.gms.common.api.e
                public final Feature[] e() {
                    Feature[] featureArr2 = C5217k.f38774a;
                    return featureArr;
                }
            }).d(new InterfaceC0793e() { // from class: r3.B
                @Override // D2.InterfaceC0793e
                public final void onFailure(Exception exc) {
                    Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
                }
            }))).areModulesAvailable();
        } catch (InterruptedException | ExecutionException e10) {
            Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e10);
            return false;
        }
    }

    @Deprecated
    public static void c(Context context, String str) {
        d(context, zzaf.k(str));
    }

    @Deprecated
    public static void d(Context context, List<String> list) {
        if (com.google.android.gms.common.c.f().a(context) >= 221500000) {
            e(context, f(f38772A, list));
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(Const.STR_MART_COMMA, list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }

    public static void e(Context context, final Feature[] featureArr) {
        q2.b.a(context).b(q2.d.d().a(new com.google.android.gms.common.api.e() { // from class: r3.y
            @Override // com.google.android.gms.common.api.e
            public final Feature[] e() {
                Feature[] featureArr2 = C5217k.f38774a;
                return featureArr;
            }
        }).b()).d(new InterfaceC0793e() { // from class: r3.z
            @Override // D2.InterfaceC0793e
            public final void onFailure(Exception exc) {
                Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
            }
        });
    }

    public static Feature[] f(Map map, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            featureArr[i10] = (Feature) C1669j.k((Feature) map.get(list.get(i10)));
        }
        return featureArr;
    }
}
