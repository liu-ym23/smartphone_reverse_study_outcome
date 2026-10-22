package L4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0014B\u001b\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\u0082\u0001\u0001\u0015¨\u0006\u0016"}, d2 = {"LL4/c;", "", "", "key", "", "defaultPriority", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getKey", "I", "getDefaultPriority", Const.INTENT_KEY_APIKEY, "LL4/c$a;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: L4.c, reason: from toString */
/* loaded from: classes2.dex */
public abstract class AgentEmotion {
    private final int defaultPriority;
    private final String key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/c$a;", "LL4/c;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.c$a */
    public static final /* data */ class a extends AgentEmotion {
        public static final a INSTANCE = new a();

        private a() {
            super("neutral", 0, null);
        }
    }

    public /* synthetic */ AgentEmotion(String str, int i10, kotlin.jvm.internal.i iVar) {
        this(str, i10);
    }

    public final boolean equals(Object other) {
        return (other instanceof AgentEmotion) && kotlin.jvm.internal.p.d(((AgentEmotion) other).key, this.key);
    }

    public final int getDefaultPriority() {
        return this.defaultPriority;
    }

    public final String getKey() {
        return this.key;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final String toString() {
        return "AgentEmotion(" + this.key + ")";
    }

    private AgentEmotion(String str, int i10) {
        this.key = str;
        this.defaultPriority = i10;
    }

    public /* synthetic */ AgentEmotion(String str, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(str, (i11 & 2) != 0 ? 2 : i10, null);
    }
}
