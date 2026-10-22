package com.obric.matrix.platform.sdk.ones.settings;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: MatrixSettingsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MatrixSettingsManager$registerSettingsObserver$observer$1 extends ContentObserver {
    final /* synthetic */ MatrixSettingsManager this$0;

    MatrixSettingsManager$registerSettingsObserver$observer$1(MatrixSettingsManager r1, Handler r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r3, Uri r4) {
        super.onChange(r3, r4);
        com.obric.matrix.platform.sdk.ones.account.b.a.b("MatrixSettingsManager", "Settings provider updated, refreshing...");
        this.this$0.a();
        String r5 = MatrixSettingsManager.a(this.this$0);
        if (r5 != null) goto L5;
        r5 = null;
    L5:
        com.obric.matrix.platform.sdk.ones.account.b.a.b("MatrixSettingsManager", "settings刷新了，通知所有listener");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(MatrixSettingsManager.b(this.this$0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin")).a(r5);
        goto L7
    }
}
