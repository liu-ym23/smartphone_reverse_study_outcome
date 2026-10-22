package com.stepos.ailauncher.agent.receiver;

import La.H;
import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/a;", "", "", "Lcom/stepos/ailauncher/agent/receiver/a$b;", "data", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "Companion", Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.receiver.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class NotifyBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<NotifyBodyItem> data;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/a$a;", "", "<init>", "()V", "", "json", "Lcom/stepos/ailauncher/agent/receiver/a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/receiver/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.receiver.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final NotifyBody a(String json) throws JSONException {
            JSONObject jSONObject;
            p.i(json, "json");
            Object objNextValue = new JSONTokener(H.D1(json).toString()).nextValue();
            if (objNextValue instanceof JSONObject) {
                jSONObject = (JSONObject) objNextValue;
            } else {
                if (!(objNextValue instanceof String)) {
                    throw new IllegalStateException("notifyBody is not a valid json object");
                }
                jSONObject = new JSONObject((String) objNextValue);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
            if (jSONArrayOptJSONArray == null) {
                String strOptString = jSONObject.optString("type");
                p.h(strOptString, "optString(...)");
                List listE = C1172u.e(new NotifyBodyItem(H.D1(strOptString).toString(), jSONObject.optInt("deletedNumber", 0)));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listE) {
                    if (((NotifyBodyItem) obj).getType().length() > 0) {
                        arrayList.add(obj);
                    }
                }
                return new NotifyBody(arrayList);
            }
            List listC = C1172u.c();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    p.h(strOptString2, "optString(...)");
                    String string = H.D1(strOptString2).toString();
                    int iOptInt = jSONObjectOptJSONObject.optInt("deletedNumber", 0);
                    if (string.length() != 0) {
                        listC.add(new NotifyBodyItem(string, iOptInt));
                    }
                }
            }
            return new NotifyBody(C1172u.a(listC));
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/receiver/a$b;", "", "", "type", "", "deletedNumber", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.receiver.a$b, reason: from toString */
    public static final /* data */ class NotifyBodyItem {
        private final int deletedNumber;
        private final String type;

        public NotifyBodyItem(String type, int i10) {
            p.i(type, "type");
            this.type = type;
            this.deletedNumber = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getDeletedNumber() {
            return this.deletedNumber;
        }

        /* renamed from: b, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyBodyItem)) {
                return false;
            }
            NotifyBodyItem notifyBodyItem = (NotifyBodyItem) other;
            return p.d(this.type, notifyBodyItem.type) && this.deletedNumber == notifyBodyItem.deletedNumber;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + Integer.hashCode(this.deletedNumber);
        }

        public String toString() {
            return "NotifyBodyItem(type=" + this.type + ", deletedNumber=" + this.deletedNumber + ")";
        }
    }

    public NotifyBody(List<NotifyBodyItem> data) {
        p.i(data, "data");
        this.data = data;
    }

    public final List<NotifyBodyItem> a() {
        return this.data;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NotifyBody) && p.d(this.data, ((NotifyBody) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "NotifyBody(data=" + this.data + ")";
    }
}
