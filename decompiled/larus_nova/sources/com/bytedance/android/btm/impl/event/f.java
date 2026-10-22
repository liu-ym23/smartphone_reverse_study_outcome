package com.bytedance.android.btm.impl.event;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f42153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f42154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f42155d;

    public f() {
        this(0);
    }

    public /* synthetic */ f(int r100) {
        this(0, new JSONObject(), MapsKt.emptyMap(), SetsKt.emptySet());
    }

    public f(int r100, JSONObject r101, Map<String, String> r102, Set<String> r103) {
        this.f42152a = r100;
        this.f42153b = r101;
        this.f42154c = r102;
        this.f42155d = r103;
    }
}
