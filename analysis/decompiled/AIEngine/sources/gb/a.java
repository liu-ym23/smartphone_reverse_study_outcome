package gb;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!a.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.util.ActiveDownloadInfo");
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ActiveDownloadInfo(fetchObserver=null, includeAddedDownloads=false)";
    }
}
