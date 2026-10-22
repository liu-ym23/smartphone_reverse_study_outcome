package co5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f24632a;

    public g(e r100) {
        this.f24632a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        SelectorConfig r100 = new SelectorConfig();
        r100.c(SelectorType.SPACE_SAVE_TEMPLATE);
        r100.a(SelectorScope.SPACE_ONLY);
        r100.b(this.f24632a.f24627a.getString(R.string.Doc_Facade_SelectFolder));
        r100.f229372d = true;
        r100.f229373e = true;
        r100.f229375g = 16;
        com.bytedance.ee.bear.contract.route.parcelable.f r101 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        e r102 = this.f24632a;
        Context r103 = r102.f24627a;
        td5.f r104 = new td5.f();
        r104.f545520e = 16;
        r104.f545519d = r102.f24628b.collection_id;
        Unit r111 = Unit.INSTANCE;
        r101.c(r103, r100, r104, null, null);
        e r112 = this.f24632a;
        List<SceneTemplateData.Scene> r105 = r112.f24628b.template_collection;
        if (r105 == null) goto L8;
        Iterator<T> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        SceneTemplateData.Scene r107 = (SceneTemplateData.Scene) r106.next();
        com.bytedance.ee.bear.templates.b r113 = new com.bytedance.ee.bear.templates.b("use_click_button", r107.obj_token, r107.name, r112.f24628b.collection_id, r112.f24630d, r107.obj_type, r112.f24629c, 96);
        TemplateReportV2 r108 = TemplateReportV2.f238768a;
        TemplateReportV2.h(r113);
        goto L6
    L10:
        return;
    }
}
