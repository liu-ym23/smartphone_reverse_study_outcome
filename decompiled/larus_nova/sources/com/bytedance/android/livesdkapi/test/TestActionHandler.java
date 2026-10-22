package com.bytedance.android.livesdkapi.test;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/test/TestActionHandler;", "", "canHandle", "", "params", "Landroid/os/Bundle;", "handle", "", "callback", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/test/HandleResult;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface TestActionHandler {
    boolean canHandle(Bundle r100);

    void handle(Bundle r100, Function1<? super HandleResult, Unit> r101);
}
