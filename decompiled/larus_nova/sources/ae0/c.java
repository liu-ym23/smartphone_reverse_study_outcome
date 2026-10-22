package ae0;

import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeDownloadManager;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements a {
    public c() {
    }

    @Override // ae0.a
    public final ArrayList<IVoiceLiveTheme> a(ArrayList<IVoiceLiveTheme> r100) {
        Intrinsics.checkNotNullParameter(r100, "themes");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (IVoiceLiveThemeKt.isUgcVideoTheme((IVoiceLiveTheme) r102) == false) goto L4;
    L9:
        IVoiceLiveTheme r103 = (IVoiceLiveTheme) r102;
        boolean r104 = false;
        if (r103 == null) goto L18;
        IAnimatedBgInfo r105 = r103.getAnimatedBgInfo();
        if (r105 == null) goto L18;
        k r106 = r105.getAnimatedBg();
        if (r106 == null) goto L18;
        List<String> r107 = r106.getUrls();
        if (r107 == null) goto L18;
        String r108 = (String) ListProtector.get(r107, 0);
    L19:
        if (r103 == null) goto L25;
        IAnimatedBgInfo r109 = r103.getAnimatedBgInfo();
        if (r109 == null) goto L25;
        k r110 = r109.getAnimatedBg();
        if (r110 == null) goto L25;
        String r111 = r110.getUri();
    L27:
        if (r108 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == true) goto L44;
        if (r111 != null) goto L36;
    L37:
        r104 = true;
    L38:
        if (r104 == true) goto L44;
        if (VideoThemeDownloadManager.e(r111) == true) goto L44;
        Intrinsics.checkNotNullParameter(r111, "id");
        if (VideoThemeDownloadManager.f71683b.containsKey(r111) == true) goto L44;
        VideoThemeDownloadManager.b(r108, r111, null);
        goto L44
    L36:
        if (r111.length() != 0) goto L38;
    L44:
        return r100;
    L29:
        if (r108.length() == 0) goto L32;
        r112 = false;
    L25:
        r111 = null;
    L18:
        r108 = null;
        goto L19
    L8:
        r102 = null;
        goto L9
    }
}
