package com.bytedance.android.shopping.anchorv4.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f166534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f166535b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, Function1<? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f166534a = r100;
        this.f166535b = r101;
    }
}
