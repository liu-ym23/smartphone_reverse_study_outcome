package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.divider.ODivider;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import mc.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0002,<B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\n2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020\n2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b&\u0010%J\u001f\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020+8\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00106R\u0018\u00109\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00108R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "l", "", "setBottomButtonClickListener", "(Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;)V", "", SlideCard.KEY_INDEX, "Lcom/obric/oui/button/OButton;", "c", "(I)Lcom/obric/oui/button/OButton;", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/actionbar/OBottomActionBar$a;", "config", "d", "(Lcom/obric/oui/actionbar/OBottomActionBar$a;)V", "", "actionButtons", "g", "(Ljava/util/List;Lcom/obric/oui/actionbar/OBottomActionBar$a;)V", "e", "Landroid/view/View;", "button", "i", "(Landroid/view/View;I)V", "", "a", "Ljava/lang/String;", "TAG", "b", "Landroid/view/View;", "contentView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "rootView", "Lcom/obric/oui/divider/ODivider;", "Lcom/obric/oui/divider/ODivider;", "dividerView", "Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "onClickListener", "f", "Ljava/util/List;", "OnBottomButtonClickListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBottomActionBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f12225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f12226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ODivider f12227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBottomButtonClickListener f12228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f12229f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "", BusSupport.EVENT_ON_CLICK, "", "button", "Landroid/view/View;", SlideCard.KEY_INDEX, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBottomButtonClickListener {
        void onClick(@NotNull View r10, int r11);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f12231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f12233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f12234e;

        public a(boolean r10, boolean r11, String r12, List r13, List r14) {
            q.g(r12, "buttonStyle");
            this.f12230a = r10;
            this.f12231b = r11;
            this.f12232c = r12;
            this.f12233d = r13;
            this.f12234e = r14;
        }

        public final List a() {
            return this.f12234e;
        }

        public final String b() {
            return this.f12232c;
        }

        public final List c() {
            return this.f12233d;
        }

        public final boolean d() {
            return this.f12230a;
        }

        public final boolean e() {
            return this.f12231b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f12230a == r11.f12230a) goto L12;
            return false;
        L12:
            if (this.f12231b == r11.f12231b) goto L15;
            return false;
        L15:
            if (q.b(this.f12232c, r11.f12232c) == true) goto L18;
            return false;
        L18:
            if (q.b(this.f12233d, r11.f12233d) == true) goto L21;
            return false;
        L21:
            if (q.b(this.f12234e, r11.f12234e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            boolean r10 = this.f12230a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f12231b;
            if (r14 == true) goto L9;
            r11 = r14;
        L9:
            int r15 = (((r13 + r11) * 31) + this.f12232c.hashCode()) * 31;
            List r16 = this.f12233d;
            int r17 = 0;
            if (r16 != null) goto L12;
            int r18 = 0;
        L13:
            int r19 = (r15 + r18) * 31;
            List r20 = this.f12234e;
            if (r20 == null) goto L18;
            r17 = r20.hashCode();
        L18:
            return r19 + r17;
        L12:
            r18 = r16.hashCode();
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.f12230a + ", lastPrimary=" + this.f12231b + ", buttonStyle=" + this.f12232c + ", buttonTexts=" + this.f12233d + ", buttonImgIds=" + this.f12234e + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBar(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void a(OBottomActionBar r10, int r11, View r12) {
        f(r10, r11, r12);
    }

    public static /* synthetic */ void b(OBottomActionBar r10, int r11, View r12) {
        h(r10, r11, r12);
    }

    public static final void f(OBottomActionBar r10, int r11, View r12) {
        q.g(r10, "this$0");
        q.f(r12, "it");
        r10.i(r12, r11);
    }

    public static final void h(OBottomActionBar r10, int r11, View r12) {
        q.g(r10, "this$0");
        q.f(r12, "it");
        r10.i(r12, r11);
    }

    public final OButton c(int r10) {
        List r11 = this.f12229f;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        int r12 = 0;
    L8:
        if (r10 >= r12) goto L14;
        List r13 = this.f12229f;
        if (r13 != null) goto L13;
        return null;
    L13:
        return (OButton) r13.get(r10);
    L14:
        return null;
    L7:
        r12 = r11.size();
        goto L8
    }

    public final void d(a r20) {
        String r10 = r20.b();
        int r11 = r10.hashCode();
        if (r11 == (-1612256902)) goto L36;
        if (r11 == 3397) goto L32;
        if (r11 == 104387) goto L28;
        if (r11 == 678742426) goto L24;
        if (r11 == 3428) goto L20;
        if (r11 != 3429) goto L40;
        if (r10.equals("m2") == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m2, null);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r12);
        View r13 = findViewById(R$id.action_button_m20);
        q.f(r13, "findViewById(R.id.action_button_m20)");
        View r14 = findViewById(R$id.action_button_m21);
        q.f(r14, "findViewById(R.id.action_button_m21)");
        View r15 = findViewById(R$id.action_button_m22);
        q.f(r15, "findViewById(R.id.action_button_m22)");
        this.f12229f = t.n(new OButton[]{(OButton) r13, (OButton) r14, (OButton) r15});
    L40:
        if (r20.b().compareTo(ServerElements.VIDEO_IMAGE) != 0) goto L42;
        e(this.f12229f, r20);
    L44:
        if (r20.d() == false) goto L46;
        this.f12227d.setVisibility(0);
        return;
    L46:
        this.f12227d.setVisibility(8);
        return;
    L42:
        g(this.f12229f, r20);
        goto L44
    L20:
        if (r10.equals("m1") == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m1, null);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r16);
        View r17 = findViewById(R$id.action_button_0);
        q.f(r17, "findViewById(R.id.action_button_0)");
        View r18 = findViewById(R$id.action_button_1);
        q.f(r18, "findViewById(R.id.action_button_1)");
        View r19 = findViewById(R$id.action_button_2);
        q.f(r19, "findViewById(R.id.action_button_2)");
        View r21 = findViewById(R$id.action_button_3);
        q.f(r21, "findViewById(R.id.action_button_3)");
        View r22 = findViewById(R$id.action_button_4);
        q.f(r22, "findViewById(R.id.action_button_4)");
        this.f12229f = t.n(new OButton[]{(OButton) r17, (OButton) r18, (OButton) r19, (OButton) r21, (OButton) r22});
        goto L40
    L24:
        if (r10.equals("m2-primary") == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m2_primary, null);
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r23);
        View r24 = findViewById(R$id.action_button_m2_primary0);
        q.f(r24, "findViewById(R.id.action_button_m2_primary0)");
        View r25 = findViewById(R$id.action_button_m2_primary1);
        q.f(r25, "findViewById(R.id.action_button_m2_primary1)");
        this.f12229f = t.n(new OButton[]{(OButton) r24, (OButton) r25});
        goto L40
    L28:
        if (r10.equals(ServerElements.VIDEO_IMAGE) == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_img, null);
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r26);
        View r27 = findViewById(R$id.action_button_0);
        q.f(r27, "findViewById(R.id.action_button_0)");
        OButton r110 = (OButton) r27;
        View r28 = findViewById(R$id.action_button_1);
        q.f(r28, "findViewById(R.id.action_button_1)");
        OButton r111 = (OButton) r28;
        View r29 = findViewById(R$id.action_button_2);
        q.f(r29, "findViewById(R.id.action_button_2)");
        OButton r112 = (OButton) r29;
        View r30 = findViewById(R$id.action_button_3);
        q.f(r30, "findViewById(R.id.action_button_3)");
        OButton r113 = (OButton) r30;
        View r31 = findViewById(R$id.action_button_4);
        q.f(r31, "findViewById(R.id.action_button_4)");
        OButton r114 = (OButton) r31;
        View r32 = findViewById(R$id.action_button_5);
        q.f(r32, "findViewById(R.id.action_button_5)");
        this.f12229f = t.n(new OButton[]{r110, r111, r112, r113, r114, (OButton) r32});
        goto L40
    L32:
        if (r10.equals("l1") == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_l1, null);
        LinearLayout.LayoutParams r33 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r33);
        View r34 = findViewById(R$id.action_button_L10);
        q.f(r34, "findViewById(R.id.action_button_L10)");
        View r35 = findViewById(R$id.action_button_L11);
        q.f(r35, "findViewById(R.id.action_button_L11)");
        this.f12229f = t.n(new OButton[]{(OButton) r34, (OButton) r35});
        goto L40
    L36:
        if (r10.equals("l1-primary") == false) goto L40;
        this.f12225b = FrameLayout.inflate(getContext(), R$layout.o_widget_bottom_action_bar_l1_primary, null);
        LinearLayout.LayoutParams r36 = new LinearLayout.LayoutParams(-1, -1);
        this.f12226c.addView(this.f12225b, r36);
        View r37 = findViewById(R$id.action_button_L1_primary);
        q.f(r37, "findViewById(R.id.action_button_L1_primary)");
        this.f12229f = t.n(new OButton[]{(OButton) r37});
        goto L40
    }

    public final void e(List r10, a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        final int r12 = 0;
        if (r11.a() == null) goto L12;
        int r13 = Math.min(r11.a().size(), r10.size());
        if (r11.a().size() <= r10.size()) goto L9;
        Log.e(this.f12224a, q.p("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r10.size())));
    L9:
        int r14 = r13 - 1;
        int r15 = 0;
    L10:
        if (r15 >= r13) goto L13;
        ((OButton) r10.get(r15)).setVisibility(0);
        ((OButton) r10.get(r15)).setButtonSourceBitmap(((Number) r11.a().get(r15)).intValue());
        r15 = r15 + 1;
    L13:
        if (r14 != (-1)) goto L15;
        r14 = r10.size() - 1;
    L15:
        if (r14 < 0) goto L20;
    L16:
        int r16 = r12 + 1;
        ((OButton) r10.get(r12)).setOnClickListener(new mc.a(this, r12));
        if (r12 == r14) goto L23;
        r12 = r16;
        goto L16
    L23:
        return;
    L20:
        return;
    L12:
        r14 = -1;
        goto L13
    }

    public final void g(List r10, a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        final int r12 = 0;
        if (r11.c() == null) goto L12;
        int r13 = Math.min(r11.c().size(), r10.size());
        if (r11.c().size() <= r10.size()) goto L9;
        Log.e(this.f12224a, q.p("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r10.size())));
    L9:
        int r14 = r13 - 1;
        int r15 = 0;
    L10:
        if (r15 >= r13) goto L13;
        ((OButton) r10.get(r15)).setVisibility(0);
        ((OButton) r10.get(r15)).setText((CharSequence) r11.c().get(r15));
        r15 = r15 + 1;
    L13:
        if (r14 != (-1)) goto L16;
        r14 = r10.size() - 1;
    L16:
        if (r11.e() == false) goto L26;
        ((OButton) r10.get(r14)).setBackgroundColor(getResources().getColor(R$color.oui_accent_bg_high_contrast));
        ((OButton) r10.get(r14)).setTextColor(getResources().getColor(R$color.oui_on_accent_default));
        c r16 = c.f24796a;
        Object r17 = r10.get(r14);
        if (r17 != null) goto L21;
    L19:
        r17 = null;
    L22:
        IOUIAlpha r18 = (IOUIAlpha) r17;
        if (r18 == null) goto L26;
        r18.refreshColors(this.f12224a);
        goto L26
    L21:
        if ((r17 instanceof IOUIAlpha) == false) goto L19;
    L26:
        if (r14 < 0) goto L31;
    L27:
        int r19 = r12 + 1;
        ((OButton) r10.get(r12)).setOnClickListener(new b(this, r12));
        if (r12 == r14) goto L34;
        r12 = r19;
        goto L27
    L34:
        return;
    L31:
        return;
    L12:
        r14 = -1;
        goto L13
    }

    public final void i(View r10, int r11) {
        OnBottomButtonClickListener r12 = this.f12228e;
        if (r12 == null) goto L7;
        r12.onClick(r10, r11);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setBottomButtonClickListener(@Nullable OnBottomButtonClickListener r10) {
        this.f12228e = r10;
    }

    public /* synthetic */ OBottomActionBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OBottomActionBar(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f12224a = "OBottomActionBar";
        FrameLayout.inflate(r10, R$layout.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.b(r10, R$color.Transparent));
        View r12 = findViewById(R$id.root_layout);
        q.f(r12, "findViewById(R.id.root_layout)");
        this.f12226c = (LinearLayout) r12;
        View r13 = findViewById(R$id.top_divider);
        q.f(r13, "findViewById(R.id.top_divider)");
        this.f12227d = (ODivider) r13;
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OBottomActionBar, 0, 0);
        boolean r15 = r14.getBoolean(R$styleable.OBottomActionBar_oui_hasDivider, true);
        boolean r16 = r14.getBoolean(R$styleable.OBottomActionBar_oui_buttonLastPrimary, false);
        String r17 = r14.getString(R$styleable.OBottomActionBar_oui_buttonStyle);
        int r18 = r14.getResourceId(R$styleable.OBottomActionBar_oui_buttonTexts, 0);
        int r19 = r14.getResourceId(R$styleable.OBottomActionBar_oui_buttonImgIds, 0);
        if (r18 != 0) goto L5;
        List r20 = null;
    L6:
        if (r19 != 0) goto L8;
        List r21 = null;
    L12:
        if (r17 != null) goto L14;
        r17 = "l1";
    L14:
        a r110 = new a(r15, r16, r17, r20, r21);
        r14.recycle();
        d(r110);
        return;
    L8:
        TypedArray r22 = r14.getResources().obtainTypedArray(r19);
        q.f(r22, "resources.obtainTypedArray(buttonImg)");
        ArrayList r23 = new ArrayList();
        int r24 = r22.length();
        int r25 = 0;
    L9:
        if (r25 >= r24) goto L11;
        r23.add(Integer.valueOf(r22.getResourceId(r25, 0)));
        r25 = r25 + 1;
        goto L9
    L11:
        List r26 = b0.z0(r23);
        r22.recycle();
        r21 = r26;
        goto L12
    L5:
        String[] r27 = r14.getResources().getStringArray(r18);
        q.f(r27, "resources.getStringArray(buttonResourceId)");
        r20 = n.M(r27);
        goto L6
    }
}
