package com.stepos.agentframework.chatui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.lang.ref.WeakReference;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.C5732a;
import y4.InterfaceC5941c;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J#\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u001f\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J+\u0010)\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010,J%\u00100\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010-*\u00020 2\b\b\u0001\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u000f\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\b=\u0010>\"\u0004\b\u0010\u0010?R\"\u0010@\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00106\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R\"\u0010C\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00106\u001a\u0004\bD\u00108\"\u0004\bE\u0010:R\u001b\u0010I\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u00108R\u001b\u0010L\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u00108R\u001b\u0010O\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010G\u001a\u0004\bN\u00108R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcom/stepos/agentframework/chatui/AgentToolBar;", "Landroid/widget/FrameLayout;", "Ly4/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lw4/a;", "info", "LY8/t;", "setAgentInfo", "(Lw4/a;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "listener", "setOnBackClickListener", "(Lp9/a;)V", "setOnBtnNewChatClickedListener", "Lkotlin/Function1;", "", "setOnBtnPlaySoundClickedListener", "(Lp9/l;)V", "setOnBtnClearContextClickedListener", "setOnBtnAudioCallClickedListener", x5.d.EXTRA_ENABLED, "setBtnClearContextEnabled", "(Z)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUIConfig", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/stepos/agentframework/AgentUIConfig;)V", "destroy", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "id", Const.INTENT_KEY_APIKEY, "(I)Landroid/view/View;", "TAG", "Ljava/lang/String;", "Landroid/widget/ImageView;", "logo", "Landroid/widget/ImageView;", "getLogo", "()Landroid/widget/ImageView;", "setLogo", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", ChatTracker.TOPBAR_MENU, "getMenu", "setMenu", "ivNewChat", "getIvNewChat", "setIvNewChat", "autoTTSPlay$delegate", "LY8/h;", "getAutoTTSPlay", "autoTTSPlay", "ivClearContext$delegate", "getIvClearContext", "ivClearContext", "ivAudioCall$delegate", "getIvAudioCall", "ivAudioCall", "Ljava/lang/ref/WeakReference;", "sessionHandlerRef", "Ljava/lang/ref/WeakReference;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentToolBar extends FrameLayout implements InterfaceC5941c {
    private final String TAG;

    /* renamed from: autoTTSPlay$delegate, reason: from kotlin metadata */
    private final Y8.h autoTTSPlay;

    /* renamed from: ivAudioCall$delegate, reason: from kotlin metadata */
    private final Y8.h ivAudioCall;

    /* renamed from: ivClearContext$delegate, reason: from kotlin metadata */
    private final Y8.h ivClearContext;
    private ImageView ivNewChat;
    private ImageView logo;
    private ImageView menu;
    private WeakReference<SessionHandler> sessionHandlerRef;
    private TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.TAG = "AgentToolBar";
        this.autoTTSPlay = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.g1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentToolBar.n(this.f22965a);
            }
        });
        this.ivClearContext = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.h1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentToolBar.p(this.f22967a);
            }
        });
        this.ivAudioCall = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.i1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentToolBar.o(this.f22972a);
            }
        });
        LayoutInflater.from(context).inflate(R$layout.view_agent_toolbar, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.agent_logo);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.logo = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.agent_title);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.title = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.iv_newchat);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.ivNewChat = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.ivMenu);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.menu = (ImageView) viewFindViewById4;
        getAutoTTSPlay().setSelected(com.stepos.agentframework.util.E.e(com.stepos.agentframework.util.E.INSTANCE.a(), context, com.stepos.agentframework.util.C.INSTANCE.b(), false, null, 12, null));
        setBtnClearContextEnabled(false);
    }

    public static final ImageView n(AgentToolBar agentToolBar) {
        return (ImageView) agentToolBar.findViewById(R$id.tts_sound);
    }

    public static final ImageView o(AgentToolBar agentToolBar) {
        return (ImageView) agentToolBar.findViewById(R$id.iv_audio_call);
    }

    public static final ImageView p(AgentToolBar agentToolBar) {
        return (ImageView) agentToolBar.findViewById(R$id.iv_clear_context);
    }

    public static final void q(InterfaceC5063a interfaceC5063a, View view) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void r(InterfaceC5063a interfaceC5063a, View view) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void s(InterfaceC5063a interfaceC5063a, View view) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void t(AgentToolBar agentToolBar, InterfaceC5074l interfaceC5074l, View view) {
        agentToolBar.getAutoTTSPlay().setSelected(!agentToolBar.getAutoTTSPlay().isSelected());
        com.stepos.agentframework.util.E eA = com.stepos.agentframework.util.E.INSTANCE.a();
        Context context = agentToolBar.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.agentframework.util.E.k(eA, context, com.stepos.agentframework.util.C.INSTANCE.b(), agentToolBar.getAutoTTSPlay().isSelected(), null, 8, null);
        interfaceC5074l.invoke(Boolean.valueOf(agentToolBar.getAutoTTSPlay().isSelected()));
    }

    @Override // y4.InterfaceC5939a
    public <T extends View> T a(int id) {
        T autoTTSPlay = id == R$id.agent_logo ? this.logo : id == R$id.agent_title ? this.title : id == R$id.iv_newchat ? this.ivNewChat : id == R$id.ivMenu ? this.menu : id == R$id.tts_sound ? getAutoTTSPlay() : null;
        return autoTTSPlay == null ? (T) super.a(id) : autoTTSPlay;
    }

    @Override // y4.InterfaceC5939a
    public void b(SessionHandler handler) {
        this.sessionHandlerRef = new WeakReference<>(handler);
    }

    @Override // y4.InterfaceC5939a
    public void c(Context context, AttributeSet attrs, AgentUIConfig agentUIConfig) {
        kotlin.jvm.internal.p.i(context, "context");
        if (agentUIConfig != null) {
            setVisibility(agentUIConfig.getWithToolbar() ? 0 : 8);
            getIvClearContext().setVisibility(agentUIConfig.getShowClearContext() ? 0 : 8);
            getIvAudioCall().setVisibility(agentUIConfig.getShowAudioCallIcon() ? 0 : 8);
        }
    }

    @Override // y4.InterfaceC5939a
    public void destroy() {
    }

    public final ImageView getAutoTTSPlay() {
        Object value = this.autoTTSPlay.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (ImageView) value;
    }

    public final ImageView getIvAudioCall() {
        Object value = this.ivAudioCall.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (ImageView) value;
    }

    public final ImageView getIvClearContext() {
        Object value = this.ivClearContext.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (ImageView) value;
    }

    public final ImageView getIvNewChat() {
        return this.ivNewChat;
    }

    public final ImageView getLogo() {
        return this.logo;
    }

    public final ImageView getMenu() {
        return this.menu;
    }

    public final TextView getTitle() {
        return this.title;
    }

    @Override // y4.InterfaceC5939a
    public View getView() {
        return this;
    }

    @Override // y4.InterfaceC5941c
    public void setAgentInfo(C5732a info) {
        kotlin.jvm.internal.p.i(info, "info");
        this.title.setText(info.getAgentName());
        Glide.with(getContext()).load(info.getAvatarUrl()).transform(new CircleCrop()).placeholder(R$drawable.icon_agent_logo_default).into(this.logo);
    }

    @Override // y4.InterfaceC5941c
    public void setBtnClearContextEnabled(boolean enabled) {
        getIvClearContext().setEnabled(enabled);
        if (enabled) {
            getIvClearContext().clearColorFilter();
        } else {
            getIvClearContext().setColorFilter(getContext().getColor(R$color.icon_disabled));
        }
    }

    public final void setIvNewChat(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivNewChat = imageView;
    }

    public final void setLogo(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.logo = imageView;
    }

    public final void setMenu(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.menu = imageView;
    }

    public void setOnBackClickListener(InterfaceC5063a<Y8.t> listener) {
    }

    @Override // y4.InterfaceC5941c
    public void setOnBtnAudioCallClickedListener(final InterfaceC5063a<Y8.t> listener) {
        getIvAudioCall().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentToolBar.q(listener, view);
            }
        });
    }

    @Override // y4.InterfaceC5941c
    public void setOnBtnClearContextClickedListener(final InterfaceC5063a<Y8.t> listener) {
        getIvClearContext().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentToolBar.r(listener, view);
            }
        });
    }

    @Override // y4.InterfaceC5941c
    public void setOnBtnNewChatClickedListener(final InterfaceC5063a<Y8.t> listener) {
        this.ivNewChat.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentToolBar.s(listener, view);
            }
        });
    }

    @Override // y4.InterfaceC5941c
    public void setOnBtnPlaySoundClickedListener(final InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        getAutoTTSPlay().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentToolBar.t(this.f22984a, listener, view);
            }
        });
    }

    public void setTitle(String title) {
        kotlin.jvm.internal.p.i(title, "title");
    }

    public final void setTitle(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.title = textView;
    }
}
