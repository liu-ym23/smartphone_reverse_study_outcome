package com.stepos.agentframework.chatcore.session.db.converter;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/converter/ReferenceSourceListConverter;", "", "<init>", "()V", "", "LK6/A;", "list", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/lang/String;", "jsonString", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "type", "Ljava/lang/reflect/Type;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReferenceSourceListConverter {
    private final Gson gson = new Gson();
    private final Type type;

    public ReferenceSourceListConverter() {
        Type type = new TypeToken<List<? extends ReferenceSource>>() { // from class: com.stepos.agentframework.chatcore.session.db.converter.ReferenceSourceListConverter$type$1
        }.getType();
        p.h(type, "getType(...)");
        this.type = type;
    }

    public final String a(List<ReferenceSource> list) {
        if (list == null) {
            return null;
        }
        return this.gson.toJson(list, this.type);
    }

    public final List<ReferenceSource> b(String jsonString) {
        Object objB;
        if (jsonString == null || jsonString.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((List) this.gson.fromJson(jsonString, this.type));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (List) (Result.g(objB) ? null : objB);
    }
}
