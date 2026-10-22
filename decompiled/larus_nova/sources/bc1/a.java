package bc1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.uikit.toast.CustomToast;
import com.ss.ttm.player.MediaPlayer;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f18560d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<CustomToast> f18561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18563c;

    /* JADX INFO: renamed from: bc1.a$a, reason: collision with other inner class name */
    public class C0289a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomToast f18564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f18565b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f18564a.setDismissing(false);
            this.f18564a.dismiss();
            a r101 = this.f18565b;
            r101.f18562b = false;
            r101.removeMessages(1110);
            this.f18565b.sendEmptyMessage(1929);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f18564a.setDismissing(true);
        }

        public C0289a(a r100, CustomToast r101) {
            this.f18565b = r100;
            this.f18564a = r101;
        }
    }

    public static synchronized a b() {
        monitor-enter(a.class);
        a r100 = f18560d;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        monitor-exit(a.class);
        return r100;
    L8:
        a r101 = new a(Looper.getMainLooper());     // Catch: Throwable -> L11
        f18560d = r101;     // Catch: Throwable -> L11
        monitor-exit(a.class);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f18561a.isEmpty() == false) goto L5;
        return;
    L5:
        CustomToast r100 = (CustomToast) ((LinkedList) this.f18561a).peek();
        if (r100.isToastRelease() == false) goto L10;
        r100.dismiss();
        ((LinkedList) this.f18561a).poll();
        d();
        return;
    L10:
        if (r100.isShowing() == true) goto L13;
        Message r101 = Message.obtain();
        r101.what = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT;
        r101.obj = r100;
        sendMessage(r101);
        return;
    }

    public a(Looper r100) {
        super(r100);
        this.f18562b = false;
        this.f18563c = 5;
        this.f18561a = new LinkedList();
    }

    public final void a(CustomToast r100) {
        if (((LinkedList) this.f18561a).contains(r100) == false) goto L5;
        return;
    L5:
        if (((LinkedList) this.f18561a).size() > this.f18563c) goto L13;
        ((LinkedList) this.f18561a).offer(r100);
        if (this.f18562b == true) goto L12;
        d();
        return;
    L12:
        return;
    }

    public final void c(CustomToast r100) {
        if (r100.isShowing() == true) goto L5;
    L13:
        r100.dismiss();
        this.f18562b = false;
        ((LinkedList) this.f18561a).remove(r100);
        sendEmptyMessage(1929);
        return;
    L5:
        if (r100.isToastRelease() == true) goto L13;
        if (((LinkedList) this.f18561a).contains(r100) == true) goto L11;
        this.f18562b = false;
        removeMessages(1110);
        sendEmptyMessage(1929);
        return;
    L11:
        AnimatorSet r101 = r100.getHideAnimatorSet();
        r101.addListener(new C0289a(this, r100));
        r101.start();
        ((LinkedList) this.f18561a).poll();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        CustomToast r101 = (CustomToast) r100.obj;
        int r102 = r100.what;
        if (r102 == 291) goto L11;
        if (r102 != 1110) goto L6;
        c(r101);
        return;
    L6:
        if (r102 != 1929) goto L17;
        d();
        return;
    L17:
        return;
    L11:
        if (r101.isShowing() == true) goto L18;
        r101.show();
        this.f18562b = true;
        r101.getShowAnimatorSet().start();
        Message r103 = Message.obtain();
        r103.what = 1110;
        r103.obj = r101;
        sendMessageDelayed(r103, r101.getDuration());
        return;
    }
}
