package g4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lg4/k;", "", "<init>", "()V", "", "tool_call_id", "Ljava/lang/String;", "getTool_call_id", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "output", "Ljava/lang/Object;", "getOutput", "()Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class k {
    private Object output;
    private String tool_call_id;

    public final void a(Object obj) {
        this.output = obj;
    }

    public final void b(String str) {
        this.tool_call_id = str;
    }
}
