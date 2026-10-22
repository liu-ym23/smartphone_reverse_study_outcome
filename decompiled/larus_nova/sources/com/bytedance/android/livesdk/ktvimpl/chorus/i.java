package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.de;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i {
    public static final List<MusicPanel> a(List<? extends de.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toMusicPanelList");
        ArrayList r100 = new ArrayList();
        Iterator<? extends de.a> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        de.a r101 = r111.next();
        Intrinsics.checkNotNullParameter(r101, "$this$toMusicPanel");
        r100.add(new MusicPanel(r101.a(), 0, null, r101.b(), MusicPanel.MusicPanelSource.KSONG, null, null, 1073741774));
        goto L4
    L6:
        return r100;
    }
}
