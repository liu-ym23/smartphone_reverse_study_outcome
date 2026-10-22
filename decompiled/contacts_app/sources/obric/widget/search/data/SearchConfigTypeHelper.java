package obric.widget.search.data;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConfigTypeHelper {
    private static final int TYPE_360SO = 4;
    private static final int TYPE_BAIDU = 0;
    private static final int TYPE_BAIDU_BAIKE = 17;
    private static final int TYPE_BING = 2;
    private static final int TYPE_BINGDICT = 258;
    private static final int TYPE_GOOGLE = 1;
    private static final int TYPE_GOOGLE_TRANSLATE = 260;
    private static final int TYPE_HUDONG_BAIKE = 16;
    private static final int TYPE_KINGSOFT = 257;
    private static Map<Integer, String> TYPE_MAPS = null;
    private static final int TYPE_SEARCH_WECHAT = 512;
    private static final int TYPE_SEARCH_WEIBO = 513;
    private static final int TYPE_SEARCH_ZHIHU = 514;
    private static final int TYPE_SOGOU = 3;
    private static final int TYPE_WIKI_PEDIA_CN = 19;
    private static final int TYPE_WIKI_PEDIA_EN = 18;
    private static final int TYPE_YOUDAO = 256;

    public SearchConfigTypeHelper() {
    }

    static {
        HashMap r0 = new HashMap(16);
        TYPE_MAPS = r0;
        r0.put(0, "search_baidu");
        TYPE_MAPS.put(1, "search_google");
        TYPE_MAPS.put(2, "search_bing");
        TYPE_MAPS.put(3, "search_sogou");
        TYPE_MAPS.put(4, "search_360so");
        TYPE_MAPS.put(16, "baike_hudong");
        TYPE_MAPS.put(17, "baike_baidu");
        TYPE_MAPS.put(18, "baike_wikiEN");
        TYPE_MAPS.put(19, "baike_wikiCN");
        TYPE_MAPS.put(256, "dictionary_youdao");
        TYPE_MAPS.put(257, "dictionary_iciba");
        TYPE_MAPS.put(258, "dictionary_bing");
        TYPE_MAPS.put(260, "dictionary_google");
        TYPE_MAPS.put(512, "third_sogou");
        TYPE_MAPS.put(513, "third_weibo");
        TYPE_MAPS.put(514, "third_zhihu");
    }

    public static String getDefaultType(Context context, String type) {
        context.getContentResolver();
        if ("config_search".equals(type) == false) goto L6;
        int r0 = 3;
    L16:
        return TYPE_MAPS.get(Integer.valueOf(r0));
    L6:
        if ("config_dictionary".equals(type) == false) goto L9;
        r0 = 256;
        goto L16
    L9:
        if ("config_baike".equals(type) == false) goto L12;
        r0 = 17;
        goto L16
    L12:
        if ("config_third_search".equals(type) == false) goto L14;
        r0 = 512;
        goto L16
    L14:
        r0 = 0;
        goto L16
    }
}
