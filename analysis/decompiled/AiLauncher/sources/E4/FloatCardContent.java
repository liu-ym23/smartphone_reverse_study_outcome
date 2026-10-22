package E4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardStatus;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b$\u0010#¨\u0006%"}, d2 = {"LE4/c;", "", "", "LE4/j;", "pages", "LE4/f;", "icon", "Lcom/stepos/agentframework/floatcard/api/FloatCardStatus;", "status", "LE4/a;", "submitAction", "dismissAction", "<init>", "(Ljava/util/List;LE4/f;Lcom/stepos/agentframework/floatcard/api/FloatCardStatus;LE4/a;LE4/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "LE4/f;", "getIcon", "()LE4/f;", "Lcom/stepos/agentframework/floatcard/api/FloatCardStatus;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/floatcard/api/FloatCardStatus;", "LE4/a;", "c", "()LE4/a;", "getDismissAction", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardContent {
    private final FloatCardAction dismissAction;
    private final FloatCardIcon icon;
    private final List<FloatCardPage> pages;
    private final FloatCardStatus status;
    private final FloatCardAction submitAction;

    public FloatCardContent(List<FloatCardPage> pages, FloatCardIcon floatCardIcon, FloatCardStatus status, FloatCardAction aVar, FloatCardAction aVar2) {
        kotlin.jvm.internal.p.i(pages, "pages");
        kotlin.jvm.internal.p.i(status, "status");
        this.pages = pages;
        this.icon = floatCardIcon;
        this.status = status;
        this.submitAction = aVar;
        this.dismissAction = aVar2;
    }

    public final List<FloatCardPage> a() {
        return this.pages;
    }

    /* renamed from: b, reason: from getter */
    public final FloatCardStatus getStatus() {
        return this.status;
    }

    /* renamed from: c, reason: from getter */
    public final FloatCardAction getSubmitAction() {
        return this.submitAction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardContent)) {
            return false;
        }
        FloatCardContent floatCardContent = (FloatCardContent) other;
        return kotlin.jvm.internal.p.d(this.pages, floatCardContent.pages) && kotlin.jvm.internal.p.d(this.icon, floatCardContent.icon) && this.status == floatCardContent.status && kotlin.jvm.internal.p.d(this.submitAction, floatCardContent.submitAction) && kotlin.jvm.internal.p.d(this.dismissAction, floatCardContent.dismissAction);
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode() * 31;
        FloatCardIcon floatCardIcon = this.icon;
        int iHashCode2 = (((iHashCode + (floatCardIcon == null ? 0 : floatCardIcon.hashCode())) * 31) + this.status.hashCode()) * 31;
        FloatCardAction aVar = this.submitAction;
        int iHashCode3 = (iHashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        FloatCardAction aVar2 = this.dismissAction;
        return iHashCode3 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "FloatCardContent(pages=" + this.pages + ", icon=" + this.icon + ", status=" + this.status + ", submitAction=" + this.submitAction + ", dismissAction=" + this.dismissAction + ")";
    }

    public /* synthetic */ FloatCardContent(List list, FloatCardIcon floatCardIcon, FloatCardStatus floatCardStatus, FloatCardAction aVar, FloatCardAction aVar2, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? null : floatCardIcon, (i10 & 4) != 0 ? FloatCardStatus.Normal : floatCardStatus, (i10 & 8) != 0 ? null : aVar, (i10 & 16) != 0 ? null : aVar2);
    }
}
