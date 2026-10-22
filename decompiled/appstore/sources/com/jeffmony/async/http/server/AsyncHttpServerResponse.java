package com.jeffmony.async.http.server;

import com.jeffmony.async.AsyncSocket;
import com.jeffmony.async.DataSink;
import com.jeffmony.async.b;
import com.jeffmony.async.callback.CompletedCallback;
import com.jeffmony.async.http.AsyncHttpResponse;
import com.jeffmony.async.http.Headers;
import com.jeffmony.async.parser.AsyncParser;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface AsyncHttpServerResponse extends DataSink, CompletedCallback {
    int code();

    AsyncHttpServerResponse code(int r10);

    @Override // com.jeffmony.async.DataSink
    void end();

    Headers getHeaders();

    String getHttpVersion();

    AsyncHttpServerRequest getRequest();

    AsyncSocket getSocket();

    @Override // com.jeffmony.async.callback.CompletedCallback
    void onCompleted(Exception r10);

    void proxy(AsyncHttpResponse r10);

    void redirect(String r10);

    void send(String r10);

    void send(String r10, b r11);

    void send(String r10, String r11);

    void send(String r10, ByteBuffer r11);

    void send(String r10, byte[] r11);

    void send(JSONArray r10);

    void send(JSONObject r10);

    <T> void sendBody(AsyncParser<T> r10, T r11);

    void sendFile(File r10);

    void sendStream(InputStream r10, long r11);

    void setContentType(String r10);

    void setHttpVersion(String r10);

    void setSocket(AsyncSocket r10);

    void writeHead();
}
