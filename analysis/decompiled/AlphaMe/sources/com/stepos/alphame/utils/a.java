package com.stepos.alphame.utils;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements TemporalAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11216a;

    public /* synthetic */ a(int i4) {
        this.f11216a = i4;
    }

    @Override // java.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        switch (this.f11216a) {
            case 0:
                return DateTimeKt.firstDayOfLastYear$lambda$2(temporal);
            case 1:
                return DateTimeKt.firstDayOfLastMonth$lambda$1(temporal);
            case 2:
                return DateTimeKt.firstDayOfLastYear$lambda$0(temporal);
            default:
                return DateTimeKt.firstDayOfLastMonth$lambda$3(temporal);
        }
    }
}
