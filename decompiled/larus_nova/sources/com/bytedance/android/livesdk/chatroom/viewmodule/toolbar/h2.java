package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class h2 {

    public static final class a extends h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f116319a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h2
        public final int a() {
            return this.f116319a;
        }

        public a(int r100) {
            this.f116319a = r100;
        }
    }

    public static final class b extends h2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Integer> f116320a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h2
        public final int a() {
            return this.f116320a.invoke().intValue();
        }

        public b(Function0<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "eval");
            this.f116320a = r100;
        }
    }

    public h2() {
    }

    public int a() {
        return 0;
    }
}
