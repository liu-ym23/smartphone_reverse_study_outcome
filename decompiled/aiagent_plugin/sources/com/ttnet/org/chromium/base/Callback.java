package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface Callback<T> {

    public static abstract class Helper {
        public Helper() {
        }

        static void onObjectResultFromNative(Callback r2, Object r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin")).a(r3);
        }

        static void onBooleanResultFromNative(Callback r2, boolean r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin")).a(Boolean.valueOf(r3));
        }

        static void onIntResultFromNative(Callback r2, int r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin")).a(Integer.valueOf(r3));
        }

        static void onLongResultFromNative(Callback r2, long r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r3));
        }

        static void onTimeResultFromNative(Callback r2, long r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r3));
        }

        static void runRunnable(Runnable r2) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin")).run();
        }
    }

    void a(T r1);
}
