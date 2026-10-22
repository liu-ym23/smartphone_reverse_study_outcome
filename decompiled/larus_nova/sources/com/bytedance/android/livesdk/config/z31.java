package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/z31;", "", "", "banRuleText", "Ljava/lang/String;", "getBanRuleText", "()Ljava/lang/String;", "setBanRuleText", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fanRules", "Ljava/util/ArrayList;", "getFanRules", "()Ljava/util/ArrayList;", "setFanRules", "(Ljava/util/ArrayList;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z31 {

    @SerializedName("ban_rule")
    private String banRuleText;

    @SerializedName("fans_rule")
    private ArrayList<String> fanRules;

    public z31() {
        this.banRuleText = "<font color=#8A8B91>近期内有过违规记录（如14天内有过直播中断及封禁、30天内曾被回收电脑直播权限等），请继续遵守《抖音社区自律公约》和《直播行为规范》，当你无违规记录超过上述对应处置周期后可再次申请电脑直播权限。如有疑问，可前往反馈入口咨询。</font>";
        ArrayList<String> r100 = new ArrayList();
        r100.add("<font color=#8A8B91>1. 单app粉丝数统计以上述数据为准；</font><font color=#FE8099>部分抖音app内展示粉丝数目为与抖音账号绑定的各app累计粉丝数值。<font/>");
        r100.add("<font color=#8A8B91>2. 若其他app粉丝数达到1000，也可使用其他app账号登录。</font>");
        Unit r101 = Unit.INSTANCE;
        this.fanRules = r100;
    }
}
