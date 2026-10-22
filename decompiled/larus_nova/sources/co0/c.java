package co0;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.cp0;
import com.bytedance.android.livesdk.config.hg1;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f24604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f24605b;

    static {
        f24604a = new LruCache(5);
    }

    @JvmStatic
    public static final String a(String r100, String r101) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        Uri r102 = UriProtector.parse(r100);
        if (r102 == null) goto L15;
        Uri.Builder r103 = r102.buildUpon();
        if (r103 == null) goto L16;
        Uri.Builder r104 = r103.appendQueryParameter("r_signature", r101);
        if (r104 == null) goto L17;
        String r105 = r104.toString();
        if (r105 != null) goto L14;
        return r100;
    L14:
        return r105;
    L17:
        return r100;
    L16:
        return r100;
    L15:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final String b(String r100, String r101) {
        if (r100 == null) goto L34;
        hg1 r102 = cp0.f119970a.getValue();
        if (r102 != null) goto L6;
        return r100;
    L6:
        if (r102.b(r101) != true) goto L37;
        Uri r103 = UriProtector.parse(r100);
        if (r103 != null) goto L12;
    L15:
        String r104 = "";
    L16:
        boolean r105 = false;
        if (r104.length() != 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        return r100;
    L22:
        LruCache r107 = f24604a;
        if (r107 == null) goto L25;
        String r108 = (String) r107.get(r104);
    L26:
        if (r108 != null) goto L28;
        return r100;
    L28:
        if (r108.length() <= 0) goto L30;
        r105 = true;
    L30:
        if (r105 == true) goto L33;
        return r100;
    L33:
        return a(r100, r108);
    L25:
        r108 = null;
        goto L26
    L19:
        r106 = false;
        goto L20
    L12:
        if (r103.isOpaque() == true) goto L15;
        r104 = UriProtector.getQueryParameter(r103, "room_id");
        if (r104 != null) goto L16;
    L37:
        return r100;
    L34:
        return r100;
    }

    @JvmStatic
    public static final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "signature");
        LruCache r102 = f24604a;
        if (r102 == null) goto L6;
        r102.put(String.valueOf(r100), r101);
    L6:
        if (f24605b == true) goto L22;
        f24605b = true;
        IMiddlewareUserService r103 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r103 == null) goto L18;
        e r104 = r103.user();
        if (r104 == null) goto L19;
        Flowable<UserEvent> r105 = r104.m();
        if (r105 == null) goto L20;
        Flowable<UserEvent> r106 = r105.onBackpressureLatest();
        if (r106 == null) goto L21;
        r106.subscribe(a.f24602a, b.f24603a);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
