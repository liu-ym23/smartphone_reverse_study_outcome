package com.typesafe.config.impl;

import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
final class ConfigNull extends AbstractConfigValue implements Serializable {
    public ConfigNull(b8.k kVar) {
        super(kVar);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // b8.p
    public Object a() {
        return null;
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.NULL;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        sb2.append("null");
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public String m0() {
        return "null";
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public ConfigNull c0(b8.k kVar) {
        return new ConfigNull(kVar);
    }
}
