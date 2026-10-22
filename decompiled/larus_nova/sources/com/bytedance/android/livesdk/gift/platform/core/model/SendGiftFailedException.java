package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftFailedException;", "Ljava/lang/Exception;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/y$c$a;", "type", "Lcom/bytedance/android/livesdk/gift/platform/core/model/y$c$a;", "getType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/y$c$a;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/core/model/y$c$a;Ljava/lang/String;)V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendGiftFailedException extends Exception {
    private final String message;
    private final y.c.a type;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final y.c.a getType() {
        return this.type;
    }

    public SendGiftFailedException(y.c.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.message = r101;
    }
}
