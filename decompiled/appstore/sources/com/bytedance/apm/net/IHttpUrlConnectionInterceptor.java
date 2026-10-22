package com.bytedance.apm.net;

import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(String r10) throws IOException;
}
