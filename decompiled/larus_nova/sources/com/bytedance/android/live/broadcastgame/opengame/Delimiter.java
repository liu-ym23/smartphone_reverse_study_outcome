package com.bytedance.android.live.broadcastgame.opengame;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/Delimiter;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "COMMA", "SPACE", "BACKSLASH", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Delimiter extends Enum<Delimiter> {
    public static final Delimiter BACKSLASH = null;
    public static final Delimiter COMMA = null;
    public static final Delimiter SPACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Delimiter[] f59697a = null;
    private final String value;

    static {
        Delimiter r100 = new Delimiter("COMMA", 0, ",");
        COMMA = r100;
        Delimiter r101 = new Delimiter("SPACE", 1, " ");
        SPACE = r101;
        Delimiter r102 = new Delimiter("BACKSLASH", 2, HTTP.URL_DEFAULT);
        BACKSLASH = r102;
        f59697a = new Delimiter[]{r100, r101, r102};
    }

    public static Delimiter valueOf(String r100) {
        return (Delimiter) r27.a.a(Delimiter.class, r100);
    }

    public static Delimiter[] values() {
        return (Delimiter[]) f59697a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Delimiter(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
