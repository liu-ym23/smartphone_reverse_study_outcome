package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.live.base.exception.ApiException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f130927a;

    public static final class a {
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f130928b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f130929c = null;

        static {
            f130929c = new b();
            f130928b = "Hold";
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public final String a() {
            return f130928b;
        }
    }

    public static abstract class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f130930b;

        public static abstract class a extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f130931c;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.model.y$c$a$a, reason: collision with other inner class name */
            public static class C2080a extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final ApiException f130932d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final boolean f130933e;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "ApiFailed , code is " + this.f130932d.getErrorCode() + ", message is : " + this.f130932d.getMessage() + ", isHandler is : " + this.f130933e;
                }

                public C2080a(ApiException r100, boolean r101, int r102) {
                    Intrinsics.checkNotNullParameter(r100, "originException");
                    super(r102);
                    this.f130932d = r100;
                    this.f130933e = r101;
                }
            }

            public static final class b extends C2080a {
                public b(ApiException r100) {
                    Intrinsics.checkNotNullParameter(r100, "originException");
                    super(r100, false, 103);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.model.y$c$a$c, reason: collision with other inner class name */
            public static final class C2081c extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public static final C2081c f130934d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "BuffCardAccountFailed";
                }

                static {
                    f130934d = new C2081c();
                }

                public C2081c() {
                    super(101);
                }
            }

            public static final class d extends C2080a {
                public d(ApiException r100) {
                    Intrinsics.checkNotNullParameter(r100, "originException");
                    super(r100, true, 104);
                }
            }

            public static final class e extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final String f130935d;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "InvalidEnv, errMessage is " + this.f130935d;
                }

                public e(int r100, String r101) {
                    Intrinsics.checkNotNullParameter(r101, "errMsg");
                    super(r100);
                    this.f130935d = r101;
                }
            }

            public static final class f extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final String f130936d;

                public f() {
                    Intrinsics.checkNotNullParameter("count != groupCount", "errMsg");
                    super(202);
                    this.f130936d = "count != groupCount";
                }

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "InvalidParam, errMessage is " + this.f130936d;
                }
            }

            public static final class g extends C2080a {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public final int f130937f;

                public g(ApiException r100, int r101) {
                    Intrinsics.checkNotNullParameter(r100, "originException");
                    super(r100, false, 102);
                    this.f130937f = r101;
                }
            }

            public static final class h extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public static final h f130938d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "NetTimeOut";
                }

                static {
                    f130938d = new h();
                }

                public h() {
                    super(105);
                }
            }

            public static final class i extends a {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public static final i f130939d = null;

                @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
                public final String toString() {
                    return "TimeOut";
                }

                static {
                    f130939d = new i();
                }

                public i() {
                    super(100);
                }
            }

            public a(int r100) {
                this.f130931c = r100;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final String f130940c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final b f130941d = null;

            static {
                f130941d = new b();
                f130940c = "SkipToIdle";
            }

            public b() {
            }

            @Override // com.bytedance.android.livesdk.gift.platform.core.model.y.c, com.bytedance.android.livesdk.gift.platform.core.model.y
            public final String a() {
                return f130940c;
            }
        }

        public c() {
            this.f130930b = "Intercept";
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public String a() {
            return this.f130930b;
        }
    }

    public static final class d extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f130942b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f130943c = null;

        static {
            f130943c = new d();
            f130942b = "Pass";
        }

        public d() {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.y
        public final String a() {
            return f130942b;
        }
    }

    static {
    }

    public String toString() {
        return "PluginResponse " + a();
    }

    public y() {
        this.f130927a = "default";
    }

    public String a() {
        return this.f130927a;
    }
}
