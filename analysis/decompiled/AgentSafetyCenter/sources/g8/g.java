package g8;

import io.modelcontextprotocol.spec.DefaultMcpTransportStream;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.io.LineNumberReader;
import java.util.BitSet;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4382c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4383f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4384g;

    public /* synthetic */ g(int i) {
        this.f4382c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4382c) {
            case 0:
                Function function = (Function) this.f4383f;
                LineNumberReader lineNumberReader = (LineNumberReader) this.f4384g;
                String str = (String) obj;
                if (str.isEmpty() || '#' == str.charAt(0)) {
                    return;
                }
                String[] strArrSplit = str.split("\\s*[;#]\\s*", 3);
                BitSet bitSet = (BitSet) function.apply(strArrSplit[1]);
                if (bitSet != null) {
                    String[] strArrSplit2 = strArrSplit[0].split("\\.\\.");
                    int length = strArrSplit2.length;
                    if (length == 1) {
                        bitSet.set(Integer.parseUnsignedInt(strArrSplit2[0], 16));
                        return;
                    } else {
                        if (length == 2) {
                            bitSet.set(Integer.parseUnsignedInt(strArrSplit2[0], 16), Integer.parseUnsignedInt(strArrSplit2[1], 16) + 1);
                            return;
                        }
                        throw new IllegalStateException("Unable to parse integer range on line " + lineNumberReader.getLineNumber());
                    }
                }
                return;
            case 1:
                ((DefaultMcpTransportStream) this.f4383f).lambda$consumeSseStream$2((ContextView) this.f4384g, (Throwable) obj);
                return;
            default:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.f4383f).lambda$sendRequest$3((String) this.f4384g, (Throwable) obj);
                return;
        }
    }
}
