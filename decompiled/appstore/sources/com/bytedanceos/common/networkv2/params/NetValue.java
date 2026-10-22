package com.bytedanceos.common.networkv2.params;

/* JADX INFO: loaded from: classes2.dex */
public class NetValue {
    public static final int SIZE_PER_PAGE_20 = 20;
    public static final String TYPE_RANK = "rank";

    public static class AppStatusType {
        public static final String CHECK_SIGN_FAILURE = "6";
        public static final String DIFF_PATCH_FAILURE = "5";
        public static final String DOWNLOAD_FAILURE_NEW = "7";
        public static final String DOWNLOAD_SUCCESS = "1";
        public static final String INSTALL_FAILURE = "3";
        public static final String INSTALL_SUCCESS = "10";
        public static final String REQUEST_DOWNLOAD = "9";
        public static final String UPDATE_FAILURE = "8";
        public static final String UPDATE_SUCCESS = "2";

        public AppStatusType() {
        }
    }

    public static class PageSource {
        public static final String PAGE_SOURCE_DETAIL = "1";

        public PageSource() {
        }
    }

    public static class ProductName {
        public static final String APP_STORE = "Bytedance_App_AppStore";
        public static final String GAME_STORE = "Bytedance_App_GameStore";

        public ProductName() {
        }
    }

    public static class Source {
        public static final String APP_STORE = "1";
        public static final String GAME_CENTER = "2";
        public static final String GAME_CENTER_4 = "4";

        public Source() {
        }
    }

    public NetValue() {
    }
}
