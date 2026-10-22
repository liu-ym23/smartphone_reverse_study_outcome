package L4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0007\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"LL4/h;", "", "", "key", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "LL4/h$a;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: L4.h, reason: from toString */
/* loaded from: classes2.dex */
public abstract class AgentSkin {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String key;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LL4/h$a;", "LL4/h;", "<init>", "()V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: L4.h$a */
    public static final /* data */ class a extends AgentSkin {

        /* renamed from: b, reason: collision with root package name */
        public static final a f4307b = new a();

        public a() {
            super("default", null);
        }
    }

    public /* synthetic */ AgentSkin(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    /* renamed from: a, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final boolean equals(Object other) {
        return (other instanceof AgentSkin) && kotlin.jvm.internal.p.d(((AgentSkin) other).key, this.key);
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final String toString() {
        return "AgentSkin(" + this.key + ")";
    }

    public AgentSkin(String str) {
        this.key = str;
    }
}
