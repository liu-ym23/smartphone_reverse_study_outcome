package Q4;

import C7.r;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.algorithm.privacyguard.PrivacyGuardCallback;
import com.stepos.aiengine.api.task.IBundleCallback;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1108a;
    public final /* synthetic */ IBundleCallback b;

    public /* synthetic */ e(IBundleCallback iBundleCallback, int i) {
        this.f1108a = i;
        this.b = iBundleCallback;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        String str = (String) obj;
        switch (this.f1108a) {
            case 0:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle = new Bundle();
                bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
                this.b.onCall(bundle);
                break;
            case 1:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(ChatCallback.KEY_SESSION_DONE, true);
                this.b.onCall(bundle2);
                break;
            case 2:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(GuiAgentCallback.KEY_DONE, true);
                this.b.onCall(bundle3);
                break;
            case 3:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean(HighlightCallback.KEY_DONE, true);
                this.b.onCall(bundle4);
                break;
            default:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                Bundle bundle5 = new Bundle();
                bundle5.putBoolean(PrivacyGuardCallback.KEY_DONE, true);
                this.b.onCall(bundle5);
                break;
        }
        return r.f317a;
    }
}
