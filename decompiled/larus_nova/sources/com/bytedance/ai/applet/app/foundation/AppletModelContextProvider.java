package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletModelContextProvider implements w, AppletChatInputController.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletApplication f34188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Long, PageContext> f34189b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/AppletModelContextProvider$PageContext;", "", "bizTaskId", "", com.heytap.mcssdk.constant.b.f276376z, "pagePath", "pageInfo", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBizTaskId", "()Ljava/lang/String;", "getAppKey", "getPagePath", "getPageInfo", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PageContext {

        @SerializedName("app_key")
        private final String appKey;

        @SerializedName("biz_task_id")
        private final String bizTaskId;

        @SerializedName("page_info")
        private final Map<String, Object> pageInfo;

        @SerializedName("page_path")
        private final String pagePath;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageContext copy$default(PageContext r100, String r101, String r102, String r103, Map r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.bizTaskId;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.appKey;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.pagePath;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.pageInfo;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.bizTaskId;
        }

        public final String component2() {
            return this.appKey;
        }

        public final String component3() {
            return this.pagePath;
        }

        public final Map<String, Object> component4() {
            return this.pageInfo;
        }

        public final PageContext copy(String r100, String r101, String r102, Map<String, ? extends Object> r103) {
            Intrinsics.checkNotNullParameter(r100, "bizTaskId");
            Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276376z);
            Intrinsics.checkNotNullParameter(r103, "pageInfo");
            return new PageContext(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PageContext) == true) goto L8;
            return false;
        L8:
            PageContext r101 = (PageContext) r100;
            if (Intrinsics.areEqual(this.bizTaskId, r101.bizTaskId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pagePath, r101.pagePath) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.pageInfo, r101.pageInfo) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.bizTaskId.hashCode() * 31) + this.appKey.hashCode()) * 31;
            String r101 = this.pagePath;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.pageInfo.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "PageContext(bizTaskId=" + this.bizTaskId + ", appKey=" + this.appKey + ", pagePath=" + this.pagePath + ", pageInfo=" + this.pageInfo + ')';
        }

        public final String getAppKey() {
            return this.appKey;
        }

        public final String getBizTaskId() {
            return this.bizTaskId;
        }

        public final Map<String, Object> getPageInfo() {
            return this.pageInfo;
        }

        public final String getPagePath() {
            return this.pagePath;
        }

        public PageContext(String r100, String r101, String r102, Map<String, ? extends Object> r103) {
            Intrinsics.checkNotNullParameter(r100, "bizTaskId");
            Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276376z);
            Intrinsics.checkNotNullParameter(r103, "pageInfo");
            this.bizTaskId = r100;
            this.appKey = r101;
            this.pagePath = r102;
            this.pageInfo = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final Integer getSource() {
        return 3;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final String b() {
        AppletAppActivity r100 = this.f34188a.f34085d;
        if (r100 == null) goto L7;
        Long r101 = r100.C1();
        if (r101 == null) goto L7;
        PageContext r102 = this.f34189b.get(r101);
    L8:
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getBizTaskId();
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final AppletChatInputController.e c() {
        AppletAppActivity r100 = this.f34188a.f34085d;
        String r101 = null;
        if (r100 == null) goto L7;
        Long r102 = r100.C1();
        if (r102 == null) goto L7;
        PageContext r103 = this.f34189b.get(r102);
    L8:
        if (r103 != null) goto L10;
        return null;
    L10:
        String r104 = r103.getPagePath();
        if (r104 != null) goto L21;
        AppletAppActivity r105 = this.f34188a.f34085d;
        if (r105 == null) goto L22;
        r104 = r105.f34075h;
        if (r104 == null) goto L22;
        if (r104.length() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
    L19:
        r106 = false;
    L22:
        Lazy r107 = com.bytedance.ai.applet.base.gson.e.f34515a;
        return new AppletChatInputController.e("miniapp_page", this.f34188a.j().f36895b, new AppletChatInputController.f(com.bytedance.ai.applet.base.gson.e.c(PageContext.copy$default(r103, null, null, r101, null, 11, null))));
    L21:
        r101 = r104;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final Map<String, String> getExtra() {
        return MapsKt.mapOf(TuplesKt.to("miniapp_appkey", this.f34188a.getAppId()));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        com.bytedance.ai.utils.g.f37637a.i("AppletModelContextProvider", "onDestroy, clear " + this.f34189b.size() + " page contexts");
        this.f34189b.clear();
    }

    public AppletModelContextProvider(AppletApplication r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f34188a = r100;
        this.f34189b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
