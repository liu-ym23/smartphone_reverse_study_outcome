package com.bytedance.android.livesdk.livecommerce.intro.model.req;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NAN", "ENTER_ROOM", "POP_MESSAGE", "REFRESH_MESSAGE", "MARKETING_MESSAGE", "GET_CARD", "ACTION", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IntroCardScene extends Enum<IntroCardScene> {
    public static final IntroCardScene ACTION = null;
    public static final IntroCardScene ENTER_ROOM = null;
    public static final IntroCardScene GET_CARD = null;
    public static final IntroCardScene MARKETING_MESSAGE = null;
    public static final IntroCardScene NAN = null;
    public static final IntroCardScene POP_MESSAGE = null;
    public static final IntroCardScene REFRESH_MESSAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntroCardScene[] f148474a = null;
    private final String value;

    static {
        IntroCardScene r100 = new IntroCardScene("NAN", 0, "");
        NAN = r100;
        IntroCardScene r101 = new IntroCardScene("ENTER_ROOM", 1, "enter_room");
        ENTER_ROOM = r101;
        IntroCardScene r102 = new IntroCardScene("POP_MESSAGE", 2, "message");
        POP_MESSAGE = r102;
        IntroCardScene r103 = new IntroCardScene("REFRESH_MESSAGE", 3, "message");
        REFRESH_MESSAGE = r103;
        IntroCardScene r104 = new IntroCardScene("MARKETING_MESSAGE", 4, "message");
        MARKETING_MESSAGE = r104;
        IntroCardScene r105 = new IntroCardScene("GET_CARD", 5, "get_card");
        GET_CARD = r105;
        IntroCardScene r106 = new IntroCardScene("ACTION", 6, "action");
        ACTION = r106;
        f148474a = new IntroCardScene[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static IntroCardScene valueOf(String r100) {
        return (IntroCardScene) a.a(IntroCardScene.class, r100);
    }

    public static IntroCardScene[] values() {
        return (IntroCardScene[]) f148474a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public IntroCardScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
