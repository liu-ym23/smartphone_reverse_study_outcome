package b62;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f17816b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f17817c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17818a;

    /* JADX WARN: Type inference failed for: r0v0, types: [b62.b] */
    static {
        f17817c = new b();
    }

    public c() {
        this.f17818a = 1500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (f17816b == false) goto L6;
        f17816b = false;
        r100.postDelayed(f17817c, this.f17818a);
        z52.c r101 = (z52.c) this;
        z52.b r102 = r101.f570090d;
        r102.getClass();
        BarrageSetting r103 = new BarrageSetting();
        r103.setBarrageArea(BarrageSettingArea.HALF);
        r103.setFontSize(BarrageSettingFont.MID);
        r103.setAlpha(75.0f);
        r103.setGiftOpen(true);
        r103.setChatChannelOpen(true);
        r102.f570084y = r103;
        z52.b r104 = r101.f570090d;
        r104.e(r104.f570084y);
        r101.f570090d.f570078s.setOnSeekBarChangeListener(null);
        z52.b r105 = r101.f570090d;
        r105.d(r105.f570084y);
        z52.b r106 = r101.f570090d;
        r106.f570078s.setOnSeekBarChangeListener(r106.f570059J);
        r101.f570090d.getClass();
        j0.l().sendLog("livesdk_landscape_barrage_settings_default_setting_click", null, new Object[]{new x(), IRoom.class});
        f2.c("已恢复默认设置", 0);
        return;
    }
}
