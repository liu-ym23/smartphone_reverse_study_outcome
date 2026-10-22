package com.obric.oui.texteffects;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import bg.h;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import od.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 42\u00020\u0001:\u0004YZ[\\B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u000fJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001dJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b'\u0010&J\u0015\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020#¢\u0006\u0004\b)\u0010&J\u0019\u0010*\u001a\u00020\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b*\u0010&J\u0015\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020#¢\u0006\u0004\b,\u0010&J\u000f\u0010-\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010\u000fJ\u001f\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00102\u0006\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\rH\u0014¢\u0006\u0004\b3\u0010\u000fJ\u000f\u00104\u001a\u00020\rH\u0014¢\u0006\u0004\b4\u0010\u000fJ'\u00106\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00102\u0006\u00105\u001a\u00020 2\u0006\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002082\u0006\u0010$\u001a\u00020#H\u0014¢\u0006\u0004\b9\u0010:J!\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010;\u001a\u0002082\u0006\u0010=\u001a\u00020<H\u0014¢\u0006\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010IR\u001a\u0010U\u001a\u00020\u00108\u0014X\u0094D¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001a\u0010X\u001a\u00020\n8\u0014X\u0094D¢\u0006\f\n\u0004\b6\u0010V\u001a\u0004\bW\u0010\f¨\u0006]"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "N", "()F", "", "Y", "()V", "", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "X", "(Ljava/lang/String;)Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "mode", "setDimPointMode", "(Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;)V", "scale", "setDebugAnimationDurationScale", "(F)V", "V", "", "P", "()Z", "R", "Q", "", "O", "()J", "", "text", "S", "(Ljava/lang/CharSequence;)V", "setTextWithEffect", "actualText", "U", "T", "newText", "W", "J", "effectName", "Lod/k;", "spec", "z", "(Ljava/lang/String;Lod/k;)V", "A", FixCard.FixStyle.KEY_Y, "playTimeMs", FixCard.FixStyle.KEY_X, "(Ljava/lang/String;JLod/k;)V", "Lqd/c;", "g", "(Ljava/lang/CharSequence;)Lqd/c;", "cache", "Lod/e$a;", "fill", "Landroid/graphics/LinearGradient;", "f", "(Lqd/c;Lod/e$a;)Landroid/graphics/LinearGradient;", "r", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "activeMode", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "s", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "pendingTextType", "t", "Ljava/lang/CharSequence;", "promptExitGenerateText", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "u", "Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "rewritePhase", "v", "pendingRewriteText", "w", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "F", "getMaxBlurRadiusDp", "maxBlurRadiusDp", "a", "DimPointMode", "PendingTextType", "RewritePhase", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointEffectTextView extends OProtocolTextEffectTextView {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f17260y = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DimPointMode f17261r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PendingTextType f17262s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f17263t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RewritePhase f17264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f17265v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f17266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f17267x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$DimPointMode;", "", "(Ljava/lang/String;I)V", "NONE", "PENDING", "PROMPT_EXIT_TO_GENERATE", "PROMPT_SWITCH", "GENERATE", "REWRITE", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DimPointMode extends Enum<DimPointMode> {
        private static final /* synthetic */ DimPointMode[] $VALUES = null;
        public static final DimPointMode GENERATE = null;
        public static final DimPointMode NONE = null;
        public static final DimPointMode PENDING = null;
        public static final DimPointMode PROMPT_EXIT_TO_GENERATE = null;
        public static final DimPointMode PROMPT_SWITCH = null;
        public static final DimPointMode REWRITE = null;

        private static final /* synthetic */ DimPointMode[] $values() {
            return new DimPointMode[]{NONE, PENDING, PROMPT_EXIT_TO_GENERATE, PROMPT_SWITCH, GENERATE, REWRITE};
        }

        static {
            NONE = new DimPointMode("NONE", 0);
            PENDING = new DimPointMode("PENDING", 1);
            PROMPT_EXIT_TO_GENERATE = new DimPointMode("PROMPT_EXIT_TO_GENERATE", 2);
            PROMPT_SWITCH = new DimPointMode("PROMPT_SWITCH", 3);
            GENERATE = new DimPointMode("GENERATE", 4);
            REWRITE = new DimPointMode("REWRITE", 5);
            $VALUES = $values();
        }

        private DimPointMode(String r10, int r11) {
            super(r10, r11);
        }

        public static DimPointMode valueOf(String r10) {
            return (DimPointMode) Enum.valueOf(DimPointMode.class, r10);
        }

        public static DimPointMode[] values() {
            return (DimPointMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$PendingTextType;", "", "(Ljava/lang/String;I)V", "CONTENT", "PROMPT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PendingTextType extends Enum<PendingTextType> {
        private static final /* synthetic */ PendingTextType[] $VALUES = null;
        public static final PendingTextType CONTENT = null;
        public static final PendingTextType PROMPT = null;

        private static final /* synthetic */ PendingTextType[] $values() {
            return new PendingTextType[]{CONTENT, PROMPT};
        }

        static {
            CONTENT = new PendingTextType("CONTENT", 0);
            PROMPT = new PendingTextType("PROMPT", 1);
            $VALUES = $values();
        }

        private PendingTextType(String r10, int r11) {
            super(r10, r11);
        }

        public static PendingTextType valueOf(String r10) {
            return (PendingTextType) Enum.valueOf(PendingTextType.class, r10);
        }

        public static PendingTextType[] values() {
            return (PendingTextType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointEffectTextView$RewritePhase;", "", "(Ljava/lang/String;I)V", "NONE", "EXITING_OLD_TEXT", "ENTERING_NEW_TEXT", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RewritePhase extends Enum<RewritePhase> {
        private static final /* synthetic */ RewritePhase[] $VALUES = null;
        public static final RewritePhase ENTERING_NEW_TEXT = null;
        public static final RewritePhase EXITING_OLD_TEXT = null;
        public static final RewritePhase NONE = null;

        private static final /* synthetic */ RewritePhase[] $values() {
            return new RewritePhase[]{NONE, EXITING_OLD_TEXT, ENTERING_NEW_TEXT};
        }

        static {
            NONE = new RewritePhase("NONE", 0);
            EXITING_OLD_TEXT = new RewritePhase("EXITING_OLD_TEXT", 1);
            ENTERING_NEW_TEXT = new RewritePhase("ENTERING_NEW_TEXT", 2);
            $VALUES = $values();
        }

        private RewritePhase(String r10, int r11) {
            super(r10, r11);
        }

        public static RewritePhase valueOf(String r10) {
            return (RewritePhase) Enum.valueOf(RewritePhase.class, r10);
        }

        public static RewritePhase[] values() {
            return (RewritePhase[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17268a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17269b = null;

        static {
            int[] r10 = new int[DimPointMode.values().length];
            r10[DimPointMode.PENDING.ordinal()] = 1;
            r10[DimPointMode.GENERATE.ordinal()] = 2;
            r10[DimPointMode.REWRITE.ordinal()] = 3;
            r10[DimPointMode.PROMPT_EXIT_TO_GENERATE.ordinal()] = 4;
            r10[DimPointMode.PROMPT_SWITCH.ordinal()] = 5;
            r10[DimPointMode.NONE.ordinal()] = 6;
            f17268a = r10;
            int[] r11 = new int[RewritePhase.values().length];
            r11[RewritePhase.EXITING_OLD_TEXT.ordinal()] = 1;
            r11[RewritePhase.ENTERING_NEW_TEXT.ordinal()] = 2;
            r11[RewritePhase.NONE.ordinal()] = 3;
            f17269b = r11;
        }
    }

    static {
        f17260y = new a(null);
    }

    @JvmOverloads
    public ODimPointEffectTextView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void A() {
        this.f17261r = DimPointMode.NONE;
        this.f17264u = RewritePhase.NONE;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void J() {
        super.J();
        this.f17261r = DimPointMode.NONE;
        this.f17262s = PendingTextType.CONTENT;
        this.f17263t = null;
        this.f17264u = RewritePhase.NONE;
        this.f17265v = null;
    }

    public final float N() {
        if (this.f17261r == DimPointMode.PENDING) goto L5;
        return 0.0f;
    L5:
        if (this.f17262s != PendingTextType.CONTENT) goto L29;
        com.obric.oui.texteffects.runtime.d r10 = B();
        if (r10 == null) goto L30;
        List r11 = r10.a();
        if (r11 == null) goto L31;
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        Object r13 = r12.next();
        if (q.b(((com.obric.oui.texteffects.runtime.c) r13).e(), "gradient_overlay") == false) goto L15;
    L20:
        com.obric.oui.texteffects.runtime.c r14 = (com.obric.oui.texteffects.runtime.c) r13;
        if (r14 != null) goto L24;
        return 0.0f;
    L24:
        return h.j(r14.a(0.0f), 0.0f, 0.8f);
    L19:
        r13 = null;
        goto L20
    L31:
        return 0.0f;
    L30:
        return 0.0f;
    L29:
        return 0.0f;
    }

    public final long O() {
        return getCurrentEffectPlayTimeMs();
    }

    public final boolean P() {
        if (this.f17261r == DimPointMode.PENDING) goto L5;
    L7:
        return false;
    L5:
        if (this.f17262s != PendingTextType.PROMPT) goto L7;
        return true;
    }

    public final boolean Q() {
        Y();
        if (this.f17264u != RewritePhase.ENTERING_NEW_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean R() {
        Y();
        if (this.f17264u != RewritePhase.EXITING_OLD_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    public final void S(CharSequence r10) {
        CharSequence r11 = getText();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        if (P() == false) goto L14;
        if (r10.length() <= 0) goto L14;
        U(r10);
        return;
    L14:
        if (TextUtils.equals(r11, r10) == false) goto L19;
        if (r11.length() != 0) goto L23;
        J();
        setText(r10);
        return;
    L23:
        return;
    L19:
        if (r11.length() != 0) goto L21;
        T(r10);
        return;
    L21:
        W(r10);
    }

    public final void T(CharSequence r11) {
        if (r11 == null) goto L4;
        setText(r11);
    L4:
        this.f17262s = PendingTextType.CONTENT;
        this.f17263t = null;
        OProtocolTextEffectTextView.G(this, pd.a.f23454a.j(false), "generate", false, getText(), null, null, 52, null);
    }

    public final void U(CharSequence r10) {
        q.g(r10, "actualText");
        if (P() == true) goto L6;
        T(r10);
        return;
    L6:
        this.f17263t = r10;
        OProtocolTextEffectTextView.G(this, pd.a.f23454a.s(), "prompt_exit_to_generate", false, "", null, null, 52, null);
    }

    public final void V() {
        this.f17262s = PendingTextType.CONTENT;
        OProtocolTextEffectTextView.G(this, pd.a.f23454a.q(), "pending", false, null, null, null, 60, null);
    }

    public final void W(CharSequence r11) {
        q.g(r11, "newText");
        if (this.f17261r != DimPointMode.REWRITE) goto L12;
        RewritePhase r10 = this.f17264u;
        int r12 = b.f17269b[r10.ordinal()];
        if (r12 != 1) goto L7;
        setText(r11);
        OProtocolTextEffectTextView.M(this, r11, null, r11, 2, null);
        return;
    L7:
        if (r12 != 2) goto L18;
        this.f17265v = r11;
        return;
    L18:
        return;
    L12:
        CharSequence r13 = getText();
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        CharSequence r14 = r13;
        float r15 = N();
        this.f17262s = PendingTextType.CONTENT;
        this.f17263t = null;
        this.f17265v = null;
        setText(r11);
        OProtocolTextEffectTextView.G(this, pd.a.f23454a.t(false, r15), "rewrite", false, r11, r14, r11, 4, null);
    }

    public final DimPointMode X(String r10) {
        switch(r10.hashCode()) {
            case -1253981585: goto L22;
            case -682587753: goto L18;
            case -208065901: goto L14;
            case 1101148556: goto L10;
            case 1810371957: goto L6;
            default: goto L30;
        };
    L6:
        if (r10.equals("generate") == false) goto L30;
        return DimPointMode.GENERATE;
    L10:
        if (r10.equals("rewrite") == false) goto L30;
        return DimPointMode.REWRITE;
    L14:
        if (r10.equals("prompt_exit_to_generate") == false) goto L30;
        return DimPointMode.PROMPT_EXIT_TO_GENERATE;
    L18:
        if (r10.equals("pending") == false) goto L30;
        return DimPointMode.PENDING;
    L22:
        if (r10.equals("prompt_switch") == false) goto L30;
        return DimPointMode.PROMPT_SWITCH;
    L30:
        return DimPointMode.NONE;
    }

    public final void Y() {
        if (this.f17261r == DimPointMode.REWRITE) goto L5;
        RewritePhase r10 = RewritePhase.NONE;
    L9:
        this.f17264u = r10;
        return;
    L5:
        if (getCurrentEffectPlayTimeMs() >= 150) goto L7;
        r10 = RewritePhase.EXITING_OLD_TEXT;
        goto L9
    L7:
        r10 = RewritePhase.ENTERING_NEW_TEXT;
        goto L9
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public LinearGradient f(qd.c r10, od.e.a r11) {
        q.g(r10, "cache");
        q.g(r11, "fill");
        if (r10.b() > 0.01f) goto L6;
        return null;
    L6:
        float r12 = r10.a();
        return new LinearGradient(r12, 0.0f, r12 + r10.b(), 0.0f, r11.a(), r11.b(), Shader.TileMode.CLAMP);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public qd.c g(CharSequence r10) {
        q.g(r10, "text");
        qd.d r11 = qd.d.f23654a;
        TextPaint r12 = getPaint();
        q.f(r12, "paint");
        return r11.a(r10, r12, j(), getEllipsize(), new ODimPointEffectTextView$buildTextCache$1(this), new ODimPointEffectTextView$buildTextCache$2(this));
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    @NotNull
    public String getLogTag() {
        return this.f17266w;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public float getMaxBlurRadiusDp() {
        return this.f17267x;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void setDebugAnimationDurationScale(float r10) {
        float r11 = getDebugAnimationDurationScale();
        super.setDebugAnimationDurationScale(r10);
        if (r11 != getDebugAnimationDurationScale()) goto L6;
        return;
    L6:
        if (this.f17261r != DimPointMode.PENDING) goto L9;
        OProtocolTextEffectTextView.G(this, pd.a.f23454a.q(), "pending", true, null, null, null, 56, null);
        return;
    }

    public final void setDimPointMode(@NotNull DimPointMode r10) {
        q.g(r10, "mode");
        if (this.f17261r != r10) goto L5;
        return;
    L5:
        J();
        int r11 = b.f17268a[r10.ordinal()];
        if (r11 != 1) goto L8;
        V();
        return;
    L8:
        if (r11 != 2) goto L14;
        T(null);
        return;
    }

    public final void setTextWithEffect(@Nullable CharSequence r10) {
        S(r10);
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void x(String r10, long r11, k r12) {
        q.g(r10, "effectName");
        q.g(r12, "spec");
        Y();
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void y() {
        DimPointMode r10 = this.f17261r;
        this.f17261r = DimPointMode.NONE;
        this.f17264u = RewritePhase.NONE;
        if (r10 != DimPointMode.PROMPT_EXIT_TO_GENERATE) goto L8;
        CharSequence r11 = this.f17263t;
        this.f17263t = null;
        this.f17262s = PendingTextType.CONTENT;
        if (r11 == null) goto L18;
        T(r11);
        return;
    L18:
        return;
    L8:
        if (r10 != DimPointMode.PROMPT_SWITCH) goto L11;
        this.f17262s = PendingTextType.PROMPT;
        return;
    L11:
        if (r10 != DimPointMode.REWRITE) goto L21;
        CharSequence r12 = this.f17265v;
        this.f17265v = null;
        if (r12 != null) goto L15;
        return;
    L15:
        if (TextUtils.equals(getText(), r12) == true) goto L23;
        W(r12);
        return;
    L23:
        return;
    }

    @Override // com.obric.oui.texteffects.OProtocolTextEffectTextView
    public void z(String r10, k r11) {
        q.g(r10, "effectName");
        q.g(r11, "spec");
        this.f17261r = X(r10);
        Y();
    }

    @JvmOverloads
    public ODimPointEffectTextView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ODimPointEffectTextView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ODimPointEffectTextView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17261r = DimPointMode.NONE;
        this.f17262s = PendingTextType.CONTENT;
        this.f17264u = RewritePhase.NONE;
        this.f17266w = "DimPointTextView";
        this.f17267x = 16.0f;
    }
}
