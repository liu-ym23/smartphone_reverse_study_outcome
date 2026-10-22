package V5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LV5/a;", "", "", "type", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: V5.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class BubbleLog {
    private final String content;
    private final long time;
    private final String type;

    public BubbleLog(String type, String content, long j10) {
        p.i(type, "type");
        p.i(content, "content");
        this.type = type;
        this.content = content;
        this.time = j10;
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BubbleLog)) {
            return false;
        }
        BubbleLog bubbleLog = (BubbleLog) other;
        return p.d(this.type, bubbleLog.type) && p.d(this.content, bubbleLog.content) && this.time == bubbleLog.time;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "BubbleLog(type=" + this.type + ", content=" + this.content + ", time=" + this.time + ")";
    }

    public /* synthetic */ BubbleLog(String str, String str2, long j10, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? System.currentTimeMillis() : j10);
    }
}
