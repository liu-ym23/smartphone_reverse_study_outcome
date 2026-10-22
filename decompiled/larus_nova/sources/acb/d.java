package acb;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushSaveToSpaceStoreStateResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements com.ss.android.lark.sdk.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f2906a;

    public class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2907a;

        public a(d r100) {
            this.f2907a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            PushSaveToSpaceStoreStateResponse r101 = PushSaveToSpaceStoreStateResponse.ADAPTER.decode(r100);     // Catch: Exception -> L4
            String r102 = r101.message_id;     // Catch: Exception -> L4
            int r103 = r101.state.getValue();     // Catch: Exception -> L4
            CoreThreadPool.getDefault().getUIExecutor().execute(new c(this, r102, r103));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            tt5.a.f(e.getMessage(), e, false);
        }
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        g.e.f439875a.b(Command.PUSH_SAVE_TO_SPACE_STORE_STATE, new a(this));
    }

    public d(e r100) {
        this.f2906a = r100;
    }
}
