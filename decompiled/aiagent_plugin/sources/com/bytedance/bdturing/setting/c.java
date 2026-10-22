package com.bytedance.bdturing.setting;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.p;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f6597b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JSONObject f6598c = null;

    /* JADX INFO: compiled from: DefaultSettings.kt */
    static final class a extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6599a = null;

        static {
            f6599a = new a();
        }

        a() {
            super(0);
        }

        public final String a() {
            return "{\n\t\"common\": {\n\t\t\"period\": 300000,\n\t\t\"retry_count\": 3,\n\t\t\"retry_interval\": 2000,\n\t\t\"alpha\": \"0.5\",\n\t\t\"rgb\": \"000000\",\n\t\t\"skip_launch\": 0,\n\t\t\"use_jsb_request\": 0,\n        \"use_native_report\":0,\n        \"use_dialog_size_v2\":0,\n\t\t\"pre_create\": 0,\n\t\t\"request_encrypt\": 0,\n\t\t\"host\": {\n\t\t\t\"cn\": \"https://vcs.zijieapi.com/\",\n            \"boe\":\"https://vcs-boe.bytedance.net/\"\n\t\t},\n\t\t\"back_up_host\": {\n\t\t\t\"cn\": \"https://vcs.zijieapi.com/\",\n            \"boe\":\"https://vcs-boe.bytedance.net/\"\n\t\t}\n\t},\n\t\"self_unpunish\": {\n\t\t\"url\": {\n            \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-unpunish/1.7.3/output/index.html\",\n            \"boe\": \"https://unblock.web.bytedance.net/\"\n\t\t},\n\t\t\"host\": {\n            \"cn\":\"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n\t\"qa\": {\n\t\t\"host\": {\n            \"cn\": \"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n\t\t\"url\": {\n\t\t\t\"cn\":  \"https://unpkg.byted-static.com/byted/secsdk-qa/1.2.6/build/index.html\",\n            \"boe\": \"http://qa.web.bytedance.net\"\n\t\t},\n\t\t\"height\": 318,\n\t\t\"width\": 300\n\t},\n\t\"sms\": {\n\t\t\"host\": {\n            \"cn\": \"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n\t\t\"url\": {\n            \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-mobile-original/1.9.9/build/index.html\",\n            \"boe\": \"https://mobile.web.bytedance.net/\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n    \"twice_verify\": {\n\t\t\"host\": {\n            \"cn\": \"\"\n\t\t},\n\t\t\"url\": {\n            \"cn\": \"/verifycenter/authentication\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n\t\"verify\": {\n\t\t\"host\": {\n            \"cn\":\"https://verify.zijieapi.com/\",\n            \"boe\": \"https://boe-verify.bytedance.net/\"\n\t\t},\n\t\t\"back_up_host\": {\n            \"cn\":\"https://verify.zijieapi.com/\",\n            \"boe\": \"https://boe-verify.bytedance.net/\"\n\t\t},\n\t\t\"url\": {\n            \"cn\":\"https://lf-cdn-tos.bytescm.com/obj/static/secsdk-captcha/cn2/2.26.18/index.html\",\n            \"boe\": \"https://captcha.web.bytedance.net/\"\n\t\t},\n\t\t\"height\": 303,\n\t\t\"width\": 300\n\t},\n\n    \"smarter_verify\":{\n        \"url\":{\n            \"cn\":\"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smarter/index.html\"\n        },\n        \"host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"back_up_host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"width\":0,\n        \"height\":0\n    },\n    \"smartest_verify\":{\n        \"url\":{\n            \"cn\":\"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smartest/index.html\"\n        },\n        \"host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"back_up_host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"width\":0,\n        \"height\":0\n    },\n     \"verify_identity\":{\n            \"report_url\":{\n                \"cn\":\"https://verify.zijieapi.com/captcha/reportIdentity\",\n                \"boe\":\"https://boe-verify.bytedance.net/captcha/reportIdentity\"\n            }\n        }\n}";
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    private final String b() {
        return (String) ZeusTransformUtils.preCheckCast(f6597b.b(), String.class, "com.obric.aiagent.plugin");
    }

    static {
        c r0 = new c();
        f6596a = r0;
        f6597b = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f6599a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        f6598c = new JSONObject(r0.b());
    }

    private c() {
    }

    public final JSONObject a() {
        return f6598c;
    }
}
