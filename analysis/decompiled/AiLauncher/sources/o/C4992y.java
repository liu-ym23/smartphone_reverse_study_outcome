package o;

import D.C0761b0;
import K.W;
import K.w0;
import Z8.C1173v;
import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import androidx.camera.camera2.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.compat.quirk.InvalidVideoProfilesQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002\u000b\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001f¨\u0006\""}, d2 = {"Lo/y;", "LK/V;", "", "cameraIdString", "LK/w0;", "cameraQuirks", "<init>", "(Ljava/lang/String;LK/w0;)V", "", "quality", "", Const.INTENT_KEY_APIKEY, "(I)Z", "LK/W;", Const.INTENT_KEY_PKGNAME, "(I)LK/W;", Const.INTENT_KEY_UMID, "()LK/W;", "e", "f", "c", "profiles", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK/W;)Z", "Ljava/lang/String;", "LK/w0;", "Z", "hasValidCameraId", "I", "cameraId", "", "Ljava/util/Map;", "mEncoderProfilesCache", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4992y implements K.V {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String cameraIdString;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final w0 cameraQuirks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean hasValidCameraId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final int cameraId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, K.W> mEncoderProfilesCache;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lo/y$a;", "", "<init>", "()V", "", "cameraId", "", "quality", "Landroid/media/EncoderProfiles;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)Landroid/media/EncoderProfiles;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.y$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f37455a = new a();

        public final EncoderProfiles a(String cameraId, int quality) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            return CamcorderProfile.getAll(cameraId, quality);
        }
    }

    public C4992y(String cameraIdString, w0 cameraQuirks) throws NumberFormatException {
        boolean z10;
        int i10;
        kotlin.jvm.internal.p.i(cameraIdString, "cameraIdString");
        kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
        this.cameraIdString = cameraIdString;
        this.cameraQuirks = cameraQuirks;
        this.mEncoderProfilesCache = new LinkedHashMap();
        try {
            i10 = Integer.parseInt(cameraIdString);
            z10 = true;
        } catch (NumberFormatException unused) {
            C0761b0.o("EncoderProfilesProviderAdapter", "Camera id is not an integer:  " + this.cameraIdString + ", unable to create EncoderProfilesProviderAdapter.");
            z10 = false;
            i10 = -1;
        }
        this.hasValidCameraId = z10;
        this.cameraId = i10;
    }

    @Override // K.V
    public boolean a(int quality) {
        return this.hasValidCameraId && b(quality) != null;
    }

    @Override // K.V
    public K.W b(int quality) {
        K.W wE = null;
        if (!this.hasValidCameraId || !CamcorderProfile.hasProfile(this.cameraId, quality)) {
            return null;
        }
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(quality))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(quality));
        }
        K.W wF = f(quality);
        if (wF != null && !g(wF)) {
            if (quality == 0) {
                wE = e();
            } else if (quality == 1) {
                wE = d();
            }
            wF = wE;
        }
        this.mEncoderProfilesCache.put(Integer.valueOf(quality), wF);
        return wF;
    }

    public final K.W c(int quality) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.cameraId, quality);
        } catch (RuntimeException e10) {
            C0761b0.p("EncoderProfilesProviderAdapter", "Unable to get CamcorderProfile by quality: " + quality, e10);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return L.a.a(camcorderProfile);
        }
        return null;
    }

    public final K.W d() {
        for (Integer num : K.V.f3932b) {
            kotlin.jvm.internal.p.f(num);
            K.W wB = b(num.intValue());
            if (wB != null) {
                return wB;
            }
        }
        return null;
    }

    public final K.W e() {
        List<Integer> QUALITY_HIGH_TO_LOW = K.V.f3932b;
        kotlin.jvm.internal.p.h(QUALITY_HIGH_TO_LOW, "QUALITY_HIGH_TO_LOW");
        for (int iO = C1173v.o(QUALITY_HIGH_TO_LOW); -1 < iO; iO--) {
            Integer num = K.V.f3932b.get(iO);
            kotlin.jvm.internal.p.h(num, "get(...)");
            K.W wB = b(num.intValue());
            if (wB != null) {
                return wB;
            }
        }
        return null;
    }

    public final K.W f(int quality) {
        EncoderProfiles encoderProfilesA = a.f37455a.a(this.cameraIdString, quality);
        if (encoderProfilesA == null) {
            return null;
        }
        if (q.f.f38470a.c(InvalidVideoProfilesQuirk.class) != null) {
            C0761b0.a("EncoderProfilesProviderAdapter", "EncoderProfiles contains invalid video profiles, use CamcorderProfile to create EncoderProfilesProxy.");
        } else {
            try {
                return L.a.b(encoderProfilesA);
            } catch (NullPointerException e10) {
                C0761b0.p("EncoderProfilesProviderAdapter", "Failed to create EncoderProfilesProxy, EncoderProfiles might contain invalid video profiles. Use CamcorderProfile instead.", e10);
            }
        }
        return this.c(quality);
    }

    public final boolean g(K.W profiles) {
        CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk = (CamcorderProfileResolutionQuirk) this.cameraQuirks.b(CamcorderProfileResolutionQuirk.class);
        if (camcorderProfileResolutionQuirk == null) {
            return true;
        }
        List<W.c> listB = profiles.b();
        kotlin.jvm.internal.p.h(listB, "getVideoProfiles(...)");
        if (listB.isEmpty()) {
            return true;
        }
        return camcorderProfileResolutionQuirk.e().contains(listB.get(0).k());
    }
}
