package com.bytedance.android.live.revlink.impl.kmpwidget;

import android.content.res.Configuration;
import b03.b;
import com.bytedance.android.live.revlink.scopeui.KmpWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/kmpwidget/KmpLiveWidget;", "Lcom/bytedance/android/live/revlink/scopeui/KmpWidget;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KmpLiveWidget extends KmpWidget {
    public KmpLiveWidget() {
    }

    @Override // com.bytedance.android.live.revlink.scopeui.KmpWidget
    public final b wq(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof Configuration) == true) goto L7;
        return null;
    L7:
        return zr0.b.a((Configuration) r100);
    }
}
