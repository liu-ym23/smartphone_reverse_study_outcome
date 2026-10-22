package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/view/BaseEnterView;", "Landroid/widget/LinearLayout;", "", "getLayoutResource", "Lcom/bytedance/android/livesdk/interactivity/enteranim/view/e;", "listener", "", "setDrawingCacheListener", "Lk32/a;", "msg", "setUI", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseEnterView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f136805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NoMoreSpaceTextView f136806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f136807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f136808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f136809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f136810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f136811g;

    public static final class a implements ImageUtil.LoadImageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseEnterView f136812a;

        @Override // com.bytedance.android.live.core.utils.ImageUtil.LoadImageCallback
        public final void onFailed(Exception r100) {
        }

        public a(BaseEnterView r100) {
            this.f136812a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.ImageUtil.LoadImageCallback
        public final void onSuccess(Bitmap r100) {
            if (r100 == null) goto L10;
            HSImageView r101 = this.f136812a.f136805a;
            if (r101 == null) goto L6;
            r101.setImageBitmap(r100);
        L6:
            this.f136812a.invalidate();
            BaseEnterView r102 = this.f136812a;
            e r103 = r102.f136811g;
            if (r103 == null) goto L11;
            ((UserEnterLevelView) r103).e(r102);
            return;
        L11:
            return;
        }
    }

    public BaseEnterView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseEnterView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getLayoutResource() {
        return R.layout.ttlive_view_base_enter;
    }

    public final void setDrawingCacheListener(e r100) {
        this.f136811g = r100;
    }

    public final void setUI(k32.a r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.f501691h;
        String r102 = r100.f501685b;
        TextView r103 = this.f136807c;
        if (r103 == null) goto L6;
        r103.setText(r102);
    L6:
        if (r101 == 2) goto L16;
        TextView r104 = this.f136808d;
        if (r104 == null) goto L10;
        r104.setText(R.string.ttlive_entry_description_level_mid);
    L10:
        TextView r105 = this.f136807c;
        if (r105 == null) goto L13;
        r105.setTextColor(getResources().getColor(R.color.ttlive_user_enter_text_color_normal));
    L13:
        TextView r106 = this.f136808d;
        if (r106 == null) goto L26;
        r106.setTextColor(getResources().getColor(R.color.ttlive_user_enter_text_color_normal));
    L26:
        if (r101 == 0) goto L40;
        if (r101 == 2) goto L34;
        View r107 = this.f136810f;
        if (r107 == null) goto L31;
        r107.setBackgroundResource(R.drawable.ttlive_bg_user_entry_level_mid);
    L31:
        ImageView r108 = this.f136809e;
        if (r108 == null) goto L46;
        r108.setBackgroundResource(R.drawable.ttlive_ic_star_white);
    L46:
        HSImageView r109 = this.f136805a;
        if (r109 == null) goto L49;
        r109.setVisibility(0);
    L49:
        NoMoreSpaceTextView r110 = this.f136806b;
        if (r110 == null) goto L52;
        r110.setVisibility(8);
    L52:
        if (r101 != 0) goto L56;
        HSImageView r111 = this.f136805a;
        if (r111 == null) goto L58;
        r111.setBackgroundResource(R.drawable.ttlive_ic_user_entry_top_10_cn);
        return;
    L58:
        return;
    L56:
        ImageLoader.loadBitmapSynchronized(r100.f501690g, 0, 0, new a(this));
        return;
    L34:
        View r112 = this.f136810f;
        if (r112 == null) goto L37;
        r112.setBackgroundResource(R.drawable.ttlive_bg_user_entry_level_high);
    L37:
        ImageView r113 = this.f136809e;
        if (r113 == null) goto L46;
        r113.setBackgroundResource(R.drawable.ttlive_ic_star_gold);
        goto L46
    L40:
        View r114 = this.f136810f;
        if (r114 == null) goto L43;
        r114.setBackgroundResource(R.drawable.ttlive_bg_user_entry_level_top);
    L43:
        ImageView r115 = this.f136809e;
        if (r115 == null) goto L46;
        r115.setBackgroundResource(R.drawable.ttlive_ic_star_white);
        goto L46
    L16:
        TextView r116 = this.f136808d;
        if (r116 == null) goto L19;
        r116.setText(R.string.ttlive_entry_description_level_high);
    L19:
        TextView r117 = this.f136807c;
        if (r117 == null) goto L22;
        r117.setTextColor(getResources().getColor(R.color.ttlive_user_enter_text_color_gold));
    L22:
        TextView r118 = this.f136808d;
        if (r118 == null) goto L26;
        r118.setTextColor(getResources().getColor(R.color.ttlive_user_enter_text_color_gold));
        goto L26
    }

    public BaseEnterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(getLayoutResource(), this);
        this.f136810f = findViewById(R.id.base_enter_body);
        this.f136806b = (NoMoreSpaceTextView) findViewById(R.id.badge_list_spannable);
        this.f136805a = (HSImageView) findViewById(R.id.honor_iv);
        this.f136807c = (TextView) findViewById(R.id.user_name_tv);
        this.f136808d = (TextView) findViewById(R.id.description_tv);
        this.f136809e = (ImageView) findViewById(R.id.star_iv);
    }

    public /* synthetic */ BaseEnterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
