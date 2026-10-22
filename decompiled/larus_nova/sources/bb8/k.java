package bb8;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class k implements CommonVideoModel.b {
    public k() {
    }

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void a(MediaEntityContainer r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        ArrayList<MediaEntity> r102 = r100.getVideo_list();
    L6:
        boolean r103 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        FLogger.f375446a.d("BannerVideoPreloadManager", "[preloadVideoByItemIds] error:media list is empty ");
        return;
    L15:
        if (r100 == null) goto L26;
        ArrayList<MediaEntity> r105 = r100.getVideo_list();
        if (r105 == null) goto L26;
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L26;
        MediaEntity r107 = (MediaEntity) r106.next();
        if (r107 == null) goto L20;
        String r108 = r107.getItem_id();
        if (r108 == null) goto L20;
        m.f18548a.put(r108, r107);
    L26:
        HashMap<String, MediaEntity> r109 = m.f18548a;
        if (r100 == null) goto L29;
        ArrayList<MediaEntity> r110 = r100.getVideo_list();
    L30:
        if (r110 != null) goto L32;
    L35:
        if (r103 == true) goto L53;
        Lazy r111 = q3.f365794a;
        z3 r112 = q3.a();
        if (r112 == null) goto L52;
        MediaEntity r113 = (MediaEntity) CollectionsKt.firstOrNull(r110);
        if (r113 == null) goto L42;
        r101 = r113.getVideo_model();
    L42:
        r112.f(r101, new l(r110));
        return;
    L52:
        return;
    L53:
        return;
    L32:
        if (r110.isEmpty() == true) goto L35;
        r103 = false;
        goto L35
    L29:
        r110 = null;
        goto L30
    L9:
        if (r102.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void b(AsyncThrowable r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[preloadVideoByItemIds] error:");
        String r103 = null;
        if (r100 == null) goto L5;
        Long r104 = Long.valueOf(r100.getCode());
    L6:
        r102.append(r104);
        r102.append(':');
        if (r100 == null) goto L9;
        r103 = r100.getMessage();
    L9:
        r102.append(r103);
        r101.d("BannerVideoPreloadManager", r102.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }
}
