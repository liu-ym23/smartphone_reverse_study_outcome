package A1;

import Ua.Q;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"LA1/r;", "LA1/d;", "Landroid/view/View;", "view", "LUa/Q;", "LA1/h;", "job", "<init>", "(Landroid/view/View;LUa/Q;)V", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "LUa/Q;", "getJob", "()LUa/Q;", "(LUa/Q;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile Q<? extends h> job;

    public r(View view, Q<? extends h> q10) {
        this.view = view;
        this.job = q10;
    }

    public void a(Q<? extends h> q10) {
        this.job = q10;
    }
}
