package com.stepos.widget.glass;

import android.content.res.TypedArray;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/stepos/widget/glass/GlassEffectResolver;", "", "<init>", "()V", "Landroid/content/res/TypedArray;", "array", "", "index", "Ly7/o;", "read$StepOSWidget_release", "(Landroid/content/res/TypedArray;I)Ly7/o;", "read", UxipConstants.f30680s, "fromValue$StepOSWidget_release", "(I)Ly7/o;", "fromValue", "UNSET", "I", "CLEAR", "LIGHT_SMALL", "LIGHT_MEDIUM", "DARK_SMALL", "DARK_MEDIUM", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlassEffectResolver {
    private static final int CLEAR = 0;
    private static final int DARK_MEDIUM = 4;
    private static final int DARK_SMALL = 3;
    public static final GlassEffectResolver INSTANCE = new GlassEffectResolver();
    private static final int LIGHT_MEDIUM = 2;
    private static final int LIGHT_SMALL = 1;
    private static final int UNSET = -1;

    private GlassEffectResolver() {
    }

    public final y7.o fromValue$StepOSWidget_release(int value) {
        if (value == -1) {
            return null;
        }
        if (value == 0) {
            return y7.o.INSTANCE.g();
        }
        if (value == 1) {
            return y7.o.INSTANCE.k();
        }
        if (value == 2) {
            return y7.o.INSTANCE.j();
        }
        if (value == 3) {
            return y7.o.INSTANCE.i();
        }
        if (value == 4) {
            return y7.o.INSTANCE.h();
        }
        throw new IllegalArgumentException("steposGlassEffect must be clear(0), light_small(1), light_medium(2), dark_small(3), or dark_medium(4) but was " + value);
    }

    public final y7.o read$StepOSWidget_release(TypedArray array, int index) {
        kotlin.jvm.internal.p.i(array, "array");
        if (array.hasValue(index)) {
            return fromValue$StepOSWidget_release(array.getInt(index, -1));
        }
        return null;
    }
}
