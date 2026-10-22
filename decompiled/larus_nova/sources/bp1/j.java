package bp1;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class j {
    public static o b(DataCenter r100) {
        return ((IRoomContextService) k.n(IRoomContextService.class)).getRoomDataContext(r100, 0);
    }

    public static com.bytedance.android.livesdk.chatroom.k a(DataCenter r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return ((IRoomContextService) k.n(IRoomContextService.class)).getBottomToolbarService(r100, 0);
    }
}
