package u6;

import La.D;
import La.H;
import La.K;
import O6.l;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ame.sdk.SkillStoreKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0017J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u0017J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lu6/j;", "", "<init>", "()V", "", "taskId", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "part", "", "timestampMs", "forcedExt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;JLjava/lang/String;)Ljava/lang/String;", "title", "fileName", "mimeType", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "name", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", "Lkotlin/text/Regex;", "ILLEGAL_FILENAME_CHARS", "Lkotlin/text/Regex;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final j INSTANCE = new j();
    private static final Regex ILLEGAL_FILENAME_CHARS = new Regex("[/\\\\:*?\"<>|\\r\\n\\t]");

    public static /* synthetic */ String c(j jVar, String str, TaskInfoPart taskInfoPart, long j10, String str2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return jVar.a(str, taskInfoPart, j10, str2);
    }

    public final String a(String taskId, TaskInfoPart part, long timestampMs, String forcedExt) {
        p.i(taskId, "taskId");
        p.i(part, "part");
        String title = part.getTitle();
        String fileName = part.getFileName();
        String mimeType = part.getMimeType();
        String content = part.getContent();
        if (part.getContentType() == TaskInfoContentType.INLINE) {
            content = null;
        }
        return b(taskId, title, fileName, mimeType, content, timestampMs, forcedExt);
    }

    public final String b(String taskId, String title, String fileName, String mimeType, String content, long timestampMs, String forcedExt) {
        p.i(taskId, "taskId");
        String strE = forcedExt == null ? e(mimeType, fileName, title, content) : forcedExt;
        String strK = k(title);
        if (strK == null) {
            strK = k(fileName != null ? H.A1(fileName, '.', null, 2, null) : null);
            if (strK == null) {
                String strR1 = K.R1(taskId, 5);
                if (strR1.length() == 0) {
                    strR1 = "00000";
                }
                strK = "Task-" + strR1 + l.DATE_SEPARATOR + new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(timestampMs));
            }
        }
        if (strE != null && (forcedExt != null || h(strK) == null)) {
            if (!D.J(strK, "." + strE, true)) {
                return strK + "." + strE;
            }
        }
        return strK;
    }

    public final String e(String mimeType, String fileName, String title, String content) {
        String strG = g(mimeType);
        if (strG != null || (strG = h(fileName)) != null) {
            return strG;
        }
        String strH = h(title);
        if (strH != null) {
            return strH;
        }
        if (content != null) {
            return INSTANCE.f(content);
        }
        return null;
    }

    public final String f(String content) {
        p.i(content, "content");
        String strQ1 = H.q1(H.s1(H.w1(H.w1(content, '?', null, 2, null), '#', null, 2, null), JsonPointer.SEPARATOR, null, 2, null), '.', "");
        if (H.x0(strQ1)) {
            return null;
        }
        return strQ1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final String g(String mimeType) {
        String strJ = j(mimeType);
        if (strJ == null) {
            return null;
        }
        switch (strJ.hashCode()) {
            case -1248334925:
                if (strJ.equals("application/pdf")) {
                    return "pdf";
                }
                break;
            case -1248325150:
                if (strJ.equals("application/zip")) {
                    return "zip";
                }
                break;
            case -1073633483:
                if (strJ.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
                    return "pptx";
                }
                break;
            case -1071817359:
                if (strJ.equals("application/vnd.ms-powerpoint")) {
                    return ChatTracker.CONTENT_PPT;
                }
                break;
            case -1050893613:
                if (strJ.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                    return "docx";
                }
                break;
            case -366307023:
                if (strJ.equals("application/vnd.ms-excel")) {
                    return "xls";
                }
                break;
            case 904647503:
                if (strJ.equals("application/msword")) {
                    return ChatTracker.CONTENT_DOC;
                }
                break;
            case 1993842850:
                if (strJ.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
                    return "xlsx";
                }
                break;
        }
        String strQ1 = H.q1(strJ, JsonPointer.SEPARATOR, "");
        if (strQ1.length() == 0) {
            return null;
        }
        return p.d(strQ1, "plain") ? "txt" : (p.d(strQ1, "markdown") || p.d(strQ1, "x-markdown")) ? "md" : p.d(strQ1, "jpeg") ? C5578a.DST_JPG : p.d(strQ1, "svg+xml") ? "svg" : H.f0(strQ1, '+', false, 2, null) ? H.w1(strQ1, '+', null, 2, null) : strQ1;
    }

    public final String h(String name) {
        String strQ1;
        if (name == null || (strQ1 = H.q1(name, '.', "")) == null || H.x0(strQ1)) {
            return null;
        }
        return strQ1;
    }

    public final String i(String fileName, String title, String content) {
        String string;
        String strH = h(fileName);
        if (strH == null && (strH = h(title)) == null) {
            strH = content != null ? INSTANCE.f(content) : null;
        }
        if (strH != null && (string = H.D1(strH).toString()) != null) {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && lowerCase.length() <= 8) {
                return lowerCase;
            }
        }
        return null;
    }

    public final String j(String mimeType) {
        String strW1;
        String string;
        if (mimeType != null && (strW1 = H.w1(mimeType, ';', null, 2, null)) != null && (string = H.D1(strW1).toString()) != null) {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && lowerCase.length() > 0) {
                return lowerCase;
            }
        }
        return null;
    }

    public final String k(String name) {
        String strL;
        String string;
        String strR1;
        String string2;
        if (name == null || (strL = ILLEGAL_FILENAME_CHARS.l(name, "_")) == null || (string = H.D1(strL).toString()) == null || (strR1 = K.R1(string, 80)) == null || (string2 = H.D1(strR1).toString()) == null || H.x0(string2)) {
            return null;
        }
        return string2;
    }
}
