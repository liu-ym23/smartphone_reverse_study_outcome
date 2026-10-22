package b;

import android.window.BackEvent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lb/b;", "", "<init>", "()V", "Landroid/window/BackEvent;", "backEvent", "", Const.INTENT_KEY_APIKEY, "(Landroid/window/BackEvent;)J", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: b.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1422b {

    /* renamed from: a, reason: collision with root package name */
    public static final C1422b f15184a = new C1422b();

    public final long a(BackEvent backEvent) {
        kotlin.jvm.internal.p.i(backEvent, "backEvent");
        return backEvent.getFrameTimeMillis();
    }
}
