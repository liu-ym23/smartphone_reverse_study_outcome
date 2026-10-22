package com.bytedance.android.live.platformplayer.utils;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.u6;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jc1.k;
import xj1.r;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends PhoneStateListener implements IMiddlewareHostAction.LiveAudioModeChangedListener, as0.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TokenCert f85835f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f85836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f85837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f85838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioManager f85839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<as0.c.a> f85840e;

    static {
        f85835f = TokenCert.with("bpea-live_enter_page_check_telephony");
    }

    @Override // as0.c
    public final void a() {
        if (Build.VERSION.SDK_INT > 30) goto L5;
    L12:
        g80.g.c(this, 0, f85835f);
        return;
    L5:
        if (this.f85837b == null) goto L12;
        if (this.f85838c == false) goto L9;
        AudioManager r100 = this.f85839d;
    L10:
        if (r100 == null) goto L14;
        ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).removeAudioModeChangedListener(r100, this.f85837b);
        return;
    L14:
        return;
    L9:
        r100 = (AudioManager) this.f85836a.getSystemService("audio");
        goto L10
    }

    public final void b() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 30) goto L13;
        if (this.f85838c == true) goto L7;
        AudioManager r101 = (AudioManager) this.f85836a.getSystemService("audio");
    L11:
        this.f85837b = ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).addAudioModeChangedListener(r101, this);
        return;
    L7:
        if (this.f85839d != null) goto L9;
        this.f85839d = (AudioManager) this.f85836a.getSystemService("audio");
    L9:
        r101 = this.f85839d;
        goto L11
    L13:
        if (u6.f158616a.getValue().booleanValue() == true) goto L15;
    L39:
        boolean r102 = true;
    L40:
        if (r102 == false) goto L50;
        g80.g.c(this, 32, f85835f);
        return;
    L50:
        return;
    L15:
        if (r100 < 23) goto L38;
        if (r100 < 23) goto L36;
        Context r103 = this.f85836a;
        ArrayList r104 = new ArrayList();
        Object[] r110 = {"android.permission.READ_PHONE_STATE"};
        f06.b r111 = new f06.b("auto_cert_com_bytedance_android_live_platformplayer_utils_LivePhoneStateReceiver_android_content_Context_checkSelfPermission");
        g06.a r105 = ApiHookConfig.f245611b.get(102608);
        if (r105 == null) goto L21;
        f06.a[] r106 = r105.f479473i;
    L22:
        f06.a[] r112 = r106;
        int r113 = r112.length;
        int r114 = 0;
    L24:
        if (r114 >= r113) goto L31;
        f06.a r107 = r112[r114];
        int r115 = r114;
        int r210 = r113;
        f06.a[] r211 = r112;
        f06.d r108 = r107.preInvoke(102608, "android/content/Context", "checkSelfPermission", r103, r110, "int", r111);     // Catch: Exception -> L43
        if (r108.f474982a == true) goto L33;
        r104.add(r107);     // Catch: Exception -> L43
    L33:
        if (r108.f474982a == false) goto L35;
        int r109 = ((Integer) r108.f474983b).intValue();
    L37:
        if (r109 == 0) goto L39;
    L35:
        r109 = r103.checkSelfPermission("android.permission.READ_PHONE_STATE");
    L30:
        r114 = r115 + 1;
        r113 = r210;
        r112 = r211;
        goto L24
    L31:
        r108 = new f06.d(false, null);
        goto L33
    L21:
        r106 = ApiHookConfig.f245613d;
        goto L22
    L36:
        r109 = -1;
    L38:
        r102 = false;
        goto L40
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostAction.LiveAudioModeChangedListener
    public final void onModeChanged(int r100) {
        WeakReference<as0.c.a> r101 = this.f85840e;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.get() == null) goto L9;
        this.f85840e.get().onModeChanged(r100);
        return;
    }

    public b(r r100, Context r101) {
        this.f85838c = j1.f142014a.getValue().getFixAudioLeak();
        this.f85836a = r101;
        this.f85840e = new WeakReference(r100);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int r100, String r101) {
        super.onCallStateChanged(r100, r101);
        WeakReference<as0.c.a> r102 = this.f85840e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.get() == null) goto L9;
        this.f85840e.get().a(r100);
        return;
    }
}
