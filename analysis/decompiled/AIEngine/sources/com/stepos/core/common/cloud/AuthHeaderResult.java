package com.stepos.core.common.cloud;

import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface AuthHeaderResult {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NotLoggedIn implements AuthHeaderResult {
        public static final NotLoggedIn INSTANCE = new NotLoggedIn();

        private NotLoggedIn() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Ready implements AuthHeaderResult {
        private final Map<String, String> headers;

        public Ready(Map<String, String> headers) {
            kotlin.jvm.internal.g.f(headers, "headers");
            this.headers = headers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ready copy$default(Ready ready, Map map, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                map = ready.headers;
            }
            return ready.copy(map);
        }

        public final Map<String, String> component1() {
            return this.headers;
        }

        public final Ready copy(Map<String, String> headers) {
            kotlin.jvm.internal.g.f(headers, "headers");
            return new Ready(headers);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ready) && kotlin.jvm.internal.g.b(this.headers, ((Ready) obj).headers);
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public int hashCode() {
            return this.headers.hashCode();
        }

        public String toString() {
            return "Ready(headers=" + this.headers + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TransientFailure implements AuthHeaderResult {
        public static final TransientFailure INSTANCE = new TransientFailure();

        private TransientFailure() {
        }
    }
}
