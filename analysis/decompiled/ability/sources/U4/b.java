package U4;

import C7.r;
import S7.k;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.api.task.IBundleCallback;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1272a;
    public final /* synthetic */ IBundleCallback b;
    public final /* synthetic */ StringBuilder c;

    public /* synthetic */ b(int i, IBundleCallback iBundleCallback, StringBuilder sb) {
        this.f1272a = i;
        this.b = iBundleCallback;
        this.c = sb;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        String str = (String) obj;
        switch (this.f1272a) {
            case 0:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle = new Bundle();
                bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
                bundle.putString(ChatCallback.KEY_SESSION_OUTPUT, this.c.toString());
                this.b.onCall(bundle);
                break;
            default:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
                bundle2.putString(ChatCallback.KEY_SESSION_OUTPUT, this.c.toString());
                this.b.onCall(bundle2);
                break;
        }
        return r.f317a;
    }
}
