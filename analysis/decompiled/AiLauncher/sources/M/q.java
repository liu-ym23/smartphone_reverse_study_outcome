package M;

import D.C0761b0;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0012\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0014\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"LM/q;", "", "<init>", "()V", "", "Landroidx/camera/core/UseCase;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/core/UseCase;)Z", "Lkotlin/Function1;", "Landroidx/camera/core/impl/z;", "configProvider", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", Const.INTENT_KEY_UMID, "(Ljava/util/Collection;Lp9/l;)Landroidx/camera/core/impl/stabilization/VideoStabilization;", "", "c", "(Ljava/util/Collection;Lp9/l;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f4494a = new q();

    public static final boolean b(Collection<? extends UseCase> collection) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        for (UseCase useCase : collection) {
            if (useCase != null && h(useCase)) {
                return true;
            }
        }
        return false;
    }

    public static final VideoStabilization d(Collection<? extends UseCase> collection, InterfaceC5074l<? super UseCase, ? extends z<?>> configProvider) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(configProvider, "configProvider");
        VideoStabilization.Companion companion = VideoStabilization.INSTANCE;
        q qVar = f4494a;
        return companion.a(qVar.c(collection, configProvider), qVar.g(collection, configProvider));
    }

    public static /* synthetic */ VideoStabilization e(Collection collection, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: M.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return q.f((UseCase) obj2);
                }
            };
        }
        return d(collection, interfaceC5074l);
    }

    public static final z f(UseCase it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.l();
    }

    public static final boolean h(UseCase useCase) {
        kotlin.jvm.internal.p.i(useCase, "<this>");
        if (useCase.l().b(z.f11551L)) {
            return useCase.l().V() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
        }
        C0761b0.c("UseCaseUtil", useCase + " UseCase does not have capture type.");
        return false;
    }

    public final int c(Collection<? extends UseCase> collection, InterfaceC5074l<? super UseCase, ? extends z<?>> interfaceC5074l) {
        Iterator<T> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int iF = interfaceC5074l.invoke((UseCase) it.next()).F();
            if (iF != 0) {
                if (i10 != iF && i10 != 0) {
                    C0761b0.o("UseCaseUtil", "Unexpected configurations: Overwriting current previewStabilizationMode(" + i10 + ") with useCasePreviewStabilization(" + iF + ")!");
                }
                i10 = iF;
            }
        }
        return i10;
    }

    public final int g(Collection<? extends UseCase> collection, InterfaceC5074l<? super UseCase, ? extends z<?>> interfaceC5074l) {
        Iterator<T> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int iZ = interfaceC5074l.invoke((UseCase) it.next()).z();
            if (iZ != 0) {
                if (i10 != iZ && i10 != 0) {
                    C0761b0.o("UseCaseUtil", "Unexpected configurations: Overwriting current videoStabilizationMode(" + i10 + ") with useCaseVideoStabilization(" + iZ + ")!");
                }
                i10 = iZ;
            }
        }
        return i10;
    }
}
