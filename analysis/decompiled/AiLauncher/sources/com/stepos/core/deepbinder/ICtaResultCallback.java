package com.stepos.core.deepbinder;

import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;

@Callback
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/core/deepbinder/ICtaResultCallback;", "", "", "granted", "LY8/t;", "onResult", "(Z)V", "onRecycle", "()V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICtaResultCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onRecycle(ICtaResultCallback iCtaResultCallback) {
        }
    }

    void onRecycle();

    void onResult(boolean granted);
}
