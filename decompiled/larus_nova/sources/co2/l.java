package co2;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.de1;
import com.bytedance.android.livesdk.config.wf0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f24611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f24612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f24613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f24614d;

    public l() {
    }

    public final boolean a(Map<String, String> r110, boolean r111, boolean r112) {
        de1 r100 = wf0.f121521a.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis();
        if (r111 == false) goto L8;
        long r102 = this.f24614d;
    L9:
        long r103 = r101 - r102;
        if (r100.b() != 0) goto L12;
    L14:
        String r104 = ((IUserService) jc1.k.f(IUserService.class)).user().b().getIdString();
        if (CollectionUtils.isEmpty(r100.c()) == false) goto L17;
    L19:
        if (r112 == true) goto L30;
        RoomContext r113 = (RoomContext) com.bytedance.live.datacontext.d.d(RoomContext.class);
        if (r113 == null) goto L28;
        Room r114 = r113.getRoom().getValue();
        if (r114 == null) goto L28;
        User r115 = (User) r114.getBaseOwner();
        if (r115 == null) goto L28;
        r104 = r115.getIdStr();
    L28:
        r104 = "0";
    L30:
        if (CollectionUtils.isEmpty(r100.a()) == false) goto L32;
    L34:
        boolean r116 = false;
    L35:
        if (r116 == false) goto L38;
        return true;
    L38:
        if (r111 == true) goto L81;
        HashMap r117 = (HashMap) r110;
        long r105 = d5.c((String) r117.get("pss_app_usage"));
        if (r100.f() == 0) goto L83;
        if (r105 <= r100.f()) goto L83;
    L77:
        return true;
    L83:
        double r106 = CastDoubleProtector.parseDouble((String) r117.get("cpu_rate"));     // Catch: Throwable -> L56
    L58:
        if (r106 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L65;
        double r107 = CastDoubleProtector.parseDouble((String) r117.get("cpu_speed"));     // Catch: Throwable -> L62
    L63:
        r106 = r107 / 8.0d;
    L62:
        r107 = 0.0d;
    L65:
        if (r100.d() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L79;
        if (r106 > r100.d()) goto L77;
    L79:
        float r118 = CastFloatProtector.parseFloat((String) r117.get(IPerformanceManager.GPU.gpu_usage));     // Catch: Throwable -> L72
    L74:
        if (r100.e() != 0.0f) goto L76;
        return false;
    L76:
        if (r118 > r100.e()) goto L77;
        return false;
    L72:
        r118 = 0.0f;
    L56:
        r106 = 0.0d;
        goto L58
    L81:
        float r119 = CastFloatProtector.parseFloat((String) ((HashMap) r110).get("avg_fps"));     // Catch: Throwable -> L42
    L44:
        if (r100.g() != 0.0f) goto L46;
        return false;
    L46:
        if (r119 < r100.g()) goto L77;
        return false;
    L42:
        r119 = 0.0f;
        goto L44
    L32:
        if (r100.a().contains(r104) == false) goto L34;
    L33:
        r116 = true;
        goto L35
    L17:
        if (r100.c().contains(r104) == false) goto L19;
    L12:
        if (r103 < (r100.b() * 1000)) goto L14;
        return true;
    L8:
        r102 = this.f24613c;
        goto L9
    }
}
