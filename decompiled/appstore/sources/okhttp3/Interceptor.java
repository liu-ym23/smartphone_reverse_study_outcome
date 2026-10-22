package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        Response proceed(Request r10) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int r10, TimeUnit r11);

        Chain withReadTimeout(int r10, TimeUnit r11);

        Chain withWriteTimeout(int r10, TimeUnit r11);

        int writeTimeoutMillis();
    }

    Response intercept(Chain r10) throws IOException;
}
