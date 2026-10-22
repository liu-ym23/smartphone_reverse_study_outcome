package com.bytedance.android.livesdk.revenue.interactivity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/interactivity/PublicScreenMessageType;", "", "DISABLE_GIFT_NOTICE", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicScreenMessageType extends Enum<PublicScreenMessageType> {
    public static final PublicScreenMessageType DISABLE_GIFT_NOTICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenMessageType[] f157167a = null;

    static {
        PublicScreenMessageType r100 = new PublicScreenMessageType();
        DISABLE_GIFT_NOTICE = r100;
        f157167a = new PublicScreenMessageType[]{r100};
    }

    public static PublicScreenMessageType valueOf(String r100) {
        return (PublicScreenMessageType) a.a(PublicScreenMessageType.class, r100);
    }

    public static PublicScreenMessageType[] values() {
        return (PublicScreenMessageType[]) f157167a.clone();
    }

    public PublicScreenMessageType() {
        super("DISABLE_GIFT_NOTICE", 0);
    }
}
