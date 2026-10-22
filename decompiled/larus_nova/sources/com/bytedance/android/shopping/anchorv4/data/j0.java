package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import java.util.Comparator;

/* JADX INFO: loaded from: classes12.dex */
public final class j0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f166448a = null;

    static {
        f166448a = new j0();
    }

    public j0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return com.bytedance.android.shopping.extensions.k.g(((PackResponseDTO) r100).getChunkIndex(), 0) - com.bytedance.android.shopping.extensions.k.g(((PackResponseDTO) r101).getChunkIndex(), 0);
    }
}
