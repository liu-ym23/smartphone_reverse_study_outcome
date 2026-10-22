package f8;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lf8/b;", "", "", "progress", "total", "", "message", "", "meta", "Landroid/os/Bundle;", "bundle", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/Map;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/Double;", "getProgress", "()Ljava/lang/Double;", Const.INTENT_KEY_PKGNAME, "getTotal", "c", "Ljava/lang/String;", "getMessage", Const.INTENT_KEY_UMID, "Ljava/util/Map;", "getMeta", "()Ljava/util/Map;", "e", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: f8.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes4.dex */
public final /* data */ class ToolProgressNotification {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Double progress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Double total;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String message;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, String> meta;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Bundle bundle;

    public ToolProgressNotification(Double d10, Double d11, String str, Map<String, String> map, Bundle bundle) {
        p.i(bundle, "bundle");
        this.progress = d10;
        this.total = d11;
        this.message = str;
        this.meta = map;
        this.bundle = bundle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolProgressNotification)) {
            return false;
        }
        ToolProgressNotification toolProgressNotification = (ToolProgressNotification) other;
        return p.d(this.progress, toolProgressNotification.progress) && p.d(this.total, toolProgressNotification.total) && p.d(this.message, toolProgressNotification.message) && p.d(this.meta, toolProgressNotification.meta) && p.d(this.bundle, toolProgressNotification.bundle);
    }

    public int hashCode() {
        Double d10 = this.progress;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        Double d11 = this.total;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, String> map = this.meta;
        return ((iHashCode3 + (map != null ? map.hashCode() : 0)) * 31) + this.bundle.hashCode();
    }

    public String toString() {
        return "ToolProgressNotification(progress=" + this.progress + ", total=" + this.total + ", message=" + this.message + ", meta=" + this.meta + ", bundle=" + this.bundle + ")";
    }
}
