package bo2;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.performance.hprof.api.ILiveCrashApi;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements ad2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f19799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ff7.e f19800b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f19801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19803c;

        /* JADX INFO: renamed from: bo2.i$a$a, reason: collision with other inner class name */
        public static final class C0321a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f19804a;

            public C0321a(a r100) {
                this.f19804a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Response r101 = (Response) r100;
                this.f19804a.f19801a.f19800b.onSuccess();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f19805a;

            public b(a r100) {
                this.f19805a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                r101.printStackTrace();
                this.f19805a.f19801a.f19800b.onFail(r101.getMessage());
            }
        }

        public a(i r100, boolean r101, String r102) {
            this.f19801a = r100;
            this.f19802b = r101;
            this.f19803c = r102;
        }

        public final void a() {
        L48:
            th = move-exception;
            th.printStackTrace();
            this.f19801a.f19800b.onFail(th.getMessage());
            return;
        L4:
            if (this.f19802b == true) goto L6;
            this.f19801a.f19799a.getClass();     // Catch: Throwable -> L48
            this.f19801a.f19800b.onFail("uploadHprofToTTLive upload fail");     // Catch: Throwable -> L48
            return;
        L6:
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L48
            this.f19801a.f19799a.getClass();     // Catch: Throwable -> L48
            r100.put("update_version_code", String.valueOf(((IHostContext) jc1.k.n(IHostContext.class)).getUpdateVersionCode()));     // Catch: Throwable -> L48
            String r110 = r100.toString();     // Catch: Throwable -> L48
            RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Throwable -> L48
            String r102 = "";
            if (r101 == null) goto L45;
            m<Room> r103 = r101.getRoom();     // Catch: Throwable -> L48
            if (r103 == null) goto L45;
            Room r104 = r103.getValue();     // Catch: Throwable -> L48
            if (r104 == null) goto L45;
            long r105 = r104.getRoomId();     // Catch: Throwable -> L48
            Long r111 = StringsKt.toLongOrNull(r104.getAnchorId());     // Catch: Throwable -> L48
            if (r111 == null) goto L16;
            long r112 = r111.longValue();     // Catch: Throwable -> L48
        L17:
            h r113 = this.f19801a.f19799a;     // Catch: Throwable -> L48
            LiveMode r114 = r104.getStreamType();     // Catch: Throwable -> L48
            r113.getClass();     // Catch: Throwable -> L48
            if (r114 == null) goto L35;
            int r115 = f.f19793a[r114.ordinal()];     // Catch: Throwable -> L48
            if (r115 != 1) goto L23;
            r102 = "video_live";
            goto L35
        L23:
            if (r115 == 2) goto L33;
            if (r115 != 3) goto L26;
            r102 = PriorityModule.SCENE_THIRD_PARTY;
            goto L35
        L26:
            if (r115 != 4) goto L28;
            r102 = "voice_live";
            goto L35
        L28:
            if (r115 != 5) goto L35;
            r102 = "media";
            goto L35
        L33:
            r102 = "game";
        L35:
            long r116 = r104.getLiveRoomMode();     // Catch: Throwable -> L48
            h r106 = this.f19801a.f19799a;     // Catch: Throwable -> L48
            Application r107 = jc1.a.b();     // Catch: Throwable -> L48
            if (r106.f19797b != null) goto L38;
            r106.f19797b = r107.getSharedPreferences("live_hprofdumpper_sp", 0);     // Catch: Throwable -> L48
        L38:
            SharedPreferences r108 = r106.f19797b;     // Catch: Throwable -> L48
            if (r108 != null) goto L41;
            long r109 = System.currentTimeMillis();     // Catch: Throwable -> L48
        L42:
            com.bytedance.android.livesdk.service.h r117 = TTLiveSDKContext.getHostService();     // Catch: Throwable -> L48
            if (r117 == null) goto L46;
            ((com.bytedance.android.livesdk.service.f) r117).h();     // Catch: Throwable -> L48
        L46:
            ILiveCrashApi r118 = (ILiveCrashApi) com.bytedance.android.live.network.c.b().e(ILiveCrashApi.class);     // Catch: Throwable -> L48
            Long r119 = Long.valueOf(r116);     // Catch: Throwable -> L48
            Long r120 = Long.valueOf(r109);     // Catch: Throwable -> L48
            String r121 = this.f19803c;     // Catch: Throwable -> L48
            Boolean r122 = Boolean.FALSE;     // Catch: Throwable -> L48
            r118.uploadHprofInfo(1, r102, r119, r120, r121, r122, r122, Long.valueOf(r105), Long.valueOf(r112), -1L, r110).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0321a(this), new b(this));     // Catch: Throwable -> L48
            return;
        L41:
            r109 = r108.getLong("last_dump_time", 0);     // Catch: Throwable -> L48
            goto L42
        L16:
            r112 = -1;
        L45:
            r109 = -1;
            r105 = -1;
            r112 = -1;
            r116 = -1;
            goto L46
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

    public i(h r100, ff7.e r101) {
        this.f19799a = r100;
        this.f19800b = r101;
    }

    @Override // ad2.b
    public final void a(boolean r100, String r101) {
        TTExecutors.getNormalExecutor().submit(new a(this, r100, r101));
    }
}
