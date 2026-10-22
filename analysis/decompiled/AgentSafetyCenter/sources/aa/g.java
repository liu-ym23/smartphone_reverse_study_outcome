package aa;

import ad.e0;
import ad.h0;
import ad.y;
import ad.z;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.stepos.agentsafetycenter.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import e9.v;
import g9.b0;
import g9.o1;
import g9.z0;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CancellationException;
import k0.c1;
import k0.w1;
import k0.z1;
import kc.w;
import nc.t0;
import p.g0;
import s8.p3;
import s8.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f318c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f319f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f320g;

    public /* synthetic */ g(int i) {
        this.f318c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [nb.c] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    @Override // xb.l
    public final Object invoke(Object obj) throws Resources.NotFoundException {
        int i;
        String str;
        Duration durationV;
        int i3 = 3;
        int i10 = 0;
        int i11 = 2;
        boolean z10 = true;
        boolean z11 = true;
        bVar = null;
        y9.b bVar = null;
        switch (this.f318c) {
            case 0:
                int[] iArr = (int[]) this.f319f;
                int[] iArr2 = (int[]) this.f320g;
                obj.getClass();
                z9.f fVar = z9.f.f16523a;
                z9.f.b(obj, "setBlendArray", new Class[]{int[].class, int[].class}, iArr, iArr2);
                break;
            case 1:
                w.u((kc.t) this.f319f, null, null, new v((e9.h) this.f320g, ((Boolean) obj).booleanValue(), I, i10), 3);
                break;
            case 2:
                d2.g gVar = (d2.g) this.f319f;
                xb.a aVar = (xb.a) this.f320g;
                int iIntValue = ((Integer) obj).intValue();
                if (((d2.e) kb.l.x0(gVar.b(iIntValue, iIntValue, "ai_operate_phone_terms"))) != null) {
                    aVar.invoke();
                }
                return jb.v.f6774a;
            case 3:
                b0 b0Var = (b0) this.f319f;
                String str2 = (String) this.f320g;
                ad.n nVar = (ad.n) obj;
                y yVar = new y();
                nVar.getClass();
                yVar.f633c = nVar.c();
                yVar.o(b0Var.f4408a);
                yVar.l("POST", td.h.l(str2, b0Var.f4410c));
                z zVarE = yVar.e();
                ad.w wVar = b0Var.f4409b;
                wVar.getClass();
                e0 e0VarE = new ed.j(wVar, zVarE).e();
                try {
                    int i12 = e0VarE.f471h;
                    h0 h0Var = e0VarE.f473k;
                    I = h0Var != null ? h0Var.i() : 0;
                    if (I == 0) {
                        I = "";
                    }
                    l8.a aVar2 = new l8.a(i12, I, e0VarE.f472j);
                    e0VarE.close();
                    return aVar2;
                } finally {
                }
            case 4:
                w.u((kc.t) this.f319f, null, null, new v((i9.b0) this.f320g, ((Boolean) obj).booleanValue(), I, z10 ? 1 : 0), 3);
                break;
            case 5:
                k0.y yVar2 = (k0.y) this.f319f;
                g0 g0Var = (g0) this.f320g;
                yVar2.z(obj);
                if (g0Var != null) {
                    g0Var.a(obj);
                }
                return jb.v.f6774a;
            case 6:
                z1 z1Var = (z1) this.f319f;
                Throwable th = (Throwable) this.f320g;
                Throwable th2 = (Throwable) obj;
                synchronized (z1Var.f7156b) {
                    if (th == null) {
                        th = null;
                    } else if (th2 != null) {
                        try {
                            if (th2 instanceof CancellationException) {
                                th2 = null;
                            }
                            if (th2 != null) {
                                com.stepos.statsrpk.h.b(th, th2);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    z1Var.f7158d = th;
                    t0 t0Var = z1Var.f7173t;
                    w1 w1Var = w1.f7100c;
                    t0Var.getClass();
                    t0Var.g(null, w1Var);
                    break;
                }
            case 7:
                String str3 = (String) this.f319f;
                c1 c1Var = (c1) this.f320g;
                Context context = (Context) obj;
                context.getClass();
                View viewInflate = LayoutInflater.from(l9.a.h(context)).inflate(R.layout.gongkong_title_bar, (ViewGroup) null, false);
                viewInflate.getClass();
                StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) viewInflate;
                stepOSTitleBar.setTitleTextColor(stepOSTitleBar.getContext().getColor(R.color.stepos_titlebar_title));
                cb.d dVar = new cb.d(i11);
                dVar.f2246f = c1Var;
                VarHandle.storeStoreFence();
                Resources resources = stepOSTitleBar.getResources();
                Resources.Theme theme = stepOSTitleBar.getContext().getTheme();
                ThreadLocal threadLocal = e3.k.f3478a;
                Drawable drawable = resources.getDrawable(R.drawable.stepos_icon_navigation_back, theme);
                Context context2 = stepOSTitleBar.getContext();
                context2.getClass();
                ab.g gVar2 = new ab.g(context2, null, R.attr.steposGlassImageButtonStyle);
                gVar2.i = new ab.c(gVar2);
                gVar2.f404m = 255;
                a4.t tVar = new a4.t(i3);
                tVar.f200f = gVar2;
                VarHandle.storeStoreFence();
                gVar2.f405n = tVar;
                ab.e eVar = new ab.e(i10);
                eVar.f393f = gVar2;
                VarHandle.storeStoreFence();
                ab.d dVar2 = new ab.d();
                dVar2.f386a = gVar2;
                dVar2.f387b = eVar;
                Context context3 = gVar2.getContext();
                context3.getClass();
                dVar2.f388c = (context3.getResources().getConfiguration().uiMode & 48) == 32;
                a4.t tVar2 = new a4.t(i11);
                tVar2.f200f = dVar2;
                VarHandle.storeStoreFence();
                dVar2.f391f = tVar2;
                VarHandle.storeStoreFence();
                gVar2.f406o = dVar2;
                gVar2.f407p = true;
                y9.b bVar2 = y9.b.f16031j;
                gVar2.f410s = bVar2;
                p5.u uVar = new p5.u((int) (z11 ? 1 : 0));
                uVar.f9807f = gVar2;
                VarHandle.storeStoreFence();
                gVar2.f400h = uVar;
                gVar2.setBackground(null);
                TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, xa.a.f15598a, R.attr.steposGlassImageButtonStyle, R.style.StepOSWidget_GlassImageButton);
                typedArrayObtainStyledAttributes.getClass();
                if (typedArrayObtainStyledAttributes.hasValue(1) && (i = typedArrayObtainStyledAttributes.getInt(1, -1)) != -1) {
                    if (i == 0) {
                        bVar = y9.b.f16029g;
                    } else if (i == 1) {
                        bVar = y9.b.f16030h;
                    } else if (i == 2) {
                        bVar = y9.b.i;
                    } else if (i == 3) {
                        bVar = bVar2;
                    } else {
                        if (i != 4) {
                            g5.f.s(k0.a.j(i, "steposGlassEffect must be clear(0), light_small(1), light_medium(2), dark_small(3), or dark_medium(4) but was "));
                            return null;
                        }
                        bVar = y9.b.f16032k;
                    }
                }
                if (bVar != null) {
                    gVar2.setGlassEffect(bVar);
                }
                gVar2.setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(2, true));
                gVar2.setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(0, false));
                typedArrayObtainStyledAttributes.recycle();
                int i13 = gVar2.isEnabled() ? 255 : 77;
                gVar2.f404m = i13;
                gVar2.setImageAlpha(i13);
                VarHandle.storeStoreFence();
                gVar2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                gVar2.setImageDrawable(stepOSTitleBar.e(drawable));
                gVar2.setContentDescription(str3);
                gVar2.setClickable(true);
                gVar2.setFocusable(true);
                gVar2.setOnClickListener(dVar);
                gVar2.setGlassCrossWindow(stepOSTitleBar.H);
                gVar2.setGlassEffect(stepOSTitleBar.I);
                gVar2.setGlassEnabled(stepOSTitleBar.G && stepOSTitleBar.P);
                gVar2.setGlassCornerRadius(stepOSTitleBar.B);
                ab.a aVar3 = stepOSTitleBar.J;
                if (aVar3 != null) {
                    gVar2.f403l = aVar3;
                    gVar2.a();
                    gVar2.b();
                }
                stepOSTitleBar.o(gVar2);
                stepOSTitleBar.n(gVar2);
                stepOSTitleBar.c(stepOSTitleBar.b(0), gVar2);
                stepOSTitleBar.f2901k.add(gVar2);
                return stepOSTitleBar;
            case 8:
                ((lc.d) this.f319f).f7858f.removeCallbacks((com.stepos.statsrpk.service.d) this.f320g);
                break;
            case 9:
                q8.h hVar = (q8.h) this.f319f;
                q8.i iVar = (q8.i) this.f320g;
                x4.a aVar4 = (x4.a) obj;
                aVar4.getClass();
                hVar.f10120b.d(aVar4, iVar);
                break;
            case 10:
                q8.v vVar = (q8.v) this.f319f;
                q8.w wVar2 = (q8.w) this.f320g;
                x4.a aVar5 = (x4.a) obj;
                aVar5.getClass();
                vVar.f10191b.d(aVar5, wVar2);
                break;
            case 11:
                xb.a aVar6 = (xb.a) this.f319f;
                c1 c1Var2 = (c1) this.f320g;
                k8.b bVar3 = (k8.b) obj;
                bVar3.getClass();
                k8.b bVar4 = (k8.b) c1Var2.getValue();
                if (bVar3 != ((k8.b) c1Var2.getValue())) {
                    int iOrdinal = bVar3.ordinal();
                    if (iOrdinal == 0) {
                        str = "all";
                    } else if (iOrdinal == 1) {
                        str = "intercepted";
                    } else {
                        if (iOrdinal != 2) {
                            g5.f.a();
                            return null;
                        }
                        str = "revocable";
                    }
                    Map mapSingletonMap = Collections.singletonMap("record_type", str);
                    mapSingletonMap.getClass();
                    td.h.P("click_switch_record_type", "all_records", mapSingletonMap);
                }
                c1Var2.setValue(bVar3);
                k8.b bVar5 = k8.b.f7280f;
                if (bVar3 == bVar5 && bVar4 != null && bVar4 != bVar5) {
                    aVar6.invoke();
                }
                return jb.v.f6774a;
            case 12:
                c1 c1Var3 = (c1) this.f319f;
                c1 c1Var4 = (c1) this.f320g;
                int iIntValue2 = ((Integer) obj).intValue();
                Integer num = (Integer) c1Var3.getValue();
                if (num != null && num.intValue() == iIntValue2) {
                    c1Var3.setValue(null);
                    c1Var4.setValue(null);
                }
                return jb.v.f6774a;
            case 13:
                xb.p pVar = (xb.p) this.f319f;
                o1 o1Var = (o1) this.f320g;
                z0 z0Var = (z0) obj;
                z0Var.getClass();
                pVar.invoke(o1Var, z0Var);
                break;
            case 14:
                Instant instant = (Instant) this.f319f;
                ZoneId zoneId = (ZoneId) this.f320g;
                p3 p3Var = (p3) obj;
                p3Var.getClass();
                return (p3Var.f11882h == z8.g.i || (durationV = x0.v(p3Var, instant, zoneId)) == null || durationV.compareTo(Duration.ZERO) > 0) ? p3Var : p3.a(p3Var, z8.g.f16512h, Boolean.FALSE, null, null, null, null, null, 0L, null, null, null, null, 1073741439);
            default:
                ad.w wVar3 = (ad.w) this.f319f;
                z8.b bVar6 = (z8.b) this.f320g;
                ad.n nVar2 = (ad.n) obj;
                nVar2.getClass();
                z zVar = (z) bVar6.invoke(nVar2);
                wVar3.getClass();
                e0 e0VarE2 = new ed.j(wVar3, zVar).e();
                try {
                    int i14 = e0VarE2.f471h;
                    h0 h0Var2 = e0VarE2.f473k;
                    String strI = h0Var2 != null ? h0Var2.i() : null;
                    if (strI == null) {
                        strI = "";
                    }
                    l8.a aVar7 = new l8.a(i14, strI, e0VarE2.f472j);
                    e0VarE2.close();
                    return aVar7;
                } finally {
                }
        }
        return jb.v.f6774a;
    }
}
