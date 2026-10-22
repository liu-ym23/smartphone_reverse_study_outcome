package com.stepos.widget.recipient;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/widget/recipient/StepOSContactInfo;", "", "<init>", "()V", "LY8/t;", "resetContactInfo", "", "name", "cmpName", "", "id", "setContactInfo", "(Ljava/lang/String;Ljava/lang/String;J)V", "contactName", "Ljava/lang/String;", "getContactName", "()Ljava/lang/String;", "setContactName", "(Ljava/lang/String;)V", "contactCompany", "getContactCompany", "setContactCompany", "contactId", "J", "getContactId", "()J", "setContactId", "(J)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSContactInfo {
    public static final long INVALID_ID = 0;
    private String contactName = "";
    private String contactCompany = "";
    private long contactId = INVALID_ID;

    public final String getContactCompany() {
        return this.contactCompany;
    }

    public final long getContactId() {
        return this.contactId;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final void resetContactInfo() {
        this.contactName = "";
        this.contactCompany = "";
        this.contactId = INVALID_ID;
    }

    public final void setContactCompany(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.contactCompany = str;
    }

    public final void setContactId(long j10) {
        this.contactId = j10;
    }

    public final void setContactInfo(String name, String cmpName, long id) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(cmpName, "cmpName");
        this.contactName = name;
        this.contactCompany = cmpName;
        this.contactId = id;
    }

    public final void setContactName(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.contactName = str;
    }
}
