package org.yaml.snakeyaml;

/* loaded from: classes4.dex */
public enum DumperOptions$FlowStyle {
    FLOW(Boolean.TRUE),
    BLOCK(Boolean.FALSE),
    AUTO(null);


    /* renamed from: a, reason: collision with root package name */
    public final Boolean f5518a;

    DumperOptions$FlowStyle(Boolean bool) {
        this.f5518a = bool;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Flow style: '" + this.f5518a + "'";
    }
}
