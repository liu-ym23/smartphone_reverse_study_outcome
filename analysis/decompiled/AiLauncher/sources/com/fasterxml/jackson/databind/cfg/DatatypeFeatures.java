package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class DatatypeFeatures implements Serializable {
    protected static final int FEATURE_INDEX_ENUM = 0;
    protected static final int FEATURE_INDEX_JSON_NODE = 1;
    private static final long serialVersionUID = 1;
    private final int _enabledFor1;
    private final int _enabledFor2;
    private final int _explicitFor1;
    private final int _explicitFor2;

    public static class DefaultHolder {
        private static final DatatypeFeatures DEFAULT_FEATURES = new DatatypeFeatures(collectDefaults(EnumFeature.values()), 0, collectDefaults(JsonNodeFeature.values()), 0);

        private DefaultHolder() {
        }

        /* JADX WARN: Incorrect types in method signature: <F:Ljava/lang/Enum<TF;>;:Lcom/fasterxml/jackson/core/util/JacksonFeature;>([TF;)I */
        /* JADX WARN: Multi-variable type inference failed */
        private static int collectDefaults(Enum[] enumArr) {
            int mask = 0;
            for (EnumFeature enumFeature : enumArr) {
                if (enumFeature.enabledByDefault()) {
                    mask |= enumFeature.getMask();
                }
            }
            return mask;
        }

        public static DatatypeFeatures getDefault() {
            return DEFAULT_FEATURES;
        }
    }

    public DatatypeFeatures(int i10, int i11, int i12, int i13) {
        this._enabledFor1 = i10;
        this._explicitFor1 = i11;
        this._enabledFor2 = i12;
        this._explicitFor2 = i13;
    }

    private static final int _calcMask(DatatypeFeature... datatypeFeatureArr) {
        int mask = 0;
        for (DatatypeFeature datatypeFeature : datatypeFeatureArr) {
            mask |= datatypeFeature.getMask();
        }
        return mask;
    }

    private DatatypeFeatures _with(int i10, int i11, int i12, int i13) {
        return (this._enabledFor1 == i10 && this._explicitFor1 == i11 && this._enabledFor2 == i12 && this._explicitFor2 == i13) ? this : new DatatypeFeatures(i10, i11, i12, i13);
    }

    public static DatatypeFeatures defaultFeatures() {
        return DefaultHolder.getDefault();
    }

    public Boolean getExplicitState(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            if (datatypeFeature.enabledIn(this._explicitFor1)) {
                return Boolean.valueOf(datatypeFeature.enabledIn(this._enabledFor1));
            }
            return null;
        }
        if (iFeatureIndex != 1) {
            VersionUtil.throwInternal();
            return null;
        }
        if (datatypeFeature.enabledIn(this._explicitFor2)) {
            return Boolean.valueOf(datatypeFeature.enabledIn(this._enabledFor2));
        }
        return null;
    }

    public boolean isEnabled(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn(this._enabledFor1);
        }
        if (iFeatureIndex == 1) {
            return datatypeFeature.enabledIn(this._enabledFor2);
        }
        VersionUtil.throwInternal();
        return false;
    }

    public boolean isExplicitlyDisabled(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn((~this._enabledFor1) & this._explicitFor1);
        }
        if (iFeatureIndex != 1) {
            VersionUtil.throwInternal();
            return false;
        }
        return datatypeFeature.enabledIn((~this._enabledFor2) & this._explicitFor2);
    }

    public boolean isExplicitlyEnabled(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn(this._enabledFor1 & this._explicitFor1);
        }
        if (iFeatureIndex != 1) {
            VersionUtil.throwInternal();
            return false;
        }
        return datatypeFeature.enabledIn(this._enabledFor2 & this._explicitFor2);
    }

    public boolean isExplicitlySet(DatatypeFeature datatypeFeature) {
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return datatypeFeature.enabledIn(this._explicitFor1);
        }
        if (iFeatureIndex == 1) {
            return datatypeFeature.enabledIn(this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return false;
    }

    public DatatypeFeatures with(DatatypeFeature datatypeFeature) {
        int mask = datatypeFeature.getMask();
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 | mask, mask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 | mask, mask | this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return this;
    }

    public DatatypeFeatures withFeatures(DatatypeFeature... datatypeFeatureArr) {
        int i_calcMask = _calcMask(datatypeFeatureArr);
        if (i_calcMask == 0) {
            return this;
        }
        int iFeatureIndex = datatypeFeatureArr[0].featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 | i_calcMask, i_calcMask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 | i_calcMask, i_calcMask | this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return this;
    }

    public DatatypeFeatures without(DatatypeFeature datatypeFeature) {
        int mask = datatypeFeature.getMask();
        int iFeatureIndex = datatypeFeature.featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 & (~mask), mask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 & (~mask), mask | this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return this;
    }

    public DatatypeFeatures withoutFeatures(DatatypeFeature... datatypeFeatureArr) {
        int i_calcMask = _calcMask(datatypeFeatureArr);
        if (i_calcMask == 0) {
            return this;
        }
        int iFeatureIndex = datatypeFeatureArr[0].featureIndex();
        if (iFeatureIndex == 0) {
            return _with(this._enabledFor1 & (~i_calcMask), i_calcMask | this._explicitFor1, this._enabledFor2, this._explicitFor2);
        }
        if (iFeatureIndex == 1) {
            return _with(this._enabledFor1, this._explicitFor1, this._enabledFor2 & (~i_calcMask), i_calcMask | this._explicitFor2);
        }
        VersionUtil.throwInternal();
        return this;
    }
}
