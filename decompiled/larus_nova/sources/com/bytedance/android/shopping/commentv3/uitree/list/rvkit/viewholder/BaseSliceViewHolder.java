package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentTemplate;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.SliceUpdateEvent;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import ic3.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "SliceCardView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSliceViewHolder<SliceCardView extends CommentSliceView> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SliceCardView f172852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcRenderContext f172853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.commentv3.data.b f172854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentSliceComponent f172855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Integer> f172856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f172857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommentTemplate f172858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f172859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f172860i;

    public Map<String, Object> T3() {
        return null;
    }

    public Map<String, fc3.b> U3(IAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return null;
    }

    public final String V3() {
        CommentSliceComponent r100 = this.f172855d;
        if (r100 == null) goto L6;
        String r101 = r100.getSliceId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "default_id";
    }

    public final void W3(CommentTemplate r110) {
        if (r110 == null) goto L5;
        String r100 = r110.getUrl();
    L6:
        if (r110 == null) goto L8;
        String r101 = r110.getName();
    L9:
        if (r100 == null) goto L24;
        if (r101 != null) goto L12;
        return;
    L12:
        if (this.f172853b != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(this.f172858g, r110) == true) goto L28;
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a(this.f172859h).i("initSlcTemplate, sliceId: ".concat(V3()));
        int r103 = e.f489165a;
        com.bytedance.android.shopping.commentv3.data.b r104 = this.f172854c;
        if (r104 == null) goto L19;
        fc3.a r105 = r104.f172737b;
    L20:
        e.a.a(r105, EventName.STATE.getEvent(), EntranceType.SLICE_BIND_DATA.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: " + this.f172859h + ", method: initSlcTemplate, sliceId: " + V3())}), null, null, 240);
        this.f172858g = r110;
        SliceCardView r111 = this.f172852a;
        if (r111 == null) goto L27;
        a r106 = new a(this);
        SlcRenderContext r107 = this.f172853b;
        Intrinsics.checkNotNullParameter(r106, "actionHandler");
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r107, "slcRenderContext");
        i r108 = new i(r100, r101, "");
        KProperty[] r109 = SlcRenderContext.f50160n0;
        r r112 = r107.c(r108, null);
        r112.b(r106);
        r111.removeAllViews();
        r111.addView(r112.f50701c, new ViewGroup.LayoutParams(-1, -1));
        r111.f172940f = r112;
        return;
    L27:
        return;
    L19:
        r105 = null;
        goto L20
    L28:
        return;
    L24:
        return;
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = null;
        goto L6
    }

    public final void X3(CommentSliceComponent r110) {
        if (r110 == null) goto L4;
        this.f172855d = r110;
    L4:
        SliceCardView r100 = this.f172852a;
        fc3.a r101 = null;
        if (r100 == null) goto L16;
        if (r110 == null) goto L8;
        Map<String, ? extends Object> r111 = r110.getStyle();
    L9:
        Function0<Integer> r102 = this.f172856e;
        if (r102 == null) goto L14;
        Integer r103 = r102.invoke();
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
    L15:
        r100.b(r111, r104, this.f172857f);
    L14:
        r104 = 0;
        goto L15
    L8:
        r111 = null;
    L16:
        dm.a.b r112 = dm.a.f469202a;
        dm.a.a(this.f172859h).i("innerBindData, sliceId: ".concat(V3()));
        int r113 = e.f489165a;
        com.bytedance.android.shopping.commentv3.data.b r114 = this.f172854c;
        if (r114 == null) goto L19;
        r101 = r114.f172737b;
    L19:
        e.a.a(r101, EventName.STATE.getEvent(), EntranceType.SLICE_BIND_DATA.getType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: " + this.f172859h + ", method: innerBindData, sliceId: " + V3())}), null, null, 240);
        SliceCardView r115 = this.f172852a;
        if (r115 == null) goto L35;
        LinkedHashMap r105 = new LinkedHashMap();
        CommentSliceComponent r106 = this.f172855d;
        if (r106 == null) goto L26;
        Map<String, Object> r107 = r106.getData();
        if (r107 == null) goto L26;
        r105.putAll(r107);
    L26:
        Map<String, Object> r108 = T3();
        if (r108 == null) goto L29;
        r105.putAll(r108);
    L29:
        Map<String, ? extends Object> r109 = SliceRender.a(r105);
        String r116 = V3();
        Intrinsics.checkNotNullParameter(r109, "data");
        Intrinsics.checkNotNullParameter(r116, "uniqueNodeId");
        r r117 = r115.f172940f;
        if (r117 == null) goto L32;
        r117.a(r109, r116);
    L32:
        r r118 = r115.f172940f;
        if (r118 == null) goto L35;
        SliceUpdateEvent.f172766e.update(r116, r118);
    L35:
        SliceCardView r119 = this.f172852a;
        if (r119 == null) goto L39;
        ExtensionsKt.visible(r119);
        return;
    }

    public final int Y3(int r100) {
        SliceCardView r101 = this.f172852a;
        if (r101 == null) goto L6;
        return r101.c(r100);
    L6:
        return com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSliceViewHolder(CommentSliceView r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f172860i = r101;
        this.f172852a = r100;
        com.bytedance.android.shopping.commentv3.data.b r102 = null;
        if (r101 == null) goto L5;
        SlcRenderContext r103 = r101.f172676c;
    L6:
        this.f172853b = r103;
        if (r101 == null) goto L9;
        r102 = r101.f172678e;
    L9:
        this.f172854c = r102;
        this.f172859h = "BaseSliceViewHolder";
        return;
    L5:
        r103 = null;
        goto L6
    }
}
