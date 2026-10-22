package com.fasterxml.jackson.core.util;

import b8.z;
import com.fasterxml.jackson.core.util.JacksonFeature;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JacksonFeatureSet<F extends JacksonFeature> implements Serializable {
    private static final long serialVersionUID = 1;
    protected int _enabled;

    public JacksonFeatureSet(int i) {
        this._enabled = i;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromBitmask(int i) {
        return new JacksonFeatureSet<>(i);
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromDefaults(F[] fArr) {
        if (fArr.length > 31) {
            z.u("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{fArr[0].getClass().getName(), Integer.valueOf(fArr.length)});
            return null;
        }
        int mask = 0;
        for (F f5 : fArr) {
            if (f5.enabledByDefault()) {
                mask |= f5.getMask();
            }
        }
        return new JacksonFeatureSet<>(mask);
    }

    public int asBitmask() {
        return this._enabled;
    }

    public boolean isEnabled(F f5) {
        return (this._enabled & f5.getMask()) != 0;
    }

    public JacksonFeatureSet<F> with(F f5) {
        int mask = f5.getMask() | this._enabled;
        return mask == this._enabled ? this : new JacksonFeatureSet<>(mask);
    }

    public JacksonFeatureSet<F> without(F f5) {
        int i = (~f5.getMask()) & this._enabled;
        return i == this._enabled ? this : new JacksonFeatureSet<>(i);
    }
}
