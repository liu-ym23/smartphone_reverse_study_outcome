package com.bytedance.android.livesdkapi.service.gamecp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/OrientationType;", "", "()V", "HORIZONTAL", "", "getHORIZONTAL", "()I", "setHORIZONTAL", "(I)V", "VERTICAL", "getVERTICAL", "setVERTICAL", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrientationType {
    private static int HORIZONTAL;
    public static final OrientationType INSTANCE = null;
    private static int VERTICAL;

    private OrientationType() {
    }

    static {
        INSTANCE = new OrientationType();
        VERTICAL = 1;
        HORIZONTAL = 2;
    }

    public final int getHORIZONTAL() {
        return HORIZONTAL;
    }

    public final int getVERTICAL() {
        return VERTICAL;
    }

    public final void setHORIZONTAL(int r100) {
        HORIZONTAL = r100;
    }

    public final void setVERTICAL(int r100) {
        VERTICAL = r100;
    }
}
