package com.bytedance.android.live.lynx.ui;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", LynxError.LYNX_THROWABLE, "", "isDebug", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer$setSrc$1$2"}, k = 3, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$2 extends Lambda implements Function2<Throwable, Boolean, Unit> {
    final /* synthetic */ String $directUrl$inlined;
    final /* synthetic */ LiveLynxAlphaPlayer this$0;

    public LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$2(LiveLynxAlphaPlayer r100, String r101) {
        this.this$0 = r100;
        this.$directUrl$inlined = r101;
        super(2);
    }

    public final void invoke(Throwable r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        String r102 = "failed when use resource loader to load " + this.this$0.f82677g + ", and error msg " + String.valueOf(r100.getMessage());
        if (r101 == false) goto L6;
        LLog.i("x-alpha-video", r102);
        this.this$0.R(this.$directUrl$inlined);
        return;
    L6:
        LiveLynxAlphaPlayer r103 = this.this$0;
        r103.Q(r102, r103.f82677g, -11);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
