package com.zyql.ai.selector.listener;

import java.util.List;

/* loaded from: classes4.dex */
public interface OnResultCallbackListener<T> {
    void onCancel();

    void onResult(List<T> list);
}
