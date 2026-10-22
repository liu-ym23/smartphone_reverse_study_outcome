package com.bytedance.android.gamecp.host_api.cloudgame;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/gamecp/host_api/cloudgame/IXPlayApiForLive$XplayConstants$NetworkQuality", "", "Lcom/bytedance/android/gamecp/host_api/cloudgame/IXPlayApiForLive$XplayConstants$NetworkQuality;", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "GREAT", "GOOD", "MEDIUM", "BAD", "TERRIBLE", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IXPlayApiForLive$XplayConstants$NetworkQuality extends Enum<IXPlayApiForLive$XplayConstants$NetworkQuality> {
    public static final IXPlayApiForLive$XplayConstants$NetworkQuality BAD = null;
    public static final IXPlayApiForLive$XplayConstants$NetworkQuality GOOD = null;
    public static final IXPlayApiForLive$XplayConstants$NetworkQuality GREAT = null;
    public static final IXPlayApiForLive$XplayConstants$NetworkQuality MEDIUM = null;
    public static final IXPlayApiForLive$XplayConstants$NetworkQuality TERRIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IXPlayApiForLive$XplayConstants$NetworkQuality[] f57360a = null;
    private final String desc;

    static {
        IXPlayApiForLive$XplayConstants$NetworkQuality r100 = new IXPlayApiForLive$XplayConstants$NetworkQuality("GREAT", 0, "网络极佳");
        GREAT = r100;
        IXPlayApiForLive$XplayConstants$NetworkQuality r101 = new IXPlayApiForLive$XplayConstants$NetworkQuality("GOOD", 1, "网络良好");
        GOOD = r101;
        IXPlayApiForLive$XplayConstants$NetworkQuality r102 = new IXPlayApiForLive$XplayConstants$NetworkQuality("MEDIUM", 2, "网络一般");
        MEDIUM = r102;
        IXPlayApiForLive$XplayConstants$NetworkQuality r103 = new IXPlayApiForLive$XplayConstants$NetworkQuality("BAD", 3, "网络差");
        BAD = r103;
        IXPlayApiForLive$XplayConstants$NetworkQuality r104 = new IXPlayApiForLive$XplayConstants$NetworkQuality("TERRIBLE", 4, "网络极差");
        TERRIBLE = r104;
        f57360a = new IXPlayApiForLive$XplayConstants$NetworkQuality[]{r100, r101, r102, r103, r104};
    }

    public static IXPlayApiForLive$XplayConstants$NetworkQuality valueOf(String r100) {
        return (IXPlayApiForLive$XplayConstants$NetworkQuality) a.a(IXPlayApiForLive$XplayConstants$NetworkQuality.class, r100);
    }

    public static IXPlayApiForLive$XplayConstants$NetworkQuality[] values() {
        return (IXPlayApiForLive$XplayConstants$NetworkQuality[]) f57360a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public IXPlayApiForLive$XplayConstants$NetworkQuality(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
