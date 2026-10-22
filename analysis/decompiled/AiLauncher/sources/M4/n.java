package M4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LM4/n;", "", "<init>", "()V", "", "manifestFps", "fileRate", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Float;F)F", "Lorg/libpag/PAGView;", "view", "Lorg/libpag/PAGFile;", "pagFile", "", "assetPath", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lorg/libpag/PAGView;Ljava/lang/Float;Lorg/libpag/PAGFile;Ljava/lang/String;)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f4639a = new n();

    public final void a(PAGView view, Float manifestFps, PAGFile pagFile, String assetPath) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(pagFile, "pagFile");
        kotlin.jvm.internal.p.i(assetPath, "assetPath");
        Float fValueOf = Float.valueOf(pagFile.frameRate());
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        view.setMaxFrameRate(b(manifestFps, fValueOf != null ? fValueOf.floatValue() : 8.0f));
    }

    public final float b(Float manifestFps, float fileRate) {
        Float fValueOf = Float.valueOf(fileRate);
        if (fValueOf.floatValue() <= 0.0f) {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : 8.0f;
        return C5685n.m(Math.min(manifestFps != null ? manifestFps.floatValue() : fFloatValue, fFloatValue), 1.0f, 60.0f);
    }
}
