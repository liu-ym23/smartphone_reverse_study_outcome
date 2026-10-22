package com.stepos.core.ability.util;

import com.stepos.core.data.ImageContent;
import gc.a;
import h0.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EmbedSessionImageMock {
    public static final int DIM = 384;
    public static final EmbedSessionImageMock INSTANCE = new EmbedSessionImageMock();

    private EmbedSessionImageMock() {
    }

    public static /* synthetic */ float[] fromImageContent$default(EmbedSessionImageMock embedSessionImageMock, ImageContent imageContent, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = DIM;
        }
        return embedSessionImageMock.fromImageContent(imageContent, i10);
    }

    private final float[] fromKey(String str, int i10) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(a.f9106b);
        g.e(bytes, "getBytes(...)");
        long j10 = 0;
        for (int i11 = 0; i11 < Math.min(8, messageDigest.digest(bytes).length); i11++) {
            j10 = (j10 << 8) | (r9[i11] & 255);
        }
        Random random = new Random(j10);
        float[] fArr = new float[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            fArr[i12] = ((float) random.nextGaussian()) * 0.02f;
        }
        float f8 = 0.0f;
        for (int i13 = 0; i13 < i10; i13++) {
            float f9 = fArr[i13];
            f8 += f9 * f9;
        }
        float fSqrt = (float) Math.sqrt(f8);
        if (fSqrt < 1.0E-8f) {
            fSqrt = 1.0E-8f;
        }
        for (int i14 = 0; i14 < i10; i14++) {
            fArr[i14] = fArr[i14] / fSqrt;
        }
        return fArr;
    }

    public static /* synthetic */ float[] fromPath$default(EmbedSessionImageMock embedSessionImageMock, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = DIM;
        }
        return embedSessionImageMock.fromPath(str, i10);
    }

    public final float[] fromImageContent(ImageContent content, int i10) {
        g.f(content, "content");
        int width = content.getWidth();
        int height = content.getHeight();
        long shmSize = content.getShmSize();
        StringBuilder sbD = e.d(width, "img:", height, "x", ":");
        sbD.append(shmSize);
        return fromKey(sbD.toString(), i10);
    }

    public final float[] fromPath(String path, int i10) {
        g.f(path, "path");
        return fromKey(path, i10);
    }
}
