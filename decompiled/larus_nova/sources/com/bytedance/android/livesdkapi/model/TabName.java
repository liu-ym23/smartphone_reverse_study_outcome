package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/TabName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ORDERED_SONG", "ORDER_SONG", "MY_SONG", "WANT_LISTEN", "AUDIENCE_SING", "EFFECT_MUSIC", "UNKNOWN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TabName extends Enum<TabName> {
    private static final /* synthetic */ TabName[] $VALUES = null;
    public static final TabName AUDIENCE_SING = null;
    public static final TabName EFFECT_MUSIC = null;
    public static final TabName MY_SONG = null;
    public static final TabName ORDERED_SONG = null;
    public static final TabName ORDER_SONG = null;
    public static final TabName UNKNOWN = null;
    public static final TabName WANT_LISTEN = null;
    private final String value;

    static {
        TabName r100 = new TabName("ORDERED_SONG", 0, "ordered_song");
        ORDERED_SONG = r100;
        TabName r101 = new TabName("ORDER_SONG", 1, "order_song");
        ORDER_SONG = r101;
        TabName r102 = new TabName("MY_SONG", 2, "my_song");
        MY_SONG = r102;
        TabName r103 = new TabName("WANT_LISTEN", 3, "want_listen");
        WANT_LISTEN = r103;
        TabName r104 = new TabName("AUDIENCE_SING", 4, "audience_sing");
        AUDIENCE_SING = r104;
        TabName r105 = new TabName("EFFECT_MUSIC", 5, "effect_music");
        EFFECT_MUSIC = r105;
        TabName r106 = new TabName("UNKNOWN", 6, "");
        UNKNOWN = r106;
        $VALUES = new TabName[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static TabName valueOf(String r100) {
        return (TabName) a.a(TabName.class, r100);
    }

    public static TabName[] values() {
        return (TabName[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private TabName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
