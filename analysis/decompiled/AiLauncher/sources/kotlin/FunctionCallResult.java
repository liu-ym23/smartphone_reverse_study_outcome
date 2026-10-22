package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LK6/w;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "LK6/u;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "structuredContent", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.w, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FunctionCallResult {
    private final List<FunctionCallContent> content;
    private final Object structuredContent;

    public final List<FunctionCallContent> a() {
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
        if (!(other instanceof FunctionCallResult)) {
            return false;
        }
        FunctionCallResult functionCallResult = (FunctionCallResult) other;
        return p.d(this.content, functionCallResult.content) && p.d(this.structuredContent, functionCallResult.structuredContent);
    }

    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        Object obj = this.structuredContent;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "FunctionCallResult(content=" + this.content + ", structuredContent=" + this.structuredContent + ")";
    }
}
