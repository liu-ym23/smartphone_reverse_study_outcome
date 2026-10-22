package com.bytedance.android.livesdk.arch.context;

import com.bytedance.android.livesdk.arch.comp.b;
import com.bytedance.android.livesdk.arch.container.d;
import com.bytedance.android.livesdk.arch.data.g;
import com.bytedance.android.livesdk.arch.task.f;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    public static final C1567a K0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.arch.context.a$a, reason: collision with other inner class name */
    public static final class C1567a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1567a f103766a = null;

        public C1567a() {
        }

        static {
            f103766a = new C1567a();
        }

        @JvmStatic
        public static a a(MiddlewareRoomContext r100, DataCenter r101) {
            IToolbarService r102 = (IToolbarService) k.f(IToolbarService.class);
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.getTbContext(r100, r101);
        }
    }

    static {
        K0 = C1567a.f103766a;
    }

    o configRegister();

    m getCompactTbLoader();

    com.bytedance.android.livesdk.arch.container.a<b> getContainer(d r100);

    ILivePreviewBusinessBridge getPreviewBizBridge(d r100);

    void initContainer(d r100, com.bytedance.android.livesdk.arch.container.a<b> r101);

    void initDataPsService(g r100);

    void initPreviewBizBridgeProvider(d r100, Function0<? extends ILivePreviewBusinessBridge> r101);

    void onRoomUiDestroy(boolean r100);

    com.bytedance.android.livesdk.arch.record.a<b> recordManager(d r100);

    me1.a stateDispatcher();

    f taskFlower();

    Disposable useContainer(d r100, Function1<? super com.bytedance.android.livesdk.arch.container.a<b>, Unit> r101);
}
