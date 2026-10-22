package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Receiver;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Scene;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Sender;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f19287b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f19288c = null;

    static {
        int[] r100 = new int[IconFilterFactory$Sender.values().length];
        f19286a = r100;
        r100[IconFilterFactory$Sender.ANCHOR.ordinal()] = 1;
        r100[IconFilterFactory$Sender.ADMIN.ordinal()] = 2;
        int[] r101 = new int[IconFilterFactory$Scene.values().length];
        f19287b = r101;
        r101[IconFilterFactory$Scene.ROOM.ordinal()] = 1;
        r101[IconFilterFactory$Scene.CROSS_ROOM.ordinal()] = 2;
        r101[IconFilterFactory$Scene.KTV.ordinal()] = 3;
        int[] r102 = new int[IconFilterFactory$Receiver.values().length];
        f19288c = r102;
        r102[IconFilterFactory$Receiver.NORMAL.ordinal()] = 1;
        r102[IconFilterFactory$Receiver.ANONYMOUS.ordinal()] = 2;
        r102[IconFilterFactory$Receiver.MYSTERY.ordinal()] = 3;
        r102[IconFilterFactory$Receiver.ANCHOR.ordinal()] = 4;
        r102[IconFilterFactory$Receiver.AI_GUEST.ordinal()] = 5;
    }
}
