package anc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.ss.ttm.player.MediaPlayer;
import com.ss.videoarch.liveplayer.log.LiveError;
import com.ss.videoarch.liveplayer.log.LiveLoggerService;
import com.ss.videoarch.liveplayer.log.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final SparseArray<String> f4573x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f4580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveLoggerService f4587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4590q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4593t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4594u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4595v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HandlerC0091a f4596w;

    /* JADX INFO: renamed from: anc.a$a, reason: collision with other inner class name */
    public class HandlerC0091a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f4597a;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            switch(r100.what) {
                case 10001: goto L9;
                case 10002: goto L8;
                case 10003: goto L8;
                case 10004: goto L7;
                case 10005: goto L6;
                case 10006: goto L5;
                default: goto L23;
            };
        L5:
            a.access$700(this.f4597a, 9, null);
            return;
        L6:
            a.access$700(this.f4597a, 7, null);
            return;
        L7:
            a.access$700(this.f4597a, 1, null);
            return;
        L8:
            a.access$700(this.f4597a, 2, null);
            return;
        L9:
            long r101 = System.currentTimeMillis();
            if ((r101 - a.access$000(this.f4597a)) >= a.access$100(this.f4597a)) goto L16;
            a.access$200(this.f4597a, LiveError.PLAYER_STALL);
            c.i("RetryProcessor", "stall timeout, trigger retry");
            if (a.access$300(this.f4597a) == true) goto L14;
            a.access$400(this.f4597a).onRetryResetPlayer(false);
        L15:
            a.access$600(this.f4597a).sendEmptyMessageDelayed(10001, a.access$500(this.f4597a));
            return;
        L14:
            LiveError r102 = new LiveError(LiveError.PLAYER_STALL, null, null);
            a.access$400(this.f4597a).onSwitchLine(r102);
            goto L15
        L16:
            HashMap r103 = new HashMap();
            r103.put("stallTime", Long.valueOf(r101 - a.access$000(this.f4597a)));
            LiveError r104 = new LiveError(LiveError.STALL_RETRY_TIMEOUT, "Stall retry timeout", r103);
            a.access$700(this.f4597a, -1, r104);
            return;
        }

        public HandlerC0091a(a r100, Looper r101) {
            this.f4597a = r100;
            super(r101);
        }
    }

    public interface b {
        void onRTCFallBack();

        void onReportOutToApplication(LiveError r100);

        void onResolutionDegrade(boolean r100);

        void onRetryNextPlayURL();

        void onRetryResetPlayer(boolean r100);

        void onStallStart();

        void onSwitchLine(LiveError r100);

        void onSwitchNetwork();

        void onToMuchRetry();
    }

    public void start() {
        this.f4586m = true;
    }

    public void stop() {
        this.f4586m = false;
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        SparseArray<String> r101 = new SparseArray();
        f4573x = r101;
        SparseArray r102 = new SparseArray();
        SparseArray r103 = new SparseArray();
        r100.put(LiveError.PLAYER_DATASOURCE, 3);
        r100.put(LiveError.LIVE_API_URL_INVALID, 3);
        r100.put(LiveError.STALL_RETRY_TIMEOUT, 3);
        r100.put(LiveError.NETWORK_IO_ERROR, 3);
        r100.put(LiveError.STREAM_DRYUP, 3);
        r100.put(LiveError.PLAY_DNS_ERROR, 3);
        r100.put(LiveError.AGAIN_ERROR, 3);
        r101.put(-499988, "media player: setting uri is null error");
        r101.put(-499987, "media player: setting uri is error");
        r101.put(MediaPlayer.MEDIA_PLAYER_URL_IS_NOT_MP4_ERROR, "media player: url is not mp4 error");
        r101.put(MediaPlayer.MEDIA_PLAYER_INVALID_INPUT_DATA_ERROR, "media player: invalid data error");
        r101.put(-499899, "media player: http bad request error");
        r101.put(-499898, "media player: http unauthorized error");
        r101.put(-499897, "media player: http forbidden error");
        r101.put(-499896, "media player: http not found error");
        r101.put(-499894, "media player: http other 4xx error");
        r101.put(-499893, "media player: http server error");
        r101.put(-499891, "media player: http content type invalid");
        r101.put(MediaPlayer.MEDIA_PLAYER_HTTP_REDIRECT_ERROR, "media info http redirect");
        r101.put(-499799, "media player: tcp failed to resolve hostname");
        r101.put(MediaPlayer.MEDIA_PLAYER_TCP_SEND_DATA_FAILED_ERROR, "media player: tcp send data failed");
        r101.put(MediaPlayer.MEDIA_PLAYER_TCP_RECEIVE_DATA_FAILED_ERROR, "media player: tcp receive data failed");
        r101.put(MediaPlayer.MEDIA_PLAYER_TCP_READ_NETWORK_TIMEOUT_ERROR, "media player: tcp read network timeout");
        r101.put(MediaPlayer.MEDIA_PLAYER_TCP_WRITE_NETWORK_TIMEOUT_ERROR, "media player: tcp write network timeout");
        r102.put(MediaPlayer.MEDIA_PLAYER_SETTING_IS_NULL_ERROR, "media player setting is null");
        r102.put(-499997, "media player start decoder error");
        r102.put(-499996, "media player open decoder error");
        r102.put(-499992, "media player open outlet error");
        r102.put(MediaPlayer.MEDIA_PLAYER_START_OUTPUTER_ERROR, "media player start outputer error");
        r102.put(-499990, "media player start outlet error");
        r102.put(MediaPlayer.MEDIA_PLAYER_OPEN_DEVICE_ERROR, "media player open device error");
        r102.put(1, "android media player unknown");
        r103.put(-1, "not retry, report to application");
        r103.put(1, "try next url from live info");
        r103.put(2, "reset player");
    }

    public int getRetryCount() {
        return this.f4580g.get();
    }

    public boolean isRtsPlay() {
        LiveLoggerService r100 = this.f4587n;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isRtcPlayAvailable();
    }

    public void reset() {
        this.f4580g.set(0);
        this.f4576c = 0;
        this.f4581h = 7;
        this.f4583j = false;
        this.f4584k = 0;
        this.f4585l = false;
        this.f4589p = false;
        this.f4590q = 2;
        this.f4594u = -1;
        this.f4596w.removeCallbacksAndMessages(null);
    }

    public void startResolutionDegrade() {
        if (this.f4588o != (-1)) goto L5;
        return;
    L5:
        if (this.f4596w.hasMessages(10005) == false) goto L7;
        this.f4596w.removeMessages(10005);
    L7:
        this.f4596w.sendEmptyMessageDelayed(10005, this.f4588o);
    }

    public void startSwitchingNetwork() {
        if (this.f4596w.hasMessages(10006) == false) goto L5;
        this.f4596w.removeMessages(10006);
    L5:
        this.f4596w.sendEmptyMessageDelayed(10006, -1);
    }

    public static /* synthetic */ long access$000(a r100) {
        return r100.f4576c;
    }

    public static /* synthetic */ long access$100(a r100) {
        return r100.f4575b;
    }

    public static /* synthetic */ boolean access$300(a r100) {
        return r100.f4593t;
    }

    public static /* synthetic */ b access$400(a r100) {
        return r100.f4574a;
    }

    public static /* synthetic */ long access$500(a r100) {
        return r100.f4577d;
    }

    public static /* synthetic */ Handler access$600(a r100) {
        return r100.f4596w;
    }

    private void upLoadErrorLog(LiveError r100) {
        int r101 = this.f4581h - 1;
        this.f4581h = r101;
        if (r101 < 0) goto L6;
        this.f4587n.onError(r100.code, r100.getInfoJSON());
        return;
    }

    private void uploadRetryLog(int r100) {
        boolean r101 = this.f4583j;
        if (r101 == false) goto L7;
        if (r101 == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.f4584k) >= 1000) goto L7;
        return;
    L7:
        this.f4587n.onFirstFrameFail(r100);
        this.f4587n.onRetry(r100);
        this.f4583j = true;
        this.f4584k = System.currentTimeMillis();
    }

    public int getRtmRetryCount(int r100) {
        LiveLoggerService r101 = this.f4587n;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getRtmRetryCount(r100);
    }

    public void setGiveUpRetryWhenAuthFail(boolean r100) {
        this.f4595v = r100;
    }

    public void setHost(String r100) {
        this.f4582i = r100;
    }

    public void setLineSwitchConfig(JSONObject r100) {
        boolean r101 = false;
        if (r100 != null) goto L7;
        this.f4593t = false;
        return;
    L7:
        if (r100.optInt("enable") != 1) goto L9;
        r101 = true;
    L9:
        this.f4593t = r101;
        if (r101 == false) goto L14;
        this.f4591r = r100.optInt("errorStartup");
        this.f4592s = r100.optInt("errorSteps");
        long r102 = r100.optInt("stallTimeThres");
        if (r102 <= 0) goto L14;
        this.f4577d = r102;
    L14:
        c.i("RetryProcessor", "enable switch line: " + this.f4593t + ", start up switch error count: " + this.f4591r + ", step switch error count: " + this.f4592s + ", stall time thres: " + this.f4577d);
    }

    public void setResolutionDegradeConfig(int r100) {
        this.f4588o = r100;
    }

    public void setRetryCountLimit(int r100) {
        this.f4579f = r100;
        c.i("RetryProcessor", "setRetryCountLimit retryCountLimit: " + r100);
    }

    public void setRetryTimeInterval(int r100) {
        this.f4578e = r100;
    }

    public void setStallRetryTimeInterval(long r100) {
        this.f4577d = r100;
    }

    public void setStallRetryTimeout(long r100) {
        this.f4575b = r100 * 1000;
        c.i("RetryProcessor", "setStallRetryTimeout mRetryTimeLimit: " + this.f4575b);
    }

    public static /* synthetic */ void access$200(a r100, int r101) {
        r100.uploadRetryLog(r101);
    }

    private void handleRetryForError(int r100, LiveError r101) {
        c.i("RetryProcessor", "handleRetryForError action=" + r100);
        long r102 = 0;
        switch(r100) {
            case -1: goto L27;
            case 0: goto L40;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L14;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L18;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L40;
        };
    L5:
        c.i("RetryProcessor", "ACTION_SWITCH_LINE");
        this.f4574a.onSwitchLine(r101);
        return;
    L6:
        c.i("RetryProcessor", "ACTION_SWITCH_NETWORK");
        this.f4574a.onSwitchNetwork();
        return;
    L7:
        c.i("RetryProcessor", "ACTION_RESOLUTION_DEGRADE");
        this.f4574a.onResolutionDegrade(this.f4589p);
        this.f4589p = true;
        return;
    L8:
        c.i("RetryProcessor", "ACTION_NEXT_URL later");
        if (this.f4596w.hasMessages(10004) == true) goto L32;
        c.i("RETRY", "start " + this.f4580g);
        HandlerC0091a r103 = this.f4596w;
        if (this.f4580g.get() <= 3) goto L13;
        r102 = this.f4578e;
    L13:
        r103.sendEmptyMessageDelayed(10004, r102);
        return;
    L32:
        return;
    L14:
        c.i("RetryProcessor", "ACTION_RTC_RESET_LATER start " + this.f4580g + ", max retry count " + this.f4587n.B7 + ",fallback threshold:" + this.f4587n.C7 + ", retry interval:" + this.f4587n.D7);
        HandlerC0091a r104 = this.f4596w;
        if (this.f4580g.get() <= 3) goto L17;
        r102 = this.f4578e;
    L17:
        r104.sendEmptyMessageDelayed(10003, r102);
        return;
    L18:
        c.i("RetryProcessor", "ACTION_RTC_FALLBACK");
        this.f4574a.onRTCFallBack();
        return;
    L19:
        c.i("RetryProcessor", "ACTION_RESET_LATER");
        if (this.f4596w.hasMessages(10002) == true) goto L36;
        c.i("RETRY", "start " + this.f4580g);
        HandlerC0091a r105 = this.f4596w;
        if (this.f4580g.get() <= 3) goto L24;
        r102 = this.f4578e;
    L24:
        r105.sendEmptyMessageDelayed(10002, r102);
        return;
    L36:
        return;
    L25:
        c.i("RetryProcessor", "ACTION_RESET_PLAYER");
        this.f4574a.onRetryResetPlayer(false);
        return;
    L26:
        c.i("RetryProcessor", "ACTION_NEXT_URL");
        this.f4574a.onRetryNextPlayURL();
        return;
    L27:
        c.d("RetryProcessor", "ACTION_REPORT_OUTSIDE");
        this.f4574a.onReportOutToApplication(r101);
        return;
    }

    public void onError(LiveError r110, boolean r111) {
        c.i("RetryProcessor", "onError error=" + r110);
        if (this.f4586m == true) goto L6;
        return;
    L6:
        if (this.f4585l == true) goto L8;
    L10:
        this.f4580g.incrementAndGet();
        c.i("RetryProcessor", "current retry count:" + this.f4580g.get());
        if (r110.code == (-100016)) goto L13;
        this.f4585l = true;
    L13:
        int r100 = this.f4580g.get();
        int r101 = this.f4590q;
        if (r100 <= r101) goto L16;
        this.f4590q = r101 + 2;
        this.f4574a.onToMuchRetry();
    L16:
        Map r102 = r110.info;
        c.d("RetryProcessor", "retry limit: " + this.f4579f);
        if (this.f4580g.get() <= this.f4579f) goto L19;
    L18:
        int r103 = -1;
    L52:
        c.i("RetryProcessor", "enable switch line: " + this.f4593t + ", retryAction: " + r103 + ", last line switch retry count: " + this.f4594u);
        if (this.f4593t == false) goto L70;
        if (r103 == 3) goto L57;
        if (r103 != 6) goto L70;
    L57:
        if (this.f4591r < 0) goto L70;
        if (this.f4580g.get() < this.f4591r) goto L70;
        if (this.f4594u != (-1)) goto L65;
        this.f4594u = this.f4580g.get();
    L63:
        r103 = 10;
        goto L70
    L65:
        if (this.f4592s <= 0) goto L70;
        if ((this.f4580g.get() - this.f4594u) < this.f4592s) goto L70;
        this.f4594u = this.f4580g.get();
    L70:
        if (this.f4580g.get() > 3) goto L72;
    L74:
        this.f4587n.setInErrorRecovering();
        if (this.f4580g.get() != 1) goto L77;
        this.f4587n.onStallStart(r110.code, r111);
        this.f4574a.onStallStart();
    L77:
        this.f4587n.f459214x7 = r110.code;
        handleRetryForError(r103, r110);
        upLoadErrorLog(r110);
        uploadRetryLog(r110.code);
        return;
    L72:
        if (this.f4582i == null) goto L74;
        ymc.b.getInstance().disableIpAddress(this.f4582i);
        goto L74
    L19:
        int r104 = r110.code;
        r103 = 4;
        if (r104 != (-100003)) goto L44;
        int r105 = 0;
        r105 = ((Integer) r102.get("internalCode")).intValue();     // Catch: NumberFormatException -> L24
        r110.code = r105;     // Catch: NumberFormatException -> L24
    L25:
        SparseArray<String> r106 = f4573x;
        if (r106.indexOfKey(r105) < 0) goto L28;
        r102.put("playErrorReason", r106.get(r105));
        int r107 = 6;
    L30:
        if (isRtsPlay() == false) goto L35;
        int r108 = getRtmRetryCount(r110.code);
        c.e("RetryProcessor RTM_PLAY", "cur retry count:" + this.f4580g.get() + " canRetryCount:" + r108);
        if (this.f4580g.get() <= r108) goto L34;
        c.e("RetryProcessor RTM_PLAY", "rtc play fallback !!!!! error code:" + r110.code);
    L37:
        if (this.f4595v == false) goto L52;
        int r109 = r110.code;
        if (r109 != (-825242872)) goto L41;
    L42:
        c.e("RetryProcessor", "http unauthorized, don't retry. " + r110.code);
        goto L18
    L41:
        if (r109 != (-499898)) goto L52;
    L34:
        c.w("RetryProcessor RTM_PLAY", "rtc retry later !!!!!");
        r103 = 5;
        goto L37
    L35:
        r103 = r107;
        goto L37
    L28:
        r107 = 3;
    L24:
        r102.put("retryError", "error while get player internal error code");
        goto L25
    L44:
        if (r104 == (-100009)) goto L46;
    L51:
        r103 = 3;
        goto L52
    L46:
        if (isRtsPlay() == false) goto L51;
        if (this.f4580g.get() <= getRtmRetryCount(r110.code)) goto L50;
        c.e("RetryProcessor", "rtmio play fallback !!!!! error code:" + r110.code);
        goto L52
    L50:
        c.w("RetryProcessor", "rtmio retry later !!!!!");
        r103 = 5;
        goto L52
    L8:
        if (r110.code != (-100016)) goto L10;
    }

    public void onStall(boolean r100, boolean r101) {
        c.i("RetryProcessor", "onStall " + r100);
        if (r100 == false) goto L10;
        this.f4576c = System.currentTimeMillis();
        if (r101 == false) goto L8;
        this.f4574a.onRetryResetPlayer(true);
        uploadRetryLog(LiveError.IO_BLOCKED);
    L8:
        if (this.f4596w.hasMessages(10001) == true) goto L12;
        this.f4596w.sendEmptyMessageDelayed(10001, this.f4577d);
        return;
    L12:
        return;
    L10:
        reset();
    }

    public static /* synthetic */ void access$700(a r100, int r101, LiveError r102) {
        r100.handleRetryForError(r101, r102);
    }

    public a(b r100, int r101, long r102, LiveLoggerService r103) {
        this.f4577d = 10000;
        this.f4578e = 5000;
        this.f4579f = 50;
        AtomicInteger r104 = new AtomicInteger(0);
        this.f4580g = r104;
        this.f4581h = 7;
        this.f4582i = null;
        this.f4583j = false;
        this.f4584k = 0;
        this.f4585l = false;
        this.f4586m = false;
        this.f4588o = -1;
        this.f4589p = false;
        this.f4590q = 2;
        this.f4591r = -1;
        this.f4592s = -1;
        this.f4593t = false;
        this.f4594u = -1;
        this.f4595v = false;
        this.f4596w = new HandlerC0091a(this, Looper.myLooper());
        this.f4574a = r100;
        this.f4575b = r101 * 1000;
        this.f4577d = r102;
        r104.set(0);
        this.f4587n = r103;
    }
}
