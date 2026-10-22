package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import q0.AbstractC5139c;
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: g, reason: collision with root package name */
    public String f12261g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f12262h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f12263i = -1;

    /* renamed from: j, reason: collision with root package name */
    public String f12264j = null;

    /* renamed from: k, reason: collision with root package name */
    public float f12265k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f12266l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f12267m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f12268n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public int f12269o = -1;

    /* renamed from: p, reason: collision with root package name */
    public float f12270p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f12271q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f12272r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f12273s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f12274t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public float f12275u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    public float f12276v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    public float f12277w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    public float f12278x = Float.NaN;

    /* renamed from: y, reason: collision with root package name */
    public float f12279y = Float.NaN;

    /* renamed from: z, reason: collision with root package name */
    public float f12280z = Float.NaN;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f12281a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12281a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            f12281a.append(R$styleable.KeyCycle_framePosition, 2);
            f12281a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f12281a.append(R$styleable.KeyCycle_curveFit, 4);
            f12281a.append(R$styleable.KeyCycle_waveShape, 5);
            f12281a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f12281a.append(R$styleable.KeyCycle_waveOffset, 7);
            f12281a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f12281a.append(R$styleable.KeyCycle_android_alpha, 9);
            f12281a.append(R$styleable.KeyCycle_android_elevation, 10);
            f12281a.append(R$styleable.KeyCycle_android_rotation, 11);
            f12281a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f12281a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f12281a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f12281a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f12281a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f12281a.append(R$styleable.KeyCycle_android_translationX, 17);
            f12281a.append(R$styleable.KeyCycle_android_translationY, 18);
            f12281a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f12281a.append(R$styleable.KeyCycle_motionProgress, 20);
            f12281a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f12281a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, fVar.f12239b);
                            fVar.f12239b = resourceId;
                            if (resourceId == -1) {
                                fVar.f12240c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.f12240c = typedArray.getString(index);
                            break;
                        } else {
                            fVar.f12239b = typedArray.getResourceId(index, fVar.f12239b);
                            break;
                        }
                    case 2:
                        fVar.f12238a = typedArray.getInt(index, fVar.f12238a);
                        break;
                    case 3:
                        fVar.f12261g = typedArray.getString(index);
                        break;
                    case 4:
                        fVar.f12262h = typedArray.getInteger(index, fVar.f12262h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            fVar.f12264j = typedArray.getString(index);
                            fVar.f12263i = 7;
                            break;
                        } else {
                            fVar.f12263i = typedArray.getInt(index, fVar.f12263i);
                            break;
                        }
                    case 6:
                        fVar.f12265k = typedArray.getFloat(index, fVar.f12265k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            fVar.f12266l = typedArray.getDimension(index, fVar.f12266l);
                            break;
                        } else {
                            fVar.f12266l = typedArray.getFloat(index, fVar.f12266l);
                            break;
                        }
                    case 8:
                        fVar.f12269o = typedArray.getInt(index, fVar.f12269o);
                        break;
                    case 9:
                        fVar.f12270p = typedArray.getFloat(index, fVar.f12270p);
                        break;
                    case 10:
                        fVar.f12271q = typedArray.getDimension(index, fVar.f12271q);
                        break;
                    case 11:
                        fVar.f12272r = typedArray.getFloat(index, fVar.f12272r);
                        break;
                    case 12:
                        fVar.f12274t = typedArray.getFloat(index, fVar.f12274t);
                        break;
                    case 13:
                        fVar.f12275u = typedArray.getFloat(index, fVar.f12275u);
                        break;
                    case 14:
                        fVar.f12273s = typedArray.getFloat(index, fVar.f12273s);
                        break;
                    case 15:
                        fVar.f12276v = typedArray.getFloat(index, fVar.f12276v);
                        break;
                    case 16:
                        fVar.f12277w = typedArray.getFloat(index, fVar.f12277w);
                        break;
                    case 17:
                        fVar.f12278x = typedArray.getDimension(index, fVar.f12278x);
                        break;
                    case 18:
                        fVar.f12279y = typedArray.getDimension(index, fVar.f12279y);
                        break;
                    case 19:
                        fVar.f12280z = typedArray.getDimension(index, fVar.f12280z);
                        break;
                    case 20:
                        fVar.f12268n = typedArray.getFloat(index, fVar.f12268n);
                        break;
                    case 21:
                        fVar.f12267m = typedArray.getFloat(index, fVar.f12267m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12281a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f12241d = 4;
        this.f12242e = new HashMap<>();
    }

    public void U(HashMap<String, AbstractC5139c> map) {
        AbstractC5139c abstractC5139c;
        AbstractC5139c abstractC5139c2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f12242e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.d() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (abstractC5139c = map.get(str)) != null) {
                    abstractC5139c.d(this.f12238a, this.f12263i, this.f12264j, this.f12269o, this.f12265k, this.f12266l, this.f12267m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float fV = V(str);
                if (!Float.isNaN(fV) && (abstractC5139c2 = map.get(str)) != null) {
                    abstractC5139c2.c(this.f12238a, this.f12263i, this.f12264j, this.f12269o, this.f12265k, this.f12266l, this.f12267m, fV);
                }
            }
        }
    }

    public float V(String str) {
        str.getClass();
        switch (str) {
            case "rotationX":
                return this.f12274t;
            case "rotationY":
                return this.f12275u;
            case "translationX":
                return this.f12278x;
            case "translationY":
                return this.f12279y;
            case "translationZ":
                return this.f12280z;
            case "progress":
                return this.f12268n;
            case "scaleX":
                return this.f12276v;
            case "scaleY":
                return this.f12277w;
            case "rotation":
                return this.f12272r;
            case "elevation":
                return this.f12271q;
            case "transitionPathRotate":
                return this.f12273s;
            case "alpha":
                return this.f12270p;
            case "waveOffset":
                return this.f12266l;
            case "wavePhase":
                return this.f12267m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, AbstractC5140d> map) {
        androidx.constraintlayout.motion.widget.a.g("KeyCycle", "add " + map.size() + " values", 2);
        for (String str : map.keySet()) {
            AbstractC5140d abstractC5140d = map.get(str);
            if (abstractC5140d != null) {
                str.getClass();
                switch (str) {
                    case "rotationX":
                        abstractC5140d.b(this.f12238a, this.f12274t);
                        break;
                    case "rotationY":
                        abstractC5140d.b(this.f12238a, this.f12275u);
                        break;
                    case "translationX":
                        abstractC5140d.b(this.f12238a, this.f12278x);
                        break;
                    case "translationY":
                        abstractC5140d.b(this.f12238a, this.f12279y);
                        break;
                    case "translationZ":
                        abstractC5140d.b(this.f12238a, this.f12280z);
                        break;
                    case "progress":
                        abstractC5140d.b(this.f12238a, this.f12268n);
                        break;
                    case "scaleX":
                        abstractC5140d.b(this.f12238a, this.f12276v);
                        break;
                    case "scaleY":
                        abstractC5140d.b(this.f12238a, this.f12277w);
                        break;
                    case "rotation":
                        abstractC5140d.b(this.f12238a, this.f12272r);
                        break;
                    case "elevation":
                        abstractC5140d.b(this.f12238a, this.f12271q);
                        break;
                    case "transitionPathRotate":
                        abstractC5140d.b(this.f12238a, this.f12273s);
                        break;
                    case "alpha":
                        abstractC5140d.b(this.f12238a, this.f12270p);
                        break;
                    case "waveOffset":
                        abstractC5140d.b(this.f12238a, this.f12266l);
                        break;
                    case "wavePhase":
                        abstractC5140d.b(this.f12238a, this.f12267m);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new f().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        f fVar = (f) dVar;
        this.f12261g = fVar.f12261g;
        this.f12262h = fVar.f12262h;
        this.f12263i = fVar.f12263i;
        this.f12264j = fVar.f12264j;
        this.f12265k = fVar.f12265k;
        this.f12266l = fVar.f12266l;
        this.f12267m = fVar.f12267m;
        this.f12268n = fVar.f12268n;
        this.f12269o = fVar.f12269o;
        this.f12270p = fVar.f12270p;
        this.f12271q = fVar.f12271q;
        this.f12272r = fVar.f12272r;
        this.f12273s = fVar.f12273s;
        this.f12274t = fVar.f12274t;
        this.f12275u = fVar.f12275u;
        this.f12276v = fVar.f12276v;
        this.f12277w = fVar.f12277w;
        this.f12278x = fVar.f12278x;
        this.f12279y = fVar.f12279y;
        this.f12280z = fVar.f12280z;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f12270p)) {
            hashSet.add(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);
        }
        if (!Float.isNaN(this.f12271q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f12272r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f12274t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f12275u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f12276v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f12277w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f12273s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f12278x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f12279y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f12280z)) {
            hashSet.add("translationZ");
        }
        if (this.f12242e.size() > 0) {
            Iterator<String> it = this.f12242e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }
}
