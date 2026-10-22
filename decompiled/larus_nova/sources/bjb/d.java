package bjb;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements y18.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f19271b;

    @Override // y18.a
    public final String getUserAgent() {
        if (TextUtils.isEmpty(this.f19270a) == false) goto L6;
        Context r100 = this.f19271b;
        yob.e.a().getClass();
        int r101 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
        this.f19270a = xoc.a.a(r100);
    L6:
        return this.f19270a;
    }

    public d(Context r100) {
        this.f19271b = r100;
    }
}
