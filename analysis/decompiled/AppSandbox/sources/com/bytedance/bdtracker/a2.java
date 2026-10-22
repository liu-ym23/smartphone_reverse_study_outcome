package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a2 extends p1 {
    public final Context e;
    public final u1 f;

    public a2(Context context, u1 u1Var) {
        super(false, false);
        this.e = context;
        this.f = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Gaid";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) {
        if (!this.f.c.isGaidEnabled()) {
            return true;
        }
        String googleAid = this.f.c.getGoogleAid();
        if (TextUtils.isEmpty(googleAid)) {
            try {
                googleAid = h5.a(this.e, this.f);
            } catch (InterruptedException | ExecutionException | Exception unused) {
            } catch (TimeoutException e) {
                LoggerImpl.global().error("Query Gaid Timeout", e, new Object[0]);
            }
        }
        w1.a(jSONObject, "google_aid", googleAid);
        return true;
    }
}
