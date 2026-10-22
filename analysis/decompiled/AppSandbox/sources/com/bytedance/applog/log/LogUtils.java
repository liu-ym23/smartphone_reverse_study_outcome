package com.bytedance.applog.log;

import com.bytedance.applog.log.EventBus;
import com.bytedance.bdtracker.e4;
import com.bytedance.bdtracker.h4;
import com.bytedance.bdtracker.l4;
import com.bytedance.bdtracker.m4;
import com.bytedance.bdtracker.o4;
import com.bytedance.bdtracker.p4;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.r4;
import com.bytedance.bdtracker.s4;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LogUtils {
    public static final String EVENT_TYPE_EVENT_V3 = "EVENT_V3";
    public static final String EVENT_TYPE_LAUNCH = "LAUNCH";
    public static final String EVENT_TYPE_PROFILE = "PROFILE";
    public static final String EVENT_TYPE_TERMINATE = "TERMINATE";
    public static final String EVENT_TYPE_TRACE = "TRACE";
    public static volatile boolean a = false;

    public static class a implements EventBus.DataFetcher {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() throws JSONException {
            e4 e4Var;
            String upperCase;
            JSONObject jSONObjectH = ((e4) this.a).h();
            JSONObject jSONObject = new JSONObject();
            r.c(jSONObjectH, jSONObject);
            try {
                jSONObject.put("$$APP_ID", ((e4) this.a).m);
                e4Var = (e4) this.a;
            } catch (JSONException unused) {
            }
            if (e4Var != null) {
                if ((e4Var instanceof l4) || (e4Var instanceof o4)) {
                    upperCase = LogUtils.EVENT_TYPE_EVENT_V3;
                } else if (e4Var instanceof h4) {
                    upperCase = ((h4) e4Var).s.toUpperCase(Locale.ROOT);
                } else if (e4Var instanceof m4) {
                    upperCase = LogUtils.EVENT_TYPE_LAUNCH;
                } else if (e4Var instanceof r4) {
                    upperCase = LogUtils.EVENT_TYPE_TERMINATE;
                } else if (e4Var instanceof p4) {
                    upperCase = LogUtils.EVENT_TYPE_PROFILE;
                } else if (e4Var instanceof s4) {
                    upperCase = LogUtils.EVENT_TYPE_TRACE;
                }
                jSONObject.put("$$EVENT_TYPE", upperCase);
                jSONObject.put("$$EVENT_LOCAL_ID", ((e4) this.a).p);
                return jSONObject;
            }
            upperCase = "";
            jSONObject.put("$$EVENT_TYPE", upperCase);
            jSONObject.put("$$EVENT_LOCAL_ID", ((e4) this.a).p);
            return jSONObject;
        }
    }

    public static String a(String str) {
        return com.bytedance.bdtracker.a.a("applog_", str);
    }

    public static boolean isDisabled() {
        return !a;
    }

    public static void sendJson(String str, JSONObject jSONObject) {
        if (isDisabled() || r.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), jSONObject);
    }

    public static void sendJsonFetcher(String str, EventBus.DataFetcher dataFetcher) {
        if (isDisabled() || r.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), dataFetcher);
    }

    public static void sendObject(String str, Object obj) {
        if (isDisabled() || r.c(str)) {
            return;
        }
        if (obj instanceof e4) {
            EventBus.global.get(new Object[0]).emit(a(str), (EventBus.DataFetcher) new a(obj));
        } else {
            EventBus.global.get(new Object[0]).emit(a(str), obj);
        }
    }

    public static void sendString(String str, String str2) {
        if (isDisabled() || r.c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(a(str), str2);
    }

    public static void setEnable(boolean z) {
        a = z;
    }
}
