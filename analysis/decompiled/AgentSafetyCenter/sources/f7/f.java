package f7;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.a1;
import androidx.lifecycle.b1;
import androidx.lifecycle.d1;
import androidx.lifecycle.r0;
import androidx.lifecycle.y0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f implements y9.g, a1, nb.f, d6.e {

    /* renamed from: f, reason: collision with root package name */
    public static f f3933f;

    /* renamed from: g, reason: collision with root package name */
    public static f f3934g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3935c;

    public /* synthetic */ f(int i) {
        this.f3935c = i;
    }

    public static y9.d d(View view, aa.f fVar) {
        view.getClass();
        fVar.getClass();
        int i = 2;
        if (fVar.f16058a) {
            p5.c cVarA = z9.f.f16523a.a(view);
            if (cVarA == null) {
                Log.i("MotionKitBlur", "自研玻璃不可用，兜底为 tint 背景");
                p5.m mVar = new p5.m(view);
                mVar.W(fVar);
                return mVar;
            }
            aa.h hVar = new aa.h(i);
            hVar.f322f = cVarA;
            VarHandle.storeStoreFence();
            aa.q qVar = new aa.q(1);
            qVar.f357f = fVar;
            VarHandle.storeStoreFence();
            ((z9.e) cVarA.f9717f).a(qVar);
            return hVar;
        }
        p5.e eVarC = z9.i.i() ? z9.i.f16559a.c(view) : null;
        if (eVarC == null) {
            Log.i("MotionKitBlur", "窗口内玻璃不可用，兜底为 tint 背景");
            p5.m mVar2 = new p5.m(view);
            mVar2.W(fVar);
            return mVar2;
        }
        aa.a aVar = new aa.a(i);
        aVar.f305f = eVarC;
        VarHandle.storeStoreFence();
        aa.q qVar2 = new aa.q(0);
        qVar2.f357f = fVar;
        VarHandle.storeStoreFence();
        ((z9.h) eVarC.f9722f).a(qVar2);
        return aVar;
    }

    public static b1 e(d1 d1Var, r0 r0Var, int i) {
        a1 defaultViewModelProviderFactory = r0Var;
        if ((i & 2) != 0) {
            defaultViewModelProviderFactory = d1Var instanceof androidx.lifecycle.k ? ((androidx.lifecycle.k) d1Var).getDefaultViewModelProviderFactory() : j4.b.f6553c;
        }
        h4.b defaultViewModelCreationExtras = d1Var instanceof androidx.lifecycle.k ? ((androidx.lifecycle.k) d1Var).getDefaultViewModelCreationExtras() : h4.a.f5289b;
        defaultViewModelProviderFactory.getClass();
        defaultViewModelCreationExtras.getClass();
        return new b1(d1Var.getViewModelStore(), defaultViewModelProviderFactory, defaultViewModelCreationExtras);
    }

    public static a9.h g(a9.c cVar, String str) {
        str.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        a9.h hVar = new a9.h();
        hVar.f264a = cVar;
        hVar.f265b = str;
        hVar.f266c = null;
        hVar.f267d = null;
        hVar.f268e = null;
        hVar.f269f = null;
        hVar.f270g = null;
        hVar.f271h = kb.s.f7404c;
        hVar.i = null;
        hVar.f272j = jCurrentTimeMillis;
        VarHandle.storeStoreFence();
        return hVar;
    }

    public static Font j(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iN = n(fontStyle, font.getStyle());
        for (int i3 = 1; i3 < fontFamily.getSize(); i3++) {
            Font font2 = fontFamily.getFont(i3);
            int iN2 = n(fontStyle, font2.getStyle());
            if (iN2 < iN) {
                font = font2;
                iN = iN2;
            }
        }
        return font;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.fonts.FontFamily m(k3.h[] r10, android.content.ContentResolver r11) throws java.io.IOException {
        /*
            int r0 = r10.length
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L5:
            if (r3 >= r0) goto Lc9
            r5 = r10[r3]
            android.net.Uri r6 = r5.f7232a
            java.lang.String r6 = r6.getScheme()
            java.lang.String r7 = "systemfont"
            boolean r6 = java.util.Objects.equals(r6, r7)
            android.net.Uri r8 = r5.f7232a
            java.lang.String r9 = r5.f7236e
            if (r6 == 0) goto L6b
            java.lang.String r5 = r8.getScheme()
            boolean r5 = java.util.Objects.equals(r5, r7)
            if (r5 == 0) goto L2a
            java.lang.String r5 = r8.getAuthority()
            goto L2b
        L2a:
            r5 = r1
        L2b:
            if (r5 != 0) goto L2e
            goto L4b
        L2e:
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r2)
            android.graphics.Typeface r6 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r2)
            if (r5 == 0) goto L41
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L41
            goto L42
        L41:
            r5 = r1
        L42:
            if (r5 != 0) goto L45
            goto L4b
        L45:
            android.graphics.fonts.Font r5 = f3.d.f(r5)
            if (r5 != 0) goto L4e
        L4b:
            r5 = r1
            goto Lb7
        L4e:
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            if (r6 == 0) goto L55
            goto Lb7
        L55:
            android.graphics.fonts.Font$Builder r6 = new android.graphics.fonts.Font$Builder     // Catch: java.io.IOException -> L63
            r6.<init>(r5)     // Catch: java.io.IOException -> L63
            android.graphics.fonts.Font$Builder r5 = r6.setFontVariationSettings(r9)     // Catch: java.io.IOException -> L63
            android.graphics.fonts.Font r5 = r5.build()     // Catch: java.io.IOException -> L63
            goto Lb7
        L63:
            java.lang.String r5 = "TypefaceCompatApi31Impl"
            java.lang.String r6 = "Failed to clone Font instance. Fall back to provider font."
            android.util.Log.e(r5, r6)
            goto L4b
        L6b:
            java.lang.String r6 = "r"
            android.os.ParcelFileDescriptor r6 = r11.openFileDescriptor(r8, r6, r1)     // Catch: java.io.IOException -> L79
            if (r6 != 0) goto L7b
            if (r6 == 0) goto L4b
            r6.close()     // Catch: java.io.IOException -> L79
            goto L4b
        L79:
            r5 = move-exception
            goto Laf
        L7b:
            android.graphics.fonts.Font$Builder r7 = new android.graphics.fonts.Font$Builder     // Catch: java.lang.Throwable -> L9c
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L9c
            int r8 = r5.f7234c     // Catch: java.lang.Throwable -> L9c
            android.graphics.fonts.Font$Builder r7 = r7.setWeight(r8)     // Catch: java.lang.Throwable -> L9c
            boolean r8 = r5.f7235d     // Catch: java.lang.Throwable -> L9c
            android.graphics.fonts.Font$Builder r7 = r7.setSlant(r8)     // Catch: java.lang.Throwable -> L9c
            int r5 = r5.f7233b     // Catch: java.lang.Throwable -> L9c
            android.graphics.fonts.Font$Builder r5 = r7.setTtcIndex(r5)     // Catch: java.lang.Throwable -> L9c
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L9c
            if (r7 != 0) goto L9e
            r5.setFontVariationSettings(r9)     // Catch: java.lang.Throwable -> L9c
            goto L9e
        L9c:
            r5 = move-exception
            goto La6
        L9e:
            android.graphics.fonts.Font r5 = r5.build()     // Catch: java.lang.Throwable -> L9c
            r6.close()     // Catch: java.io.IOException -> L79
            goto Lb7
        La6:
            r6.close()     // Catch: java.lang.Throwable -> Laa
            goto Lae
        Laa:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L79
        Lae:
            throw r5     // Catch: java.io.IOException -> L79
        Laf:
            java.lang.String r6 = "TypefaceCompatApi29Impl"
            java.lang.String r7 = "Font load failed"
            android.util.Log.w(r6, r7, r5)
            goto L4b
        Lb7:
            if (r5 != 0) goto Lba
            goto Lc5
        Lba:
            if (r4 != 0) goto Lc2
            android.graphics.fonts.FontFamily$Builder r4 = new android.graphics.fonts.FontFamily$Builder
            r4.<init>(r5)
            goto Lc5
        Lc2:
            r4.addFont(r5)
        Lc5:
            int r3 = r3 + 1
            goto L5
        Lc9:
            if (r4 != 0) goto Lcc
            return r1
        Lcc:
            android.graphics.fonts.FontFamily r10 = r4.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.f.m(k3.h[], android.content.ContentResolver):android.graphics.fonts.FontFamily");
    }

    public static int n(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean p(c4.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.f.p(c4.b, android.text.Editable, int, int, boolean):boolean");
    }

    public static a9.i q(String str, String str2, String str3, int i, int i3, ArrayList arrayList, String str4, List list, int i10) {
        if ((i10 & 16) != 0) {
            i3 = 0;
        }
        List list2 = arrayList;
        if ((i10 & 32) != 0) {
            list2 = kb.s.f7404c;
        }
        if ((i10 & 64) != 0) {
            str4 = null;
        }
        if ((i10 & 128) != 0) {
            list = null;
        }
        str2.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        a9.i iVar = new a9.i();
        iVar.f273a = str;
        iVar.f274b = str2;
        iVar.f275c = str3;
        iVar.f276d = i;
        iVar.f277e = i3;
        iVar.f278f = list2;
        iVar.f279g = str4;
        iVar.f280h = list;
        iVar.i = jCurrentTimeMillis;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public y0 a(Class cls) {
        return id.c.m(cls);
    }

    @Override // androidx.lifecycle.a1
    public y0 b(yb.e eVar, h4.c cVar) {
        Class cls = eVar.f16088a;
        cls.getClass();
        return c(cls, cVar);
    }

    public y0 c(Class cls, h4.c cVar) {
        return a(cls);
    }

    public Typeface f(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyM = m((k3.h[]) list.get(0), contentResolver);
            if (fontFamilyM == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyM);
            for (int i3 = 1; i3 < list.size(); i3++) {
                FontFamily fontFamilyM2 = m((k3.h[]) list.get(i3), contentResolver);
                if (fontFamilyM2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyM2);
                }
            }
            return customFallbackBuilder.setStyle(j(fontFamilyM, i).getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    @Override // y9.g
    public String getId() {
        switch (this.f3935c) {
            case 4:
                return "glass_blend";
            case 5:
                return "blur";
            case 6:
                return "glass_text";
            case 7:
                return "glass_inner_shadow";
            case 8:
                return "glass_refraction";
            default:
                return "glass_stroke";
        }
    }

    @Override // d6.e
    public boolean h() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y9.g
    public y9.d i(View view, y9.j jVar) {
        boolean z10;
        p5.c cVarA;
        Object objL;
        aa.h hVar = null;
        hVar = null;
        int i = 1;
        int i3 = 0;
        switch (this.f3935c) {
            case 4:
                aa.d dVar = (aa.d) jVar;
                view.getClass();
                dVar.getClass();
                if (dVar.f16058a) {
                    p5.c cVarA2 = z9.f.f16523a.a(view);
                    if (cVarA2 != null) {
                        aa.h hVar2 = new aa.h(i3);
                        hVar2.f322f = cVarA2;
                        VarHandle.storeStoreFence();
                        List listJ0 = kb.l.J0(dVar.f310c, 4);
                        int size = listJ0.size();
                        int[] iArr = new int[size];
                        for (int i10 = 0; i10 < size; i10++) {
                            iArr[i10] = ((Number) ((jb.g) listJ0.get(i10)).f6759c).intValue();
                        }
                        int size2 = listJ0.size();
                        int[] iArr2 = new int[size2];
                        for (int i11 = 0; i11 < size2; i11++) {
                            iArr2[i11] = ((Number) ((jb.g) listJ0.get(i11)).f6760f).intValue();
                        }
                        p5.c cVar = hVar2.f322f;
                        aa.g gVar = new aa.g(i3);
                        gVar.f319f = iArr;
                        gVar.f320g = iArr2;
                        VarHandle.storeStoreFence();
                        ((z9.e) cVar.f9717f).a(gVar);
                        hVar = hVar2;
                    }
                } else {
                    p5.e eVarC = z9.i.f16559a.c(view);
                    if (eVarC != null) {
                        aa.b bVar = new aa.b(i);
                        bVar.f307f = eVarC;
                        VarHandle.storeStoreFence();
                        z9.h hVar3 = (z9.h) eVarC.f9722f;
                        hVar3.getClass();
                        z9.g gVar2 = hVar3.f16558c;
                        gVar2.getClass();
                        gVar2.f16536f = kb.l.J0(dVar.f310c, 4);
                        if (z9.i.f16566h > 0) {
                            z9.i.i.add(hVar3);
                            hVar = bVar;
                        } else {
                            hVar3.b();
                            hVar = bVar;
                        }
                    }
                }
                return hVar;
            case 5:
                return d(view, (aa.f) jVar);
            case 6:
                aa.o oVar = (aa.o) jVar;
                view.getClass();
                oVar.getClass();
                if (!oVar.f16058a || !((z10 = view instanceof TextView)) || (cVarA = z9.f.f16523a.a(view)) == null) {
                    return null;
                }
                aa.n nVar = new aa.n();
                nVar.f334c = cVarA;
                nVar.f335f = new WeakReference(view);
                nVar.f337h = new Path();
                aa.i iVar = new aa.i(i3);
                iVar.f324b = nVar;
                VarHandle.storeStoreFence();
                nVar.f344p = iVar;
                aa.m mVar = new aa.m();
                mVar.f333c = nVar;
                VarHandle.storeStoreFence();
                nVar.f345q = mVar;
                aa.l lVar = new aa.l(i3);
                lVar.f332f = nVar;
                VarHandle.storeStoreFence();
                nVar.f346r = lVar;
                try {
                    objL = Class.forName("com.android.internal.graphics.backdrop.BackdropLayerDrawable$PathProvider");
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                boolean z11 = objL instanceof jb.h;
                Object obj = objL;
                if (z11) {
                    obj = null;
                }
                nVar.f347s = (Class) obj;
                view.addOnLayoutChangeListener(nVar.f344p);
                TextView textView = z10 ? (TextView) view : null;
                if (textView != null) {
                    textView.addTextChangedListener(nVar.f345q);
                }
                VarHandle.storeStoreFence();
                nVar.d(oVar);
                return nVar;
            case 7:
                aa.r rVar = (aa.r) jVar;
                view.getClass();
                rVar.getClass();
                if (rVar.f16058a) {
                    p5.c cVarA3 = z9.f.f16523a.a(view);
                    if (cVarA3 == null) {
                        return null;
                    }
                    aa.h hVar4 = new aa.h(i);
                    hVar4.f322f = cVarA3;
                    VarHandle.storeStoreFence();
                    a9.e eVar = new a9.e(2);
                    eVar.f257f = rVar;
                    VarHandle.storeStoreFence();
                    ((z9.e) cVarA3.f9717f).a(eVar);
                    return hVar4;
                }
                p5.e eVarC2 = z9.i.f16559a.c(view);
                if (eVarC2 == null) {
                    return null;
                }
                aa.a aVar = new aa.a(i3);
                aVar.f305f = eVarC2;
                VarHandle.storeStoreFence();
                z9.h hVar5 = (z9.h) eVarC2.f9722f;
                hVar5.getClass();
                z9.g gVar3 = hVar5.f16558c;
                gVar3.getClass();
                gVar3.D = true;
                gVar3.E = rVar.f358c;
                gVar3.F = rVar.f359d;
                gVar3.G = rVar.f360e;
                if (z9.i.f16566h > 0) {
                    z9.i.i.add(hVar5);
                    return aVar;
                }
                hVar5.b();
                return aVar;
            case 8:
                aa.t tVar = (aa.t) jVar;
                view.getClass();
                tVar.getClass();
                if (tVar.f16058a) {
                    p5.c cVarA4 = z9.f.f16523a.a(view);
                    if (cVarA4 == null) {
                        return null;
                    }
                    aa.s sVar = new aa.s(i3);
                    sVar.f362f = cVarA4;
                    VarHandle.storeStoreFence();
                    a9.e eVar2 = new a9.e(3);
                    eVar2.f257f = tVar;
                    VarHandle.storeStoreFence();
                    ((z9.e) cVarA4.f9717f).a(eVar2);
                    return sVar;
                }
                p5.e eVarC3 = z9.i.f16559a.c(view);
                if (eVarC3 == null) {
                    return null;
                }
                aa.b bVar2 = new aa.b(i3);
                bVar2.f307f = eVarC3;
                VarHandle.storeStoreFence();
                z9.h hVar6 = (z9.h) eVarC3.f9722f;
                hVar6.getClass();
                z9.g gVar4 = hVar6.f16558c;
                gVar4.getClass();
                gVar4.H = true;
                float f5 = tVar.f363c;
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                }
                gVar4.I = f5;
                float f10 = tVar.f364d;
                gVar4.J = f10 >= 0.0f ? f10 : 0.0f;
                gVar4.K = tVar.f365e;
                gVar4.L = tVar.f366f;
                if (z9.i.f16566h > 0) {
                    z9.i.i.add(hVar6);
                    return bVar2;
                }
                hVar6.b();
                return bVar2;
            default:
                aa.u uVar = (aa.u) jVar;
                view.getClass();
                uVar.getClass();
                if (uVar.f16058a) {
                    p5.c cVarA5 = z9.f.f16523a.a(view);
                    if (cVarA5 == null) {
                        return null;
                    }
                    aa.s sVar2 = new aa.s(i);
                    sVar2.f362f = cVarA5;
                    VarHandle.storeStoreFence();
                    aa.c cVar2 = new aa.c(i);
                    cVar2.f309f = uVar;
                    VarHandle.storeStoreFence();
                    ((z9.e) cVarA5.f9717f).a(cVar2);
                    return sVar2;
                }
                p5.e eVarC4 = z9.i.f16559a.c(view);
                if (eVarC4 == null) {
                    return null;
                }
                aa.a aVar2 = new aa.a(i);
                aVar2.f305f = eVarC4;
                VarHandle.storeStoreFence();
                aa.c cVar3 = new aa.c(i3);
                cVar3.f309f = uVar;
                VarHandle.storeStoreFence();
                ((z9.h) eVarC4.f9722f).a(cVar3);
                return aVar2;
        }
    }

    @Override // y9.g
    public boolean k(Context context) {
        switch (this.f3935c) {
            case 4:
                z9.f fVar = z9.f.f16523a;
                if (!z9.f.c()) {
                    z9.i iVar = z9.i.f16559a;
                    if (!z9.i.i()) {
                    }
                }
                break;
            case 5:
                break;
            case 6:
                z9.f fVar2 = z9.f.f16523a;
                break;
            case 7:
                z9.f fVar3 = z9.f.f16523a;
                if (!z9.f.c()) {
                    z9.i iVar2 = z9.i.f16559a;
                    if (!z9.i.i()) {
                    }
                }
                break;
            case 8:
                z9.f fVar4 = z9.f.f16523a;
                if (!z9.f.c()) {
                    z9.i iVar3 = z9.i.f16559a;
                    if (!z9.i.i()) {
                    }
                }
                break;
            default:
                z9.f fVar5 = z9.f.f16523a;
                if (!z9.f.c()) {
                    z9.i iVar4 = z9.i.f16559a;
                    if (!z9.i.i()) {
                    }
                }
                break;
        }
        return true;
    }

    public e9.h l(Context context) {
        e9.h hVar;
        context.getClass();
        Context applicationContext = context.getApplicationContext();
        e9.h hVar2 = e9.h.f3656g;
        if (hVar2 != null) {
            return hVar2;
        }
        synchronized (this) {
            hVar = e9.h.f3656g;
            if (hVar == null) {
                applicationContext.getClass();
                hVar = new e9.h(applicationContext);
                e9.h.f3656g = hVar;
            }
        }
        return hVar;
    }

    @Override // y9.g
    public y9.j o() {
        switch (this.f3935c) {
            case 4:
                return new aa.d();
            case 5:
                return new aa.f();
            case 6:
                return new aa.o();
            case 7:
                return new aa.r();
            case 8:
                return new aa.t();
            default:
                return new aa.u();
        }
    }

    public String toString() throws JSONException {
        switch (this.f3935c) {
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("noBootUp", false);
                    jSONObject.put("replacePackage", "");
                    jSONObject.put("printLog", false);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                return jSONObject.toString();
            default:
                return super.toString();
        }
    }

    @Override // d6.e
    public void shutdown() {
    }
}
