package b84;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.crash.general.HardwareInfo;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18058e;

    public o(Context r100) {
        super(true, false);
        this.f18058e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r110) throws JSONException {
        String r100 = "mdpi";
        Resources r101 = this.f18058e.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        int r103 = r102.densityDpi;     // Catch: Exception -> L13
        if (r103 == 120) goto L10;
        if (r103 == 240) goto L9;
        if (r103 == 320) goto L8;
        Object r111 = "mdpi";
    L11:
        r110.put(HardwareInfo.KEY_HW_DENSITY_DPI, r103);     // Catch: Exception -> L13
        r110.put(HardwareInfo.KEY_HW_DISPLAY_DENSITY, r111);     // Catch: Exception -> L13
        r110.put("resolution", r102.heightPixels + "x" + r102.widthPixels);     // Catch: Exception -> L13
    L15:
        int r104 = r102.densityDpi;
        if (r104 > 120) goto L19;
        r100 = "ldpi";
    L32:
        r110.put("display_density_v2", r100);
        WindowManager r105 = (WindowManager) this.f18058e.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L38
        DisplayMetrics r106 = new DisplayMetrics();     // Catch: Throwable -> L38
        r105.getDefaultDisplay().getRealMetrics(r106);     // Catch: Throwable -> L38
        int r107 = r106.widthPixels;     // Catch: Throwable -> L38
        int r108 = r106.heightPixels;     // Catch: Throwable -> L36
    L41:
        int[] r109 = {r107, r108};
        r110.put("resolution_v2", r109[1] + "x" + r109[0]);
        int r112 = com.bytedance.bdinstall.t.f199790a;
        return true;
    L36:
        Throwable th10 = th;
    L40:
        th10.printStackTrace();
        r108 = 0;
    L38:
        th = move-exception;
        th10 = th;
        r107 = 0;
        goto L40
    L19:
        if (r104 <= 160) goto L32;
        if (r104 > 240) goto L23;
        r100 = "hdpi";
        goto L32
    L23:
        if (r104 > 320) goto L26;
        r100 = "xhdpi";
        goto L32
    L26:
        if (r104 > 480) goto L29;
        r100 = "xxhdpi";
        goto L32
    L29:
        if (r104 > 640) goto L31;
        r100 = "xxxhdpi";
        goto L32
    L31:
        r100 = "xxxxhdpi";
        goto L32
    L8:
        r111 = "xhdpi";
        goto L11
    L9:
        r111 = "hdpi";
        goto L11
    L10:
        r111 = "ldpi";
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
