package com.bytedance.ai.applet.app.foundation;

import android.os.Bundle;
import android.os.ResultReceiver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {
    public static final void a(ResultReceiver r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Bundle r102 = new Bundle();
        r102.putString("error_msg", r101);
        r100.send(1, r102);
    }
}
