package com.obric.capabilitykit.entity;

import android.net.Uri;
import android.os.Parcel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.common.g;
import com.obric.capabilitykit.common.i;
import com.obric.capabilitykit.common.k;
import com.obric.capabilitykit.common.m;
import com.obric.capabilitykit.common.o;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f32083a = null;
    private static final Gson entityGson = null;
    private static final Gson entityKeepTimeStampGson = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new k()).registerTypeAdapter(AppEntity.class, new g()).registerTypeAdapter(AppEntity.class, new i()).registerTypeAdapter(MemoryEntity.class, new g()).registerTypeAdapter(MemoryEntity.class, new i()).registerTypeAdapter(MetaValue.class, new o()).registerTypeAdapter(MetaValue.class, new m()).create();
        d.h.b.o.a(r0);
        entityGson = r0;
        Gson r1 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new k()).create();
        d.h.b.o.a(r1);
        f32083a = r1;
        Gson r2 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
        d.h.b.o.a(r2);
        entityKeepTimeStampGson = r2;
    }

    public static final Gson a() {
        return entityGson;
    }

    public static final String a(Parcel r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static final void a(Parcel r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        r1.writeInt(r2 ? 1 : 0);
    }

    public static final boolean a(Object r5) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L34;
        return true;
    L34:
        if (ZeusTransformUtils.instanceOf(r5, Uri.class) == false) goto L37;
        return true;
    L37:
        if (ZeusTransformUtils.instanceOf(r5, MetaValue.class) == false) goto L40;
        return true;
    L40:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L53;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L44;
    L46:
        Iterator r11 = r10.iterator();
    L48:
        if (r11.hasNext() == false) goto L82;
        if (a(r11.next()) == true) goto L48;
    L68:
        return false;
    L82:
        return true;
    L44:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L46;
        return true;
    L53:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L68;
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin");
        if (r12.isEmpty() == true) goto L81;
        Iterator r13 = r12.entrySet().iterator();
    L59:
        if (r13.hasNext() == false) goto L83;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (a(r14.getKey()) == true) goto L63;
    L65:
        boolean r15 = false;
    L66:
        if (r15 == true) goto L59;
    L63:
        if (a(r14.getValue()) == false) goto L65;
        r15 = true;
        goto L66
    L83:
        return true;
    L81:
        return true;
    L29:
        r9 = ZeusTransformUtils.instanceOf(r5, String.class);
        goto L31
    L26:
        r8 = ZeusTransformUtils.instanceOf(r5, Character.class);
        goto L27
    L23:
        r7 = ZeusTransformUtils.instanceOf(r5, Boolean.class);
        goto L24
    L20:
        r6 = ZeusTransformUtils.instanceOf(r5, Byte.class);
        goto L21
    L17:
        r4 = ZeusTransformUtils.instanceOf(r5, Short.class);
        goto L18
    L14:
        r3 = ZeusTransformUtils.instanceOf(r5, Long.class);
        goto L15
    L11:
        r2 = ZeusTransformUtils.instanceOf(r5, Float.class);
        goto L12
    L8:
        r1 = ZeusTransformUtils.instanceOf(r5, Double.class);
        goto L9
    }

    public static final Gson b() {
        return f32083a;
    }

    public static final boolean b(Parcel r1) {
        d.h.b.o.e(r1, "<this>");
        if (r1.readInt() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final Gson c() {
        return entityKeepTimeStampGson;
    }

    public static final String toJson(AppEntity r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = f32083a.toJson(r1);
        d.h.b.o.c(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJson(ExtraEntity r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = f32083a.toJson(r1);
        d.h.b.o.c(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJson(MetaValue r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = f32083a.toJson(r1);
        d.h.b.o.c(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJsonKeepTimeStamp(AppEntity r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = entityKeepTimeStampGson.toJson(r1);
        d.h.b.o.c(r2, "entityKeepTimeStampGson.toJson(this)");
        return r2;
    }
}
