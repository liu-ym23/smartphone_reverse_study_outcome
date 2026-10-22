package com.stepos.base.protocol;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFeedKind {

    /* renamed from: a, reason: collision with root package name */
    public static final AsrFeedKind f6375a;

    /* renamed from: b, reason: collision with root package name */
    public static final AsrFeedKind f6376b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AsrFeedKind[] f6377c;

    static {
        AsrFeedKind asrFeedKind = new AsrFeedKind("STREAM", 0);
        f6375a = asrFeedKind;
        AsrFeedKind asrFeedKind2 = new AsrFeedKind("FILE", 1);
        f6376b = asrFeedKind2;
        AsrFeedKind[] asrFeedKindArr = {asrFeedKind, asrFeedKind2};
        f6377c = asrFeedKindArr;
        a.a(asrFeedKindArr);
    }

    public AsrFeedKind() {
        throw null;
    }

    public static AsrFeedKind valueOf(String str) {
        return (AsrFeedKind) Enum.valueOf(AsrFeedKind.class, str);
    }

    public static AsrFeedKind[] values() {
        return (AsrFeedKind[]) f6377c.clone();
    }
}
