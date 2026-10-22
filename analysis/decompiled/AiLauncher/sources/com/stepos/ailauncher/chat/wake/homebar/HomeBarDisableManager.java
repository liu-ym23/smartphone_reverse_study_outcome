package com.stepos.ailauncher.chat.wake.homebar;

import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k5.C4814a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\n\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", HomeGestureEligibilityContract.EXTRA_SCENE, "Lkotlin/Function0;", "", "isActive", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;Lp9/a;)Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;", "e", "()Z", "", "source", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "", "c", "()Ljava/util/Set;", M5.b.CREDENTIAL_TOKEN, "LY8/t;", "f", "(Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;)V", "", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$a;", "active", "Ljava/util/Map;", "Scene", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeBarDisableManager {
    public static final HomeBarDisableManager INSTANCE = new HomeBarDisableManager();
    private static final Map<b, Entry> active = new LinkedHashMap();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", "", "<init>", "(Ljava/lang/String;I)V", "MORE_CAMERA", "MORE_GALLERY", "MORE_FILE_PICKER", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Scene {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Scene[] $VALUES;
        public static final Scene MORE_CAMERA = new Scene("MORE_CAMERA", 0);
        public static final Scene MORE_GALLERY = new Scene("MORE_GALLERY", 1);
        public static final Scene MORE_FILE_PICKER = new Scene("MORE_FILE_PICKER", 2);

        private static final /* synthetic */ Scene[] $values() {
            return new Scene[]{MORE_CAMERA, MORE_GALLERY, MORE_FILE_PICKER};
        }

        static {
            Scene[] sceneArr$values = $values();
            $VALUES = sceneArr$values;
            $ENTRIES = kotlin.enums.a.a(sceneArr$values);
        }

        private Scene(String str, int i10) {
        }

        public static InterfaceC4149a<Scene> getEntries() {
            return $ENTRIES;
        }

        public static Scene valueOf(String str) {
            return (Scene) Enum.valueOf(Scene.class, str);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$a;", "", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", HomeGestureEligibilityContract.EXTRA_SCENE, "Lkotlin/Function0;", "", "isActive", "<init>", "(Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;Lp9/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$Scene;", "Lp9/a;", Const.INTENT_KEY_PKGNAME, "()Lp9/a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager$a, reason: from toString */
    public static final /* data */ class Entry {
        private final InterfaceC5063a<Boolean> isActive;
        private final Scene scene;

        public Entry(Scene scene, InterfaceC5063a<Boolean> isActive) {
            kotlin.jvm.internal.p.i(scene, "scene");
            kotlin.jvm.internal.p.i(isActive, "isActive");
            this.scene = scene;
            this.isActive = isActive;
        }

        /* renamed from: a, reason: from getter */
        public final Scene getScene() {
            return this.scene;
        }

        public final InterfaceC5063a<Boolean> b() {
            return this.isActive;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return this.scene == entry.scene && kotlin.jvm.internal.p.d(this.isActive, entry.isActive);
        }

        public int hashCode() {
            return (this.scene.hashCode() * 31) + this.isActive.hashCode();
        }

        public String toString() {
            return "Entry(scene=" + this.scene + ", isActive=" + this.isActive + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarDisableManager$b;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "LY8/t;", "close", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AutoCloseable {
        @Override // java.lang.AutoCloseable
        public void close() {
            HomeBarDisableManager.INSTANCE.f(this);
        }
    }

    public final synchronized b b(Scene scene, InterfaceC5063a<Boolean> isActive) {
        b bVar;
        kotlin.jvm.internal.p.i(scene, "scene");
        kotlin.jvm.internal.p.i(isActive, "isActive");
        bVar = new b();
        active.put(bVar, new Entry(scene, isActive));
        return bVar;
    }

    public final synchronized Set<Scene> c() {
        ArrayList arrayList;
        try {
            Collection<Entry> collectionValues = active.values();
            arrayList = new ArrayList(C1174w.x(collectionValues, 10));
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                arrayList.add(((Entry) it.next()).getScene());
            }
        } catch (Throwable th) {
            throw th;
        }
        return F.r1(arrayList);
    }

    public final boolean d(String source) {
        return kotlin.jvm.internal.p.d(source, C4814a.BOTTOM_BAR_KEY_LONG_CLICK) && e();
    }

    public final boolean e() {
        List listM1;
        synchronized (this) {
            listM1 = F.m1(active.values());
        }
        List list = listM1;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Entry) it.next()).b().invoke().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void f(b token) {
        active.remove(token);
    }
}
