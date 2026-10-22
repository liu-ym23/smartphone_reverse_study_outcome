package com.stepos.ailauncher.chat.wake.homebar;

import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/e;", "", "<init>", "()V", "", "finalPosition", "Landroidx/dynamicanimation/animation/j;", Const.INTENT_KEY_APIKEY, "(F)Landroidx/dynamicanimation/animation/j;", "c", "stiffness", "damping", Const.INTENT_KEY_PKGNAME, "(FFF)Landroidx/dynamicanimation/animation/j;", "", "APPEAR_MS", "J", "EXIT_MS", "CONTENT_AFTER_BACKGROUND_MS", "GLOW_DELAY_MS", "", "ILLUSTRATION_HOMEBAR_GLOW_FRAME", "I", "APPEAR_SCALE_FROM", "F", "CAPSULE_OUT_SCALE_TO", "Landroid/view/animation/PathInterpolator;", "illustrationFade", "Landroid/view/animation/PathInterpolator;", "e", "()Landroid/view/animation/PathInterpolator;", "glowFadeOut", Const.INTENT_KEY_UMID, "IMG3_LEAD_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final long APPEAR_MS = 500;
    public static final float APPEAR_SCALE_FROM = 0.8f;
    public static final float CAPSULE_OUT_SCALE_TO = 0.9f;
    public static final long CONTENT_AFTER_BACKGROUND_MS = 500;
    public static final long EXIT_MS = 400;
    public static final long GLOW_DELAY_MS = 667;
    public static final int ILLUSTRATION_HOMEBAR_GLOW_FRAME = 40;
    public static final long IMG3_LEAD_MS = 166;
    public static final e INSTANCE = new e();
    private static final PathInterpolator illustrationFade = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private static final PathInterpolator glowFadeOut = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);

    public final androidx.dynamicanimation.animation.j a(float finalPosition) {
        return b(finalPosition, 200.0f, 22.0f);
    }

    public final androidx.dynamicanimation.animation.j b(float finalPosition, float stiffness, float damping) {
        float fM = C5685n.m(damping / (((float) Math.sqrt(stiffness)) * 2.0f), 0.2f, 1.0f);
        androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j(finalPosition);
        jVar.h(stiffness);
        jVar.f(fM);
        return jVar;
    }

    public final androidx.dynamicanimation.animation.j c(float finalPosition) {
        return b(finalPosition, 300.0f, 30.0f);
    }

    public final PathInterpolator d() {
        return glowFadeOut;
    }

    public final PathInterpolator e() {
        return illustrationFade;
    }
}
