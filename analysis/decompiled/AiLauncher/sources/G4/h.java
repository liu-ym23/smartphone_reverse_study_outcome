package G4;

import E4.FloatCardContent;
import E4.FloatCardOptions;
import E4.r;
import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u001a\b\u0002\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012\u0012 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0010H\u0002¢\u0006\u0004\b(\u0010)J=\u0010,\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015H\u0002¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u00100R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u00103R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u00108\u001a\u0004\b9\u0010:R&\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010;R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010<R,\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0004\u0012\u00020\u00100\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010;R\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006?"}, d2 = {"LG4/h;", "LE4/r;", "", "hostId", "", "priority", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "container", "", "Lcom/stepos/agentframework/floatcard/api/FloatCardScene;", "scenes", "Lkotlin/Function2;", "", "LE4/i;", "LY8/t;", "onCardVisibilityChanged", "Lkotlin/Function1;", "LE4/p;", "onHostEnterAnim", "Lkotlin/Function0;", "onHostExitAnim", "<init>", "(Ljava/lang/String;ILandroid/content/Context;Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;Ljava/util/Set;Lp9/p;Lp9/l;Lp9/p;)V", HomeGestureEligibilityContract.EXTRA_SCENE, Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/floatcard/api/FloatCardScene;)Z", "card", "options", "c", "(LE4/p;LE4/i;)V", "cardId", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "f", "(Ljava/lang/String;LE4/c;)V", "animated", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)V", "w", "()V", "afterHost", "fallback", "u", "(LE4/p;ZLp9/a;Lp9/a;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "I", "e", "()I", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "Ljava/util/Set;", "v", "()Ljava/util/Set;", "Lp9/p;", "Lp9/l;", "hostDrivenAnim", "Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h implements r {
    private final FloatCardContainerView container;
    private final Context context;
    private boolean hostDrivenAnim;
    private final String hostId;
    private final p<Boolean, FloatCardOptions, t> onCardVisibilityChanged;
    private final InterfaceC5074l<E4.p, t> onHostEnterAnim;
    private final p<E4.p, InterfaceC5063a<t>, t> onHostExitAnim;
    private final int priority;
    private final Set<FloatCardScene> scenes;

    /* JADX WARN: Multi-variable type inference failed */
    public h(String hostId, int i10, Context context, FloatCardContainerView container, Set<? extends FloatCardScene> scenes, p<? super Boolean, ? super FloatCardOptions, t> onCardVisibilityChanged, InterfaceC5074l<? super E4.p, t> onHostEnterAnim, p<? super E4.p, ? super InterfaceC5063a<t>, t> onHostExitAnim) {
        kotlin.jvm.internal.p.i(hostId, "hostId");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(scenes, "scenes");
        kotlin.jvm.internal.p.i(onCardVisibilityChanged, "onCardVisibilityChanged");
        kotlin.jvm.internal.p.i(onHostEnterAnim, "onHostEnterAnim");
        kotlin.jvm.internal.p.i(onHostExitAnim, "onHostExitAnim");
        this.hostId = hostId;
        this.priority = i10;
        this.context = context;
        this.container = container;
        this.scenes = scenes;
        this.onCardVisibilityChanged = onCardVisibilityChanged;
        this.onHostEnterAnim = onHostEnterAnim;
        this.onHostExitAnim = onHostExitAnim;
    }

    public static final t n(boolean z10, FloatCardOptions floatCardOptions) {
        kotlin.jvm.internal.p.i(floatCardOptions, "<unused var>");
        return t.f7040a;
    }

    public static final t o(E4.p it) {
        kotlin.jvm.internal.p.i(it, "it");
        return t.f7040a;
    }

    public static final t p(E4.p pVar, InterfaceC5063a onEnd) {
        kotlin.jvm.internal.p.i(pVar, "<unused var>");
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        onEnd.invoke();
        return t.f7040a;
    }

    public static final t q(final h hVar, String str) {
        hVar.container.i(str, new InterfaceC5063a() { // from class: G4.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.r(this.f2810a);
            }
        });
        return t.f7040a;
    }

    public static final t r(h hVar) {
        hVar.w();
        return t.f7040a;
    }

    public static final t s(final h hVar, String str) {
        hVar.container.f(str, new InterfaceC5063a() { // from class: G4.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.t(this.f2811a);
            }
        });
        return t.f7040a;
    }

    public static final t t(h hVar) {
        hVar.w();
        return t.f7040a;
    }

    @Override // E4.r
    /* renamed from: a, reason: from getter */
    public String getHostId() {
        return this.hostId;
    }

    @Override // E4.r
    public void b(final String cardId, boolean animated) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        E4.p currentCard = this.container.getCurrentCard();
        if (currentCard == null || !kotlin.jvm.internal.p.d(currentCard.getCardId(), cardId)) {
            currentCard = null;
        }
        u(currentCard, animated, new InterfaceC5063a() { // from class: G4.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.q(this.f2806a, cardId);
            }
        }, new InterfaceC5063a() { // from class: G4.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.s(this.f2808a, cardId);
            }
        });
    }

    @Override // E4.r
    public void c(E4.p card, FloatCardOptions options) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(card, "card");
        kotlin.jvm.internal.p.i(options, "options");
        this.hostDrivenAnim = options.getHostDrivenEnterAnim();
        this.onCardVisibilityChanged.invoke(Boolean.TRUE, options);
        this.container.p(card, !options.getHostDrivenEnterAnim());
        if (options.getHostDrivenEnterAnim()) {
            this.onHostEnterAnim.invoke(card);
        }
    }

    @Override // E4.r
    public boolean d(FloatCardScene scene) {
        kotlin.jvm.internal.p.i(scene, "scene");
        return this.scenes.contains(scene);
    }

    @Override // E4.r
    /* renamed from: e, reason: from getter */
    public int getPriority() {
        return this.priority;
    }

    @Override // E4.r
    public void f(String cardId, FloatCardContent content) {
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(content, "content");
        this.container.r(cardId, content);
    }

    @Override // E4.r
    public Context getContext() {
        return this.context;
    }

    public final void u(E4.p card, boolean animated, InterfaceC5063a<t> afterHost, InterfaceC5063a<t> fallback) {
        if (!animated) {
            afterHost.invoke();
        } else if (!this.hostDrivenAnim || card == null) {
            fallback.invoke();
        } else {
            this.onHostExitAnim.invoke(card, afterHost);
        }
    }

    public final Set<FloatCardScene> v() {
        return this.scenes;
    }

    public final void w() {
        this.onCardVisibilityChanged.invoke(Boolean.FALSE, new FloatCardOptions(false, false, false, false, false, 31, null));
    }

    public /* synthetic */ h(String str, int i10, Context context, FloatCardContainerView floatCardContainerView, Set set, p pVar, InterfaceC5074l interfaceC5074l, p pVar2, int i11, i iVar) {
        this(str, i10, context, floatCardContainerView, set, (i11 & 32) != 0 ? new p() { // from class: G4.a
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return h.n(((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
            }
        } : pVar, (i11 & 64) != 0 ? new InterfaceC5074l() { // from class: G4.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.o((E4.p) obj);
            }
        } : interfaceC5074l, (i11 & 128) != 0 ? new p() { // from class: G4.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return h.p((E4.p) obj, (InterfaceC5063a) obj2);
            }
        } : pVar2);
    }
}
