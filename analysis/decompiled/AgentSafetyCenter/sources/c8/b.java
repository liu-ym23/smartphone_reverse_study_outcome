package c8;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.ToolHelper;
import g5.f;
import io.modelcontextprotocol.spec.McpClientSession;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;
import reactor.core.publisher.MonoSink;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2228c;

    public /* synthetic */ b(int i) {
        this.f2228c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f2228c) {
            case 0:
                StringBuilder sb2 = (StringBuilder) obj;
                sb2.append(".");
                sb2.append(e.a((String) obj2));
                break;
            case 1:
                StringBuilder sb3 = (StringBuilder) obj;
                sb3.append("[");
                sb3.append((Integer) obj2);
                sb3.append("]");
                break;
            case 2:
                StringBuilder sb4 = (StringBuilder) obj;
                String strReplace = (String) obj2;
                if (!strReplace.isEmpty()) {
                    IntPredicate intPredicate = d.f2230a;
                    if (!strReplace.isEmpty()) {
                        if (!d.f2230a.test(strReplace.codePointAt(0)) || !strReplace.codePoints().skip(1L).allMatch(d.f2231b)) {
                            if (strReplace.indexOf(39) != -1) {
                                strReplace = strReplace.replace("'", "\\'");
                            }
                            String strA = e.a(strReplace);
                            sb4.append("['");
                            sb4.append(strA);
                            sb4.append("']");
                            break;
                        } else {
                            sb4.append(".");
                            sb4.append(strReplace);
                            break;
                        }
                    } else {
                        f.s("A JSONPath selector cannot be empty");
                        break;
                    }
                } else {
                    f.s("A JSONPath selector cannot be empty");
                    break;
                }
                break;
            case 3:
                StringBuilder sb5 = (StringBuilder) obj;
                sb5.append("[");
                sb5.append((Integer) obj2);
                sb5.append("]");
                break;
            case 4:
                StringBuilder sb6 = (StringBuilder) obj;
                String strReplace2 = (String) obj2;
                if (strReplace2.indexOf(126) != -1) {
                    strReplace2 = strReplace2.replace("~", JsonPointer.ESC_TILDE);
                }
                if (strReplace2.indexOf(47) != -1) {
                    strReplace2 = strReplace2.replace("/", JsonPointer.ESC_SLASH);
                }
                String strA2 = e.a(strReplace2);
                sb6.append("/");
                sb6.append(strA2);
                break;
            case 5:
                StringBuilder sb7 = (StringBuilder) obj;
                sb7.append("/");
                sb7.append((Integer) obj2);
                break;
            case 6:
                StringBuilder sb8 = (StringBuilder) obj;
                String str = (String) obj2;
                if (sb8.length() == 0) {
                    sb8.append(str);
                    break;
                } else {
                    sb8.append("/");
                    sb8.append(str);
                    break;
                }
            case 7:
                StringBuilder sb9 = (StringBuilder) obj;
                sb9.append("/");
                sb9.append((Integer) obj2);
                break;
            case 8:
                ((ArrayNode) obj).add((JsonNode) obj2);
                break;
            case 9:
                ToolHelper.lambda$destroy$0((String) obj, (AndroidMCPClient) obj2);
                break;
            case 10:
                McpClientSession.lambda$dismissPendingResponses$1(obj, (MonoSink) obj2);
                break;
            default:
                Context.lambda$of$0(obj, obj2);
                break;
        }
    }
}
