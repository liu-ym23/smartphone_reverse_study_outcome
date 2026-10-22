package az8;

import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.service.o;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;
import tx9.a4;
import uo8.l;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends ab9.b<ty8.b> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet<Integer> f16810n;

    /* JADX INFO: renamed from: az8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0247a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16811a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f16811a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ab9.b
    public final JSONObject y() {
        ty8.b r100 = (ty8.b) this.f343898d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f548010f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ab9.b
    public final c4 z() {
        ty8.b r100 = (ty8.b) this.f343898d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f548011g;
    }

    public a() {
        this.f16810n = new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ab9.b
    public final void A(int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "slideStatus");
        ty8.b r113 = (ty8.b) this.f343898d;
        JSONObject r100 = null;
        String r101 = null;
        r101 = null;
        if (r113 == null) goto L5;
        GalleryType r114 = r113.f548009e;
    L6:
        if (r114 != null) goto L8;
        int r115 = -1;
    L10:
        if (r115 == 1) goto L56;
        if (r115 != 2) goto L70;
        ty8.b r116 = (ty8.b) this.f343898d;
        if (r116 == null) goto L19;
        g r117 = r116.f548007c;
        if (r117 == null) goto L19;
        String r102 = r117.f520257a;
    L20:
        if (r116 == null) goto L24;
        c4 r118 = r116.f548011g;
        if (r118 == null) goto L24;
        String r103 = r118.f314985b;
    L25:
        if (r116 == null) goto L29;
        c4 r119 = r116.f548011g;
        if (r119 == null) goto L29;
        String r104 = r119.f314984a;
    L30:
        if (r116 == null) goto L34;
        c4 r120 = r116.f548011g;
        if (r120 == null) goto L34;
        String r105 = r120.f314986c;
    L35:
        if (r116 == null) goto L39;
        c4 r121 = r116.f548011g;
        if (r121 == null) goto L39;
        String r106 = r121.f314990g;
    L40:
        if (r116 == null) goto L44;
        c4 r122 = r116.f548011g;
        if (r122 == null) goto L44;
        String r107 = r122.f314993j;
    L45:
        if (r116 == null) goto L49;
        c4 r123 = r116.f548011g;
        if (r123 == null) goto L49;
        Integer r108 = r123.f314992i;
    L50:
        if (r116 == null) goto L54;
        c4 r124 = r116.f548011g;
        if (r124 == null) goto L54;
        r101 = r124.f314991h;
    L54:
        a4.h(r102, r103, r104, r111, r105, r106, r107, r108, r101, "user", 3072);
        return;
    L49:
        r108 = null;
    L44:
        r107 = null;
    L39:
        r106 = null;
    L34:
        r105 = null;
    L29:
        r104 = null;
    L24:
        r103 = null;
    L19:
        r102 = null;
        goto L20
    L70:
        return;
    L56:
        if (this.f16810n.contains(Integer.valueOf(r110)) == true) goto L64;
        o r125 = o.f365780a;
        ty8.b r109 = (ty8.b) this.f343898d;
        if (r109 == null) goto L62;
        JSONObject r126 = r109.f548010f;
        if (r126 == null) goto L62;
        r126.put("enter_method", r111);
        Unit r127 = Unit.INSTANCE;
    L63:
        r125.reportEvent("enter_picture_detail", r126);
        this.f16810n.add(Integer.valueOf(r110));
    L62:
        r126 = null;
    L64:
        l.a r128 = l.f550936a;
        ty8.b r129 = (ty8.b) this.f343898d;
        if (r129 == null) goto L67;
        r100 = r129.f548010f;
    L67:
        l.b(r110, r100);
        return;
    L8:
        r115 = C0247a.f16811a[r114.ordinal()];
        goto L10
    L5:
        r114 = null;
        goto L6
    }
}
