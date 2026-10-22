package com.bytedance.android.livesdk.chatroom.model.interact;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/ThemeType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", EffectConstants.NORMAL, "CUSTOM", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ThemeType extends Enum<ThemeType> {
    public static final ThemeType CUSTOM = null;
    public static final ThemeType NORMAL = null;
    public static final ThemeType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThemeType[] f106942a = null;
    private final int value;

    static {
        ThemeType r100 = new ThemeType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ThemeType r101 = new ThemeType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        ThemeType r102 = new ThemeType("CUSTOM", 2, 2);
        CUSTOM = r102;
        f106942a = new ThemeType[]{r100, r101, r102};
    }

    public static ThemeType valueOf(String r100) {
        return (ThemeType) r27.a.a(ThemeType.class, r100);
    }

    public static ThemeType[] values() {
        return (ThemeType[]) f106942a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ThemeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
