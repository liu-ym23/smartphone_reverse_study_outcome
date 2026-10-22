package com.bytedance.android.gamecp.live_impl.toolbar;

import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/toolbar/ToolbarContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "enterRoomTimestamp", "J", "getEnterRoomTimestamp", "()J", "setEnterRoomTimestamp", "(J)V", "preloadToolbarDuration", "Ljava/lang/Long;", "getPreloadToolbarDuration", "()Ljava/lang/Long;", "setPreloadToolbarDuration", "(Ljava/lang/Long;)V", "", "preloadToolbarHasClick", "Z", "getPreloadToolbarHasClick", "()Z", "setPreloadToolbarHasClick", "(Z)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarContext extends DataContext {
    public static final String CONTEXT_TAG = "_toolbar_context";
    public static final a Companion = null;
    private long enterRoomTimestamp;
    private Long preloadToolbarDuration;
    private boolean preloadToolbarHasClick;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ToolbarContext a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "source");
            StringBuilder r103 = new StringBuilder();
            RoomContext.Companion.getClass();
            r103.append(RoomContext.a.a(r100, r101, r102));
            r103.append(ToolbarContext.CONTEXT_TAG);
            String r104 = r103.toString();
            DataContext r105 = com.bytedance.live.datacontext.d.d(r104);
            DataContext r106 = null;
            if ((r105 instanceof ToolbarContext) == true) goto L5;
            r105 = null;
        L5:
            ToolbarContext r107 = (ToolbarContext) r105;
            if (r107 != null) goto L13;
            DataContext r108 = com.bytedance.live.datacontext.d.d(ToolbarContext.class);
            if ((r108 instanceof ToolbarContext) == false) goto L11;
            r106 = r108;
        L11:
            ToolbarContext r109 = (ToolbarContext) r106;
            yr.b.b(6, "GameCP_RoomContext", "previewKey=" + r104 + " and result=" + r109);
            return r109;
        L13:
            return r107;
        }

        public static /* synthetic */ ToolbarContext b(a r100, String r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            String r104 = ILiveRoomControllerProvider.ProviderSource.DEFAULT.name();
        L12:
            r100.getClass();
            return a(r101, r102, r104);
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final ToolbarContext getShared() {
        return a.b(Companion, null, null, 7);
    }

    @JvmStatic
    public static final ToolbarContext getShared(String r100) {
        return a.b(Companion, r100, null, 6);
    }

    @JvmStatic
    public static final ToolbarContext getShared(String r100, String r101) {
        return a.b(Companion, r100, r101, 4);
    }

    @JvmStatic
    public static final ToolbarContext getShared(String r100, String r101, String r102) {
        Companion.getClass();
        return a.a(r100, r101, r102);
    }

    public ToolbarContext() {
        this.preloadToolbarDuration = 0L;
    }

    public final long getEnterRoomTimestamp() {
        return this.enterRoomTimestamp;
    }

    public final Long getPreloadToolbarDuration() {
        return this.preloadToolbarDuration;
    }

    public final boolean getPreloadToolbarHasClick() {
        return this.preloadToolbarHasClick;
    }

    public final void setEnterRoomTimestamp(long r100) {
        this.enterRoomTimestamp = r100;
    }

    public final void setPreloadToolbarDuration(Long r100) {
        this.preloadToolbarDuration = r100;
    }

    public final void setPreloadToolbarHasClick(boolean r100) {
        this.preloadToolbarHasClick = r100;
    }
}
