package bq0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BusinessToolType f20015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20019f;

    @Override // bq0.a
    public final int a() {
        return this.f20016c;
    }

    @Override // bq0.a
    public final BusinessToolType b() {
        return this.f20015b;
    }

    @Override // bq0.a
    public final String c() {
        return this.f20017d;
    }

    public c(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "settingDesc");
        super(r101);
        this.f20017d = r100;
        this.f20018e = r102;
        this.f20019f = r103;
        this.f20015b = BusinessToolType.PrivateMsg;
        this.f20016c = R.drawable.ttlive_mini_app_business_tool_private_msg_icon;
    }
}
