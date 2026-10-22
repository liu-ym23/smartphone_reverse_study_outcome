package com.bytedance.android.livesdk.arch.plugin;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/arch/plugin/Identity;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "HandleBehavior", "Unfold2MorePanel", "TracePlugin", "PreloadContent", "BizCheckCallback", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Identity extends Enum<Identity> {
    public static final Identity BizCheckCallback = null;
    public static final Identity HandleBehavior = null;
    public static final Identity PreloadContent = null;
    public static final Identity TracePlugin = null;
    public static final Identity Unfold2MorePanel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Identity[] f103810a = null;
    private final String desc;

    static {
        Identity r100 = new Identity("HandleBehavior", 0, "处理Toolbar的behavior");
        HandleBehavior = r100;
        Identity r101 = new Identity("Unfold2MorePanel", 1, "处理底部toolbar按钮被挤占到更多面板");
        Unfold2MorePanel = r101;
        Identity r102 = new Identity("TracePlugin", 2, "toolbar监控链路");
        TracePlugin = r102;
        Identity r103 = new Identity("PreloadContent", 3, "预加载组件内容，不等二次确认结果回来");
        PreloadContent = r103;
        Identity r104 = new Identity("BizCheckCallback", 4, "业务二次检查结果回传插件");
        BizCheckCallback = r104;
        f103810a = new Identity[]{r100, r101, r102, r103, r104};
    }

    public static Identity valueOf(String r100) {
        return (Identity) a.a(Identity.class, r100);
    }

    public static Identity[] values() {
        return (Identity[]) f103810a.clone();
    }

    public Identity(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
