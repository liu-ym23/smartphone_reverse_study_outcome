package a36;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f1577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1580d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1581a = null;

        static {
            int[] r100 = new int[KitType.values().length];
            r100[KitType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[KitType.WEB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f1581a = r100;
        }
    }

    static {
    }

    public abstract String b();

    public abstract KitType c();

    public final String a() {
        return this.f1577a.toString();
    }

    public c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f1577a = r100;
    }
}
