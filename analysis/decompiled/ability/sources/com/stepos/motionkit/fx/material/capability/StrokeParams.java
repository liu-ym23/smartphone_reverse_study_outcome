package com.stepos.motionkit.fx.material.capability;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\u001a\u00104\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001a\u00107\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\u001a\u0010:\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000f¨\u0006="}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/StrokeParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "width", "", "getWidth", "()F", "setWidth", "(F)V", "softness", "getSoftness", "setSoftness", "intensity", "getIntensity", "setIntensity", "spread", "getSpread", "setSpread", TypedValues.Custom.S_COLOR, "", "getColor", "()I", "setColor", "(I)V", "light0X", "getLight0X", "setLight0X", "light0Y", "getLight0Y", "setLight0Y", "light1X", "getLight1X", "setLight1X", "light1Y", "getLight1Y", "setLight1Y", "ambient", "getAmbient", "setAmbient", "anisotropicRim", "getAnisotropicRim", "setAnisotropicRim", "edgeColor", "getEdgeColor", "setEdgeColor", "darkColor", "getDarkColor", "setDarkColor", "darkWidth", "getDarkWidth", "setDarkWidth", "edgeWidth", "getEdgeWidth", "setEdgeWidth", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StrokeParams extends MaterialParams {
    private float ambient;
    private boolean anisotropicRim;
    private float light0X;
    private float light1X;
    private float width;
    private boolean enabled = true;
    private float softness = 6.0f;
    private float intensity = 0.7f;
    private float spread = 2.0f;
    private int color = -1;
    private float light0Y = -1.0f;
    private float light1Y = 1.0f;
    private int edgeColor = -3355444;
    private int darkColor = -3092272;
    private float darkWidth = 1.0f;
    private float edgeWidth = 1.0f;

    public final float getAmbient() {
        return this.ambient;
    }

    public final boolean getAnisotropicRim() {
        return this.anisotropicRim;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDarkColor() {
        return this.darkColor;
    }

    public final float getDarkWidth() {
        return this.darkWidth;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final float getEdgeWidth() {
        return this.edgeWidth;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getIntensity() {
        return this.intensity;
    }

    public final float getLight0X() {
        return this.light0X;
    }

    public final float getLight0Y() {
        return this.light0Y;
    }

    public final float getLight1X() {
        return this.light1X;
    }

    public final float getLight1Y() {
        return this.light1Y;
    }

    public final float getSoftness() {
        return this.softness;
    }

    public final float getSpread() {
        return this.spread;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setAmbient(float f) {
        this.ambient = f;
    }

    public final void setAnisotropicRim(boolean z10) {
        this.anisotropicRim = z10;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setDarkColor(int i) {
        this.darkColor = i;
    }

    public final void setDarkWidth(float f) {
        this.darkWidth = f;
    }

    public final void setEdgeColor(int i) {
        this.edgeColor = i;
    }

    public final void setEdgeWidth(float f) {
        this.edgeWidth = f;
    }

    public final void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public final void setIntensity(float f) {
        this.intensity = f;
    }

    public final void setLight0X(float f) {
        this.light0X = f;
    }

    public final void setLight0Y(float f) {
        this.light0Y = f;
    }

    public final void setLight1X(float f) {
        this.light1X = f;
    }

    public final void setLight1Y(float f) {
        this.light1Y = f;
    }

    public final void setSoftness(float f) {
        this.softness = f;
    }

    public final void setSpread(float f) {
        this.spread = f;
    }

    public final void setWidth(float f) {
        this.width = f;
    }
}
