package com.stepos.base.lease;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LeaseState {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LeaseState[] f6261a;

    static {
        LeaseState[] leaseStateArr = {new LeaseState("ACTIVE", 0), new LeaseState("CLOSING", 1), new LeaseState("CLOSED", 2)};
        f6261a = leaseStateArr;
        a.a(leaseStateArr);
    }

    public LeaseState() {
        throw null;
    }

    public static LeaseState valueOf(String str) {
        return (LeaseState) Enum.valueOf(LeaseState.class, str);
    }

    public static LeaseState[] values() {
        return (LeaseState[]) f6261a.clone();
    }
}
