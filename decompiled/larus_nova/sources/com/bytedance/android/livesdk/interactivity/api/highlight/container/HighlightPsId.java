package com.bytedance.android.livesdk.interactivity.api.highlight.container;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/container/HighlightPsId;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "Announcement", WikiFolderPushPlugin.PIN, "PSHighlightPin", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HighlightPsId extends Enum<HighlightPsId> {
    public static final HighlightPsId Announcement = null;
    public static final HighlightPsId PSHighlightPin = null;
    public static final HighlightPsId Pin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HighlightPsId[] f133224a = null;
    private final String desc;
    private final String key;

    static {
        HighlightPsId r100 = new HighlightPsId("Announcement", 0, "AnnouncementHighlightProcessor", "预告");
        Announcement = r100;
        HighlightPsId r101 = new HighlightPsId(WikiFolderPushPlugin.PIN, 1, "PinContainer", "贴纸置顶消息");
        Pin = r101;
        HighlightPsId r102 = new HighlightPsId("PSHighlightPin", 2, "PSHighlightPinContainer", "公屏强调区置顶消息");
        PSHighlightPin = r102;
        f133224a = new HighlightPsId[]{r100, r101, r102};
    }

    public static HighlightPsId valueOf(String r100) {
        return (HighlightPsId) a.a(HighlightPsId.class, r100);
    }

    public static HighlightPsId[] values() {
        return (HighlightPsId[]) f133224a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public HighlightPsId(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.key = r102;
        this.desc = r103;
    }
}
