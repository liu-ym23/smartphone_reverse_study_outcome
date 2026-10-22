package com.bytedance.apm.listener;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IStorageCheckListener {
    void onDetectException(long r10, long r11, @Nullable List<String> r12, @Nullable List<String> r13, @Nullable List<String> r14);
}
