package com.stepos.config.dag.cloud;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface CloudConfigSource {

    public interface Callback {
        CloudConfigResult apply(String str, InputStream inputStream);
    }

    void subscribe(String str, Callback callback);

    void unsubscribe(String str);
}
