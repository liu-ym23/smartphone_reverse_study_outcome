package com.stepos.agentframework.chatcore.session.db.converter;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/converter/ListConverter;", "", "<init>", "()V", "", "", "list", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/lang/String;", "jsonString", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ListConverter {
    private final Gson gson = new Gson();

    public final String a(List<String> list) {
        if (list == null) {
            return null;
        }
        Type type = new TypeToken<List<? extends String>>() { // from class: com.stepos.agentframework.chatcore.session.db.converter.ListConverter$fromList$type$1
        }.getType();
        p.h(type, "getType(...)");
        return this.gson.toJson(list, type);
    }

    public final List<String> b(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        Type type = new TypeToken<List<? extends String>>() { // from class: com.stepos.agentframework.chatcore.session.db.converter.ListConverter$toList$type$1
        }.getType();
        p.h(type, "getType(...)");
        return (List) this.gson.fromJson(jsonString, type);
    }
}
