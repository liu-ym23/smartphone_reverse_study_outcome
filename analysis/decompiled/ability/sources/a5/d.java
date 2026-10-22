package a5;

import android.content.Context;
import android.graphics.Path;
import android.view.View;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import e3.C1413b;
import e3.InterfaceC1415d;
import java.util.HashMap;
import java.util.Map;
import qa.C1856h;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import retrofit2.HttpException;
import stepos.support.v7.widget.C0;
import stepos.support.v7.widget.Q;
import z8.n;
import z8.o;

/* loaded from: classes3.dex */
public final class d implements n, Q, InterfaceC1855g, C0, v.c, x.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1640a;
    public Object b;

    public /* synthetic */ d(int i) {
        this.f1640a = i;
    }

    @Override // v.c
    public String a() {
        return ((A8.b) this.b).M0("clientudid");
    }

    @Override // v.c
    public boolean b(Object obj) {
        return U7.a.q((String) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    @Override // x.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D9.n c(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r6 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r1 = android.net.Uri.parse(r6)
            android.content.ContentResolver r0 = r7.getContentResolver()
            r6 = 0
            java.lang.String r7 = "oaid"
            java.lang.String[] r4 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L45
            r5 = 0
            r2 = 0
            r3 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L45
            if (r7 != 0) goto L20
            if (r7 == 0) goto L1f
            r7.close()
        L1f:
            return r6
        L20:
            D9.n r0 = new D9.n     // Catch: java.lang.Throwable -> L3d
            r0.<init>()     // Catch: java.lang.Throwable -> L3d
            boolean r1 = r7.isClosed()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L2d
        L2b:
            r1 = r6
            goto L3f
        L2d:
            r7.moveToFirst()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "value"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L3d
            if (r1 < 0) goto L2b
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Throwable -> L3d
            goto L3f
        L3d:
            r0 = move-exception
            goto L47
        L3f:
            r0.f443a = r1     // Catch: java.lang.Throwable -> L3d
            r7.close()
            return r0
        L45:
            r0 = move-exception
            r7 = r6
        L47:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L50
            if (r7 == 0) goto L4f
            r7.close()
        L4f:
            return r6
        L50:
            r0 = move-exception
            r6 = r0
            if (r7 == 0) goto L57
            r7.close()
        L57:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.d.c(android.content.Context):D9.n");
    }

    public InterfaceC1415d d(InterfaceC1415d interfaceC1415d) {
        return interfaceC1415d instanceof e3.m ? interfaceC1415d : new C1413b(-((e3.k) this.b).j(), interfaceC1415d);
    }

    public void e(Path path) {
        float[] fArr = (float[]) this.b;
        path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
        path.cubicTo(fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13]);
    }

    @Override // v.c
    public String f(Object obj, Object obj2, A8.b bVar) {
        String str = (String) obj;
        return bVar == null ? str : bVar.N0(str, (String) obj2);
    }

    @Override // x.j
    public boolean g(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) ((x.d) this.b).b(context)).booleanValue();
    }

    public e h(ClassLoader classLoader, String str) throws ClassNotFoundException {
        HashMap map = (HashMap) this.b;
        Map map2 = (Map) map.get(classLoader);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(classLoader, map2);
        }
        e eVar = (e) map2.get(str);
        if (eVar != null) {
            return eVar;
        }
        Class<?> clsLoadClass = classLoader.loadClass(str);
        e eVar2 = new e();
        new HashMap();
        eVar2.b = new HashMap();
        new HashMap();
        eVar2.f1641a = clsLoadClass;
        map2.put(str, eVar2);
        return eVar2;
    }

    public void i() {
        float[] fArr = (float[]) this.b;
        float f = fArr[0];
        float f7 = fArr[1];
        fArr[0] = fArr[12];
        fArr[1] = fArr[13];
        fArr[12] = f;
        fArr[13] = f7;
        float f9 = fArr[2];
        float f10 = fArr[3];
        fArr[2] = fArr[10];
        fArr[3] = fArr[11];
        fArr[10] = f9;
        fArr[11] = f10;
        float f11 = fArr[4];
        float f12 = fArr[5];
        fArr[4] = fArr[8];
        fArr[5] = fArr[9];
        fArr[8] = f11;
        fArr[9] = f12;
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        C1856h c1856h = (C1856h) this.b;
        if (l.f5644a.c()) {
            c1856h.complete(l.b);
        } else {
            c1856h.completeExceptionally(new HttpException(l));
        }
    }

    @Override // z8.n
    public void k() {
    }

    @Override // z8.n
    public n l(G8.b bVar, G8.f fVar) {
        return null;
    }

    @Override // z8.n
    public void m(G8.f fVar, L8.f fVar2) {
    }

    @Override // z8.n
    public o n(G8.f fVar) {
        String strB = fVar.b();
        if (SettingsConfig.KEY_DATA.equals(strB) || "filePartClassNames".equals(strB)) {
            return new A8.e(this, 0);
        }
        if ("strings".equals(strB)) {
            return new A8.e(this, 1);
        }
        return null;
    }

    @Override // v.c
    public boolean o(Object obj, Object obj2) {
        return U7.a.m((String) obj, (String) obj2);
    }

    @Override // stepos.support.v7.widget.Q
    public void onScrollChange(View view, int i, int i6, int i10, int i11) {
        Ua.f fVar = (Ua.f) this.b;
        Ua.f.a(fVar, view, fVar.d, fVar.f1284j);
    }

    @Override // v.c
    public void q(Object obj) {
        ((A8.b) this.b).J0("clientudid", (String) obj);
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1856h) this.b).completeExceptionally(th);
    }

    @Override // z8.n
    public void t(G8.f fVar, Object obj) {
        A8.f fVar2 = (A8.f) this.b;
        String strB = fVar.b();
        if ("version".equals(strB)) {
            if (obj instanceof int[]) {
                fVar2.f163a = (int[]) obj;
            }
        } else if ("multifileClassName".equals(strB)) {
            fVar2.b = obj instanceof String ? (String) obj : null;
        }
    }

    public String toString() {
        switch (this.f1640a) {
            case 6:
                return B7.a.g('>', (String) this.b, new StringBuilder("<"));
            default:
                return super.toString();
        }
    }

    @Override // z8.n
    public void y(G8.f fVar, G8.b bVar, G8.f fVar2) {
    }

    public /* synthetic */ d(Object obj, int i) {
        this.f1640a = i;
        this.b = obj;
    }
}
