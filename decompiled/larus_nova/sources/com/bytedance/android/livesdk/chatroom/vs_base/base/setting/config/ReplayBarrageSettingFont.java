package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSettingFont;", "", "", LynxResourceModule.FONT_TYPE, "I", "getFont", "()I", "level", "getLevel", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LARGE", "BIG", "MID", "SMALL", "VS_PORTRAIT", "VS_PORTRAIT_SMALL", "VS_PORTRAIT_MID", "VS_PORTRAIT_BIG", "VS_PORTRAIT_LARGE", "PORTRAIT", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayBarrageSettingFont extends Enum<ReplayBarrageSettingFont> {
    public static final ReplayBarrageSettingFont BIG = null;
    public static final a Companion = null;
    public static final ReplayBarrageSettingFont LARGE = null;
    public static final ReplayBarrageSettingFont MID = null;
    public static final ReplayBarrageSettingFont PORTRAIT = null;
    public static final ReplayBarrageSettingFont SMALL = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_BIG = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_LARGE = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_MID = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayBarrageSettingFont[] f117914a = null;
    private final String des;
    private final int font;
    private final int level;

    public static final class a {
        public a() {
        }
    }

    public static ReplayBarrageSettingFont valueOf(String r100) {
        return (ReplayBarrageSettingFont) r27.a.a(ReplayBarrageSettingFont.class, r100);
    }

    public static ReplayBarrageSettingFont[] values() {
        return (ReplayBarrageSettingFont[]) f117914a.clone();
    }

    static {
        ReplayBarrageSettingFont r100 = new ReplayBarrageSettingFont("LARGE", 0, -1, 3, "超大");
        LARGE = r100;
        ReplayBarrageSettingFont r101 = new ReplayBarrageSettingFont("BIG", 1, 0, 2, "大");
        BIG = r101;
        ReplayBarrageSettingFont r102 = new ReplayBarrageSettingFont("MID", 2, 1, 1, "适中");
        MID = r102;
        ReplayBarrageSettingFont r103 = new ReplayBarrageSettingFont("SMALL", 3, 2, 0, "小");
        SMALL = r103;
        ReplayBarrageSettingFont r104 = new ReplayBarrageSettingFont("VS_PORTRAIT", 4, 3, 0, "竖屏横流默认");
        VS_PORTRAIT = r104;
        ReplayBarrageSettingFont r105 = new ReplayBarrageSettingFont("VS_PORTRAIT_SMALL", 5, 4, 0, "小");
        VS_PORTRAIT_SMALL = r105;
        ReplayBarrageSettingFont r106 = new ReplayBarrageSettingFont("VS_PORTRAIT_MID", 6, 5, 1, "适中");
        VS_PORTRAIT_MID = r106;
        ReplayBarrageSettingFont r107 = new ReplayBarrageSettingFont("VS_PORTRAIT_BIG", 7, 6, 2, "大");
        VS_PORTRAIT_BIG = r107;
        ReplayBarrageSettingFont r108 = new ReplayBarrageSettingFont("VS_PORTRAIT_LARGE", 8, 7, 3, "超大");
        VS_PORTRAIT_LARGE = r108;
        ReplayBarrageSettingFont r109 = new ReplayBarrageSettingFont("PORTRAIT", 9, 8, 0, "");
        PORTRAIT = r109;
        f117914a = new ReplayBarrageSettingFont[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getFont() {
        return this.font;
    }

    public final int getLevel() {
        return this.level;
    }

    public ReplayBarrageSettingFont(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.font = r102;
        this.level = r103;
        this.des = r104;
    }
}
