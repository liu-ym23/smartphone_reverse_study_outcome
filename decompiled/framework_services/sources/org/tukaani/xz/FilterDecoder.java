package org.tukaani.xz;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
interface FilterDecoder extends FilterCoder {
    InputStream getInputStream(InputStream r1, ArrayCache r2);

    int getMemoryUsage();
}
