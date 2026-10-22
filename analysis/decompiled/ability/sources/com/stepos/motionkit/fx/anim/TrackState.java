package com.stepos.motionkit.fx.anim;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.TrackType;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/motionkit/fx/anim/TrackState;", "", HintConstants.AUTOFILL_HINT_NAME, "", "type", "Lcom/stepos/motionkit/TrackType;", "component", "", "value", "", "completeFired", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/TrackType;IFZ)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/stepos/motionkit/TrackType;", "getComponent", "()I", "getValue", "()F", "setValue", "(F)V", "getCompleteFired", "()Z", "setCompleteFired", "(Z)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TrackState {
    private boolean completeFired;
    private final int component;
    private final String name;
    private final TrackType type;
    private float value;

    public TrackState(String name, TrackType type, int i, float f, boolean z10) {
        k.f(name, "name");
        k.f(type, "type");
        this.name = name;
        this.type = type;
        this.component = i;
        this.value = f;
        this.completeFired = z10;
    }

    public final boolean getCompleteFired() {
        return this.completeFired;
    }

    public final int getComponent() {
        return this.component;
    }

    public final String getName() {
        return this.name;
    }

    public final TrackType getType() {
        return this.type;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setCompleteFired(boolean z10) {
        this.completeFired = z10;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    public /* synthetic */ TrackState(String str, TrackType trackType, int i, float f, boolean z10, int i6, e eVar) {
        this(str, trackType, (i6 & 4) != 0 ? -1 : i, (i6 & 8) != 0 ? 0.0f : f, (i6 & 16) != 0 ? false : z10);
    }
}
