package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyTradeCreateScene;", "", "(Ljava/lang/String;I)V", "getDescription", "", "SCENE_INIT", "SCENE_SWITCH_ACCOUNT", "SCENE_PAY_AGAIN", "SCENE_PRE_VERIFY", "SCENE_RETRY", "SCENE_FRONT_HOME_PAGE_SWITCH", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyTradeCreateScene extends Enum<CJUnifyTradeCreateScene> {
    private static final /* synthetic */ CJUnifyTradeCreateScene[] $VALUES = null;
    public static final CJUnifyTradeCreateScene SCENE_FRONT_HOME_PAGE_SWITCH = null;
    public static final CJUnifyTradeCreateScene SCENE_INIT = null;
    public static final CJUnifyTradeCreateScene SCENE_PAY_AGAIN = null;
    public static final CJUnifyTradeCreateScene SCENE_PRE_VERIFY = null;
    public static final CJUnifyTradeCreateScene SCENE_RETRY = null;
    public static final CJUnifyTradeCreateScene SCENE_SWITCH_ACCOUNT = null;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[CJUnifyTradeCreateScene.values().length];
            r100[CJUnifyTradeCreateScene.SCENE_INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[CJUnifyTradeCreateScene.SCENE_SWITCH_ACCOUNT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[CJUnifyTradeCreateScene.SCENE_PAY_AGAIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[CJUnifyTradeCreateScene.SCENE_PRE_VERIFY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[CJUnifyTradeCreateScene.SCENE_RETRY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[CJUnifyTradeCreateScene.SCENE_FRONT_HOME_PAGE_SWITCH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ CJUnifyTradeCreateScene[] $values() {
        return new CJUnifyTradeCreateScene[]{SCENE_INIT, SCENE_SWITCH_ACCOUNT, SCENE_PAY_AGAIN, SCENE_PRE_VERIFY, SCENE_RETRY, SCENE_FRONT_HOME_PAGE_SWITCH};
    }

    public static CJUnifyTradeCreateScene valueOf(String r100) {
        return (CJUnifyTradeCreateScene) a.a(CJUnifyTradeCreateScene.class, r100);
    }

    public static CJUnifyTradeCreateScene[] values() {
        return (CJUnifyTradeCreateScene[]) $VALUES.clone();
    }

    static {
        SCENE_INIT = new CJUnifyTradeCreateScene("SCENE_INIT", 0);
        SCENE_SWITCH_ACCOUNT = new CJUnifyTradeCreateScene("SCENE_SWITCH_ACCOUNT", 1);
        SCENE_PAY_AGAIN = new CJUnifyTradeCreateScene("SCENE_PAY_AGAIN", 2);
        SCENE_PRE_VERIFY = new CJUnifyTradeCreateScene("SCENE_PRE_VERIFY", 3);
        SCENE_RETRY = new CJUnifyTradeCreateScene("SCENE_RETRY", 4);
        SCENE_FRONT_HOME_PAGE_SWITCH = new CJUnifyTradeCreateScene("SCENE_FRONT_HOME_PAGE_SWITCH", 5);
        $VALUES = $values();
    }

    public final String getDescription() {
        switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "前置首页切换到展开态";
    L7:
        return "重试";
    L8:
        return "支付前处理完成";
    L9:
        return "二次支付";
    L10:
        return "切换账号";
    L11:
        return "初始化";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private CJUnifyTradeCreateScene(String r100, int r101) {
        super(r100, r101);
    }
}
