package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessagePipelineType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SquareTabPipeline", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MessagePipelineType extends Enum<MessagePipelineType> {
    public static final MessagePipelineType SquareTabPipeline = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessagePipelineType[] f133729a = null;
    private final String tag;

    static {
        MessagePipelineType r100 = new MessagePipelineType();
        SquareTabPipeline = r100;
        f133729a = new MessagePipelineType[]{r100};
    }

    public static MessagePipelineType valueOf(String r100) {
        return (MessagePipelineType) a.a(MessagePipelineType.class, r100);
    }

    public static MessagePipelineType[] values() {
        return (MessagePipelineType[]) f133729a.clone();
    }

    public MessagePipelineType() {
        super("SquareTabPipeline", 0);
        this.tag = "SquarePipeline";
    }

    public final String getTag() {
        return this.tag;
    }
}
