package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR.\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00060\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/g;", "", "", "bubbleId", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/g$b;", "query", "", "", "lastShowItems", "Ljava/util/Map;", "items", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f115848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f115849b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f115850c = null;

    @SerializedName("items")
    private Map<String, Map<Integer, b>> items;

    @SerializedName("last_show_items")
    private Map<String, b> lastShowItems;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00028\u0006@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/bubble/g$b;", "", "", "status", "I", "<set-?>", "showTimes", "d", "()I", "", "lastShowTime", "J", "c", "()J", "setLastShowTime", "(J)V", "showPanelEffect", "bubbleId", "b", "setBubbleId", "(I)V", "associateButtonId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("associate_button_id")
        private final long associateButtonId;

        @SerializedName("bubble_id")
        private int bubbleId;

        @SerializedName("last_show_time")
        private long lastShowTime;

        @SerializedName("show_panel_effect")
        private int showPanelEffect;

        @SerializedName("show_times")
        private int showTimes;

        @SerializedName("status")
        private int status;

        public final void h() {
            this.status = 1;
        }

        public final void i() {
            this.showPanelEffect = 1;
        }

        public final boolean e() {
            if (this.status == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean f() {
            if (this.showPanelEffect == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public final String toString() {
            return "Item(bubbleId=" + this.bubbleId + ", associateButtonId=" + this.associateButtonId + ", status=" + this.status + ", showTimes=" + this.showTimes + ", lastShowTime=" + this.lastShowTime + ", showPanelEffect=" + this.showPanelEffect + ')';
        }

        public final boolean g() {
            if (e() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.showTimes >= 3) goto L8;
            return false;
        }

        public final void j() {
            this.lastShowTime = System.currentTimeMillis();
            int r100 = this.showTimes + 1;
            this.showTimes = r100;
            if (this.bubbleId != 1001) goto L5;
        L7:
            this.showPanelEffect = 0;
            return;
        L5:
            if (r100 < 3) goto L7;
            this.status = 1;
        }

        public final long a() {
            return this.associateButtonId;
        }

        public final int b() {
            return this.bubbleId;
        }

        public final long c() {
            return this.lastShowTime;
        }

        public final int d() {
            return this.showTimes;
        }

        public b(int r100, long r101) {
            this.bubbleId = r100;
            this.associateButtonId = r101;
        }
    }

    static {
        f115850c = new a();
        f115848a = Keva.getRepo("BubbleShowRecord");
        f115849b = "BubbleShowRecord";
    }

    public static String a() {
        return ((IUserService) jc1.k.n(IUserService.class)).user().n();
    }

    public final Map<Integer, b> b() {
        Map<Integer, b> r100 = this.items.get(a());
        if (r100 != null) goto L6;
        LinkedHashMap r101 = new LinkedHashMap();
        this.items.put(a(), r101);
        return r101;
    L6:
        return r100;
    }

    public final b c() {
        return this.lastShowItems.get(a());
    }

    public g() {
        this.lastShowItems = new LinkedHashMap();
        this.items = new LinkedHashMap();
    }

    public final boolean d() {
        b r100 = c();
        if (r100 == null) goto L11;
        long r101 = r100.c();
        if (Math.abs(System.currentTimeMillis() - r101) >= 86400000) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = false;
        goto L8
    L11:
        return false;
    }

    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.lastShowItems.put(a(), r100);
    }

    public final void f(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        b().put(Integer.valueOf(r100.b()), r100);
        f115850c.getClass();
        Intrinsics.checkNotNullParameter(this, "record");
        String r101 = JsonUtil.toJSONString(this);     // Catch: Exception -> L8
        if (v.a() == false) goto L6;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r102 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();     // Catch: Exception -> L8
        r102.d("BubbleShowRecord");     // Catch: Exception -> L8
        r102.c("气泡展示记录保存");     // Catch: Exception -> L8
        r102.a("recordJson", r101);     // Catch: Exception -> L8
        MorePanelBubbleAlog.a(r102.b());     // Catch: Exception -> L8
    L6:
        f115848a.storeString(f115849b, r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "BubbleShowRecord: 保存json失败");
    }

    public final b query(int r100) {
        return b().get(Integer.valueOf(r100));
    }
}
