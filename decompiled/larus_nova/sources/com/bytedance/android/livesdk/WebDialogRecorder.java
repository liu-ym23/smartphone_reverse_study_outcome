package com.bytedance.android.livesdk;

import java.util.HashSet;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes7.dex */
public final class WebDialogRecorder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f102978c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<String> f102979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f102980b;

    public static final class a {
    }

    static {
        f102978c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WebDialogRecorder$Companion$INSTANCE$2.INSTANCE);
    }

    public WebDialogRecorder() {
        this.f102979a = new Stack();
        this.f102980b = new HashSet();
    }
}
