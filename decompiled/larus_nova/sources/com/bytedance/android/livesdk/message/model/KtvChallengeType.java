package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/KtvChallengeType;", "", "", "value", "I", "getValue", "()I", "KTV_CHALLENGE_TYPE_UNKNOWN", "KTV_CHALLENGE_TYPE_GIFT", "KTV_CHALLENGE_TYPE_MIDI", "KTV_CHALLENGE_TYPE_LIKE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvChallengeType extends Enum<KtvChallengeType> {
    public static final KtvChallengeType KTV_CHALLENGE_TYPE_GIFT = null;
    public static final KtvChallengeType KTV_CHALLENGE_TYPE_LIKE = null;
    public static final KtvChallengeType KTV_CHALLENGE_TYPE_MIDI = null;
    public static final KtvChallengeType KTV_CHALLENGE_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvChallengeType[] f153561a = null;
    private final int value;

    static {
        KtvChallengeType r100 = new KtvChallengeType("KTV_CHALLENGE_TYPE_UNKNOWN", 0, 0);
        KTV_CHALLENGE_TYPE_UNKNOWN = r100;
        KtvChallengeType r101 = new KtvChallengeType("KTV_CHALLENGE_TYPE_GIFT", 1, 1);
        KTV_CHALLENGE_TYPE_GIFT = r101;
        KtvChallengeType r102 = new KtvChallengeType("KTV_CHALLENGE_TYPE_MIDI", 2, 2);
        KTV_CHALLENGE_TYPE_MIDI = r102;
        KtvChallengeType r103 = new KtvChallengeType("KTV_CHALLENGE_TYPE_LIKE", 3, 3);
        KTV_CHALLENGE_TYPE_LIKE = r103;
        f153561a = new KtvChallengeType[]{r100, r101, r102, r103};
    }

    public static KtvChallengeType valueOf(String r100) {
        return (KtvChallengeType) r27.a.a(KtvChallengeType.class, r100);
    }

    public static KtvChallengeType[] values() {
        return (KtvChallengeType[]) f153561a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvChallengeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
