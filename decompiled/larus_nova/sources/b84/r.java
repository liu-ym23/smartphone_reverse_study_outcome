package b84;

import android.content.Context;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f18060f;

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        c1.i(r100, "language", this.f18059e.getResources().getConfiguration().locale.getLanguage());
        int r101 = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (r101 >= (-12)) goto L6;
        r101 = -12;
    L6:
        if (r101 <= 12) goto L8;
        r101 = 12;
    L8:
        r100.put("timezone", r101);
        o0 r102 = this.f18060f;
        i84.q.a r103 = i84.q.f488632a;
        c1.i(r100, EffectConfiguration.KEY_REGION, r102.M.e());
        TimeZone r104 = Calendar.getInstance().getTimeZone();
        c1.i(r100, "tz_name", r104.getID());
        r100.put("tz_offset", r104.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }

    public r(Context r100, o0 r101) {
        super(true, true);
        this.f18059e = r100;
        this.f18060f = r101;
    }
}
