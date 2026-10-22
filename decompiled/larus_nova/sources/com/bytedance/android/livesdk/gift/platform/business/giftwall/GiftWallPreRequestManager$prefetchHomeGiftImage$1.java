package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GiftWallPreRequestManager$prefetchHomeGiftImage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $json;
    final /* synthetic */ GiftWallPreRequestManager this$0;

    public GiftWallPreRequestManager$prefetchHomeGiftImage$1(GiftWallPreRequestManager r100, JsonObject r101) {
        this.this$0 = r100;
        this.$json = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Iterator<JsonElement> r100 = this.$json.getAsJsonArray("lighted_items").iterator();
        int r101 = 0;
    L3:
        String r102 = null;
        boolean r103 = true;
        if (r100.hasNext() == false) goto L17;
        JsonElement r104 = r100.next();
        if (r101 >= 12) goto L3;
        String r105 = GiftWallPreRequestManager.j(this.this$0, r104);
        if (r105 == null) goto L3;
        if (r105.length() > 0) goto L13;
        r103 = false;
    L13:
        if (r103 == false) goto L15;
        r102 = r105;
    L15:
        if (r102 == null) goto L3;
        r101 = r101 + 1;
        GiftWallPreRequestManager.k(this.this$0, r102);
        goto L3
    L17:
        Iterator<JsonElement> r106 = this.$json.getAsJsonArray("unlighted_items").iterator();
    L19:
        if (r106.hasNext() == false) goto L33;
        JsonElement r107 = r106.next();
        if (r101 >= 12) goto L19;
        String r108 = GiftWallPreRequestManager.j(this.this$0, r107);
        if (r108 == null) goto L19;
        if (r108.length() <= 0) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L31;
        r108 = null;
    L31:
        if (r108 == null) goto L19;
        r101 = r101 + 1;
        GiftWallPreRequestManager.k(this.this$0, r108);
        goto L19
    L27:
        r109 = false;
        goto L28
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
