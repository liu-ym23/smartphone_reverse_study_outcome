package com.stepos.ailauncher.chat.wake.effect;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u0019¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/effect/d;", "", "", "idleGlowIntensity", "idleGlowWidth", "idleBorderRadius", "idleAmplitude", "recordingGlowIntensity", "recordingGlowWidth", "recordingBorderRadius", "recordingAmplitude", "<init>", "(FFFFFFFF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_UMID, "()F", "e", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.effect.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SpectrumBorderConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SpectrumBorderConfig LONG_PRESS = new SpectrumBorderConfig(0.0f, 0.0f, 0.0f, 0.0f, 1.8f, 0.045f, 0.0f, 0.5f, 79, null);
    private final float idleAmplitude;
    private final float idleBorderRadius;
    private final float idleGlowIntensity;
    private final float idleGlowWidth;
    private final float recordingAmplitude;
    private final float recordingBorderRadius;
    private final float recordingGlowIntensity;
    private final float recordingGlowWidth;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/effect/d$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "LONG_PRESS", "Lcom/stepos/ailauncher/chat/wake/effect/d;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/wake/effect/d;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.effect.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SpectrumBorderConfig a() {
            return SpectrumBorderConfig.LONG_PRESS;
        }

        public Companion() {
        }
    }

    public SpectrumBorderConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255, null);
    }

    /* renamed from: b, reason: from getter */
    public final float getIdleAmplitude() {
        return this.idleAmplitude;
    }

    /* renamed from: c, reason: from getter */
    public final float getIdleBorderRadius() {
        return this.idleBorderRadius;
    }

    /* renamed from: d, reason: from getter */
    public final float getIdleGlowIntensity() {
        return this.idleGlowIntensity;
    }

    /* renamed from: e, reason: from getter */
    public final float getIdleGlowWidth() {
        return this.idleGlowWidth;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpectrumBorderConfig)) {
            return false;
        }
        SpectrumBorderConfig spectrumBorderConfig = (SpectrumBorderConfig) other;
        return Float.compare(this.idleGlowIntensity, spectrumBorderConfig.idleGlowIntensity) == 0 && Float.compare(this.idleGlowWidth, spectrumBorderConfig.idleGlowWidth) == 0 && Float.compare(this.idleBorderRadius, spectrumBorderConfig.idleBorderRadius) == 0 && Float.compare(this.idleAmplitude, spectrumBorderConfig.idleAmplitude) == 0 && Float.compare(this.recordingGlowIntensity, spectrumBorderConfig.recordingGlowIntensity) == 0 && Float.compare(this.recordingGlowWidth, spectrumBorderConfig.recordingGlowWidth) == 0 && Float.compare(this.recordingBorderRadius, spectrumBorderConfig.recordingBorderRadius) == 0 && Float.compare(this.recordingAmplitude, spectrumBorderConfig.recordingAmplitude) == 0;
    }

    /* renamed from: f, reason: from getter */
    public final float getRecordingAmplitude() {
        return this.recordingAmplitude;
    }

    /* renamed from: g, reason: from getter */
    public final float getRecordingBorderRadius() {
        return this.recordingBorderRadius;
    }

    /* renamed from: h, reason: from getter */
    public final float getRecordingGlowIntensity() {
        return this.recordingGlowIntensity;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.idleGlowIntensity) * 31) + Float.hashCode(this.idleGlowWidth)) * 31) + Float.hashCode(this.idleBorderRadius)) * 31) + Float.hashCode(this.idleAmplitude)) * 31) + Float.hashCode(this.recordingGlowIntensity)) * 31) + Float.hashCode(this.recordingGlowWidth)) * 31) + Float.hashCode(this.recordingBorderRadius)) * 31) + Float.hashCode(this.recordingAmplitude);
    }

    /* renamed from: i, reason: from getter */
    public final float getRecordingGlowWidth() {
        return this.recordingGlowWidth;
    }

    public String toString() {
        return "SpectrumBorderConfig(idleGlowIntensity=" + this.idleGlowIntensity + ", idleGlowWidth=" + this.idleGlowWidth + ", idleBorderRadius=" + this.idleBorderRadius + ", idleAmplitude=" + this.idleAmplitude + ", recordingGlowIntensity=" + this.recordingGlowIntensity + ", recordingGlowWidth=" + this.recordingGlowWidth + ", recordingBorderRadius=" + this.recordingBorderRadius + ", recordingAmplitude=" + this.recordingAmplitude + ")";
    }

    public SpectrumBorderConfig(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.idleGlowIntensity = f10;
        this.idleGlowWidth = f11;
        this.idleBorderRadius = f12;
        this.idleAmplitude = f13;
        this.recordingGlowIntensity = f14;
        this.recordingGlowWidth = f15;
        this.recordingBorderRadius = f16;
        this.recordingAmplitude = f17;
    }

    public /* synthetic */ SpectrumBorderConfig(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i10, i iVar) {
        this((i10 & 1) != 0 ? 1.8f : f10, (i10 & 2) != 0 ? 0.045f : f11, (i10 & 4) != 0 ? 0.12f : f12, (i10 & 8) != 0 ? 0.5f : f13, (i10 & 16) != 0 ? 2.4f : f14, (i10 & 32) != 0 ? 0.06f : f15, (i10 & 64) != 0 ? 0.12f : f16, (i10 & 128) != 0 ? 0.85f : f17);
    }
}
