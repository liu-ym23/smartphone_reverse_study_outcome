package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/Panel;", "", "MORE", LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Panel extends Enum<Panel> {
    public static final Panel BEAUTY = null;
    public static final Panel MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Panel[] f115692a = null;

    static {
        Panel r100 = new Panel("MORE", 0);
        MORE = r100;
        Panel r101 = new Panel(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, 1);
        BEAUTY = r101;
        f115692a = new Panel[]{r100, r101};
    }

    public static Panel valueOf(String r100) {
        return (Panel) r27.a.a(Panel.class, r100);
    }

    public static Panel[] values() {
        return (Panel[]) f115692a.clone();
    }

    public Panel(String r100, int r101) {
        super(r100, r101);
    }
}
