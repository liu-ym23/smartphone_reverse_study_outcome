package com.ss.android.http.legacy;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
