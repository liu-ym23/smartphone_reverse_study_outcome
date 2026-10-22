package M4;

import L4.AgentEmotion;
import L4.AgentPlace;
import L4.AgentSkin;
import L4.e;
import La.H;
import M4.e;
import Z8.C1168p;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentsprite.SceneLayerSpec;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import io.ktor.http.ContentType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 *2\u00020\u0001:\u000219B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b$\u0010%J)\u0010(\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b(\u0010)J3\u0010*\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b,\u0010-J5\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b/\u00100J)\u00101\u001a\u0004\u0018\u00010.2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b1\u00102J9\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0004¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010;R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010<R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010>¨\u0006@"}, d2 = {"LM4/g;", "", "Landroid/content/res/Resources;", "resources", "", "packageName", "LM4/e;", "manifest", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;LM4/e;)V", "LM4/e$c;", "entry", "Lcom/stepos/agentsprite/SceneLayerSpec;", "n", "(LM4/e$c;)Lcom/stepos/agentsprite/SceneLayerSpec;", "name", "", "l", "(Ljava/lang/String;)I", "m", "o", "arrayName", "", "p", "(Ljava/lang/String;)Ljava/util/List;", "hex", "", "k", "(Ljava/lang/String;)J", "agentId", "LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "LL4/h;", "skin", "LL4/f;", "place", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;LL4/l;LL4/h;LL4/f;)I", "LL4/c;", "emotion", "f", "(Ljava/lang/String;LL4/c;LL4/h;)I", "e", "(Ljava/lang/String;LL4/l;LL4/h;LL4/f;)Lcom/stepos/agentsprite/SceneLayerSpec;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;LL4/c;LL4/h;)Lcom/stepos/agentsprite/SceneLayerSpec;", "LM4/g$b;", "c", "(Ljava/lang/String;LL4/l;LL4/h;LL4/f;)LM4/g$b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;LL4/c;LL4/h;)LM4/g$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;LL4/l;LL4/h;LL4/f;)Ljava/util/List;", "r", "()Landroid/content/res/Resources;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/content/res/Resources;", "Ljava/lang/String;", "LM4/e;", "LM4/q;", "LM4/q;", "resourceIds", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Resources resources;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String packageName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final e manifest;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final q resourceIds;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"LM4/g$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "assetsPackage", "LL4/e;", "nightMode", "LM4/g;", "c", "(Landroid/content/Context;Ljava/lang/String;LL4/e;)LM4/g;", "requestedPackage", "Lkotlin/Pair;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;)Lkotlin/Pair;", "base", "mode", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;LL4/e;)Landroid/content/Context;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Context a(Context base, L4.e mode) {
            int i10;
            Object objB;
            if (kotlin.jvm.internal.p.d(mode, e.b.f4304a)) {
                return null;
            }
            if (kotlin.jvm.internal.p.d(mode, e.c.f4305a)) {
                i10 = 16;
            } else {
                if (!kotlin.jvm.internal.p.d(mode, e.a.f4303a)) {
                    throw new NoWhenBranchMatchedException();
                }
                i10 = 32;
            }
            Configuration configuration = new Configuration(base.getResources().getConfiguration());
            configuration.uiMode = i10 | (configuration.uiMode & (-49));
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(base.createConfigurationContext(configuration));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            return (Context) (Result.g(objB) ? null : objB);
        }

        public final Pair<Context, String> b(Context context, String requestedPackage) {
            Object objB;
            Object objB2;
            if (requestedPackage != null && requestedPackage.length() != 0) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB2 = Result.b(context.createPackageContext(requestedPackage, 0));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th));
                }
                if (Result.h(objB2)) {
                    return Y8.j.a((Context) objB2, requestedPackage);
                }
            }
            if (!kotlin.jvm.internal.p.d(requestedPackage, "com.stepos.agentpack")) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB = Result.b(context.createPackageContext("com.stepos.agentpack", 0));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th2));
                }
                if (Result.h(objB)) {
                    return Y8.j.a((Context) objB, "com.stepos.agentpack");
                }
            }
            return Y8.j.a(context, context.getPackageName());
        }

        public final g c(Context context, String assetsPackage, L4.e nightMode) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(nightMode, "nightMode");
            Pair<Context, String> pairB = b(context, assetsPackage);
            Context contextA = pairB.a();
            String strB = pairB.b();
            Context contextA2 = a(contextA, nightMode);
            if (contextA2 != null) {
                contextA = contextA2;
            }
            Resources resources = contextA.getResources();
            kotlin.jvm.internal.p.f(resources);
            return new g(resources, strB, e.INSTANCE.c(resources, strB), null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"LM4/g$b;", "", "", "id", "name", Const.JSON_KEY_DESC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "getDesc", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.g$b, reason: from toString */
    public static final /* data */ class ResolvedAnimation {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String desc;

        public ResolvedAnimation(String id, String name, String desc) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(desc, "desc");
            this.id = id;
            this.name = name;
            this.desc = desc;
        }

        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResolvedAnimation)) {
                return false;
            }
            ResolvedAnimation resolvedAnimation = (ResolvedAnimation) other;
            return kotlin.jvm.internal.p.d(this.id, resolvedAnimation.id) && kotlin.jvm.internal.p.d(this.name, resolvedAnimation.name) && kotlin.jvm.internal.p.d(this.desc, resolvedAnimation.desc);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.desc.hashCode();
        }

        public String toString() {
            return "ResolvedAnimation(id=" + this.id + ", name=" + this.name + ", desc=" + this.desc + ")";
        }
    }

    public /* synthetic */ g(Resources resources, String str, e eVar, kotlin.jvm.internal.i iVar) {
        this(resources, str, eVar);
    }

    public static /* synthetic */ int h(g gVar, String str, L4.l lVar, AgentSkin agentSkin, AgentPlace agentPlace, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            agentSkin = AgentSkin.a.f4307b;
        }
        if ((i10 & 8) != 0) {
            agentPlace = null;
        }
        return gVar.g(str, lVar, agentSkin, agentPlace);
    }

    public static final int q(g gVar, String type, String name) {
        Object objB;
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(gVar.resources.getIdentifier(name, type, gVar.packageName)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        return ((Number) objB).intValue();
    }

    public final ResolvedAnimation b(String agentId, AgentEmotion emotion, AgentSkin skin) {
        e.c cVarB;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(emotion, "emotion");
        kotlin.jvm.internal.p.i(skin, "skin");
        if (kotlin.jvm.internal.p.d(emotion, AgentEmotion.a.INSTANCE) || (cVarB = this.manifest.b(agentId, skin.getKey(), emotion.getKey())) == null) {
            return null;
        }
        String strB = cVarB.b();
        if (strB == null) {
            strB = "";
        }
        return new ResolvedAnimation(strB, "", "");
    }

    public final ResolvedAnimation c(String agentId, L4.l state, AgentSkin skin, AgentPlace place) {
        String strB;
        String strA;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(skin, "skin");
        e.StateSpec gVarE = this.manifest.e(agentId, skin.getKey(), state.getKey(), place != null ? place.getKey() : null);
        if (gVarE == null) {
            return null;
        }
        String strB2 = gVarE.getBody().b();
        String str = "";
        if (strB2 == null) {
            strB2 = "";
        }
        e.AnimationMeta bVarB = gVarE.getMeta();
        if (bVarB == null || (strB = bVarB.getName()) == null) {
            strB = "";
        }
        e.AnimationMeta bVarB2 = gVarE.getMeta();
        if (bVarB2 != null && (strA = bVarB2.getDesc()) != null) {
            str = strA;
        }
        return new ResolvedAnimation(strB2, strB, str);
    }

    public final SceneLayerSpec d(String agentId, AgentEmotion emotion, AgentSkin skin) {
        e.c cVarB;
        SceneLayerSpec sceneLayerSpecN;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(emotion, "emotion");
        kotlin.jvm.internal.p.i(skin, "skin");
        return (kotlin.jvm.internal.p.d(emotion, AgentEmotion.a.INSTANCE) || (cVarB = this.manifest.b(agentId, skin.getKey(), emotion.getKey())) == null || (sceneLayerSpecN = n(cVarB)) == null) ? SceneLayerSpec.f.f23369a : sceneLayerSpecN;
    }

    public final SceneLayerSpec e(String agentId, L4.l state, AgentSkin skin, AgentPlace place) {
        int iL;
        e.c cVarA;
        SceneLayerSpec sceneLayerSpecN;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(skin, "skin");
        e.StateSpec gVarE = this.manifest.e(agentId, skin.getKey(), state.getKey(), place != null ? place.getKey() : null);
        if (gVarE != null && (cVarA = gVarE.getBody()) != null && (sceneLayerSpecN = n(cVarA)) != null) {
            return sceneLayerSpecN;
        }
        String strC = this.manifest.c(agentId, skin.getKey());
        if (strC != null && (iL = l(strC)) != 0) {
            return new SceneLayerSpec.Drawable(iL);
        }
        return SceneLayerSpec.f.f23369a;
    }

    public final int f(String agentId, AgentEmotion emotion, AgentSkin skin) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(emotion, "emotion");
        kotlin.jvm.internal.p.i(skin, "skin");
        if (kotlin.jvm.internal.p.d(emotion, AgentEmotion.a.INSTANCE)) {
            return 0;
        }
        return l(this.manifest.a(agentId, skin.getKey(), emotion.getKey()));
    }

    public final int g(String agentId, L4.l state, AgentSkin skin, AgentPlace place) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(skin, "skin");
        String key = null;
        if (place != null) {
            if (kotlin.jvm.internal.p.d(place, AgentPlace.d.INSTANCE)) {
                place = null;
            }
            if (place != null) {
                key = place.getKey();
            }
        }
        String strF = this.manifest.f(agentId, skin.getKey(), state.getKey(), key);
        if (strF == null) {
            strF = this.manifest.c(agentId, skin.getKey());
        }
        return l(strF);
    }

    public final List<String> i(String agentId, L4.l state, AgentSkin skin, AgentPlace place) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(skin, "skin");
        String key = null;
        if (place != null) {
            if (kotlin.jvm.internal.p.d(place, AgentPlace.d.INSTANCE)) {
                place = null;
            }
            if (place != null) {
                key = place.getKey();
            }
        }
        String strG = this.manifest.g(agentId, skin.getKey(), state.getKey(), key);
        return strG == null ? C1173v.m() : p(strG);
    }

    /* renamed from: j, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final long k(String hex) {
        Object objB;
        if (hex == null || H.x0(hex)) {
            return 0L;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Long.valueOf(Color.parseColor(hex) & 4294967295L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0L;
        }
        return ((Number) objB).longValue();
    }

    public final int l(String name) {
        return this.resourceIds.a("drawable", name);
    }

    public final int m(String name) {
        return this.resourceIds.a(ContentType.Font.TYPE, name);
    }

    public final SceneLayerSpec n(e.c entry) {
        if (entry instanceof e.c.DrawableSpec) {
            int iL = l(((e.c.DrawableSpec) entry).getName());
            if (iL == 0) {
                return null;
            }
            return new SceneLayerSpec.Drawable(iL);
        }
        if (entry instanceof e.c.TextSpec) {
            e.c.TextSpec kVar = (e.c.TextSpec) entry;
            List<String> listP = p(kVar.getArrayName());
            if (listP.isEmpty()) {
                return null;
            }
            SceneLayerSpec.TileMode tileModeJ = kVar.getTileMode();
            long jK = k(kVar.getColorHex());
            Float fG = kVar.getFontSizeSp();
            float fFloatValue = fG != null ? fG.floatValue() : 0.0f;
            String strF = kVar.getFontResName();
            int iM = strF != null ? m(strF) : 0;
            Float fI = kVar.getLineHeightEm();
            float fFloatValue2 = fI != null ? fI.floatValue() : 0.0f;
            Float fH = kVar.getLetterSpacingEm();
            float fFloatValue3 = fH != null ? fH.floatValue() : 0.0f;
            SceneLayerSpec.Anchor anchorC = kVar.getAnchor();
            if (anchorC == null) {
                anchorC = SceneLayerSpec.Anchor.TopLeft;
            }
            return new SceneLayerSpec.Text(listP, tileModeJ, jK, fFloatValue, iM, fFloatValue2, fFloatValue3, anchorC);
        }
        if (entry instanceof e.c.LottieSpec) {
            e.c.LottieSpec dVar = (e.c.LottieSpec) entry;
            int iO = o(dVar.getRawName());
            if (iO == 0) {
                return null;
            }
            return new SceneLayerSpec.Lottie(iO, dVar.getLoop(), dVar.getSpeed());
        }
        if (entry instanceof e.c.PagSpec) {
            e.c.PagSpec fVar = (e.c.PagSpec) entry;
            return new SceneLayerSpec.Pag(fVar.getAssetPath(), fVar.getLoop(), fVar.getSpeed(), fVar.getFps());
        }
        if (entry instanceof e.c.HtmlSpec) {
            e.c.HtmlSpec c0080c = (e.c.HtmlSpec) entry;
            return new SceneLayerSpec.Html(c0080c.getHtml(), c0080c.getSandbox());
        }
        if (entry instanceof e.c.MarkdownSpec) {
            return new SceneLayerSpec.Markdown(((e.c.MarkdownSpec) entry).getMd());
        }
        if (entry instanceof e.c.RemoteSvgSpec) {
            return new SceneLayerSpec.RemoteSvg(((e.c.RemoteSvgSpec) entry).getSvg());
        }
        if (entry instanceof e.c.RemoteImageSpec) {
            return new SceneLayerSpec.RemoteImage(((e.c.RemoteImageSpec) entry).getUrl());
        }
        if (entry instanceof e.c.RawSpec) {
            int iO2 = o(((e.c.RawSpec) entry).getRawName());
            if (iO2 == 0) {
                return null;
            }
            return new SceneLayerSpec.Raw(iO2);
        }
        if (entry instanceof e.c.SpriteSheetSpec) {
            e.c.SpriteSheetSpec jVar = (e.c.SpriteSheetSpec) entry;
            int iL2 = l(jVar.getDrawableName());
            if (iL2 == 0) {
                return null;
            }
            return new SceneLayerSpec.SpriteSheet(iL2, jVar.getColumns(), jVar.getRows(), jVar.getFrameCount(), jVar.getFps(), jVar.getLoop());
        }
        if (!(entry instanceof e.c.FramesSpec)) {
            throw new NoWhenBranchMatchedException();
        }
        e.c.FramesSpec bVar = (e.c.FramesSpec) entry;
        String strE = bVar.getFrameArrayName();
        List<String> listC = (strE == null || strE.length() == 0) ? bVar.c() : p(bVar.getFrameArrayName());
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(l((String) it.next()));
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new SceneLayerSpec.Frames(arrayList, bVar.getFps(), bVar.getLoop());
    }

    public final int o(String name) {
        return this.resourceIds.a("raw", name);
    }

    public final List<String> p(String arrayName) {
        Object objB;
        if (arrayName == null || arrayName.length() == 0) {
            return C1173v.m();
        }
        int iA = this.resourceIds.a("array", arrayName);
        if (iA == 0) {
            return C1173v.m();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String[] stringArray = this.resources.getStringArray(iA);
            kotlin.jvm.internal.p.h(stringArray, "getStringArray(...)");
            objB = Result.b(C1168p.d(stringArray));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        return (List) objB;
    }

    /* renamed from: r, reason: from getter */
    public final Resources getResources() {
        return this.resources;
    }

    public g(Resources resources, String str, e eVar) {
        this.resources = resources;
        this.packageName = str;
        this.manifest = eVar;
        this.resourceIds = new q(new p9.p() { // from class: M4.f
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(g.q(this.f4613a, (String) obj, (String) obj2));
            }
        });
    }
}
