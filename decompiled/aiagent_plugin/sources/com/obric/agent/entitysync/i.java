package com.obric.agent.entitysync;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f14528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonObject f14530d;

    /* JADX INFO: compiled from: AppEntitySyncModels.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ i a(a r1, AppEntity r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = "";
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = "";
        L9:
            return r1.a(r2, r3, r4);
        }

        public final i a(AppEntity r8, String r9, String r10) {
            o.e(r8, "entity");
            o.e(r9, "fallbackPackageName");
            o.e(r10, "fallbackEcaId");
            String r7 = r8.getEcaId();
            String r0 = null;
            if (r7 == null) goto L5;
            String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L6:
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
            boolean r3 = false;
            if (r12.length() != 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L14;
            r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L14:
            String r13 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
            boolean r14 = true;
        L18:
            if (r14 == false) goto L48;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L46;
            JsonObject r15 = EntityExtKt.a().toJsonTree(r8).getAsJsonObject().deepCopy();
            JsonElement r5 = r15.get("ecaId");
            if (r5 != null) goto L24;
        L29:
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L32;
        L35:
            boolean r4 = true;
        L36:
            if (r4 == false) goto L38;
            r15.addProperty("ecaId", r13);
        L38:
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8.get_packageName(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r6.length() != 0) goto L41;
            r3 = true;
        L41:
            if (r3 == false) goto L43;
            r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L43:
            c r16 = new c((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin"), r8.getType(), r8.getId());
            o.a(r15);
            return new i(r16, r13, r15);
        L32:
            if (d.o.o.d(r1) == true) goto L35;
            r4 = false;
            goto L36
        L24:
            if (r5.isJsonPrimitive() == true) goto L27;
            r5 = null;
        L27:
            if (r5 == null) goto L29;
            r0 = r5.getAsString();
            goto L29
        L46:
            throw new IllegalArgumentException("AppEntity id is required".toString());
        L48:
            throw new IllegalArgumentException("AppEntity ecaId is required".toString());
        L17:
            r14 = false;
            goto L18
        L11:
            r2 = false;
            goto L12
        L5:
            r11 = null;
            goto L6
        }
    }

    static {
        f14527a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14528b, r6.f14528b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14529c, r6.f14529c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14530d, r6.f14530d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f14528b.hashCode() * 31) + this.f14529c.hashCode()) * 31) + this.f14530d.hashCode();
    }

    public String toString() {
        return "AppEntitySnapshot(identity=" + this.f14528b + ", ecaId=" + this.f14529c + ", entityInfo=" + this.f14530d + ')';
    }

    public i(c r2, String r3, JsonObject r4) {
        o.e(r2, DownloadHelper.IDENTITY);
        o.e(r3, "ecaId");
        o.e(r4, "entityInfo");
        this.f14528b = r2;
        this.f14529c = r3;
        this.f14530d = r4;
    }

    public final c a() {
        return this.f14528b;
    }

    public final String b() {
        return this.f14529c;
    }

    public final JsonObject c() {
        return this.f14530d;
    }
}
