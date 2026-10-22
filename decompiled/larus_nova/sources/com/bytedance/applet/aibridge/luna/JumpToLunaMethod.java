package com.bytedance.applet.aibridge.luna;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.m.p.e;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tx9.v1;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applet/aibridge/luna/JumpToLunaMethod;", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL$JumpToLunaMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/luna/AbsJumpToLunaMethodIDL$JumpToLunaMethodResultModel;", "handleVipScene", "jumpLuna", "callbackFailure", "scene", "", e.f25671s, "errorMsg", "startActivityByUrl", "", "url", "Landroid/net/Uri;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JumpToLunaMethod extends AbsJumpToLunaMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f191188b = 0;

    public static final class a {
    }

    static {
    }

    public JumpToLunaMethod() {
    }

    public static boolean c(Uri r100, h r101, String r102) {
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r100);
        Activity r104 = AppHost.f326268a.a().getCurrentActivity();
        if (r104 != null) goto L6;
        b("member", r102, "current_activity_not_found", r101);
        return false;
    L6:
        r104.startActivity(r103);
        return true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r110) {
        AbsJumpToLunaMethodIDL.a r102 = (AbsJumpToLunaMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (Intrinsics.areEqual(r102.getScene(), "member") == false) goto L18;
        AppHost.Companion r103 = AppHost.f326268a;
        Activity r104 = r103.a().getCurrentActivity();
        if ((r104 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r105 = (FragmentActivity) r104;
    L8:
        Resources r106 = r103.getApplication().getResources();
        if (r105 == null) goto L17;
        if (r106 == null) goto L17;
        FragmentManager r107 = r105.getSupportFragmentManager();
        CommonDialog.a r108 = new CommonDialog.a();
        r108.i(r106.getString(R.string.larus_music_luna_toast));
        CommonDialog.a.f(r108, new com.bytedance.applet.aibridge.luna.a(this, r100, r102, r110), r106.getString(R.string.larus_music_luna_confirm), false, 12);
        CommonDialog.a.e(r108, new b(r110), r106.getString(R.string.larus_music_luna_cancel), 4);
        CommonDialog r109 = r108.d(ContextCompat.getColor(r105, R.color.larus_primary_50));
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, null, r111);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r109, r111) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L16:
        r109.show(r107, null);
        return;
    L25:
        return;
    L17:
        b("member", "unknown", "context_error", r110);
        return;
    L7:
        r105 = null;
        goto L8
    L18:
        b("unknown", "unknown", "wrong_scene:" + r102.getScene(), r110);
    }

    public static void b(String r100, String r101, String r102, h r103) {
        FLogger.f375446a.i("JumpToLunaMethod", r100 + " try " + r101 + " fail, errorMsg: " + r102);
        v1.a(r100, r101, 0, r102, 48);
        h.a.a(r103, r102, null, null, 14);
    }
}
