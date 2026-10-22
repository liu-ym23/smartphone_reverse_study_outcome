package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/PreVerifyAction;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SET_LOADING_STATUS", "UPDATE_TITLE", "UPDATE_LEFT_BUTTON", "SET_CONFIRM_STATUS", "UPDATE_TITLE_BAR", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PreVerifyAction extends Enum<PreVerifyAction> {
    private static final /* synthetic */ PreVerifyAction[] $VALUES = null;
    public static final PreVerifyAction SET_CONFIRM_STATUS = null;
    public static final PreVerifyAction SET_LOADING_STATUS = null;
    public static final PreVerifyAction UPDATE_LEFT_BUTTON = null;
    public static final PreVerifyAction UPDATE_TITLE = null;
    public static final PreVerifyAction UPDATE_TITLE_BAR = null;
    private final String value;

    private static final /* synthetic */ PreVerifyAction[] $values() {
        return new PreVerifyAction[]{SET_LOADING_STATUS, UPDATE_TITLE, UPDATE_LEFT_BUTTON, SET_CONFIRM_STATUS, UPDATE_TITLE_BAR};
    }

    public static PreVerifyAction valueOf(String r100) {
        return (PreVerifyAction) a.a(PreVerifyAction.class, r100);
    }

    public static PreVerifyAction[] values() {
        return (PreVerifyAction[]) $VALUES.clone();
    }

    static {
        SET_LOADING_STATUS = new PreVerifyAction("SET_LOADING_STATUS", 0, "set_loading_status");
        UPDATE_TITLE = new PreVerifyAction("UPDATE_TITLE", 1, "update_title");
        UPDATE_LEFT_BUTTON = new PreVerifyAction("UPDATE_LEFT_BUTTON", 2, "update_left_button");
        SET_CONFIRM_STATUS = new PreVerifyAction("SET_CONFIRM_STATUS", 3, "set_confirm_status");
        UPDATE_TITLE_BAR = new PreVerifyAction("UPDATE_TITLE_BAR", 4, "update_title_bar");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private PreVerifyAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
