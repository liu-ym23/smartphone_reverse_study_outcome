package com.bytedance.android.latch.prefetch.internal;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f58450d;

    public a() {
        throw null;
    }

    public a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        String r100 = r110.optString("source");
        String r101 = r110.optString("key");
        String r102 = r110.optString(OnekeyLoginConstants.CU_KEY_OPERATOR);
        JSONArray r111 = r110.optJSONArray("values");
        if (r111 != null) goto L5;
        List<Object> r112 = CollectionsKt.emptyList();
    L9:
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, OnekeyLoginConstants.CU_KEY_OPERATOR);
        Intrinsics.checkNotNullParameter(r112, "values");
        this.f58447a = r100;
        this.f58448b = r101;
        this.f58449c = r102;
        this.f58450d = r112;
        return;
    L5:
        ArrayList r103 = new ArrayList();
        int r104 = r111.length();
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103.add(r111.get(r105));
        r105 = r105 + 1;
        goto L6
    L8:
        r112 = r103;
        goto L9
    }
}
