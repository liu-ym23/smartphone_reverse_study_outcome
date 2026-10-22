package com.bytedance.android.annie.service.network;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxError;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class DefaultAnnieNetworkService implements IAnnieNetworkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f39889a;

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final InputStream doPost(String r100, String r101, Map<String, String> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "contentType");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, "params");
        return null;
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final String getHostDomain() {
        return "";
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final String getNetworkAccessType() {
        return "";
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final void handleFetchError(View r100, String r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final void handleStatusCodeInterception(JsonObject r100, Context r101) {
    }

    public final c<d> H1() {
        return (c) this.f39889a.getValue();
    }

    public DefaultAnnieNetworkService() {
        this.f39889a = LazyKt.lazy(DefaultAnnieNetworkService$emptyCall$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final Map<String, String> getCommonParams() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> get(String r100, List<Pair<String, String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> get(String r100, List<Pair<String, String>> r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> post(String r100, List<Pair<String, String>> r101, String r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "headers");
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> downloadFile(boolean r100, int r101, String r102, List<Pair<String, String>> r103, Object r104) {
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "headers");
        Intrinsics.checkNotNullParameter(r104, "extraInfo");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> downloadFileStreaming(boolean r100, int r101, String r102, List<Pair<String, String>> r103, Object r104) {
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "headers");
        Intrinsics.checkNotNullParameter(r104, "extraInfo");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> post(String r100, List<Pair<String, String>> r101, String r102, byte[] r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return H1();
    }

    @Override // com.bytedance.android.annie.service.network.IAnnieNetworkService
    public final c<d> uploadFile(int r100, String r101, List<Pair<String, String>> r102, String r103, byte[] r104, long r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, "mediaType");
        Intrinsics.checkNotNullParameter(r104, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r106, "md5Stub");
        return H1();
    }
}
