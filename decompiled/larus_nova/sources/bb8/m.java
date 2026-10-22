package bb8;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, MediaEntity> f18548a = null;

    static {
        f18548a = new HashMap();
    }

    public static String a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(k0.a(r100), "//flow/open_video") == true) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(UriProtector.parse(r100), "item_id");
    }

    public static void b(List r410) {
        if (r410 == null) goto L22;
        ArrayList r100 = new ArrayList();
        Iterator r101 = r410.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = ((i) r101.next()).c();
        if (r102 == null) goto L6;
        r100.add(r102);
        goto L6
    L10:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(k0.a((String) r105), "//flow/open_video") == false) goto L12;
        r103.add(r105);
        goto L12
    L16:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L18:
        if (r107.hasNext() == false) goto L24;
        String r108 = UriProtector.getQueryParameter(UriProtector.parse((String) r107.next()), "item_id");
        if (r108 == null) goto L18;
        r106.add(r108);
    L24:
        if (r106 != null) goto L26;
    L29:
        boolean r109 = true;
    L30:
        if (r109 == true) goto L68;
        ArrayList r110 = new ArrayList();
        Iterator r111 = r106.iterator();
    L34:
        if (r111.hasNext() == false) goto L38;
        Object r112 = r111.next();
        if ((!f18548a.containsKey((String) r112)) == false) goto L34;
        r110.add(r112);
        goto L34
    L38:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r110.iterator();
    L40:
        if (r114.hasNext() == false) goto L42;
        r113.add(new MediaEntity(null, (String) r114.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16777213, null));
        goto L40
    L42:
        ArrayList r115 = new ArrayList(r113);
        if (r115.isEmpty() == true) goto L69;
        MediaEntityContainer r116 = new MediaEntityContainer(null, r115, null, null, false, 0, 0, null, 253, null);
        CommonVideoModel r117 = new CommonVideoModel(null);
        r117.setLoadMoreContainer(r116);
        r117.setUseNewApiGetVideoModel(true);
        r117.requestPreloadVideoByItemIds(r116, new k());
        return;
    L69:
        return;
    L68:
        return;
    L26:
        if (r106.isEmpty() == true) goto L29;
        r109 = false;
        goto L30
    L22:
        r106 = null;
        goto L24
    }
}
