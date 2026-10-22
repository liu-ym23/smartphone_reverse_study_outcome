package com.bytedance.android.livesdk.chatroom.bl;

import ag1.g;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.e;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.message.model.n3;
import com.bytedance.android.livesdk.message.model.p4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import zg1.k;

/* JADX INFO: loaded from: classes7.dex */
public final enum PlatformMessageHelper extends Enum<PlatformMessageHelper> {
    public static final PlatformMessageHelper INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f105237a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f105238b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PlatformMessageHelper[] f105239c = null;
    private k bigGiftPlayStateEvent;
    private Map<String, b> followGuideBarriers;
    private Runnable followGuideRunnable;
    private List<c> mMessageCallbackList;
    private Handler mainHandler;
    private boolean sIsBusy;
    private boolean sIsRunning;
    private Queue<BaseMessage> sMessageQueue;

    public class a implements Observer<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlatformMessageHelper f105240a;

        public a(PlatformMessageHelper r100) {
            this.f105240a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L6;
            PlatformMessageHelper.access$000(this.f105240a);
            return;
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        void AS(BaseMessage r100);
    }

    public void onMessageFinish() {
        this.sIsBusy = false;
        d();
    }

    static {
        PlatformMessageHelper r100 = new PlatformMessageHelper();
        INSTANCE = r100;
        f105239c = new PlatformMessageHelper[]{r100};
        f105237a = 2000;
        f105238b = 500;
    }

    public PlatformMessageHelper() {
        super("INSTANCE", 0);
        this.mMessageCallbackList = new ArrayList();
        this.sIsBusy = false;
        this.sIsRunning = false;
        this.followGuideBarriers = new HashMap();
    }

    public static PlatformMessageHelper[] values() {
        return (PlatformMessageHelper[]) f105239c.clone();
    }

    public final void d() {
        Queue<BaseMessage> r100 = this.sMessageQueue;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() >= 1) goto L7;
        return;
    L7:
        if (this.mMessageCallbackList.size() != 0) goto L9;
        return;
    L9:
        if (this.sIsRunning == false) goto L37;
        BaseMessage r101 = this.sMessageQueue.poll();
        if ((r101 instanceof n3) == true) goto L14;
    L16:
        boolean r102 = false;
    L18:
        if (this.sIsBusy == true) goto L21;
        e.b().getClass();
        if ((!e.c()) == false) goto L21;
    L23:
        this.sIsBusy = true;
        Iterator<c> r103 = this.mMessageCallbackList.iterator();
    L25:
        if (r103.hasNext() == false) goto L38;
        c r104 = r103.next();
        if (r104 == null) goto L25;
        r104.AS(r101);
        goto L25
    L38:
        return;
    L21:
        if (r102 == true) goto L23;
        return;
    L14:
        if (((n3) r101).Q() == false) goto L16;
        r102 = true;
        goto L18
    }

    public void stop() {
        this.mMessageCallbackList.clear();
        this.sMessageQueue = null;
        this.sIsRunning = false;
        this.sIsBusy = false;
        Handler r100 = this.mainHandler;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.mainHandler = null;
        this.followGuideRunnable = null;
    }

    public static /* synthetic */ boolean a(PlatformMessageHelper r100) {
        k r101 = r100.bigGiftPlayStateEvent;
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.f571865a == true) goto L8;
        return false;
    }

    public static void access$000(PlatformMessageHelper r100) {
        r100.onMessageFinish();
    }

    public static boolean c(Room r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = r100.mo8271getOwner().getFollowInfo().getFollowStatus();
        if (r101 != 1) goto L8;
    L9:
        return true;
    L8:
        if (r101 == 2) goto L9;
        return false;
    }

    public static PlatformMessageHelper valueOf(String r100) {
        return (PlatformMessageHelper) r27.a.a(PlatformMessageHelper.class, r100);
    }

    public void add(BaseMessage r100) {
        if (this.sIsRunning == false) goto L10;
        if (r100 == null) goto L11;
        Queue<BaseMessage> r101 = this.sMessageQueue;
        if (r101 == null) goto L12;
        r101.offer(r100);
        d();
        return;
    L12:
        return;
    L11:
        return;
    }

    public void addMessageCallback(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mMessageCallbackList.contains(r100) == true) goto L8;
        this.mMessageCallbackList.add(r100);
        return;
    }

    public void start(c r100) {
        this.mMessageCallbackList.add(r100);
        this.sMessageQueue = new ArrayDeque();
        this.sIsRunning = true;
        this.sIsBusy = false;
        f.d().f123392a.observeForever(new a(this));
    }

    public void addFollowGuideMessage(final Room r100, final BaseMessage r101) {
        if ((r101 instanceof p4) == true) goto L6;
        return;
    L6:
        if (c(r100) == false) goto L12;
        Handler r102 = this.mainHandler;
        if (r102 == null) goto L10;
        r102.removeCallbacksAndMessages(null);
    L10:
        this.followGuideRunnable = null;
        onMessageFinish();
        return;
    L12:
        final p4 r103 = (p4) r101;
        if (this.sIsRunning == true) goto L15;
        return;
    L15:
        if (this.sMessageQueue != null) goto L18;
        return;
    L18:
        if (this.mainHandler != null) goto L21;
        this.mainHandler = new Handler(Looper.getMainLooper());
    L21:
        if (this.followGuideRunnable != null) goto L23;
        this.followGuideRunnable = new ag1.e(this, r100, r103);
    L23:
        Iterator<b> r104 = this.followGuideBarriers.values().iterator();
    L25:
        if (r104.hasNext() == false) goto L31;
        b r105 = r104.next();
        if (r105 == null) goto L25;
        if (r105.a() == true) goto L25;
        boolean r106 = false;
    L32:
        if (r106 == true) goto L35;
        this.mainHandler.postDelayed(new ag1.f(this, r100, r101), f105237a);
        return;
    L35:
        this.mainHandler.postDelayed(this.followGuideRunnable, f105238b);
        return;
    L31:
        r106 = true;
        goto L32
    }

    public void setFollowGuideBarrier(String r100, b r101) {
        this.followGuideBarriers.put(r100, r101);
    }

    public static /* synthetic */ void b(PlatformMessageHelper r100, Room r101, p4 r102) {
        r100.getClass();
        if (c(r101) == true) goto L5;
        r100.add(r102);
    L5:
        r100.followGuideRunnable = null;
    }

    public void setBigGiftPlayStateEvent(boolean r100, boolean r101, EffectMessage r102) {
        if (this.bigGiftPlayStateEvent != null) goto L5;
        this.bigGiftPlayStateEvent = new k(r101);
    L5:
        this.bigGiftPlayStateEvent.getClass();
        this.bigGiftPlayStateEvent.f571865a = r101;
        setFollowGuideBarrier("BigGiftPlay", new g(this));
    }
}
