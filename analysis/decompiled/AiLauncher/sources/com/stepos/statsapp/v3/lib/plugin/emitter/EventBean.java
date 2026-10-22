package com.stepos.statsapp.v3.lib.plugin.emitter;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.secure.SimpleCryptoAES;
import com.stepos.statsapp.v3.utils.log.Logger;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class EventBean {
    private static String TAG = "EventBean";
    private static final String masterPassword = "262t1#x23&^ya1bk";
    String dateCreated;
    int encrypt;
    String eventData;
    String eventSource;
    long id;
    String sessionId;

    public static EventBean fromPayload(int i10, TrackerPayload trackerPayload) throws JSONException {
        String string;
        EventBean eventBean = new EventBean();
        eventBean.setEncrypt(i10);
        String str = (String) trackerPayload.getHeaderMap().get(Parameters.SESSION_ID);
        String str2 = (String) trackerPayload.getHeaderMap().get("source");
        eventBean.setSessionId(str);
        eventBean.setEventSource(str2);
        trackerPayload.getHeaderMap().remove(Parameters.SESSION_ID);
        trackerPayload.getHeaderMap().remove("source");
        int encrypt = eventBean.getEncrypt();
        if (encrypt != 0) {
            string = null;
            try {
                string = SimpleCryptoAES.getInstance().b(masterPassword, trackerPayload.toString(), encrypt);
                Logger.d(TAG, "SimpleCryptoAES encrypt[" + encrypt + "] done");
            } catch (Exception e10) {
                Logger.w(TAG, "SimpleCryptoAES encrypt[" + encrypt + "], Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            }
        } else {
            string = trackerPayload.toString();
        }
        eventBean.setEventData(string);
        trackerPayload.addHeader(Parameters.SESSION_ID, str);
        trackerPayload.addHeader("source", str2);
        return eventBean;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload toPayload(com.stepos.statsapp.v3.lib.plugin.emitter.EventBean r7) {
        /*
            java.lang.String r0 = "SimpleCryptoAES decrypt["
            int r1 = r7.getEncrypt()
            r2 = 0
            if (r1 == 0) goto L62
            com.stepos.statsapp.v3.lib.plugin.secure.SimpleCryptoAES r3 = com.stepos.statsapp.v3.lib.plugin.secure.SimpleCryptoAES.getInstance()     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = "262t1#x23&^ya1bk"
            java.lang.String r5 = r7.getEventData()     // Catch: java.lang.Exception -> L33
            java.lang.String r3 = r3.a(r4, r5, r1)     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = com.stepos.statsapp.v3.lib.plugin.emitter.EventBean.TAG     // Catch: java.lang.Exception -> L31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            r5.<init>()     // Catch: java.lang.Exception -> L31
            r5.append(r0)     // Catch: java.lang.Exception -> L31
            r5.append(r1)     // Catch: java.lang.Exception -> L31
            java.lang.String r6 = "] done"
            r5.append(r6)     // Catch: java.lang.Exception -> L31
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L31
            com.stepos.statsapp.v3.utils.log.Logger.d(r4, r5)     // Catch: java.lang.Exception -> L31
            goto L66
        L31:
            r4 = move-exception
            goto L35
        L33:
            r4 = move-exception
            r3 = r2
        L35:
            java.lang.String r5 = com.stepos.statsapp.v3.lib.plugin.emitter.EventBean.TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "], Exception: "
            r6.append(r0)
            java.lang.String r0 = r4.toString()
            r6.append(r0)
            java.lang.String r0 = " - Cause: "
            r6.append(r0)
            java.lang.Throwable r0 = r4.getCause()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.stepos.statsapp.v3.utils.log.Logger.w(r5, r0)
            goto L66
        L62:
            java.lang.String r3 = r7.getEventData()
        L66:
            com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload r0 = com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload.fromString(r3)
            if (r0 == 0) goto L7f
            java.lang.String r1 = r7.getSessionId()
            java.lang.String r2 = "sid"
            r0.addHeader(r2, r1)
            java.lang.String r7 = r7.getEventSource()
            java.lang.String r1 = "source"
            r0.addHeader(r1, r7)
            return r0
        L7f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsapp.v3.lib.plugin.emitter.EventBean.toPayload(com.stepos.statsapp.v3.lib.plugin.emitter.EventBean):com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload");
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public int getEncrypt() {
        return this.encrypt;
    }

    public String getEventData() {
        return this.eventData;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public long getId() {
        return this.id;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setDateCreated(String str) {
        this.dateCreated = str;
    }

    public void setEncrypt(int i10) {
        this.encrypt = i10;
    }

    public void setEventData(String str) {
        this.eventData = str;
    }

    public void setEventSource(String str) {
        this.eventSource = str;
    }

    public void setId(long j10) {
        this.id = j10;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
