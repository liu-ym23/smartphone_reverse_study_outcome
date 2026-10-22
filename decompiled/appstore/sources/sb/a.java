package sb;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlphaVideoViewType f24689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f24690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleOwner f24691c;

    public a(Context r10, LifecycleOwner r11) {
        q.g(r10, "context");
        q.g(r11, "lifecycleOwner");
        this.f24690b = r10;
        this.f24691c = r11;
        this.f24689a = AlphaVideoViewType.GL_SURFACE_VIEW;
    }

    public final AlphaVideoViewType a() {
        return this.f24689a;
    }

    public final Context b() {
        return this.f24690b;
    }

    public final LifecycleOwner c() {
        return this.f24691c;
    }

    public final void d(AlphaVideoViewType r10) {
        q.g(r10, "<set-?>");
        this.f24689a = r10;
    }
}
