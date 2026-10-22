package E4;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardActionStyle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LE4/a;", "", "", "id", "label", "Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "style", "Landroid/os/Bundle;", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "getStyle", "()Lcom/stepos/agentframework/floatcard/api/FloatCardActionStyle;", "Landroid/os/Bundle;", "c", "()Landroid/os/Bundle;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardAction {
    private final String id;
    private final String label;
    private final Bundle payload;
    private final FloatCardActionStyle style;

    public FloatCardAction(String id, String label, FloatCardActionStyle style, Bundle payload) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(label, "label");
        kotlin.jvm.internal.p.i(style, "style");
        kotlin.jvm.internal.p.i(payload, "payload");
        this.id = id;
        this.label = label;
        this.style = style;
        this.payload = payload;
    }

    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
    public final Bundle getPayload() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardAction)) {
            return false;
        }
        FloatCardAction floatCardAction = (FloatCardAction) other;
        return kotlin.jvm.internal.p.d(this.id, floatCardAction.id) && kotlin.jvm.internal.p.d(this.label, floatCardAction.label) && this.style == floatCardAction.style && kotlin.jvm.internal.p.d(this.payload, floatCardAction.payload);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + this.style.hashCode()) * 31) + this.payload.hashCode();
    }

    public String toString() {
        return "FloatCardAction(id=" + this.id + ", label=" + this.label + ", style=" + this.style + ", payload=" + this.payload + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FloatCardAction(String str, String str2, FloatCardActionStyle floatCardActionStyle, Bundle EMPTY, int i10, kotlin.jvm.internal.i iVar) {
        floatCardActionStyle = (i10 & 4) != 0 ? FloatCardActionStyle.Secondary : floatCardActionStyle;
        if ((i10 & 8) != 0) {
            EMPTY = Bundle.EMPTY;
            kotlin.jvm.internal.p.h(EMPTY, "EMPTY");
        }
        this(str, str2, floatCardActionStyle, EMPTY);
    }
}
