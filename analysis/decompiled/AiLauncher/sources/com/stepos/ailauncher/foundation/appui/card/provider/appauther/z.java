package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\nJ%\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010!¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/z;", "", "<init>", "()V", "", "displayName", "c", "(Ljava/lang/String;)Ljava/lang/String;", "authText", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "", "helpTexts", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/z$a;", "e", "(Ljava/lang/String;Ljava/util/List;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/z$a;", "", "code", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "fallback", "f", "(ILjava/lang/String;)Ljava/lang/String;", "steps", "source", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/z$a;", "raw", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "FALLBACK_APP_NAME", "Ljava/lang/String;", "STEP_SOURCE_GUIDE_TEXT", "STEP_SOURCE_HELP_TEXT", "STEP_SOURCE_NONE", "Lkotlin/text/Regex;", "MARKDOWN_LINK", "Lkotlin/text/Regex;", "TOOL_SYNTAX", "ORDINAL_PREFIX", "MIN_STEPS", "I", "MAX_STEPS", "ERR_KEY_INVALID", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    public static final String ERR_KEY_INVALID = "授权密匙错误，请重试";
    private static final String FALLBACK_APP_NAME = "该应用";
    private static final int MAX_STEPS = 8;
    private static final int MIN_STEPS = 2;
    public static final String STEP_SOURCE_GUIDE_TEXT = "guide_text";
    public static final String STEP_SOURCE_HELP_TEXT = "help_text";
    public static final String STEP_SOURCE_NONE = "none";
    public static final z INSTANCE = new z();
    private static final Regex MARKDOWN_LINK = new Regex("\\[([^\\]]*)]\\([^)]*\\)");
    private static final Regex TOOL_SYNTAX = new Regex("skill_\\w*\\s*\\(");
    private static final Regex ORDINAL_PREFIX = new Regex("^\\s*(?:\\d+[.、)]|[①-⑳]|[-•*])\\s*");

    public static final CharSequence k(La.m it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.c().get(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto Le
            boolean r0 = La.H.x0(r2)
            if (r0 != 0) goto La
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 == 0) goto Le
            return r2
        Le:
            if (r3 == 0) goto L1a
            boolean r2 = La.H.x0(r3)
            if (r2 != 0) goto L17
            goto L18
        L17:
            r3 = r1
        L18:
            if (r3 != 0) goto L1d
        L1a:
            java.lang.String r3 = "该应用"
        L1d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "使用「"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = "」需要先授予 Amoo Agent 访问权限。"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.z.b(java.lang.String, java.lang.String):java.lang.String");
    }

    public final String c(String displayName) {
        if (displayName == null) {
            return "应用请求授权";
        }
        if (La.H.x0(displayName)) {
            displayName = null;
        }
        if (displayName == null) {
            return "应用请求授权";
        }
        return "「" + displayName + "」请求授权";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto Le
            boolean r0 = La.H.x0(r2)
            if (r0 != 0) goto La
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 == 0) goto Le
            return r2
        Le:
            if (r3 == 0) goto L1a
            boolean r2 = La.H.x0(r3)
            if (r2 != 0) goto L17
            goto L18
        L17:
            r3 = r1
        L18:
            if (r3 != 0) goto L1d
        L1a:
            java.lang.String r3 = "该应用"
        L1d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "为完成当前任务，Agent 需要使用「"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = "」的 API 凭证，请前往第三方平台获取并完成授权。"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.z.d(java.lang.String, java.lang.String):java.lang.String");
    }

    public final GuideSteps e(String authText, List<String> helpTexts) {
        List<String> listM;
        List listA1;
        kotlin.jvm.internal.p.i(helpTexts, "helpTexts");
        if (authText == null || (listA1 = La.H.a1(authText, new char[]{'\n', '\r'}, false, 0, 6, null)) == null) {
            listM = null;
        } else {
            listM = new ArrayList<>();
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                String strJ = INSTANCE.j((String) it.next());
                if (strJ != null) {
                    listM.add(strJ);
                }
            }
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        if (listM.size() >= 2) {
            return h(listM, STEP_SOURCE_GUIDE_TEXT);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = helpTexts.iterator();
        while (it2.hasNext()) {
            String strJ2 = INSTANCE.j((String) it2.next());
            if (strJ2 != null) {
                arrayList.add(strJ2);
            }
        }
        return !arrayList.isEmpty() ? h(arrayList, STEP_SOURCE_HELP_TEXT) : new GuideSteps(C1173v.m(), "none", false, 4, null);
    }

    public final String f(int code, String fallback) {
        kotlin.jvm.internal.p.i(fallback, "fallback");
        return i(code) ? ERR_KEY_INVALID : fallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto Le
            boolean r0 = La.H.x0(r2)
            if (r0 != 0) goto La
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 == 0) goto Le
            return r2
        Le:
            if (r3 == 0) goto L1a
            boolean r2 = La.H.x0(r3)
            if (r2 != 0) goto L17
            goto L18
        L17:
            r3 = r1
        L18:
            if (r3 != 0) goto L1d
        L1a:
            java.lang.String r3 = "该应用"
        L1d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "为完成当前任务，Agent 需要使用「"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = "」提供的相关服务，请完成授权后继续。"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.z.g(java.lang.String, java.lang.String):java.lang.String");
    }

    public final GuideSteps h(List<String> steps, String source) {
        if (steps.size() > 8) {
            return new GuideSteps(Z8.F.f1(steps, 8), source, true);
        }
        return new GuideSteps(steps, source, false, 4, null);
    }

    public final boolean i(int code) {
        return (code == 0 || code == 401 || code == 403 || code >= 500) ? false : true;
    }

    public final String j(String raw) {
        String strM = MARKDOWN_LINK.m(raw, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return z.k((La.m) obj);
            }
        });
        if (TOOL_SYNTAX.b(strM)) {
            return null;
        }
        String string = La.H.D1(ORDINAL_PREFIX.l(strM, "")).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/z$a;", "", "", "", "steps", "source", "", "truncated", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", "c", "()Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.z$a, reason: from toString */
    public static final /* data */ class GuideSteps {
        private final String source;
        private final List<String> steps;
        private final boolean truncated;

        public GuideSteps(List<String> steps, String source, boolean z10) {
            kotlin.jvm.internal.p.i(steps, "steps");
            kotlin.jvm.internal.p.i(source, "source");
            this.steps = steps;
            this.source = source;
            this.truncated = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public final List<String> b() {
            return this.steps;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getTruncated() {
            return this.truncated;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuideSteps)) {
                return false;
            }
            GuideSteps guideSteps = (GuideSteps) other;
            return kotlin.jvm.internal.p.d(this.steps, guideSteps.steps) && kotlin.jvm.internal.p.d(this.source, guideSteps.source) && this.truncated == guideSteps.truncated;
        }

        public int hashCode() {
            return (((this.steps.hashCode() * 31) + this.source.hashCode()) * 31) + Boolean.hashCode(this.truncated);
        }

        public String toString() {
            return "GuideSteps(steps=" + this.steps + ", source=" + this.source + ", truncated=" + this.truncated + ")";
        }

        public /* synthetic */ GuideSteps(List list, String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(list, str, (i10 & 4) != 0 ? false : z10);
        }
    }
}
