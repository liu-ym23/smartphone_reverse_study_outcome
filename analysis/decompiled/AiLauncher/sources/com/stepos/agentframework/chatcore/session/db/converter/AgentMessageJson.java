package com.stepos.agentframework.chatcore.session.db.converter;

import La.H;
import Z8.C1173v;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import h8.C4148a;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.AgentMessage;
import u4.m;
import v4.c;
import v4.f;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/converter/AgentMessageJson;", "", "<init>", "()V", "Lu4/a;", "agent", "", "c", "(Lu4/a;)Ljava/lang/String;", "json", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lu4/a;", "", "list", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentMessageJson {
    public static final AgentMessageJson INSTANCE = new AgentMessageJson();
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Uri.class, new f()).registerTypeAdapter(m.class, new c()).setLenient().serializeNulls().create();

    public final AgentMessage a(String json) {
        p.i(json, "json");
        if (H.x0(json)) {
            return new AgentMessage(null, null, null, null, false, false, 63, null);
        }
        try {
            Object objFromJson = gson.fromJson(json, (Class<Object>) AgentMessage.class);
            p.f(objFromJson);
            return (AgentMessage) objFromJson;
        } catch (JsonSyntaxException e10) {
            C4148a.g("AgentMessageJson", "decode failed: " + json, e10, false, 8, null);
            return new AgentMessage(null, null, null, null, false, false, 63, null);
        } catch (Exception e11) {
            C4148a.g("AgentMessageJson", "decode unknown error", e11, false, 8, null);
            return new AgentMessage(null, null, null, null, false, false, 63, null);
        }
    }

    public final List<AgentMessage> b(String json) {
        if (json == null || H.x0(json)) {
            return C1173v.h(new AgentMessage(null, null, null, null, false, false, 63, null));
        }
        try {
            Type type = new TypeToken<List<AgentMessage>>() { // from class: com.stepos.agentframework.chatcore.session.db.converter.AgentMessageJson$decodeList$type$1
            }.getType();
            p.h(type, "getType(...)");
            List<AgentMessage> list = (List) gson.fromJson(json, type);
            return list == null ? C1173v.h(new AgentMessage(null, null, null, null, false, false, 63, null)) : list;
        } catch (Exception e10) {
            C4148a.g("AgentMessageJson", "decodeList failed", e10, false, 8, null);
            return C1173v.h(new AgentMessage(null, null, null, null, false, false, 63, null));
        }
    }

    public final String c(AgentMessage agent) {
        p.i(agent, "agent");
        try {
            String json = gson.toJson(agent);
            p.f(json);
            return json;
        } catch (Exception e10) {
            C4148a.g("AgentMessageJson", "encode failed", e10, false, 8, null);
            String json2 = gson.toJson(new AgentMessage(null, null, null, null, false, false, 63, null));
            p.f(json2);
            return json2;
        }
    }

    public final String d(List<AgentMessage> list) {
        p.i(list, "list");
        try {
            Type type = new TypeToken<List<AgentMessage>>() { // from class: com.stepos.agentframework.chatcore.session.db.converter.AgentMessageJson$encodeList$type$1
            }.getType();
            p.h(type, "getType(...)");
            String json = gson.toJson(list, type);
            p.f(json);
            return json;
        } catch (Exception e10) {
            C4148a.g("AgentMessageJson", "encodeList failed", e10, false, 8, null);
            String json2 = gson.toJson(C1173v.h(new AgentMessage(null, null, null, null, false, false, 63, null)));
            p.f(json2);
            return json2;
        }
    }
}
