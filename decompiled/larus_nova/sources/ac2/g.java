package ac2;

import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2579a = 0;

    public static final class a {
        @JvmStatic
        public static String a(com.ss.ugc.live.sdk.msg.network.g r100) {
            Intrinsics.checkNotNullParameter(r100, "httpResponse");
            List<com.ss.ugc.live.sdk.msg.network.d> r101 = r100.f458313c;
            if (r101 == null) goto L15;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Object r103 = r102.next();
            if (StringsKt.equals(NetResponse.HEADER_KEY_LOG_ID, ((com.ss.ugc.live.sdk.msg.network.d) r103).f458296a, true) == false) goto L6;
        L11:
            com.ss.ugc.live.sdk.msg.network.d r104 = (com.ss.ugc.live.sdk.msg.network.d) r103;
            if (r104 == null) goto L15;
            String r105 = r104.f458297b;
            if (r105 == null) goto L15;
            return r105;
        L10:
            r103 = null;
        L15:
            return "not exist";
        }
    }

    static {
    }
}
