package bc7;

import androidx.collection.ScatterMapKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18591a = 0;

    static {
    }

    public static int a(byte[] r110, int r111) {
        int r100 = r110.length;
        int r101 = r100 >> 2;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L6;
        int r104 = r103 << 2;
        int r105 = (((r110[r104 + 3] & 255) << 24) | (((r110[r104] & 255) | ((r110[r104 + 1] & 255) << 8)) | ((r110[r104 + 2] & 255) << 16))) * ScatterMapKt.MurmurHashC1;
        int r112 = r111 ^ (((r105 >>> 17) | (r105 << 15)) * 461845907);
        r111 = (((r112 >>> 19) | (r112 << 13)) * 5) - 430675100;
        r103 = r103 + 1;
        goto L4
    L6:
        int r106 = r100 & 3;
        if (r106 <= 0) goto L18;
        int r107 = r101 << 2;
        if (r106 == 1) goto L16;
        if (r106 == 2) goto L14;
        if (r106 != 3) goto L17;
        int r108 = (0 ^ ((r110[r107 + 2] & 255) << 16)) ^ ((r110[r107 + 1] & 255) << 8);
        int r113 = r110[r107];
    L15:
        r102 = r108 ^ (r113 & 255);
    L17:
        int r109 = r102 * ScatterMapKt.MurmurHashC1;
        r111 = r111 ^ (((r109 << 15) | (r109 >>> 17)) * 461845907);
        goto L18
    L14:
        r108 = 0 ^ ((r110[r107 + 1] & 255) << 8);
        r113 = r110[r107];
        goto L15
    L16:
        r102 = 0 ^ (r110[r107] & 255);
    L18:
        int r114 = r111 ^ r100;
        int r115 = (r114 ^ (r114 >>> 16)) * ((int) 2246822507L);
        int r116 = (r115 ^ (r115 >>> 13)) * ((int) 3266489909L);
        return r116 ^ (r116 >>> 16);
    }
}
