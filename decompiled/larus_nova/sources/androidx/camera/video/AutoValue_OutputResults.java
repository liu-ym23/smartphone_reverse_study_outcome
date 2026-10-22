package androidx.camera.video;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_OutputResults extends OutputResults {
    private final Uri outputUri;

    public int hashCode() {
        return this.outputUri.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.outputUri + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.video.OutputResults
    public Uri getOutputUri() {
        return this.outputUri;
    }

    public AutoValue_OutputResults(Uri r100) {
        if (r100 == null) goto L7;
        this.outputUri = r100;
        return;
    L7:
        throw new NullPointerException("Null outputUri");
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OutputResults) == true) goto L8;
        return false;
    L8:
        return this.outputUri.equals(((OutputResults) r100).getOutputUri());
    }
}
