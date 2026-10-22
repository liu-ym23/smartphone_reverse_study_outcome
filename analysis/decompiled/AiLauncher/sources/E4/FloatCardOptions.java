package E4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJB\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"LE4/i;", "", "", "hideChatViewOnShow", "replaceExisting", "dismissOnNavigate", "hostDrivenEnterAnim", "expandAllOptions", "<init>", "(ZZZZZ)V", Const.INTENT_KEY_APIKEY, "(ZZZZZ)LE4/i;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_UMID, "()Z", "f", "getDismissOnNavigate", "e", "c", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.i, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardOptions {
    private final boolean dismissOnNavigate;
    private final boolean expandAllOptions;
    private final boolean hideChatViewOnShow;
    private final boolean hostDrivenEnterAnim;
    private final boolean replaceExisting;

    public FloatCardOptions() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ FloatCardOptions b(FloatCardOptions floatCardOptions, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = floatCardOptions.hideChatViewOnShow;
        }
        if ((i10 & 2) != 0) {
            z11 = floatCardOptions.replaceExisting;
        }
        if ((i10 & 4) != 0) {
            z12 = floatCardOptions.dismissOnNavigate;
        }
        if ((i10 & 8) != 0) {
            z13 = floatCardOptions.hostDrivenEnterAnim;
        }
        if ((i10 & 16) != 0) {
            z14 = floatCardOptions.expandAllOptions;
        }
        boolean z15 = z14;
        boolean z16 = z12;
        return floatCardOptions.a(z10, z11, z16, z13, z15);
    }

    public final FloatCardOptions a(boolean hideChatViewOnShow, boolean replaceExisting, boolean dismissOnNavigate, boolean hostDrivenEnterAnim, boolean expandAllOptions) {
        return new FloatCardOptions(hideChatViewOnShow, replaceExisting, dismissOnNavigate, hostDrivenEnterAnim, expandAllOptions);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getExpandAllOptions() {
        return this.expandAllOptions;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHideChatViewOnShow() {
        return this.hideChatViewOnShow;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getHostDrivenEnterAnim() {
        return this.hostDrivenEnterAnim;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardOptions)) {
            return false;
        }
        FloatCardOptions floatCardOptions = (FloatCardOptions) other;
        return this.hideChatViewOnShow == floatCardOptions.hideChatViewOnShow && this.replaceExisting == floatCardOptions.replaceExisting && this.dismissOnNavigate == floatCardOptions.dismissOnNavigate && this.hostDrivenEnterAnim == floatCardOptions.hostDrivenEnterAnim && this.expandAllOptions == floatCardOptions.expandAllOptions;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getReplaceExisting() {
        return this.replaceExisting;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.hideChatViewOnShow) * 31) + Boolean.hashCode(this.replaceExisting)) * 31) + Boolean.hashCode(this.dismissOnNavigate)) * 31) + Boolean.hashCode(this.hostDrivenEnterAnim)) * 31) + Boolean.hashCode(this.expandAllOptions);
    }

    public String toString() {
        return "FloatCardOptions(hideChatViewOnShow=" + this.hideChatViewOnShow + ", replaceExisting=" + this.replaceExisting + ", dismissOnNavigate=" + this.dismissOnNavigate + ", hostDrivenEnterAnim=" + this.hostDrivenEnterAnim + ", expandAllOptions=" + this.expandAllOptions + ")";
    }

    public FloatCardOptions(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.hideChatViewOnShow = z10;
        this.replaceExisting = z11;
        this.dismissOnNavigate = z12;
        this.hostDrivenEnterAnim = z13;
        this.expandAllOptions = z14;
    }

    public /* synthetic */ FloatCardOptions(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14);
    }
}
