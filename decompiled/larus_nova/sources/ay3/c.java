package ay3;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;
import com.ss.ttm.player.MediaPlayer;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f16745b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<XToast> f16746a;

    public final void a() {
        if (this.f16746a.isEmpty() == false) goto L5;
        return;
    L5:
        XToast r100 = (XToast) ((LinkedList) this.f16746a).peek();
        View r101 = r100.f193806c;
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        Message r103 = Message.obtain();
        r103.what = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT;
        r103.obj = r100;
        sendMessage(r103);
        return;
    L14:
        return;
    L8:
        if (r101.getParent() == null) goto L10;
        r102 = true;
        goto L11
    }

    public c(Looper r100) {
        super(r100);
        this.f16746a = new LinkedList();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        XToast r101 = (XToast) r100.obj;
        int r102 = r100.what;
        boolean r103 = true;
        if (r102 == 291) goto L21;
        if (r102 != 1110) goto L6;
        View r104 = r101.f193806c;
        if (r104 != null) goto L12;
    L14:
        r103 = false;
    L15:
        if (r103 == true) goto L18;
        ((LinkedList) this.f16746a).remove(r101);
        return;
    L18:
        if (((LinkedList) this.f16746a).contains(r101) == false) goto L35;
        AnimatorSet r105 = r101.f193809f;
        r105.addListener(new b(this, r101));
        r105.start();
        ((LinkedList) this.f16746a).poll();
        return;
    L35:
        return;
    L12:
        if (r104.getParent() == null) goto L14;
    L6:
        if (r102 != 1929) goto L34;
        a();
        return;
    L34:
        return;
    L21:
        View r106 = r101.f193806c;
        if (r106 != null) goto L24;
    L26:
        r103 = false;
    L27:
        if (r103 == true) goto L36;
        r101.f193805b.addView(r101.f193806c);
        r101.f193808e.start();
        Message r107 = Message.obtain();
        r107.what = 1110;
        r107.obj = r101;
        sendMessageDelayed(r107, r101.f193811h);
        return;
    L36:
        return;
    L24:
        if (r106.getParent() == null) goto L26;
        goto L26
    }
}
