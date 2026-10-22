package com.jeffmony.async.http.server;

import com.jeffmony.async.AsyncSocket;
import com.jeffmony.async.DataEmitter;
import com.jeffmony.async.http.Headers;
import com.jeffmony.async.http.Multimap;
import com.jeffmony.async.http.body.AsyncHttpRequestBody;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpServerRequest extends DataEmitter {
    String get(String r10);

    <T extends AsyncHttpRequestBody> T getBody();

    Headers getHeaders();

    Matcher getMatcher();

    String getMethod();

    String getPath();

    Multimap getQuery();

    AsyncSocket getSocket();

    Map<String, Object> getState();

    String getUrl();

    void setMatcher(Matcher r10);
}
