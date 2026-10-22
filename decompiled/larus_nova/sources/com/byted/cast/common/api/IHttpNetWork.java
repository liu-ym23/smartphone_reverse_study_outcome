package com.byted.cast.common.api;

import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public interface IHttpNetWork {
    Response doGet(String r100, Map<String, String> r101) throws Exception;

    Response doPost(String r100, String r101, Map<String, String> r102) throws Exception;
}
