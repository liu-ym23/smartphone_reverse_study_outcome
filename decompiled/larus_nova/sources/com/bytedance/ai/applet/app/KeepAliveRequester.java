package com.bytedance.ai.applet.app;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/app/KeepAliveRequester;", "", "<init>", "(Ljava/lang/String;I)V", "AUDIO_PLAYER", MediaScene.NAVIGATION, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeepAliveRequester extends Enum<KeepAliveRequester> {
    public static final KeepAliveRequester AUDIO_PLAYER = null;
    public static final KeepAliveRequester NAVIGATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeepAliveRequester[] f34138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34139b = null;

    public static EnumEntries<KeepAliveRequester> getEntries() {
        return f34139b;
    }

    static {
        KeepAliveRequester r100 = new KeepAliveRequester("AUDIO_PLAYER", 0);
        AUDIO_PLAYER = r100;
        KeepAliveRequester r101 = new KeepAliveRequester(MediaScene.NAVIGATION, 1);
        NAVIGATION = r101;
        KeepAliveRequester[] r102 = {r100, r101};
        f34138a = r102;
        f34139b = EnumEntriesKt.enumEntries(r102);
    }

    public static KeepAliveRequester[] values() {
        return (KeepAliveRequester[]) f34138a.clone();
    }

    public static KeepAliveRequester valueOf(String r100) {
        return (KeepAliveRequester) r27.a.a(KeepAliveRequester.class, r100);
    }

    public KeepAliveRequester(String r100, int r101) {
        super(r100, r101);
    }
}
