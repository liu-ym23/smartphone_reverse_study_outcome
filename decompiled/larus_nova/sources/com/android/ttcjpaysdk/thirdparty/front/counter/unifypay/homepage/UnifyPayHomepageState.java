package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "EXPAND_STATE", "VERIFY_STATE", "CONFIRM_STATE", "FRONT_HOMEPAGE_STATE", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum UnifyPayHomepageState extends Enum<UnifyPayHomepageState> {
    private static final /* synthetic */ UnifyPayHomepageState[] $VALUES = null;
    public static final UnifyPayHomepageState CONFIRM_STATE = null;
    public static final UnifyPayHomepageState EXPAND_STATE = null;
    public static final UnifyPayHomepageState FRONT_HOMEPAGE_STATE = null;
    public static final UnifyPayHomepageState VERIFY_STATE = null;
    private final String type;

    private static final /* synthetic */ UnifyPayHomepageState[] $values() {
        return new UnifyPayHomepageState[]{EXPAND_STATE, VERIFY_STATE, CONFIRM_STATE, FRONT_HOMEPAGE_STATE};
    }

    public static UnifyPayHomepageState valueOf(String r100) {
        return (UnifyPayHomepageState) a.a(UnifyPayHomepageState.class, r100);
    }

    public static UnifyPayHomepageState[] values() {
        return (UnifyPayHomepageState[]) $VALUES.clone();
    }

    static {
        EXPAND_STATE = new UnifyPayHomepageState("EXPAND_STATE", 0, BitableAnalytic.LinkSceneClickType.EXPAND);
        VERIFY_STATE = new UnifyPayHomepageState("VERIFY_STATE", 1, "unify_verify");
        CONFIRM_STATE = new UnifyPayHomepageState("CONFIRM_STATE", 2, "unify_confirm");
        FRONT_HOMEPAGE_STATE = new UnifyPayHomepageState("FRONT_HOMEPAGE_STATE", 3, "unify_front_homepage");
        $VALUES = $values();
    }

    public final String getType() {
        return this.type;
    }

    private UnifyPayHomepageState(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
