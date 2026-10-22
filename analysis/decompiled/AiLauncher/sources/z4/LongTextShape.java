package z4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u0000 '2\u00020\u0001:\u0001\u000fBG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\u0010R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b#\u0010\u0010R\u0011\u0010&\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lz4/g;", "", "", "parts", "", "textChars", "thinkingChars", "maxTextChars", "lastChars", "prefixChars", "", "lastType", "partShape", "<init>", "(IJJIIJLjava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getParts", "J", "getTextChars", "()J", "getThinkingChars", "getMaxTextChars", "getLastChars", "getPrefixChars", "Ljava/lang/String;", "getLastType", "getPartShape", Const.INTENT_KEY_PKGNAME, "()Z", "isLong", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z4.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class LongTextShape {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int lastChars;
    private final String lastType;
    private final int maxTextChars;
    private final String partShape;
    private final int parts;
    private final long prefixChars;
    private final long textChars;
    private final long thinkingChars;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lz4/g$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/N1;", "message", "Lz4/g;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/N1;)Lz4/g;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z4.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final z4.LongTextShape a(com.stepos.agentframework.chatui.DisplayMessage r23) {
            /*
                Method dump skipped, instructions count: 310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: z4.LongTextShape.Companion.a(com.stepos.agentframework.chatui.N1):z4.g");
        }

        public Companion() {
        }
    }

    public LongTextShape(int i10, long j10, long j11, int i11, int i12, long j12, String lastType, String partShape) {
        p.i(lastType, "lastType");
        p.i(partShape, "partShape");
        this.parts = i10;
        this.textChars = j10;
        this.thinkingChars = j11;
        this.maxTextChars = i11;
        this.lastChars = i12;
        this.prefixChars = j12;
        this.lastType = lastType;
        this.partShape = partShape;
    }

    public final String a() {
        return "parts=" + this.parts + " textChars=" + this.textChars + " thinkingChars=" + this.thinkingChars + " maxTextChars=" + this.maxTextChars + " lastChars=" + this.lastChars + " prefixChars=" + this.prefixChars + " lastType=" + this.lastType + " partShape=" + this.partShape;
    }

    public final boolean b() {
        return this.textChars + this.thinkingChars >= 3072;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongTextShape)) {
            return false;
        }
        LongTextShape longTextShape = (LongTextShape) other;
        return this.parts == longTextShape.parts && this.textChars == longTextShape.textChars && this.thinkingChars == longTextShape.thinkingChars && this.maxTextChars == longTextShape.maxTextChars && this.lastChars == longTextShape.lastChars && this.prefixChars == longTextShape.prefixChars && p.d(this.lastType, longTextShape.lastType) && p.d(this.partShape, longTextShape.partShape);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.parts) * 31) + Long.hashCode(this.textChars)) * 31) + Long.hashCode(this.thinkingChars)) * 31) + Integer.hashCode(this.maxTextChars)) * 31) + Integer.hashCode(this.lastChars)) * 31) + Long.hashCode(this.prefixChars)) * 31) + this.lastType.hashCode()) * 31) + this.partShape.hashCode();
    }

    public String toString() {
        return "LongTextShape(parts=" + this.parts + ", textChars=" + this.textChars + ", thinkingChars=" + this.thinkingChars + ", maxTextChars=" + this.maxTextChars + ", lastChars=" + this.lastChars + ", prefixChars=" + this.prefixChars + ", lastType=" + this.lastType + ", partShape=" + this.partShape + ")";
    }
}
