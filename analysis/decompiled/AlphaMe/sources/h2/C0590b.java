package h2;

import B0.g;
import android.opengl.GLES20;
import android.opengl.GLES30;
import androidx.fragment.app.A;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import s.AbstractC0831a;
import w2.C0974a;
import w2.C0975b;
import w2.C0976c;
import w2.InterfaceC0977d;
import x2.e;
import z2.InterfaceC1006a;

/* renamed from: h2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0590b implements InterfaceC1006a {

    /* renamed from: c, reason: collision with root package name */
    public final Object f12697c;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12695a = true;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12698d = new C0974a();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12696b = false;

    public C0590b(x2.b[] bVarArr) {
        this.f12697c = new C0976c(new e(bVarArr));
    }

    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final void a(C0975b c0975b) {
        int iLimit;
        ?? r12;
        boolean z4;
        C0974a c0974a = (C0974a) this.f12698d;
        if ((c0974a.f15835g ? 0 : c0974a.f15829a.capacity()) > 0) {
            iLimit = ((C0974a) this.f12698d).a();
        } else {
            C0976c c0976c = (C0976c) ((InterfaceC0977d) this.f12697c);
            iLimit = (c0976c.f15853b.limit() * 4) / c0976c.f15852a.f15931b;
        }
        boolean z5 = this.f12695a;
        if (iLimit == 0) {
            return;
        }
        if (z5) {
            C0976c c0976c2 = (C0976c) ((InterfaceC0977d) this.f12697c);
            GLES30.glBindVertexArray(c0976c2.f15859h);
            ArrayList arrayList = c0976c2.f15860i;
            boolean z6 = arrayList.size() != 0;
            e eVar = c0976c2.f15852a;
            x2.b[] bVarArr = eVar.f15930a;
            int length = bVarArr.length;
            if (z6) {
                for (int i4 = 0; z6 && i4 < length; i4++) {
                    Integer num = (Integer) c0975b.f15842g.get(bVarArr[i4].f15921f);
                    z6 = (num == null ? -1 : num.intValue()) == ((Integer) arrayList.get(i4)).intValue();
                }
            }
            if (!z6) {
                GLES20.glBindBuffer(34962, c0976c2.f15855d);
                if (arrayList.size() != 0) {
                    int length2 = bVarArr.length;
                    for (int i5 = 0; i5 < length2; i5++) {
                        int iIntValue = ((Integer) arrayList.get(i5)).intValue();
                        if (iIntValue >= 0) {
                            c0975b.getClass();
                            GLES20.glDisableVertexAttribArray(iIntValue);
                        }
                    }
                }
                arrayList.clear();
                for (int i6 = 0; i6 < length; i6++) {
                    x2.b bVar = bVarArr[i6];
                    Integer num2 = (Integer) c0975b.f15842g.get(bVar.f15921f);
                    arrayList.add(Integer.valueOf(num2 == null ? -1 : num2.intValue()));
                    int iIntValue2 = ((Integer) arrayList.get(i6)).intValue();
                    if (iIntValue2 >= 0) {
                        GLES20.glEnableVertexAttribArray(iIntValue2);
                        GLES20.glVertexAttribPointer(iIntValue2, bVar.f15917b, bVar.f15919d, bVar.f15918c, eVar.f15931b, bVar.f15920e);
                    }
                }
            }
            if (c0976c2.f15857f) {
                GLES20.glBindBuffer(34962, c0976c2.f15855d);
                int iLimit2 = c0976c2.f15853b.limit() * 4;
                ByteBuffer byteBuffer = c0976c2.f15854c;
                byteBuffer.limit(iLimit2);
                GLES20.glBufferData(34962, byteBuffer.limit(), byteBuffer, c0976c2.f15856e);
                c0976c2.f15857f = false;
            }
            c0976c2.f15858g = true;
            if (((C0974a) this.f12698d).a() > 0) {
                C0974a c0974a2 = (C0974a) this.f12698d;
                int i7 = c0974a2.f15831c;
                if (i7 == 0) {
                    throw new A("No buffer allocated!", 7);
                }
                GLES20.glBindBuffer(34963, i7);
                if (c0974a2.f15832d) {
                    int iLimit3 = c0974a2.f15829a.limit() * 2;
                    ByteBuffer byteBuffer2 = c0974a2.f15830b;
                    byteBuffer2.limit(iLimit3);
                    GLES20.glBufferData(34963, byteBuffer2.limit(), byteBuffer2, c0974a2.f15834f);
                    c0974a2.f15832d = false;
                }
                c0974a2.f15833e = true;
            }
        }
        if (this.f12696b) {
            if (((C0974a) this.f12698d).a() > 0) {
                C0974a c0974a3 = (C0974a) this.f12698d;
                c0974a3.f15832d = true;
                ShortBuffer shortBuffer = c0974a3.f15829a;
                int iPosition = shortBuffer.position();
                int iLimit4 = shortBuffer.limit();
                z4 = false;
                shortBuffer.position(0);
                shortBuffer.limit(iLimit);
                GLES20.glDrawElements(4, iLimit, 5123, shortBuffer);
                shortBuffer.position(iPosition);
                shortBuffer.limit(iLimit4);
            } else {
                z4 = false;
                GLES20.glDrawArrays(4, 0, iLimit);
            }
            r12 = z4;
        } else if (((C0974a) this.f12698d).a() > 0) {
            C0974a c0974a4 = (C0974a) this.f12698d;
            if (iLimit > (c0974a4.f15835g ? 0 : c0974a4.f15829a.capacity())) {
                StringBuilder sbT = g.t("Mesh attempting to access memory outside of the index buffer (count: ", iLimit, ", offset: 0, max: ");
                C0974a c0974a5 = (C0974a) this.f12698d;
                throw new A(AbstractC0831a.d(sbT, c0974a5.f15835g ? 0 : c0974a5.f15829a.capacity(), ")"), 7);
            }
            r12 = 0;
            GLES20.glDrawElements(4, iLimit, 5123, 0);
        } else {
            r12 = 0;
            GLES20.glDrawArrays(4, 0, iLimit);
        }
        if (z5) {
            C0976c c0976c3 = (C0976c) ((InterfaceC0977d) this.f12697c);
            c0976c3.getClass();
            GLES30.glBindVertexArray(r12);
            c0976c3.f15858g = r12;
            if (((C0974a) this.f12698d).a() > 0) {
                C0974a c0974a6 = (C0974a) this.f12698d;
                c0974a6.getClass();
                GLES20.glBindBuffer(34963, r12);
                c0974a6.f15833e = r12;
            }
        }
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        ((C0976c) ((InterfaceC0977d) this.f12697c)).dispose();
        ((C0974a) this.f12698d).dispose();
    }

    public final String toString() {
        return super.toString();
    }
}
