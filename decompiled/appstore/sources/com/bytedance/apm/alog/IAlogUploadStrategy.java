package com.bytedance.apm.alog;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAlogUploadStrategy {
    List<String> getUploadAlogFiles(Context r10, String r11, long r12, long r13);
}
