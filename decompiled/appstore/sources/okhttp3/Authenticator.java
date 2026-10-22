package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Authenticator {
    public static final Authenticator NONE = null;

    public static class a implements Authenticator {
        public a() {
        }

        @Override // okhttp3.Authenticator
        public Request authenticate(Route r10, Response r11) {
            return null;
        }
    }

    static {
        NONE = new a();
    }

    @Nullable
    Request authenticate(Route r10, Response r11) throws IOException;
}
