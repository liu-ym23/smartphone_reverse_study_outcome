package Q4;

import C7.r;
import S7.o;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.algorithm.privacyguard.PrivacyGuardCallback;
import com.stepos.aiengine.api.task.IBundleCallback;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1107a;
    public final /* synthetic */ IBundleCallback b;

    public /* synthetic */ d(IBundleCallback iBundleCallback, int i) {
        this.f1107a = i;
        this.b = iBundleCallback;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f1107a;
        String str = (String) obj;
        int iIntValue = ((Integer) obj2).intValue();
        String msg = (String) obj3;
        switch (i) {
            case 0:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle = new Bundle();
                bundle.putString("exception", msg);
                bundle.putInt("error_code", iIntValue);
                this.b.onCall(bundle);
                break;
            case 1:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle2 = new Bundle();
                bundle2.putString("exception", msg);
                bundle2.putInt("error_code", iIntValue);
                this.b.onCall(bundle2);
                break;
            case 2:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle3 = new Bundle();
                bundle3.putString(GuiAgentCallback.KEY_EXCEPTION, msg);
                bundle3.putInt(GuiAgentCallback.KEY_ERROR_CODE, iIntValue);
                this.b.onCall(bundle3);
                break;
            case 3:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle4 = new Bundle();
                bundle4.putString("exception", msg);
                bundle4.putInt("error_code", iIntValue);
                bundle4.putBoolean(HighlightCallback.KEY_DONE, true);
                this.b.onCall(bundle4);
                break;
            case 4:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle5 = new Bundle();
                bundle5.putString(PrivacyGuardCallback.KEY_EXCEPTION, msg);
                bundle5.putInt(PrivacyGuardCallback.KEY_ERROR_CODE, iIntValue);
                this.b.onCall(bundle5);
                break;
            case 5:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle6 = new Bundle();
                bundle6.putString("exception", msg);
                bundle6.putInt("error_code", iIntValue);
                this.b.onCall(bundle6);
                break;
            default:
                kotlin.jvm.internal.k.f(str, "<unused var>");
                kotlin.jvm.internal.k.f(msg, "msg");
                Bundle bundle7 = new Bundle();
                bundle7.putString("exception", msg);
                bundle7.putInt("error_code", iIntValue);
                this.b.onCall(bundle7);
                break;
        }
        return r.f317a;
    }
}
