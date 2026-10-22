package ae0;

import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements a {
    public d() {
    }

    @Override // ae0.a
    public final ArrayList<IVoiceLiveTheme> a(ArrayList<IVoiceLiveTheme> r110) {
        Intrinsics.checkNotNullParameter(r110, "themes");
        long r100 = e.a() / ((long) 1000);
        ArrayList r101 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L19;
        Object r102 = r111.next();
        IVoiceLiveTheme r103 = (IVoiceLiveTheme) r102;
        boolean r104 = true;
        if (r103.getTimeLimit() == 1) goto L8;
    L17:
        if (r104 == false) goto L4;
        r101.add(r102);
        goto L4
    L8:
        if (r103.getEndTime() > 0) goto L10;
    L16:
        r104 = false;
        goto L17
    L10:
        if (r103.getStartTime() >= r103.getEndTime()) goto L16;
        if (r100 < r103.getStartTime()) goto L16;
        if (r100 >= r103.getEndTime()) goto L16;
    L19:
        ArrayList<IVoiceLiveTheme> r112 = new ArrayList();
        r112.addAll(r101);
        return r112;
    }
}
