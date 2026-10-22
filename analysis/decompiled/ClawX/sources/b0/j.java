package b0;

import android.content.res.Resources;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import f0.p;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f832a;

    /* renamed from: b, reason: collision with root package name */
    public Object f833b;

    public j(int i8) {
        switch (i8) {
            case 2:
                this.f833b = new byte[32];
                this.f832a = 0;
                break;
            default:
                this.f832a = 1;
                this.f833b = Collections.singletonList(null);
                break;
        }
    }

    public static void a(int i8, long j4) {
        long j8 = 1 << i8;
        if (j4 < 0 || j4 > j8) {
            throw new IllegalArgumentException(j4 + " out of range for " + i8 + " bit value");
        }
    }

    public void b(int i8, c7.d dVar) {
        while (true) {
            int i9 = i8 >> 1;
            if (i9 == 0) {
                break;
            }
            c7.d dVar2 = ((c7.d[]) this.f833b)[i9];
            kotlin.jvm.internal.p.b(dVar2);
            if (kotlin.jvm.internal.p.h(0L, dVar.f1156g - dVar2.f1156g) <= 0) {
                break;
            }
            dVar2.f1155f = i8;
            ((c7.d[]) this.f833b)[i8] = dVar2;
            i8 = i9;
        }
        ((c7.d[]) this.f833b)[i8] = dVar;
        dVar.f1155f = i8;
    }

    @Override // f0.p
    public boolean c(View view) throws Resources.NotFoundException {
        ((BottomSheetBehavior) this.f833b).B(this.f832a);
        return true;
    }

    public void d(int i8) {
        byte[] bArr = (byte[]) this.f833b;
        int length = bArr.length;
        int i9 = this.f832a;
        if (length - i9 >= i8) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i9 + i8) {
            length2 = i9 + i8;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i9);
        this.f833b = bArr2;
    }

    public void e(c7.d dVar) {
        c7.d dVar2;
        int i8 = dVar.f1155f;
        if (i8 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i9 = this.f832a;
        c7.d dVar3 = ((c7.d[]) this.f833b)[i9];
        kotlin.jvm.internal.p.b(dVar3);
        dVar.f1155f = -1;
        ((c7.d[]) this.f833b)[i9] = null;
        this.f832a = i9 - 1;
        if (dVar == dVar3) {
            return;
        }
        int iH = kotlin.jvm.internal.p.h(0L, dVar3.f1156g - dVar.f1156g);
        if (iH == 0) {
            ((c7.d[]) this.f833b)[i8] = dVar3;
            dVar3.f1155f = i8;
            return;
        }
        if (iH >= 0) {
            b(i8, dVar3);
            return;
        }
        while (true) {
            int i10 = i8 << 1;
            int i11 = i10 + 1;
            int i12 = this.f832a;
            if (i11 > i12) {
                if (i10 > i12) {
                    break;
                }
                dVar2 = ((c7.d[]) this.f833b)[i10];
                kotlin.jvm.internal.p.b(dVar2);
            } else {
                dVar2 = ((c7.d[]) this.f833b)[i10];
                kotlin.jvm.internal.p.b(dVar2);
                c7.d dVar4 = ((c7.d[]) this.f833b)[i11];
                kotlin.jvm.internal.p.b(dVar4);
                if (kotlin.jvm.internal.p.h(0L, dVar4.f1156g - dVar2.f1156g) >= 0) {
                    dVar2 = dVar4;
                }
            }
            if (kotlin.jvm.internal.p.h(0L, dVar2.f1156g - dVar3.f1156g) <= 0) {
                break;
            }
            int i13 = dVar2.f1155f;
            dVar2.f1155f = i8;
            ((c7.d[]) this.f833b)[i8] = dVar2;
            i8 = i13;
        }
        ((c7.d[]) this.f833b)[i8] = dVar3;
        dVar3.f1155f = i8;
    }

    public byte[] f() {
        int i8 = this.f832a;
        byte[] bArr = new byte[i8];
        System.arraycopy((byte[]) this.f833b, 0, bArr, 0, i8);
        return bArr;
    }

    public void g(int i8, int i9, byte[] bArr) {
        d(i9);
        System.arraycopy(bArr, i8, (byte[]) this.f833b, this.f832a, i9);
        this.f832a += i9;
    }

    public void h(byte[] bArr) {
        g(0, bArr.length, bArr);
    }

    public void i(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        d(bArr.length + 1);
        byte[] bArr2 = (byte[]) this.f833b;
        int i8 = this.f832a;
        this.f832a = i8 + 1;
        bArr2[i8] = (byte) (255 & bArr.length);
        g(0, bArr.length, bArr);
    }

    public void j(int i8) {
        a(16, i8);
        d(2);
        byte[] bArr = (byte[]) this.f833b;
        int i9 = this.f832a;
        int i10 = i9 + 1;
        this.f832a = i10;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        this.f832a = i9 + 2;
        bArr[i10] = (byte) (i8 & 255);
    }

    public void k(int i8, int i9) {
        a(16, i8);
        if (i9 > this.f832a - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = (byte[]) this.f833b;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 1] = (byte) (i8 & 255);
    }

    public void l(long j4) {
        a(32, j4);
        d(4);
        byte[] bArr = (byte[]) this.f833b;
        int i8 = this.f832a;
        int i9 = i8 + 1;
        this.f832a = i9;
        bArr[i8] = (byte) ((j4 >>> 24) & 255);
        int i10 = i8 + 2;
        this.f832a = i10;
        bArr[i9] = (byte) ((j4 >>> 16) & 255);
        int i11 = i8 + 3;
        this.f832a = i11;
        bArr[i10] = (byte) ((j4 >>> 8) & 255);
        this.f832a = i8 + 4;
        bArr[i11] = (byte) (j4 & 255);
    }

    public void m(int i8) {
        a(8, i8);
        d(1);
        byte[] bArr = (byte[]) this.f833b;
        int i9 = this.f832a;
        this.f832a = i9 + 1;
        bArr[i9] = (byte) (i8 & 255);
    }

    public j(ArrayList arrayList, int i8) {
        switch (i8) {
            case 4:
                this.f833b = arrayList;
                break;
            default:
                this.f832a = 0;
                this.f833b = arrayList;
                break;
        }
    }

    public j(BottomSheetBehavior bottomSheetBehavior, int i8) {
        this.f833b = bottomSheetBehavior;
        this.f832a = i8;
    }
}
