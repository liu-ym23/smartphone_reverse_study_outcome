package com.stepos.ailauncher.chat.voice.longpress;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001:\u00024;B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\rJ-\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u000fJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u000fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b \u0010\u001dJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u000fJ!\u0010%\u001a\u00020\u000b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\"¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u000fJ\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u000fJ\u0017\u0010+\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u000b¢\u0006\u0004\b1\u0010\u000fJ\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00132\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u000b¢\u0006\u0004\b:\u0010\u000fJ\u000f\u0010;\u001a\u00020\u000bH\u0002¢\u0006\u0004\b;\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010<R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR*\u0010C\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010=\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010J\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010L\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bK\u0010\u001aR\u0011\u0010N\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bM\u0010\u001aR\u0011\u0010P\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bO\u0010\u001aR\u0011\u0010R\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bQ\u0010\u001a¨\u0006S"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/Q;", "", "Lcom/stepos/ailauncher/chat/voice/longpress/Q$b;", "inputBar", "Lkotlin/Function0;", "Lcom/stepos/ailauncher/chat/voice/longpress/Q$a;", "createFullScreen", "<init>", "(Lcom/stepos/ailauncher/chat/voice/longpress/Q$b;Lp9/a;)V", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "presentation", "LY8/t;", "u", "(Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;)V", "o", "()V", "p", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "strategy", "", "moveCenterHorizontally", "holdToTalk", "withKeyFeedback", "y", "(Lcom/stepos/ailauncher/chat/voice/longpress/l;ZZZ)V", "c", "()Z", "showWaiting", "e", "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "t", "q", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingExitResult;", "onFinished", "s", "(Lp9/l;)V", "z", "r", "", "text", "v", "(Ljava/lang/CharSequence;)V", "", "hintRes", "w", "(I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/stepos/ailauncher/speech/dialog/c;", "view", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/speech/dialog/c;)V", "", "data", "n", "([S)Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/chat/voice/longpress/Q$b;", "Lp9/a;", "Lcom/stepos/ailauncher/chat/voice/longpress/T;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/voice/longpress/T;", "fullScreen", "Lcom/stepos/ailauncher/chat/voice/longpress/Q$a;", "presentationProvider", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lp9/a;", "x", "(Lp9/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "current", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "usesInputBar", "l", "isInputBarActive", "m", "isInputBarFinalizing", "k", "isFullScreenListening", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Q {
    private final InterfaceC5063a<a> createFullScreen;
    private a fullScreen;
    private final b inputBar;
    private InterfaceC5063a<? extends RecordingPresentation> presentationProvider;
    private final T state;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u0012J#\u0010\u0018\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH&¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0010R\u0014\u0010&\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010¨\u0006'À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/Q$a;", "", "", "withKeyFeedback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)Z", "", "hintRes", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "", "text", "l", "(Ljava/lang/CharSequence;)V", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "f", "release", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingExitResult;", "onFinished", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;)V", Const.INTENT_KEY_PKGNAME, "", "volume", "k", "(F)V", "e", "Lcom/stepos/ailauncher/speech/dialog/c;", "view", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/speech/dialog/c;)V", "c", "isListening", "isRunning", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        boolean a();

        void b();

        boolean c();

        void d(com.stepos.ailauncher.speech.dialog.c view);

        void e();

        void f();

        void g(InterfaceC5074l<? super RecordingExitResult, Y8.t> onFinished);

        boolean h(boolean withKeyFeedback);

        void i(int hintRes);

        boolean isRunning();

        void j();

        void k(float volume);

        void l(CharSequence text);

        void release();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0017\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/Q$b;", "", "", "visible", "LY8/t;", "setVisible", "(Z)V", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "strategy", "moveCenterHorizontally", "holdToTalk", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/voice/longpress/l;ZZ)V", "cancel", "()V", Const.INTENT_KEY_APIKEY, "e", "", "data", "c", "([S)V", "destroy", "isAvailable", "()Z", "isVisible", Const.INTENT_KEY_PKGNAME, "isActive", "f", "isFinalizing", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a();

        boolean b();

        void c(short[] data);

        void cancel();

        void d(InterfaceC3047l strategy, boolean moveCenterHorizontally, boolean holdToTalk);

        void destroy();

        void e();

        boolean f();

        boolean isAvailable();

        boolean isVisible();

        void setVisible(boolean visible);
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingPresentation.values().length];
            try {
                iArr[RecordingPresentation.INPUT_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordingPresentation.FULL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Q(b inputBar, InterfaceC5063a<? extends a> createFullScreen) {
        kotlin.jvm.internal.p.i(inputBar, "inputBar");
        kotlin.jvm.internal.p.i(createFullScreen, "createFullScreen");
        this.inputBar = inputBar;
        this.createFullScreen = createFullScreen;
        this.state = new T();
    }

    public final void A() {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void a() {
        this.inputBar.setVisible(h() == RecordingPresentation.INPUT_BAR);
    }

    public final void b(com.stepos.ailauncher.speech.dialog.c view) {
        kotlin.jvm.internal.p.i(view, "view");
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.d(view);
        }
    }

    public final boolean c() {
        a aVar = this.fullScreen;
        return aVar != null && aVar.a();
    }

    public final void d() {
        this.inputBar.destroy();
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.f();
        }
        this.fullScreen = null;
        this.presentationProvider = null;
        this.state.b();
    }

    public final void e(boolean showWaiting) {
        b bVar = this.inputBar;
        if (showWaiting) {
            bVar.a();
        } else {
            bVar.cancel();
        }
    }

    public final void f() {
        this.state.b();
    }

    public final void g() {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.j();
        }
        this.inputBar.e();
        this.state.b();
    }

    public final RecordingPresentation h() {
        return this.state.getCurrent();
    }

    public final InterfaceC5063a<RecordingPresentation> i() {
        return this.presentationProvider;
    }

    public final boolean j() {
        return h() == RecordingPresentation.INPUT_BAR && this.inputBar.isAvailable();
    }

    public final boolean k() {
        a aVar = this.fullScreen;
        return aVar != null && aVar.c();
    }

    public final boolean l() {
        return this.inputBar.b();
    }

    public final boolean m() {
        return this.inputBar.f();
    }

    public final boolean n(short[] data) {
        kotlin.jvm.internal.p.i(data, "data");
        a aVar = this.fullScreen;
        if (aVar == null || !aVar.isRunning()) {
            if (!this.inputBar.b()) {
                return false;
            }
            this.inputBar.c(data);
            return true;
        }
        a aVar2 = this.fullScreen;
        if (aVar2 != null) {
            aVar2.k(p0.b(p0.INSTANCE, data, 0.0f, 2, null));
        }
        return true;
    }

    public final void o() {
        RecordingPresentation recordingPresentationInvoke;
        InterfaceC5063a<? extends RecordingPresentation> interfaceC5063a = this.presentationProvider;
        if (interfaceC5063a == null || (recordingPresentationInvoke = interfaceC5063a.invoke()) == null) {
            recordingPresentationInvoke = this.inputBar.isVisible() ? RecordingPresentation.INPUT_BAR : RecordingPresentation.FULL_SCREEN;
        }
        p(recordingPresentationInvoke);
    }

    public final void p(RecordingPresentation presentation) {
        kotlin.jvm.internal.p.i(presentation, "presentation");
        this.state.d(presentation);
        a();
    }

    public final void q() {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void r() {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void s(InterfaceC5074l<? super RecordingExitResult, Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        a aVar = this.fullScreen;
        if (aVar == null) {
            onFinished.invoke(RecordingExitResult.COMPLETED);
        } else {
            aVar.g(onFinished);
        }
    }

    public final void t(boolean withKeyFeedback) {
        a aVar;
        if (h() == RecordingPresentation.FULL_SCREEN || ((aVar = this.fullScreen) != null && aVar.isRunning())) {
            a aVar2 = this.fullScreen;
            if (aVar2 != null) {
                aVar2.f();
            }
            a aVarInvoke = this.fullScreen;
            if (aVarInvoke == null) {
                aVarInvoke = this.createFullScreen.invoke();
                this.fullScreen = aVarInvoke;
            }
            aVarInvoke.h(withKeyFeedback);
        }
    }

    public final void u(RecordingPresentation presentation) {
        kotlin.jvm.internal.p.i(presentation, "presentation");
        this.state.e(presentation);
        a();
    }

    public final void v(CharSequence text) {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.l(text);
        }
    }

    public final void w(int hintRes) {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.i(hintRes);
        }
    }

    public final void x(InterfaceC5063a<? extends RecordingPresentation> interfaceC5063a) {
        this.presentationProvider = interfaceC5063a;
    }

    public final void y(InterfaceC3047l strategy, boolean moveCenterHorizontally, boolean holdToTalk, boolean withKeyFeedback) {
        kotlin.jvm.internal.p.i(strategy, "strategy");
        int i10 = c.$EnumSwitchMapping$0[this.state.a().ordinal()];
        if (i10 == 1) {
            a aVar = this.fullScreen;
            if (aVar != null) {
                aVar.f();
            }
            a();
            this.inputBar.d(strategy, moveCenterHorizontally, holdToTalk);
            return;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        a aVarInvoke = this.fullScreen;
        if (aVarInvoke == null) {
            aVarInvoke = this.createFullScreen.invoke();
            this.fullScreen = aVarInvoke;
        }
        if (aVarInvoke.h(withKeyFeedback)) {
            aVarInvoke.i(strategy.b(holdToTalk));
        }
    }

    public final void z() {
        a aVar = this.fullScreen;
        if (aVar != null) {
            aVar.f();
        }
    }
}
