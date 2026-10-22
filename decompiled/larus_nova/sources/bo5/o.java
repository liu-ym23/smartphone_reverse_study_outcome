package bo5;

import com.bytedance.ee.bear.templates.TemplateUtils;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements com.bytedance.ee.bear.templates.dto.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.templates.dto.d f19865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bizwidget.d f19866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yn5.e f19867c;

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onFail(int r100, String r101) {
        com.bytedance.ee.bear.templates.dto.d r102 = this.f19865a;
        if (r102 == null) goto L5;
        r102.onFail(r100, r101);
    L5:
        com.bytedance.ee.bear.bizwidget.d r103 = this.f19866b;
        if (r103 == null) goto L9;
        r103.a();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onSuccess(int r100, String r101) {
        com.bytedance.ee.bear.templates.dto.d r102 = this.f19865a;
        if (r102 == null) goto L5;
        r102.onSuccess(r100, r101);
    L5:
        com.bytedance.ee.bear.bizwidget.d r103 = this.f19866b;
        if (r103 == null) goto L9;
        r103.a();
    L9:
        if (this.f19867c.f568559d == false) goto L12;
        TemplateUtils.f238776a.getClass();
        TemplateUtils.k(r100, r101);
        return;
    }

    public o(com.bytedance.ee.bear.templates.dto.d r100, com.bytedance.ee.bear.bizwidget.d r101, yn5.e r102) {
        this.f19865a = r100;
        this.f19866b = r101;
        this.f19867c = r102;
    }
}
