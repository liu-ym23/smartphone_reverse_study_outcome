package com.bytedance.android.livesdkapi.depend.model.live.vs;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IMultiTab;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMultiTab;", "()V", "disableBackground", "", "getDisableBackground", "()I", "setDisableBackground", "(I)V", "tabTitleColor", "", "getTabTitleColor", "()Ljava/lang/String;", "setTabTitleColor", "(Ljava/lang/String;)V", "tabs", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$TabItem;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "validTabs", "getValidTabs", "validTabs$delegate", "Lkotlin/Lazy;", "Bubble", "Companion", "TabItem", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTab extends FlexModelBase<IMultiTab> implements IMultiTab, h {
    public static final Companion Companion = null;
    private static final AtomicLong count = null;

    @SerializedName("disable_background")
    protected int disableBackground;

    @SerializedName("tab_title_color")
    protected String tabTitleColor;

    @SerializedName("tabs")
    protected List<TabItem> tabs;
    private final Lazy validTabs$delegate;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$Bubble;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBubble;", "()V", "bubbleId", "", "getBubbleId", "()J", "setBubbleId", "(J)V", "bubbleText", "", "getBubbleText", "()Ljava/lang/String;", "setBubbleText", "(Ljava/lang/String;)V", "delay", "getDelay", "setDelay", "duration", "getDuration", "setDuration", "showTabId", "getShowTabId", "setShowTabId", "switch", "", "getSwitch", "()I", "setSwitch", "(I)V", "toString", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Bubble extends FlexModelBase<IBubble> implements IBubble, h {

        @SerializedName("bubble_id")
        protected long bubbleId;

        @SerializedName("bubble_text")
        protected String bubbleText;

        @SerializedName("delay")
        protected long delay;

        @SerializedName("duration")
        protected long duration;
        private long showTabId;

        /* JADX INFO: renamed from: switch, reason: not valid java name */
        @SerializedName("switch")
        protected int f91switch;

        public Bubble() {
            super(IBubble.class);
            this.showTabId = -1;
        }

        public String toString() {
            return "bubble_text:" + getBubbleText() + ", bubbleId:" + getBubbleId() + ", switch:" + getSwitch() + ", delay:" + getDelay() + ", duration:" + getDuration() + ", showTabId:" + this.showTabId;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble
        public long getBubbleId() {
            return this.bubbleId;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble
        public String getBubbleText() {
            return this.bubbleText;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble
        public long getDelay() {
            return this.delay;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble
        public long getDuration() {
            return this.duration;
        }

        public final long getShowTabId() {
            return this.showTabId;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IBubble
        public int getSwitch() {
            return this.f91switch;
        }

        public Bubble(g r100) {
            super(IBubble.class);
            this.showTabId = -1;
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.f91switch = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.bubbleId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.duration = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.delay = r100.j();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.bubbleText = am3.h.c(r100);
            goto L3
        L15:
            am3.h.d(r103, r100);
            goto L3
        L21:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setBubbleId(long r100) {
            this.bubbleId = r100;
        }

        public void setBubbleText(String r100) {
            this.bubbleText = r100;
        }

        public void setDelay(long r100) {
            this.delay = r100;
        }

        public void setDuration(long r100) {
            this.duration = r100;
        }

        public final void setShowTabId(long r100) {
            this.showTabId = r100;
        }

        public void setSwitch(int r100) {
            this.f91switch = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$Companion;", "", "()V", "count", "Ljava/util/concurrent/atomic/AtomicLong;", "getCount", "()Ljava/util/concurrent/atomic/AtomicLong;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final AtomicLong getCount() {
            return MultiTab.access$getCount$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001(B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u001d8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u001d8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$TabItem;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ITabItem;", "()V", "bubble", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$Bubble;", "getBubble", "()Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$Bubble;", "setBubble", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$Bubble;)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "disablePreload", "", "getDisablePreload", "()I", "setDisablePreload", "(I)V", "schema", "getSchema", "setSchema", "showType", "getShowType", "setShowType", "tabId", "", "getTabId", "()J", "setTabId", "(J)V", "tabName", "getTabName", "setTabName", "tabType", "getTabType", "setTabType", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabItem extends FlexModelBase<ITabItem> implements ITabItem, h {
        public static final Companion Companion = null;
        public static final int TAB_SHOW_DEFAULT = 0;
        public static final int TAB_SHOW_ONLY_HORIZONTAL = 2;
        public static final int TAB_SHOW_ONLY_VERTICAL = 1;
        public static final long TAB_TYPE_CHAT = 2;
        public static final long TAB_TYPE_HYBRID = 3;
        public static final long TAB_TYPE_INTERACT = 1;

        @SerializedName("bubble")
        protected Bubble bubble;

        @SerializedName("color")
        protected String color;

        @SerializedName("disable_preload")
        protected int disablePreload;

        @SerializedName("jump_link")
        protected String schema;

        @SerializedName("tab_show_type")
        protected int showType;

        @SerializedName("tab_id")
        protected long tabId;

        @SerializedName(a.KEY_TAB_NAME)
        protected String tabName;

        @SerializedName("tab_type")
        protected long tabType;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/MultiTab$TabItem$Companion;", "", "()V", "TAB_SHOW_DEFAULT", "", "TAB_SHOW_ONLY_HORIZONTAL", "TAB_SHOW_ONLY_VERTICAL", "TAB_TYPE_CHAT", "", "TAB_TYPE_HYBRID", "TAB_TYPE_INTERACT", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public TabItem() {
            super(ITabItem.class);
            this.color = "";
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public /* bridge */ /* synthetic */ IBubble getBubble() {
            return getBubble();
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public String getColor() {
            return this.color;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public int getDisablePreload() {
            return this.disablePreload;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public String getSchema() {
            return this.schema;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public int getShowType() {
            return this.showType;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public long getTabId() {
            return this.tabId;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public String getTabName() {
            return this.tabName;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public long getTabType() {
            return this.tabType;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ITabItem
        public Bubble getBubble() {
            return this.bubble;
        }

        public TabItem(g r100) {
            super(ITabItem.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L16;
            g.a r103 = decodeExtensionFields(r102, r100);
            switch(r102) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L7;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            this.color = am3.h.c(r100);
            goto L3
        L9:
            this.disablePreload = r100.i();
            goto L3
        L10:
            this.bubble = new Bubble(r100);
            goto L3
        L11:
            this.showType = r100.i();
            goto L3
        L12:
            this.tabId = r100.j();
            goto L3
        L13:
            this.schema = am3.h.c(r100);
            goto L3
        L14:
            this.tabName = am3.h.c(r100);
            goto L3
        L15:
            this.tabType = r100.j();
            goto L3
        L7:
            am3.h.d(r103, r100);
            goto L3
        L16:
            r100.d(r101);
            setThreadSafe(true);
            if (this.color != null) goto L40;
            this.color = "";
            return;
        }

        public void setBubble(Bubble r100) {
            this.bubble = r100;
        }

        public void setColor(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.color = r100;
        }

        public void setDisablePreload(int r100) {
            this.disablePreload = r100;
        }

        public void setSchema(String r100) {
            this.schema = r100;
        }

        public void setShowType(int r100) {
            this.showType = r100;
        }

        public void setTabId(long r100) {
            this.tabId = r100;
        }

        public void setTabName(String r100) {
            this.tabName = r100;
        }

        public void setTabType(long r100) {
            this.tabType = r100;
        }
    }

    public final List<TabItem> getValidTabs() {
        return (List) this.validTabs$delegate.getValue();
    }

    static {
        Companion = new Companion(null);
        count = new AtomicLong(100);
    }

    public MultiTab() {
        super(IMultiTab.class);
        this.validTabs$delegate = LazyKt.lazy(new MultiTab$validTabs$2(this));
    }

    public static final /* synthetic */ AtomicLong access$getCount$cp() {
        return count;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMultiTab
    public int getDisableBackground() {
        return this.disableBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMultiTab
    public String getTabTitleColor() {
        return this.tabTitleColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMultiTab
    public List<TabItem> getTabs() {
        return this.tabs;
    }

    public MultiTab(g r100) {
        super(IMultiTab.class);
        this.tabs = new ArrayList();
        this.validTabs$delegate = LazyKt.lazy(new MultiTab$validTabs$2(this));
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.tabTitleColor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.tabs.add(new TabItem(r100));
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this.disableBackground = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setDisableBackground(int r100) {
        this.disableBackground = r100;
    }

    public void setTabTitleColor(String r100) {
        this.tabTitleColor = r100;
    }

    public void setTabs(List<TabItem> r100) {
        this.tabs = r100;
    }
}
