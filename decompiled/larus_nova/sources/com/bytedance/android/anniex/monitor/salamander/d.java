package com.bytedance.android.anniex.monitor.salamander;

import com.bytedance.salamander.anniex.i7;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f41014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f41015b;

    public d(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f41014a = r100;
        this.f41015b = SetsKt.setOf(new Integer[]{2, 11, 3});
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onReceivedError(LynxError r100) {
        super.onReceivedError(r100);
        SLMonitorCompat.f41001a.getClass();
        if (SLMonitorCompat.f41002b == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L11;
        int r101 = r100.getErrorCode() / 100;
        if (this.f41015b.contains(Integer.valueOf(r101)) == false) goto L9;
        return;
    L9:
        String r102 = this.f41014a.invoke();
        i7 r103 = new i7();
        r103.f268125a = r100.getErrorCode();
        String r104 = r100.getMsg();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f268126b = r104;
        String r105 = SLMonitorCompat.NativeErrorScene.LynxError.getValue();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r103.f268127c = r105;
        Unit r106 = Unit.INSTANCE;
        SLMonitorCompat.o(r102, r103);
        return;
    }
}
