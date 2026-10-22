package ak2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements com.bytedance.android.livesdk.livecommerce.room.api.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f3993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3994b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.f
    public final MutableLiveData<Boolean> getPlaying() {
        return this.f3993a;
    }

    public o(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        this.f3994b = r100;
        if ((r100 instanceof td.e) == false) goto L6;
        MutableLiveData<Boolean> r101 = ((td.e) r100).getPlaying();
    L9:
        this.f3993a = r101;
        if ((r100 instanceof td.e) == false) goto L13;
        ((td.e) r100).getStopped();
    L17:
        if ((r100 instanceof td.e) == false) goto L20;
        ((td.e) r100).getReleased();
    L24:
        if ((r100 instanceof td.e) == false) goto L27;
        ((td.e) r100).getVideoSizeChanged();
    L31:
        if ((r100 instanceof td.e) == false) goto L34;
        ((td.e) r100).getFirstFrame();
    L38:
        if ((r100 instanceof td.e) == false) goto L41;
        ((td.e) r100).getSeiUpdate();
    L45:
        if ((r100 instanceof td.e) == false) goto L48;
        ((td.e) r100).getPlayComplete();
    L52:
        if ((r100 instanceof td.e) == false) goto L55;
        ((td.e) r100).getPlayResume();
    L59:
        if ((r100 instanceof td.e) == false) goto L62;
        ((td.e) r100).getPlayerMute();
    L66:
        if ((r100 instanceof td.e) == false) goto L69;
        ((td.e) r100).getPlayPrepared();
    L73:
        if ((r100 instanceof td.e) == false) goto L76;
        ((td.e) r100).getPlayerMediaError();
    L80:
        if ((r100 instanceof td.e) == false) goto L83;
        ((td.e) r100).isSeiCropping();
    L87:
        if ((r100 instanceof td.e) == false) goto L90;
        ((td.e) r100).getLiveEnd();
    L94:
        if ((r100 instanceof td.e) == false) goto L97;
        ((td.e) r100).getReset();
    L101:
        if ((r100 instanceof td.e) == false) goto L104;
        ((td.e) r100).getPlayerBlur();
        return;
    L104:
        if ((r100 instanceof IRoomEventHub) == false) goto L106;
        ((IRoomEventHub) r100).getPlayerBlur();
        return;
    L106:
        new MutableLiveData();
        return;
    L97:
        if ((r100 instanceof IRoomEventHub) == false) goto L99;
        ((IRoomEventHub) r100).getReset();
        goto L101
    L99:
        new MutableLiveData();
        goto L101
    L90:
        if ((r100 instanceof IRoomEventHub) == false) goto L92;
        ((IRoomEventHub) r100).getLiveEnd();
        goto L94
    L92:
        new MutableLiveData();
        goto L94
    L83:
        if ((r100 instanceof IRoomEventHub) == false) goto L85;
        ((IRoomEventHub) r100).isSeiCropping();
        goto L87
    L85:
        new MutableLiveData();
        goto L87
    L76:
        if ((r100 instanceof IRoomEventHub) == false) goto L78;
        ((IRoomEventHub) r100).getPlayerMediaError();
        goto L80
    L78:
        new MutableLiveData();
        goto L80
    L69:
        if ((r100 instanceof IRoomEventHub) == false) goto L71;
        ((IRoomEventHub) r100).getPlayPrepared();
        goto L73
    L71:
        new MutableLiveData();
        goto L73
    L62:
        if ((r100 instanceof IRoomEventHub) == false) goto L64;
        ((IRoomEventHub) r100).getPlayerMute();
        goto L66
    L64:
        new MutableLiveData();
        goto L66
    L55:
        if ((r100 instanceof IRoomEventHub) == false) goto L57;
        ((IRoomEventHub) r100).getPlayResume();
        goto L59
    L57:
        new MutableLiveData();
        goto L59
    L48:
        if ((r100 instanceof IRoomEventHub) == false) goto L50;
        ((IRoomEventHub) r100).getPlayComplete();
        goto L52
    L50:
        new MutableLiveData();
        goto L52
    L41:
        if ((r100 instanceof IRoomEventHub) == false) goto L43;
        ((IRoomEventHub) r100).getSeiUpdate();
        goto L45
    L43:
        new MutableLiveData();
        goto L45
    L34:
        if ((r100 instanceof IRoomEventHub) == false) goto L36;
        ((IRoomEventHub) r100).getFirstFrame();
        goto L38
    L36:
        new MutableLiveData();
        goto L38
    L27:
        if ((r100 instanceof IRoomEventHub) == false) goto L29;
        ((IRoomEventHub) r100).getVideoSizeChanged();
        goto L31
    L29:
        new MutableLiveData();
        goto L31
    L20:
        if ((r100 instanceof IRoomEventHub) == false) goto L22;
        ((IRoomEventHub) r100).getReleased();
        goto L24
    L22:
        new MutableLiveData();
        goto L24
    L13:
        if ((r100 instanceof IRoomEventHub) == false) goto L15;
        ((IRoomEventHub) r100).getStopped();
        goto L17
    L15:
        new MutableLiveData();
        goto L17
    L6:
        if ((r100 instanceof IRoomEventHub) == false) goto L8;
        r101 = ((IRoomEventHub) r100).getPlaying();
        goto L9
    L8:
        r101 = new MutableLiveData();
        goto L9
    }
}
