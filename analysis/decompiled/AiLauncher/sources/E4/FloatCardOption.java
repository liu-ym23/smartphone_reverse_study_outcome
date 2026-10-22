package E4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"LE4/h;", "", "", "id", "label", "", "selected", x5.d.EXTRA_ENABLED, "isPlaying", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "Z", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_APIKEY, "e", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.h, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardOption {
    private final boolean enabled;
    private final String id;
    private final boolean isPlaying;
    private final String label;
    private final boolean selected;

    public FloatCardOption(String id, String label, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(label, "label");
        this.id = id;
        this.label = label;
        this.selected = z10;
        this.enabled = z11;
        this.isPlaying = z12;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardOption)) {
            return false;
        }
        FloatCardOption floatCardOption = (FloatCardOption) other;
        return kotlin.jvm.internal.p.d(this.id, floatCardOption.id) && kotlin.jvm.internal.p.d(this.label, floatCardOption.label) && this.selected == floatCardOption.selected && this.enabled == floatCardOption.enabled && this.isPlaying == floatCardOption.isPlaying;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.label.hashCode()) * 31) + Boolean.hashCode(this.selected)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.isPlaying);
    }

    public String toString() {
        return "FloatCardOption(id=" + this.id + ", label=" + this.label + ", selected=" + this.selected + ", enabled=" + this.enabled + ", isPlaying=" + this.isPlaying + ")";
    }

    public /* synthetic */ FloatCardOption(String str, String str2, boolean z10, boolean z11, boolean z12, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? true : z11, (i10 & 16) != 0 ? false : z12);
    }
}
