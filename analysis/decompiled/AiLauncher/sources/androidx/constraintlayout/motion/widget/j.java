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
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: g, reason: collision with root package name */
    public String f12298g;

    /* renamed from: h, reason: collision with root package name */
    public int f12299h = -1;

    /* renamed from: i, reason: collision with root package name */
    public float f12300i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f12301j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f12302k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f12303l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f12304m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f12305n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f12306o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f12307p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f12308q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f12309r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f12310s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f12311t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public int f12312u = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f12313v = null;

    /* renamed from: w, reason: collision with root package name */
    public float f12314w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    public float f12315x = 0.0f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f12316a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12316a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f12316a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f12316a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f12316a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f12316a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f12316a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f12316a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f12316a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f12316a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f12316a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f12316a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f12316a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f12316a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f12316a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f12316a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f12316a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f12316a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f12316a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f12316a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(j jVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f12316a.get(index)) {
                    case 1:
                        jVar.f12300i = typedArray.getFloat(index, jVar.f12300i);
                        break;
                    case 2:
                        jVar.f12301j = typedArray.getDimension(index, jVar.f12301j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12316a.get(index));
                        break;
                    case 4:
                        jVar.f12302k = typedArray.getFloat(index, jVar.f12302k);
                        break;
                    case 5:
                        jVar.f12303l = typedArray.getFloat(index, jVar.f12303l);
                        break;
                    case 6:
                        jVar.f12304m = typedArray.getFloat(index, jVar.f12304m);
                        break;
                    case 7:
                        jVar.f12306o = typedArray.getFloat(index, jVar.f12306o);
                        break;
                    case 8:
                        jVar.f12305n = typedArray.getFloat(index, jVar.f12305n);
                        break;
                    case 9:
                        jVar.f12298g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, jVar.f12239b);
                            jVar.f12239b = resourceId;
                            if (resourceId == -1) {
                                jVar.f12240c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            jVar.f12240c = typedArray.getString(index);
                            break;
                        } else {
                            jVar.f12239b = typedArray.getResourceId(index, jVar.f12239b);
                            break;
                        }
                    case 12:
                        jVar.f12238a = typedArray.getInt(index, jVar.f12238a);
                        break;
                    case 13:
                        jVar.f12299h = typedArray.getInteger(index, jVar.f12299h);
                        break;
                    case 14:
                        jVar.f12307p = typedArray.getFloat(index, jVar.f12307p);
                        break;
                    case 15:
                        jVar.f12308q = typedArray.getDimension(index, jVar.f12308q);
                        break;
                    case 16:
                        jVar.f12309r = typedArray.getDimension(index, jVar.f12309r);
                        break;
                    case 17:
                        jVar.f12310s = typedArray.getDimension(index, jVar.f12310s);
                        break;
                    case 18:
                        jVar.f12311t = typedArray.getFloat(index, jVar.f12311t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            jVar.f12313v = typedArray.getString(index);
                            jVar.f12312u = 7;
                            break;
                        } else {
                            jVar.f12312u = typedArray.getInt(index, jVar.f12312u);
                            break;
                        }
                    case 20:
                        jVar.f12314w = typedArray.getFloat(index, jVar.f12314w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            jVar.f12315x = typedArray.getDimension(index, jVar.f12315x);
                            break;
                        } else {
                            jVar.f12315x = typedArray.getFloat(index, jVar.f12315x);
                            break;
                        }
                }
            }
        }
    }

    public j() {
        this.f12241d = 3;
        this.f12242e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Q(java.util.HashMap<java.lang.String, q0.AbstractC5142f> r11) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.j.Q(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, AbstractC5140d> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new j().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        j jVar = (j) dVar;
        this.f12298g = jVar.f12298g;
        this.f12299h = jVar.f12299h;
        this.f12312u = jVar.f12312u;
        this.f12314w = jVar.f12314w;
        this.f12315x = jVar.f12315x;
        this.f12311t = jVar.f12311t;
        this.f12300i = jVar.f12300i;
        this.f12301j = jVar.f12301j;
        this.f12302k = jVar.f12302k;
        this.f12305n = jVar.f12305n;
        this.f12303l = jVar.f12303l;
        this.f12304m = jVar.f12304m;
        this.f12306o = jVar.f12306o;
        this.f12307p = jVar.f12307p;
        this.f12308q = jVar.f12308q;
        this.f12309r = jVar.f12309r;
        this.f12310s = jVar.f12310s;
        this.f12313v = jVar.f12313v;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f12300i)) {
            hashSet.add(ConstConfig.KEY_VIEW_ALPHA_PROPERTY);
        }
        if (!Float.isNaN(this.f12301j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f12302k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f12303l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f12304m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f12308q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f12309r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f12310s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f12305n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f12306o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f12307p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f12311t)) {
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
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void g(HashMap<String, Integer> map) {
        if (this.f12299h == -1) {
            return;
        }
        if (!Float.isNaN(this.f12300i)) {
            map.put(ConstConfig.KEY_VIEW_ALPHA_PROPERTY, Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12301j)) {
            map.put("elevation", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12302k)) {
            map.put("rotation", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12303l)) {
            map.put("rotationX", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12304m)) {
            map.put("rotationY", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12308q)) {
            map.put("translationX", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12309r)) {
            map.put("translationY", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12310s)) {
            map.put("translationZ", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12305n)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12306o)) {
            map.put("scaleX", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12306o)) {
            map.put("scaleY", Integer.valueOf(this.f12299h));
        }
        if (!Float.isNaN(this.f12311t)) {
            map.put("progress", Integer.valueOf(this.f12299h));
        }
        if (this.f12242e.size() > 0) {
            Iterator<String> it = this.f12242e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f12299h));
            }
        }
    }
}
