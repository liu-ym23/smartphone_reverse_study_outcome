package o2;

import B0.f;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.text.TextUtils;
import com.airbnb.lottie.z;
import com.google.android.gms.common.api.internal.p;
import com.google.android.material.datepicker.s;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import l1.g;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: i, reason: collision with root package name */
    public static volatile d f13795i;

    /* renamed from: a, reason: collision with root package name */
    public Object f13796a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13797b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13798c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13799d;

    /* renamed from: e, reason: collision with root package name */
    public Object f13800e;

    /* renamed from: f, reason: collision with root package name */
    public Object f13801f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13802g;

    /* renamed from: h, reason: collision with root package name */
    public Object f13803h;

    public d() {
        this.f13796a = new C0808a("udid");
        this.f13797b = new C0808a("oaid");
        this.f13799d = new C0808a("vaid");
        this.f13798c = new C0808a("aaid");
        this.f13800e = new p(20, 0);
    }

    public static C0809b b(Cursor cursor) {
        C0809b c0809b = new C0809b();
        if (cursor.isClosed()) {
            return c0809b;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            c0809b.f13794c = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            c0809b.f13793b = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            c0809b.f13792a = cursor.getLong(columnIndex3);
        }
        return c0809b;
    }

    public static final d c() {
        if (f13795i == null) {
            synchronized (d.class) {
                try {
                    if (f13795i == null) {
                        f13795i = new d();
                    }
                } finally {
                }
            }
        }
        return f13795i;
    }

    public final g a(Context context) {
        g gVar = (g) this.f13801f;
        if (gVar != null && gVar.f13460b) {
            return gVar;
        }
        PackageManager packageManager = context.getPackageManager();
        String str = null;
        if (packageManager == null) {
            return null;
        }
        boolean z4 = false;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider("com.stepos.secureservice.openidsdk", 0);
        String str2 = (providerInfoResolveContentProvider == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) ? null : providerInfoResolveContentProvider.packageName;
        if (TextUtils.isEmpty(str2)) {
            ProviderInfo providerInfoResolveContentProvider2 = packageManager.resolveContentProvider("com.stepos.openidsdk", 0);
            if (providerInfoResolveContentProvider2 != null && (providerInfoResolveContentProvider2.applicationInfo.flags & 1) != 0) {
                str = providerInfoResolveContentProvider2.packageName;
            }
            str2 = str;
        } else {
            z4 = true;
        }
        g gVar2 = new g(str2, z4);
        this.f13801f = gVar2;
        return gVar2;
    }

    public final synchronized void d(Context context, String str) {
        if (((c) this.f13802g) != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.stepos.openid.ACTION_OPEN_ID_CHANGE");
        c cVar = new c();
        this.f13802g = cVar;
        context.registerReceiver(cVar, intentFilter, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f13800e
            com.google.android.gms.common.api.internal.p r0 = (com.google.android.gms.common.api.internal.p) r0
            java.lang.Object r0 = r0.f9664b
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r2 = 0
            if (r1 == 0) goto L17
            if (r11 != 0) goto L17
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L16
            boolean r2 = r0.booleanValue()
        L16:
            return r2
        L17:
            l1.g r11 = r9.a(r10)
            if (r11 == 0) goto L81
            boolean r11 = r11.f13460b
            if (r11 == 0) goto L81
            l1.g r11 = r9.a(r10)
            if (r11 == 0) goto L77
            boolean r0 = r11.f13460b
            if (r0 == 0) goto L77
            r0 = 0
            java.lang.Object r11 = r11.f13462d     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r10 = 1
            java.lang.String[] r7 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r11 = "supported"
            r7[r2] = r11     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r5 = 0
            r6 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            if (r0 == 0) goto L68
            o2.b r11 = b(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            int r1 = r11.f13793b     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r1) goto L63
            java.lang.String r1 = "0"
            java.io.Serializable r11 = r11.f13794c     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            boolean r11 = r1.equals(r11)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            if (r11 == 0) goto L64
            goto L63
        L5f:
            r9 = move-exception
            goto L71
        L61:
            r10 = move-exception
            goto L6b
        L63:
            r2 = r10
        L64:
            r0.close()
            goto L77
        L68:
            if (r0 == 0) goto L77
            goto L70
        L6b:
            r10.getMessage()     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L77
        L70:
            goto L64
        L71:
            if (r0 == 0) goto L76
            r0.close()
        L76:
            throw r9
        L77:
            java.lang.Object r9 = r9.f13800e
            com.google.android.gms.common.api.internal.p r9 = (com.google.android.gms.common.api.internal.p) r9
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)
            r9.f9664b = r10
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.d.e(android.content.Context, boolean):boolean");
    }

    public final void f(M0.b bVar) {
        bVar.c((H0.b) this.f13797b);
        bVar.c((H0.b) this.f13798c);
        bVar.c((H0.b) this.f13799d);
        bVar.c((H0.b) this.f13800e);
        bVar.c((H0.b) this.f13801f);
        Object obj = this.f13802g;
        if (((H0.b) obj) != null) {
            bVar.c((H0.b) obj);
        }
        Object obj2 = this.f13803h;
        if (((H0.b) obj2) != null) {
            bVar.c((H0.b) obj2);
        }
    }

    public final void g(H0.a aVar) {
        ((H0.b) this.f13797b).a(aVar);
        ((H0.b) this.f13798c).a(aVar);
        ((H0.b) this.f13799d).a(aVar);
        ((H0.b) this.f13800e).a(aVar);
        ((H0.b) this.f13801f).a(aVar);
        Object obj = this.f13802g;
        if (((H0.b) obj) != null) {
            ((H0.b) obj).a(aVar);
        }
        Object obj2 = this.f13803h;
        if (((H0.b) obj2) != null) {
            ((H0.b) obj2).a(aVar);
        }
    }

    public final boolean h(Object obj, Q0.b bVar) {
        if (obj == z.f4588a) {
            ((H0.b) this.f13797b).i(bVar);
            return true;
        }
        if (obj == z.f4589b) {
            ((H0.b) this.f13798c).i(bVar);
            return true;
        }
        if (obj == z.f4592e) {
            ((H0.b) this.f13799d).i(bVar);
            return true;
        }
        if (obj == z.f4593f) {
            ((H0.b) this.f13800e).i(bVar);
            return true;
        }
        if (obj == 3) {
            ((H0.b) this.f13801f).i(bVar);
            return true;
        }
        if (obj == z.f4604q) {
            Object obj2 = this.f13802g;
            if (((H0.b) obj2) != null) {
                ((H0.b) obj2).i(bVar);
                return true;
            }
        }
        if (obj != z.f4605r) {
            return false;
        }
        Object obj3 = this.f13803h;
        if (((H0.b) obj3) == null) {
            return false;
        }
        ((H0.b) obj3).i(bVar);
        return true;
    }

    public final Matrix i() {
        ((Matrix) this.f13796a).reset();
        PointF pointF = (PointF) ((H0.b) this.f13798c).e();
        float f4 = pointF.x;
        if (f4 != Property.DEFAULT_FLOAT_VALUE || pointF.y != Property.DEFAULT_FLOAT_VALUE) {
            ((Matrix) this.f13796a).preTranslate(f4, pointF.y);
        }
        float fFloatValue = ((Float) ((H0.b) this.f13800e).e()).floatValue();
        if (fFloatValue != Property.DEFAULT_FLOAT_VALUE) {
            ((Matrix) this.f13796a).preRotate(fFloatValue);
        }
        Q0.c cVar = (Q0.c) ((H0.b) this.f13799d).e();
        float f5 = cVar.f1638a;
        float f6 = cVar.f1639b;
        if (f5 != 1.0f || f6 != 1.0f) {
            ((Matrix) this.f13796a).preScale(f5, f6);
        }
        PointF pointF2 = (PointF) ((H0.b) this.f13797b).e();
        float f7 = pointF2.x;
        if (f7 != Property.DEFAULT_FLOAT_VALUE || pointF2.y != Property.DEFAULT_FLOAT_VALUE) {
            ((Matrix) this.f13796a).preTranslate(-f7, -pointF2.y);
        }
        return (Matrix) this.f13796a;
    }

    public final Matrix j(float f4) {
        PointF pointF = (PointF) ((H0.b) this.f13798c).e();
        PointF pointF2 = (PointF) ((H0.b) this.f13797b).e();
        Q0.c cVar = (Q0.c) ((H0.b) this.f13799d).e();
        float fFloatValue = ((Float) ((H0.b) this.f13800e).e()).floatValue();
        ((Matrix) this.f13796a).reset();
        ((Matrix) this.f13796a).preTranslate(pointF.x * f4, pointF.y * f4);
        double d4 = f4;
        ((Matrix) this.f13796a).preScale((float) Math.pow(cVar.f1638a, d4), (float) Math.pow(cVar.f1639b, d4));
        ((Matrix) this.f13796a).preRotate(fFloatValue * f4, pointF2.x, pointF2.y);
        return (Matrix) this.f13796a;
    }

    public d(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0557a.Y(context, s.class.getCanonicalName(), R.attr.materialCalendarStyle).data, AbstractC0769a.f13551q);
        this.f13796a = H.d.a(typedArrayObtainStyledAttributes.getResourceId(4, 0), context);
        this.f13802g = H.d.a(typedArrayObtainStyledAttributes.getResourceId(2, 0), context);
        this.f13797b = H.d.a(typedArrayObtainStyledAttributes.getResourceId(3, 0), context);
        this.f13798c = H.d.a(typedArrayObtainStyledAttributes.getResourceId(5, 0), context);
        ColorStateList colorStateListY = f.y(context, typedArrayObtainStyledAttributes, 7);
        this.f13799d = H.d.a(typedArrayObtainStyledAttributes.getResourceId(9, 0), context);
        this.f13800e = H.d.a(typedArrayObtainStyledAttributes.getResourceId(8, 0), context);
        this.f13801f = H.d.a(typedArrayObtainStyledAttributes.getResourceId(10, 0), context);
        Paint paint = new Paint();
        this.f13803h = paint;
        paint.setColor(colorStateListY.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
