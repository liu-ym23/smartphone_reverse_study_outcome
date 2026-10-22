package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f116120a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f116121a = null;

        public a() {
        }

        static {
            f116121a = new a();
        }

        public static n a(DataCenter r100) {
            IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            if (r101 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.o r102 = IRoomContextService.a.a(r101, r100, 0, 2);
            if (r102 == null) goto L9;
            com.bytedance.live.datacontext.j<m> r103 = r102.getCompactTbLoader();
            if (r103 == null) goto L9;
            m r104 = r103.getValue();
        L11:
            if ((r104 instanceof m) == true) goto L13;
            r104 = null;
        L13:
            if (r104 != null) goto L15;
            return null;
        L15:
            return r104.getCheckManager();
        L9:
            r104 = null;
            goto L11
        }
    }

    static {
        f116120a = a.f116121a;
    }

    void a();

    void b(NewToolbarButtonConstants r100, ToolbarComponentCheckInterface r101);

    boolean c(int r100);

    void clear();

    void d(NewToolbarButtonConstants r100);
}
