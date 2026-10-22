package b7;

import Y8.t;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.datacenter.fts.sqlite.AsyncIndexQueue;
import com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001\u001fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010&¨\u0006)"}, d2 = {"Lb7/a;", "", "Landroid/content/Context;", "context", "Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;", C3081a.KEY_ENGINE, "<init>", "(Landroid/content/Context;Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;)V", "", "docId", "", "tableName", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", Const.INTENT_KEY_UMID, "(JLjava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lb7/b;", "request", "", "Lb7/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lb7/b;Le9/c;)Ljava/lang/Object;", "f", "(JLjava/lang/String;Le9/c;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LY8/t;", "e", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/datacenter/fts/sqlite/SQLiteFtsEngine;", "Z", "isInitialized", "Lcom/stepos/datacenter/fts/sqlite/AsyncIndexQueue;", "Lcom/stepos/datacenter/fts/sqlite/AsyncIndexQueue;", "asyncQueue", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: b7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1453a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static volatile C1453a f15254e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SQLiteFtsEngine engine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile boolean isInitialized;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile AsyncIndexQueue asyncQueue;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lb7/a$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lb7/a;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Lb7/a;", "", "TAG", "Ljava/lang/String;", "instance", "Lb7/a;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: b7.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C1453a a(Context context) {
            C1453a c1453a;
            p.i(context, "context");
            C1453a c1453a2 = C1453a.f15254e;
            if (c1453a2 != null) {
                return c1453a2;
            }
            synchronized (this) {
                c1453a = C1453a.f15254e;
                if (c1453a == null) {
                    Context applicationContext = context.getApplicationContext();
                    p.f(applicationContext);
                    c1453a = new C1453a(applicationContext, new SQLiteFtsEngine(applicationContext), null);
                    C1453a.f15254e = c1453a;
                }
            }
            return c1453a;
        }

        public Companion() {
        }
    }

    public /* synthetic */ C1453a(Context context, SQLiteFtsEngine sQLiteFtsEngine, i iVar) {
        this(context, sQLiteFtsEngine);
    }

    public final Object c(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return this.engine.o(str, interfaceC4014c);
    }

    public final Object d(long j10, String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return this.engine.r(j10, str, str2, interfaceC4014c);
    }

    public final Object e(InterfaceC4014c<? super t> interfaceC4014c) {
        if (this.isInitialized) {
            return t.f7040a;
        }
        try {
            h();
            this.isInitialized = true;
            Log.d("FullTextSearchManager", "FTS initialized successfully");
        } catch (Exception e10) {
            Log.e("FullTextSearchManager", "FTS initialization failed", e10);
        }
        return t.f7040a;
    }

    public final Object f(long j10, String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return this.engine.u(j10, str, interfaceC4014c);
    }

    public final Object g(C1454b c1454b, InterfaceC4014c<? super List<? extends d>> interfaceC4014c) {
        return this.engine.v(c1454b, interfaceC4014c);
    }

    public final void h() {
        if (this.asyncQueue == null) {
            AsyncIndexQueue asyncIndexQueue = new AsyncIndexQueue(this.engine, 0, 0L, 6, null);
            asyncIndexQueue.e();
            this.asyncQueue = asyncIndexQueue;
            Log.d("FullTextSearchManager", "Async index queue started");
        }
    }

    public C1453a(Context context, SQLiteFtsEngine sQLiteFtsEngine) {
        this.context = context;
        this.engine = sQLiteFtsEngine;
    }
}
