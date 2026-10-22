package co5;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f24631a;

    public f(e r100) {
        this.f24631a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (TextUtils.isEmpty(this.f24631a.f24628b.app_link) == false) goto L5;
        tt5.a.h("TemplateSelectView", "handleEcologyButton app_link is empty");
        return;
    L5:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(this.f24631a.f24628b.app_link);
        TemplateReportV2 r101 = TemplateReportV2.f238768a;
        e r102 = this.f24631a;
        String r103 = r102.f24630d;
        SceneTemplateData r104 = r102.f24628b;
        String r105 = r104.collection_id;
        String r106 = r104.name;
        String r107 = r102.f24629c;
        Intrinsics.checkNotNullParameter(r105, "setId");
        Intrinsics.checkNotNullParameter(r106, "templateName");
        JSONObject r108 = new JSONObject();
        r108.put2("click_type", "consult_button");
        r108.put2("set_id", r105);
        r108.put2("set_name", r106);
        r108.put2("is_customized", Boolean.valueOf(Intrinsics.areEqual("4", r107)));
        r108.put2("template_source", TemplateReportV2.f238770c);
        if (r103 == null) goto L8;
        r108.put2("templatecenter_source", r103);
    L8:
        TemplateReportV2.a().o("ccm_set_template_preview_click", r108, false);
    }
}
