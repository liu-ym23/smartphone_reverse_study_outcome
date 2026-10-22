package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1173v;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;
import p7.AppUI;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001d\u0010\u0015J!\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/b;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", "w0", "(Landroid/widget/FrameLayout;)V", "", "x0", "()Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "J0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)V", "Landroid/widget/TextView;", "F0", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "V0", "()Landroid/widget/ImageView;", "W0", "D0", "target", "", "raw", "b1", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Landroid/text/SpannableStringBuilder;", "source", SdCardDbCreator.FIELD_LASTLOC_ID, "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;)V", "LT5/f;", "a2a", "LT5/f;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3287b extends AppAutherBaseCardView {
    private T5.f a2a;
    private static final a Companion = new a(null);
    private static final Regex IMAGE_MARKDOWN = new Regex("!\\[[^\\]]*]\\([^)]*\\)");
    private static final Regex HTML_TAG = new Regex("<[^>]*>");
    private static final Regex LINK_MARKDOWN = new Regex("\\[([^\\]]+)]\\(([^)\\s]+)\\)");
    private static final Regex ORDERED_ITEM = new Regex("^\\s*(\\d+)[.)、]\\s+(.+)$");
    private static final Regex UNORDERED_ITEM = new Regex("^\\s*[-*+]\\s+(.+)$");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/b$a;", "", "<init>", "()V", "Lkotlin/text/Regex;", "IMAGE_MARKDOWN", "Lkotlin/text/Regex;", "HTML_TAG", "LINK_MARKDOWN", "ORDERED_ITEM", "UNORDERED_ITEM", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.b$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/appauther/b$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.b$b, reason: collision with other inner class name */
    public static final class C0311b extends ClickableSpan {
        final /* synthetic */ int $linkColor;
        final /* synthetic */ String $url;

        public C0311b(String str, int i10) {
            this.$url = str;
            this.$linkColor = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            N5.d.G(C3287b.this, null, this.$url, null, false, false, false, 60, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(this.$linkColor);
            ds.setUnderlineText(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3287b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void D0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        R5.b.INSTANCE.c("auther.action.click", Y8.j.a("card", "a2a"), Y8.j.a("taskId", model.getCardId()), Y8.j.a(Const.JSON_KEY_PROVIDER, model.getProvider()));
        r0(model);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView F0() {
        T5.f fVar = this.a2a;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("a2a");
            fVar = null;
        }
        TextView btnAutherPrimary = fVar.btnAutherPrimary;
        kotlin.jvm.internal.p.h(btnAutherPrimary, "btnAutherPrimary");
        return btnAutherPrimary;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void J0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        T5.f fVar = this.a2a;
        T5.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("a2a");
            fVar = null;
        }
        ImageView ivAutherIcon = fVar.ivAutherIcon;
        kotlin.jvm.internal.p.h(ivAutherIcon, "ivAutherIcon");
        A0(ivAutherIcon, model.getIconUrl());
        T5.f fVar3 = this.a2a;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("a2a");
            fVar3 = null;
        }
        TextView tvAutherTitle = fVar3.tvAutherTitle;
        kotlin.jvm.internal.p.h(tvAutherTitle, "tvAutherTitle");
        n(tvAutherTitle, model.getTitle());
        T5.f fVar4 = this.a2a;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("a2a");
        } else {
            fVar2 = fVar4;
        }
        TextView tvAutherDesc = fVar2.tvAutherDesc;
        kotlin.jvm.internal.p.h(tvAutherDesc, "tvAutherDesc");
        b1(tvAutherDesc, model.getDesc());
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public ImageView V0() {
        return null;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public TextView W0() {
        T5.f fVar = this.a2a;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("a2a");
            fVar = null;
        }
        TextView tvAutherStatus = fVar.tvAutherStatus;
        kotlin.jvm.internal.p.h(tvAutherStatus, "tvAutherStatus");
        return tvAutherStatus;
    }

    public final void a1(SpannableStringBuilder target, String source) {
        T5.f fVar = this.a2a;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("a2a");
            fVar = null;
        }
        int currentTextColor = fVar.tvAutherDesc.getCurrentTextColor();
        String strL = HTML_TAG.l(IMAGE_MARKDOWN.l(source, ""), "");
        int last = 0;
        for (La.m mVar : Regex.f(LINK_MARKDOWN, strL, 0, 2, null)) {
            String strSubstring = strL.substring(last, mVar.a().getFirst());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            target.append((CharSequence) strSubstring);
            String str = mVar.c().get(1);
            String str2 = mVar.c().get(2);
            int length = target.length();
            target.append((CharSequence) str);
            if (La.D.V(str2, "https://", true)) {
                target.setSpan(new C0311b(str2, currentTextColor), length, target.length(), 33);
            }
            last = mVar.a().getLast() + 1;
        }
        String strSubstring2 = strL.substring(last);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        target.append((CharSequence) strSubstring2);
    }

    public final void b1(TextView target, String raw) {
        if (raw == null || La.H.x0(raw) || La.D.L(raw, "null", true)) {
            target.setText((CharSequence) null);
            target.setVisibility(8);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List listA1 = La.H.a1(La.D.S(La.D.T(raw, ServerSentEventKt.END_OF_LINE, "\n", false, 4, null), '\r', '\n', false, 4, null), new char[]{'\n'}, false, 0, 6, null);
        int i10 = 0;
        for (Object obj : listA1) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String string = La.H.D1((String) obj).toString();
            La.m mVarJ = ORDERED_ITEM.j(string);
            La.m mVarJ2 = UNORDERED_ITEM.j(string);
            if (mVarJ != null) {
                spannableStringBuilder.append((CharSequence) mVarJ.c().get(1)).append(". ");
                a1(spannableStringBuilder, mVarJ.c().get(2));
            } else if (mVarJ2 != null) {
                spannableStringBuilder.append("• ");
                a1(spannableStringBuilder, mVarJ2.c().get(1));
            } else {
                a1(spannableStringBuilder, string);
            }
            if (i10 != C1173v.o(listA1)) {
                spannableStringBuilder.append('\n');
            }
            i10 = i11;
        }
        target.setText(spannableStringBuilder);
        target.setVisibility(La.H.x0(spannableStringBuilder) ? 8 : 0);
        target.setMovementMethod(LinkMovementMethod.getInstance());
        target.setLinksClickable(true);
        target.setHighlightColor(0);
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public void w0(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.f fVarB = T5.f.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(fVarB, "inflate(...)");
        this.a2a = fVarB;
    }

    @Override // com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView
    public boolean x0() {
        return this.a2a != null;
    }

    public /* synthetic */ C3287b(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
