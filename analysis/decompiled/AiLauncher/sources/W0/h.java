package W0;

import V0.CreationExtras;
import android.view.InterfaceC1391i;
import android.view.Q;
import android.view.U;
import android.view.W;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LW0/h;", "", "<init>", "()V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "modelClass", "", "c", "(Lw9/d;)Ljava/lang/String;", "VM", Const.INTENT_KEY_UMID, "()Landroidx/lifecycle/Q;", "Landroidx/lifecycle/W;", "owner", "Landroidx/lifecycle/U$c;", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/W;)Landroidx/lifecycle/U$c;", "LV0/a;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/W;)LV0/a;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f6590a = new h();

    public final CreationExtras a(W owner) {
        p.i(owner, "owner");
        return owner instanceof InterfaceC1391i ? ((InterfaceC1391i) owner).getDefaultViewModelCreationExtras() : CreationExtras.b.f6465c;
    }

    public final U.c b(W owner) {
        p.i(owner, "owner");
        return owner instanceof InterfaceC1391i ? ((InterfaceC1391i) owner).getDefaultViewModelProviderFactory() : d.f6584b;
    }

    public final <T extends Q> String c(InterfaceC5745d<T> modelClass) {
        p.i(modelClass, "modelClass");
        String strA = a.a(modelClass);
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + strA;
    }

    public final <VM extends Q> VM d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
