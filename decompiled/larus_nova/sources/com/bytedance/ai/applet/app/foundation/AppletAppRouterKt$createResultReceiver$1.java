package com.bytedance.ai.applet.app.foundation;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/bytedance/ai/applet/app/foundation/AppletAppRouterKt$createResultReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Landroid/os/Bundle;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppRouterKt$createResultReceiver$1 extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Result<Unit>, Unit> f34187a;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletAppRouterKt$createResultReceiver$1(Function1<? super Result<Unit>, Unit> r100, Handler r101) {
        this.f34187a = r100;
        super(r101);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r100, Bundle r101) {
        if (r100 != 0) goto L4;
        Function1<Result<Unit>, Unit> r102 = this.f34187a;
        Result.Companion r103 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)));
        return;
    L4:
        if (r101 == null) goto L7;
        String r104 = r101.getString("error_msg");
        if (r104 == null) goto L7;
    L8:
        Function1<Result<Unit>, Unit> r105 = this.f34187a;
        Result.Companion r106 = Result.Companion;
        r105.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException(r104)))));
        return;
    L7:
        r104 = "Unknown error";
        goto L8
    }
}
