package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public class k extends d {

    /* renamed from: A, reason: collision with root package name */
    public boolean f12317A;

    /* renamed from: g, reason: collision with root package name */
    public float f12318g = 0.1f;

    /* renamed from: h, reason: collision with root package name */
    public int f12319h;

    /* renamed from: i, reason: collision with root package name */
    public int f12320i;

    /* renamed from: j, reason: collision with root package name */
    public int f12321j;

    /* renamed from: k, reason: collision with root package name */
    public RectF f12322k;

    /* renamed from: l, reason: collision with root package name */
    public RectF f12323l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, Method> f12324m;

    /* renamed from: n, reason: collision with root package name */
    public int f12325n;

    /* renamed from: o, reason: collision with root package name */
    public String f12326o;

    /* renamed from: p, reason: collision with root package name */
    public int f12327p;

    /* renamed from: q, reason: collision with root package name */
    public String f12328q;

    /* renamed from: r, reason: collision with root package name */
    public String f12329r;

    /* renamed from: s, reason: collision with root package name */
    public int f12330s;

    /* renamed from: t, reason: collision with root package name */
    public int f12331t;

    /* renamed from: u, reason: collision with root package name */
    public View f12332u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12333v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12334w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12335x;

    /* renamed from: y, reason: collision with root package name */
    public float f12336y;

    /* renamed from: z, reason: collision with root package name */
    public float f12337z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f12338a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12338a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            f12338a.append(R$styleable.KeyTrigger_onCross, 4);
            f12338a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f12338a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f12338a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f12338a.append(R$styleable.KeyTrigger_triggerId, 6);
            f12338a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f12338a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f12338a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f12338a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f12338a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f12338a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f12338a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(k kVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f12338a.get(index)) {
                    case 1:
                        kVar.f12328q = typedArray.getString(index);
                        break;
                    case 2:
                        kVar.f12329r = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12338a.get(index));
                        break;
                    case 4:
                        kVar.f12326o = typedArray.getString(index);
                        break;
                    case 5:
                        kVar.f12318g = typedArray.getFloat(index, kVar.f12318g);
                        break;
                    case 6:
                        kVar.f12330s = typedArray.getResourceId(index, kVar.f12330s);
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, kVar.f12239b);
                            kVar.f12239b = resourceId;
                            if (resourceId == -1) {
                                kVar.f12240c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.f12240c = typedArray.getString(index);
                            break;
                        } else {
                            kVar.f12239b = typedArray.getResourceId(index, kVar.f12239b);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, kVar.f12238a);
                        kVar.f12238a = integer;
                        kVar.f12336y = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        kVar.f12331t = typedArray.getResourceId(index, kVar.f12331t);
                        break;
                    case 10:
                        kVar.f12317A = typedArray.getBoolean(index, kVar.f12317A);
                        break;
                    case 11:
                        kVar.f12327p = typedArray.getResourceId(index, kVar.f12327p);
                        break;
                    case 12:
                        kVar.f12321j = typedArray.getResourceId(index, kVar.f12321j);
                        break;
                    case 13:
                        kVar.f12319h = typedArray.getResourceId(index, kVar.f12319h);
                        break;
                    case 14:
                        kVar.f12320i = typedArray.getResourceId(index, kVar.f12320i);
                        break;
                }
            }
        }
    }

    public k() {
        int i10 = d.f12237f;
        this.f12319h = i10;
        this.f12320i = i10;
        this.f12321j = i10;
        this.f12322k = new RectF();
        this.f12323l = new RectF();
        this.f12324m = new HashMap<>();
        this.f12325n = -1;
        this.f12326o = null;
        int i11 = d.f12237f;
        this.f12327p = i11;
        this.f12328q = null;
        this.f12329r = null;
        this.f12330s = i11;
        this.f12331t = i11;
        this.f12332u = null;
        this.f12333v = true;
        this.f12334w = true;
        this.f12335x = true;
        this.f12336y = Float.NaN;
        this.f12317A = false;
        this.f12241d = 5;
        this.f12242e = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, AbstractC5140d> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new k().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        k kVar = (k) dVar;
        this.f12325n = kVar.f12325n;
        this.f12326o = kVar.f12326o;
        this.f12327p = kVar.f12327p;
        this.f12328q = kVar.f12328q;
        this.f12329r = kVar.f12329r;
        this.f12330s = kVar.f12330s;
        this.f12331t = kVar.f12331t;
        this.f12332u = kVar.f12332u;
        this.f12318g = kVar.f12318g;
        this.f12333v = kVar.f12333v;
        this.f12334w = kVar.f12334w;
        this.f12335x = kVar.f12335x;
        this.f12336y = kVar.f12336y;
        this.f12337z = kVar.f12337z;
        this.f12317A = kVar.f12317A;
        this.f12322k = kVar.f12322k;
        this.f12323l = kVar.f12323l;
        this.f12324m = kVar.f12324m;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(float r10, android.view.View r11) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.u(float, android.view.View):void");
    }

    public final void v(String str, View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            w(str, view);
            return;
        }
        if (this.f12324m.containsKey(str)) {
            method = this.f12324m.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, null);
                this.f12324m.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.f12324m.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
                return;
            }
        }
        try {
            method.invoke(view, null);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f12326o + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
        }
    }

    public final void w(String str, View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f12242e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z10 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.f12242e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    public final void x(RectF rectF, View view, boolean z10) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }
}
