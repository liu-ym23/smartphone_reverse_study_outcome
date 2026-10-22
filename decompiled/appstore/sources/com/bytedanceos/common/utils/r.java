package com.bytedanceos.common.utils;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f10212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f10213b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f10214c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList f10215d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList f10216e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ArrayList f10217f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList f10218g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArrayList f10219h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArrayList f10220i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArrayList f10221j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArrayList f10222k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f10223l = null;

    static {
        f10212a = new ArrayList();
        f10213b = new ArrayList(Arrays.asList(new String[]{"com.sdu.didi.psnger", "com.autonavi.minimap", "com.tencent.qqlive", "com.netease.newsreader.activity", "com.sankuai.meituan", "com.mfw.roadbook", "com.chaozh.iReaderFree", "com.Qunar", "com.dianping.v1", "com.douban.frodo", "cn.dxy.android.aspirin"}));
        f10214c = new ArrayList(Arrays.asList(new String[]{"com.autonavi.minimap", "com.netease.newsreader.activity", "com.sankuai.meituan", "com.dianping.v1", "com.douban.frodo", "cn.dxy.android.aspirin", "ctrip.android.view", "com.achievo.vipshop", "com.qq.reader", "com.jiemian.news", "com.youku.phone", "com.ximalaya.ting.android"}));
        f10215d = new ArrayList(Arrays.asList(new String[]{"com.ss.android.article.news", "com.jiemian.news", "com.shuqi.controller", "cn.dxy.android.aspirin", "com.youku.phone", "com.dianping.v1", "com.sankuai.meituan", "ctrip.android.view", "com.autonavi.minimap", "com.ximalaya.ting.android", "com.douban.frodo"}));
        f10216e = new ArrayList(Arrays.asList(new String[]{"com.ss.android.article.news", "com.jiemian.news", "com.shuqi.controller", "cn.dxy.android.aspirin", "com.dianping.v1", "com.sankuai.meituan", "ctrip.android.view", "com.autonavi.minimap", "com.ximalaya.ting.android", "com.qiyi.video", "com.ss.android.article.video", "com.ruguoapp.jike", "com.jingdong.app.mall", "com.sina.weibo", "com.tmall.wireless", "com.intsig.camscanner"}));
        f10217f = new ArrayList(Arrays.asList(new String[]{"com.ss.android.article.news", "com.jiemian.news", "com.shuqi.controller", "cn.dxy.android.aspirin", "com.dianping.v1", "com.sankuai.meituan", "ctrip.android.view", "com.autonavi.minimap", "com.ximalaya.ting.android", "com.qiyi.video", "com.ruguoapp.jike", "com.jingdong.app.mall", "com.sina.weibo", "com.intsig.camscanner", "com.yixia.videoeditor", "com.netease.newsreader.activity", "com.luojilab.player"}));
        f10218g = new ArrayList(Arrays.asList(new String[]{"com.ss.android.article.news", "com.jiemian.news", "com.shuqi.controller", "com.dianping.v1", "com.sankuai.meituan", "ctrip.android.view", "com.autonavi.minimap", "com.ximalaya.ting.android", "com.qiyi.video", "com.jingdong.app.mall", "com.sina.weibo", "com.intsig.camscanner", "com.netease.newsreader.activity", "com.achievo.vipshop", "com.icloudoor.bizranking", "com.gzhm.gamebox", "com.ttdj.cmel"}));
        f10219h = new ArrayList(Arrays.asList(new String[]{"com.ss.android.ugc.live", "com.ss.android.ugc.aweme", "com.ss.android.article.video", "com.sup.android.superb", "com.ss.android.auto", "com.ss.android.article.news"}));
        f10220i = new ArrayList(Arrays.asList(new String[]{"com.ss.android.article.news", "com.jiemian.news", "com.shuqi.controller", "com.dianping.v1", "com.sankuai.meituan", "ctrip.android.view", "com.autonavi.minimap", "com.ximalaya.ting.android", "com.qiyi.video", "com.jingdong.app.mall", "com.sina.weibo", "com.intsig.camscanner", "com.netease.newsreader.activity", "com.achievo.vipshop", "com.icloudoor.bizranking", "com.baidu.haokan"}));
        f10221j = new ArrayList(Arrays.asList(new String[]{"cn.kuwo.player", "com.Qunar", "com.ss.android.article.news", "com.ss.android.article.video", "com.ss.android.ugc.aweme", "com.autonavi.minimap", "ctrip.android.view", "com.achievo.vipshop", "com.dianping.v1", "com.qiyi.video", "com.blink.academy.nomo", "com.intsig.camscanner", "com.lemon.lv", "com.sina.weibo"}));
        f10222k = new ArrayList(Arrays.asList(new String[]{"cn.kuwo.player", "com.Qunar", "com.sina.weibo", "com.intsig.camscanner", "com.autonavi.minimap", "com.achievo.vipshop", "com.ss.android.ugc.aweme", "com.ss.android.article.news", "com.lemon.lv", "com.ss.android.lark", "cn.wps.moffice_eng", "ctrip.android.view"}));
        f10223l = Collections.singletonList("com.intsig.BizCardReader");
    }

    public static ArrayList a() {
        switch(BaseApplication.c().e()) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return f10222k;
    L9:
        return f10221j;
    L11:
        return f10220i;
    L13:
        return f10218g;
    L15:
        return f10217f;
    L17:
        return f10216e;
    L19:
        return f10215d;
    L21:
        return f10214c;
    L23:
        return f10213b;
    L25:
        return f10212a;
    }

    public static boolean b(String r10) {
        BaseApplication r11 = BaseApplication.c();
        String r12 = com.bytedanceos.common.toolbox.s.c(r11);
        if (TextUtils.isEmpty(r12) == true) goto L10;
        String[] r13 = r12.split(";");
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        if (TextUtils.equals(r13[r15], r10) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        return true;
    L10:
        PackageManager r16 = r11.getPackageManager();
        if (f10223l.contains(r10) == true) goto L13;
        return true;
    L13:
        return ReflectTool.isAppActive(r16, r10);
    }

    public static boolean c(String r10) {
        PackageManager r11 = BaseApplication.c().getPackageManager();
        switch(BaseApplication.c().e()) {
            case 0: goto L45;
            case 1: goto L42;
            case 2: goto L39;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L26;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L16;
            case 9: goto L11;
            case 10: goto L6;
            default: goto L59;
        };
    L59:
        return true;
    L6:
        if (f10222k.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L47:
        return ReflectTool.isAppActive(r11, r10);
    L11:
        if (f10221j.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L16:
        if (f10220i.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L21:
        if (f10218g.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L26:
        if (f10217f.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L31:
        if (f10216e.contains(r10) == true) goto L47;
        if (f10219h.contains(r10) == true) goto L47;
        return true;
    L36:
        if (f10215d.contains(r10) == true) goto L47;
        return true;
    L39:
        if (f10214c.contains(r10) == true) goto L47;
        return true;
    L42:
        if (f10213b.contains(r10) == true) goto L47;
        return true;
    L45:
        if (f10212a.contains(r10) == true) goto L47;
        return true;
    }
}
