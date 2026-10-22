package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0096\u0002J\b\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/action/instance/InteractGiftPanelAction;", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "", "()V", AbsMethodDelegate.TAG_INVOKE, "params", "", "", "", "onTerminate", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@ActionMethod("webcast_inroom_ugc_gift_panel")
public final class InteractGiftPanelAction extends BaseActionMethod<Unit> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public InteractGiftPanelAction() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r110) {
        String r100 = "";
        int r101 = 2;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L31
        if (r110 == null) goto L11;
        Object r104 = r110.get(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID);     // Catch: Throwable -> L31
        if (r104 == null) goto L11;
        String r105 = r104.toString();     // Catch: Throwable -> L31
        if (r105 == null) goto L11;
        Long r106 = Long.valueOf(CastLongProtector.parseLong(r105));     // Catch: Throwable -> L31
    L12:
        if (r110 != null) goto L35;
    L20:
        if (r110 == null) goto L29;
        Object r111 = r110.get("click_from");     // Catch: Throwable -> L18
        if (r111 == null) goto L29;
        String r112 = r111.toString();     // Catch: Throwable -> L18
        if (r112 == null) goto L29;
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r100 = r112;
    L27:
        th = move-exception;
        r102 = r106;
        r100 = r112;
        th = th;
    L32:
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        String r108 = r100;
        int r109 = r101;
        Long r113 = r102;
    L33:
        ((IGiftCoreService) k.n(IGiftCoreService.class)).openInteractGiftDialog(null, r109, r113, r108, null, null);
        return;
    L29:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L18
        r108 = r100;
        r109 = r101;
        r113 = r106;
    L18:
        th = th;
        r102 = r106;
        goto L32
    L35:
        Object r114 = r110.get("source_from");     // Catch: Throwable -> L18
        if (r114 == null) goto L20;
        String r115 = r114.toString();     // Catch: Throwable -> L18
        if (r115 == null) goto L20;
        r101 = CastIntegerProtector.parseInt(r115);     // Catch: Throwable -> L18
    L11:
        r106 = null;
    L31:
        th = th;
        goto L32
    }
}
