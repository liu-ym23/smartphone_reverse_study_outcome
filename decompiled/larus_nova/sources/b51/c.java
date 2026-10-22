package b51;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final boolean a(com.bytedance.android.livesdk.revenue.service.room.c r100) {
        if (r100 == null) goto L4;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
    L6:
        if (r101 == null) goto L10;
        IRoomBase r102 = r101.getCommonRoom();
        if (r102 == null) goto L10;
        boolean r103 = r102.isLiveTypeAudio();
    L11:
        if (r101 == null) goto L13;
        boolean r104 = r101.getCommonIsMediaRoom();
    L15:
        if (r101 == null) goto L23;
        IRoomBase r105 = r101.getCommonRoom();
        if (r105 == null) goto L23;
        IRoomSpecificSceneTypeInfo r106 = r105.getSceneTypeInfo();
        if (r106 == null) goto L23;
        if (r106.isLandscapeVerticalRoom() != 1) goto L23;
        boolean r107 = true;
    L24:
        b r108 = b.f17721c0;
        r108.getClass();
        if (((Number) b.W.getValue(r108, b.f17716a[47])).intValue() == 0) goto L31;
        if (r103 == true) goto L32;
        if (r104 == true) goto L33;
        if (r107 == true) goto L34;
        return true;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L23:
        r107 = false;
        goto L24
    L13:
        r104 = false;
    L10:
        r103 = false;
        goto L11
    L4:
        r101 = null;
        goto L6
    }
}
