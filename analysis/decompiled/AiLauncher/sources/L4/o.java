package L4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"LL4/o;", "", "LL4/n;", "info", "LY8/t;", Const.INTENT_KEY_UMID, "(LL4/n;)V", "e", "", "success", Const.INTENT_KEY_APIKEY, "(LL4/n;Z)V", Const.INTENT_KEY_PKGNAME, "c", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface o {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a {
        public static void a(o oVar, AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
        }

        public static void b(o oVar, AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
        }

        public static void c(o oVar, AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
        }

        public static void d(o oVar, AnimationInfo info, boolean z10) {
            kotlin.jvm.internal.p.i(info, "info");
        }

        public static void e(o oVar, AnimationInfo info) {
            kotlin.jvm.internal.p.i(info, "info");
        }
    }

    void a(AnimationInfo info, boolean success);

    void b(AnimationInfo info);

    void c(AnimationInfo info);

    void d(AnimationInfo info);

    void e(AnimationInfo info);
}
