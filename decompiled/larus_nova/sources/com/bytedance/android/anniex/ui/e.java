package com.bytedance.android.anniex.ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.model.Response;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface e {

    public static class a implements e {
        public a() {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void a(TemplateBundle r100) {
            Intrinsics.checkNotNullParameter(r100, "templateBundle");
        }

        @Override // com.bytedance.android.anniex.ui.e
        @Deprecated(message = "Use onLoadFailed with errorCode instead")
        public void b(AnnieXLynxView r100, String r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void c(AnnieXLynxView r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void d(Uri r100, AnnieXLynxView r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void e(AnnieXLynxView r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void f(AnnieXLynxView r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void g(AnnieXLynxView r100, LynxError r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void j(AnnieXLynxView r100, JSONObject r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void k(AnnieXLynxView r100, String r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void l(q1.b r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void loadImage(Context r100, String r101, String r102, float r103, float r104, Transformer r105, m.a r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r106, "handler");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void m(AnnieXLynxView r100, JSONObject r101) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void n(Uri r100, AnnieXLynxView r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void o(q1.b r100) {
        }

        public void onDestroy() {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onModuleMethodInvoked(String r100, String r101, int r102) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTemplateReady(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "resFrom");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTimingSetup(Map<String, Object> r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void p(AnnieXLynxView r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public void q(AnnieXLynxView r100, String r101) {
        }

        public void s(String r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public String shouldRedirectImageUrl(String r100) {
            return null;
        }

        public void t(Response r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
        }
    }

    public static final class b {
        public static void a(Context r100, m.a r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "handler");
        }

        public static void b(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }
    }

    void a(TemplateBundle r100);

    void b(AnnieXLynxView r100, String r101);

    void c(AnnieXLynxView r100);

    void d(Uri r100, AnnieXLynxView r101);

    void e(AnnieXLynxView r100);

    void f(AnnieXLynxView r100);

    void g(AnnieXLynxView r100, LynxError r101);

    void j(AnnieXLynxView r100, JSONObject r101);

    void k(AnnieXLynxView r100, String r101);

    void l(q1.b r100);

    void loadImage(Context r100, String r101, String r102, float r103, float r104, Transformer r105, m.a r106);

    void m(AnnieXLynxView r100, JSONObject r101);

    void n(Uri r100, AnnieXLynxView r101);

    void o(q1.b r100);

    void onLoadFail(Uri r100, Throwable r101);

    void onModuleMethodInvoked(String r100, String r101, int r102);

    void onTemplateReady(String r100, boolean r101);

    void onTimingSetup(Map<String, Object> r100);

    void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102);

    void p(AnnieXLynxView r100);

    void q(AnnieXLynxView r100, String r101);

    String shouldRedirectImageUrl(String r100);
}
