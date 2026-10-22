package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/SelectLabelView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "<set-?>", "d", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "getLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "label", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectLabelView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f140598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f140599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f140600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomIntroLabel f140601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f140602e;

    public static final class a {
    }

    static {
    }

    public SelectLabelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SelectLabelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final RoomIntroLabel getLabel() {
        return this.f140601d;
    }

    public final void a(boolean r100) {
        this.f140602e = r100;
        Drawable r101 = null;
        if (r100 == false) goto L32;
        ImageView r102 = this.f140599b;
        if (r102 == null) goto L7;
        a1.p(r102, UtilityKotlinExtentionsKt.i(14));
    L7:
        ImageView r103 = this.f140599b;
        if (r103 == null) goto L10;
        a1.k(r103, UtilityKotlinExtentionsKt.i(14));
    L10:
        ImageView r104 = this.f140599b;
        if (r104 == null) goto L13;
        r104.setImageResource(R.drawable.ttlive_broadcast_tag_selected_icon);
    L13:
        TextView r105 = this.f140600c;
        if (r105 == null) goto L16;
        r105.setTextColor(s1.h(R.color.ttlive_label_select_dialog_selected_text));
    L16:
        View r106 = this.f140598a;
        if (r106 == null) goto L19;
        Drawable r107 = r106.getBackground();
    L21:
        if ((r107 instanceof GradientDrawable) == false) goto L24;
        r101 = r107;
    L24:
        GradientDrawable r108 = (GradientDrawable) r101;
        if (r108 == null) goto L27;
        r108.mutate();
    L27:
        if (r108 == null) goto L29;
        r108.setColor(s1.h(R.color.ttlive_label_select_dialog_selected_bg));
    L29:
        View r109 = this.f140598a;
        if (r109 == null) goto L61;
        r109.setBackground(r108);
        return;
    L61:
        return;
    L19:
        r107 = null;
        goto L21
    L32:
        ImageView r110 = this.f140599b;
        if (r110 == null) goto L35;
        a1.p(r110, UtilityKotlinExtentionsKt.i(12));
    L35:
        ImageView r111 = this.f140599b;
        if (r111 == null) goto L38;
        a1.k(r111, UtilityKotlinExtentionsKt.i(12));
    L38:
        ImageView r112 = this.f140599b;
        if (r112 == null) goto L41;
        r112.setImageResource(R.drawable.ttlive_broadcast_tag_add_v2);
    L41:
        TextView r113 = this.f140600c;
        if (r113 == null) goto L44;
        r113.setTextColor(s1.h(R.color.ttlive_label_select_dialog_select_text));
    L44:
        View r114 = this.f140598a;
        if (r114 == null) goto L47;
        Drawable r115 = r114.getBackground();
    L49:
        if ((r115 instanceof GradientDrawable) == false) goto L52;
        r101 = r115;
    L52:
        GradientDrawable r116 = (GradientDrawable) r101;
        if (r116 == null) goto L55;
        r116.mutate();
    L55:
        if (r116 == null) goto L57;
        r116.setColor(s1.h(R.color.ttlive_label_select_dialog_select_bg));
    L57:
        View r117 = this.f140598a;
        if (r117 == null) goto L63;
        r117.setBackground(r116);
        return;
    L63:
        return;
    L47:
        r115 = null;
        goto L49
    }

    public SelectLabelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_select_label_item, this, true);
        this.f140598a = findViewById(R.id.item_root);
        this.f140599b = (ImageView) findViewById(R.id.item_icon);
        this.f140600c = (TextView) findViewById(R.id.item_text);
    }

    public /* synthetic */ SelectLabelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
