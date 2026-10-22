package D;

import K.C0877d;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0012B!\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001a"}, d2 = {"LD/n;", "", "", "", "cameraIds", "LK/Z;", "compatibilityId", "<init>", "(Ljava/util/List;LK/Z;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "LK/Z;", "getCompatibilityId", "()LK/Z;", "internalId", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: D.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0777n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<String> cameraIds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final K.Z compatibilityId;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LD/n$a;", "", "<init>", "()V", "", "", "cameraIds", "LK/Z;", "compatibilityId", "LD/n;", "c", "(Ljava/util/List;LK/Z;)LD/n;", "primaryCameraId", "secondaryCameraId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;LK/Z;)LD/n;", "LK/d;", "primaryInfo", "secondaryInfo", "e", "(LK/d;LK/d;)LD/n;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: D.n$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2144a = new a();

        public static final C0777n a(String primaryCameraId) {
            kotlin.jvm.internal.p.i(primaryCameraId, "primaryCameraId");
            return d(primaryCameraId, null, null, 6, null);
        }

        public static final C0777n b(String primaryCameraId, String secondaryCameraId, K.Z compatibilityId) {
            kotlin.jvm.internal.p.i(primaryCameraId, "primaryCameraId");
            List listS = C1173v.s(primaryCameraId);
            if (secondaryCameraId != null) {
                listS.add(secondaryCameraId);
            }
            return c(listS, compatibilityId);
        }

        public static final C0777n c(List<String> cameraIds, K.Z compatibilityId) {
            kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
            return new C0777n(cameraIds, compatibilityId, null);
        }

        public static /* synthetic */ C0777n d(String str, String str2, K.Z z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                z10 = null;
            }
            return b(str, str2, z10);
        }

        public static final C0777n e(C0877d primaryInfo, C0877d secondaryInfo) {
            kotlin.jvm.internal.p.i(primaryInfo, "primaryInfo");
            String strH = secondaryInfo != null ? secondaryInfo.h() : null;
            K.Z zA0 = primaryInfo.b().a0();
            kotlin.jvm.internal.p.h(zA0, "getCompatibilityId(...)");
            String strH2 = primaryInfo.h();
            kotlin.jvm.internal.p.h(strH2, "getCameraId(...)");
            return b(strH2, strH, zA0);
        }
    }

    public /* synthetic */ C0777n(List list, K.Z z10, kotlin.jvm.internal.i iVar) {
        this(list, z10);
    }

    public final List<String> a() {
        return this.cameraIds;
    }

    public final String b() {
        B0.h.i(this.cameraIds.size() == 1, "getInternalId() is only available for single-camera identifiers.");
        return (String) Z8.F.q0(this.cameraIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C0777n)) {
            return false;
        }
        C0777n c0777n = (C0777n) other;
        return kotlin.jvm.internal.p.d(this.cameraIds, c0777n.cameraIds) && kotlin.jvm.internal.p.d(this.compatibilityId, c0777n.compatibilityId);
    }

    public int hashCode() {
        int iHashCode = this.cameraIds.hashCode() * 31;
        K.Z z10 = this.compatibilityId;
        return iHashCode + (z10 != null ? z10.hashCode() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CameraIdentifier{cameraIds="
            r0.append(r1)
            java.util.List<java.lang.String> r1 = r11.cameraIds
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r9 = 62
            r10 = 0
            java.lang.String r3 = ","
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r1 = Z8.F.A0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0.append(r1)
            K.Z r11 = r11.compatibilityId
            if (r11 == 0) goto L37
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ", compatId="
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            if (r11 != 0) goto L39
        L37:
            java.lang.String r11 = ""
        L39:
            r0.append(r11)
            r11 = 125(0x7d, float:1.75E-43)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: D.C0777n.toString():java.lang.String");
    }

    public C0777n(List<String> list, K.Z z10) {
        this.cameraIds = list;
        this.compatibilityId = z10;
        B0.h.b(!list.isEmpty(), "Camera ID set cannot be empty.");
    }
}
