package com.google.android.gms.common.internal;

import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
/* renamed from: com.google.android.gms.common.internal.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC1672m {
    @ResultIgnorabilityUnspecified
    D2.i<Void> a(TelemetryData telemetryData);
}
