package com.bytedance.android.annie.service.network;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public interface IAnnieNetworkService extends com.bytedance.android.annie.service.a {
    InputStream doPost(String r100, String r101, Map<String, String> r102, Map<String, Object> r103);

    c<d> downloadFile(boolean r100, int r101, String r102, List<Pair<String, String>> r103, Object r104) throws IOException;

    c<d> downloadFileStreaming(boolean r100, int r101, String r102, List<Pair<String, String>> r103, Object r104) throws IOException;

    c<d> get(String r100, List<Pair<String, String>> r101) throws IOException;

    c<d> get(String r100, List<Pair<String, String>> r101, Boolean r102) throws IOException;

    Map<String, String> getCommonParams();

    String getHostDomain();

    String getNetworkAccessType();

    void handleFetchError(View r100, String r101, String r102, Throwable r103);

    void handleStatusCodeInterception(JsonObject r100, Context r101);

    c<d> post(String r100, List<Pair<String, String>> r101, String r102, byte[] r103) throws IOException;

    c<d> post(String r100, List<Pair<String, String>> r101, String r102, byte[] r103, Boolean r104) throws IOException;

    c<d> uploadFile(int r100, String r101, List<Pair<String, String>> r102, String r103, byte[] r104, long r105, String r106) throws IOException;
}
