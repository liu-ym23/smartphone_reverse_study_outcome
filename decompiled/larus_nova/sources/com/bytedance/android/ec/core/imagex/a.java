package com.bytedance.android.ec.core.imagex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f44530d;

    public a(String r100, String r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "cleanUrl");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        Intrinsics.checkNotNullParameter(r103, "extraMap");
        this.f44527a = r100;
        this.f44528b = r101;
        this.f44529c = r102;
        this.f44530d = r103;
    }
}
