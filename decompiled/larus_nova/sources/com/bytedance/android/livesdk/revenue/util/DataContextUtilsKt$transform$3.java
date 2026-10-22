package com.bytedance.android.livesdk.revenue.util;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T, U] */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "U", ExifInterface.GPS_DIRECTION_TRUE, "", "p1", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DataContextUtilsKt$transform$3<T, U> extends FunctionReferenceImpl implements Function1<T, U> {
    public DataContextUtilsKt$transform$3(c r100) {
        super(1, r100, c.class, "transform", "transform(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final U invoke(T r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return (U) ((c) this.receiver).transform(r100);
    }
}
