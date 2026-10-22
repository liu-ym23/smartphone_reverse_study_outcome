package okhttp3.internal;

import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Internal {
    public static Internal instance;

    public Internal() {
    }

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }

    public abstract void addLenient(Headers.Builder r10, String r11);

    public abstract void addLenient(Headers.Builder r10, String r11, String r12);

    public abstract void apply(ConnectionSpec r10, SSLSocket r11, boolean r12);

    public abstract int code(Response.Builder r10);

    public abstract boolean connectionBecameIdle(ConnectionPool r10, RealConnection r11);

    public abstract Socket deduplicate(ConnectionPool r10, Address r11, StreamAllocation r12);

    public abstract boolean equalsNonHost(Address r10, Address r11);

    public abstract RealConnection get(ConnectionPool r10, Address r11, StreamAllocation r12, Route r13);

    public abstract HttpUrl getHttpUrlChecked(String r10) throws MalformedURLException, UnknownHostException;

    public abstract Call newWebSocketCall(OkHttpClient r10, Request r11);

    public abstract void put(ConnectionPool r10, RealConnection r11);

    public abstract RouteDatabase routeDatabase(ConnectionPool r10);

    public abstract void setCache(OkHttpClient.Builder r10, InternalCache r11);

    public abstract StreamAllocation streamAllocation(Call r10);
}
