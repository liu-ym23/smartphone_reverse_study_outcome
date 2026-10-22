package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/Q1;", "", "<init>", "()V", "", "fileType", Const.INTENT_KEY_PKGNAME, "(I)I", "", "name", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)I", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Q1 {
    public static final Q1 INSTANCE = new Q1();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r1.equals("xlsx") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r1.equals("pptx") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r1.equals("docx") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (r1.equals("zip") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (r1.equals("xls") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_xls;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (r1.equals("tar") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
    
        if (r1.equals("rar") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
    
        if (r1.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_PPT) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
    
        if (r1.equals("key") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0090, code lost:
    
        if (r1.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_DOC) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009c, code lost:
    
        if (r1.equals("gz") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a5, code lost:
    
        if (r1.equals("7z") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        return com.stepos.agentframework.R$drawable.ic_folder_line_zip;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L18
            r1 = 46
            java.lang.String r0 = ""
            java.lang.String r1 = La.H.q1(r2, r1, r0)
            if (r1 == 0) goto L18
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            goto L19
        L18:
            r1 = 0
        L19:
            if (r1 == 0) goto Lab
            int r2 = r1.hashCode()
            switch(r2) {
                case 1827: goto L9f;
                case 3315: goto L96;
                case 99640: goto L8a;
                case 106079: goto L7e;
                case 110834: goto L72;
                case 111220: goto L69;
                case 112675: goto L60;
                case 114597: goto L57;
                case 118783: goto L4b;
                case 120609: goto L42;
                case 3088960: goto L38;
                case 3447940: goto L2e;
                case 3682393: goto L24;
                default: goto L22;
            }
        L22:
            goto Lab
        L24:
            java.lang.String r2 = "xlsx"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L54
            goto Lab
        L2e:
            java.lang.String r2 = "pptx"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L87
            goto Lab
        L38:
            java.lang.String r2 = "docx"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L93
            goto Lab
        L42:
            java.lang.String r2 = "zip"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La8
            goto Lab
        L4b:
            java.lang.String r2 = "xls"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L54
            goto Lab
        L54:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_xls
            return r1
        L57:
            java.lang.String r2 = "tar"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La8
            goto Lab
        L60:
            java.lang.String r2 = "rar"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La8
            goto Lab
        L69:
            java.lang.String r2 = "ppt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L87
            goto Lab
        L72:
            java.lang.String r2 = "pdf"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L7b
            goto Lab
        L7b:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_pdf
            return r1
        L7e:
            java.lang.String r2 = "key"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L87
            goto Lab
        L87:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_ppt
            return r1
        L8a:
            java.lang.String r2 = "doc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L93
            goto Lab
        L93:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_doc
            return r1
        L96:
            java.lang.String r2 = "gz"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La8
            goto Lab
        L9f:
            java.lang.String r2 = "7z"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La8
            goto Lab
        La8:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_zip
            return r1
        Lab:
            int r1 = com.stepos.agentframework.R$drawable.ic_folder_line_code
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.Q1.a(java.lang.String):int");
    }

    public final int b(int fileType) {
        if (fileType != 3) {
            if (fileType == 4) {
                return R$drawable.ic_folder_line_pdf;
            }
            if (fileType == 7) {
                return R$drawable.ic_folder_line_ppt;
            }
            if (fileType != 8) {
                return fileType != 9 ? fileType != 13 ? R$drawable.ic_folder_line_code : R$drawable.ic_folder_line_zip : R$drawable.ic_folder_line_xls;
            }
        }
        return R$drawable.ic_folder_line_doc;
    }
}
