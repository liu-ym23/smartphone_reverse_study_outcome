package M3;

import S7.k;
import android.util.Log;
import com.stepos.ability.beaninternal.ability.ProgressNotification;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpSession;
import java.util.function.Consumer;
import reactor.core.publisher.MonoSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f967a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(McpSession mcpSession, String str, MonoSink monoSink, int i) {
        this.f967a = i;
        this.c = mcpSession;
        this.b = str;
        this.d = monoSink;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f967a) {
            case 0:
                String str = (String) this.c;
                k kVar = (k) this.d;
                McpSchema.ProgressNotification progressNotification = (McpSchema.ProgressNotification) obj;
                Double dProgress = progressNotification.progress();
                StringBuilder sbW = B7.a.w("Receive ", this.b, " method:", str, " progress:");
                sbW.append(dProgress);
                Log.i("McpCallToolHandler", sbW.toString());
                Object objProgressToken = progressNotification.progressToken();
                Double dProgress2 = progressNotification.progress();
                kotlin.jvm.internal.k.e(dProgress2, "progress(...)");
                kVar.invoke(new ProgressNotification(objProgressToken, dProgress2.doubleValue(), progressNotification.total(), progressNotification.message(), progressNotification.meta()));
                break;
            case 1:
                ((McpClientSession) this.c).lambda$sendRequest$9(this.b, (MonoSink) this.d, (Throwable) obj);
                break;
            default:
                ((McpServerSession) this.c).lambda$sendRequest$1(this.b, (MonoSink) this.d, (Throwable) obj);
                break;
        }
    }

    public /* synthetic */ e(String str, String str2, k kVar) {
        this.f967a = 0;
        this.b = str;
        this.c = str2;
        this.d = kVar;
    }
}
