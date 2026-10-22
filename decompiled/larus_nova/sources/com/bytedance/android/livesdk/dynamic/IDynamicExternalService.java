package com.bytedance.android.livesdk.dynamic;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.locallife.ShortTermState;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ServiceLookup("om.bytedance.android.livesdk.dynamic.DynamicExternalService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamic/IDynamicExternalService;", "Lcom/bytedance/android/live/base/IService;", "getGameGuessPredictorWidget", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "liveLocalLifeSetShortTermState", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "state", "Lcom/bytedance/android/livehostapi/business/depend/locallife/ShortTermState;", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDynamicExternalService extends IService {
    Class<? extends Widget> getGameGuessPredictorWidget();

    void liveLocalLifeSetShortTermState(FragmentActivity r100, ShortTermState r101);
}
