package com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/ILiveBizWindowAbility;", "()V", "abilityEnv", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "getAbilityEnv", "()Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "setAbilityEnv", "(Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;)V", "getBizInteractView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "windowW", "", "windowH", "onAttach", "", "onBizInteractViewClick", "onDetach", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveBizWindowWidgetAbility implements ILiveBizWindowAbility {
    private LiveBizWindowAbilityEnv abilityEnv;

    public AbsLiveBizWindowWidgetAbility() {
    }

    public abstract View getBizInteractView(Context r100, int r101, int r102);

    public abstract void onAttach();

    public abstract void onBizInteractViewClick();

    public abstract void onDetach();

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
    public int getPriority() {
        return ILiveBizWindowAbility.DefaultImpls.getPriority(this);
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
    public LiveBizWindowAbilityEnv getAbilityEnv() {
        return this.abilityEnv;
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
    public void setAbilityEnv(LiveBizWindowAbilityEnv r100) {
        this.abilityEnv = r100;
    }
}
