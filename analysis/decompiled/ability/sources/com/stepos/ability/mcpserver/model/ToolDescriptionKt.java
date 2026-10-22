package com.stepos.ability.mcpserver.model;

import C7.f;
import D7.w;
import P3.a;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LJ3/a;", "Lcom/stepos/ability/mcpserver/model/ToolDescription;", "toToolDescription", "(LJ3/a;)Lcom/stepos/ability/mcpserver/model/ToolDescription;", "", "permission", "", "splitPermissions", "(Ljava/lang/String;)Ljava/util/List;", "json", "", "", "parseJsonObject", "(Ljava/lang/String;)Ljava/util/Map;", "server_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToolDescriptionKt {
    public static final Map<String, Object> parseJsonObject(String str) {
        Object objFromJson;
        if (str == null || m.s0(str) || str.equals("{}")) {
            return null;
        }
        try {
            f fVar = a.f1084a;
            if (str.length() == 0) {
                objFromJson = null;
            } else {
                try {
                    objFromJson = a.b().fromJson(str, (Class<Object>) Map.class);
                } catch (Exception unused) {
                }
            }
            if (objFromJson instanceof Map) {
                return (Map) objFromJson;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static final List<String> splitPermissions(String str) {
        if (str == null || m.s0(str)) {
            return EmptyList.f4893a;
        }
        List listD0 = m.D0(str, new String[]{","}, 6);
        ArrayList arrayList = new ArrayList(w.c0(listD0, 10));
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            arrayList.add(m.R0((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (((String) next).length() > 0) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public static final ToolDescription toToolDescription(J3.a aVar) {
        k.f(aVar, "<this>");
        String str = aVar.b;
        String str2 = aVar.e;
        Map<String, Object> jsonObject = parseJsonObject(aVar.f869j);
        Map<String, Object> jsonObject2 = parseJsonObject(aVar.k);
        List<String> listSplitPermissions = splitPermissions(aVar.i);
        Integer num = aVar.h;
        return new ToolDescription(str, str, str2, jsonObject, jsonObject2, listSplitPermissions, num != null ? num.intValue() : 30, aVar.f868a, aVar.c, aVar.f, aVar.d, parseJsonObject(aVar.l));
    }
}
