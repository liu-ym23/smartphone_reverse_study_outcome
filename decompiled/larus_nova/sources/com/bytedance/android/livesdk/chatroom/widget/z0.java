package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PointF;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.ui.u7;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class z0 extends Dialog implements View.OnClickListener, SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, WeakHandler.IHandler {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f119266u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f119267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f119268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f119269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SurfaceView f119270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f119271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f119272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f119273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f119274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f119275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.record.x f119276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f119277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f119278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHandler f119279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u7 f119280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f119281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f119282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f119283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Room f119284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f119285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f119286t;

    public class a implements o60.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0 f119287a;

        @Override // o60.e
        public final void onPermissionDenied(String... r100) {
        }

        public a(z0 r100) {
            this.f119287a = r100;
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r100) {
            this.f119287a.c();
        }
    }

    public interface b {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
    }

    static {
        f119266u = z0.class.getSimpleName();
    }

    public final void c() {
        if (this.f119277k == false) goto L5;
        return;
    L5:
        if (this.f119278l == false) goto L8;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_save_success, 0);
        return;
    L8:
        this.f119277k = true;
        f(true);
        new com.bytedance.android.livesdk.chatroom.record.a0(this.f119279m, 0).execute1(new String[]{this.f119275i});
    }

    public final void d() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        c();
        return;
    L6:
        Activity r100 = ContextUtil.contextToActivity(com.bytedance.android.live.core.utils.s1.getContext());
        SettingKey<Boolean> r101 = m60.i.f512260a;
        new m60.i.b(r100).b(new a(this), null, TokenCert.with("bpea-live_record_LiveRecordShareDialog"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f119268b = true;
        if (this.f119274h != 0) goto L5;
        this.f119269c.setImageURI(Uri.fromFile(new PolarisFileWrapper(this.f119275i)));
        return;
    L5:
        this.f119270d.getHolder().addCallback(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f119279m.removeCallbacksAndMessages(null);
        this.f119268b = false;
        u7 r100 = this.f119280n;
        if (r100 == null) goto L8;
        if (r100.isShowing() == false) goto L8;
        a(this.f119280n);
    L8:
        if (1 != this.f119274h) goto L13;
        com.bytedance.android.livesdk.chatroom.record.x r101 = this.f119276j;
        if (r101 == null) goto L13;
        r101.stop();
        this.f119276j.release();
    L13:
        if (this.f119282p == true) goto L15;
    L17:
        this.f119285s.clear();
        return;
    L15:
        if (jc1.k.f(IRoomService.class) == null) goto L17;
        com.bytedance.android.live.room.q r102 = ((IRoomService) jc1.k.f(IRoomService.class)).roomInteractService();
        long r103 = this.f119284r.getId();
        int r104 = this.f119283q;
        String r105 = this.f119284r.getLabels();
        ((com.bytedance.android.livesdk.module.d) r102).a(null, r103, r104, 3, r105);
        goto L17
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public final View b(int r100) {
        View r101 = getLayoutInflater().inflate(R.layout.ttlive_view_record_share_item, null);
        r101.setTag(Integer.valueOf(r100));
        r101.setOnClickListener(this);
        ImageView r102 = (ImageView) r101.findViewById(R.id.image);
        TextView r103 = (TextView) r101.findViewById(R.id.text);
        switch(r100) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        int r104 = -1;
        int r105 = -1;
    L12:
        if (r104 == (-1)) goto L14;
        r102.setImageResource(r104);
    L14:
        if (r105 == (-1)) goto L16;
        r103.setText(r105);
    L16:
        return r101;
    L5:
        r104 = R.drawable.ttlive_ic_live_record_publish;
        r105 = R.string.ttlive_live_record_share_publish;
        goto L12
    L6:
        r104 = R.drawable.ttlive_ic_live_record_save;
        r105 = R.string.ttlive_live_record_share_save;
        goto L12
    L7:
        r104 = R.drawable.ttlive_icon_share_qzone_new;
        r105 = R.string.ttlive_live_record_share_qzone;
        goto L12
    L8:
        r104 = R.drawable.ttlive_icon_share_weibo_new;
        r105 = R.string.ttlive_weibo;
        goto L12
    L9:
        r104 = R.drawable.ttlive_icon_share_qq_new;
        r105 = R.string.ttlive_live_record_share_qq;
        goto L12
    L10:
        r104 = R.drawable.ttlive_icon_share_weixin_circle_new;
        r105 = R.string.ttlive_live_record_share_moments;
        goto L12
    L11:
        r104 = R.drawable.ttlive_icon_share_weixin_new;
        r105 = R.string.ttlive_live_record_share_wechat;
        goto L12
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L9;
        u7 r101 = this.f119280n;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isShowing() == false) goto L32;
        a(this.f119280n);
        return;
    L32:
        return;
    L9:
        u7 r102 = this.f119280n;
        if (r102 != null) goto L18;
        u7 r103 = new u7(ContextUtil.contextToActivity(getContext()));
        r103.f114246b = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_record_saving);
        r103.setCancelable(false);
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r103);
    L16:
        this.f119280n = r103;
        return;
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L15:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L16
    L18:
        if (r102.isShowing() == true) goto L34;
        u7 r104 = this.f119280n;
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L23:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        int r101 = r100.what;
        if (r101 == 0) goto L10;
        if (r101 != 2) goto L24;
        Object r102 = r100.obj;
        if ((r102 instanceof String) == false) goto L9;
        this.f119281o = (String) r102;
        return;
    L9:
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_create_thumbnail_failed, 0);
        return;
    L24:
        return;
    L10:
        this.f119277k = false;
        f(false);
        Object r103 = r100.obj;
        if ((r103 instanceof File) == false) goto L15;
        File r104 = (File) r103;
        this.f119275i = r104.getAbsolutePath();
        Context r105 = com.bytedance.android.live.core.utils.s1.getContext();
        MediaScannerConnection.scanFile(r105, new String[]{r104.getAbsolutePath()}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension("3gp"), MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4")}, new w0(r105));
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_save_success, 0);
        this.f119278l = true;
        b r106 = this.f119286t;
        if (r106 == null) goto L21;
        ((LiveRecordWidget.e) r106).b();
        return;
    L21:
        return;
    L15:
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_save_failed, 0);
        b r107 = this.f119286t;
        if (r107 == null) goto L23;
        ((LiveRecordWidget.e) r107).a(r100.obj);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (R.id.close != r100.getId()) goto L22;
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
    L25:
        if ((r100.getTag() instanceof Integer) == true) goto L27;
        return;
    L27:
        int r102 = ((Integer) r100.getTag()).intValue();
        switch(r102) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L31;
            default: goto L62;
        };
    L39:
        d();
        return;
    L40:
        e(r102, "qzone");
        return;
    L45:
        e(r102, "qq");
        return;
    L46:
        e(r102, "weixin_moment");
        return;
    L47:
        e(r102, "weixin");
        return;
    L62:
        return;
    L31:
        if (this.f119277k == true) goto L52;
        com.bytedance.android.livesdk.chatroom.record.x r103 = this.f119276j;
        if (r103 == null) goto L53;
        int r104 = r103.getDuration();
        if (r104 > 0) goto L37;
    L38:
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_more_than_15s, 0);
        return;
    L37:
        if (r104 > 15000) goto L38;
        return;
    L53:
        return;
    L52:
        return;
    L42:
        if (((ILiveShareService) jc1.k.f(ILiveShareService.class)).isShareAvailable(this.f119267a, "weibo") == true) goto L44;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_weibo_client_not_available, 0);
        return;
    L44:
        e(r102, "weibo");
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r105 == null) goto L18;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(this));
        goto L25
    L22:
        if (R.id.anchor_action_container != r100.getId()) goto L25;
        d();
        goto L25
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer r100) {
        if (this.f119268b == true) goto L5;
        return;
    L5:
        r100.start();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = findViewById(R.id.close);
        this.f119269c = (HSImageView) findViewById(R.id.image);
        this.f119270d = (SurfaceView) findViewById(R.id.video);
        this.f119271e = findViewById(R.id.anchor_action_container);
        this.f119272f = findViewById(R.id.audience_action_container);
        this.f119269c.getHierarchy().setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        boolean r102 = false;
        if (this.f119274h != 0) goto L5;
        this.f119269c.setVisibility(0);
        this.f119270d.setVisibility(8);
    L6:
        r101.setOnClickListener(this);
        if (this.f119273g == false) goto L10;
        this.f119272f.setVisibility(8);
        this.f119271e.setVisibility(0);
        this.f119271e.setOnClickListener(this);
        return;
    L10:
        if (1 != this.f119274h) goto L12;
        this.f119271e.setVisibility(0);
        this.f119272f.setVisibility(8);
        this.f119271e.setOnClickListener(this);
        return;
    L12:
        this.f119272f.setVisibility(0);
        this.f119271e.setVisibility(8);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.action_container);
        Context r104 = getContext();
        if (r104 != null) goto L15;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L23;
        r103.addView(b(1));
        r103.addView(b(2));
    L23:
        Context r106 = getContext();
        if (r106 != null) goto L26;
    L31:
        if (r102 == false) goto L33;
        r103.addView(b(3));
    L33:
        r103.addView(b(4));
        return;
    L26:
        if (TextUtils.isEmpty("com.tencent.mobileqq") == true) goto L31;
        r106.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);     // Catch: Exception -> L35
        r102 = true;
        goto L31
    L15:
        if (TextUtils.isEmpty("com.tencent.mm") == true) goto L20;
        r104.getPackageManager().getPackageInfo("com.tencent.mm", 0);     // Catch: Exception -> L36
        r105 = true;
        goto L21
    L5:
        this.f119269c.setVisibility(8);
        this.f119270d.setVisibility(0);
        this.f119270d.getHolder().addCallback(this);
        goto L6
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer r100) {
        if (this.f119268b == true) goto L5;
        return;
    L5:
        r100.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        com.bytedance.android.livesdk.chatroom.record.x r101 = this.f119276j;
        if (r101 == null) goto L6;
        r101.stop();
        return;
    }

    public final void e(int r100, String r101) {
        i81.a.C6239a r102 = new i81.a.C6239a();
        int r103 = this.f119274h;
        String r104 = f119266u;
        if (r103 != 0) goto L13;
        ILiveShareService r105 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        r102.f488564d = ShareParams.builder().setPlatform(r101).setLocalFilePath(this.f119275i).build();
        r102.f488562b = this.f119267a;
        Single<i81.b> r106 = r105.share(r102.a(), r104, LiveShareType.SHARE_THIRD, null);
        if (r106 == null) goto L7;
        r106.observeOn(AndroidSchedulers.mainThread()).subscribe(new x0(this));
    L7:
        JSONObject r107 = new JSONObject();
        r107.put("request_id", this.f119284r.getRequestId());     // Catch: JSONException -> L10
        r107.put("log_pb", this.f119284r.getLog_pb());     // Catch: JSONException -> L10
        r107.put("source", this.f119284r.getUserFrom());     // Catch: JSONException -> L10
        getContext();
        this.f119284r.getId();
        this.f119284r.getId();
        return;
    L10:
        e = move-exception;
        Logger.e(r104, e.toString());
        return;
    L13:
        if (TextUtils.isEmpty(this.f119281o) == false) goto L17;
        new com.bytedance.android.livesdk.chatroom.record.a(this.f119279m).execute1(new String[]{this.f119275i});
        return;
    L17:
        if (TextUtils.isEmpty(null) == false) goto L19;
        return;
    L19:
        ILiveShareService r108 = (ILiveShareService) jc1.k.f(ILiveShareService.class);
        r102.f488564d = ShareParams.builder().setPlatform(r101).setLocalFilePath(this.f119281o).build();
        r102.f488562b = this.f119267a;
        Single<i81.b> r109 = r108.share(r102.a(), r104, LiveShareType.SHARE_THIRD, null);
        if (r109 == null) goto L27;
        r109.observeOn(AndroidSchedulers.mainThread()).subscribe(new y0(this, r100));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer r100, int r101, int r102) {
        ALogger.e(f119266u, "MediaPlayer onError, what = " + r101 + " extra = " + r102 + " ,fileExist=" + FileUtils.checkFileExists(this.f119275i));
        r100.release();
        this.f119276j = null;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_video_play_failed, 0);
        return false;
    }

    public z0(Activity r100, Room r101, boolean r102, String r103) {
        super(r100, R.style.ttlive_live_record_share_dialog);
        this.f119285s = new CompositeDisposable();
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams((int) UIUtils.dip2Px(r100, 306.0f), (int) UIUtils.dip2Px(r100, 541.0f));
        setContentView(LayoutInflater.from(r100).inflate(R.layout.ttlive_dialog_live_record_share, null), r104);
        setCancelable(false);
        if (TextUtils.isEmpty(r103) == true) goto L7;
        this.f119284r = r101;
        this.f119273g = r102;
        this.f119274h = 1;
        this.f119275i = r103;
        this.f119279m = new WeakHandler(this);
        this.f119267a = r100;
        return;
    L7:
        throw new RuntimeException("File path is empty");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        if (this.f119274h == 1) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.record.x r104 = this.f119276j;
        if (r104 == null) goto L8;
        r104.reset();
    L9:
        this.f119276j.setSurface(r100.getSurface());
        this.f119276j.setIntOption(36, 1);     // Catch: IOException -> L12
        this.f119276j.setOnCompletionListener(this);     // Catch: IOException -> L12
        this.f119276j.setOnPreparedListener(this);     // Catch: IOException -> L12
        this.f119276j.setOnErrorListener(this);     // Catch: IOException -> L12
        this.f119276j.setDataSource(this.f119275i);     // Catch: IOException -> L12
        this.f119276j.setVolume(0.0f, 0.0f);     // Catch: IOException -> L12
        this.f119276j.prepareAsync();     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        this.f119276j = null;
        String r105 = f119266u;
        Logger.e(r105, e.toString());
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_live_record_video_play_failed, 0);
        ALogger.e(r105, "surfaceChanged-exception", e);
        return;
    L8:
        this.f119276j = com.bytedance.android.livesdk.chatroom.record.x.b(getContext());
        goto L9
    }
}
