package com.bytedance.android.live.browser.schema.core.strategy;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64219b;

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        throw new IllegalStateException(("illegal rule for " + this.f64219b).toString());
    }

    public b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        super(r100);
        this.f64219b = r101;
    }
}
