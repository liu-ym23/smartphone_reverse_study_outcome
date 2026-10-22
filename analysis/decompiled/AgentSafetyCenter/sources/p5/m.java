package p5;

import a4.a0;
import a4.w;
import a4.z;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.x0;
import b8.e0;
import b8.r0;
import com.fasterxml.jackson.databind.JsonNode;
import com.stepos.agentsafetycenter.R;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import m.o0;
import org.xmlpull.v1.XmlPullParserException;
import p.f0;
import p.v;
import s1.b0;
import u1.c1;
import u1.g0;
import u1.n1;
import u1.w1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements y9.d, r0, d6.e, t0.f, k0.d {
    public static m i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9740c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9741f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9742g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9743h;

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m(android.content.Context r3) {
        /*
            r2 = this;
            r0 = 11
            r2.f9740c = r0
            android.content.ContentResolver r0 = r3.getContentResolver()
            java.lang.String r1 = "net_env"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)
            r2.<init>()
            java.lang.String r1 = "basic"
            android.text.TextUtils.isEmpty(r1)
            android.content.Context r3 = r3.getApplicationContext()
            r2.f9741f = r3
            r2.f9742g = r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f9743h = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "https://i."
            r2.<init>(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L6b
            r0.getClass()
            int r3 = r0.hashCode()
            r1 = -1
            switch(r3) {
                case 99349: goto L54;
                case 114214: goto L49;
                case 3556498: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L5e
        L3e:
            java.lang.String r3 = "test"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L47
            goto L5e
        L47:
            r1 = 2
            goto L5e
        L49:
            java.lang.String r3 = "stg"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L52
            goto L5e
        L52:
            r1 = 1
            goto L5e
        L54:
            java.lang.String r3 = "dev"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L5d
            goto L5e
        L5d:
            r1 = 0
        L5e:
            switch(r1) {
                case 0: goto L68;
                case 1: goto L65;
                case 2: goto L62;
                default: goto L61;
            }
        L61:
            goto L6b
        L62:
            java.lang.String r3 = "t-stepaos.com"
            goto L6d
        L65:
            java.lang.String r3 = "s-stepaos.com"
            goto L6d
        L68:
            java.lang.String r3 = "d-stepaos.com"
            goto L6d
        L6b:
            java.lang.String r3 = "stepaos.com"
        L6d:
            java.lang.String r1 = "/uc/oauth/member/getBasicInfo"
            java.lang.String r2 = androidx.activity.b.n(r2, r3, r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r1 = "env: "
            r3.<init>(r1)
            r3.append(r0)
            java.lang.String r0 = ", url: "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "[Cloud]Account.SDK"
            android.util.Log.i(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.m.<init>(android.content.Context):void");
    }

    public static m J(Context context, AttributeSet attributeSet, int[] iArr, int i3) {
        return new m(context, context.obtainStyledAttributes(attributeSet, iArr, i3, 0));
    }

    public static final void b(m mVar, Network network, boolean z10) {
        boolean z11;
        Network[] allNetworks = ((ConnectivityManager) mVar.f9741f).getAllNetworks();
        int length = allNetworks.length;
        boolean z12 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Network network2 = allNetworks[i3];
            if (yb.k.a(network2, network)) {
                z11 = z10;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) mVar.f9741f).getNetworkCapabilities(network2);
                z11 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z11) {
                z12 = true;
                break;
            }
            i3++;
        }
        i6.f fVar = (i6.f) mVar.f9742g;
        synchronized (fVar) {
            try {
                if (((t5.g) fVar.f5808c.get()) != null) {
                    fVar.i = z12;
                } else {
                    fVar.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean v(Editable editable, KeyEvent keyEvent, boolean z10) {
        a0[] a0VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (a0VarArr = (a0[]) editable.getSpans(selectionStart, selectionEnd, a0.class)) != null && a0VarArr.length > 0) {
                for (a0 a0Var : a0VarArr) {
                    int spanStart = editable.getSpanStart(a0Var);
                    int spanEnd = editable.getSpanEnd(a0Var);
                    if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Drawable A(int i3) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f9742g;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) ? typedArray.getDrawable(i3) : id.k.v(resourceId, (Context) this.f9741f);
    }

    public Drawable B(int i3) {
        int resourceId;
        Drawable drawableE;
        if (!((TypedArray) this.f9742g).hasValue(i3) || (resourceId = ((TypedArray) this.f9742g).getResourceId(i3, 0)) == 0) {
            return null;
        }
        m.s sVarA = m.s.a();
        Context context = (Context) this.f9741f;
        synchronized (sVarA) {
            drawableE = sVarA.f8062a.e(context, resourceId, true);
        }
        return drawableE;
    }

    public Typeface C(int i3, int i10, o0 o0Var) throws Throwable {
        o0 o0Var2;
        XmlPullParserException xmlPullParserException;
        IOException iOException;
        int resourceId = ((TypedArray) this.f9742g).getResourceId(i3, 0);
        if (resourceId != 0) {
            if (((TypedValue) this.f9743h) == null) {
                this.f9743h = new TypedValue();
            }
            Context context = (Context) this.f9741f;
            TypedValue typedValue = (TypedValue) this.f9743h;
            ThreadLocal threadLocal = e3.k.f3478a;
            if (!context.isRestricted()) {
                Resources resources = context.getResources();
                resources.getValue(resourceId, typedValue, true);
                CharSequence charSequence = typedValue.string;
                if (charSequence == null) {
                    throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(resourceId) + "\" (" + Integer.toHexString(resourceId) + ") is not a Font: " + typedValue);
                }
                String string = charSequence.toString();
                if (!string.startsWith("res/")) {
                    o0Var.a(-3);
                    return null;
                }
                Typeface typeface = (Typeface) f3.d.f3907b.b(f3.d.d(resources, resourceId, string, typedValue.assetCookie, i10));
                if (typeface != null) {
                    o0Var.b(typeface);
                    return typeface;
                }
                try {
                } catch (IOException e10) {
                    e = e10;
                    o0Var2 = o0Var;
                } catch (XmlPullParserException e11) {
                    e = e11;
                    o0Var2 = o0Var;
                }
                try {
                    if (!string.toLowerCase().endsWith(".xml")) {
                        Typeface typefaceC = f3.d.c(resources, resourceId, string, typedValue.assetCookie, i10);
                        if (typefaceC != null) {
                            o0Var.b(typefaceC);
                        } else {
                            o0Var.a(-3);
                        }
                        return typefaceC;
                    }
                    e3.d dVarH = e3.b.h(resources.getXml(resourceId), resources);
                    if (dVarH != null) {
                        return f3.d.b(context, dVarH, resources, resourceId, string, typedValue.assetCookie, i10, o0Var, true);
                    }
                    try {
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        o0Var.a(-3);
                        return null;
                    } catch (IOException e12) {
                        iOException = e12;
                        o0Var2 = o0Var;
                        Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), iOException);
                        o0Var2.a(-3);
                        return null;
                    } catch (XmlPullParserException e13) {
                        xmlPullParserException = e13;
                        o0Var2 = o0Var;
                        Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), xmlPullParserException);
                        o0Var2.a(-3);
                        return null;
                    }
                } catch (IOException e14) {
                    e = e14;
                    iOException = e;
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), iOException);
                    o0Var2.a(-3);
                    return null;
                } catch (XmlPullParserException e15) {
                    e = e15;
                    xmlPullParserException = e;
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), xmlPullParserException);
                    o0Var2.a(-3);
                    return null;
                }
            }
        }
        return null;
    }

    public long D() {
        return ((f1.b) this.f9743h).f3858c.f3857d;
    }

    public boolean E(CharSequence charSequence, int i3, int i10, z zVar) {
        if ((zVar.f219c & 3) == 0) {
            a4.c cVar = (a4.c) this.f9743h;
            b4.a aVarB = zVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarB.f1900h).getShort(iA + aVarB.f1897c);
            }
            cVar.getClass();
            ThreadLocal threadLocal = a4.c.f161b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = (StringBuilder) threadLocal.get();
            sb2.setLength(0);
            while (i3 < i10) {
                sb2.append(charSequence.charAt(i3));
                i3++;
            }
            boolean zHasGlyph = cVar.f162a.hasGlyph(sb2.toString());
            int i11 = zVar.f219c & 4;
            zVar.f219c = zHasGlyph ? i11 | 2 : i11 | 1;
        }
        return (zVar.f219c & 3) == 2;
    }

    public boolean F(zd.g gVar) {
        if (gVar != null && gVar.c(2)) {
            zd.d dVar = (zd.d) gVar;
            for (int i3 : (int[]) this.f9743h) {
                if (dVar.f16581c == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean G() {
        return !(((w1) ((sa.c) this.f9741f).f12170f).isEmpty() && ((w1) ((sa.c) this.f9743h).f12170f).isEmpty() && ((w1) ((sa.c) this.f9742g).f12170f).isEmpty());
    }

    public boolean H() {
        if (((g2.s) this.f9741f).f4266c != this.f9743h) {
            return true;
        }
        m mVar = (m) this.f9742g;
        return mVar != null && mVar.H();
    }

    public boolean I(int i3, w2.e eVar, z2.e eVar2) {
        x2.b bVar = (x2.b) this.f9742g;
        int[] iArr = eVar.f15184o0;
        int[] iArr2 = eVar.f15189t;
        bVar.f15523a = iArr[0];
        bVar.f15524b = iArr[1];
        bVar.f15525c = eVar.o();
        bVar.f15526d = eVar.i();
        bVar.i = false;
        bVar.f15531j = i3;
        boolean z10 = bVar.f15523a == 3;
        boolean z11 = bVar.f15524b == 3;
        boolean z12 = z10 && eVar.V > 0.0f;
        boolean z13 = z11 && eVar.V > 0.0f;
        if (z12 && iArr2[0] == 4) {
            bVar.f15523a = 1;
        }
        if (z13 && iArr2[1] == 4) {
            bVar.f15524b = 1;
        }
        eVar2.b(eVar, bVar);
        eVar.K(bVar.f15527e);
        eVar.H(bVar.f15528f);
        eVar.E = bVar.f15530h;
        int i10 = bVar.f15529g;
        eVar.Z = i10;
        eVar.E = i10 > 0;
        bVar.f15531j = 0;
        return bVar.i;
    }

    public void K(androidx.lifecycle.o oVar) {
        x0 x0Var = (x0) this.f9743h;
        if (x0Var != null) {
            x0Var.run();
        }
        androidx.lifecycle.z zVar = (androidx.lifecycle.z) this.f9741f;
        zVar.getClass();
        oVar.getClass();
        x0 x0Var2 = new x0();
        x0Var2.f1449c = zVar;
        x0Var2.f1450f = oVar;
        VarHandle.storeStoreFence();
        this.f9743h = x0Var2;
        ((Handler) this.f9742g).postAtFrontOfQueue(x0Var2);
    }

    public Object L(CharSequence charSequence, int i3, int i10, int i11, boolean z10, a4.q qVar) {
        int i12;
        char c9;
        w wVar = (w) ((i) this.f9742g).f9732g;
        a4.s sVar = new a4.s();
        sVar.f193a = 1;
        sVar.f194b = wVar;
        sVar.f195c = wVar;
        VarHandle.storeStoreFence();
        int iCodePointAt = Character.codePointAt(charSequence, i3);
        boolean zB = true;
        int i13 = 0;
        int iCharCount = i3;
        loop0: while (true) {
            i12 = iCharCount;
            while (iCharCount < i10 && i13 < i11 && zB) {
                SparseArray sparseArray = sVar.f195c.f210a;
                w wVar2 = sparseArray == null ? null : (w) sparseArray.get(iCodePointAt);
                if (sVar.f193a == 2) {
                    if (wVar2 != null) {
                        sVar.f195c = wVar2;
                        sVar.f198f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            sVar.a();
                        } else if (iCodePointAt != 65039) {
                            w wVar3 = sVar.f195c;
                            if (wVar3.f211b != null) {
                                if (sVar.f198f != 1) {
                                    sVar.f196d = wVar3;
                                    sVar.a();
                                } else if (sVar.b()) {
                                    sVar.f196d = sVar.f195c;
                                    sVar.a();
                                } else {
                                    sVar.a();
                                }
                                c9 = 3;
                            } else {
                                sVar.a();
                            }
                        }
                        c9 = 1;
                    }
                    c9 = 2;
                } else if (wVar2 == null) {
                    sVar.a();
                    c9 = 1;
                } else {
                    sVar.f193a = 2;
                    sVar.f195c = wVar2;
                    sVar.f198f = 1;
                    c9 = 2;
                }
                sVar.f197e = iCodePointAt;
                if (c9 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i12)) + i12;
                    if (iCharCount < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c9 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c9 == 3) {
                    if (z10 || !E(charSequence, i12, iCharCount, sVar.f196d.f211b)) {
                        zB = qVar.b(charSequence, i12, iCharCount, sVar.f196d.f211b);
                        i13++;
                    }
                }
            }
            break loop0;
        }
        if (sVar.f193a == 2 && sVar.f195c.f211b != null && ((sVar.f198f > 1 || sVar.b()) && i13 < i11 && zB && (z10 || !E(charSequence, i12, iCharCount, sVar.f195c.f211b)))) {
            qVar.b(charSequence, i12, iCharCount, sVar.f195c.f211b);
        }
        return qVar.getResult();
    }

    public void M() {
        ((TypedArray) this.f9742g).recycle();
    }

    public void N(Object obj) {
        long jB = s0.h.b();
        if (jB == s0.k.f11197a) {
            this.f9743h = obj;
            return;
        }
        synchronized (this.f9742g) {
            s0.j jVar = (s0.j) ((AtomicReference) this.f9741f).get();
            int iA = jVar.a(jB);
            if (iA < 0) {
                ((AtomicReference) this.f9741f).set(jVar.b(obj, jB));
            } else {
                jVar.f11196c[iA] = obj;
            }
        }
    }

    public void O(d1.o oVar) {
        ((f1.b) this.f9743h).f3858c.f3856c = oVar;
    }

    public void P(o2.c cVar) {
        ((f1.b) this.f9743h).f3858c.f3854a = cVar;
    }

    public void Q(o2.l lVar) {
        ((f1.b) this.f9743h).f3858c.f3855b = lVar;
    }

    public void R(long j10) {
        ((f1.b) this.f9743h).f3858c.f3857d = j10;
    }

    public void S(w2.f fVar, int i3, int i10, int i11) {
        int i12 = fVar.f15159a0;
        int i13 = fVar.f15161b0;
        fVar.f15159a0 = 0;
        fVar.f15161b0 = 0;
        fVar.K(i10);
        fVar.H(i11);
        if (i12 < 0) {
            fVar.f15159a0 = 0;
        } else {
            fVar.f15159a0 = i12;
        }
        if (i13 < 0) {
            fVar.f15161b0 = 0;
        } else {
            fVar.f15161b0 = i13;
        }
        w2.f fVar2 = (w2.f) this.f9743h;
        fVar2.f15199s0 = i3;
        fVar2.Q();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object T(pb.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof y8.z
            if (r0 == 0) goto L13
            r0 = r7
            y8.z r0 = (y8.z) r0
            int r1 = r0.f16026h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16026h = r1
            goto L18
        L13:
            y8.z r0 = new y8.z
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f16024f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f16026h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f16023c
            id.c.I(r7)
            jb.i r7 = (jb.i) r7
            java.lang.Object r7 = r7.f6762c
            goto L5d
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L37:
            id.c.I(r7)
            jb.i r7 = (jb.i) r7
            java.lang.Object r7 = r7.f6762c
            goto L4d
        L3f:
            id.c.I(r7)
            y8.w r7 = y8.w.f16013g
            r0.f16026h = r4
            java.lang.Object r7 = r6.U(r7, r0)
            if (r7 != r1) goto L4d
            goto L59
        L4d:
            y8.w r2 = y8.w.f16014h
            r0.f16023c = r7
            r0.f16026h = r3
            java.lang.Object r6 = r6.U(r2, r0)
            if (r6 != r1) goto L5a
        L59:
            return r1
        L5a:
            r5 = r7
            r7 = r6
            r6 = r5
        L5d:
            y8.b0 r0 = new y8.b0
            r0.<init>()
            r0.f15952a = r6
            r0.f15953b = r7
            java.lang.invoke.VarHandle.storeStoreFence()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.m.T(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: all -> 0x00f6, TRY_ENTER, TryCatch #0 {all -> 0x00f6, blocks: (B:18:0x0043, B:31:0x008c, B:33:0x0093, B:39:0x00bd, B:41:0x00c1, B:48:0x00f0, B:49:0x00f5), top: B:54:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Type inference failed for: r13v4, types: [pb.i, xb.q] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object U(y8.w r14, pb.c r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.m.U(y8.w, pb.c):java.lang.Object");
    }

    public void V() {
        f0 f0Var = (f0) this.f9741f;
        String str = (String) this.f9742g;
        List list = (List) f0Var.k(str);
        if (list != null) {
            list.remove((xb.a) this.f9743h);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        f0Var.m(str, list);
    }

    public void W(y9.j jVar) {
        View view;
        GradientDrawable gradientDrawable = (GradientDrawable) this.f9742g;
        jVar.getClass();
        aa.f fVar = jVar instanceof aa.f ? (aa.f) jVar : null;
        if (fVar == null || (view = (View) ((WeakReference) this.f9741f).get()) == null) {
            return;
        }
        gradientDrawable.setCornerRadius(fVar.f16059b);
        gradientDrawable.setColor(-434431205);
        gradientDrawable.setStroke(1, 620756991);
        view.invalidate();
    }

    public void X(w2.f fVar) {
        ArrayList arrayList = (ArrayList) this.f9741f;
        arrayList.clear();
        int size = fVar.f15196p0.size();
        for (int i3 = 0; i3 < size; i3++) {
            w2.e eVar = (w2.e) fVar.f15196p0.get(i3);
            int[] iArr = eVar.f15184o0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(eVar);
            }
        }
        fVar.f15198r0.f9471b = true;
    }

    @Override // y9.d
    public void a() {
        View view = (View) ((WeakReference) this.f9741f).get();
        if (view != null && view.getBackground() == ((GradientDrawable) this.f9742g)) {
            view.setBackground((Drawable) this.f9743h);
        }
    }

    @Override // k0.d
    public void c(int i3, Object obj) {
        ((g0) this.f9743h).z(i3, (g0) obj);
    }

    @Override // k0.d
    public void d(Object obj) {
        ((ArrayList) this.f9742g).add(this.f9743h);
        this.f9743h = obj;
    }

    @Override // k0.d
    public void e() {
        g0 g0Var = (g0) this.f9743h;
        c1 c1Var = g0Var.H;
        if (!g0Var.G()) {
            r1.a.a("onReuse is only expected on attached node");
        }
        r2.q qVar = g0Var.f13801r;
        if (qVar != null) {
            View view = qVar.f10388f;
            if (view.getParent() != qVar) {
                qVar.addView(view);
            } else {
                qVar.f10391j.invoke();
            }
        }
        b0 b0Var = g0Var.J;
        if (b0Var != null) {
            b0Var.e(false);
        }
        g0Var.f13806w = false;
        if (g0Var.S) {
            g0Var.S = false;
        } else {
            w0.l lVar = g0Var.H.f13745e;
            for (w0.l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.i) {
                if (lVar2.f15126r) {
                    lVar2.w0();
                }
            }
            for (w0.l lVar3 = lVar; lVar3 != null; lVar3 = lVar3.i) {
                if (lVar3.f15126r) {
                    lVar3.y0();
                }
            }
            while (lVar != null) {
                if (lVar.f15126r) {
                    lVar.s0();
                }
                lVar = lVar.i;
            }
        }
        int i3 = g0Var.f13790f;
        g0Var.f13790f = a2.l.f79a.addAndGet(1);
        n1 n1Var = g0Var.f13800q;
        if (n1Var != null) {
            v1.t tVar = (v1.t) n1Var;
            tVar.getLayoutNodes().g(i3);
            tVar.getLayoutNodes().h(g0Var.f13790f, g0Var);
        }
        for (w0.l lVar4 = c1Var.f13746f; lVar4 != null; lVar4 = lVar4.f15118j) {
            lVar4.r0();
        }
        c1Var.e();
        if (c1Var.d(8)) {
            g0Var.E();
        }
        g0.W(g0Var);
        n1 n1Var2 = g0Var.f13800q;
        if (n1Var2 != null) {
            v1.t tVar2 = (v1.t) n1Var2;
            x0.b bVar = tVar2.J;
            if (bVar != null) {
                v1.t tVar3 = bVar.f15507c;
                stepos.support.v7.app.f fVar = bVar.f15505a;
                v vVar = bVar.f15511g;
                if (vVar.e(i3)) {
                    fVar.h(tVar3, i3, false);
                }
                a2.k kVarV = g0Var.v();
                if (kVarV != null && kVarV.f75c.b(a2.u.f132q)) {
                    vVar.a(g0Var.f13790f);
                    fVar.h(tVar3, g0Var.f13790f, true);
                }
            }
            tVar2.getRectManager().f(g0Var, true);
        }
    }

    @Override // k0.d
    public void f(int i3, int i10, int i11) {
        ((g0) this.f9743h).K(i3, i10, i11);
    }

    @Override // k0.d
    public void g(int i3, int i10) {
        ((g0) this.f9743h).Q(i3, i10);
    }

    @Override // d6.e
    public boolean h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f9741f;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    @Override // k0.d
    public void i() {
        this.f9743h = ((ArrayList) this.f9742g).remove(r0.size() - 1);
    }

    @Override // k0.d
    public /* bridge */ /* synthetic */ void j(int i3, Object obj) {
    }

    @Override // b8.r0
    public String k() {
        switch (this.f9740c) {
        }
        return (String) this.f9742g;
    }

    @Override // k0.d
    public void l() {
        n1 n1Var = ((g0) this.f9741f).f13800q;
        if (n1Var != null) {
            ((v1.t) n1Var).v();
        }
    }

    @Override // k0.d
    public Object m() {
        return this.f9743h;
    }

    @Override // b8.r0
    public boolean o(JsonNode jsonNode) {
        switch (this.f9740c) {
            case 5:
                JsonNode jsonNode2 = (JsonNode) this.f9741f;
                if (!jsonNode2.isDouble() || jsonNode2.doubleValue() != Double.POSITIVE_INFINITY) {
                    if (!jsonNode2.isDouble() || jsonNode2.doubleValue() != Double.NEGATIVE_INFINITY) {
                        if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.NEGATIVE_INFINITY) {
                            if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.POSITIVE_INFINITY) {
                                int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.f9742g));
                                if (iCompareTo > 0 || (((e0) this.f9743h).f1953h && iCompareTo == 0)) {
                                }
                            }
                        }
                    }
                }
                break;
            default:
                JsonNode jsonNode3 = (JsonNode) this.f9741f;
                if (!jsonNode3.isDouble() || jsonNode3.doubleValue() != Double.NEGATIVE_INFINITY) {
                    if ((!jsonNode3.isDouble() || jsonNode3.doubleValue() != Double.POSITIVE_INFINITY) && (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.NEGATIVE_INFINITY)) {
                        if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.POSITIVE_INFINITY) {
                            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.f9742g));
                            if (iCompareTo2 < 0 || (((e0) this.f9743h).f1953h && iCompareTo2 == 0)) {
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public void p(g0 g0Var, u1.t tVar) {
        sa.c cVar = (sa.c) this.f9741f;
        sa.c cVar2 = (sa.c) this.f9742g;
        sa.c cVar3 = (sa.c) this.f9743h;
        int iOrdinal = tVar.ordinal();
        if (iOrdinal == 0) {
            cVar.a(g0Var);
            cVar3.a(g0Var);
            return;
        }
        if (iOrdinal == 1) {
            cVar2.a(g0Var);
            cVar3.a(g0Var);
            return;
        }
        if (iOrdinal == 2) {
            if (g0Var.f13794k != null) {
                cVar3.a(g0Var);
                return;
            } else {
                cVar.a(g0Var);
                return;
            }
        }
        if (iOrdinal != 3) {
            g5.f.a();
        } else if (g0Var.f13794k != null) {
            cVar3.a(g0Var);
        } else {
            cVar2.a(g0Var);
        }
    }

    public String q() {
        if (((String) this.f9741f) == null) {
            synchronized (this) {
                this.f9741f = UUID.randomUUID().toString();
                ua.c.a("SessionController", "generate a sessionId: " + ((String) this.f9741f));
            }
        }
        return (String) this.f9741f;
    }

    public void r() {
        ((ArrayList) this.f9742g).clear();
        this.f9743h = (g0) this.f9741f;
        ((g0) this.f9741f).P();
    }

    public zd.g s(zd.g gVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f9742g;
        if (gVar != null) {
            if (!F(gVar)) {
                return gVar;
            }
            ((ArrayList) this.f9741f).add(new wd.a((zd.d) gVar));
        }
        while (F((zd.g) arrayDeque.peek())) {
            ((ArrayList) this.f9741f).add(new wd.a((zd.d) arrayDeque.poll()));
        }
        return null;
    }

    @Override // d6.e
    public void shutdown() {
        ((ConnectivityManager) this.f9741f).unregisterNetworkCallback((d6.f) this.f9743h);
    }

    public zd.g t(zd.g gVar) {
        zd.g gVarS = s(gVar);
        return gVarS != null ? gVarS : (zd.g) ((ArrayDeque) this.f9742g).poll();
    }

    public boolean u(g0 g0Var) {
        return !(g0Var.f13794k == null) && (((w1) ((sa.c) this.f9741f).f12170f).contains(g0Var) || ((w1) ((sa.c) this.f9742g).f12170f).contains(g0Var));
    }

    public Object w() {
        long jB = s0.h.b();
        if (jB == s0.k.f11197a) {
            return this.f9743h;
        }
        s0.j jVar = (s0.j) ((AtomicReference) this.f9741f).get();
        int iA = jVar.a(jB);
        if (iA >= 0) {
            return jVar.f11196c[iA];
        }
        return null;
    }

    public String[] x(Activity activity, boolean z10) throws j8.a {
        Log.d("[Cloud]Account.SDK", "getAuthToken1  running... timeoutSeconds: 30");
        AccountManager accountManager = AccountManager.get((Context) this.f9741f);
        Account accountY = a.a.y((Context) this.f9741f);
        if (accountY == null) {
            accountY = new Account("unknown", "com.stepos.account");
        }
        Account account = accountY;
        Bundle bundle = new Bundle();
        bundle.putBoolean("invalidateToken", z10);
        if (activity == null) {
            bundle.putBoolean("retry", false);
        }
        AccountManagerFuture<Bundle> authToken = accountManager.getAuthToken(account, (String) this.f9742g, bundle, activity, (AccountManagerCallback<Bundle>) null, (Handler) null);
        synchronized (((ArrayList) this.f9743h)) {
            ((ArrayList) this.f9743h).add(authToken);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = new String[2];
        try {
            try {
                try {
                    Bundle result = authToken.getResult(30L, TimeUnit.SECONDS);
                    synchronized (((ArrayList) this.f9743h)) {
                        ((ArrayList) this.f9743h).remove(authToken);
                    }
                    Log.d("[Cloud]Account.SDK", "getAuthToken1  mCanceled: false");
                    if (result.containsKey("authtoken")) {
                        String string = result.getString("authtoken");
                        strArr[0] = string;
                        strArr[1] = result.getString("authsecret");
                        if (!TextUtils.isEmpty(string)) {
                            return strArr;
                        }
                        if (authToken.isDone()) {
                            throw new j8.a(String.format(((Context) this.f9741f).getString(R.string.scope_null_token), (String) this.f9742g));
                        }
                        Log.w("[Cloud]Account.SDK", "getAutoToken1. accountManagerFuture: " + authToken);
                        throw new j8.a(((Context) this.f9741f).getString(R.string.unsupport_operation));
                    }
                    if (result.containsKey("intent")) {
                        Intent intent = (Intent) result.getParcelable("intent");
                        j8.a aVar = new j8.a();
                        aVar.f6621c = intent;
                        throw aVar;
                    }
                    if (!result.containsKey("errorMessage")) {
                        throw new j8.a(((Context) this.f9741f).getString(R.string.unkown_error));
                    }
                    String str = (String) this.f9742g;
                    Context context = (Context) this.f9741f;
                    ArrayList arrayList = new ArrayList();
                    String string2 = result.getString("errorMessage");
                    int i3 = result.containsKey("errorCode") ? result.getInt("errorCode") : -1;
                    String string3 = result.containsKey("cacheAccountName") ? result.getString("cacheAccountName") : null;
                    if (i3 >= 0) {
                        arrayList.add(Integer.valueOf(i3));
                        arrayList.add(string2);
                    } else if ("params not legal!".equalsIgnoreCase(string2)) {
                        arrayList.add(7);
                        arrayList.add(context.getString(R.string.context_is_null));
                    } else if ("get token failed!".equalsIgnoreCase(string2)) {
                        arrayList.add(2);
                        arrayList.add(context.getString(R.string.get_token_failed));
                    } else {
                        if (("unknown type : " + str).equalsIgnoreCase(string2)) {
                            arrayList.add(8);
                            arrayList.add(String.format(context.getString(R.string.scope_null_token), str));
                        } else if (!TextUtils.isEmpty(string2) && string2.startsWith("uid =") && string2.contains("not match package")) {
                            arrayList.add(9);
                            arrayList.add(context.getString(R.string.uid_not_match));
                        } else {
                            arrayList.add(3);
                            arrayList.add(string2);
                        }
                    }
                    if (string3 == null) {
                        string3 = "";
                    }
                    arrayList.add(string3);
                    ((Integer) arrayList.get(0)).getClass();
                    String str2 = (String) arrayList.get(1);
                    throw new j8.a(str2);
                } catch (OperationCanceledException e10) {
                    Log.w("[Cloud]Account.SDK", "getAuthToken1, fail.", e10);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 <= jCurrentTimeMillis || (jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000 <= 25) {
                        throw new j8.a(((Context) this.f9741f).getString(R.string.get_cancel), e10);
                    }
                    throw new j8.a(((Context) this.f9741f).getString(R.string.sync_timeout), e10);
                }
            } catch (Exception e11) {
                Log.w("[Cloud]Account.SDK", "getAuthToken1, fail.", e11);
                throw new j8.a(((Context) this.f9741f).getString(R.string.error_is_throwed), e11);
            }
        } catch (Throwable th) {
            synchronized (((ArrayList) this.f9743h)) {
                ((ArrayList) this.f9743h).remove(authToken);
                throw th;
            }
        }
    }

    public d1.o y() {
        return ((f1.b) this.f9743h).f3858c.f3856c;
    }

    public ColorStateList z(int i3) throws Resources.NotFoundException {
        int resourceId;
        ColorStateList colorStateListU;
        TypedArray typedArray = (TypedArray) this.f9742g;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListU = id.k.u(resourceId, (Context) this.f9741f)) == null) ? typedArray.getColorStateList(i3) : colorStateListU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(qa.b bVar, xb.q qVar) {
        this.f9740c = 26;
        androidx.room.c cVar = new androidx.room.c(29);
        this.f9741f = bVar;
        this.f9742g = (pb.i) qVar;
        this.f9743h = cVar;
    }

    public m() {
        this.f9740c = 17;
        this.f9741f = new AtomicReference(s0.h.f11183b);
        this.f9742g = new Object();
    }

    public m(Method method, Method method2, Method method3) {
        this.f9740c = 16;
        this.f9741f = method;
        this.f9742g = method2;
        this.f9743h = method3;
    }

    public m(Context context, TypedArray typedArray) {
        this.f9740c = 14;
        this.f9741f = context;
        this.f9742g = typedArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(xb.l lVar, xb.l lVar2, s0.c cVar) {
        this.f9740c = 23;
        this.f9741f = lVar;
        this.f9742g = (yb.l) lVar2;
        this.f9743h = cVar;
    }

    public m(ArrayDeque arrayDeque, int[] iArr) {
        this.f9740c = 22;
        this.f9742g = arrayDeque;
        this.f9743h = iArr;
        this.f9741f = new ArrayList();
    }

    public m(View view) {
        this.f9740c = 2;
        view.getClass();
        this.f9741f = new WeakReference(view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.f9742g = gradientDrawable;
        this.f9743h = view.getBackground();
        view.setBackground(gradientDrawable);
    }

    public m(g0 g0Var) {
        this.f9740c = 20;
        this.f9741f = g0Var;
        this.f9742g = new ArrayList();
        this.f9743h = g0Var;
    }

    public /* synthetic */ m(int i3) {
        this.f9740c = i3;
    }
}
