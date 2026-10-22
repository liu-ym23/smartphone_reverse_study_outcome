package com.bytedance.android.ec.adapter.api.state;

import android.os.Bundle;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f42712e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f42714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f42715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f42716d;

    public static final class a {
    }

    static {
    }

    public c(String r100, String r101, String r102, String r103, Function0 r104, Map r105, Bundle r106) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "secUid");
        Intrinsics.checkNotNullParameter(r102, "clientKey");
        Intrinsics.checkNotNullParameter(r103, "appName");
        Intrinsics.checkNotNullParameter(r104, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r105, "reportParams");
        Intrinsics.checkNotNullParameter(r106, "extra");
        this.f42713a = r100;
        this.f42714b = r104;
        this.f42715c = r105;
        this.f42716d = r106;
    }
}
