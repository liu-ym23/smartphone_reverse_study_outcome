package com.bytedance.android.livesdk.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/widget/Break;", "", "msg", "", "(Ljava/lang/String;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
final class Break extends Throwable {
    public Break(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super(r100);
    }
}
