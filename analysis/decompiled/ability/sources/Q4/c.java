package Q4;

import C7.r;
import S7.n;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.algorithm.privacyguard.PrivacyGuardCallback;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.data.TextContent;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1106a;
    public final /* synthetic */ IBundleCallback b;

    public /* synthetic */ c(IBundleCallback iBundleCallback, int i) {
        this.f1106a = i;
        this.b = iBundleCallback;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        TextContent r5 = (TextContent) obj2;
        switch (this.f1106a) {
            case 0:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                Bundle bundle = new Bundle();
                bundle.putString("token_next", r5.getText());
                bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
                this.b.onCall(bundle);
                break;
            case 1:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                Bundle bundle2 = new Bundle();
                bundle2.putString("token_next", r5.getText());
                bundle2.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
                this.b.onCall(bundle2);
                break;
            case 2:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                Bundle bundle3 = new Bundle();
                bundle3.putString(GuiAgentCallback.KEY_TOKEN_NEXT, r5.getText());
                bundle3.putBoolean(GuiAgentCallback.KEY_DONE, false);
                this.b.onCall(bundle3);
                break;
            case 3:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                Bundle bundle4 = new Bundle();
                bundle4.putString("token_next", r5.getText());
                bundle4.putBoolean(HighlightCallback.KEY_DONE, false);
                this.b.onCall(bundle4);
                break;
            default:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(r5, "r");
                Bundle bundle5 = new Bundle();
                bundle5.putString(PrivacyGuardCallback.KEY_TOKEN_NEXT, r5.getText());
                bundle5.putBoolean(PrivacyGuardCallback.KEY_DONE, false);
                this.b.onCall(bundle5);
                break;
        }
        return r.f317a;
    }
}
