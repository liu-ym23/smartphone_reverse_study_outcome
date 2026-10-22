package com.bytedance.android.live.openplatform.impl.base.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$ExplainCardTriggerType", "", "Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$ExplainCardTriggerType;", "", "value", "I", "getValue", "()I", "Normal", "HighIntention", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenPlatformConstants$ExplainCardTriggerType extends Enum<OpenPlatformConstants$ExplainCardTriggerType> {
    public static final OpenPlatformConstants$ExplainCardTriggerType HighIntention = null;
    public static final OpenPlatformConstants$ExplainCardTriggerType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenPlatformConstants$ExplainCardTriggerType[] f84013a = null;
    private final int value;

    static {
        OpenPlatformConstants$ExplainCardTriggerType r100 = new OpenPlatformConstants$ExplainCardTriggerType("Normal", 0, 0);
        Normal = r100;
        OpenPlatformConstants$ExplainCardTriggerType r101 = new OpenPlatformConstants$ExplainCardTriggerType("HighIntention", 1, 1);
        HighIntention = r101;
        f84013a = new OpenPlatformConstants$ExplainCardTriggerType[]{r100, r101};
    }

    public static OpenPlatformConstants$ExplainCardTriggerType valueOf(String r100) {
        return (OpenPlatformConstants$ExplainCardTriggerType) a.a(OpenPlatformConstants$ExplainCardTriggerType.class, r100);
    }

    public static OpenPlatformConstants$ExplainCardTriggerType[] values() {
        return (OpenPlatformConstants$ExplainCardTriggerType[]) f84013a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public OpenPlatformConstants$ExplainCardTriggerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
