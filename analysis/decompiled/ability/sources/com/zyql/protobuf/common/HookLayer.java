package com.zyql.protobuf.common;

import com.google.protobuf.InterfaceC0974o1;

/* loaded from: classes2.dex */
public enum HookLayer implements InterfaceC0974o1 {
    HOOK_LAYER_UNSPECIFIED(0),
    HOOK_LAYER_APP(1),
    HOOK_LAYER_AGENT(2),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f4258a;

    HookLayer(int i) {
        this.f4258a = i;
    }

    public static HookLayer a(int i) {
        if (i == 0) {
            return HOOK_LAYER_UNSPECIFIED;
        }
        if (i == 1) {
            return HOOK_LAYER_APP;
        }
        if (i != 2) {
            return null;
        }
        return HOOK_LAYER_AGENT;
    }

    @Override // com.google.protobuf.InterfaceC0974o1
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f4258a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
