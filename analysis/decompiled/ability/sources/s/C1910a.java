package s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.compose.material3.MenuKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1910a extends c {
    public final /* synthetic */ int d;
    public Context e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1910a(int i, boolean z10, boolean z11) {
        super(z10, z11);
        this.d = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    @Override // s.c
    public final boolean a(JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException {
        String str;
        int i;
        PackageInfo packageInfoB;
        Signature[] signatureArr;
        Signature signature;
        byte[] byteArray;
        switch (this.d) {
            case 0:
                Context context = this.e;
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null && !TextUtils.isEmpty("UMENG_APPKEY")) {
                        jSONObject.put("appkey", bundle.getString("UMENG_APPKEY"));
                        break;
                    }
                } catch (Throwable unused) {
                    return true;
                }
                break;
            case 1:
                Context context2 = this.e;
                int i6 = context2.getResources().getDisplayMetrics().densityDpi;
                switch (i6) {
                    case MenuKt.InTransitionDuration /* 120 */:
                        str = "ldpi";
                        break;
                    case 240:
                        str = "hdpi";
                        break;
                    case 260:
                    case 280:
                    case 300:
                    case 320:
                        str = "xhdpi";
                        break;
                    case 340:
                    case 360:
                    case 400:
                    case TypedValues.CycleType.TYPE_EASING /* 420 */:
                    case 440:
                    case 480:
                        str = "xxhdpi";
                        break;
                    case 560:
                    case 640:
                        str = "xxxhdpi";
                        break;
                    default:
                        str = "mdpi";
                        break;
                }
                jSONObject.put("density_dpi", i6);
                jSONObject.put("display_density", str);
                WindowManager windowManager = (WindowManager) context2.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                int defaultDisplay = windowManager.getDefaultDisplay();
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        i = 0;
                        int[] iArr = {defaultDisplay, i};
                        jSONObject.put("resolution", iArr[1] + "x" + iArr[0]);
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    defaultDisplay = 0;
                    th.printStackTrace();
                    i = 0;
                    int[] iArr2 = {defaultDisplay, i};
                    jSONObject.put("resolution", iArr2[1] + "x" + iArr2[0]);
                    return true;
                }
                if (defaultDisplay == 0) {
                    DisplayMetrics displayMetrics2 = context2.getResources().getDisplayMetrics();
                    if (displayMetrics2 != null) {
                        int i10 = displayMetrics2.widthPixels;
                        i = displayMetrics2.heightPixels;
                        defaultDisplay = i10;
                    } else {
                        i = 0;
                        defaultDisplay = 0;
                        int[] iArr22 = {defaultDisplay, i};
                        jSONObject.put("resolution", iArr22[1] + "x" + iArr22[0]);
                    }
                } else {
                    defaultDisplay.getRealMetrics(displayMetrics);
                    int i11 = displayMetrics.widthPixels;
                    i = displayMetrics.heightPixels;
                    defaultDisplay = i11;
                }
                int[] iArr222 = {defaultDisplay, i};
                jSONObject.put("resolution", iArr222[1] + "x" + iArr222[0]);
            case 2:
                h.b("language", jSONObject, this.e.getResources().getConfiguration().locale.getLanguage());
                int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
                if (rawOffset < -12) {
                    rawOffset = -12;
                }
                if (rawOffset > 12) {
                    rawOffset = 12;
                }
                jSONObject.put("timezone", rawOffset);
                h.b("region", jSONObject, Locale.getDefault().getCountry());
                TimeZone timeZone = Calendar.getInstance().getTimeZone();
                h.b("tz_name", jSONObject, timeZone.getID());
                jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis()) / 1000);
                break;
            case 3:
                h.b("access", jSONObject, D2.b.b(D2.b.d(this.e)));
                break;
            case 4:
                try {
                    j.a(this.e);
                    if (!w.h.b) {
                        break;
                    } else {
                        w.h.a("new user mode = false", null);
                        break;
                    }
                } catch (Throwable unused2) {
                    return true;
                }
            default:
                String strN = null;
                try {
                    Context context3 = this.e;
                    packageInfoB = D2.c.b(context3, context3.getPackageName(), 64);
                } catch (Throwable th3) {
                    w.h.b(th3);
                    packageInfoB = null;
                }
                if (packageInfoB != null && (signatureArr = packageInfoB.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null && (byteArray = signature.toByteArray()) != null) {
                    try {
                        if (byteArray.length != 0) {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            messageDigest.update(byteArray);
                            strN = M0.i.n(messageDigest.digest());
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (strN != null) {
                    jSONObject.put("sig_hash", strN);
                    break;
                }
                break;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1910a(Context context, int i) {
        super(true, false);
        this.d = i;
        this.e = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1910a(Context context, int i, boolean z10) {
        super(true, true);
        this.d = i;
        this.e = context;
    }
}
