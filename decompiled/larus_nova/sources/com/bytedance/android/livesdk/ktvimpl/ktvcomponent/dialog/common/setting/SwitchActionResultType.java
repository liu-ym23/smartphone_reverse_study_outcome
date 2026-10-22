package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchActionResultType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "OPEN_TYPE", "CLOSE_TYPE", "FAILED_TYPE", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchActionResultType extends Enum<SwitchActionResultType> {
    public static final SwitchActionResultType CLOSE_TYPE = null;
    public static final SwitchActionResultType FAILED_TYPE = null;
    public static final SwitchActionResultType OPEN_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchActionResultType[] f144112a = null;
    private final String value;

    static {
        SwitchActionResultType r100 = new SwitchActionResultType("OPEN_TYPE", 0, "open");
        OPEN_TYPE = r100;
        SwitchActionResultType r101 = new SwitchActionResultType("CLOSE_TYPE", 1, "close");
        CLOSE_TYPE = r101;
        SwitchActionResultType r102 = new SwitchActionResultType("FAILED_TYPE", 2, "failed");
        FAILED_TYPE = r102;
        f144112a = new SwitchActionResultType[]{r100, r101, r102};
    }

    public static SwitchActionResultType valueOf(String r100) {
        return (SwitchActionResultType) r27.a.a(SwitchActionResultType.class, r100);
    }

    public static SwitchActionResultType[] values() {
        return (SwitchActionResultType[]) f144112a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SwitchActionResultType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
