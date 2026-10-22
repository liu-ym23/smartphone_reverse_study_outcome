package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.lynx.tasm.LynxError;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends LiveWebShareCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f100290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveWebShareParams f100291b;

    @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
    public final void onRefresh() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onFail(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        ALogger.e("ShareFullParamsMethod", r100);
    }

    public c(b r100, LiveWebShareParams r101) {
        this.f100290a = r100;
        this.f100291b = r101;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onSuccess(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "shareType");
        if (this.f100291b.getNeedShareCallback() == true) goto L5;
    L9:
        b r102 = this.f100290a;
        r102.getClass();
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12
        r103.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r100);     // Catch: Exception -> L12
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L12
        r102.finishWithResult(r103);     // Catch: Exception -> L12
        return;
    L12:
        r102.finishWithResult(new JSONObject());
        return;
    L5:
        if (this.f100291b.getUseReturnData() == false) goto L9;
        if (Intrinsics.areEqual(r100, "chat_merge") == false) goto L9;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
    public final void onSuccessWithExtra(String r100, String r101, Map<String, List<String>> r102) {
        if (this.f100291b.getNeedShareCallback() == true) goto L5;
    L13:
        b r103 = this.f100290a;
        JSONObject r104 = new JSONObject();
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r100);
        Unit r105 = Unit.INSTANCE;
        r103.finishWithResult(r104);
        return;
    L5:
        if (this.f100291b.getUseReturnData() == false) goto L13;
        if (Intrinsics.areEqual(r100, "chat_merge") == false) goto L13;
        b r106 = this.f100290a;
        r106.getClass();
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L11
        r107.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r100);     // Catch: Exception -> L11
        Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L11
        r106.finishWithResult(r107);     // Catch: Exception -> L11
        return;
    L11:
        r106.finishWithResult(new JSONObject());
    }
}
