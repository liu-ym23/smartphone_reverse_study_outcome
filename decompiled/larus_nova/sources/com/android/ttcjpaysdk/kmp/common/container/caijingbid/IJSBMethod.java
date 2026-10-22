package com.android.ttcjpaysdk.kmp.common.container.caijingbid;

import android.content.Context;
import com.android.ttcjpaysdk.kmp.common.container.PlatformObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\tH\u0017R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IJSBMethod;", "", "name", "", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/android/ttcjpaysdk/kmp/common/container/PlatformContext;", "params", "Lcom/android/ttcjpaysdk/kmp/common/container/PlatformObject;", "callback", "Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IPlatformJSBCallback;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/kmp/common/container/PlatformObject;Lcom/android/ttcjpaysdk/kmp/common/container/caijingbid/IPlatformJSBCallback;)V", "release", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IJSBMethod {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getName$annotations() {
        }

        public static void release(IJSBMethod r100) {
        }
    }

    String getName();

    void handle(Context r100, PlatformObject r101, IPlatformJSBCallback r102);

    void release();
}
