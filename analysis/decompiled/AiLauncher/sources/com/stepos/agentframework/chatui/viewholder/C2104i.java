package com.stepos.agentframework.chatui.viewholder;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$raw;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.C1978a;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 @2\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J/\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010(R\u0014\u00104\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010(R\u0014\u00105\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00100R\u0017\u00106\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/i;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "isLike", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "H", "()V", "G", "Lcom/stepos/agentframework/chatui/N1;", "message", "I", "(Lcom/stepos/agentframework/chatui/N1;)V", "J", "Landroid/widget/ImageView;", "arrow", "delta", "", x5.d.EXTRA_ENABLED, "v", "(Landroid/widget/ImageView;Lcom/stepos/agentframework/chatui/N1;IZ)V", "u", "y", "(Lcom/stepos/agentframework/chatui/N1;)Z", "", "x", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", "iconCopy", "Landroid/widget/ImageView;", "iconLike", "iconDislike", "iconRefresh", "iconShare", "iconChannelLogo", "Landroid/widget/TextView;", "tvChannelSupport", "Landroid/widget/TextView;", "variantPager", "Landroid/view/View;", "iconVariantPrev", "iconVariantNext", "variantIndicator", "iconRead", "getIconRead", "()Landroid/widget/ImageView;", "Lcom/airbnb/lottie/LottieAnimationView;", "iconTtsPlaying", "Lcom/airbnb/lottie/LottieAnimationView;", "getIconTtsPlaying", "()Lcom/airbnb/lottie/LottieAnimationView;", "target", "Lcom/stepos/agentframework/chatui/N1;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.viewholder.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2104i extends AbstractC2106k {
    private static final String MUSIC_LIST_TEMPLATE_TYPE = "music_list";
    private static final String TAG = "ActionFooterLogo";
    private final ImageView iconChannelLogo;
    private final ImageView iconCopy;
    private final ImageView iconDislike;
    private final ImageView iconLike;
    private final ImageView iconRead;
    private final ImageView iconRefresh;
    private final ImageView iconShare;
    private final LottieAnimationView iconTtsPlaying;
    private final ImageView iconVariantNext;
    private final ImageView iconVariantPrev;
    private DisplayMessage target;
    private final TextView tvChannelSupport;
    private final TextView variantIndicator;
    private final View variantPager;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0003\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/chatui/viewholder/i$b", "Lcom/bumptech/glide/request/target/CustomViewTarget;", "Landroid/widget/ImageView;", "Landroid/graphics/drawable/Drawable;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/drawable/Drawable;Lcom/bumptech/glide/request/transition/Transition;)V", "errorDrawable", "onLoadFailed", "(Landroid/graphics/drawable/Drawable;)V", "placeholder", "onResourceCleared", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.i$b */
    public static final class b extends CustomViewTarget<ImageView, Drawable> {
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, ImageView imageView) {
            super(imageView);
            this.$url = str;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
            kotlin.jvm.internal.p.i(resource, "resource");
            C2104i.this.iconChannelLogo.setImageDrawable(resource);
            C2104i.this.iconChannelLogo.setVisibility(0);
            C2104i.this.tvChannelSupport.setVisibility(0);
            C4148a.k(C2104i.TAG, "logo load ok url=" + this.$url, false, 4, null);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable errorDrawable) {
            C2104i.this.iconChannelLogo.setVisibility(8);
            C2104i.this.tvChannelSupport.setVisibility(8);
            C4148a.u(C2104i.TAG, "logo load FAILED url=" + this.$url, false, 4, null);
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable placeholder) {
            C2104i.this.iconChannelLogo.setImageDrawable(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2104i(View itemView, U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.iv_copy);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.iconCopy = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.iv_like);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.iconLike = (ImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.iv_dislike);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.iconDislike = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.iv_refresh);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.iconRefresh = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.iv_share);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.iconShare = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R$id.iv_channel_logo);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        this.iconChannelLogo = (ImageView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R$id.tv_channel_support);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        this.tvChannelSupport = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R$id.variant_pager);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        this.variantPager = viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R$id.iv_variant_prev);
        kotlin.jvm.internal.p.h(viewFindViewById9, "findViewById(...)");
        this.iconVariantPrev = (ImageView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R$id.iv_variant_next);
        kotlin.jvm.internal.p.h(viewFindViewById10, "findViewById(...)");
        this.iconVariantNext = (ImageView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R$id.tv_variant_indicator);
        kotlin.jvm.internal.p.h(viewFindViewById11, "findViewById(...)");
        this.variantIndicator = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R$id.iv_read);
        kotlin.jvm.internal.p.h(viewFindViewById12, "findViewById(...)");
        this.iconRead = (ImageView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R$id.lottieTtsPlaying);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewFindViewById13;
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setAnimation(R$raw.lottie_chat_tts_playing);
        kotlin.jvm.internal.p.h(viewFindViewById13, "apply(...)");
        this.iconTtsPlaying = lottieAnimationView;
    }

    public static final void A(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().i(c2104i.getBindingAdapterPosition(), displayMessage);
    }

    public static final void B(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().D(c2104i.getBindingAdapterPosition(), displayMessage);
    }

    public static final void C(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().Q(c2104i.getBindingAdapterPosition(), displayMessage);
    }

    public static final void D(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().e(c2104i.getBindingAdapterPosition(), displayMessage);
    }

    public static final void E(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().P(c2104i.getBindingAdapterPosition(), displayMessage);
        c2104i.H();
    }

    public static final void F(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().d(c2104i.getBindingAdapterPosition(), displayMessage);
        c2104i.G();
    }

    public static final void w(C2104i c2104i, DisplayMessage displayMessage, int i10, View view) {
        c2104i.getChatView().f(c2104i.getBindingAdapterPosition(), displayMessage, i10);
    }

    public static final void z(C2104i c2104i, DisplayMessage displayMessage, View view) {
        c2104i.getChatView().z(c2104i.getBindingAdapterPosition(), displayMessage);
    }

    public final void G() {
        this.iconTtsPlaying.cancelAnimation();
        ExtKt.p(this.iconTtsPlaying);
        ExtKt.C(this.iconRead);
    }

    public final void H() {
        ExtKt.C(this.iconTtsPlaying);
        this.iconTtsPlaying.playAnimation();
        ExtKt.p(this.iconRead);
    }

    public final void I(DisplayMessage message) {
        boolean zC = message.c();
        ImageView imageView = this.iconRefresh;
        if (zC) {
            ExtKt.C(imageView);
        } else {
            ExtKt.m(imageView);
        }
    }

    public final void J(DisplayMessage message) {
        int variantCount = message.getVariantCount();
        if (variantCount <= 1) {
            ExtKt.m(this.variantPager);
            return;
        }
        ExtKt.C(this.variantPager);
        int iN = C5685n.n(message.getVariantIndex() + 1, 1, variantCount);
        this.variantIndicator.setText(this.itemView.getContext().getString(R$string.chat_variant_indicator, Integer.valueOf(iN), Integer.valueOf(variantCount)));
        v(this.iconVariantPrev, message, -1, iN > 1);
        v(this.iconVariantNext, message, 1, iN < variantCount);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        C1978a c1978a = item instanceof C1978a ? (C1978a) item : null;
        if (c1978a == null) {
            return;
        }
        final DisplayMessage target = c1978a.getTarget();
        this.target = target;
        i(target.getLikeStatus());
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.itemView.getContext().getColor(R$color.chat_action_icon_default));
        kotlin.jvm.internal.p.h(colorStateListValueOf, "valueOf(...)");
        this.iconCopy.setImageTintList(colorStateListValueOf);
        this.iconRefresh.setImageTintList(colorStateListValueOf);
        this.iconCopy.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.z(this.f23182a, target, view);
            }
        });
        this.iconLike.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.A(this.f23184a, target, view);
            }
        });
        this.iconDislike.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.B(this.f23186a, target, view);
            }
        });
        this.iconRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.C(this.f23188a, target, view);
            }
        });
        this.iconShare.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.D(this.f23190a, target, view);
            }
        });
        I(target);
        J(target);
        this.iconRead.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.E(this.f23192a, target, view);
            }
        });
        this.iconTtsPlaying.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.F(this.f23194a, target, view);
            }
        });
        u(target);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void i(int isLike) {
        this.iconLike.setImageResource(isLike == 1 ? R$drawable.ic_action_liked : R$drawable.ic_action_like);
        this.iconDislike.setImageResource(isLike == 2 ? com.stepos.agentframework.uikit.R$drawable.ic_disliked : R$drawable.ic_popup_dislike);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.itemView.getContext().getColor(R.color.white));
        kotlin.jvm.internal.p.h(colorStateListValueOf, "valueOf(...)");
        ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(this.itemView.getContext().getColor(R$color.chat_action_icon_default));
        kotlin.jvm.internal.p.h(colorStateListValueOf2, "valueOf(...)");
        this.iconLike.setImageTintList(isLike == 1 ? colorStateListValueOf : colorStateListValueOf2);
        ImageView imageView = this.iconDislike;
        if (isLike != 2) {
            colorStateListValueOf = colorStateListValueOf2;
        }
        imageView.setImageTintList(colorStateListValueOf);
    }

    public final void u(DisplayMessage message) {
        this.iconChannelLogo.setVisibility(8);
        this.tvChannelSupport.setVisibility(8);
        this.iconChannelLogo.setImageDrawable(null);
        try {
            Result.Companion companion = Result.INSTANCE;
            Glide.with(this.itemView).clear(this.iconChannelLogo);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (!y(message)) {
            this.tvChannelSupport.setText("支持");
            String strX = x(message);
            if (strX == null || La.H.x0(strX)) {
                return;
            }
            Glide.with(this.itemView).load(strX).override(Integer.MIN_VALUE).into((RequestBuilder) new b(strX, this.iconChannelLogo));
            return;
        }
        this.iconChannelLogo.setImageResource(R$drawable.ic_migu_brand_logo);
        this.iconChannelLogo.setVisibility(0);
        this.tvChannelSupport.setText("提供");
        this.tvChannelSupport.setVisibility(0);
        C4148a.k(TAG, "migu logo local msgId=" + message.getMessageId(), false, 4, null);
    }

    public final void v(ImageView arrow, final DisplayMessage message, final int delta, boolean enabled) {
        arrow.setEnabled(enabled);
        arrow.setClickable(enabled);
        arrow.setAlpha(enabled ? 0.8f : 0.3f);
        arrow.setOnClickListener(enabled ? new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2104i.w(this.f23196a, message, delta, view);
            }
        } : null);
    }

    public final String x(DisplayMessage message) {
        Iterator<T> it = message.m().iterator();
        int i10 = 0;
        String str = null;
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF != null) {
                for (DisplayTool displayTool : listF) {
                    i10++;
                    AppUIData appUIData = displayTool.getAppUIData();
                    Object structuredContent = appUIData != null ? appUIData.getStructuredContent() : null;
                    Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
                    Object obj = map != null ? map.get("bizChannelIcon") : null;
                    Map map2 = obj instanceof Map ? (Map) obj : null;
                    Object obj2 = map2 != null ? map2.get("icon") : null;
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    C4148a.k(TAG, "probe msgId=" + message.getMessageId() + " toolCallId=" + displayTool.getToolCallId() + " scType=" + (structuredContent != null ? structuredContent.getClass().getSimpleName() : null) + " keys=" + (map != null ? map.keySet() : null) + " bizChannel=" + (map != null ? map.get("bizChannel") : null) + " bizIconType=" + (obj != null ? obj.getClass().getSimpleName() : null) + " icon=" + str2, false, 4, null);
                    if (str2 != null && !La.H.x0(str2)) {
                        str = str2;
                    }
                }
            }
        }
        C4148a.k(TAG, "result msgId=" + message.getMessageId() + " tools=" + i10 + " url=" + ((Object) str), false, 4, null);
        return str;
    }

    public final boolean y(DisplayMessage message) {
        Iterator<T> it = message.m().iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF != null) {
                Iterator<T> it2 = listF.iterator();
                while (it2.hasNext()) {
                    AppUIData appUIData = ((DisplayTool) it2.next()).getAppUIData();
                    Object structuredContent = appUIData != null ? appUIData.getStructuredContent() : null;
                    Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
                    if (map != null) {
                        if (kotlin.jvm.internal.p.d(map.get("templateType"), "music_list")) {
                            return true;
                        }
                        Object obj = map.get("businessData");
                        Map map2 = obj instanceof Map ? (Map) obj : null;
                        if (map.get("brandLogoUrl") == null) {
                            if ((map2 != null ? map2.get("brandLogoUrl") : null) == null) {
                                continue;
                            }
                        }
                        if (!kotlin.jvm.internal.p.d(map.get("brandName"), "咪咕音乐")) {
                            if (kotlin.jvm.internal.p.d(map2 != null ? map2.get("brandName") : null, "咪咕音乐")) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
