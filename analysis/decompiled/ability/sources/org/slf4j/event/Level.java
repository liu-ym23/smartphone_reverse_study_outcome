package org.slf4j.event;

/* loaded from: classes4.dex */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");


    /* renamed from: a, reason: collision with root package name */
    public final int f5513a;
    public final String b;

    Level(int i, String str) {
        this.f5513a = i;
        this.b = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
