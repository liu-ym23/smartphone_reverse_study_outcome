package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.LocalBroadcastManager;

/* JADX INFO: loaded from: classes.dex */
class LocalBroadcastManager$1 extends Handler {
    final /* synthetic */ LocalBroadcastManager this$0;

    LocalBroadcastManager$1(LocalBroadcastManager r1, Looper r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        if (r3.what == 1) goto L5;
        super.handleMessage(r3);
        return;
    L5:
        this.this$0.executePendingBroadcasts();
    }
}
