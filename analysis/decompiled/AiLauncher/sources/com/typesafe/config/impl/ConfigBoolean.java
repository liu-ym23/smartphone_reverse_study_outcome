package com.typesafe.config.impl;

import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
final class ConfigBoolean extends AbstractConfigValue implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f31739b;

    public ConfigBoolean(b8.k kVar, boolean z10) {
        super(kVar);
        this.f31739b = z10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.BOOLEAN;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public String m0() {
        return this.f31739b ? "true" : "false";
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public ConfigBoolean c0(b8.k kVar) {
        return new ConfigBoolean(kVar, this.f31739b);
    }

    @Override // b8.p
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public Boolean a() {
        return Boolean.valueOf(this.f31739b);
    }
}
