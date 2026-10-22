package com.stepos.policy.sdk.util;

import android.content.ClipboardManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ ClipboardManager f2801a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2802b;

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return ReadClipboardUtils.lambda$injectClipboardManager$0(this.f2801a, this.f2802b, obj, method, objArr);
    }
}
