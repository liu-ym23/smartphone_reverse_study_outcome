package E3;

import io.modelcontextprotocol.spec.DefaultMcpTransportStream;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.io.LineNumberReader;
import java.util.BitSet;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.util.context.ContextView;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f468a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.f468a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f468a) {
            case 0:
                Function function = (Function) this.b;
                LineNumberReader lineNumberReader = (LineNumberReader) this.c;
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
                    } else if (length == 2) {
                        bitSet.set(Integer.parseUnsignedInt(strArrSplit2[0], 16), Integer.parseUnsignedInt(strArrSplit2[1], 16) + 1);
                        return;
                    } else {
                        throw new IllegalStateException("Unable to parse integer range on line " + lineNumberReader.getLineNumber());
                    }
                }
                return;
            case 1:
                ((DefaultMcpTransportStream) this.b).lambda$consumeSseStream$2((ContextView) this.c, (Throwable) obj);
                return;
            default:
                ((McpStreamableServerSession.McpStreamableServerSessionStream) this.b).lambda$sendRequest$3((String) this.c, (Throwable) obj);
                return;
        }
    }
}
