package aw4;

import io.reactivex.Flowable;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public interface a {
    void a(String r100, Serializable r101);

    Flowable<Boolean> clearCache();

    <T extends Serializable> T get(String r100) throws IOException;

    Flowable<Long> getCacheSize();
}
