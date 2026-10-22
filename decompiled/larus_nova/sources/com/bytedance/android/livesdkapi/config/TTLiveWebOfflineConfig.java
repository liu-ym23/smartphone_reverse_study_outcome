package com.bytedance.android.livesdkapi.config;

import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public class TTLiveWebOfflineConfig {
    private static final String CHANNEL_GAME_NATIVE_LYNX_DOUYIN = "webcast_native_lynx_game_douyin";
    public static final String CHANNEL_LYNX_DOUYIN = "webcast_lynx_douyin";
    private static final String CHANNEL_LYNX_HUOSHAN = "webcast_lynx_huoshan";
    private static final String CHANNEL_NATIVE_LYNX_DOUYIN = "webcast_native_lynx_douyin";
    private static final String CHANNEL_NATIVE_LYNX_HUOSHAN = "webcast_native_lynx_huoshan";
    private static final String CHANNEL_NATIVE_LYNX_TOUTIAO = "webcast_native_lynx_toutiao";
    private static final String CHANNEL_NATIVE_LYNX_XIGUA = "webcast_native_lynx_xigua";
    private static final String CHANNEL_NATIVE_XIGUA = "webcast_lynx_xigua";
    public static final List<String> DOUYIN_CHANNEL_LIST = null;
    public static final List<Pattern> DOUYIN_PATTERN_LIST = null;
    private static final String GECKO_OPEN_PATTERN_CONFIG = "live_gecko_open_pattern_config";
    public static final List<String> HOTSOON_CHANNEL_LIST = null;
    public static final List<Pattern> HOTSOON_PATTERN_LIST = null;
    public static final List<String> PPX_CHANNEL_LIST = null;
    public static final List<Pattern> PPX_PATTERN_LIST = null;
    private static final String TAG = "TTLiveWebOfflineConfig";
    public static final List<String> TOUTIAO_CHANNEL_LIST = null;
    public static final List<String> XIGUA_CHANNEL_LIST = null;
    public static final List<Pattern> XIGUA_PATTERN_LIST = null;

    public TTLiveWebOfflineConfig() {
    }

    private static List<String> getDouyinChannelList() {
        ArrayList r100 = new ArrayList();
        r100.add(CHANNEL_NATIVE_LYNX_DOUYIN);
        r100.add("webcast_douyin");
        r100.add("fe_lynx_doupay_promotion");
        r100.add("ecom_mix_h5");
        r100.add(CHANNEL_LYNX_DOUYIN);
        r100.add(CHANNEL_GAME_NATIVE_LYNX_DOUYIN);
        r100.addAll(getWebcastChannels());
        return r100;
    }

    private static List<Pattern> getDouyinPatternList() {
        ArrayList r100 = new ArrayList();
        r100.add(PatternProtector.compile(".snssdk.com/falcon/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/aweme/resource/falcon/"));
        r100.add(PatternProtector.compile("s3a.bytecdn.cn/aweme/resource/falcon/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile("s3a.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile(".amemv.com/falcon/"));
        r100.add(PatternProtector.compile(".bytedance.net/falcon/"));
        r100.add(PatternProtector.compile(".bytecdn.cn/ies/live/"));
        return r100;
    }

    public static List<Pattern> getGroupTypePattern() {
        ArrayList r100 = new ArrayList();
        if (TTLiveServiceMiddleware.getLiveService() == null) goto L8;
        Iterator r101 = ((ArrayList) TTLiveServiceMiddleware.getLiveService().getLiveSettingValue("live_offline_patterns", new ArrayList())).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.add(PatternProtector.compile((String) r101.next()));
    L8:
        return r100;
    }

    private static List<String> getHotsoonChannelList() {
        ArrayList r100 = new ArrayList();
        r100.add(CHANNEL_NATIVE_LYNX_HUOSHAN);
        r100.add(CHANNEL_LYNX_HUOSHAN);
        r100.add("webcast_huoshan");
        r100.add("ecom_mix_h5");
        r100.addAll(getWebcastChannels());
        return r100;
    }

    private static List<Pattern> getHotsoonPatternList() {
        ArrayList r100 = new ArrayList();
        r100.add(PatternProtector.compile(".snssdk.com/falcon/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile("s3a.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile(".amemv.com/falcon/"));
        r100.add(PatternProtector.compile(".bytedance.net/falcon/"));
        r100.add(PatternProtector.compile(".huoshan.com/falcon/"));
        return r100;
    }

    public static List<Pattern> getOfflinePatterns() {
        ArrayList r100 = new ArrayList();
        if (TTLiveServiceMiddleware.getLiveService() == null) goto L8;
        Iterator r101 = ((ArrayList) TTLiveServiceMiddleware.getLiveService().getLiveSettingValue("live_gurd_patterns", new ArrayList())).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.add(PatternProtector.compile((String) r101.next()));
    L8:
        return r100;
    }

    private static List<String> getPpxChannelList() {
        ArrayList r100 = new ArrayList();
        r100.add("webcast_pipixia");
        r100.addAll(getWebcastChannels());
        return r100;
    }

    private static List<Pattern> getPpxPatternList() {
        ArrayList r100 = new ArrayList();
        r100.add(PatternProtector.compile("api.ribaoapi.com/falcon/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile("s3a.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile("/*.snssdk.com/falcon/"));
        r100.add(PatternProtector.compile("webcast-ppx.snssdk.com/falcon/"));
        r100.add(PatternProtector.compile(".bytedance.net/falcon/"));
        return r100;
    }

    private static List<String> getToutiaoChannelList() {
        ArrayList r100 = new ArrayList();
        r100.add(CHANNEL_NATIVE_LYNX_TOUTIAO);
        r100.add("webcast_xigua");
        r100.addAll(getWebcastChannels());
        return r100;
    }

    private static List<String> getWebcastChannels() {
        ArrayList r100 = new ArrayList();
        r100.add("webcast_activity");
        r100.add("webcast_lynx_mini");
        return r100;
    }

    private static List<String> getXiguaChannelList() {
        ArrayList r100 = new ArrayList();
        r100.add(CHANNEL_NATIVE_LYNX_XIGUA);
        r100.add(CHANNEL_NATIVE_XIGUA);
        r100.add("webcast_xigua");
        r100.addAll(getWebcastChannels());
        return r100;
    }

    private static List<Pattern> getXiguaPatternList() {
        ArrayList r100 = new ArrayList();
        r100.add(PatternProtector.compile(".snssdk.com/falcon/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile("s3a.bytecdn.cn/ies/resource/falcon/"));
        r100.add(PatternProtector.compile(".bytedance.net/falcon/"));
        r100.add(PatternProtector.compile(".ixigua.com/falcon/"));
        r100.add(PatternProtector.compile("snssdk.com/feoffline/"));
        r100.add(PatternProtector.compile("s3.bytecdn.cn/ies/elegant/"));
        return r100;
    }

    static {
        DOUYIN_CHANNEL_LIST = getDouyinChannelList();
        DOUYIN_PATTERN_LIST = getDouyinPatternList();
        PPX_CHANNEL_LIST = getPpxChannelList();
        PPX_PATTERN_LIST = getPpxPatternList();
        HOTSOON_CHANNEL_LIST = getHotsoonChannelList();
        HOTSOON_PATTERN_LIST = getHotsoonPatternList();
        XIGUA_CHANNEL_LIST = getXiguaChannelList();
        XIGUA_PATTERN_LIST = getXiguaPatternList();
        TOUTIAO_CHANNEL_LIST = getToutiaoChannelList();
    }
}
