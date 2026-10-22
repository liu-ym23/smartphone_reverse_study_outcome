package cb9;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.h;
import com.larus.gallery.api.k;
import com.larus.gallery.api.m;
import com.larus.gallery.api.q;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import nr9.f;
import nr9.g;
import v19.m5;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f23099a = null;

    /* JADX INFO: renamed from: cb9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0424a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23100a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GalleryType.Custom.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f23100a = r100;
        }
    }

    static {
        f23099a = new LinkedHashMap();
    }

    public static String a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        GalleryType r101 = r100.getType();
        int[] r102 = C0424a.f23100a;
        int r103 = r102[r101.ordinal()];
        boolean r104 = true;
        String r105 = null;
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L11;
        if (r103 != 3) goto L10;
        h r106 = r100.f343862d;
        if (r106 == null) goto L21;
        String r107 = r106.f343856b;
    L22:
        int r108 = r102[r100.getType().ordinal()];
        if (r108 == 1) goto L46;
        if (r108 == 2) goto L29;
        if (r108 != 3) goto L28;
    L49:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("thumbUrl is null: ");
        if (r107 == null) goto L53;
        r104 = false;
    L53:
        r110.append(r104);
        r109.i("GalleryUtils", r110.toString());
        if (r107 == null) goto L56;
        return r107;
    L56:
        return r105;
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        q r111 = r100.f343861c;
        if (r111 == null) goto L49;
        g r112 = r111.f343890b;
        if (r112 == null) goto L49;
        f r113 = r112.f520263g;
        if (r113 == null) goto L49;
        if (m5.c(r113.f520253c) == true) goto L44;
        String r114 = r113.f520253c;
        if (r114 != null) goto L41;
        r114 = "";
    L41:
        if (m5.c(UriProtector.parse(r114).getPath()) == true) goto L44;
        String r115 = r113.f520252b;
    L45:
        r105 = r115;
    L44:
        r115 = r113.f520253c;
        goto L45
    L46:
        m r116 = r100.f343860b;
        if (r116 == null) goto L49;
        r105 = r116.f343865a;
    L21:
        r107 = null;
        goto L22
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        q r117 = r100.f343861c;
        if (r117 == null) goto L21;
        g r118 = r117.f343890b;
        if (r118 == null) goto L21;
        f r119 = r118.f520263g;
        if (r119 == null) goto L21;
        r107 = r119.f520251a;
        goto L22
    L18:
        m r120 = r100.f343860b;
        if (r120 == null) goto L21;
        r107 = r120.f343866b;
        goto L22
    }
}
