package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/ToolbarReasonTag;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", EffectConstants.NORMAL, "MUTEX_ERROR", "TOOLBAR_MANAGER_ERROR", "CONFIG_ERROR", "COMPONENT", "VIEW_CONTAINER", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ToolbarReasonTag extends Enum<ToolbarReasonTag> {
    public static final ToolbarReasonTag COMPONENT = null;
    public static final ToolbarReasonTag CONFIG_ERROR = null;
    public static final ToolbarReasonTag MUTEX_ERROR = null;
    public static final ToolbarReasonTag NORMAL = null;
    public static final ToolbarReasonTag TOOLBAR_MANAGER_ERROR = null;
    public static final ToolbarReasonTag VIEW_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarReasonTag[] f115960a = null;
    private final String tag;

    static {
        ToolbarReasonTag r100 = new ToolbarReasonTag(EffectConstants.NORMAL, 0, "NormalProcess");
        NORMAL = r100;
        ToolbarReasonTag r101 = new ToolbarReasonTag("MUTEX_ERROR", 1, "MutexError");
        MUTEX_ERROR = r101;
        ToolbarReasonTag r102 = new ToolbarReasonTag("TOOLBAR_MANAGER_ERROR", 2, "ToolbarManagerError");
        TOOLBAR_MANAGER_ERROR = r102;
        ToolbarReasonTag r103 = new ToolbarReasonTag("CONFIG_ERROR", 3, "ConfigError");
        CONFIG_ERROR = r103;
        ToolbarReasonTag r104 = new ToolbarReasonTag("COMPONENT", 4, "ComponentInnerError");
        COMPONENT = r104;
        ToolbarReasonTag r105 = new ToolbarReasonTag("VIEW_CONTAINER", 5, "ViewContainerError");
        VIEW_CONTAINER = r105;
        f115960a = new ToolbarReasonTag[]{r100, r101, r102, r103, r104, r105};
    }

    public static ToolbarReasonTag valueOf(String r100) {
        return (ToolbarReasonTag) r27.a.a(ToolbarReasonTag.class, r100);
    }

    public static ToolbarReasonTag[] values() {
        return (ToolbarReasonTag[]) f115960a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public ToolbarReasonTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
