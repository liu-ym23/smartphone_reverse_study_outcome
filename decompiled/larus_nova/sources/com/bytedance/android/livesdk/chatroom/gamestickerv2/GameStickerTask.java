package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessageKt;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerRecord;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerUpdateListener;
import com.bytedance.android.livesdkapi.gamestickerv2.config.AlignMode;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class GameStickerTask implements IGameStickerTask, Handler.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f106271m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f106272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f106273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f106274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f106275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f106276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile t f106277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f106278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<IGameStickerUpdateListener> f106279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GameStickerInfo f106280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f106281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GameStickerScene f106282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f106283l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameStickerTask f106284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GameStickerInfo f106285b;

        public b(GameStickerTask r100, GameStickerInfo r101) {
            this.f106284a = r100;
            this.f106285b = r101;
        }

        public final void a() {
            GameStickerInfo r100 = this.f106284a.f106280i;
            if (r100 == null) goto L13;
            if (r100 == null) goto L6;
            GameStickerOpr r101 = r100.getStickerOpr();
        L8:
            if (r101 == GameStickerOpr.DESTROY) goto L13;
            GameStickerInfo r102 = this.f106284a.f106280i;
            if (r102 != null) goto L12;
        L14:
            GameStickerTask r103 = this.f106284a;
            r103.f106281j = !r103.f106279h.isEmpty();
            Iterator<T> r104 = this.f106284a.f106279h.iterator();
        L16:
            if (r104.hasNext() == false) goto L18;
            ((IGameStickerUpdateListener) r104.next()).onStickerUpdate(this.f106285b);
            goto L16
        L18:
            return;
        L12:
            if (r102.getStickerType() != this.f106285b.getStickerType()) goto L14;
        L6:
            r101 = null;
        L13:
            this.f106284a.f106280i = this.f106285b;
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final int referenceCount() {
        return ((ArrayList) this.f106279h).size();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void release() {
        ((ArrayList) this.f106279h).clear();
        Disposable r100 = this.f106272a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        ((Handler) this.f106274c.getValue()).removeCallbacksAndMessages(null);
        ((HandlerThread) this.f106273b.getValue()).quit();
        this.f106278g.f106345a.clear();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final String getTaskRoomId() {
        return this.f106283l;
    }

    public GameStickerTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f106283l = r100;
        this.f106273b = LazyKt.lazy(new GameStickerTask$workThread$2(this));
        this.f106274c = LazyKt.lazy(new GameStickerTask$workHandler$2(this));
        this.f106275d = LazyKt.lazy(GameStickerTask$uiHandler$2.INSTANCE);
        this.f106276e = "";
        this.f106278g = new e(r100);
        this.f106279h = new ArrayList();
        this.f106282k = GameStickerScene.UNKNOWN;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void addStickerInfoUpdateListener(IGameStickerUpdateListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f106279h).add(r100);
        t r101 = this.f106277f;
        if (r101 == null) goto L5;
        r100.onSeiSceneUpdate(r101.f106371b, r101.f106372c);
    L5:
        GameStickerInfo r102 = this.f106280i;
        if (r102 == null) goto L9;
        r100.onStickerUpdate(r102);
        return;
    }

    public final void b(GameStickerInfo r100) {
        Lazy r101 = GameStickerSetting.f106265a;
        AlignMode r102 = GameStickerSetting.a(r100);
        int r103 = g.f106347a[r102.ordinal()];
        if (r103 == 1) goto L9;
        if (r103 != 2) goto L21;
        c(r100);
        return;
    L21:
        return;
    L9:
        if (r100.getStickerOpr() != GameStickerOpr.DESTROY) goto L11;
        this.f106278g.f106345a.clear();
        c(r100);
        return;
    L11:
        e r104 = this.f106278g;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "info");
        PriorityQueue<GameStickerInfo> r105 = r104.f106345a.get(Integer.valueOf(r100.getStickerType()));
        if (r105 != null) goto L14;
        r105 = new PriorityQueue(10, d.f106344a);
        r104.f106345a.put(Integer.valueOf(r100.getStickerType()), r105);
    L14:
        r105.add(r100);
        if (this.f106281j == true) goto L22;
        c(r100);
        return;
    }

    public final void c(GameStickerInfo r100) {
        ((Handler) this.f106275d.getValue()).post(new b(this, r100));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "p0");
        int r100 = r110.what;
        if (r100 != 1) goto L5;
        int r111 = com.bytedance.android.livesdk.chatroom.gamestickerv2.a.f106286a;
        String r112 = this.f106276e;
        Intrinsics.checkNotNullParameter(r112, "sei");
        ArrayList r101 = new ArrayList();
        LinkedHashSet r102 = new LinkedHashSet();
        LinkedHashSet r103 = new LinkedHashSet();
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L31
        JSONObject r113 = LiveSeiUtil.c(r112);     // Catch: Exception -> L31
        int r104 = com.bytedance.android.livesdk.chatroom.gamestickerv2.a.a(r113);     // Catch: Exception -> L31
        r102.add(Integer.valueOf(r104));     // Catch: Exception -> L31
        r103.addAll(com.bytedance.android.livesdk.chatroom.gamestickerv2.a.b(r113));     // Catch: Exception -> L31
        JSONObject r114 = r113.optJSONObject("game_sticker");     // Catch: Exception -> L31
        if (r114 == null) goto L29;
        JSONArray r115 = r114.optJSONArray("data");     // Catch: Exception -> L31
        if (r115 == null) goto L29;
        int r105 = r115.length();     // Catch: Exception -> L31
        int r106 = 0;
    L23:
        if (r106 >= r105) goto L29;
        JSONObject r107 = r115.optJSONObject(r106);     // Catch: Exception -> L31
        String r116 = r107.optString("type", "");     // Catch: Exception -> L31
        String r108 = r107.optString("record_id", "");     // Catch: Exception -> L31
        Integer r117 = StringsKt.toIntOrNull(r116);     // Catch: Exception -> L31
        Long r109 = StringsKt.toLongOrNull(r108);     // Catch: Exception -> L31
        if (r117 == null) goto L28;
        if (r109 == null) goto L28;
        r101.add(new GameStickerRecord(r104, r117.intValue(), r109.longValue()));     // Catch: Exception -> L31
    L28:
        r106 = r106 + 1;     // Catch: Exception -> L31
    L29:
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L31
    L32:
        this.f106277f = new t(r101, r102, r103);
        t r119 = this.f106277f;
        if (r119 == null) goto L64;
        Set<Integer> r120 = r119.f106371b;
        Set<String> r121 = r119.f106372c;
        ((Handler) this.f106275d.getValue()).post(new h(this, r120, r121));
        e r122 = this.f106278g;
        List<GameStickerRecord> r123 = r119.f106370a;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r123, "recordIds");
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r123.iterator();
    L36:
        if (r125.hasNext() == false) goto L60;
        GameStickerRecord r126 = (GameStickerRecord) r125.next();
        int r127 = r126.getType();
        long r128 = r126.getId();
        PriorityQueue<GameStickerInfo> r129 = r122.f106345a.get(Integer.valueOf(r127));
        Object r130 = null;
        if (r129 == null) goto L58;
        Iterator<T> r131 = r129.iterator();
    L42:
        if (r131.hasNext() == false) goto L49;
        Object r132 = r131.next();
        if (r128 != ((GameStickerInfo) r132).getStickerRecordId()) goto L46;
        boolean r133 = true;
    L47:
        if (r133 == false) goto L42;
        r130 = r132;
        goto L49
    L46:
        r133 = false;
    L49:
        r130 = (GameStickerInfo) r130;
        if (r130 == null) goto L58;
    L52:
        if (r129.isEmpty() == false) goto L58;
        GameStickerInfo r134 = r129.peek();
        if (r134 == null) goto L58;
        if (r134.getStickerRecordId() >= r128) goto L58;
        r129.poll();
    L58:
        if (r130 == null) goto L36;
        r124.add(r130);
        goto L36
    L60:
        Iterator r135 = r124.iterator();
    L62:
        if (r135.hasNext() == false) goto L64;
        c((GameStickerInfo) r135.next());
    L64:
        return true;
    L5:
        if (r100 != 2) goto L7;
    L9:
        Object r136 = r110.obj;
        if ((r136 instanceof GameStickerInfo) == false) goto L64;
        if (r136 == null) goto L14;
        b((GameStickerInfo) r136);
        goto L64
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo");
    L7:
        if (r100 == 3) goto L9;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void init(Set<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "stickerTypes");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.iterator();     // Catch: Exception -> L13
    L8:
        if (r102.hasNext() == false) goto L11;
        int r103 = ((Number) r102.next()).intValue();     // Catch: Exception -> L13
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L13
        r104.put("sticker_type", r103);     // Catch: Exception -> L13
        r104.put("record_id", "");     // Catch: Exception -> L13
        r101.put(r104);     // Catch: Exception -> L13
    L11:
        String r105 = r101.toString();
        this.f106272a = ((GameRoomStickerApi) com.bytedance.android.live.network.c.b().e(GameRoomStickerApi.class)).getGameRoomSticker(this.f106283l, r105, this.f106282k.ordinal()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.f106352a);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void onMessage(GameRoomStickerOprMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        GameStickerInfo r101 = GameRoomStickerOprMessageKt.toGameStickerInfo(r100);
        Lazy r102 = GameStickerSetting.f106265a;
        if (GameStickerSetting.a(r101) != AlignMode.IM) goto L6;
        b(r101);
        return;
    L6:
        Message r103 = Message.obtain();
        r103.what = 2;
        r103.obj = r101;
        ((Handler) this.f106274c.getValue()).sendMessage(r103);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.f(r100, false) == true) goto L5;
        return;
    L5:
        this.f106276e = r100;
        ((Handler) this.f106274c.getValue()).sendEmptyMessage(1);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void removeStickerInfoUpdateListener(IGameStickerUpdateListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f106279h).remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask
    public final void setScene(GameStickerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f106282k = r100;
    }

    public static final void a(GameStickerTask r100, GameStickerInfo r101) {
        r100.getClass();
        Lazy r102 = GameStickerSetting.f106265a;
        if (GameStickerSetting.a(r101) != AlignMode.IM) goto L5;
        r100.b(r101);
        return;
    L5:
        Message r103 = Message.obtain();
        r103.what = 3;
        r103.obj = r101;
        ((Handler) r100.f106274c.getValue()).sendMessage(r103);
    }
}
