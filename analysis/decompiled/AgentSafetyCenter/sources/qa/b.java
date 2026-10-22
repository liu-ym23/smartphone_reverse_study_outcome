package qa;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.lifecycle.r;
import h5.t;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import kc.e0;
import rc.d;
import t.o;
import u8.q;
import y3.e;
import y8.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: c, reason: collision with root package name */
    public Context f10210c;

    public b(Context context) {
        context.getClass();
        this.f10210c = context.getApplicationContext();
    }

    public static e c(w wVar) {
        return o.k(wVar.f16016c.concat("_checked_at_ms"));
    }

    public static e d(w wVar) {
        return o.k(wVar.f16016c.concat("_version"));
    }

    @Override // u8.q
    public Object a(List list, nb.c cVar) {
        rc.e eVar = e0.f7430a;
        return kc.w.E(d.f10552f, new r(this, list, null, 12), cVar);
    }

    public a b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strReplace;
        boolean zBooleanValue;
        String strReplace2;
        String str;
        a aVar = new a();
        aVar.f10209a = new HashMap();
        String strReplace3 = Build.MODEL;
        aVar.a("device", !TextUtils.isEmpty(strReplace3) ? strReplace3.replace("\n", "").replace("\r", "") : strReplace3);
        if (!TextUtils.isEmpty(strReplace3)) {
            strReplace3 = strReplace3.replace("\n", "").replace("\r", "");
        }
        aVar.a("product_model", strReplace3);
        if (TextUtils.isEmpty(ra.b.f10519c)) {
            ra.b.f10519c = t1.e.f("ro.build.mask.id");
        }
        String strReplace4 = ra.b.f10519c;
        if (!TextUtils.isEmpty(strReplace4)) {
            strReplace4 = strReplace4.replace("\n", "").replace("\r", "");
        }
        aVar.a("build_mask", strReplace4);
        aVar.a("os_type", "android");
        if (TextUtils.isEmpty(ra.b.f10521e)) {
            String strG = t1.e.g("ro.product.other.brand", "unknown");
            if ("unknown".equals(strG)) {
                ra.b.f10521e = Build.BRAND;
            } else {
                ra.b.f10521e = strG;
            }
            strReplace = ra.b.f10521e;
        } else {
            strReplace = ra.b.f10521e;
        }
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", "").replace("\r", "");
        }
        aVar.a("brand", strReplace);
        String strReplace5 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(strReplace5)) {
            strReplace5 = strReplace5.replace("\n", "").replace("\r", "");
        }
        aVar.a("os_version", strReplace5);
        aVar.a("os", "StepOS");
        if (ra.b.f10525j != null) {
            ua.c.a("StepOSUtils", "isInternational = " + ra.b.f10525j);
            zBooleanValue = ra.b.f10525j.booleanValue();
        } else {
            try {
                ra.b.f10525j = Boolean.valueOf(("zh".equalsIgnoreCase(t1.e.f("ro.product.locale.language")) && "CN".equalsIgnoreCase(t1.e.f("ro.product.locale.region")) && !"zh-CN".equalsIgnoreCase(t1.e.f("ro.product.locale"))) ? false : true);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            zBooleanValue = ra.b.f10525j.booleanValue();
        }
        aVar.f10209a.put("international", Boolean.valueOf(zBooleanValue));
        ua.c.d("DeviceInfo", "setDevicePersonalInfo start");
        aVar.a("imsi1", "");
        aVar.a("imsi2", "");
        aVar.a("andro_id", "");
        aVar.a("android_ad_id", "");
        aVar.a("mac_address", "");
        aVar.f10209a.put("root", Boolean.FALSE);
        aVar.a("udid", "");
        aVar.a("oaid", t.A());
        aVar.a("vaid", "");
        aVar.a("aaid", "");
        Context context = this.f10210c;
        if (context != null) {
            if (TextUtils.isEmpty(ra.b.f10522f)) {
                try {
                    if (context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
                        ra.b.f10522f = context.getResources().getConfiguration().locale.getCountry();
                    }
                } catch (Exception e11) {
                    ua.c.b("StepOSUtils", "Exception: " + e11.getMessage() + " - Cause: " + e11.getCause());
                }
                strReplace2 = ra.b.f10522f;
            } else {
                strReplace2 = ra.b.f10522f;
            }
            if (!TextUtils.isEmpty(strReplace2)) {
                strReplace2 = strReplace2.replace("\n", "").replace("\r", "");
            }
            aVar.a("country", strReplace2);
            Context context2 = this.f10210c;
            if (TextUtils.isEmpty(ra.b.f10520d)) {
                try {
                    DisplayManager displayManager = (DisplayManager) context2.getSystemService("display");
                    Display display = displayManager != null ? displayManager.getDisplay(0) : null;
                    if (display != null) {
                        Point point = new Point();
                        display.getRealSize(point);
                        int i = point.x;
                        int i3 = point.y;
                        if (i > 0 && i3 > 0) {
                            ra.b.f10520d = i + "." + i3;
                        }
                    }
                } catch (Exception e12) {
                    ua.c.b("StepOSUtils", "getDisplaySize error, " + e12.getMessage());
                }
                str = ra.b.f10520d;
            } else {
                str = ra.b.f10520d;
            }
            aVar.a("sre", str);
            aVar.f10209a.put("ter_type", 1);
        }
        ua.c.e("DeviceInfo", "DeviceInfo created successfully.");
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(y8.w r8, pb.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof y8.f
            if (r0 == 0) goto L13
            r0 = r9
            y8.f r0 = (y8.f) r0
            int r1 = r0.f15964h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15964h = r1
            goto L18
        L13:
            y8.f r0 = new y8.f
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f15962f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f15964h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            y8.w r8 = r0.f15961c
            id.c.I(r9)
            goto L51
        L29:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L30:
            id.c.I(r9)
            android.content.Context r7 = r7.f10210c
            r7.getClass()
            v3.f r7 = y8.h.a(r7)
            stepos.support.v7.app.f r7 = (stepos.support.v7.app.f) r7
            java.lang.Object r7 = r7.f12315f
            v3.f r7 = (v3.f) r7
            nc.g r7 = r7.getData()
            r0.f15961c = r8
            r0.f15964h = r3
            java.lang.Object r9 = nc.k0.i(r7, r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            y3.b r9 = (y3.b) r9
            y8.x r7 = new y8.x
            y3.e r0 = d(r8)
            java.lang.Object r0 = r9.c(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            r1 = 0
            if (r0 == 0) goto L68
            long r3 = r0.longValue()
            goto L69
        L68:
            r3 = r1
        L69:
            y3.e r0 = c(r8)
            java.lang.Object r0 = r9.c(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L7a
            long r5 = r0.longValue()
            goto L7b
        L7a:
            r5 = r1
        L7b:
            java.lang.String r8 = r8.f16016c
            java.lang.String r0 = "_updated_at_ms"
            java.lang.String r8 = r8.concat(r0)
            y3.e r8 = t.o.k(r8)
            java.lang.Object r8 = r9.c(r8)
            java.lang.Long r8 = (java.lang.Long) r8
            if (r8 == 0) goto L93
            long r1 = r8.longValue()
        L93:
            r7.<init>()
            r7.f16017a = r3
            r7.f16018b = r5
            r7.f16019c = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.b.e(y8.w, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(y8.w r5, pb.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof y8.g
            if (r0 == 0) goto L13
            r0 = r6
            y8.g r0 = (y8.g) r0
            int r1 = r0.f15968h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15968h = r1
            goto L18
        L13:
            y8.g r0 = new y8.g
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f15966f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f15968h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            y8.w r5 = r0.f15965c
            id.c.I(r6)
            goto L51
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L30:
            id.c.I(r6)
            android.content.Context r4 = r4.f10210c
            r4.getClass()
            v3.f r4 = y8.h.a(r4)
            stepos.support.v7.app.f r4 = (stepos.support.v7.app.f) r4
            java.lang.Object r4 = r4.f12315f
            v3.f r4 = (v3.f) r4
            nc.g r4 = r4.getData()
            r0.f15965c = r5
            r0.f15968h = r3
            java.lang.Object r6 = nc.k0.i(r4, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            y3.b r6 = (y3.b) r6
            java.lang.String r4 = r5.f16016c
            java.lang.String r0 = "_json"
            java.lang.String r4 = r4.concat(r0)
            y3.e r4 = t.o.n(r4)
            java.lang.Object r4 = r6.c(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L69
            java.lang.String r4 = ""
        L69:
            boolean r0 = hc.h.g0(r4)
            if (r0 == 0) goto L71
            r4 = 0
            return r4
        L71:
            y3.e r0 = d(r5)
            java.lang.Object r6 = r6.c(r0)
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L82
            long r0 = r6.longValue()
            goto L84
        L82:
            r0 = 0
        L84:
            y8.y r6 = new y8.y
            r6.<init>(r5, r0, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.b.f(y8.w, pb.c):java.lang.Object");
    }

    public b() {
        this.f10210c = null;
    }
}
