package com.stepos.base.awareness.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SceneType {

    /* renamed from: a, reason: collision with root package name */
    public static final SceneType f6193a;

    /* renamed from: b, reason: collision with root package name */
    public static final SceneType f6194b;

    /* renamed from: c, reason: collision with root package name */
    public static final SceneType f6195c;

    /* renamed from: d, reason: collision with root package name */
    public static final SceneType f6196d;

    /* renamed from: e, reason: collision with root package name */
    public static final SceneType f6197e;
    public static final SceneType h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ SceneType[] f6198j;

    static {
        SceneType sceneType = new SceneType("IDLE", 0);
        f6193a = sceneType;
        SceneType sceneType2 = new SceneType("REALTIME_INTERACTION", 1);
        f6194b = sceneType2;
        SceneType sceneType3 = new SceneType("BACKGROUND_PROCESSING", 2);
        f6195c = sceneType3;
        SceneType sceneType4 = new SceneType("BATCH_PROCESSING", 3);
        f6196d = sceneType4;
        SceneType sceneType5 = new SceneType("LOW_BATTERY", 4);
        f6197e = sceneType5;
        SceneType sceneType6 = new SceneType("THERMAL_THROTTLING", 5);
        h = sceneType6;
        SceneType[] sceneTypeArr = {sceneType, sceneType2, sceneType3, sceneType4, sceneType5, sceneType6, new SceneType("POWER_SAVING", 6)};
        f6198j = sceneTypeArr;
        a.a(sceneTypeArr);
    }

    public SceneType() {
        throw null;
    }

    public static SceneType valueOf(String str) {
        return (SceneType) Enum.valueOf(SceneType.class, str);
    }

    public static SceneType[] values() {
        return (SceneType[]) f6198j.clone();
    }
}
