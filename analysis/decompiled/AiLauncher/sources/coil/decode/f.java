package coil.decode;

import F1.j;
import Mb.AbstractC0971i;
import Mb.InterfaceC0968f;
import Mb.z;
import android.content.Context;
import coil.decode.e;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LMb/z;", Const.STR_FILE, "LMb/i;", "fileSystem", "", "diskCacheKey", "Ljava/io/Closeable;", "closeable", "Lcoil/decode/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/z;LMb/i;Ljava/lang/String;Ljava/io/Closeable;)Lcoil/decode/e;", "LMb/f;", "source", "Landroid/content/Context;", "context", "e", "(LMb/f;Landroid/content/Context;)Lcoil/decode/e;", "Lcoil/decode/e$a;", "metadata", "f", "(LMb/f;Landroid/content/Context;Lcoil/decode/e$a;)Lcoil/decode/e;", "coil-base_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f {
    public static final File c(Context context) {
        return j.m(context);
    }

    public static final File d(Context context) {
        return j.m(context);
    }

    public static final e e(InterfaceC0968f interfaceC0968f, final Context context) {
        return new h(interfaceC0968f, new InterfaceC5063a() { // from class: u1.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return coil.decode.f.c(context);
            }
        }, null);
    }

    public static final e f(InterfaceC0968f interfaceC0968f, final Context context, e.a aVar) {
        return new h(interfaceC0968f, new InterfaceC5063a() { // from class: u1.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return coil.decode.f.d(context);
            }
        }, aVar);
    }

    public static final e g(z zVar, AbstractC0971i abstractC0971i, String str, Closeable closeable) {
        return new d(zVar, abstractC0971i, str, closeable, null);
    }

    public static /* synthetic */ e h(z zVar, AbstractC0971i abstractC0971i, String str, Closeable closeable, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            abstractC0971i = AbstractC0971i.f4735b;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            closeable = null;
        }
        return g(zVar, abstractC0971i, str, closeable);
    }
}
