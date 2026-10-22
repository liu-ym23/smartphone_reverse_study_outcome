package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/input/OGCFixedCommentViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedCommentAdapter extends RecyclerView.Adapter<OGCFixedCommentViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<Integer, String>> f135047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f135048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f135049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f135050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f135051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f135052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f135053g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f135047a).size();
    }

    public OGCFixedCommentAdapter(d0 r110, DataCenter r111) {
        Intrinsics.checkNotNullParameter(r110, "actionHandler");
        this.f135052f = r110;
        this.f135053g = r111;
        this.f135047a = new ArrayList();
        this.f135048b = LazyKt.lazy(new OGCFixedCommentAdapter$skinNormal$2(this));
        this.f135049c = LazyKt.lazy(new OGCFixedCommentAdapter$skinSelect$2(this));
        this.f135050d = ColorProtector.parseColor("#161823");
        this.f135051e = ColorProtector.parseColor("#161823");
        com.bytedance.android.livesdk.interactivity.api.h r112 = com.bytedance.android.livesdk.interactivity.api.i.a(null, r111);
        if (r112 == null) goto L57;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r113 = r112.getQuickCommentManager();
        if (r113 == null) goto L58;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r114 = r113.getValue();
        if (r114 == null) goto L59;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r115 = r114.getOGCFixedChatInfo();
        if (r115 == null) goto L60;
        List<String> r100 = r115.fixedChatList;
        boolean r101 = false;
        if (r100 == null) goto L36;
        List<String> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L30;
        String r105 = (String) r104.next();
        if (StringsKt.contains$default(r105, "%v", false, 2, null) == false) goto L29;
        IRoomContextService r106 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r106 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r107 = IRoomContextService.a.a(r106, this.f135053g, 0, 2);
        if (r107 == null) goto L27;
        com.bytedance.live.datacontext.m<String> r108 = r107.K2();
        if (r108 == null) goto L27;
        String r109 = r108.getValue();
        if (r109 == null) goto L27;
        String r116 = r109;
    L28:
        r105 = StringsKt.replace$default(r105, "%v", r116, false, 4, null);
        ALogger.i("OGCFixedCommentAdapter", "replace cityName: result = " + r105);
    L27:
        r116 = "";
    L29:
        r103.add(TuplesKt.to(1, r105));
        goto L14
    L30:
        ((ArrayList) this.f135047a).clear();
        int r117 = 0;
    L31:
        if (r117 >= 2) goto L33;
        ((ArrayList) this.f135047a).add(TuplesKt.to(2, ""));
        r117 = r117 + 1;
        goto L31
    L33:
        ((ArrayList) this.f135047a).addAll(r103);
        int r118 = 0;
    L34:
        if (r118 >= 2) goto L36;
        ((ArrayList) this.f135047a).add(TuplesKt.to(2, ""));
        r118 = r118 + 1;
    L36:
        String r119 = r115.textSelectedColor;
        if (r119 != null) goto L39;
    L44:
        String r120 = r115.textDefaultColor;
        if (r120 != null) goto L47;
        return;
    L47:
        if (r120.length() <= 0) goto L49;
        r101 = true;
    L49:
        if (r101 != true) goto L62;
        this.f135050d = ColorProtector.parseColor(r115.textDefaultColor);
        return;
    L62:
        return;
    L39:
        if (r119.length() <= 0) goto L41;
        boolean r121 = true;
    L42:
        if (r121 != true) goto L44;
        this.f135051e = ColorProtector.parseColor(r115.textSelectedColor);
        goto L44
    L41:
        r121 = false;
        goto L42
    L60:
        return;
    L59:
        return;
    L58:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        OGCFixedCommentViewHolder r102 = (OGCFixedCommentViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Pair r103 = (Pair) ListProtector.get(this.f135047a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "text");
        r102.f135055a = ((Number) r103.getFirst()).intValue();
        r102.T3(false);
        int r104 = r102.f135055a;
        if (r104 != 1) goto L5;
        View r105 = (View) r102.f135056b.getValue();
        if (r105 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r105);
    L16:
        View r106 = (View) r102.f135056b.getValue();
        if (r106 == null) goto L19;
        r106.setClickable(true);
    L19:
        TextView r107 = (TextView) r102.f135059e.getValue();
        if (r107 == null) goto L25;
        r107.setText((CharSequence) r103.getSecond());
        return;
    L25:
        return;
    L5:
        if (r104 != 2) goto L26;
        View r108 = (View) r102.f135056b.getValue();
        if (r108 == null) goto L10;
        UtilityKotlinExtentionsKt.u(r108);
    L10:
        View r109 = (View) r102.f135056b.getValue();
        if (r109 == null) goto L23;
        r109.setClickable(false);
        return;
    L23:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_ogc_fixed_comment_item, r100, false);
        if (PadConfigUtils.c() == false) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = s1.f(65.0f);
        r101.setLayoutParams(r102);
    L5:
        OGCFixedCommentViewHolder r103 = new OGCFixedCommentViewHolder(r101, (py.k) this.f135048b.getValue(), (py.k) this.f135049c.getValue(), Integer.valueOf(this.f135050d), Integer.valueOf(this.f135051e));
        r103.itemView.setOnClickListener(new g(this, r103));
        return r103;
    }
}
