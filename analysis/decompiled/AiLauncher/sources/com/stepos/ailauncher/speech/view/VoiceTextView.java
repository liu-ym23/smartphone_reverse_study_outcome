package com.stepos.ailauncher.speech.view;

import La.D;
import La.H;
import Y8.t;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.speech.R$drawable;
import com.stepos.ailauncher.speech.R$styleable;
import com.stepos.ailauncher.speech.view.a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u000eJ\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\f¢\u0006\u0004\b,\u0010\u000eJ\u0017\u0010/\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017¢\u0006\u0004\b2\u0010$J\u0015\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u0007¢\u0006\u0004\b4\u0010!J\u0017\u00107\u001a\u00020\f2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\fH\u0014¢\u0006\u0004\b9\u0010\u000eJ\u001f\u0010:\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0007H\u0016¢\u0006\u0004\b<\u0010=J)\u0010?\u001a\u00020\f2\u0018\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f0>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020-H\u0016¢\u0006\u0004\bB\u00100R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR*\u0010U\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\f\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010TR\"\u0010X\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010D\u001a\u0004\bY\u0010=\"\u0004\bZ\u0010!R\"\u0010[\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010D\u001a\u0004\b\\\u0010=\"\u0004\b]\u0010!R\u0018\u0010^\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006`"}, d2 = {"Lcom/stepos/ailauncher/speech/view/VoiceTextView;", "Landroid/widget/LinearLayout;", "Lcom/stepos/ailauncher/speech/view/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", "l", "()V", "n", "p", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)I", "status", "reason", "", "k", "(II)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)V", ContentDisposition.Parameters.Size, "setRollingAsrTextSize", "(F)V", "color", "setRollingAsrTextColor", "(I)V", "isBold", "setRollingAsrTextBold", "(Z)V", "m", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "o", "", "text", "setAsrText", "(Ljava/lang/String;)V", "enable", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "resId", "setIcon", "Lcom/stepos/ailauncher/speech/view/a$b;", "listener", "setViewStatusUpdateListener", "(Lcom/stepos/ailauncher/speech/view/a$b;)V", "onDetachedFromWindow", Const.INTENT_KEY_PKGNAME, "(II)V", "getStatus", "()I", "Lkotlin/Function2;", "setOnViewClicked", "(Lp9/p;)V", "txt", "q", "mStatus", "I", "iconView", "Landroid/widget/ImageView;", "tvEllipsis", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "paddingView", "Landroid/view/View;", "Landroid/os/Handler;", "uiHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "listeningAnimRunnable", "Ljava/lang/Runnable;", "isListening", "Z", "viewClickEvent", "Lp9/p;", "mEnableSelfTextStyle", "mAsrTextStyle", "getMAsrTextStyle", "setMAsrTextStyle", "mAsrTextBackgroundColor", "getMAsrTextBackgroundColor", "setMAsrTextBackgroundColor", "viewStatusUpdateListener", "Lcom/stepos/ailauncher/speech/view/a$b;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceTextView extends LinearLayout implements com.stepos.ailauncher.speech.view.a {
    private ImageView iconView;
    private boolean isListening;
    private Runnable listeningAnimRunnable;
    private int mAsrTextBackgroundColor;
    private int mAsrTextStyle;
    private boolean mEnableSelfTextStyle;
    private int mStatus;
    private View paddingView;
    private TextView textView;
    private TextView tvEllipsis;
    private final Handler uiHandler;
    private p<? super Integer, ? super String, t> viewClickEvent;
    private a.b viewStatusUpdateListener;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/speech/view/VoiceTextView$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "", "idx", "I", "getIdx", "()I", "setIdx", "(I)V", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        final /* synthetic */ String $base;
        private int idx;

        public a(String str) {
            this.$base = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceTextView.this.isAttachedToWindow() && VoiceTextView.this.isListening) {
                int i10 = this.idx % 4;
                String str = i10 != 0 ? i10 != 1 ? i10 != 2 ? "···" : "··" : "·" : "";
                TextView textView = VoiceTextView.this.textView;
                if (textView == null) {
                    kotlin.jvm.internal.p.A("textView");
                    textView = null;
                }
                textView.setText(this.$base + str);
                this.idx = this.idx + 1;
                VoiceTextView.this.uiHandler.postDelayed(this, 500L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.mEnableSelfTextStyle = true;
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VoiceTextView);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.mEnableSelfTextStyle = typedArrayObtainStyledAttributes.getBoolean(R$styleable.VoiceTextView_enableSelfTextStyle, true);
            this.mAsrTextStyle = typedArrayObtainStyledAttributes.getInt(R$styleable.VoiceTextView_asrTextStyle, 0);
            this.mAsrTextBackgroundColor = typedArrayObtainStyledAttributes.getColor(R$styleable.VoiceTextView_asrTextBackgroundColor, 0);
            typedArrayObtainStyledAttributes.recycle();
            i(context);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static final t j(VoiceTextView voiceTextView, boolean z10) {
        if (z10) {
            TextView textView = voiceTextView.tvEllipsis;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = voiceTextView.tvEllipsis;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        return t.f7040a;
    }

    @Override // com.stepos.ailauncher.speech.view.a
    public void b(int status, int reason) {
        if (k(status, reason)) {
            return;
        }
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.p.A("textView");
            textView = null;
        }
        d dVar = textView instanceof d ? (d) textView : null;
        if (dVar != null) {
            dVar.setShowAnimation(false);
        }
        int i10 = this.mStatus;
        if (i10 == 1) {
            this.isListening = true;
            TextView textView3 = this.textView;
            if (textView3 == null) {
                kotlin.jvm.internal.p.A("textView");
                textView3 = null;
            }
            textView3.setText("聆听中…");
            l();
            TextView textView4 = this.textView;
            if (textView4 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView4;
            }
            textView2.setGravity(3);
            return;
        }
        if (i10 != 3) {
            TextView textView5 = this.textView;
            if (textView5 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView5;
            }
            textView2.setGravity(3);
            return;
        }
        TextView textView6 = this.textView;
        if (textView6 == null) {
            kotlin.jvm.internal.p.A("textView");
            textView6 = null;
        }
        textView6.setText("点击或按住说话");
        TextView textView7 = this.textView;
        if (textView7 == null) {
            kotlin.jvm.internal.p.A("textView");
        } else {
            textView2 = textView7;
        }
        textView2.setGravity(1);
    }

    public final int g(float value) {
        return (int) ((value * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final ImageView getIconView() {
        ImageView imageView = this.iconView;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.p.A("iconView");
        return null;
    }

    public final int getMAsrTextBackgroundColor() {
        return this.mAsrTextBackgroundColor;
    }

    public final int getMAsrTextStyle() {
        return this.mAsrTextStyle;
    }

    /* renamed from: getStatus, reason: from getter */
    public int getMStatus() {
        return this.mStatus;
    }

    public final TextView getTextView() {
        TextView textView = this.textView;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.p.A("textView");
        return null;
    }

    public final void h(boolean enable) {
        this.mEnableSelfTextStyle = enable;
    }

    public final void i(Context context) {
        Context context2;
        TextView textView;
        kotlin.jvm.internal.p.i(context, "context");
        if (getChildCount() > 0) {
            removeAllViews();
        }
        this.iconView = new ImageView(context);
        int iG = g(28.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iG, iG);
        ImageView imageView = this.iconView;
        TextView textView2 = null;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("iconView");
            imageView = null;
        }
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = this.iconView;
        if (imageView2 == null) {
            kotlin.jvm.internal.p.A("iconView");
            imageView2 = null;
        }
        imageView2.setImageResource(R$drawable.ai_icon_d);
        if (this.mAsrTextStyle == 1) {
            context2 = context;
            d dVar = new d(context2, null, 0, 6, null);
            int i10 = this.mAsrTextBackgroundColor;
            if (i10 != 0) {
                dVar.setBgColor(i10);
            }
            TextView textView3 = new TextView(context2);
            this.tvEllipsis = textView3;
            textView3.setText("···");
            dVar.setCallShowEllipsis(new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.view.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return VoiceTextView.j(this.f28356a, ((Boolean) obj).booleanValue());
                }
            });
            textView = dVar;
        } else {
            context2 = context;
            TextView textView4 = new TextView(context2);
            textView4.setEllipsize(TextUtils.TruncateAt.START);
            textView = textView4;
        }
        this.textView = textView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.leftMargin = g(6.0f);
        TextView textView5 = this.textView;
        if (textView5 == null) {
            kotlin.jvm.internal.p.A("textView");
            textView5 = null;
        }
        textView5.setLayoutParams(layoutParams2);
        TextView textView6 = this.textView;
        if (textView6 == null) {
            kotlin.jvm.internal.p.A("textView");
            textView6 = null;
        }
        textView6.setSingleLine(true);
        TextView textView7 = this.textView;
        if (textView7 == null) {
            kotlin.jvm.internal.p.A("textView");
            textView7 = null;
        }
        textView7.setTextSize(2, 16.0f);
        if (this.mEnableSelfTextStyle) {
            TextView textView8 = this.textView;
            if (textView8 == null) {
                kotlin.jvm.internal.p.A("textView");
                textView8 = null;
            }
            textView8.setTextColor(Color.parseColor("#FF777777"));
            TextView textView9 = this.textView;
            if (textView9 == null) {
                kotlin.jvm.internal.p.A("textView");
                textView9 = null;
            }
            textView9.getPaint().setFakeBoldText(false);
        }
        ImageView imageView3 = this.iconView;
        if (imageView3 == null) {
            kotlin.jvm.internal.p.A("iconView");
            imageView3 = null;
        }
        addView(imageView3);
        if (this.tvEllipsis == null) {
            TextView textView10 = this.textView;
            if (textView10 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView10;
            }
            addView(textView2);
            return;
        }
        View view = new View(context2);
        this.paddingView = view;
        addView(view, g(5.0f), -2);
        addView(this.tvEllipsis, -2, -2);
        TextView textView11 = this.textView;
        if (textView11 == null) {
            kotlin.jvm.internal.p.A("textView");
            textView11 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = textView11.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams3).leftMargin = g(1.0f);
        TextView textView12 = this.tvEllipsis;
        if (textView12 != null) {
            textView12.setVisibility(8);
        }
        TextView textView13 = this.textView;
        if (textView13 == null) {
            kotlin.jvm.internal.p.A("textView");
        } else {
            textView2 = textView13;
        }
        addView(textView2);
    }

    public final boolean k(int status, int reason) {
        if (this.mStatus == status) {
            return true;
        }
        this.mStatus = status;
        if (this.mEnableSelfTextStyle) {
            TextView textView = null;
            if (status == 2) {
                TextView textView2 = this.textView;
                if (textView2 == null) {
                    kotlin.jvm.internal.p.A("textView");
                    textView2 = null;
                }
                textView2.setTextColor(Color.parseColor("#FF111111"));
                TextView textView3 = this.textView;
                if (textView3 == null) {
                    kotlin.jvm.internal.p.A("textView");
                } else {
                    textView = textView3;
                }
                textView.getPaint().setFakeBoldText(true);
            } else {
                TextView textView4 = this.textView;
                if (textView4 == null) {
                    kotlin.jvm.internal.p.A("textView");
                    textView4 = null;
                }
                textView4.setTextColor(Color.parseColor("#FF777777"));
                TextView textView5 = this.textView;
                if (textView5 == null) {
                    kotlin.jvm.internal.p.A("textView");
                } else {
                    textView = textView5;
                }
                textView.getPaint().setFakeBoldText(false);
            }
        }
        a.b bVar = this.viewStatusUpdateListener;
        if (bVar != null) {
            bVar.a(status, reason);
        }
        return false;
    }

    public final void l() {
        n();
        a aVar = new a("聆听中");
        this.listeningAnimRunnable = aVar;
        Handler handler = this.uiHandler;
        kotlin.jvm.internal.p.f(aVar);
        handler.post(aVar);
    }

    public void m() {
        com.stepos.ailauncher.speech.view.a.a(this, 1, 0, 2, null);
    }

    public final void n() {
        Runnable runnable = this.listeningAnimRunnable;
        if (runnable != null) {
            this.uiHandler.removeCallbacks(runnable);
        }
        this.listeningAnimRunnable = null;
    }

    public final void o() {
        this.isListening = false;
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    public final void p() {
        if (this.isListening) {
            o();
        }
    }

    public void q(String txt) {
        kotlin.jvm.internal.p.i(txt, "txt");
        k(2, 0);
        setAsrText(txt);
    }

    public final void setAsrText(String text) {
        String strT;
        String string;
        p();
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.p.A("textView");
            textView = null;
        }
        d dVar = textView instanceof d ? (d) textView : null;
        if (dVar != null) {
            dVar.setShowAnimation(true);
        }
        TextView textView3 = this.textView;
        if (textView3 == null) {
            kotlin.jvm.internal.p.A("textView");
        } else {
            textView2 = textView3;
        }
        if (text == null || (string = H.D1(text).toString()) == null || (strT = D.T(string, " ", "", false, 4, null)) == null) {
            strT = "";
        }
        textView2.setText(strT);
    }

    public final void setIcon(int resId) {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("iconView");
            imageView = null;
        }
        imageView.setImageResource(resId);
    }

    public final void setMAsrTextBackgroundColor(int i10) {
        this.mAsrTextBackgroundColor = i10;
    }

    public final void setMAsrTextStyle(int i10) {
        this.mAsrTextStyle = i10;
    }

    public void setOnViewClicked(p<? super Integer, ? super String, t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.viewClickEvent = listener;
    }

    public final void setRollingAsrTextBold(boolean isBold) {
        TextPaint paint;
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.p.A("textView");
            textView = null;
        }
        if (textView instanceof d) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView3;
            }
            ((d) textView2).setPaintBoldText(isBold);
            TextView textView4 = this.tvEllipsis;
            if (textView4 == null || (paint = textView4.getPaint()) == null) {
                return;
            }
            paint.setFakeBoldText(isBold);
        }
    }

    public final void setRollingAsrTextColor(int color) {
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.p.A("textView");
            textView = null;
        }
        if (textView instanceof d) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView3;
            }
            ((d) textView2).setTextPaintColor(color);
            TextView textView4 = this.tvEllipsis;
            if (textView4 != null) {
                textView4.setTextColor(color);
            }
        }
    }

    public final void setRollingAsrTextSize(float size) {
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.p.A("textView");
            textView = null;
        }
        if (textView instanceof d) {
            TextView textView3 = this.textView;
            if (textView3 == null) {
                kotlin.jvm.internal.p.A("textView");
            } else {
                textView2 = textView3;
            }
            ((d) textView2).setTextPaintSize(size);
            TextView textView4 = this.tvEllipsis;
            if (textView4 != null) {
                textView4.setTextSize(size);
            }
        }
    }

    public void setViewStatusUpdateListener(a.b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.viewStatusUpdateListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.p.i(context, "context");
    }
}
