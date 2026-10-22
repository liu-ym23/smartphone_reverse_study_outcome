package androidx.camera.core.internal;

import P.StreamSpecQueryResult;
import Y.f;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b\"\u0010!R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010%R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b&\u0010%R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b(\u0010.R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b*\u00103\u001a\u0004\b,\u00104R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b1\u00103\u001a\u0004\b/\u00104¨\u00065"}, d2 = {"Landroidx/camera/core/internal/a;", "", "", "Landroidx/camera/core/UseCase;", "appUseCases", "cameraUseCases", "", "cameraUseCasesToAttach", "cameraUseCasesToKeep", "cameraUseCasesToDetach", "LY/f;", "streamSharing", "placeholderForExtensions", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$a;", "useCaseConfigs", "LP/h;", "primaryStreamSpecResult", "secondaryStreamSpecResult", "<init>", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/List;Ljava/util/List;Ljava/util/List;LY/f;Landroidx/camera/core/UseCase;Ljava/util/Map;LP/h;LP/h;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/Collection;", "()Ljava/util/Collection;", Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "e", "f", "LY/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LY/f;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/core/UseCase;", "()Landroidx/camera/core/UseCase;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Map;", "LP/h;", "()LP/h;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.camera.core.internal.a, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class CalculatedUseCaseInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Collection<UseCase> appUseCases;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Collection<UseCase> cameraUseCases;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<UseCase> cameraUseCasesToAttach;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<UseCase> cameraUseCasesToKeep;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<UseCase> cameraUseCasesToDetach;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final f streamSharing;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final UseCase placeholderForExtensions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<UseCase, CameraUseCaseAdapter.a> useCaseConfigs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final StreamSpecQueryResult primaryStreamSpecResult;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final StreamSpecQueryResult secondaryStreamSpecResult;

    /* JADX WARN: Multi-variable type inference failed */
    public CalculatedUseCaseInfo(Collection<? extends UseCase> appUseCases, Collection<? extends UseCase> cameraUseCases, List<? extends UseCase> cameraUseCasesToAttach, List<? extends UseCase> cameraUseCasesToKeep, List<? extends UseCase> cameraUseCasesToDetach, f fVar, UseCase useCase, Map<UseCase, ? extends CameraUseCaseAdapter.a> useCaseConfigs, StreamSpecQueryResult primaryStreamSpecResult, StreamSpecQueryResult hVar) {
        p.i(appUseCases, "appUseCases");
        p.i(cameraUseCases, "cameraUseCases");
        p.i(cameraUseCasesToAttach, "cameraUseCasesToAttach");
        p.i(cameraUseCasesToKeep, "cameraUseCasesToKeep");
        p.i(cameraUseCasesToDetach, "cameraUseCasesToDetach");
        p.i(useCaseConfigs, "useCaseConfigs");
        p.i(primaryStreamSpecResult, "primaryStreamSpecResult");
        this.appUseCases = appUseCases;
        this.cameraUseCases = cameraUseCases;
        this.cameraUseCasesToAttach = cameraUseCasesToAttach;
        this.cameraUseCasesToKeep = cameraUseCasesToKeep;
        this.cameraUseCasesToDetach = cameraUseCasesToDetach;
        this.streamSharing = fVar;
        this.placeholderForExtensions = useCase;
        this.useCaseConfigs = useCaseConfigs;
        this.primaryStreamSpecResult = primaryStreamSpecResult;
        this.secondaryStreamSpecResult = hVar;
    }

    public final Collection<UseCase> a() {
        return this.appUseCases;
    }

    public final Collection<UseCase> b() {
        return this.cameraUseCases;
    }

    public final List<UseCase> c() {
        return this.cameraUseCasesToAttach;
    }

    public final List<UseCase> d() {
        return this.cameraUseCasesToDetach;
    }

    public final List<UseCase> e() {
        return this.cameraUseCasesToKeep;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalculatedUseCaseInfo)) {
            return false;
        }
        CalculatedUseCaseInfo calculatedUseCaseInfo = (CalculatedUseCaseInfo) other;
        return p.d(this.appUseCases, calculatedUseCaseInfo.appUseCases) && p.d(this.cameraUseCases, calculatedUseCaseInfo.cameraUseCases) && p.d(this.cameraUseCasesToAttach, calculatedUseCaseInfo.cameraUseCasesToAttach) && p.d(this.cameraUseCasesToKeep, calculatedUseCaseInfo.cameraUseCasesToKeep) && p.d(this.cameraUseCasesToDetach, calculatedUseCaseInfo.cameraUseCasesToDetach) && p.d(this.streamSharing, calculatedUseCaseInfo.streamSharing) && p.d(this.placeholderForExtensions, calculatedUseCaseInfo.placeholderForExtensions) && p.d(this.useCaseConfigs, calculatedUseCaseInfo.useCaseConfigs) && p.d(this.primaryStreamSpecResult, calculatedUseCaseInfo.primaryStreamSpecResult) && p.d(this.secondaryStreamSpecResult, calculatedUseCaseInfo.secondaryStreamSpecResult);
    }

    /* renamed from: f, reason: from getter */
    public final UseCase getPlaceholderForExtensions() {
        return this.placeholderForExtensions;
    }

    /* renamed from: g, reason: from getter */
    public final StreamSpecQueryResult getPrimaryStreamSpecResult() {
        return this.primaryStreamSpecResult;
    }

    /* renamed from: h, reason: from getter */
    public final StreamSpecQueryResult getSecondaryStreamSpecResult() {
        return this.secondaryStreamSpecResult;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.appUseCases.hashCode() * 31) + this.cameraUseCases.hashCode()) * 31) + this.cameraUseCasesToAttach.hashCode()) * 31) + this.cameraUseCasesToKeep.hashCode()) * 31) + this.cameraUseCasesToDetach.hashCode()) * 31;
        f fVar = this.streamSharing;
        int iHashCode2 = (iHashCode + (fVar == null ? 0 : fVar.hashCode())) * 31;
        UseCase useCase = this.placeholderForExtensions;
        int iHashCode3 = (((((iHashCode2 + (useCase == null ? 0 : useCase.hashCode())) * 31) + this.useCaseConfigs.hashCode()) * 31) + this.primaryStreamSpecResult.hashCode()) * 31;
        StreamSpecQueryResult hVar = this.secondaryStreamSpecResult;
        return iHashCode3 + (hVar != null ? hVar.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final f getStreamSharing() {
        return this.streamSharing;
    }

    public final Map<UseCase, CameraUseCaseAdapter.a> j() {
        return this.useCaseConfigs;
    }

    public String toString() {
        return "CalculatedUseCaseInfo(appUseCases=" + this.appUseCases + ", cameraUseCases=" + this.cameraUseCases + ", cameraUseCasesToAttach=" + this.cameraUseCasesToAttach + ", cameraUseCasesToKeep=" + this.cameraUseCasesToKeep + ", cameraUseCasesToDetach=" + this.cameraUseCasesToDetach + ", streamSharing=" + this.streamSharing + ", placeholderForExtensions=" + this.placeholderForExtensions + ", useCaseConfigs=" + this.useCaseConfigs + ", primaryStreamSpecResult=" + this.primaryStreamSpecResult + ", secondaryStreamSpecResult=" + this.secondaryStreamSpecResult + ')';
    }
}
