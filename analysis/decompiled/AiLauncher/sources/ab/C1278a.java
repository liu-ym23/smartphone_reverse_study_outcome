package ab;

import Y8.t;
import Za.C1189i;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.DispatchException;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a=\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aQ\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000e\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0012\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Le9/c;", "", "completion", "LY8/t;", "c", "(Lp9/l;Le9/c;)V", "R", "Lkotlin/Function2;", "receiver", Const.INTENT_KEY_UMID, "(Lp9/p;Ljava/lang/Object;Le9/c;)V", "fatalCompletion", Const.INTENT_KEY_PKGNAME, "(Le9/c;Le9/c;)V", "", "e", Const.INTENT_KEY_APIKEY, "(Le9/c;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: ab.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1278a {
    public static final void a(InterfaceC4014c<?> interfaceC4014c, Throwable th) throws Throwable {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).getCause();
        }
        Result.Companion companion = Result.INSTANCE;
        interfaceC4014c.resumeWith(Result.b(C4849c.a(th)));
        throw th;
    }

    public static final void b(InterfaceC4014c<? super t> interfaceC4014c, InterfaceC4014c<?> interfaceC4014c2) throws Throwable {
        try {
            InterfaceC4014c interfaceC4014cD = IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c);
            Result.Companion companion = Result.INSTANCE;
            C1189i.b(interfaceC4014cD, Result.b(t.f7040a));
        } catch (Throwable th) {
            a(interfaceC4014c2, th);
        }
    }

    public static final <T> void c(InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super T> interfaceC4014c) {
        try {
            InterfaceC4014c interfaceC4014cD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.a(interfaceC5074l, interfaceC4014c));
            Result.Companion companion = Result.INSTANCE;
            C1189i.b(interfaceC4014cD, Result.b(t.f7040a));
        } catch (Throwable th) {
            a(interfaceC4014c, th);
        }
    }

    public static final <R, T> void d(p<? super R, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, R r10, InterfaceC4014c<? super T> interfaceC4014c) {
        try {
            InterfaceC4014c interfaceC4014cD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(pVar, r10, interfaceC4014c));
            Result.Companion companion = Result.INSTANCE;
            C1189i.b(interfaceC4014cD, Result.b(t.f7040a));
        } catch (Throwable th) {
            a(interfaceC4014c, th);
        }
    }
}
