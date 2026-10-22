package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import m0.C4890c;
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public class l implements Comparable<l> {

    /* renamed from: D, reason: collision with root package name */
    public static String[] f12339D = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: c, reason: collision with root package name */
    public int f12345c;

    /* renamed from: t, reason: collision with root package name */
    public C4890c f12362t;

    /* renamed from: v, reason: collision with root package name */
    public float f12364v;

    /* renamed from: w, reason: collision with root package name */
    public float f12365w;

    /* renamed from: x, reason: collision with root package name */
    public float f12366x;

    /* renamed from: y, reason: collision with root package name */
    public float f12367y;

    /* renamed from: z, reason: collision with root package name */
    public float f12368z;

    /* renamed from: a, reason: collision with root package name */
    public float f12343a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f12344b = 0;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f12346d = new LinkedHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public int f12347e = 0;

    /* renamed from: f, reason: collision with root package name */
    public double[] f12348f = new double[18];

    /* renamed from: g, reason: collision with root package name */
    public double[] f12349g = new double[18];

    /* renamed from: h, reason: collision with root package name */
    public float f12350h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12351i = false;

    /* renamed from: j, reason: collision with root package name */
    public float f12352j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f12353k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public float f12354l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f12355m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f12356n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f12357o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f12358p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f12359q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    public float f12360r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    public float f12361s = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    public int f12363u = 0;

    /* renamed from: A, reason: collision with root package name */
    public float f12340A = Float.NaN;

    /* renamed from: B, reason: collision with root package name */
    public float f12341B = Float.NaN;

    /* renamed from: C, reason: collision with root package name */
    public int f12342C = -1;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap<String, AbstractC5140d> map, int i10) {
        for (String str : map.keySet()) {
            AbstractC5140d abstractC5140d = map.get(str);
            if (abstractC5140d != null) {
                str.getClass();
                char c10 = 65535;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -760884510:
                        if (str.equals("transformPivotX")) {
                            c10 = '\b';
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals("transformPivotY")) {
                            c10 = '\t';
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c10 = '\n';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c10 = '\f';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(ConstConfig.KEY_VIEW_ALPHA_PROPERTY)) {
                            c10 = '\r';
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        abstractC5140d.b(i10, Float.isNaN(this.f12354l) ? 0.0f : this.f12354l);
                        break;
                    case 1:
                        abstractC5140d.b(i10, Float.isNaN(this.f12343a) ? 0.0f : this.f12343a);
                        break;
                    case 2:
                        abstractC5140d.b(i10, Float.isNaN(this.f12359q) ? 0.0f : this.f12359q);
                        break;
                    case 3:
                        abstractC5140d.b(i10, Float.isNaN(this.f12360r) ? 0.0f : this.f12360r);
                        break;
                    case 4:
                        abstractC5140d.b(i10, Float.isNaN(this.f12361s) ? 0.0f : this.f12361s);
                        break;
                    case 5:
                        abstractC5140d.b(i10, Float.isNaN(this.f12341B) ? 0.0f : this.f12341B);
                        break;
                    case 6:
                        abstractC5140d.b(i10, Float.isNaN(this.f12355m) ? 1.0f : this.f12355m);
                        break;
                    case 7:
                        abstractC5140d.b(i10, Float.isNaN(this.f12356n) ? 1.0f : this.f12356n);
                        break;
                    case '\b':
                        abstractC5140d.b(i10, Float.isNaN(this.f12357o) ? 0.0f : this.f12357o);
                        break;
                    case '\t':
                        abstractC5140d.b(i10, Float.isNaN(this.f12358p) ? 0.0f : this.f12358p);
                        break;
                    case '\n':
                        abstractC5140d.b(i10, Float.isNaN(this.f12353k) ? 0.0f : this.f12353k);
                        break;
                    case 11:
                        abstractC5140d.b(i10, Float.isNaN(this.f12352j) ? 0.0f : this.f12352j);
                        break;
                    case '\f':
                        abstractC5140d.b(i10, Float.isNaN(this.f12340A) ? 0.0f : this.f12340A);
                        break;
                    case '\r':
                        abstractC5140d.b(i10, Float.isNaN(this.f12350h) ? 1.0f : this.f12350h);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            String str2 = str.split(Const.STR_MART_COMMA)[1];
                            if (this.f12346d.containsKey(str2)) {
                                ConstraintAttribute constraintAttribute = this.f12346d.get(str2);
                                if (abstractC5140d instanceof AbstractC5140d.b) {
                                    ((AbstractC5140d.b) abstractC5140d).h(i10, constraintAttribute);
                                    break;
                                } else {
                                    Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i10 + ", value" + constraintAttribute.e() + abstractC5140d);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN spline " + str);
                            break;
                        }
                }
            }
        }
    }

    public void b(View view) {
        this.f12345c = view.getVisibility();
        this.f12350h = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f12351i = false;
        this.f12352j = view.getElevation();
        this.f12353k = view.getRotation();
        this.f12354l = view.getRotationX();
        this.f12343a = view.getRotationY();
        this.f12355m = view.getScaleX();
        this.f12356n = view.getScaleY();
        this.f12357o = view.getPivotX();
        this.f12358p = view.getPivotY();
        this.f12359q = view.getTranslationX();
        this.f12360r = view.getTranslationY();
        this.f12361s = view.getTranslationZ();
    }

    public void c(c.a aVar) {
        c.d dVar = aVar.f12723c;
        int i10 = dVar.f12828c;
        this.f12344b = i10;
        int i11 = dVar.f12827b;
        this.f12345c = i11;
        this.f12350h = (i11 == 0 || i10 != 0) ? dVar.f12829d : 0.0f;
        c.e eVar = aVar.f12726f;
        this.f12351i = eVar.f12844m;
        this.f12352j = eVar.f12845n;
        this.f12353k = eVar.f12833b;
        this.f12354l = eVar.f12834c;
        this.f12343a = eVar.f12835d;
        this.f12355m = eVar.f12836e;
        this.f12356n = eVar.f12837f;
        this.f12357o = eVar.f12838g;
        this.f12358p = eVar.f12839h;
        this.f12359q = eVar.f12841j;
        this.f12360r = eVar.f12842k;
        this.f12361s = eVar.f12843l;
        this.f12362t = C4890c.c(aVar.f12724d.f12815d);
        c.C0154c c0154c = aVar.f12724d;
        this.f12340A = c0154c.f12820i;
        this.f12363u = c0154c.f12817f;
        this.f12342C = c0154c.f12813b;
        this.f12341B = aVar.f12723c.f12830e;
        for (String str : aVar.f12727g.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f12727g.get(str);
            if (constraintAttribute.g()) {
                this.f12346d.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return Float.compare(this.f12364v, lVar.f12364v);
    }

    public final boolean i(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    public void j(l lVar, HashSet<String> hashSet) {
        if (i(this.f12350h, lVar.f12350h)) {
            hashSet.add(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);
        }
        if (i(this.f12352j, lVar.f12352j)) {
            hashSet.add("elevation");
        }
        int i10 = this.f12345c;
        int i11 = lVar.f12345c;
        if (i10 != i11 && this.f12344b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);
        }
        if (i(this.f12353k, lVar.f12353k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f12340A) || !Float.isNaN(lVar.f12340A)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f12341B) || !Float.isNaN(lVar.f12341B)) {
            hashSet.add("progress");
        }
        if (i(this.f12354l, lVar.f12354l)) {
            hashSet.add("rotationX");
        }
        if (i(this.f12343a, lVar.f12343a)) {
            hashSet.add("rotationY");
        }
        if (i(this.f12357o, lVar.f12357o)) {
            hashSet.add("transformPivotX");
        }
        if (i(this.f12358p, lVar.f12358p)) {
            hashSet.add("transformPivotY");
        }
        if (i(this.f12355m, lVar.f12355m)) {
            hashSet.add("scaleX");
        }
        if (i(this.f12356n, lVar.f12356n)) {
            hashSet.add("scaleY");
        }
        if (i(this.f12359q, lVar.f12359q)) {
            hashSet.add("translationX");
        }
        if (i(this.f12360r, lVar.f12360r)) {
            hashSet.add("translationY");
        }
        if (i(this.f12361s, lVar.f12361s)) {
            hashSet.add("translationZ");
        }
    }

    public void k(float f10, float f11, float f12, float f13) {
        this.f12365w = f10;
        this.f12366x = f11;
        this.f12367y = f12;
        this.f12368z = f13;
    }

    public void l(Rect rect, View view, int i10, float f10) {
        k(rect.left, rect.top, rect.width(), rect.height());
        b(view);
        this.f12357o = Float.NaN;
        this.f12358p = Float.NaN;
        if (i10 == 1) {
            this.f12353k = f10 - 90.0f;
        } else {
            if (i10 != 2) {
                return;
            }
            this.f12353k = f10 + 90.0f;
        }
    }

    public void m(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        k(rect.left, rect.top, rect.width(), rect.height());
        c(cVar.F(i11));
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                }
            }
            float f10 = this.f12353k + 90.0f;
            this.f12353k = f10;
            if (f10 > 180.0f) {
                this.f12353k = f10 - 360.0f;
                return;
            }
            return;
        }
        this.f12353k -= 90.0f;
    }

    public void n(View view) {
        k(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
