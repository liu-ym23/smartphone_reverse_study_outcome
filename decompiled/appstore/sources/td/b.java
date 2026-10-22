package td;

import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24795a = null;

    static {
        f24795a = new b();
    }

    public b() {
    }

    public static final int a(float r10, int r11, int r12) {
        int r13 = (r11 >> 24) & PrivateKeyType.INVALID;
        int r14 = (r11 >> 16) & PrivateKeyType.INVALID;
        int r15 = (r11 >> 8) & PrivateKeyType.INVALID;
        int r16 = r11 & PrivateKeyType.INVALID;
        int r17 = (r12 >> 24) & PrivateKeyType.INVALID;
        int r18 = (r12 >> 16) & PrivateKeyType.INVALID;
        return ((int) (r16 + (r10 * ((r12 & PrivateKeyType.INVALID) - r16)))) | (((((int) (r13 + ((r17 - r13) * r10))) << 24) | (((int) (r14 + ((r18 - r14) * r10))) << 16)) | (((int) (r15 + ((((r12 >> 8) & PrivateKeyType.INVALID) - r15) * r10))) << 8));
    }

    public static final float b(float r10, float r11, float r12) {
        return (r10 - r11) / (r12 - r11);
    }

    public static final float c(float r10, float r11, float r12) {
        return r10 + ((r11 - r10) * r12);
    }

    public static final float d(float r10, float r11, float r12) {
        if (r11 != r12) goto L7;
        return 0.0f;
    L7:
        return (r10 - r11) / (r12 - r11);
    }

    public static final float e(float r10, float r11, float r12, float r13, float r14) {
        if (r11 >= r12) goto L5;
        float r15 = bg.h.j(r10, r11, r12);
    L7:
        return c(r13, r14, d(r15, r11, r12));
    L5:
        r15 = bg.h.j(r10, r12, r11);
        goto L7
    }
}
