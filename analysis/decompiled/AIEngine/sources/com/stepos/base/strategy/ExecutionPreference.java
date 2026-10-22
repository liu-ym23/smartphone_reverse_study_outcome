package com.stepos.base.strategy;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExecutionPreference {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutionPreference f6386a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutionPreference f6387b;

    /* renamed from: c, reason: collision with root package name */
    public static final ExecutionPreference f6388c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ExecutionPreference[] f6389d;

    static {
        ExecutionPreference executionPreference = new ExecutionPreference("AUTO", 0);
        f6386a = executionPreference;
        ExecutionPreference executionPreference2 = new ExecutionPreference("LOCAL_ONLY", 1);
        f6387b = executionPreference2;
        ExecutionPreference executionPreference3 = new ExecutionPreference("CLOUD_ONLY", 2);
        f6388c = executionPreference3;
        ExecutionPreference[] executionPreferenceArr = {executionPreference, executionPreference2, executionPreference3};
        f6389d = executionPreferenceArr;
        a.a(executionPreferenceArr);
    }

    public ExecutionPreference() {
        throw null;
    }

    public static ExecutionPreference valueOf(String str) {
        return (ExecutionPreference) Enum.valueOf(ExecutionPreference.class, str);
    }

    public static ExecutionPreference[] values() {
        return (ExecutionPreference[]) f6389d.clone();
    }
}
