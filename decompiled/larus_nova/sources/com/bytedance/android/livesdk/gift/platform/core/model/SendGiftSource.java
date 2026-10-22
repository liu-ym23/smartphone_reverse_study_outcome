package com.bytedance.android.livesdk.gift.platform.core.model;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftSource;", "", "", "sourceName", "Ljava/lang/String;", "getSourceName", "()Ljava/lang/String;", "FastGift", "GiftDialog", "Guide", "JsbPage", "RedPacketGiftGuide", "Schema", "Comment", "MessageBoard", "Format", "UnKnow", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftSource extends Enum<SendGiftSource> {
    public static final SendGiftSource Comment = null;
    public static final SendGiftSource FastGift = null;
    public static final SendGiftSource Format = null;
    public static final SendGiftSource GiftDialog = null;
    public static final SendGiftSource Guide = null;
    public static final SendGiftSource JsbPage = null;
    public static final SendGiftSource MessageBoard = null;
    public static final SendGiftSource RedPacketGiftGuide = null;
    public static final SendGiftSource Schema = null;
    public static final SendGiftSource UnKnow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendGiftSource[] f130827a = null;
    private final String sourceName;

    public static SendGiftSource valueOf(String r100) {
        return (SendGiftSource) r27.a.a(SendGiftSource.class, r100);
    }

    public static SendGiftSource[] values() {
        return (SendGiftSource[]) f130827a.clone();
    }

    static {
        SendGiftSource r100 = new SendGiftSource("FastGift", 0, "convenient");
        FastGift = r100;
        SendGiftSource r101 = new SendGiftSource("GiftDialog", 1, "giftDialog");
        GiftDialog = r101;
        SendGiftSource r102 = new SendGiftSource("Guide", 2, "guide");
        Guide = r102;
        SendGiftSource r103 = new SendGiftSource("JsbPage", 3, "jsbPage");
        JsbPage = r103;
        SendGiftSource r104 = new SendGiftSource("RedPacketGiftGuide", 4, "redPacketGiftGuide");
        RedPacketGiftGuide = r104;
        SendGiftSource r105 = new SendGiftSource("Schema", 5, "schema");
        Schema = r105;
        SendGiftSource r106 = new SendGiftSource("Comment", 6, "comment");
        Comment = r106;
        SendGiftSource r107 = new SendGiftSource("MessageBoard", 7, "messageBoard");
        MessageBoard = r107;
        SendGiftSource r108 = new SendGiftSource("Format", 8, SubInfo.KEY_FORMAT);
        Format = r108;
        SendGiftSource r109 = new SendGiftSource("UnKnow", 9, "unKnow");
        UnKnow = r109;
        f130827a = new SendGiftSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public SendGiftSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.sourceName = r102;
    }
}
