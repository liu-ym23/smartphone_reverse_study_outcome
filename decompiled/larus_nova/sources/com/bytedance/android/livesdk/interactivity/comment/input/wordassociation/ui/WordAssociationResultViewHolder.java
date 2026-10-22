package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c32.c;
import c32.d;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils.WordAssociationAppLogger;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/wordassociation/ui/WordAssociationResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WordAssociationResultViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f135212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f135213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f135214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MultiTypeAdapter f135215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayoutManager f135216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f135217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f135218g;

    public WordAssociationResultViewHolder(View r100, g r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f135217f = r101;
        this.f135218g = r102;
        this.f135212a = (TextView) r100.findViewById(R.id.tv_association);
        this.f135213b = (LinearLayout) r100.findViewById(R.id.fusion_emoji_container);
        this.f135214c = (RecyclerView) r100.findViewById(R.id.fusion_list);
        this.f135215d = new MultiTypeAdapter();
        this.f135216e = new LinearLayoutManager(r100.getContext(), 0, false);
    }

    public static final void T3(WordAssociationResultViewHolder r210, Context r211, d r212, String r213, g r214) {
        r210.getClass();
        int r100 = r212.actionType;
        boolean r101 = false;
        if (r100 != 1) goto L5;
        WordAssociationAppLogger.d(r212, r212.a(), r213, r212.f22268b, r212.f22269c, r210.f135218g);
        String r102 = r212.schemaUrl;
        if (r102 != null) goto L39;
    L40:
        r101 = true;
    L41:
        if (r101 == true) goto L43;
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(r211, r212.schemaUrl);
    L43:
        if (r214 == null) goto L59;
        h r103 = i.b(null, 3);
        if ((r103 instanceof InteractivityPlatformContext) == true) goto L47;
        r103 = null;
    L47:
        InteractivityPlatformContext r104 = (InteractivityPlatformContext) r103;
        if (r104 == null) goto L52;
        n<c> r105 = r104.getWordAssociateResult();
        if (r105 == null) goto L52;
        r105.setValue(null);
    L52:
        r214.J();
        return;
    L59:
        return;
    L39:
        if (r102.length() != 0) goto L41;
    L5:
        if (r100 != 2) goto L60;
        WordAssociationAppLogger.d(r212, r212.a(), r213, r212.f22268b, r212.f22269c, r210.f135218g);
        Map<String, String> r106 = r212.extraMap;
        if (r106 == null) goto L54;
        String r107 = r106.get("emoji_id");
        if (r107 == null) goto L55;
        Long r108 = StringsKt.toLongOrNull(r107);
        if (r108 == null) goto L56;
        long r110 = r108.longValue();
        Map<String, String> r109 = r212.extraMap;
        if (r109 == null) goto L20;
        String r111 = r109.get("emoji_scale");
        if (r111 == null) goto L20;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L20;
        int r113 = r112.intValue();
    L21:
        HashMap r114 = new HashMap();
        r114.put("is_word_to_vipemoji", "1");
        r114.put("message_source", "association");
        xs2.b r115 = xs2.b.a();
        ISendCommentEvent.Sender r116 = ISendCommentEvent.Sender.SubscribeJSB;
        HashMap r117 = new HashMap();
        if (r214 == null) goto L24;
        CommentFlowContext r118 = r214.S();
    L25:
        r115.post(new c0(r110, r113, false, r116, r117, r118, r114));
        if (r214 == null) goto L57;
        h r119 = i.b(null, 3);
        if ((r119 instanceof InteractivityPlatformContext) == true) goto L30;
        r119 = null;
    L30:
        InteractivityPlatformContext r120 = (InteractivityPlatformContext) r119;
        if (r120 == null) goto L35;
        n<c> r121 = r120.getWordAssociateResult();
        if (r121 == null) goto L35;
        r121.setValue(null);
    L35:
        r214.J();
        return;
    L57:
        return;
    L24:
        r118 = null;
    L20:
        r113 = 0;
        goto L21
    L56:
        return;
    L55:
        return;
    L54:
        return;
    }
}
