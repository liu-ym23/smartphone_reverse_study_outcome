package com.bytedance.android.livesdk.bottomguide;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0014/B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/GuideBarResponseItem;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", n.KEY_MAIN_TEXT, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", n.KEY_SUB_TEXT, "f", "setSubText", "buttonText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setButtonText", "showSecond", "e", "setShowSecond", "showLimit", "d", "setShowLimit", "toastText", "getToastText", "setToastText", "Lcom/bytedance/android/livesdk/bottomguide/g;", "thresholdConfig", "Lcom/bytedance/android/livesdk/bottomguide/g;", ce.f26391f, "()Lcom/bytedance/android/livesdk/bottomguide/g;", "h", "(Lcom/bytedance/android/livesdk/bottomguide/g;)V", "Lcom/bytedance/android/livesdk/bottomguide/a;", "mainTextMap", "Lcom/bytedance/android/livesdk/bottomguide/a;", "c", "()Lcom/bytedance/android/livesdk/bottomguide/a;", "setMainTextMap", "(Lcom/bytedance/android/livesdk/bottomguide/a;)V", "<init>", "()V", "GuideBarType", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class GuideBarResponseItem {

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("main_text")
    private String mainText;

    @SerializedName("main_text_map")
    private com.bytedance.android.livesdk.bottomguide.a mainTextMap;

    @SerializedName("show_limit")
    private int showLimit;

    @SerializedName("show_second")
    private int showSecond;

    @SerializedName("sub_text")
    private String subText;

    @SerializedName("threshold_config")
    private g thresholdConfig;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    private String toastText;

    @SerializedName("type")
    private int type;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/GuideBarResponseItem$GuideBarType;", "", "", "type", "I", "getType", "()I", "UnknownGuideBarType", "OauthBarType", "JumpNoticeAfterRejectOauth", "OauthConfidenceBar", "SilentOauthGuideBar", "CouponOauthBar", "CouponSilenceOauthBar5", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final enum GuideBarType extends Enum<GuideBarType> {
        public static final GuideBarType CouponOauthBar = null;
        public static final GuideBarType CouponSilenceOauthBar5 = null;
        public static final GuideBarType JumpNoticeAfterRejectOauth = null;
        public static final GuideBarType OauthBarType = null;
        public static final GuideBarType OauthConfidenceBar = null;
        public static final GuideBarType SilentOauthGuideBar = null;
        public static final GuideBarType UnknownGuideBarType = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GuideBarType[] f104356a = null;
        private final int type;

        static {
            GuideBarType r100 = new GuideBarType("UnknownGuideBarType", 0, 0);
            UnknownGuideBarType = r100;
            GuideBarType r101 = new GuideBarType("OauthBarType", 1, 1);
            OauthBarType = r101;
            GuideBarType r102 = new GuideBarType("JumpNoticeAfterRejectOauth", 2, 2);
            JumpNoticeAfterRejectOauth = r102;
            GuideBarType r103 = new GuideBarType("OauthConfidenceBar", 3, 3);
            OauthConfidenceBar = r103;
            GuideBarType r104 = new GuideBarType("SilentOauthGuideBar", 4, 4);
            SilentOauthGuideBar = r104;
            GuideBarType r105 = new GuideBarType("CouponOauthBar", 5, 5);
            CouponOauthBar = r105;
            GuideBarType r106 = new GuideBarType("CouponSilenceOauthBar5", 6, 6);
            CouponSilenceOauthBar5 = r106;
            f104356a = new GuideBarType[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static GuideBarType valueOf(String r100) {
            return (GuideBarType) r27.a.a(GuideBarType.class, r100);
        }

        public static GuideBarType[] values() {
            return (GuideBarType[]) f104356a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public GuideBarType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public GuideBarResponseItem() {
        this.showSecond = 5;
        this.showLimit = 1;
    }

    public final String a() {
        return this.buttonText;
    }

    public final String b() {
        return this.mainText;
    }

    public final com.bytedance.android.livesdk.bottomguide.a c() {
        return this.mainTextMap;
    }

    public final int d() {
        return this.showLimit;
    }

    public final int e() {
        return this.showSecond;
    }

    public final String f() {
        return this.subText;
    }

    public final g g() {
        return this.thresholdConfig;
    }

    public final int getType() {
        return this.type;
    }

    public final void h(g r100) {
        this.thresholdConfig = r100;
    }
}
