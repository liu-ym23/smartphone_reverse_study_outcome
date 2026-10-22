package com.bytedance.android.ec.core.arch.state;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/arch/state/b;", ExifInterface.LATITUDE_SOUTH, "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/core/arch/state/b;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class StateRepository$awaitState$2<S> extends FunctionReferenceImpl implements Function1<S, Boolean> {
    public StateRepository$awaitState$2(CompletableDeferred r100) {
        super(1, r100, CompletableDeferred.class, BitableAnalytic.SelectSceneClickType.COMPLETE, "complete(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)Z */
    public final boolean invoke(b r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return ((CompletableDeferred) this.receiver).complete(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return Boolean.valueOf(invoke((b) r100));
    }
}
