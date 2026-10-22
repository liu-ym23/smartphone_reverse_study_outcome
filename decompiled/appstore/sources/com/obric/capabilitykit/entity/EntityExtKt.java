package com.obric.capabilitykit.entity;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.common.e;
import com.obric.capabilitykit.common.f;
import com.obric.capabilitykit.common.g;
import com.obric.capabilitykit.common.h;
import com.obric.capabilitykit.common.i;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\f\u001a\u00020\u0001*\u00020\u000eH\u0007¢\u0006\u0004\b\f\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\u0001*\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\r\u001a\u0013\u0010\f\u001a\u00020\u0001*\u00020\u0011H\u0007¢\u0006\u0004\b\f\u0010\u0012\u001a\u0017\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001d\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b\"\u001a\u0010\u001e\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b¨\u0006 "}, d2 = {"Landroid/os/Parcel;", "", "f", "(Landroid/os/Parcel;)Ljava/lang/String;", "", "e", "(Landroid/os/Parcel;)Z", CommonKey.KEY_VALUE, "", "g", "(Landroid/os/Parcel;Z)V", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "toJson", "(Lcom/obric/capabilitykit/entity/app/AppEntity;)Ljava/lang/String;", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "(Lcom/obric/capabilitykit/entity/app/ExtraEntity;)Ljava/lang/String;", "toJsonKeepTimeStamp", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "(Lcom/obric/capabilitykit/entity/meta/MetaValue;)Ljava/lang/String;", "", "obj", "d", "(Ljava/lang/Object;)Z", "Lcom/google/gson/Gson;", "entityGson", "Lcom/google/gson/Gson;", "a", "()Lcom/google/gson/Gson;", "c", "innerEntityGson", "entityKeepTimeStampGson", "b", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EntityExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f11315a = null;

    @Keep
    @NotNull
    private static final Gson entityGson = null;

    @Keep
    @NotNull
    private static final Gson entityKeepTimeStampGson = null;

    static {
        Gson r10 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).registerTypeAdapter(AppEntity.class, new e()).registerTypeAdapter(AppEntity.class, new f()).registerTypeAdapter(MemoryEntity.class, new e()).registerTypeAdapter(MemoryEntity.class, new f()).registerTypeAdapter(MetaValue.class, new i()).registerTypeAdapter(MetaValue.class, new h()).create();
        q.d(r10);
        entityGson = r10;
        Gson r11 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).create();
        q.d(r11);
        f11315a = r11;
        Gson r12 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
        q.d(r12);
        entityKeepTimeStampGson = r12;
    }

    public static final Gson a() {
        return entityGson;
    }

    public static final Gson b() {
        return entityKeepTimeStampGson;
    }

    public static final Gson c() {
        return f11315a;
    }

    public static final boolean d(Object r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if ((r10 instanceof Integer) == false) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L17;
        boolean r14 = true;
    L18:
        if (r14 == false) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        boolean r16 = true;
    L24:
        if (r16 == false) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == false) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == false) goto L33;
        return true;
    L33:
        if ((r10 instanceof Uri) == false) goto L36;
        return true;
    L36:
        if ((r10 instanceof MetaValue) == false) goto L39;
        return true;
    L39:
        if ((r10 instanceof List) == false) goto L52;
        Iterable r19 = (Iterable) r10;
        if ((r19 instanceof Collection) == true) goto L43;
    L45:
        Iterator r20 = r19.iterator();
    L47:
        if (r20.hasNext() == false) goto L81;
        if (d(r20.next()) == true) goto L47;
    L67:
        return false;
    L81:
        return true;
    L43:
        if (((Collection) r19).isEmpty() == false) goto L45;
        return true;
    L52:
        if ((r10 instanceof Map) == false) goto L67;
        Map r21 = (Map) r10;
        if (r21.isEmpty() == true) goto L80;
        Iterator r22 = r21.entrySet().iterator();
    L58:
        if (r22.hasNext() == false) goto L82;
        Map.Entry r23 = (Map.Entry) r22.next();
        if (d(r23.getKey()) == true) goto L62;
    L64:
        boolean r24 = false;
    L65:
        if (r24 == true) goto L58;
    L62:
        if (d(r23.getValue()) == false) goto L64;
        r24 = true;
        goto L65
    L82:
        return true;
    L80:
        return true;
    L29:
        r18 = r10 instanceof String;
        goto L30
    L26:
        r17 = r10 instanceof Character;
        goto L27
    L23:
        r16 = r10 instanceof Boolean;
        goto L24
    L20:
        r15 = r10 instanceof Byte;
        goto L21
    L17:
        r14 = r10 instanceof Short;
        goto L18
    L14:
        r13 = r10 instanceof Long;
        goto L15
    L11:
        r12 = r10 instanceof Float;
        goto L12
    L8:
        r11 = r10 instanceof Double;
        goto L9
    }

    public static final boolean e(Parcel r10) {
        q.g(r10, "<this>");
        if (r10.readInt() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String f(Parcel r10) {
        q.g(r10, "<this>");
        String r11 = r10.readString();
        if (r11 != null) goto L6;
        return "";
    L6:
        return r11;
    }

    public static final void g(Parcel r10, boolean r11) {
        q.g(r10, "<this>");
        r10.writeInt(r11 ? 1 : 0);
    }

    @Keep
    @NotNull
    public static final String toJson(@NotNull AppEntity r10) {
        q.g(r10, "<this>");
        String r11 = f11315a.toJson(r10);
        q.f(r11, "innerEntityGson.toJson(this)");
        return r11;
    }

    @Keep
    @NotNull
    public static final String toJsonKeepTimeStamp(@NotNull AppEntity r10) {
        q.g(r10, "<this>");
        String r11 = entityKeepTimeStampGson.toJson(r10);
        q.f(r11, "entityKeepTimeStampGson.toJson(this)");
        return r11;
    }

    @Keep
    @NotNull
    public static final String toJson(@NotNull ExtraEntity r10) {
        q.g(r10, "<this>");
        String r11 = f11315a.toJson(r10);
        q.f(r11, "innerEntityGson.toJson(this)");
        return r11;
    }

    @Keep
    @NotNull
    public static final String toJson(@NotNull MetaValue r10) {
        q.g(r10, "<this>");
        String r11 = f11315a.toJson(r10);
        q.f(r11, "innerEntityGson.toJson(this)");
        return r11;
    }
}
