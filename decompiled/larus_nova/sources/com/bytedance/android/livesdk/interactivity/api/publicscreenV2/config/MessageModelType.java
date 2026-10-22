package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessageModelType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Square", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MessageModelType extends Enum<MessageModelType> {
    public static final MessageModelType Square = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageModelType[] f133728a = null;
    private final String tag;

    static {
        MessageModelType r100 = new MessageModelType();
        Square = r100;
        f133728a = new MessageModelType[]{r100};
    }

    public static MessageModelType valueOf(String r100) {
        return (MessageModelType) a.a(MessageModelType.class, r100);
    }

    public static MessageModelType[] values() {
        return (MessageModelType[]) f133728a.clone();
    }

    public MessageModelType() {
        super("Square", 0);
        this.tag = "WorldChatData";
    }

    public final String getTag() {
        return this.tag;
    }
}
