package s7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000b¨\u0006\u0014"}, d2 = {"Ls7/g;", "", "", "capacity", "<init>", "(I)V", "", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_APIKEY, "(F)V", "I", "", Const.INTENT_KEY_PKGNAME, "[F", "data", "c", "head", Const.INTENT_KEY_UMID, "count", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final float[] data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int head;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int count;

    public g(int i10) {
        this.capacity = i10;
        this.data = new float[i10];
    }

    public final void a(float value) {
        float[] fArr = this.data;
        int i10 = this.head;
        fArr[i10] = value;
        int i11 = this.capacity;
        this.head = (i10 + 1) % i11;
        int i12 = this.count;
        if (i12 < i11) {
            this.count = i12 + 1;
        }
    }
}
