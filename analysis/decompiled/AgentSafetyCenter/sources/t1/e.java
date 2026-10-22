package t1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentsafetycenter.R;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import k0.c1;
import k0.s;
import k0.v1;
import k0.y0;
import k0.z;
import r.p0;
import s.t;
import u.k;
import v1.a1;
import w.l0;
import w.v0;
import w0.m;
import x.r;
import x.u;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static Integer f13134a;

    public static final void a(int i, int i3, s sVar, k kVar, w.h hVar, l0 l0Var, w0.c cVar, m mVar, r rVar, l lVar, boolean z10) {
        int i10;
        r rVarA;
        w.h hVar2;
        int i11;
        w0.c cVar2;
        boolean z11;
        k kVar2;
        l0 l0Var2;
        k kVar3;
        w.h hVar3;
        l0 l0Var3;
        w0.c cVar3;
        boolean z12;
        sVar.Z(-740714857);
        if ((i & 6) == 0) {
            i10 = (sVar.f(mVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) == 0) {
                rVarA = rVar;
                int i12 = sVar.f(rVarA) ? 32 : 16;
                i10 |= i12;
            } else {
                rVarA = rVar;
            }
            i10 |= i12;
        } else {
            rVarA = rVar;
        }
        int i13 = i10 | 3456;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                hVar2 = hVar;
                int i14 = sVar.f(hVar2) ? 16384 : 8192;
                i13 |= i14;
            } else {
                hVar2 = hVar;
            }
            i13 |= i14;
        } else {
            hVar2 = hVar;
        }
        int i15 = 196608 | i13;
        if ((1572864 & i) == 0) {
            i15 = 720896 | i13;
        }
        int i16 = 12582912 | i15;
        if ((100663296 & i) == 0) {
            i16 |= sVar.h(lVar) ? 67108864 : 33554432;
        }
        if ((38347923 & i16) == 38347922 && sVar.B()) {
            sVar.S();
            kVar3 = kVar;
            cVar3 = cVar;
            z12 = z10;
            hVar3 = hVar2;
            l0Var3 = l0Var;
        } else {
            sVar.U();
            if ((i & 1) == 0 || sVar.z()) {
                if ((i3 & 2) != 0) {
                    rVarA = u.a(sVar);
                    i16 &= -113;
                }
                float f5 = 0;
                l0 l0Var4 = new l0(f5, f5, f5, f5);
                if ((i3 & 16) != 0) {
                    hVar2 = w.k.f14992c;
                    i16 &= -57345;
                }
                w0.c cVar4 = w0.b.f15100q;
                float f10 = p0.f10334a;
                o2.c cVar5 = (o2.c) sVar.j(a1.f14363h);
                boolean zC = sVar.c(cVar5.a());
                Object objM = sVar.M();
                Object obj = k0.m.f6974a;
                Object obj2 = objM;
                if (zC || objM == obj) {
                    a1.g gVar = new a1.g(cVar5);
                    t tVar = new t();
                    tVar.f11121a = gVar;
                    VarHandle.storeStoreFence();
                    sVar.i0(tVar);
                    obj2 = tVar;
                }
                t tVar2 = (t) obj2;
                boolean zF = sVar.f(tVar2);
                Object objM2 = sVar.M();
                if (zF || objM2 == obj) {
                    objM2 = new k(tVar2);
                    sVar.i0(objM2);
                }
                i11 = i16 & (-3670017);
                cVar2 = cVar4;
                z11 = true;
                kVar2 = (k) objM2;
                l0Var2 = l0Var4;
            } else {
                sVar.S();
                if ((i3 & 2) != 0) {
                    i16 &= -113;
                }
                if ((i3 & 16) != 0) {
                    i16 &= -57345;
                }
                i11 = i16 & (-3670017);
                kVar2 = kVar;
                l0Var2 = l0Var;
                cVar2 = cVar;
                z11 = z10;
            }
            r rVar2 = rVarA;
            w.h hVar4 = hVar2;
            sVar.r();
            t2.a.a((i11 & 14) | 24576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | ((i11 >> 3) & 3670016) | ((i11 << 9) & 234881024) | ((i11 << 15) & 1879048192), (i11 >> 18) & 896, sVar, kVar2, hVar4, l0Var2, cVar2, mVar, rVar2, lVar, z11);
            kVar3 = kVar2;
            hVar3 = hVar4;
            l0Var3 = l0Var2;
            cVar3 = cVar2;
            rVarA = rVar2;
            z12 = z11;
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new x.a(mVar, rVarA, l0Var3, hVar3, cVar3, kVar3, z12, lVar, i, i3);
        }
    }

    public static final yc.i b(xb.a aVar) {
        yc.i iVar = new yc.i();
        iVar.f16109a = new jb.k(aVar);
        VarHandle.storeStoreFence();
        return iVar;
    }

    public static final c1 c(v.k kVar, s sVar) {
        Object objM = sVar.M();
        y0 y0Var = k0.m.f6974a;
        if (objM == y0Var) {
            objM = z.v(Boolean.FALSE);
            sVar.i0(objM);
        }
        c1 c1Var = (c1) objM;
        Object objM2 = sVar.M();
        if (objM2 == y0Var) {
            objM2 = new v.g(kVar, c1Var, null, 2);
            sVar.i0(objM2);
        }
        z.h(kVar, sVar, (p) objM2);
        return c1Var;
    }

    public static float e(float f5, Context context) {
        return TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
    }

    public static String f(String str) {
        try {
            va.b.f14866a.getClass();
            Class clsH = r2.i.h("android.os.SystemProperties");
            return (String) r2.i.n(clsH, String.class).invoke(clsH, str);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            va.b.f14866a.getClass();
            Class clsH = r2.i.h("android.os.SystemProperties");
            return (String) r2.i.n(clsH, String.class, String.class).invoke(clsH, str, str2);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static int i(int i, View view) {
        Context context = view.getContext();
        Context context2 = view.getContext();
        String canonicalName = view.getClass().getCanonicalName();
        TypedValue typedValueE = p5.f.E(i, context2);
        if (typedValueE != null) {
            int i3 = typedValueE.resourceId;
            return i3 != 0 ? context.getColor(i3) : typedValueE.data;
        }
        b8.z.u("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{canonicalName, context2.getResources().getResourceName(i)});
        return 0;
    }

    public static int j(int i, Context context) {
        TypedValue typedValue;
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            typedValue = null;
        } else {
            TypedValue typedValue2 = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i, typedValue2, true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            typedValue = typedValue2;
        }
        if (typedValue == null) {
            return 0;
        }
        return typedValue.resourceId;
    }

    public static int k(Context context) {
        try {
            if (f13134a == null) {
                f13134a = Integer.valueOf(context.getResources().getIdentifier(k0.a.C("android:", "dimen", "/status_bar_height"), null, null));
            }
            return context.getResources().getDimensionPixelSize(f13134a.intValue());
        } catch (Exception e10) {
            Log.e("ResurceUtils", "get status bar height fail", e10);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }

    public static final boolean l(File file) {
        file.getClass();
        if (file.isFile()) {
            if (file.canRead()) {
                return true;
            }
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            String strReplace = absolutePath.replace('\\', JsonPointer.SEPARATOR);
            strReplace.getClass();
            if (hc.h.X(strReplace, "/Android/.com.stepos.filemanager/.garbage/", false) && file.exists()) {
                return true;
            }
        }
        return false;
    }

    public static int m(int i, float f5, int i3) {
        return f3.a.b(f3.a.d(i3, Math.round(Color.alpha(i3) * f5)), i);
    }

    public static String n(Context context) {
        context.getClass();
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "net_env");
        String string2 = string != null ? hc.h.w0(string).toString() : null;
        return string2 == null ? "" : string2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:61:0x019e
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final h1.b o(int r49, k0.s r50) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.e.o(int, k0.s):h1.b");
    }

    public static String p(Context context) {
        context.getClass();
        String strX0 = hc.h.x0(hc.h.w0("").toString(), JsonPointer.SEPARATOR);
        if (strX0.length() > 0) {
            return strX0;
        }
        String lowerCase = n(context).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return hc.h.x0((lowerCase.equals("dev") || lowerCase.equals("test") || lowerCase.equals("stg")) ? "https://biz-gw.t-stepos.com/agi-ai-tools" : "https://biz-gw.stepaos.com/agi-ai-tools", JsonPointer.SEPARATOR);
    }

    public static final v0 q(w.y0 y0Var, w.y0 y0Var2) {
        v0 v0Var = new v0();
        v0Var.f15057a = y0Var;
        v0Var.f15058b = y0Var2;
        VarHandle.storeStoreFence();
        return v0Var;
    }

    public abstract boolean d(i iVar);

    public abstract Object h(i iVar);
}
