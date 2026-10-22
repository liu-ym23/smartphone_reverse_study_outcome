package com.obric.cloudsdk.utils;

import androidx.exifinterface.media.ExifInterface;
import com.obric.cloudsdk.kv.base.KvLog;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u0004\u0018\u0001H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/cloudsdk/utils/KtExt;", "", "()V", "TAG", "", "safeExecute", ExifInterface.GPS_DIRECTION_TRUE, CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeCastTo", "(Ljava/lang/Object;)Ljava/lang/Object;", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KtExt {
    public static final KtExt INSTANCE = null;
    private static final String TAG = "KtExt";

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

    public final <T> T safeExecute(Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        return r3.invoke();
    L5:
        e = move-exception;
        KvLog.INSTANCE.e(TAG, "safeExecute failed", e);
        return null;
    }
}
