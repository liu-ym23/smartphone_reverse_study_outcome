package com.bytedance.android.shopping.anchorv4.event_chain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b<EventFields> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f166546d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f166547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f166548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventFields f166549c;

    public static final class a {
        public static b a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return new b(false, r100, null);
        }

        public static b b(Object r100) {
            return new b(true, null, r100);
        }

        public static b c(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return new b(true, r100, r101);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r100, String r101, Object r102) {
        this.f166547a = r100;
        this.f166548b = r101;
        this.f166549c = r102;
    }
}
