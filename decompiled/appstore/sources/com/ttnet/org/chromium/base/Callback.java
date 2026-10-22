package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface Callback<T> {

    public static abstract class Helper {
        @CalledByNative("Helper")
        public static void onBooleanResultFromNative(Callback r10, boolean r11) {
            r10.onResult(Boolean.valueOf(r11));
        }

        @CalledByNative("Helper")
        public static void onIntResultFromNative(Callback r10, int r11) {
            r10.onResult(Integer.valueOf(r11));
        }

        @CalledByNative("Helper")
        public static void onObjectResultFromNative(Callback r10, Object r11) {
            r10.onResult(r11);
        }

        @CalledByNative("Helper")
        public static void runRunnable(Runnable r10) {
            r10.run();
        }
    }

    static /* synthetic */ void a(Callback r10, Object r11) {
        r10.lambda$bind$0(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default void lambda$bind$0(Object r10) {
        onResult(r10);
    }

    default Runnable bind(final T r10) {
        return new d(this, r10);
    }

    void onResult(T r10);
}
