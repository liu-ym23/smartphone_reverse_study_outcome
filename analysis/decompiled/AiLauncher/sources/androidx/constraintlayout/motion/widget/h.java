package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import m0.C4890c;
import q0.AbstractC5140d;

/* loaded from: classes.dex */
public class h extends i {

    /* renamed from: h, reason: collision with root package name */
    public String f12284h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f12285i = d.f12237f;

    /* renamed from: j, reason: collision with root package name */
    public int f12286j = 0;

    /* renamed from: k, reason: collision with root package name */
    public float f12287k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f12288l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f12289m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f12290n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f12291o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f12292p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public int f12293q = 0;

    /* renamed from: r, reason: collision with root package name */
    public float f12294r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f12295s = Float.NaN;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f12296a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12296a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            f12296a.append(R$styleable.KeyPosition_framePosition, 2);
            f12296a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f12296a.append(R$styleable.KeyPosition_curveFit, 4);
            f12296a.append(R$styleable.KeyPosition_drawPath, 5);
            f12296a.append(R$styleable.KeyPosition_percentX, 6);
            f12296a.append(R$styleable.KeyPosition_percentY, 7);
            f12296a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f12296a.append(R$styleable.KeyPosition_sizePercent, 8);
            f12296a.append(R$styleable.KeyPosition_percentWidth, 11);
            f12296a.append(R$styleable.KeyPosition_percentHeight, 12);
            f12296a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void b(h hVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f12296a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, hVar.f12239b);
                            hVar.f12239b = resourceId;
                            if (resourceId == -1) {
                                hVar.f12240c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            hVar.f12240c = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f12239b = typedArray.getResourceId(index, hVar.f12239b);
                            break;
                        }
                    case 2:
                        hVar.f12238a = typedArray.getInt(index, hVar.f12238a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            hVar.f12284h = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f12284h = C4890c.f37052c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        hVar.f12297g = typedArray.getInteger(index, hVar.f12297g);
                        break;
                    case 5:
                        hVar.f12286j = typedArray.getInt(index, hVar.f12286j);
                        break;
                    case 6:
                        hVar.f12289m = typedArray.getFloat(index, hVar.f12289m);
                        break;
                    case 7:
                        hVar.f12290n = typedArray.getFloat(index, hVar.f12290n);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, hVar.f12288l);
                        hVar.f12287k = f10;
                        hVar.f12288l = f10;
                        break;
                    case 9:
                        hVar.f12293q = typedArray.getInt(index, hVar.f12293q);
                        break;
                    case 10:
                        hVar.f12285i = typedArray.getInt(index, hVar.f12285i);
                        break;
                    case 11:
                        hVar.f12287k = typedArray.getFloat(index, hVar.f12287k);
                        break;
                    case 12:
                        hVar.f12288l = typedArray.getFloat(index, hVar.f12288l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12296a.get(index));
                        break;
                }
            }
            if (hVar.f12238a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public h() {
        this.f12241d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, AbstractC5140d> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new h().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        h hVar = (h) dVar;
        this.f12284h = hVar.f12284h;
        this.f12285i = hVar.f12285i;
        this.f12286j = hVar.f12286j;
        this.f12287k = hVar.f12287k;
        this.f12288l = Float.NaN;
        this.f12289m = hVar.f12289m;
        this.f12290n = hVar.f12290n;
        this.f12291o = hVar.f12291o;
        this.f12292p = hVar.f12292p;
        this.f12294r = hVar.f12294r;
        this.f12295s = hVar.f12295s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }
}
