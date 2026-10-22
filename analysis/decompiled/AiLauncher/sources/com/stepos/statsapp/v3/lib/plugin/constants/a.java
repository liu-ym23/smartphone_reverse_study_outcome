package com.stepos.statsapp.v3.lib.plugin.constants;

/* loaded from: classes2.dex */
public enum a {
    PHONE(1),
    TV(2),
    PAD(3),
    WEARABLE(4);

    private final int type;

    a(int i10) {
        this.type = i10;
    }

    public int b() {
        return this.type;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.type);
    }
}
