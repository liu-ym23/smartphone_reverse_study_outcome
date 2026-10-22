package p0;

import android.graphics.Matrix;
import android.graphics.Paint;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f13869a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13870b;

    /* renamed from: c, reason: collision with root package name */
    public float f13871c;

    /* renamed from: d, reason: collision with root package name */
    public float f13872d;

    /* renamed from: e, reason: collision with root package name */
    public float f13873e;

    /* renamed from: f, reason: collision with root package name */
    public float f13874f;

    /* renamed from: g, reason: collision with root package name */
    public float f13875g;

    /* renamed from: h, reason: collision with root package name */
    public float f13876h;

    /* renamed from: i, reason: collision with root package name */
    public float f13877i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f13878j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13879k;

    /* renamed from: l, reason: collision with root package name */
    public String f13880l;

    public i() {
        this.f13869a = new Matrix();
        this.f13870b = new ArrayList();
        this.f13871c = Property.DEFAULT_FLOAT_VALUE;
        this.f13872d = Property.DEFAULT_FLOAT_VALUE;
        this.f13873e = Property.DEFAULT_FLOAT_VALUE;
        this.f13874f = 1.0f;
        this.f13875g = 1.0f;
        this.f13876h = Property.DEFAULT_FLOAT_VALUE;
        this.f13877i = Property.DEFAULT_FLOAT_VALUE;
        this.f13878j = new Matrix();
        this.f13880l = null;
    }

    @Override // p0.j
    public final boolean a() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f13870b;
            if (i4 >= arrayList.size()) {
                return false;
            }
            if (((j) arrayList.get(i4)).a()) {
                return true;
            }
            i4++;
        }
    }

    @Override // p0.j
    public final boolean b(int[] iArr) {
        int i4 = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f13870b;
            if (i4 >= arrayList.size()) {
                return zB;
            }
            zB |= ((j) arrayList.get(i4)).b(iArr);
            i4++;
        }
    }

    public final void c() {
        Matrix matrix = this.f13878j;
        matrix.reset();
        matrix.postTranslate(-this.f13872d, -this.f13873e);
        matrix.postScale(this.f13874f, this.f13875g);
        matrix.postRotate(this.f13871c, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        matrix.postTranslate(this.f13876h + this.f13872d, this.f13877i + this.f13873e);
    }

    public String getGroupName() {
        return this.f13880l;
    }

    public Matrix getLocalMatrix() {
        return this.f13878j;
    }

    public float getPivotX() {
        return this.f13872d;
    }

    public float getPivotY() {
        return this.f13873e;
    }

    public float getRotation() {
        return this.f13871c;
    }

    public float getScaleX() {
        return this.f13874f;
    }

    public float getScaleY() {
        return this.f13875g;
    }

    public float getTranslateX() {
        return this.f13876h;
    }

    public float getTranslateY() {
        return this.f13877i;
    }

    public void setPivotX(float f4) {
        if (f4 != this.f13872d) {
            this.f13872d = f4;
            c();
        }
    }

    public void setPivotY(float f4) {
        if (f4 != this.f13873e) {
            this.f13873e = f4;
            c();
        }
    }

    public void setRotation(float f4) {
        if (f4 != this.f13871c) {
            this.f13871c = f4;
            c();
        }
    }

    public void setScaleX(float f4) {
        if (f4 != this.f13874f) {
            this.f13874f = f4;
            c();
        }
    }

    public void setScaleY(float f4) {
        if (f4 != this.f13875g) {
            this.f13875g = f4;
            c();
        }
    }

    public void setTranslateX(float f4) {
        if (f4 != this.f13876h) {
            this.f13876h = f4;
            c();
        }
    }

    public void setTranslateY(float f4) {
        if (f4 != this.f13877i) {
            this.f13877i = f4;
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(i iVar, q.f fVar) {
        g gVar;
        this.f13869a = new Matrix();
        this.f13870b = new ArrayList();
        this.f13871c = Property.DEFAULT_FLOAT_VALUE;
        this.f13872d = Property.DEFAULT_FLOAT_VALUE;
        this.f13873e = Property.DEFAULT_FLOAT_VALUE;
        this.f13874f = 1.0f;
        this.f13875g = 1.0f;
        this.f13876h = Property.DEFAULT_FLOAT_VALUE;
        this.f13877i = Property.DEFAULT_FLOAT_VALUE;
        Matrix matrix = new Matrix();
        this.f13878j = matrix;
        this.f13880l = null;
        this.f13871c = iVar.f13871c;
        this.f13872d = iVar.f13872d;
        this.f13873e = iVar.f13873e;
        this.f13874f = iVar.f13874f;
        this.f13875g = iVar.f13875g;
        this.f13876h = iVar.f13876h;
        this.f13877i = iVar.f13877i;
        String str = iVar.f13880l;
        this.f13880l = str;
        this.f13879k = iVar.f13879k;
        if (str != null) {
            fVar.put(str, this);
        }
        matrix.set(iVar.f13878j);
        ArrayList arrayList = iVar.f13870b;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Object obj = arrayList.get(i4);
            if (obj instanceof i) {
                this.f13870b.add(new i((i) obj, fVar));
            } else {
                if (obj instanceof h) {
                    h hVar = (h) obj;
                    h hVar2 = new h(hVar);
                    hVar2.f13859f = Property.DEFAULT_FLOAT_VALUE;
                    hVar2.f13861h = 1.0f;
                    hVar2.f13862i = 1.0f;
                    hVar2.f13863j = Property.DEFAULT_FLOAT_VALUE;
                    hVar2.f13864k = 1.0f;
                    hVar2.f13865l = Property.DEFAULT_FLOAT_VALUE;
                    hVar2.f13866m = Paint.Cap.BUTT;
                    hVar2.f13867n = Paint.Join.MITER;
                    hVar2.f13868o = 4.0f;
                    hVar2.f13858e = hVar.f13858e;
                    hVar2.f13859f = hVar.f13859f;
                    hVar2.f13861h = hVar.f13861h;
                    hVar2.f13860g = hVar.f13860g;
                    hVar2.f13883c = hVar.f13883c;
                    hVar2.f13862i = hVar.f13862i;
                    hVar2.f13863j = hVar.f13863j;
                    hVar2.f13864k = hVar.f13864k;
                    hVar2.f13865l = hVar.f13865l;
                    hVar2.f13866m = hVar.f13866m;
                    hVar2.f13867n = hVar.f13867n;
                    hVar2.f13868o = hVar.f13868o;
                    gVar = hVar2;
                } else if (obj instanceof g) {
                    gVar = new g((g) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f13870b.add(gVar);
                Object obj2 = gVar.f13882b;
                if (obj2 != null) {
                    fVar.put(obj2, gVar);
                }
            }
        }
    }
}
