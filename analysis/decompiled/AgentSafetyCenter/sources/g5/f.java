package g5;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements o7.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4312c;

    public static /* synthetic */ void a() {
        throw new androidx.fragment.app.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(int i, int i3, int i10, int i11, int i12) {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + ((boolean) i) + ((Object) ", windowActionBarOverlay: ") + ((boolean) i3) + ((Object) ", android:windowIsFloating: ") + ((boolean) i10) + ((Object) ", windowActionModeOverlay: ") + ((boolean) i11) + ((Object) ", windowNoTitle: ") + ((boolean) i12) + ((Object) " }"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(int i, int i3, String str) {
        throw new IllegalArgumentException((str + i + ((char) i3)).toString());
    }

    public static /* synthetic */ void e(int i, String str) throws IOException {
        throw new IOException(str + i);
    }

    public static /* synthetic */ void f(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void g(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void h(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void j(StringBuilder sb2, Object obj, Object obj2) {
        sb2.append(obj);
        sb2.append(obj2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static /* synthetic */ void k() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void l(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void m(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void n(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void o(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void p(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void q(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void r(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void s(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void t(Object obj, String str) {
        throw new m7.h(str + ((Object) obj.toString()));
    }

    @Override // o7.o
    public Object b() {
        switch (this.f4312c) {
            case 19:
                return new o7.n(true);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return new LinkedHashMap();
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return new TreeMap();
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return new ConcurrentHashMap();
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return new ConcurrentSkipListMap();
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                return new ArrayList();
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                return new LinkedHashSet();
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                return new TreeSet();
            default:
                return new ArrayDeque();
        }
    }
}
