package com.obric.oui.blur;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: BlurToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BlurToken {
    public static final float Blur_Background_Regular = 0.0f;
    public static final float Blur_Background_Thick = 0.0f;
    public static final float Blur_Progress_Regular = 0.0f;
    public static final float Blur_Progress_Thin = 0.0f;
    public static final float Blur_Regular = 0.0f;
    public static final float Blur_Thick = 0.0f;
    public static final float Blur_Thin = 0.0f;
    public static final float Blur_UltraThick = 0.0f;
    public static final float Blur_UltraThin = 0.0f;
    public static final float Blur_Zero = 0.0f;
    public static final BlurToken INSTANCE = null;

    private BlurToken() {
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static final void register(Object r1, boolean r2) {
        o.e(r1, "customTokenOwner");
        BlurTokenCore.register(INSTANCE, r1, r2);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    public static final void registerTokens(Map<String, Float> r2, boolean r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "customTokens");
        BlurTokenCore.registerTokens(INSTANCE, r4, r3);
    }

    public static final Float parse(String r1) {
        return BlurTokenCore.parse(INSTANCE, r1);
    }

    static {
        INSTANCE = new BlurToken();
        Blur_Zero = 0.1f;
        Blur_UltraThin = BlurTokenCore.Blur_UltraThin;
        Blur_Thin = 8.0f;
        Blur_Regular = 20.0f;
        Blur_Thick = 32.0f;
        Blur_UltraThick = 64.0f;
        Blur_Background_Regular = 20.0f;
        Blur_Background_Thick = 64.0f;
        Blur_Progress_Thin = 8.0f;
        Blur_Progress_Regular = 20.0f;
    }
}
