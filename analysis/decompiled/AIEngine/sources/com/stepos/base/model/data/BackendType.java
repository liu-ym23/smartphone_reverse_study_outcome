package com.stepos.base.model.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BackendType {

    /* renamed from: a, reason: collision with root package name */
    public static final BackendType f6357a;

    /* renamed from: b, reason: collision with root package name */
    public static final BackendType f6358b;

    /* renamed from: c, reason: collision with root package name */
    public static final BackendType f6359c;

    /* renamed from: d, reason: collision with root package name */
    public static final BackendType f6360d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ BackendType[] f6361e;

    static {
        BackendType backendType = new BackendType("QNN", 0);
        f6357a = backendType;
        BackendType backendType2 = new BackendType("LLAMA_CPP", 1);
        f6358b = backendType2;
        BackendType backendType3 = new BackendType("TFLITE", 2);
        BackendType backendType4 = new BackendType("ONNX", 3);
        f6359c = backendType4;
        BackendType backendType5 = new BackendType("PYTORCH", 4);
        BackendType backendType6 = new BackendType("CUSTOM", 5);
        f6360d = backendType6;
        BackendType[] backendTypeArr = {backendType, backendType2, backendType3, backendType4, backendType5, backendType6};
        f6361e = backendTypeArr;
        a.a(backendTypeArr);
    }

    public BackendType() {
        throw null;
    }

    public static BackendType valueOf(String str) {
        return (BackendType) Enum.valueOf(BackendType.class, str);
    }

    public static BackendType[] values() {
        return (BackendType[]) f6361e.clone();
    }
}
