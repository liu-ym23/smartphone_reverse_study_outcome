package com.obric.oui.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/utils/KtExt;", "", "()V", "safeCastTo", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Ljava/lang/Object;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KtExt {
    public static final KtExt INSTANCE = null;

    static {
        INSTANCE = new KtExt();
    }

    private KtExt() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T safeCastTo(Object r3) {
        if (r3 != 0) goto L5;
        return null;
    L5:
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r3 instanceof Object) == false) goto L9;
        return r3;
    L9:
        return null;
    }
}
