package l7;

/* loaded from: classes3.dex */
public final class c {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        ((c) obj).getClass();
        return Float.compare(1.5f, 1.5f) == 0;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + androidx.appfunctions.metadata.a.b(1.5f, androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Integer.hashCode(3) * 31, 31, 1000L), 31, 10000L), 31);
    }

    public final String toString() {
        return "RetryConfig(maxRetryCount=3, initialDelayMs=1000, maxDelayMs=10000, backoffMultiplier=1.5, retryOnDisconnect=true)";
    }
}
