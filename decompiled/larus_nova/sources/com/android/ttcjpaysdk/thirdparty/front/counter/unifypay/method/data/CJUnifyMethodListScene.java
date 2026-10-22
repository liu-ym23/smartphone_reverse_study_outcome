package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodListScene;", "", "(Ljava/lang/String;I)V", "SCENE_INIT", "SCENE_UPDATE", "SCENE_PAY_AGAIN", "SCENE_CHANGE_METHOD", "SCENE_UPDATE_PROMOTION", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyMethodListScene extends Enum<CJUnifyMethodListScene> {
    private static final /* synthetic */ CJUnifyMethodListScene[] $VALUES = null;
    public static final CJUnifyMethodListScene SCENE_CHANGE_METHOD = null;
    public static final CJUnifyMethodListScene SCENE_INIT = null;
    public static final CJUnifyMethodListScene SCENE_PAY_AGAIN = null;
    public static final CJUnifyMethodListScene SCENE_UPDATE = null;
    public static final CJUnifyMethodListScene SCENE_UPDATE_PROMOTION = null;

    private static final /* synthetic */ CJUnifyMethodListScene[] $values() {
        return new CJUnifyMethodListScene[]{SCENE_INIT, SCENE_UPDATE, SCENE_PAY_AGAIN, SCENE_CHANGE_METHOD, SCENE_UPDATE_PROMOTION};
    }

    public static CJUnifyMethodListScene valueOf(String r100) {
        return (CJUnifyMethodListScene) a.a(CJUnifyMethodListScene.class, r100);
    }

    public static CJUnifyMethodListScene[] values() {
        return (CJUnifyMethodListScene[]) $VALUES.clone();
    }

    static {
        SCENE_INIT = new CJUnifyMethodListScene("SCENE_INIT", 0);
        SCENE_UPDATE = new CJUnifyMethodListScene("SCENE_UPDATE", 1);
        SCENE_PAY_AGAIN = new CJUnifyMethodListScene("SCENE_PAY_AGAIN", 2);
        SCENE_CHANGE_METHOD = new CJUnifyMethodListScene("SCENE_CHANGE_METHOD", 3);
        SCENE_UPDATE_PROMOTION = new CJUnifyMethodListScene("SCENE_UPDATE_PROMOTION", 4);
        $VALUES = $values();
    }

    private CJUnifyMethodListScene(String r100, int r101) {
        super(r100, r101);
    }
}
