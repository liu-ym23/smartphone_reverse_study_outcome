package com.bytedance.android.livesdk.feed;

/* JADX INFO: loaded from: classes8.dex */
public interface ApiCallBack {

    public static final enum ApiType extends Enum<ApiType> {
        public static final ApiType LOAD_MORE = null;
        public static final ApiType REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ApiType[] f123409a = null;

        static {
            ApiType r100 = new ApiType("REFRESH", 0);
            REFRESH = r100;
            ApiType r101 = new ApiType("LOAD_MORE", 1);
            LOAD_MORE = r101;
            f123409a = new ApiType[]{r100, r101};
        }

        public static ApiType[] values() {
            return (ApiType[]) f123409a.clone();
        }

        public static ApiType valueOf(String r100) {
            return (ApiType) r27.a.a(ApiType.class, r100);
        }

        public ApiType(String r100, int r101) {
            super(r100, r101);
        }
    }
}
