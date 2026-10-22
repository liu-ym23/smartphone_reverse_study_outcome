package b26;

import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.d1;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v26.j;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f17027a = null;

    static {
        ArrayList r100 = new ArrayList();
        r100.add("http");
        r100.add("local_file");
        r100.add(ChameleonAssertResManager.ASSET_FOLDER);
        r100.add("https");
        r100.add(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW);
        f17027a = r100;
    }

    public static boolean a(j r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "url");
        if (i.f246826c == false) goto L6;
        return false;
    L6:
        if ((!((ArrayList) r100.f552695p).isEmpty()) == false) goto L15;
        Iterator r102 = ((ArrayList) r100.f552695p).iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (StringsKt.contains$default(r101, (String) r102.next(), false, 2, null) == false) goto L9;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L15;
        return false;
    L13:
        r103 = false;
    L15:
        return true;
    }

    public static void b(d1 r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        Intrinsics.checkNotNullParameter(r101, "config");
        String r102 = r100.f247858a.getScheme();
        boolean r103 = true;
        if (i.f246826c == false) goto L6;
    L16:
        r100.f247864g = r103;
        return;
    L6:
        if (CollectionsKt.contains(f17027a, r102) == true) goto L16;
        if (r100.f247861d != null) goto L16;
        if (r101.f552705h.length() <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = false;
        goto L16
    L12:
        r104 = false;
        goto L13
    }
}
