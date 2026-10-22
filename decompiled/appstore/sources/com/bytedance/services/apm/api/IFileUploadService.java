package com.bytedance.services.apm.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IFileUploadService {
    void uploadFiles(@NonNull String r10, @NonNull String r11, @NonNull String r12, @NonNull List<String> r13, @NonNull String r14, @Nullable JSONObject r15, @Nullable IFileUploadCallback r16);
}
