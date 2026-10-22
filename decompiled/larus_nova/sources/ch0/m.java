package ch0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f23753d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f23754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f23756c;

    public static final class a {
        public static m a() {
            return new m(new ArrayList(), 0, null);
        }
    }

    static {
    }

    public final String toString() {
        return "WaitingListMergeData(waitingList=" + this.f23754a + ", totalCount=" + this.f23755b + ", waitingUser=" + this.f23756c + ")";
    }

    public final int hashCode() {
        List<ILinkPlayerInfoBridge> r100 = this.f23754a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((int) (((long) (r102 * 37)) + this.f23755b)) * 37;
        n0 r104 = this.f23756c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(m.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L34;
        m r102 = (m) r100;
        List<ILinkPlayerInfoBridge> r103 = this.f23754a;
        if (r103 == null) goto L16;
    L17:
        if (r103 != null) goto L19;
    L26:
        n0 r104 = this.f23756c;
        if (r104 != null) goto L29;
    L31:
        return false;
    L29:
        if (r104.equals(r102.f23756c) != true) goto L31;
        return true;
    L19:
        if (r103.equals(r102.f23754a) != true) goto L26;
        if (this.f23755b != r102.f23755b) goto L26;
        if (this.f23756c != null) goto L26;
        if (r102.f23756c != null) goto L26;
        return true;
    L16:
        if (r102.f23754a != null) goto L17;
        return true;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.datamerge.entity.WaitingListMergeData");
    L8:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(List<? extends ILinkPlayerInfoBridge> r100, long r101, n0 r102) {
        this.f23754a = r100;
        this.f23755b = r101;
        this.f23756c = r102;
    }
}
