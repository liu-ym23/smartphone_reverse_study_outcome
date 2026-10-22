package com.stepos.base.protocol;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ProtocolType {

    /* renamed from: a, reason: collision with root package name */
    public static final ProtocolType f6378a;

    /* renamed from: b, reason: collision with root package name */
    public static final ProtocolType f6379b;

    /* renamed from: c, reason: collision with root package name */
    public static final ProtocolType f6380c;

    /* renamed from: d, reason: collision with root package name */
    public static final ProtocolType f6381d;

    /* renamed from: e, reason: collision with root package name */
    public static final ProtocolType f6382e;
    public static final ProtocolType h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ ProtocolType[] f6383j;

    static {
        ProtocolType protocolType = new ProtocolType("TEXT", 0);
        f6378a = protocolType;
        ProtocolType protocolType2 = new ProtocolType("VISION", 1);
        f6379b = protocolType2;
        ProtocolType protocolType3 = new ProtocolType("AUDIO", 2);
        f6380c = protocolType3;
        ProtocolType protocolType4 = new ProtocolType("GRAPHIC", 3);
        f6381d = protocolType4;
        ProtocolType protocolType5 = new ProtocolType("MULTIMODAL", 4);
        f6382e = protocolType5;
        ProtocolType protocolType6 = new ProtocolType("SPEECH", 5);
        h = protocolType6;
        ProtocolType[] protocolTypeArr = {protocolType, protocolType2, protocolType3, protocolType4, protocolType5, protocolType6};
        f6383j = protocolTypeArr;
        a.a(protocolTypeArr);
    }

    public ProtocolType() {
        throw null;
    }

    public static ProtocolType valueOf(String str) {
        return (ProtocolType) Enum.valueOf(ProtocolType.class, str);
    }

    public static ProtocolType[] values() {
        return (ProtocolType[]) f6383j.clone();
    }
}
