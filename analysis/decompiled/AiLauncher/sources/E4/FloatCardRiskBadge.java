package E4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardRiskLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"LE4/l;", "", "Lcom/stepos/agentframework/floatcard/api/FloatCardRiskLevel;", "level", "", "label", "", "fillColor", "LE4/b;", "border", "<init>", "(Lcom/stepos/agentframework/floatcard/api/FloatCardRiskLevel;Ljava/lang/String;Ljava/lang/Integer;LE4/b;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/floatcard/api/FloatCardRiskLevel;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/floatcard/api/FloatCardRiskLevel;", "Ljava/lang/String;", "c", "Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Integer;", "LE4/b;", Const.INTENT_KEY_APIKEY, "()LE4/b;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardRiskBadge {
    private final FloatCardBadgeBorder border;
    private final Integer fillColor;
    private final String label;
    private final FloatCardRiskLevel level;

    public FloatCardRiskBadge(FloatCardRiskLevel level, String label, Integer num, FloatCardBadgeBorder floatCardBadgeBorder) {
        kotlin.jvm.internal.p.i(level, "level");
        kotlin.jvm.internal.p.i(label, "label");
        this.level = level;
        this.label = label;
        this.fillColor = num;
        this.border = floatCardBadgeBorder;
    }

    /* renamed from: a, reason: from getter */
    public final FloatCardBadgeBorder getBorder() {
        return this.border;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getFillColor() {
        return this.fillColor;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: d, reason: from getter */
    public final FloatCardRiskLevel getLevel() {
        return this.level;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardRiskBadge)) {
            return false;
        }
        FloatCardRiskBadge floatCardRiskBadge = (FloatCardRiskBadge) other;
        return this.level == floatCardRiskBadge.level && kotlin.jvm.internal.p.d(this.label, floatCardRiskBadge.label) && kotlin.jvm.internal.p.d(this.fillColor, floatCardRiskBadge.fillColor) && kotlin.jvm.internal.p.d(this.border, floatCardRiskBadge.border);
    }

    public int hashCode() {
        int iHashCode = ((this.level.hashCode() * 31) + this.label.hashCode()) * 31;
        Integer num = this.fillColor;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        FloatCardBadgeBorder floatCardBadgeBorder = this.border;
        return iHashCode2 + (floatCardBadgeBorder != null ? floatCardBadgeBorder.hashCode() : 0);
    }

    public String toString() {
        return "FloatCardRiskBadge(level=" + this.level + ", label=" + this.label + ", fillColor=" + this.fillColor + ", border=" + this.border + ")";
    }

    public /* synthetic */ FloatCardRiskBadge(FloatCardRiskLevel floatCardRiskLevel, String str, Integer num, FloatCardBadgeBorder floatCardBadgeBorder, int i10, kotlin.jvm.internal.i iVar) {
        this(floatCardRiskLevel, str, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : floatCardBadgeBorder);
    }
}
