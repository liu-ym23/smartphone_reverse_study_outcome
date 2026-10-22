package com.bytedance.android.livesdk.chatroom.record;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.IRecordService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/livesdk/chatroom/record/RecordServiceController$serviceController$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/chatroom/record/RecordServiceController$serviceController$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RecordServiceController$serviceController$2 extends Lambda implements Function0<a> {
    final /* synthetic */ y this$0;

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordServiceController$serviceController$2 f108041a;

        public a(RecordServiceController$serviceController$2 r100) {
            this.f108041a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            this.f108041a.this$0.getClass();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            y r102 = this.f108041a.this$0;
            if ((r101 instanceof IRecordService) == true) goto L5;
            r101 = null;
        L5:
            IRecordService r103 = (IRecordService) r101;
            r102.getClass();
            if (r103 != null) goto L8;
            return;
        L8:
            r103.startRecord(null);
        }
    }

    public RecordServiceController$serviceController$2(y r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
