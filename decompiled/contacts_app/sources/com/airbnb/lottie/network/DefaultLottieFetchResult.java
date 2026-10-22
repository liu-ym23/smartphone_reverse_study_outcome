package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {
    private final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection r1) {
        this.connection = r1;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        if ((this.connection.getResponseCode() / 100) != 2) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public InputStream bodyByteStream() throws IOException {
        return this.connection.getInputStream();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String contentType() {
        return this.connection.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String error() {
    L8:
        e = move-exception;
        Logger.warning("get error failed ", e);
        return e.getMessage();
    L4:
        if (isSuccessful() == true) goto L13;
        return "Unable to fetch " + this.connection.getURL() + ". Failed with " + this.connection.getResponseCode() + "\n" + getErrorFromConnection(this.connection);
    L13:
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.connection.disconnect();
    }

    private String getErrorFromConnection(HttpURLConnection r3) throws IOException {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r3.getErrorStream()));
        StringBuilder r4 = new StringBuilder();
    L19:
        String r0 = r2.readLine();     // Catch: Throwable -> L10
        if (r0 == null) goto L17;
        r4.append(r0).append('\n');     // Catch: Throwable -> L10
        goto L19
    L17:
        r2.close();     // Catch: Exception -> L13
    L9:
        return r4.toString();
    L10:
        th = move-exception;
        r2.close();     // Catch: Exception -> L14
    L12:
        throw th;
    }
}
