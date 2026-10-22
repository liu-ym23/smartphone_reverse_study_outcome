package a4;

import a6.w;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.a0;
import androidx.emoji2.text.q;
import androidx.emoji2.text.r;
import androidx.emoji2.text.s;
import androidx.emoji2.text.z;
import androidx.recyclerview.widget.RecyclerView;
import c7.t;
import c7.u;
import c7.v;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.o;
import f2.p;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import k2.e1;
import k2.f1;
import k2.n0;
import k2.q1;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.f0;
import org.bouncycastle.asn1.BERTags;
import z3.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements y, j2.a, u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f95a;

    /* renamed from: b, reason: collision with root package name */
    public Object f96b;

    /* renamed from: c, reason: collision with root package name */
    public Object f97c;
    public Object d;

    public /* synthetic */ d(int i8) {
        this.f95a = i8;
    }

    public static d E(Context context, AttributeSet attributeSet, int[] iArr, int i8) {
        return new d(context, context.obtainStyledAttributes(attributeSet, iArr, i8, 0));
    }

    public static final d G(y1.f fVar, e2.b bVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) fVar.f6318b;
        try {
            n0 n0VarA = n0.A(byteArrayInputStream, o.a());
            byteArrayInputStream.close();
            if (n0VarA.y().size() == 0) {
                throw new GeneralSecurityException("empty keyset");
            }
            try {
                f1 f1VarE = f1.E(bVar.b(n0VarA.y().j(), bArr), o.a());
                if (f1VarE.z() > 0) {
                    return p(f1VarE);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (c0 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    public static boolean m(Editable editable, KeyEvent keyEvent, boolean z) {
        a0[] a0VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (a0VarArr = (a0[]) editable.getSpans(selectionStart, selectionEnd, a0.class)) != null && a0VarArr.length > 0) {
                for (a0 a0Var : a0VarArr) {
                    int spanStart = editable.getSpanStart(a0Var);
                    int spanEnd = editable.getSpanEnd(a0Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final d p(f1 f1Var) throws GeneralSecurityException {
        if (f1Var.z() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        ArrayList arrayList = new ArrayList(f1Var.z());
        for (e1 e1Var : f1Var.A()) {
            e1Var.getClass();
            try {
                try {
                    y1.b bVarA = f2.j.f2563b.a(p.b(e1Var.A().B(), e1Var.A().C(), e1Var.A().A(), e1Var.C(), e1Var.C() == q1.RAW ? null : Integer.valueOf(e1Var.B())));
                    int iOrdinal = e1Var.D().ordinal();
                    if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    arrayList.add(new y1.h(bVarA));
                } catch (GeneralSecurityException unused) {
                    arrayList.add(null);
                }
            } catch (GeneralSecurityException e9) {
                throw new w("Creating a protokey serialization failed", e9);
            }
        }
        return new d(f1Var, Collections.unmodifiableList(arrayList));
    }

    public boolean A(CharSequence charSequence, int i8, int i9, z zVar) {
        if ((zVar.f652c & 3) == 0) {
            androidx.emoji2.text.f fVar = (androidx.emoji2.text.f) this.d;
            o0.a aVarB = zVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarB.d).getShort(iA + aVarB.f1830a);
            }
            androidx.emoji2.text.c cVar = (androidx.emoji2.text.c) fVar;
            cVar.getClass();
            ThreadLocal threadLocal = androidx.emoji2.text.c.f598b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i8 < i9) {
                sb.append(charSequence.charAt(i8));
                i8++;
            }
            boolean zHasGlyph = cVar.f599a.hasGlyph(sb.toString());
            int i10 = zVar.f652c & 4;
            zVar.f652c = zHasGlyph ? i10 | 2 : i10 | 1;
        }
        return (zVar.f652c & 3) == 2;
    }

    public boolean B() {
        return ((ArrayList) this.f97c).size() > 0;
    }

    public void C(View view) {
        ((ArrayList) this.d).add(view);
        RecyclerView.s(view);
    }

    public boolean D(int i8, o.d dVar, r.f fVar) {
        p.b bVar = (p.b) this.f97c;
        int[] iArr = dVar.f4239o0;
        int[] iArr2 = dVar.f4243s;
        bVar.f4592a = iArr[0];
        bVar.f4593b = iArr[1];
        bVar.f4594c = dVar.n();
        bVar.d = dVar.k();
        bVar.f4599i = false;
        bVar.f4600j = i8;
        boolean z = bVar.f4592a == 3;
        boolean z2 = bVar.f4593b == 3;
        boolean z8 = z && dVar.V > 0.0f;
        boolean z9 = z2 && dVar.V > 0.0f;
        if (z8 && iArr2[0] == 4) {
            bVar.f4592a = 1;
        }
        if (z9 && iArr2[1] == 4) {
            bVar.f4593b = 1;
        }
        fVar.b(dVar, bVar);
        dVar.J(bVar.f4595e);
        dVar.G(bVar.f4596f);
        dVar.D = bVar.f4598h;
        dVar.D(bVar.f4597g);
        bVar.f4600j = 0;
        return bVar.f4599i;
    }

    public Object F(CharSequence charSequence, int i8, int i9, int i10, boolean z, q qVar) {
        int i11;
        char c3;
        s sVar = new s((androidx.emoji2.text.w) ((a1.w) this.f97c).d);
        int iCodePointAt = Character.codePointAt(charSequence, i8);
        int i12 = 0;
        boolean zB = true;
        int iCharCount = i8;
        loop0: while (true) {
            i11 = iCharCount;
            while (iCharCount < i9 && i12 < i10 && zB) {
                SparseArray sparseArray = sVar.f629c.f644a;
                androidx.emoji2.text.w wVar = sparseArray == null ? null : (androidx.emoji2.text.w) sparseArray.get(iCodePointAt);
                if (sVar.f627a == 2) {
                    if (wVar != null) {
                        sVar.f629c = wVar;
                        sVar.f631f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            sVar.a();
                        } else if (iCodePointAt != 65039) {
                            androidx.emoji2.text.w wVar2 = sVar.f629c;
                            if (wVar2.f645b != null) {
                                if (sVar.f631f != 1) {
                                    sVar.d = wVar2;
                                    sVar.a();
                                } else if (sVar.b()) {
                                    sVar.d = sVar.f629c;
                                    sVar.a();
                                } else {
                                    sVar.a();
                                }
                                c3 = 3;
                            } else {
                                sVar.a();
                            }
                        }
                        c3 = 1;
                    }
                    c3 = 2;
                } else if (wVar == null) {
                    sVar.a();
                    c3 = 1;
                } else {
                    sVar.f627a = 2;
                    sVar.f629c = wVar;
                    sVar.f631f = 1;
                    c3 = 2;
                }
                sVar.f630e = iCodePointAt;
                if (c3 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i11)) + i11;
                    if (iCharCount < i9) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c3 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i9) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c3 == 3) {
                    if (z || !A(charSequence, i11, iCharCount, sVar.d.f645b)) {
                        zB = qVar.b(charSequence, i11, iCharCount, sVar.d.f645b);
                        i12++;
                    }
                }
            }
            break loop0;
        }
        if (sVar.f627a == 2 && sVar.f629c.f645b != null && ((sVar.f631f > 1 || sVar.b()) && i12 < i10 && zB && (z || !A(charSequence, i11, iCharCount, sVar.f629c.f645b)))) {
            qVar.b(charSequence, i11, iCharCount, sVar.f629c.f645b);
        }
        return qVar.getResult();
    }

    public void H() {
        ((TypedArray) this.f97c).recycle();
    }

    public void I(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            v0.a aVar = (v0.a) arrayList.get(i8);
            aVar.getClass();
            ((d0.b) this.f96b).c(aVar);
        }
        arrayList.clear();
    }

    public void J(int i8) throws InvalidAlgorithmParameterException {
        if (i8 != 16 && i8 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i8 * 8)));
        }
        this.f96b = Integer.valueOf(i8);
    }

    public void K(o.e eVar, int i8, int i9, int i10) {
        int i11 = eVar.f4213a0;
        int i12 = eVar.f4215b0;
        eVar.f4213a0 = 0;
        eVar.f4215b0 = 0;
        eVar.J(i9);
        eVar.G(i10);
        if (i11 < 0) {
            eVar.f4213a0 = 0;
        } else {
            eVar.f4213a0 = i11;
        }
        if (i12 < 0) {
            eVar.f4215b0 = 0;
        } else {
            eVar.f4215b0 = i12;
        }
        o.e eVar2 = (o.e) this.d;
        eVar2.f4252s0 = i8;
        eVar2.P();
    }

    public void L(View view) {
        if (((ArrayList) this.d).remove(view)) {
            RecyclerView.s(view);
        }
    }

    public void M(o.e eVar) {
        ArrayList arrayList = (ArrayList) this.f96b;
        arrayList.clear();
        int size = eVar.f4249p0.size();
        for (int i8 = 0; i8 < size; i8++) {
            o.d dVar = (o.d) eVar.f4249p0.get(i8);
            int[] iArr = dVar.f4239o0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(dVar);
            }
        }
        eVar.f4251r0.f4604b = true;
    }

    @Override // z3.y
    public Object a(p5.l lVar) {
        Object objInvoke = ((p5.a) this.f96b).invoke();
        lVar.invoke(objInvoke);
        return new e((r4.a) this.d, objInvoke, (p5.l) this.f97c);
    }

    @Override // z3.y
    public void b(Object obj, t3.c scope) {
        e plugin = (e) obj;
        kotlin.jvm.internal.p.e(plugin, "plugin");
        kotlin.jvm.internal.p.e(scope, "scope");
        c cVar = new c(plugin.f98a, scope, plugin.f99b);
        plugin.f100c.invoke(cVar);
        plugin.d = cVar.d;
        ArrayList arrayList = cVar.f94c;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            f fVar = (f) obj2;
            fVar.getClass();
            fVar.f101a.c(scope, fVar.f102b);
        }
    }

    @Override // c7.u
    public t c() {
        switch (this.f95a) {
            case 10:
                return (c7.o) this.d;
            default:
                return (r6.e) this.f96b;
        }
    }

    @Override // c7.u
    public void cancel() {
        switch (this.f95a) {
            case 10:
                ((u) this.f96b).cancel();
                break;
            default:
                ((r6.g) this.d).f5143c.cancel();
                break;
        }
    }

    @Override // c7.u
    public v d() {
        switch (this.f95a) {
            case 10:
                return (c7.p) this.f97c;
            default:
                return (r6.f) this.f97c;
        }
    }

    @Override // j2.a
    public byte[] e(byte[] bArr, int i8) throws GeneralSecurityException {
        byte[] bArrV0;
        if (i8 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        if (!a8.b.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) l2.i.f3785b.f3787a.a("AES/ECB/NoPadding");
        cipher.init(1, (SecretKeySpec) this.f96b);
        int iMax = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        if (iMax * 16 == bArr.length) {
            bArrV0 = k4.v.u0((iMax - 1) * 16, bArr, 0, (byte[]) this.f97c, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length);
            if (bArrCopyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[bArrCopyOfRange.length] = -128;
            bArrV0 = k4.v.v0(bArrCopyOf, (byte[]) this.d);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i9 = 0; i9 < iMax - 1; i9++) {
            bArrDoFinal = cipher.doFinal(k4.v.u0(0, bArrDoFinal, i9 * 16, bArr, 16));
        }
        return Arrays.copyOf(cipher.doFinal(k4.v.v0(bArrV0, bArrDoFinal)), i8);
    }

    public void f(View view, int i8, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = ((v0.u) this.f96b).f5940a;
        int childCount = i8 < 0 ? recyclerView.getChildCount() : v(i8);
        ((t6.a) this.f97c).e(childCount, z);
        if (z) {
            C(view);
        }
        RecyclerView.s(view);
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public g2.a g() throws GeneralSecurityException {
        androidx.emoji2.text.m mVar;
        m2.a aVarA;
        g2.d dVar = (g2.d) this.f96b;
        if (dVar == null || (mVar = (androidx.emoji2.text.m) this.f97c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (dVar.f2930b != ((m2.a) mVar.f621a).f3894a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        g2.c cVar = dVar.d;
        g2.c cVar2 = g2.c.f2918f;
        if (cVar != cVar2 && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (cVar == cVar2 && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (cVar == cVar2) {
            aVarA = m2.a.a(new byte[0]);
        } else if (cVar == g2.c.f2917e || cVar == g2.c.d) {
            aVarA = m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (cVar != g2.c.f2916c) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + ((g2.d) this.f96b).d);
            }
            aVarA = m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new g2.a((g2.d) this.f96b, aVarA);
    }

    @Override // z3.y
    public r4.a getKey() {
        return (r4.a) this.d;
    }

    public g2.d h() throws GeneralSecurityException {
        Integer num = (Integer) this.f96b;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (((Integer) this.f97c) == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (((g2.c) this.d) != null) {
            return new g2.d(num.intValue(), ((Integer) this.f97c).intValue(), (g2.c) this.d);
        }
        throw new GeneralSecurityException("variant not set");
    }

    public g2.i i() throws GeneralSecurityException {
        androidx.emoji2.text.m mVar;
        m2.a aVarA;
        g2.j jVar = (g2.j) this.f96b;
        if (jVar == null || (mVar = (androidx.emoji2.text.m) this.f97c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (jVar.f2938b != ((m2.a) mVar.f621a).f3894a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        g2.c cVar = jVar.d;
        g2.c cVar2 = g2.c.f2927o;
        if (cVar != cVar2 && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (cVar == cVar2 && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (cVar == cVar2) {
            aVarA = m2.a.a(new byte[0]);
        } else if (cVar == g2.c.f2926n || cVar == g2.c.f2925m) {
            aVarA = m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (cVar != g2.c.f2924l) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: " + ((g2.j) this.f96b).d);
            }
            aVarA = m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new g2.i((g2.j) this.f96b, aVarA);
    }

    public z1.e j() throws GeneralSecurityException {
        androidx.emoji2.text.m mVar;
        z1.g gVar = (z1.g) this.f96b;
        if (gVar == null || (mVar = (androidx.emoji2.text.m) this.f97c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (gVar.f6384b != ((m2.a) mVar.f621a).f3894a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        z1.f fVar = gVar.f6386e;
        z1.f fVar2 = z1.f.f6369e;
        if (fVar != fVar2 && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            m2.a.a(new byte[0]);
        } else if (fVar == z1.f.d) {
            m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar != z1.f.f6368c) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + ((z1.g) this.f96b).f6386e);
            }
            m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new z1.e();
    }

    public z1.i k() throws GeneralSecurityException {
        androidx.emoji2.text.m mVar;
        z1.j jVar = (z1.j) this.f96b;
        if (jVar == null || (mVar = (androidx.emoji2.text.m) this.f97c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (jVar.f6390b != ((m2.a) mVar.f621a).f3894a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        z1.f fVar = jVar.f6392e;
        z1.f fVar2 = z1.f.f6372h;
        if (fVar != fVar2 && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            m2.a.a(new byte[0]);
        } else if (fVar == z1.f.f6371g) {
            m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar != z1.f.f6370f) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + ((z1.j) this.f96b).f6392e);
            }
            m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new z1.i();
    }

    public z1.l l() throws GeneralSecurityException {
        androidx.emoji2.text.m mVar;
        z1.m mVar2 = (z1.m) this.f96b;
        if (mVar2 == null || (mVar = (androidx.emoji2.text.m) this.f97c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (mVar2.f6396b != ((m2.a) mVar.f621a).f3894a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        z1.f fVar = mVar2.f6397c;
        z1.f fVar2 = z1.f.f6375k;
        if (fVar != fVar2 && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            m2.a.a(new byte[0]);
        } else if (fVar == z1.f.f6374j) {
            m2.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.d).intValue()).array());
        } else {
            if (fVar != z1.f.f6373i) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + ((z1.m) this.f96b).f6397c);
            }
            m2.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.d).intValue()).array());
        }
        return new z1.l();
    }

    public void n(int i8) {
        int iV = v(i8);
        ((t6.a) this.f97c).g(iV);
        RecyclerView recyclerView = ((v0.u) this.f96b).f5940a;
        View childAt = recyclerView.getChildAt(iV);
        if (childAt != null) {
            RecyclerView.s(childAt);
        }
        recyclerView.detachViewFromParent(iV);
    }

    public int o(int i8, int i9) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i9 < size) {
            ((v0.a) arrayList.get(i9)).getClass();
            i9++;
        }
        return i8;
    }

    public View q(int i8) {
        return ((v0.u) this.f96b).f5940a.getChildAt(v(i8));
    }

    public int r() {
        return ((v0.u) this.f96b).f5940a.getChildCount() - ((ArrayList) this.d).size();
    }

    public ColorStateList s(int i8) {
        int resourceId;
        ColorStateList colorStateListT;
        TypedArray typedArray = (TypedArray) this.f97c;
        return (!typedArray.hasValue(i8) || (resourceId = typedArray.getResourceId(i8, 0)) == 0 || (colorStateListT = k4.z.t((Context) this.f96b, resourceId)) == null) ? typedArray.getColorStateList(i8) : colorStateListT;
    }

    public Drawable t(int i8) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f97c;
        return (!typedArray.hasValue(i8) || (resourceId = typedArray.getResourceId(i8, 0)) == 0) ? typedArray.getDrawable(i8) : b8.h.p((Context) this.f96b, resourceId);
    }

    public String toString() {
        switch (this.f95a) {
            case BERTags.RELATIVE_OID /* 13 */:
                return ((t6.a) this.f97c).toString() + ", hidden list:" + ((ArrayList) this.d).size();
            case BERTags.TIME /* 14 */:
                return y1.o.a((f1) this.f96b).toString();
            default:
                return super.toString();
        }
    }

    public Typeface u(int i8, int i9, g.y yVar) {
        int resourceId = ((TypedArray) this.f97c).getResourceId(i8, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.d) == null) {
            this.d = new TypedValue();
        }
        Context context = (Context) this.f96b;
        TypedValue typedValue = (TypedValue) this.d;
        ThreadLocal threadLocal = w.j.f6061a;
        if (context.isRestricted()) {
            return null;
        }
        return w.j.a(context, resourceId, typedValue, i9, yVar, true, false);
    }

    public int v(int i8) {
        t6.a aVar = (t6.a) this.f97c;
        if (i8 < 0) {
            return -1;
        }
        int childCount = ((v0.u) this.f96b).f5940a.getChildCount();
        int i9 = i8;
        while (i9 < childCount) {
            int iB = i8 - (i9 - aVar.b(i9));
            if (iB == 0) {
                while (aVar.d(i9)) {
                    i9++;
                }
                return i9;
            }
            i9 += iB;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object w(java.lang.Class r17) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.d.w(java.lang.Class):java.lang.Object");
    }

    public List x(byte[] bArr) {
        List list = (List) ((ConcurrentMap) this.f96b).get(new y1.l(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public View y(int i8) {
        return ((v0.u) this.f96b).f5940a.getChildAt(i8);
    }

    public int z() {
        return ((v0.u) this.f96b).f5940a.getChildCount();
    }

    public d(u uVar) {
        this.f95a = 10;
        this.f96b = uVar;
        this.f97c = c7.b.b(uVar.d());
        t tVarC = uVar.c();
        kotlin.jvm.internal.p.e(tVarC, "<this>");
        this.d = new c7.o(tVarC);
    }

    public d(v0.u uVar) {
        this.f95a = 13;
        this.f96b = uVar;
        this.f97c = new t6.a();
        this.d = new ArrayList();
    }

    public d(byte[] bArr) throws GeneralSecurityException {
        this.f95a = 7;
        l2.o.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f96b = secretKeySpec;
        if (a8.b.a(1)) {
            Cipher cipher = (Cipher) l2.i.f3785b.f3787a.a("AES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            byte[] bArrQ = a.a.q(cipher.doFinal(new byte[16]));
            this.f97c = bArrQ;
            this.d = a.a.q(bArrQ);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public d(Method method, Method method2, Method method3) {
        this.f95a = 6;
        this.f96b = method;
        this.f97c = method2;
        this.d = method3;
    }

    public d(String str, p5.a createConfiguration, p5.l lVar) {
        f0 f0VarD;
        this.f95a = 0;
        kotlin.jvm.internal.p.e(createConfiguration, "createConfiguration");
        this.f96b = createConfiguration;
        this.f97c = lVar;
        kotlin.jvm.internal.h hVarA = kotlin.jvm.internal.z.a(e.class);
        try {
            v5.k kVar = v5.k.f5986c;
            kotlin.jvm.internal.h hVarA2 = kotlin.jvm.internal.z.a(d.class);
            v5.l lVar2 = v5.l.f5989a;
            kotlin.jvm.internal.z.f3687a.getClass();
            e0 e0Var = new e0(hVarA2);
            kotlin.jvm.internal.z.b(e0Var, kotlin.jvm.internal.z.c(Object.class));
            f0VarD = kotlin.jvm.internal.z.d(e.class, k4.z.w(kotlin.jvm.internal.a0.b(e0Var, Collections.EMPTY_LIST)));
        } catch (Throwable unused) {
            f0VarD = null;
        }
        this.d = new r4.a(str, new w4.a(hVarA, f0VarD));
    }

    public d(Context context, TypedArray typedArray) {
        this.f95a = 2;
        this.f96b = context;
        this.f97c = typedArray;
    }

    public d(o.e eVar) {
        this.f95a = 9;
        this.f96b = new ArrayList();
        this.f97c = new p.b();
        this.d = eVar;
    }

    public d(p0.b bVar) {
        this.f95a = 12;
        this.f96b = new d0.b(30);
        this.f97c = new ArrayList();
        this.d = new ArrayList();
        new p0.b(8, this);
    }

    public d(a1.w wVar, t1.f fVar, androidx.emoji2.text.c cVar, Set set) {
        this.f95a = 1;
        this.f96b = fVar;
        this.f97c = wVar;
        this.d = cVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            F(str, 0, str.length(), 1, true, new r(str, 0));
        }
    }

    public d(r6.g gVar) {
        this.f95a = 11;
        this.d = gVar;
        s6.f fVar = gVar.f5143c;
        this.f96b = new r6.e(gVar, fVar.d().c());
        this.f97c = new r6.f(gVar, fVar.d().d(), -1L, true);
    }

    public d(ConcurrentMap concurrentMap, y1.k kVar, i2.a aVar, Class cls) {
        this.f95a = 15;
        this.f96b = concurrentMap;
        this.f97c = kVar;
        this.d = aVar;
    }

    public d(f1 f1Var, List list) {
        this.f95a = 14;
        this.f96b = f1Var;
        this.f97c = list;
        this.d = i2.a.f3137b;
    }
}
