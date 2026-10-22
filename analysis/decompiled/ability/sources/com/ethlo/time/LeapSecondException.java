package com.ethlo.time;

import java.time.DateTimeException;

/* loaded from: classes2.dex */
public class LeapSecondException extends DateTimeException {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2250a;

    public LeapSecondException(boolean z10) {
        super("Leap second detected in input");
        this.f2250a = z10;
    }
}
