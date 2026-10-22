package com.obric.agent.permission;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ICallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ICallback<T> {

    /* JADX INFO: compiled from: ICallback.kt */
    public static final class a {
        public static <T> void a(ICallback<T> r1, int r2) {
            ICallback r3 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r1, ICallback.class, "com.obric.aiagent.plugin");
        }

        public static <T> void a(ICallback<T> r1, T r2) {
            ICallback r3 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r1, ICallback.class, "com.obric.aiagent.plugin");
        }
    }

    void onFailure(int r1);

    void onSuccess(T r1);
}
