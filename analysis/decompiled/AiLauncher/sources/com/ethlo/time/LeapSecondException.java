package com.ethlo.time;

import java.time.DateTimeException;
import java.time.OffsetDateTime;

/* loaded from: classes.dex */
public class LeapSecondException extends DateTimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f19313a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19314b;

    /* renamed from: c, reason: collision with root package name */
    public final OffsetDateTime f19315c;

    public LeapSecondException(OffsetDateTime offsetDateTime, int i10, boolean z10) {
        super("Leap second detected in input");
        this.f19315c = offsetDateTime;
        this.f19313a = i10;
        this.f19314b = z10;
    }

    public boolean a() {
        return this.f19314b;
    }
}
