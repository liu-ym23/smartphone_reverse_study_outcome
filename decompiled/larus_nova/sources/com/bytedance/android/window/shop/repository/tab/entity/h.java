package com.bytedance.android.window.shop.repository.tab.entity;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f189566m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.ec.window.base.dynamicview.virtualview.k<? extends View, ?> f189567j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final to.d f189568k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final to.b f189569l;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/h$b;", "", "", "itemType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "templateName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "layout", "c", "", "renderDataGroup", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "", "Lmo/a;", "dynamicEventGroup", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("dynamic_event_data_group")
        private final Map<String, List<mo.a>> dynamicEventGroup;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
        private final Integer itemType;

        @SerializedName("layout")
        private final String layout;

        @SerializedName("dynamic_render_data_group")
        private final Map<String, String> renderDataGroup;

        @SerializedName("layout_name")
        private final String templateName;

        public final Map<String, List<mo.a>> a() {
            return this.dynamicEventGroup;
        }

        public final Integer b() {
            return this.itemType;
        }

        public final String c() {
            return this.layout;
        }

        public final Map<String, String> d() {
            return this.renderDataGroup;
        }

        public final String e() {
            return this.templateName;
        }
    }

    static {
    }

    public h(int r100, com.bytedance.android.ec.window.base.dynamicview.virtualview.k<? extends View, ?> r101, to.d r102, to.b r103) {
        Intrinsics.checkNotNullParameter(r101, "viewElement");
        super(r100);
        this.f189567j = r101;
        this.f189568k = r102;
        this.f189569l = r103;
    }
}
