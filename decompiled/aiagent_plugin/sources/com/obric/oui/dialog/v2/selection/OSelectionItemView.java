package com.obric.oui.dialog.v2.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.g;
import com.obric.oui.d.c;
import com.obric.oui.dialog.v2.common.ODialogListItemView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: OSelectionItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSelectionItemView extends ODialogListItemView {
    public static final a Companion = null;
    private static final String TAG = "OSelectionItemView";

    /* JADX INFO: compiled from: OSelectionItemView.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.dialog.v2.selection.OSelectionItemView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OSelectionItemView.kt */
        public static final enum EnumC0953a extends Enum<EnumC0953a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0953a f35229a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0953a f35230b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0953a f35231c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0953a[] f35232d = null;

            private static final /* synthetic */ EnumC0953a[] a() {
                return new EnumC0953a[]{f35229a, f35230b, f35231c};
            }

            public static EnumC0953a valueOf(String r2) {
                return (EnumC0953a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0953a.class, r2), EnumC0953a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0953a[] values() {
                return (EnumC0953a[]) ZeusTransformUtils.preCheckCast(f35232d.clone(), EnumC0953a[].class, "com.obric.aiagent.plugin");
            }

            private EnumC0953a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f35229a = new EnumC0953a("NONE", 0);
                f35230b = new EnumC0953a("ICON", 1);
                f35231c = new EnumC0953a("CHECKBOX", 2);
                f35232d = a();
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSelectionItemView.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35233a = null;

        static {
            int[] r0 = new int[a.EnumC0953a.values().length];
            r0[a.EnumC0953a.f35230b.ordinal()] = 1;
            r0[a.EnumC0953a.f35231c.ordinal()] = 2;
            r0[a.EnumC0953a.f35229a.ordinal()] = 3;
            f35233a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public /* synthetic */ OSelectionItemView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public OSelectionItemView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setCheckStyle(a.EnumC0953a.f35229a);
        showDivider(true);
    }

    public final void setCheckStyle(a.EnumC0953a r7) {
        o.e(r7, "style");
        int r8 = b.f35233a[r7.ordinal()];
        ImageView r1 = null;
        if (r8 != 1) goto L5;
        ImageView r9 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r9.setImageDrawable(androidx.core.content.b.h.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.oui_select_list_item_checker, "drawable", "oui_select_list_item_checker"), null));
        r1 = r9;
    L13:
        if (r1 == null) goto L15;
        FrameLayout r10 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r10.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), new ViewGroup.LayoutParams(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 32), -2));
        return;
    L15:
        getTrailingContainer().setVisibility(8);
        return;
    L5:
        if (r8 != 2) goto L7;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        r1 = (ImageView) ZeusTransformUtils.preCheckCast(new OCheckBox(r2), ImageView.class, "com.obric.aiagent.plugin");
        goto L13
    L7:
        if (r8 == 3) goto L13;
        throw new k();
    }

    public final void setChecked(boolean r3) {
        View r2 = getCheckMark();
        if (ZeusTransformUtils.instanceOf(r2, OCheckBox.class) == false) goto L6;
        ((OCheckBox) ZeusTransformUtils.preCheckCast(r2, OCheckBox.class, "com.obric.aiagent.plugin")).setChecked(r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ImageView.class) == false) goto L12;
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.aiagent.plugin");
        if (r3 == false) goto L10;
        int r5 = 0;
    L11:
        r4.setVisibility(r5);
        return;
    L10:
        r5 = 4;
        goto L11
    L12:
        com.obric.oui.d.a.b.b(TAG, "checkMark is not OCheckBox or ImageView");
    }

    public final void toggleCheckState() {
        setChecked(!isChecked());
    }

    public final boolean isChecked() {
        View r3 = getCheckMark();
        if (ZeusTransformUtils.instanceOf(r3, OCheckBox.class) == false) goto L6;
        return ((OCheckBox) ZeusTransformUtils.preCheckCast(r3, OCheckBox.class, "com.obric.aiagent.plugin")).isChecked();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ImageView.class) == true) goto L8;
        return false;
    L8:
        if (((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L13;
        return true;
    L13:
        return false;
    }

    private final View getCheckMark() {
        c r0 = c.f35012a;
        View r4 = getTrailingContainer().getChildAt(0);
        if (r4 != null) goto L6;
    L4:
        r4 = null;
    L7:
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.getChildAt(0);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L4;
        goto L4
    }
}
