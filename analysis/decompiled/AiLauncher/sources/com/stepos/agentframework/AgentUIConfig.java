package com.stepos.agentframework;

import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import d4.InterfaceC3955b;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\u0018\u0000 B2\u00020\u0001:\u00049CD)B\u009b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0017\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/stepos/agentframework/AgentUIConfig;", "Ljava/io/Serializable;", "", "withToolbar", "showClearContext", "showAudioCallIcon", "withInputLayout", "withToolExecuteView", "", "receiveItemBg", "chatViewBg", "sendItemBg", "withActionLayout", "withToolActionLayout", "showMsgTopSoundController", "Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "messageTextStyle", "", "hiddenUserMenuItemIds", "Ld4/b;", "loadingViewProvider", "<init>", "(ZZZZZIIIZZZLcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;Ljava/util/Set;Ld4/b;)V", "Z", "m", "()Z", ExifInterface.LONGITUDE_EAST, "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "x", "f", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", "D", "I", Const.INTENT_KEY_UMID, "()I", "u", "(I)V", Const.INTENT_KEY_APIKEY, "n", "e", "v", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "z", "k", "C", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "y", "Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "c", "()Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "t", "(Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;)V", "Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "q", "(Ljava/util/Set;)V", "Ld4/b;", "getLoadingViewProvider", "()Ld4/b;", "s", "(Ld4/b;)V", "Companion", "MessageTextStyle", "TextStyle", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentUIConfig implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int chatViewBg;
    private Set<Integer> hiddenUserMenuItemIds;
    private transient InterfaceC3955b loadingViewProvider;
    private MessageTextStyle messageTextStyle;
    private int receiveItemBg;
    private int sendItemBg;
    private boolean showAudioCallIcon;
    private boolean showClearContext;
    private boolean showMsgTopSoundController;
    private boolean withActionLayout;
    private boolean withInputLayout;
    private boolean withToolActionLayout;
    private boolean withToolExecuteView;
    private boolean withToolbar;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010+\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentframework/AgentUIConfig$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/AgentUIConfig;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/AgentUIConfig;", "", "withActionLayout", "c", "(Z)Lcom/stepos/agentframework/AgentUIConfig$a;", "withToolActionLayout", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "withToolExecuteView", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "receiveBg", "f", "(I)Lcom/stepos/agentframework/AgentUIConfig$a;", "sendBg", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "style", "e", "(Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;)Lcom/stepos/agentframework/AgentUIConfig$a;", "", "ids", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;)Lcom/stepos/agentframework/AgentUIConfig$a;", "Ld4/b;", Const.JSON_KEY_PROVIDER, Const.INTENT_KEY_UMID, "(Ld4/b;)Lcom/stepos/agentframework/AgentUIConfig$a;", "withToolbar", "Z", "withInputLayout", "showClearContext", "showAudioCallIcon", "receiveItemBg", "I", "chatViewBg", "sendItemBg", "showMsgTopSoundController", "messageTextStyle", "Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "loadingViewProvider", "Ld4/b;", "hiddenUserMenuItemIds", "Ljava/util/Set;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private InterfaceC3955b loadingViewProvider;
        private boolean showAudioCallIcon;
        private boolean showClearContext;
        private boolean showMsgTopSoundController;
        private boolean withToolbar = true;
        private boolean withInputLayout = true;
        private int receiveItemBg = -1;
        private int chatViewBg = -1;
        private int sendItemBg = -1;
        private boolean withActionLayout = true;
        private boolean withToolActionLayout = true;
        private boolean withToolExecuteView = true;
        private MessageTextStyle messageTextStyle = new MessageTextStyle(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        private Set<Integer> hiddenUserMenuItemIds = Y.e();

        public final AgentUIConfig a() {
            AgentUIConfig agentUIConfig = new AgentUIConfig(false, false, false, false, false, 0, 0, 0, false, false, false, null, null, null, 16383, null);
            agentUIConfig.E(this.withToolbar);
            agentUIConfig.A(this.withInputLayout);
            agentUIConfig.x(this.showClearContext);
            agentUIConfig.v(this.sendItemBg);
            agentUIConfig.n(this.chatViewBg);
            agentUIConfig.u(this.receiveItemBg);
            agentUIConfig.z(this.withActionLayout);
            agentUIConfig.C(this.withToolActionLayout);
            agentUIConfig.D(this.withToolExecuteView);
            agentUIConfig.y(this.showMsgTopSoundController);
            agentUIConfig.w(this.showAudioCallIcon);
            agentUIConfig.t(this.messageTextStyle);
            agentUIConfig.s(this.loadingViewProvider);
            agentUIConfig.q(this.hiddenUserMenuItemIds);
            return agentUIConfig;
        }

        public final a b(Set<Integer> ids) {
            p.i(ids, "ids");
            this.hiddenUserMenuItemIds = ids;
            return this;
        }

        public final a c(boolean withActionLayout) {
            this.withActionLayout = withActionLayout;
            return this;
        }

        public final a d(InterfaceC3955b provider) {
            this.loadingViewProvider = provider;
            return this;
        }

        public final a e(MessageTextStyle style) {
            p.i(style, "style");
            this.messageTextStyle = style;
            return this;
        }

        public final a f(int receiveBg) {
            this.receiveItemBg = receiveBg;
            return this;
        }

        public final a g(int sendBg) {
            this.sendItemBg = sendBg;
            return this;
        }

        public final a h(boolean withToolActionLayout) {
            this.withToolActionLayout = withToolActionLayout;
            return this;
        }

        public final a i(boolean withToolExecuteView) {
            this.withToolExecuteView = withToolExecuteView;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/AgentUIConfig$b;", "", "<init>", "()V", "Lcom/stepos/agentframework/AgentUIConfig$a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/AgentUIConfig$a;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.AgentUIConfig$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final a a() {
            return new a();
        }

        public Companion() {
        }
    }

    public AgentUIConfig() {
        this(false, false, false, false, false, 0, 0, 0, false, false, false, null, null, null, 16383, null);
    }

    public final void A(boolean z10) {
        this.withInputLayout = z10;
    }

    public final void C(boolean z10) {
        this.withToolActionLayout = z10;
    }

    public final void D(boolean z10) {
        this.withToolExecuteView = z10;
    }

    public final void E(boolean z10) {
        this.withToolbar = z10;
    }

    /* renamed from: a, reason: from getter */
    public final int getChatViewBg() {
        return this.chatViewBg;
    }

    public final Set<Integer> b() {
        return this.hiddenUserMenuItemIds;
    }

    /* renamed from: c, reason: from getter */
    public final MessageTextStyle getMessageTextStyle() {
        return this.messageTextStyle;
    }

    /* renamed from: d, reason: from getter */
    public final int getReceiveItemBg() {
        return this.receiveItemBg;
    }

    /* renamed from: e, reason: from getter */
    public final int getSendItemBg() {
        return this.sendItemBg;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShowAudioCallIcon() {
        return this.showAudioCallIcon;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getShowClearContext() {
        return this.showClearContext;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getShowMsgTopSoundController() {
        return this.showMsgTopSoundController;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getWithActionLayout() {
        return this.withActionLayout;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getWithInputLayout() {
        return this.withInputLayout;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getWithToolActionLayout() {
        return this.withToolActionLayout;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getWithToolExecuteView() {
        return this.withToolExecuteView;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getWithToolbar() {
        return this.withToolbar;
    }

    public final void n(int i10) {
        this.chatViewBg = i10;
    }

    public final void q(Set<Integer> set) {
        p.i(set, "<set-?>");
        this.hiddenUserMenuItemIds = set;
    }

    public final void s(InterfaceC3955b interfaceC3955b) {
        this.loadingViewProvider = interfaceC3955b;
    }

    public final void t(MessageTextStyle messageTextStyle) {
        p.i(messageTextStyle, "<set-?>");
        this.messageTextStyle = messageTextStyle;
    }

    public final void u(int i10) {
        this.receiveItemBg = i10;
    }

    public final void v(int i10) {
        this.sendItemBg = i10;
    }

    public final void w(boolean z10) {
        this.showAudioCallIcon = z10;
    }

    public final void x(boolean z10) {
        this.showClearContext = z10;
    }

    public final void y(boolean z10) {
        this.showMsgTopSoundController = z10;
    }

    public final void z(boolean z10) {
        this.withActionLayout = z10;
    }

    public AgentUIConfig(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, int i11, int i12, boolean z15, boolean z16, boolean z17, MessageTextStyle messageTextStyle, Set<Integer> hiddenUserMenuItemIds, InterfaceC3955b interfaceC3955b) {
        p.i(messageTextStyle, "messageTextStyle");
        p.i(hiddenUserMenuItemIds, "hiddenUserMenuItemIds");
        this.withToolbar = z10;
        this.showClearContext = z11;
        this.showAudioCallIcon = z12;
        this.withInputLayout = z13;
        this.withToolExecuteView = z14;
        this.receiveItemBg = i10;
        this.chatViewBg = i11;
        this.sendItemBg = i12;
        this.withActionLayout = z15;
        this.withToolActionLayout = z16;
        this.showMsgTopSoundController = z17;
        this.messageTextStyle = messageTextStyle;
        this.hiddenUserMenuItemIds = hiddenUserMenuItemIds;
        this.loadingViewProvider = interfaceC3955b;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/AgentUIConfig$MessageTextStyle;", "Ljava/io/Serializable;", "Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "receive", "sent", "<init>", "(Lcom/stepos/agentframework/AgentUIConfig$TextStyle;Lcom/stepos/agentframework/AgentUIConfig$TextStyle;)V", "Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "setReceive", "(Lcom/stepos/agentframework/AgentUIConfig$TextStyle;)V", Const.INTENT_KEY_PKGNAME, "setSent", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MessageTextStyle implements Serializable {
        private TextStyle receive;
        private TextStyle sent;

        public MessageTextStyle(TextStyle receive, TextStyle sent) {
            p.i(receive, "receive");
            p.i(sent, "sent");
            this.receive = receive;
            this.sent = sent;
        }

        /* renamed from: a, reason: from getter */
        public final TextStyle getReceive() {
            return this.receive;
        }

        /* renamed from: b, reason: from getter */
        public final TextStyle getSent() {
            return this.sent;
        }

        public /* synthetic */ MessageTextStyle(TextStyle textStyle, TextStyle textStyle2, int i10, i iVar) {
            if ((i10 & 1) != 0) {
                textStyle = new TextStyle(-13421773, 16.0f, 0.0f, 4, null);
            }
            if ((i10 & 2) != 0) {
                textStyle2 = new TextStyle(-16777216, 15.0f, 0.0f, 4, null);
            }
            this(textStyle, textStyle2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/AgentUIConfig$TextStyle;", "Ljava/io/Serializable;", "", "textColor", "", "textSizeSp", "lineSpacingMultiplier", "<init>", "(IFF)V", "I", Const.INTENT_KEY_PKGNAME, "()I", "setTextColor", "(I)V", "F", "c", "()F", "setTextSizeSp", "(F)V", Const.INTENT_KEY_APIKEY, "setLineSpacingMultiplier", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TextStyle implements Serializable {
        private float lineSpacingMultiplier;
        private int textColor;
        private float textSizeSp;

        public TextStyle(int i10, float f10, float f11) {
            this.textColor = i10;
            this.textSizeSp = f10;
            this.lineSpacingMultiplier = f11;
        }

        /* renamed from: a, reason: from getter */
        public final float getLineSpacingMultiplier() {
            return this.lineSpacingMultiplier;
        }

        /* renamed from: b, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        /* renamed from: c, reason: from getter */
        public final float getTextSizeSp() {
            return this.textSizeSp;
        }

        public /* synthetic */ TextStyle(int i10, float f10, float f11, int i11, i iVar) {
            this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? -1.0f : f10, (i11 & 4) != 0 ? 1.6f : f11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AgentUIConfig(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, int i11, int i12, boolean z15, boolean z16, boolean z17, MessageTextStyle messageTextStyle, Set set, InterfaceC3955b interfaceC3955b, int i13, i iVar) {
        MessageTextStyle messageTextStyle2;
        boolean z18 = (i13 & 1) != 0 ? true : z10;
        boolean z19 = (i13 & 2) != 0 ? false : z11;
        boolean z20 = (i13 & 4) != 0 ? false : z12;
        boolean z21 = (i13 & 8) != 0 ? true : z13;
        boolean z22 = (i13 & 16) != 0 ? true : z14;
        int i14 = (i13 & 32) != 0 ? -1 : i10;
        int i15 = (i13 & 64) != 0 ? -1 : i11;
        int i16 = (i13 & 128) == 0 ? i12 : -1;
        boolean z23 = (i13 & 256) != 0 ? true : z15;
        boolean z24 = (i13 & 512) == 0 ? z16 : true;
        boolean z25 = (i13 & 1024) == 0 ? z17 : false;
        TextStyle textStyle = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if ((i13 & 2048) != 0) {
            messageTextStyle2 = new MessageTextStyle(textStyle, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        } else {
            messageTextStyle2 = messageTextStyle;
        }
        this(z18, z19, z20, z21, z22, i14, i15, i16, z23, z24, z25, messageTextStyle2, (i13 & 4096) != 0 ? Y.e() : set, (i13 & b.THRESHOLD) != 0 ? null : interfaceC3955b);
    }
}
