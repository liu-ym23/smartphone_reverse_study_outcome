package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: loaded from: classes5.dex */
public final class CacheControl {
    public static final CacheControl FORCE_CACHE = null;
    public static final CacheControl FORCE_NETWORK = null;

    @Nullable
    String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public static final class Builder {
        boolean immutable;
        int maxAgeSeconds;
        int maxStaleSeconds;
        int minFreshSeconds;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder maxAge(int r3, TimeUnit r4) {
            if (r3 < 0) goto L10;
            long r5 = r4.toSeconds(r3);
            if (r5 <= 2147483647L) goto L6;
            int r6 = Integer.MAX_VALUE;
        L7:
            this.maxAgeSeconds = r6;
            return this;
        L6:
            r6 = (int) r5;
            goto L7
        L10:
            throw new IllegalArgumentException("maxAge < 0: " + r3);
        }

        public Builder maxStale(int r3, TimeUnit r4) {
            if (r3 < 0) goto L10;
            long r5 = r4.toSeconds(r3);
            if (r5 <= 2147483647L) goto L6;
            int r6 = Integer.MAX_VALUE;
        L7:
            this.maxStaleSeconds = r6;
            return this;
        L6:
            r6 = (int) r5;
            goto L7
        L10:
            throw new IllegalArgumentException("maxStale < 0: " + r3);
        }

        public Builder minFresh(int r3, TimeUnit r4) {
            if (r3 < 0) goto L10;
            long r5 = r4.toSeconds(r3);
            if (r5 <= 2147483647L) goto L6;
            int r6 = Integer.MAX_VALUE;
        L7:
            this.minFreshSeconds = r6;
            return this;
        L6:
            r6 = (int) r5;
            goto L7
        L10:
            throw new IllegalArgumentException("minFresh < 0: " + r3);
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder immutable() {
            this.immutable = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }
    }

    static {
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, @Nullable String r13) {
        this.noCache = r1;
        this.noStore = r2;
        this.maxAgeSeconds = r3;
        this.sMaxAgeSeconds = r4;
        this.isPrivate = r5;
        this.isPublic = r6;
        this.mustRevalidate = r7;
        this.maxStaleSeconds = r8;
        this.minFreshSeconds = r9;
        this.onlyIfCached = r10;
        this.noTransform = r11;
        this.immutable = r12;
        this.headerValue = r13;
    }

    CacheControl(Builder r2) {
        this.noCache = r2.noCache;
        this.noStore = r2.noStore;
        this.maxAgeSeconds = r2.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = r2.maxStaleSeconds;
        this.minFreshSeconds = r2.minFreshSeconds;
        this.onlyIfCached = r2.onlyIfCached;
        this.noTransform = r2.noTransform;
        this.immutable = r2.immutable;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean immutable() {
        return this.immutable;
    }

    public static CacheControl parse(Headers r22) {
        int r1 = r22.size();
        int r6 = 0;
        boolean r7 = true;
        String r8 = null;
        boolean r9 = false;
        boolean r10 = false;
        int r11 = -1;
        int r12 = -1;
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = -1;
        int r17 = -1;
        boolean r18 = false;
        boolean r19 = false;
        boolean r20 = false;
    L3:
        if (r6 >= r1) goto L67;
        String r2 = r22.name(r6);
        String r5 = r22.value(r6);
        if (r2.equalsIgnoreCase("Cache-Control") == false) goto L10;
        if (r8 != null) goto L11;
        r8 = r5;
    L12:
        int r3 = 0;
    L14:
        if (r3 >= r5.length()) goto L66;
        int r4 = HttpHeaders.skipUntil(r5, r3, "=,;");
        String r21 = r5.substring(r3, r4).trim();
        if (r4 != r5.length()) goto L18;
    L28:
        int r23 = r4 + 1;
        String r0 = null;
    L30:
        if ("no-cache".equalsIgnoreCase(r21) == false) goto L33;
        r9 = true;
    L65:
        r3 = r23;
        goto L14
    L33:
        if ("no-store".equalsIgnoreCase(r21) == false) goto L36;
        r10 = true;
        goto L65
    L36:
        if ("max-age".equalsIgnoreCase(r21) == false) goto L39;
        r11 = HttpHeaders.parseSeconds(r0, -1);
        goto L65
    L39:
        if ("s-maxage".equalsIgnoreCase(r21) == false) goto L42;
        r12 = HttpHeaders.parseSeconds(r0, -1);
        goto L65
    L42:
        if ("private".equalsIgnoreCase(r21) == false) goto L45;
        r13 = true;
        goto L65
    L45:
        if ("public".equalsIgnoreCase(r21) == false) goto L48;
        r14 = true;
        goto L65
    L48:
        if ("must-revalidate".equalsIgnoreCase(r21) == false) goto L51;
        r15 = true;
        goto L65
    L51:
        if ("max-stale".equalsIgnoreCase(r21) == false) goto L54;
        r16 = HttpHeaders.parseSeconds(r0, Integer.MAX_VALUE);
        goto L65
    L54:
        if ("min-fresh".equalsIgnoreCase(r21) == false) goto L57;
        r17 = HttpHeaders.parseSeconds(r0, -1);
        goto L65
    L57:
        if ("only-if-cached".equalsIgnoreCase(r21) == false) goto L60;
        r18 = true;
        goto L65
    L60:
        if ("no-transform".equalsIgnoreCase(r21) == false) goto L63;
        r19 = true;
        goto L65
    L63:
        if ("immutable".equalsIgnoreCase(r21) == false) goto L65;
        r20 = true;
        goto L65
    L18:
        if (r5.charAt(r4) == ',') goto L28;
        if (r5.charAt(r4) == ';') goto L28;
        int r24 = HttpHeaders.skipWhitespace(r5, r4 + 1);
        if (r24 < r5.length()) goto L25;
    L27:
        r23 = HttpHeaders.skipUntil(r5, r24, ",;");
        r0 = r5.substring(r24, r23).trim();
        goto L30
    L25:
        if (r5.charAt(r24) != '\"') goto L27;
        int r25 = r24 + 1;
        int r26 = HttpHeaders.skipUntil(r5, r25, "\"");
        r0 = r5.substring(r25, r26);
        r23 = r26 + 1;
    L66:
        r6 = r6 + 1;
    L11:
        r7 = false;
        goto L12
    L10:
        if (r2.equalsIgnoreCase(com.google.common.net.HttpHeaders.PRAGMA) == false) goto L66;
    L67:
        if (r7 == true) goto L69;
        String r27 = null;
    L71:
        return new CacheControl(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r27);
    L69:
        r27 = r8;
        goto L71
    }

    public String toString() {
        String r0 = this.headerValue;
        if (r0 != null) goto L7;
        String r1 = headerValue();
        this.headerValue = r1;
        return r1;
    L7:
        return r0;
    }

    private String headerValue() {
        StringBuilder r0 = new StringBuilder();
        if (this.noCache == false) goto L6;
        r0.append("no-cache, ");
    L6:
        if (this.noStore == false) goto L9;
        r0.append("no-store, ");
    L9:
        if (this.maxAgeSeconds == (-1)) goto L12;
        r0.append("max-age=").append(this.maxAgeSeconds).append(", ");
    L12:
        if (this.sMaxAgeSeconds == (-1)) goto L15;
        r0.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
    L15:
        if (this.isPrivate == false) goto L18;
        r0.append("private, ");
    L18:
        if (this.isPublic == false) goto L21;
        r0.append("public, ");
    L21:
        if (this.mustRevalidate == false) goto L24;
        r0.append("must-revalidate, ");
    L24:
        if (this.maxStaleSeconds == (-1)) goto L27;
        r0.append("max-stale=").append(this.maxStaleSeconds).append(", ");
    L27:
        if (this.minFreshSeconds == (-1)) goto L30;
        r0.append("min-fresh=").append(this.minFreshSeconds).append(", ");
    L30:
        if (this.onlyIfCached == false) goto L33;
        r0.append("only-if-cached, ");
    L33:
        if (this.noTransform == false) goto L36;
        r0.append("no-transform, ");
    L36:
        if (this.immutable == false) goto L39;
        r0.append("immutable, ");
    L39:
        if (r0.length() != 0) goto L42;
        return "";
    L42:
        r0.delete(r0.length() - 2, r0.length());
        return r0.toString();
    }
}
