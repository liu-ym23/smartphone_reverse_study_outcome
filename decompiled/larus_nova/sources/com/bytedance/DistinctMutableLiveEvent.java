package com.bytedance;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.als.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/DistinctMutableLiveEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/als/h;", "value", "", "postValue", "(Ljava/lang/Object;)V", "setValue", "<init>", "()V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class DistinctMutableLiveEvent<T> extends h<T> {
    public DistinctMutableLiveEvent() {
    }

    @Override // com.bytedance.als.h, com.bytedance.als.f
    public void postValue(T r100) {
        if ((!Intrinsics.areEqual(getValue(), r100)) == false) goto L6;
        super.postValue(r100);
        return;
    }

    @Override // com.bytedance.als.h, com.bytedance.als.f
    public void setValue(T r100) {
        if ((!Intrinsics.areEqual(getValue(), r100)) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        super.setValue(r100);
        return;
    L7:
        super.postValue(r100);
    }
}
