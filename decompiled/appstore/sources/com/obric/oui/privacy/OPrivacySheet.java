package com.obric.oui.privacy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import bg.h;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.DialogExtInterface;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.adapter.PrivacySheetAdapter;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class OPrivacySheet {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f16361f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.privacy.d f16363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OSheet f16364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f16365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OPrivacySheetListener f16366e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends RecyclerView.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OPrivacySheet f16367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f16368b;

        public b(OPrivacySheet r10, PrivacyTopDownAlphaMaskRecyclerView r11) {
            this.f16367a = r10;
            this.f16368b = r11;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
        public void b(Rect r10, View r11, RecyclerView r12, RecyclerView.q r13) {
            q.g(r10, "outRect");
            q.g(r11, "view");
            q.g(r12, "parent");
            q.g(r13, WsConstants.KEY_CONNECTION_STATE);
            int r14 = r12.b0(r11);
            if (r14 <= 0) goto L11;
            e r15 = (e) b0.a0(OPrivacySheet.c(this.f16367a).i(), r14);
            e r16 = (e) b0.a0(OPrivacySheet.c(this.f16367a).i(), r14 - 1);
            if (r15 == null) goto L12;
            if (r16 != null) goto L8;
            return;
        L8:
            if (q.b(u.b(r15.getClass()), u.b(r16.getClass())) == true) goto L14;
            Context r17 = this.f16368b.getContext();
            q.f(r17, "context");
            r10.top = f.b(r17, 16);
            return;
        L14:
            return;
        L12:
            return;
        }
    }

    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OPrivacySheet f16369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OTextView f16371c;

        public c(OPrivacySheet r10, String r11, OTextView r12) {
            this.f16369a = r10;
            this.f16370b = r11;
            this.f16371c = r12;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r10) {
            q.g(r10, "widget");
            OPrivacySheetListener r11 = OPrivacySheet.d(this.f16369a);
            if (r11 == null) goto L7;
            r11.onPrivacyPolicyClicked(this.f16370b);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r10) {
            q.g(r10, "ds");
            super.updateDrawState(r10);
            r10.setColor(ContextCompat.b(this.f16371c.getContext(), R$color.oui_functional_blue_6));
            r10.setUnderlineText(false);
        }
    }

    public static final class d implements DialogExtInterface.OnConfigurationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OPrivacySheet f16372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f16373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16374c;

        public d(OPrivacySheet r10, View r11, int r12) {
            this.f16372a = r10;
            this.f16373b = r11;
            this.f16374c = r12;
        }

        @Override // com.obric.oui.dialog.DialogExtInterface.OnConfigurationListener
        public void onConfigurationChanged(Dialog r10, Configuration r11) {
            q.g(r10, "dialog");
            q.g(r11, "configuration");
            OPrivacySheet r12 = this.f16372a;
            int r13 = r11.screenHeightDp;
            View r14 = this.f16373b;
            OPrivacySheet.f(r12, r13, r14, wd.a.c(r14.getContext()), this.f16374c);
            RecyclerView r15 = OPrivacySheet.e(this.f16372a);
            if (r15 != null) goto L6;
            return;
        L6:
            if (r11.screenHeightDp <= 650) goto L8;
            r15.setPadding(0, f.r(r15, 16), 0, f.r(r15, 16));
            return;
        L8:
            r15.setPadding(0, 0, 0, 0);
        }
    }

    static {
        f16361f = new a(null);
    }

    public OPrivacySheet(Context r10, com.obric.oui.privacy.d r11) {
        q.g(r10, "context");
        q.g(r11, "config");
        this.f16362a = r10;
        this.f16363b = r11;
    }

    public static /* synthetic */ boolean a(OPrivacySheet r10, DialogInterface r11, int r12, KeyEvent r13) {
        return s(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(OPrivacySheet r10, DialogInterface r11) {
        r(r10, r11);
    }

    public static final /* synthetic */ com.obric.oui.privacy.d c(OPrivacySheet r10) {
        return r10.f16363b;
    }

    public static final /* synthetic */ OPrivacySheetListener d(OPrivacySheet r10) {
        return r10.f16366e;
    }

    public static final /* synthetic */ RecyclerView e(OPrivacySheet r10) {
        return r10.f16365d;
    }

    public static final /* synthetic */ void f(OPrivacySheet r10, int r11, View r12, Size r13, int r14) {
        r10.o(r11, r12, r13, r14);
    }

    public static final void r(OPrivacySheet r10, DialogInterface r11) {
        q.g(r10, "this$0");
        OPrivacySheetListener r12 = r10.f16366e;
        if (r12 == null) goto L7;
        r12.onDismiss();
        return;
    }

    public static final boolean s(OPrivacySheet r10, DialogInterface r11, int r12, KeyEvent r13) {
        q.g(r10, "this$0");
        if (r12 != 4) goto L13;
        if (r13 != null) goto L7;
        return false;
    L7:
        if (r13.getAction() != 1) goto L15;
        OPrivacySheetListener r14 = r10.f16366e;
        if (r14 == null) goto L12;
        r14.onBackPressed();
    L12:
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public final View g() {
        int r10 = f.o(this.f16362a, wd.a.c(this.f16362a).getHeight());
        FrameLayout r11 = new FrameLayout(this.f16362a);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        Context r13 = r11.getContext();
        q.f(r13, "context");
        r12.bottomMargin = f.b(r13, 8);
        r11.setLayoutParams(r12);
        PrivacyTopDownAlphaMaskRecyclerView r14 = new PrivacyTopDownAlphaMaskRecyclerView(this.f16362a, null, 0, 6, null);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r10 <= 650) goto L5;
        Context r15 = r14.getContext();
        q.f(r15, "context");
        int r16 = f.b(r15, 16);
        Context r17 = r14.getContext();
        q.f(r17, "context");
        r14.setPadding(0, r16, 0, f.b(r17, 16));
    L6:
        Context r18 = r14.getContext();
        q.f(r18, "context");
        r14.setFadeEdgeLength(f.e(r18, 75));
        r14.setFadeTop(true);
        r14.setFadeBottom(true);
        r14.setDynamicFade(true);
        r14.setBackgroundColor(0);
        r14.setClipToPadding(false);
        r14.setLayoutManager(new LinearLayoutManager(r14.getContext()));
        r14.setAdapter(new PrivacySheetAdapter(this.f16363b.i()));
        r14.i(new b(this, r14));
        this.f16365d = r14;
        r11.addView(r14);
        return r11;
    L5:
        r14.setPadding(0, 0, 0, 0);
        goto L6
    }

    public final OTextView h() {
        String r10 = this.f16363b.b();
        if (r10 != null) goto L5;
    L12:
        return null;
    L5:
        if (o.r(r10) == true) goto L12;
        OTextView r11 = new OTextView(new ContextThemeWrapper(this.f16362a, R$style.Body_1_Regular), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.b(r11.getContext(), R$color.oui_basic_text_3));
        r11.setText(this.f16363b.b());
        if (q.b(Locale.getDefault().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L10;
        int r12 = 17;
    L11:
        r11.setGravity(r12);
        r11.setMaxLines(3);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        Context r14 = r11.getContext();
        q.f(r14, "context");
        r13.topMargin = f.b(r14, 8);
        r11.setLayoutParams(r13);
        return r11;
    L10:
        r12 = 8388611;
        goto L11
    }

    public final View i() {
        LinearLayout r10 = new LinearLayout(this.f16362a);
        r10.setOrientation(1);
        r10.setGravity(1);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context r11 = r10.getContext();
        q.f(r11, "context");
        int r12 = f.b(r11, 20);
        Context r13 = r10.getContext();
        q.f(r13, "context");
        int r14 = f.b(r13, 16);
        Context r15 = r10.getContext();
        q.f(r15, "context");
        int r16 = f.b(r15, 20);
        Context r17 = r10.getContext();
        q.f(r17, "context");
        r10.setPadding(r12, r14, r16, f.b(r17, 8));
        if (this.f16363b.k() == null) goto L17;
        OTextView r18 = new OTextView(new ContextThemeWrapper(this.f16362a, R$style.Button_1_Regular), null, 0, null, 14, null);
        r18.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r18.setTextColor(ContextCompat.b(r18.getContext(), R$color.oui_basic_text_1));
        r18.setGravity(8388611);
        String r19 = this.f16363b.k();
        List r20 = this.f16363b.j();
        if (r20.isEmpty() == true) goto L15;
        SpannableString r110 = new SpannableString(r19);
        Iterator r111 = r20.iterator();
    L8:
        if (r111.hasNext() == false) goto L14;
        String r112 = (String) r111.next();
        int r113 = 0;
    L10:
        String r114 = r112;
        int r21 = StringsKt__StringsKt.Q(r19, r112, r113, false, 4, null);
        if (r21 < 0) goto L8;
        r113 = r21 + r114.length();
        r110.setSpan(new c(this, r114, r18), r21, r113, 33);
        r112 = r114;
        goto L10
    L14:
        r18.setText(r110);
        r18.setMovementMethod(LinkMovementMethod.getInstance());
        r18.setHighlightColor(0);
    L16:
        r10.addView(r18);
        goto L17
    L15:
        r18.setText(r19);
    L17:
        LinearLayout r22 = new LinearLayout(this.f16362a);
        r22.setOrientation(1);
        r22.setGravity(1);
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, -2);
        Context r24 = r22.getContext();
        q.f(r24, "context");
        r23.topMargin = f.b(r24, 14);
        r22.setLayoutParams(r23);
        Context r25 = r22.getContext();
        q.f(r25, "context");
        int r26 = f.b(r25, 4);
        Context r27 = r22.getContext();
        q.f(r27, "context");
        r22.setPadding(r26, 0, f.b(r27, 4), 0);
        Context r28 = this.f16362a;
        String r29 = this.f16363b.a();
        if (r29 != null) goto L20;
        r29 = this.f16362a.getString(R$string.oui_agree);
        q.f(r29, "context.getString(R.string.oui_agree)");
    L20:
        r22.addView(k(r28, r29, R$style.OStyleV2_OButton_L_Standard_Primary, new OPrivacySheet$buildFooterView$agreeButton$1(this)));
        Context r30 = this.f16362a;
        String r31 = this.f16363b.h();
        if (r31 != null) goto L23;
        r31 = this.f16362a.getString(R$string.oui_exit);
        q.f(r31, "context.getString(R.string.oui_exit)");
    L23:
        OButton r32 = k(r30, r31, R$style.OStyleV2_OButton_L_Trans_Neutral, new OPrivacySheet$buildFooterView$exitButton$1(this));
        LinearLayout.LayoutParams r33 = new LinearLayout.LayoutParams(-1, -2);
        Context r34 = r32.getContext();
        q.f(r34, "context");
        r33.topMargin = f.b(r34, 12);
        r32.setLayoutParams(r33);
        r22.addView(r32);
        r10.addView(r22);
        return r10;
    }

    public final View j(OTextView r14) {
        LinearLayout r10 = new LinearLayout(this.f16362a);
        r10.setOrientation(1);
        r10.setGravity(1);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        AttributeSet r11 = null;
        int r12 = 0;
        OImageAppIcon r13 = new OImageAppIcon(this.f16362a, r11, r12, 6, null);
        int r15 = r13.getContext().getResources().getDimensionPixelSize(R$dimen.oui_image_size_xl);
        r13.setLayoutParams(new LinearLayout.LayoutParams(r15, r15));
        String r16 = this.f16363b.c();
        if (r16 != null) goto L5;
    L8:
        r10.addView(r13);
        LinearLayout r17 = new LinearLayout(this.f16362a);
        r17.setOrientation(1);
        r17.setGravity(1);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, -2);
        Context r19 = r17.getContext();
        q.f(r19, "context");
        r18.leftMargin = f.b(r19, 32);
        Context r20 = r17.getContext();
        q.f(r20, "context");
        r18.rightMargin = f.b(r20, 32);
        Context r21 = r17.getContext();
        q.f(r21, "context");
        r18.topMargin = f.b(r21, 20);
        r17.setLayoutParams(r18);
        OTextView r22 = new OTextView(new ContextThemeWrapper(this.f16362a, R$style.Title_4_Bold), null, 0, null, 14, null);
        r22.setIncludeFontPadding(true);
        r22.setTextColor(ContextCompat.b(r22.getContext(), R$color.oui_basic_text_1));
        r22.setText(this.f16363b.d());
        r22.setGravity(17);
        r22.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r17.addView(r22);
        if (r14 == null) goto L11;
        r17.addView(r14);
    L11:
        r10.addView(r17);
        return r10;
    L5:
        if (o.r(r16) == true) goto L8;
        r13.setImagePackageName(this.f16363b.c());
        goto L8
    }

    public final OButton k(Context r10, String r11, int r12, Function1 r13) {
        return (OButton) td.e.a(r10, r12, new OPrivacySheet$createSingleButton$1(r11, r13));
    }

    public final void l() {
        OSheet r10 = this.f16364c;     // Catch: Exception -> L7
        if (r10 == null) goto L10;
        r10.dismiss();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final void m() {
        OSheet r10 = this.f16364c;     // Catch: Exception -> L7
        if (r10 == null) goto L10;
        r10.d();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final int n(Size r10, OTextView r11) {
        if (r11 != null) goto L5;
        return 0;
    L5:
        r11.measure(View.MeasureSpec.makeMeasureSpec(h.d(r10.getWidth() - (f.b(this.f16362a, 32) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return (h.d(r11.getLineCount(), 1) - 1) * r11.getLineHeight();
    }

    public final void o(int r10, View r11, Size r12, int r13) {
        if (r10 <= 650) goto L5;
        r11.setPadding(0, (int) (r12.getHeight() * 0.135f), 0, (int) ((r12.getHeight() * 0.10375f) - r13));
        return;
    L5:
        r11.setPadding(0, f.r(r11, 20), 0, f.r(r11, 12));
    }

    public final OPrivacySheet p(OPrivacySheetListener r10) {
        q.g(r10, "listener");
        this.f16366e = r10;
        return this;
    }

    public final OPrivacySheet q() {
        OSheet r10 = new OSheet(this.f16362a, 0, 0, false, false, 14, null);
        r10.setHeightMode(OSheet.HeightMode.FULL_HEIGHT);
        r10.setCanceledOnTouchOutside(false);
        r10.setCancelable(false);
        r10.setSheetBgColor(ContextCompat.b(r10.getContext(), R$color.oui_bg_base_2));
        OTextView r11 = h();
        View r12 = j(r11);
        Size r13 = wd.a.c(r12.getContext());
        Context r14 = r10.getContext();
        q.f(r14, "context");
        int r15 = f.o(r14, r13.getHeight());
        int r16 = n(r13, r11);
        o(r15, r12, r13, r16);
        r10.setHeaderView(r12);
        r10.setBodyView(g());
        r10.setFooterView(i());
        r10.g(!this.f16363b.f());
        r10.setOnDismissListener(new com.obric.oui.privacy.a(this));
        if (this.f16363b.e() == false) goto L5;
        r10.setOnKeyListener(new com.obric.oui.privacy.b(this));
    L5:
        r10.setOnConfigurationListener(new d(this, r12, r16));
        this.f16364c = r10;
        r10.setEnableEnterAnim(this.f16363b.g());
        r10.show();
        return this;
    }
}
