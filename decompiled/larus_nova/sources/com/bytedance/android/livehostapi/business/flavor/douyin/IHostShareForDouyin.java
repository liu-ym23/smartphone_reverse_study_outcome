package com.bytedance.android.livehostapi.business.flavor.douyin;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostShareForDouyin extends IService, IBaseHostShare {
    public static final String FACEBOOK = "facebook";
    public static final String FB_LITE = "facebook_lite";
    public static final String INSTAGRAM = "instagram";
    public static final String KAKAO_TALK = "kakao_talk";
    public static final String LINE = "line";
    public static final String MESSENGER = "messenger";
    public static final String QQ = "qq";
    public static final String QZONE = "qzone";
    public static final String ROCKET = "rocket";
    public static final String ROCKET_TIMELINE = "rocket_timeline";
    public static final String TWITTER = "twitter";
    public static final String VK = "vk";
    public static final String WEIBO = "weibo";
    public static final String WEIXIN = "weixin";
    public static final String WEIXIN_MOMENT = "weixin_moment";
    public static final String WHATS_APP = "whatsapp";

    String getIMContactConversationId(f r100);

    void getQrCodeFromUrl(int r100, String r101, String r102, Function1<String, Unit> r103);

    void getQrCodeInfo(int r100, String r101, Function1<String, Unit> r102);

    JSONObject getTcActivitySettings();

    boolean isShareAvailable(String r100, Activity r101);

    void share(Activity r100, ShareParams r101, IShareCallback r102);

    void shareActivity(Context r100, Map<String, Object> r101, IShareCallback r102);

    void shareLive(Context r100, f r101, ShareParams r102, IShareCallback r103);

    void shareText2FansGroup(String r100, String r101);

    void shareVideo2FansGroups(List<String> r100, List<String> r101, Function1<String, Unit> r102);

    void showReportDialog(Activity r100, ShareParams r101, String r102);

    void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102);
}
