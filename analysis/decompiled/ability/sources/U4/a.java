package U4;

import C7.r;
import S7.n;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.chat.ChatCallback;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.data.TextContent;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1271a;
    public final /* synthetic */ StringBuilder b;
    public final /* synthetic */ IBundleCallback c;

    public /* synthetic */ a(int i, IBundleCallback iBundleCallback, StringBuilder sb) {
        this.f1271a = i;
        this.b = sb;
        this.c = iBundleCallback;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        TextContent r5 = (TextContent) obj2;
        switch (this.f1271a) {
            case 0:
                k.f(str, "<unused var>");
                k.f(r5, "r");
                this.b.append(r5.getText());
                Bundle bundle = new Bundle();
                bundle.putString("token_next", r5.getText());
                bundle.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
                this.c.onCall(bundle);
                break;
            default:
                k.f(str, "<unused var>");
                k.f(r5, "r");
                this.b.append(r5.getText());
                Bundle bundle2 = new Bundle();
                bundle2.putString("token_next", r5.getText());
                bundle2.putBoolean(ChatCallback.KEY_SESSION_DONE, false);
                this.c.onCall(bundle2);
                break;
        }
        return r.f317a;
    }
}
