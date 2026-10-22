package tb;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltb/m;", "", "Ltb/v;", "url", "", "Ltb/l;", "cookies", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ltb/v;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ltb/v;)Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5546m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f42217a;

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5546m f42216b = new Companion.C0531a();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\b"}, d2 = {"Ltb/m$a;", "", "<init>", "()V", "Ltb/m;", "NO_COOKIES", "Ltb/m;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.m$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f42217a = new Companion();

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ltb/m$a$a;", "Ltb/m;", "<init>", "()V", "Ltb/v;", "url", "", "Ltb/l;", "cookies", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ltb/v;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ltb/v;)Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.m$a$a, reason: collision with other inner class name */
        public static final class C0531a implements InterfaceC5546m {
            @Override // tb.InterfaceC5546m
            public List<C5545l> a(v url) {
                kotlin.jvm.internal.p.i(url, "url");
                return C1173v.m();
            }

            @Override // tb.InterfaceC5546m
            public void b(v url, List<C5545l> cookies) {
                kotlin.jvm.internal.p.i(url, "url");
                kotlin.jvm.internal.p.i(cookies, "cookies");
            }
        }
    }

    List<C5545l> a(v url);

    void b(v url, List<C5545l> cookies);
}
