package com.bytedance.android.livesdk.revenue.condition;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/condition/RevConditionType;", "", "SHOW_GIFT_EFFECT", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevConditionType extends Enum<RevConditionType> {
    public static final RevConditionType SHOW_GIFT_EFFECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevConditionType[] f157100a = null;

    static {
        RevConditionType r100 = new RevConditionType();
        SHOW_GIFT_EFFECT = r100;
        f157100a = new RevConditionType[]{r100};
    }

    public static RevConditionType valueOf(String r100) {
        return (RevConditionType) a.a(RevConditionType.class, r100);
    }

    public static RevConditionType[] values() {
        return (RevConditionType[]) f157100a.clone();
    }

    public RevConditionType() {
        super("SHOW_GIFT_EFFECT", 0);
    }
}
