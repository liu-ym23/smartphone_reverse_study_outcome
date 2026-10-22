package bq0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BusinessToolType f20012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20014d;

    public b() {
        super(s1.B(R.string.ttlive_open_platform_coupon_content));
        this.f20012b = BusinessToolType.Coupon;
        this.f20013c = s1.B(R.string.ttlive_open_platform_send_coupon_text);
        this.f20014d = R.drawable.ttlive_mini_app_business_tool_coupon_icon;
    }

    @Override // bq0.a
    public final int a() {
        return this.f20014d;
    }

    @Override // bq0.a
    public final BusinessToolType b() {
        return this.f20012b;
    }

    @Override // bq0.a
    public final String c() {
        return this.f20013c;
    }
}
