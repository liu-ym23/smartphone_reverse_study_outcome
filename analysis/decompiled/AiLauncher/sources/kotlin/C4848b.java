package kotlin;

import Y8.h;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "initializer", "LY8/h;", Const.INTENT_KEY_PKGNAME, "(Lp9/a;)LY8/h;", "Lkotlin/LazyThreadSafetyMode;", "mode", Const.INTENT_KEY_APIKEY, "(Lkotlin/LazyThreadSafetyMode;Lp9/a;)LY8/h;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/LazyKt")
/* renamed from: kotlin.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4848b {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.b$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34707a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34707a = iArr;
        }
    }

    public static <T> h<T> a(LazyThreadSafetyMode mode, InterfaceC5063a<? extends T> initializer) {
        p.i(mode, "mode");
        p.i(initializer, "initializer");
        int i10 = a.f34707a[mode.ordinal()];
        int i11 = 2;
        if (i10 == 1) {
            i iVar = null;
            return new SynchronizedLazyImpl(initializer, iVar, i11, iVar);
        }
        if (i10 == 2) {
            return new SafePublicationLazyImpl(initializer);
        }
        if (i10 == 3) {
            return new UnsafeLazyImpl(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static <T> h<T> b(InterfaceC5063a<? extends T> initializer) {
        p.i(initializer, "initializer");
        i iVar = null;
        return new SynchronizedLazyImpl(initializer, iVar, 2, iVar);
    }
}
