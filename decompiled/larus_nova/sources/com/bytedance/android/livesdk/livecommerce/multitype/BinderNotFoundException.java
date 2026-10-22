package com.bytedance.android.livesdk.livecommerce.multitype;

/* JADX INFO: loaded from: classes10.dex */
class BinderNotFoundException extends RuntimeException {
    public BinderNotFoundException(Class<?> r100) {
        super("Do you have registered {className}.class to the binder in the adapter/pool?".replace("{className}", r100.getSimpleName()));
    }
}
