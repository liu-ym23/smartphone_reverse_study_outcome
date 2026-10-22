package com.bytedance.android.live.virtuallive.impl.anchor;

import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f102623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f102624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f102625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f102626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f102627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f102628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f102629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f102630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f102631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f102632j;

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    public b() {
        this.f102623a = "";
        this.f102624b = "";
        this.f102625c = -1;
        this.f102626d = "";
        this.f102627e = "";
        this.f102628f = "";
        this.f102629g = "normal";
        this.f102630h = System.currentTimeMillis();
        this.f102631i = System.currentTimeMillis();
        this.f102632j = System.currentTimeMillis();
        j0.l().addSendLogFilter(b.class, this);
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        switch(r100.hashCode()) {
            case -1376200822: goto L45;
            case -1007472952: goto L42;
            case -986754921: goto L39;
            case -978083431: goto L36;
            case -522078680: goto L33;
            case -439990293: goto L30;
            case 394083251: goto L27;
            case 551812441: goto L24;
            case 731713941: goto L21;
            case 755214242: goto L18;
            case 806670959: goto L15;
            case 929402142: goto L12;
            case 1249850874: goto L9;
            case 1868914468: goto L6;
            default: goto L66;
        };
    L66:
        return;
    L6:
        if (r100.equals("livesdk_connection_over") == false) goto L52;
    L46:
        r101.put("character_id", this.f102624b);
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L49;
        String r102 = "1";
    L50:
        r101.put("is_trial", r102);
        r101.put("character_style", this.f102628f);
        return;
    L49:
        r102 = "0";
        goto L50
    L52:
        return;
    L9:
        if (r100.equals("livesdk_interact_icon_click") == true) goto L46;
        return;
    L12:
        if (r100.equals("pk_start") == true) goto L46;
        return;
    L15:
        if (r100.equals("livesdk_pk_start") == true) goto L46;
        return;
    L18:
        if (r100.equals("connection_success") == true) goto L46;
        return;
    L21:
        if (r100.equals("connection_over") == true) goto L46;
        return;
    L24:
        if (r100.equals("livesdk_connection_invite") == true) goto L46;
        return;
    L27:
        if (r100.equals("livesdk_connection_success") == true) goto L46;
        return;
    L30:
        if (r100.equals("interact_icon_click") == true) goto L46;
        return;
    L33:
        if (r100.equals("livesdk_pk_end") == true) goto L46;
        return;
    L36:
        if (r100.equals("livesdk_connection_invited_page_show") == true) goto L46;
        return;
    L39:
        if (r100.equals("pk_end") == true) goto L46;
        return;
    L42:
        if (r100.equals("connection_invited_page_show") == true) goto L46;
        return;
    L45:
        if (r100.equals("connection_invite") == true) goto L46;
    }
}
