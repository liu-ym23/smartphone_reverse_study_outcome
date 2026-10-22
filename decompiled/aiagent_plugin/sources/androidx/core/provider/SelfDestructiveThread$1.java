package androidx.core.provider;

import android.os.Handler;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class SelfDestructiveThread$1 implements Handler.Callback {
    final /* synthetic */ f this$0;

    SelfDestructiveThread$1(f r1) {
        this.this$0 = r1;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        int r0 = r4.what;
        if (r0 == 0) goto L8;
        if (r0 == 1) goto L6;
        return true;
    L6:
        this.this$0.a((Runnable) ZeusTransformUtils.preCheckCast(r4.obj, Runnable.class, "com.obric.aiagent.plugin"));
        return true;
    L8:
        this.this$0.a();
        return true;
    }
}
