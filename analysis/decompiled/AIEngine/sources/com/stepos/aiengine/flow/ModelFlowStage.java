package com.stepos.aiengine.flow;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelFlowStage {

    /* renamed from: a, reason: collision with root package name */
    public static final ModelFlowStage f5775a;

    /* renamed from: b, reason: collision with root package name */
    public static final ModelFlowStage f5776b;

    /* renamed from: c, reason: collision with root package name */
    public static final ModelFlowStage f5777c;

    /* renamed from: d, reason: collision with root package name */
    public static final ModelFlowStage f5778d;

    /* renamed from: e, reason: collision with root package name */
    public static final ModelFlowStage f5779e;
    public static final ModelFlowStage h;

    /* renamed from: j, reason: collision with root package name */
    public static final ModelFlowStage f5780j;

    /* renamed from: k, reason: collision with root package name */
    public static final ModelFlowStage f5781k;

    /* renamed from: l, reason: collision with root package name */
    public static final ModelFlowStage f5782l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ ModelFlowStage[] f5783m;

    static {
        ModelFlowStage modelFlowStage = new ModelFlowStage("CHECKING", 0);
        f5775a = modelFlowStage;
        ModelFlowStage modelFlowStage2 = new ModelFlowStage("CTA", 1);
        f5776b = modelFlowStage2;
        ModelFlowStage modelFlowStage3 = new ModelFlowStage("DOWNLOADING", 2);
        f5777c = modelFlowStage3;
        ModelFlowStage modelFlowStage4 = new ModelFlowStage("PAUSED", 3);
        f5778d = modelFlowStage4;
        ModelFlowStage modelFlowStage5 = new ModelFlowStage("DOWNLOAD_CONFIRM", 4);
        f5779e = modelFlowStage5;
        ModelFlowStage modelFlowStage6 = new ModelFlowStage("DOWNLOAD_CELLULAR_CONFIRM", 5);
        h = modelFlowStage6;
        ModelFlowStage modelFlowStage7 = new ModelFlowStage("UPDATE_CONFIRM", 6);
        f5780j = modelFlowStage7;
        ModelFlowStage modelFlowStage8 = new ModelFlowStage("UPDATE_CELLULAR_CONFIRM", 7);
        f5781k = modelFlowStage8;
        ModelFlowStage modelFlowStage9 = new ModelFlowStage("UPDATE_WIFI_GUIDE", 8);
        f5782l = modelFlowStage9;
        ModelFlowStage[] modelFlowStageArr = {modelFlowStage, modelFlowStage2, modelFlowStage3, modelFlowStage4, modelFlowStage5, modelFlowStage6, modelFlowStage7, modelFlowStage8, modelFlowStage9};
        f5783m = modelFlowStageArr;
        a.a(modelFlowStageArr);
    }

    public ModelFlowStage() {
        throw null;
    }

    public static ModelFlowStage valueOf(String str) {
        return (ModelFlowStage) Enum.valueOf(ModelFlowStage.class, str);
    }

    public static ModelFlowStage[] values() {
        return (ModelFlowStage[]) f5783m.clone();
    }
}
