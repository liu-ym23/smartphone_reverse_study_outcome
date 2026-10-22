package com.stepos.agentframework.chatui.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.os.Trace;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.longtext.ChatRenderRow;
import com.stepos.agentframework.chatui.longtext.LongTextDocument;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p7.AppUI;
import w4.RobotInfo;
import z4.C6360f;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001d\u001e\u001f B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/n;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/ViewGroup;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "row", "k", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;)V", "Landroid/widget/LinearLayout;", Parameters.ROOT, "Landroid/widget/LinearLayout;", "Lcom/stepos/agentframework/chatui/viewholder/n$a;", "text", "Lcom/stepos/agentframework/chatui/viewholder/n$a;", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.viewholder.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2109n extends AbstractC2106k {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LinearLayout root;
    private final MessageContentContainer sources;
    private final a text;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/n$a;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "row", "Lcom/stepos/agentframework/chatui/N1;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;Lcom/stepos/agentframework/chatui/N1;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "phase", "", RobotInfo.STATUS_STARTED, "", AMapLocationStaticsEntity.FIRST_LOCATE, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;JZ)V", "Lz4/f;", "logLimiter", "Lz4/f;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "Ljava/lang/String;", "blockIndex", "I", "blockStart", "blockChars", "firstMeasure", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.n$a */
    public static final class a extends TextView {
        private int blockChars;
        private int blockIndex;
        private int blockStart;
        private boolean firstMeasure;
        private String identity;
        private final C6360f logLimiter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            kotlin.jvm.internal.p.i(context, "context");
            this.logLimiter = new C6360f(16, 0L, 2, null);
            this.identity = "";
            this.blockIndex = -1;
            this.blockStart = -1;
        }

        public static /* synthetic */ void c(a aVar, String str, long j10, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            aVar.b(str, j10, z10);
        }

        public final void a(ChatRenderRow row, DisplayMessage message) {
            List<LongTextDocument.Block> listA;
            kotlin.jvm.internal.p.i(row, "row");
            kotlin.jvm.internal.p.i(message, "message");
            this.identity = "sessionId=" + message.getSessionId() + " messageId=" + message.getMessageId();
            this.blockIndex = row.getBlockIndex();
            LongTextDocument document = row.getDocument();
            LongTextDocument.Block block = (document == null || (listA = document.a()) == null) ? null : (LongTextDocument.Block) Z8.F.t0(listA, row.getBlockIndex());
            this.blockStart = block != null ? block.getStart() : -1;
            this.blockChars = block != null ? block.getEnd() - block.getStart() : 0;
            this.firstMeasure = block != null;
        }

        public final void b(String phase, long started, boolean first) {
            long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - started) / 1000000;
            if (this.blockIndex >= 0) {
                if (first || jElapsedRealtimeNanos >= 8) {
                    C6360f.Sample sampleA = this.logLimiter.a(phase + "/slow=" + (jElapsedRealtimeNanos >= 8), this.identity, SystemClock.elapsedRealtime());
                    if (sampleA == null) {
                        return;
                    }
                    String str = this.identity;
                    int i10 = this.blockIndex;
                    int i11 = this.blockStart;
                    int i12 = this.blockChars;
                    int measuredWidth = getMeasuredWidth();
                    int measuredHeight = getMeasuredHeight();
                    Layout layout = getLayout();
                    int lineCount = layout != null ? layout.getLineCount() : 0;
                    C4148a.d("LongTextBlockViewHolder", "long text block " + str + " phase=" + phase + " blockIndex=" + i10 + " blockStart=" + i11 + " blockChars=" + i12 + " elapsedMs=" + jElapsedRealtimeNanos + " width=" + measuredWidth + " height=" + measuredHeight + " lines=" + lineCount + " targetBlockChars=384 hardLimit=512 firstMeasure=" + first + " count=" + sampleA.getCount() + " suppressed=" + sampleA.getSuppressed(), false, 4, null);
                }
            }
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Trace.beginSection("Chat.longText.drawBlock");
            try {
                super.onDraw(canvas);
                Trace.endSection();
                c(this, "draw", jElapsedRealtimeNanos, false, 4, null);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Trace.beginSection("Chat.longText.measureBlock");
            try {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                Trace.endSection();
                b("measure", jElapsedRealtimeNanos, this.firstMeasure);
                this.firstMeasure = false;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/n$b;", "", "<init>", "()V", "Landroid/widget/TextView;", "text", "", "source", "", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument$d;", "styles", "Landroid/text/SpannableString;", Const.INTENT_KEY_APIKEY, "(Landroid/widget/TextView;Ljava/lang/String;Ljava/util/List;)Landroid/text/SpannableString;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.n$b, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.viewholder.n$b$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LongTextDocument.Kind.values().length];
                try {
                    iArr[LongTextDocument.Kind.BOLD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LongTextDocument.Kind.ITALIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LongTextDocument.Kind.CODE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LongTextDocument.Kind.STRIKETHROUGH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[LongTextDocument.Kind.UNDERLINE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[LongTextDocument.Kind.SUBSCRIPT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[LongTextDocument.Kind.SUPERSCRIPT.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[LongTextDocument.Kind.QUOTE.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[LongTextDocument.Kind.RULE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[LongTextDocument.Kind.HEADING.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[LongTextDocument.Kind.LINK.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/agentframework/chatui/viewholder/n$b$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.viewholder.n$b$b, reason: collision with other inner class name */
        public static final class C0253b extends ClickableSpan {
            final /* synthetic */ LongTextDocument.Style $span;

            public C0253b(LongTextDocument.Style style) {
                this.$span = style;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                kotlin.jvm.internal.p.i(widget, "widget");
                MarkwonHelper.o0(widget, this.$span.getValue());
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                kotlin.jvm.internal.p.i(ds, "ds");
                ds.setColor(MarkwonHelper.X());
                ds.setUnderlineText(false);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SpannableString a(TextView text, String source, List<LongTextDocument.Style> styles) {
            Object styleSpan;
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(source, "source");
            kotlin.jvm.internal.p.i(styles, "styles");
            SpannableString spannableString = new SpannableString(source);
            for (LongTextDocument.Style style : styles) {
                switch (a.$EnumSwitchMapping$0[style.getKind().ordinal()]) {
                    case 1:
                        styleSpan = new StyleSpan(1);
                        break;
                    case 2:
                        styleSpan = new StyleSpan(2);
                        break;
                    case 3:
                        styleSpan = new TypefaceSpan("monospace");
                        break;
                    case 4:
                        styleSpan = new StrikethroughSpan();
                        break;
                    case 5:
                        styleSpan = new UnderlineSpan();
                        break;
                    case 6:
                        styleSpan = new d(false);
                        break;
                    case 7:
                        styleSpan = new d(true);
                        break;
                    case 8:
                        styleSpan = new QuoteSpan(text.getCurrentTextColor(), (int) (2 * text.getResources().getDisplayMetrics().density), (int) (8 * text.getResources().getDisplayMetrics().density));
                        break;
                    case 9:
                        styleSpan = new c(text.getCurrentTextColor(), text.getResources().getDisplayMetrics().density);
                        break;
                    case 10:
                        spannableString.setSpan(new StyleSpan(1), style.getStart(), style.getEnd(), 33);
                        String value = style.getValue();
                        styleSpan = new RelativeSizeSpan(kotlin.jvm.internal.p.d(value, "1") ? 1.5f : kotlin.jvm.internal.p.d(value, "2") ? 1.3f : 1.15f);
                        break;
                    case 11:
                        styleSpan = new C0253b(style);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                spannableString.setSpan(styleSpan, style.getStart(), style.getEnd(), 33);
            }
            return spannableString;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007Jg\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/n$c;", "Landroid/text/style/LineBackgroundSpan;", "", "color", "", "thickness", "<init>", "(IF)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "left", "right", "top", "baseline", "bottom", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "lineNumber", "LY8/t;", "drawBackground", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;III)V", "I", "F", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.n$c */
    public static final class c implements LineBackgroundSpan {
        private final int color;
        private final float thickness;

        public c(int i10, float f10) {
            this.color = i10;
            this.thickness = f10;
        }

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lineNumber) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            kotlin.jvm.internal.p.i(paint, "paint");
            kotlin.jvm.internal.p.i(text, "text");
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(this.color);
            paint.setStrokeWidth(this.thickness);
            float f10 = (top + bottom) / 2.0f;
            canvas.drawLine(left, f10, right, f10, paint);
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/n$d;", "Landroid/text/style/MetricAffectingSpan;", "", "superscript", "<init>", "(Z)V", "Landroid/text/TextPaint;", "tp", "LY8/t;", "updateDrawState", "(Landroid/text/TextPaint;)V", "updateMeasureState", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.n$d */
    public static final class d extends MetricAffectingSpan {
        private final boolean superscript;

        public d(boolean z10) {
            this.superscript = z10;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp) {
            kotlin.jvm.internal.p.i(tp, "tp");
            updateMeasureState(tp);
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint tp) {
            kotlin.jvm.internal.p.i(tp, "tp");
            tp.setTextSize(tp.getTextSize() * 0.75f);
            int iAscent = (int) (tp.ascent() / 2);
            int i10 = tp.baselineShift;
            if (!this.superscript) {
                iAscent = -iAscent;
            }
            tp.baselineShift = i10 + iAscent;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2109n(ViewGroup parent, U1 chatView) {
        super(new LinearLayout(parent.getContext()), chatView);
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View view = this.itemView;
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        this.root = linearLayout;
        Context context = parent.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        a aVar = new a(context);
        this.text = aVar;
        Context context2 = parent.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        MessageContentContainer messageContentContainer = new MessageContentContainer(context2, null);
        this.sources = messageContentContainer;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        linearLayout.addView(aVar, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(messageContentContainer, new LinearLayout.LayoutParams(-1, -2));
        aVar.setTextIsSelectable(false);
        aVar.setBreakStrategy(0);
        aVar.setHyphenationFrequency(0);
        aVar.setIncludeFontPadding(false);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[Catch: all -> 0x01d3, TryCatch #0 {all -> 0x01d3, blocks: (B:3:0x000a, B:5:0x0026, B:7:0x002c, B:9:0x0032, B:11:0x003a, B:15:0x0041, B:17:0x0047, B:19:0x004f, B:21:0x0061, B:23:0x0067, B:25:0x006d, B:27:0x007c, B:29:0x0080, B:34:0x0092, B:36:0x00a3, B:38:0x00ab, B:43:0x00bf, B:45:0x00c6, B:47:0x00ce, B:52:0x00e2, B:54:0x00ea, B:56:0x00f8, B:69:0x017a, B:71:0x0180, B:73:0x0188, B:78:0x0192, B:81:0x0197, B:85:0x01a2, B:87:0x01a9, B:89:0x01bc, B:57:0x0101, B:59:0x014d, B:62:0x0157, B:63:0x015b, B:65:0x0161, B:67:0x016f, B:35:0x0097, B:26:0x0077), top: B:95:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(com.stepos.agentframework.chatui.longtext.ChatRenderRow r12) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.C2109n.k(com.stepos.agentframework.chatui.longtext.ChatRenderRow):void");
    }
}
