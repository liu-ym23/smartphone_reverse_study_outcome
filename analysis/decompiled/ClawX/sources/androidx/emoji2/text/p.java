package androidx.emoji2.text;

import android.content.res.TypedArray;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import d8.i2;
import d8.l2;
import d8.q4;
import d8.w2;
import d8.x0;
import g.e0;
import g.g0;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;
import p7.d0;
import v0.c0;
import v0.n0;
import v0.t0;
import v0.u0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class p implements q, e0, e0.k, p7.w, y5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f622a;

    /* renamed from: b, reason: collision with root package name */
    public Object f623b;

    /* renamed from: c, reason: collision with root package name */
    public Object f624c;

    public /* synthetic */ p(int i8, Object obj) {
        this.f622a = i8;
        this.f624c = obj;
    }

    @Override // g.e0
    public void a(int i8) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i8);
    }

    @Override // androidx.emoji2.text.q
    public boolean b(CharSequence charSequence, int i8, int i9, z zVar) {
        if ((zVar.f652c & 4) > 0) {
            return true;
        }
        if (((b0) this.f623b) == null) {
            this.f623b = new b0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((t1.f) this.f624c).getClass();
        ((b0) this.f623b).setSpan(new a0(zVar), i8, i9, 33);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    @Override // e0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e0.x0 c(android.view.View r19, e0.x0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.Object r3 = r0.f623b
            c0.f r3 = (c0.f) r3
            java.lang.Object r0 = r0.f624c
            p1.m r0 = (p1.m) r0
            int r4 = r0.f4724a
            int r5 = r0.f4725b
            int r0 = r0.f4726c
            e0.t0 r6 = r2.f2338a
            r7 = 519(0x207, float:7.27E-43)
            x.b r7 = r6.h(r7)
            r8 = 32
            x.b r8 = r6.h(r8)
            java.lang.Object r9 = r3.f1047b
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            int r10 = r7.f6233b
            int r11 = r7.f6234c
            int r12 = r7.f6232a
            r9.f1259w = r10
            int r10 = r1.getLayoutDirection()
            r14 = 1
            if (r10 != r14) goto L37
            r10 = r14
            goto L38
        L37:
            r10 = 0
        L38:
            int r15 = r1.getPaddingBottom()
            int r16 = r1.getPaddingLeft()
            int r17 = r1.getPaddingRight()
            boolean r13 = r9.f1251o
            if (r13 == 0) goto L52
            x.b r6 = r6.j()
            int r6 = r6.d
            r9.f1258v = r6
            int r15 = r0 + r6
        L52:
            boolean r0 = r9.f1252p
            if (r0 == 0) goto L5d
            if (r10 == 0) goto L5a
            r0 = r5
            goto L5b
        L5a:
            r0 = r4
        L5b:
            int r16 = r0 + r12
        L5d:
            r0 = r16
            boolean r6 = r9.f1253q
            if (r6 == 0) goto L69
            if (r10 == 0) goto L66
            goto L67
        L66:
            r4 = r5
        L67:
            int r17 = r4 + r11
        L69:
            r4 = r17
            android.view.ViewGroup$LayoutParams r5 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            boolean r6 = r9.f1255s
            if (r6 == 0) goto L7d
            int r6 = r5.leftMargin
            if (r6 == r12) goto L7d
            r5.leftMargin = r12
            r6 = r14
            goto L7e
        L7d:
            r6 = 0
        L7e:
            boolean r10 = r9.f1256t
            if (r10 == 0) goto L89
            int r10 = r5.rightMargin
            if (r10 == r11) goto L89
            r5.rightMargin = r11
            r6 = r14
        L89:
            boolean r10 = r9.f1257u
            if (r10 == 0) goto L96
            int r10 = r5.topMargin
            int r7 = r7.f6233b
            if (r10 == r7) goto L96
            r5.topMargin = r7
            goto L97
        L96:
            r14 = r6
        L97:
            if (r14 == 0) goto L9c
            r1.setLayoutParams(r5)
        L9c:
            int r5 = r1.getPaddingTop()
            r1.setPadding(r0, r5, r4, r15)
            boolean r0 = r3.f1046a
            if (r0 == 0) goto Lab
            int r1 = r8.d
            r9.f1249m = r1
        Lab:
            if (r13 != 0) goto Lb1
            if (r0 == 0) goto Lb0
            goto Lb1
        Lb0:
            return r2
        Lb1:
            r9.I()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.c(android.view.View, e0.x0):e0.x0");
    }

    @Override // g.e0
    public void d(int i8) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i8);
    }

    @Override // p7.w
    public p7.x e(p7.x xVar) {
        d0 d0Var;
        p7.r[] rVarArr;
        p7.r[] rVarArr2;
        switch (this.f622a) {
            case 15:
                p7.h hVar = (p7.h) this.f623b;
                p7.t tVar = xVar instanceof p7.t ? (p7.t) xVar : null;
                int iD = d0.d(hVar);
                int i8 = iD > 250 ? 6 : 5;
                int i9 = 1 << i8;
                if (tVar != null && (d0Var = tVar.f4823b) != null && d0Var.f() >= i9) {
                    return tVar;
                }
                int i10 = ((iD + i8) - 1) / i8;
                int i11 = i8 + 1;
                p7.r[] rVarArr3 = new p7.r[i11];
                rVarArr3[0] = (p7.r) this.f624c;
                for (int i12 = 1; i12 < i8; i12++) {
                    rVarArr3[i12] = rVarArr3[i12 - 1].w(i10);
                }
                rVarArr3[i8] = rVarArr3[0].u(rVarArr3[1]);
                hVar.p(rVarArr3, 0, i11, null);
                p7.r[] rVarArr4 = new p7.r[i9];
                rVarArr4[0] = rVarArr3[0];
                for (int i13 = i8 - 1; i13 >= 0; i13--) {
                    p7.r rVar = rVarArr3[i13];
                    int i14 = 1 << i13;
                    for (int i15 = i14; i15 < i9; i15 += i14 << 1) {
                        rVarArr4[i15] = rVarArr4[i15 - i14].a(rVar);
                    }
                }
                hVar.p(rVarArr4, 0, i9, null);
                p7.t tVar2 = new p7.t();
                tVar2.f4822a = null;
                tVar2.f4823b = null;
                tVar2.f4824c = -1;
                tVar2.f4823b = hVar.b(rVarArr4, i9);
                tVar2.f4822a = rVarArr3[i8];
                tVar2.f4824c = i8;
                return tVar2;
            case 16:
                p7.b0 b0Var = xVar instanceof p7.b0 ? (p7.b0) xVar : null;
                p7.b0 b0Var2 = (p7.b0) this.f623b;
                int i16 = b0Var2.f4773f;
                int length = b0Var2.f4771c.length;
                if (b0Var == null || b0Var.f4773f < i16 || (rVarArr = b0Var.f4771c) == null || rVarArr.length < length || (rVarArr2 = b0Var.d) == null || rVarArr2.length < length) {
                    b0Var = new p7.b0();
                    b0Var.f4769a = b0Var2.f4769a;
                    p7.r rVar2 = ((p7.b0) this.f623b).f4772e;
                    if (rVar2 != null) {
                        b0Var.f4772e = rVar2.s((p7.m) ((m) this.f624c).f621a);
                    }
                    p7.r[] rVarArr5 = ((p7.b0) this.f623b).f4771c;
                    int length2 = rVarArr5.length;
                    p7.r[] rVarArr6 = new p7.r[length2];
                    for (int i17 = 0; i17 < rVarArr5.length; i17++) {
                        rVarArr6[i17] = rVarArr5[i17].s((p7.m) ((m) this.f624c).f621a);
                    }
                    b0Var.f4771c = rVarArr6;
                    b0Var.f4773f = i16;
                    p7.r[] rVarArr7 = new p7.r[length2];
                    for (int i18 = 0; i18 < length2; i18++) {
                        rVarArr7[i18] = rVarArr6[i18].n();
                    }
                    b0Var.d = rVarArr7;
                } else {
                    int i19 = b0Var.f4769a;
                    if (i19 > 0) {
                        b0Var.f4769a = i19 - 1;
                    }
                }
                return b0Var;
            default:
                t7.b bVar = (t7.b) this.f623b;
                t7.a aVar = xVar instanceof t7.a ? (t7.a) xVar : null;
                if (aVar != null && aVar.f5600a == bVar && aVar.f5601b != null) {
                    return aVar;
                }
                p7.r rVarS = ((p7.r) this.f624c).s((p7.m) bVar.f5603b.f621a);
                t7.a aVar2 = new t7.a();
                aVar2.f5600a = bVar;
                aVar2.f5601b = rVarS;
                return aVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(h4.c r5, h5.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof h4.g
            if (r0 == 0) goto L13
            r0 = r6
            h4.g r0 = (h4.g) r0
            int r1 = r0.f3029c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3029c = r1
            goto L18
        L13:
            h4.g r0 = new h4.g
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f3027a
            g5.a r6 = g5.a.f2984a
            int r1 = r0.f3029c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            a.a.c0(r4)
            goto L59
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.a.c0(r4)
            f5.h r4 = r5.b()
            a6.c0 r1 = a6.c0.f143b
            f5.f r4 = r4.o(r1)
            kotlin.jvm.internal.p.b(r4)
            a6.t r4 = (a6.t) r4
            r1 = r4
            a6.j1 r1 = (a6.j1) r1
            r1.f0()
            io.ktor.utils.io.p r5 = r5.d()     // Catch: java.lang.Throwable -> L4e
            io.ktor.utils.io.h0.b(r5)     // Catch: java.lang.Throwable -> L4e
        L4e:
            r0.f3029c = r2
            a6.p1 r4 = (a6.p1) r4
            java.lang.Object r4 = r4.j(r0)
            if (r4 != r6) goto L59
            return r6
        L59:
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.g(h4.c, h5.c):java.lang.Object");
    }

    @Override // androidx.emoji2.text.q
    public Object getResult() {
        return (b0) this.f623b;
    }

    public void h() {
        int[] iArr = (int[]) this.f623b;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f624c = null;
    }

    public void i(int i8) {
        int[] iArr = (int[]) this.f623b;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i8, 10) + 1];
            this.f623b = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i8 >= iArr.length) {
            int length = iArr.length;
            while (length <= i8) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f623b = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f623b;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(h5.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof h4.h
            if (r0 == 0) goto L13
            r0 = r7
            h4.h r0 = (h4.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            h4.h r0 = new h4.h
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f3031b
            g5.a r1 = g5.a.f2984a
            int r2 = r0.d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            a6.f0 r6 = r0.f3030a
            h4.c r6 = (h4.c) r6
            a.a.c0(r7)     // Catch: java.util.concurrent.CancellationException -> L85
            return r6
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            a6.f0 r2 = r0.f3030a
            u3.c r2 = (u3.c) r2
            a.a.c0(r7)     // Catch: java.util.concurrent.CancellationException -> L85
            goto L6f
        L41:
            a.a.c0(r7)     // Catch: java.util.concurrent.CancellationException -> L85
            goto L61
        L45:
            a.a.c0(r7)
            f4.c r7 = new f4.c     // Catch: java.util.concurrent.CancellationException -> L85
            r7.<init>()     // Catch: java.util.concurrent.CancellationException -> L85
            java.lang.Object r2 = r6.f623b     // Catch: java.util.concurrent.CancellationException -> L85
            f4.c r2 = (f4.c) r2     // Catch: java.util.concurrent.CancellationException -> L85
            r7.d(r2)     // Catch: java.util.concurrent.CancellationException -> L85
            java.lang.Object r2 = r6.f624c     // Catch: java.util.concurrent.CancellationException -> L85
            t3.c r2 = (t3.c) r2     // Catch: java.util.concurrent.CancellationException -> L85
            r0.d = r5     // Catch: java.util.concurrent.CancellationException -> L85
            java.lang.Object r7 = r2.a(r7, r0)     // Catch: java.util.concurrent.CancellationException -> L85
            if (r7 != r1) goto L61
            goto L83
        L61:
            r2 = r7
            u3.c r2 = (u3.c) r2     // Catch: java.util.concurrent.CancellationException -> L85
            r0.f3030a = r2     // Catch: java.util.concurrent.CancellationException -> L85
            r0.d = r4     // Catch: java.util.concurrent.CancellationException -> L85
            java.lang.Object r7 = k4.z.F(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L85
            if (r7 != r1) goto L6f
            goto L83
        L6f:
            u3.c r7 = (u3.c) r7     // Catch: java.util.concurrent.CancellationException -> L85
            h4.c r7 = r7.e()     // Catch: java.util.concurrent.CancellationException -> L85
            h4.c r2 = r2.e()     // Catch: java.util.concurrent.CancellationException -> L85
            r0.f3030a = r7     // Catch: java.util.concurrent.CancellationException -> L85
            r0.d = r3     // Catch: java.util.concurrent.CancellationException -> L85
            java.lang.Object r6 = r6.g(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L85
            if (r6 != r1) goto L84
        L83:
            return r1
        L84:
            return r7
        L85:
            r6 = move-exception
            java.lang.Throwable r6 = i4.a.a(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.j(h5.c):java.lang.Object");
    }

    public View k(int i8, int i9, int i10, int i11) {
        int iX;
        int i12;
        int iY;
        View viewP;
        int left;
        int i13;
        int right;
        int i14;
        t0 t0Var = (t0) this.f624c;
        v0.a0 a0Var = (v0.a0) this.f623b;
        switch (a0Var.f5787a) {
            case 0:
                iX = a0Var.f5788b.x();
                break;
            default:
                iX = a0Var.f5788b.z();
                break;
        }
        switch (a0Var.f5787a) {
            case 0:
                v0.b0 b0Var = a0Var.f5788b;
                i12 = b0Var.f5799i;
                iY = b0Var.y();
                break;
            default:
                v0.b0 b0Var2 = a0Var.f5788b;
                i12 = b0Var2.f5800j;
                iY = b0Var2.w();
                break;
        }
        int i15 = i12 - iY;
        int i16 = i9 > i8 ? 1 : -1;
        View view = null;
        while (i8 != i9) {
            switch (a0Var.f5787a) {
                case 0:
                    viewP = a0Var.f5788b.p(i8);
                    break;
                default:
                    viewP = a0Var.f5788b.p(i8);
                    break;
            }
            switch (a0Var.f5787a) {
                case 0:
                    c0 c0Var = (c0) viewP.getLayoutParams();
                    left = viewP.getLeft() - ((c0) viewP.getLayoutParams()).f5804a.left;
                    i13 = ((ViewGroup.MarginLayoutParams) c0Var).leftMargin;
                    break;
                default:
                    c0 c0Var2 = (c0) viewP.getLayoutParams();
                    left = viewP.getTop() - ((c0) viewP.getLayoutParams()).f5804a.top;
                    i13 = ((ViewGroup.MarginLayoutParams) c0Var2).topMargin;
                    break;
            }
            int i17 = left - i13;
            switch (a0Var.f5787a) {
                case 0:
                    c0 c0Var3 = (c0) viewP.getLayoutParams();
                    right = viewP.getRight() + ((c0) viewP.getLayoutParams()).f5804a.right;
                    i14 = ((ViewGroup.MarginLayoutParams) c0Var3).rightMargin;
                    break;
                default:
                    c0 c0Var4 = (c0) viewP.getLayoutParams();
                    right = viewP.getBottom() + ((c0) viewP.getLayoutParams()).f5804a.bottom;
                    i14 = ((ViewGroup.MarginLayoutParams) c0Var4).bottomMargin;
                    break;
            }
            int i18 = right + i14;
            t0Var.f5937b = iX;
            t0Var.f5938c = i15;
            t0Var.d = i17;
            t0Var.f5939e = i18;
            if (i10 != 0) {
                t0Var.f5936a = i10;
                if (t0Var.a()) {
                    return viewP;
                }
            }
            if (i11 != 0) {
                t0Var.f5936a = i11;
                if (t0Var.a()) {
                    view = viewP;
                }
            }
            i8 += i16;
        }
        return view;
    }

    public KeyListener l(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((p) ((m) this.f624c).f621a).getClass();
        if (keyListener instanceof p0.f) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new p0.f(keyListener);
    }

    public void m(w2 w2Var) {
        ArrayList arrayList = (ArrayList) this.f624c;
        if (arrayList == null) {
            ((ArrayList) this.f623b).add(w2Var);
            return;
        }
        q4 q4Var = (q4) arrayList.get(arrayList.size() - 1);
        if (q4Var.f2125a.isEmpty()) {
            q4Var.f2126b.add(w2Var);
        } else {
            q4Var.f2125a.add(w2Var);
        }
    }

    public void n(AttributeSet attributeSet, int i8) {
        TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f623b).getContext().obtainStyledAttributes(attributeSet, c.a.f1019g, i8, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            w(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public p0.c o(InputConnection inputConnection, EditorInfo editorInfo) {
        m mVar = (m) this.f624c;
        if (inputConnection == null) {
            mVar.getClass();
            inputConnection = null;
        } else {
            p pVar = (p) mVar.f621a;
            pVar.getClass();
            if (!(inputConnection instanceof p0.c)) {
                inputConnection = new p0.c((EditText) pVar.f623b, inputConnection, editorInfo);
            }
        }
        return (p0.c) inputConnection;
    }

    public void p(n6.d dVar, IOException iOException) {
        b7.h.c((b7.h) this.f623b, iOException, null, 6);
    }

    public void q(n6.d dVar, n6.u uVar) throws IOException {
        c7.v vVarD;
        c7.t tVarC;
        int iIntValue;
        try {
            c7.u uVarA = ((b7.h) this.f623b).a(uVar);
            n6.k kVar = uVar.f4150f;
            int size = kVar.size();
            int i8 = 0;
            int i9 = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z8 = false;
            boolean z9 = false;
            Integer numD1 = null;
            Integer numD12 = null;
            while (i9 < size) {
                if (kVar.g(i9).equalsIgnoreCase("Sec-WebSocket-Extensions")) {
                    String strI = kVar.i(i9);
                    int i10 = i8;
                    while (i10 < strI.length()) {
                        n6.k kVar2 = kVar;
                        int iD = o6.d.d(strI, AbstractJsonLexerKt.COMMA, i10, i8, 4);
                        int iC = o6.d.c(strI, ';', i10, iD);
                        String strN = o6.d.n(i10, iC, strI);
                        int i11 = iC + 1;
                        if (strN.equalsIgnoreCase("permessage-deflate")) {
                            if (z) {
                                z9 = true;
                            }
                            while (true) {
                                i10 = i11;
                                while (i10 < iD) {
                                    int iC2 = o6.d.c(strI, ';', i10, iD);
                                    int iC3 = o6.d.c(strI, '=', i10, iC2);
                                    String strN2 = o6.d.n(i10, iC3, strI);
                                    String strD1 = iC3 < iC2 ? x5.n.D1(o6.d.n(iC3 + 1, iC2, strI), "\"") : null;
                                    i11 = iC2 + 1;
                                    if (strN2.equalsIgnoreCase("client_max_window_bits")) {
                                        if (numD1 != null) {
                                            z9 = true;
                                        }
                                        numD1 = strD1 != null ? x5.u.d1(strD1) : null;
                                        if (numD1 != null) {
                                            break;
                                        }
                                        i10 = i11;
                                        z9 = true;
                                    } else if (strN2.equalsIgnoreCase("client_no_context_takeover")) {
                                        if (z2) {
                                            z9 = true;
                                        }
                                        if (strD1 != null) {
                                            z9 = true;
                                        }
                                        i10 = i11;
                                        z2 = true;
                                    } else {
                                        if (strN2.equalsIgnoreCase("server_max_window_bits")) {
                                            if (numD12 != null) {
                                                z9 = true;
                                            }
                                            numD12 = strD1 != null ? x5.u.d1(strD1) : null;
                                            if (numD12 != null) {
                                                break;
                                            }
                                        } else if (strN2.equalsIgnoreCase("server_no_context_takeover")) {
                                            if (z8) {
                                                z9 = true;
                                            }
                                            if (strD1 != null) {
                                                z9 = true;
                                            }
                                            i10 = i11;
                                            z8 = true;
                                        }
                                        i10 = i11;
                                        z9 = true;
                                    }
                                }
                            }
                            kVar = kVar2;
                            z = true;
                        } else {
                            i10 = i11;
                            kVar = kVar2;
                            z9 = true;
                        }
                        i8 = 0;
                    }
                }
                i9++;
                kVar = kVar;
                i8 = 0;
            }
            ((b7.h) this.f623b).d = new b7.i(z, numD1, z2, numD12, z8, z9);
            if (z9 || numD1 != null || (numD12 != null && (8 > (iIntValue = numD12.intValue()) || iIntValue >= 16))) {
                b7.h hVar = (b7.h) this.f623b;
                synchronized (hVar) {
                    hVar.f962p.clear();
                    hVar.b(1010, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            String name = o6.f.f4331b + " WebSocket " + ((n6.s) this.f624c).f4128a.f();
            b7.h hVar2 = (b7.h) this.f623b;
            a4.d dVar2 = new a4.d(uVarA);
            kotlin.jvm.internal.p.e(name, "name");
            b7.i iVar = hVar2.d;
            kotlin.jvm.internal.p.b(iVar);
            synchronized (hVar2) {
                try {
                    hVar2.f959m = name;
                    hVar2.f960n = dVar2;
                    hVar2.f957k = new b7.l((c7.o) dVar2.d, hVar2.f949b, iVar.f970a, iVar.f972c, hVar2.f951e);
                    hVar2.f955i = new b7.g(hVar2);
                    long j4 = hVar2.f950c;
                    if (j4 != 0) {
                        long nanos = TimeUnit.MILLISECONDS.toNanos(j4);
                        q6.c cVar = hVar2.f958l;
                        String name2 = name.concat(" ping");
                        b7.d dVar3 = new b7.d(0, nanos, hVar2);
                        cVar.getClass();
                        kotlin.jvm.internal.p.e(name2, "name");
                        cVar.c(new q6.b(name2, dVar3), nanos);
                    }
                    if (!hVar2.f962p.isEmpty()) {
                        hVar2.e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hVar2.f956j = new b7.k((c7.p) dVar2.f97c, hVar2, iVar.f970a, iVar.f973e);
            b7.h hVar3 = (b7.h) this.f623b;
            try {
                hVar3.f948a.onOpen(hVar3, uVar);
                while (hVar3.f965s == -1) {
                    b7.k kVar3 = hVar3.f956j;
                    kotlin.jvm.internal.p.b(kVar3);
                    kVar3.a();
                }
            } catch (Exception e9) {
                b7.h.c(hVar3, e9, null, 6);
            } finally {
                hVar3.d();
            }
        } catch (IOException e10) {
            b7.h.c((b7.h) this.f623b, e10, uVar, 4);
            o6.d.a(uVar);
            c7.u uVar2 = uVar.f4152h;
            if (uVar2 != null && (tVarC = uVar2.c()) != null) {
                o6.d.a(tVarC);
            }
            c7.u uVar3 = uVar.f4152h;
            if (uVar3 == null || (vVarD = uVar3.d()) == null) {
                return;
            }
            o6.d.a(vVarD);
        }
    }

    public void r(b0.h hVar) {
        b0.n nVar = (b0.n) this.f624c;
        r6.x xVar = (r6.x) this.f623b;
        int i8 = hVar.f828b;
        if (i8 != 0) {
            nVar.execute(new h(xVar, i8));
        } else {
            nVar.execute(new b0.a(xVar, 0, hVar.f827a));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0205, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[Catch: IOException -> 0x008d, XmlPullParserException -> 0x0090, TryCatch #2 {IOException -> 0x008d, XmlPullParserException -> 0x0090, blocks: (B:19:0x005e, B:96:0x0205, B:27:0x0070, B:28:0x007e, B:30:0x0083, B:37:0x0093, B:45:0x00ad, B:40:0x009c, B:43:0x00a5, B:46:0x00bb, B:50:0x00ca, B:52:0x00d2, B:53:0x00dc, B:62:0x0105, B:63:0x010c, B:64:0x0124, B:56:0x00e5, B:58:0x00ed, B:59:0x00fb, B:65:0x0125, B:67:0x012d, B:68:0x013b, B:71:0x0145, B:72:0x0150, B:73:0x0168, B:74:0x0169, B:77:0x0173, B:78:0x017e, B:79:0x0196, B:80:0x0197, B:82:0x019f, B:83:0x01a8, B:86:0x01b2, B:87:0x01bc, B:88:0x01d4, B:89:0x01d5, B:92:0x01df, B:93:0x01e9, B:94:0x0201, B:95:0x0202), top: B:104:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(android.content.Context r10, android.content.res.XmlResourceParser r11) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.p.s(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void t(f2.m mVar) throws GeneralSecurityException {
        HashMap map = (HashMap) this.f623b;
        f2.n nVar = new f2.n(mVar.f2567a, g2.f.class);
        if (!map.containsKey(nVar)) {
            map.put(nVar, mVar);
            return;
        }
        f2.m mVar2 = (f2.m) map.get(nVar);
        if (mVar2.equals(mVar) && mVar.equals(mVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + nVar);
    }

    @Override // y5.i
    public y5.f toInstant() {
        throw new x0(((String) this.f623b) + " when parsing an Instant from \"" + y5.g.k(64, (String) this.f624c) + AbstractJsonLexerKt.STRING);
    }

    public String toString() {
        switch (this.f622a) {
            case 8:
                return "HttpStatement[" + ((f4.c) this.f623b).f2591a + AbstractJsonLexerKt.END_LIST;
            case 9:
                String str = "[ ";
                if (((m.g) this.f623b) != null) {
                    for (int i8 = 0; i8 < 9; i8++) {
                        str = str + ((m.g) this.f623b).f3883h[i8] + " ";
                    }
                }
                return str + "] " + ((m.g) this.f623b);
            default:
                return super.toString();
        }
    }

    public void u(y1.m mVar) throws GeneralSecurityException {
        HashMap map = (HashMap) this.f624c;
        if (mVar == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class clsC = mVar.c();
        if (!map.containsKey(clsC)) {
            map.put(clsC, mVar);
            return;
        }
        y1.m mVar2 = (y1.m) map.get(clsC);
        if (mVar2.equals(mVar) && mVar.equals(mVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + clsC);
    }

    public void v(n0 n0Var) {
        u0 u0Var = (u0) ((j.j) this.f623b).get(n0Var);
        if (u0Var == null) {
            return;
        }
        u0Var.f5942a &= -2;
    }

    public void w(boolean z) {
        p0.j jVar = (p0.j) ((p) ((m) this.f624c).f621a).f624c;
        if (jVar.f4660c != z) {
            if (jVar.f4659b != null) {
                j jVarA = j.a();
                p0.i iVar = jVar.f4659b;
                jVarA.getClass();
                a.a.j(iVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = jVarA.f609a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    jVarA.f610b.remove(iVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            jVar.f4660c = z;
            if (z) {
                p0.j.a(jVar.f4658a, j.a().b());
            }
        }
    }

    public /* synthetic */ p(int i8, boolean z) {
        this.f622a = i8;
    }

    public /* synthetic */ p(Object obj, int i8, Object obj2) {
        this.f622a = i8;
        this.f623b = obj;
        this.f624c = obj2;
    }

    public p(int i8) {
        this.f622a = i8;
        switch (i8) {
            case 5:
                this.f623b = new HashMap();
                this.f624c = new HashMap();
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                this.f623b = Choreographer.getInstance();
                this.f624c = Looper.myLooper();
                break;
            case BERTags.IA5_STRING /* 22 */:
                this.f623b = new j.j(0);
                this.f624c = new j.g();
                break;
            default:
                this.f623b = new i2();
                this.f624c = new l2();
                break;
        }
    }

    public p(w0.f fVar) {
        this.f622a = 23;
        this.f623b = fVar;
        this.f624c = new w0.e();
    }

    public p(f4.c cVar, t3.c client) {
        this.f622a = 8;
        kotlin.jvm.internal.p.e(client, "client");
        this.f623b = cVar;
        this.f624c = client;
    }

    public p(f2.o oVar) {
        this.f622a = 5;
        this.f623b = new HashMap(oVar.f2571a);
        this.f624c = new HashMap(oVar.f2572b);
    }

    public p(EditText editText, int i8) {
        this.f622a = i8;
        switch (i8) {
            case 12:
                this.f623b = editText;
                p0.j jVar = new p0.j(editText);
                this.f624c = jVar;
                editText.addTextChangedListener(jVar);
                if (p0.a.f4643b == null) {
                    synchronized (p0.a.f4642a) {
                        try {
                            if (p0.a.f4643b == null) {
                                p0.a aVar = new p0.a();
                                try {
                                    p0.a.f4644c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, p0.a.class.getClassLoader());
                                } catch (Throwable unused) {
                                }
                                p0.a.f4643b = aVar;
                            }
                        } finally {
                        }
                    }
                }
                editText.setEditableFactory(p0.a.f4643b);
                return;
            default:
                this.f623b = editText;
                m mVar = new m();
                mVar.f621a = new p(editText, 12);
                this.f624c = mVar;
                return;
        }
    }

    public p(v0.a0 a0Var) {
        this.f622a = 21;
        this.f623b = a0Var;
        t0 t0Var = new t0();
        t0Var.f5936a = 0;
        this.f624c = t0Var;
    }

    public p(String error, String str) {
        this.f622a = 24;
        kotlin.jvm.internal.p.e(error, "error");
        this.f623b = error;
        this.f624c = str;
    }

    public p(g0 g0Var) {
        this.f622a = 7;
        this.f624c = g0Var;
        this.f622a = 7;
        this.f623b = g0Var;
    }

    @Override // g.e0
    public void f(int i8, float f3) {
    }
}
