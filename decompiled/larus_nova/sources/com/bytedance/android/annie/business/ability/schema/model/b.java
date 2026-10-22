package com.bytedance.android.annie.business.ability.schema.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.jvm.internal.Intrinsics;
import t36.d;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public class b extends AnnieXLiveCardModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y36.a f38878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y36.a f38879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f38880h;

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d() {
        y36.a r100 = this.f38879g;
        if (r100 == null) goto L7;
        Boolean r101 = (Boolean) r100.f565862b;
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        return false;
    }

    public b() {
    }

    @Override // com.bytedance.android.annie.business.ability.schema.model.AnnieXLiveCardModel, t36.f
    public void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        super.a(r100);
        Boolean r101 = Boolean.FALSE;
        new y36.a(r100, "forbid_right_back", r101);
        this.f38878f = new y36.a(r100, AppConstants.BUNDLE_ENABLE_SHARE, r101);
        this.f38879g = new y36.a(r100, "show_float_live", r101);
        new y36.a(r100, "enable_card_cache", r101);
        new y36.a(r100, "close_position_right", Boolean.TRUE);
        this.f38880h = new p(r100, "title", null);
    }
}
