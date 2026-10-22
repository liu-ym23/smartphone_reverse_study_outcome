package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/window/shop/holder/WindowBaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopWindowItemHolder<T extends f> extends WindowBaseViewHolder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f187822p = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public T f187823o;

    public static final class a {
    }

    public abstract void q4(T r100);

    public boolean s4() {
        return this instanceof WindowAnchorCardHolder;
    }

    public void t4() {
    }

    static {
        f187822p = q.a(1);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void o() {
        super.o();
        t4();
        this.f187823o = null;
    }

    public ShopWindowItemHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public Rect r4(int r100) {
        return new Rect(0, 0, 0, 0);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        if ((r100 instanceof mp3.c) == false) goto L5;
        Object r103 = ((mp3.c) r100).a();
    L6:
        super.b4(r103, r101, r102);
        if ((r103 instanceof f) == true) goto L9;
        Object r104 = null;
    L10:
        T r105 = (T) r104;
        if (r105 == null) goto L13;
        q4((f) r103);
        this.f187823o = r105;
        return;
    L13:
        ECExceptionMonitor.e(new Exception("window vo data can not be null, holder is " + getClass() + ", data = " + r100));
        return;
    L9:
        r104 = r103;
        goto L10
    L5:
        r103 = r100;
        goto L6
    }
}
