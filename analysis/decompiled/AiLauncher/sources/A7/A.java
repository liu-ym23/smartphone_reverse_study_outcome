package A7;

import android.content.Context;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"LA7/A;", "Ly7/C;", "LA7/B;", "<init>", "()V", Const.INTENT_KEY_UMID, "()LA7/B;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", "c", "(Landroid/view/View;LA7/B;)Ly7/s;", "LA7/l;", Const.INTENT_KEY_APIKEY, "LA7/l;", "delegate", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class A implements y7.C<B> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C0744l delegate = new C0744l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String id = "gradient_blur";

    @Override // y7.C
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y7.s a(View view, B params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        return this.delegate.a(view, params);
    }

    @Override // y7.C
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public B get$params() {
        return new B();
    }

    @Override // y7.C
    public String getId() {
        return this.id;
    }

    @Override // y7.C
    public boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.delegate.isSupported(context);
    }
}
