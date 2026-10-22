package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.api.internal.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC1642h {
    void a(String str, LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T b(String str, Class<T> cls);

    Activity i();

    void startActivityForResult(Intent intent, int i10);
}
