package com.obric.agent.permission.bean;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: RequestPermissionReq.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestPermissionReq {
    private final String content;
    private final List<RequestPermissionOption> options;
    private final List<Permission> permissions;
    private final String title;

    public static /* synthetic */ RequestPermissionReq copy$default(RequestPermissionReq r1, String r2, String r3, List r4, List r5, int r6, Object r7) {
        List<RequestPermissionOption> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<Permission> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.title;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.content;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.options;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.permissions;
    L15:
        return r1.copy(r2, r3, r8, r9);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final List<RequestPermissionOption> component3() {
        return this.options;
    }

    public final List<Permission> component4() {
        return this.permissions;
    }

    public final RequestPermissionReq copy(String r2, String r3, List<RequestPermissionOption> r4, List<Permission> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r2, DBDefinition.TITLE);
        o.e(r3, "content");
        o.e(r1, "options");
        o.e(r6, "permissions");
        return new RequestPermissionReq(r2, r3, r1, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestPermissionReq.class) == true) goto L8;
        return false;
    L8:
        RequestPermissionReq r6 = (RequestPermissionReq) ZeusTransformUtils.preCheckCast(r5, RequestPermissionReq.class, "com.obric.aiagent.plugin");
        if (o.a(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.options, r6.options) == true) goto L18;
        return false;
    L18:
        if (o.a(this.permissions, r6.permissions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.options.hashCode()) * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "RequestPermissionReq(title=" + this.title + ", content=" + this.content + ", options=" + this.options + ", permissions=" + this.permissions + ')';
    }

    public RequestPermissionReq(String r3, String r4, List<RequestPermissionOption> r5, List<Permission> r6) {
        List<RequestPermissionOption> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<Permission> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TITLE);
        o.e(r4, "content");
        o.e(r7, "options");
        o.e(r8, "permissions");
        this.title = r3;
        this.content = r4;
        this.options = r7;
        this.permissions = r8;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<RequestPermissionOption> getOptions() {
        return this.options;
    }

    public final List<Permission> getPermissions() {
        return this.permissions;
    }
}
