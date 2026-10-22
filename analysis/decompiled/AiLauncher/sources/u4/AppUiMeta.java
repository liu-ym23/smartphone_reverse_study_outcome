package u4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lu4/l;", "", "", "Lu4/b;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "structuredContent", "_meta", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "get_meta", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AppUiMeta {
    private final Object _meta;
    private final List<AgentMetaContent> content;
    private final Object structuredContent;

    public AppUiMeta() {
        this(null, null, null, 7, null);
    }

    public final List<AgentMetaContent> a() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUiMeta)) {
            return false;
        }
        AppUiMeta appUiMeta = (AppUiMeta) other;
        return p.d(this.content, appUiMeta.content) && p.d(this.structuredContent, appUiMeta.structuredContent) && p.d(this._meta, appUiMeta._meta);
    }

    public int hashCode() {
        List<AgentMetaContent> list = this.content;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Object obj = this.structuredContent;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this._meta;
        return iHashCode2 + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "AppUiMeta(content=" + this.content + ", structuredContent=" + this.structuredContent + ", _meta=" + this._meta + ")";
    }

    public AppUiMeta(List<AgentMetaContent> list, Object obj, Object obj2) {
        this.content = list;
        this.structuredContent = obj;
        this._meta = obj2;
    }

    public /* synthetic */ AppUiMeta(List list, Object obj, Object obj2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : obj, (i10 & 4) != 0 ? null : obj2);
    }
}
