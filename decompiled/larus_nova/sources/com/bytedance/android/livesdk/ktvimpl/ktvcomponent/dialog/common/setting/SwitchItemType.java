package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchItemType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "AUDIENCE_SING", "MULTI_CHORUS", "KTV_CHALLENGE", "HIDE_LYRICS_FOR_SUBTITLE", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchItemType extends Enum<SwitchItemType> {
    public static final SwitchItemType AUDIENCE_SING = null;
    public static final SwitchItemType HIDE_LYRICS_FOR_SUBTITLE = null;
    public static final SwitchItemType KTV_CHALLENGE = null;
    public static final SwitchItemType MULTI_CHORUS = null;
    public static final SwitchItemType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchItemType[] f144113a = null;
    private final int value;

    static {
        SwitchItemType r100 = new SwitchItemType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        SwitchItemType r101 = new SwitchItemType("AUDIENCE_SING", 1, 1);
        AUDIENCE_SING = r101;
        SwitchItemType r102 = new SwitchItemType("MULTI_CHORUS", 2, 2);
        MULTI_CHORUS = r102;
        SwitchItemType r103 = new SwitchItemType("KTV_CHALLENGE", 3, 3);
        KTV_CHALLENGE = r103;
        SwitchItemType r104 = new SwitchItemType("HIDE_LYRICS_FOR_SUBTITLE", 4, 4);
        HIDE_LYRICS_FOR_SUBTITLE = r104;
        f144113a = new SwitchItemType[]{r100, r101, r102, r103, r104};
    }

    public static SwitchItemType valueOf(String r100) {
        return (SwitchItemType) r27.a.a(SwitchItemType.class, r100);
    }

    public static SwitchItemType[] values() {
        return (SwitchItemType[]) f144113a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SwitchItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
