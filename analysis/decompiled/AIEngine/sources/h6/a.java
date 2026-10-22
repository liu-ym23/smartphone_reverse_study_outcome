package h6;

import android.graphics.drawable.Drawable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9295a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f9296b = mb.m.b0("icon.png", "icon.webp", "icon.jpg", "icon.jpeg");

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Drawable.ConstantState> f9297c = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h6.s a(android.content.Context r5, h6.s r6) {
        /*
            java.lang.String r0 = r6.f9347k
            boolean r1 = gc.q.t0(r0)
            if (r1 == 0) goto L9
            goto L6d
        L9:
            com.stepos.core.common.display.ModelDisplayResolver r1 = com.stepos.core.common.display.ModelDisplayResolver.INSTANCE
            java.io.File r5 = r1.pickStringsFile(r5, r0)
            r0 = 0
            if (r5 != 0) goto L14
            r3 = r0
            goto L6b
        L14:
            java.util.Map r1 = r1.parseStrings(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = "title"
            java.lang.Object r2 = r1.get(r2)     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L2b
            boolean r3 = gc.q.t0(r2)     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L2c
            goto L2b
        L29:
            r1 = move-exception
            goto L43
        L2b:
            r2 = r0
        L2c:
            java.lang.String r3 = "desc"
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L3c
            boolean r3 = gc.q.t0(r1)     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L3d
        L3c:
            r1 = r0
        L3d:
            kotlin.Pair r3 = new kotlin.Pair     // Catch: java.lang.Throwable -> L29
            r3.<init>(r2, r1)     // Catch: java.lang.Throwable -> L29
            goto L47
        L43:
            kotlin.Result$Failure r3 = kotlin.c.a(r1)
        L47:
            java.lang.Throwable r1 = kotlin.Result.b(r3)
            if (r1 == 0) goto L64
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "parse strings.xml failed: "
            r2.<init>(r4)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            java.lang.String r2 = "ModelDisplayResource"
            android.util.Log.w(r2, r5, r1)
        L64:
            boolean r5 = r3 instanceof kotlin.Result.Failure
            if (r5 == 0) goto L69
            r3 = r0
        L69:
            kotlin.Pair r3 = (kotlin.Pair) r3
        L6b:
            if (r3 != 0) goto L6e
        L6d:
            return r6
        L6e:
            A r5 = r3.f9985a
            java.lang.String r5 = (java.lang.String) r5
            B r1 = r3.f9986b
            java.lang.String r1 = (java.lang.String) r1
            if (r5 == 0) goto L82
            boolean r2 = gc.q.t0(r5)
            if (r2 != 0) goto L7f
            goto L80
        L7f:
            r5 = r0
        L80:
            if (r5 != 0) goto L84
        L82:
            java.lang.String r5 = r6.f9340c
        L84:
            if (r1 == 0) goto L8f
            boolean r2 = gc.q.t0(r1)
            if (r2 != 0) goto L8d
            r0 = r1
        L8d:
            if (r0 != 0) goto L91
        L8f:
            java.lang.String r0 = r6.f9341d
        L91:
            r1 = 2035(0x7f3, float:2.852E-42)
            h6.s r5 = h6.s.a(r6, r5, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.a.a(android.content.Context, h6.s):h6.s");
    }

    public static File b(String str, String str2) {
        Object obj;
        List<String> list = f9296b;
        ArrayList arrayList = new ArrayList(mb.m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(str, com.stepos.core.ota.d.i(str2, "/", (String) it.next())));
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((File) obj).isFile()) {
                break;
            }
        }
        return (File) obj;
    }
}
