package I4;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
class k {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3142b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, CategoryEntity.NEWS, CategoryEntity.LIFE, CategoryEntity.FINANCING, CategoryEntity.SOCIAL, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3143c = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: d, reason: collision with root package name */
    private static final k f3144d = new k();

    /* renamed from: a, reason: collision with root package name */
    private final a f3145a = new a();

    private k() {
        b();
    }

    private void a(int i5, int i6, byte b6) {
        a aVar = new a(i5, b6);
        a aVar2 = this.f3145a;
        while (b6 > 8) {
            b6 = (byte) (b6 - 8);
            int i7 = (i6 >>> b6) & 255;
            a[] aVarArr = aVar2.f3146a;
            if (aVarArr == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (aVarArr[i7] == null) {
                aVarArr[i7] = new a();
            }
            aVar2 = aVar2.f3146a[i7];
        }
        int i8 = 8 - b6;
        int i9 = (i6 << i8) & 255;
        int i10 = 1 << i8;
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            aVar2.f3146a[i11] = aVar;
        }
    }

    private void b() {
        int i5 = 0;
        while (true) {
            byte[] bArr = f3143c;
            if (i5 >= bArr.length) {
                return;
            }
            a(i5, f3142b[i5], bArr[i5]);
            i5++;
        }
    }

    public static k f() {
        return f3144d;
    }

    byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f3145a;
        int i5 = 0;
        int i6 = 0;
        for (byte b6 : bArr) {
            i5 = (i5 << 8) | (b6 & 255);
            i6 += 8;
            while (i6 >= 8) {
                aVar = aVar.f3146a[(i5 >>> (i6 - 8)) & 255];
                if (aVar.f3146a == null) {
                    byteArrayOutputStream.write(aVar.f3147b);
                    i6 -= aVar.f3148c;
                    aVar = this.f3145a;
                } else {
                    i6 -= 8;
                }
            }
        }
        while (i6 > 0) {
            a aVar2 = aVar.f3146a[(i5 << (8 - i6)) & 255];
            if (aVar2.f3146a != null || aVar2.f3148c > i6) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f3147b);
            i6 -= aVar2.f3148c;
            aVar = this.f3145a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    void d(L4.h hVar, L4.f fVar) {
        long j5 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < hVar.w(); i6++) {
            int i7 = hVar.i(i6) & 255;
            int i8 = f3142b[i7];
            byte b6 = f3143c[i7];
            j5 = (j5 << b6) | i8;
            i5 += b6;
            while (i5 >= 8) {
                i5 -= 8;
                fVar.writeByte((int) (j5 >> i5));
            }
        }
        if (i5 > 0) {
            fVar.writeByte((int) ((j5 << (8 - i5)) | (255 >>> i5)));
        }
    }

    int e(L4.h hVar) {
        long j5 = 0;
        for (int i5 = 0; i5 < hVar.w(); i5++) {
            j5 += f3143c[hVar.i(i5) & 255];
        }
        return (int) ((j5 + 7) >> 3);
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final a[] f3146a;

        /* renamed from: b, reason: collision with root package name */
        final int f3147b;

        /* renamed from: c, reason: collision with root package name */
        final int f3148c;

        a() {
            this.f3146a = new a[256];
            this.f3147b = 0;
            this.f3148c = 0;
        }

        a(int i5, int i6) {
            this.f3146a = null;
            this.f3147b = i5;
            int i7 = i6 & 7;
            this.f3148c = i7 == 0 ? 8 : i7;
        }
    }
}
