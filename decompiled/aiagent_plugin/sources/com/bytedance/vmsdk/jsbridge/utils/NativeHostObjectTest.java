package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes.dex */
public class NativeHostObjectTest implements NativeHostObject {
    native long nativeGetHostObject(long r1);

    public NativeHostObjectTest() {
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.NativeHostObject
    public long getPtr(long r1) {
        return nativeGetHostObject(r1);
    }
}
