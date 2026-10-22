package bo5;

import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements com.bytedance.ee.bear.templates.dto.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.templates.dto.d f19864a;

    public n(TemplateTypeSwitchItemV2.c r100) {
        this.f19864a = r100;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onFail(int r100, String r101) {
        com.bytedance.ee.bear.templates.dto.d r102 = this.f19864a;
        if (r102 == null) goto L6;
        r102.onFail(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.dto.d
    public final void onSuccess(int r100, String r101) {
        com.bytedance.ee.bear.templates.dto.d r102 = this.f19864a;
        if (r102 == null) goto L6;
        r102.onSuccess(r100, r101);
        return;
    }
}
