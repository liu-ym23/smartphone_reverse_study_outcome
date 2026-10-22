package com.bytedance.android.annie.service.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.preload.PreloadSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface e extends com.bytedance.android.annie.service.a {
    int A1(String r100, boolean r101, String r102, String r103, IHybridComponent.HybridType r104, boolean r105);

    boolean D1(String r100);

    boolean F0(String r100);

    d b1(String r100, String r101);

    void h(String r100);

    boolean l(String r100);

    int m(String r100, JSONObject r101, @PreloadSource String r102, String r103, String r104, IHybridComponent.HybridType r105, String r106, boolean r107);

    h o0(String r100, RequestConfig r101);

    String t1(String r100);

    h x(String r100, RequestConfig r101, Function1<? super i, Unit> r102);
}
