package s7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.ErrorLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ls7/d;", "Ls7/f;", "<init>", "()V", "Ls7/q;", "error", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ls7/q;)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements f {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40077a;

        static {
            int[] iArr = new int[ErrorLevel.values().length];
            try {
                iArr[ErrorLevel.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ErrorLevel.DEGRADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ErrorLevel.FATAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f40077a = iArr;
        }
    }

    @Override // s7.f
    public void a(MotionKitError error) {
        kotlin.jvm.internal.p.i(error, "error");
        int i10 = a.f40077a[error.getLevel().ordinal()];
        if (i10 == 1) {
            m.f40102a.e("Core", error.getMessage(), error.getCause());
        } else if (i10 == 2) {
            m.f40102a.b("Core", error.getMessage(), error.getCause());
        } else {
            if (i10 == 3) {
                throw new IllegalStateException(error.getMessage(), error.getCause());
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
