package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f153061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153062b;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return this.f153062b;
    }

    public a1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f153062b = r100;
        System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        r101.put("type", r100);
        Unit r102 = Unit.INSTANCE;
        this.f153061a = r101;
    }
}
