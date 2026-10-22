package com.zyql.ai.selector.compress;

import com.zyql.ai.selector.entity.LocalMedia;
import java.util.List;

/* loaded from: classes4.dex */
public interface OnCompressListener {
    void onError(Throwable th);

    void onStart();

    void onSuccess(List<LocalMedia> list);
}
