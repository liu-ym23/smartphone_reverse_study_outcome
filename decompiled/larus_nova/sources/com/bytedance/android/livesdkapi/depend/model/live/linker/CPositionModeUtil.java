package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\"\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/CPositionModeUtil;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "user", "", "isCPositionUser", "", "interactId", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "onlineList", "hasCPositionUser", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionModeUtil {
    public static final CPositionModeUtil INSTANCE = null;

    private CPositionModeUtil() {
    }

    static {
        INSTANCE = new CPositionModeUtil();
    }

    @JvmStatic
    public static final boolean hasCPositionUser(List<ILinkPlayerInfoBridge> r100) {
        if (r100 == null) goto L10;
        Iterator<ILinkPlayerInfoBridge> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L15;
        if (r101.next().isEnlarged() == false) goto L5;
        return true;
    L15:
        return false;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean isCPositionUser(k r100) {
        if (r100 == null) goto L10;
        k1 r101 = r100.getContent();
        if (r101 == null) goto L10;
        l1 r102 = r101.getLinkMicAudienceContent();
        if (r102 == null) goto L10;
        if (r102.isEnlarged() != true) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final boolean isCPositionUser(String r100, List<ILinkPlayerInfoBridge> r101) {
        if (r101 == null) goto L12;
        Iterator<ILinkPlayerInfoBridge> r102 = r101.iterator();
    L5:
        if (r102.hasNext() == false) goto L20;
        ILinkPlayerInfoBridge r103 = r102.next();
        if (Intrinsics.areEqual(r103.getInteractId(), r100) == false) goto L5;
        if (r103.isEnlarged() == false) goto L5;
        return true;
    L20:
        return false;
    L12:
        return false;
    }
}
