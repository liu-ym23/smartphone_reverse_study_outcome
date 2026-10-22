package com.stepos.core.deepbinder;

import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;

@Callback
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/core/deepbinder/IReleaseListener;", "", "", "modelId", "", "reasonCode", "message", "LY8/t;", "onReleased", "(Ljava/lang/String;ILjava/lang/String;)V", "onRecycle", "()V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IReleaseListener {
    void onRecycle();

    void onReleased(String modelId, int reasonCode, String message);
}
