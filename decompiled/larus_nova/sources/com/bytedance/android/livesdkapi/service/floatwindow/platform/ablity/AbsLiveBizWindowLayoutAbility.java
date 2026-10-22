package com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/ILiveBizWindowAbility;", "()V", "abilityEnv", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "getAbilityEnv", "()Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "setAbilityEnv", "(Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;)V", "getBizWindowLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "videoWidth", "", "videoHeight", "sourceLayoutParams", "getCloseBtnLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getMuteBtnLayoutParams", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveBizWindowLayoutAbility implements ILiveBizWindowAbility {
    private LiveBizWindowAbilityEnv abilityEnv;

    public AbsLiveBizWindowLayoutAbility() {
    }

    public abstract RelativeLayout.LayoutParams getBizWindowLayoutParams(int r100, int r101, RelativeLayout.LayoutParams r102);

    public abstract FrameLayout.LayoutParams getCloseBtnLayoutParams(FrameLayout.LayoutParams r100);

    public abstract FrameLayout.LayoutParams getMuteBtnLayoutParams(FrameLayout.LayoutParams r100);

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
