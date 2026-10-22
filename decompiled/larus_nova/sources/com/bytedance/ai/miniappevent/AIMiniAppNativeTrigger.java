package com.bytedance.ai.miniappevent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/miniappevent/AIMiniAppNativeTrigger;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "ACTION_BAR_EXPOSURE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIMiniAppNativeTrigger extends Enum<AIMiniAppNativeTrigger> {
    public static final AIMiniAppNativeTrigger ACTION_BAR_EXPOSURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIMiniAppNativeTrigger[] f36706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36707b = null;
    private final String wireValue;

    public static EnumEntries<AIMiniAppNativeTrigger> getEntries() {
        return f36707b;
    }

    static {
        AIMiniAppNativeTrigger r100 = new AIMiniAppNativeTrigger();
        ACTION_BAR_EXPOSURE = r100;
        AIMiniAppNativeTrigger[] r101 = {r100};
        f36706a = r101;
        f36707b = EnumEntriesKt.enumEntries(r101);
    }

    public AIMiniAppNativeTrigger() {
        super("ACTION_BAR_EXPOSURE", 0);
        this.wireValue = "action_bar_exposure";
    }

    public static AIMiniAppNativeTrigger[] values() {
        return (AIMiniAppNativeTrigger[]) f36706a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static AIMiniAppNativeTrigger valueOf(String r100) {
        return (AIMiniAppNativeTrigger) r27.a.a(AIMiniAppNativeTrigger.class, r100);
    }
}
