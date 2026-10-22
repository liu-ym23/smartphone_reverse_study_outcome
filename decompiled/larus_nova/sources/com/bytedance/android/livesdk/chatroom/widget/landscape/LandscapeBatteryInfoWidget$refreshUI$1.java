package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LandscapeBatteryInfoWidget$refreshUI$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LandscapeBatteryInfoWidget this$0;

    public LandscapeBatteryInfoWidget$refreshUI$1(LandscapeBatteryInfoWidget r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LandscapeBatteryInfoWidget r100 = this.this$0;
        int r101 = (r100.f118840d * 100) / r100.f118839c;
        TextView r102 = r100.f118837a;
        if (r102 == null) goto L5;
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        r103.append('%');
        r102.setText(r103.toString());
    L5:
        LandscapeBatteryInfoWidget r104 = this.this$0;
        int r105 = r104.f118841e;
        if (r105 != 2) goto L8;
    L11:
        boolean r106 = true;
    L12:
        float r107 = r104.f118840d / r104.f118839c;
        if (r107 <= 1.0f) goto L15;
        r107 = 1.0f;
    L15:
        LandscapeBatteryView r108 = r104.f118838b;
        if (r108 == null) goto L19;
        r108.f118846b = r107;
        r108.f118847c = r106;
        r108.e();
        r108.invalidate();
        return;
    L19:
        return;
    L8:
        if (r105 == 5) goto L11;
        r106 = false;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
