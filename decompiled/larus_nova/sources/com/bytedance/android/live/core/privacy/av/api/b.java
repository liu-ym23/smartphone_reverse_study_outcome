package com.bytedance.android.live.core.privacy.av.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65134a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1072a f65135a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f65136b = null;

        /* JADX INFO: renamed from: com.bytedance.android.live.core.privacy.av.api.b$a$a, reason: collision with other inner class name */
        public static final class C1072a implements b {
            public C1072a() {
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void a(String r100, String r101, String r102, Map r103, com.bytedance.android.live.core.privacy.av.api.a r104, AudioAndVideoException r105) {
                Intrinsics.checkNotNullParameter(r100, "biz");
                Intrinsics.checkNotNullParameter(r101, "sense");
                Intrinsics.checkNotNullParameter(r102, "type");
                Intrinsics.checkNotNullParameter(r103, "params");
                Intrinsics.checkNotNullParameter(r104, "config");
                Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void b(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
                Intrinsics.checkNotNullParameter(r100, "biz");
                Intrinsics.checkNotNullParameter(r101, "sense");
                Intrinsics.checkNotNullParameter(r102, "type");
                Intrinsics.checkNotNullParameter(r103, "params");
                Intrinsics.checkNotNullParameter(r104, "config");
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void c(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
                Intrinsics.checkNotNullParameter(r100, "biz");
                Intrinsics.checkNotNullParameter(r101, "sense");
                Intrinsics.checkNotNullParameter(r102, "type");
                Intrinsics.checkNotNullParameter(r103, "params");
                Intrinsics.checkNotNullParameter(r104, "config");
            }

            @Override // com.bytedance.android.live.core.privacy.av.api.b
            public final void d(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
                Intrinsics.checkNotNullParameter(r100, "biz");
                Intrinsics.checkNotNullParameter(r101, "sense");
                Intrinsics.checkNotNullParameter(r102, "type");
                Intrinsics.checkNotNullParameter(r103, "params");
                Intrinsics.checkNotNullParameter(r104, "config");
            }
        }

        public a() {
        }

        static {
            f65136b = new a();
            f65135a = new C1072a();
        }
    }

    static {
        f65134a = a.f65136b;
    }

    void a(String r100, String r101, String r102, Map r103, com.bytedance.android.live.core.privacy.av.api.a r104, AudioAndVideoException r105);

    void b(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104);

    void c(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104);

    void d(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104);
}
