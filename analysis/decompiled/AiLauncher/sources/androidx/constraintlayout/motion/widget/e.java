package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: g, reason: collision with root package name */
    public String f12243g;

    /* renamed from: h, reason: collision with root package name */
    public int f12244h = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12245i = false;

    /* renamed from: j, reason: collision with root package name */
    public float f12246j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f12247k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f12248l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f12249m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f12250n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f12251o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f12252p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f12253q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f12254r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f12255s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f12256t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public float f12257u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    public float f12258v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    public float f12259w = Float.NaN;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f12260a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12260a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            f12260a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f12260a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f12260a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f12260a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f12260a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f12260a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f12260a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f12260a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f12260a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f12260a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f12260a.append(R$styleable.KeyAttribute_framePosition, 12);
            f12260a.append(R$styleable.KeyAttribute_curveFit, 13);
            f12260a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f12260a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f12260a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f12260a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f12260a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(e eVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f12260a.get(index)) {
                    case 1:
                        eVar.f12246j = typedArray.getFloat(index, eVar.f12246j);
                        break;
                    case 2:
                        eVar.f12247k = typedArray.getDimension(index, eVar.f12247k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12260a.get(index));
                        break;
                    case 4:
                        eVar.f12248l = typedArray.getFloat(index, eVar.f12248l);
                        break;
                    case 5:
                        eVar.f12249m = typedArray.getFloat(index, eVar.f12249m);
                        break;
                    case 6:
                        eVar.f12250n = typedArray.getFloat(index, eVar.f12250n);
                        break;
                    case 7:
                        eVar.f12254r = typedArray.getFloat(index, eVar.f12254r);
                        break;
                    case 8:
                        eVar.f12253q = typedArray.getFloat(index, eVar.f12253q);
                        break;
                    case 9:
                        eVar.f12243g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, eVar.f12239b);
                            eVar.f12239b = resourceId;
                            if (resourceId == -1) {
                                eVar.f12240c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            eVar.f12240c = typedArray.getString(index);
                            break;
                        } else {
                            eVar.f12239b = typedArray.getResourceId(index, eVar.f12239b);
                            break;
                        }
                    case 12:
                        eVar.f12238a = typedArray.getInt(index, eVar.f12238a);
                        break;
                    case 13:
                        eVar.f12244h = typedArray.getInteger(index, eVar.f12244h);
                        break;
                    case 14:
                        eVar.f12255s = typedArray.getFloat(index, eVar.f12255s);
                        break;
                    case 15:
                        eVar.f12256t = typedArray.getDimension(index, eVar.f12256t);
                        break;
                    case 16:
                        eVar.f12257u = typedArray.getDimension(index, eVar.f12257u);
                        break;
                    case 17:
                        eVar.f12258v = typedArray.getDimension(index, eVar.f12258v);
                        break;
                    case 18:
                        eVar.f12259w = typedArray.getFloat(index, eVar.f12259w);
                        break;
                    case 19:
                        eVar.f12251o = typedArray.getDimension(index, eVar.f12251o);
                        break;
                    case 20:
                        eVar.f12252p = typedArray.getDimension(index, eVar.f12252p);
                        break;
                }
            }
        }
    }

    public e() {
        this.f12241d = 1;
        this.f12242e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // androidx.constraintlayout.motion.widget.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, q0.AbstractC5140d> r7) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.e.a(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new e().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        e eVar = (e) dVar;
        this.f12244h = eVar.f12244h;
        this.f12245i = eVar.f12245i;
        this.f12246j = eVar.f12246j;
        this.f12247k = eVar.f12247k;
        this.f12248l = eVar.f12248l;
        this.f12249m = eVar.f12249m;
        this.f12250n = eVar.f12250n;
        this.f12251o = eVar.f12251o;
        this.f12252p = eVar.f12252p;
        this.f12253q = eVar.f12253q;
        this.f12254r = eVar.f12254r;
        this.f12255s = eVar.f12255s;
        this.f12256t = eVar.f12256t;
        this.f12257u = eVar.f12257u;
        this.f12258v = eVar.f12258v;
        this.f12259w = eVar.f12259w;
        this.f12243g = eVar.f12243g;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f12246j)) {
            hashSet.add(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);
        }
        if (!Float.isNaN(this.f12247k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f12248l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f12249m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f12250n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f12251o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f12252p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f12256t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f12257u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f12258v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f12253q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f12254r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f12255s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f12259w)) {
            hashSet.add("progress");
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
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void g(HashMap<String, Integer> map) {
        if (this.f12244h == -1) {
            return;
        }
        if (!Float.isNaN(this.f12246j)) {
            map.put(ConstConfig.KEY_VIEW_ALPHA_PROPERTY, Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12247k)) {
            map.put("elevation", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12248l)) {
            map.put("rotation", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12249m)) {
            map.put("rotationX", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12250n)) {
            map.put("rotationY", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12251o)) {
            map.put("transformPivotX", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12252p)) {
            map.put("transformPivotY", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12256t)) {
            map.put("translationX", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12257u)) {
            map.put("translationY", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12258v)) {
            map.put("translationZ", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12253q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12254r)) {
            map.put("scaleX", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12255s)) {
            map.put("scaleY", Integer.valueOf(this.f12244h));
        }
        if (!Float.isNaN(this.f12259w)) {
            map.put("progress", Integer.valueOf(this.f12244h));
        }
        if (this.f12242e.size() > 0) {
            Iterator<String> it = this.f12242e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f12244h));
            }
        }
    }
}
