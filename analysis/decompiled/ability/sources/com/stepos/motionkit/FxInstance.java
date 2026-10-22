package com.stepos.motionkit;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\rJ/\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\u000fJ7\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\u0014J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/motionkit/FxInstance;", "", "LC7/r;", "release", "()V", "", HintConstants.AUTOFILL_HINT_NAME, "", "value", "setUniform", "(Ljava/lang/String;F)V", "x", "y", "(Ljava/lang/String;FF)V", "z", "(Ljava/lang/String;FFF)V", "w", "(Ljava/lang/String;FFFF)V", "speed", "setSpeed", "(F)V", "", "fps", "setFrameRate", "(I)V", "t", "setProgress", "instance", "(Ljava/lang/String;)Lcom/stepos/motionkit/FxInstance;", "", "getId", "()J", "id", "getName", "()Ljava/lang/String;", "", "isActive", "()Z", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FxInstance {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static FxInstance instance(FxInstance fxInstance, String name) {
            k.f(name, "name");
            if (k.b(fxInstance.getName(), name)) {
                return fxInstance;
            }
            return null;
        }
    }

    long getId();

    String getName();

    FxInstance instance(String name);

    boolean isActive();

    void release();

    void setFrameRate(int fps);

    void setProgress(float t9);

    void setSpeed(float speed);

    void setUniform(String name, float value);

    void setUniform(String name, float x10, float y);

    void setUniform(String name, float x10, float y, float z10);

    void setUniform(String name, float x10, float y, float z10, float w8);
}
