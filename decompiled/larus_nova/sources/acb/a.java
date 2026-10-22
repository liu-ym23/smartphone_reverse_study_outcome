package acb;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PushSaveToNutStoreStateResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements com.ss.android.lark.sdk.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f2898a;

    /* JADX INFO: renamed from: acb.a$a, reason: collision with other inner class name */
    public class C0052a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2899a;

        public C0052a(a r100) {
            this.f2899a = r100;
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            e r101 = this.f2899a.f2898a;
            r101.getClass();
            PushSaveToNutStoreStateResponse r102 = PushSaveToNutStoreStateResponse.ADAPTER.decode(r100);     // Catch: Exception -> L5
            String r103 = r102.message_id;     // Catch: Exception -> L5
            int r104 = r102.state.getValue();     // Catch: Exception -> L5
            CoreThreadPool.getDefault().getUIExecutor().execute(new b(r101, r103, r104));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            tt5.a.f(e.getMessage(), e, false);
        }
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        g.e.f439875a.b(Command.PUSH_SAVE_TO_NUT_STORE_STATE, new C0052a(this));
    }

    public a(e r100) {
        this.f2898a = r100;
    }
}
