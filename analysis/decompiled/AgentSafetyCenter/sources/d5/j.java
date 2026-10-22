package d5;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f3220a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3221b;

    /* renamed from: c, reason: collision with root package name */
    public float f3222c;

    /* renamed from: d, reason: collision with root package name */
    public float f3223d;

    /* renamed from: e, reason: collision with root package name */
    public float f3224e;

    /* renamed from: f, reason: collision with root package name */
    public float f3225f;

    /* renamed from: g, reason: collision with root package name */
    public float f3226g;

    /* renamed from: h, reason: collision with root package name */
    public float f3227h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f3228j;

    /* renamed from: k, reason: collision with root package name */
    public String f3229k;

    /* JADX WARN: Multi-variable type inference failed */
    public j(j jVar, p.e eVar) {
        h hVar;
        this.f3220a = new Matrix();
        this.f3221b = new ArrayList();
        this.f3222c = 0.0f;
        this.f3223d = 0.0f;
        this.f3224e = 0.0f;
        this.f3225f = 1.0f;
        this.f3226g = 1.0f;
        this.f3227h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.f3228j = matrix;
        this.f3229k = null;
        this.f3222c = jVar.f3222c;
        this.f3223d = jVar.f3223d;
        this.f3224e = jVar.f3224e;
        this.f3225f = jVar.f3225f;
        this.f3226g = jVar.f3226g;
        this.f3227h = jVar.f3227h;
        this.i = jVar.i;
        String str = jVar.f3229k;
        this.f3229k = str;
        if (str != null) {
            eVar.put(str, this);
        }
        matrix.set(jVar.f3228j);
        ArrayList arrayList = jVar.f3221b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof j) {
                this.f3221b.add(new j((j) obj, eVar));
            } else {
                if (obj instanceof i) {
                    i iVar = (i) obj;
                    i iVar2 = new i(iVar);
                    iVar2.f3211e = 0.0f;
                    iVar2.f3213g = 1.0f;
                    iVar2.f3214h = 1.0f;
                    iVar2.i = 0.0f;
                    iVar2.f3215j = 1.0f;
                    iVar2.f3216k = 0.0f;
                    iVar2.f3217l = Paint.Cap.BUTT;
                    iVar2.f3218m = Paint.Join.MITER;
                    iVar2.f3219n = 4.0f;
                    iVar2.f3210d = iVar.f3210d;
                    iVar2.f3211e = iVar.f3211e;
                    iVar2.f3213g = iVar.f3213g;
                    iVar2.f3212f = iVar.f3212f;
                    iVar2.f3232c = iVar.f3232c;
                    iVar2.f3214h = iVar.f3214h;
                    iVar2.i = iVar.i;
                    iVar2.f3215j = iVar.f3215j;
                    iVar2.f3216k = iVar.f3216k;
                    iVar2.f3217l = iVar.f3217l;
                    iVar2.f3218m = iVar.f3218m;
                    iVar2.f3219n = iVar.f3219n;
                    hVar = iVar2;
                } else {
                    if (!(obj instanceof h)) {
                        od.f.e("Unknown object in the tree!");
                        throw null;
                    }
                    hVar = new h((h) obj);
                }
                this.f3221b.add(hVar);
                Object obj2 = hVar.f3231b;
                if (obj2 != null) {
                    eVar.put(obj2, hVar);
                }
            }
        }
    }

    @Override // d5.k
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3221b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((k) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // d5.k
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f3221b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((k) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.f3228j;
        matrix.reset();
        matrix.postTranslate(-this.f3223d, -this.f3224e);
        matrix.postScale(this.f3225f, this.f3226g);
        matrix.postRotate(this.f3222c, 0.0f, 0.0f);
        matrix.postTranslate(this.f3227h + this.f3223d, this.i + this.f3224e);
    }

    public String getGroupName() {
        return this.f3229k;
    }

    public Matrix getLocalMatrix() {
        return this.f3228j;
    }

    public float getPivotX() {
        return this.f3223d;
    }

    public float getPivotY() {
        return this.f3224e;
    }

    public float getRotation() {
        return this.f3222c;
    }

    public float getScaleX() {
        return this.f3225f;
    }

    public float getScaleY() {
        return this.f3226g;
    }

    public float getTranslateX() {
        return this.f3227h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f5) {
        if (f5 != this.f3223d) {
            this.f3223d = f5;
            c();
        }
    }

    public void setPivotY(float f5) {
        if (f5 != this.f3224e) {
            this.f3224e = f5;
            c();
        }
    }

    public void setRotation(float f5) {
        if (f5 != this.f3222c) {
            this.f3222c = f5;
            c();
        }
    }

    public void setScaleX(float f5) {
        if (f5 != this.f3225f) {
            this.f3225f = f5;
            c();
        }
    }

    public void setScaleY(float f5) {
        if (f5 != this.f3226g) {
            this.f3226g = f5;
            c();
        }
    }

    public void setTranslateX(float f5) {
        if (f5 != this.f3227h) {
            this.f3227h = f5;
            c();
        }
    }

    public void setTranslateY(float f5) {
        if (f5 != this.i) {
            this.i = f5;
            c();
        }
    }

    public j() {
        this.f3220a = new Matrix();
        this.f3221b = new ArrayList();
        this.f3222c = 0.0f;
        this.f3223d = 0.0f;
        this.f3224e = 0.0f;
        this.f3225f = 1.0f;
        this.f3226g = 1.0f;
        this.f3227h = 0.0f;
        this.i = 0.0f;
        this.f3228j = new Matrix();
        this.f3229k = null;
    }
}
