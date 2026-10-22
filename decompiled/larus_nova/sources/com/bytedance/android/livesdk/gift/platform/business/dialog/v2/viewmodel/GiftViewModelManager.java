package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.tencent.open.SocialConstants;
import i12.e;
import i12.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public class GiftViewModelManager extends ViewModel {
    public static final int LIVE_GIFT_DIALOG_RECHARGE_LOGIN = 1002;
    public static final int LIVE_GIFT_DIALOG_SEND_LOGIN = 1001;
    public static final int LIVE_GIFT_DIALOG_TASK_GIFT_LOGIN = 1003;
    public static final int PAGE_COUNT = 8;
    public static final String TAG = "GiftViewModelManager";
    private DataCenter mDataCenter;
    private boolean mIsAnchor;
    private boolean mIsVertical;
    private IRoom mRoom;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.mDataCenter = null;
        super.onCleared();
    }

    public boolean isGiftUpdateOptimizeOpen() {
        if (((Boolean) nz1.a.f521338h.getValue(null, nz1.a.f521324a[6])).booleanValue() == true) goto L8;
        getDataCenter();
        if (u.p() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public GiftViewModelManager() {
    }

    public DataCenter getDataCenter() {
        return this.mDataCenter;
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    public IRoom getRoom() {
        return this.mRoom;
    }

    public boolean getSendToAnchor(IBaseUser r100) {
        return d.l(r100);
    }

    public boolean isPreCheckSendGift(IBaseUser r100) {
        KProperty[] r101 = s.f132083a;
        e r102 = o.b();
        if (r102 == null) goto L5;
        Object r103 = m.f163449e.d(r102, GiftSendPreCheckService.class);
    L7:
        if (((GiftSendPreCheckService) r103) == null) goto L16;
        e r104 = o.b();
        if (r104 == null) goto L11;
        Object r105 = m.f163449e.d(r104, GiftSendPreCheckService.class);
    L12:
        GiftSendPreCheckService r106 = (GiftSendPreCheckService) r105;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        if (r106.d(r100, null, null) == 0) goto L16;
        return false;
    L11:
        r105 = null;
    L16:
        return true;
    L5:
        r103 = null;
        goto L7
    }

    public void setDataCenter(DataCenter r100) {
        this.mDataCenter = r100;
    }

    public void setAllCommonData(Context r100, DataCenter r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.mDataCenter = r101;
        this.mRoom = x.a();
        this.mIsAnchor = ((Boolean) this.mDataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.mIsVertical = ((Boolean) this.mDataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        return;
    L8:
        return;
    }
}
