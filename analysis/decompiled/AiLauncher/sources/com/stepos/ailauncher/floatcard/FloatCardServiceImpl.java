package com.stepos.ailauncher.floatcard;

import E4.FloatCardContent;
import E4.FloatCardRequest;
import E4.d;
import E4.e;
import E4.p;
import E4.q;
import E4.r;
import G4.h;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.A;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.AccountStatus;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import com.stepos.ailauncher.floatcard.api.IFloatCardProvider;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.d;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u00020JB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b&\u0010\u0012J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0004J\u0019\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010)J'\u0010,\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\"H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\"H\u0002¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0019\u0010:\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00050<j\b\u0012\u0004\u0012\u00020\u0005`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020D0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010BR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/stepos/ailauncher/floatcard/FloatCardServiceImpl;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "LE4/q;", "<init>", "()V", "LE4/r;", "host", "LY8/t;", "registerHost", "(LE4/r;)V", "unregisterHost", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;", Const.JSON_KEY_PROVIDER, "registerProvider", "(Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;)V", "", "type", "unregisterProvider", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "handler", "registerEventHandler", "(Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;)V", "businessType", "unregisterEventHandler", "LE4/k;", "request", "show", "(LE4/k;)V", "cardId", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(Ljava/lang/String;LE4/c;)V", "", "animated", DidiCardProvider.ACTION_DISMISS, "(Ljava/lang/String;Z)V", "e", "dismissAll", "hostIdOf", "(Ljava/lang/String;)Ljava/lang/String;", "text", "isFinal", "pushVoiceText", "(Ljava/lang/String;Ljava/lang/String;Z)V", "LE4/d;", "event", Const.INTENT_KEY_APIKEY, "(LE4/d;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "LE4/e;", "result", "f", "(Ljava/lang/String;LE4/e;)V", "Lcom/stepos/agentframework/floatcard/api/FloatCardScene;", HomeGestureEligibilityContract.EXTRA_SCENE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/floatcard/api/FloatCardScene;)LE4/r;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "hosts", "Ljava/util/LinkedHashSet;", "", "providers", "Ljava/util/Map;", "handlers", "Lcom/stepos/ailauncher/floatcard/FloatCardServiceImpl$a;", "activeCards", "LUa/M;", "scope", "LUa/M;", "Companion", Const.INTENT_KEY_PKGNAME, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatCardServiceImpl implements IFloatCardService, q {
    private static final b Companion = new b(null);
    private static final String TAG = "FloatCardService";
    private final LinkedHashSet<r> hosts = new LinkedHashSet<>();
    private final Map<String, IFloatCardProvider> providers = new LinkedHashMap();
    private final Map<String, IFloatCardEventHandler> handlers = new LinkedHashMap();
    private final Map<String, ActiveCard> activeCards = new LinkedHashMap();
    private final M scope = d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/floatcard/FloatCardServiceImpl$a;", "", "LE4/k;", "request", "LE4/r;", "host", "LE4/p;", "card", "<init>", "(LE4/k;LE4/r;LE4/p;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LE4/k;", "c", "()LE4/k;", Const.INTENT_KEY_UMID, "(LE4/k;)V", "LE4/r;", Const.INTENT_KEY_PKGNAME, "()LE4/r;", "LE4/p;", Const.INTENT_KEY_APIKEY, "()LE4/p;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.floatcard.FloatCardServiceImpl$a, reason: from toString */
    public static final /* data */ class ActiveCard {
        private final p card;
        private final r host;
        private FloatCardRequest request;

        public ActiveCard(FloatCardRequest request, r host, p card) {
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(host, "host");
            kotlin.jvm.internal.p.i(card, "card");
            this.request = request;
            this.host = host;
            this.card = card;
        }

        /* renamed from: a, reason: from getter */
        public final p getCard() {
            return this.card;
        }

        /* renamed from: b, reason: from getter */
        public final r getHost() {
            return this.host;
        }

        /* renamed from: c, reason: from getter */
        public final FloatCardRequest getRequest() {
            return this.request;
        }

        public final void d(FloatCardRequest floatCardRequest) {
            kotlin.jvm.internal.p.i(floatCardRequest, "<set-?>");
            this.request = floatCardRequest;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveCard)) {
                return false;
            }
            ActiveCard activeCard = (ActiveCard) other;
            return kotlin.jvm.internal.p.d(this.request, activeCard.request) && kotlin.jvm.internal.p.d(this.host, activeCard.host) && kotlin.jvm.internal.p.d(this.card, activeCard.card);
        }

        public int hashCode() {
            return (((this.request.hashCode() * 31) + this.host.hashCode()) * 31) + this.card.hashCode();
        }

        public String toString() {
            return "ActiveCard(request=" + this.request + ", host=" + this.host + ", card=" + this.card + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/floatcard/FloatCardServiceImpl$b;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        public /* synthetic */ b(i iVar) {
            this();
        }

        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.floatcard.FloatCardServiceImpl$pushVoiceText$1", f = "FloatCardServiceImpl.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.floatcard.FloatCardServiceImpl$pushVoiceText$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ String $cardId;
        final /* synthetic */ boolean $isFinal;
        final /* synthetic */ String $text;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, boolean z10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$cardId = str;
            this.$text = str2;
            this.$isFinal = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = FloatCardServiceImpl.this.new AnonymousClass1(this.$cardId, this.$text, this.$isFinal, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ActiveCard activeCard = (ActiveCard) FloatCardServiceImpl.this.activeCards.get(this.$cardId);
            if (activeCard != null) {
                activeCard.getCard().f(this.$text, this.$isFinal);
                return t.f7040a;
            }
            Log.w(FloatCardServiceImpl.TAG, "pushVoiceText: no active card for id=" + this.$cardId);
            return t.f7040a;
        }
    }

    public FloatCardServiceImpl() {
        registerProvider(new a());
    }

    public static final boolean i(r rVar, Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        ActiveCard activeCard = (ActiveCard) entry.getValue();
        if (activeCard.getHost() != rVar) {
            return false;
        }
        activeCard.getCard().destroy();
        return true;
    }

    @Override // E4.q
    public void a(E4.d event) {
        p card;
        r host;
        Context context;
        kotlin.jvm.internal.p.i(event, "event");
        ActiveCard activeCard = this.activeCards.get(event.getCardId());
        IFloatCardEventHandler iFloatCardEventHandler = this.handlers.get(event.getBusinessType());
        if (iFloatCardEventHandler == null) {
            if (event instanceof d.Exposed) {
                return;
            }
            Log.w(TAG, "dispatch: no handler for businessType=" + event.getBusinessType());
            return;
        }
        if (event instanceof d.Exposed) {
            C1060i.d(this.scope, null, null, new FloatCardServiceImpl$dispatch$1(iFloatCardEventHandler, event, null), 3, null);
            return;
        }
        if (!g()) {
            if (activeCard != null && (card = activeCard.getCard()) != null) {
                p.b(card, true, null, 2, null);
            }
            C1060i.d(this.scope, null, null, new FloatCardServiceImpl$dispatch$3(this, event, iFloatCardEventHandler, null), 3, null);
            return;
        }
        if (activeCard == null || (host = activeCard.getHost()) == null || (context = host.getContext()) == null) {
            return;
        }
        Toast.makeText(context, com.stepos.agentframework.floatcard.R$string.account_banned_no_time, 0).show();
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void dismiss(String cardId, boolean animated) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        ActiveCard activeCardRemove = this.activeCards.remove(cardId);
        if (activeCardRemove == null) {
            return;
        }
        activeCardRemove.getHost().b(cardId, animated);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void dismissAll() {
        Iterator it = F.m1(this.activeCards.keySet()).iterator();
        while (it.hasNext()) {
            e((String) it.next());
        }
    }

    public void e(String cardId) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        dismiss(cardId, true);
    }

    public final void f(String cardId, e result) {
        r host;
        Context context;
        Object objB;
        p card;
        p card2;
        p card3;
        p card4;
        ActiveCard activeCard = this.activeCards.get(cardId);
        if (kotlin.jvm.internal.p.d(result, e.C0026e.INSTANCE)) {
            if (activeCard == null || (card4 = activeCard.getCard()) == null) {
                return;
            }
            p.b(card4, false, null, 2, null);
            return;
        }
        if (kotlin.jvm.internal.p.d(result, e.a.INSTANCE)) {
            e(cardId);
            return;
        }
        if (result instanceof e.Loading) {
            if (activeCard == null || (card3 = activeCard.getCard()) == null) {
                return;
            }
            card3.d(true, ((e.Loading) result).getMessage());
            return;
        }
        if (result instanceof e.Update) {
            if (activeCard != null && (card2 = activeCard.getCard()) != null) {
                p.b(card2, false, null, 2, null);
            }
            update(cardId, ((e.Update) result).getContent());
            return;
        }
        if (result instanceof e.Error) {
            if (activeCard == null || (card = activeCard.getCard()) == null) {
                return;
            }
            e.Error error = (e.Error) result;
            card.c(error.getMessage(), error.getRetryable());
            return;
        }
        if (!(result instanceof e.Navigate)) {
            throw new NoWhenBranchMatchedException();
        }
        if (activeCard == null || (host = activeCard.getHost()) == null || (context = host.getContext()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(((e.Navigate) result).getIntent());
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            p card5 = activeCard.getCard();
            String message = thE.getMessage();
            if (message == null) {
                message = "打开页面失败";
            }
            p.a(card5, message, false, 2, null);
        }
        if (((e.Navigate) result).getDismissCurrent()) {
            e(cardId);
        } else {
            p.b(activeCard.getCard(), false, null, 2, null);
        }
    }

    public final boolean g() {
        Xa.t<AccountStatus> status;
        IAccountStatusService iAccountStatusService = (IAccountStatusService) D5.a.INSTANCE.a(IAccountStatusService.class);
        return ((iAccountStatusService == null || (status = iAccountStatusService.getStatus()) == null) ? null : status.getValue()) instanceof AccountStatus.Banned;
    }

    public final r h(FloatCardScene scene) {
        LinkedHashSet<r> linkedHashSet = this.hosts;
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSet) {
            if (((r) obj).d(scene)) {
                arrayList.add(obj);
            }
        }
        Object next = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int priority = ((r) it.next()).getPriority();
        while (it.hasNext()) {
            int priority2 = ((r) it.next()).getPriority();
            if (priority < priority2) {
                priority = priority2;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((r) obj2).getPriority() == priority) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            if (c.a(((r) obj3).getContext())) {
                arrayList3.add(obj3);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2 = arrayList3;
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int priority3 = ((r) next).getPriority();
                do {
                    Object next2 = it2.next();
                    int priority4 = ((r) next2).getPriority();
                    if (priority3 < priority4) {
                        next = next2;
                        priority3 = priority4;
                    }
                } while (it2.hasNext());
            }
        }
        return (r) next;
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public String hostIdOf(String cardId) {
        r host;
        kotlin.jvm.internal.p.i(cardId, "cardId");
        ActiveCard activeCard = this.activeCards.get(cardId);
        if (activeCard == null || (host = activeCard.getHost()) == null) {
            return null;
        }
        return host.getHostId();
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void pushVoiceText(String cardId, String text, boolean isFinal) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(text, "text");
        C1060i.d(this.scope, null, null, new AnonymousClass1(cardId, text, isFinal, null), 3, null);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void registerEventHandler(IFloatCardEventHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        this.handlers.put(handler.getBusinessType(), handler);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void registerHost(r host) {
        Set<FloatCardScene> setV;
        kotlin.jvm.internal.p.i(host, "host");
        String hostId = host.getHostId();
        ArrayList arrayList = null;
        h hVar = host instanceof h ? (h) host : null;
        if (hVar != null && (setV = hVar.v()) != null) {
            Set<FloatCardScene> set = setV;
            arrayList = new ArrayList(C1174w.x(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((FloatCardScene) it.next()).name());
            }
        }
        Log.w(TAG, "registerHost: hostId: " + hostId + ",  type=" + arrayList);
        this.hosts.remove(host);
        this.hosts.add(host);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void registerProvider(IFloatCardProvider provider) {
        kotlin.jvm.internal.p.i(provider, "provider");
        this.providers.put(provider.getType(), provider);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void show(FloatCardRequest request) {
        Set<String> setKeySet;
        kotlin.jvm.internal.p.i(request, "request");
        IFloatCardProvider iFloatCardProvider = this.providers.get(request.getType());
        if (iFloatCardProvider == null) {
            Log.w(TAG, "show: no provider for type=" + request.getType());
            return;
        }
        r rVarH = h(request.getScene());
        if (rVarH == null) {
            Log.w(TAG, "show: no host for scene=" + request.getScene());
            return;
        }
        boolean zA = c.a(rVarH.getContext());
        ActiveCard activeCard = this.activeCards.get(request.getCardId());
        if (activeCard != null) {
            if (activeCard.getHost() == rVarH) {
                activeCard.d(request);
                activeCard.getCard().e(request.getContent());
                activeCard.getHost().c(activeCard.getCard(), request.getOptions());
                return;
            }
            if (!zA) {
                Log.w(TAG, "show: cardId=" + request.getCardId() + " already on host=" + activeCard.getHost().getHostId() + ", skip steal by background host=" + rVarH.getHostId());
                return;
            }
            Log.i(TAG, "show: steal cardId=" + request.getCardId() + " from host=" + activeCard.getHost().getHostId() + " to foreground host=" + rVarH.getHostId());
            e(request.getCardId());
        }
        if (request.getOptions().getReplaceExisting()) {
            if (zA) {
                setKeySet = this.activeCards.keySet();
            } else {
                Map<String, ActiveCard> map = this.activeCards;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ActiveCard> entry : map.entrySet()) {
                    if (entry.getValue().getHost() == rVarH) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                setKeySet = linkedHashMap.keySet();
            }
            Iterator it = F.m1(setKeySet).iterator();
            while (it.hasNext()) {
                e((String) it.next());
            }
        }
        p pVarCreateCard = iFloatCardProvider.createCard(rVarH.getContext(), request, this);
        this.activeCards.put(request.getCardId(), new ActiveCard(request, rVarH, pVarCreateCard));
        rVarH.c(pVarCreateCard, request.getOptions());
        a(new d.Exposed(request.getCardId(), request.getBusinessType(), request.getPayload()));
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void unregisterEventHandler(String businessType) {
        kotlin.jvm.internal.p.i(businessType, "businessType");
        this.handlers.remove(businessType);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void unregisterHost(final r host) {
        kotlin.jvm.internal.p.i(host, "host");
        Log.w(TAG, "unregisterHost:  hostid=" + host.getHostId());
        this.hosts.remove(host);
        A.J(this.activeCards.entrySet(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.floatcard.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(FloatCardServiceImpl.i(host, (Map.Entry) obj));
            }
        });
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void unregisterProvider(String type) {
        kotlin.jvm.internal.p.i(type, "type");
        this.providers.remove(type);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardService
    public void update(String cardId, FloatCardContent content) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(content, "content");
        ActiveCard activeCard = this.activeCards.get(cardId);
        if (activeCard != null) {
            activeCard.d(FloatCardRequest.b(activeCard.getRequest(), null, null, null, null, content, null, null, 111, null));
            activeCard.getHost().f(cardId, content);
            return;
        }
        Log.w(TAG, "update: no active card for id=" + cardId + ", activeCards=" + this.activeCards.keySet());
    }
}
