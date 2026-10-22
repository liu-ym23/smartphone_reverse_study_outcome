package com.bytedance.android.livehostapi.business.depend.share;

import com.tencent.connect.common.Constants;
import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public interface IShareAble extends Serializable {

    public static final enum SharePlatform extends Enum<SharePlatform> {
        private static final /* synthetic */ SharePlatform[] $VALUES = null;
        public static final SharePlatform I18N = null;
        public static final SharePlatform QQ = null;
        public static final SharePlatform QZONE = null;
        public static final SharePlatform ROCKET = null;
        public static final SharePlatform ROCKET_TIMELINE = null;
        public static final SharePlatform WEIBO = null;
        public static final SharePlatform WEIXIN = null;
        public static final SharePlatform WEIXIN_MOMENT = null;

        static {
            SharePlatform r100 = new SharePlatform(Constants.SOURCE_QQ, 0);
            QQ = r100;
            SharePlatform r101 = new SharePlatform("QZONE", 1);
            QZONE = r101;
            SharePlatform r102 = new SharePlatform("WEIBO", 2);
            WEIBO = r102;
            SharePlatform r103 = new SharePlatform("WEIXIN", 3);
            WEIXIN = r103;
            SharePlatform r104 = new SharePlatform("WEIXIN_MOMENT", 4);
            WEIXIN_MOMENT = r104;
            SharePlatform r105 = new SharePlatform("ROCKET", 5);
            ROCKET = r105;
            SharePlatform r110 = new SharePlatform("ROCKET_TIMELINE", 6);
            ROCKET_TIMELINE = r110;
            SharePlatform r111 = new SharePlatform("I18N", 7);
            I18N = r111;
            $VALUES = new SharePlatform[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static SharePlatform[] values() {
            return (SharePlatform[]) $VALUES.clone();
        }

        public static SharePlatform valueOf(String r100) {
            return (SharePlatform) a.a(SharePlatform.class, r100);
        }

        private SharePlatform(String r100, int r101) {
            super(r100, r101);
        }
    }

    int getDefaultTumb();

    String getSSLocalUrl();

    String getShareDesc(SharePlatform r100);

    long getShareGroupId(SharePlatform r100);

    ShareScene getShareScene();

    String getShareTargetUrl();

    String getShareThumbUrl(SharePlatform r100);

    String getShareTitle(SharePlatform r100);

    boolean isWeiBoTopic();

    boolean needVideoPlayIcon();
}
