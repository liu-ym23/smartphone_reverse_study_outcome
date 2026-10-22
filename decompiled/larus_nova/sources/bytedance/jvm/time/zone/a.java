package bytedance.jvm.time.zone;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f21728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<String, a> f21729b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Set<String> f21730c;

    /* JADX INFO: renamed from: bytedance.jvm.time.zone.a$a, reason: collision with other inner class name */
    public class C0378a implements PrivilegedAction<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21731a;

        @Override // java.security.PrivilegedAction
        public final Object run() {
            String r100 = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
            if (r100 != null) goto L12;
            a.d(new b());
            return null;
        L12:
            a r101 = (a) a.class.cast(a(r100, a.class.getClassLoader()).newInstance());     // Catch: Exception -> L6
            a.d(r101);     // Catch: Exception -> L6
            this.f21731a.add(r101);     // Catch: Exception -> L6
            return null;
        L6:
            e = move-exception;
            throw new Error(e);
        }

        public C0378a(List r100) {
            this.f21731a = r100;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r104 = Class.forName(r100, true, r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r105 = Class.forName(r100, true, r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f21732d;

        public b() {
            LinkedHashSet r100 = new LinkedHashSet();
            String[] r101 = TimeZone.getAvailableIDs();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r100.add(r101[r103]);
            r103 = r103 + 1;
            goto L3
        L5:
            this.f21732d = Collections.unmodifiableSet(r100);
        }

        @Override // bytedance.jvm.time.zone.a
        public final Set<String> c() {
            return this.f21732d;
        }

        @Override // bytedance.jvm.time.zone.a
        public final ZoneRules b(String r100) {
            if (this.f21732d.contains(r100) == false) goto L7;
            return new ZoneRules(TimeZone.getTimeZone(r100));
        L7:
            throw new ZoneRulesException("Not a built-in time zone: " + r100);
        }
    }

    public abstract ZoneRules b(String r100);

    public abstract Set<String> c();

    static {
        CopyOnWriteArrayList<a> r100 = new CopyOnWriteArrayList();
        f21728a = r100;
        f21729b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList r101 = new ArrayList();
        AccessController.doPrivileged(new C0378a(r101));
        r100.addAll(r101);
    }

    public a() {
    }

    public static void d(a r100) {
        Objects.requireNonNull(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        monitor-enter(a.class);
        Iterator<String> r101 = r100.c().iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();     // Catch: Throwable -> L16
        Objects.requireNonNull(r102, "zoneId");     // Catch: Throwable -> L16
        if (((a) ((ConcurrentHashMap) f21729b).putIfAbsent(r102, r100)) == null) goto L6;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r102 + ", currently loading from provider: " + r100);     // Catch: Throwable -> L16
    L12:
        f21730c = Collections.unmodifiableSet(new HashSet(((ConcurrentHashMap) f21729b).keySet()));     // Catch: Throwable -> L16
        monitor-exit(a.class);
        f21728a.add(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static ZoneRules a(String r100, boolean r101) {
        Objects.requireNonNull(r100, "zoneId");
        ConcurrentHashMap r102 = (ConcurrentHashMap) f21729b;
        a r103 = (a) r102.get(r100);
        if (r103 != null) goto L11;
        if (r102.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: ".concat(r100));
    L11:
        return r103.b(r100);
    }
}
