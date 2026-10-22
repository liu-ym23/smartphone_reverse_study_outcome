package com.bytedance.android.live.messagewindow.business.presenter;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/messagewindow/business/presenter/JsEventType;", "", "", "value", "I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "CLOSE_CARD", "HIDE_CARD", "SHOW_CARD", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum JsEventType extends Enum<JsEventType> {
    public static final JsEventType CLOSE_CARD = null;
    public static final JsEventType HIDE_CARD = null;
    public static final JsEventType SHOW_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsEventType[] f82966a = null;
    private final String desc;
    private final int value;

    static {
        JsEventType r100 = new JsEventType("CLOSE_CARD", 0, 1, "关闭（销毁）卡片");
        CLOSE_CARD = r100;
        JsEventType r101 = new JsEventType("HIDE_CARD", 1, 2, "隐藏卡片");
        HIDE_CARD = r101;
        JsEventType r102 = new JsEventType("SHOW_CARD", 2, 3, "展示卡片");
        SHOW_CARD = r102;
        f82966a = new JsEventType[]{r100, r101, r102};
    }

    public static JsEventType valueOf(String r100) {
        return (JsEventType) r27.a.a(JsEventType.class, r100);
    }

    public static JsEventType[] values() {
        return (JsEventType[]) f82966a.clone();
    }

    public JsEventType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
