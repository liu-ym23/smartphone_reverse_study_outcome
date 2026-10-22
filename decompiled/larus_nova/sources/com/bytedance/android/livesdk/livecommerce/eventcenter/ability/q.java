package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class q implements ml.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f147793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f147794b;

    @Override // ml.b
    public final String c() {
        return this.f147793a.optString("broadcast_id");
    }

    @Override // ml.b
    public final String d() {
        return this.f147793a.optString("broadcast_sec_id");
    }

    @Override // ml.b
    public final String roomId() {
        String r100 = this.f147793a.optString("room_id");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L11;
        return r100;
    L11:
        return this.f147794b;
    L5:
        r101 = false;
        goto L6
    }

    public q(JSONObject r100, String r101) {
        this.f147793a = r100;
        this.f147794b = r101;
    }
}
