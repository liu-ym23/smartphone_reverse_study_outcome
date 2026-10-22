package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkTagsContainerView;", "Landroid/widget/LinearLayout;", "", "d", "Z", "isOldTag", "()Z", "setOldTag", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkTagsContainerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IRoom f97013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f97014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f97015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f97016d;

    public static final class a {
    }

    static {
    }

    public PkTagsContainerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PkTagsContainerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static int c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getWidth() != 0) goto L7;
        r100.measure(0, 0);
        return r100.getMeasuredWidth();
    L7:
        return r100.getWidth();
    }

    public final void setOldTag(boolean r100) {
        this.f97016d = r100;
    }

    public final void a(List r100, IRoom r101) {
        Intrinsics.checkNotNullParameter("invited_window", "showFrom");
        removeAllViews();
        this.f97013a = r101;
        if (r100 == null) goto L8;
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        View r103 = b((IBattleRivalTag) r102.next(), false, false);
        ((TextView) r103.findViewById(R.id.tv_tag)).setTextSize(9);
        addView(r103);
        goto L6
    L10:
        return;
    }

    public PkTagsContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_item_pk_tags_container, this);
        setGravity(8388627);
    }

    public final View b(IBattleRivalTag r100, boolean r110, boolean r111) {
        if (r110 == true) goto L5;
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_interact_pk_user_tag, this, false);
    L7:
        if (a1.j(r100.getIconImage()) == false) goto L11;
        ((HSImageView) r101.findViewById(R.id.ic_tag)).setVisibility(0);
        ImageUtil.loadImage((ImageView) r101.findViewById(R.id.ic_tag), r100.getIconImage(), 0);
        if (this.f97016d == false) goto L13;
        ViewGroup.LayoutParams r102 = ((HSImageView) r101.findViewById(R.id.ic_tag)).getLayoutParams();
        r102.width = s1.f(8.0f);
        ViewGroup.LayoutParams r103 = ((HSImageView) r101.findViewById(R.id.ic_tag)).getLayoutParams();
        r103.height = s1.f(10.0f);
    L13:
        if (r100.getContent() == null) goto L34;
        ((TextView) r101.findViewById(R.id.tv_tag)).setVisibility(0);
        ((TextView) r101.findViewById(R.id.tv_tag)).setText(r100.getContent());
    L34:
        ((TextView) r101.findViewById(R.id.tv_tag)).setTextColor(Color.parseColor(r100.getFontColor()));     // Catch: Throwable -> L17
    L19:
        if (r111 == false) goto L22;
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setBackgroundResource(R.drawable.ttlive_pk_user_tag_background_default);
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setPadding(s1.f(3.0f), 0, s1.f(4.0f), 0);
        ((TextView) r101.findViewById(R.id.tv_tag)).setTextColor(ColorProtector.parseColor("#80FFFFFF"));
        ((HSImageView) r101.findViewById(R.id.ic_tag)).setVisibility(8);
    L33:
        return r101;
    L22:
        if (a1.j(r100.getBackgroundImage()) == false) goto L32;
        View r112 = r101.findViewById(R.id.tag_container);
        r112.post(new s(r100.getBackgroundImage(), r112));
        if (a1.j(r100.getIconImage()) == false) goto L31;
        if (r110 == true) goto L28;
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setPadding(0, 0, s1.f(4.0f), 0);
    L28:
        if (this.f97016d == false) goto L33;
        if (r110 == true) goto L33;
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setPadding(s1.f(4.0f), 0, s1.f(4.0f), 0);
        goto L33
    L31:
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setPadding(s1.f(3.0f), 0, s1.f(4.0f), 0);
        goto L33
    L32:
        ((LinearLayout) r101.findViewById(R.id.tag_container)).setPadding(0, 0, 0, 0);
        goto L33
    L11:
        ((HSImageView) r101.findViewById(R.id.ic_tag)).setVisibility(8);
        goto L13
    L5:
        r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_interact_link_user_tag, this, false);
        goto L7
    }

    public final void d(IBattleRivalTag r100, int r101, boolean r102) {
        View r103 = b(r100, false, r102);
        ((TextView) r103.findViewById(R.id.tv_tag)).setTextSize(r101);
        if ((c(r103) + s1.f(4.0f)) >= this.f97014b) goto L6;
        addView(r103);
        this.f97014b -= c(r103) + s1.f(4.0f);
        return;
    }

    public /* synthetic */ PkTagsContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void g(List r100, List r101, IRoom r102, Function1 r103) {
        Intrinsics.checkNotNullParameter("record_banner", "showFrom");
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return;
    L6:
        this.f97013a = r102;
        removeAllViews();
        int r104 = 0;
        if (r100 == null) goto L13;
        Iterator r105 = r100.iterator();
        int r106 = 0;
    L10:
        if (r105.hasNext() == false) goto L12;
        View r107 = b((IBattleRivalTag) r105.next(), false, false);
        ((TextView) r107.findViewById(R.id.tv_tag)).setTextSize(9);
        addView(r107);
        r106 = r106 + (c(r107) + s1.f(4.0f));
        goto L10
    L12:
        r104 = r106;
    L13:
        if (r101 == null) goto L28;
        Iterator r108 = r101.iterator();
    L16:
        if (r108.hasNext() == false) goto L28;
        View r109 = (View) r108.next();
        ViewParent r110 = r109.getParent();
        if ((r110 instanceof ViewGroup) == true) goto L20;
        r110 = null;
    L20:
        ViewGroup r111 = (ViewGroup) r110;
        if (r111 == null) goto L23;
        r111.removeView(r109);
    L23:
        addView(r109);
        int r112 = r109.getLayoutParams().width;
        if (r112 > 0) goto L27;
        r112 = c(r109);
    L27:
        r104 = r104 + (r112 + s1.f(4.0f));
    L28:
        if (r103 == null) goto L35;
        Unit r113 = (Unit) r103.invoke(Integer.valueOf(r104));
        return;
    }

    public final void e(List r100, IRoom r101, int r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "showFrom");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f97013a = r101;
        removeAllViews();
        int r105 = this.f97015c;
        if (r105 != 0) goto L8;
        post(new t(this, r100, r102, r104));
        return;
    L8:
        this.f97014b = r105;
        Iterator r106 = r100.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        d((IBattleRivalTag) r106.next(), r102, r104);
        goto L10
    }

    public static /* synthetic */ void f(PkTagsContainerView r100, List r101, boolean r102, IRoom r103, int r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        r103 = null;
    L5:
        IRoom r104 = r103;
        if ((r112 & 8) == 0) goto L8;
        int r105 = 9;
    L10:
        if ((r112 & 16) == 0) goto L12;
        r111 = "";
    L12:
        r100.e(r101, r104, r105, r111, false);
        return;
    L8:
        r105 = r110;
        goto L10
    }
}
