package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.view;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayHomepageStateManager;", "", "initialState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;)V", "TAG", "", "stateStack", "", "getCurrentState", "handleBackPress", "isCloseButtonEnabled", "", "popState", "pushState", "", "newState", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayHomepageStateManager {
    private final String TAG;
    private UnifyPayHomepageState initialState;
    private final List<UnifyPayHomepageState> stateStack;

    private final UnifyPayHomepageState getCurrentState() {
        if ((!this.stateStack.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (UnifyPayHomepageState) CollectionsKt.last(this.stateStack);
    }

    private final UnifyPayHomepageState popState() {
        if (this.stateStack.size() <= 1) goto L5;
        List<UnifyPayHomepageState> r100 = this.stateStack;
        ListProtector.remove(r100, CollectionsKt.getLastIndex(r100));
        return getCurrentState();
    L5:
        return null;
    }

    public final UnifyPayHomepageState handleBackPress() {
        if (this.stateStack.size() > 1) goto L7;
        return null;
    L7:
        return popState();
    }

    public final boolean isCloseButtonEnabled() {
        if (this.stateStack.size() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public CJUnifyPayHomepageStateManager(UnifyPayHomepageState r100) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        this.initialState = r100;
        this.stateStack = CollectionsKt.mutableListOf(new UnifyPayHomepageState[]{r100});
        this.TAG = "CJUnifyPayHomepageStateManager";
    }

    public final void pushState(UnifyPayHomepageState r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        if (getCurrentState() != r100) goto L6;
        CJLogger.e(this.TAG, "pushState 最上面就是" + r100 + ",啥也不干");
        return;
    L6:
        List<UnifyPayHomepageState> r101 = this.stateStack;
        UnifyPayHomepageState r102 = UnifyPayHomepageState.CONFIRM_STATE;
        if (r101.contains(r102) == true) goto L9;
    L11:
        List<UnifyPayHomepageState> r103 = this.stateStack;
        UnifyPayHomepageState r104 = UnifyPayHomepageState.VERIFY_STATE;
        if (r103.contains(r104) == false) goto L15;
        if (r100 != r102) goto L15;
        this.stateStack.remove(r104);
        CJLogger.e(this.TAG, "pushState " + r100 + " 禁止在 CONFIRM 和 VERIFY 状态间直接切换");
    L20:
        if (this.stateStack.contains(r100) == false) goto L22;
        this.stateStack.remove(r100);
        CJLogger.e(this.TAG, "pushState " + r100 + " 状态已存在于栈中，移除该状态并将其推到栈顶");
    L22:
        UnifyPayHomepageState r105 = UnifyPayHomepageState.EXPAND_STATE;
        if (r100 == r105) goto L25;
    L26:
        UnifyPayHomepageState r106 = this.initialState;
        if (r106 != r102) goto L29;
        if (r100 != r102) goto L29;
    L37:
        this.stateStack.clear();
        CJLogger.e(this.TAG, "pushState " + r100 + " 清空之前的栈 " + this.initialState);
    L38:
        CJLogger.d(this.TAG, "pushState " + r100 + ", now stack size:" + this.stateStack.size());
        this.stateStack.add(r100);
        return;
    L29:
        if (r106 == r102) goto L31;
    L32:
        UnifyPayHomepageState r107 = UnifyPayHomepageState.VERIFY_STATE;
        if (r106 != r107) goto L35;
        if (r100 == r102) goto L37;
    L35:
        if (r106 != r107) goto L38;
        if (r100 != r107) goto L38;
    L31:
        if (r100 == UnifyPayHomepageState.VERIFY_STATE) goto L37;
    L25:
        if (this.initialState == r105) goto L37;
    L15:
        List<UnifyPayHomepageState> r108 = this.stateStack;
        UnifyPayHomepageState r109 = UnifyPayHomepageState.FRONT_HOMEPAGE_STATE;
        if (r108.contains(r109) == false) goto L20;
        if (r100 == r109) goto L20;
        this.stateStack.remove(r109);
        this.initialState = r100;
        CJLogger.e(this.TAG, "pushState " + r100 + " 禁止在 FRONT_HOMEPAGE_STATE 和 其他状态间直接切换");
        goto L20
    L9:
        if (r100 != UnifyPayHomepageState.VERIFY_STATE) goto L11;
        this.stateStack.remove(r102);
        CJLogger.e(this.TAG, "pushState " + r100 + " 禁止在 CONFIRM 和 VERIFY 状态间直接切换");
        goto L20
    }
}
