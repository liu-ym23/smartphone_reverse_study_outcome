package com.bytedance.android.livesdkapi.service.vs;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.paidlive.PaidInRoomFloatWindowAbilityCenterImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/vs/IPaidInRoomFloatWindowAbilityCenter;", "Lcom/bytedance/android/live/base/IService;", "provideWindowLayoutAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "provideWindowLogAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLogAbility;", "provideWindowWidgetAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "registerWindowLayoutAbility", "", "ability", "registerWindowLogAbility", "registerWindowWidgetAbility", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPaidInRoomFloatWindowAbilityCenter extends IService {
    AbsLiveBizWindowLayoutAbility provideWindowLayoutAbility();

    AbsLiveBizWindowLogAbility provideWindowLogAbility();

    AbsLiveBizWindowWidgetAbility provideWindowWidgetAbility();

    void registerWindowLayoutAbility(AbsLiveBizWindowLayoutAbility r100);

    void registerWindowLogAbility(AbsLiveBizWindowLogAbility r100);

    void registerWindowWidgetAbility(AbsLiveBizWindowWidgetAbility r100);
}
