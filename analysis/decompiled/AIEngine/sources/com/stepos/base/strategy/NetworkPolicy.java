package com.stepos.base.strategy;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetworkPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkPolicy f6390a;

    /* renamed from: b, reason: collision with root package name */
    public static final NetworkPolicy f6391b;

    /* renamed from: c, reason: collision with root package name */
    public static final NetworkPolicy f6392c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ NetworkPolicy[] f6393d;

    static {
        NetworkPolicy networkPolicy = new NetworkPolicy("ALLOW_CELLULAR", 0);
        f6390a = networkPolicy;
        NetworkPolicy networkPolicy2 = new NetworkPolicy("WIFI_ONLY", 1);
        f6391b = networkPolicy2;
        NetworkPolicy networkPolicy3 = new NetworkPolicy("OFFLINE_ONLY", 2);
        f6392c = networkPolicy3;
        NetworkPolicy[] networkPolicyArr = {networkPolicy, networkPolicy2, networkPolicy3};
        f6393d = networkPolicyArr;
        a.a(networkPolicyArr);
    }

    public NetworkPolicy() {
        throw null;
    }

    public static NetworkPolicy valueOf(String str) {
        return (NetworkPolicy) Enum.valueOf(NetworkPolicy.class, str);
    }

    public static NetworkPolicy[] values() {
        return (NetworkPolicy[]) f6393d.clone();
    }
}
