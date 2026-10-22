package A3;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.path.PathType;
import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.ToolHelper;
import io.modelcontextprotocol.spec.McpClientSession;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;
import reactor.core.publisher.MonoSink;
import reactor.util.context.Context;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f93a;

    public /* synthetic */ b(int i) {
        this.f93a = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f93a) {
            case 0:
                StringBuilder sb = (StringBuilder) obj;
                sb.append(".");
                sb.append(PathType.a((String) obj2));
                return;
            case 1:
                StringBuilder sb2 = (StringBuilder) obj;
                sb2.append("[");
                sb2.append((Integer) obj2);
                sb2.append("]");
                return;
            case 2:
                StringBuilder sb3 = (StringBuilder) obj;
                String strReplace = (String) obj2;
                if (strReplace.isEmpty()) {
                    throw new IllegalArgumentException("A JSONPath selector cannot be empty");
                }
                IntPredicate intPredicate = d.f95a;
                if (strReplace.isEmpty()) {
                    throw new IllegalArgumentException("A JSONPath selector cannot be empty");
                }
                if (d.f95a.test(strReplace.codePointAt(0)) && strReplace.codePoints().skip(1L).allMatch(d.b)) {
                    sb3.append(".");
                    sb3.append(strReplace);
                    return;
                }
                if (strReplace.indexOf(39) != -1) {
                    strReplace = strReplace.replace("'", "\\'");
                }
                String strA = PathType.a(strReplace);
                sb3.append("['");
                sb3.append(strA);
                sb3.append("']");
                return;
            case 3:
                StringBuilder sb4 = (StringBuilder) obj;
                sb4.append("[");
                sb4.append((Integer) obj2);
                sb4.append("]");
                return;
            case 4:
                StringBuilder sb5 = (StringBuilder) obj;
                String strReplace2 = (String) obj2;
                if (strReplace2.indexOf(126) != -1) {
                    strReplace2 = strReplace2.replace("~", JsonPointer.ESC_TILDE);
                }
                if (strReplace2.indexOf(47) != -1) {
                    strReplace2 = strReplace2.replace("/", JsonPointer.ESC_SLASH);
                }
                String strA2 = PathType.a(strReplace2);
                sb5.append("/");
                sb5.append(strA2);
                return;
            case 5:
                StringBuilder sb6 = (StringBuilder) obj;
                sb6.append("/");
                sb6.append((Integer) obj2);
                return;
            case 6:
                StringBuilder sb7 = (StringBuilder) obj;
                String str = (String) obj2;
                if (sb7.length() == 0) {
                    sb7.append(str);
                    return;
                } else {
                    sb7.append("/");
                    sb7.append(str);
                    return;
                }
            case 7:
                StringBuilder sb8 = (StringBuilder) obj;
                sb8.append("/");
                sb8.append((Integer) obj2);
                return;
            case 8:
                ((ArrayNode) obj).add((JsonNode) obj2);
                return;
            case 9:
                ToolHelper.lambda$destroy$0((String) obj, (AndroidMCPClient) obj2);
                return;
            case 10:
                McpClientSession.lambda$dismissPendingResponses$1(obj, (MonoSink) obj2);
                return;
            default:
                Context.lambda$of$0(obj, obj2);
                return;
        }
    }
}
