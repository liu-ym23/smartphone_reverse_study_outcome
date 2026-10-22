package ag3;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.cache.a {
    @Override // com.bytedance.android.ecom.arch.slice.render.cache.a
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.cache.b
    public final String getElementType() {
        return "Image";
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.cache.a
    public final int b() {
        Lazy r100 = CartSettingUtils.f179349a;
        return ((Number) CartSettingUtils.f179351c.getValue()).intValue();
    }

    public b() {
    }
}
