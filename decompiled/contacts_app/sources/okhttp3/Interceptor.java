package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        Response proceed(Request r1) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int r1, TimeUnit r2);

        Chain withReadTimeout(int r1, TimeUnit r2);

        Chain withWriteTimeout(int r1, TimeUnit r2);

        int writeTimeoutMillis();
    }

    Response intercept(Chain r1) throws IOException;
}
