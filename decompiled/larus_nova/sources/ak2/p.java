package ak2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements com.bytedance.android.livesdk.livecommerce.room.api.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f3995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3996b;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.h
    public final MutableLiveData<Boolean> getPlaying() {
        return this.f3995a;
    }

    public p(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "eventHub");
        this.f3996b = r100;
        if ((r100 instanceof td.e) == false) goto L6;
        MutableLiveData<Boolean> r101 = ((td.e) r100).getPlaying();
    L9:
        this.f3995a = r101;
        if ((r100 instanceof td.e) == false) goto L13;
        ((td.e) r100).getVideoSizeChanged();
    L17:
        if ((r100 instanceof td.e) == false) goto L20;
        ((td.e) r100).getFirstFrame();
    L24:
        if ((r100 instanceof td.e) == false) goto L27;
        ((td.e) r100).getPlayerMute();
    L31:
        if ((r100 instanceof td.e) == false) goto L34;
        ((td.e) r100).getPlayPrepared();
    L38:
        if ((r100 instanceof td.e) == false) goto L41;
        ((td.e) r100).getPlayerMediaError();
        return;
    L41:
        if ((r100 instanceof IRoomEventHub) == false) goto L43;
        ((IRoomEventHub) r100).getPlayerMediaError();
        return;
    L43:
        new MutableLiveData();
        return;
    L34:
        if ((r100 instanceof IRoomEventHub) == false) goto L36;
        ((IRoomEventHub) r100).getPlayPrepared();
        goto L38
    L36:
        new MutableLiveData();
        goto L38
    L27:
        if ((r100 instanceof IRoomEventHub) == false) goto L29;
        ((IRoomEventHub) r100).getPlayerMute();
        goto L31
    L29:
        new MutableLiveData();
        goto L31
    L20:
        if ((r100 instanceof IRoomEventHub) == false) goto L22;
        ((IRoomEventHub) r100).getFirstFrame();
        goto L24
    L22:
        new MutableLiveData();
        goto L24
    L13:
        if ((r100 instanceof IRoomEventHub) == false) goto L15;
        ((IRoomEventHub) r100).getVideoSizeChanged();
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
