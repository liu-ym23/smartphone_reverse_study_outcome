package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.ODynamicThemeWidget;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.b;
import com.obric.oui.material.f;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;
import td.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008b\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u001cJ\u0019\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0017H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010(J\u0019\u0010,\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0017H\u0016¢\u0006\u0004\b/\u0010(J\u0017\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\r2\u0006\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u00102J\u000f\u00105\u001a\u00020\u0017H\u0016¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\r2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\r\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010#¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u0004\u0018\u00010#¢\u0006\u0004\bA\u0010BJ\u0015\u0010E\u001a\u00020\r2\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bI\u0010HJ\u0017\u0010J\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bJ\u0010-J\u0017\u0010K\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bK\u0010-J\u0015\u0010M\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u0017¢\u0006\u0004\bM\u0010(J\u0019\u0010P\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010NH\u0014¢\u0006\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010.\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\b.\u00106\"\u0004\bX\u0010(R\u0017\u0010^\u001a\u00020Y8\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010aR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010j\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010iR\u0016\u0010k\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010WR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010nR\u001e\u0010p\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010nR\u0016\u0010r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010qR\u0016\u0010t\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010qR\u0016\u0010u\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010WR\u0018\u0010w\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010vR\u0018\u0010y\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010vR\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001f\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010}R \u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010}R\u0018\u0010\u0084\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010qR'\u0010\u0089\u0001\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u0085\u0001\u0010q\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0005\b\u0088\u0001\u00102¨\u0006\u008c\u0001"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "", "newWidth", "", "n", "(Landroid/view/View;I)V", "context", "Landroid/content/res/TypedArray;", "typedArray", "e", "(Landroid/content/Context;Landroid/content/res/TypedArray;)V", "Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "currentState", "", "showShadow", "k", "(Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;Z)V", "m", "()V", WsConstants.KEY_CONNECTION_STATE, "j", "(Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;)V", "h", "i", CommonKey.KEY_VALUE, "Landroid/text/TextUtils$TruncateAt;", "g", "(I)Landroid/text/TextUtils$TruncateAt;", "enabled", "setEnabled", "(Z)V", "apply", "applyContentMaterial", "view", "setBackdropTarget", "(Landroid/view/View;)V", "isBackdropView", "updateBackdropTargetType", "srcType", "updateBackdropSrcType", "(I)V", "themeStyle", "applyDynamicTheme", "isDarkTheme", "()Z", "", "text", "setText", "(Ljava/lang/String;)V", "", "getText", "()Ljava/lang/CharSequence;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "(Landroid/view/View$OnFocusChangeListener;)V", "getPrefixView", "()Landroid/view/View;", "getPostfixView", "setPrefixView", "setPostfixView", "show", "setCanShowClear", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/obric/oui/layout/OUILinearLayout;", "a", "Lcom/obric/oui/layout/OUILinearLayout;", "searchBarContainer", "b", "Z", "setBackdropView", "Lcom/obric/oui/forms/OEditText;", "c", "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "inputView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "leftContainer", "rightContainer", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "clearActionContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "clearAction", "canShowClear", "", "Lcom/obric/oui/common/style/Shadow;", "Ljava/util/List;", "shadowsNormal", "shadowsResting", "I", Style.KEY_BG_COLOR, "l", "bgColorResting", "enabledMaterial", "Ljava/lang/String;", "materialTokenResting", "o", "materialToken", "", "Lcom/obric/oui/material/b;", "p", "[Lcom/obric/oui/material/b;", "materialsActive", "q", "materialsResting", "r", "currentMaterials", "s", "materialSrcType", "t", "getCurrentTheme", "()I", "setCurrentTheme", "currentTheme", "u", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSearchBar extends OUIFrameLayout implements MaterialOwner, ODynamicThemeWidget {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f16522u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OUILinearLayout f16523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OEditText f16525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f16526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f16527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f16528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f16529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f16531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f16532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f16536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f16537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b[] f16538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b[] f16539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b[] f16540r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16541s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16542t;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "", "(Ljava/lang/String;I)V", "RESTING", "ACTIVE", "VALUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum SearchBarState extends Enum<SearchBarState> {
            private static final /* synthetic */ SearchBarState[] $VALUES = null;
            public static final SearchBarState ACTIVE = null;
            public static final SearchBarState RESTING = null;
            public static final SearchBarState VALUE = null;

            private static final /* synthetic */ SearchBarState[] $values() {
                return new SearchBarState[]{RESTING, ACTIVE, VALUE};
            }

            static {
                RESTING = new SearchBarState("RESTING", 0);
                ACTIVE = new SearchBarState("ACTIVE", 1);
                VALUE = new SearchBarState("VALUE", 2);
                $VALUES = $values();
            }

            private SearchBarState(String r10, int r11) {
                super(r10, r11);
            }

            public static SearchBarState valueOf(String r10) {
                return (SearchBarState) Enum.valueOf(SearchBarState.class, r10);
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public Companion() {
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16543a = null;

        static {
            int[] r10 = new int[Companion.SearchBarState.values().length];
            r10[Companion.SearchBarState.RESTING.ordinal()] = 1;
            r10[Companion.SearchBarState.ACTIVE.ordinal()] = 2;
            r10[Companion.SearchBarState.VALUE.ordinal()] = 3;
            f16543a = r10;
        }
    }

    static {
        f16522u = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSearchBar(@NotNull Context r10) {
        q.g(r10, "originContext");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void a(OSearchBar r10, View r11) {
        f(r10, r11);
    }

    public static final /* synthetic */ OUILinearLayout b(OSearchBar r10) {
        return r10.f16523a;
    }

    public static final /* synthetic */ void c(OSearchBar r10) {
        r10.h();
    }

    public static final /* synthetic */ void d(OSearchBar r10) {
        r10.m();
    }

    private final void e(Context r10, TypedArray r11) {
        List r12 = OUILayoutHelper.p(r10, r11, R$styleable.OSearchBar_oui_widgetShadowNormal);
        if (r12 == null) goto L5;
        this.f16531i = r12;
    L5:
        List r13 = OUILayoutHelper.p(r10, r11, R$styleable.OSearchBar_oui_widgetShadowResting);
        if (r13 == null) goto L9;
        this.f16532j = r13;
        return;
    }

    public static final void f(OSearchBar r10, View r11) {
        q.g(r10, "this$0");
        r10.f16525c.setText("");
    }

    public static /* synthetic */ void l(OSearchBar r10, Companion.SearchBarState r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        r10.k(r11, r12);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        f.b(this, r10, this.f16524b);
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public void applyDynamicTheme(int r10) {
        if (this.f16542t == r10) goto L16;
        this.f16542t = r10;
        if (this.f16535m == false) goto L17;
        String r11 = this.f16537o;
        if (r11 == null) goto L18;
        b[] r12 = MaterialToken.parseSet(r11, !isDarkTheme());
        if (r12 == null) goto L19;
        OUILinearLayout r13 = this.f16523a;
        if (r13 != null) goto L14;
        q.y("searchBarContainer");
        r13 = null;
    L14:
        o.j(r13, r12, false, 0, null, 14, null);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final TextUtils.TruncateAt g(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    public final int getCurrentTheme() {
        return this.f16542t;
    }

    @Nullable
    public final TextUtils.TruncateAt getEllipsize() {
        return this.f16525c.getEllipsize();
    }

    @NotNull
    public final OEditText getInputView() {
        return this.f16525c;
    }

    @Nullable
    public final View getPostfixView() {
        if (this.f16527e.getChildCount() != 0) goto L7;
        return null;
    L7:
        return this.f16527e.getChildAt(0);
    }

    @Nullable
    public final View getPrefixView() {
        if (this.f16526d.getChildCount() != 0) goto L7;
        return null;
    L7:
        return this.f16526d.getChildAt(0);
    }

    @NotNull
    public final CharSequence getText() {
        Editable r10 = this.f16525c.getText();
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    public final void h() {
        int r10 = 8;
        if (this.f16530h == true) goto L5;
        this.f16528f.setVisibility(8);
    L13:
        if (this.f16528f.getVisibility() != 0) goto L16;
        l.k(this.f16527e);
    L18:
        i();
        return;
    L16:
        if (this.f16527e.getChildCount() == 0) goto L18;
        l.m(this.f16527e);
        goto L18
    L5:
        ViewGroup r11 = this.f16528f;
        Editable r12 = this.f16525c.getText();
        if (r12 != null) goto L8;
    L11:
        r11.setVisibility(r10);
        goto L13
    L8:
        if (r12.length() == 0) goto L11;
        r10 = 0;
        goto L11
    }

    public final void i() {
        if (this.f16526d.getVisibility() != 0) goto L5;
        int r10 = 0;
    L7:
        if (this.f16528f.getVisibility() != 0) goto L10;
    L11:
        int r11 = tc.f.r(this, 0);
    L13:
        this.f16525c.setPaddingRelative(r10, 0, r11, 0);
        return;
    L10:
        if (this.f16527e.getVisibility() == 0) goto L11;
        r11 = tc.f.r(this, 8);
        goto L13
    L5:
        r10 = tc.f.r(this, 12);
        goto L7
    }

    @Override // com.obric.oui.common.style.ODynamicThemeWidget
    public boolean isDarkTheme() {
        int r10 = this.f16533k;
        if (r10 != 0) goto L7;
        return i.a(this);
    L7:
        if (this.f16542t != 2) goto L9;
    L12:
        return true;
    L9:
        if (i0.c(r10) == true) goto L12;
        return false;
    }

    public final void j(Companion.SearchBarState r10) {
        if (this.f16535m == true) goto L6;
        return;
    L6:
        if (r10 != Companion.SearchBarState.RESTING) goto L11;
        b[] r11 = this.f16539q;
        if (r11 != null) goto L10;
        r11 = this.f16538p;
    L10:
        b[] r12 = r11;
        this.f16540r = r12;
        if (r12 == null) goto L24;
        int r13 = this.f16541s;
        if (r13 == (-1)) goto L18;
    L17:
        int r14 = r13;
        OUILinearLayout r15 = this.f16523a;
        if (r15 != null) goto L22;
        q.y("searchBarContainer");
        r15 = null;
    L22:
        o.j(r15, r12, false, r14, null, 10, null);
        return;
    L18:
        r13 = 2;
        goto L17
    L24:
        return;
    L11:
        r11 = this.f16538p;
        goto L10
    }

    public final void k(Companion.SearchBarState r10, boolean r11) {
        if (this.f16531i != null) goto L6;
        Shadow r12 = Shadow.f13061i;
        setShadow(r12, r12, false);
        return;
    L6:
        int r13 = tc.f.r(this, 99);
        setShadowCornerRadius(r13);
        OUILinearLayout r14 = this.f16523a;
        if (r14 != null) goto L9;
        q.y("searchBarContainer");
        r14 = null;
    L9:
        r14.setRadius(r13);
        if (r11 == true) goto L12;
        Shadow r15 = Shadow.f13061i;
        setShadow(r15, r15, true);
        return;
    L12:
        if (a.f16543a[r10.ordinal()] != 1) goto L17;
        List r16 = this.f16532j;
        if (r16 == null) goto L16;
        q.d(r16);
        Shadow r17 = (Shadow) b0.a0(r16, 0);
        List r18 = this.f16532j;
        q.d(r18);
        setShadow(r17, (Shadow) b0.a0(r18, 1), true);
        return;
    L16:
        Shadow r19 = Shadow.f13061i;
        setShadow(r19, r19, true);
        return;
    L17:
        List r20 = this.f16531i;
        q.d(r20);
        Shadow r21 = (Shadow) b0.a0(r20, 0);
        List r22 = this.f16531i;
        q.d(r22);
        setShadow(r21, (Shadow) b0.a0(r22, 1), true);
    }

    public final void m() {
        if (this.f16525c.hasFocus() == false) goto L5;
        Companion.SearchBarState r10 = Companion.SearchBarState.ACTIVE;
    L12:
        int r11 = a.f16543a[r10.ordinal()];
        if (r11 == 1) goto L33;
        if (r11 == 2) goto L26;
        if (r11 == 3) goto L19;
    L39:
        j(r10);
        return;
    L19:
        if (this.f16535m == true) goto L24;
        OUILinearLayout r12 = this.f16523a;
        if (r12 != null) goto L23;
        q.y("searchBarContainer");
        r12 = null;
    L23:
        r12.setBackgroundColor(this.f16533k);
    L24:
        this.f16526d.setSelected(true);
        l(this, r10, false, 2, null);
        goto L39
    L26:
        if (this.f16535m == true) goto L31;
        OUILinearLayout r13 = this.f16523a;
        if (r13 != null) goto L30;
        q.y("searchBarContainer");
        r13 = null;
    L30:
        r13.setBackgroundColor(this.f16533k);
    L31:
        this.f16526d.setSelected(true);
        l(this, r10, false, 2, null);
        goto L39
    L33:
        if (this.f16535m == true) goto L38;
        OUILinearLayout r14 = this.f16523a;
        if (r14 != null) goto L37;
        q.y("searchBarContainer");
        r14 = null;
    L37:
        r14.setBackgroundColor(this.f16534l);
    L38:
        this.f16526d.setSelected(false);
        l(this, r10, false, 2, null);
        goto L39
    L5:
        Editable r15 = this.f16525c.getText();
        if (r15 != null) goto L8;
    L11:
        r10 = Companion.SearchBarState.RESTING;
        goto L12
    L8:
        if (r15.length() == 0) goto L11;
        r10 = Companion.SearchBarState.VALUE;
        goto L12
    }

    public final void n(View r10, int r11) {
        if (r11 > 0) goto L5;
        L.b("OSearchBar", q.p("newWidth must be greater than 0, ", Integer.valueOf(r11)));
        return;
    L5:
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.width = r11;
        r10.setLayoutParams(r12);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        this.f16538p = MaterialToken.parseSet(this.f16537o, !i.a(this));
        String r11 = this.f16536n;
        if (r11 == null) goto L5;
        b[] r12 = MaterialToken.parseSet(r11, !i.a(this));
    L6:
        this.f16539q = r12;
        m();
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        o.n(this, r10);
    }

    public final void setBackdropView(boolean r10) {
        this.f16524b = r10;
    }

    public final void setCanShowClear(boolean r10) {
        this.f16530h = r10;
        h();
    }

    public final void setCurrentTheme(int r10) {
        this.f16542t = r10;
    }

    public final void setEllipsize(@Nullable TextUtils.TruncateAt r10) {
        this.f16525c.setEllipsize(r10);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        this.f16525c.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setOnInputFocusChange(@NotNull View.OnFocusChangeListener r10) {
        q.g(r10, "onFocusChangeListener");
        this.f16525c.setOnFocusChangeListener(r10);
    }

    public final void setPostfixView(@Nullable View r10) {
        this.f16527e.removeAllViews();
        if (r10 != null) goto L5;
        l.k(this.f16527e);
    L6:
        i();
        return;
    L5:
        this.f16527e.addView(r10);
        l.m(this.f16527e);
        goto L6
    }

    public final void setPrefixView(@Nullable View r10) {
        this.f16526d.removeAllViews();
        if (r10 != null) goto L5;
        l.k(this.f16526d);
    L6:
        i();
        return;
    L5:
        r10.setDuplicateParentStateEnabled(true);
        this.f16526d.addView(r10);
        l.m(this.f16526d);
        goto L6
    }

    public final void setText(@NotNull String r10) {
        q.g(r10, "text");
        this.f16525c.setText(r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        this.f16541s = r10;
        OUILinearLayout r11 = this.f16523a;
        if (r11 != null) goto L5;
        q.y("searchBarContainer");
        r11 = null;
    L5:
        o.p(r11, r10);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f16524b == r10) goto L12;
        this.f16524b = r10;
        if (this.f16541s == (-1)) goto L7;
        return;
    L7:
        OUILinearLayout r11 = this.f16523a;
        if (r11 != null) goto L10;
        q.y("searchBarContainer");
        r11 = null;
    L10:
        o.q(r11, r10);
        return;
    }

    public /* synthetic */ OSearchBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OSearchBar(@NotNull Context r24, @Nullable AttributeSet r25) {
        q.g(r24, "originContext");
        super(r24, r25, 0, null, 12, null);
        this.f16524b = true;
        this.f16530h = true;
        this.f16541s = -1;
        FrameLayout.inflate(getContext(), R$layout.o_widget_search_bar_v2, this);
        setChangeAlphaWhenPress(false);
        if (o.f(this) == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f16535m = r10;
        View r11 = findViewById(R$id.searchbar_container);
        q.f(r11, "findViewById(R.id.searchbar_container)");
        this.f16523a = (OUILinearLayout) r11;
        View r12 = findViewById(R$id.input_view);
        q.f(r12, "findViewById(R.id.input_view)");
        OEditText r13 = (OEditText) r12;
        this.f16525c = r13;
        r13.e(new AnonymousClass1(this));
        View r14 = findViewById(R$id.left_container);
        q.f(r14, "findViewById(R.id.left_container)");
        FrameLayout r15 = (FrameLayout) r14;
        this.f16526d = r15;
        View r16 = findViewById(R$id.right_container);
        q.f(r16, "findViewById(R.id.right_container)");
        FrameLayout r17 = (FrameLayout) r16;
        this.f16527e = r17;
        View r18 = findViewById(R$id.clear_action_container);
        q.f(r18, "findViewById(R.id.clear_action_container)");
        ViewGroup r19 = (ViewGroup) r18;
        this.f16528f = r19;
        View r20 = findViewById(R$id.clear_action);
        q.f(r20, "findViewById(R.id.clear_action)");
        ImageView r21 = (ImageView) r20;
        this.f16529g = r21;
        Context r22 = getContext();
        q.f(r22, "context");
        int[] r110 = R$styleable.OSearchBar;
        q.f(r110, "OSearchBar");
        TypedArray r23 = r22.obtainStyledAttributes(r25, r110, 0, 0);
        q.f(r23, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        OUILinearLayout r111 = null;
        this.f16533k = r23.getColor(R$styleable.OSearchBar_oui_widgetBgColor, getContext().getResources().getColor(R$color.oui_searchbar_bg, null));
        this.f16534l = r23.getColor(R$styleable.OSearchBar_oui_widgetBgColorResting, getContext().getResources().getColor(R$color.oui_searchbar_bg_resting, null));
        getInputView().setTextColor(r23.getColorStateList(R$styleable.OSearchBar_oui_widgetTextColor));
        ColorStateList r112 = r23.getColorStateList(R$styleable.OSearchBar_oui_widgetTextColorHint);
        getInputView().setHintTextColor(r112);
        r21.setImageTintList(r112);
        getInputView().setHint(r23.getString(R$styleable.OSearchBar_android_hint));
        getInputView().setText(r23.getString(R$styleable.OSearchBar_android_text));
        int r26 = R$styleable.OSearchBar_android_ellipsize;
        if (r23.hasValue(r26) == false) goto L11;
        setEllipsize(g(r23.getInt(r26, 0)));
    L11:
        int r27 = r23.getLayoutDimension(R$styleable.OSearchBar_android_layout_height, 0);
        if (r27 > 0) goto L14;
        L.b("OSearchBar", q.p("searchBarHeight must be greater than 0, ", Integer.valueOf(r27)));
    L14:
        int r113 = r23.getResourceId(R$styleable.OSearchBar_oui_search_postfixView, 0);
        if (r113 == 0) goto L17;
        FrameLayout.inflate(getContext(), r113, r17);
        l.m(r17);
    L17:
        int r28 = r23.getResourceId(R$styleable.OSearchBar_oui_search_prefixView, R$layout.o_widget_search_bar_prefix_v2);
        if (r28 == 0) goto L20;
        FrameLayout.inflate(getContext(), r28, r15);
        l.m(r15);
        n(r15, r27);
    L20:
        n(r19, r27);
        r19.setOnClickListener(new com.obric.oui.searchbar.v2.a(this));
        Context r29 = getContext();
        q.f(r29, "context");
        e(r29, r23);
        if (this.f16535m == false) goto L23;
        this.f16541s = r23.getInt(R$styleable.OSearchBar_oui_widgetMaterialSrcType, -1);
        this.f16535m = r23.getBoolean(R$styleable.OSearchBar_oui_widgetEnableMaterial, false);
    L23:
        boolean r30 = isDarkTheme();
        if (this.f16535m == false) goto L52;
        String r31 = r23.getString(R$styleable.OSearchBar_oui_widgetMaterial);
        this.f16537o = r31;
        if (r31 != null) goto L28;
        this.f16537o = r23.getResources().getString(R$string.oui_material_bg_floating);
    L28:
        this.f16536n = r23.getString(R$styleable.OSearchBar_oui_widgetMaterialResting);
        this.f16538p = MaterialToken.parseSet(this.f16537o, !r30);
        String r32 = this.f16536n;
        if (r32 == null) goto L31;
        b[] r33 = MaterialToken.parseSet(r32, true ^ r30);
    L32:
        this.f16539q = r33;
        if (r33 != null) goto L35;
        r33 = this.f16538p;
    L35:
        this.f16540r = r33;
        if (r33 != null) goto L38;
        Unit r34 = null;
    L50:
        if (r34 != null) goto L52;
        this.f16535m = false;
        goto L52
    L38:
        setBackground(null);
        int r35 = this.f16541s;
        if (r35 == (-1)) goto L41;
        int r114 = r35;
    L42:
        OUILinearLayout r36 = this.f16523a;
        if (r36 != null) goto L45;
        q.y("searchBarContainer");
        r36 = null;
    L45:
        GradientDrawable r37 = new GradientDrawable();
        r37.setShape(0);
        r37.setCornerRadius(tc.f.u(this, 99));
        r37.setColor(0);
        r36.setBackground(r37);
        OUILinearLayout r38 = this.f16523a;
        if (r38 != null) goto L48;
        q.y("searchBarContainer");
        OUILinearLayout r115 = null;
    L49:
        o.j(r115, r33, false, r114, null, 10, null);
        r34 = Unit.f21064a;
        goto L50
    L48:
        r115 = r38;
        goto L49
    L41:
        r114 = 2;
        goto L42
    L31:
        r33 = null;
    L52:
        r23.recycle();
        if (isDarkTheme() == true) goto L58;
        OUILinearLayout r39 = this.f16523a;
        if (r39 != null) goto L57;
        q.y("searchBarContainer");
        r39 = null;
    L57:
        r39.setOverridePressColor(getResources().getColor(R$color.oui_basic_fill_element_2_light));
    L62:
        OUILinearLayout r40 = this.f16523a;
        if (r40 != null) goto L65;
        q.y("searchBarContainer");
    L66:
        r111.refreshColors("OSearchBar");
        r13.f(new AnonymousClass3(this));
        r13.d(new AnonymousClass4(this));
        m();
        i();
        return;
    L65:
        r111 = r40;
        goto L66
    L58:
        OUILinearLayout r41 = this.f16523a;
        if (r41 != null) goto L61;
        q.y("searchBarContainer");
        r41 = null;
    L61:
        r41.setOverridePressColor(getResources().getColor(R$color.oui_basic_fill_element_2_dark));
        goto L62
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        r10 = true;
        goto L8
    }
}
