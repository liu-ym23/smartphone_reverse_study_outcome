package com.zyql.ai.selector.compress;

import com.zyql.ai.selector.entity.LocalMedia;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public interface InputStreamProvider {
    void close();

    LocalMedia getMedia();

    String getPath();

    InputStream open() throws IOException;
}
