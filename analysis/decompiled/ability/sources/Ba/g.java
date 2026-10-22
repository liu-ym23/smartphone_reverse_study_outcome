package Ba;

import com.mdisdk.observer.DisplayObserverManager;
import com.networknt.schema.InvalidSchemaException;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpStreamableServerTransport;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import stepai.aios.guiagent.llm.cell.LocalModelCell;
import stepai.aios.guiagent.llm.cell.StepGelabModelCell;
import t5.C2016a;
import u3.C2036b;
import u3.k;
import w3.C2096a;
import w3.C2097b;
import w9.InterfaceC2108a;

/* loaded from: classes4.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f271a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f271a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f271a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return (AtomicBoolean) ((f) obj2).invoke(obj);
            case 1:
                return ((McpClientTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 2:
                return ((McpClientSession) obj2).lambda$new$0((Mono) obj);
            case 3:
                return ((McpServerTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 4:
                return ((McpStreamableServerTransport) obj2).sendMessage((McpSchema.JSONRPCResponse) obj);
            case 5:
                return ((Mono) obj2).thenReturn(obj);
            case 6:
                return DisplayObserverManager.addTaskObserverId$lambda$7((m5.a) obj2, obj);
            case 7:
                return LocalModelCell.getSessionState$lambda$1((m5.a) obj2, obj);
            case 8:
                return StepGelabModelCell.getSessionState$lambda$1((m5.a) obj2, obj);
            case 9:
                C2097b c2097b = (C2097b) obj2;
                if (c2097b.f6840a.equals((String) obj)) {
                    return c2097b;
                }
                return null;
            case 10:
                String str = (String) obj;
                try {
                    return Z0.a.G(str, (k) obj2).d();
                } catch (InvalidSchemaException e) {
                    throw e;
                } catch (Exception e6) {
                    C2036b c2036b = new C2036b();
                    c2036b.g = "Failed to load dialect ''{0}''";
                    c2036b.e = new Object[]{str};
                    InvalidSchemaException invalidSchemaException = new InvalidSchemaException(c2036b.a());
                    invalidSchemaException.initCause(e6);
                    throw invalidSchemaException;
                }
            case 11:
                return (InterfaceC2108a) ((C2016a) obj2).invoke(obj);
            default:
                return new MessageFormat((String) obj, (Locale) obj2);
        }
    }

    public /* synthetic */ g(C2096a c2096a, k kVar) {
        this.f271a = 10;
        this.b = kVar;
    }
}
