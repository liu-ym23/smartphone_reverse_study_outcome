package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.android.livesdkapi.view.SaasLiveCircleView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/view/SimpleLiveView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class SimpleLiveView extends RelativeLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f124256g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f124257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f124258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f124259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f124260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f124261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f124262f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleLiveView f124263a;

        public b(SimpleLiveView r100) {
            this.f124263a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SimpleLiveView r100 = this.f124263a;     // Catch: Throwable -> L4
            SimpleLiveView.b(r100, r100.f124260d, ((HSImageView) r100.a(R.id.iv_content_label)).getMeasuredWidth());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public SimpleLiveView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimpleLiveView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f124262f != null) goto L5;
        this.f124262f = new HashMap();
    L5:
        View r101 = (View) this.f124262f.get(Integer.valueOf(r100));
        if (r101 != null) goto L9;
        View r102 = findViewById(r100);
        this.f124262f.put(Integer.valueOf(r100), r102);
        return r102;
    L9:
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f124259c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f124259c = false;
        removeCallbacks(new b(this));
    }

    public SimpleLiveView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f124258b = "unknown";
        this.f124261e = "";
        View.inflate(getContext(), R.layout.ttlive_feed_item_simple_live, this);
    }

    public static final void b(SimpleLiveView r100, boolean r101, int r102) {
        if (r100.f124259c == false) goto L11;
        int r103 = ((RelativeLayout) r100.a(R.id.view_name_container)).getMeasuredWidth();
        if (r101 == false) goto L8;
        ((TextView) r100.a(R.id.tv_anchor_name)).setMaxWidth((r103 - r102) - LiveResUtil.dp2Px(8.0f));
        return;
    L8:
        ((TextView) r100.a(R.id.tv_anchor_name)).setMaxWidth(r103);
        return;
    }

    public /* synthetic */ SimpleLiveView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void c(User r100, ImageModel r101, String r102, long r103, String r110, LiveCoverConfig r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((TextView) a(R.id.tv_anchor_name)).setText(r100.getNickName());
        if (r100.getAvatarThumb() != null) goto L7;
        ((HSImageView) a(R.id.iv_avatar)).setBackground(getContext().getResources().getDrawable(R.drawable.ttlive_img_avatar_empty));
    L9:
        if (r101 == null) goto L14;
        if (r111 != null) goto L12;
    L13:
        this.f124260d = true;
        UIUtils.setViewVisibility((HSImageView) a(R.id.iv_content_label), 0);
        ImageLoader.d r104 = ImageLoader.load(r101);
        r104.f66060e = new h(this);
        r104.a((HSImageView) a(R.id.iv_content_label));
    L15:
        if (r111 != null) goto L17;
    L31:
        ((TextView) a(R.id.tv_room_title)).setText(r102);
        if (r111 != null) goto L34;
    L42:
        ((TextView) a(R.id.tv_audience_count)).setText(getContext().getString(R.string.ttlive_feed_people, new Object[]{r110}));
        setOnClickListener(new j(this));
        return;
    L34:
        if ((r111 instanceof mw1.b) == false) goto L42;
        if (((mw1.b) r111).f515914f == false) goto L41;
        ((TextView) a(R.id.tv_rank_num)).setText(String.valueOf(r103));
        ((TextView) a(R.id.tv_rank_num)).setVisibility(0);
        if (r103 >= 4) goto L40;
        ((TextView) a(R.id.tv_rank_num)).setTextColor(LiveResUtil.getColor(R.color.ttlive_feed_open_d2_71));
        goto L42
    L40:
        ((TextView) a(R.id.tv_rank_num)).setTextColor(LiveResUtil.getColor(R.color.ttlive_feed_open_d2_72));
        goto L42
    L41:
        ((TextView) a(R.id.tv_rank_num)).setVisibility(8);
        goto L42
    L17:
        if ((r111 instanceof mw1.b) == false) goto L31;
        if ((((LinearLayout) a(R.id.live_tag_layout)).getBackground() instanceof GradientDrawable) == false) goto L28;
        Drawable r105 = ((LinearLayout) a(R.id.live_tag_layout)).getBackground();
        if (r105 == null) goto L26;
        GradientDrawable r106 = (GradientDrawable) r105;
        Integer r107 = ((mw1.b) r111).f515909a;
        if (r107 == null) goto L28;
        int r108 = r107.intValue();
        r106.setColor(r108);
        ((SaasLiveCircleView) a(R.id.iv_live_circle)).setColors(r108, r108);
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L28:
        if (((mw1.b) r111).f515915g == false) goto L30;
        UtilityKotlinExtentionsKt.z(a(R.id.iv_douyin_label), true);
        ((LinearLayout) a(R.id.live_tag_layout)).getLayoutParams().width = LiveResUtil.getDimension(R.dimen.ttlive_feed_douyin_label_layout_width);
        goto L31
    L30:
        UtilityKotlinExtentionsKt.z(a(R.id.iv_douyin_label), false);
        ((LinearLayout) a(R.id.live_tag_layout)).getLayoutParams().width = LiveResUtil.getDimension(R.dimen.ttlive_feed_none_douyin_label_layout_width);
        goto L31
    L12:
        if (r111.getEnableContentLabel() == true) goto L13;
    L14:
        this.f124260d = false;
        UIUtils.setViewVisibility((HSImageView) a(R.id.iv_content_label), 8);
        post(new i(this));
        goto L15
    L7:
        a1.x((HSImageView) a(R.id.iv_avatar), r100.getAvatarThumb(), ((HSImageView) a(R.id.iv_avatar)).getWidth(), ((HSImageView) a(R.id.iv_avatar)).getHeight(), R.drawable.ttlive_img_avatar_empty);
        goto L9
    }
}
