package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes3.dex */
public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = null;

    static {
        instance = new ArgbEvaluatorCompat();
    }

    public ArgbEvaluatorCompat() {
    }

    @NonNull
    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    @Override // android.animation.TypeEvaluator
    @NonNull
    public /* bridge */ /* synthetic */ Integer evaluate(float r10, Integer r11, Integer r12) {
        return evaluate2(r10, r11, r12);
    }

    @NonNull
    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Integer evaluate2(float r11, Integer r12, Integer r13) {
        int r10 = r12.intValue();
        float r14 = ((r10 >> 24) & PrivateKeyType.INVALID) / 255.0f;
        float r15 = ((r10 >> 16) & PrivateKeyType.INVALID) / 255.0f;
        float r16 = ((r10 >> 8) & PrivateKeyType.INVALID) / 255.0f;
        float r17 = (r10 & PrivateKeyType.INVALID) / 255.0f;
        int r18 = r13.intValue();
        float r19 = ((r18 >> 24) & PrivateKeyType.INVALID) / 255.0f;
        float r20 = ((r18 >> 16) & PrivateKeyType.INVALID) / 255.0f;
        float r21 = ((r18 >> 8) & PrivateKeyType.INVALID) / 255.0f;
        float r110 = (r18 & PrivateKeyType.INVALID) / 255.0f;
        float r22 = (float) Math.pow(r15, 2.2d);
        float r23 = (float) Math.pow(r16, 2.2d);
        float r111 = (float) Math.pow(r17, 2.2d);
        float r24 = (float) Math.pow(r20, 2.2d);
        float r112 = r14 + ((r19 - r14) * r11);
        float r25 = r23 + ((((float) Math.pow(r21, 2.2d)) - r23) * r11);
        float r113 = r111 + (r11 * (((float) Math.pow(r110, 2.2d)) - r111));
        float r114 = ((float) Math.pow(r22 + ((r24 - r22) * r11), 0.45454545454545453d)) * 255.0f;
        float r115 = ((float) Math.pow(r25, 0.45454545454545453d)) * 255.0f;
        float r116 = ((float) Math.pow(r113, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(r116) | (((Math.round(r114) << 16) | (Math.round(r112 * 255.0f) << 24)) | (Math.round(r115) << 8)));
    }
}
