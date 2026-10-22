package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;

/* JADX INFO: loaded from: classes28.dex */
public class y4 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f28425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f28426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f28427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f28428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f28429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OfflineMapManager f28430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OfflineMapCity f28431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f28432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f28433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DownloadProgressView f28434k;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y4 f28435a;

        public a(y4 r100) {
            this.f28435a = r100;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            super.handleMessage(r100);
            int r101 = r100.arg1;
            int r102 = r100.arg2;
            y4.a(this.f28435a, r101, r102);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    private void a() {
        this.f28429f.setVisibility(0);
        this.f28428e.setVisibility(8);
        this.f28429f.setTextColor(-65536);
        this.f28429f.setText(p0.a(2131034193));
    }

    private void b() {
        this.f28429f.setVisibility(0);
        this.f28428e.setVisibility(8);
        this.f28429f.setTextColor(FakePickerAvatarCreator.GRAY);
        this.f28429f.setText(p0.a(2131034142));
    }

    private void c() {
        if (this.f28424a != 1) goto L5;
        this.f28428e.setVisibility(8);
        this.f28429f.setVisibility(0);
        this.f28429f.setText(p0.a(2131034140));
        this.f28429f.setTextColor(ColorProtector.parseColor("#4287ff"));
        return;
    L5:
        this.f28429f.setVisibility(0);
        this.f28428e.setVisibility(8);
        this.f28429f.setTextColor(ColorProtector.parseColor("#4287ff"));
        this.f28429f.setText(p0.a(2131034140));
    }

    private void e() {
        View r100 = b5.a(this.f28425b, R.array.audio2text_option_array, null);
        this.f28433j = r100;
        this.f28434k = (DownloadProgressView) r100.findViewById(2147479571);
        TextView r101 = (TextView) this.f28433j.findViewById(2147479566);
        this.f28426c = r101;
        r101.setText(p0.a(2131034188));
        TextView r102 = (TextView) this.f28433j.findViewById(2147479570);
        this.f28427d = r102;
        r102.setText(p0.a(2131034189));
        this.f28428e = (ImageView) this.f28433j.findViewById(2147479569);
        this.f28429f = (TextView) this.f28433j.findViewById(2147479568);
        this.f28428e.setOnClickListener(this);
    }

    public View d() {
        return this.f28433j;
    }

    public void a(OfflineMapCity r100) {
        if (r100 == null) goto L11;
        this.f28431h = r100;
        this.f28426c.setText(r100.getCity());
        double r101 = ((double) ((int) (((r100.getSize() / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;
        if (r101 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        this.f28427d.setText(String.valueOf(r101) + " M");
        int r102 = this.f28431h.getState();
        int r103 = this.f28431h.getcompleteCode();
        OfflineMapCity r104 = this.f28431h;
        if (r104 == null) goto L8;
        r104.setState(r102);
        this.f28431h.setCompleteCode(r103);
    L8:
        Message r105 = new Message();
        r105.arg1 = r102;
        r105.arg2 = r103;
        this.f28432i.sendMessage(r105);
        return;
    L9:
        this.f28427d.setVisibility(8);
        this.f28428e.setVisibility(8);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        boolean r101 = false;
        if (w3.d(this.f28425b) == true) goto L6;
        Toast.makeText(this.f28425b, p0.a(2131034401), 0).show();     // Catch: Exception -> L34
        return;
    L6:
        OfflineMapCity r102 = this.f28431h;     // Catch: Exception -> L34
        if (r102 == null) goto L43;
        int r103 = r102.getState();     // Catch: Exception -> L34
        this.f28431h.getcompleteCode();     // Catch: Exception -> L34
        if (r103 != 0) goto L11;
        monitor-enter(this);     // Catch: Exception -> L34
        this.f28430g.pause();     // Catch: Throwable -> L31
        this.f28430g.restart();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Exception -> L34
        b();     // Catch: Exception -> L34
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L11:
        if (r103 != 1) goto L13;
        return;
    L13:
        if (r103 == 4) goto L45;
        monitor-enter(this);     // Catch: Exception -> L34
        this.f28430g.downloadByCityName(this.f28431h.getCity());     // Catch: Throwable -> L17 AMapException -> L19
        r101 = true;
    L21:
        monitor-exit(this);     // Catch: Exception -> L34
        if (r101 == false) goto L24;
        c();     // Catch: Exception -> L34
        return;
    L24:
        a();     // Catch: Exception -> L34
        return;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        Toast.makeText(this.f28425b, e.getErrorMessage(), 0).show();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L45:
        return;
    L43:
        return;
    L34:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(int r100) {
        this.f28424a = r100;
    }

    public y4(Context r100, OfflineMapManager r101) {
        this.f28424a = 0;
        this.f28432i = new a(this);
        this.f28425b = r100;
        e();
        this.f28430g = r101;
    }

    public static void a(y4 r100, int r101, int r102) throws Exception {
        if (r100.f28424a != 2) goto L8;
        if (r102 <= 3) goto L8;
        if (r102 >= 100) goto L8;
        r100.f28434k.setVisibility(0);
        r100.f28434k.setProgress(r102);
    L10:
        if (r101 != 6) goto L12;
        r100.f28429f.setVisibility(8);
        r100.f28428e.setVisibility(0);
        r100.f28428e.setImageResource(R.animator.aos_profile_ic_back_bg_anim);
        return;
    L12:
        if (r101 != 7) goto L14;
        r100.f28429f.setVisibility(0);
        r100.f28428e.setVisibility(0);
        r100.f28428e.setImageResource(R.animator.aos_profile_ic_back_bg_anim);
        r100.f28429f.setText(p0.a(2131034192));
        return;
    L14:
        if (r101 != (-1)) goto L16;
        r100.a();
        return;
    L16:
        if (r101 == 0) goto L34;
        if (r101 == 1) goto L30;
        if (r101 == 2) goto L28;
        if (r101 != 3) goto L22;
        r100.b();
        return;
    L22:
        if (r101 == 4) goto L26;
        switch(r101) {
            case 101: goto L25;
            case 102: goto L25;
            case 103: goto L25;
            default: goto L53;
        };
    L25:
        r100.a();
        return;
    L53:
        return;
    L26:
        r100.f28429f.setVisibility(0);
        r100.f28428e.setVisibility(8);
        r100.f28429f.setText(p0.a(2131034143));
        r100.f28429f.setTextColor(ColorProtector.parseColor("#898989"));
        return;
    L28:
        r100.c();
        return;
    L30:
        if (r100.f28424a == 1) goto L54;
        r100.f28429f.setVisibility(0);
        r100.f28428e.setVisibility(8);
        r100.f28429f.setText(p0.a(2131034187));
        r100.f28429f.setTextColor(ColorProtector.parseColor("#898989"));
        return;
    L54:
        return;
    L34:
        if (r100.f28424a != 1) goto L37;
        r100.f28428e.setVisibility(8);
        r100.f28429f.setText(p0.a(2131034141));
        r100.f28429f.setTextColor(ColorProtector.parseColor("#4287ff"));
        return;
    L37:
        if (r100.f28431h == null) goto L55;
        r100.f28429f.setVisibility(0);
        r100.f28429f.setText(p0.a(2131034141));
        r100.f28428e.setVisibility(8);
        r100.f28429f.setTextColor(ColorProtector.parseColor("#4287ff"));
        return;
    L55:
        return;
    L8:
        r100.f28434k.setVisibility(8);
        goto L10
    }
}
