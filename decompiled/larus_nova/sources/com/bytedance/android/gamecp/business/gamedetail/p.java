package com.bytedance.android.gamecp.business.gamedetail;

import android.graphics.Color;

/* JADX INFO: loaded from: classes44.dex */
public final class p {
    public static float[] b(int r110) {
        float[] r100 = new float[3];
        int r101 = Color.red(r110);
        int r102 = Color.green(r110);
        int r111 = Color.blue(r110);
        if (r101 <= r102) goto L5;
        int r103 = r101;
    L6:
        if (r111 <= r103) goto L8;
        r103 = r111;
    L8:
        if (r101 >= r102) goto L10;
        int r104 = r101;
    L11:
        if (r111 >= r104) goto L13;
        r104 = r111;
    L13:
        float r105 = r103;
        float r106 = r105 / 255.0f;
        float r107 = 0.0f;
        if (r103 == 0) goto L16;
        float r108 = (r103 - r104) / r105;
    L18:
        if (r108 == 0.0f) goto L30;
        float r109 = r103 - r104;
        float r112 = (r103 - r101) / r109;
        float r113 = (r103 - r102) / r109;
        float r114 = (r103 - r111) / r109;
        if (r101 != r103) goto L23;
        float r115 = r114 - r113;
    L26:
        float r116 = r115 / 6.0f;
        if (r116 >= 0.0f) goto L29;
        r107 = r116 + 1.0f;
        goto L30
    L29:
        r107 = r116;
        goto L30
    L23:
        if (r102 != r103) goto L25;
        r115 = (r112 + 2.0f) - r114;
        goto L26
    L25:
        r115 = (r113 + 4.0f) - r112;
    L30:
        r100[0] = r107;
        r100[1] = r108;
        r100[2] = r106;
        return r100;
    L16:
        r108 = 0.0f;
        goto L18
    L10:
        r104 = r102;
        goto L11
    L5:
        r103 = r102;
        goto L6
    }

    public static int a(float r100, float r101, float r102) {
        if (r101 != 0.0f) goto L5;
        int r103 = (int) ((r102 * 255.0f) + 0.5f);
        int r104 = r103;
        int r105 = r104;
    L27:
        return (((r103 << 16) | (-16777216)) | (r104 << 8)) | (r105 << 0);
    L5:
        float r106 = (r100 - ((float) Math.floor(r100))) * 6.0f;
        float r107 = r106 - ((float) Math.floor(r106));
        float r108 = (1.0f - r101) * r102;
        float r109 = (1.0f - (r101 * r107)) * r102;
        float r110 = (1.0f - (r101 * (1.0f - r107))) * r102;
        int r111 = (int) r106;
        if (r111 != 0) goto L8;
        r103 = (int) ((r102 * 255.0f) + 0.5f);
        r104 = (int) ((r110 * 255.0f) + 0.5f);
    L25:
        r105 = (int) ((r108 * 255.0f) + 0.5f);
        goto L27
    L8:
        if (r111 != 1) goto L10;
        r103 = (int) ((r109 * 255.0f) + 0.5f);
        r104 = (int) ((r102 * 255.0f) + 0.5f);
        goto L25
    L10:
        if (r111 != 2) goto L12;
        r103 = (int) ((r108 * 255.0f) + 0.5f);
        r104 = (int) ((r102 * 255.0f) + 0.5f);
        r105 = (int) ((r110 * 255.0f) + 0.5f);
        goto L27
    L12:
        if (r111 != 3) goto L14;
        r103 = (int) ((r108 * 255.0f) + 0.5f);
        r104 = (int) ((r109 * 255.0f) + 0.5f);
    L21:
        r105 = (int) ((r102 * 255.0f) + 0.5f);
        goto L27
    L14:
        if (r111 != 4) goto L16;
        r103 = (int) ((r110 * 255.0f) + 0.5f);
        r104 = (int) ((r108 * 255.0f) + 0.5f);
        goto L21
    L16:
        if (r111 == 5) goto L18;
        r103 = 0;
        r104 = 0;
        r105 = 0;
        goto L27
    L18:
        r103 = (int) ((r102 * 255.0f) + 0.5f);
        r104 = (int) ((r108 * 255.0f) + 0.5f);
        r105 = (int) ((r109 * 255.0f) + 0.5f);
        goto L27
    }
}
