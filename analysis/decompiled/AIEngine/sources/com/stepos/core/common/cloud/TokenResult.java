package com.stepos.core.common.cloud;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface TokenResult {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotLoggedIn implements TokenResult {
        public static final NotLoggedIn INSTANCE = new NotLoggedIn();

        private NotLoggedIn() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Ok implements TokenResult {
        private final String token;

        public Ok(String token) {
            kotlin.jvm.internal.g.f(token, "token");
            this.token = token;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = ok.token;
            }
            return ok.copy(str);
        }

        public final String component1() {
            return this.token;
        }

        public final Ok copy(String token) {
            kotlin.jvm.internal.g.f(token, "token");
            return new Ok(token);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ok) && kotlin.jvm.internal.g.b(this.token, ((Ok) obj).token);
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        public String toString() {
            return a0.a.k("Ok(token=", this.token, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TransientFailure implements TokenResult {
        public static final TransientFailure INSTANCE = new TransientFailure();

        private TransientFailure() {
        }
    }
}
