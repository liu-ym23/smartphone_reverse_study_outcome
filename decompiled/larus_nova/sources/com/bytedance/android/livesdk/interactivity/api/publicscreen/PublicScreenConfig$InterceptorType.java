package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType", "", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType;", "MentionChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenConfig$InterceptorType extends Enum<PublicScreenConfig$InterceptorType> {
    public static final PublicScreenConfig$InterceptorType MentionChat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenConfig$InterceptorType[] f133368a = null;

    static {
        PublicScreenConfig$InterceptorType r100 = new PublicScreenConfig$InterceptorType();
        MentionChat = r100;
        f133368a = new PublicScreenConfig$InterceptorType[]{r100};
    }

    public static PublicScreenConfig$InterceptorType valueOf(String r100) {
        return (PublicScreenConfig$InterceptorType) r27.a.a(PublicScreenConfig$InterceptorType.class, r100);
    }

    public static PublicScreenConfig$InterceptorType[] values() {
        return (PublicScreenConfig$InterceptorType[]) f133368a.clone();
    }

    public PublicScreenConfig$InterceptorType() {
        super("MentionChat", 0);
    }
}
