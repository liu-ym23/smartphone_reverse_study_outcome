package com.android.ttcjpaysdk.base.ktextension;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/CJJsonValidResult;", "", "isValid", "", "value", "Lorg/json/JSONObject;", LynxError.LYNX_THROWABLE, "", "(ZLorg/json/JSONObject;Ljava/lang/Throwable;)V", "()Z", "getThrowable", "()Ljava/lang/Throwable;", "getValue", "()Lorg/json/JSONObject;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJJsonValidResult {
    private final boolean isValid;
    private final Throwable throwable;
    private final JSONObject value;

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final JSONObject getValue() {
        return this.value;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public CJJsonValidResult(boolean r100, JSONObject r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.isValid = r100;
        this.value = r101;
        this.throwable = r102;
    }

    public /* synthetic */ CJJsonValidResult(boolean r100, JSONObject r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
