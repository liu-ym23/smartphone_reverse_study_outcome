package com.bytedance.android.live.lynx.ui;

import com.bytedance.ies.xelement.api.XResourceFrom;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lf76/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lf76/c;)V", "com/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer$setSrc$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$1 extends Lambda implements Function1<f76.c, Unit> {
    final /* synthetic */ String $directUrl$inlined;
    final /* synthetic */ LiveLynxAlphaPlayer this$0;

    public LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$1(LiveLynxAlphaPlayer r100, String r101) {
        this.this$0 = r100;
        this.$directUrl$inlined = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f76.c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LiveLynxAlphaPlayer r101 = this.this$0;
        int r102 = LiveLynxAlphaPlayer.f82670h;
        r101.getClass();
        LiveLynxAlphaPlayer r103 = this.this$0;
        XResourceFrom r104 = r100.f475772d;
        r103.getClass();
        LLog.i("x-alpha-video", "load resource success: " + r100.f475770b + ", " + r100.f475771c);
        XResourceFrom r105 = r100.f475772d;
        if (r105 == null) goto L22;
        int r106 = b.f82731a[r105.ordinal()];
        if (r106 != 1) goto L8;
    L15:
        String r107 = r100.f475770b;
        if (r107 == null) goto L21;
        LiveLynxAlphaPlayer.N(this.this$0, r107, this.$directUrl$inlined);
        return;
    L21:
        return;
    L8:
        if (r106 == 2) goto L15;
        if (r106 != 3) goto L23;
        String r108 = r100.f475770b;
        if (r108 == null) goto L19;
        this.this$0.R(r108);
        return;
    L19:
        return;
    L23:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f76.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
