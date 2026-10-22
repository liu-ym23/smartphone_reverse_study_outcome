package androidx.camera.camera2.impl;

import Ua.C1058h;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.h;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o.Y;
import r.G;
import s.m;
import t.N;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/impl/FeatureCombinationQueryImpl;", "Landroidx/camera/core/featuregroup/impl/a;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "<init>", "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/camera2/pipe/h;Landroidx/camera/camera2/compat/quirk/a;)V", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SessionConfig;)Z", "c", "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/pipe/h;", "e", "Landroidx/camera/camera2/compat/quirk/a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeatureCombinationQueryImpl implements androidx.camera.core.featuregroup.impl.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h cameraPipe;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.compat.quirk.a cameraQuirks;

    public FeatureCombinationQueryImpl(androidx.camera.camera2.pipe.g cameraMetadata, h cameraPipe, androidx.camera.camera2.compat.quirk.a cameraQuirks) {
        p.i(cameraMetadata, "cameraMetadata");
        p.i(cameraPipe, "cameraPipe");
        p.i(cameraQuirks, "cameraQuirks");
        this.cameraMetadata = cameraMetadata;
        this.cameraPipe = cameraPipe;
        this.cameraQuirks = cameraQuirks;
    }

    @Override // androidx.camera.core.featuregroup.impl.a
    public boolean a(SessionConfig sessionConfig) {
        p.i(sessionConfig, "sessionConfig");
        return ((Boolean) C1058h.b(null, new FeatureCombinationQueryImpl$isSupported$1(this, c.b(new c(new b(), new N(), new m(this.cameraMetadata.getCamera(), null), this.cameraQuirks, new Y(), new G(this.cameraQuirks.b()), this.cameraMetadata, null, null, com.stepos.agentframework.chatui.longtext.b.BLOCK_CHARS, null), CameraGraph.e.INSTANCE.d(), sessionConfig, true, null, null, null, null, 120, null), null), 1, null)).booleanValue();
    }
}
