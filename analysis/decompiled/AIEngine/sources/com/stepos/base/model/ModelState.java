package com.stepos.base.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelState {

    /* renamed from: a, reason: collision with root package name */
    public static final ModelState f6326a;

    /* renamed from: b, reason: collision with root package name */
    public static final ModelState f6327b;

    /* renamed from: c, reason: collision with root package name */
    public static final ModelState f6328c;

    /* renamed from: d, reason: collision with root package name */
    public static final ModelState f6329d;

    /* renamed from: e, reason: collision with root package name */
    public static final ModelState f6330e;
    public static final ModelState h;

    /* renamed from: j, reason: collision with root package name */
    public static final ModelState f6331j;

    /* renamed from: k, reason: collision with root package name */
    public static final ModelState f6332k;

    /* renamed from: l, reason: collision with root package name */
    public static final ModelState f6333l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ ModelState[] f6334m;

    static {
        ModelState modelState = new ModelState("CREATED", 0);
        f6326a = modelState;
        ModelState modelState2 = new ModelState("UNLOADED", 1);
        ModelState modelState3 = new ModelState("LOADED", 2);
        f6327b = modelState3;
        ModelState modelState4 = new ModelState("INITIALIZING", 3);
        f6328c = modelState4;
        ModelState modelState5 = new ModelState("INITIALIZED", 4);
        f6329d = modelState5;
        ModelState modelState6 = new ModelState("WARMED_UP", 5);
        f6330e = modelState6;
        ModelState modelState7 = new ModelState("RUNNING", 6);
        ModelState modelState8 = new ModelState("CLOSING", 7);
        h = modelState8;
        ModelState modelState9 = new ModelState("CLOSED", 8);
        f6331j = modelState9;
        ModelState modelState10 = new ModelState("CLEANED_UP", 9);
        f6332k = modelState10;
        ModelState modelState11 = new ModelState("ERROR", 10);
        f6333l = modelState11;
        ModelState[] modelStateArr = {modelState, modelState2, modelState3, modelState4, modelState5, modelState6, modelState7, modelState8, modelState9, modelState10, modelState11};
        f6334m = modelStateArr;
        kotlin.enums.a.a(modelStateArr);
    }

    public ModelState() {
        throw null;
    }

    public static ModelState valueOf(String str) {
        return (ModelState) Enum.valueOf(ModelState.class, str);
    }

    public static ModelState[] values() {
        return (ModelState[]) f6334m.clone();
    }
}
