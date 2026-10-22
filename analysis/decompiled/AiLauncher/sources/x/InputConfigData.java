package x;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0011\u0010\f¨\u0006\u0015"}, d2 = {"Lx/u0;", "", "", "width", "height", "format", "<init>", "(III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "c", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.u0, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class InputConfigData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int format;

    public InputConfigData(int i10, int i11, int i12) {
        this.width = i10;
        this.height = i11;
        this.format = i12;
    }

    /* renamed from: a, reason: from getter */
    public final int getFormat() {
        return this.format;
    }

    /* renamed from: b, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: c, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputConfigData)) {
            return false;
        }
        InputConfigData inputConfigData = (InputConfigData) other;
        return this.width == inputConfigData.width && this.height == inputConfigData.height && this.format == inputConfigData.format;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.format);
    }

    public String toString() {
        return "InputConfigData(width=" + this.width + ", height=" + this.height + ", format=" + this.format + ')';
    }
}
