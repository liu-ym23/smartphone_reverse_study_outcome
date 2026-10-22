package okhttp3.logging;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"okhttp3/logging/HttpLoggingInterceptor$Level", "", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HttpLoggingInterceptor$Level {

    /* renamed from: a, reason: collision with root package name */
    public static final HttpLoggingInterceptor$Level f5476a;
    public static final HttpLoggingInterceptor$Level b;
    public static final HttpLoggingInterceptor$Level c;
    public static final /* synthetic */ HttpLoggingInterceptor$Level[] d;

    static {
        HttpLoggingInterceptor$Level httpLoggingInterceptor$Level = new HttpLoggingInterceptor$Level("NONE", 0);
        f5476a = httpLoggingInterceptor$Level;
        HttpLoggingInterceptor$Level httpLoggingInterceptor$Level2 = new HttpLoggingInterceptor$Level("BASIC", 1);
        HttpLoggingInterceptor$Level httpLoggingInterceptor$Level3 = new HttpLoggingInterceptor$Level("HEADERS", 2);
        b = httpLoggingInterceptor$Level3;
        HttpLoggingInterceptor$Level httpLoggingInterceptor$Level4 = new HttpLoggingInterceptor$Level("BODY", 3);
        c = httpLoggingInterceptor$Level4;
        d = new HttpLoggingInterceptor$Level[]{httpLoggingInterceptor$Level, httpLoggingInterceptor$Level2, httpLoggingInterceptor$Level3, httpLoggingInterceptor$Level4};
    }

    public static HttpLoggingInterceptor$Level valueOf(String str) {
        return (HttpLoggingInterceptor$Level) Enum.valueOf(HttpLoggingInterceptor$Level.class, str);
    }

    public static HttpLoggingInterceptor$Level[] values() {
        return (HttpLoggingInterceptor$Level[]) d.clone();
    }
}
