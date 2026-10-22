package com.stepos.aiengine.modelmanager;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelGroup {

    /* renamed from: a, reason: collision with root package name */
    public static final ModelGroup f5843a;

    /* renamed from: b, reason: collision with root package name */
    public static final ModelGroup f5844b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ModelGroup[] f5845c;

    static {
        ModelGroup modelGroup = new ModelGroup("PRESET", 0);
        f5843a = modelGroup;
        ModelGroup modelGroup2 = new ModelGroup("NON_PRESET", 1);
        f5844b = modelGroup2;
        ModelGroup[] modelGroupArr = {modelGroup, modelGroup2};
        f5845c = modelGroupArr;
        a.a(modelGroupArr);
    }

    public ModelGroup() {
        throw null;
    }

    public static ModelGroup valueOf(String str) {
        return (ModelGroup) Enum.valueOf(ModelGroup.class, str);
    }

    public static ModelGroup[] values() {
        return (ModelGroup[]) f5845c.clone();
    }
}
