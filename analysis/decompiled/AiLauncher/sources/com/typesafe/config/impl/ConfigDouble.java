package com.typesafe.config.impl;

import com.typesafe.config.ConfigValueType;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* loaded from: classes4.dex */
final class ConfigDouble extends ConfigNumber implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final double f31740c;

    public ConfigDouble(b8.k kVar, double d10, String str) {
        super(kVar, str);
        this.f31740c = d10;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.NUMBER;
    }

    @Override // com.typesafe.config.impl.ConfigNumber, com.typesafe.config.impl.AbstractConfigValue
    public String m0() {
        String strM0 = super.m0();
        return strM0 == null ? Double.toString(this.f31740c) : strM0;
    }

    @Override // com.typesafe.config.impl.ConfigNumber
    public double q0() {
        return this.f31740c;
    }

    @Override // com.typesafe.config.impl.ConfigNumber
    public long t0() {
        return (long) this.f31740c;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public ConfigDouble c0(b8.k kVar) {
        return new ConfigDouble(kVar, this.f31740c, this.f31743b);
    }

    @Override // com.typesafe.config.impl.ConfigNumber
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public Double a() {
        return Double.valueOf(this.f31740c);
    }
}
