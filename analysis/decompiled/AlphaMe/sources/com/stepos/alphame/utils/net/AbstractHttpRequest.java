package com.stepos.alphame.utils.net;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractHttpRequest {

    public static abstract class AbstractBuilder {
        public abstract AbstractBuilder addHeader(String str, String str2);

        public abstract AbstractHttpRequest build();

        public abstract AbstractBuilder cacheAge(long j4);

        public abstract AbstractBuilder headers(Map<String, String> map);

        public abstract AbstractBuilder method(String str);

        public abstract AbstractBuilder path(String str);

        public abstract AbstractBuilder path(String str, boolean z4);

        public abstract AbstractBuilder query(String str, String str2);

        public abstract AbstractBuilder query(String str, String str2, boolean z4);

        public abstract AbstractBuilder removeHeader(String str);

        public abstract AbstractBuilder requestBody(HttpRequestBody httpRequestBody);

        public abstract AbstractBuilder tag(Object obj);

        public abstract AbstractBuilder url(String str);
    }

    public abstract long cacheAge();

    public abstract void cancel();

    public abstract String getHeader(String str);

    public abstract Map<String, String> headers();

    public abstract String method();

    public abstract Object tag();

    public abstract String url();
}
