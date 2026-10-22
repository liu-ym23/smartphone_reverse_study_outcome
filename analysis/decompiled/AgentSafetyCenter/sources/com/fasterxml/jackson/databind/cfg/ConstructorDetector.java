package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ConstructorDetector implements Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _allowJDKTypeCtors;
    protected final boolean _requireCtorAnnotation;
    protected final SingleArgConstructor _singleArgMode;
    public static final ConstructorDetector DEFAULT = new ConstructorDetector(SingleArgConstructor.HEURISTIC);
    public static final ConstructorDetector USE_PROPERTIES_BASED = new ConstructorDetector(SingleArgConstructor.PROPERTIES);
    public static final ConstructorDetector USE_DELEGATING = new ConstructorDetector(SingleArgConstructor.DELEGATING);
    public static final ConstructorDetector EXPLICIT_ONLY = new ConstructorDetector(SingleArgConstructor.REQUIRE_MODE);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum SingleArgConstructor {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    public ConstructorDetector(SingleArgConstructor singleArgConstructor, boolean z10, boolean z11) {
        this._singleArgMode = singleArgConstructor;
        this._requireCtorAnnotation = z10;
        this._allowJDKTypeCtors = z11;
    }

    public boolean allowJDKTypeConstructors() {
        return this._allowJDKTypeCtors;
    }

    public boolean requireCtorAnnotation() {
        return this._requireCtorAnnotation;
    }

    public boolean shouldIntrospectorImplicitConstructors(Class<?> cls) {
        if (this._requireCtorAnnotation) {
            return false;
        }
        return this._allowJDKTypeCtors || !ClassUtil.isJDKClass(cls) || Throwable.class.isAssignableFrom(cls);
    }

    public boolean singleArgCreatorDefaultsToDelegating() {
        return this._singleArgMode == SingleArgConstructor.DELEGATING;
    }

    public boolean singleArgCreatorDefaultsToProperties() {
        return this._singleArgMode == SingleArgConstructor.PROPERTIES;
    }

    public SingleArgConstructor singleArgMode() {
        return this._singleArgMode;
    }

    public ConstructorDetector withAllowJDKTypeConstructors(boolean z10) {
        return new ConstructorDetector(this._singleArgMode, this._requireCtorAnnotation, z10);
    }

    public ConstructorDetector withRequireAnnotation(boolean z10) {
        return new ConstructorDetector(this._singleArgMode, z10, this._allowJDKTypeCtors);
    }

    public ConstructorDetector withSingleArgMode(SingleArgConstructor singleArgConstructor) {
        return new ConstructorDetector(singleArgConstructor, this._requireCtorAnnotation, this._allowJDKTypeCtors);
    }

    public ConstructorDetector(SingleArgConstructor singleArgConstructor) {
        this(singleArgConstructor, false, false);
    }
}
