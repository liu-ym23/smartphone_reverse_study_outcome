package com.bytedance.android.shopping.anchorv4.schemav2;

import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends PdpSchemaParam {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f167372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f167373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f167374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f167375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f167376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f167377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f167378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f167379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f167380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f167381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f167382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f167383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f167384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f167385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f167386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f167387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f167388t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f167389u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f167390v;

    public final void e() {
        this.f167372d = c().optString("enter_from", null);
        this.f167373e = c().optString("enter_method", null);
        this.f167378j = c().optString("domain_params", null);
        this.f167375g = c().optString(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, null);
        this.f167374f = c().optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, null);
        this.f167376h = c().optString(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, null);
        this.f167377i = c().optString(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, null);
        this.f167379k = c().optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, null);
        this.f167380l = Boolean.valueOf(com.bytedance.android.shopping.extensions.k.n(c().optString("from_video", null), false));
        this.f167381m = c().optString(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, null);
        this.f167382n = c().optString(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, null);
        this.f167383o = c().optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, null);
        this.f167384p = c().optString("ecom_scene_id", null);
        this.f167385q = Integer.valueOf(c().optInt("toutiao_app_id", 0));
        this.f167386r = c().optString("header_config", null);
        this.f167387s = c().optString(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, null);
        this.f167388t = c().optString("channel_id", null);
        this.f167389u = Integer.valueOf(c().optInt(WsConstants.KEY_CHANNEL_TYPE, 0));
        this.f167390v = c().optString("source_page", null);
    }

    @Override // com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaParam
    public final String d() {
        return this.f167371c;
    }

    public d(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        super(r100);
        this.f167371c = "chain_info";
        this.f167380l = Boolean.FALSE;
        this.f167385q = 0;
    }
}
