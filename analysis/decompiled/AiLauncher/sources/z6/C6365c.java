package z6;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Lz6/c;", "", "<init>", "()V", "", "result", "f", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "previous", "sessionId", "parameter", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "raw", "Lorg/json/JSONObject;", "e", "(Ljava/lang/String;)Lorg/json/JSONObject;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "key", "", Const.INTENT_KEY_UMID, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "TAG", "Ljava/lang/String;", "TOOL_NAME", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6365c {
    public static final C6365c INSTANCE = new C6365c();
    private static final String TAG = "TaskToolCardMapper";
    public static final String TOOL_NAME = "task";

    public final TaskInfoEventType a(TaskInfoStatus status) {
        return status == TaskInfoStatus.FAILED ? TaskInfoEventType.FAILED : status.isTerminal() ? TaskInfoEventType.COMPLETED : (status == TaskInfoStatus.CREATED || status == TaskInfoStatus.PENDING) ? TaskInfoEventType.CREATED : TaskInfoEventType.UPDATED;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoStatus b(java.lang.String r5) {
        /*
            r4 = this;
            r4 = 0
            if (r5 == 0) goto La1
            java.lang.CharSequence r5 = La.H.D1(r5)
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto La1
            int r0 = r5.length()
            if (r0 <= 0) goto L14
            goto L15
        L14:
            r5 = r4
        L15:
            if (r5 != 0) goto L19
            goto La1
        L19:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r5.toLowerCase(r0)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1867169789: goto L4f;
                case -1274442605: goto L46;
                case -643901989: goto L39;
                case 96784904: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L58
        L2d:
            java.lang.String r1 = "error"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L36
            goto L58
        L36:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.FAILED
            goto L80
        L39:
            java.lang.String r1 = "takeover"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L43
            goto L58
        L43:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.WAITING
            goto L80
        L46:
            java.lang.String r1 = "finish"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7e
            goto L58
        L4f:
            java.lang.String r1 = "success"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7e
        L58:
            h9.a r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.getEntries()
            java.util.Iterator r0 = r0.iterator()
        L60:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L79
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r2 = (com.stepos.ailauncher.taskstore.entity.TaskInfoStatus) r2
            java.lang.String r2 = r2.name()
            r3 = 1
            boolean r2 = La.D.L(r2, r5, r3)
            if (r2 == 0) goto L60
            goto L7a
        L79:
            r1 = r4
        L7a:
            r0 = r1
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = (com.stepos.ailauncher.taskstore.entity.TaskInfoStatus) r0
            goto L80
        L7e:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.COMPLETED
        L80:
            if (r0 != 0) goto La0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unrecognized task state="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ", keep previous status"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r1 = 0
            r2 = 4
            java.lang.String r3 = "TaskToolCardMapper"
            h8.C4148a.u(r3, r5, r1, r2, r4)
        La0:
            return r0
        La1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.C6365c.b(java.lang.String):com.stepos.ailauncher.taskstore.entity.TaskInfoStatus");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoCard c(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r51, java.lang.String r52, java.lang.String r53, java.lang.String r54) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.C6365c.c(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, java.lang.String, java.lang.String, java.lang.String):com.stepos.ailauncher.taskstore.entity.TaskInfoCard");
    }

    public final Integer d(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Integer.valueOf(jSONObject.optInt(str));
    }

    public final JSONObject e(String raw) {
        Object objB;
        if (raw == null) {
            return null;
        }
        if (H.x0(raw)) {
            raw = null;
        }
        if (raw == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(raw));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JSONObject) (Result.g(objB) ? null : objB);
    }

    public final String f(String result) {
        JSONObject jSONObjectE = e(result);
        if (jSONObjectE == null) {
            return null;
        }
        if (jSONObjectE.has("ok") && !jSONObjectE.optBoolean("ok", true)) {
            return null;
        }
        String strOptString = jSONObjectE.optString("task_id");
        p.f(strOptString);
        if (H.x0(strOptString)) {
            return null;
        }
        return strOptString;
    }
}
