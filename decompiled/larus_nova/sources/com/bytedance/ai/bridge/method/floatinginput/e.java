package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import e3.g;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements g, e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e3.d> f35518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f35519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l3.e f35520c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f35521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f35522b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f35521a == r101.f35521a) goto L12;
            return false;
        L12:
            if (this.f35522b == r101.f35522b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f35521a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f35522b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Indication(send=" + this.f35521a + ", receive=" + this.f35522b + ')';
        }

        public a(boolean r100, boolean r101) {
            this.f35521a = r100;
            this.f35522b = r101;
        }
    }

    @Override // e3.b
    public final void a() {
        this.f35519b.clear();
        this.f35518a.clear();
        Lazy r100 = l3.d.f507201a;
        l3.e r101 = this.f35520c;
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        Intrinsics.checkNotNullParameter(MessageIndication.EVENT_NAME, "eventName");
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) l3.d.a().get(MessageIndication.EVENT_NAME);
        if (r102 == null) goto L6;
        r102.remove(r101);
        return;
    }

    public e(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        this.f35518a = new WeakReference(r100);
        this.f35519b = new ConcurrentHashMap();
        l3.e r101 = new l3.e(this, UUID.randomUUID().toString(), null, 28);
        this.f35520c = r101;
        l3.d.e(r101, MessageIndication.EVENT_NAME);
    }

    @Override // e3.g
    public final void b(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 == null) goto L24;
        JsonElement r102 = r101.get("botId");
        if (r102 == null) goto L25;
        String r103 = r102.getAsString();
        if (r103 == null) goto L30;
        JsonElement r104 = r101.get("isSend");
        if (r104 == null) goto L26;
        boolean r105 = r104.getAsBoolean();
        a r106 = this.f35519b.get(r103);
        if (r106 != null) goto L14;
        return;
    L14:
        if (r105 == true) goto L16;
    L17:
        if (r105 == false) goto L19;
        return;
    L19:
        if (r106.f35522b == false) goto L28;
    L20:
        e3.d r107 = this.f35518a.get();
        if (r107 == null) goto L29;
        r107.a("applet.chatEvent", r101);
        return;
    L29:
        return;
    L28:
        return;
    L16:
        if (r106.f35521a == true) goto L20;
    L26:
        return;
    L30:
        return;
    L25:
        return;
    }

    public final void update(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f35519b.put(r100, new a(r101, r102));
    }
}
