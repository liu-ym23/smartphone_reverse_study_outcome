package w;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017¨\u0006\u0018"}, d2 = {"Lw/D;", "", "LC/n;", "image", "Lw/w;", "frameInfo", "<init>", "(LC/n;Lw/w;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LC/n;", Const.INTENT_KEY_PKGNAME, "()LC/n;", "Lw/w;", "()Lw/w;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.D, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class InputRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final C.n image;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final w frameInfo;

    public InputRequest(C.n image, w frameInfo) {
        kotlin.jvm.internal.p.i(image, "image");
        kotlin.jvm.internal.p.i(frameInfo, "frameInfo");
        this.image = image;
        this.frameInfo = frameInfo;
    }

    /* renamed from: a, reason: from getter */
    public final w getFrameInfo() {
        return this.frameInfo;
    }

    /* renamed from: b, reason: from getter */
    public final C.n getImage() {
        return this.image;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputRequest)) {
            return false;
        }
        InputRequest inputRequest = (InputRequest) other;
        return kotlin.jvm.internal.p.d(this.image, inputRequest.image) && kotlin.jvm.internal.p.d(this.frameInfo, inputRequest.frameInfo);
    }

    public int hashCode() {
        return (this.image.hashCode() * 31) + this.frameInfo.hashCode();
    }

    public String toString() {
        return "InputRequest(image=" + this.image + ", frameInfo=" + this.frameInfo + ')';
    }
}
