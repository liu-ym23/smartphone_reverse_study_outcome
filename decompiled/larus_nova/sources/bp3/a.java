package bp3;

import android.net.Uri;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECWindowParam f19970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowHeaderResponseDTO f19971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f19972c;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        a(this, "statusCode", String.valueOf(this.f19971b.getStatusCode()));
        a(this, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, this.f19971b.getStatusMsg());
        a(this, com.bytedance.android.ec.core.event.a.KEY_MESSAGE, this.f19971b.getMessage());
        a(this, "page_name", this.f19970a.getPageName());
        a(this, "author_id", this.f19970a.getAuthorId());
        a(this, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, this.f19970a.getEntranceLocation());
        a(this, "enter_from", this.f19970a.getEnterFrom());
        a(this, "enter_method", this.f19970a.getEnterMethod());
        ECAdLogExtra r100 = this.f19970a.getAdLogExtra();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getCreativeId();
    L6:
        a(this, "creative_id", String.valueOf(r102));
        ECAdLogExtra r103 = this.f19970a.getAdLogExtra();
        if (r103 == null) goto L9;
        String r104 = r103.getGroupId();
    L10:
        a(this, "item_id", String.valueOf(r104));
        ECAdLogExtra r105 = this.f19970a.getAdLogExtra();
        if (r105 == null) goto L13;
        String r106 = r105.getLogExtra();
    L14:
        a(this, "log_extra", r106);
        ECAdLogExtra r107 = this.f19970a.getAdLogExtra();
        if (r107 == null) goto L17;
        String r108 = r107.getAdExtraData();
    L18:
        a(this, "ad_extra_data", r108);
        Uri r109 = this.f19972c;
        String[] r110 = {com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "enter_from", "enter_method", "uid", "sec_uid", "is_search"};
        if (r109 == null) goto L33;
        int r111 = 0;
    L23:
        if (r111 >= 6) goto L33;
        String r112 = r110[r111];
        String r113 = UriProtector.getQueryParameter(r109, r112);
        if (r113 == null) goto L32;
        if (k.c(r113) == true) goto L30;
        r113 = null;
    L30:
        if (r113 == null) goto L32;
        a(this, r112, r113);
    L32:
        r111 = r111 + 1;
    L33:
        Uri r114 = this.f19972c;
        if (r114 == null) goto L36;
        r101 = r114.toString();
    L36:
        a(this, com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL, r101);
        return;
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public a(ECWindowParam r100, WindowHeaderResponseDTO r101, Uri r102) {
        Intrinsics.checkNotNullParameter(r100, "shopParam");
        Intrinsics.checkNotNullParameter(r101, "responseDTO");
        super("ec_shop_enter_failed");
        this.f19970a = r100;
        this.f19971b = r101;
        this.f19972c = r102;
    }

    public static void a(a r100, String r101, String r102) {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        r100.appendParam(r101, r102, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
    }
}
