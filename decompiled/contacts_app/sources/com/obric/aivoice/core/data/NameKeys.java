package com.obric.aivoice.core.data;

import kotlin.Metadata;

/* JADX INFO: compiled from: NameKeys.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aivoice/core/data/NameKeys;", "", "()V", "LoadStrategy_Always", "", "LoadStrategy_Persist", "LoadStrategy_Use", "ModelType_Cloud", "ModelType_ImgEmbedding", "ModelType_Ort", "ModelType_SlmService", "ModelType_TextEmbedding", "UnloadStrategy_Dispose_After_Execute", "UnloadStrategy_No_Strategy", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NameKeys {
    public static final NameKeys INSTANCE = null;
    public static final String LoadStrategy_Always = "always";
    public static final String LoadStrategy_Persist = "persist";
    public static final String LoadStrategy_Use = "use";
    public static final String ModelType_Cloud = "Cloud";
    public static final String ModelType_ImgEmbedding = "ImgEmbedding";
    public static final String ModelType_Ort = "Ort";
    public static final String ModelType_SlmService = "Slm";
    public static final String ModelType_TextEmbedding = "TextEmbedding";
    public static final String UnloadStrategy_Dispose_After_Execute = "dispose_now";
    public static final String UnloadStrategy_No_Strategy = "";

    static {
        INSTANCE = new NameKeys();
    }

    private NameKeys() {
    }
}
