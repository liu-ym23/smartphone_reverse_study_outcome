package com.bytedance.bdtracker;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import stepos.com.android.internal.os.StatsdConfigProto;

/* loaded from: classes.dex */
public class b2 extends p1 {
    public final Context e;

    public b2(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Locale";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        w1.a(jSONObject, "language", this.e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        w1.a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        w1.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis()) / StatsdConfigProto.TimeUnit.CTS_VALUE);
        return true;
    }
}
