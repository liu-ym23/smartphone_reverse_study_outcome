package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.d.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Objects;

/* JADX INFO: compiled from: OSegmentTabMiniView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSegmentTabMiniView extends OTouchAnimView {
    public static final a Companion = null;
    private static Typeface DEFAULT_TYPE_FACE;
    private static Typeface SELECTED_TYPE_FACE;
    private static int instanceId;
    private final String TAG;
    private ImageView iconView;
    private int originIconAlpha;
    private boolean selectState;
    private TextView tabTitle;
    private int textSelectColor;
    private int textUnselectColor;

    /* JADX INFO: compiled from: OSegmentTabMiniView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final OSegmentTabMiniView a(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            View r5 = RelativeLayout.inflate(r3, ZeusTransformUtils.mapRes(R.layout.o_layout_tab_segment_small, "layout", "o_layout_tab_segment_small"), null);
            Objects.requireNonNull(r5, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OSegmentTabMiniView");
            OSegmentTabMiniView r6 = (OSegmentTabMiniView) ZeusTransformUtils.preCheckCast(r5, OSegmentTabMiniView.class, "com.obric.aiagent.plugin");
            r6.initView();
            return r6;
        }

        public final Typeface a(Typeface r2, int r3) {
            o.e(r2, "typeface");
            if (OSegmentTabMiniView.access$getSELECTED_TYPE_FACE$cp() != null) goto L8;
            if (Build.VERSION.SDK_INT < 28) goto L8;
            OSegmentTabMiniView.access$setSELECTED_TYPE_FACE$cp(Typeface.create(r2, r3, false));
        L8:
            return OSegmentTabMiniView.access$getSELECTED_TYPE_FACE$cp();
        }
    }

    static {
        Companion = new a(null);
    }

    public OSegmentTabMiniView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSegmentTabMiniView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OSegmentTabMiniView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ Typeface access$getSELECTED_TYPE_FACE$cp() {
        return SELECTED_TYPE_FACE;
    }

    public static final /* synthetic */ void access$setSELECTED_TYPE_FACE$cp(Typeface r0) {
        SELECTED_TYPE_FACE = r0;
    }

    public OSegmentTabMiniView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        int r8 = instanceId;
        instanceId = r8 + 1;
        this.TAG = o.a("OSegmentTabView_", Integer.valueOf(r8));
    }

    public final void initView() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_tab_title_small, DbHelper.COL_ID, "tv_tab_title_small"));
        o.c(r0, "findViewById(R.id.tv_tab_title_small)");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.aiagent.plugin");
        this.tabTitle = r1;
        if (r1 != null) goto L5;
        o.c("tabTitle");
        r1 = null;
    L5:
        Typeface r2 = r1.getTypeface();
        o.c(r2, "tabTitle.typeface");
        DEFAULT_TYPE_FACE = r2;
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_tab_icon_small, DbHelper.COL_ID, "tv_tab_icon_small"));
        o.c(r3, "findViewById(R.id.tv_tab_icon_small)");
        this.iconView = (ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin");
    }

    public final void setOriginTextColor(int r1, int r2) {
        this.textSelectColor = r1;
        this.textUnselectColor = r2;
    }

    public final void setOriginIconAlpha(int r1) {
        this.originIconAlpha = r1;
    }

    public final void updateSelectState(boolean r4) {
        b.b(this.TAG, o.a("updateSelectState, isSelected: ", Boolean.valueOf(r4)));
        this.selectState = r4;
        setSelected(r4);
        updateTextColor(r4);
        updateIconAlpha(r4);
    }

    private final void updateTextColor(boolean r3) {
        TextView r0 = null;
        if (r3 == true) goto L5;
        cancelAnim();
        TextView r4 = this.tabTitle;
        if (r4 != null) goto L15;
        o.c("tabTitle");
    L16:
        r0.setTextColor(this.textUnselectColor);
        return;
    L15:
        r0 = r4;
        goto L16
    L5:
        if (isAnimRunning() == true) goto L19;
        TextView r5 = this.tabTitle;
        if (r5 != null) goto L10;
        o.c("tabTitle");
    L11:
        r0.setTextColor(this.textSelectColor);
        return;
    L10:
        r0 = r5;
        goto L11
    }

    private final void updateIconAlpha(boolean r3) {
        ImageView r0 = null;
        if (r3 == true) goto L5;
        cancelAnim();
        ImageView r4 = this.iconView;
        if (r4 != null) goto L15;
        o.c("iconView");
    L16:
        r0.setImageAlpha(this.originIconAlpha);
        return;
    L15:
        r0 = r4;
        goto L16
    L5:
        if (isAnimRunning() == true) goto L19;
        ImageView r5 = this.iconView;
        if (r5 != null) goto L10;
        o.c("iconView");
    L11:
        r0.setImageAlpha(this.originIconAlpha);
        return;
    L10:
        r0 = r5;
        goto L11
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean canPerFormAnim() {
        return !this.selectState;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void onTouchAnimUpdate(float r4, String r5) {
        o.e(r5, DBHelper.BATTERY_COL_SCENE);
        b.b(this.TAG, "onTouchAnimUpdate, scene: " + r5 + ", animFraction: " + r4);
        updateTextAppearanceOnPress(r4, r5);
        updateIconAlphaOnPress(r4, r5);
    }

    private final void updateTextAppearanceOnPress(float r9, String r10) {
        boolean r1 = false;
        if (o.a(r10, OTouchAnimView.PRESS_ANIM_SCENE_PRESS) == false) goto L6;
        int r0 = this.textUnselectColor;
    L12:
        if (r0 != 0) goto L14;
        return;
    L14:
        int r2 = (r0 >> 24) & 255;
        int r3 = n.a((int) (r2 * OTouchAnimView.Companion.a(r9)), 0, 255);
        int r4 = ((r0 >> 16) & 255) << 16;
        int r5 = (r0 & 255) | ((r4 | (r3 << 24)) | (((r0 >> 8) & 255) << 8));
        TextView r6 = this.tabTitle;
        Typeface r7 = null;
        if (r6 != null) goto L17;
        o.c("tabTitle");
        r6 = null;
    L17:
        r6.setTextColor(r5);
        TextView r8 = this.tabTitle;
        if (r8 != null) goto L21;
        o.c("tabTitle");
        r8 = null;
    L21:
        if (this.selectState == true) goto L23;
    L31:
        Typeface r11 = DEFAULT_TYPE_FACE;
        if (r11 != null) goto L34;
        o.c("DEFAULT_TYPE_FACE");
    L35:
        r8.setTypeface(r7);
        b.b(this.TAG, "updateTextColorOnPress, scene: " + r10 + ", fraction: " + r9 + ", newTextAlpha: " + r3 + ", originTextAlpha: " + r2);
        return;
    L34:
        r7 = r11;
        goto L35
    L23:
        if (r9 != 0.0f) goto L25;
        r1 = true;
    L25:
        if (r1 == false) goto L31;
        a r12 = Companion;
        Typeface r13 = DEFAULT_TYPE_FACE;
        if (r13 != null) goto L29;
        o.c("DEFAULT_TYPE_FACE");
    L30:
        r7 = r12.a(r7, 500);
        goto L35
    L29:
        r7 = r13;
        goto L30
    L6:
        if (o.a(r10, OTouchAnimView.PRESS_ANIM_SCENE_RELEASE) == true) goto L8;
        r0 = 0;
        goto L12
    L8:
        if (this.selectState == false) goto L10;
        r0 = this.textSelectColor;
        goto L12
    L10:
        r0 = this.textUnselectColor;
        goto L12
    }

    private final void updateIconAlphaOnPress(float r5, String r6) {
        int r0 = n.a((int) (this.originIconAlpha * OTouchAnimView.Companion.a(r5)), 0, 255);
        ImageView r1 = this.iconView;
        if (r1 != null) goto L5;
        o.c("iconView");
        r1 = null;
    L5:
        r1.setImageAlpha(r0);
        b.b(this.TAG, "updateIconAlphaOnPress, scene: " + r6 + ", fraction: " + r5 + ", alpha: " + r0 + ", originIconAlpha: " + this.originIconAlpha);
    }
}
