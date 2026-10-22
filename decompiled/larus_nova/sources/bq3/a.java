package bq3;

import android.view.View;
import aq3.e;
import aq3.f;
import aq3.g;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final cq3.a f20021n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<aq3.a> i() {
        vp.c r100 = new vp.c();
        return CollectionsKt.listOf(new aq3.a[]{new g(this.f20023m.findViewById(R.id.ec_shop_inner_flow_video_module_container), this.f20021n.f464767c, r100), new aq3.d(this.f20023m.findViewById(R.id.ec_shop_inner_flow_product_module_container)), new aq3.c(this.f20023m.findViewById(R.id.ec_shop_inner_flow_hot_comment_module_container), this.f20021n.f464768d), new aq3.b(this.f20023m.findViewById(R.id.ec_shop_inner_flow_barrage_root_area), r100), new e(this.f20023m.findViewById(R.id.ec_shop_inner_flow_recommend_area)), new f(this.f20023m.findViewById(R.id.ec_shop_inner_flow_tags_module_container))});
    }

    public a(View r100, vp.c r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "proxy");
        super(r100);
        cq3.a r102 = new cq3.a();
        r101.f556543a = r102;
        Unit r103 = Unit.INSTANCE;
        this.f20021n = r102;
    }
}
