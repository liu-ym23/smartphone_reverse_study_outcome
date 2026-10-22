package com.bytedance.android.livesdk.gift.platform.core.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Audience", "Anchor", "OtherAnchor", "Guest", "MicTeamAnchor", "AllMic", "GroupLive", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReceiverType extends Enum<ReceiverType> {
    public static final ReceiverType AllMic = null;
    public static final ReceiverType Anchor = null;
    public static final ReceiverType Audience = null;
    public static final a Companion = null;
    public static final ReceiverType GroupLive = null;
    public static final ReceiverType Guest = null;
    public static final ReceiverType MicTeamAnchor = null;
    public static final ReceiverType OtherAnchor = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReceiverType[] f130826a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        ReceiverType r100 = new ReceiverType("Audience", 0, 1);
        Audience = r100;
        ReceiverType r101 = new ReceiverType("Anchor", 1, 2);
        Anchor = r101;
        ReceiverType r102 = new ReceiverType("OtherAnchor", 2, 3);
        OtherAnchor = r102;
        ReceiverType r103 = new ReceiverType("Guest", 3, 4);
        Guest = r103;
        ReceiverType r104 = new ReceiverType("MicTeamAnchor", 4, 5);
        MicTeamAnchor = r104;
        ReceiverType r105 = new ReceiverType("AllMic", 5, 6);
        AllMic = r105;
        ReceiverType r106 = new ReceiverType("GroupLive", 6, 7);
        GroupLive = r106;
        f130826a = new ReceiverType[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static ReceiverType valueOf(String r100) {
        return (ReceiverType) r27.a.a(ReceiverType.class, r100);
    }

    public static ReceiverType[] values() {
        return (ReceiverType[]) f130826a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReceiverType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
