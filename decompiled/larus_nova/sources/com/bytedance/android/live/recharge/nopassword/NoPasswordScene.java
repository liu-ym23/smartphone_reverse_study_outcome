package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SCENE_UNKNOWN", "SCENE_PK", "SCENE_FANS_CLUB_JOIN", "SCENE_FANS_CLUB_SEND_GIFT", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordScene extends Enum<NoPasswordScene> {
    public static final NoPasswordScene SCENE_FANS_CLUB_JOIN = null;
    public static final NoPasswordScene SCENE_FANS_CLUB_SEND_GIFT = null;
    public static final NoPasswordScene SCENE_PK = null;
    public static final NoPasswordScene SCENE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoPasswordScene[] f90043a = null;
    private final String value;

    static {
        NoPasswordScene r100 = new NoPasswordScene("SCENE_UNKNOWN", 0, "unknown");
        SCENE_UNKNOWN = r100;
        NoPasswordScene r101 = new NoPasswordScene("SCENE_PK", 1, PbRequest.SwitchType.PK);
        SCENE_PK = r101;
        NoPasswordScene r102 = new NoPasswordScene("SCENE_FANS_CLUB_JOIN", 2, "fansclub");
        SCENE_FANS_CLUB_JOIN = r102;
        NoPasswordScene r103 = new NoPasswordScene("SCENE_FANS_CLUB_SEND_GIFT", 3, "fansclub_send_gift");
        SCENE_FANS_CLUB_SEND_GIFT = r103;
        f90043a = new NoPasswordScene[]{r100, r101, r102, r103};
    }

    public static NoPasswordScene valueOf(String r100) {
        return (NoPasswordScene) r27.a.a(NoPasswordScene.class, r100);
    }

    public static NoPasswordScene[] values() {
        return (NoPasswordScene[]) f90043a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public NoPasswordScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
