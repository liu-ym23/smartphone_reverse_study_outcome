package r0;

import android.os.Build;
import androidx.core.backported.fixes.Status;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Lr0/a;", "", "Lr0/h;", "resolver", "<init>", "(Lr0/h;)V", "()V", "Lr0/c;", "ki", "", Const.INTENT_KEY_PKGNAME, "(Lr0/c;)Z", "Landroidx/core/backported/fixes/Status;", Const.INTENT_KEY_APIKEY, "(Lr0/c;)Landroidx/core/backported/fixes/Status;", "Lr0/h;", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5196a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h resolver;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: r0.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0514a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38726a;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.Fixed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.NotApplicable.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Status.NotFixed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f38726a = iArr;
        }
    }

    public C5196a(h resolver) {
        p.i(resolver, "resolver");
        this.resolver = resolver;
    }

    public final Status a(c ki) {
        p.i(ki, "ki");
        return ki.e().invoke().booleanValue() ? ki.d().contains(Build.FINGERPRINT) ? Status.Fixed : this.resolver.a(ki) : Status.NotApplicable;
    }

    public final boolean b(c ki) {
        p.i(ki, "ki");
        int i10 = C0514a.f38726a[a(ki).ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2 || i10 == 3) {
            return true;
        }
        if (i10 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public C5196a() {
        this(new j());
    }
}
