package com.android.ttcjpaysdk.bdpay.counter.outer.sign;

import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInfoQueryResponse;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/AbsCJSignWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "initSignInfoResponse", "", "result", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", LiveCommonConstants.REASON_ON_DEDTROY, "ISignAction", "SignPageScene", "SignQueryScene", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsCJSignWrapper extends BaseWrapper {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/AbsCJSignWrapper$ISignAction;", "", "onRenderEnd", "", "signQueryCallback", "isSuccess", "", "userFlag", "", "signResult", "code", "", "data", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ISignAction {
        void onRenderEnd();

        void signQueryCallback(boolean r100, String r101);

        void signResult(int r100, Map<String, String> r101);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/AbsCJSignWrapper$SignPageScene;", "", "(Ljava/lang/String;I)V", "SCENE_INIT", "SCENE_UPDATE", "SCENE_CHANGE_METHOD", "SCENE_BIND_CARD", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SignPageScene extends Enum<SignPageScene> {
        private static final /* synthetic */ SignPageScene[] $VALUES = null;
        public static final SignPageScene SCENE_BIND_CARD = null;
        public static final SignPageScene SCENE_CHANGE_METHOD = null;
        public static final SignPageScene SCENE_INIT = null;
        public static final SignPageScene SCENE_UPDATE = null;

        private static final /* synthetic */ SignPageScene[] $values() {
            return new SignPageScene[]{SCENE_INIT, SCENE_UPDATE, SCENE_CHANGE_METHOD, SCENE_BIND_CARD};
        }

        public static SignPageScene valueOf(String r100) {
            return (SignPageScene) a.a(SignPageScene.class, r100);
        }

        public static SignPageScene[] values() {
            return (SignPageScene[]) $VALUES.clone();
        }

        static {
            SCENE_INIT = new SignPageScene("SCENE_INIT", 0);
            SCENE_UPDATE = new SignPageScene("SCENE_UPDATE", 1);
            SCENE_CHANGE_METHOD = new SignPageScene("SCENE_CHANGE_METHOD", 2);
            SCENE_BIND_CARD = new SignPageScene("SCENE_BIND_CARD", 3);
            $VALUES = $values();
        }

        private SignPageScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/AbsCJSignWrapper$SignQueryScene;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FIRST", "BIND_CARD", "CREDIT_SIGN_BIND_CARD", "CREDIT_SIGN_SET_PWD", "BUTTON_INFO_ACTION", "SWITCH_ACCOUNT", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum SignQueryScene extends Enum<SignQueryScene> {
        private static final /* synthetic */ SignQueryScene[] $VALUES = null;
        public static final SignQueryScene BIND_CARD = null;
        public static final SignQueryScene BUTTON_INFO_ACTION = null;
        public static final SignQueryScene CREDIT_SIGN_BIND_CARD = null;
        public static final SignQueryScene CREDIT_SIGN_SET_PWD = null;
        public static final SignQueryScene FIRST = null;
        public static final SignQueryScene SWITCH_ACCOUNT = null;
        private final String value;

        private static final /* synthetic */ SignQueryScene[] $values() {
            return new SignQueryScene[]{FIRST, BIND_CARD, CREDIT_SIGN_BIND_CARD, CREDIT_SIGN_SET_PWD, BUTTON_INFO_ACTION, SWITCH_ACCOUNT};
        }

        public static SignQueryScene valueOf(String r100) {
            return (SignQueryScene) a.a(SignQueryScene.class, r100);
        }

        public static SignQueryScene[] values() {
            return (SignQueryScene[]) $VALUES.clone();
        }

        static {
            FIRST = new SignQueryScene("FIRST", 0, SoloKtvContext.SOLO_PAGE_FIRST);
            BIND_CARD = new SignQueryScene("BIND_CARD", 1, "bind_card");
            CREDIT_SIGN_BIND_CARD = new SignQueryScene("CREDIT_SIGN_BIND_CARD", 2, "credit_sign_bind_card");
            CREDIT_SIGN_SET_PWD = new SignQueryScene("CREDIT_SIGN_SET_PWD", 3, "credit_sign_set_pwd");
            BUTTON_INFO_ACTION = new SignQueryScene("BUTTON_INFO_ACTION", 4, "button_info_action");
            SWITCH_ACCOUNT = new SignQueryScene("SWITCH_ACCOUNT", 5, "switch_account");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private SignQueryScene(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public abstract void initSignInfoResponse(CJPaySignInfoQueryResponse r100);

    public abstract void onDestroy();

    public AbsCJSignWrapper(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
    }
}
