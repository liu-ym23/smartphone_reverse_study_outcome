package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocaleLoader.java */
/* JADX INFO: loaded from: classes.dex */
class s extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6233e;
    private final an f;

    s(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(true, true);
        this.f6233e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f = r4;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r3) {
        ba.a(r3, "language", ZeusTransformUtils.getResources(this.f6233e, "com.obric.aiagent.plugin").getConfiguration().locale.getLanguage());
        int r0 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r0 >= (-12)) goto L6;
        r0 = -12;
    L6:
        if (r0 <= 12) goto L8;
        r0 = 12;
    L8:
        r3.put("timezone", r0);
        ba.a(r3, "region", com.bytedance.bdinstall.j.q.d(this.f));
        TimeZone r2 = Calendar.getInstance().getTimeZone();
        ba.a(r3, "tz_name", r2.getID());
        r3.put("tz_offset", r2.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
