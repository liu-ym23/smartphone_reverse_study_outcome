package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class u01 {

    @SerializedName("add_time_schema")
    public String addTimeSchema;

    @SerializedName("application_reason_schema")
    public String applicationReasonConfigSchema;

    @SerializedName("apply_schema")
    public String applyLinkSchema;

    @SerializedName("comment_schema")
    public String commentSchema;

    @SerializedName("paid_turnon_schema")
    public String paymentConfigSchema;

    public u01() {
    }

    public static u01 a() {
        u01 r100 = new u01();
        r100.paymentConfigSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf3-webcast.bytetos.com%2Fobj%2Fwebcast-new%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Flinkmic%2Fpayforlink%2Finterface%2Fsettingpanel%2Ftemplate.js&gravity=bottom&type=popup&load_taro=0&height=450";
        r100.applyLinkSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf3-webcast.bytetos.com%2Fobj%2Fwebcast-new%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Flinkmic%2Fpayforlink%2Finterface%2Fapply%2Ftemplate.js&gravity=bottom&type=popup&load_taro=0&height=344";
        r100.addTimeSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf3-webcast.bytetos.com%2Fobj%2Fwebcast-new%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Flinkmic%2Fpayforlink%2Finterface%2Frenew%2Ftemplate.js&gravity=bottom&type=popup&load_taro=0&height=200";
        r100.commentSchema = "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Fh5%2Fdouyin_h5_community%2Ftemplate%2Fpages%2Fevaluate%2Fsubmit%2Findex.html%3Fweb_bg_color%3D%2523%252300000000&type=popup&gravity=bottom&rate_height=450&height=450";
        r100.applicationReasonConfigSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf3-webcast.bytetos.com%2Fobj%2Fwebcast-new%2Fies%2Flive%2Fwebcast_native_lynx_douyin%2Fpages%2Flinkmic%2Fpayforlink%2Finterface%2Fapplyreasonsetting%2Ftemplate.js&gravity=bottom&type=popup&load_taro=0&height=300&show_dim=1";
        return r100;
    }
}
