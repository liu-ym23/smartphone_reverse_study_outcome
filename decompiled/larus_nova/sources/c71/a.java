package c71;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$Event;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22634a = null;

    static {
        int[] r100 = new int[ICardLifecycle$Event.values().length];
        f22634a = r100;
        r100[ICardLifecycle$Event.OnCreate.ordinal()] = 1;
        r100[ICardLifecycle$Event.OnStore.ordinal()] = 2;
        r100[ICardLifecycle$Event.OnStart.ordinal()] = 3;
        r100[ICardLifecycle$Event.OnShow.ordinal()] = 4;
        r100[ICardLifecycle$Event.OnHide.ordinal()] = 5;
        r100[ICardLifecycle$Event.OnDestroy.ordinal()] = 6;
    }
}
